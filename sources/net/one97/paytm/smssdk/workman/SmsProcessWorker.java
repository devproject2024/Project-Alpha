package net.one97.paytm.smssdk.workman;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.smssdk.a.c;
import net.one97.paytm.smssdk.model.ConsentStatus;
import net.one97.paytm.smssdk.model.ConsentStatusPreference;
import net.one97.paytm.smssdk.model.ConsentStatusResponse;

public final class SmsProcessWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    final String f65077a = "SmsProcessWorker";

    /* renamed from: b  reason: collision with root package name */
    public volatile CountDownLatch f65078b;

    /* renamed from: c  reason: collision with root package name */
    Context f65079c;

    /* renamed from: d  reason: collision with root package name */
    private ListenableWorker.a f65080d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmsProcessWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "context");
        k.c(workerParameters, "params");
        this.f65079c = context;
    }

    public final CountDownLatch a() {
        CountDownLatch countDownLatch = this.f65078b;
        if (countDownLatch == null) {
            k.a("latch");
        }
        return countDownLatch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0313, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0314, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0333, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0334, code lost:
        r1 = new java.lang.StringBuilder("Result.retry()  ");
        r0.printStackTrace();
        r1.append(kotlin.x.f47997a);
        com.paytm.utility.q.d(r1.toString());
        r0 = androidx.work.ListenableWorker.a.b();
        kotlin.g.b.k.a((java.lang.Object) r0, "Result.retry()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0353, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0333 A[ExcHandler: IllegalStateException (r0v1 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), Splitter:B:1:0x000d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.work.ListenableWorker.a doWork() {
        /*
            r36 = this;
            r8 = r36
            java.lang.String r0 = "sms_sync_time"
            java.lang.String r9 = "Result.failure()"
            java.lang.String r10 = "context"
            java.lang.String r1 = "doWork started..."
            com.paytm.utility.q.d(r1)
            net.one97.paytm.smssdk.a.d$a r1 = net.one97.paytm.smssdk.a.d.f65062a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r1 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r2 = "android.permission.READ_SMS"
            kotlin.g.b.k.c(r1, r10)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r3 = "permission"
            kotlin.g.b.k.c(r2, r3)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r1 = androidx.core.content.b.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r11 = 0
            r12 = 1
            if (r1 != 0) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            net.one97.paytm.smssdk.b.a r2 = net.one97.paytm.smssdk.b.a.f65066a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r2 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            boolean r2 = net.one97.paytm.smssdk.b.a.b(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r2 != 0) goto L_0x00ae
            if (r1 == 0) goto L_0x00ae
            net.one97.paytm.smssdk.b r3 = net.one97.paytm.smssdk.b.f65064b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a.b r3 = net.one97.paytm.smssdk.b.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.Boolean r3 = r3.f65049f     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r3 != 0) goto L_0x003f
            kotlin.g.b.k.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x003f:
            boolean r3 = r3.booleanValue()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r3 == 0) goto L_0x00ae
            net.one97.paytm.smssdk.b r3 = net.one97.paytm.smssdk.b.f65064b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a.b r3 = net.one97.paytm.smssdk.b.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.List<java.lang.String> r3 = r3.f65051h     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r3 == 0) goto L_0x00ae
            android.content.Context r2 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            kotlin.g.b.k.c(r2, r10)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = "consentKeys"
            kotlin.g.b.k.c(r3, r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            kotlin.g.b.x$e r4 = new kotlin.g.b.x$e     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r4.<init>()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.concurrent.CountDownLatch r5 = new java.util.concurrent.CountDownLatch     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r5.<init>(r12)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r4.element = r5     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r5 = r3.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r5 != 0) goto L_0x0071
            java.lang.String r2 = "getConsent returning one of the param is null"
            com.paytm.utility.q.d(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            goto L_0x00a6
        L_0x0071:
            java.lang.String r5 = "requestig consent keys : "
            java.lang.String r6 = java.lang.String.valueOf(r3)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r5)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a r5 = net.one97.paytm.smssdk.a.f65042a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.workman.SmsProcessWorker$a r5 = new net.one97.paytm.smssdk.workman.SmsProcessWorker$a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r5.<init>(r8, r4, r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.network.listener.b r5 = (com.paytm.network.listener.b) r5     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r6 = r6.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r7 = "UUID.randomUUID().toString()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.network.a r2 = net.one97.paytm.smssdk.a.a(r2, r5, r3, r6)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r2 == 0) goto L_0x009d
            r2.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x009d:
            T r2 = r4.element     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.concurrent.CountDownLatch r2 = (java.util.concurrent.CountDownLatch) r2     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r2 == 0) goto L_0x00a6
            r2.await()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x00a6:
            net.one97.paytm.smssdk.b.a r2 = net.one97.paytm.smssdk.b.a.f65066a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r2 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            boolean r2 = net.one97.paytm.smssdk.b.a.b(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x00ae:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = "Sms read permission : "
            r3.<init>(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r3.append(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = " and consent : "
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r3.append(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = " $ and sms-sdk is on : "
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.b r4 = net.one97.paytm.smssdk.b.f65064b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a.b r4 = net.one97.paytm.smssdk.b.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.Boolean r4 = r4.f65049f     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r3)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r13 = "latch"
            if (r1 == 0) goto L_0x02dc
            if (r2 == 0) goto L_0x02dc
            net.one97.paytm.smssdk.b r1 = net.one97.paytm.smssdk.b.f65064b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a.b r1 = net.one97.paytm.smssdk.b.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.Boolean r1 = r1.f65049f     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r1 != 0) goto L_0x00ea
            kotlin.g.b.k.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x00ea:
            boolean r1 = r1.booleanValue()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r1 == 0) goto L_0x02dc
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a.c$a r1 = net.one97.paytm.smssdk.a.c.f65060a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r1 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.b.a.a r1 = net.one97.paytm.smssdk.a.c.a.a(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r2 = 0
            long r5 = r1.b((java.lang.String) r0, (long) r2, (boolean) r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.c.c r1 = net.one97.paytm.smssdk.c.c.f65075a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r1 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.List r7 = net.one97.paytm.smssdk.c.c.a(r1, r5, r14)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r2 = "Sms Read , final sms count :"
            r1.<init>(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r2 = r7.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r1.append(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = r1.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.b.a r1 = net.one97.paytm.smssdk.b.a.f65066a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r1 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.List r3 = net.one97.paytm.smssdk.b.a.a(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = "ConsentUpdatePreference list  :"
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r1 = r7.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            double r1 = (double) r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r16 = 4632233691727265792(0x4049000000000000, double:50.0)
            double r1 = r1 / r16
            double r1 = java.lang.Math.ceil(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r4 = (int) r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = "Number of batches list  :"
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r2 = 0
        L_0x0150:
            if (r2 >= r4) goto L_0x02be
            int r1 = r2 * 50
            int r11 = r4 + -1
            if (r2 != r11) goto L_0x015d
            int r11 = r7.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            goto L_0x015f
        L_0x015d:
            int r11 = r1 + 50
        L_0x015f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r33 = r4
            java.lang.String r4 = "Batch executing :"
            r12.<init>(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r12.append(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = " sms count :"
            r12.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r12.append(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = "  to "
            r12.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r12.append(r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = r12.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.List r1 = r7.subList(r1, r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r11 = "calendar"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r11 = r1.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r12 = 1
            int r11 = r11 - r12
            java.lang.Object r11 = r1.get(r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.model.Payload r11 = (net.one97.paytm.smssdk.model.Payload) r11     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            long r11 = r11.getSmsDateTime()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r4.setTimeInMillis(r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r12 = "Last sms timestamp :"
            r11.<init>(r12)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.Date r4 = r4.getTime()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r11.append(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = r11.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.paytm.utility.q.d(r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.c.a$a r4 = net.one97.paytm.smssdk.c.a.f65073a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r4 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            kotlin.g.b.k.c(r4, r10)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r11 = "payload"
            kotlin.g.b.k.c(r1, r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r11 = "preference"
            kotlin.g.b.k.c(r3, r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.model.SmsPayload r11 = new net.one97.paytm.smssdk.model.SmsPayload     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r4 = com.paytm.utility.b.Q((android.content.Context) r4)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r12 = "CJRAppCommonUtility.getAppVersionName(context)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r12)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r12 = android.os.Build.BRAND     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r34 = r2
            java.lang.String r2 = "Build.BRAND"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.b r2 = net.one97.paytm.smssdk.b.f65064b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r19 = net.one97.paytm.smssdk.b.c()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            if (r19 != 0) goto L_0x01eb
            kotlin.g.b.k.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
        L_0x01eb:
            java.lang.String r20 = "androidapp"
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r23 = "smsEvent"
            java.lang.String r24 = ""
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r35 = r7
            java.lang.String r7 = "Build.MODEL"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r26 = "android"
            int r7 = com.paytm.utility.b.d()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r27 = java.lang.String.valueOf(r7)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            long r30 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r32 = "sms"
            r16 = r11
            r17 = r4
            r18 = r12
            r25 = r2
            r28 = r1
            r29 = r3
            r16.<init>(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r32)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            com.google.gson.f r2 = new com.google.gson.f     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r11 = r2.b(r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            int r2 = r1.size()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r4 = 1
            int r2 = r2 - r4
            java.lang.Object r1 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.model.Payload r1 = (net.one97.paytm.smssdk.model.Payload) r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            long r16 = r1.getSmsDateTime()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.lang.String r1 = "body"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            kotlin.g.b.x$a r12 = new kotlin.g.b.x$a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r12.<init>()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r1 = 0
            r12.element = r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r7 = 1
            r1.<init>(r7)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r8.f65078b = r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.a r1 = net.one97.paytm.smssdk.a.f65042a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            android.content.Context r4 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            net.one97.paytm.smssdk.workman.SmsProcessWorker$b r18 = new net.one97.paytm.smssdk.workman.SmsProcessWorker$b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x0313 }
            r1 = r18
            r19 = r10
            r10 = r34
            r2 = r36
            r20 = r3
            r22 = r9
            r21 = r33
            r9 = r4
            r3 = r5
            r23 = r5
            r5 = r16
            r16 = r35
            r17 = 1
            r7 = r12
            r1.<init>(r2, r3, r5, r7)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            r1 = r18
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            com.paytm.network.a r1 = net.one97.paytm.smssdk.a.a(r9, r1, r11)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            if (r1 == 0) goto L_0x027a
            r1.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
        L_0x027a:
            r1 = r8
            net.one97.paytm.smssdk.workman.SmsProcessWorker r1 = (net.one97.paytm.smssdk.workman.SmsProcessWorker) r1     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.util.concurrent.CountDownLatch r1 = r1.f65078b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            if (r1 == 0) goto L_0x028d
            java.util.concurrent.CountDownLatch r1 = r8.f65078b     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            if (r1 != 0) goto L_0x0288
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
        L_0x0288:
            if (r1 == 0) goto L_0x028d
            r1.await()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
        L_0x028d:
            boolean r1 = r12.element     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            if (r1 != 0) goto L_0x02a3
            int r2 = r10 + 1
            r7 = r16
            r10 = r19
            r3 = r20
            r4 = r21
            r9 = r22
            r5 = r23
            r11 = 0
            r12 = 1
            goto L_0x0150
        L_0x02a3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.String r2 = "Batch number "
            r1.<init>(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            r1.append(r10)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.String r2 = "is failed"
            r1.append(r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            throw r0     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
        L_0x02be:
            r22 = r9
            net.one97.paytm.smssdk.a.c$a r1 = net.one97.paytm.smssdk.a.c.f65060a     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            android.content.Context r1 = r8.f65079c     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            com.paytm.b.a.a r1 = net.one97.paytm.smssdk.a.c.a.a(r1)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            r2 = 0
            r1.a((java.lang.String) r0, (long) r14, (boolean) r2)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            java.lang.String r0 = "All batch uploading done"
            com.paytm.utility.q.d(r0)     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            androidx.work.ListenableWorker$a r0 = androidx.work.ListenableWorker.a.a()     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            r8.f65080d = r0     // Catch:{ IllegalStateException -> 0x0333, Exception -> 0x02d8 }
            goto L_0x02de
        L_0x02d8:
            r0 = move-exception
            r1 = r22
            goto L_0x0315
        L_0x02dc:
            r22 = r9
        L_0x02de:
            r0 = r8
            net.one97.paytm.smssdk.workman.SmsProcessWorker r0 = (net.one97.paytm.smssdk.workman.SmsProcessWorker) r0
            androidx.work.ListenableWorker$a r1 = r0.f65080d
            java.lang.String r1 = java.lang.String.valueOf(r1)
            if (r1 != 0) goto L_0x02ec
            kotlin.g.b.k.a()
        L_0x02ec:
            com.paytm.utility.q.d(r1)
            java.util.concurrent.CountDownLatch r0 = r0.f65078b
            if (r0 == 0) goto L_0x02ff
            java.util.concurrent.CountDownLatch r0 = r8.f65078b
            if (r0 != 0) goto L_0x02fa
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x02fa:
            if (r0 == 0) goto L_0x02ff
            r0.countDown()
        L_0x02ff:
            androidx.work.ListenableWorker$a r0 = r8.f65080d
            if (r0 != 0) goto L_0x030d
            androidx.work.ListenableWorker$a r0 = androidx.work.ListenableWorker.a.c()
            r1 = r22
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            return r0
        L_0x030d:
            if (r0 != 0) goto L_0x0312
            kotlin.g.b.k.a()
        L_0x0312:
            return r0
        L_0x0313:
            r0 = move-exception
            r1 = r9
        L_0x0315:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Result.failure()  "
            r2.<init>(r3)
            r0.printStackTrace()
            kotlin.x r0 = kotlin.x.f47997a
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.paytm.utility.q.d(r0)
            androidx.work.ListenableWorker$a r0 = androidx.work.ListenableWorker.a.c()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            return r0
        L_0x0333:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Result.retry()  "
            r1.<init>(r2)
            r0.printStackTrace()
            kotlin.x r0 = kotlin.x.f47997a
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.paytm.utility.q.d(r0)
            androidx.work.ListenableWorker$a r0 = androidx.work.ListenableWorker.a.b()
            java.lang.String r1 = "Result.retry()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.smssdk.workman.SmsProcessWorker.doWork():androidx.work.ListenableWorker$a");
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SmsProcessWorker f65084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f65085b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f65086c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.a f65087d;

        b(SmsProcessWorker smsProcessWorker, long j, long j2, x.a aVar) {
            this.f65084a = smsProcessWorker;
            this.f65085b = j;
            this.f65086c = j2;
            this.f65087d = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            NetworkResponse networkResponse;
            NetworkResponse networkResponse2;
            Integer num = null;
            if (this.f65085b == 0) {
                StringBuilder sb = new StringBuilder("sms data uploaded successfully first sync");
                if (!(iJRPaytmDataModel == null || (networkResponse2 = iJRPaytmDataModel.getNetworkResponse()) == null)) {
                    num = Integer.valueOf(networkResponse2.statusCode);
                }
                sb.append(num);
                q.d(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder("sms data uploaded successfully ");
                if (!(iJRPaytmDataModel == null || (networkResponse = iJRPaytmDataModel.getNetworkResponse()) == null)) {
                    num = Integer.valueOf(networkResponse.statusCode);
                }
                sb2.append(num);
                q.d(sb2.toString());
            }
            c.a aVar = c.f65060a;
            c.a.a(this.f65084a.f65079c).a("sms_sync_time", this.f65086c, false);
            if (this.f65084a.f65078b != null) {
                this.f65084a.a().countDown();
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) throws IllegalStateException {
            CountDownLatch a2;
            q.d("sms data upload failed ".concat(String.valueOf(i2)));
            if (!(this.f65084a.f65078b == null || (a2 = this.f65084a.a()) == null)) {
                a2.countDown();
            }
            this.f65087d.element = true;
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SmsProcessWorker f65081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f65082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f65083c;

        a(SmsProcessWorker smsProcessWorker, x.e eVar, Context context) {
            this.f65081a = smsProcessWorker;
            this.f65082b = eVar;
            this.f65083c = context;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            q.d("get consent failed  status code =  ".concat(String.valueOf(i2)));
            ((CountDownLatch) this.f65082b.element).countDown();
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof ConsentStatus) {
                ConsentStatus consentStatus = (ConsentStatus) iJRPaytmDataModel;
                if (consentStatus.getNetworkResponse().statusCode == 200) {
                    HashMap hashMap = new HashMap();
                    ConsentStatusResponse response = consentStatus.getResponse();
                    List<ConsentStatusPreference> preferences = response != null ? response.getPreferences() : null;
                    if (preferences != null) {
                        for (ConsentStatusPreference consentStatusPreference : preferences) {
                            c.a aVar = c.f65060a;
                            c.a.a(this.f65083c).a(consentStatusPreference.getKey(), consentStatusPreference.getValue(), false);
                            net.one97.paytm.smssdk.b.a aVar2 = net.one97.paytm.smssdk.b.a.f65066a;
                            net.one97.paytm.smssdk.b.a.a(this.f65083c, consentStatusPreference.getKey());
                            hashMap.put(consentStatusPreference.getKey(), Boolean.valueOf(consentStatusPreference.getValue()));
                        }
                    }
                    StringBuilder sb = new StringBuilder("consent fetch id successfully  response = ");
                    byte[] bArr = consentStatus.getNetworkResponse().data;
                    k.a((Object) bArr, "response.networkResponse.data");
                    Charset forName = Charset.forName(AppConstants.UTF_8);
                    k.a((Object) forName, "Charset.forName(\"UTF-8\")");
                    sb.append(new String(bArr, forName));
                    q.d(sb.toString());
                    ((CountDownLatch) this.f65082b.element).countDown();
                }
            }
        }
    }
}
