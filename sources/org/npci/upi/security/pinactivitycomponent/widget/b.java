package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.View;

class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73036a;

    b(FormItemEditText formItemEditText) {
        this.f73036a = formItemEditText;
    }

    public void onClick(View view) {
        FormItemEditText formItemEditText = this.f73036a;
        formItemEditText.setSelection(formItemEditText.getText().length());
        if (this.f73036a.r != null) {
            this.f73036a.r.onClick(view);
        }
    }
}
