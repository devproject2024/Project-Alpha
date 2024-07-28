package net.one97.paytm.moneytransfer.e;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.fragments.n;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;

public final class c extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f54013a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f54014b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f54015c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        TextView textView2;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.neft_holiday_bottomsheet_fragment, viewGroup, false);
        k.a((Object) inflate, "view");
        View.OnClickListener onClickListener = this;
        inflate.findViewById(R.id.cross_iv).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.tryLowerAmount).setOnClickListener(onClickListener);
        this.f54013a = (TextView) inflate.findViewById(R.id.messageTV);
        this.f54014b = (TextView) inflate.findViewById(R.id.detailMessageTV);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str = null;
            CharSequence string = arguments != null ? arguments.getString("neft_error_message") : null;
            if (!TextUtils.isEmpty(string) && (textView2 = this.f54013a) != null) {
                textView2.setText(string);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("neft_tooltip_message");
            }
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence) && (textView = this.f54014b) != null) {
                textView.setText(charSequence);
            }
        }
        return inflate;
    }

    public final void onClick(View view) {
        if (view == null || view.getId() != R.id.cross_iv) {
            if (view != null && view.getId() == R.id.tryLowerAmount && a()) {
                dismissAllowingStateLoss();
                if (getParentFragment() instanceof n) {
                    Fragment parentFragment = getParentFragment();
                    if (parentFragment != null) {
                        n nVar = (n) parentFragment;
                        if (nVar != null && nVar.i()) {
                            CustomAmountTextInputEditText customAmountTextInputEditText = nVar.f54548a;
                            if (customAmountTextInputEditText == null) {
                                k.a("amountET");
                            }
                            customAmountTextInputEditText.requestFocus();
                            CustomAmountTextInputEditText customAmountTextInputEditText2 = nVar.f54548a;
                            if (customAmountTextInputEditText2 == null) {
                                k.a("amountET");
                            }
                            m.a((EditText) customAmountTextInputEditText2, (Activity) nVar.getActivity());
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.fragments.MoneyTransferPaymentFragment");
                }
            }
        } else if (a()) {
            dismissAllowingStateLoss();
        }
    }

    private final boolean a() {
        return getActivity() != null && isAdded() && isResumed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54015c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
