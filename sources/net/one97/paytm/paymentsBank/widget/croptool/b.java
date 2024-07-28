package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;
import net.one97.paytm.paymentsBank.widget.croptool.c;

final class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    final Uri f19705a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<PBCropImageView> f19706b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f19707c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19708d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19709e;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        PBCropImageView pBCropImageView;
        a aVar = (a) obj;
        if (aVar != null) {
            boolean z = false;
            if (!isCancelled() && (pBCropImageView = (PBCropImageView) this.f19706b.get()) != null) {
                z = true;
                pBCropImageView.f19680h = null;
                pBCropImageView.a();
                if (aVar.f19714e == null) {
                    pBCropImageView.f19674b = aVar.f19713d;
                    pBCropImageView.a(aVar.f19711b, 0, aVar.f19710a, aVar.f19712c, aVar.f19713d);
                }
                PBCropImageView.h hVar = pBCropImageView.f19677e;
                if (hVar != null) {
                    hVar.a(aVar.f19714e);
                }
            }
            if (!z && aVar.f19711b != null) {
                aVar.f19711b.recycle();
            }
        }
    }

    public b(PBCropImageView pBCropImageView, Uri uri) {
        this.f19705a = uri;
        this.f19706b = new WeakReference<>(pBCropImageView);
        this.f19707c = pBCropImageView.getContext();
        DisplayMetrics displayMetrics = pBCropImageView.getResources().getDisplayMetrics();
        double d2 = displayMetrics.density > 1.0f ? (double) (1.0f / displayMetrics.density) : 1.0d;
        this.f19708d = (int) (((double) displayMetrics.widthPixels) * d2);
        this.f19709e = (int) (((double) displayMetrics.heightPixels) * d2);
    }

    private a a() {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a a2 = c.a(this.f19707c, this.f19705a, this.f19708d, this.f19709e);
            if (isCancelled()) {
                return null;
            }
            c.a(a2.f19722a, this.f19707c, this.f19705a);
            return new a(this.f19705a, a2.f19722a, a2.f19723b);
        } catch (Exception e2) {
            return new a(this.f19705a, e2);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f19710a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f19711b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19712c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19713d;

        /* renamed from: e  reason: collision with root package name */
        public final Exception f19714e;

        a(Uri uri, Bitmap bitmap, int i2) {
            this.f19710a = uri;
            this.f19711b = bitmap;
            this.f19712c = i2;
            this.f19713d = 90;
            this.f19714e = null;
        }

        a(Uri uri, Exception exc) {
            this.f19710a = uri;
            this.f19711b = null;
            this.f19712c = 0;
            this.f19713d = 0;
            this.f19714e = exc;
        }
    }
}
