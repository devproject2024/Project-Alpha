package net.one97.paytm.smssdk;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.j;
import androidx.work.o;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.smssdk.a.b;
import net.one97.paytm.smssdk.a.c;

public final class SmsSdkProviderImpl implements net.one97.paytm.smssdk.a.a {
    public static final a Companion = new a((byte) 0);
    private static final String KEY_CONSENT_LIST = "sms_sdk_consent_list";
    private static final String KEY_INGEST_URL = "sms_ingest_url";
    private static final String KEY_IS_SMS_SDK_ON = "is_sms_sdk_on";
    private static final String KEY_REGEX = "sms_regex";
    private static final String KEY_REGEX_BODY = "sms_body_regex";
    private static final String KEY_SMS_SDK_THROTTLE = "sms_sdk_throttle_limit";
    private static final String KEY_UPLOAD_FREQUENCY = "sms_upload_frequency";
    private static final String KEY_UPS_URL = "ups_url";
    /* access modifiers changed from: private */
    public static SmsSdkProviderImpl instance;

    public final Context getContext() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final b provideSmsSdkConfig() {
        c.a();
        String a2 = c.a(KEY_UPS_URL, (String) null);
        c.a();
        String a3 = c.a(KEY_INGEST_URL, (String) null);
        c.a();
        String a4 = c.a(KEY_REGEX, (String) null);
        c.a();
        int a5 = c.a(KEY_UPLOAD_FREQUENCY, 0);
        c.a();
        String a6 = c.a(KEY_REGEX_BODY, (String) null);
        c.a();
        int a7 = c.a(KEY_SMS_SDK_THROTTLE, 0);
        c.a();
        boolean a8 = c.a(KEY_IS_SMS_SDK_ON, true);
        c.a();
        Object a9 = new f().a(c.a(KEY_CONSENT_LIST, (String) null), String[].class);
        if (a9 != null) {
            String[] strArr = (String[]) a9;
            q.d(" isSmsSdkOn : " + a8 + " upsUrl : " + a2 + " ingestUrl : " + a3 + ' ' + "regex : " + a4 + " upload frequency : " + a5 + " regexBody : " + a6 + " throttle : " + a7);
            StringBuilder sb = new StringBuilder(" consentsList ");
            sb.append(kotlin.a.f.b(strArr).toString());
            q.d(sb.toString());
            b.C1285b bVar = new b.C1285b();
            k.a((Object) a2, "upsUrl");
            k.c(a2, "upsUrl");
            b.C1285b bVar2 = bVar;
            bVar2.f65054c = a2;
            k.a((Object) a3, "ingestUrl");
            k.c(a3, "ingestUrl");
            b.C1285b bVar3 = bVar2;
            bVar3.f65055d = a3;
            k.a((Object) a4, "regex");
            k.c(a4, "regex");
            b.C1285b bVar4 = bVar3;
            bVar4.f65053b = a4;
            b.C1285b bVar5 = bVar4;
            bVar5.f65052a = Integer.valueOf(a5);
            b.C1285b bVar6 = bVar5;
            bVar6.f65058g = Integer.valueOf(a7);
            k.a((Object) a6, "regexBody");
            k.c(a6, "regexBody");
            b.C1285b bVar7 = bVar6;
            bVar7.f65056e = a6;
            b.C1285b bVar8 = bVar7;
            bVar8.f65057f = Boolean.valueOf(a8);
            List<String> b2 = kotlin.a.f.b(strArr);
            k.c(b2, "consentList");
            b.C1285b bVar9 = bVar8;
            bVar9.f65059h = b2;
            if (b.j == null) {
                b.j = new b(bVar9, (byte) 0);
            }
            b a10 = b.j;
            if (a10 == null) {
                k.a();
            }
            return a10;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    }

    public final String getSSOToken() {
        String q = com.paytm.utility.a.q(CJRJarvisApplication.getAppContext());
        k.a((Object) q, "ApplaunchUtility.getSSOT…lication.getAppContext())");
        return q;
    }

    public final String getStringFromGTM(String str) {
        k.c(str, "key");
        c.a();
        String a2 = c.a(str, (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().getString(key)");
        return a2;
    }

    public final boolean getBooleanFromGTM(String str, boolean z) {
        k.c(str, "key");
        c.a();
        return c.a(str, z);
    }

    public final int getIntFromGTM(String str, int i2) {
        k.c(str, "key");
        c.a();
        return c.a(str, i2);
    }

    public final String getUserId() {
        String n = com.paytm.utility.b.n(CJRJarvisApplication.getAppContext());
        k.a((Object) n, "CJRAppCommonUtility.getU…lication.getAppContext())");
        return n;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void initSmsSdk() {
        String str = "";
        if (instance == null) {
            instance = new SmsSdkProviderImpl();
            q.d("initSmsSdk");
        }
        b bVar = b.f65064b;
        SmsSdkProviderImpl access$getInstance$cp = instance;
        if (access$getInstance$cp == null) {
            k.a();
        }
        net.one97.paytm.smssdk.a.a aVar = access$getInstance$cp;
        k.c(aVar, "provider");
        b.f65063a = aVar;
        Context applicationContext = aVar.getContext().getApplicationContext();
        k.a((Object) applicationContext, "provider.getContext().applicationContext");
        Boolean bool = b.a().f65049f;
        if (bool == null || !bool.booleanValue()) {
            q.d("sms sdk is " + bool + ", cancelling job sms-process-worker");
            o a2 = b.a(applicationContext, "sms-process-worker");
            if (a2 != null) {
                StringBuilder sb = new StringBuilder("sms sdk is ");
                sb.append(bool);
                sb.append(", cancelled job sms-process-worker state ");
                LiveData<o.a> a3 = a2.a();
                k.a((Object) a3, "operation.state");
                sb.append(a3.getValue());
                q.d(sb.toString());
                return;
            }
            return;
        }
        q.d("registering Work Manager  with TAG  sms-process-worker  ...");
        com.google.b.a.a.a<List<androidx.work.u>> c2 = j.b(applicationContext).c("sms-process-worker");
        k.a((Object) c2, "WorkManager.getInstance(…etWorkInfosByTag(JOB_TAG)");
        try {
            Integer num = b.a().f65044a;
            if (num == null) {
                k.a();
            }
            long intValue = (long) num.intValue();
            c.a aVar2 = net.one97.paytm.smssdk.a.c.f65060a;
            long b2 = c.a.a(applicationContext).b("sms_wm_freq", intValue, false);
            q.d("Work Manager current frequency ..." + intValue + " oldFreq " + b2);
            if (((List) c2.get()).isEmpty()) {
                b.a(applicationContext, intValue);
            } else {
                if (intValue != b2) {
                    b.a(applicationContext, "sms-process-worker");
                    b.a(applicationContext, intValue);
                } else {
                    q.d("Work Manager  already registered with TAG ...sms-process-worker");
                }
                Object obj = c2.get();
                k.a(obj, "listenableFuture.get()");
                for (androidx.work.u uVar : (Iterable) obj) {
                    StringBuilder sb2 = new StringBuilder(" work info state ");
                    k.a((Object) uVar, "it");
                    sb2.append(uVar.f5511b.name());
                    sb2.append(" work info id ");
                    sb2.append(uVar.f5510a);
                    q.b(sb2.toString());
                }
            }
            c.a aVar3 = net.one97.paytm.smssdk.a.c.f65060a;
            c.a.a(applicationContext).a("sms_wm_freq", intValue, false);
        } catch (InterruptedException e2) {
            if (e2.getMessage() != null) {
                str = e2.getMessage();
            }
            q.d(str);
        } catch (ExecutionException e3) {
            if (e3.getMessage() != null) {
                str = e3.getMessage();
            }
            q.d(str);
        }
    }
}
