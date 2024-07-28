package net.one97.paytm.recharge.model.v4;

import java.util.List;
import kotlin.g.b.k;

public final class CJRNextGroupData {
    private final List<CJRAggsItem> aggs;
    private final GroupAttributesItem groupAttributesItem;
    private final int groupLevel;
    private final String groupName;

    public static /* synthetic */ CJRNextGroupData copy$default(CJRNextGroupData cJRNextGroupData, int i2, String str, GroupAttributesItem groupAttributesItem2, List<CJRAggsItem> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = cJRNextGroupData.groupLevel;
        }
        if ((i3 & 2) != 0) {
            str = cJRNextGroupData.groupName;
        }
        if ((i3 & 4) != 0) {
            groupAttributesItem2 = cJRNextGroupData.groupAttributesItem;
        }
        if ((i3 & 8) != 0) {
            list = cJRNextGroupData.aggs;
        }
        return cJRNextGroupData.copy(i2, str, groupAttributesItem2, list);
    }

    public final int component1() {
        return this.groupLevel;
    }

    public final String component2() {
        return this.groupName;
    }

    public final GroupAttributesItem component3() {
        return this.groupAttributesItem;
    }

    public final List<CJRAggsItem> component4() {
        return this.aggs;
    }

    public final CJRNextGroupData copy(int i2, String str, GroupAttributesItem groupAttributesItem2, List<CJRAggsItem> list) {
        return new CJRNextGroupData(i2, str, groupAttributesItem2, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRNextGroupData) {
                CJRNextGroupData cJRNextGroupData = (CJRNextGroupData) obj;
                if (!(this.groupLevel == cJRNextGroupData.groupLevel) || !k.a((Object) this.groupName, (Object) cJRNextGroupData.groupName) || !k.a((Object) this.groupAttributesItem, (Object) cJRNextGroupData.groupAttributesItem) || !k.a((Object) this.aggs, (Object) cJRNextGroupData.aggs)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.groupLevel * 31;
        String str = this.groupName;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        GroupAttributesItem groupAttributesItem2 = this.groupAttributesItem;
        int hashCode2 = (hashCode + (groupAttributesItem2 != null ? groupAttributesItem2.hashCode() : 0)) * 31;
        List<CJRAggsItem> list = this.aggs;
        if (list != null) {
            i3 = list.hashCode();
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        return "CJRNextGroupData(groupLevel=" + this.groupLevel + ", groupName=" + this.groupName + ", groupAttributesItem=" + this.groupAttributesItem + ", aggs=" + this.aggs + ")";
    }

    public CJRNextGroupData(int i2, String str, GroupAttributesItem groupAttributesItem2, List<CJRAggsItem> list) {
        this.groupLevel = i2;
        this.groupName = str;
        this.groupAttributesItem = groupAttributesItem2;
        this.aggs = list;
    }

    public final int getGroupLevel() {
        return this.groupLevel;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final GroupAttributesItem getGroupAttributesItem() {
        return this.groupAttributesItem;
    }

    public final List<CJRAggsItem> getAggs() {
        return this.aggs;
    }
}
