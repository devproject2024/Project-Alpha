package com.google.zxing.client.android.encode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

final class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40217a = Pattern.compile("([\\\\,;])");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40218b = Pattern.compile("\\n");

    /* renamed from: c  reason: collision with root package name */
    private final List<Map<String, Set<String>>> f40219c;

    f() {
        this((List<Map<String, Set<String>>>) null);
    }

    f(List<Map<String, Set<String>>> list) {
        this.f40219c = list;
    }

    public final CharSequence a(CharSequence charSequence, int i2) {
        String replaceAll = f40218b.matcher(f40217a.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        List<Map<String, Set<String>>> list = this.f40219c;
        Map map = (list == null || list.size() <= i2) ? null : this.f40219c.get(i2);
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Set set = (Set) entry.getValue();
                if (set != null && !set.isEmpty()) {
                    sb.append(';');
                    sb.append((String) entry.getKey());
                    sb.append('=');
                    if (set.size() > 1) {
                        sb.append('\"');
                    }
                    Iterator it2 = set.iterator();
                    sb.append((String) it2.next());
                    while (it2.hasNext()) {
                        sb.append(',');
                        sb.append((String) it2.next());
                    }
                    if (set.size() > 1) {
                        sb.append('\"');
                    }
                }
            }
        }
        sb.append(':');
        sb.append(replaceAll);
        return sb;
    }
}
