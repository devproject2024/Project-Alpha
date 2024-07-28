package com.travel.flight.flightticket.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.flighthomepage.CJRFlightHomepageRequestFilterResponse;
import com.travel.flight.utils.h;
import d.a.a.c;
import java.util.List;
import net.one97.paytm.i.g;

public class d extends g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRFlightHomepageRequestFilterResponse.IJROnward f24866a;

    public static d a(CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse, CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataModel", cJRFlightHomepageRequestFilterResponse);
        if (iJROnward != null) {
            bundle.putSerializable("selected_options", iJROnward);
        }
        dVar.setArguments(bundle);
        return dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.pre_f_flight_white_bg_with_corner_radius);
        View inflate = layoutInflater.inflate(R.layout.pre_f_fragment_flight_home_page_options, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.option_selected_doneaction);
        try {
            final CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse = (CJRFlightHomepageRequestFilterResponse) getArguments().getSerializable("dataModel");
            this.f24866a = (CJRFlightHomepageRequestFilterResponse.IJROnward) getArguments().getSerializable("selected_options");
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    h.b bVar = new h.b();
                    CJRFlightHomepageRequestFilterResponse cJRFlightHomepageRequestFilterResponse = cJRFlightHomepageRequestFilterResponse;
                    if (cJRFlightHomepageRequestFilterResponse == null || cJRFlightHomepageRequestFilterResponse.getBody() == null) {
                        bVar.f25587a = true;
                    } else if (cJRFlightHomepageRequestFilterResponse.getBody().getReturnJourny() != null) {
                        bVar.f25587a = false;
                    } else {
                        bVar.f25587a = true;
                    }
                    bVar.f25588b = true;
                    bVar.f25589c = d.this.f24866a;
                    c.a().c(bVar);
                    d.this.dismiss();
                }
            });
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.flight_homepage_search_option_rv);
            if (!(cJRFlightHomepageRequestFilterResponse.getBody() == null || cJRFlightHomepageRequestFilterResponse.getBody().getOnward() == null)) {
                final List<CJRFlightHomepageRequestFilterResponse.IJROnward> onward = cJRFlightHomepageRequestFilterResponse.getBody().getOnward();
                CJRFlightHomepageRequestFilterResponse.IJROnward iJROnward = this.f24866a;
                if (onward != null) {
                    int i2 = 0;
                    for (CJRFlightHomepageRequestFilterResponse.IJROnward next : onward) {
                        View inflate2 = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.pre_f_homepage_flight_option_dialog_row, linearLayout, false);
                        CheckBox checkBox = (CheckBox) inflate2.findViewById(R.id.flight_search_options_row_radiobtn);
                        TextView textView = (TextView) inflate2.findViewById(R.id.flight_search_options_row_message);
                        TextView textView2 = (TextView) inflate2.findViewById(R.id.flight_search_options_row_type);
                        String header = next.getHeader();
                        String message = next.getMessage();
                        if (!TextUtils.isEmpty(header)) {
                            textView2.setText(header);
                        }
                        if (!TextUtils.isEmpty(message)) {
                            textView.setText(message);
                        }
                        inflate2.setTag(Integer.valueOf(i2));
                        checkBox.setTag(Integer.valueOf(i2));
                        if (iJROnward != null && header.equalsIgnoreCase(iJROnward.getHeader())) {
                            checkBox.setChecked(true);
                        }
                        inflate2.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                Object tag = view.getTag();
                                if (tag instanceof Integer) {
                                    CJRFlightHomepageRequestFilterResponse.IJROnward unused = d.this.f24866a = d.a(linearLayout, ((Integer) tag).intValue(), onward);
                                }
                            }
                        });
                        checkBox.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                Object tag = view.getTag();
                                if (tag instanceof Integer) {
                                    CJRFlightHomepageRequestFilterResponse.IJROnward unused = d.this.f24866a = d.a(linearLayout, ((Integer) tag).intValue(), onward);
                                }
                            }
                        });
                        linearLayout.addView(inflate2);
                        i2++;
                    }
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return inflate;
    }

    static /* synthetic */ CJRFlightHomepageRequestFilterResponse.IJROnward a(LinearLayout linearLayout, int i2, List list) {
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3).findViewById(R.id.flight_search_options_row_radiobtn);
            if (i3 != i2) {
                checkBox.setChecked(false);
                checkBox.invalidate();
            } else {
                checkBox.setChecked(true);
                checkBox.invalidate();
            }
        }
        return (CJRFlightHomepageRequestFilterResponse.IJROnward) list.get(i2);
    }
}
