package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.verifier.CJRVerifierRenderData;

public class CJRIMPSInitiateExtraInfoDataModel implements IJRDataModel {
    @b(a = "isRetriable")
    protected boolean isRetriable;
    @b(a = "tooltip_message")
    protected String tooltip_message;
    @b(a = "transfer_type")
    protected String transferType;
    @b(a = "verification_method")
    protected String verification_method;
    @b(a = "verification_methods")
    protected String verification_methods;
    @b(a = "verify_id")
    protected String verify_id;
    @b(a = "verify_render_data")
    protected CJRVerifierRenderData verify_render_data;

    public String getVerification_method() {
        return this.verification_method;
    }

    public void setVerification_method(String str) {
        this.verification_method = str;
    }

    public String getVerification_methods() {
        return this.verification_methods;
    }

    public void setVerification_methods(String str) {
        this.verification_methods = str;
    }

    public CJRVerifierRenderData getVerify_render_data() {
        return this.verify_render_data;
    }

    public void setVerify_render_data(CJRVerifierRenderData cJRVerifierRenderData) {
        this.verify_render_data = cJRVerifierRenderData;
    }

    public String getVerify_id() {
        return this.verify_id;
    }

    public void setVerify_id(String str) {
        this.verify_id = str;
    }

    public String getToolTipMessage() {
        return this.tooltip_message;
    }

    public void setToolTipMessage(String str) {
        this.tooltip_message = str;
    }

    public String getTransferType() {
        return this.transferType;
    }

    public void setTransferType(String str) {
        this.transferType = str;
    }

    public boolean isRetriable() {
        return this.isRetriable;
    }

    public void setRetriable(boolean z) {
        this.isRetriable = z;
    }
}
