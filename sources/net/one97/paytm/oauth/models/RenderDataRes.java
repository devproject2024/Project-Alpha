package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class RenderDataRes extends IJRPaytmDataModel {
    @c(a = "account_encrypt_pubkey")
    private final String account_encrypt_pubkey;
    @c(a = "account_encrypt_salt")
    private final String account_encrypt_salt;
    @c(a = "encryption")
    private final String encryption;
    @c(a = "foot_tip")
    private final String footTip;
    @c(a = "form_button")
    private final String formButton;
    @c(a = "form_title")
    private final String formTitle;
    @c(a = "HAS_OTHERS")
    private final Boolean hasOthers = Boolean.FALSE;
    @c(a = "head_title")
    private final String headTitle;
    @c(a = "inputType")
    private final String inputType;
    @c(a = "masked_card_list")
    private final String masked_card_list;
    @c(a = "mobile_no")
    private final String mobileNo;
    @c(a = "source")
    private final String source;
    @c(a = "templateId")
    private final String templateId;

    public final Boolean getHasOthers() {
        return this.hasOthers;
    }

    public final String getFormTitle() {
        return this.formTitle;
    }

    public final String getEncryption() {
        return this.encryption;
    }

    public final String getMobileNo() {
        return this.mobileNo;
    }

    public final String getInputType() {
        return this.inputType;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getHeadTitle() {
        return this.headTitle;
    }

    public final String getFormButton() {
        return this.formButton;
    }

    public final String getFootTip() {
        return this.footTip;
    }

    public final String getAccount_encrypt_pubkey() {
        return this.account_encrypt_pubkey;
    }

    public final String getAccount_encrypt_salt() {
        return this.account_encrypt_salt;
    }

    public final String getMasked_card_list() {
        return this.masked_card_list;
    }
}
