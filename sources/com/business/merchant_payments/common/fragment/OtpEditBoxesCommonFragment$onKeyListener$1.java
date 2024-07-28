package com.business.merchant_payments.common.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBinding;
import kotlin.g.b.k;

public final class OtpEditBoxesCommonFragment$onKeyListener$1 implements View.OnKeyListener {
    public final /* synthetic */ OtpEditBoxesCommonFragment this$0;

    public OtpEditBoxesCommonFragment$onKeyListener$1(OtpEditBoxesCommonFragment otpEditBoxesCommonFragment) {
        this.this$0 = otpEditBoxesCommonFragment;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        k.d(view, "v");
        k.d(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (this.this$0.getView() == null || i2 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p = this.this$0.mLayoutBinding;
        CustomTextInputEditText customTextInputEditText = null;
        if (k.a((Object) view, (Object) access$getMLayoutBinding$p != null ? access$getMLayoutBinding$p.editOtpChar1 : null)) {
            OtpEditBoxesCommonFragment otpEditBoxesCommonFragment = this.this$0;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p2 = otpEditBoxesCommonFragment.mLayoutBinding;
            boolean unused = otpEditBoxesCommonFragment.handleDeleteKey(access$getMLayoutBinding$p2 != null ? access$getMLayoutBinding$p2.editOtpChar1 : null, (EditText) null);
            return true;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p3 = this.this$0.mLayoutBinding;
        if (k.a((Object) view, (Object) access$getMLayoutBinding$p3 != null ? access$getMLayoutBinding$p3.editOtpChar2 : null)) {
            OtpEditBoxesCommonFragment otpEditBoxesCommonFragment2 = this.this$0;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p4 = otpEditBoxesCommonFragment2.mLayoutBinding;
            CustomTextInputEditText customTextInputEditText2 = access$getMLayoutBinding$p4 != null ? access$getMLayoutBinding$p4.editOtpChar2 : null;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p5 = this.this$0.mLayoutBinding;
            if (access$getMLayoutBinding$p5 != null) {
                customTextInputEditText = access$getMLayoutBinding$p5.editOtpChar1;
            }
            boolean unused2 = otpEditBoxesCommonFragment2.handleDeleteKey(customTextInputEditText2, customTextInputEditText);
            return true;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p6 = this.this$0.mLayoutBinding;
        if (k.a((Object) view, (Object) access$getMLayoutBinding$p6 != null ? access$getMLayoutBinding$p6.editOtpChar3 : null)) {
            OtpEditBoxesCommonFragment otpEditBoxesCommonFragment3 = this.this$0;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p7 = otpEditBoxesCommonFragment3.mLayoutBinding;
            CustomTextInputEditText customTextInputEditText3 = access$getMLayoutBinding$p7 != null ? access$getMLayoutBinding$p7.editOtpChar3 : null;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p8 = this.this$0.mLayoutBinding;
            if (access$getMLayoutBinding$p8 != null) {
                customTextInputEditText = access$getMLayoutBinding$p8.editOtpChar2;
            }
            boolean unused3 = otpEditBoxesCommonFragment3.handleDeleteKey(customTextInputEditText3, customTextInputEditText);
            return true;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p9 = this.this$0.mLayoutBinding;
        if (k.a((Object) view, (Object) access$getMLayoutBinding$p9 != null ? access$getMLayoutBinding$p9.editOtpChar4 : null)) {
            OtpEditBoxesCommonFragment otpEditBoxesCommonFragment4 = this.this$0;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p10 = otpEditBoxesCommonFragment4.mLayoutBinding;
            CustomTextInputEditText customTextInputEditText4 = access$getMLayoutBinding$p10 != null ? access$getMLayoutBinding$p10.editOtpChar4 : null;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p11 = this.this$0.mLayoutBinding;
            if (access$getMLayoutBinding$p11 != null) {
                customTextInputEditText = access$getMLayoutBinding$p11.editOtpChar3;
            }
            boolean unused4 = otpEditBoxesCommonFragment4.handleDeleteKey(customTextInputEditText4, customTextInputEditText);
            return true;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p12 = this.this$0.mLayoutBinding;
        if (k.a((Object) view, (Object) access$getMLayoutBinding$p12 != null ? access$getMLayoutBinding$p12.editOtpChar5 : null)) {
            OtpEditBoxesCommonFragment otpEditBoxesCommonFragment5 = this.this$0;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p13 = otpEditBoxesCommonFragment5.mLayoutBinding;
            CustomTextInputEditText customTextInputEditText5 = access$getMLayoutBinding$p13 != null ? access$getMLayoutBinding$p13.editOtpChar5 : null;
            MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p14 = this.this$0.mLayoutBinding;
            if (access$getMLayoutBinding$p14 != null) {
                customTextInputEditText = access$getMLayoutBinding$p14.editOtpChar4;
            }
            boolean unused5 = otpEditBoxesCommonFragment5.handleDeleteKey(customTextInputEditText5, customTextInputEditText);
            return true;
        }
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p15 = this.this$0.mLayoutBinding;
        if (!k.a((Object) view, (Object) access$getMLayoutBinding$p15 != null ? access$getMLayoutBinding$p15.editOtpChar6 : null)) {
            return true;
        }
        OtpEditBoxesCommonFragment otpEditBoxesCommonFragment6 = this.this$0;
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p16 = otpEditBoxesCommonFragment6.mLayoutBinding;
        CustomTextInputEditText customTextInputEditText6 = access$getMLayoutBinding$p16 != null ? access$getMLayoutBinding$p16.editOtpChar6 : null;
        MpFragmentOtpEditboxesLytBinding access$getMLayoutBinding$p17 = this.this$0.mLayoutBinding;
        if (access$getMLayoutBinding$p17 != null) {
            customTextInputEditText = access$getMLayoutBinding$p17.editOtpChar5;
        }
        boolean unused6 = otpEditBoxesCommonFragment6.handleDeleteKey(customTextInputEditText6, customTextInputEditText);
        return true;
    }
}
