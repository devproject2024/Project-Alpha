package net.one97.paytm.wallet.splitbill.model.AddBillAPI;

import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBAddBillModel extends CJRWalletDataModel {
    private String groupId;
    private String name;
    private ArrayList<SBContact> payeeList;
    private ArrayList<SBContact> payerList;
    private String requestId;
    private String splitTag;
    private String totalAmount;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public ArrayList<SBContact> getPayeeList() {
        return this.payeeList;
    }

    public void setPayeeList(ArrayList<SBContact> arrayList) {
        this.payeeList = arrayList;
    }

    public ArrayList<SBContact> getPayerList() {
        return this.payerList;
    }

    public void setPayerList(ArrayList<SBContact> arrayList) {
        this.payerList = arrayList;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getSplitTag() {
        return this.splitTag;
    }

    public void setSplitTag(String str) {
        this.splitTag = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }
}
