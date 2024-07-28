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
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;

public final class m extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22179a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22180b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22181c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22182d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22183e;

    public m(View view) {
        super(view);
        this.f22179a = (ImageView) view.findViewById(R.id.filterAmenityIcon);
        this.f22180b = (TextView) view.findViewById(R.id.amenityLable);
        this.f22181c = (RelativeLayout) view.findViewById(R.id.amenityFilterItem);
        this.f22182d = (ImageView) view.findViewById(R.id.tickMark);
        this.f22183e = (TextView) view.findViewById(R.id.amenityCount);
    }

    public final void a(Context context, CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo) {
        String str;
        if (cJRBusSearchOperatorTagInfo.isSelected()) {
            str = b(cJRBusSearchOperatorTagInfo, "");
            a(context);
        } else {
            str = a(cJRBusSearchOperatorTagInfo, "");
            b(context);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f22179a.setVisibility(0);
            a(context, str);
            return;
        }
        this.f22179a.setVisibility(8);
    }

    private void a(Context context) {
        this.f22182d.setImageResource(R.drawable.travel_res_bus_filter_blue_tick);
        this.f22180b.setTextColor(context.getResources().getColor(R.color.color_222222));
        this.f22183e.setTextColor(context.getResources().getColor(R.color.color_222222));
        this.f22181c.setBackgroundResource(R.drawable.travel_res_bus_bg_selector_filter_tag_select);
    }

    private void b(Context context) {
        this.f22182d.setImageResource(R.drawable.travel_res_bus_filter_grey_tick);
        this.f22180b.setTextColor(context.getResources().getColor(R.color.color_999999));
        this.f22183e.setTextColor(context.getResources().getColor(R.color.color_999999));
        this.f22181c.setBackgroundResource(R.drawable.travel_res_bus_bg_selector_filter_tag);
    }

    private static String a(CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo, String str) {
        return cJRBusSearchOperatorTagInfo.getIcon() != null ? cJRBusSearchOperatorTagInfo.getIcon() : str;
    }

    private static String b(CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo, String str) {
        return cJRBusSearchOperatorTagInfo.getIcon() != null ? cJRBusSearchOperatorTagInfo.getIcon() : str;
    }

    private void a(Context context, String str) {
        if (URLUtil.isValidUrl(str)) {
            b.a.C0750a a2 = b.a(context);
            a2.f43753a = str;
            a2.m = true;
            b.a.C0750a.a(a2, this.f22179a, (com.paytm.utility.b.b.b) null, 2);
        }
    }
}
