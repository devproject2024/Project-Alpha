package net.one97.paytm.recharge.legacy.catalog.model.v2;

import java.util.List;
import net.one97.paytm.recharge.legacy.catalog.model.CJRRichMessage;

public class CJRRechargeProductAttributesAlertV2 extends CJRRechargeProductAttributesErrorV2 {
    private String checkBoxText;
    private String heading;
    private List<CJRRichMessage> richMessage;

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public List<CJRRichMessage> getRichMessage() {
        return this.richMessage;
    }

    public void setRichMessage(List<CJRRichMessage> list) {
        this.richMessage = list;
    }

    public String getCheckBoxText() {
        return this.checkBoxText;
    }

    public void setCheckBoxText(String str) {
        this.checkBoxText = str;
    }
}
