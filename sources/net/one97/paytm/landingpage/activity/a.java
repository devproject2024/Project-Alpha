package net.one97.paytm.landingpage.activity;

import android.content.Context;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.b.d;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f52734a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f52735b;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r10, net.one97.paytm.landingpage.c.h r11) {
        /*
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x0009
            android.os.Looper.prepare()
        L_0x0009:
            android.content.Context r1 = r10.getApplicationContext()
            com.paytm.b.a.a r1 = net.one97.paytm.utils.ag.a(r1)
            r2 = 1
            java.lang.String r3 = "is_upi_user"
            boolean r1 = r1.b(r3, r2)
            android.content.Context r3 = net.one97.paytm.upi.g.d()
            r4 = 0
            net.one97.paytm.upi.h.a r3 = net.one97.paytm.upi.h.a.a(r3, r4)
            net.one97.paytm.upi.registration.b.a.b r3 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r3)
            boolean r3 = r3.e()
            android.content.Context r5 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r4 = net.one97.paytm.upi.h.a.a(r5, r4)
            net.one97.paytm.upi.registration.b.a.b r4 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r4)
            boolean r4 = r4.f()
            if (r1 == 0) goto L_0x00f9
            if (r3 != 0) goto L_0x00f9
            if (r4 != 0) goto L_0x00f9
            int r1 = b(r10)
            android.content.Context r3 = r10.getApplicationContext()
            com.paytm.b.a.a r3 = net.one97.paytm.utils.ag.a(r3)
            r4 = 0
            java.lang.String r6 = "is_select_bank_time"
            long r7 = r3.b((java.lang.String) r6, (long) r4, (boolean) r2)
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x007a
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            long r3 = r3.getTimeInMillis()
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            java.util.Date r9 = new java.util.Date
            r9.<init>(r7)
            r5.setTime(r9)
            r7 = 11
            r5.add(r7, r1)
            long r7 = r5.getTimeInMillis()
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x007a
            r1 = 0
            goto L_0x007b
        L_0x007a:
            r1 = 1
        L_0x007b:
            if (r1 == 0) goto L_0x00f9
            boolean r1 = com.paytm.utility.a.p(r10)
            if (r1 == 0) goto L_0x00f9
            f52735b = r2
            r11.dismiss()
            android.content.Context r1 = r10.getApplicationContext()
            boolean r1 = com.paytm.utility.a.p(r1)
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            java.lang.String r4 = "is_from_scheduler"
            if (r1 == 0) goto L_0x00ab
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r5 = r10.getApplicationContext()
            java.lang.Class<net.one97.paytm.upi.registration.view.UpiSelectBankActivity> r7 = net.one97.paytm.upi.registration.view.UpiSelectBankActivity.class
            r1.<init>(r5, r7)
            r1.putExtra(r4, r2)
            r1.setFlags(r3)
            r10.startActivity(r1)
            goto L_0x00c8
        L_0x00ab:
            net.one97.paytm.common.b.e r1 = net.one97.paytm.common.b.d.a()
            android.content.Context r5 = r10.getApplicationContext()
            android.content.Intent r1 = r1.n(r5)
            java.lang.String r5 = "resultant_activity"
            java.lang.String r7 = "upi"
            r1.putExtra(r5, r7)
            r1.putExtra(r4, r2)
            r1.setFlags(r3)
            r10.startActivity(r1)
        L_0x00c8:
            android.content.Context r1 = r10.getApplicationContext()
            com.paytm.b.a.a r1 = net.one97.paytm.utils.ag.a(r1)
            long r3 = java.lang.System.currentTimeMillis()
            r1.a((java.lang.String) r6, (long) r3, (boolean) r2)
            net.one97.paytm.common.b.e r1 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r3 = "wallet_vpa"
            java.lang.String r4 = "select_bank_dialog_loaded"
            r5 = 0
            r6 = 0
            java.lang.String r7 = ""
            java.lang.String r8 = "/"
            java.lang.String r9 = "banksavingsaccount"
            r2 = r10
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00ed }
            return
        L_0x00ed:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x00f9
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.activity.a.a(android.content.Context, net.one97.paytm.landingpage.c.h):void");
    }

    public static int b(Context context) {
        return ag.a(context.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SELECT_BANK_DIALOG_INTERVAL, 0, true);
    }

    public static void a(Context context, int i2) {
        ag.a(context.getApplicationContext()).a(UpiConstants.PREF_KEY_IS_SELECT_BANK_DIALOG_INTERVAL, i2, true);
    }

    public static void c(Context context) {
        ag.a(context.getApplicationContext()).a(UpiConstants.PREF_KEY_UPI_QR_HOME_DIALOG_TIME, System.currentTimeMillis(), true);
    }

    public static boolean a(Context context) {
        String a2 = d.b().a("upi_pop_up_logic");
        int i2 = -1;
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(AppConstants.COMMA);
            if (split.length > 2) {
                i2 = Integer.parseInt(split[2]);
            }
        }
        long b2 = ag.a(context.getApplicationContext()).b(UpiConstants.PREF_KEY_UPI_QR_HOME_DIALOG_TIME, 0, true);
        if (i2 <= 0) {
            return false;
        }
        if (b2 <= 0) {
            return true;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(b2));
        return TimeUnit.DAYS.convert(timeInMillis - instance.getTimeInMillis(), TimeUnit.MILLISECONDS) >= ((long) i2);
    }
}
