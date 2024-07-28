package com.paytm.android.chat.bean;

import com.sendbird.android.GroupChannel;

public class SelectChannelBean {
    private GroupChannel groupChannel;
    private boolean isSelect;

    public GroupChannel getGroupChannel() {
        return this.groupChannel;
    }

    public void setGroupChannel(GroupChannel groupChannel2) {
        this.groupChannel = groupChannel2;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public SelectChannelBean() {
    }

    public SelectChannelBean(GroupChannel groupChannel2, boolean z) {
        this.groupChannel = groupChannel2;
        this.isSelect = z;
    }
}
