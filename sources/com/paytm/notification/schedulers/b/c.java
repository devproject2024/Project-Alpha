package com.paytm.notification.schedulers.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.f;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;

public final class c extends com.paytm.notification.data.b.a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f43258h = new a((byte) 0);

    /* renamed from: i  reason: collision with root package name */
    private final String f43259i = "UNREAD";

    public static final class b {
        @com.google.gson.a.c(a = "count")

        /* renamed from: a  reason: collision with root package name */
        int f43260a;
    }

    public c(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0091, code lost:
        r4 = r1.getResponseCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() throws com.paytm.notification.schedulers.a.a {
        /*
            r10 = this;
            r0 = 0
            com.paytm.notification.j r1 = com.paytm.notification.j.f43241a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.data.c.h r1 = r1.c()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.models.NotificationUserConfig r2 = r1.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r2 = r2.getInboxEndPoints$paytmnotification_paytmRelease()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = "/v2/api/inbox/count/"
            java.lang.String r9 = r1.j()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.models.NotificationUserConfig r4 = r1.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r8 = r4.getClientName$paytmnotification_paytmRelease()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.models.NotificationUserConfig r4 = r1.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r4 = r4.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r1 = r1.f()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5.<init>()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5.append(r4)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r3 = 47
            r5.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5.append(r1)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = "?tag="
            r5.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = r10.f43259i     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = r5.toString()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r8 == 0) goto L_0x0163
            if (r9 == 0) goto L_0x0163
            if (r1 == 0) goto L_0x0163
            if (r2 != 0) goto L_0x0055
            kotlin.g.b.k.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x0055:
            com.paytm.signal.c r1 = com.paytm.signal.c.f43614a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.pai.network.d r4 = r1.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r1.<init>()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r2 = r10.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r1.append(r2)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r1.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r5 = r1.toString()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r7 = r10.f43054b     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r7 != 0) goto L_0x0075
            kotlin.g.b.k.a()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x0075:
            r6 = r3
            com.paytm.pai.network.model.EventResponse r1 = r4.a(r5, r6, r7, r8, r9)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.schedulers.b.c$c r2 = com.paytm.notification.schedulers.b.c.C0729c.INSTANCE     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            kotlin.g.a.b r2 = (kotlin.g.a.b) r2     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.pai.network.model.EventResponse r2 = a((com.paytm.pai.network.model.EventResponse<java.lang.String>) r1, r2)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Boolean r4 = r2.isSuccess()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r5 = 1
            if (r4 == 0) goto L_0x0102
            if (r1 == 0) goto L_0x009c
            java.lang.Integer r4 = r1.getResponseCode()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r4 == 0) goto L_0x009c
            int r4 = r4.intValue()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            goto L_0x009d
        L_0x009c:
            r4 = 0
        L_0x009d:
            r6 = 404(0x194, float:5.66E-43)
            if (r4 == r6) goto L_0x0102
            if (r1 == 0) goto L_0x00ae
            java.lang.Integer r4 = r1.getResponseCode()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r4 == 0) goto L_0x00ae
            int r4 = r4.intValue()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            goto L_0x00af
        L_0x00ae:
            r4 = 0
        L_0x00af:
            if (r4 == r5) goto L_0x0102
            com.paytm.notification.b.e$b r4 = com.paytm.notification.b.e.f43014a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r7 = "[ServerCallError] getInboxCount() failed. ResponseCode: "
            r6.<init>(r7)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r7 = 0
            if (r1 == 0) goto L_0x00c2
            java.lang.Integer r8 = r1.getResponseCode()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            goto L_0x00c3
        L_0x00c2:
            r8 = r7
        L_0x00c3:
            r6.append(r8)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r8 = 32
            r6.append(r8)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r9 = "URL: "
            r6.append(r9)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r6.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r6.append(r8)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = "Response: "
            r6.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 == 0) goto L_0x00e4
            java.lang.Object r3 = r1.getResponse()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            goto L_0x00e5
        L_0x00e4:
            r3 = r7
        L_0x00e5:
            r6.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r6.append(r8)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = "ErrorMessage: "
            r6.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 == 0) goto L_0x00f6
            java.lang.String r7 = r1.getErrorMessage()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x00f6:
            r6.append(r7)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r1 = r6.toString()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r4.d(r1, r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x0102:
            java.lang.Boolean r1 = r2.isSuccess()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 == 0) goto L_0x0123
            java.lang.Boolean r1 = r2.isDoNotRetry()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 != 0) goto L_0x011b
            goto L_0x0123
        L_0x011b:
            com.paytm.notification.schedulers.a.a r1 = new com.paytm.notification.schedulers.a.a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r1.<init>()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            throw r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x0123:
            java.lang.Boolean r1 = r2.isSuccess()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 == 0) goto L_0x0130
            return r0
        L_0x0130:
            java.lang.Object r1 = r2.getResponse()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.schedulers.b.c$b r1 = (com.paytm.notification.schedulers.b.c.b) r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            if (r1 == 0) goto L_0x015b
            if (r1 == 0) goto L_0x015a
            java.lang.Class<com.paytm.notification.schedulers.b.c> r2 = com.paytm.notification.schedulers.b.c.class
            r2.getCanonicalName()     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r3 = "Msg inbox count = "
            r2.<init>(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            int r3 = r1.f43260a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            r2.append(r3)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.data.c.g$a r2 = com.paytm.notification.data.c.g.f43067b     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            android.content.Context r2 = r10.f43053a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            int r2 = com.paytm.notification.data.c.g.a.a(r2)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            android.content.Context r3 = r10.f43053a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            int r1 = r1.f43260a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            com.paytm.notification.schedulers.b.c.a.a(r3, r2, r1)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x015a:
            return r5
        L_0x015b:
            kotlin.u r1 = new kotlin.u     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r2 = "null cannot be cast to non-null type com.paytm.notification.schedulers.tasks.FetchInboxMessageCountTask.Count"
            r1.<init>(r2)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            throw r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x0163:
            com.paytm.notification.schedulers.a.a r1 = new com.paytm.notification.schedulers.a.a     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.String r2 = "secret / clientId / deviceId are not found"
            r1.<init>(r2)     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
            throw r1     // Catch:{ a -> 0x0172, Exception -> 0x016d }
        L_0x016d:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0176
        L_0x0172:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0176:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.b.c.e():boolean");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, int i2, int i3) {
            k.c(context, "context");
            Bundle bundle = new Bundle();
            bundle.putInt("PREV_MSG_COUNT", i2);
            bundle.putInt("MSG_COUNT", i3);
            Intent putExtras = new Intent("com.paytm.notification.COUNT_RECEIVED").putExtras(bundle);
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            Intent addCategory = putExtras.addCategory(applicationContext.getPackageName());
            Context applicationContext2 = context.getApplicationContext();
            k.a((Object) applicationContext2, "context.applicationContext");
            Intent intent = addCategory.setPackage(applicationContext2.getPackageName());
            k.a((Object) intent, "Intent(PushConstants.ACT…ationContext.packageName)");
            context.sendOrderedBroadcast(intent, (String) null);
        }
    }

    /* renamed from: com.paytm.notification.schedulers.b.c$c  reason: collision with other inner class name */
    static final class C0729c extends l implements kotlin.g.a.b<String, b> {
        public static final C0729c INSTANCE = new C0729c();

        C0729c() {
            super(1);
        }

        /* renamed from: com.paytm.notification.schedulers.b.c$c$a */
        public static final class a extends com.google.gson.b.a<b> {
            a() {
            }
        }

        public final b invoke(String str) {
            if (str == null) {
                return null;
            }
            try {
                Object a2 = new f().a(str, new a().getType());
                if (a2 != null) {
                    return (b) a2;
                }
                throw new u("null cannot be cast to non-null type com.paytm.notification.schedulers.tasks.FetchInboxMessageCountTask.Count");
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
