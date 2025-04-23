package sergeev.alexander.calculator;

import java.time.LocalDate;

public class Temp2 {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2025, 3, 14);
        for (int i = 0; i < 12; i++) {
            start = get(start);
            System.out.println(start);
        }
    }

    public static LocalDate get(LocalDate start) {
        return start.plusDays(26);
    }
}
