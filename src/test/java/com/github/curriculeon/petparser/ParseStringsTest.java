package com.github.curriculeon.petparser;

import com.github.curriculeon.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by leon on 1/8/2020.
 */
public class ParseStringsTest {
    // given
    private void test(String[] dataArray, Pet[] expected) {
        PetParser parser = new PetParser();

        // when
        Pet[] actual = parser.parseStrings(dataArray);

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test0() {
        Long id0 = 99L;
        String name0 = "Leon the Lion";
        String dateString0 = "04-23-2005";
        String data0 = new StringJoiner("\n")
                .add(id0.toString())
                .add(name0)
                .add(dateString0)
                .toString();

        String[] dataArray = {data0};
        Pet pet0 = new Pet(id0, name0, DateParser.parseDate(dateString0));
        Pet[] expected = new Pet[]{pet0};

        test(dataArray, expected);
    }

    @Test
    public void test1() {
        Long id0 = 99L;
        String name0 = "Leon the Lion";
        String dateString0 = "04-23-2005";
        String data0 = new StringJoiner("\n")
                .add(id0.toString())
                .add(name0)
                .add(dateString0)
                .toString();

        Long id1 = 98L;
        String name1 = "Goliath the Golem";
        String dateString1 = "0-0-0";
        String data1 = new StringJoiner("\n")
                .add(id1.toString())
                .add(name1)
                .add(dateString1)
                .toString();

        String[] dataArray = {data0, data1};
        Pet pet0 = new Pet(id0, name0, DateParser.parseDate(dateString0));
        Pet pet1 = new Pet(id1, name1, DateParser.parseDate(dateString1));
        Pet[] expected = new Pet[]{pet0, pet1};

        test(dataArray, expected);
    }



    @Test
    public void test2() {
        Long id0 = 99L;
        String name0 = "Leon the Lion";
        String dateString0 = "04-23-2005";
        String data0 = new StringJoiner("\n")
                .add(id0.toString())
                .add(name0)
                .add(dateString0)
                .toString();

        Long id1 = 98L;
        String name1 = "Goliath the Golem";
        String dateString1 = "0-0-0";
        String data1 = new StringJoiner("\n")
                .add(id1.toString())
                .add(name1)
                .add(dateString1)
                .toString();


        Long id2 = 97L;
        String name2 = "Nikola the Electrobuzz";
        String dateString2 = "06-10-1856";
        String data2 = new StringJoiner("\n")
                .add(id2.toString())
                .add(name2)
                .add(dateString2)
                .toString();

        String[] dataArray = {data0, data1, data2};
        Pet pet0 = new Pet(id0, name0, DateParser.parseDate(dateString0));
        Pet pet1 = new Pet(id1, name1, DateParser.parseDate(dateString1));
        Pet pet2 = new Pet(id2, name2, DateParser.parseDate(dateString2));
        Pet[] expected = new Pet[]{pet0, pet1, pet2};

        test(dataArray, expected);
    }
}