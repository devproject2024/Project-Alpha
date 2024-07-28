package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.paytm.utility.t;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRIMAXDifferenceModel;

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f74658a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f74659b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f74660c;

    /* renamed from: d  reason: collision with root package name */
    private List<CJRIMAXDifferenceModel> f74661d;

    public j(Activity activity, List<CJRIMAXDifferenceModel> list, ViewPager viewPager) {
        this.f74660c = viewPager;
        this.f74661d = list;
        this.f74658a = activity;
        this.f74659b = LayoutInflater.from(activity);
    }

    public final int getCount() {
        List<CJRIMAXDifferenceModel> list = this.f74661d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f74659b.inflate(R.layout.imax_differences_pager_lyt, viewGroup, false);
        CJRIMAXDifferenceModel cJRIMAXDifferenceModel = this.f74661d.get(i2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imax_difference_pager_img);
        TextView textView = (TextView) inflate.findViewById(R.id.content_desc_title);
        String differenceImageUrl = cJRIMAXDifferenceModel.getDifferenceImageUrl();
        if (differenceImageUrl != null) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f74658a, R.drawable.android_movie_placeholder_bg);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            t.a(differenceImageUrl, 4, b2, b2, imageView, true);
        }
        if (!TextUtils.isEmpty(cJRIMAXDifferenceModel.getDifferenceName())) {
            textView.setIncludeFontPadding(false);
            textView.setText(cJRIMAXDifferenceModel.getDifferenceName().toUpperCase());
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
