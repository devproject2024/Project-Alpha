package net.one97.paytm.appManager.b;

import android.content.Context;
import android.os.Looper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.appManager.beans.Data;
import net.one97.paytm.appManager.d.d;
import net.one97.paytm.appManager.storage.db.c;
import net.one97.paytm.common.utility.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49025a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49026b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f49027c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.appManager.storage.db.a f49028d = null;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.appManager.storage.a.a f49029e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.a f49030f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, Object> f49031g;

    public a(Context context, net.one97.paytm.appManager.storage.a.a aVar, com.google.firebase.remoteconfig.a aVar2, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(aVar, "cacheDataManager");
        k.c(aVar2, "mFirebaseRemoteConfig");
        k.c(map, "hardCoreAppKeys");
        this.f49027c = context;
        this.f49029e = aVar;
        this.f49030f = aVar2;
        this.f49031g = map;
        this.f49025a = true;
        this.f49026b = "DataController";
    }

    private final void a(String str) {
        if (this.f49025a && k.a((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) {
            l.a((Throwable) new Exception("MISSING_KEY: " + str + " | Debug: false"));
        }
    }

    public final String a(String str, String str2) {
        String str3;
        k.c(str, "key");
        Object obj = this.f49031g.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        String a2 = this.f49030f.a(str);
        CharSequence charSequence = a2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return a2;
        }
        a(str);
        net.one97.paytm.appManager.storage.a.a aVar = this.f49029e;
        k.c(str, "key");
        Object a3 = aVar.a(str);
        List<c> list = null;
        if (a3 != null) {
            str3 = a3.toString();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            return str3;
        }
        net.one97.paytm.appManager.storage.db.a aVar2 = this.f49028d;
        if (aVar2 != null) {
            list = aVar2.a(str);
        }
        if (list == null || !(!list.isEmpty())) {
            c[] list2 = a(this.f49027c).getList();
            if (list2 != null) {
                Collection arrayList = new ArrayList();
                for (c cVar : list2) {
                    if (k.a((Object) cVar.f49068b, (Object) str)) {
                        arrayList.add(cVar);
                    }
                }
                List list3 = (List) arrayList;
                if (!list3.isEmpty()) {
                    str3 = ((c) list3.get(0)).f49069c;
                }
            }
        } else {
            str3 = list.get(0).f49069c;
        }
        if (str3 != null) {
            net.one97.paytm.appManager.storage.a.a aVar3 = this.f49029e;
            if (str3 == null) {
                k.a();
            }
            k.c(str, "key");
            k.c(str3, "value");
            aVar3.a(str, str3);
        }
        return str3 == null ? str2 : str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r2 = r2.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long a(java.lang.String r10, java.lang.Long r11) {
        /*
            r9 = this;
            java.lang.String r0 = "key"
            kotlin.g.b.k.c(r10, r0)
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            com.google.firebase.remoteconfig.a r2 = r9.f49030f
            java.util.Map r2 = r2.c()
            boolean r2 = r2.containsKey(r10)
            if (r2 == 0) goto L_0x0021
            com.google.firebase.remoteconfig.a r11 = r9.f49030f
            long r10 = r11.c(r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            return r10
        L_0x0021:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f49031g
            java.lang.Object r2 = r2.get(r10)
            boolean r3 = r2 instanceof java.lang.Long
            if (r3 == 0) goto L_0x002e
            java.lang.Long r2 = (java.lang.Long) r2
            return r2
        L_0x002e:
            r9.a((java.lang.String) r10)
            net.one97.paytm.appManager.storage.a.a r2 = r9.f49029e
            kotlin.g.b.k.c(r10, r0)
            java.lang.Object r2 = r2.a((java.lang.String) r10)
            r3 = 0
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x004d
            double r4 = java.lang.Double.parseDouble(r2)
            long r4 = (long) r4
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            goto L_0x004e
        L_0x004d:
            r2 = r3
        L_0x004e:
            r1.element = r2
            T r2 = r1.element
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x005b
            T r10 = r1.element
            java.lang.Long r10 = (java.lang.Long) r10
            return r10
        L_0x005b:
            net.one97.paytm.appManager.storage.db.a r2 = r9.f49028d
            if (r2 == 0) goto L_0x0063
            java.util.List r3 = r2.a((java.lang.String) r10)
        L_0x0063:
            r2 = 0
            if (r3 == 0) goto L_0x0084
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0084
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.appManager.storage.db.c r2 = (net.one97.paytm.appManager.storage.db.c) r2
            java.lang.String r2 = r2.f49069c
            long r2 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.element = r2
            goto L_0x00ca
        L_0x0084:
            android.content.Context r3 = r9.f49027c
            net.one97.paytm.appManager.beans.Data r3 = a((android.content.Context) r3)
            net.one97.paytm.appManager.storage.db.c[] r3 = r3.getList()
            if (r3 == 0) goto L_0x00ca
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            int r5 = r3.length
            r6 = 0
        L_0x0099:
            if (r6 >= r5) goto L_0x00ab
            r7 = r3[r6]
            java.lang.String r8 = r7.f49068b
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00a8
            r4.add(r7)
        L_0x00a8:
            int r6 = r6 + 1
            goto L_0x0099
        L_0x00ab:
            java.util.List r4 = (java.util.List) r4
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x00ca
            java.lang.Object r2 = r4.get(r2)
            net.one97.paytm.appManager.storage.db.c r2 = (net.one97.paytm.appManager.storage.db.c) r2
            java.lang.String r2 = r2.f49069c
            long r2 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.element = r2
        L_0x00ca:
            T r2 = r1.element
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x00e9
            net.one97.paytm.appManager.storage.a.a r2 = r9.f49029e
            T r3 = r1.element
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 != 0) goto L_0x00db
            kotlin.g.b.k.a()
        L_0x00db:
            long r3 = r3.longValue()
            kotlin.g.b.k.c(r10, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r2.a(r10, r0)
        L_0x00e9:
            T r10 = r1.element
            java.lang.Long r10 = (java.lang.Long) r10
            if (r10 != 0) goto L_0x00f0
            r10 = r11
        L_0x00f0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.appManager.b.a.a(java.lang.String, java.lang.Long):java.lang.Long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r2 = r2.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer a(java.lang.String r10, java.lang.Integer r11) {
        /*
            r9 = this;
            java.lang.String r0 = "key"
            kotlin.g.b.k.c(r10, r0)
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            com.google.firebase.remoteconfig.a r2 = r9.f49030f
            java.util.Map r2 = r2.c()
            boolean r2 = r2.containsKey(r10)
            if (r2 == 0) goto L_0x0022
            com.google.firebase.remoteconfig.a r11 = r9.f49030f
            long r10 = r11.c(r10)
            int r11 = (int) r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            return r10
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f49031g
            java.lang.Object r2 = r2.get(r10)
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x002f
            java.lang.Integer r2 = (java.lang.Integer) r2
            return r2
        L_0x002f:
            r9.a((java.lang.String) r10)
            net.one97.paytm.appManager.storage.a.a r2 = r9.f49029e
            kotlin.g.b.k.c(r10, r0)
            java.lang.Object r2 = r2.a((java.lang.String) r10)
            r3 = 0
            if (r2 == 0) goto L_0x004e
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x004e
            double r4 = java.lang.Double.parseDouble(r2)
            int r2 = (int) r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x004f
        L_0x004e:
            r2 = r3
        L_0x004f:
            r1.element = r2
            T r2 = r1.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x005c
            T r10 = r1.element
            java.lang.Integer r10 = (java.lang.Integer) r10
            return r10
        L_0x005c:
            net.one97.paytm.appManager.storage.db.a r2 = r9.f49028d
            if (r2 == 0) goto L_0x0064
            java.util.List r3 = r2.a((java.lang.String) r10)
        L_0x0064:
            r2 = 0
            if (r3 == 0) goto L_0x0085
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0085
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.appManager.storage.db.c r2 = (net.one97.paytm.appManager.storage.db.c) r2
            java.lang.String r2 = r2.f49069c
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.element = r2
            goto L_0x00cb
        L_0x0085:
            android.content.Context r3 = r9.f49027c
            net.one97.paytm.appManager.beans.Data r3 = a((android.content.Context) r3)
            net.one97.paytm.appManager.storage.db.c[] r3 = r3.getList()
            if (r3 == 0) goto L_0x00cb
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            int r5 = r3.length
            r6 = 0
        L_0x009a:
            if (r6 >= r5) goto L_0x00ac
            r7 = r3[r6]
            java.lang.String r8 = r7.f49068b
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00a9
            r4.add(r7)
        L_0x00a9:
            int r6 = r6 + 1
            goto L_0x009a
        L_0x00ac:
            java.util.List r4 = (java.util.List) r4
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x00cb
            java.lang.Object r2 = r4.get(r2)
            net.one97.paytm.appManager.storage.db.c r2 = (net.one97.paytm.appManager.storage.db.c) r2
            java.lang.String r2 = r2.f49069c
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.element = r2
        L_0x00cb:
            T r2 = r1.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x00ea
            net.one97.paytm.appManager.storage.a.a r2 = r9.f49029e
            T r3 = r1.element
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 != 0) goto L_0x00dc
            kotlin.g.b.k.a()
        L_0x00dc:
            int r3 = r3.intValue()
            kotlin.g.b.k.c(r10, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r2.a(r10, r0)
        L_0x00ea:
            T r10 = r1.element
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 != 0) goto L_0x00f1
            r10 = r11
        L_0x00f1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.appManager.b.a.a(java.lang.String, java.lang.Integer):java.lang.Integer");
    }

    public final Boolean a(String str, Boolean bool) {
        k.c(str, "key");
        x.e eVar = new x.e();
        if (this.f49030f.c().containsKey(str)) {
            return Boolean.valueOf(this.f49030f.b(str));
        }
        Object obj = this.f49031g.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        a(str);
        net.one97.paytm.appManager.storage.a.a aVar = this.f49029e;
        k.c(str, "key");
        Object a2 = aVar.a(str);
        List<c> list = null;
        eVar.element = a2 != null ? Boolean.valueOf(Boolean.parseBoolean(a2.toString())) : null;
        if (((Boolean) eVar.element) != null) {
            return (Boolean) eVar.element;
        }
        net.one97.paytm.appManager.storage.db.a aVar2 = this.f49028d;
        if (aVar2 != null) {
            list = aVar2.a(str);
        }
        if (list == null || !(!list.isEmpty())) {
            c[] list2 = a(this.f49027c).getList();
            if (list2 != null) {
                Collection arrayList = new ArrayList();
                for (c cVar : list2) {
                    if (k.a((Object) cVar.f49068b, (Object) str)) {
                        arrayList.add(cVar);
                    }
                }
                List list3 = (List) arrayList;
                if (!list3.isEmpty()) {
                    eVar.element = Boolean.valueOf(Boolean.parseBoolean(((c) list3.get(0)).f49069c));
                }
            }
        } else {
            eVar.element = Boolean.valueOf(Boolean.parseBoolean(list.get(0).f49069c));
        }
        if (((Boolean) eVar.element) != null) {
            net.one97.paytm.appManager.storage.a.a aVar3 = this.f49029e;
            Boolean bool2 = (Boolean) eVar.element;
            if (bool2 == null) {
                k.a();
            }
            boolean booleanValue = bool2.booleanValue();
            k.c(str, "key");
            aVar3.a(str, Boolean.valueOf(booleanValue));
        }
        Boolean bool3 = (Boolean) eVar.element;
        return bool3 == null ? bool : bool3;
    }

    public static Data a(Context context) {
        InputStream open = context.getAssets().open(net.one97.paytm.appManager.d.a.a().getLocalRawFileName());
        k.a((Object) open, "context.assets.open(AppM…().getLocalRawFileName())");
        Data a2 = d.a(open);
        k.a((Object) a2, "Utility.parseData(dataStream)");
        return a2;
    }
}
