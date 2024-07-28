package com.paytm.erroranalytics.schedulers.b;

import android.content.Context;
import android.os.Build;
import com.google.gson.f;
import com.paytm.erroranalytics.a.d;
import com.paytm.erroranalytics.c.b;
import com.paytm.erroranalytics.e;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private d f42815a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42816b = 10;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.erroranalytics.c.a f42817c;

    /* renamed from: d  reason: collision with root package name */
    private Context f42818d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f42819e;

    public a(Context context, d dVar, com.paytm.erroranalytics.c.a aVar, Map<String, String> map) {
        this.f42815a = dVar;
        this.f42817c = aVar;
        this.f42818d = context;
        this.f42819e = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        throw new com.paytm.erroranalytics.schedulers.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062 A[LOOP:1: B:33:0x005c->B:35:0x0062, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() throws com.paytm.erroranalytics.schedulers.a.a {
        /*
            r6 = this;
            com.paytm.erroranalytics.a.d r0 = r6.f42815a
            java.util.List r0 = r0.a()
            if (r0 == 0) goto L_0x000b
            r0.size()
        L_0x000b:
            java.lang.String r1 = com.paytm.erroranalytics.e.f42808a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "SyncEventTask performTask "
            r1.<init>(r2)
            r1.append(r0)
        L_0x0017:
            r1 = 1
            if (r0 == 0) goto L_0x0092
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0092
            r2 = 0
            com.paytm.erroranalytics.c.b r3 = r6.a(r0)     // Catch:{ b -> 0x0057 }
            if (r3 == 0) goto L_0x002e
            boolean r4 = r3.f42760d     // Catch:{ b -> 0x0057 }
            if (r4 == 0) goto L_0x002e
            java.lang.String r1 = com.paytm.erroranalytics.e.f42808a     // Catch:{ b -> 0x0057 }
            goto L_0x0057
        L_0x002e:
            if (r3 == 0) goto L_0x004f
            boolean r4 = r3.f42757a     // Catch:{ b -> 0x0057 }
            if (r4 != 0) goto L_0x0038
            boolean r4 = r3.f42759c     // Catch:{ b -> 0x0057 }
            if (r4 != 0) goto L_0x004f
        L_0x0038:
            if (r3 == 0) goto L_0x003e
            boolean r4 = r3.f42757a     // Catch:{ b -> 0x0057 }
            if (r4 != 0) goto L_0x0057
        L_0x003e:
            java.lang.String r4 = com.paytm.erroranalytics.e.f42808a     // Catch:{ b -> 0x0057 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ b -> 0x0057 }
            java.lang.String r5 = "response == null "
            r4.<init>(r5)     // Catch:{ b -> 0x0057 }
            if (r3 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            r4.append(r1)     // Catch:{ b -> 0x0057 }
            return r2
        L_0x004f:
            java.lang.String r1 = com.paytm.erroranalytics.e.f42808a     // Catch:{ b -> 0x0057 }
            com.paytm.erroranalytics.schedulers.a.a r1 = new com.paytm.erroranalytics.schedulers.a.a     // Catch:{ b -> 0x0057 }
            r1.<init>()     // Catch:{ b -> 0x0057 }
            throw r1     // Catch:{ b -> 0x0057 }
        L_0x0057:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x005c:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0074
            java.lang.Object r3 = r0.get(r2)
            com.paytm.erroranalytics.c.b.a r3 = (com.paytm.erroranalytics.c.b.a) r3
            long r3 = r3.f42762a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r1.add(r3)
            int r2 = r2 + 1
            goto L_0x005c
        L_0x0074:
            com.paytm.erroranalytics.a.d r0 = r6.f42815a
            com.paytm.erroranalytics.a.c r0 = r0.f42700a
            r0.a((java.util.List<java.lang.Long>) r1)
            com.paytm.erroranalytics.a.d r0 = r6.f42815a
            java.util.List r0 = r0.a()
            java.lang.String r1 = com.paytm.erroranalytics.e.f42808a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Job sync event count: "
            r1.<init>(r2)
            int r2 = r0.size()
            r1.append(r2)
            goto L_0x0017
        L_0x0092:
            java.lang.String r0 = com.paytm.erroranalytics.e.f42808a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.erroranalytics.schedulers.b.a.a():boolean");
    }

    private b a(List<com.paytm.erroranalytics.c.b.a> list) throws com.paytm.erroranalytics.schedulers.a.a, com.paytm.erroranalytics.schedulers.a.b {
        try {
            Context context = this.f42818d;
            com.paytm.erroranalytics.c.a aVar = this.f42817c;
            com.paytm.erroranalytics.c.a.a.b bVar = null;
            if (list != null) {
                if (!list.isEmpty()) {
                    int size = list.size();
                    ArrayList arrayList = new ArrayList();
                    com.paytm.erroranalytics.c.a.a.a aVar2 = new com.paytm.erroranalytics.c.a.a.a();
                    com.paytm.erroranalytics.b.b.f42707a = aVar2;
                    aVar2.f42729c = com.paytm.erroranalytics.b.b.a(context);
                    com.paytm.erroranalytics.b.b.f42707a.f42728b = Build.MODEL;
                    com.paytm.erroranalytics.b.b.f42707a.f42731e = com.paytm.erroranalytics.b.b.a(context);
                    com.paytm.erroranalytics.b.b.f42707a.f42732f = String.valueOf(Build.VERSION.SDK_INT);
                    com.paytm.erroranalytics.b.b.f42707a.f42727a = Build.MANUFACTURER;
                    com.paytm.erroranalytics.b.b.f42707a.f42730d = "android";
                    com.paytm.erroranalytics.c.a.a.a aVar3 = com.paytm.erroranalytics.b.b.f42707a;
                    com.paytm.erroranalytics.c.a.a.b bVar2 = new com.paytm.erroranalytics.c.a.a.b();
                    bVar2.f42735c = aVar.f42709a;
                    bVar2.f42738f = aVar3.f42727a;
                    bVar2.f42739g = aVar3.f42728b;
                    bVar2.f42736d = aVar3.f42730d;
                    bVar2.f42737e = aVar3.f42732f;
                    bVar2.f42734b = aVar.f42710b;
                    bVar2.f42733a = aVar.f42717i;
                    for (int i2 = 0; i2 < size; i2++) {
                        Object a2 = new f().a(list.get(i2).f42766e, Object.class);
                        String str = e.f42808a;
                        new StringBuilder("EventRequest payload ").append(a2);
                        arrayList.add(a2);
                    }
                    if (arrayList.size() != 0) {
                        bVar2.f42740h = arrayList;
                        String str2 = e.f42808a;
                        new StringBuilder("EventRequest eventRequest ").append(bVar2);
                        bVar = bVar2;
                    }
                }
            }
            String str3 = e.f42808a;
            new StringBuilder("SyncEventTask uploadEvents 111 ").append(bVar);
            if (bVar != null) {
                d dVar = this.f42815a;
                b a3 = dVar.f42700a.a(bVar, this.f42817c.f42714f, this.f42817c.f42712d, this.f42819e);
                String str4 = e.f42808a;
                new StringBuilder("SyncEventTask uploadEvents 222 ").append(a3);
                return a3;
            }
            throw new com.paytm.erroranalytics.schedulers.a.b("Events are invalid");
        } catch (MalformedURLException e2) {
            String str5 = e.f42808a;
            throw new com.paytm.erroranalytics.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.erroranalytics.data.a.a e3) {
            String str6 = e.f42808a;
            throw new com.paytm.erroranalytics.schedulers.a.a(e3.getMessage());
        }
    }
}
