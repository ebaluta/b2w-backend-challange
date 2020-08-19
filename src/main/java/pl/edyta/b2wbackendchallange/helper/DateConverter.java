package pl.edyta.b2wbackendchallange.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static Date retireveDateFromParam(String date) {
        String[] strDate = date.split("-");
        String day = strDate[0];
        String month = strDate[1];
        String year = strDate[2];
        String newStrDate = year + "-" + month + "-" + day;

        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(newStrDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date1;
    }

    public static Date retrieveDateFromGameResponse(String date) {
        String cuttedDate = date.substring(0, 10);
        String[] dateArray = cuttedDate.split("-");
        String day = dateArray[2];
        String month = dateArray[1];
        String year = dateArray[0];
        String newDateStr = year + "-" + month + "-" + day;

        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(newDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date1;
    }

}
