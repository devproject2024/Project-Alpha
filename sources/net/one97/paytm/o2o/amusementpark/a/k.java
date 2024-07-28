package net.one97.paytm.o2o.amusementpark.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.a;
import com.paytm.utility.b;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.e;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    e.d f73200a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRHomePageItem> f73201b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f73202c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f73203d;

    public k(Context context, ArrayList<CJRHomePageItem> arrayList, e.d dVar) {
        this.f73203d = LayoutInflater.from(context);
        this.f73202c = context;
        this.f73201b = arrayList;
        this.f73200a = dVar;
    }

    public final int getCount() {
        ArrayList<CJRHomePageItem> arrayList = this.f73201b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
        View inflate = this.f73203d.inflate(R.layout.park_store_item_lyt, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.viewpager_image);
        int a2 = b.a((Activity) this.f73202c);
        int dimensionPixelSize = this.f73202c.getResources().getDimensionPixelSize(R.dimen.park_store_img_height);
        CJRHomePageItem cJRHomePageItem = this.f73201b.get(i2);
        this.f73202c.getApplicationContext();
        String a3 = b.a(cJRHomePageItem.getImageUrl(), a2, dimensionPixelSize);
        if (cJRHomePageItem != null && !TextUtils.isEmpty(a3) && URLUtil.isValidUrl(a3)) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f73202c, net.one97.paytm.common.assets.R.drawable.android_amusement_park_placeholder_bg);
            t.a(net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory());
            t.a(a3, b2, b2, imageView, a2, dimensionPixelSize);
        }
        viewGroup.addView(inflate);
        inflate.setTag(cJRHomePageItem);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (k.this.f73200a != null) {
                    k.this.f73200a.a((CJRHomePageItem) view.getTag(), i2, "-C1");
                }
            }
        });
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
