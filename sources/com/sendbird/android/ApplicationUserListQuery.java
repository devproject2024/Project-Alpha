package com.sendbird.android;

import com.sendbird.android.UserListQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ApplicationUserListQuery extends UserListQuery {
    ApplicationUserListQuery() {
        super(UserListQuery.a.FILTERED_USER);
    }

    public final void setUserIdsFilter(List<String> list) {
        if (list != null) {
            this.mUserIds = new ArrayList(list);
        }
    }

    public final void setMetaDataFilter(String str, List<String> list) {
        if (str != null && list != null) {
            this.mMetaDataFilter = new HashMap();
            this.mMetaDataFilter.put(str, list);
        }
    }
}
