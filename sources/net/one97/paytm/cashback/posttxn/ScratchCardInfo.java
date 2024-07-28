package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ScratchCardInfo extends IJRPaytmDataModel {
    @b(a = "displayType")
    private String displayType;
    @b(a = "id")
    private String id;
    @b(a = "randomIndex")
    private String randomIndex;
    @b(a = "scratched")
    private String scratched;
    @b(a = "unlockText")
    private String unlockText;

    public String getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(String str) {
        this.displayType = str;
    }

    public String getScratched() {
        return this.scratched;
    }

    public void setScratched(String str) {
        this.scratched = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getRandomIndex() {
        return this.randomIndex;
    }

    public void setRandomIndex(String str) {
        this.randomIndex = str;
    }

    public String getUnlockText() {
        return this.unlockText;
    }
}
