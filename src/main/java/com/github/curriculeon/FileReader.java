package com.github.curriculeon;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


/**
 * Created by leon on 1/8/2020.
 */
public class FileReader {
    private final String filename;

    public FileReader(String filename){
        this.filename = filename;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        String filePath = "src\\main\\resources\\"+filename;
        System.out.println(new File("").getAbsolutePath());
        try (Scanner scanner = new Scanner(new java.io.FileReader(filePath))) {
            while (scanner.hasNextLine()) {
                output.append(scanner.nextLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString().trim();
    }

}
