package net.one97.paytm.upgradeKyc.utils;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.KycJobIntentService;
import androidx.core.app.h;
import androidx.core.content.b;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.f.d;
import net.one97.paytm.upgradeKyc.helper.e;

public final class KycPointsNotifierService extends KycJobIntentService {
    /* access modifiers changed from: private */
    public ArrayList<PayTMPartnerListModal.Response> j;
    /* access modifiers changed from: private */
    public ArrayList<PayTMPartnerListModal.Response> k;
    private int l;
    private NotificationManager m;
    private h.e n;
    private String o;
    private String p;

    public final void a(Intent intent) {
        k.c(intent, "intent");
        Context context = this;
        int a2 = b.a(context, "android.permission.ACCESS_FINE_LOCATION");
        int a3 = b.a(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (a2 == 0) {
            try {
                e.a aVar = e.f66028b;
                String s = com.paytm.utility.b.s(e.a.b().a());
                k.a((Object) s, "CJRAppCommonUtility.getL….getApplicationContext())");
                Double b2 = p.b(s);
                e.a aVar2 = e.f66028b;
                String t = com.paytm.utility.b.t(e.a.b().a());
                k.a((Object) t, "CJRAppCommonUtility.getL….getApplicationContext())");
                Double b3 = p.b(t);
                if (b2 == null || b3 == null) {
                    a(0.0d, 0.0d);
                } else {
                    a(b2.doubleValue(), b3.doubleValue());
                }
            } catch (Exception unused) {
            }
        } else if (a3 == 0 && a2 == 0) {
            String s2 = com.paytm.utility.b.s(getApplicationContext());
            k.a((Object) s2, "CJRAppCommonUtility.getL…mPref(applicationContext)");
            Double b4 = p.b(s2);
            String t2 = com.paytm.utility.b.t(getApplicationContext());
            k.a((Object) t2, "CJRAppCommonUtility.getL…mPref(applicationContext)");
            Double b5 = p.b(t2);
            if (b4 != null && b5 != null) {
                a(b4.doubleValue(), b5.doubleValue());
            }
        }
    }

    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycPointsNotifierService f66311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f66312b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double f66313c;

        public final void a() {
        }

        public final void a(NetworkCustomError networkCustomError) {
        }

        public final void b() {
        }

        a(KycPointsNotifierService kycPointsNotifierService, double d2, double d3) {
            this.f66311a = kycPointsNotifierService;
            this.f66312b = d2;
            this.f66313c = d3;
        }

        public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList) {
            ArrayList a2;
            k.c(arrayList, "centerList");
            this.f66311a.k = new ArrayList();
            Location location = new Location("");
            location.setLatitude(this.f66312b);
            location.setLongitude(this.f66313c);
            this.f66311a.j = arrayList;
            ArrayList<PayTMPartnerListModal.Response> b2 = this.f66311a.j;
            if (b2 != null) {
                for (PayTMPartnerListModal.Response response : b2) {
                    Location location2 = new Location("");
                    String str = response.cashPointsDetail.location.lat;
                    k.a((Object) str, "it.cashPointsDetail.location.lat");
                    Double b3 = p.b(str);
                    if (b3 == null) {
                        k.a();
                    }
                    location2.setLatitude(b3.doubleValue());
                    String str2 = response.cashPointsDetail.location.lon;
                    k.a((Object) str2, "it.cashPointsDetail.location.lon");
                    Double b4 = p.b(str2);
                    if (b4 == null) {
                        k.a();
                    }
                    location2.setLongitude(b4.doubleValue());
                    if (location.distanceTo(location2) < 2000.0f && (a2 = this.f66311a.k) != null) {
                        a2.add(response);
                    }
                }
            }
            ArrayList a3 = this.f66311a.k;
            Integer valueOf = a3 != null ? Integer.valueOf(a3.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                KycPointsNotifierService.c(this.f66311a);
            }
        }
    }

    private final void a(double d2, double d3) {
        if (getApplicationContext() != null) {
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            new net.one97.paytm.upgradeKyc.f.e(applicationContext, d2, d3, new a(this, d2, d3)).a();
        }
    }

    public static final /* synthetic */ void c(KycPointsNotifierService kycPointsNotifierService) {
        kycPointsNotifierService.o = kycPointsNotifierService.getString(R.string.app_name);
        int i2 = R.string.kyc_centers_found;
        Object[] objArr = new Object[1];
        ArrayList<PayTMPartnerListModal.Response> arrayList = kycPointsNotifierService.k;
        Notification notification = null;
        objArr[0] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        kycPointsNotifierService.p = kycPointsNotifierService.getString(i2, objArr);
        Context context = kycPointsNotifierService;
        kycPointsNotifierService.n = new h.e(context).a(R.drawable.ic_launcher).a((CharSequence) kycPointsNotifierService.o).b((CharSequence) kycPointsNotifierService.p);
        e.a aVar = e.f66028b;
        e.a.b().a(context, "kyc_location_service", "push_triggered", new ArrayList(), "", "/", "kyc");
        e.a aVar2 = e.f66028b;
        Intent intent = new Intent(context, Class.forName(e.a.b().e()));
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(872415232);
        intent.setData(Uri.parse("paytmmp://nearby"));
        intent.putExtra("push_notification", false);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        h.e eVar = kycPointsNotifierService.n;
        if (eVar != null) {
            eVar.a(activity);
        }
        h.e eVar2 = kycPointsNotifierService.n;
        if (eVar2 != null) {
            notification = eVar2.d();
        }
        if (notification != null) {
            notification.flags |= 16;
        }
        notification.defaults |= 1;
        kycPointsNotifierService.l++;
        int i3 = kycPointsNotifierService.l;
        if (i3 == 2147483646) {
            i3 = 0;
        }
        Object systemService = kycPointsNotifierService.getSystemService("notification");
        if (systemService != null) {
            kycPointsNotifierService.m = (NotificationManager) systemService;
            NotificationManager notificationManager = kycPointsNotifierService.m;
            if (notificationManager != null) {
                notificationManager.notify(i3, notification);
            }
            Intent intent2 = new Intent(context, KycPointServiceTriggerReciever.class);
            intent2.setAction("KycPointServiceTriggerReciever");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 9999, intent2, 134217728);
            Object systemService2 = kycPointsNotifierService.getSystemService("alarm");
            if (systemService2 != null) {
                AlarmManager alarmManager = (AlarmManager) systemService2;
                if (Build.VERSION.SDK_INT >= 23) {
                    alarmManager.setAndAllowWhileIdle(0, new Date().getTime() + FileCache.EXPIRE_TIME, broadcast);
                    return;
                }
                Calendar instance = Calendar.getInstance();
                k.a((Object) instance, "Calendar.getInstance()");
                alarmManager.setRepeating(0, instance.getTimeInMillis() + FileCache.EXPIRE_TIME, FileCache.EXPIRE_TIME, broadcast);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.AlarmManager");
        }
        throw new u("null cannot be cast to non-null type android.app.NotificationManager");
    }
}
