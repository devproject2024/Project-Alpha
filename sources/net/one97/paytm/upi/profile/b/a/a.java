package net.one97.paytm.upi.profile.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;

public class a implements net.one97.paytm.upi.profile.b.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f67818c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f67819a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67820b = a.class.getCanonicalName();

    public final void a(String str) {
    }

    public final void a(UserUpiDetails userUpiDetails, a.C1382a aVar, String str, String str2) {
    }

    public final void a(a.C1382a aVar, String str, String str2) {
    }

    public final void a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type, UserUpiDetails userUpiDetails, a.C1382a aVar, String str, String str2) {
    }

    private a(Context context) {
        this.f67819a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f67818c == null) {
                f67818c = new a(context);
            }
            aVar = f67818c;
        }
        return aVar;
    }

    public final void a(a.b bVar) {
        try {
            String b2 = PaytmUpiPrefUtil.getPref(this.f67819a.getApplicationContext()).b(UpiConstants.KEY_SHARED_PREF_VPA_INFO, "", false);
            if (b2.equals("")) {
                b2 = null;
            }
            List list = (List) new f().a(b2, new com.google.gson.b.a<ArrayList<UserVpaInfo>>() {
            }.getType());
            if (bVar != null) {
                bVar.a(list);
            }
        } catch (Exception unused) {
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public final void a() {
        PaytmUpiPrefUtil.getPref(this.f67819a.getApplicationContext()).a(UpiConstants.KEY_SHARED_PREF_VPA_INFO, (String) null, false);
    }

    public static void a(Context context, String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            net.one97.paytm.upi.database.a a2 = net.one97.paytm.upi.database.a.a(context);
            if (!a2.b()) {
                sQLiteDatabase = a2.a();
            } else {
                sQLiteDatabase = a2.f66667a;
            }
            PaytmLogs.i("Rows affected::", "count::".concat(String.valueOf(sQLiteDatabase.delete(str, (String) null, (String[]) null))));
        } catch (Exception unused) {
        }
    }
}
