package com.github.curriculeon;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by leon on 1/8/2020.
 */
public class PetParser implements Parser<Pet> {
    @Override
    public Pet parseString(String data) {
        String[] fields = data.split("\n");
        Pet result =  null;
        try {
            result = new Pet(Long.parseLong(fields[0]) , fields[1], new SimpleDateFormat("MM-dd-yyyy").parse(fields[2]) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Pet[] parseStrings(String[] data) {

        Pet[] result = new Pet[data.length];
        for(int i=0; i<result.length; i++){
            result[i] = parseString(data[i]);
        }
        return result;
    }

    @Override
    public Pet[] parseFile(File data) {
        String dataAsString = new FileReader(data.getPath()).toString();
        String[] fieldsAsStrings = dataAsString.split("\n");
        String[] fieldsGrouped = new String[fieldsAsStrings.length/3];
        for (int i=0; i<fieldsGrouped.length; i++){
            fieldsGrouped[i] = fieldsAsStrings[3*i] + "\n"+fieldsAsStrings[3*i+1]+"\n"+fieldsAsStrings[3*i+2];
        }
        return parseStrings(fieldsGrouped);
    }
}
