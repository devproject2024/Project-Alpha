package net.one97.paytm.passbook.transactionDetail.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.RoboTextView;
import java.text.DecimalFormat;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.i.f;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private double f59057a;

    /* renamed from: b  reason: collision with root package name */
    private double f59058b;

    /* renamed from: c  reason: collision with root package name */
    private double f59059c;

    /* renamed from: d  reason: collision with root package name */
    private double f59060d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f59061e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f59062f;

    public c() {
    }

    public c(double d2, double d3, double d4, double d5, boolean z) {
        this();
        this.f59057a = d2;
        this.f59058b = d3;
        this.f59059c = d4;
        this.f59060d = d5;
        this.f59061e = z;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        String str;
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.addmoney_bottomsheet_cc_fee_on_add_money, (ViewGroup) null);
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("add_money_to_wallet_cc_charge_msg_without_percent");
        if (TextUtils.isEmpty(f2)) {
            f2 = getString(R.string.add_money_to_wallet_cc_charge_msg_without_percent);
        }
        View findViewById = inflate.findViewById(R.id.tvHeader);
        k.a((Object) findViewById, "view.findViewById<RoboTextView>(R.id.tvHeader)");
        ((RoboTextView) findViewById).setText(f2);
        String f3 = net.one97.paytm.helper.a.f50546a.a().f("charges_without_percent");
        if (TextUtils.isEmpty(f3)) {
            f3 = getString(R.string.charges_without_percent);
        }
        View findViewById2 = inflate.findViewById(R.id.tvCharges);
        k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.tvCharges)");
        ((TextView) findViewById2).setText(f3);
        String f4 = net.one97.paytm.helper.a.f50546a.a().f("msg_add_money_to_wallet_cc_fee");
        if (TextUtils.isEmpty(f4)) {
            f4 = getString(R.string.msg_add_money_to_wallet_cc_fee);
        }
        if (f4 == null) {
            k.a();
        }
        CharSequence charSequence = f4;
        if (p.a(charSequence, (CharSequence) "https", false)) {
            View findViewById3 = inflate.findViewById(R.id.tvHeader2);
            k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.tvHeader2)");
            ((TextView) findViewById3).setMovementMethod(LinkMovementMethod.getInstance());
            String substring = f4.substring(p.a(charSequence, "https", 0, false, 6), p.a(charSequence, "'>", 0, false, 6));
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = f4.substring(p.a(charSequence, "'>", 0, false, 6) + 2, p.a(charSequence, "</", 0, false, 6));
            k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (Build.VERSION.SDK_INT >= 24) {
                str = Html.fromHtml(f4, 0).toString();
            } else {
                str = Html.fromHtml(f4).toString();
            }
            CharSequence charSequence2 = str;
            SpannableString spannableString = new SpannableString(charSequence2);
            ClickableSpan bVar = new b(this, substring);
            int a2 = p.a(charSequence2, substring2, 0, false, 6);
            int length = substring2.length() + a2;
            if (a2 >= 0 && length >= 0) {
                spannableString.setSpan(bVar, a2, length, 33);
            }
            View findViewById4 = inflate.findViewById(R.id.tvHeader2);
            k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.tvHeader2)");
            ((TextView) findViewById4).setText(spannableString);
        } else {
            View findViewById5 = inflate.findViewById(R.id.tvHeader2);
            k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.tvHeader2)");
            ((TextView) findViewById5).setText(charSequence);
        }
        ((TextView) inflate.findViewById(R.id.tvWalletTxnAmount)).setText(getString(R.string.uam_rs_amount, a(this.f59057a)));
        ((TextView) inflate.findViewById(R.id.tvChargesAmount)).setText(getString(R.string.uam_rs_amount, a(this.f59059c)));
        ((TextView) inflate.findViewById(R.id.tvAmountNetPayable)).setText(getString(R.string.uam_rs_amount, a(this.f59058b)));
        if (this.f59061e) {
            ((TextView) inflate.findViewById(R.id.tvNetPayable)).setText(getString(R.string.net_paid));
        } else {
            ((TextView) inflate.findViewById(R.id.tvNetPayable)).setText(getString(R.string.uam_p2b_net_payable));
        }
        dialog.setContentView(inflate);
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            View view = (View) parent;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            view.setBackgroundColor(androidx.core.content.b.c(context, 17170445));
            ((ImageView) inflate.findViewById(R.id.ivClose)).setOnClickListener(new a(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f59064a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59065b;

        b(c cVar, String str) {
            this.f59064a = cVar;
            this.f59065b = str;
        }

        public final void onClick(View view) {
            k.c(view, "textView");
            net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
            Context context = this.f59064a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            Intent j = a2.j(context);
            j.putExtra("url", this.f59065b);
            FragmentActivity activity = this.f59064a.getActivity();
            if (activity != null) {
                activity.startActivity(j);
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#00b9f5"));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f59063a;

        a(c cVar) {
            this.f59063a = cVar;
        }

        public final void onClick(View view) {
            this.f59063a.dismiss();
        }
    }

    private static String a(double d2) {
        String format = new DecimalFormat("########.##").format(d2);
        k.a((Object) format, "DecimalFormat(\"########.##\").format(value)");
        return format;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59062f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
