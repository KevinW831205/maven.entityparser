package com.github.curriculeon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leon on 1/8/2020.
 * this class is used a utility to easily generate `Date`
 */
public class DateParser {
    public static Date parseDate(String sDate1) {
        try {
            return new SimpleDateFormat("MM-dd-yyyy").parse(sDate1);
        } catch (ParseException e) {
            throw new Error(e);
        }
    }
}
