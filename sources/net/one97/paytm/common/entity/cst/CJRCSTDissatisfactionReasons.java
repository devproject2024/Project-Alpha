package net.one97.paytm.common.entity.cst;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTDissatisfactionReasons implements IJRDataModel {
    private boolean isSelected;
    @c(a = "reason")
    @a
    private String reason;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
