package sergeev.alexander.xml.calculator;

import java.time.LocalDate;

public class Calculator {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2025, 7, 22);
        for (int i = 0; i < 12; i++) {
            start = get(start);
            System.out.println(start);
        }
    }

    public static LocalDate get(LocalDate start) {
        return start.plusDays(26);
    }
}
