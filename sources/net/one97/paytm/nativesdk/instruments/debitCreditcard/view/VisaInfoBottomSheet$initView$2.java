package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.widget.TextView;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.R;

final class VisaInfoBottomSheet$initView$2 extends l implements b<String, x> {
    final /* synthetic */ VisaInfoBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VisaInfoBottomSheet$initView$2(VisaInfoBottomSheet visaInfoBottomSheet) {
        super(1);
        this.this$0 = visaInfoBottomSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        k.c(str, "it");
        TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.tvInfo1);
        k.a((Object) textView, "mView.tvInfo1");
        textView.setText(str);
    }
}
