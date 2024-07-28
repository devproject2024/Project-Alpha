package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.nativesdk.R;

final class VisaInfoBottomSheet$initView$3 extends l implements b<String, x> {
    final /* synthetic */ VisaInfoBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VisaInfoBottomSheet$initView$3(VisaInfoBottomSheet visaInfoBottomSheet) {
        super(1);
        this.this$0 = visaInfoBottomSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        String str2;
        k.c(str, "value");
        Context context = this.this$0.getContext();
        if (context != null) {
            str2 = context.getString(R.string.important_note_one_click_payment, new Object[]{str});
        } else {
            str2 = null;
        }
        SpannableString spannableString = new SpannableString(str2);
        CharSequence charSequence = spannableString;
        int a2 = p.a(charSequence, "IMPORTANT :", 0, true, 2);
        int i2 = 11 + a2;
        Context context2 = this.this$0.getContext();
        if (context2 == null) {
            k.a();
        }
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context2, R.color.pending_color)), a2, i2, 17);
        TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.importantNote);
        k.a((Object) textView, "mView.importantNote");
        textView.setText(charSequence);
    }
}
