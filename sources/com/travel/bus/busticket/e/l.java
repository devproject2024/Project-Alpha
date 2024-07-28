package com.travel.bus.busticket.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;

public final class l extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22174a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22175b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22176c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22177d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22178e;

    public l(View view) {
        super(view);
        this.f22174a = (ImageView) view.findViewById(R.id.filterAmenityIcon);
        this.f22175b = (TextView) view.findViewById(R.id.amenityLable);
        this.f22176c = (RelativeLayout) view.findViewById(R.id.amenityFilterItem);
        this.f22177d = (ImageView) view.findViewById(R.id.tickMark);
        this.f22175b = (TextView) view.findViewById(R.id.amenityLable);
        this.f22178e = (TextView) view.findViewById(R.id.amenityCount);
    }

    public final void a(Context context, CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo) {
        String str;
        if (cJRBusSearchAmenitiesInfo.isSelected()) {
            str = cJRBusSearchAmenitiesInfo.getIconSelected();
            this.f22177d.setImageResource(R.drawable.travel_res_bus_filter_blue_tick);
            this.f22175b.setTextColor(context.getResources().getColor(R.color.color_222222));
            this.f22178e.setTextColor(context.getResources().getColor(R.color.color_222222));
        } else {
            str = cJRBusSearchAmenitiesInfo.getIcon();
            this.f22177d.setImageResource(R.drawable.travel_res_bus_filter_grey_tick);
            this.f22175b.setTextColor(context.getResources().getColor(R.color.color_999999));
            this.f22178e.setTextColor(context.getResources().getColor(R.color.color_999999));
        }
        if (!TextUtils.isEmpty(str) && URLUtil.isValidUrl(str)) {
            b.a.C0750a a2 = b.a(context);
            a2.f43753a = str;
            b.a.C0750a b2 = a2.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
            b2.m = true;
            b.a.C0750a.a(b2, this.f22174a, (com.paytm.utility.b.b.b) null, 2);
        }
    }
}
