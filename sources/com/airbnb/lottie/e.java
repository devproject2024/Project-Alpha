package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.e.t;
import com.airbnb.lottie.f.h;
import i.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, m<d>> f5987a = new HashMap();

    public static m<d> a(Context context, String str) {
        return a(context, str, "url_".concat(String.valueOf(str)));
    }

    public static m<d> a(final Context context, final String str, final String str2) {
        return a(str2, (Callable<l<d>>) new Callable<l<d>>() {
            /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ java.lang.Object call() throws java.lang.Exception {
                /*
                    r4 = this;
                    android.content.Context r0 = r1
                    java.lang.String r1 = r2
                    java.lang.String r2 = r3
                    com.airbnb.lottie.d.c r3 = new com.airbnb.lottie.d.c
                    r3.<init>(r0, r1, r2)
                    com.airbnb.lottie.d.b r0 = r3.f5985b
                    if (r0 == 0) goto L_0x0040
                    com.airbnb.lottie.d.b r0 = r3.f5985b
                    java.lang.String r1 = r3.f5984a
                    androidx.core.g.d r0 = r0.a(r1)
                    if (r0 == 0) goto L_0x0040
                    F r1 = r0.f2964a
                    com.airbnb.lottie.d.a r1 = (com.airbnb.lottie.d.a) r1
                    S r0 = r0.f2965b
                    java.io.InputStream r0 = (java.io.InputStream) r0
                    com.airbnb.lottie.d.a r2 = com.airbnb.lottie.d.a.ZIP
                    if (r1 != r2) goto L_0x0031
                    java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream
                    r1.<init>(r0)
                    java.lang.String r0 = r3.f5984a
                    com.airbnb.lottie.l r0 = com.airbnb.lottie.e.a((java.util.zip.ZipInputStream) r1, (java.lang.String) r0)
                    goto L_0x0037
                L_0x0031:
                    java.lang.String r1 = r3.f5984a
                    com.airbnb.lottie.l r0 = com.airbnb.lottie.e.b((java.io.InputStream) r0, (java.lang.String) r1)
                L_0x0037:
                    V r1 = r0.f6164a
                    if (r1 == 0) goto L_0x0040
                    V r0 = r0.f6164a
                    com.airbnb.lottie.d r0 = (com.airbnb.lottie.d) r0
                    goto L_0x0041
                L_0x0040:
                    r0 = 0
                L_0x0041:
                    if (r0 == 0) goto L_0x0049
                    com.airbnb.lottie.l r1 = new com.airbnb.lottie.l
                    r1.<init>(r0)
                    return r1
                L_0x0049:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "Animation for "
                    r0.<init>(r1)
                    java.lang.String r1 = r3.f5984a
                    r0.append(r1)
                    java.lang.String r1 = " not found in cache. Fetching from network."
                    r0.append(r1)
                    com.airbnb.lottie.f.d.a()
                    com.airbnb.lottie.l r0 = r3.a()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.AnonymousClass1.call():java.lang.Object");
            }
        });
    }

    public static m<d> b(Context context, String str) {
        return b(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static m<d> b(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return a(str2, (Callable<l<d>>) new Callable<l<d>>() {
            public final /* synthetic */ Object call() throws Exception {
                return e.c(applicationContext, str, str2);
            }
        });
    }

    public static l<d> c(Context context, String str, String str2) {
        try {
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return c(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new l<>((Throwable) e2);
        }
    }

    public static m<d> a(Context context, int i2) {
        return a(context, i2, c(context, i2));
    }

    public static m<d> a(Context context, final int i2, String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return a(str, (Callable<l<d>>) new Callable<l<d>>() {
            public final /* synthetic */ Object call() throws Exception {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    context = applicationContext;
                }
                return e.b(context, i2);
            }
        });
    }

    public static l<d> b(Context context, int i2) {
        return b(context, i2, c(context, i2));
    }

    private static l<d> b(Context context, int i2, String str) {
        try {
            return c(context.getResources().openRawResource(i2), str);
        } catch (Resources.NotFoundException e2) {
            return new l<>((Throwable) e2);
        }
    }

    private static String c(Context context, int i2) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(a(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }

    private static boolean a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static m<d> a(final InputStream inputStream, final String str) {
        return a(str, (Callable<l<d>>) new Callable<l<d>>() {
            public final /* synthetic */ Object call() throws Exception {
                return e.b(inputStream, str);
            }
        });
    }

    public static l<d> b(InputStream inputStream, String str) {
        return c(inputStream, str);
    }

    private static l<d> c(InputStream inputStream, String str) {
        try {
            return a(c.a(n.a(n.a(inputStream))), str, true);
        } finally {
            h.a((Closeable) inputStream);
        }
    }

    private static l<d> a(c cVar, String str, boolean z) {
        try {
            d a2 = t.a(cVar);
            if (str != null) {
                g.a().a(str, a2);
            }
            l<d> lVar = new l<>(a2);
            if (z) {
                h.a((Closeable) cVar);
            }
            return lVar;
        } catch (Exception e2) {
            l<d> lVar2 = new l<>((Throwable) e2);
            if (z) {
                h.a((Closeable) cVar);
            }
            return lVar2;
        } catch (Throwable th) {
            if (z) {
                h.a((Closeable) cVar);
            }
            throw th;
        }
    }

    public static l<d> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            h.a((Closeable) zipInputStream);
        }
    }

    private static l<d> b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        dVar = (d) a(c.a(n.a(n.a((InputStream) zipInputStream))), (String) null, false).f6164a;
                    } else if (name.contains(".png") || name.contains(".webp")) {
                        String[] split = name.split("/");
                        hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new l<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a2 = a(dVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.f6132e = h.a((Bitmap) entry.getValue(), a2.f6128a, a2.f6129b);
                }
            }
            for (Map.Entry next : dVar.f5976c.entrySet()) {
                if (((g) next.getValue()).f6132e == null) {
                    return new l<>((Throwable) new IllegalStateException("There is no image for " + ((g) next.getValue()).f6131d));
                }
            }
            if (str != null) {
                g.a().a(str, dVar);
            }
            return new l<>(dVar);
        } catch (IOException e2) {
            return new l<>((Throwable) e2);
        }
    }

    private static m<d> a(final String str, Callable<l<d>> callable) {
        final d a2 = str == null ? null : g.a().a(str);
        if (a2 != null) {
            return new m<>(new Callable<l<d>>() {
                public final /* synthetic */ Object call() throws Exception {
                    return new l(d.this);
                }
            });
        }
        if (str != null && f5987a.containsKey(str)) {
            return f5987a.get(str);
        }
        m<d> mVar = new m<>(callable);
        if (str != null) {
            mVar.a((h<d>) new h<d>() {
                public final /* synthetic */ void onResult(Object obj) {
                    e.f5987a.remove(str);
                }
            });
            mVar.c(new h<Throwable>() {
                public final /* synthetic */ void onResult(Object obj) {
                    e.f5987a.remove(str);
                }
            });
            f5987a.put(str, mVar);
        }
        return mVar;
    }

    private static g a(d dVar, String str) {
        for (g next : dVar.f5976c.values()) {
            if (next.f6131d.equals(str)) {
                return next;
            }
        }
        return null;
    }
}
