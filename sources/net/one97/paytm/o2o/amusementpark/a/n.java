package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.a;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.utility.t;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRResourceDetailModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.e;

public final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    List<CJRResourceDetailModel> f73244a = null;

    /* renamed from: b  reason: collision with root package name */
    e f73245b;

    /* renamed from: c  reason: collision with root package name */
    boolean f73246c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f73247d;

    /* renamed from: e  reason: collision with root package name */
    private Context f73248e;

    /* renamed from: f  reason: collision with root package name */
    private int f73249f;

    /* renamed from: g  reason: collision with root package name */
    private int f73250g;

    public n(List<CJRResourceDetailModel> list, e eVar, int i2, int i3, boolean z, Context context) {
        this.f73244a = list;
        this.f73245b = eVar;
        this.f73249f = i2;
        this.f73250g = i3;
        this.f73246c = z;
        this.f73248e = context;
    }

    public final int getCount() {
        List<CJRResourceDetailModel> list = this.f73244a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == ((RelativeLayout) obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
        this.f73247d = (LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater");
        View inflate = this.f73247d.inflate(R.layout.park_banner_row, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_bannerImage);
        String value1 = this.f73244a.get(i2).getValue1();
        if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(this.f73244a.get(i2).getType())) {
            value1 = this.f73244a.get(i2).getImage();
        }
        Drawable b2 = androidx.appcompat.a.a.a.b(this.f73248e, net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg);
        t.a(this.f73246c);
        t.a(value1, b2, b2, imageView, this.f73249f, this.f73250g);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (n.this.f73245b != null) {
                    n.this.f73245b.a(n.this.f73244a.get(i2), i2);
                }
            }
        });
        viewGroup.addView(inflate);
        return inflate;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((RelativeLayout) obj);
    }
}
