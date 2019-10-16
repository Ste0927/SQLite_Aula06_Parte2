package br.com.stefany.filadechamados;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static String convert (Date date){
        return sdf.format(date);
    }
}

