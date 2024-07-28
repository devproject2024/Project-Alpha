package com.business.merchant_payments.newhome;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.fragment.BaseDialogFragment;
import com.business.merchant_payments.databinding.MpBwSettlementAmountToHoldDialogBinding;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AmountOnHoldDialogFragment extends BaseDialogFragment {
    public static final String AMOUNT_ON_HOLD_BUNDLE = "amountOnHoldBundle";
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;
    public LinkedHashMap<String, String> holdAmountMap = new LinkedHashMap<>();

    public static final AmountOnHoldDialogFragment newInstance(LinkedHashMap<String, String> linkedHashMap) {
        return Companion.newInstance(linkedHashMap);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(AMOUNT_ON_HOLD_BUNDLE) : null;
        if (serializable != null) {
            this.holdAmountMap = (LinkedHashMap) serializable;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.LinkedHashMap<kotlin.String, kotlin.String> /* = java.util.LinkedHashMap<kotlin.String, kotlin.String> */");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Window window2;
        Window window3;
        k.d(layoutInflater, "inflater");
        MpBwSettlementAmountToHoldDialogBinding inflate = MpBwSettlementAmountToHoldDialogBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "MpBwSettlementAmountToHo…inflater,container,false)");
        LinearLayout linearLayout = inflate.container;
        k.b(linearLayout, "binding.container");
        int i2 = 0;
        for (Map.Entry next : this.holdAmountMap.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!k.a((Object) "--", (Object) str2)) {
                View inflate2 = getLayoutInflater().inflate(R.layout.mp_amount_on_hold_item, (ViewGroup) null, true);
                k.b(inflate2, "childView");
                TextView textView = (TextView) inflate2.findViewById(R.id.hold_amount_text);
                k.b(textView, "childView.hold_amount_text");
                textView.setText(str);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.hold_amount_value);
                k.b(textView2, "childView.hold_amount_value");
                textView2.setText(str2);
                TextView textView3 = (TextView) inflate2.findViewById(R.id.hold_amount_subtext);
                k.b(textView3, "childView.hold_amount_subtext");
                textView3.setText(getSubText(str));
                inflate2.setId(View.generateViewId());
                linearLayout.addView(inflate2, i2);
                i2++;
            }
        }
        inflate.crossBtn.setOnClickListener(new AmountOnHoldDialogFragment$onCreateView$1(this));
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            k.a((Object) dialog);
            k.b(dialog, "dialog!!");
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                if (!(dialog2 == null || (window3 = dialog2.getWindow()) == null)) {
                    window3.setBackgroundDrawable(new ColorDrawable(0));
                }
                Dialog dialog3 = getDialog();
                if (!(dialog3 == null || (window2 = dialog3.getWindow()) == null)) {
                    window2.requestFeature(1);
                }
                Dialog dialog4 = getDialog();
                if (!(dialog4 == null || (window = dialog4.getWindow()) == null)) {
                    window.setSoftInputMode(16);
                }
            }
        }
        return inflate.getRoot();
    }

    private final String getSubText(String str) {
        if (k.a((Object) str, (Object) getString(R.string.mp_label_amount_on_hold))) {
            String string = getString(R.string.mp_amont_on_hold_subtext);
            k.b(string, "getString(R.string.mp_amont_on_hold_subtext)");
            return string;
        } else if (k.a((Object) str, (Object) getString(R.string.mp_label_amount_on_hold_for_loan))) {
            String string2 = getString(R.string.mp_amount_on_hold_for_loan_subtext);
            k.b(string2, "getString(R.string.mp_am…on_hold_for_loan_subtext)");
            return string2;
        } else if (k.a((Object) str, (Object) getString(R.string.mp_label_val_amount_on_hold_for_EDC))) {
            String string3 = getString(R.string.mp_amount_on_hold_for_edc_subtext);
            k.b(string3, "getString(R.string.mp_am…_on_hold_for_edc_subtext)");
            return string3;
        } else if (k.a((Object) str, (Object) getString(R.string.mp_label_val_amount_on_hold_for_channels))) {
            String string4 = getString(R.string.mp_amount_on_hold_for_channels_subtext);
            k.b(string4, "getString(R.string.mp_am…old_for_channels_subtext)");
            return string4;
        } else if (k.a((Object) str, (Object) getString(R.string.mp_label_val_amount_on_hold_for_soundBox))) {
            String string5 = getString(R.string.mp_amount_on_hold_for_soundbox_subtext);
            k.b(string5, "getString(R.string.mp_am…old_for_soundbox_subtext)");
            return string5;
        } else {
            String string6 = getString(R.string.mp_carry_forward_balance_subtext);
            k.b(string6, "getString(R.string.mp_ca…_forward_balance_subtext)");
            return string6;
        }
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AmountOnHoldDialogFragment newInstance(LinkedHashMap<String, String> linkedHashMap) {
            k.d(linkedHashMap, "amountOnHoldValue");
            AmountOnHoldDialogFragment amountOnHoldDialogFragment = new AmountOnHoldDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(AmountOnHoldDialogFragment.AMOUNT_ON_HOLD_BUNDLE, linkedHashMap);
            amountOnHoldDialogFragment.setArguments(bundle);
            return amountOnHoldDialogFragment;
        }
    }
}
