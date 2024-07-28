package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ErrorDesc extends IJRPaytmDataModel {
    @b(a = "button_action")
    private String buttonAction;
    @b(a = "button_text")
    private String buttonText;
    @b(a = "heading")
    private String heading;
    @b(a = "message")
    private String message;

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public String getButtonAction() {
        return this.buttonAction;
    }

    public void setButtonAction(String str) {
        this.buttonAction = str;
    }
}
