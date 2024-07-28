package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.utility.StringUtility;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.k;
import java.util.ArrayList;

public final class y extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f25241a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f25242b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25243c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f25244d;

    /* renamed from: e  reason: collision with root package name */
    private k f25245e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f25246f;

    public y(Activity activity, View view, k kVar) {
        super(view);
        this.f25242b = activity;
        this.f25243c = (TextView) view.findViewById(R.id.teams_heading);
        this.f25246f = (LinearLayout) view.findViewById(R.id.lv_important_container);
        this.f25244d = (TextView) view.findViewById(R.id.tv_important_info);
        this.f25245e = kVar;
    }

    public final void a(boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = this.f25241a;
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    sb.append(this.f25241a.get(0));
                    sb.append(StringUtility.NEW_LINE);
                } else {
                    for (int i2 = 0; i2 < this.f25241a.size(); i2++) {
                        sb.append("•   " + this.f25241a.get(i2));
                        sb.append(StringUtility.NEW_LINE);
                    }
                }
            }
            this.f25244d.setText(sb);
            return;
        }
        this.f25246f.setVisibility(8);
    }
}
