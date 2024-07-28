package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.t;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ad;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesV2;

public final class k extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f74662a;

    /* renamed from: b  reason: collision with root package name */
    List<CJRMoviesV2> f74663b;

    /* renamed from: c  reason: collision with root package name */
    public a f74664c;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f74665d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f74666e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f74667f = true;

    public interface a {
        void a(IJRDataModel iJRDataModel);
    }

    public k(Activity activity, List<CJRMoviesV2> list, ViewPager viewPager) {
        this.f74662a = viewPager;
        this.f74663b = list;
        this.f74665d = activity;
        this.f74666e = LayoutInflater.from(activity);
        if (activity instanceof ad.a) {
            this.f74664c = (a) activity;
        }
    }

    public final int getCount() {
        List<CJRMoviesV2> list = this.f74663b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f74666e.inflate(R.layout.imax_movies_pager_lyt, viewGroup, false);
        CJRMoviesV2 cJRMoviesV2 = this.f74663b.get(i2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imax_movie_pager_img);
        String imaxImgUrl = cJRMoviesV2.getImaxImgUrl();
        if (imaxImgUrl != null) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f74665d, R.drawable.android_movie_placeholder_bg);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            t.a(imaxImgUrl, 4, b2, b2, imageView, true);
        }
        ((TextView) inflate.findViewById(R.id.imax_movie_pager_txt)).setText(cJRMoviesV2.getDisplay());
        Button button = (Button) inflate.findViewById(R.id.imax_pager_button);
        if (this.f74667f) {
            button.setVisibility(0);
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k kVar = k.this;
                    if (kVar.f74664c != null) {
                        kVar.f74662a.getCurrentItem();
                        kVar.f74664c.a(kVar.f74663b.get(kVar.f74662a.getCurrentItem()));
                    }
                }
            });
        } else {
            button.setVisibility(8);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        view.setOnClickListener((View.OnClickListener) null);
        view.removeCallbacks((Runnable) null);
        viewGroup.removeView(view);
    }
}
