package com.sendbird.android;

import com.sendbird.android.UserListQuery;
import java.util.ArrayList;
import java.util.List;

public final class BlockedUserListQuery extends UserListQuery {
    BlockedUserListQuery() {
        super(UserListQuery.a.BLOCKED_USER);
    }

    public final void setUserIdsFilter(List<String> list) {
        if (list != null) {
            this.mUserIds = new ArrayList(list);
        }
    }
}
