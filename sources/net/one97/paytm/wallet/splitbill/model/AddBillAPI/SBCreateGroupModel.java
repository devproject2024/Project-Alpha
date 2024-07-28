package net.one97.paytm.wallet.splitbill.model.AddBillAPI;

import com.google.gson.f;
import java.util.ArrayList;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.network.CJRWalletDataModel;
import org.json.JSONObject;

public class SBCreateGroupModel extends CJRWalletDataModel {
    private String client;
    private String createdBy;
    private String createdByCustId;
    private String description;
    private String groupId;
    private String groupName;
    private String name;
    private ArrayList<SBContact> payeeList;
    private ArrayList<SBContact> payerList;
    private String requestId;
    private String splitTag;
    private String totalAmount;
    private ArrayList<SBContact> userList;

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

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String str) {
        this.createdBy = str;
    }

    public String getCreatedByCustId() {
        return this.createdByCustId;
    }

    public void setCreatedByCustId(String str) {
        this.createdByCustId = str;
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

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ArrayList<SBContact> getUserList() {
        return this.userList;
    }

    public void setUserList(ArrayList<SBContact> arrayList) {
        this.userList = arrayList;
    }

    public String getJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("groupId", this.groupId);
            jSONObject.put("requestId", this.requestId);
            jSONObject.put("name", this.name);
            jSONObject.put("splitTag", this.splitTag);
            jSONObject.put(CJRQRScanResultModel.KEY_TOTAL_AMOUNT, this.totalAmount);
            jSONObject.put("payerList", new f().b(this.payerList));
            jSONObject.put("payeeList", new f().b(this.payeeList));
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
