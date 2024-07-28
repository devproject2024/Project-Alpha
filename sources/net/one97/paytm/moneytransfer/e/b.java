package net.one97.paytm.moneytransfer.e;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f54007a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f54008b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f54009c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f54010d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f54011e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f54012f;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        String str;
        String string2;
        TextView textView;
        String string3;
        TextView textView2;
        String string4;
        TextView textView3;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.neft_errorstate_bottomsheet_fragment, viewGroup, false);
        k.a((Object) inflate, "view");
        inflate.findViewById(R.id.cross_iv).setOnClickListener(this);
        this.f54007a = (TextView) inflate.findViewById(R.id.errorMessage);
        this.f54008b = (TextView) inflate.findViewById(R.id.detailMessageTV);
        this.f54009c = (TextView) inflate.findViewById(R.id.bankName);
        this.f54010d = (ImageView) inflate.findViewById(R.id.bankImageView);
        this.f54011e = (TextView) inflate.findViewById(R.id.accountNumber);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string4 = arguments.getString("neft_error_message")) == null)) {
            k.a((Object) string4, "it");
            CharSequence charSequence = string4;
            if (!TextUtils.isEmpty(charSequence) && (textView3 = this.f54007a) != null) {
                textView3.setText(charSequence);
            }
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string3 = arguments2.getString("bankname")) == null)) {
            k.a((Object) string3, "it");
            CharSequence charSequence2 = string3;
            if (!TextUtils.isEmpty(charSequence2) && (textView2 = this.f54009c) != null) {
                textView2.setText(charSequence2);
            }
        }
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (string2 = arguments3.getString("vpa")) == null)) {
            k.a((Object) string2, "it");
            if (!TextUtils.isEmpty(string2) && (textView = this.f54011e) != null) {
                aa aaVar = aa.f47921a;
                String string5 = getString(R.string.money_transfer_acc_no_with_placeholder_without_bold);
                k.a((Object) string5, "getString(R.string.money…placeholder_without_bold)");
                String format = String.format(string5, Arrays.copyOf(new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(string2), 4)}, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                textView.setText(format);
            }
        }
        Bundle arguments4 = getArguments();
        if (!(arguments4 == null || (string = arguments4.getString("neft_tooltip_message")) == null)) {
            k.a((Object) string, "it");
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    str = Html.fromHtml(string, 0).toString();
                } else {
                    str = Html.fromHtml(string).toString();
                }
                SpannableString spannableString = new SpannableString(str);
                TextView textView4 = this.f54008b;
                if (textView4 != null) {
                    textView4.setText(spannableString);
                }
                TextView textView5 = this.f54008b;
                if (textView5 == null) {
                    k.a();
                }
                Linkify.addLinks(textView5, 4);
                TextView textView6 = this.f54008b;
                if (textView6 != null) {
                    textView6.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        }
        ImageView imageView = this.f54010d;
        Bundle arguments5 = getArguments();
        m.a(imageView, arguments5 != null ? arguments5.getString("ifsc") : null, getContext());
        return inflate;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.cross_iv) {
            if (getActivity() != null && isAdded() && isResumed()) {
                dismissAllowingStateLoss();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54012f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
