package com.travel.citybus.best.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.travel.citybus.R;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.i.f;

public final class h extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f23114a;

    /* renamed from: b  reason: collision with root package name */
    private String f23115b;

    /* renamed from: c  reason: collision with root package name */
    private CJROrderSummary f23116c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f23117d;

    public interface a {
        void onCancel();
    }

    private View a(int i2) {
        if (this.f23117d == null) {
            this.f23117d = new HashMap();
        }
        View view = (View) this.f23117d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23117d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f23116c = (CJROrderSummary) arguments.getSerializable("intent_extra_order_summary");
            this.f23115b = arguments.getString("extra_merchant_name");
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onAttach(Context context) {
        Window window;
        WindowManager.LayoutParams attributes;
        k.c(context, "context");
        super.onAttach(context);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.BottomSheetDialogTheme;
        }
        if (context instanceof a) {
            this.f23114a = (a) context;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_city_bus_payment_details_bottom, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList<CJROrderSummaryPayment> paymentInfo;
        ArrayList<CJRTransactionDetails> payModes;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.tvMerchantName);
        k.a((Object) textView, "tvMerchantName");
        textView.setText(this.f23115b);
        TextView textView2 = (TextView) a(R.id.pdOrderAmountTv);
        k.a((Object) textView2, "pdOrderAmountTv");
        CJROrderSummary cJROrderSummary = this.f23116c;
        textView2.setText(com.travel.citybus.best.e.b.a(String.valueOf(cJROrderSummary != null ? Double.valueOf(cJROrderSummary.getGrandTotal()) : null)));
        CJROrderSummary cJROrderSummary2 = this.f23116c;
        if (!(cJROrderSummary2 == null || (payModes = cJROrderSummary2.getPayModes()) == null || !(!payModes.isEmpty()))) {
            TextView textView3 = (TextView) a(R.id.pdModeNameTv);
            k.a((Object) textView3, "pdModeNameTv");
            CJRTransactionDetails cJRTransactionDetails = payModes.get(0);
            k.a((Object) cJRTransactionDetails, "it[0]");
            textView3.setText(cJRTransactionDetails.getPayment_mode());
            TextView textView4 = (TextView) a(R.id.pdEPurseOrderAmountTv);
            k.a((Object) textView4, "pdEPurseOrderAmountTv");
            CJRTransactionDetails cJRTransactionDetails2 = payModes.get(0);
            k.a((Object) cJRTransactionDetails2, "it[0]");
            textView4.setText(com.travel.citybus.best.e.b.a(String.valueOf(cJRTransactionDetails2.getAmount())));
        }
        CJROrderSummary cJROrderSummary3 = this.f23116c;
        if (!(cJROrderSummary3 == null || (paymentInfo = cJROrderSummary3.getPaymentInfo()) == null || !(!paymentInfo.isEmpty()))) {
            CJROrderSummaryPayment cJROrderSummaryPayment = paymentInfo.get(0);
            k.a((Object) cJROrderSummaryPayment, "it[0]");
            String bankTransactionId = cJROrderSummaryPayment.getBankTransactionId();
            if (bankTransactionId != null) {
                TextView textView5 = (TextView) a(R.id.pdTransactionIdTv);
                k.a((Object) textView5, "pdTransactionIdTv");
                textView5.setVisibility(0);
                TextView textView6 = (TextView) a(R.id.pdTransactionIdTv);
                k.a((Object) textView6, "pdTransactionIdTv");
                textView6.setText("Transaction ID : ".concat(String.valueOf(bankTransactionId)));
            } else {
                TextView textView7 = (TextView) a(R.id.pdTransactionIdTv);
                k.a((Object) textView7, "pdTransactionIdTv");
                textView7.setVisibility(8);
            }
        }
        ((ImageView) a(R.id.pdCancelIv)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f23118a;

        b(h hVar) {
            this.f23118a = hVar;
        }

        public final void onClick(View view) {
            this.f23118a.dismiss();
            a a2 = this.f23118a.f23114a;
            if (a2 != null) {
                a2.onCancel();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23117d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
