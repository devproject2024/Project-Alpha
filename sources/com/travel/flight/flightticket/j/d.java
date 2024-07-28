package com.travel.flight.flightticket.j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem;

public final class d extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    h f25129a;

    /* renamed from: b  reason: collision with root package name */
    private CheckBox f25130b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25131c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f25132d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f25133e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public k f25134f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f25135g;

    /* renamed from: h  reason: collision with root package name */
    private Context f25136h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f25137i;
    private Boolean j = null;

    public final void onClick(View view) {
    }

    public d(Context context, View view, CJRCancelProtectInsuranceItem cJRCancelProtectInsuranceItem, h hVar, boolean z) {
        super(view);
        CheckBox checkBox;
        this.f25136h = context;
        this.f25130b = (CheckBox) view.findViewById(R.id.flight_cancelation_protect_checkbox);
        this.f25131c = (TextView) view.findViewById(R.id.flight_cancel_insurance_title);
        this.f25132d = (TextView) view.findViewById(R.id.flight_insurance_details_msg);
        this.f25133e = (TextView) view.findViewById(R.id.flight_insurance_tooltip_msg);
        this.f25135g = (ImageView) view.findViewById(R.id.flight_cancel_protect_insurance_benefits_image);
        this.f25137i = (RelativeLayout) view.findViewById(R.id.relative_cancel_protect_tooltip);
        this.f25129a = hVar;
        view.findViewById(R.id.top_divider).setVisibility(0);
        view.findViewById(R.id.bottom_divider).setVisibility(8);
        this.j = Boolean.valueOf(z);
        this.f25131c.setText(cJRCancelProtectInsuranceItem.getAddonType());
        String reviewDisplayText = cJRCancelProtectInsuranceItem.getReviewDisplayText();
        SpannableString spannableString = new SpannableString(reviewDisplayText + " T&C ");
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                if (d.this.f25134f != null) {
                    d.this.f25134f.reviewIternaryActionClick("", (Intent) null, (Boolean) null, c.CANCEL_PROTECT_TnC);
                }
                if (d.this.f25129a != null) {
                    d.this.f25129a.a((Boolean) null, c.CANCEL_PROTECT_TnC);
                }
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(Color.parseColor("#00baf2"));
                textPaint.setUnderlineText(false);
            }
        }, reviewDisplayText.length(), reviewDisplayText.length() + 4, 0);
        this.f25132d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f25132d.setText(spannableString);
        if (!TextUtils.isEmpty(cJRCancelProtectInsuranceItem.getToolTip())) {
            this.f25133e.setText(cJRCancelProtectInsuranceItem.getToolTip());
        } else {
            this.f25137i.setVisibility(8);
        }
        String icon = cJRCancelProtectInsuranceItem.getIcon();
        if (icon == null || !URLUtil.isValidUrl(icon)) {
            ImageView imageView = this.f25135g;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.f25135g;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            b.a.C0750a a2 = b.a(this.f25136h);
            a2.f43753a = icon;
            a2.a(this.f25135g);
        }
        Boolean bool = this.j;
        if (bool != null) {
            CheckBox checkBox2 = this.f25130b;
            if (checkBox2 != null) {
                checkBox2.setChecked(bool.booleanValue());
            }
        } else if (!cJRCancelProtectInsuranceItem.isOptIn() && (checkBox = this.f25130b) != null) {
            checkBox.setChecked(true);
        }
        this.f25130b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (d.this.f25134f != null) {
                    d.this.f25134f.reviewIternaryActionClick("", (Intent) null, Boolean.valueOf(z), c.CANCEL_PROTECT_INSURANCE_CHECKBOX);
                }
                if (d.this.f25129a != null) {
                    d.this.f25129a.a(Boolean.valueOf(z), c.CANCEL_PROTECT_INSURANCE_CHECKBOX);
                }
            }
        });
    }
}
