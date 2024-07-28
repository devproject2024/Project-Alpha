package net.one97.paytm.paymentsBank.createfd.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class OptionsModel extends IJRPaytmDataModel {
    private String amt;
    private int iconId;
    private Integer tag;
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getIconId() {
        return this.iconId;
    }

    public final void setIconId(int i2) {
        this.iconId = i2;
    }

    public final Integer getTag() {
        return this.tag;
    }

    public final void setTag(Integer num) {
        this.tag = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OptionsModel(String str, int i2, Integer num, String str2, int i3, g gVar) {
        this((i3 & 1) != 0 ? null : str, i2, num, (i3 & 8) != 0 ? null : str2);
    }

    public final String getAmt() {
        return this.amt;
    }

    public final void setAmt(String str) {
        this.amt = str;
    }

    public OptionsModel(String str, int i2, Integer num, String str2) {
        this.title = str;
        this.iconId = i2;
        this.tag = num;
        this.amt = str2;
    }
}
