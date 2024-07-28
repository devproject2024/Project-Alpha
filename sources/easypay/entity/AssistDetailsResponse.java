package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class AssistDetailsResponse implements Serializable {
    @c(a = "bankName")
    private String bank;
    @c(a = "cardScheme")
    private String cardScheme;
    @c(a = "enabled")
    private Boolean enabled;
    @c(a = "etag")
    private String etag;
    @c(a = "payMode")
    private String payType;
    @c(a = "pages")
    private ArrayList<AssistUrlResponse> response = null;

    public String getCardScheme() {
        return this.cardScheme;
    }

    public void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String str) {
        this.payType = str;
    }

    public ArrayList<AssistUrlResponse> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<AssistUrlResponse> arrayList) {
        this.response = arrayList;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AssistDetailsResponse)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AssistDetailsResponse assistDetailsResponse = (AssistDetailsResponse) obj;
        return (getBank() + getPayType() + getCardScheme()).equals(assistDetailsResponse.getBank() + assistDetailsResponse.getPayType() + assistDetailsResponse.getCardScheme());
    }

    public String toString() {
        return getBank() + getPayType() + getCardScheme();
    }
}
