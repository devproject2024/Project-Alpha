package net.one97.paytm.addmoney.utils;

import android.content.Context;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.helper.a;

public final class d {
    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            a.b().a(context.getApplicationContext(), str, str2, str4, str5, "", str3, "add_money");
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            a.b().a(str, "add_money", context.getApplicationContext());
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, ArrayList<String> arrayList, String str4) {
        a.b().a(context, str, str2, arrayList, str4, str3, "");
    }

    public static void a(Context context, String str, String str2, String str3, ArrayList<String> arrayList, String str4, String str5) {
        a.b().a(context, str, str2, arrayList, str4, str3, str5);
    }
}
