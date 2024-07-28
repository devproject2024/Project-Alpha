package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;

public class P2PRecentSendMoney extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isSelected;
    private String nickName;
    private RecentSendMoney recentSendMoney;

    public RecentSendMoney getRecentSendMoney() {
        return this.recentSendMoney;
    }

    public void setRecentSendMoney(RecentSendMoney recentSendMoney2) {
        this.recentSendMoney = recentSendMoney2;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
