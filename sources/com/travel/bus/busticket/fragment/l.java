package com.travel.bus.busticket.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.play.core.splitcompat.a;
import com.travel.bus.R;
import com.travel.bus.busticket.activity.AJRBusTravellerDetailsActivity;
import com.travel.bus.busticket.f.h;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import net.one97.paytm.i.f;

public class l extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private h f22297a;

    /* renamed from: b  reason: collision with root package name */
    private String f22298b = "";

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AJRBusTravellerDetailsActivity) {
            this.f22297a = (h) context;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        a.b((Context) getActivity());
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bus_sold_out_error_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.sold_out_error_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sold_out_error_message);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sold_out_change_bus);
        ResourceUtils.loadBusImagesFromCDN((ImageView) inflate.findViewById(R.id.bus_sold_out_error_image), "sold_out_image_revamp.png", false, false, n.a.V1);
        textView3.setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.image_view_close_options)).setOnClickListener(this);
        if (getArguments() != null && getArguments().containsKey("bus_sold_out_title")) {
            textView.setText(getArguments().getString("bus_sold_out_title"));
        }
        if (getArguments() != null && getArguments().containsKey("bus_sold_out_message")) {
            textView2.setText(getArguments().getString("bus_sold_out_message"));
        }
        if (getArguments() != null && getArguments().containsKey("bus_sold_out_button_txt")) {
            this.f22298b = getArguments().getString("bus_sold_out_button_txt");
            textView3.setText(this.f22298b);
        }
        return inflate;
    }

    public void onClick(View view) {
        h hVar;
        if (this.f22298b.equalsIgnoreCase("Okay") || view.getId() == R.id.image_view_close_options) {
            dismiss();
        } else if (view.getId() == R.id.sold_out_change_bus && (hVar = this.f22297a) != null) {
            hVar.a();
        }
    }
}
