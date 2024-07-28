package net.one97.paytm.common.entity.wallet;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRWarningMessageContainer extends CJRWalletDataModel implements IJRDataModel {
    private String priority;
    private String state;
    private String warningMessage;

    public String getWarningMessage() {
        return this.warningMessage;
    }

    public void setWarningMessage(String str) {
        this.warningMessage = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public String toString() {
        return "ClassPojo [warningMessage = " + this.warningMessage + ", state = " + this.state + ", priority = " + this.priority + "]";
    }
}
