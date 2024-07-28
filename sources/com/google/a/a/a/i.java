package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7494a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f7495b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f7496c = Pattern.compile("\\s*(" + "[^\\s/=;\"]+" + ")/(" + "[^\\s/=;\"]+" + ")\\s*(" + ";.*" + ")?", 32);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f7497d;

    /* renamed from: e  reason: collision with root package name */
    private String f7498e = "application";

    /* renamed from: f  reason: collision with root package name */
    private String f7499f = "octet-stream";

    /* renamed from: g  reason: collision with root package name */
    private final SortedMap<String, String> f7500g = new TreeMap();

    /* renamed from: h  reason: collision with root package name */
    private String f7501h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("\"([^\"]*)\"");
        sb.append("|");
        sb.append("[^\\s;\"]*");
        String sb2 = sb.toString();
        f7497d = Pattern.compile("\\s*;\\s*(" + "[^\\s/=;\"]+" + ")=(" + sb2 + ")");
    }

    public i(String str) {
        b(str);
    }

    private i b(String str) {
        Matcher matcher = f7496c.matcher(str);
        c.a(matcher.matches(), (Object) "Type must be in the 'maintype/subtype; parameter=value' format");
        String group = matcher.group(1);
        c.a(f7494a.matcher(group).matches(), (Object) "Type contains reserved characters");
        this.f7498e = group;
        this.f7501h = null;
        String group2 = matcher.group(2);
        c.a(f7494a.matcher(group2).matches(), (Object) "Subtype contains reserved characters");
        this.f7499f = group2;
        this.f7501h = null;
        String group3 = matcher.group(3);
        if (group3 != null) {
            Matcher matcher2 = f7497d.matcher(group3);
            while (matcher2.find()) {
                String group4 = matcher2.group(1);
                String group5 = matcher2.group(3);
                if (group5 == null) {
                    group5 = matcher2.group(2);
                }
                a(group4, group5);
            }
        }
        return this;
    }

    public final i a(String str, String str2) {
        if (str2 == null) {
            c(str);
            return this;
        }
        c.a(f7495b.matcher(str).matches(), (Object) "Name contains reserved characters");
        this.f7501h = null;
        this.f7500g.put(str.toLowerCase(), str2);
        return this;
    }

    private i c(String str) {
        this.f7501h = null;
        this.f7500g.remove(str.toLowerCase());
        return this;
    }

    static boolean a(String str) {
        return f7495b.matcher(str).matches();
    }

    private static String d(String str) {
        String replace = str.replace("\\", "\\\\").replace("\"", "\\\"");
        return "\"" + replace + "\"";
    }

    public final String a() {
        String str = this.f7501h;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7498e);
        sb.append('/');
        sb.append(this.f7499f);
        SortedMap<String, String> sortedMap = this.f7500g;
        if (sortedMap != null) {
            for (Map.Entry next : sortedMap.entrySet()) {
                String str2 = (String) next.getValue();
                sb.append("; ");
                sb.append((String) next.getKey());
                sb.append("=");
                if (!a(str2)) {
                    str2 = d(str2);
                }
                sb.append(str2);
            }
        }
        this.f7501h = sb.toString();
        return this.f7501h;
    }

    public final String toString() {
        return a();
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!(iVar != null && this.f7498e.equalsIgnoreCase(iVar.f7498e) && this.f7499f.equalsIgnoreCase(iVar.f7499f)) || !this.f7500g.equals(iVar.f7500g)) {
            return false;
        }
        return true;
    }

    public final Charset b() {
        String str = (String) this.f7500g.get("charset".toLowerCase());
        if (str == null) {
            return null;
        }
        return Charset.forName(str);
    }
}
