package net.one97.paytm.wallet.splitbill.model.CreateGroupAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class SBUserList implements IJRDataModel {
    @c(a = "admin")
    @a
    private Boolean admin;
    @c(a = "name")
    @a
    private String name;
    @c(a = "self")
    @a
    private Boolean self;
    @c(a = "userId")
    @a
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
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
