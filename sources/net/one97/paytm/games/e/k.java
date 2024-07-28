package net.one97.paytm.games.e;

import java.text.DecimalFormat;

public final class k {
    public static String a(double d2) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        if (d2 > ((double) ((int) d2))) {
            decimalFormat.setMinimumFractionDigits(2);
        }
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format(d2);
    }
}
