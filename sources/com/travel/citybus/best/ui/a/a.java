package com.travel.citybus.best.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;

public final class a extends net.one97.paytm.i.f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C0447a f23058a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Float f23059b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Float f23060c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Float f23061d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BestEPurse f23062e;

    /* renamed from: f  reason: collision with root package name */
    private final h f23063f = new h(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f23064g;

    /* renamed from: com.travel.citybus.best.ui.a.a$a  reason: collision with other inner class name */
    public interface C0447a {
        void a(boolean z, float f2);
    }

    public final View a(int i2) {
        if (this.f23064g == null) {
            this.f23064g = new HashMap();
        }
        View view = (View) this.f23064g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23064g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = null;
        this.f23059b = arguments != null ? Float.valueOf(arguments.getFloat("extra_min_balance_e_purse")) : null;
        Bundle arguments2 = getArguments();
        this.f23061d = arguments2 != null ? Float.valueOf(arguments2.getFloat("extra_total_price")) : null;
        Bundle arguments3 = getArguments();
        this.f23060c = arguments3 != null ? Float.valueOf(arguments3.getFloat("extra_current_price")) : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            serializable = arguments4.getSerializable("extra_e_purse");
        }
        this.f23062e = (BestEPurse) serializable;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
        aVar.setOnShowListener(g.f23070a);
        return aVar;
    }

    static final class g implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f23070a = new g();

        g() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from…ttomSheet as FrameLayout)");
                    from.setState(3);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
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
        if (context instanceof C0447a) {
            this.f23058a = (C0447a) context;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.best_bottom_sheet_recharge, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.tv_epurse_balance);
        k.a((Object) textView, "tv_epurse_balance");
        StringBuilder sb = new StringBuilder("₹ ");
        Float f2 = this.f23060c;
        if (f2 == null) {
            k.a();
        }
        sb.append(com.travel.citybus.best.e.b.a(f2.floatValue()));
        textView.setText(sb.toString());
        ((Button) a(R.id.btn_proceed_pay)).setOnClickListener(new b(this));
        ((Button) a(R.id.btn_add_100)).setOnClickListener(new c(this));
        ((Button) a(R.id.btn_add_200)).setOnClickListener(new d(this));
        ((Button) a(R.id.btn_add_500)).setOnClickListener(new e(this));
        ((EditText) a(R.id.et_enter_amount)).addTextChangedListener(this.f23063f);
        ((AppCompatImageView) a(R.id.iv_close_rechage_sheet)).setOnClickListener(new f(this));
    }

    public final void onDetach() {
        this.f23058a = null;
        super.onDetach();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23065a;

        b(a aVar) {
            this.f23065a = aVar;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c((Context) this.f23065a.getActivity())) {
                EditText editText = (EditText) this.f23065a.a(R.id.et_enter_amount);
                k.a((Object) editText, "et_enter_amount");
                Editable text = editText.getText();
                k.a((Object) text, "et_enter_amount.text");
                if (text.length() == 0) {
                    a aVar = this.f23065a;
                    String string = aVar.getString(R.string.city_bus_best_error_recharge_empty);
                    k.a((Object) string, "getString(R.string.city_…est_error_recharge_empty)");
                    a.a(aVar, string);
                    return;
                }
                EditText editText2 = (EditText) this.f23065a.a(R.id.et_enter_amount);
                k.a((Object) editText2, "et_enter_amount");
                float parseFloat = Float.parseFloat(editText2.getText().toString());
                BestEPurse a2 = this.f23065a.f23062e;
                if ((a2 != null ? a2.getPassNumber() : null) == null) {
                    Float b2 = this.f23065a.f23059b;
                    if (b2 == null) {
                        k.a();
                    }
                    if (parseFloat < b2.floatValue()) {
                        a aVar2 = this.f23065a;
                        int i2 = R.string.city_bus_best_min_recharge_amount_is;
                        Object[] objArr = new Object[1];
                        Float b3 = this.f23065a.f23059b;
                        if (b3 == null) {
                            k.a();
                        }
                        objArr[0] = com.travel.citybus.best.e.b.a(b3.floatValue());
                        String string2 = aVar2.getString(i2, objArr);
                        k.a((Object) string2, "getString(R.string.city_…ils.format(minBalance!!))");
                        a.a(aVar2, string2);
                        return;
                    }
                }
                BestEPurse a3 = this.f23065a.f23062e;
                if (a3 != null) {
                    if (a3.getAmountBalance() + (a3.getBonusFactor() * parseFloat) > a3.getMaximumBalance()) {
                        a aVar3 = this.f23065a;
                        String string3 = aVar3.getString(R.string.city_bus_best_max_recharge_amount_is, com.travel.citybus.best.e.b.a(a3.getMaximumBalance()));
                        k.a((Object) string3, "getString(R.string.city_…mat(it.maximumBalance!!))");
                        a.a(aVar3, string3);
                        return;
                    } else if (parseFloat % a3.getDenomination() != 0.0f) {
                        a aVar4 = this.f23065a;
                        String string4 = aVar4.getString(R.string.city_bus_best_denomination_recharge_amount_is, com.travel.citybus.best.e.b.a(a3.getDenomination()));
                        k.a((Object) string4, "getString(R.string.city_…ormat(it.denomination!!))");
                        a.a(aVar4, string4);
                        return;
                    }
                }
                Float c2 = this.f23065a.f23061d;
                if (c2 == null) {
                    k.a();
                }
                float floatValue = c2.floatValue();
                Float d2 = this.f23065a.f23060c;
                if (d2 == null) {
                    k.a();
                }
                if (floatValue > d2.floatValue() + parseFloat) {
                    a aVar5 = this.f23065a;
                    int i3 = R.string.city_bus_best_balance_required_for_booking;
                    Object[] objArr2 = new Object[1];
                    Float d3 = this.f23065a.f23060c;
                    if (d3 == null) {
                        k.a();
                    }
                    objArr2[0] = com.travel.citybus.best.e.b.a(parseFloat + d3.floatValue());
                    String string5 = aVar5.getString(i3, objArr2);
                    k.a((Object) string5, "getString(R.string.city_…ount + currentBalance!!))");
                    a.a(aVar5, string5);
                    return;
                }
                this.f23065a.a(true);
                C0447a e2 = this.f23065a.f23058a;
                if (e2 != null) {
                    CheckBox checkBox = (CheckBox) this.f23065a.a(R.id.iv_check_fast);
                    k.a((Object) checkBox, "iv_check_fast");
                    e2.a(checkBox.isChecked(), parseFloat);
                    return;
                }
                return;
            }
            com.paytm.utility.b.b((Context) this.f23065a.getActivity(), this.f23065a.getString(R.string.no_internet_title), this.f23065a.getString(R.string.no_internet_message));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23066a;

        c(a aVar) {
            this.f23066a = aVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23066a.a(R.id.et_enter_amount)).setText(this.f23066a.getString(R.string.city_bus_best_amount_100));
            EditText editText = (EditText) this.f23066a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23066a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23067a;

        d(a aVar) {
            this.f23067a = aVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23067a.a(R.id.et_enter_amount)).setText(this.f23067a.getString(R.string.city_bus_best_amount_200));
            EditText editText = (EditText) this.f23067a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23067a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23068a;

        e(a aVar) {
            this.f23068a = aVar;
        }

        public final void onClick(View view) {
            ((EditText) this.f23068a.a(R.id.et_enter_amount)).setText(this.f23068a.getString(R.string.city_bus_best_amount_500));
            EditText editText = (EditText) this.f23068a.a(R.id.et_enter_amount);
            k.a((Object) editText, "et_enter_amount");
            ((EditText) this.f23068a.a(R.id.et_enter_amount)).setSelection(editText.getText().length());
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23069a;

        f(a aVar) {
            this.f23069a = aVar;
        }

        public final void onClick(View view) {
            this.f23069a.dismiss();
        }
    }

    public final void a(boolean z) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lottieProgressBar);
        k.a((Object) lottieAnimationView, "lottieProgressBar");
        lottieAnimationView.setVisibility(z ? 0 : 8);
        Button button = (Button) a(R.id.btn_proceed_pay);
        k.a((Object) button, "btn_proceed_pay");
        button.setEnabled(!z);
        Button button2 = (Button) a(R.id.btn_proceed_pay);
        k.a((Object) button2, "btn_proceed_pay");
        button2.setText(z ? "" : getString(R.string.proceed_to_pay));
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23071a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(a aVar) {
            this.f23071a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            TextView textView = (TextView) this.f23071a.a(R.id.tvErrorMessage);
            k.a((Object) textView, "tvErrorMessage");
            textView.setVisibility(8);
            CharSequence obj = editable != null ? editable.toString() : null;
            if (obj == null || obj.length() == 0) {
                Button button = (Button) this.f23071a.a(R.id.btn_proceed_pay);
                k.a((Object) button, "btn_proceed_pay");
                button.setText(this.f23071a.getString(R.string.proceed_to_pay));
                return;
            }
            Button button2 = (Button) this.f23071a.a(R.id.btn_proceed_pay);
            k.a((Object) button2, "btn_proceed_pay");
            button2.setText(this.f23071a.getString(R.string.proceed_to_pay) + " ₹ " + editable);
        }
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        TextView textView = (TextView) aVar.a(R.id.tvErrorMessage);
        k.a((Object) textView, "tvErrorMessage");
        textView.setText(str);
        TextView textView2 = (TextView) aVar.a(R.id.tvErrorMessage);
        k.a((Object) textView2, "tvErrorMessage");
        textView2.setVisibility(0);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23064g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
