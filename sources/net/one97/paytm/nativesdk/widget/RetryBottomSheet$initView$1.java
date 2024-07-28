package net.one97.paytm.nativesdk.widget;

import android.widget.TextView;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.R;

final class RetryBottomSheet$initView$1 extends l implements b<String, x> {
    final /* synthetic */ RetryBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RetryBottomSheet$initView$1(RetryBottomSheet retryBottomSheet) {
        super(1);
        this.this$0 = retryBottomSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        k.c(str, "it");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.native_message);
        k.a((Object) textView, "native_message");
        textView.setText(str);
    }
}
