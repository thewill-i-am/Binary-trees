package cr.ac.ulead.parseadorUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public LocalDate parseador(String date){
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }
}
