
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

import data.FeedEntry;

/**
 * Created by Vitus on 16.12.2016.
 */

public class RSSReader extends AsyncTask<Void,Void,Void>{

    private   Context cont;
    private  ProgressDialog progDialog;
    private  String address = "https://www.tagesschau.de/xml/rss2"; // URL of the Feed ToDo: needs to be flexible
    private URL StreamUrl; //URL Object for Data Stream

    public RSSReader (Context cont){
        this.cont = cont;
        progDialog=new ProgressDialog(cont);
        progDialog.setMessage("Getting Data from the Cloud");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progDialog.dismiss();
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onPreExecute() {
        progDialog.show();
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        processXml(getData());
        return null;
    }

    private void processXml(Document data) {
        if (data != null) {
            ArrayList<FeedEntry>feedItems=new ArrayList<>();
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node cureentchild = items.item(i);
                if (cureentchild.getNodeName().equalsIgnoreCase("item")) {
                    FeedEntry item=new FeedEntry();
                    NodeList itemchilds = cureentchild.getChildNodes();
                    for (int j = 0; j < itemchilds.getLength(); j++) {
                        Node cureent = itemchilds.item(j);
                        if (cureent.getNodeName().equalsIgnoreCase("title")){
                            item.setTitle(cureent.getTextContent());
                        }else if (cureent.getNodeName().equalsIgnoreCase("description")){
                            item.setDescription(cureent.getTextContent());
                        }else if (cureent.getNodeName().equalsIgnoreCase("pubDate")){
                            item.setPubDate(cureent.getTextContent());
                        }else if (cureent.getNodeName().equalsIgnoreCase("link")){
                            item.setLink(cureent.getTextContent());
                        }
                    }
                    feedItems.add(item);
                    Log.d("itemTitle", item.getTitle());
                    Log.d("itemDescription",item.getDescription());
                    Log.d("itemPubDate",item.getPubDate());
                    Log.d("itemLink",item.getLink());



                }
            }
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