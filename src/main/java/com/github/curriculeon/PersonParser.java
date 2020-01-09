package com.github.curriculeon;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by leon on 1/8/2020.
 */
public class PersonParser implements Parser<Person> {
    @Override
    public Person parseString(String data) {
        String[] arg = data.split("\n");
        return new Person(Long.parseLong(arg[0]),arg[1],arg[2]);
    }

    @Override
    public Person[] parseStrings(String[] data) {
        Person[] result = new Person[data.length];
        for(int i=0; i<data.length; i++){
            result[i] = parseString(data[i]);
        }
        return result;
    }

    @Override
    public Person[] parseFile(File data) {
        System.out.println(data.getPath());
        String dataAsString = new FileReader(data.getPath()).toString();
        String[] fieldAsString = dataAsString.split("\n");
        String[] splittedData = new String[fieldAsString.length/3];
        for (int i=0; i<splittedData.length; i++){
            splittedData[i] = fieldAsString[3*i] + "\n"+fieldAsString[3*i+1]+"\n"+fieldAsString[3*i+2];
        }
        return parseStrings(splittedData);
    }
}
