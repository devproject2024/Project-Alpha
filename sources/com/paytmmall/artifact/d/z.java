package com.paytmmall.artifact.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

final class z extends ProgressDialog {

    /* renamed from: a  reason: collision with root package name */
    private Activity f15754a;

    z(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.f15754a = (Activity) context;
        }
    }

    public final void dismiss() {
        Activity activity = this.f15754a;
        if (activity != null && !activity.isFinishing()) {
            super.dismiss();
        }
    }
}
