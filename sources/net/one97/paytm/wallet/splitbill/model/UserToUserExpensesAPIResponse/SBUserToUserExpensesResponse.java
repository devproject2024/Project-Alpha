package net.one97.paytm.wallet.splitbill.model.UserToUserExpensesAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;

public class SBUserToUserExpensesResponse extends CJRWalletDataModel {
    @c(a = "groupWiseSummary")
    @a
    private List<SBGroupWiseSummary> groupWiseSummary = null;
    @c(a = "netBalance")
    @a
    private Double netBalance;
    @c(a = "nextPage")
    @a
    private Boolean nextPage;
    @c(a = "nonGrpTotal")
    @a
    private Double nonGrpTotal;
    @c(a = "offset")
    @a
    private String offset;
    @c(a = "requestHistoryList")
    @a
    private List<SBRequestHistory> requestHistoryList = null;
    @c(a = "toPay")
    @a
    private Double toPay;
    @c(a = "toReceive")
    @a
    private Double toReceive;
    @c(a = "userId")
    @a
    private String userId;
    @c(a = "userMobile")
    @a
    private String userMobile;
    @c(a = "userName")
    @a
    private String userName;

    public String getUserMobile() {
        return this.userMobile;
    }

    public void setUserMobile(String str) {
        this.userMobile = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public Double getToPay() {
        return this.toPay;
    }

    public void setToPay(Double d2) {
        this.toPay = d2;
    }

    public Double getToReceive() {
        return this.toReceive;
    }

    public void setToReceive(Double d2) {
        this.toReceive = d2;
    }

    public Double getNetBalance() {
        return this.netBalance;
    }

    public void setNetBalance(Double d2) {
        this.netBalance = d2;
    }

    public Boolean getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Boolean bool) {
        this.nextPage = bool;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public List<SBRequestHistory> getRequestHistoryList() {
        return this.requestHistoryList;
    }

    public void setRequestHistoryList(List<SBRequestHistory> list) {
        this.requestHistoryList = list;
    }

    public List<SBGroupWiseSummary> getGroupWiseSummary() {
        return this.groupWiseSummary;
    }

    public void setGroupWiseSummary(List<SBGroupWiseSummary> list) {
        this.groupWiseSummary = list;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public Double getNonGrpTotal() {
        return this.nonGrpTotal;
    }

    public void setNonGrpTotal(Double d2) {
        this.nonGrpTotal = d2;
    }
}
