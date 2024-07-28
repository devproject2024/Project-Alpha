package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.CharacterWrapTextView;

final class AppInvokeSheet$setUpUI$5 implements View.OnClickListener {
    final /* synthetic */ AppInvokeSheet this$0;

    AppInvokeSheet$setUpUI$5(AppInvokeSheet appInvokeSheet) {
        this.this$0 = appInvokeSheet;
    }

    public final void onClick(View view) {
        CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) this.this$0._$_findCachedViewById(R.id.order_id);
        k.a((Object) characterWrapTextView, "order_id");
        characterWrapTextView.setMaxLines(2);
        ((CharacterWrapTextView) this.this$0._$_findCachedViewById(R.id.order_id)).setTextIsSelectable(true);
    }
}
