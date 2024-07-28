package net.one97.paytm.autoaddmoney.views;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.helper.c;
import net.one97.paytm.i.h;

public final class f extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f49404a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f49405b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f49406c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f49407d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49408e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f49409f;

    /* renamed from: g  reason: collision with root package name */
    private String f49410g;

    /* renamed from: h  reason: collision with root package name */
    private String f49411h;

    /* renamed from: i  reason: collision with root package name */
    private IJRDataModel f49412i;
    private Boolean j = Boolean.FALSE;
    private HashMap k;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.am_autoaddmoney_failed, (ViewGroup) null);
    }

    public final void onActivityCreated(Bundle bundle) {
        TextView textView;
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("SAVED_CARD")) {
                Bundle arguments2 = getArguments();
                if ((arguments2 != null ? arguments2.getSerializable("SAVED_CARD") : null) != null) {
                    Bundle arguments3 = getArguments();
                    if (arguments3 == null) {
                        k.a();
                    }
                    Serializable serializable = arguments3.getSerializable("SAVED_CARD");
                    if (serializable != null) {
                        this.f49412i = (IJRDataModel) serializable;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.IJRDataModel");
                    }
                }
            }
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                k.a();
            }
            this.f49404a = arguments4.getString("min_amount");
            Bundle arguments5 = getArguments();
            if (arguments5 == null) {
                k.a();
            }
            this.f49410g = arguments5.getString("auto_amount");
            Bundle arguments6 = getArguments();
            if (arguments6 == null) {
                k.a();
            }
            this.f49411h = arguments6.getString("STATUS_MESSAGE");
        }
        if (getArguments() != null) {
            Bundle arguments7 = getArguments();
            if (arguments7 == null) {
                k.a();
            }
            if (arguments7.containsKey("isTransactionOrSubscriptionFailed")) {
                Bundle arguments8 = getArguments();
                if (arguments8 == null) {
                    k.a();
                }
                this.j = Boolean.valueOf(arguments8.getBoolean("isTransactionOrSubscriptionFailed", false));
            }
        }
        TextView textView2 = this.f49407d;
        if (textView2 == null) {
            k.a("tv_autoadd_status");
        }
        textView2.setText(this.f49411h);
        if (!TextUtils.isEmpty(this.f49404a)) {
            TextView textView3 = this.f49405b;
            if (textView3 == null) {
                k.a("mTvMinAmount");
            }
            textView3.setText(getString(R.string.min_amount_rs, this.f49404a));
        }
        if (!TextUtils.isEmpty(this.f49410g)) {
            TextView textView4 = this.f49406c;
            if (textView4 == null) {
                k.a("mTvAutoAmount");
            }
            textView4.setText(getString(R.string.auto_amount_rs, this.f49410g));
        }
        View view = getView();
        if (!(view == null || (textView = (TextView) view.findViewById(R.id.tv_am_time)) == null)) {
            textView.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        }
        IJRDataModel iJRDataModel = this.f49412i;
        if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card)) {
            TextView textView5 = this.f49408e;
            if (textView5 == null) {
                k.a("tv_linked_account_number");
            }
            StringBuilder sb = new StringBuilder();
            CJRAvailableInstrumentsAddMoney.Card card = (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel;
            sb.append(card.getIssuerDisplayName());
            sb.append(" ");
            sb.append(getString(R.string.card_number_format, card.getCardFirstFourDigit(), card.getCardLastFourDigits()));
            textView5.setText(sb.toString());
        } else if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card)) {
            TextView textView6 = this.f49408e;
            if (textView6 == null) {
                k.a("tv_linked_account_number");
            }
            StringBuilder sb2 = new StringBuilder();
            CJRAvailableInstrumentsAddMoneyCreditCard.Card card2 = (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
            sb2.append(card2.getIssuerDisplayName());
            sb2.append(" ");
            sb2.append(getString(R.string.card_number_format, card2.getCardFirstFourDigit(), card2.getCardLastFourDigits()));
            textView6.setText(sb2.toString());
        } else if (iJRDataModel != null && (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card)) {
            TextView textView7 = this.f49408e;
            if (textView7 == null) {
                k.a("tv_linked_account_number");
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel).getIssuerDisplayName());
            int i2 = R.string.acc_number_format;
            Object[] objArr = new Object[1];
            String str = com.paytm.utility.b.l((Context) getActivity()).toString();
            if (str != null) {
                String substring = str.substring(6, 10);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                objArr[0] = substring;
                sb3.append(getString(i2, objArr));
                textView7.setText(sb3.toString());
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        Boolean bool = this.j;
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            TextView textView8 = this.f49409f;
            if (textView8 == null) {
                k.a("mRetryTransaction");
            }
            textView8.setVisibility(0);
            TextView textView9 = this.f49409f;
            if (textView9 == null) {
                k.a("mRetryTransaction");
            }
            textView9.setOnClickListener(new b(this));
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_min_amount);
        k.a((Object) findViewById, "view.findViewById(R.id.tv_min_amount)");
        this.f49405b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_auto_add_amount);
        k.a((Object) findViewById2, "view.findViewById(R.id.tv_auto_add_amount)");
        this.f49406c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_autoadd_status);
        k.a((Object) findViewById3, "view.findViewById(R.id.tv_autoadd_status)");
        this.f49407d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_linked_account_number);
        k.a((Object) findViewById4, "view.findViewById(R.id.tv_linked_account_number)");
        this.f49408e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.btn_retry);
        k.a((Object) findViewById5, "view.findViewById(R.id.btn_retry)");
        this.f49409f = (TextView) findViewById5;
        ((RelativeLayout) view.findViewById(R.id.help_layout)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f49413a;

        a(f fVar) {
            this.f49413a = fVar;
        }

        public final void onClick(View view) {
            f.a(this.f49413a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f49414a;

        b(f fVar) {
            this.f49414a = fVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f49414a.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this.f49414a.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = fVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        a2.a(activity, (Bundle) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
