package net.one97.paytm.wallet.splitbill.model.UserToUserExpensesAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBGroupWiseSummary extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private Double amount;
    @c(a = "groupId")
    @a
    private String groupId;
    @c(a = "groupName")
    @a
    private String groupName;
    @c(a = "nonGroupSnapshot")
    @a
    private Boolean nonGroupSnapshot;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double d2) {
        this.amount = d2;
    }

    public Boolean getNonGroupSnapshot() {
        return this.nonGroupSnapshot;
    }

    public void setNonGroupSnapshot(Boolean bool) {
        this.nonGroupSnapshot = bool;
    }
}
