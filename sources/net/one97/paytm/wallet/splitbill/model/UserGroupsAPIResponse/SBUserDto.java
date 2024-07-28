package net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserDto extends CJRWalletDataModel {
    @c(a = "admin")
    @a
    private Boolean admin;
    @c(a = "custId")
    @a
    private String custId;
    @c(a = "name")
    @a
    private String name;
    @c(a = "self")
    @a
    private Boolean self;
    @c(a = "userId")
    @a
    private String userId;

    public SBUserDto(String str, String str2, Boolean bool, Boolean bool2) {
        this.userId = str;
        this.name = str2;
        this.admin = bool;
        this.self = bool2;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean bool) {
        this.admin = bool;
    }

    public Boolean getSelf() {
        return this.self;
    }

    public void setSelf(Boolean bool) {
        this.self = bool;
    }
}
