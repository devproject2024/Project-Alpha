package com.google.zxing.client.android.encode;

import java.util.HashSet;
import java.util.List;

abstract class a {
    /* access modifiers changed from: package-private */
    public abstract String[] a(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2);

    a() {
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim;
    }

    static void a(StringBuilder sb, StringBuilder sb2, String str, String str2, b bVar, char c2) {
        String a2 = a(str2);
        if (a2 != null) {
            sb.append(str);
            sb.append(bVar.a(a2, 0));
            sb.append(c2);
            sb2.append(a2);
            sb2.append(10);
        }
    }

    static void a(StringBuilder sb, StringBuilder sb2, String str, List<String> list, int i2, b bVar, b bVar2, char c2) {
        CharSequence charSequence;
        if (list != null) {
            HashSet hashSet = new HashSet(2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                String a2 = a(list.get(i4));
                if (a2 != null && !a2.isEmpty() && !hashSet.contains(a2)) {
                    sb.append(str);
                    sb.append(bVar2.a(a2, i4));
                    sb.append(c2);
                    if (bVar == null) {
                        charSequence = a2;
                    } else {
                        charSequence = bVar.a(a2, i4);
                    }
                    sb2.append(charSequence);
                    sb2.append(10);
                    i3++;
                    if (i3 != i2) {
                        hashSet.add(a2);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
