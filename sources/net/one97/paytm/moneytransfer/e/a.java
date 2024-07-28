package net.one97.paytm.moneytransfer.e;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.fragments.n;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f54000a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f54001b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f54002c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f54003d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f54004e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f54005f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f54006g;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        String string2;
        TextView textView;
        String str;
        String string3;
        TextView textView2;
        String string4;
        TextView textView3;
        String string5;
        TextView textView4;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.neft_confirmation_bottomsheet_fragment, viewGroup, false);
        k.a((Object) inflate, "view");
        String str2 = null;
        View.OnClickListener onClickListener = this;
        (inflate != null ? inflate.findViewById(R.id.cross_iv) : null).setOnClickListener(onClickListener);
        (inflate != null ? inflate.findViewById(R.id.bottomButton) : null).setOnClickListener(onClickListener);
        this.f54000a = inflate != null ? (TextView) inflate.findViewById(R.id.message) : null;
        this.f54001b = inflate != null ? (TextView) inflate.findViewById(R.id.tooltipMessage) : null;
        this.f54002c = inflate != null ? (TextView) inflate.findViewById(R.id.accountNumber) : null;
        this.f54003d = inflate != null ? (TextView) inflate.findViewById(R.id.bankName) : null;
        this.f54004e = inflate != null ? (ImageView) inflate.findViewById(R.id.bankImageView) : null;
        this.f54005f = inflate != null ? (TextView) inflate.findViewById(R.id.amount) : null;
        Bundle arguments = getArguments();
        if (!(arguments == null || (string5 = arguments.getString("neft_error_message")) == null)) {
            k.a((Object) string5, "it");
            CharSequence charSequence = string5;
            if (!TextUtils.isEmpty(charSequence) && (textView4 = this.f54000a) != null) {
                textView4.setText(charSequence);
            }
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string4 = arguments2.getString("bankname")) == null)) {
            k.a((Object) string4, "it");
            CharSequence charSequence2 = string4;
            if (!TextUtils.isEmpty(charSequence2) && (textView3 = this.f54003d) != null) {
                textView3.setText(charSequence2);
            }
        }
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (string3 = arguments3.getString("vpa")) == null)) {
            k.a((Object) string3, "it");
            if (!TextUtils.isEmpty(string3) && (textView2 = this.f54002c) != null) {
                aa aaVar = aa.f47921a;
                String string6 = getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                k.a((Object) string6, "getString(R.string.money…placeholder_without_bold)");
                String format = String.format(string6, Arrays.copyOf(new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(string3), 4)}, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                textView2.setText(format);
            }
        }
        Bundle arguments4 = getArguments();
        if (!(arguments4 == null || (string2 = arguments4.getString("amount")) == null)) {
            k.a((Object) string2, "it");
            if (!TextUtils.isEmpty(string2) && (textView = this.f54005f) != null) {
                Context context = getContext();
                if (context != null) {
                    int i2 = R.string.mt_rupees_with_amount;
                    aa aaVar2 = aa.f47921a;
                    String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
                    k.a((Object) format2, "java.lang.String.format(format, *args)");
                    str = context.getString(i2, new Object[]{UpiAppUtils.priceToString(format2)});
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }
        Bundle arguments5 = getArguments();
        if (!(arguments5 == null || (string = arguments5.getString("neft_tooltip_message")) == null)) {
            k.a((Object) string, "it");
            if (!TextUtils.isEmpty(string)) {
                SpannableString spannableString = new SpannableString("NOTE: ".concat(String.valueOf(string)));
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                spannableString.setSpan(new ForegroundColorSpan(b.c(context2, R.color.mt_neft_hint_color)), 0, 5, 33);
                TextView textView5 = this.f54001b;
                if (textView5 != null) {
                    textView5.setText(spannableString);
                }
            }
        }
        ImageView imageView = this.f54004e;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str2 = arguments6.getString("ifsc");
        }
        m.a(imageView, str2, getContext());
        return inflate;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.cross_iv) {
            a();
        } else if (view != null && view.getId() == R.id.bottomButton && b()) {
            a();
            if (getParentFragment() instanceof n) {
                Fragment parentFragment = getParentFragment();
                if (!(parentFragment instanceof n)) {
                    parentFragment = null;
                }
                n nVar = (n) parentFragment;
                if (nVar != null) {
                    nVar.h();
                }
            } else if (getParentFragment() instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b) {
                Fragment parentFragment2 = getParentFragment();
                if (!(parentFragment2 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
                    parentFragment2 = null;
                }
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment2;
                if (bVar != null) {
                    bVar.h();
                }
            }
        }
    }

    private final void a() {
        if (b()) {
            dismissAllowingStateLoss();
        }
    }

    private final boolean b() {
        return getActivity() != null && isAdded() && isResumed();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54006g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
