package net.one97.paytm.o2o.movies.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.q;
import com.paytm.utility.t;
import com.squareup.picasso.af;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.x;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.g;
import net.one97.paytm.photoview.PhotoView;
import net.one97.paytm.photoview.a.f;

public final class z extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    final kotlin.g.a.b<Boolean, x> f74873a;

    /* renamed from: b  reason: collision with root package name */
    a f74874b;

    /* renamed from: c  reason: collision with root package name */
    private final List<net.one97.paytm.o2o.movies.activity.b> f74875c;

    /* renamed from: d  reason: collision with root package name */
    private final int f74876d;

    /* renamed from: e  reason: collision with root package name */
    private int f74877e;

    public interface a {
        void a(int i2);
    }

    public z(List<net.one97.paytm.o2o.movies.activity.b> list, kotlin.g.a.b<? super Boolean, x> bVar, int i2, int i3, a aVar) {
        k.c(list, "mUrlList");
        k.c(bVar, "swipeListener");
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        this.f74875c = list;
        this.f74873a = bVar;
        this.f74876d = i2;
        this.f74877e = i3;
        this.f74874b = aVar;
    }

    public final int getCount() {
        return this.f74875c.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        k.c(view, "view");
        k.c(obj, "obj");
        return k.a((Object) view, obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f74876d, viewGroup, false);
        k.a((Object) inflate, "this");
        ((PhotoView) inflate.findViewById(R.id.viewpager_image)).setOnScaleChangeListener(new b(inflate, this, i2, viewGroup));
        inflate.setTag(Integer.valueOf(i2));
        x.e eVar = new x.e();
        eVar.element = (net.one97.paytm.o2o.movies.activity.b) this.f74875c.get(i2);
        ((PhotoView) inflate.findViewById(R.id.viewpager_image)).setImageResource(R.drawable.ic_movie_portrait_placeholder);
        g a2 = g.a();
        viewGroup.getContext();
        String str = ((net.one97.paytm.o2o.movies.activity.b) eVar.element).f74223a;
        int i3 = R.drawable.ic_movie_portrait_placeholder;
        PhotoView photoView = (PhotoView) inflate.findViewById(R.id.viewpager_image);
        g.AnonymousClass1 r11 = new af((float) this.f74877e, photoView, new c(eVar, this, i2, viewGroup)) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ float f75119a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ImageView f75120b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ e f75121c;

            public final void onPrepareLoad(Drawable drawable) {
            }

            {
                this.f75119a = r2;
                this.f75120b = r3;
                this.f75121c = r4;
            }

            public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f75119a, (int) ((this.f75119a / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())));
                layoutParams.gravity = 16;
                this.f75120b.setLayoutParams(layoutParams);
                this.f75120b.setImageBitmap(bitmap);
                this.f75121c.onSuccess();
            }

            public final void onBitmapFailed(Exception exc, Drawable drawable) {
                this.f75121c.onError(exc);
            }
        };
        photoView.setTag(r11);
        if (i3 == 0 || i3 == 0) {
            w.a().a(str).a((ah) new t.b(0, 0, true)).a((af) r11);
        } else {
            w.a().a(str).a((ah) new t.b(0, 0, true)).b(i3).a(i3).a((af) r11);
        }
        viewGroup.addView(inflate);
        k.a((Object) inflate, "view");
        return inflate;
    }

    static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f74878a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f74879b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74880c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewGroup f74881d;

        b(View view, z zVar, int i2, ViewGroup viewGroup) {
            this.f74878a = view;
            this.f74879b = zVar;
            this.f74880c = i2;
            this.f74881d = viewGroup;
        }

        public final void a(float f2) {
            q.d("scaleFactor : ".concat(String.valueOf(f2)));
            this.f74879b.f74873a.invoke(Boolean.valueOf(f2 <= 1.0f));
        }
    }

    public static final class c implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f74882a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f74883b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74884c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewGroup f74885d;

        public final void onError(Exception exc) {
            k.c(exc, "e");
        }

        c(x.e eVar, z zVar, int i2, ViewGroup viewGroup) {
            this.f74882a = eVar;
            this.f74883b = zVar;
            this.f74884c = i2;
            this.f74885d = viewGroup;
        }

        public final void onSuccess() {
            ((net.one97.paytm.o2o.movies.activity.b) this.f74882a.element).f74224b = true;
            this.f74883b.f74874b.a(this.f74884c);
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "data");
        viewGroup.removeView((View) obj);
    }
}
