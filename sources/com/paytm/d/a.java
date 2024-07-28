package com.paytm.d;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public final class a {
    private static String a(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0".concat(String.valueOf(bigInteger));
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(TreeMap<String, String> treeMap, String str) {
        StringBuilder sb = new StringBuilder();
        if (treeMap == null) {
            return null;
        }
        for (Map.Entry next : treeMap.entrySet()) {
            sb.append(next.getKey());
            sb.append(next.getValue());
        }
        sb.append(str);
        return a(sb.toString());
    }
}
