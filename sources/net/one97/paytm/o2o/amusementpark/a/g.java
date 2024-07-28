package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.a;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.entity.amPark.CJRResourceDetailModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.e;
import net.one97.paytm.photoview.PhotoView;
import net.one97.paytm.photoview.b;

public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    e f73143a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRResourceDetailModel> f73144b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f73145c = null;

    /* renamed from: d  reason: collision with root package name */
    private Context f73146d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f73147e;

    /* renamed from: f  reason: collision with root package name */
    private PhotoView f73148f;

    public g(Context context, ArrayList<String> arrayList, ArrayList<CJRResourceDetailModel> arrayList2, e eVar) {
        this.f73147e = LayoutInflater.from(context);
        this.f73146d = context;
        this.f73144b = arrayList2;
        this.f73145c = arrayList;
        this.f73143a = eVar;
    }

    public final int getCount() {
        ArrayList<String> arrayList = this.f73145c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
        View inflate = this.f73147e.inflate(R.layout.park_gallery_item_lyt, viewGroup, false);
        ((ProgressBar) inflate.findViewById(R.id.loading)).setVisibility(8);
        this.f73148f = (PhotoView) inflate.findViewById(R.id.viewpager_image);
        String str = this.f73145c.get(i2);
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f73146d, net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg);
            t.a(net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory());
            t.a(trim, 0, b2, b2, this.f73148f);
        }
        this.f73148f.setOnPhotoTapListener(new b.d() {
            public final void a() {
                if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(g.this.f73144b.get(i2).getType())) {
                    g.this.f73143a.a(g.this.f73144b.get(i2), i2);
                }
            }
        });
        viewGroup.addView(inflate);
        return inflate;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        viewGroup.removeView(view);
    }
}
