package org.npci.upi.security.pinactivitycomponent.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.business.merchant_payments.common.utility.AppUtility;

class j implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemView f73044a;

    j(FormItemView formItemView) {
        this.f73044a = formItemView;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f73044a.f73027a) {
            String unused = this.f73044a.n = editable.toString();
        } else if (this.f73044a.o) {
            String unused2 = this.f73044a.n = editable.toString();
        } else if (editable.length() == 0) {
            String unused3 = this.f73044a.n = "";
        } else if (this.f73044a.n.length() > editable.length()) {
            FormItemView formItemView = this.f73044a;
            String unused4 = formItemView.n = formItemView.n.substring(0, this.f73044a.n.length() - 1);
        } else {
            char charAt = editable.toString().charAt(editable.length() - 1);
            if (charAt != 9679) {
                FormItemView formItemView2 = this.f73044a;
                String unused5 = formItemView2.n = formItemView2.n.concat(String.valueOf(charAt));
                this.f73044a.f73032f.setText(this.f73044a.n.replaceAll(AppUtility.CENTER_DOT, "●"));
                return;
            }
            this.f73044a.f73032f.setSelection(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f73044a.f73033g != null && this.f73044a.f73032f.getText() != null && this.f73044a.f73032f.getText().length() >= this.f73044a.f73030d) {
            this.f73044a.f73033g.a(this.f73044a.f73034h, this.f73044a.f73032f.getText().toString());
        }
    }
}
