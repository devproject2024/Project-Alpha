package net.one97.paytm.paymentsBank.cifCreation.view.a;

import android.content.Context;
import android.os.Bundle;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.common.view.d;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public class b extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f18013a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f18014b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18015c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18016d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18017e;

    public interface a {
        void f();

        void h();
    }

    public static b a(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("EXTRA_FLAG_SHOW_FD_CREATE_BUTTON", z);
        bundle.putBoolean("EXTRA_FLAG_SHOW_TNC", z2);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f18015c = getArguments().getBoolean("EXTRA_FLAG_SHOW_FD_CREATE_BUTTON", false);
            this.f18016d = getArguments().getBoolean("EXTRA_FLAG_SHOW_TNC", false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_fdbenefits, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getView().findViewById(R.id.tv_know_more).setOnClickListener(this);
        this.f18017e = (TextView) getView().findViewById(R.id.tv_terms_and_condition);
        Button button = (Button) getView().findViewById(R.id.btn_proceed);
        if (this.f18015c) {
            button.setVisibility(0);
        } else {
            button.setVisibility(8);
        }
        if (this.f18016d) {
            this.f18017e.setVisibility(8);
        } else {
            this.f18017e.setVisibility(0);
        }
        TextView textView = (TextView) getView().findViewById(R.id.tv_view_interest_table);
        textView.setPaintFlags(8 | textView.getPaintFlags());
        textView.setOnClickListener(this);
        try {
            ((TextView) getView().findViewById(R.id.tv_earn_risk_free)).setText(getString(R.string.pb_earn_risk_free, a()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        button.setOnClickListener(this);
        String string = getString(R.string.pdc_proceed_agree);
        String string2 = getString(R.string.pdc_tnc);
        String str = string + " " + string2;
        final SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                Selection.setSelection(spannableString, 0);
                b.this.f18014b.f();
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(androidx.core.content.b.c(b.this.getContext(), R.color.paytm_blue));
            }
        }, str.indexOf(string2), str.indexOf(string2) + string2.length(), 33);
        this.f18017e.setText(spannableString);
        this.f18017e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f18017e.setText(spannableString);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_know_more) {
            o.a().openWebViewActivity(this.f18013a, n.n(), getString(R.string.paytm_payments_bank));
        } else if (view.getId() == R.id.tv_view_interest_table) {
            new d().show(getActivity().getSupportFragmentManager(), "itTableBottomSheet");
        } else if (view.getId() == R.id.btn_proceed) {
            this.f18014b.h();
        }
    }

    private String a() {
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = (SlfdMetaApiResponseModel) new f().a(net.one97.paytm.bankCommon.h.b.D(this.f18013a), SlfdMetaApiResponseModel.class);
        if (slfdMetaApiResponseModel == null || slfdMetaApiResponseModel.getPeakInterestRatePerAnnum() == null) {
            try {
                g.a();
                if (TextUtils.isEmpty(net.one97.paytm.bankCommon.utils.d.a("saving_acc_interest"))) {
                    return "7.03%";
                }
                g.a();
                String[] split = net.one97.paytm.bankCommon.utils.d.a("saving_acc_interest").split("##");
                if (split.length > 1) {
                    return split[1];
                }
                return "7.03%";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "7.03%";
            }
        } else {
            return slfdMetaApiResponseModel.getPeakInterestRatePerAnnum() + "%";
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f18013a = context;
        try {
            if (this.f18013a instanceof a) {
                this.f18014b = (a) context;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDetach() {
        super.onDetach();
    }
}
