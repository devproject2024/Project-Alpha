package com.sendbird.android;

import com.sendbird.android.UserListQuery;

public final class ParticipantListQuery extends UserListQuery {
    ParticipantListQuery(BaseChannel baseChannel) {
        super(UserListQuery.a.PARTICIPANT, baseChannel);
    }
}
