package com.paytm.business.merchantprofile.view;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.b;

public class CustomBottomSheetDialogFragment extends b {
    public Dialog onCreateDialog(Bundle bundle) {
        return new CustomBottomSheetDialog(getContext(), getTheme());
    }
}
