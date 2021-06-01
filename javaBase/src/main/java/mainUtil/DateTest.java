package mainUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期类，
 */
public class DateTest {

    public static void main(String[] args) {
        String date = getDate();
        System.out.println(date);

        getTime();
    }

    public static void getTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter ofForMat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(ofForMat.format(dateTime));
    }

    //获取当前日期
    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        return format;
    }

    //练习题：字符串"2020-09-08"转换为java.sql.Date
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);

        //java.util.Date  转化为 java.sql.Date
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }

}
