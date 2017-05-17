package com.example.android.quakereport.utils;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by obed.gonzalez on 03/05/2017.
 */



public class DateUtils {

    public static final String FORMAT_LOG = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_HORA_12 = "hh:mm a";
    public static final String FORMAT_ANIO_MES_DIA = "yyyy-MM-dd";
    public static final String COMPL_TIME_CEROS = " 00:00:00";
    public static final String FORMAT_SOLONUMS = "yyyyMMdd";
    public static final String FECHA_DIAMESANIO_12HORA_AMPM = "LLL dd,yyyy\nh:mm a";

    public static String getDateString(long longDate, String format) {

        return new java.text.SimpleDateFormat(format).format(new java.util.Date(longDate));
    }

    public static long getDateLong(String stringDate, String format) {

        try {
            return new java.text.SimpleDateFormat(format).parse(stringDate).getTime();
        } catch (ParseException p) {
            Log.e(AppConstants.TAG, p.getMessage(), p.fillInStackTrace());
        }
        return -1l;
    }

    /**
     * Retorna como strinf una fecha de entrada segun el patron de entrada<br>
     * Creado el 26/09/2014 a las 16:46:04 <br>
     *
     * @param date
     * @param pattern
     * @return
     * @author <a href="http://www.quipux.com/">Quipux Software.</a></br>
     */
    public static String formatDate(Date date, String pattern) {

        if (date != null) {
            SimpleDateFormat formateador = new SimpleDateFormat(pattern);
            return formateador.format(date);
        } else {
            return "";
        }

    }

    public static Date getDateFromLong(Context context, long longDate, String formatDate) {

        return new Date(longDate);
    }

    public static Date getDateFromString(String stringDate, String formatDate) {

        Date date = null;
        try {
            DateFormat format = new SimpleDateFormat(formatDate);
            date = format.parse(stringDate);
        } catch (ParseException parse) {
            Log.e(AppConstants.TAG, parse.getMessage(), parse);
        }
        return date;
    }

    public static String getCurrentTimeStamp(String format) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(format);//dd/MM/yyyy
        Date now = new Date(System.currentTimeMillis());
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
