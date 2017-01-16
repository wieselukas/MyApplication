
package dataInputs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import data.Data;
import data.FeedEntry;

/**
 * Created by Vitus on 16.12.2016.
 */

public class RSSReader extends AsyncTask<Void,Void,Void>{

    private   Context cont;
    private  ProgressDialog progDialog;
    private  String address = "https://www.tagesschau.de/xml/rss2"; // URL of the Feed ToDo: needs to be flexible
    private URL StreamUrl; //URL Object for Data Stream


    private ArrayList<Data>feedItems=new ArrayList<>();



    public void setReady_flag(boolean ready_flag) {
        this.ready_flag = ready_flag;
    }

    private boolean ready_flag;

    public RSSReader (Context cont){
        this.cont = cont;
        progDialog=new ProgressDialog(cont);
        progDialog.setMessage("Getting Data from the Cloud");
    }

    public boolean isReady() {
        return ready_flag;
    }

    public ArrayList<Data> getFeedItems() {
        return feedItems;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progDialog.dismiss();
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onPreExecute() {
        progDialog.show();
        ready_flag=false;
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        processXml(getData());
        return null;
    }

    private void processXml(Document data) {
        if (data != null) {

            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node cureentchild = items.item(i);
                if (cureentchild.getNodeName().equalsIgnoreCase("item")) {
                    FeedEntry item=new FeedEntry();
                    NodeList itemchilds = cureentchild.getChildNodes();
                    for (int j = 0; j < itemchilds.getLength(); j++) {
                        Node current = itemchilds.item(j);
                        if (current.getNodeName().equalsIgnoreCase("title")){
                            item.setTitle(current.getTextContent());
                        }else if (current.getNodeName().equalsIgnoreCase("description")){
                            item.setContent(current.getTextContent());
                        }else if (current.getNodeName().equalsIgnoreCase("pubDate")){
                            item.setInfo(current.getTextContent());
                        }else if (current.getNodeName().equalsIgnoreCase("link")){
                            item.setLink(current.getTextContent());
                        }
                    }
                    item.setImgInfo("http://modernus.de/pics/branchcontent/solarthermie/solarthermie-anlagen-test-vergleich-paradigma-wagner-viessman-buderus.jpg");   //Todo: replace with real code
                    feedItems.add(item);
                }
            }
            ready_flag=true;
        }
    }

    private Document getData(){
        try{
            StreamUrl = new URL(address);
            HttpURLConnection connection= (HttpURLConnection) StreamUrl.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}