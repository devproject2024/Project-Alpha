package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import java.util.Arrays;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f8847a = 129;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f8848b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static i f8849c;

    /* access modifiers changed from: protected */
    public abstract boolean a(a aVar, ServiceConnection serviceConnection);

    /* access modifiers changed from: protected */
    public abstract void b(a aVar, ServiceConnection serviceConnection);

    public static int a() {
        return f8847a;
    }

    public static i a(Context context) {
        synchronized (f8848b) {
            if (f8849c == null) {
                f8849c = new ao(context.getApplicationContext());
            }
        }
        return f8849c;
    }

    protected static final class a {

        /* renamed from: f  reason: collision with root package name */
        private static final Uri f8850f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a  reason: collision with root package name */
        final String f8851a;

        /* renamed from: b  reason: collision with root package name */
        final ComponentName f8852b = null;

        /* renamed from: c  reason: collision with root package name */
        final int f8853c;

        /* renamed from: d  reason: collision with root package name */
        private final String f8854d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f8855e;

        public a(String str, String str2, int i2, boolean z) {
            this.f8854d = s.a(str);
            this.f8851a = s.a(str2);
            this.f8853c = i2;
            this.f8855e = z;
        }

        public final String toString() {
            String str = this.f8854d;
            if (str != null) {
                return str;
            }
            s.a(this.f8852b);
            return this.f8852b.flattenToString();
        }

        public final Intent a(Context context) {
            if (this.f8854d == null) {
                return new Intent().setComponent(this.f8852b);
            }
            Intent b2 = this.f8855e ? b(context) : null;
            if (b2 == null) {
                return new Intent(this.f8854d).setPackage(this.f8851a);
            }
            return b2;
        }

        /* JADX WARNING: type inference failed for: r5v3, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.content.Intent b(android.content.Context r5) {
            /*
                r4 = this;
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                java.lang.String r1 = r4.f8854d
                java.lang.String r2 = "serviceActionBundleKey"
                r0.putString(r2, r1)
                r1 = 0
                android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x001a }
                android.net.Uri r2 = f8850f     // Catch:{ IllegalArgumentException -> 0x001a }
                java.lang.String r3 = "serviceIntentCall"
                android.os.Bundle r5 = r5.call(r2, r3, r1, r0)     // Catch:{ IllegalArgumentException -> 0x001a }
                goto L_0x0037
            L_0x001a:
                r5 = move-exception
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r0 = java.lang.String.valueOf(r5)
                int r0 = r0.length()
                int r0 = r0 + 34
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r0)
                java.lang.String r0 = "Dynamic intent resolution failed: "
                r2.append(r0)
                r2.append(r5)
                r5 = r1
            L_0x0037:
                if (r5 != 0) goto L_0x003a
                goto L_0x0043
            L_0x003a:
                java.lang.String r0 = "serviceResponseIntentKey"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0043:
                if (r1 != 0) goto L_0x005c
                java.lang.String r5 = "Dynamic lookup for intent failed for action: "
                java.lang.String r0 = r4.f8854d
                java.lang.String r0 = java.lang.String.valueOf(r0)
                int r2 = r0.length()
                if (r2 == 0) goto L_0x0057
                r5.concat(r0)
                goto L_0x005c
            L_0x0057:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r5)
            L_0x005c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.i.a.b(android.content.Context):android.content.Intent");
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f8854d, this.f8851a, this.f8852b, Integer.valueOf(this.f8853c), Boolean.valueOf(this.f8855e)});
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return q.a(this.f8854d, aVar.f8854d) && q.a(this.f8851a, aVar.f8851a) && q.a(this.f8852b, aVar.f8852b) && this.f8853c == aVar.f8853c && this.f8855e == aVar.f8855e;
        }
    }

    public final void a(String str, String str2, int i2, ServiceConnection serviceConnection, boolean z) {
        b(new a(str, str2, i2, z), serviceConnection);
    }
}
