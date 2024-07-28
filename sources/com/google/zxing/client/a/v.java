package com.google.zxing.client.a;

import com.google.zxing.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class v extends u {
    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        String str2 = null;
        if (indexOf < 0) {
            collection.add(str);
            collection2.add((Object) null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            str2 = substring.substring(4);
        }
        collection2.add(str2);
    }

    public final /* synthetic */ q a(r rVar) {
        String str;
        String str2;
        String b2 = b(rVar);
        String str3 = null;
        if (!b2.startsWith("sms:") && !b2.startsWith("SMS:") && !b2.startsWith("mms:") && !b2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> c2 = c(b2);
        boolean z = false;
        if (c2 == null || c2.isEmpty()) {
            str = null;
        } else {
            str3 = c2.get("subject");
            str = c2.get("body");
            z = true;
        }
        int indexOf = b2.indexOf(63, 4);
        if (indexOf < 0 || !z) {
            str2 = b2.substring(4);
        } else {
            str2 = b2.substring(4, indexOf);
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int indexOf2 = str2.indexOf(44, i3);
            if (indexOf2 > i2) {
                a(arrayList, arrayList2, str2.substring(i3, indexOf2));
                i2 = indexOf2;
            } else {
                a(arrayList, arrayList2, str2.substring(i3));
                return new w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str3, str);
            }
        }
    }
}
