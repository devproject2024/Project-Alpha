package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.RecentScan;

public final class P2MRecentScan extends IJRPaytmDataModel implements IJRDataModel {
    private String imageUrl;
    private boolean isSelected;
    private String name;
    private String nickName;
    private String phoneNumber;
    private RecentScan recentScan = new RecentScan();

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final RecentScan getRecentScan() {
        return this.recentScan;
    }

    public final void setRecentScan(RecentScan recentScan2) {
        k.c(recentScan2, "<set-?>");
        this.recentScan = recentScan2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
