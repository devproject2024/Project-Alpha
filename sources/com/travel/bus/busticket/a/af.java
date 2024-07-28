package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.travel.bus.R;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.busticket.CJRBusTransactionModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class af extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21587a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRBusTransactionModel> f21588b;

    public af(Context context, List<CJRBusTransactionModel> list) {
        k.c(context, "context");
        k.c(list, "transactionList");
        this.f21587a = context;
        this.f21588b = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRBusTransactionModel cJRBusTransactionModel = this.f21588b.get(i2);
        if (cJRBusTransactionModel != null) {
            CharSequence message = cJRBusTransactionModel.getMessage();
            boolean z = true;
            if (!(message == null || message.length() == 0)) {
                aVar.f21593e.setVisibility(0);
                aVar.f21594f.setText(cJRBusTransactionModel.getMessage());
            }
            CharSequence rrn = cJRBusTransactionModel.getRrn();
            if (!(rrn == null || rrn.length() == 0)) {
                aVar.f21595g.setVisibility(0);
                aVar.f21596h.setText(cJRBusTransactionModel.getRrn());
            }
            CharSequence refundAmount = cJRBusTransactionModel.getRefundAmount();
            if (!(refundAmount == null || refundAmount.length() == 0)) {
                aVar.f21590b.setText(v.a(this.f21587a.getString(R.string.rs_symbol), " ", String.valueOf((int) Double.parseDouble(cJRBusTransactionModel.getRefundAmount()))));
            }
            CharSequence issuingBankName = cJRBusTransactionModel.getIssuingBankName();
            if (!(issuingBankName == null || issuingBankName.length() == 0)) {
                aVar.f21589a.setText(this.f21587a.getString(R.string.bus_order_summary_refund_to, new Object[]{cJRBusTransactionModel.getIssuingBankName()}));
            } else {
                aVar.f21597i.setVisibility(0);
                CharSequence payMethod = cJRBusTransactionModel.getPayMethod();
                if ((payMethod == null || payMethod.length() == 0) || !p.a(cJRBusTransactionModel.getPayMethod(), "BALANCE", true)) {
                    CharSequence paymentMode = cJRBusTransactionModel.getPaymentMode();
                    if ((paymentMode == null || paymentMode.length() == 0) || !p.a(cJRBusTransactionModel.getPaymentMode(), "BALANCE", true)) {
                        CharSequence paymentMode2 = cJRBusTransactionModel.getPaymentMode();
                        if ((paymentMode2 == null || paymentMode2.length() == 0) || !p.a(cJRBusTransactionModel.getPaymentMode(), "UPI", true)) {
                            aVar.f21597i.setVisibility(8);
                        } else {
                            aVar.f21589a.setText(this.f21587a.getString(R.string.bus_order_summary_refund_to, new Object[]{"UPI"}));
                        }
                    } else {
                        aVar.f21589a.setText(this.f21587a.getString(R.string.bus_order_summary_refund_to, new Object[]{SDKConstants.AI_KEY_WALLET}));
                    }
                } else {
                    aVar.f21589a.setText(this.f21587a.getString(R.string.bus_order_summary_refund_to, new Object[]{SDKConstants.AI_KEY_WALLET}));
                }
            }
            CharSequence maskedBankAccountNumber = cJRBusTransactionModel.getMaskedBankAccountNumber();
            if (maskedBankAccountNumber == null || maskedBankAccountNumber.length() == 0) {
                CharSequence maskedCardNumber = cJRBusTransactionModel.getMaskedCardNumber();
                if (!(maskedCardNumber == null || maskedCardNumber.length() == 0)) {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            aVar.f21591c.setVisibility(0);
            aVar.f21592d.setText(cJRBusTransactionModel.getMaskedBankAccountNumber() != null ? cJRBusTransactionModel.getMaskedBankAccountNumber() : cJRBusTransactionModel.getMaskedCardNumber());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f21587a).inflate(R.layout.pre_b_refund_breakup_model_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f21588b.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f21589a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f21590b;

        /* renamed from: c  reason: collision with root package name */
        final LinearLayout f21591c;

        /* renamed from: d  reason: collision with root package name */
        final RoboTextView f21592d;

        /* renamed from: e  reason: collision with root package name */
        final LinearLayout f21593e;

        /* renamed from: f  reason: collision with root package name */
        final RoboTextView f21594f;

        /* renamed from: g  reason: collision with root package name */
        final LinearLayout f21595g;

        /* renamed from: h  reason: collision with root package name */
        final RoboTextView f21596h;

        /* renamed from: i  reason: collision with root package name */
        final LinearLayout f21597i;
        private final LinearLayout j;
        private final RoboTextView k;
        private final LinearLayout l;
        private final RoboTextView m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.heading_text);
            k.a((Object) findViewById, "itemView.findViewById(R.id.heading_text)");
            this.f21589a = (RoboTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.heading_value);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.heading_value)");
            this.f21590b = (RoboTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.acc_no_layout);
            k.a((Object) findViewById3, "itemView.findViewById(R.id.acc_no_layout)");
            this.f21591c = (LinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.acc_no);
            k.a((Object) findViewById4, "itemView.findViewById(R.id.acc_no)");
            this.f21592d = (RoboTextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.name_layout);
            k.a((Object) findViewById5, "itemView.findViewById(R.id.name_layout)");
            this.j = (LinearLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.name);
            k.a((Object) findViewById6, "itemView.findViewById(R.id.name)");
            this.k = (RoboTextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.status_layout);
            k.a((Object) findViewById7, "itemView.findViewById(R.id.status_layout)");
            this.f21593e = (LinearLayout) findViewById7;
            View findViewById8 = view.findViewById(R.id.status);
            k.a((Object) findViewById8, "itemView.findViewById(R.id.status)");
            this.f21594f = (RoboTextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.expected_date_layout);
            k.a((Object) findViewById9, "itemView.findViewById(R.id.expected_date_layout)");
            this.l = (LinearLayout) findViewById9;
            View findViewById10 = view.findViewById(R.id.expected_date);
            k.a((Object) findViewById10, "itemView.findViewById(R.id.expected_date)");
            this.m = (RoboTextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.ref_no_layout);
            k.a((Object) findViewById11, "itemView.findViewById(R.id.ref_no_layout)");
            this.f21595g = (LinearLayout) findViewById11;
            View findViewById12 = view.findViewById(R.id.ref_no);
            k.a((Object) findViewById12, "itemView.findViewById(R.id.ref_no)");
            this.f21596h = (RoboTextView) findViewById12;
            View findViewById13 = view.findViewById(R.id.ll_refund_view);
            k.a((Object) findViewById13, "itemView.findViewById(R.id.ll_refund_view)");
            this.f21597i = (LinearLayout) findViewById13;
        }
    }
}
