package net.one97.paytm.smssdk;

import android.content.Context;
import androidx.work.c;
import androidx.work.m;
import androidx.work.o;
import androidx.work.p;
import androidx.work.v;
import androidx.work.w;
import com.paytm.utility.q;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.smssdk.a.a;
import net.one97.paytm.smssdk.a.c;
import net.one97.paytm.smssdk.b.a;
import net.one97.paytm.smssdk.workman.SmsProcessWorker;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static a f65063a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f65064b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static net.one97.paytm.smssdk.a.b f65065c;

    private b() {
    }

    private static a d() {
        if (f65063a == null) {
            q.d("getSmsDataProvider");
            try {
                Class<?> cls = Class.forName("net.one97.paytm.smssdk.SmsSdkProviderImpl");
                k.a((Object) cls, "Class.forName(\"net.one97…ssdk.SmsSdkProviderImpl\")");
                Method method = cls.getMethod("initSmsSdk", new Class[0]);
                k.a((Object) method, "cls.getMethod(\"initSmsSdk\")");
                method.invoke((Object) null, new Object[0]);
                q.d("Initialized SmsSdkProviderImpl from SmsSdk module via reflection");
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        a aVar = f65063a;
        if (aVar == null) {
            k.a("provider");
        }
        return aVar;
    }

    public static net.one97.paytm.smssdk.a.b a() {
        if (f65065c == null) {
            f65065c = d().provideSmsSdkConfig();
        }
        net.one97.paytm.smssdk.a.b bVar = f65065c;
        if (bVar == null) {
            k.a();
        }
        return bVar;
    }

    public static void a(Context context, List<String> list, net.one97.paytm.smssdk.b.b bVar) {
        k.c(context, "context");
        k.c(list, "consentKeys");
        k.c(bVar, "listener");
        net.one97.paytm.smssdk.b.a aVar = net.one97.paytm.smssdk.b.a.f65066a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        k.c(applicationContext, "context");
        k.c(list, "consentKeys");
        k.c(bVar, "listener");
        if (list.size() == 0) {
            q.d("getConsent returning one of the param is null");
            return;
        }
        q.d("requestig consent keys : ".concat(String.valueOf(list)));
        Map<String, Boolean> a2 = net.one97.paytm.smssdk.b.a.a(applicationContext, list);
        if (a2 == null) {
            a aVar2 = a.f65042a;
            String uuid = UUID.randomUUID().toString();
            k.a((Object) uuid, "UUID.randomUUID().toString()");
            com.paytm.network.a a3 = a.a(applicationContext, new a.C1286a(bVar, applicationContext), list, uuid);
            if (a3 != null) {
                a3.a();
                return;
            }
            return;
        }
        q.d("consent locally found ".concat(String.valueOf(a2)));
        bVar.a(a2, 0, (String) null);
    }

    public static void a(Context context, String str, boolean z, net.one97.paytm.smssdk.b.b bVar) {
        k.c(context, "context");
        k.c(str, "consentKey");
        k.c(bVar, "listener");
        net.one97.paytm.smssdk.b.a aVar = net.one97.paytm.smssdk.b.a.f65066a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        net.one97.paytm.smssdk.b.a.a(applicationContext, str, z, bVar);
    }

    public static String b() {
        return d().getSSOToken();
    }

    public static String c() {
        return d().getUserId();
    }

    static void a(Context context, long j) throws ExecutionException {
        c b2 = new c.a().a().a(m.CONNECTED).b();
        k.a((Object) b2, "Constraints.Builder()\n  …TED)\n            .build()");
        w c2 = ((p.a) ((p.a) ((p.a) new p.a(SmsProcessWorker.class, j, TimeUnit.SECONDS, TimeUnit.MILLISECONDS).a("sms-process-worker")).a(b2)).a(androidx.work.a.LINEAR, (context.getApplicationInfo().flags & 2) != 0 ? 1 : 10, TimeUnit.MINUTES)).c();
        k.a((Object) c2, "PeriodicWorkRequest.Buil…\n                .build()");
        v.a(context).a((w) (p) c2);
        q.d("registered ...sms-process-worker");
    }

    static o a(Context context, String str) {
        q.d("cancelling job sms-process-worker");
        o a2 = v.a(context).a(str);
        k.a((Object) a2, "WorkManager.getInstance(…).cancelAllWorkByTag(tag)");
        return a2;
    }

    public static void a(Context context) {
        k.c(context, "context");
        c.a aVar = net.one97.paytm.smssdk.a.c.f65060a;
        c.a.a(context).a();
        q.d("cleared sms data");
    }
}
