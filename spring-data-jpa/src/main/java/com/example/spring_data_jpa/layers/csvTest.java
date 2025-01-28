package com.example.spring_data_jpa.layers;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class csvTest {
    public static void main(String[] args) {
        csvTest csvTest = new csvTest();
        System.out.println(csvTest.readCsv());
    }

    public String readCsv(){
        BufferedReader bufferedReader;
        String s = "";
        {
            try {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csvs/nation.csv");
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                s = bufferedReader.readLine();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return s;
    }


}

