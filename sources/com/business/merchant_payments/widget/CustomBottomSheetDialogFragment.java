package com.business.merchant_payments.widget;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.j;
import net.one97.paytm.i.f;

public class CustomBottomSheetDialogFragment extends f {
    public Dialog onCreateDialog(Bundle bundle) {
        return new CustomBottomSheetDialog(getContext(), getTheme());
    }

    public void show(j jVar, String str) {
        if (!jVar.o && !jVar.i()) {
            super.show(jVar, str);
        }
    }
}
