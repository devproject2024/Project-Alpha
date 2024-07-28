package com.travel.flight.utils;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.flight.flightSRPV2.view.ui.a.i;
import com.travel.flight.flightSRPV2.view.ui.a.k;
import com.travel.flight.pojo.Header;
import com.travel.flight.pojo.Item;
import com.travel.flight.pojo.PaymentDetail;
import java.util.List;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f25603a = new m();

    private m() {
    }

    public static final void a(TextView textView, Header header) {
        if (header != null && textView != null) {
            textView.setText(header.getTitle() + " " + header.getDesc());
        }
    }

    public static final void a(RecyclerView recyclerView, List<Item> list) {
        if (recyclerView != null && (!list.isEmpty())) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(new k(list));
        }
    }

    public static final void a(TextView textView, Integer num) {
        if (textView != null && num != null) {
            int intValue = num.intValue();
            textView.setText("₹ " + b.S(String.valueOf(intValue)));
        }
    }

    public static final void b(RecyclerView recyclerView, List<PaymentDetail> list) {
        if (recyclerView != null && list != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(new i(list));
        }
    }

    public static final void a(TextView textView, Boolean bool) {
        if (textView != null) {
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                textView.setTypeface(textView.getTypeface(), 1);
            }
        }
    }
}
