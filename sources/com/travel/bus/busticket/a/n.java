package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.a;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.pojo.photos.CJRBusPhoto;
import java.util.ArrayList;

public final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRBusPhoto> f21715a;

    /* renamed from: b  reason: collision with root package name */
    private Context f21716b;

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public n(Context context, ArrayList<CJRBusPhoto> arrayList) {
        this.f21715a = arrayList;
        this.f21716b = context;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f21716b).inflate(R.layout.layout_bus_photo_view, viewGroup, false);
        String photo = this.f21715a.get(i2).getPhoto();
        b.a.C0750a a2 = b.a(this.f21716b);
        a2.f43753a = photo;
        b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon)), (ImageView) viewGroup2.findViewById(R.id.ivPhoto), (com.paytm.utility.b.b.b) null, 2);
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.f21715a.size();
    }
}
