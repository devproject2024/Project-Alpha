package com.sendbird.android;

import java.util.List;

public class GroupChannelChangeLogsParams {
    protected List<String> customTypes;
    protected boolean includeEmpty;
    protected boolean includeFrozen;

    public GroupChannelChangeLogsParams() {
        this((List<String>) null, true, true);
    }

    public GroupChannelChangeLogsParams(List<String> list, boolean z, boolean z2) {
        this.customTypes = list;
        this.includeEmpty = z;
        this.includeFrozen = z2;
    }

    public void setCustomTypes(List<String> list) {
        this.customTypes = list;
    }

    public void setIncludeEmpty(boolean z) {
        this.includeEmpty = z;
    }

    public void setIncludeFrozen(boolean z) {
        this.includeFrozen = z;
    }

    public List<String> getCustomTypes() {
        return this.customTypes;
    }

    public boolean shouldIncludeEmpty() {
        return this.includeEmpty;
    }

    public boolean shouldIncludeFrozen() {
        return this.includeFrozen;
    }

    public GroupChannelChangeLogsParams clone() {
        return new GroupChannelChangeLogsParams(this.customTypes, this.includeEmpty, this.includeFrozen);
    }

    public static GroupChannelChangeLogsParams from(GroupChannelListQuery groupChannelListQuery) {
        return new GroupChannelChangeLogsParams(groupChannelListQuery.getCustomTypesFilter(), groupChannelListQuery.isIncludeEmpty(), groupChannelListQuery.isIncludeFrozen());
    }

    public String toString() {
        return "GroupChannelChangeLogsParams{customTypes=" + this.customTypes + ", includeEmpty=" + this.includeEmpty + ", includeFrozen=" + this.includeFrozen + '}';
    }
}
