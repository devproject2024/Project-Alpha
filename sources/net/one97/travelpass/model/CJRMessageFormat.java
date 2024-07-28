package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRMessageFormat extends IJRPaytmDataModel {
    @b(a = "action")
    private String action;
    @b(a = "button_text")
    private String buttonText;
    @b(a = "message")
    private String message;
    @b(a = "title")
    private String title;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
