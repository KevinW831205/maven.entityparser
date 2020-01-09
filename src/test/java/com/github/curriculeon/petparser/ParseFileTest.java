package com.github.curriculeon.petparser;

import com.github.curriculeon.DateParser;
import com.github.curriculeon.Person;
import com.github.curriculeon.Pet;
import com.github.curriculeon.PetParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leon on 1/8/2020.
 */
public class ParseFileTest {

    // given
    private void test(File fileOfData, Pet[] expected) {
        PetParser parser = new PetParser();

        // when
        Pet[] actual = parser.parseFile(fileOfData);

        // then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void test0() {
        // given
        Long id = 0L;
        String name = "milo the dog";
        Date date = DateParser.parseDate("06-14-2015");
        Pet pet = new Pet(id, name, date);
        Pet[] expected = new Pet[]{pet};
        String filePath = "/creature/milo.pet";
        File fileOfData = new File(filePath);
        
        test(fileOfData, expected);
    }

    @Test
    public void test1() {
        // given
        Long id = 1L;
        String name = "sam the snake";
        Date date = DateParser.parseDate("09-07-2007");
        Pet pet = new Pet(id, name, date);
        Pet[] expected = new Pet[]{pet};
        String filePath = "/creature/sam.pet";
        File fileOfData = new File(filePath);

        test(fileOfData, expected);
    }

    @Test
    public void test2() {
        // given
        Long id = 2L;
        String name = "zula the kitty";
        Date date = DateParser.parseDate("01-01-2005");
        Pet pet = new Pet(id, name, date);
        Pet[] expected = new Pet[]{pet};
        String filePath = "/creature/zula.pet";
        File fileOfData = new File(filePath);

        test(fileOfData, expected);
    }


    @Test
    public void test3() {
        // given
        Long id1 = 0L;
        String name1 = "milo the dog";
        Date date1 = DateParser.parseDate("06-14-2015");
        
        Long id2 = 1L;
        String name2 = "sam the snake";
        Date date2 = DateParser.parseDate("09-07-2007");

        Long id3 = 2L;
        String name3 = "zula the kitty";
        Date date3 = DateParser.parseDate("01-01-2005");
        
        Pet pet1 = new Pet(id1, name1, date1);
        Pet pet2 = new Pet(id2, name2, date2);
        Pet pet3 = new Pet(id3, name3, date3);
        
        Pet[] expected = new Pet[]{pet1, pet2, pet3};
        
        String filePath = "/creature/allpet.pets";
        File fileOfData = new File(filePath);

        test(fileOfData, expected);
    }
}
