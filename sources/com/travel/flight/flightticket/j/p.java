package com.travel.flight.flightticket.j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.CustomTypefaceSpan;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.span.TopAlignProportionalSpan;
import com.travel.flight.travellerProfile.a;
import com.travel.flight.travellerProfile.model.CJRTpUserProfileBody;

public final class p extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public k f25190a;

    /* renamed from: b  reason: collision with root package name */
    public View f25191b;

    /* renamed from: c  reason: collision with root package name */
    public RadioButton f25192c;

    /* renamed from: d  reason: collision with root package name */
    public RadioButton f25193d;

    /* renamed from: e  reason: collision with root package name */
    public CJRFlightDetails f25194e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f25195f;

    public p(Context context, View view, k kVar, CJRFlightDetails cJRFlightDetails) {
        super(view);
        this.f25195f = context;
        this.f25194e = cJRFlightDetails;
        this.f25190a = kVar;
        this.f25191b = view;
    }

    public final void onClick(View view) {
        if ((view.getId() == R.id.opt_out_radio_button || view.getId() == R.id.opt_out_lyt) && this.f25190a != null) {
            this.f25193d.setChecked(false);
            this.f25192c.setChecked(true);
            this.f25190a.reviewIternaryActionClick("", (Intent) null, Boolean.FALSE, c.CANCEL_PROTECT_INSURANCE_CHECKBOX);
        } else if ((view.getId() == R.id.opt_in_radio_button || view.getId() == R.id.opt_in_lyt) && this.f25190a != null) {
            this.f25193d.setChecked(true);
            this.f25192c.setChecked(false);
            this.f25190a.reviewIternaryActionClick("", (Intent) null, Boolean.TRUE, c.CANCEL_PROTECT_INSURANCE_CHECKBOX);
        }
    }

    public static Boolean a() {
        CJRTpUserProfileBody cJRTpUserProfileBody = a.a().f25522a;
        if (cJRTpUserProfileBody == null || cJRTpUserProfileBody.isCancellationInsurance() == null) {
            return null;
        }
        return cJRTpUserProfileBody.isCancellationInsurance();
    }

    public static void a(TextView textView, String str, String str2) {
        int color = textView.getContext().getResources().getColor(R.color.color_000000);
        String format = String.format(textView.getResources().getString(R.string.raw_refund_amount), new Object[]{str, str2});
        int lastIndexOf = format.lastIndexOf(textView.getResources().getString(R.string.rupee_symbol));
        SpannableString spannableString = new SpannableString(format);
        Typeface create = Typeface.create("sans-serif-medium", 0);
        spannableString.setSpan(new ForegroundColorSpan(color), (format.length() - str2.length()) - 1, format.length(), 33);
        spannableString.setSpan(new CustomTypefaceSpan("", create), (format.length() - str2.length()) - 1, format.length(), 33);
        spannableString.setSpan(new TopAlignProportionalSpan(0.75f), lastIndexOf, lastIndexOf + 1, 33);
        textView.setText(spannableString);
    }
}
