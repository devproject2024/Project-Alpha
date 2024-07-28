package com.business.common_module.view;

import android.app.Dialog;
import android.os.Bundle;

public class b extends com.google.android.material.bottomsheet.b {
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }
}
