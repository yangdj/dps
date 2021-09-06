package lrn.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZonedDateTime.of(ldt, ZoneId.of("Asia/Shanghai")));
        System.out.println(Locale.getDefault());
        DayOfWeek lw = DayOfWeek.from(ld);
        Locale lc = Locale.getDefault();
        System.out.println(lw);
        System.out.println(lw.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        System.out.println(lw.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
        System.out.println(lw.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    }
}
