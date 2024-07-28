package net.one97.paytm.landingpage.utils.croptool;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import net.one97.paytm.landingpage.utils.croptool.c;

final class a extends AsyncTask<Void, Void, C0944a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CropImageView> f52950a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f52951b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f52952c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f52953d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f52954e;

    /* renamed from: f  reason: collision with root package name */
    private final int f52955f;

    /* renamed from: g  reason: collision with root package name */
    private final int f52956g;

    /* renamed from: h  reason: collision with root package name */
    private final int f52957h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f52958i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final boolean n;
    private final boolean o;
    private final CropImageView.i p;
    private final Uri q;
    private final Bitmap.CompressFormat r;
    private final int s;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        C0944a aVar = (C0944a) obj;
        if (aVar != null) {
            boolean z = false;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.f52950a.get();
                if (cropImageView != null) {
                    cropImageView.f52929i = null;
                    cropImageView.a();
                    CropImageView.d dVar = cropImageView.f52926f;
                    if (dVar != null) {
                        CropImageView.a aVar2 = r5;
                        CropImageView.a aVar3 = new CropImageView.a(cropImageView.f52921a, cropImageView.f52927g, aVar.f52959a, aVar.f52960b, aVar.f52961c, cropImageView.getCropPoints(), cropImageView.getCropRect(), cropImageView.getWholeImageRect(), cropImageView.getRotatedDegrees(), aVar.f52963e);
                        dVar.a(aVar2);
                    }
                    z = true;
                }
            }
            if (!z && aVar.f52959a != null) {
                aVar.f52959a.recycle();
                return;
            }
            return;
        }
    }

    a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i2, boolean z, int i3, int i4, int i5, int i6, boolean z2, boolean z3, CropImageView.i iVar, Uri uri, Bitmap.CompressFormat compressFormat, int i7) {
        CropImageView cropImageView2 = cropImageView;
        this.f52950a = new WeakReference<>(cropImageView);
        this.f52953d = cropImageView.getContext();
        this.f52951b = bitmap;
        this.f52954e = fArr;
        this.f52952c = null;
        this.f52955f = i2;
        this.f52958i = z;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = z2;
        this.o = z3;
        this.p = iVar;
        this.q = uri;
        this.r = compressFormat;
        this.s = i7;
        this.f52956g = 0;
        this.f52957h = 0;
    }

    a(CropImageView cropImageView, Uri uri, float[] fArr, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, boolean z2, boolean z3, CropImageView.i iVar, Uri uri2, Bitmap.CompressFormat compressFormat, int i9) {
        CropImageView cropImageView2 = cropImageView;
        this.f52950a = new WeakReference<>(cropImageView);
        this.f52953d = cropImageView.getContext();
        this.f52952c = uri;
        this.f52954e = fArr;
        this.f52955f = i2;
        this.f52958i = z;
        this.j = i5;
        this.k = i6;
        this.f52956g = i3;
        this.f52957h = i4;
        this.l = i7;
        this.m = i8;
        this.n = z2;
        this.o = z3;
        this.p = iVar;
        this.q = uri2;
        this.r = compressFormat;
        this.s = i9;
        this.f52951b = null;
    }

    private C0944a a() {
        c.a aVar;
        boolean z = true;
        try {
            if (isCancelled()) {
                return null;
            }
            if (this.f52952c != null) {
                aVar = c.a(this.f52953d, this.f52952c, this.f52954e, this.f52955f, this.f52956g, this.f52957h, this.f52958i, this.j, this.k, this.l, this.m, this.n, this.o);
            } else if (this.f52951b == null) {
                return new C0944a((Bitmap) null, 1);
            } else {
                aVar = c.a(this.f52951b, this.f52954e, this.f52955f, this.f52958i, this.j, this.k, this.n, this.o);
            }
            Bitmap a2 = c.a(aVar.f52981a, this.l, this.m, this.p);
            if (this.q == null) {
                return new C0944a(a2, aVar.f52982b);
            }
            c.a(this.f52953d, a2, this.q, this.r, this.s);
            if (a2 != null) {
                a2.recycle();
            }
            return new C0944a(this.q, aVar.f52982b);
        } catch (Exception e2) {
            if (this.q == null) {
                z = false;
            }
            return new C0944a(e2, z);
        }
    }

    /* renamed from: net.one97.paytm.landingpage.utils.croptool.a$a  reason: collision with other inner class name */
    static final class C0944a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f52959a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f52960b;

        /* renamed from: c  reason: collision with root package name */
        final Exception f52961c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f52962d;

        /* renamed from: e  reason: collision with root package name */
        final int f52963e;

        C0944a(Bitmap bitmap, int i2) {
            this.f52959a = bitmap;
            this.f52960b = null;
            this.f52961c = null;
            this.f52962d = false;
            this.f52963e = i2;
        }

        C0944a(Uri uri, int i2) {
            this.f52959a = null;
            this.f52960b = uri;
            this.f52961c = null;
            this.f52962d = true;
            this.f52963e = i2;
        }

        C0944a(Exception exc, boolean z) {
            this.f52959a = null;
            this.f52960b = null;
            this.f52961c = exc;
            this.f52962d = z;
            this.f52963e = 1;
        }
    }
}
