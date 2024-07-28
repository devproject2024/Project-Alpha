package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.f;
import com.bumptech.glide.b.l;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.a.m;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.j;
import com.bumptech.glide.load.b.b.g;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.b.i;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.a;
import com.bumptech.glide.load.c.a.a;
import com.bumptech.glide.load.c.a.b;
import com.bumptech.glide.load.c.a.c;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.c.a.e;
import com.bumptech.glide.load.c.a.f;
import com.bumptech.glide.load.c.b;
import com.bumptech.glide.load.c.d;
import com.bumptech.glide.load.c.e;
import com.bumptech.glide.load.c.f;
import com.bumptech.glide.load.c.k;
import com.bumptech.glide.load.c.s;
import com.bumptech.glide.load.c.t;
import com.bumptech.glide.load.c.u;
import com.bumptech.glide.load.c.v;
import com.bumptech.glide.load.c.w;
import com.bumptech.glide.load.c.x;
import com.bumptech.glide.load.d.a.ac;
import com.bumptech.glide.load.d.a.ae;
import com.bumptech.glide.load.d.a.af;
import com.bumptech.glide.load.d.a.c;
import com.bumptech.glide.load.d.a.m;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.r;
import com.bumptech.glide.load.d.a.v;
import com.bumptech.glide.load.d.a.x;
import com.bumptech.glide.load.d.a.z;
import com.bumptech.glide.load.d.b.a;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b implements ComponentCallbacks2 {

    /* renamed from: h  reason: collision with root package name */
    private static volatile b f6423h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f6424i;

    /* renamed from: a  reason: collision with root package name */
    public final e f6425a;

    /* renamed from: b  reason: collision with root package name */
    public final d f6426b;

    /* renamed from: c  reason: collision with root package name */
    public final g f6427c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bumptech.glide.load.b.a.b f6428d;

    /* renamed from: e  reason: collision with root package name */
    public final l f6429e;

    /* renamed from: f  reason: collision with root package name */
    final d f6430f;

    /* renamed from: g  reason: collision with root package name */
    final List<i> f6431g = new ArrayList();
    private final k j;
    private final h k;
    private final a l;
    private e m = e.NORMAL;

    public interface a {
        com.bumptech.glide.e.h a();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static b a(Context context) {
        if (f6423h == null) {
            GeneratedAppGlideModule c2 = c(context.getApplicationContext());
            synchronized (b.class) {
                if (f6423h == null) {
                    if (!f6424i) {
                        f6424i = true;
                        a(context, new c(), c2);
                        f6424i = false;
                    } else {
                        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                    }
                }
            }
        }
        return f6423h;
    }

    private static void a(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) {
        c cVar2 = cVar;
        Context applicationContext = context.getApplicationContext();
        Collections.emptyList();
        List<com.bumptech.glide.c.b> a2 = new com.bumptech.glide.c.d(applicationContext).a();
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> a3 = generatedAppGlideModule.a();
            Iterator<com.bumptech.glide.c.b> it2 = a2.iterator();
            while (it2.hasNext()) {
                com.bumptech.glide.c.b next = it2.next();
                if (a3.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.bumptech.glide.c.b bVar : a2) {
                new StringBuilder("Discovered GlideModule from manifest: ").append(bVar.getClass());
            }
        }
        cVar2.m = null;
        Iterator<com.bumptech.glide.c.b> it3 = a2.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        if (cVar2.f6473f == null) {
            cVar2.f6473f = com.bumptech.glide.load.b.c.a.b();
        }
        if (cVar2.f6474g == null) {
            cVar2.f6474g = com.bumptech.glide.load.b.c.a.a();
        }
        if (cVar2.n == null) {
            cVar2.n = com.bumptech.glide.load.b.c.a.d();
        }
        if (cVar2.f6476i == null) {
            cVar2.f6476i = new i(new i.a(applicationContext));
        }
        if (cVar2.j == null) {
            cVar2.j = new f();
        }
        if (cVar2.f6470c == null) {
            int i2 = cVar2.f6476i.f6789a;
            if (i2 > 0) {
                cVar2.f6470c = new com.bumptech.glide.load.b.a.k((long) i2);
            } else {
                cVar2.f6470c = new com.bumptech.glide.load.b.a.f();
            }
        }
        if (cVar2.f6471d == null) {
            cVar2.f6471d = new j(cVar2.f6476i.f6791c);
        }
        if (cVar2.f6472e == null) {
            cVar2.f6472e = new g((long) cVar2.f6476i.f6790b);
        }
        if (cVar2.f6475h == null) {
            cVar2.f6475h = new com.bumptech.glide.load.b.b.f(applicationContext);
        }
        if (cVar2.f6469b == null) {
            cVar2.f6469b = new k(cVar2.f6472e, cVar2.f6475h, cVar2.f6474g, cVar2.f6473f, com.bumptech.glide.load.b.c.a.c(), cVar2.n, cVar2.o);
        }
        if (cVar2.p == null) {
            cVar2.p = Collections.emptyList();
        } else {
            cVar2.p = Collections.unmodifiableList(cVar2.p);
        }
        l lVar = new l(cVar2.m);
        Context context2 = applicationContext;
        Context context3 = applicationContext;
        b bVar2 = r0;
        b bVar3 = new b(context2, cVar2.f6469b, cVar2.f6472e, cVar2.f6470c, cVar2.f6471d, lVar, cVar2.j, cVar2.k, cVar2.l, cVar2.f6468a, cVar2.p, cVar2.q, cVar2.r);
        Iterator<com.bumptech.glide.c.b> it4 = a2.iterator();
        while (it4.hasNext()) {
            it4.next();
        }
        context3.registerComponentCallbacks(bVar2);
        f6423h = bVar2;
    }

    private static GeneratedAppGlideModule c(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            Log.isLoggable("Glide", 5);
        } catch (InstantiationException e2) {
            a((Exception) e2);
        } catch (IllegalAccessException e3) {
            a((Exception) e3);
        } catch (NoSuchMethodException e4) {
            a((Exception) e4);
        } catch (InvocationTargetException e5) {
            a((Exception) e5);
        }
        return null;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    private b(Context context, k kVar, h hVar, e eVar, com.bumptech.glide.load.b.a.b bVar, l lVar, d dVar, int i2, a aVar, Map<Class<?>, j<?, ?>> map, List<com.bumptech.glide.e.g<Object>> list, boolean z, boolean z2) {
        com.bumptech.glide.load.k kVar2;
        com.bumptech.glide.load.k kVar3;
        com.bumptech.glide.load.d.c.e eVar2;
        Context context2 = context;
        e eVar3 = eVar;
        com.bumptech.glide.load.b.a.b bVar2 = bVar;
        Class<byte[]> cls = byte[].class;
        this.j = kVar;
        this.f6425a = eVar3;
        this.f6428d = bVar2;
        this.k = hVar;
        this.f6429e = lVar;
        this.f6430f = dVar;
        this.l = aVar;
        Resources resources = context.getResources();
        this.f6427c = new g();
        this.f6427c.a((ImageHeaderParser) new m());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f6427c.a((ImageHeaderParser) new r());
        }
        List<ImageHeaderParser> a2 = this.f6427c.a();
        com.bumptech.glide.load.d.e.a aVar2 = new com.bumptech.glide.load.d.e.a(context2, a2, eVar3, bVar2);
        com.bumptech.glide.load.k<ParcelFileDescriptor, Bitmap> b2 = af.b(eVar);
        o oVar = new o(this.f6427c.a(), resources.getDisplayMetrics(), eVar3, bVar2);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            kVar2 = new com.bumptech.glide.load.d.a.h(oVar);
            kVar3 = new ac(oVar, bVar2);
        } else {
            kVar3 = new v();
            kVar2 = new com.bumptech.glide.load.d.a.i();
        }
        com.bumptech.glide.load.d.c.e eVar4 = new com.bumptech.glide.load.d.c.e(context2);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        Class<byte[]> cls2 = cls;
        s.a aVar3 = new s.a(resources);
        c cVar2 = new c(bVar2);
        s.a aVar4 = aVar3;
        com.bumptech.glide.load.d.f.a aVar5 = new com.bumptech.glide.load.d.f.a();
        com.bumptech.glide.load.d.f.d dVar3 = new com.bumptech.glide.load.d.f.d();
        ContentResolver contentResolver = context.getContentResolver();
        s.d dVar4 = dVar2;
        s.b bVar4 = bVar3;
        s.c cVar3 = cVar;
        this.f6427c.a(ByteBuffer.class, new com.bumptech.glide.load.c.c()).a(InputStream.class, new t(bVar2)).a("Bitmap", ByteBuffer.class, Bitmap.class, kVar2).a("Bitmap", InputStream.class, Bitmap.class, kVar3);
        if (com.bumptech.glide.load.a.m.c()) {
            eVar2 = eVar4;
            this.f6427c.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new x(oVar));
        } else {
            eVar2 = eVar4;
        }
        com.bumptech.glide.load.d.c.e eVar5 = eVar2;
        this.f6427c.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, af.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.a()).a("Bitmap", Bitmap.class, Bitmap.class, new ae()).a(Bitmap.class, cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, kVar2)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, kVar3)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, b2)).a(BitmapDrawable.class, new com.bumptech.glide.load.d.a.b(eVar3, cVar2)).a("Gif", InputStream.class, com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.j(a2, aVar2, bVar2)).a("Gif", ByteBuffer.class, com.bumptech.glide.load.d.e.c.class, aVar2).a(com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.d()).a(com.bumptech.glide.gifdecoder.a.class, com.bumptech.glide.gifdecoder.a.class, v.a.a()).a("Bitmap", com.bumptech.glide.gifdecoder.a.class, Bitmap.class, new com.bumptech.glide.load.d.e.h(eVar3)).a(Uri.class, Drawable.class, eVar5).a(Uri.class, Bitmap.class, new z(eVar5, eVar3)).a((e.a<?>) new a.C0100a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.load.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.a()).a((e.a<?>) new k.a(bVar2));
        if (com.bumptech.glide.load.a.m.c()) {
            this.f6427c.a((e.a<?>) new m.a());
        }
        s.c cVar4 = cVar3;
        s.b bVar5 = bVar4;
        s.d dVar5 = dVar4;
        s.a aVar6 = aVar4;
        Context context3 = context;
        this.f6427c.a(Integer.TYPE, InputStream.class, cVar4).a(Integer.TYPE, ParcelFileDescriptor.class, bVar5).a(Integer.class, InputStream.class, cVar4).a(Integer.class, ParcelFileDescriptor.class, bVar5).a(Integer.class, Uri.class, dVar5).a(Integer.TYPE, AssetFileDescriptor.class, aVar6).a(Integer.class, AssetFileDescriptor.class, aVar6).a(Integer.TYPE, Uri.class, dVar5).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context3)).a(Uri.class, InputStream.class, new d.a(context3));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6427c.a(Uri.class, InputStream.class, new e.c(context3));
            this.f6427c.a(Uri.class, ParcelFileDescriptor.class, new e.b(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls3 = cls2;
        com.bumptech.glide.load.d.f.a aVar7 = aVar5;
        com.bumptech.glide.load.d.f.d dVar6 = dVar3;
        this.f6427c.a(Uri.class, InputStream.class, new w.d(contentResolver2)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver2)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver2)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new f.a()).a(Uri.class, File.class, new k.a(context3)).a(com.bumptech.glide.load.c.g.class, InputStream.class, new a.C0097a()).a(cls3, ByteBuffer.class, new b.a()).a(cls3, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.a()).a(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.d.c.f()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.d.f.b(resources)).a(Bitmap.class, cls3, aVar7).a(Drawable.class, cls3, new com.bumptech.glide.load.d.f.c(eVar3, aVar7, dVar6)).a(com.bumptech.glide.load.d.e.c.class, cls3, dVar6);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.k<ByteBuffer, Bitmap> c2 = af.c(eVar);
            this.f6427c.a(ByteBuffer.class, Bitmap.class, c2);
            this.f6427c.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, c2));
        }
        Context context4 = context;
        com.bumptech.glide.load.b.a.b bVar6 = bVar;
        this.f6426b = new d(context4, bVar6, this.f6427c, new com.bumptech.glide.e.a.f(), aVar, map, list, kVar, z, i2);
    }

    private static l d(Context context) {
        com.bumptech.glide.g.j.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).f6429e;
    }

    public static i b(Context context) {
        return d(context).a(context);
    }

    public static i a(Activity activity) {
        return d(activity).a(activity);
    }

    public static i a(FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: type inference failed for: r4v8, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0082, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0082, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ed, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.i a(android.view.View r6) {
        /*
            android.content.Context r0 = r6.getContext()
            com.bumptech.glide.b.l r0 = d(r0)
            boolean r1 = com.bumptech.glide.g.k.d()
            if (r1 == 0) goto L_0x001b
            android.content.Context r6 = r6.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r6)
            return r6
        L_0x001b:
            java.lang.String r1 = "Argument must not be null"
            com.bumptech.glide.g.j.a(r6, (java.lang.String) r1)
            android.content.Context r1 = r6.getContext()
            java.lang.String r2 = "Unable to obtain a request manager for a view without a Context"
            com.bumptech.glide.g.j.a(r1, (java.lang.String) r2)
            android.content.Context r1 = r6.getContext()
            android.app.Activity r1 = com.bumptech.glide.b.l.b((android.content.Context) r1)
            if (r1 != 0) goto L_0x0040
            android.content.Context r6 = r6.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r6)
            return r6
        L_0x0040:
            boolean r2 = r1 instanceof androidx.fragment.app.FragmentActivity
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            r4 = 0
            if (r2 == 0) goto L_0x00bb
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            androidx.a.a<android.view.View, androidx.fragment.app.Fragment> r2 = r0.f6451c
            r2.clear()
            androidx.fragment.app.j r2 = r1.getSupportFragmentManager()
            androidx.fragment.app.p r2 = r2.f3424a
            java.util.List r2 = r2.d()
            androidx.a.a<android.view.View, androidx.fragment.app.Fragment> r5 = r0.f6451c
            com.bumptech.glide.b.l.a((java.util.Collection<androidx.fragment.app.Fragment>) r2, (java.util.Map<android.view.View, androidx.fragment.app.Fragment>) r5)
            android.view.View r2 = r1.findViewById(r3)
        L_0x0062:
            boolean r3 = r6.equals(r2)
            if (r3 != 0) goto L_0x0082
            androidx.a.a<android.view.View, androidx.fragment.app.Fragment> r3 = r0.f6451c
            java.lang.Object r3 = r3.get(r6)
            r4 = r3
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            if (r4 != 0) goto L_0x0082
            android.view.ViewParent r3 = r6.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x0082
            android.view.ViewParent r6 = r6.getParent()
            android.view.View r6 = (android.view.View) r6
            goto L_0x0062
        L_0x0082:
            androidx.a.a<android.view.View, androidx.fragment.app.Fragment> r6 = r0.f6451c
            r6.clear()
            if (r4 == 0) goto L_0x00b6
            android.content.Context r6 = r4.getContext()
            java.lang.String r1 = "You cannot start a load on a fragment before it is attached or after it is destroyed"
            com.bumptech.glide.g.j.a(r6, (java.lang.String) r1)
            boolean r6 = com.bumptech.glide.g.k.d()
            if (r6 == 0) goto L_0x00a5
            android.content.Context r6 = r4.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r6)
            return r6
        L_0x00a5:
            androidx.fragment.app.j r6 = r4.getChildFragmentManager()
            android.content.Context r1 = r4.getContext()
            boolean r2 = r4.isVisible()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r1, (androidx.fragment.app.j) r6, (androidx.fragment.app.Fragment) r4, (boolean) r2)
            return r6
        L_0x00b6:
            com.bumptech.glide.i r6 = r0.a((androidx.fragment.app.FragmentActivity) r1)
            return r6
        L_0x00bb:
            androidx.a.a<android.view.View, android.app.Fragment> r2 = r0.f6452d
            r2.clear()
            android.app.FragmentManager r2 = r1.getFragmentManager()
            androidx.a.a<android.view.View, android.app.Fragment> r5 = r0.f6452d
            r0.a((android.app.FragmentManager) r2, (androidx.a.a<android.view.View, android.app.Fragment>) r5)
            android.view.View r2 = r1.findViewById(r3)
        L_0x00cd:
            boolean r3 = r6.equals(r2)
            if (r3 != 0) goto L_0x00ed
            androidx.a.a<android.view.View, android.app.Fragment> r3 = r0.f6452d
            java.lang.Object r3 = r3.get(r6)
            r4 = r3
            android.app.Fragment r4 = (android.app.Fragment) r4
            if (r4 != 0) goto L_0x00ed
            android.view.ViewParent r3 = r6.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x00ed
            android.view.ViewParent r6 = r6.getParent()
            android.view.View r6 = (android.view.View) r6
            goto L_0x00cd
        L_0x00ed:
            androidx.a.a<android.view.View, android.app.Fragment> r6 = r0.f6452d
            r6.clear()
            if (r4 != 0) goto L_0x00f9
            com.bumptech.glide.i r6 = r0.a((android.app.Activity) r1)
            return r6
        L_0x00f9:
            android.app.Activity r6 = r4.getActivity()
            if (r6 == 0) goto L_0x012a
            boolean r6 = com.bumptech.glide.g.k.d()
            if (r6 != 0) goto L_0x011d
            int r6 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r6 >= r1) goto L_0x010c
            goto L_0x011d
        L_0x010c:
            android.app.FragmentManager r6 = r4.getChildFragmentManager()
            android.app.Activity r1 = r4.getActivity()
            boolean r2 = r4.isVisible()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r1, (android.app.FragmentManager) r6, (android.app.Fragment) r4, (boolean) r2)
            return r6
        L_0x011d:
            android.app.Activity r6 = r4.getActivity()
            android.content.Context r6 = r6.getApplicationContext()
            com.bumptech.glide.i r6 = r0.a((android.content.Context) r6)
            return r6
        L_0x012a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "You cannot start a load on a fragment before it is attached"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a(android.view.View):com.bumptech.glide.i");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(com.bumptech.glide.e.a.j<?> jVar) {
        synchronized (this.f6431g) {
            for (i b2 : this.f6431g) {
                if (b2.b(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onTrimMemory(int i2) {
        com.bumptech.glide.g.k.a();
        for (i onTrimMemory : this.f6431g) {
            onTrimMemory.onTrimMemory(i2);
        }
        this.k.a(i2);
        this.f6425a.a(i2);
        this.f6428d.a(i2);
    }

    public void onLowMemory() {
        com.bumptech.glide.g.k.a();
        this.k.a();
        this.f6425a.a();
        this.f6428d.a();
    }
}
