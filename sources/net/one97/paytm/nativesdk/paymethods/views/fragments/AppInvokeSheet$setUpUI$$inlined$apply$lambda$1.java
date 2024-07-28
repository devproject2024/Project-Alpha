package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;

final class AppInvokeSheet$setUpUI$$inlined$apply$lambda$1 extends l implements b<View, x> {
    final /* synthetic */ AppInvokeSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppInvokeSheet$setUpUI$$inlined$apply$lambda$1(AppInvokeSheet appInvokeSheet) {
        super(1);
        this.this$0 = appInvokeSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return x.f47997a;
    }

    public final void invoke(View view) {
        k.c(view, "it");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
