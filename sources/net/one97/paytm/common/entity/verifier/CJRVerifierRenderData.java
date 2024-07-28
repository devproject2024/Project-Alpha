package net.one97.paytm.common.entity.verifier;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifierRenderData implements IJRDataModel {
    @b(a = "HAS_OTHERS")
    private String HAS_OTHERS;
    @b(a = "account_encrypt_pubkey")
    private String account_encrypt_pubkey;
    @b(a = "account_encrypt_salt")
    private String account_encrypt_salt;
    @b(a = "callbackUrl")
    private String callbackUrl;
    @b(a = "encryption")
    private String encryption;
    @b(a = "foot_tip")
    private String foot_tip;
    @b(a = "form_button")
    private String form_button;
    @b(a = "form_input_tip_low")
    private String form_input_tip_low;
    @b(a = "form_input_tip_up")
    private String form_input_tip_up;
    @b(a = "form_title")
    private String form_title;
    @b(a = "head_tip")
    private String head_tip;
    @b(a = "head_title")
    private String head_title;
    @b(a = "inputCharCount")
    private String inputCharCount;
    @b(a = "inputType")
    private String inputType;
    @b(a = "methods")
    private ArrayList<CJRVerifierMethods> methods;
    @b(a = "mobile_no")
    private String mobile_no;
    @b(a = "source")
    private String source;
    @b(a = "templateId")
    private String templateId;

    public String getMobile_no() {
        return this.mobile_no;
    }

    public void setMobile_no(String str) {
        this.mobile_no = str;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public String getHAS_OTHERS() {
        return this.HAS_OTHERS;
    }

    public void setHAS_OTHERS(String str) {
        this.HAS_OTHERS = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getInputCharCount() {
        return this.inputCharCount;
    }

    public void setInputCharCount(String str) {
        this.inputCharCount = str;
    }

    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String str) {
        this.inputType = str;
    }

    public String getEncryption() {
        return this.encryption;
    }

    public void setEncryption(String str) {
        this.encryption = str;
    }

    public String getHeadTip() {
        return this.head_tip;
    }

    public void setHeadTip(String str) {
        this.head_tip = str;
    }

    public String getHead_title() {
        return this.head_title;
    }

    public void setHead_title(String str) {
        this.head_title = str;
    }

    public String getForm_input_tip_up() {
        return this.form_input_tip_up;
    }

    public void setForm_input_tip_up(String str) {
        this.form_input_tip_up = str;
    }

    public String getForm_title() {
        return this.form_title;
    }

    public void setForm_title(String str) {
        this.form_title = str;
    }

    public String getForm_input_tip_low() {
        return this.form_input_tip_low;
    }

    public void setForm_input_tip_low(String str) {
        this.form_input_tip_low = str;
    }

    public String getForm_button() {
        return this.form_button;
    }

    public void setForm_button(String str) {
        this.form_button = str;
    }

    public String getFoot_tip() {
        return this.foot_tip;
    }

    public void setFoot_tip(String str) {
        this.foot_tip = str;
    }

    public ArrayList<CJRVerifierMethods> getMethods() {
        return this.methods;
    }

    public void setMethods(ArrayList<CJRVerifierMethods> arrayList) {
        this.methods = arrayList;
    }

    public String getAccountEncryptPubkey() {
        return this.account_encrypt_pubkey;
    }

    public void setAccountEncryptPubkey(String str) {
        this.account_encrypt_pubkey = str;
    }

    public String getAccountEncryptSalt() {
        return this.account_encrypt_salt;
    }

    public void setAccountEncryptSalt(String str) {
        this.account_encrypt_salt = str;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public class CJRVerifierMethods implements IJRDataModel {
        @b(a = "code")
        private String code;
        @b(a = "name")
        private String name;

        public CJRVerifierMethods() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }
    }
}
