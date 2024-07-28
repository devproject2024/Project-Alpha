package com.travel.citybus.best.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.R;
import com.travel.citybus.best.b.a;
import com.travel.citybus.best.e.d;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity;
import com.travel.citybus.brts.model.pojo.CJRCity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class b extends net.one97.paytm.i.h implements a.C0443a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23072a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Integer f23073b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f23074c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f23075d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BestEPurse f23076e;

    /* renamed from: f  reason: collision with root package name */
    private CJRCity f23077f;

    /* renamed from: g  reason: collision with root package name */
    private com.travel.citybus.best.c.a f23078g;

    /* renamed from: h  reason: collision with root package name */
    private final h f23079h = new h(this);

    /* renamed from: i  reason: collision with root package name */
    private HashMap f23080i;

    public final View a(int i2) {
        if (this.f23080i == null) {
            this.f23080i = new HashMap();
        }
        View view = (View) this.f23080i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23080i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(com.travel.citybus.best.a.a aVar) {
        k.c(aVar, "status");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f23076e = (BestEPurse) arguments.getSerializable("best_e_purse_data");
            this.f23077f = (CJRCity) arguments.getSerializable("extra_city");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_city_bus_add_money, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Resources resources = getResources();
        Float f2 = null;
        this.f23073b = resources != null ? Integer.valueOf(resources.getColor(R.color.color_city_default)) : null;
        Resources resources2 = getResources();
        this.f23074c = resources2 != null ? Integer.valueOf(resources2.getColor(R.color.color_bmtc_route)) : null;
        BestEPurse bestEPurse = this.f23076e;
        Float valueOf = bestEPurse != null ? Float.valueOf(bestEPurse.getAmountBalance()) : null;
        BestEPurse bestEPurse2 = this.f23076e;
        if (bestEPurse2 != null) {
            f2 = Float.valueOf(bestEPurse2.getMinBalance());
        }
        ((Button) a(R.id.btn_proceed)).setOnClickListener(new c(this, f2));
        TextView textView = (TextView) a(R.id.tv_epurse_avail_balance);
        k.a((Object) textView, "tv_epurse_avail_balance");
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.city_bus_best_available_balance));
        sb.append(" ₹");
        if (valueOf == null) {
            k.a();
        }
        sb.append(com.travel.citybus.best.e.b.a(valueOf.floatValue()));
        textView.setText(sb.toString());
        ((Button) a(R.id.btn_hint_100)).setOnClickListener(new d(this));
        ((Button) a(R.id.btn_hint_200)).setOnClickListener(new e(this));
        ((Button) a(R.id.btn_hint_500)).setOnClickListener(new f(this));
        ((EditText) a(R.id.et_enter_amount)).addTextChangedListener(this.f23079h);
        ((AppCompatImageView) a(R.id.iv_wallet_back_button)).setOnClickListener(new g(this));
        this.f23078g = new com.travel.citybus.best.c.a(this, this.f23077f, this.f23076e);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 1287) {
            Boolean bool = null;
            String stringExtra = intent != null ? intent.getStringExtra("order_id") : null;
            if (intent != null) {
                bool = Boolean.valueOf(intent.getBooleanExtra(AppConstants.IS_CANCEL, true));
            }
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue() || stringExtra == null) {
                a(false);
                return;
            }
            Intent intent2 = new Intent(getActivity(), CityBusRechargeOrderSummaryActivity.class);
            intent2.putExtra("order_id", stringExtra);
            intent2.putExtra("is_from_payment", true);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivity(intent2);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        a(false);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23082a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Float f23083b;

        c(b bVar, Float f2) {
            this.f23082a = bVar;
            this.f23083b = f2;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c((Context) this.f23082a.getActivity())) {
                EditText editText = (EditText) this.f23082a.a(R.id.et_enter_amount);
                k.a((Object) editText, "et_enter_amount");
                Editable text = editText.getText();
                k.a((Object) text, "et_enter_amount.text");
                if (text.length() == 0) {
                    b bVar = this.f23082a;
                    String string = bVar.getString(R.string.city_bus_best_error_recharge_empty);
                    k.a((Object) string, "getString(R.string.city_…est_error_recharge_empty)");
                    b.a(bVar, string);
                    return;
                }
                b bVar2 = this.f23082a;
                EditText editText2 = (EditText) bVar2.a(R.id.et_enter_amount);
                k.a((Object) editText2, "et_enter_amount");
                bVar2.f23075d = Float.parseFloat(editText2.getText().toString());
                BestEPurse b2 = this.f23082a.f23076e;
                if ((b2 != null ? b2.getPassNumber() : null) == null) {
                    float a2 = this.f23082a.f23075d;
                    Float f2 = this.f23083b;
                    if (f2 == null) {
                        k.a();
                    }
                    if (a2 < f2.floatValue()) {
                        b bVar3 = this.f23082a;
                        int i2 = R.string.city_bus_best_min_recharge_amount_is;
                        Object[] objArr = new Object[1];
                        Float f3 = this.f23083b;
                        if (f3 == null) {
                            k.a();
                        }
                        objArr[0] = com.travel.citybus.best.e.b.a(f3.floatValue());
                        String string2 = bVar3.getString(i2, objArr);
                        k.a((Object) string2, "getString(R.string.city_…ils.format(minBalance!!))");
                        b.a(bVar3, string2);
                        return;
                    }
                }
                BestEPurse b3 = this.f23082a.f23076e;
                if (b3 != null) {
                    if (b3.getAmountBalance() + (this.f23082a.f23075d * b3.getBonusFactor()) > b3.getMaximumBalance()) {
                        b bVar4 = this.f23082a;
                        String string3 = bVar4.getString(R.string.city_bus_best_max_recharge_amount_is, com.travel.citybus.best.e.b.a(b3.getMaximumBalance()));
                        k.a((Object) string3, "getString(R.string.city_…mat(it.maximumBalance!!))");
                        b.a(bVar4, string3);
                        return;
                    } else if (this.f23082a.f23075d % b3.getDenomination() != 0.0f) {
                        b bVar5 = this.f23082a;
                        String string4 = bVar5.getString(R.string.city_bus_best_denomination_recharge_amount_is, com.travel.citybus.best.e.b.a(b3.getDenomination()));
                        k.a((Object) string4, "getString(R.string.city_…ormat(it.denomination!!))");
                        b.a(bVar5, string4);
                        return;
                    }
                }
                this.f23082a.a(true);
                b.c(this.f23082a);
                return;
            }
            com.paytm.utility.b.b((Context) this.f23082a.getActivity(), this.f23082a.getString(R.string.no_internet_title), this.f23082a.getString(R.string.no_internet_message));
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23084a;

        d(b bVar) {
            this.f23084a = bVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23084a.a(R.id.et_enter_amount)).setText(this.f23084a.getString(R.string.city_bus_best_amount_100));
            EditText editText = (EditText) this.f23084a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23084a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23085a;

        e(b bVar) {
            this.f23085a = bVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23085a.a(R.id.et_enter_amount)).setText(this.f23085a.getString(R.string.city_bus_best_amount_200));
            EditText editText = (EditText) this.f23085a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23085a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23086a;

        f(b bVar) {
            this.f23086a = bVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23086a.a(R.id.et_enter_amount)).setText(this.f23086a.getString(R.string.city_bus_best_amount_500));
            EditText editText = (EditText) this.f23086a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23086a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23087a;

        g(b bVar) {
            this.f23087a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f23087a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        Button button = (Button) a(R.id.btn_proceed);
        k.a((Object) button, "btn_proceed");
        button.setEnabled(!z);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lottieProgressBar);
        k.a((Object) lottieAnimationView, "lottieProgressBar");
        lottieAnimationView.setVisibility(z ? 0 : 8);
        Button button2 = (Button) a(R.id.btn_proceed);
        k.a((Object) button2, "btn_proceed");
        button2.setText(z ? "" : getString(R.string.city_bus_best_proceed_to_pay));
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23088a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(b bVar) {
            this.f23088a = bVar;
        }

        public final void afterTextChanged(Editable editable) {
            TextView textView = (TextView) this.f23088a.a(R.id.tv_error_message);
            k.a((Object) textView, "tv_error_message");
            textView.setVisibility(8);
            CharSequence obj = editable != null ? editable.toString() : null;
            if (obj == null || obj.length() == 0) {
                Button button = (Button) this.f23088a.a(R.id.btn_proceed);
                k.a((Object) button, "btn_proceed");
                button.setText(this.f23088a.getString(R.string.city_bus_best_proceed_to_pay));
                Integer d2 = this.f23088a.f23073b;
                if (d2 != null) {
                    ((TextView) this.f23088a.a(R.id.tv_rupee_symbol)).setTextColor(d2.intValue());
                    return;
                }
                return;
            }
            Button button2 = (Button) this.f23088a.a(R.id.btn_proceed);
            k.a((Object) button2, "btn_proceed");
            button2.setText(this.f23088a.getString(R.string.city_bus_best_proceed_to_pay) + " ₹ " + editable);
            Integer e2 = this.f23088a.f23074c;
            if (e2 != null) {
                ((TextView) this.f23088a.a(R.id.tv_rupee_symbol)).setTextColor(e2.intValue());
            }
        }
    }

    /* renamed from: com.travel.citybus.best.ui.a.b$b  reason: collision with other inner class name */
    public static final class C0448b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23081a;

        C0448b(b bVar) {
            this.f23081a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23081a.a(false);
            d.a aVar = com.travel.citybus.best.e.d.f23053a;
            FragmentActivity activity = this.f23081a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            String string = this.f23081a.getString(R.string.brts_error);
            k.a((Object) string, "getString(R.string.brts_error)");
            String string2 = this.f23081a.getString(R.string.some_went_wrong);
            k.a((Object) string2, "getString(R.string.some_went_wrong)");
            d.a.a(activity, string, string2);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                b.a(this.f23081a, (CJRPGTokenList) iJRPaytmDataModel);
            }
        }
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        k.c(cJRRechargePayment, "rechargePayment");
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("city_bus_add_money", true);
        k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
        com.travel.citybus.brts.f.e().d(getActivity(), intent);
    }

    public final void a(String str) {
        a(false);
        d.a aVar = com.travel.citybus.best.e.d.f23053a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context context = activity;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        if (str == null) {
            str = getString(R.string.brts_some_went_wrong);
            k.a((Object) str, "getString(R.string.brts_some_went_wrong)");
        }
        d.a.a(context, string, str);
    }

    public final void R_() {
        a(false);
        d.a aVar = com.travel.citybus.best.e.d.f23053a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        String string2 = getString(R.string.brts_some_went_wrong);
        k.a((Object) string2, "getString(R.string.brts_some_went_wrong)");
        d.a.a(activity, string, string2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        TextView textView = (TextView) bVar.a(R.id.tv_error_message);
        k.a((Object) textView, "tv_error_message");
        textView.setText(str);
        TextView textView2 = (TextView) bVar.a(R.id.tv_error_message);
        k.a((Object) textView2, "tv_error_message");
        textView2.setVisibility(0);
    }

    public static final /* synthetic */ void c(b bVar) {
        bVar.a(true);
        FragmentActivity activity = bVar.getActivity();
        Context context = null;
        if (com.paytm.utility.b.c(activity != null ? activity.getApplicationContext() : null)) {
            FragmentActivity activity2 = bVar.getActivity();
            if (activity2 != null) {
                context = activity2.getApplicationContext();
            }
            String a2 = com.paytm.utility.d.a(context);
            if (!TextUtils.isEmpty(a2)) {
                com.travel.citybus.brts.utils.c.a(a2, (Activity) bVar.getActivity(), (com.paytm.network.listener.b) new C0448b(bVar));
                return;
            }
            return;
        }
        bVar.a(false);
        com.travel.citybus.brts.utils.c.a((Activity) bVar.getActivity());
    }

    public static final /* synthetic */ void a(b bVar, CJRPGTokenList cJRPGTokenList) {
        com.travel.citybus.best.c.a aVar;
        k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
        String a2 = com.travel.citybus.brts.f.e().a(cJRPGTokenList);
        if (!TextUtils.isEmpty(a2) && (aVar = bVar.f23078g) != null) {
            FragmentActivity activity = bVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            k.a((Object) a2, "walletSSOToken");
            EditText editText = (EditText) bVar.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            aVar.a(activity, a2, false, Float.parseFloat(editText.getText().toString()));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23080i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
