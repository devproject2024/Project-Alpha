package com.travel.bus.orders.i;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.busticket.a.af;
import com.travel.bus.busticket.i.i;
import com.travel.bus.busticket.i.v;
import com.travel.bus.busticket.i.y;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.h.b;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusRefundCardDetails;
import com.travel.bus.pojo.busticket.CJRBusRefundDetails;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;

public final class e extends a {
    private TextView A;

    /* renamed from: a  reason: collision with root package name */
    Context f22672a;

    /* renamed from: b  reason: collision with root package name */
    CJRBusRefundDetails f22673b;

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f22674c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f22675d;

    /* renamed from: e  reason: collision with root package name */
    private CJRBusOrderSummary f22676e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22677f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22678g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22679h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22680i;
    private RelativeLayout j;
    private double k = 0.0d;
    private LinearLayout l;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private int p = 1;
    private int q = 2;
    private int r = 0;
    private int s = 0;
    private RecyclerView t;
    private LinearLayout u;
    private TextView v;
    private ImageView w;
    private LinearLayout x;
    private TextView y;
    private LinearLayout z;

    public e(View view, CJRBusOrderSummary cJRBusOrderSummary, CJRBusRefundDetails cJRBusRefundDetails) {
        super(view);
        this.f22676e = cJRBusOrderSummary;
        this.f22673b = cJRBusRefundDetails;
        this.f22672a = view.getContext();
        this.f22674c = (RelativeLayout) view.findViewById(R.id.total_refundable_amount_layout);
        this.l = (LinearLayout) view.findViewById(R.id.refund_details_container);
        this.f22677f = (TextView) view.findViewById(R.id.bus_cashback_already_creditied);
        this.j = (RelativeLayout) view.findViewById(R.id.cashback_lyt);
        this.f22675d = (RelativeLayout) view.findViewById(R.id.refund_processed_lyt_paytm);
        this.f22679h = (TextView) view.findViewById(R.id.refund_to_wallet);
        this.f22680i = (TextView) view.findViewById(R.id.refund_to_wallet_amount);
        this.f22678g = (TextView) view.findViewById(R.id.wallet_summary_link);
        this.t = (RecyclerView) view.findViewById(R.id.bank_account_details_recyclerview);
        this.u = (LinearLayout) view.findViewById(R.id.policy_pop_up_lyt);
        this.v = (TextView) view.findViewById(R.id.cancellation_desc_text);
        this.w = (ImageView) view.findViewById(R.id.insurance_image);
        this.x = (LinearLayout) this.itemView.findViewById(R.id.bank_offer_cashback_layout);
        this.y = (TextView) this.itemView.findViewById(R.id.paytm_bus_bank_offer_cashback_amount);
        this.z = (LinearLayout) this.itemView.findViewById(R.id.tbl_row_bank_discount);
        this.A = (TextView) this.itemView.findViewById(R.id.text_bank_discount);
        CJRBusOrderSummary cJRBusOrderSummary2 = this.f22676e;
        if (!(cJRBusOrderSummary2 == null || cJRBusOrderSummary2.getOrderedCartList() == null || this.f22676e.getOrderedCartList().isEmpty() || this.f22676e.getOrderedCartList().get(0).getBusRefundModel() == null || this.f22676e.getOrderedCartList().get(0).getBusRefundModel().getTransactionDetails() == null || this.f22676e.getOrderedCartList().get(0).getBusRefundModel().getTransactionDetails().isEmpty())) {
            this.t.setAdapter(new af(this.f22672a, this.f22676e.getOrderedCartList().get(0).getBusRefundModel().getTransactionDetails()));
            this.t.setLayoutManager(new LinearLayoutManager(this.f22672a, 1, false));
            this.t.setHasFixedSize(true);
        }
        ResourceUtils.loadBusImagesFromCDN(this.w, "insurance_success.png", false, false, n.a.V1);
        this.f22678g.setVisibility(8);
        this.f22678g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.travel.bus.a.a();
                com.travel.bus.a.b().d(e.this.f22672a, new Intent());
            }
        });
        y yVar = y.f22482a;
        y.a(CJRBusRefundDetails.class).subscribeOn(io.reactivex.rxjava3.android.b.a.a()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new w<CJRBusRefundDetails>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final /* bridge */ /* synthetic */ void onNext(Object obj) {
                e.this.f22673b = (CJRBusRefundDetails) obj;
            }

            public final void onSubscribe(c cVar) {
                v.a(cVar);
            }
        });
    }

    public final void a(c.b bVar) {
        boolean z2;
        CJRBusOrderSummary cJRBusOrderSummary = this.f22676e;
        if (cJRBusOrderSummary != null) {
            try {
                if (!this.m) {
                    if (cJRBusOrderSummary != null) {
                        if (cJRBusOrderSummary.getOrderedCartList() != null) {
                            for (int i2 = 0; i2 < this.f22676e.getOrderedCartList().size(); i2++) {
                                if (Integer.parseInt(this.f22676e.getOrderedCartList().get(i2).getItemStatus()) == 18) {
                                    this.k += this.f22676e.getOrderedCartList().get(i2).getTotalCashBack();
                                }
                            }
                            if (this.k != 0.0d) {
                                this.f22677f.setText(com.paytm.utility.v.a("-", this.f22672a.getString(R.string.rs_symbol), " ", String.valueOf(this.k)));
                            } else {
                                this.j.setVisibility(8);
                            }
                        }
                    }
                    double doubleValue = (this.f22676e.getOnwardBankCashback() == null || this.f22676e.getOnwardBankCashback().doubleValue() <= 0.0d) ? 0.0d : this.f22676e.getOnwardBankCashback().doubleValue() + 0.0d;
                    if (this.f22676e.getReturnBankCashback() != null && this.f22676e.getReturnBankCashback().doubleValue() > 0.0d) {
                        doubleValue += this.f22676e.getReturnBankCashback().doubleValue();
                    }
                    double doubleValue2 = (this.f22676e.getOnwardBankDiscount() == null || this.f22676e.getOnwardBankDiscount().doubleValue() <= 0.0d) ? 0.0d : this.f22676e.getOnwardBankDiscount().doubleValue() + 0.0d;
                    if (this.f22676e.getReturnBankDiscount() != null && this.f22676e.getReturnBankDiscount().doubleValue() > 0.0d) {
                        doubleValue2 += this.f22676e.getReturnBankDiscount().doubleValue();
                    }
                    if (doubleValue > 0.0d) {
                        this.x.setVisibility(0);
                        this.y.setText(this.f22672a.getString(R.string.rs_symbol) + " " + i.b(doubleValue));
                    } else {
                        this.x.setVisibility(8);
                    }
                    if (doubleValue2 > 0.0d) {
                        this.z.setVisibility(0);
                        this.A.setText(this.f22672a.getString(R.string.rs_symbol) + " " + i.b(doubleValue2));
                    } else {
                        this.z.setVisibility(8);
                    }
                    if (this.f22673b != null) {
                        this.m = true;
                        this.l.removeAllViews();
                        int size = (this.f22673b.getRefundCard() == null || this.f22673b.getRefundCard().getDisplayData() == null) ? 0 : this.f22673b.getRefundCard().getDisplayData().size();
                        for (int i3 = 0; i3 < size; i3++) {
                            a(this.f22673b.getRefundCard().getDisplayData().get(i3).getRefundDetails());
                        }
                    }
                }
                if (!(this.f22676e == null || this.f22676e.getOrderedCartList() == null || this.f22676e.getOrderedCartList().size() <= 0)) {
                    Iterator<CJRBusOrderedCart> it2 = this.f22676e.getOrderedCartList().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        CJRBusOrderedCart next = it2.next();
                        if (b.b(next) && Integer.parseInt(next.getItemStatus()) == 18) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        Iterator<CJRBusOrderedCart> it3 = this.f22676e.getOrderedCartList().iterator();
                        while (it3.hasNext()) {
                            CJRBusOrderedCart next2 = it3.next();
                            if (b.b(next2)) {
                                Integer.parseInt(next2.getItemStatus());
                            }
                        }
                    }
                }
                ArrayList<CJROrderSummaryPayment> paymentInfo = this.f22676e.getPaymentInfo();
                double d2 = 0.0d;
                if (paymentInfo != null) {
                    for (int i4 = 0; i4 < paymentInfo.size(); i4++) {
                        if (Objects.equals(paymentInfo.get(i4).getPgResponseCode(), "10") && paymentInfo.get(i4).getGateway() != null) {
                            this.f22679h.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.refund_to), " ", paymentInfo.get(i4).getGateway()));
                            d2 += paymentInfo.get(i4).getPgAmount();
                        }
                    }
                }
                if (d2 != 0.0d) {
                    this.f22680i.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", i.b(d2)));
                } else {
                    this.f22675d.setVisibility(8);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    private void a(List<CJRBusRefundCardDetails> list) {
        int i2;
        int i3;
        Spannable a2;
        Spannable a3;
        List<CJRBusRefundCardDetails> list2 = list;
        int size = list.size();
        CJRBusOrderSummary cJRBusOrderSummary = this.f22676e;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list2.get(i4).getLabel() != null && list2.get(i4).getData() != null) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list2.get(i4).getData().size()) {
                        break;
                    } else if (TextUtils.isEmpty(list2.get(i4).getData().get(i5).getLabel()) || !list2.get(i4).getData().get(i5).getLabel().equalsIgnoreCase(this.f22672a.getString(R.string.bus_operator_charges))) {
                        i5++;
                    } else if (list2.get(i4).getData().get(i5).getValue().contains(AppUtility.CENTER_DOT)) {
                        this.r = (int) Double.parseDouble(list2.get(i4).getData().get(i5).getValue());
                    } else {
                        this.r = Integer.parseInt(list2.get(i4).getData().get(i5).getValue());
                    }
                }
            }
        }
        if (cJRBusOrderSummary != null) {
            for (int i6 = 0; i6 < cJRBusOrderSummary.getOrderedCartList().size(); i6++) {
                if (Integer.parseInt(cJRBusOrderSummary.getOrderedCartList().get(i6).getItemStatus()) == 18) {
                    this.s = (int) (((double) this.s) + cJRBusOrderSummary.getOrderedCartList().get(i6).getTotalCashBack());
                }
            }
        }
        sparseIntArray.put(this.p, this.r);
        sparseIntArray.put(this.q, this.s);
        int i7 = 0;
        while (i7 < size) {
            if (list2.get(i7).getLabel() != null) {
                CJRBusRefundCardDetails cJRBusRefundCardDetails = list2.get(i7);
                View inflate = LayoutInflater.from(this.f22672a).inflate(R.layout.pre_b_bus_refund_details, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.display_text);
                TextView textView2 = (TextView) inflate.findViewById(R.id.display_amount);
                TextView textView3 = (TextView) inflate.findViewById(R.id.operator_cancellation_label);
                TextView textView4 = (TextView) inflate.findViewById(R.id.operator_cancellation_fare_amount);
                TextView textView5 = (TextView) inflate.findViewById(R.id.cashback_already_credited_label);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.expandable_arrow_lyt);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.cancellation_charges_lyt);
                i2 = size;
                int i8 = i7;
                TextView textView6 = (TextView) inflate.findViewById(R.id.cashback_already_credited__amount);
                ResourceUtils.loadBusImagesFromCDN((ImageView) inflate.findViewById(R.id.expandable_arrow), "arrow_up.png", false, true, n.a.V1);
                inflate.findViewById(R.id.expandable_frame_layout);
                View findViewById = inflate.findViewById(R.id.seperator);
                if (!TextUtils.isEmpty(cJRBusRefundCardDetails.getLabel()) && !TextUtils.isEmpty(cJRBusRefundCardDetails.getValue())) {
                    if (cJRBusRefundCardDetails.getLabel().toLowerCase().equalsIgnoreCase(this.f22672a.getString(R.string.refundable_amount).toLowerCase())) {
                        findViewById.setVisibility(0);
                    }
                    if (cJRBusRefundCardDetails.getTextStyle().equalsIgnoreCase(this.f22672a.getString(R.string.super_bold))) {
                        textView.setTextColor(androidx.core.content.b.c(this.f22672a, R.color.color_4a4a4a));
                        textView.setTypeface((Typeface) null, 1);
                        textView2.setTextColor(androidx.core.content.b.c(this.f22672a, R.color.color_4a4a4a));
                        textView2.setTypeface((Typeface) null, 1);
                    }
                    this.u.setVisibility(0);
                    this.v.setVisibility(0);
                    if (TextUtils.isEmpty(this.f22673b.getInsuranceText().getReturn().getTitle()) && !this.n && (a3 = a()) != null) {
                        this.v.setText(a3);
                        this.v.setMovementMethod(LinkMovementMethod.getInstance());
                        this.u.setVisibility(0);
                    }
                    if (!this.o && TextUtils.isEmpty(this.f22673b.getInsuranceText().getOnward().getTitle()) && (a2 = a()) != null) {
                        this.v.setText(a2);
                        this.v.setMovementMethod(LinkMovementMethod.getInstance());
                        this.u.setVisibility(0);
                    }
                    if (this.v.getText() != null && TextUtils.isEmpty(this.v.getText().toString().trim())) {
                        this.u.setVisibility(8);
                        this.v.setVisibility(8);
                    }
                    if (cJRBusRefundCardDetails.getLabel().toLowerCase().equalsIgnoreCase(this.f22672a.getString(R.string.total_amount_paid_order_summary).toLowerCase()) || cJRBusRefundCardDetails.getLabel().toLowerCase().equalsIgnoreCase(this.f22672a.getString(R.string.refundable_amount).toLowerCase())) {
                        textView.setText(cJRBusRefundCardDetails.getLabel());
                        if (cJRBusRefundCardDetails.getLabel().toLowerCase().equalsIgnoreCase(this.f22672a.getString(R.string.refundable_amount).toLowerCase())) {
                            relativeLayout.setVisibility(8);
                            this.f22675d.setVisibility(0);
                            textView2.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", String.valueOf((int) (Double.parseDouble(cJRBusRefundCardDetails.getValue()) - ((double) sparseIntArray.get(this.q))))));
                        } else {
                            relativeLayout.setVisibility(8);
                            textView2.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", cJRBusRefundCardDetails.getValue()));
                        }
                    } else {
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                        relativeLayout.setVisibility(8);
                    }
                }
                if (cJRBusRefundCardDetails.getLabel().toLowerCase().equalsIgnoreCase(this.f22672a.getString(R.string.total_amount_paid_order_summary).toLowerCase())) {
                    textView.setText(cJRBusRefundCardDetails.getLabel());
                    textView2.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", cJRBusRefundCardDetails.getValue()));
                    linearLayout.setVisibility(0);
                    textView3.setText(this.f22672a.getString(R.string.operator_cancellation_charges));
                    textView4.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", String.valueOf(sparseIntArray.get(this.p))));
                    textView5.setText(this.f22672a.getString(R.string.cashback_already_credited));
                    TextView textView7 = textView6;
                    textView7.setText(com.paytm.utility.v.a(this.f22672a.getString(R.string.rs_symbol), " ", String.valueOf(sparseIntArray.get(this.q))));
                } else {
                    linearLayout.setVisibility(8);
                }
                i3 = i8;
                this.l.addView(inflate, i3);
            } else {
                i2 = size;
                i3 = i7;
            }
            i7 = i3 + 1;
            size = i2;
            list2 = list;
        }
        this.f22674c.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.text.Spannable a() {
        /*
            r7 = this;
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            r1 = 0
            if (r0 == 0) goto L_0x00a9
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            if (r0 == 0) goto L_0x00a9
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r0 = r0.getOnward()
            r2 = 1
            if (r0 == 0) goto L_0x003d
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r0 = r0.getOnward()
            java.lang.String r0 = r0.getTitle()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006e
            r7.n = r2
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r0 = r0.getOnward()
            java.lang.String r0 = r0.getDescription()
            goto L_0x006f
        L_0x003d:
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusReturnTrip r0 = r0.getReturn()
            if (r0 == 0) goto L_0x006e
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r0 = r0.getOnward()
            java.lang.String r0 = r0.getTitle()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006e
            r7.o = r2
            com.travel.bus.pojo.busticket.CJRBusRefundDetails r0 = r7.f22673b
            com.travel.bus.pojo.busticket.CJRBusInsuranceText r0 = r0.getInsuranceText()
            com.travel.bus.pojo.busticket.CJRBusOnwardTrip r0 = r0.getOnward()
            java.lang.String r0 = r0.getDescription()
            goto L_0x006f
        L_0x006e:
            r0 = r1
        L_0x006f:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x00a9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r0 = 26
            java.lang.String r3 = "\""
            java.lang.StringBuilder r1 = r1.insert(r0, r3)
            java.lang.String r1 = r1.toString()
            android.text.SpannableString r3 = new android.text.SpannableString
            r3.<init>(r1)
            android.text.style.StyleSpan r4 = new android.text.style.StyleSpan
            r4.<init>(r2)
            com.travel.bus.orders.i.e$4 r2 = new com.travel.bus.orders.i.e$4
            r2.<init>()
            int r5 = r1.length()
            int r5 = r5 + -10
            int r1 = r1.length()
            r6 = 0
            r3.setSpan(r2, r5, r1, r6)
            r1 = 9
            r3.setSpan(r4, r1, r0, r6)
            r1 = r3
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.e.a():android.text.Spannable");
    }

    static /* synthetic */ void a(e eVar) {
        View inflate = ((LayoutInflater) eVar.f22672a.getSystemService("layout_inflater")).inflate(R.layout.pre_b_cancellation_pop_up, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.cancellation_desc);
        SpannableString spannableString = new SpannableString(eVar.f22672a.getString(R.string.pay_a_nominal_amount_and_get_a_guarenteed_refund_on));
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(androidx.core.content.b.c(e.this.f22672a, R.color.color_00b8f8));
                textPaint.setUnderlineText(false);
            }
        }, 102, 106, 0);
        ResourceUtils.loadBusImagesFromCDN((ImageView) inflate.findViewById(R.id.cancellation_popup_image), "cancellation_popup.png", false, false, n.a.V1);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AlertDialog.Builder builder = new AlertDialog.Builder(eVar.f22672a);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.show();
        ((TextView) inflate.findViewById(R.id.ok_got_it)).setOnClickListener(new View.OnClickListener(create) {
            private final /* synthetic */ AlertDialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
    }
}
