package com.paytm.business.merchantprofile.common;

import android.text.TextWatcher;
import kotlin.g.b.k;

public final class OtpEditBoxesCommonFragment$passcodeChange$1 implements TextWatcher {
    public final /* synthetic */ OtpEditBoxesCommonFragment this$0;

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.d(charSequence, "s");
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.d(charSequence, "s");
    }

    public OtpEditBoxesCommonFragment$passcodeChange$1(OtpEditBoxesCommonFragment otpEditBoxesCommonFragment) {
        this.this$0 = otpEditBoxesCommonFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        r5 = r5.editOtpChar1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void afterTextChanged(android.text.Editable r5) {
        /*
            r4 = this;
            java.lang.String r0 = "s"
            kotlin.g.b.k.d(r5, r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            android.view.View r5 = r5.getView()
            if (r5 == 0) goto L_0x01eb
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x001e
            com.business.common_module.view.widget.CustomTextView r5 = r5.errorOtpTv
            if (r5 == 0) goto L_0x001e
            r0 = 8
            r5.setVisibility(r0)
        L_0x001e:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            r0 = 0
            if (r5 == 0) goto L_0x0030
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar1
            if (r5 == 0) goto L_0x0030
            android.text.Editable r5 = r5.getText()
            goto L_0x0031
        L_0x0030:
            r5 = r0
        L_0x0031:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = ""
            boolean r5 = r5.equals(r1)
            r2 = 1
            if (r5 == 0) goto L_0x0053
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x004d
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar1
            if (r5 == 0) goto L_0x004d
            r5.requestFocus()
        L_0x004d:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setBlueBackground(r2)
            return
        L_0x0053:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x0064
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar2
            if (r5 == 0) goto L_0x0064
            android.text.Editable r5 = r5.getText()
            goto L_0x0065
        L_0x0064:
            r5 = r0
        L_0x0065:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r5.equals(r1)
            r3 = 0
            if (r5 == 0) goto L_0x00a9
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x007f
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar2
            if (r5 == 0) goto L_0x007f
            r5.requestFocus()
        L_0x007f:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x008e
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar1
            if (r5 == 0) goto L_0x008e
            r5.setEnabled(r3)
        L_0x008e:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x009d
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar3
            if (r5 == 0) goto L_0x009d
            r5.setEnabled(r2)
        L_0x009d:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r0 = 2
            r5.setBlueBackground(r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setIndex(r0)
            return
        L_0x00a9:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x00ba
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar3
            if (r5 == 0) goto L_0x00ba
            android.text.Editable r5 = r5.getText()
            goto L_0x00bb
        L_0x00ba:
            r5 = r0
        L_0x00bb:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00fe
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x00d4
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar3
            if (r5 == 0) goto L_0x00d4
            r5.requestFocus()
        L_0x00d4:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x00e3
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar2
            if (r5 == 0) goto L_0x00e3
            r5.setEnabled(r3)
        L_0x00e3:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x00f2
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar4
            if (r5 == 0) goto L_0x00f2
            r5.setEnabled(r2)
        L_0x00f2:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r0 = 3
            r5.setBlueBackground(r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setIndex(r0)
            return
        L_0x00fe:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x010f
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar4
            if (r5 == 0) goto L_0x010f
            android.text.Editable r5 = r5.getText()
            goto L_0x0110
        L_0x010f:
            r5 = r0
        L_0x0110:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0153
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x0129
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar4
            if (r5 == 0) goto L_0x0129
            r5.requestFocus()
        L_0x0129:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x0138
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar3
            if (r5 == 0) goto L_0x0138
            r5.setEnabled(r3)
        L_0x0138:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x0147
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar5
            if (r5 == 0) goto L_0x0147
            r5.setEnabled(r2)
        L_0x0147:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r0 = 4
            r5.setBlueBackground(r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setIndex(r0)
            return
        L_0x0153:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x0164
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar5
            if (r5 == 0) goto L_0x0164
            android.text.Editable r5 = r5.getText()
            goto L_0x0165
        L_0x0164:
            r5 = r0
        L_0x0165:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x01a8
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x017e
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar5
            if (r5 == 0) goto L_0x017e
            r5.requestFocus()
        L_0x017e:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x018d
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar4
            if (r5 == 0) goto L_0x018d
            r5.setEnabled(r3)
        L_0x018d:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x019c
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar6
            if (r5 == 0) goto L_0x019c
            r5.setEnabled(r2)
        L_0x019c:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r0 = 5
            r5.setBlueBackground(r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setIndex(r0)
            return
        L_0x01a8:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x01b8
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar6
            if (r5 == 0) goto L_0x01b8
            android.text.Editable r0 = r5.getText()
        L_0x01b8:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x01eb
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x01d1
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar6
            if (r5 == 0) goto L_0x01d1
            r5.requestFocus()
        L_0x01d1:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBinding r5 = r5.mLayoutBinding
            if (r5 == 0) goto L_0x01e0
            com.business.common_module.view.widget.CustomTextInputEditText r5 = r5.editOtpChar5
            if (r5 == 0) goto L_0x01e0
            r5.setEnabled(r3)
        L_0x01e0:
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r0 = 6
            r5.setBlueBackground(r0)
            com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment r5 = r4.this$0
            r5.setIndex(r0)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment$passcodeChange$1.afterTextChanged(android.text.Editable):void");
    }
}
