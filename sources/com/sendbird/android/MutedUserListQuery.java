package com.sendbird.android;

import com.sendbird.android.UserListQuery;

public final class MutedUserListQuery extends UserListQuery {
    MutedUserListQuery(BaseChannel baseChannel) {
        super(UserListQuery.a.MUTED_USER, baseChannel);
    }
}
