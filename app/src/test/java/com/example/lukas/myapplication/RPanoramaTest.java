package com.example.lukas.myapplication;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import data.Data;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RPanoramaTest {
    private ArrayList<Data> myData;

    @Before
    public void setUp() throws Exception {
        myData=new ArrayList<>();
        myData.add(new Data(0, 21, "Berlin", "Mo", 32, "01"));
        myData.add(new Data(0, 22, "Hamburg", "Mo", 32, "01"));
        myData.add(new Data(0, 23, "London", "Mo", 32, "01"));
        myData.add(new Data(0, 24, "New York", "Mo", 32, "01"));
        myData.add(new Data(0, 25, "Paris", "Mo", 32, "01"));
    }

    @Test
    public void checkTempCity() throws Exception {
        assertEquals("Berlin", myData.get(0).getTempCity());
    }

    @Test
    public void checkTempTemperature() throws Exception{
        Integer[] temperatures= {21,22,23,24,25};
        for(int i=0;i<5;i++){
            assertEquals(temperatures[i].toString()+"°C",myData.get(i).getTempInCel());
        }
    }
}