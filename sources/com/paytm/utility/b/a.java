package com.paytm.utility.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.e.a.j;
import com.bumptech.glide.e.g;
import com.bumptech.glide.load.b.q;
import com.paytm.utility.a.b;
import kotlin.g.b.k;
import kotlin.u;

public final class a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f43710a;

    /* renamed from: b  reason: collision with root package name */
    public static final C0749a f43711b = new C0749a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f43712c;

    /* renamed from: com.paytm.utility.b.a$a  reason: collision with other inner class name */
    public static final class C0749a {
        private C0749a() {
        }

        public /* synthetic */ C0749a(byte b2) {
            this();
        }
    }

    public static final class b implements g<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43714a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f43715b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProgressBar f43716c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f43717d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f43718e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f43719f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.b.b.b f43720g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f43721h;

        b(a aVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2, com.paytm.utility.b.b.b bVar, boolean z) {
            this.f43714a = aVar;
            this.f43715b = lottieAnimationView;
            this.f43716c = progressBar;
            this.f43717d = obj;
            this.f43718e = str;
            this.f43719f = str2;
            this.f43720g = bVar;
            this.f43721h = z;
        }

        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, j jVar, com.bumptech.glide.load.a aVar, boolean z) {
            Bitmap bitmap = (Bitmap) obj;
            a.a(this.f43715b, this.f43716c);
            com.paytm.utility.b.b.b bVar = this.f43720g;
            if (bVar != null) {
                bVar.onSuccess(bitmap, a.a(aVar));
            }
            return !this.f43721h;
        }

        public final boolean onLoadFailed(q qVar, Object obj, j<Bitmap> jVar, boolean z) {
            a.a(this.f43715b, this.f43716c);
            a.class.getSimpleName();
            com.paytm.utility.q.c("Error loading image ");
            a.a(this.f43717d, qVar, this.f43718e, this.f43719f);
            com.paytm.utility.b.b.b bVar = this.f43720g;
            if (bVar != null) {
                if (qVar != null) {
                    bVar.onError(qVar);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
                }
            }
            return !this.f43721h;
        }
    }

    /* access modifiers changed from: package-private */
    public final b a(boolean z, com.paytm.utility.b.b.b<Bitmap> bVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2) {
        return new b(this, lottieAnimationView, progressBar, obj, str, str2, bVar, z);
    }

    public static final class d implements g<com.bumptech.glide.load.d.e.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43736a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f43737b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProgressBar f43738c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f43739d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f43740e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f43741f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.b.b.b f43742g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f43743h;

        d(a aVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2, com.paytm.utility.b.b.b bVar, boolean z) {
            this.f43736a = aVar;
            this.f43737b = lottieAnimationView;
            this.f43738c = progressBar;
            this.f43739d = obj;
            this.f43740e = str;
            this.f43741f = str2;
            this.f43742g = bVar;
            this.f43743h = z;
        }

        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, j jVar, com.bumptech.glide.load.a aVar, boolean z) {
            com.bumptech.glide.load.d.e.c cVar = (com.bumptech.glide.load.d.e.c) obj;
            a.a(this.f43737b, this.f43738c);
            com.paytm.utility.b.b.b bVar = this.f43742g;
            if (bVar != null) {
                bVar.onSuccess(cVar, a.a(aVar));
            }
            return !this.f43743h;
        }

        public final boolean onLoadFailed(q qVar, Object obj, j<com.bumptech.glide.load.d.e.c> jVar, boolean z) {
            a.a(this.f43737b, this.f43738c);
            a.class.getSimpleName();
            com.paytm.utility.q.c("Error loading image ");
            a.a(this.f43739d, qVar, this.f43740e, this.f43741f);
            com.paytm.utility.b.b.b bVar = this.f43742g;
            if (bVar != null) {
                if (qVar != null) {
                    bVar.onError(qVar);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
                }
            }
            return !this.f43743h;
        }
    }

    /* access modifiers changed from: package-private */
    public final d b(boolean z, com.paytm.utility.b.b.b<com.bumptech.glide.load.d.e.c> bVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2) {
        return new d(this, lottieAnimationView, progressBar, obj, str, str2, bVar, z);
    }

    public static final class c implements g<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43728a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f43729b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProgressBar f43730c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f43731d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f43732e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f43733f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.b.b.b f43734g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f43735h;

        c(a aVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2, com.paytm.utility.b.b.b bVar, boolean z) {
            this.f43728a = aVar;
            this.f43729b = lottieAnimationView;
            this.f43730c = progressBar;
            this.f43731d = obj;
            this.f43732e = str;
            this.f43733f = str2;
            this.f43734g = bVar;
            this.f43735h = z;
        }

        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, j jVar, com.bumptech.glide.load.a aVar, boolean z) {
            Drawable drawable = (Drawable) obj;
            a.a(this.f43729b, this.f43730c);
            com.paytm.utility.b.b.b bVar = this.f43734g;
            if (bVar != null) {
                bVar.onSuccess(drawable, a.a(aVar));
            }
            return !this.f43735h;
        }

        public final boolean onLoadFailed(q qVar, Object obj, j<Drawable> jVar, boolean z) {
            a.a(this.f43729b, this.f43730c);
            a.class.getSimpleName();
            com.paytm.utility.q.c("Error loading image ");
            a.a(this.f43731d, qVar, this.f43732e, this.f43733f);
            com.paytm.utility.b.b.b bVar = this.f43734g;
            if (bVar != null) {
                if (qVar != null) {
                    bVar.onError(qVar);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
                }
            }
            return !this.f43735h;
        }
    }

    /* access modifiers changed from: package-private */
    public final c c(boolean z, com.paytm.utility.b.b.b<Drawable> bVar, LottieAnimationView lottieAnimationView, ProgressBar progressBar, Object obj, String str, String str2) {
        return new c(this, lottieAnimationView, progressBar, obj, str, str2, bVar, z);
    }

    public static final /* synthetic */ void a(LottieAnimationView lottieAnimationView, ProgressBar progressBar) {
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public static final /* synthetic */ void a(Object obj, q qVar, String str, String str2) {
        String message;
        try {
            com.paytm.utility.a.c cVar = new com.paytm.utility.a.c((byte) 0);
            cVar.f43683a = -1;
            if (obj != null) {
                cVar.f43685c = (String) obj;
                cVar.f43686d = str;
                cVar.f43687e = str2;
                if (!(qVar == null || (message = qVar.getMessage()) == null)) {
                    cVar.f43684b = message;
                }
                b.a aVar = com.paytm.utility.a.b.f43681a;
                com.paytm.utility.a.a a2 = com.paytm.utility.a.b.f43682b;
                if (a2 != null) {
                    Context context = f43710a;
                    if (context == null) {
                        k.a();
                    }
                    a2.a(cVar, context);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e2) {
            a.class.getSimpleName();
            com.paytm.utility.q.b("on load failed exception message = " + e2.getMessage());
        }
    }

    public static final /* synthetic */ com.paytm.utility.b.b.c a(com.bumptech.glide.load.a aVar) {
        Integer valueOf = aVar != null ? Integer.valueOf(aVar.ordinal()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            return com.paytm.utility.b.b.c.LOCAL;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return com.paytm.utility.b.b.c.REMOTE;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            return com.paytm.utility.b.b.c.DATA_DISK_CACHE;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return com.paytm.utility.b.b.c.RESOURCE_DISK_CACHE;
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            return com.paytm.utility.b.b.c.MEMORY_CACHE;
        }
        return null;
    }
}
