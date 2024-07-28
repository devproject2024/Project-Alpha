package net.one97.paytm.landingpage.utils.croptool;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import net.one97.paytm.landingpage.utils.croptool.c;

final class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    final Uri f52964a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<CropImageView> f52965b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f52966c;

    /* renamed from: d  reason: collision with root package name */
    private final int f52967d;

    /* renamed from: e  reason: collision with root package name */
    private final int f52968e;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        CropImageView cropImageView;
        a aVar = (a) obj;
        if (aVar != null) {
            boolean z = false;
            if (!isCancelled() && (cropImageView = (CropImageView) this.f52965b.get()) != null) {
                z = true;
                cropImageView.f52928h = null;
                cropImageView.a();
                if (aVar.f52973e == null) {
                    cropImageView.f52922b = aVar.f52972d;
                    cropImageView.a(aVar.f52970b, 0, aVar.f52969a, aVar.f52971c, aVar.f52972d);
                }
                CropImageView.h hVar = cropImageView.f52925e;
                if (hVar != null) {
                    hVar.a(aVar.f52973e);
                }
            }
            if (!z && aVar.f52970b != null) {
                aVar.f52970b.recycle();
            }
        }
    }

    public b(CropImageView cropImageView, Uri uri) {
        this.f52964a = uri;
        this.f52965b = new WeakReference<>(cropImageView);
        this.f52966c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d2 = displayMetrics.density > 1.0f ? (double) (1.0f / displayMetrics.density) : 1.0d;
        this.f52967d = (int) (((double) displayMetrics.widthPixels) * d2);
        this.f52968e = (int) (((double) displayMetrics.heightPixels) * d2);
    }

    private a a() {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a a2 = c.a(this.f52966c, this.f52964a, this.f52967d, this.f52968e);
            if (isCancelled()) {
                return null;
            }
            c.b a3 = c.a(a2.f52981a, this.f52966c, this.f52964a);
            return new a(this.f52964a, a3.f52983a, a2.f52982b, a3.f52984b);
        } catch (Exception e2) {
            return new a(this.f52964a, e2);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f52969a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f52970b;

        /* renamed from: c  reason: collision with root package name */
        public final int f52971c;

        /* renamed from: d  reason: collision with root package name */
        public final int f52972d;

        /* renamed from: e  reason: collision with root package name */
        public final Exception f52973e;

        a(Uri uri, Bitmap bitmap, int i2, int i3) {
            this.f52969a = uri;
            this.f52970b = bitmap;
            this.f52971c = i2;
            this.f52972d = i3;
            this.f52973e = null;
        }

        a(Uri uri, Exception exc) {
            this.f52969a = uri;
            this.f52970b = null;
            this.f52971c = 0;
            this.f52972d = 0;
            this.f52973e = exc;
        }
    }
}
