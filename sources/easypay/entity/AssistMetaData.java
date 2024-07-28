package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;

public class AssistMetaData implements Serializable {
    @c(a = "fieldHtml")
    private String fieldHtml;
    @c(a = "jsField")
    private String jsField;
    @c(a = "msgKeywords")
    private String msgKeywords;
    @c(a = "msgPattern")
    private String msgPattern;
    @c(a = "msgSender")
    private String msgSender;
    @c(a = "passwordId")
    private String passwordId;
    @c(a = "userId")
    private String userId;

    public String getFieldHtml() {
        return this.fieldHtml;
    }

    public void setFieldHtml(String str) {
        this.fieldHtml = str;
    }

    public String getMsgPattern() {
        return this.msgPattern;
    }

    public void setMsgPattern(String str) {
        this.msgPattern = str;
    }

    public String getJsField() {
        return this.jsField;
    }

    public void setJsField(String str) {
        this.jsField = str;
    }

    public String getMsgKeywords() {
        return this.msgKeywords;
    }

    public void setMsgKeywords(String str) {
        this.msgKeywords = str;
    }

    public String getMsgSender() {
        return this.msgSender;
    }

    public void setMsgSender(String str) {
        this.msgSender = str;
    }

    public String getPasswordId() {
        return this.passwordId;
    }

    public void setPasswordId(String str) {
        this.passwordId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
