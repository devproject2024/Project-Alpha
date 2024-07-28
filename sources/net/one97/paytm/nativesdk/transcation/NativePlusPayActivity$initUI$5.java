package net.one97.paytm.nativesdk.transcation;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.text.Editable;
import android.widget.TextView;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import kotlin.g.b.k;
import kotlin.j.d;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.transcation.OtpEditText;

public final class NativePlusPayActivity$initUI$5 implements OtpEditText.OnTextChangedListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$initUI$5(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onTextChanged() {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
        k.a((Object) textView, "tvInvalidOtpText");
        textView.setVisibility(8);
        this.this$0.hideOtpErrorView();
        boolean z = true;
        d dVar = new d(1, 5);
        OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        Editable text = otpEditText.getText();
        Integer valueOf = text != null ? Integer.valueOf(text.length()) : null;
        if (valueOf == null || !dVar.a(valueOf.intValue())) {
            z = false;
        }
        if (z) {
            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_OTP_MANUALLY_REQUESTED, "true");
        }
        OtpEditText otpEditText2 = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText2, "otpEditText");
        Editable text2 = otpEditText2.getText();
        if (text2 == null) {
            k.a();
        }
        if (text2.length() >= 6) {
            this.this$0.hideKeyboard();
            OtpEditText otpEditText3 = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
            k.a((Object) otpEditText3, "otpEditText");
            otpEditText3.setActive(false);
            if (!this.this$0.isOtpAutoFilled && !this.this$0.isOtpPasted) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_DIRECT_OTP_INPUT_ACTION, "manual_input", ""));
            }
        }
        OtpEditText otpEditText4 = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText4, "otpEditText");
        Editable text3 = otpEditText4.getText();
        if (text3 == null) {
            k.a();
        }
        if (text3.length() == 0) {
            this.this$0.isOtpAutoFilled = false;
            this.this$0.isOtpPasted = false;
        }
    }

    public final void onTextPasted() {
        ClipDescription primaryClipDescription;
        try {
            Object systemService = this.this$0.getSystemService("clipboard");
            if (systemService != null) {
                ClipboardManager clipboardManager = (ClipboardManager) systemService;
                if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null && primaryClipDescription.hasMimeType("text/plain")) {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    boolean z = false;
                    CharSequence charSequence = null;
                    ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
                    if (itemAt != null) {
                        charSequence = itemAt.getText();
                    }
                    String valueOf = String.valueOf(charSequence);
                    if (valueOf.length() == 0) {
                        z = true;
                    }
                    if (!z && !this.this$0.isValidItemPasted(valueOf)) {
                        this.this$0.showOtpValidationError();
                    }
                    OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
                    k.a((Object) otpEditText, "otpEditText");
                    Editable text = otpEditText.getText();
                    if (text == null) {
                        k.a();
                    }
                    if (text.length() == 6) {
                        this.this$0.isOtpPasted = true;
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_DIRECT_OTP_INPUT_ACTION, "copy_paste", ""));
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.content.ClipboardManager");
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }
}
