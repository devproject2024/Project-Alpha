package com.imsdk;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelListQuery;
import com.sendbird.android.SendBirdException;
import io.reactivex.rxjava3.a.z;
import java.util.List;

public final class CPCSendbirdWrapper$fetchChannelList$1$1$1 implements GroupChannelListQuery.GroupChannelListQueryResultHandler {
    final /* synthetic */ List $channelList;
    final /* synthetic */ z $emitter;
    final /* synthetic */ GroupChannelListQuery $mChannelListQuery;

    CPCSendbirdWrapper$fetchChannelList$1$1$1(List list, z zVar, GroupChannelListQuery groupChannelListQuery) {
        this.$channelList = list;
        this.$emitter = zVar;
        this.$mChannelListQuery = groupChannelListQuery;
    }

    public final void onResult(List<GroupChannel> list, SendBirdException sendBirdException) {
        if (sendBirdException != null) {
            if (this.$channelList.size() == 0) {
                this.$emitter.onError(sendBirdException);
            } else {
                this.$emitter.onSuccess(this.$channelList);
            }
        } else if (this.$mChannelListQuery.hasNext()) {
            if (list != null) {
                this.$channelList.addAll(list);
            }
            this.$mChannelListQuery.next(this);
        } else {
            if (list != null) {
                this.$channelList.addAll(list);
            }
            this.$emitter.onSuccess(this.$channelList);
        }
    }
}
