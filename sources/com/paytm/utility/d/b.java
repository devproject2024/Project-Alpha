package com.paytm.utility.d;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import java.io.Serializable;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43794a = new b();

    private b() {
    }

    public static final void a(Context context, a.c cVar, String str, Serializable serializable, kotlin.g.a.b<? super Boolean, x> bVar) {
        k.c(context, "context");
        k.c(cVar, "vertical");
        k.c(str, "name");
        k.c(serializable, "obj");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        a.a(new C0754b(cVar, str, context, serializable, false, bVar));
    }

    /* renamed from: com.paytm.utility.d.b$b  reason: collision with other inner class name */
    static final class C0754b extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $dispatchOnMainThread;
        final /* synthetic */ String $name;
        final /* synthetic */ Serializable $obj;
        final /* synthetic */ a.c $vertical;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0754b(a.c cVar, String str, Context context, Serializable serializable, boolean z, kotlin.g.a.b bVar) {
            super(0);
            this.$vertical = cVar;
            this.$name = str;
            this.$context = context;
            this.$obj = serializable;
            this.$dispatchOnMainThread = z;
            this.$callback = bVar;
        }

        public final void invoke() {
            b bVar = b.f43794a;
            boolean a2 = b.b(this.$vertical, this.$name, this.$context, this.$obj);
            boolean z = this.$dispatchOnMainThread;
            Boolean valueOf = Boolean.valueOf(a2);
            kotlin.g.a.b bVar2 = this.$callback;
            if (bVar2 != null) {
                a.a(z, valueOf, (kotlin.g.a.b) ab.a((Object) bVar2, 1));
                return;
            }
            throw new u("null cannot be cast to non-null type (kotlin.Any) -> kotlin.Unit");
        }
    }

    public static final void a(Context context, a.c cVar, String str, Class<?> cls, kotlin.g.a.b<? super Serializable, x> bVar) {
        k.c(context, "context");
        k.c(cVar, "vertical");
        k.c(str, "name");
        k.c(cls, "classType");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        a.a(new a(cVar, str, context, cls, false, bVar));
    }

    static final class a extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.b $callback;
        final /* synthetic */ Class $classType;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $dispatchOnMainThread;
        final /* synthetic */ String $name;
        final /* synthetic */ a.c $vertical;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(a.c cVar, String str, Context context, Class cls, boolean z, kotlin.g.a.b bVar) {
            super(0);
            this.$vertical = cVar;
            this.$name = str;
            this.$context = context;
            this.$classType = cls;
            this.$dispatchOnMainThread = z;
            this.$callback = bVar;
        }

        public final void invoke() {
            b bVar = b.f43794a;
            Object a2 = b.b(this.$vertical, this.$name, this.$context, (Class<?>) this.$classType);
            boolean z = this.$dispatchOnMainThread;
            kotlin.g.a.b bVar2 = this.$callback;
            if (bVar2 != null) {
                a.a(z, a2, (kotlin.g.a.b) ab.a((Object) bVar2, 1));
                return;
            }
            throw new u("null cannot be cast to non-null type (kotlin.Any) -> kotlin.Unit");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r1 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        if (r1 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(com.paytm.network.a.c r5, java.lang.String r6, android.content.Context r7, java.io.Serializable r8) {
        /*
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            r2.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            if (r5 == 0) goto L_0x005e
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x0066 }
            r2.append(r5)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = "_"
            r2.append(r5)     // Catch:{ Exception -> 0x0066 }
            r2.append(r6)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0066 }
            java.io.FileOutputStream r1 = r7.openFileOutput(r5, r0)     // Catch:{ Exception -> 0x0066 }
            com.google.gson.f r5 = new com.google.gson.f     // Catch:{ Exception -> 0x0066 }
            r5.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = r5.b(r8)     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0052
            java.lang.String r6 = "data"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0066 }
            java.nio.charset.Charset r6 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x0066 }
            if (r5 == 0) goto L_0x004c
            byte[] r5 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r6 = "(this as java.lang.String).getBytes(charset)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0066 }
            r1.write(r5)     // Catch:{ Exception -> 0x0066 }
            goto L_0x0052
        L_0x004c:
            kotlin.u r5 = new kotlin.u     // Catch:{ Exception -> 0x0066 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0066 }
            throw r5     // Catch:{ Exception -> 0x0066 }
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.flush()     // Catch:{ Exception -> 0x0066 }
        L_0x0057:
            r0 = 1
            if (r1 == 0) goto L_0x0071
        L_0x005a:
            r1.close()
            goto L_0x0071
        L_0x005e:
            kotlin.u r5 = new kotlin.u     // Catch:{ Exception -> 0x0066 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0066 }
            throw r5     // Catch:{ Exception -> 0x0066 }
        L_0x0064:
            r5 = move-exception
            goto L_0x0072
        L_0x0066:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0064 }
            com.paytm.utility.q.b(r5)     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0071
            goto L_0x005a
        L_0x0071:
            return r0
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.d.b.b(com.paytm.network.a$c, java.lang.String, android.content.Context, java.io.Serializable):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object b(com.paytm.network.a.c r4, java.lang.String r5, android.content.Context r6, java.lang.Class<?> r7) {
        /*
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0078 }
            r2.<init>()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0078 }
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0078 }
            r2.append(r4)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r4 = "_"
            r2.append(r4)     // Catch:{ Exception -> 0x0078 }
            r2.append(r5)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0078 }
            java.io.FileInputStream r4 = r6.openFileInput(r4)     // Catch:{ Exception -> 0x0078 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ Exception -> 0x0078 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            r5.<init>()     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
        L_0x0038:
            int r1 = r4.read(r6)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            r2 = -1
            if (r1 == r2) goto L_0x0044
            r2 = 0
            r5.write(r6, r2, r1)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            goto L_0x0038
        L_0x0044:
            byte[] r5 = r5.toByteArray()     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            java.lang.String r6 = "baos.toByteArray()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            java.nio.charset.Charset r1 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            r6.<init>(r5, r1)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            com.google.gson.f r5 = new com.google.gson.f     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            r5.<init>()     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            java.lang.Object r5 = r5.a((java.lang.String) r6, r7)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            java.lang.String r6 = "Gson().fromJson(jsonData, classType)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x006b, all -> 0x0068 }
            if (r4 == 0) goto L_0x0086
            r4.close()
            goto L_0x0086
        L_0x0068:
            r5 = move-exception
            r1 = r4
            goto L_0x0087
        L_0x006b:
            r5 = move-exception
            r1 = r4
            goto L_0x0079
        L_0x006e:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0078 }
            throw r4     // Catch:{ Exception -> 0x0078 }
        L_0x0076:
            r5 = move-exception
            goto L_0x0087
        L_0x0078:
            r5 = move-exception
        L_0x0079:
            java.lang.String r4 = r5.getMessage()     // Catch:{ all -> 0x0076 }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            r5 = r0
        L_0x0086:
            return r5
        L_0x0087:
            if (r1 == 0) goto L_0x008c
            r1.close()
        L_0x008c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.d.b.b(com.paytm.network.a$c, java.lang.String, android.content.Context, java.lang.Class):java.lang.Object");
    }
}
