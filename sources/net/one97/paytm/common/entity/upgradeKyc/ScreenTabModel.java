package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ScreenTabModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "tab1")
    private String mTab1;
    @b(a = "tab2")
    private String mTab2;
    @b(a = "tab3")
    private String mTab3;

    public String getTab1() {
        return this.mTab1;
    }

    public void setTab1(String str) {
        this.mTab1 = str;
    }

    public String getTab2() {
        return this.mTab2;
    }

    public void setTab2(String str) {
        this.mTab2 = str;
    }

    public String getTab3() {
        return this.mTab3;
    }

    public void setTab3(String str) {
        this.mTab3 = str;
    }
}
