package com.paytm.notification.data.c;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.notification.data.datasource.dao.d;
import com.paytm.notification.data.datasource.dao.f;
import com.paytm.notification.models.InboxMessageResponse;
import com.paytm.notification.models.PaytmInbox;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.notification.schedulers.b.c;
import com.paytm.pai.network.model.EventResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;

public final class g implements f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f43067b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String j = j;
    /* access modifiers changed from: private */
    public static final String k = k;

    /* renamed from: a  reason: collision with root package name */
    final d f43068a;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<PaytmInbox> f43069c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<PaytmInbox> f43070d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private y<Integer> f43071e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f43072f;

    /* renamed from: g  reason: collision with root package name */
    private final ExecutorService f43073g = Executors.newCachedThreadPool();

    /* renamed from: h  reason: collision with root package name */
    private final Context f43074h;

    /* renamed from: i  reason: collision with root package name */
    private final com.paytm.notification.data.b.d f43075i;

    public g(Context context, d dVar, com.paytm.notification.data.b.d dVar2) {
        k.c(context, "context");
        k.c(dVar, "inboxDao");
        k.c(dVar2, "inboxApi");
        this.f43074h = context;
        this.f43068a = dVar;
        this.f43075i = dVar2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static SharedPreferences b(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(g.j, 0);
            k.a((Object) sharedPreferences, "context.getSharedPrefere…EF, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }

        public static int a(Context context) {
            k.c(context, "context");
            return b(context).getInt(g.k, -1);
        }

        public static void a(Context context, int i2) {
            k.c(context, "context");
            SharedPreferences.Editor edit = b(context).edit();
            edit.putInt(g.k, i2);
            edit.apply();
        }
    }

    public final LiveData<List<f>> a() {
        return this.f43068a.a();
    }

    public final int d() {
        return this.f43070d.size();
    }

    public final y<Integer> e() {
        return this.f43071e;
    }

    public final void a(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "customerId");
        this.f43068a.a(str, str2);
        i();
    }

    public final EventResponse<ArrayList<InboxMessageResponse>> a(String str, String str2, String str3, String str4, FetchInboxRequest fetchInboxRequest) {
        k.c(str, "endpoints");
        k.c(str2, "userId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        k.c(fetchInboxRequest, "request");
        return this.f43075i.a(str, str2, str3, str4, fetchInboxRequest);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r12.get(r7).getTag(), (java.lang.Object) "UNREAD") != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
        if (r6.intValue() == 3) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        r5.f43141i = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c3, code lost:
        if (r6.intValue() != 2) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ce, code lost:
        if (r6.intValue() == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d0, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.ArrayList<com.paytm.notification.models.InboxMessageResponse> a(java.util.ArrayList<com.paytm.notification.models.InboxMessageResponse> r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "customerId"
            kotlin.g.b.k.c(r13, r0)     // Catch:{ all -> 0x013d }
            r0 = 0
            if (r12 != 0) goto L_0x0019
            com.paytm.notification.b.e$b r12 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x012e }
            java.lang.String r13 = "Found empty inbox msg list from server"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x012e }
            r12.b(r13, r0)     // Catch:{ Exception -> 0x012e }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x012e }
            r12.<init>()     // Catch:{ Exception -> 0x012e }
            monitor-exit(r11)
            return r12
        L_0x0019:
            com.paytm.notification.data.datasource.dao.d r1 = r11.f43068a     // Catch:{ Exception -> 0x012e }
            java.util.List r1 = r1.a((java.lang.String) r13)     // Catch:{ Exception -> 0x012e }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x012e }
            r3.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x012e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x012e }
            r4 = 0
        L_0x0030:
            boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x012e }
            if (r5 == 0) goto L_0x00ed
            java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.data.datasource.dao.f r5 = (com.paytm.notification.data.datasource.dao.f) r5     // Catch:{ Exception -> 0x012e }
            r6 = r12
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ Exception -> 0x012e }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x012e }
            r7 = 0
        L_0x0044:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x012e }
            r9 = -1
            if (r8 == 0) goto L_0x0067
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.models.InboxMessageResponse r8 = (com.paytm.notification.models.InboxMessageResponse) r8     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = r8.getPushId()     // Catch:{ Exception -> 0x012e }
            if (r10 == 0) goto L_0x0064
            java.lang.String r8 = r8.getPushId()     // Catch:{ Exception -> 0x012e }
            java.lang.String r10 = r5.f43137e     // Catch:{ Exception -> 0x012e }
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r10, (boolean) r0)     // Catch:{ Exception -> 0x012e }
            if (r8 == 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            int r7 = r7 + 1
            goto L_0x0044
        L_0x0067:
            r7 = -1
        L_0x0068:
            if (r7 == r9) goto L_0x00e4
            java.lang.Integer r6 = r5.f43133a     // Catch:{ Exception -> 0x012e }
            r8 = 1
            if (r6 != 0) goto L_0x0070
            goto L_0x0088
        L_0x0070:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x012e }
            if (r6 != r8) goto L_0x0088
            java.lang.Object r6 = r12.get(r7)     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.models.InboxMessageResponse r6 = (com.paytm.notification.models.InboxMessageResponse) r6     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = r6.getTag()     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = "UNREAD"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r9)     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x0094
        L_0x0088:
            java.lang.Integer r6 = r5.f43133a     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x008d
            goto L_0x0096
        L_0x008d:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x012e }
            r9 = 3
            if (r6 != r9) goto L_0x0096
        L_0x0094:
            r5.f43141i = r8     // Catch:{ Exception -> 0x012e }
        L_0x0096:
            java.lang.Object r6 = r12.get(r7)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = "serverData[foundIndex]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.models.InboxMessageResponse r6 = (com.paytm.notification.models.InboxMessageResponse) r6     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = "$this$hasStatusChangedFromUnreadToRead"
            kotlin.g.b.k.c(r5, r9)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = "inboxMessageResponse"
            kotlin.g.b.k.c(r6, r9)     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = r6.getTag()     // Catch:{ Exception -> 0x012e }
            if (r6 == 0) goto L_0x00d2
            java.lang.String r9 = "READ"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r9)     // Catch:{ Exception -> 0x012e }
            if (r6 == 0) goto L_0x00d2
            java.lang.Integer r6 = r5.f43133a     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x012e }
            r9 = 2
            if (r6 == r9) goto L_0x00d0
        L_0x00c5:
            java.lang.Integer r6 = r5.f43133a     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x00ca
            goto L_0x00d2
        L_0x00ca:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x00d2
        L_0x00d0:
            r6 = 1
            goto L_0x00d3
        L_0x00d2:
            r6 = 0
        L_0x00d3:
            if (r6 == 0) goto L_0x00dc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x012e }
            r5.f43133a = r4     // Catch:{ Exception -> 0x012e }
            r4 = 1
        L_0x00dc:
            r12.remove(r7)     // Catch:{ Exception -> 0x012e }
            r2.add(r5)     // Catch:{ Exception -> 0x012e }
            goto L_0x0030
        L_0x00e4:
            if (r7 != r9) goto L_0x0030
            java.lang.String r5 = r5.f43137e     // Catch:{ Exception -> 0x012e }
            r3.add(r5)     // Catch:{ Exception -> 0x012e }
            goto L_0x0030
        L_0x00ed:
            r0 = r12
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x012e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x012e }
        L_0x00f4:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x012e }
            if (r1 == 0) goto L_0x010d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.models.InboxMessageResponse r1 = (com.paytm.notification.models.InboxMessageResponse) r1     // Catch:{ Exception -> 0x012e }
            com.paytm.notification.data.datasource.dao.f r5 = com.paytm.notification.c.c.a((com.paytm.notification.models.InboxMessageResponse) r1, (java.lang.String) r13)     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = r5.p     // Catch:{ Exception -> 0x012e }
            r1.setCampaignId(r6)     // Catch:{ Exception -> 0x012e }
            r2.add(r5)     // Catch:{ Exception -> 0x012e }
            goto L_0x00f4
        L_0x010d:
            boolean r0 = r12.isEmpty()     // Catch:{ Exception -> 0x012e }
            if (r0 == 0) goto L_0x0115
            if (r4 == 0) goto L_0x011c
        L_0x0115:
            com.paytm.notification.data.datasource.dao.d r0 = r11.f43068a     // Catch:{ Exception -> 0x012e }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x012e }
            r0.a((java.util.List<com.paytm.notification.data.datasource.dao.f>) r2)     // Catch:{ Exception -> 0x012e }
        L_0x011c:
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x012e }
            if (r0 != 0) goto L_0x0129
            com.paytm.notification.data.datasource.dao.d r0 = r11.f43068a     // Catch:{ Exception -> 0x012e }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x012e }
            r0.b(r3, r13)     // Catch:{ Exception -> 0x012e }
        L_0x0129:
            r11.i()     // Catch:{ Exception -> 0x012e }
            monitor-exit(r11)
            return r12
        L_0x012e:
            r12 = move-exception
            com.paytm.notification.b.e$b r13 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x013d }
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x013d }
            r13.b(r12)     // Catch:{ all -> 0x013d }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x013d }
            r12.<init>()     // Catch:{ all -> 0x013d }
            monitor-exit(r11)
            return r12
        L_0x013d:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.c.g.a(java.util.ArrayList, java.lang.String):java.util.ArrayList");
    }

    public final ArrayList<f> a(String str) {
        k.c(str, "customerId");
        return (ArrayList) this.f43068a.a(str, 1);
    }

    public final ArrayList<String> b() {
        return (ArrayList) this.f43068a.b();
    }

    public final ArrayList<f> b(String str) {
        k.c(str, "customerId");
        return (ArrayList) this.f43068a.a(str, 3);
    }

    public final EventResponse<Boolean> b(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4) {
        k.c(fetchInboxRequest, "pushIds");
        k.c(str, "endPoints");
        k.c(str2, "customerId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        return this.f43075i.a(fetchInboxRequest, str, str2, str3, str4);
    }

    public final EventResponse<Boolean> a(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4) {
        k.c(fetchInboxRequest, "pushIds");
        k.c(str, "endPoints");
        k.c(str2, "customerId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        return this.f43075i.b(fetchInboxRequest, str, str2, str3, str4);
    }

    public final void b(ArrayList<String> arrayList, String str) {
        k.c(arrayList, "pushIds");
        k.c(str, "customerId");
        this.f43068a.a((List<String>) arrayList, str);
    }

    public final synchronized void c() {
        i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f A[Catch:{ Exception -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e8 A[Catch:{ Exception -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8 A[Catch:{ Exception -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void i() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.paytm.notification.data.datasource.a r0 = com.paytm.notification.data.datasource.a.f43088i     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.models.NotificationUserConfig r0 = r0.b()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r0.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x0137 }
            if (r0 == 0) goto L_0x013f
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r1 = r7.f43069c     // Catch:{ Exception -> 0x0137 }
            r1.clear()     // Catch:{ Exception -> 0x0137 }
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r1 = r7.f43070d     // Catch:{ Exception -> 0x0137 }
            r1.clear()     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.data.datasource.dao.d r1 = r7.f43068a     // Catch:{ Exception -> 0x0137 }
            java.util.List r0 = r1.b(r0)     // Catch:{ Exception -> 0x0137 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x0137 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x0137 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0137 }
        L_0x0025:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0137 }
            r2 = 1
            if (r1 == 0) goto L_0x0104
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.data.datasource.dao.f r1 = (com.paytm.notification.data.datasource.dao.f) r1     // Catch:{ Exception -> 0x0137 }
            java.lang.String r3 = "$this$mapToPaytmInboxNotification"
            kotlin.g.b.k.c(r1, r3)     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.models.PaytmInbox r3 = new com.paytm.notification.models.PaytmInbox     // Catch:{ Exception -> 0x0137 }
            r3.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.f43136d     // Catch:{ Exception -> 0x0137 }
            r3.setCustomerId(r4)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.f43137e     // Catch:{ Exception -> 0x0137 }
            r3.setPushId(r4)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.l     // Catch:{ Exception -> 0x0137 }
            r3.setBody(r4)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.k     // Catch:{ Exception -> 0x0137 }
            r3.setTitle(r4)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.m     // Catch:{ Exception -> 0x0137 }
            r3.setImageUrl(r4)     // Catch:{ Exception -> 0x0137 }
            java.lang.Integer r4 = r1.f43133a     // Catch:{ Exception -> 0x0137 }
            if (r4 != 0) goto L_0x005a
            goto L_0x0069
        L_0x005a:
            int r5 = r4.intValue()     // Catch:{ Exception -> 0x0137 }
            if (r5 != r2) goto L_0x0069
            java.lang.String r4 = "READ"
            r3.setStatus(r4)     // Catch:{ Exception -> 0x0137 }
            r3.setRead(r2)     // Catch:{ Exception -> 0x0137 }
            goto L_0x008b
        L_0x0069:
            if (r4 != 0) goto L_0x006c
            goto L_0x007c
        L_0x006c:
            int r5 = r4.intValue()     // Catch:{ Exception -> 0x0137 }
            r6 = 2
            if (r5 != r6) goto L_0x007c
            java.lang.String r4 = "UNREAD"
            r3.setStatus(r4)     // Catch:{ Exception -> 0x0137 }
            r3.setUnRead(r2)     // Catch:{ Exception -> 0x0137 }
            goto L_0x008b
        L_0x007c:
            if (r4 != 0) goto L_0x007f
            goto L_0x008b
        L_0x007f:
            int r2 = r4.intValue()     // Catch:{ Exception -> 0x0137 }
            r4 = 3
            if (r2 != r4) goto L_0x008b
            java.lang.String r2 = "DELETED"
            r3.setStatus(r2)     // Catch:{ Exception -> 0x0137 }
        L_0x008b:
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.c.a r4 = com.paytm.notification.c.a.f43021a     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = r1.f43134b     // Catch:{ Exception -> 0x0137 }
            long r4 = com.paytm.notification.c.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0137 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0137 }
            r3.setDate(r2)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r2 = r1.f43139g     // Catch:{ Exception -> 0x0137 }
            if (r2 == 0) goto L_0x00e4
            com.paytm.notification.c.c$a r4 = new com.paytm.notification.c.c$a     // Catch:{ Exception -> 0x0137 }
            r4.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0137 }
            com.google.gson.f r5 = new com.google.gson.f     // Catch:{ Exception -> 0x0137 }
            r5.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.Object r2 = r5.a((java.lang.String) r2, (java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x0137 }
            boolean r4 = r2 instanceof java.util.HashMap     // Catch:{ Exception -> 0x0137 }
            if (r4 != 0) goto L_0x00b6
            r2 = 0
        L_0x00b6:
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ Exception -> 0x0137 }
            if (r2 == 0) goto L_0x00e4
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x0137 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x0137 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0137 }
        L_0x00c4:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0137 }
            if (r4 == 0) goto L_0x00e4
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0137 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x0137 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0137 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0137 }
            android.os.Bundle r6 = r3.getExtras()     // Catch:{ Exception -> 0x0137 }
            r6.putString(r5, r4)     // Catch:{ Exception -> 0x0137 }
            goto L_0x00c4
        L_0x00e4:
            java.lang.String r2 = r1.p     // Catch:{ Exception -> 0x0137 }
            if (r2 != 0) goto L_0x00ea
            java.lang.String r2 = ""
        L_0x00ea:
            r3.setCampaignId(r2)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r1 = r1.m     // Catch:{ Exception -> 0x0137 }
            r3.setImageUrl(r1)     // Catch:{ Exception -> 0x0137 }
            boolean r1 = r3.isUnRead()     // Catch:{ Exception -> 0x0137 }
            if (r1 == 0) goto L_0x00fd
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r1 = r7.f43070d     // Catch:{ Exception -> 0x0137 }
            r1.add(r3)     // Catch:{ Exception -> 0x0137 }
        L_0x00fd:
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r1 = r7.f43069c     // Catch:{ Exception -> 0x0137 }
            r1.add(r3)     // Catch:{ Exception -> 0x0137 }
            goto L_0x0025
        L_0x0104:
            android.content.Context r0 = r7.f43074h     // Catch:{ Exception -> 0x0137 }
            int r0 = com.paytm.notification.data.c.g.a.a(r0)     // Catch:{ Exception -> 0x0137 }
            android.content.Context r1 = r7.f43074h     // Catch:{ Exception -> 0x0137 }
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r3 = r7.f43070d     // Catch:{ Exception -> 0x0137 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.data.c.g.a.a(r1, r3)     // Catch:{ Exception -> 0x0137 }
            androidx.lifecycle.y<java.lang.Integer> r1 = r7.f43071e     // Catch:{ Exception -> 0x0137 }
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r3 = r7.f43070d     // Catch:{ Exception -> 0x0137 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0137 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0137 }
            r1.postValue(r3)     // Catch:{ Exception -> 0x0137 }
            r7.f43072f = r2     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.schedulers.b.c$a r1 = com.paytm.notification.schedulers.b.c.f43258h     // Catch:{ Exception -> 0x0137 }
            android.content.Context r1 = r7.f43074h     // Catch:{ Exception -> 0x0137 }
            java.util.ArrayList<com.paytm.notification.models.PaytmInbox> r2 = r7.f43070d     // Catch:{ Exception -> 0x0137 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0137 }
            com.paytm.notification.schedulers.b.c.a.a(r1, r0, r2)     // Catch:{ Exception -> 0x0137 }
            monitor-exit(r7)
            return
        L_0x0135:
            r0 = move-exception
            goto L_0x0141
        L_0x0137:
            r0 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0135 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0135 }
            r1.b(r0)     // Catch:{ all -> 0x0135 }
        L_0x013f:
            monitor-exit(r7)
            return
        L_0x0141:
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.data.c.g.i():void");
    }

    public final synchronized void c(String str) {
        k.c(str, "customerId");
        this.f43068a.c(str);
    }

    public final void f() {
        this.f43069c.clear();
        this.f43070d.clear();
        a.a(this.f43074h, 0);
        this.f43072f = false;
        this.f43073g.execute(new b(this));
        c.a aVar = c.f43258h;
        Context context = this.f43074h;
        c.a.a(context, a.a(context), this.f43070d.size());
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f43076a;

        b(g gVar) {
            this.f43076a = gVar;
        }

        public final void run() {
            try {
                this.f43076a.f43068a.c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
