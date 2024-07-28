package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.CharacterWrapTextView;

final class InstrumentsSheet$onCreateView$3 implements View.OnClickListener {
    public static final InstrumentsSheet$onCreateView$3 INSTANCE = new InstrumentsSheet$onCreateView$3();

    InstrumentsSheet$onCreateView$3() {
    }

    public final void onClick(View view) {
        k.a((Object) view, "it");
        CharacterWrapTextView characterWrapTextView = (CharacterWrapTextView) view.findViewById(R.id.order_id);
        k.a((Object) characterWrapTextView, "it.order_id");
        characterWrapTextView.setMaxLines(2);
        ((CharacterWrapTextView) view.findViewById(R.id.order_id)).setTextIsSelectable(true);
    }
}
