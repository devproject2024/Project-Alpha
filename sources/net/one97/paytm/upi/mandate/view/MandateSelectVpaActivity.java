package net.one97.paytm.upi.mandate.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.mandate.p2p.CreateMandateActivity;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;

public final class MandateSelectVpaActivity extends RequestMoneyV2Activity {
    public final int a() {
        return R.layout.activity_mandate_select_vpa;
    }

    public final int b() {
        return R.string.upi_mandate_contact_title;
    }

    public final String c() {
        String string = getString(R.string.money_transfer_saved_accounts);
        k.a((Object) string, "getString(R.string.money_transfer_saved_accounts)");
        return string;
    }

    public final void d() {
        super.d();
        String string = getString(R.string.upi_mandate_subtitle);
        k.a((Object) string, "getString(R.string.upi_mandate_subtitle)");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        a aVar = new a(this);
        String string2 = getString(R.string.upi_mandate_know_more);
        k.a((Object) string2, "getString(R.string.upi_mandate_know_more)");
        if (!TextUtils.isEmpty(string2)) {
            int a2 = p.a(charSequence, string2, 0, false, 6);
            int length = string2.length() + a2;
            if (a2 > 0 && length > 0 && a2 < length) {
                spannableString.setSpan(aVar, a2, length, 33);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), a2, length, 33);
            }
        }
        TextView textView = (TextView) findViewById(R.id.tv_title);
        k.a((Object) textView, "tvSubtitle");
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateSelectVpaActivity f67464a;

        a(MandateSelectVpaActivity mandateSelectVpaActivity) {
            this.f67464a = mandateSelectVpaActivity;
        }

        public final void onClick(View view) {
            k.c(view, "textView");
            new c().show(this.f67464a.getSupportFragmentManager(), "KnowMoreBS");
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    public final void a(Bundle bundle) {
        Intent intent = new Intent(this, CreateMandateActivity.class);
        intent.putExtra("payee_details", bundle);
        intent.putExtra("KEY_VERIFIED_VPA_RESPONSE", this.f69219b);
        startActivityForResult(intent, RequestMoneyV2Activity.f69217c);
        finish();
    }
}
