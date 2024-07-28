package net.one97.paytm.fastag.dependencies;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.model.CJRCashback;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.model.CJRRefund;

public class g extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private CJROrderedCart f13691a = null;

    public g(CJROrderedCart cJROrderedCart) {
        this.f13691a = cJROrderedCart;
    }

    public g() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lyt_item_detail_refund_detail_ft, viewGroup);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setWindowAnimations(R.style.CustomAnimations_slide_in);
        getDialog().getWindow().getAttributes().gravity = 87;
        TextView textView = (TextView) inflate.findViewById(R.id.paid_amount);
        inflate.findViewById(R.id.lifafa_amount);
        TextView textView2 = (TextView) inflate.findViewById(R.id.total_refund_amount);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.cashback_credited_layout);
        TextView textView3 = (TextView) inflate.findViewById(R.id.cashback_credited_text);
        TextView textView4 = (TextView) inflate.findViewById(R.id.cashback_amount);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.goldback_layout);
        TextView textView5 = (TextView) inflate.findViewById(R.id.goldback_credited_text);
        TextView textView6 = (TextView) inflate.findViewById(R.id.goldback_amount);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.lifafa_cashback_layout);
        TextView textView7 = (TextView) inflate.findViewById(R.id.lifafa_cashback_text);
        TextView textView8 = (TextView) inflate.findViewById(R.id.lifafa_amount);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.lifafa_goldback_layout);
        TextView textView9 = (TextView) inflate.findViewById(R.id.total_refund_desc_text);
        TextView textView10 = (TextView) inflate.findViewById(R.id.lifafa_goldback_amount);
        TextView textView11 = (TextView) inflate.findViewById(R.id.lifafa_goldback_text);
        View view = inflate;
        inflate.findViewById(R.id.close_icon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.getDialog().dismiss();
            }
        });
        CJROrderedCart cJROrderedCart = this.f13691a;
        if (cJROrderedCart != null) {
            double subTotal = cJROrderedCart.getSubTotal();
            String shippingCharge = this.f13691a.getShippingCharge();
            int parseInt = !TextUtils.isEmpty(shippingCharge) ? Integer.parseInt(shippingCharge) : 0;
            this.f13691a.getTotalCashBack();
            double creditedCashBack = this.f13691a.getCreditedCashBack();
            double refundAmount = this.f13691a.getRefundAmount();
            this.f13691a.getLifafaCashBack();
            TextView textView12 = textView10;
            StringBuilder sb = new StringBuilder("₹ ");
            LinearLayout linearLayout5 = linearLayout4;
            LinearLayout linearLayout6 = linearLayout3;
            TextView textView13 = textView7;
            TextView textView14 = textView8;
            sb.append(String.format("%.2f", new Object[]{Double.valueOf(subTotal + ((double) parseInt))}));
            textView.setText(String.valueOf(sb.toString()));
            textView2.setText(String.valueOf("₹ " + String.format("%.2f", new Object[]{Double.valueOf(refundAmount)})));
            textView4.setText(String.valueOf("₹ " + String.format("%.2f", new Object[]{Double.valueOf(creditedCashBack)})));
            linearLayout.setVisibility(0);
            ArrayList<CJRCashback> lifafaCashbackModle = this.f13691a.getLifafaCashbackModle();
            if (lifafaCashbackModle != null) {
                try {
                    if (lifafaCashbackModle.get(0) != null) {
                        a(lifafaCashbackModle.get(0), linearLayout, textView3, textView4);
                    }
                    if (lifafaCashbackModle.get(1) != null) {
                        a(lifafaCashbackModle.get(1), linearLayout2, textView5, textView6);
                    }
                    if (lifafaCashbackModle.get(2) != null) {
                        a(lifafaCashbackModle.get(2), linearLayout6, textView13, textView14);
                    }
                    if (lifafaCashbackModle.get(3) != null) {
                        a(lifafaCashbackModle.get(3), linearLayout5, textView11, textView12);
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            CJRRefund refund = this.f13691a.getRefund();
            if (refund != null) {
                String status_text = refund.getStatus_text();
                if (!TextUtils.isEmpty(status_text)) {
                    textView9.setText(status_text);
                } else {
                    textView9.setVisibility(8);
                }
            }
        }
        return view;
    }

    private static void a(CJRCashback cJRCashback, LinearLayout linearLayout, TextView textView, TextView textView2) {
        if (cJRCashback != null) {
            linearLayout.setVisibility(0);
            textView.setText(cJRCashback.getCashbackText());
            textView2.setText(String.valueOf("- ₹ " + String.format("%.2f", new Object[]{Double.valueOf(cJRCashback.getCashBackAmount())})));
            return;
        }
        linearLayout.setVisibility(8);
    }
}
