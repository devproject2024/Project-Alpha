package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;
import net.one97.paytm.paymentsBank.widget.croptool.c;

final class a extends AsyncTask<Void, Void, C0349a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<PBCropImageView> f19691a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f19692b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f19693c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f19694d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f19695e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19696f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19697g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19698h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f19699i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final boolean n;
    private final boolean o;
    private final PBCropImageView.i p;
    private final Uri q;
    private final Bitmap.CompressFormat r;
    private final int s;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        C0349a aVar = (C0349a) obj;
        if (aVar != null) {
            boolean z = false;
            if (!isCancelled()) {
                PBCropImageView pBCropImageView = (PBCropImageView) this.f19691a.get();
                if (pBCropImageView != null) {
                    pBCropImageView.f19681i = null;
                    pBCropImageView.a();
                    PBCropImageView.d dVar = pBCropImageView.f19678f;
                    if (dVar != null) {
                        PBCropImageView.a aVar2 = r5;
                        PBCropImageView.a aVar3 = new PBCropImageView.a(pBCropImageView.f19673a, pBCropImageView.f19679g, aVar.f19700a, aVar.f19701b, aVar.f19702c, pBCropImageView.getCropPoints(), pBCropImageView.getCropRect(), pBCropImageView.getWholeImageRect(), pBCropImageView.getRotatedDegrees(), aVar.f19704e);
                        dVar.a(aVar2);
                    }
                    z = true;
                }
            }
            if (!z && aVar.f19700a != null) {
                aVar.f19700a.recycle();
                return;
            }
            return;
        }
    }

    a(PBCropImageView pBCropImageView, Bitmap bitmap, float[] fArr, int i2, boolean z, int i3, int i4, int i5, int i6, boolean z2, boolean z3, PBCropImageView.i iVar, Uri uri, Bitmap.CompressFormat compressFormat, int i7) {
        PBCropImageView pBCropImageView2 = pBCropImageView;
        this.f19691a = new WeakReference<>(pBCropImageView);
        this.f19694d = pBCropImageView.getContext();
        this.f19692b = bitmap;
        this.f19695e = fArr;
        this.f19693c = null;
        this.f19696f = i2;
        this.f19699i = z;
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
        this.f19697g = 0;
        this.f19698h = 0;
    }

    a(PBCropImageView pBCropImageView, Uri uri, float[] fArr, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, boolean z2, boolean z3, PBCropImageView.i iVar, Uri uri2, Bitmap.CompressFormat compressFormat, int i9) {
        PBCropImageView pBCropImageView2 = pBCropImageView;
        this.f19691a = new WeakReference<>(pBCropImageView);
        this.f19694d = pBCropImageView.getContext();
        this.f19693c = uri;
        this.f19695e = fArr;
        this.f19696f = i2;
        this.f19699i = z;
        this.j = i5;
        this.k = i6;
        this.f19697g = i3;
        this.f19698h = i4;
        this.l = i7;
        this.m = i8;
        this.n = z2;
        this.o = z3;
        this.p = iVar;
        this.q = uri2;
        this.r = compressFormat;
        this.s = i9;
        this.f19692b = null;
    }

    private C0349a a() {
        c.a aVar;
        boolean z = true;
        try {
            if (isCancelled()) {
                return null;
            }
            if (this.f19693c != null) {
                aVar = c.a(this.f19694d, this.f19693c, this.f19695e, this.f19696f, this.f19697g, this.f19698h, this.f19699i, this.j, this.k, this.l, this.m, this.n, this.o);
            } else if (this.f19692b == null) {
                return new C0349a((Bitmap) null, 1);
            } else {
                aVar = c.a(this.f19692b, this.f19695e, this.f19696f, this.f19699i, this.j, this.k, this.n, this.o);
            }
            Bitmap a2 = c.a(aVar.f19722a, this.l, this.m, this.p);
            if (this.q == null) {
                return new C0349a(a2, aVar.f19723b);
            }
            c.a(this.f19694d, a2, this.q, this.r, this.s);
            if (a2 != null) {
                a2.recycle();
            }
            return new C0349a(this.q, aVar.f19723b);
        } catch (Exception e2) {
            if (this.q == null) {
                z = false;
            }
            return new C0349a(e2, z);
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.widget.croptool.a$a  reason: collision with other inner class name */
    static final class C0349a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f19700a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f19701b;

        /* renamed from: c  reason: collision with root package name */
        final Exception f19702c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f19703d;

        /* renamed from: e  reason: collision with root package name */
        final int f19704e;

        C0349a(Bitmap bitmap, int i2) {
            this.f19700a = bitmap;
            this.f19701b = null;
            this.f19702c = null;
            this.f19703d = false;
            this.f19704e = i2;
        }

        C0349a(Uri uri, int i2) {
            this.f19700a = null;
            this.f19701b = uri;
            this.f19702c = null;
            this.f19703d = true;
            this.f19704e = i2;
        }

        C0349a(Exception exc, boolean z) {
            this.f19700a = null;
            this.f19701b = null;
            this.f19702c = exc;
            this.f19703d = z;
            this.f19704e = 1;
        }
    }
}
