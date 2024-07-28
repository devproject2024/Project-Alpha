package net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBGroupDTO extends CJRWalletDataModel {
    @c(a = "client")
    @a
    private String client;
    @c(a = "createdAt")
    @a
    private String createdAt;
    @c(a = "createdBy")
    @a
    private String createdBy;
    @c(a = "description")
    @a
    private String description;
    @c(a = "groupId")
    @a
    private String groupId;
    @c(a = "name")
    @a
    private String name;
    @c(a = "updatedAt")
    @a
    private String updatedAt;
    @c(a = "updatedBy")
    @a
    private String updatedBy;
    @c(a = "userList")
    @a
    private ArrayList<SBUserList> userList = null;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public ArrayList<SBUserList> getUserList() {
        return this.userList;
    }

    public void setUserList(ArrayList<SBUserList> arrayList) {
        this.userList = arrayList;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
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

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }
}
