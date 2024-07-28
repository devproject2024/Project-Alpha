package com.paytm.android.chat.utils;

import android.util.Patterns;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtils {
    private WebUtils() {
    }

    public static class UrlBean {
        public String content;
        public boolean isUrl;

        public UrlBean(String str, boolean z) {
            this.content = str;
            this.isUrl = z;
        }
    }

    public static List<UrlBean> extractUrls(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("\\s+");
        Pattern pattern = Patterns.WEB_URL;
        boolean z = false;
        for (String str2 : split) {
            if (!z) {
                z = pattern.matcher(str2).find();
            }
            arrayList.add(new UrlBean(str2, pattern.matcher(str2).find()));
            arrayList.add(new UrlBean(" ", false));
        }
        if (!z) {
            arrayList.clear();
        }
        return arrayList;
    }

    public static List<UrlBean> extractUrlsFromString(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("\\s+");
        Pattern pattern = Patterns.WEB_URL;
        Boolean bool = Boolean.FALSE;
        int length = split.length;
        Boolean bool2 = bool;
        int i2 = 0;
        while (i2 < length) {
            String str2 = split[i2];
            Matcher matcher = pattern.matcher(str2.toLowerCase());
            Boolean bool3 = bool2;
            int i3 = 0;
            while (matcher.find()) {
                bool3 = Boolean.TRUE;
                if (matcher.start() - i3 > 0) {
                    arrayList.add(new UrlBean(str2.subSequence(i3, matcher.start()).toString(), false));
                    arrayList.add(new UrlBean(" ", false));
                }
                arrayList.add(new UrlBean(str2.subSequence(matcher.start(), matcher.end()).toString(), true));
                arrayList.add(new UrlBean(" ", false));
                i3 = matcher.end();
            }
            if (i3 < str2.length()) {
                arrayList.add(new UrlBean(str2.subSequence(i3, str2.length()).toString(), false));
                arrayList.add(new UrlBean(" ", false));
            }
            i2++;
            bool2 = bool3;
        }
        if (!bool2.booleanValue()) {
            arrayList.clear();
        }
        return arrayList;
    }

    public static String exChange(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb.append(Character.toLowerCase(charAt));
                } else {
                    sb.append(charAt);
                }
            }
        }
        return sb.toString();
    }
}
