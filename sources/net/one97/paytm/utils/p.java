package net.one97.paytm.utils;

import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static String f69777a = p.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<Integer> f69778b = new Comparator<Integer>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<String> f69779c = new Comparator<String>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            int compare = String.CASE_INSENSITIVE_ORDER.compare(String.valueOf(str.charAt(0)), String.valueOf(str2.charAt(0)));
            return compare == 0 ? Integer.compare(Integer.parseInt(str.substring(1)), Integer.parseInt(str2.substring(1))) : compare;
        }
    };

    public static String a(String str) {
        ArrayList arrayList;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    String trim = str.substring(0, str.indexOf("-")).trim();
                    List asList = Arrays.asList(str.substring(str.indexOf("-") + 1).trim().split("\\s*,\\s*"));
                    if (asList != null) {
                        arrayList = new ArrayList(asList);
                        Collections.sort(arrayList, f69779c);
                    } else {
                        arrayList = null;
                    }
                    String a2 = a((ArrayList<String>) arrayList);
                    if (!TextUtils.isEmpty(a2)) {
                        if (!TextUtils.isEmpty(trim)) {
                            sb.append(trim);
                            sb.append(" - ");
                        }
                        sb.append(a2);
                    } else {
                        sb.append(str);
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return null;
    }

    private static String a(ArrayList<String> arrayList) {
        try {
            StringBuilder sb = new StringBuilder();
            char charAt = arrayList.get(0).charAt(0);
            int parseInt = Integer.parseInt(arrayList.get(0).substring(1));
            int i2 = parseInt;
            char c2 = charAt;
            int i3 = 1;
            while (i3 <= arrayList.size()) {
                char c3 = '*';
                int i4 = -1;
                if (i3 != arrayList.size()) {
                    String str = arrayList.get(i3);
                    i4 = Integer.parseInt(str.substring(1));
                    c3 = str.charAt(0);
                }
                if (c3 != c2 || i4 - i2 > 1 || i3 == arrayList.size()) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(c2);
                    sb.append(parseInt);
                    int i5 = i2 - parseInt;
                    if (i5 > 1) {
                        sb.append("-");
                        sb.append(c2);
                        sb.append(i2);
                    } else if (i5 == 1) {
                        sb.append(", ");
                        sb.append(c2);
                        sb.append(i2);
                    }
                    if (c3 != c2) {
                        c2 = c3;
                    }
                    parseInt = i4;
                }
                i3++;
                i2 = i4;
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
