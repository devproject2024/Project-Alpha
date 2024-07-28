package kotlin.m;

import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.j.e;

public class r extends q {

    static final class a extends l implements kotlin.g.a.b<String, String> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        public final String invoke(String str) {
            k.d(str, "line");
            return str;
        }
    }

    public static final String a(String str) {
        kotlin.g.a.b bVar;
        String str2;
        k.d(str, "$this$trimIndent");
        k.d(str, "$this$replaceIndent");
        k.d("", "newIndent");
        List<String> g2 = p.g(str);
        Iterable iterable = g2;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (true ^ p.a((String) next)) {
                arrayList.add(next);
            }
        }
        Iterable<String> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable2));
        for (String b2 : iterable2) {
            arrayList2.add(Integer.valueOf(b(b2)));
        }
        Integer num = (Integer) kotlin.a.k.h((List) arrayList2);
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (g2.size() * 0);
        if ("".length() == 0) {
            bVar = a.INSTANCE;
        } else {
            bVar = new b("");
        }
        int a2 = kotlin.a.k.a(g2);
        Collection arrayList3 = new ArrayList();
        int i2 = 0;
        for (Object next2 : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            String str3 = (String) next2;
            if ((i2 == 0 || i2 == a2) && p.a(str3)) {
                str3 = null;
            } else {
                k.d(str3, "$this$drop");
                if (intValue >= 0) {
                    String substring = str3.substring(e.c(intValue, str3.length()));
                    k.b(substring, "(this as java.lang.String).substring(startIndex)");
                    if (!(substring == null || (str2 = (String) bVar.invoke(substring)) == null)) {
                        str3 = str2;
                    }
                } else {
                    throw new IllegalArgumentException(("Requested character count " + intValue + " is less than zero.").toString());
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) kotlin.a.k.a((List) arrayList3, new StringBuilder(length), (CharSequence) StringUtility.NEW_LINE, (CharSequence) "", (CharSequence) "", -1, (CharSequence) AppConstants.DOTS, (kotlin.g.a.b) null)).toString();
        k.b(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    private static final int b(String str) {
        CharSequence charSequence = str;
        int length = charSequence.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!a.a(charSequence.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return i2 == -1 ? str.length() : i2;
    }

    static final class b extends l implements kotlin.g.a.b<String, String> {
        final /* synthetic */ String $indent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$indent = str;
        }

        public final String invoke(String str) {
            k.d(str, "line");
            return this.$indent + str;
        }
    }
}
