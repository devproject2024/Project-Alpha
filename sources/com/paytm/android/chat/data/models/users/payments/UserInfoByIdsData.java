package com.paytm.android.chat.data.models.users.payments;

import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import java.util.Map;
import kotlin.g.b.k;

public final class UserInfoByIdsData {
    @b(a = "userDTOMap")
    private Map<String, ? extends UsersInfoJsonBean> map;

    public static /* synthetic */ UserInfoByIdsData copy$default(UserInfoByIdsData userInfoByIdsData, Map<String, ? extends UsersInfoJsonBean> map2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map2 = userInfoByIdsData.map;
        }
        return userInfoByIdsData.copy(map2);
    }

    public final Map<String, UsersInfoJsonBean> component1() {
        return this.map;
    }

    public final UserInfoByIdsData copy(Map<String, ? extends UsersInfoJsonBean> map2) {
        return new UserInfoByIdsData(map2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UserInfoByIdsData) && k.a((Object) this.map, (Object) ((UserInfoByIdsData) obj).map);
        }
        return true;
    }

    public final int hashCode() {
        Map<String, ? extends UsersInfoJsonBean> map2 = this.map;
        if (map2 != null) {
            return map2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "UserInfoByIdsData(map=" + this.map + ")";
    }

    public UserInfoByIdsData(Map<String, ? extends UsersInfoJsonBean> map2) {
        this.map = map2;
    }

    public final Map<String, UsersInfoJsonBean> getMap() {
        return this.map;
    }

    public final void setMap(Map<String, ? extends UsersInfoJsonBean> map2) {
        this.map = map2;
    }
}
