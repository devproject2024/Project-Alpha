package com.paytm.utility.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.f;
import com.bumptech.glide.h;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.a.aa;
import com.bumptech.glide.load.d.c.c;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.m;
import com.paytm.utility.R;
import com.paytm.utility.b.a;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b.a;
import com.paytm.utility.b.b.d;
import com.paytm.utility.b.b.e;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43744a = new a((byte) 0);
    private int A = this.S.x;
    private boolean B = this.S.y;
    private int C = this.S.z;
    private int D = this.S.A;
    private Boolean E = this.S.H;
    private int F = this.S.J;
    private int G = this.S.K;
    private a H = this.S.L;
    private boolean I = this.S.M;
    private boolean J = this.S.q;
    private e K = this.S.r;
    private boolean L = this.S.s;
    private d M = this.S.t;
    private String N = this.S.u;
    private String O = this.S.N;
    private String P = this.S.O;
    private com.paytm.utility.b.b.b<?> Q = this.S.P;
    private a R;
    private a.C0750a S;

    /* renamed from: b  reason: collision with root package name */
    private Context f43745b = this.S.Q;

    /* renamed from: c  reason: collision with root package name */
    private Object f43746c = this.S.f43753a;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f43747d = this.S.f43754b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43748e = this.S.f43755c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43749f = this.S.f43756d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43750g = this.S.f43757e;

    /* renamed from: h  reason: collision with root package name */
    private float f43751h = this.S.f43758f;

    /* renamed from: i  reason: collision with root package name */
    private Object f43752i = this.S.f43759g;
    private Object j = this.S.f43760h;
    private Object k = this.S.f43761i;
    private ProgressBar l = this.S.j;
    private LottieAnimationView m = this.S.k;
    private boolean n = this.S.l;
    private boolean o = this.S.m;
    private boolean p = this.S.n;
    private boolean q = this.S.o;
    private boolean r = this.S.p;
    private boolean s = this.S.F;
    private boolean t = this.S.G;
    private int u = this.S.B;
    private int v = this.S.C;
    private b.a w = this.S.D;
    private int x = this.S.E;
    private boolean y = this.S.v;
    private int z = this.S.w;

    public static final a.C0750a a(Context context) {
        return a.a(context);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && k.a((Object) this.S, (Object) ((b) obj).S);
        }
        return true;
    }

    public final int hashCode() {
        a.C0750a aVar = this.S;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PaytmImageLoader(builder=" + this.S + ")";
    }

    public b(a.C0750a aVar) {
        j jVar;
        h hVar;
        com.bumptech.glide.load.b bVar;
        f fVar;
        a.C0750a aVar2 = aVar;
        Class<b> cls = b.class;
        k.c(aVar2, "builder");
        this.S = aVar2;
        a.C0749a aVar3 = a.f43711b;
        if (a.f43712c == null) {
            synchronized (cls) {
                a.C0749a aVar4 = a.f43711b;
                if (a.f43712c == null) {
                    a.C0749a aVar5 = a.f43711b;
                    Context context = this.f43745b;
                    k.c(context, "context");
                    a.f43710a = context.getApplicationContext();
                    a.f43712c = new a();
                }
                x xVar = x.f47997a;
            }
        }
        a.C0749a aVar6 = a.f43711b;
        this.R = a.f43712c;
        a aVar7 = this.R;
        if (aVar7 != null) {
            com.bumptech.glide.e.h hVar2 = new com.bumptech.glide.e.h();
            if (this.q || !this.f43749f) {
                hVar2.i();
            }
            if (this.n) {
                hVar2.f();
            }
            if (this.o) {
                hVar2.g();
            }
            if (this.p) {
                hVar2.j();
            }
            if (this.r) {
                hVar2.k();
            }
            if (this.s) {
                hVar2.a((m<Bitmap>) new com.paytm.utility.b.a.b(this.f43745b, this.u, this.v, this.w));
            }
            int i2 = this.x;
            if (i2 > 0) {
                hVar2.a((m<Bitmap>) new aa(i2));
            }
            if (this.t) {
                hVar2.a((m<Bitmap>) new com.paytm.utility.b.a.a(this.f43745b));
            }
            if (this.y) {
                hVar2.a(this.A, this.z);
                cls.getSimpleName();
                q.b("resizeWidth =" + this.A + " and resizeHeight = " + this.z);
            } else if (this.B) {
                Resources resources = this.f43745b.getResources();
                k.a((Object) resources, "mContext.resources");
                int dimensionPixelSize = resources.getDimensionPixelSize(this.D);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(this.C);
                hVar2.a(dimensionPixelSize, dimensionPixelSize2);
                cls.getSimpleName();
                q.b("resize Width =" + dimensionPixelSize + " and resize Height = " + dimensionPixelSize2);
            }
            Object obj = this.f43752i;
            if (obj != null) {
                if (k.a(obj, (Object) -1)) {
                    this.f43752i = Integer.valueOf(R.drawable.homepage_default_icon);
                }
                Object obj2 = this.f43752i;
                if (obj2 instanceof Integer) {
                    if (obj2 != null) {
                        hVar2.a(((Integer) obj2).intValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                Object obj3 = this.f43752i;
                if (obj3 instanceof Drawable) {
                    if (obj3 != null) {
                        hVar2.b((Drawable) obj3);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                    }
                }
            }
            Object obj4 = this.j;
            if (obj4 != null) {
                if (k.a(obj4, (Object) -1)) {
                    this.j = Integer.valueOf(R.drawable.homepage_default_icon);
                }
                Object obj5 = this.j;
                if (obj5 instanceof Integer) {
                    if (obj5 != null) {
                        hVar2.c(((Integer) obj5).intValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                Object obj6 = this.j;
                if (obj6 instanceof Drawable) {
                    if (obj6 != null) {
                        hVar2.d((Drawable) obj6);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                    }
                }
            }
            Object obj7 = this.k;
            if (obj7 != null) {
                if (k.a(obj7, (Object) -1)) {
                    this.k = Integer.valueOf(R.drawable.homepage_default_icon);
                }
                if (this.k instanceof Integer) {
                    Object obj8 = this.j;
                    if (obj8 != null) {
                        hVar2.b(((Integer) obj8).intValue());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                if (this.k instanceof Drawable) {
                    Object obj9 = this.j;
                    if (obj9 != null) {
                        hVar2.c((Drawable) obj9);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                    }
                }
            }
            com.paytm.utility.b.b.a aVar8 = this.H;
            com.bumptech.glide.j jVar2 = null;
            Integer valueOf = aVar8 != null ? Integer.valueOf(aVar8.ordinal()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                jVar = j.f6875a;
                k.a((Object) jVar, "DiskCacheStrategy.ALL");
            } else if (valueOf != null && valueOf.intValue() == 1) {
                jVar = j.f6876b;
                k.a((Object) jVar, "DiskCacheStrategy.NONE");
            } else if (valueOf != null && valueOf.intValue() == 2) {
                jVar = j.f6877c;
                k.a((Object) jVar, "DiskCacheStrategy.DATA");
            } else if (valueOf != null && valueOf.intValue() == 3) {
                jVar = j.f6878d;
                k.a((Object) jVar, "DiskCacheStrategy.RESOURCE");
            } else {
                jVar = j.f6879e;
                k.a((Object) jVar, "DiskCacheStrategy.AUTOMATIC");
            }
            hVar2.a(jVar);
            if (this.I) {
                hVar2.a(true);
            }
            if (this.J) {
                e eVar = this.K;
                int intValue = (eVar != null ? Integer.valueOf(eVar.ordinal()) : null).intValue();
                if (intValue == 0) {
                    fVar = f.IMMEDIATE;
                } else if (intValue == 1) {
                    fVar = f.HIGH;
                } else if (intValue == 2) {
                    fVar = f.NORMAL;
                } else if (intValue != 3) {
                    fVar = f.NORMAL;
                } else {
                    fVar = f.LOW;
                }
                hVar2.a(fVar);
            }
            if (this.L) {
                d dVar = this.M;
                if ((dVar != null ? Integer.valueOf(dVar.ordinal()) : null).intValue() != 1) {
                    bVar = com.bumptech.glide.load.b.PREFER_ARGB_8888;
                } else {
                    bVar = com.bumptech.glide.load.b.PREFER_RGB_565;
                }
                hVar2.a(bVar);
            }
            String str = this.N;
            if (str != null) {
                hVar2.a((g) new com.bumptech.glide.f.d(str));
            }
            if (this.f43748e) {
                if (k.a((Object) this.E, (Object) Boolean.TRUE)) {
                    jVar2 = com.bumptech.glide.load.d.a.g.a(this.F);
                    int i3 = this.G;
                    if (i3 > 0) {
                        jVar2 = com.bumptech.glide.a.a(i3);
                    }
                }
            } else if (this.f43749f) {
                if (k.a((Object) this.E, (Object) Boolean.TRUE)) {
                    jVar2 = c.a(this.F);
                    int i4 = this.G;
                    if (i4 > 0) {
                        jVar2 = com.bumptech.glide.a.a(i4);
                    }
                }
            } else if (k.a((Object) this.E, (Object) Boolean.TRUE)) {
                jVar2 = c.a(this.F);
                int i5 = this.G;
                if (i5 > 0) {
                    jVar2 = com.bumptech.glide.a.a(i5);
                }
            }
            com.paytm.utility.b.b.b<?> bVar2 = this.Q;
            Object obj10 = this.f43746c;
            ImageView imageView = this.f43747d;
            LottieAnimationView lottieAnimationView = this.m;
            ProgressBar progressBar = this.l;
            boolean z2 = this.f43748e;
            boolean z3 = this.f43749f;
            boolean z4 = this.f43750g;
            float f2 = this.f43751h;
            String str2 = this.O;
            String str3 = this.P;
            k.c(hVar2, "requestOptions");
            if (a.f43710a != null) {
                if (z2) {
                    Context context2 = a.f43710a;
                    if (context2 == null) {
                        k.a();
                    }
                    hVar = com.bumptech.glide.b.b(context2).d();
                    k.a((Object) hVar, "Glide.with(mContext!!).asBitmap()");
                    if (z4) {
                        hVar.a(f2);
                    }
                    hVar.b((com.bumptech.glide.e.a<?>) hVar2);
                    if (jVar2 != null) {
                        if (jVar2 != null) {
                            hVar.a(jVar2);
                        } else {
                            throw new u("null cannot be cast to non-null type com.bumptech.glide.TransitionOptions<*, in android.graphics.Bitmap>");
                        }
                    }
                } else if (z3) {
                    Context context3 = a.f43710a;
                    if (context3 == null) {
                        k.a();
                    }
                    hVar = com.bumptech.glide.b.b(context3).e();
                    k.a((Object) hVar, "Glide.with(mContext!!).asGif()");
                    if (z4) {
                        hVar.a(f2);
                    }
                    hVar.b((com.bumptech.glide.e.a<?>) hVar2);
                    if (jVar2 != null) {
                        if (jVar2 != null) {
                            hVar.a(jVar2);
                        } else {
                            throw new u("null cannot be cast to non-null type com.bumptech.glide.TransitionOptions<*, in com.bumptech.glide.load.resource.gif.GifDrawable>");
                        }
                    }
                } else {
                    Context context4 = a.f43710a;
                    if (context4 == null) {
                        k.a();
                    }
                    hVar = com.bumptech.glide.b.b(context4).f();
                    k.a((Object) hVar, "Glide.with(mContext!!).asDrawable()");
                    if (z4) {
                        hVar.a(f2);
                    }
                    hVar.b((com.bumptech.glide.e.a<?>) hVar2);
                    if (jVar2 != null) {
                        if (jVar2 != null) {
                            hVar.a(jVar2);
                        } else {
                            throw new u("null cannot be cast to non-null type com.bumptech.glide.TransitionOptions<*, in android.graphics.drawable.Drawable>");
                        }
                    }
                }
                boolean z5 = false;
                if (z2) {
                    if (hVar != null) {
                        if (imageView == null ? true : z5) {
                            hVar.a(obj10).a(aVar7.a(false, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).b();
                        } else {
                            hVar.a(obj10).a(aVar7.a(true, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).a(imageView);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type com.bumptech.glide.RequestBuilder<android.graphics.Bitmap>");
                    }
                } else if (z3) {
                    if (hVar != null) {
                        if (imageView == null ? true : z5) {
                            hVar.a(obj10).a(aVar7.b(false, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).b();
                        } else {
                            hVar.a(obj10).a(aVar7.b(true, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).a(imageView);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type com.bumptech.glide.RequestBuilder<com.bumptech.glide.load.resource.gif.GifDrawable>");
                    }
                } else if (hVar != null) {
                    if (imageView == null ? true : z5) {
                        hVar.a(obj10).a(aVar7.c(false, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).b();
                    } else {
                        hVar.a(obj10).a(aVar7.c(true, bVar2, lottieAnimationView, progressBar, obj10, str2, str3)).a(imageView);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable>");
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static C0750a a(Context context) {
            k.c(context, "context");
            return new C0750a(context);
        }

        /* renamed from: com.paytm.utility.b.b$a$a  reason: collision with other inner class name */
        public static final class C0750a {
            int A;
            int B;
            int C;
            b.a D = b.a.ALL;
            public int E;
            boolean F;
            boolean G;
            public Boolean H;
            public Boolean I;
            public int J;
            public int K;
            com.paytm.utility.b.b.a L;
            public boolean M;
            String N;
            String O;
            com.paytm.utility.b.b.b<?> P;
            final Context Q;

            /* renamed from: a  reason: collision with root package name */
            public Object f43753a;

            /* renamed from: b  reason: collision with root package name */
            ImageView f43754b;

            /* renamed from: c  reason: collision with root package name */
            boolean f43755c;

            /* renamed from: d  reason: collision with root package name */
            boolean f43756d;

            /* renamed from: e  reason: collision with root package name */
            boolean f43757e;

            /* renamed from: f  reason: collision with root package name */
            float f43758f = 0.1f;

            /* renamed from: g  reason: collision with root package name */
            Object f43759g;

            /* renamed from: h  reason: collision with root package name */
            Object f43760h;

            /* renamed from: i  reason: collision with root package name */
            Object f43761i;
            ProgressBar j;
            LottieAnimationView k;
            public boolean l;
            public boolean m;
            public boolean n;
            public boolean o;
            public boolean p;
            boolean q;
            e r = e.NORMAL;
            boolean s;
            d t = d.PREFER_ARGB_8888;
            public String u;
            boolean v;
            int w;
            int x;
            boolean y;
            int z;

            public final b a(ImageView imageView) {
                return a(this, imageView, (com.paytm.utility.b.b.b) null, 2);
            }

            public C0750a(Context context) {
                k.c(context, "context");
                this.Q = context;
            }

            public final C0750a a(Object obj) {
                k.c(obj, "placeHolderDrawable");
                this.f43759g = obj;
                return this;
            }

            public final C0750a b(Object obj) {
                k.c(obj, "errorDrawable");
                this.f43760h = obj;
                return this;
            }

            public final C0750a a(e eVar) {
                k.c(eVar, "priority");
                this.q = true;
                this.r = eVar;
                return this;
            }

            public final C0750a a(d dVar) {
                k.c(dVar, "format");
                this.s = true;
                this.t = dVar;
                return this;
            }

            public final C0750a a(int i2, int i3) {
                this.v = true;
                this.w = i2;
                if (i3 > 0) {
                    this.x = i3;
                } else {
                    this.x = i2;
                }
                return this;
            }

            public final C0750a a(int i2, b.a aVar) {
                k.c(aVar, "cornerType");
                this.F = true;
                this.B = i2;
                this.C = 0;
                this.D = aVar;
                return this;
            }

            public final C0750a a(com.paytm.utility.b.b.a aVar) {
                k.c(aVar, "imageCacheType");
                this.L = aVar;
                return this;
            }

            public static /* synthetic */ b a(C0750a aVar, ImageView imageView, com.paytm.utility.b.b.b bVar, int i2) {
                if ((i2 & 1) != 0) {
                    imageView = null;
                }
                if ((i2 & 2) != 0) {
                    bVar = null;
                }
                return aVar.a(imageView, (com.paytm.utility.b.b.b<?>) bVar);
            }

            public final b a(ImageView imageView, com.paytm.utility.b.b.b<?> bVar) {
                this.f43754b = imageView;
                this.P = bVar;
                a(bVar);
                return new b(this);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
                r10 = r10.getClass();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final void a(com.paytm.utility.b.b.b<?> r10) {
                /*
                    r9 = this;
                    if (r10 == 0) goto L_0x000d
                    java.lang.Class r10 = r10.getClass()
                    if (r10 == 0) goto L_0x000d
                    java.lang.reflect.Type[] r10 = r10.getGenericInterfaces()
                    goto L_0x000e
                L_0x000d:
                    r10 = 0
                L_0x000e:
                    if (r10 == 0) goto L_0x0061
                    int r0 = r10.length
                    r1 = 0
                    r2 = 0
                L_0x0013:
                    if (r2 >= r0) goto L_0x0061
                    r3 = r10[r2]
                    boolean r4 = r3 instanceof java.lang.reflect.ParameterizedType
                    if (r4 == 0) goto L_0x005e
                    java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
                    java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
                    int r4 = r3.length
                    r5 = 0
                L_0x0023:
                    if (r5 >= r4) goto L_0x005e
                    r6 = r3[r5]
                    if (r6 == 0) goto L_0x0056
                    java.lang.Class r6 = (java.lang.Class) r6
                    java.lang.String r7 = r6.getCanonicalName()
                    java.lang.Class<android.graphics.Bitmap> r8 = android.graphics.Bitmap.class
                    java.lang.String r8 = r8.getCanonicalName()
                    boolean r7 = r7.equals(r8)
                    if (r7 == 0) goto L_0x0041
                    r6 = 1
                    r9.f43755c = r6
                    r9.f43756d = r1
                    goto L_0x0053
                L_0x0041:
                    java.lang.String r6 = r6.getCanonicalName()
                    java.lang.Class<android.graphics.drawable.Drawable> r7 = android.graphics.drawable.Drawable.class
                    java.lang.String r7 = r7.getCanonicalName()
                    boolean r6 = r6.equals(r7)
                    if (r6 == 0) goto L_0x0053
                    r9.f43755c = r1
                L_0x0053:
                    int r5 = r5 + 1
                    goto L_0x0023
                L_0x0056:
                    kotlin.u r10 = new kotlin.u
                    java.lang.String r0 = "null cannot be cast to non-null type java.lang.Class<android.graphics.Bitmap>"
                    r10.<init>(r0)
                    throw r10
                L_0x005e:
                    int r2 = r2 + 1
                    goto L_0x0013
                L_0x0061:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.b.a.C0750a.a(com.paytm.utility.b.b.b):void");
            }

            public final C0750a a(ProgressBar progressBar) {
                this.j = progressBar;
                this.k = null;
                return this;
            }

            public static /* synthetic */ C0750a a(C0750a aVar, String str) {
                aVar.N = str;
                aVar.O = null;
                return aVar;
            }
        }
    }
}
