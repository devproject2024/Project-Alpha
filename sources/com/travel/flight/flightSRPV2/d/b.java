package com.travel.flight.flightSRPV2.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.a;
import kotlin.g.b.k;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f24177a = new b();

    private b() {
    }

    public static <T extends ViewDataBinding> T a(int i2, ViewGroup viewGroup) {
        int i3;
        k.c(viewGroup, "parent");
        switch (i2) {
            case 1:
                i3 = R.layout.pre_f_row_srp_header;
                break;
            case 2:
                i3 = R.layout.pre_f_item_flight_search_list_revamp2;
                break;
            case 3:
                i3 = R.layout.pre_f_item_flight_child_search_list_revamp2;
                break;
            case 4:
                i3 = R.layout.pre_f_item_flight_search_banner;
                break;
            case 5:
            case 6:
                i3 = R.layout.pre_f_item_flight_search_time_filter;
                break;
            case 7:
                i3 = R.layout.pre_f_item_flight_search_duration;
                break;
            case 8:
                i3 = R.layout.pre_f_item_flight_search_airline_filter;
                break;
            case 9:
                i3 = R.layout.pre_f_item_flight_search_price_filter;
                break;
            case 10:
                i3 = R.layout.flight_list_item_airline_price_strip;
                break;
            case 11:
                i3 = R.layout.pre_f_blank_space;
                break;
            case 12:
                i3 = R.layout.pre_f_filter_list_strip;
                break;
            default:
                throw new IllegalArgumentException("Unknown view type passed to SRPOneWayViewFactory");
        }
        T a2 = f.a(LayoutInflater.from(viewGroup.getContext()), i3, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        if (i2 == 5) {
            a2.setVariable(a.l, Boolean.TRUE);
        } else if (i2 == 6) {
            a2.setVariable(a.l, Boolean.FALSE);
        }
        if (a2 != null) {
            return a2;
        }
        throw new u("null cannot be cast to non-null type T");
    }
}
