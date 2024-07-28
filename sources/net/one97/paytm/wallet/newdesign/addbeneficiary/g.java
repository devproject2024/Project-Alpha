package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class g extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f70638a;

    /* renamed from: b  reason: collision with root package name */
    String f70639b;

    /* renamed from: c  reason: collision with root package name */
    String f70640c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70641d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70642e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70643f;

    public static g a() {
        return new g();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_success_bottom_sheet, viewGroup, false);
        this.f70641d = (TextView) inflate.findViewById(R.id.tv_success_message);
        this.f70643f = (TextView) inflate.findViewById(R.id.footer_txt);
        this.f70642e = (TextView) inflate.findViewById(R.id.tv_message_cool_off_period);
        if (!TextUtils.isEmpty(this.f70639b)) {
            this.f70641d.setText("Added " + this.f70639b + " as a beneficiary");
        } else {
            this.f70641d.setText("Added " + this.f70640c + " as a beneficiary");
        }
        String stringFromGTM = b.a().getStringFromGTM(this.f70638a, "p2pBeneficiaryCoolingPeriod");
        String stringFromGTM2 = b.a().getStringFromGTM(this.f70638a, "p2pBeneficiaryCoolingAmt");
        String string = getString(R.string.you_can_manage_your_beneficiaries_from);
        String string2 = getString(R.string.payment_settings);
        String str = string + " " + string2;
        int indexOf = str.indexOf(string2);
        int length = str.length();
        TextView textView = this.f70643f;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                g.this.f70638a.startActivity(b.a().openManageBeneficiaryIntent(g.this.f70638a));
                g.this.dismissAllowingStateLoss();
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(g.this.getResources().getColor(R.color.color_00b9f5));
            }
        }, indexOf, length, 33);
        textView.setText(spannableString);
        this.f70643f.setClickable(true);
        this.f70643f.setMovementMethod(LinkMovementMethod.getInstance());
        String string3 = getString(R.string.important_with_colon);
        String str2 = string3 + " " + getString(R.string.add_bene_success_message, stringFromGTM, stringFromGTM2);
        int indexOf2 = str2.indexOf(string3);
        int length2 = string3.length();
        TextView textView2 = this.f70642e;
        SpannableString spannableString2 = new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_ffad00)), indexOf2, length2, 33);
        textView2.setText(spannableString2);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                g.this.b();
            }
        }, 5000);
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        dismissAllowingStateLoss();
    }
}
