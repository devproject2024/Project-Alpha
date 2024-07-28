package com.travel.train.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.travel.train.activity.AJRAppWebView;
import com.travel.train.model.CJRTrainSearchInput;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f27597a;

    /* renamed from: b  reason: collision with root package name */
    Activity f27598b;

    /* renamed from: c  reason: collision with root package name */
    Context f27599c = this.f27598b.getApplicationContext();

    /* renamed from: d  reason: collision with root package name */
    TextView f27600d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainSearchInput f27601e;

    public q(Activity activity, TextView textView, CJRTrainSearchInput cJRTrainSearchInput) {
        this.f27598b = activity;
        this.f27597a = textView.getText().toString().trim();
        this.f27600d = textView;
        this.f27600d.setOnClickListener(this);
        this.f27601e = cJRTrainSearchInput;
    }

    public final void onClick(View view) {
        if (this.f27597a.equalsIgnoreCase(SDKConstants.GA_KEY_T_N_C)) {
            o.a("train_traveller_details", this.f27601e.getmSourceCityName(), this.f27601e.getmDestCityName(), this.f27601e.getmDate(), (String) null, (String) null, (String) null, "free_travel_insurance_clicked", "/trains/traveller-details", this.f27598b, (Map<String, Object>) null);
            Intent intent = new Intent(this.f27598b, AJRAppWebView.class);
            intent.putExtra("url", "https://s3-ap-southeast-1.amazonaws.com/travel-trains/terms-conditions/v1/insurance_tnc.html");
            intent.putExtra("show_title", true);
            this.f27598b.startActivity(intent);
        }
    }
}
