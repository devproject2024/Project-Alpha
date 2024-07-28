package net.one97.paytm.o2o.events.e;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.common.entity.events.CJRAddressDetailModel;
import net.one97.paytm.common.entity.events.CJRParticularEventDescriptionModel;
import net.one97.paytm.common.entity.events.CJRResourceDetailModel;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f73750a = net.one97.paytm.o2o.events.a.a().getAppContext();

    /* renamed from: b  reason: collision with root package name */
    private final String f73751b = "EventDigitalTicket_";

    /* renamed from: c  reason: collision with root package name */
    private String f73752c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f73753d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.o2o.events.b.a f73754e;

    /* renamed from: f  reason: collision with root package name */
    private BroadcastReceiver f73755f = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            if (extras != null) {
                query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            }
            Cursor query2 = a.this.f73753d.query(query);
            if (!query2.moveToFirst()) {
                return;
            }
            if (query2.getInt(query2.getColumnIndex("status")) == 8) {
                a.this.f73754e.c();
                a.a(a.this, context);
                return;
            }
            a.this.f73754e.d();
            a.a(a.this, context);
        }
    };

    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x002d
            java.lang.String r1 = r3.trim()     // Catch:{ Exception -> 0x002d }
            int r1 = r1.length()     // Catch:{ Exception -> 0x002d }
            if (r1 <= 0) goto L_0x002d
            java.util.Locale r1 = new java.util.Locale     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x002d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002d }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x002d }
            r2.<init>(r4, r1)     // Catch:{ Exception -> 0x002d }
            r4 = 0
            java.util.Date r4 = r2.parse(r3)     // Catch:{ ParseException -> 0x0021 }
        L_0x0021:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x002d }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x002d }
            r3.<init>(r5, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.String r3 = r3.format(r4)     // Catch:{ Exception -> 0x002d }
            return r3
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.e.a.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        String b2 = d.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2.equals("") || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String substring = str.substring(0, 10);
        String substring2 = str.substring(11);
        String str2 = Integer.parseInt(substring.split("-")[1]) != Integer.parseInt(substring2.split("-")[1]) ? "d MMM" : "d";
        return a(substring, "yyyy-MM-dd", str2) + " - " + a(substring2, "yyyy-MM-dd", "d MMM, yyyy");
    }

    public static String a(CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel) {
        try {
            for (CJRResourceDetailModel next : cJRParticularEventDescriptionModel.getResources()) {
                if (next.getType().equals("banner_android")) {
                    return next.getValue1();
                }
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static Context a() {
        return f73750a;
    }

    public static String a(CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel, int i2, int i3, int i4) {
        CJRAddressDetailModel cJRAddressDetailModel = cJRParticularEventDescriptionModel.getmAddressList().get(i2);
        return (a(cJRAddressDetailModel.getDateRangeFromIndex(i3)) + ", ") + c.a(cJRAddressDetailModel.getTimeForDateRangeFromIndex(i3, i4).getmStart(), Locale.ENGLISH);
    }

    public static String b(CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel, int i2, int i3, int i4) {
        String str;
        CJRAddressDetailModel cJRAddressDetailModel = cJRParticularEventDescriptionModel.getmAddressList().get(i2);
        String dateFromIndex = cJRAddressDetailModel.getDateFromIndex(i3);
        if (dateFromIndex != null) {
            Date a2 = c.a(dateFromIndex);
            str = c.a(a2) + ", " + c.c(a2) + " " + c.b(a2) + " at ";
        } else {
            str = "";
        }
        return str + c.a(cJRAddressDetailModel.getTimeFromIndex(i3, i4).getmStart(), Locale.ENGLISH);
    }

    public final void a(Context context, String str, String str2, net.one97.paytm.o2o.events.b.a aVar) {
        try {
            this.f73752c = str2;
            this.f73754e = aVar;
            context.registerReceiver(this.f73755f, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            a(Uri.parse(str));
        } catch (Exception unused) {
        }
    }

    private void a(Uri uri) {
        if (!b() || !c()) {
            this.f73754e.d();
            return;
        }
        this.f73753d = (DownloadManager) f73750a.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("EventDigitalTicket_" + this.f73752c);
        request.setDescription("Downloading...");
        if (Build.VERSION.SDK_INT >= 29) {
            String str = Environment.DIRECTORY_DOWNLOADS;
            request.setDestinationInExternalPublicDir(str, "EventDigitalTicket__" + this.f73752c + ".pdf");
        } else {
            request.allowScanningByMediaScanner();
            Context context = f73750a;
            String str2 = Environment.DIRECTORY_DOWNLOADS;
            request.setDestinationInExternalFilesDir(context, str2, "EventDigitalTicket__" + this.f73752c + ".pdf");
        }
        request.setNotificationVisibility(1);
        this.f73753d.enqueue(request);
    }

    private static boolean b() {
        int applicationEnabledSetting = f73750a.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
    }

    private static boolean c() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    static /* synthetic */ void a(a aVar, Context context) {
        try {
            context.unregisterReceiver(aVar.f73755f);
        } catch (Exception unused) {
        }
    }
}
