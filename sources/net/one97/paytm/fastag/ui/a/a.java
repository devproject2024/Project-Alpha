package net.one97.paytm.fastag.ui.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import easypay.manager.Constants;
import java.util.Iterator;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderSummaryPayment;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends RecyclerView.a<C0188a> {

    /* renamed from: a  reason: collision with root package name */
    private CJROrderSummary f13796a;

    /* renamed from: b  reason: collision with root package name */
    private double f13797b = 0.0d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0188a aVar = (C0188a) vVar;
        CJROrderSummary cJROrderSummary = this.f13796a;
        if (cJROrderSummary != null && (aVar instanceof C0188a) && cJROrderSummary.getPaymentInfo() != null && this.f13796a.getPaymentInfo().size() > 0) {
            CJROrderSummaryPayment cJROrderSummaryPayment = this.f13796a.getPaymentInfo().get(i2);
            if (!TextUtils.isEmpty(a(cJROrderSummaryPayment))) {
                aVar.f13802e.setVisibility(0);
                TextView textView = aVar.f13800c;
                textView.setText(a(cJROrderSummaryPayment));
                if (cJROrderSummaryPayment.getPgAmount() > 0.0d) {
                    TextView textView2 = aVar.f13799b;
                    textView2.setText("₹ " + h.b(Double.valueOf(cJROrderSummaryPayment.getPgAmount())));
                }
                if (cJROrderSummaryPayment == null || TextUtils.isEmpty(cJROrderSummaryPayment.getBankTransactionId())) {
                    aVar.f13798a.setVisibility(8);
                    return;
                }
                aVar.f13798a.setVisibility(0);
                TextView textView3 = aVar.f13798a;
                textView3.setText("Transaction ID: " + cJROrderSummaryPayment.getBankTransactionId());
                return;
            }
            aVar.f13802e.setVisibility(8);
        }
    }

    public a(CJROrderSummary cJROrderSummary) {
        this.f13796a = cJROrderSummary;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null) {
            Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                this.f13797b += it2.next().getTotalCashBack();
            }
        }
    }

    public final int getItemCount() {
        if (this.f13796a.getPaymentInfo() != null) {
            return this.f13796a.getPaymentInfo().size();
        }
        return 0;
    }

    public final int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public final long getItemId(int i2) {
        return super.getItemId(i2);
    }

    private static String a(CJROrderSummaryPayment cJROrderSummaryPayment) {
        String str;
        if (TextUtils.isEmpty(cJROrderSummaryPayment.getPaymentMethod())) {
            str = null;
        } else if (cJROrderSummaryPayment.getPaymentMethod().equalsIgnoreCase("Paytm Cash")) {
            str = "Paytm Wallet";
        } else if (cJROrderSummaryPayment.getPaymentMethod().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
            str = "Credit Card";
        } else if (cJROrderSummaryPayment.getPaymentMethod().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
            str = "Debit Card";
        } else {
            str = cJROrderSummaryPayment.getPaymentMethod().equalsIgnoreCase("NB") ? "Net Banking" : cJROrderSummaryPayment.getPaymentMethod();
        }
        if (TextUtils.isEmpty(cJROrderSummaryPayment.getPaymentBank()) || SDKConstants.AI_KEY_WALLET.equals(cJROrderSummaryPayment.getPaymentBank())) {
            return str;
        }
        return cJROrderSummaryPayment.getPaymentBank() + " " + str;
    }

    /* renamed from: net.one97.paytm.fastag.ui.a.a$a  reason: collision with other inner class name */
    public static class C0188a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f13798a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13799b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13800c;

        /* renamed from: d  reason: collision with root package name */
        LinearLayout f13801d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f13802e;

        public C0188a(View view) {
            super(view);
            this.f13802e = (LinearLayout) view.findViewById(R.id.ll_mainLayout);
            this.f13801d = (LinearLayout) view.findViewById(R.id.card_payment_layout);
            this.f13800c = (TextView) view.findViewById(R.id.tv_payment_type_card);
            this.f13799b = (TextView) view.findViewById(R.id.tv_card_amount);
            this.f13798a = (TextView) view.findViewById(R.id.tv_card_transaction_id);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0188a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ft_payment_breakup, viewGroup, false));
    }
}
