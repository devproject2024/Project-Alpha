package net.one97.paytm.packageScanner;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.google.android.gms.common.util.f;
import com.paytm.utility.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.packageScanner.view.SecurityAlertActivity;
import net.one97.paytm.utils.ag;
import org.json.JSONObject;

public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public static final C1062a f57028b = new C1062a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final boolean f57029a;

    /* renamed from: c  reason: collision with root package name */
    private List<RemoteAppDataModel> f57030c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f57031d;

    public a(Context context, boolean z) {
        k.c(context, "context");
        this.f57031d = context;
        this.f57029a = z;
    }

    /* renamed from: net.one97.paytm.packageScanner.a$a  reason: collision with other inner class name */
    public static final class C1062a {
        private C1062a() {
        }

        public /* synthetic */ C1062a(byte b2) {
            this();
        }
    }

    public final void run() {
        if (f.a(this.f57030c)) {
            try {
                String jSONArray = new JSONObject(d.b().a("allRemoteAppPackageList")).getJSONArray("remote_apps").toString();
                k.a((Object) jSONArray, "remoteAppsJson.getJSONAr…\"remote_apps\").toString()");
                this.f57030c = (List) new com.google.gson.f().a(jSONArray, new b().getType());
            } catch (IOException e2) {
                q.b(e2.getMessage());
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }
        a();
    }

    private final void a() {
        ArrayList arrayList = new ArrayList();
        List<RemoteAppDataModel> list = this.f57030c;
        int i2 = 0;
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            while (i2 < size) {
                RemoteAppDataModel remoteAppDataModel = list.get(i2);
                String pckg_name = remoteAppDataModel.getPckg_name();
                if (a(pckg_name)) {
                    q.d("found package ".concat(String.valueOf(pckg_name)));
                    arrayList.add(remoteAppDataModel);
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a(this.f57031d);
            k.a((Object) a2, "LocalBroadcastManager.getInstance(context)");
            a2.a(new Intent("NoDangerousAppFound"));
            q.d("NoDangerousAppFound event sent");
            return;
        }
        Context context = this.f57031d;
        new Handler(context.getMainLooper()).post(new c(this, arrayList, context));
        ag.a aVar = ag.f69605a;
        Context applicationContext = this.f57031d.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a3 = ag.a.a(applicationContext);
        if (a3 != null) {
            a3.a("lastScanTime", System.currentTimeMillis(), true);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f57038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f57039c;

        c(a aVar, ArrayList arrayList, Context context) {
            this.f57037a = aVar;
            this.f57038b = arrayList;
            this.f57039c = context;
        }

        public final void run() {
            if (this.f57037a.f57029a && !f.a(this.f57038b)) {
                Intent intent = new Intent(this.f57039c, SecurityAlertActivity.class);
                intent.putExtra("InstalledAppList", this.f57038b);
                this.f57039c.startActivity(intent);
            }
        }
    }

    public static final class b extends com.google.gson.b.a<List<? extends RemoteAppDataModel>> {
        b() {
        }
    }

    private final boolean a(String str) {
        try {
            this.f57031d.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
