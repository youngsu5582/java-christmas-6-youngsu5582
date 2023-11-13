package christmas.util;

import java.text.NumberFormat;

public class Formatter {
    public static String formatNumber(int number) {
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(number);
    }

    public static String formatNegativeNumber(int number) {
        StringBuilder sb = new StringBuilder();
        return sb.append('-').append(formatNumber(number)).toString();
    }

}
