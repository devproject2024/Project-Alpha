package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;

public class AssistRequest implements Serializable {
    @c(a = "bnkCode")
    private String bank;
    @c(a = "cardScheme")
    private String cardScheme;
    @c(a = "payType")
    private String payType;

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
}
