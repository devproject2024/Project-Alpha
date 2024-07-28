package net.one97.paytm.passbook.transactionDetail.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.utility.c;

public final class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private CJRTransaction f59066a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f59067b;

    private View a(int i2) {
        if (this.f59067b == null) {
            this.f59067b = new HashMap();
        }
        View view = (View) this.f59067b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f59067b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public d(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "mTransactionInstance");
        this.f59066a = cJRTransaction;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_bottomsheet_cc_fee_on_add_money, viewGroup, false);
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        View.inflate(getContext(), R.layout.pass_bottomsheet_cc_fee_on_add_money, (ViewGroup) null);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        String txnAmount;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Double d2 = null;
        try {
            Context context = getContext();
            if (context != null) {
                int c2 = androidx.core.content.b.c(context, 17170445);
                ViewParent parent = view != null ? view.getParent() : null;
                if (parent != null) {
                    ((View) parent).setBackgroundColor(c2);
                } else {
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(this.f59066a.getmTxnDescription3())) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tvChargesAmount);
            k.a((Object) roboTextView, "tvChargesAmount");
            roboTextView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + c.a(this.f59066a.getmTxnDescription3()));
        }
        CJRTransaction cJRTransaction = this.f59066a;
        Double valueOf = (cJRTransaction == null || (txnAmount = cJRTransaction.getTxnAmount()) == null) ? null : Double.valueOf(Double.parseDouble(txnAmount));
        CJRTransaction cJRTransaction2 = this.f59066a;
        if (!(cJRTransaction2 == null || (str = cJRTransaction2.getmTxnDescription3()) == null)) {
            d2 = Double.valueOf(Double.parseDouble(str));
        }
        Double valueOf2 = (valueOf == null || d2 == null) ? valueOf : Double.valueOf(valueOf.doubleValue() + d2.doubleValue());
        if (d2 != null) {
            double doubleValue = d2.doubleValue();
            if (valueOf == null) {
                k.a();
            }
            Double.valueOf((doubleValue / valueOf.doubleValue()) * 100.0d);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvAmountNetPayable);
        k.a((Object) roboTextView2, "tvAmountNetPayable");
        roboTextView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + c.a(String.valueOf(valueOf2)));
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.saTvHeader);
        k.a((Object) roboTextView3, "saTvHeader");
        roboTextView3.setText(getString(R.string.pass_cc_fee_on_add_money_heading_updated));
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.tvWalletTxnAmount);
        k.a((Object) roboTextView4, "tvWalletTxnAmount");
        roboTextView4.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + c.a(this.f59066a.getTxnAmount()));
        RoboTextView roboTextView5 = (RoboTextView) a(R.id.tvCharges);
        k.a((Object) roboTextView5, "tvCharges");
        roboTextView5.setText(getString(R.string.pass_cc_fee_on_add_money_charges_updated));
        ((ImageView) a(R.id.ivClose)).setOnClickListener(new a(this));
        SpannableString spannableString = new SpannableString(getString(R.string.pass_cc_fee_on_add_money_sub_heading_updated));
        b bVar = new b(this);
        CharSequence charSequence = spannableString;
        String string = getString(R.string.pass_cc_fee_on_add_money_know_more);
        k.a((Object) string, "getString(R.string.pass_…e_on_add_money_know_more)");
        spannableString.setSpan(bVar, p.a(charSequence, string, 0, false, 6), spannableString.length(), 33);
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(androidx.core.content.b.c(context2, R.color.paytm_blue));
        String string2 = getString(R.string.pass_cc_fee_on_add_money_know_more);
        k.a((Object) string2, "getString(R.string.pass_…e_on_add_money_know_more)");
        spannableString.setSpan(foregroundColorSpan, p.a(charSequence, string2, 0, false, 6), spannableString.length(), 33);
        RoboTextView roboTextView6 = (RoboTextView) a(R.id.tvHeader2);
        k.a((Object) roboTextView6, "tvHeader2");
        roboTextView6.setText(charSequence);
        RoboTextView roboTextView7 = (RoboTextView) a(R.id.tvHeader2);
        k.a((Object) roboTextView7, "tvHeader2");
        roboTextView7.setMovementMethod(LinkMovementMethod.getInstance());
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f59068a;

        a(d dVar) {
            this.f59068a = dVar;
        }

        public final void onClick(View view) {
            this.f59068a.dismiss();
        }
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f59069a;

        b(d dVar) {
            this.f59069a = dVar;
        }

        public final void onClick(View view) {
            k.c(view, "view");
            net.one97.paytm.passbook.d.b().a(this.f59069a.getContext(), "https://www.paytmbank.com/ratesCharges", "Rates & Charges");
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59067b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
