package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLayoutParams implements IJRDataModel {
    @b(a = "label")
    private String label;
    @b(a = "label_bgcolor")
    private String labelBgColor;
    @b(a = "label_text_color")
    private String labelColor;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getLabelColor() {
        return this.labelColor;
    }

    public void setLabelColor(String str) {
        this.labelColor = str;
    }

    public String getLabelBgColor() {
        return this.labelBgColor;
    }

    public void setLabelBgColor(String str) {
        this.labelBgColor = str;
    }
}
