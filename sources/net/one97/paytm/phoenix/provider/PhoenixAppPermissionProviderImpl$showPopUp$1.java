package net.one97.paytm.phoenix.provider;

import android.view.View;
import com.paytm.utility.h;

final class PhoenixAppPermissionProviderImpl$showPopUp$1 implements View.OnClickListener {
    final /* synthetic */ h $dialog;

    PhoenixAppPermissionProviderImpl$showPopUp$1(h hVar) {
        this.$dialog = hVar;
    }

    public final void onClick(View view) {
        this.$dialog.cancel();
    }
}
