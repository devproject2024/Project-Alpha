package net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;

public class SBGroupDetailsDtoList extends CJRWalletDataModel {
    @c(a = "groupId")
    @a
    private String groupId;
    @c(a = "name")
    @a
    private String name;
    @c(a = "totalUser")
    @a
    private Integer totalUser;
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

    public ArrayList<SBUserList> getUserDtoList() {
        return this.userList;
    }

    public void setUserDtoList(ArrayList<SBUserList> arrayList) {
        this.userList = arrayList;
    }

    public Integer getTotalUser() {
        return this.totalUser;
    }

    public void setTotalUser(Integer num) {
        this.totalUser = num;
    }
}
