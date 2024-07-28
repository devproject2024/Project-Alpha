package com.sendbird.android;

import com.sendbird.android.UserListQuery;

public final class BannedUserListQuery extends UserListQuery {
    BannedUserListQuery(BaseChannel baseChannel) {
        super(UserListQuery.a.BANNED_USER, baseChannel);
    }
}
