package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.View;

class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73037a;

    c(FormItemEditText formItemEditText) {
        this.f73037a = formItemEditText;
    }

    public boolean onLongClick(View view) {
        FormItemEditText formItemEditText = this.f73037a;
        formItemEditText.setSelection(formItemEditText.getText().length());
        return true;
    }
}
