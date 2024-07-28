package net.one97.paytm.locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.v;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRLocaleData;
import net.one97.paytm.common.entity.LangEntity;
import net.one97.paytm.l;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.locale.a.b;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.locale.storage.LocaleDBQuery;
import net.one97.paytm.utils.ag;

public class a implements b, b.a {

    /* renamed from: d  reason: collision with root package name */
    public static String f53061d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f53062e = TimeUnit.HOURS.toMillis(12);
    private static volatile c j = new c();

    /* renamed from: a  reason: collision with root package name */
    public j f53063a;

    /* renamed from: b  reason: collision with root package name */
    public String f53064b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53065c;

    /* renamed from: f  reason: collision with root package name */
    private final b f53066f;

    /* renamed from: g  reason: collision with root package name */
    private Activity f53067g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.locale.a.b f53068h;

    /* renamed from: i  reason: collision with root package name */
    private String f53069i;
    private HandlerThread k;
    private Handler l;
    private Handler m;
    private long n;
    private String o;
    private volatile boolean p = false;
    private volatile boolean q = false;
    private C0945a r;
    private volatile int s = 0;

    /* renamed from: net.one97.paytm.locale.a$a  reason: collision with other inner class name */
    public interface C0945a {
        void a(boolean z);
    }

    public a(C0945a aVar, Activity activity, b bVar) {
        this.f53067g = activity;
        this.f53066f = bVar;
        this.m = new Handler(Looper.getMainLooper());
        this.r = aVar;
    }

    public a(Activity activity, b bVar) {
        this.f53067g = activity;
        this.f53066f = bVar;
        this.m = new Handler(Looper.getMainLooper());
    }

    public final void a(String str) {
        q.d("onCancelClicked:  ".concat(String.valueOf(str)));
        C0945a aVar = this.r;
        if (aVar != null) {
            aVar.a(false);
        }
        this.p = true;
        net.one97.paytm.locale.a.b bVar = this.f53068h;
        if (bVar != null) {
            bVar.a();
            this.f53068h.dismissAllowingStateLoss();
        }
    }

    public final void b(String str) {
        if (com.paytm.utility.a.m(d.b().a())) {
            this.p = false;
            this.n = LocaleDBQuery.getLastUpdatedTimeStamp(LocaleDBContract.getLanguageIdFromLocale(str));
            this.f53069i = str;
            if (System.currentTimeMillis() >= this.n + f53062e || LocaleDBQuery.isToUpdateLangByPush()) {
                j = new c();
                this.o = a(this.n, "yyyyMMddHHmmss");
                if (this.f53065c) {
                    d(str);
                } else if (!v.a(this.f53064b) && this.f53064b.equalsIgnoreCase(str) && !com.paytm.utility.a.m(this.f53067g)) {
                    a(true);
                } else if (this.q) {
                    Activity activity = this.f53067g;
                    Toast.makeText(activity, activity.getString(R.string.please_wait), 0).show();
                } else {
                    this.f53068h = new net.one97.paytm.locale.a.b();
                    net.one97.paytm.locale.a.b bVar = this.f53068h;
                    bVar.f53081a = this;
                    bVar.setCancelable(false);
                    Bundle bundle = new Bundle();
                    bundle.putString("languageCode", str);
                    this.f53068h.setArguments(bundle);
                    androidx.fragment.app.q a2 = this.f53063a.a();
                    net.one97.paytm.locale.a.b bVar2 = this.f53068h;
                    a2.a((Fragment) bVar2, bVar2.getTag()).c();
                    d(str);
                }
            } else if (!this.f53065c) {
                c(str);
                a();
                a(true);
            }
        }
    }

    public final void a(j jVar) {
        this.f53063a = jVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, int i3) {
        net.one97.paytm.locale.a.b bVar = this.f53068h;
        if (bVar != null && bVar.isVisible()) {
            this.f53068h.a(((i2 * 60) / i3) + 40);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2) {
        if (!this.f53065c) {
            a(true);
            c(this.f53069i);
            a();
        }
        LocaleDBQuery.saveLastUpdatedTimeStamp(i2);
    }

    private void a(boolean z) {
        net.one97.paytm.locale.a.b bVar = this.f53068h;
        if (bVar != null) {
            bVar.a();
            this.f53068h.dismissAllowingStateLoss();
        }
        new Handler().postDelayed(new Runnable(z) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                a.this.b(this.f$1);
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        if (z) {
            C0945a aVar = this.r;
            if (aVar != null) {
                aVar.a(true);
            }
            this.f53066f.refreshHomeLocaleChange(true, false);
        }
    }

    private void c(String str) {
        this.f53064b = str;
        ag.a(this.f53067g.getApplicationContext()).a("user-set-language", Resources.getSystem().getConfiguration().locale.getLanguage(), true);
        n.b(this.f53067g, str);
        if (!this.f53065c) {
            d.a(this.f53067g, str);
            Activity activity = this.f53067g;
            d.b(activity, d.a(activity));
        }
        l lVar = l.f52428a;
        l.a();
    }

    private void a() {
        Activity activity = this.f53067g;
        if (activity != null && !activity.isFinishing() && com.paytm.utility.a.m(this.f53067g) && !this.f53065c) {
            v.a(com.paytm.utility.a.q(this.f53067g));
        }
    }

    private void d(String str) {
        if (!this.f53067g.isFinishing() && !this.p) {
            this.s = 0;
            b();
            this.f53069i = str;
            String str2 = d.b().h() + "&language=" + str + "-IN&page=" + j.f53124a + "&pageSize=15000";
            if (this.n != 0) {
                str2 = str2 + "&timestamp=" + this.o;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Encoding", "gzip");
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f53067g;
            bVar.f42880d = str2;
            bVar.f42882f = hashMap;
            bVar.n = a.b.USER_FACING;
            bVar.f42878b = a.c.HOME;
            bVar.j = this;
            bVar.f42885i = new CJRLocaleData();
            bVar.f42879c = a.C0715a.GET;
            bVar.k = false;
            bVar.o = a.class.getSimpleName();
            com.paytm.network.a l2 = bVar.l();
            if (com.paytm.utility.a.m(this.f53067g)) {
                q.d("fetchLanguageData: ".concat(String.valueOf(str2)));
                l2.a();
            } else if (!this.f53065c) {
                a(this.f53067g, l2);
            }
        }
    }

    private void b() {
        if (this.s < 40) {
            this.s++;
        }
        net.one97.paytm.locale.a.b bVar = this.f53068h;
        if (bVar != null && bVar.isVisible()) {
            this.f53068h.a(this.s);
        }
        if (this.s < 40 && !this.p && !this.f53067g.isFinishing()) {
            this.m.postDelayed(new Runnable() {
                public final void run() {
                    a.this.d();
                }
            }, 20);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (this.s < 40) {
            b();
        }
    }

    public final void a(final Activity activity, final com.paytm.network.a aVar) {
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(activity.getResources().getString(R.string.no_connection));
            builder.setMessage(activity.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(activity.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (com.paytm.utility.a.m(activity)) {
                        aVar.a();
                    } else {
                        a.this.a(activity, aVar);
                    }
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.a(dialogInterface);
                }
            });
            builder.setCancelable(true);
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.m.post(new Runnable() {
            public final void run() {
                a.this.c();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a(false);
    }

    private static String a(long j2, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            return simpleDateFormat.format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        q.d("onresponse: " + this.p);
        if (!this.p) {
            LocaleDBQuery.savePushReceivedToUpdateLang(false);
            if (iJRPaytmDataModel instanceof CJRLocaleData) {
                CJRLocaleData cJRLocaleData = (CJRLocaleData) iJRPaytmDataModel;
                if (cJRLocaleData.ERROR == null) {
                    if (this.l == null) {
                        this.k = new HandlerThread(a.class.getName(), 5);
                        this.k.start();
                        this.l = new Handler(this.k.getLooper());
                        if (this.m == null) {
                            this.m = new Handler(Looper.getMainLooper());
                        }
                    }
                    this.s = 40;
                    b();
                    this.l.post(new Runnable(cJRLocaleData) {
                        private final /* synthetic */ CJRLocaleData f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            a.this.a(this.f$1);
                        }
                    });
                } else if (!this.f53065c) {
                    if ("514".equals(cJRLocaleData.ERROR) || ("516".equals(cJRLocaleData.ERROR) && "en".equalsIgnoreCase(this.f53069i))) {
                        a(true);
                        c(this.f53069i);
                        a();
                        return;
                    }
                    Toast.makeText(this.f53067g, cJRLocaleData.MESSAGE, 0).show();
                    this.f53066f.refreshHomeLocaleChange(true, false);
                    net.one97.paytm.locale.a.b bVar = this.f53068h;
                    if (bVar != null) {
                        bVar.a();
                        this.f53068h.dismissAllowingStateLoss();
                    }
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        LocaleDBQuery.savePushReceivedToUpdateLang(false);
        if (!this.f53065c) {
            net.one97.paytm.locale.a.b bVar = this.f53068h;
            if (bVar != null) {
                bVar.a();
            }
            a(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRLocaleData cJRLocaleData) {
        boolean z;
        ArrayList<LangEntity> arrayList = new ArrayList<>();
        if (cJRLocaleData != null) {
            arrayList = cJRLocaleData.getData();
            z = cJRLocaleData.hasNext;
        } else {
            z = false;
        }
        int languageIdFromLocale = LocaleDBContract.getLanguageIdFromLocale(this.f53069i);
        if (arrayList != null) {
            this.q = true;
            q.d("saveAndRequestToFetchMoreData: started saving: " + languageIdFromLocale + ":  " + this.p);
            LocaleDBQuery.getDB().saveData(languageIdFromLocale, arrayList, (b.C0946b) new b.C0946b() {
                public final void doUpdateProgress(int i2, int i3) {
                    a.this.a(i2, i3);
                }
            });
            q.d("saveAndRequestToFetchMoreData: started saved: " + languageIdFromLocale + ":  " + this.p);
            this.q = false;
            if (this.p) {
                return;
            }
            if (z) {
                j.f53124a++;
                d(this.f53069i);
                return;
            }
            this.m.post(new Runnable(languageIdFromLocale) {
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    a.this.a(this.f$1);
                }
            });
        }
    }
}
