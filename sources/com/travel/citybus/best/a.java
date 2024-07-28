package com.travel.citybus.best;

import com.travel.citybus.brts.model.pojo.CJRCity;

public final class a {
    public static boolean a(CJRCity cJRCity) {
        return cJRCity.getName().toLowerCase().equals("mumbai") || cJRCity.getMerchantName().toLowerCase().equals("best");
    }

    public static boolean b(CJRCity cJRCity) {
        return cJRCity.getName().toLowerCase().equals("rajkot") || cJRCity.getMerchantName().toLowerCase().equals("RMTS");
    }

    public static boolean a(String str) {
        return str.toLowerCase().equals("brts_amd");
    }

    public static boolean c(CJRCity cJRCity) {
        return cJRCity.getName().toLowerCase().equals("goa") || cJRCity.getMerchantName().toLowerCase().equals("KTCL");
    }

    public static String a(int i2) {
        if (i2 == 1) {
            return "1 passenger";
        }
        return i2 + " passengers";
    }
}
