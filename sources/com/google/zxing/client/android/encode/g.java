package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    private final List<Map<String, Set<String>>> f40220a;

    g() {
        this((List<Map<String, Set<String>>>) null);
    }

    g(List<Map<String, Set<String>>> list) {
        this.f40220a = list;
    }

    public final CharSequence a(CharSequence charSequence, int i2) {
        String formatNumber = PhoneNumberUtils.formatNumber(charSequence.toString());
        List<Map<String, Set<String>>> list = this.f40220a;
        Map map = (list == null || list.size() <= i2) ? null : this.f40220a.get(i2);
        if (map == null || map.isEmpty()) {
            return formatNumber;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry value : map.entrySet()) {
            Set set = (Set) value.getValue();
            if (set != null && !set.isEmpty()) {
                Iterator it2 = set.iterator();
                sb.append((String) it2.next());
                while (it2.hasNext()) {
                    sb.append(',');
                    sb.append((String) it2.next());
                }
            }
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(formatNumber);
        return sb;
    }
}
