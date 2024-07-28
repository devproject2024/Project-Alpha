package net.one97.paytm.nativesdk.instruments.wallet.widgets;

import android.view.View;
import kotlin.g.a.b;
import kotlin.g.b.k;

final class StickyToolbar$setOrderDetailOnClickListener$1 implements View.OnClickListener {
    final /* synthetic */ b $clickListener;

    StickyToolbar$setOrderDetailOnClickListener$1(b bVar) {
        this.$clickListener = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.$clickListener;
        k.a((Object) view, "it");
        bVar.invoke(view);
    }
}
