package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.CustomTypefaceSpan;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.i.b;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainDisplayName;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainOrderFareCollapse;
import com.travel.train.model.trainticket.CJRTrainOrderPayment;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryBody;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import com.travel.train.model.trainticket.CJRTrainValue;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class as extends RecyclerView.v implements b {

    /* renamed from: a  reason: collision with root package name */
    Context f27858a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainSummaryItem f27859b;

    /* renamed from: c  reason: collision with root package name */
    ab f27860c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f27861d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f27862e;

    /* renamed from: f  reason: collision with root package name */
    TextView f27863f;

    /* renamed from: g  reason: collision with root package name */
    CJRTrainOrderFareCollapse f27864g;

    /* renamed from: h  reason: collision with root package name */
    private String f27865h = "Plain";

    /* renamed from: i  reason: collision with root package name */
    private String f27866i = "Heading";
    private String j = "Padded";
    private String k = "Left";
    private String l = "Transaction ID #";
    private ArrayList<CJRTrainFareDetail> m;
    private ArrayList<CJRTrainOrderPayment> n;
    private CJRTrainOrderSummaryBody o;

    public as(View view, ab abVar) {
        super(view);
        this.f27860c = abVar;
        this.f27861d = (LinearLayout) view.findViewById(R.id.fare_detail_container);
        this.f27862e = (LinearLayout) view.findViewById(R.id.payment_detail_container);
        this.f27863f = (TextView) view.findViewById(R.id.show_more);
        this.f27863f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                as.this.f27864g.setShowMoreClicked(true);
                as.this.f27861d.removeAllViews();
                as.this.f27862e.removeAllViews();
                as.this.f27863f.setVisibility(8);
                as.this.a();
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.f27858a = context;
        this.f27859b = (CJRTrainSummaryItem) iJRDataModel;
        this.o = (CJRTrainOrderSummaryBody) this.f27859b.getItem();
        CJRTrainOrderSummaryBody cJRTrainOrderSummaryBody = this.o;
        if (!(cJRTrainOrderSummaryBody == null || cJRTrainOrderSummaryBody.getFareCollapse() == null)) {
            this.f27864g = this.o.getFareCollapse();
        }
        if (!this.f27864g.isShowMoreClicked()) {
            this.f27861d.removeAllViews();
            this.f27862e.removeAllViews();
            CJRTrainOrderFareCollapse cJRTrainOrderFareCollapse = this.f27864g;
            if (cJRTrainOrderFareCollapse == null || !cJRTrainOrderFareCollapse.ismEnabled()) {
                this.f27863f.setVisibility(8);
                a();
                return;
            }
            this.f27863f.setVisibility(0);
            this.f27861d.removeAllViews();
            this.f27862e.removeAllViews();
            this.f27863f.setText(this.f27864g.getmText());
            CJRTrainOrderSummaryBody cJRTrainOrderSummaryBody2 = this.o;
            if (cJRTrainOrderSummaryBody2 != null && cJRTrainOrderSummaryBody2.getFareDetails() != null) {
                ArrayList<CJRTrainFareDetail> fareDetails = this.o.getFareDetails();
                this.f27861d.setVisibility(0);
                for (int i3 = 0; i3 <= 2; i3++) {
                    a(fareDetails.get(i3), i3, (ViewGroup) this.f27861d);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        CJRTrainOrderSummaryBody cJRTrainOrderSummaryBody = this.o;
        if (!(cJRTrainOrderSummaryBody == null || cJRTrainOrderSummaryBody.getFareDetails() == null)) {
            this.m = this.o.getFareDetails();
            this.f27861d.setVisibility(0);
            b();
        }
        CJRTrainOrderSummaryBody cJRTrainOrderSummaryBody2 = this.o;
        if (cJRTrainOrderSummaryBody2 != null && cJRTrainOrderSummaryBody2.getPayments() != null) {
            this.n = this.o.getPayments();
            this.f27862e.setVisibility(0);
            c();
        }
    }

    private void b() {
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            CJRTrainFareDetail cJRTrainFareDetail = this.m.get(i2);
            if (cJRTrainFareDetail != null && cJRTrainFareDetail.getVisibility()) {
                a(cJRTrainFareDetail, i2, (ViewGroup) this.f27861d);
            }
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, int i2, ViewGroup viewGroup) {
        CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail;
        View inflate = LayoutInflater.from(this.f27858a).inflate(R.layout.pre_t_lyt_train_fare_detail_item, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.fare_details_layout);
        TextView textView = (TextView) inflate.findViewById(R.id.fare_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fare_value);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sub_title);
        View findViewById = inflate.findViewById(R.id.v_left_empty_view);
        View findViewById2 = inflate.findViewById(R.id.bottom_separator_line);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.plus_symbol);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lv_child_container);
        if (cJRTrainFareDetail.getType().equalsIgnoreCase(this.f27865h) || cJRTrainFareDetail.getType().equalsIgnoreCase(this.f27866i) || cJRTrainFareDetail.getType().equalsIgnoreCase(this.j)) {
            findViewById2.setVisibility(8);
            relativeLayout.setVisibility(0);
            a(cJRTrainFareDetail2, textView, textView3, findViewById);
            a(cJRTrainFareDetail2, textView2);
            a(cJRTrainFareDetail2, imageView, linearLayout);
        } else {
            findViewById2.setVisibility(0);
            relativeLayout.setVisibility(8);
        }
        viewGroup.addView(inflate, i2);
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView, TextView textView2, View view) {
        SpannableStringBuilder spannableStringBuilder;
        if (cJRTrainFareDetail != null) {
            List<CJRTrainDisplayName> displayName = cJRTrainFareDetail.getDisplayName();
            if (cJRTrainFareDetail.getType().equalsIgnoreCase(this.j)) {
                view.setVisibility(0);
                textView.setTextSize(2, 12.0f);
            } else {
                view.setVisibility(8);
                textView.setTextSize(2, 13.0f);
            }
            if (displayName != null) {
                textView.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder2;
                for (int i2 = 0; i2 < displayName.size(); i2++) {
                    CJRTrainDisplayName cJRTrainDisplayName = displayName.get(i2);
                    if (!TextUtils.isEmpty(cJRTrainDisplayName.getText())) {
                        if (cJRTrainDisplayName.getAlignment().equalsIgnoreCase(this.k)) {
                            if (spannableStringBuilder4.length() == 0) {
                                spannableStringBuilder = a(spannableStringBuilder4, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), cJRTrainDisplayName.getTextColor(), 0);
                            } else {
                                spannableStringBuilder = a(spannableStringBuilder4, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), cJRTrainDisplayName.getTextColor(), spannableStringBuilder4.length());
                            }
                            spannableStringBuilder4 = spannableStringBuilder;
                        } else {
                            textView2.setVisibility(0);
                            if (spannableStringBuilder3.length() == 0) {
                                spannableStringBuilder3 = a(spannableStringBuilder3, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), cJRTrainDisplayName.getTextColor(), 0);
                            } else {
                                spannableStringBuilder3 = a(spannableStringBuilder3, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), cJRTrainDisplayName.getTextColor(), spannableStringBuilder4.length());
                            }
                        }
                    }
                }
                textView.setText(spannableStringBuilder4);
                textView2.setText(spannableStringBuilder3);
            }
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView) {
        List<CJRTrainValue> value;
        SpannableStringBuilder spannableStringBuilder;
        if (cJRTrainFareDetail != null && (value = cJRTrainFareDetail.getValue()) != null) {
            textView.setVisibility(0);
            int size = value.size();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                CJRTrainValue cJRTrainValue = value.get(i2);
                if (cJRTrainValue != null && !TextUtils.isEmpty(cJRTrainValue.getText())) {
                    if (i2 == 0) {
                        spannableStringBuilder = a(spannableStringBuilder2, cJRTrainValue.getText(), cJRTrainValue.getTextType(), cJRTrainValue.getTextColor(), 0);
                    } else {
                        spannableStringBuilder = a(spannableStringBuilder2, cJRTrainValue.getText(), cJRTrainValue.getTextType(), cJRTrainValue.getTextColor(), spannableStringBuilder2.length());
                    }
                    spannableStringBuilder2 = spannableStringBuilder;
                }
            }
            textView.setText(spannableStringBuilder2);
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, final ImageView imageView, final LinearLayout linearLayout) {
        if (cJRTrainFareDetail != null) {
            if (cJRTrainFareDetail.getChildList() == null || cJRTrainFareDetail.getChildList().size() <= 0) {
                imageView.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                linearLayout.setVisibility(0);
                for (int i2 = 0; i2 < cJRTrainFareDetail.getChildList().size(); i2++) {
                    CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail.getChildList().get(i2);
                    if (cJRTrainFareDetail2 != null) {
                        a(cJRTrainFareDetail2, i2, (ViewGroup) linearLayout);
                    }
                }
                linearLayout.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (linearLayout.getVisibility() == 0) {
                        linearLayout.setVisibility(8);
                        imageView.setImageDrawable(as.this.f27858a.getResources().getDrawable(R.drawable.sqaure_plus_thin));
                        return;
                    }
                    linearLayout.setVisibility(0);
                    imageView.setImageDrawable(as.this.f27858a.getResources().getDrawable(R.drawable.sqaure_minus_thin));
                }
            });
        }
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, String str, String str2, String str3, int i2) {
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append(str);
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 2076325) {
                if (hashCode == 2141079518 && str2.equals("Greyed")) {
                    c2 = 1;
                }
            } else if (str2.equals("Bold")) {
                c2 = 0;
            }
            if (c2 == 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(o.a(this.f27858a, str3, R.color.black)), i2, spannableStringBuilder.length(), 0);
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, spannableStringBuilder.length(), 0);
                spannableStringBuilder.setSpan(new CustomTypefaceSpan("sans-serif-mediam", Typeface.SANS_SERIF), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(1.1f), i2, spannableStringBuilder.length(), 33);
            } else if (c2 != 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(o.a(this.f27858a, str3, R.color.color_666666)), i2, spannableStringBuilder.length(), 0);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(o.a(this.f27858a, str3, R.color.full_name_color)), i2, spannableStringBuilder.length(), 0);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(1.0f), i2, spannableStringBuilder.length(), 0);
            }
        }
        return spannableStringBuilder;
    }

    private void c() {
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            CJRTrainOrderPayment cJRTrainOrderPayment = this.n.get(i2);
            if (cJRTrainOrderPayment != null) {
                a(cJRTrainOrderPayment, i2, this.n.size());
            }
        }
    }

    private void a(CJRTrainOrderPayment cJRTrainOrderPayment, int i2, int i3) {
        int i4 = i2;
        View inflate = LayoutInflater.from(this.f27858a).inflate(R.layout.pre_t_train_order_refund_item_layout, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.account_details_container);
        TextView textView = (TextView) inflate.findViewById(R.id.fare_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fare_value);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sub_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.refund_expected_date);
        TextView textView5 = (TextView) inflate.findViewById(R.id.account_card_details);
        TextView textView6 = (TextView) inflate.findViewById(R.id.reference_details);
        TextView textView7 = (TextView) inflate.findViewById(R.id.refund_msg);
        TextView textView8 = (TextView) inflate.findViewById(R.id.view_passbook);
        View findViewById = inflate.findViewById(R.id.center_view);
        View findViewById2 = inflate.findViewById(R.id.under_line);
        ((RelativeLayout) inflate.findViewById(R.id.fare_details_layout)).setVisibility(0);
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getSource())) {
            textView.setVisibility(0);
            textView.setText(cJRTrainOrderPayment.getSource());
        }
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getAmount())) {
            textView2.setVisibility(0);
            textView2.setText(cJRTrainOrderPayment.getAmount());
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getDate())) {
            textView3.setVisibility(0);
            sb.append(cJRTrainOrderPayment.getDate());
        }
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getTransactionId())) {
            textView3.setVisibility(0);
            sb.append(" | ");
            sb.append(this.l);
            sb.append(cJRTrainOrderPayment.getTransactionId());
        }
        textView3.setText(sb);
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getExpectedDate()) || !TextUtils.isEmpty(cJRTrainOrderPayment.getMaskedNumber()) || !TextUtils.isEmpty(cJRTrainOrderPayment.getReferenceNumber())) {
            linearLayout.setVisibility(0);
            if (!TextUtils.isEmpty(cJRTrainOrderPayment.getExpectedDate())) {
                textView4.setVisibility(0);
                textView4.setText(cJRTrainOrderPayment.getExpectedDate());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPayment.getMaskedNumber())) {
                textView5.setVisibility(0);
                textView5.setText(cJRTrainOrderPayment.getMaskedNumber());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPayment.getReferenceNumber())) {
                textView6.setVisibility(0);
                textView6.setText(cJRTrainOrderPayment.getReferenceNumber());
            }
        } else {
            linearLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(cJRTrainOrderPayment.getText())) {
            textView7.setVisibility(0);
            textView7.setText(cJRTrainOrderPayment.getText());
        }
        if (cJRTrainOrderPayment.isShowPassbook()) {
            findViewById.setVisibility(0);
            textView8.setVisibility(0);
        }
        if (i4 == i3 - 1) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        textView8.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                as.this.f27860c.a(as.this.f27859b, ah.VIEW_PASSBOOK_CLICK);
            }
        });
        this.f27862e.addView(inflate, i4);
    }
}
