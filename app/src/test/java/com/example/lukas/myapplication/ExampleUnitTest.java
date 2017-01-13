package com.example.lukas.myapplication;

import org.junit.Test;

import java.util.ArrayList;

import data.Data;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Data myData = new Data(0,21,"Berlin","Mo",32,"01");

    @Test
    public void check_Temp_City() throws Exception {
        assertEquals("Berlin", myData.getTempCity());
    }
}