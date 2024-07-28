package net.one97.paytm.p2mNewDesign.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Buttons extends IJRPaytmDataModel implements IJRDataModel {
    private String buttonAction;
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getButtonAction() {
        return this.buttonAction;
    }

    public void setButtonAction(String str) {
        this.buttonAction = str;
    }

    public String toString() {
        return "ClassPojo [text = " + this.text + ", buttonAction = " + this.buttonAction + "]";
    }
}
