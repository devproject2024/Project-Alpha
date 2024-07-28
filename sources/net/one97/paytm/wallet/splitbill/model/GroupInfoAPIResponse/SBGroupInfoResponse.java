package net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBGroupInfoResponse extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "group")
    @a
    private SBGroupDTO group;
    @c(a = "groupSnapshots")
    @a
    private List<SBGroupSnapshot> groupSnapshots = null;
    @c(a = "requestHistoryResponse")
    @a
    private SBRequestHistoryResponse requestHistoryResponse;

    public SBGroupDTO getGroupDto() {
        return this.group;
    }

    public void setGroupDto(SBGroupDTO sBGroupDTO) {
        this.group = sBGroupDTO;
    }

    public SBRequestHistoryResponse getRequestHistoryResponse() {
        return this.requestHistoryResponse;
    }

    public void setRequestHistoryResponse(SBRequestHistoryResponse sBRequestHistoryResponse) {
        this.requestHistoryResponse = sBRequestHistoryResponse;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public List<SBGroupSnapshot> getGroupSnapshots() {
        return this.groupSnapshots;
    }

    public void setGroupSnapshots(List<SBGroupSnapshot> list) {
        this.groupSnapshots = list;
    }
}
