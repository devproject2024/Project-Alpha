package net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBBillDetailResponse extends CJRWalletDataModel {
    @c(a = "createdBy")
    @a
    private String createdBy;
    @c(a = "createdDate")
    @a
    private String createdDate;
    @c(a = "groupId")
    @a
    private String groupId;
    @c(a = "groupName")
    @a
    private String groupName;
    @c(a = "id")
    @a
    private String id;
    @c(a = "name")
    @a
    private String name;
    @c(a = "splitTag")
    @a
    private String splitTag;
    @c(a = "subRequest")
    @a
    private ArrayList<SBSubRequest> subRequest = null;
    @c(a = "totalAmount")
    @a
    private Double totalAmount;
    @c(a = "updatedBy")
    @a
    private String updatedBy;
    @c(a = "updatedDate")
    @a
    private String updatedDate;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

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

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Double d2) {
        this.totalAmount = d2;
    }

    public String getSplitTag() {
        return this.splitTag;
    }

    public void setSplitTag(String str) {
        this.splitTag = str;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String str) {
        this.createdBy = str;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String str) {
        this.updatedBy = str;
    }

    public String getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(String str) {
        this.updatedDate = str;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String str) {
        this.createdDate = str;
    }

    public ArrayList<SBSubRequest> getSubRequest() {
        return this.subRequest;
    }

    public void setSubRequest(ArrayList<SBSubRequest> arrayList) {
        this.subRequest = arrayList;
    }
}
