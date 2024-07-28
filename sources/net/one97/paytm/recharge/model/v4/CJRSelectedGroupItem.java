package net.one97.paytm.recharge.model.v4;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRSelectedGroupItem extends IJRPaytmDataModel {
    private String groupDisplayName;
    private String groupName;
    private String groupType;
    private CJRAggsItem item;
    private int itemIndex;
    private String value;

    public CJRSelectedGroupItem() {
        this((String) null, (String) null, (String) null, (String) null, 0, (CJRAggsItem) null, 63, (g) null);
    }

    public static /* synthetic */ CJRSelectedGroupItem copy$default(CJRSelectedGroupItem cJRSelectedGroupItem, String str, String str2, String str3, String str4, int i2, CJRAggsItem cJRAggsItem, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cJRSelectedGroupItem.groupName;
        }
        if ((i3 & 2) != 0) {
            str2 = cJRSelectedGroupItem.groupType;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = cJRSelectedGroupItem.groupDisplayName;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = cJRSelectedGroupItem.value;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i2 = cJRSelectedGroupItem.itemIndex;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            cJRAggsItem = cJRSelectedGroupItem.item;
        }
        return cJRSelectedGroupItem.copy(str, str5, str6, str7, i4, cJRAggsItem);
    }

    public final String component1() {
        return this.groupName;
    }

    public final String component2() {
        return this.groupType;
    }

    public final String component3() {
        return this.groupDisplayName;
    }

    public final String component4() {
        return this.value;
    }

    public final int component5() {
        return this.itemIndex;
    }

    public final CJRAggsItem component6() {
        return this.item;
    }

    public final CJRSelectedGroupItem copy(String str, String str2, String str3, String str4, int i2, CJRAggsItem cJRAggsItem) {
        return new CJRSelectedGroupItem(str, str2, str3, str4, i2, cJRAggsItem);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRSelectedGroupItem) {
                CJRSelectedGroupItem cJRSelectedGroupItem = (CJRSelectedGroupItem) obj;
                if (k.a((Object) this.groupName, (Object) cJRSelectedGroupItem.groupName) && k.a((Object) this.groupType, (Object) cJRSelectedGroupItem.groupType) && k.a((Object) this.groupDisplayName, (Object) cJRSelectedGroupItem.groupDisplayName) && k.a((Object) this.value, (Object) cJRSelectedGroupItem.value)) {
                    if (!(this.itemIndex == cJRSelectedGroupItem.itemIndex) || !k.a((Object) this.item, (Object) cJRSelectedGroupItem.item)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.groupName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.groupType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.groupDisplayName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.value;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.itemIndex) * 31;
        CJRAggsItem cJRAggsItem = this.item;
        if (cJRAggsItem != null) {
            i2 = cJRAggsItem.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CJRSelectedGroupItem(groupName=" + this.groupName + ", groupType=" + this.groupType + ", groupDisplayName=" + this.groupDisplayName + ", value=" + this.value + ", itemIndex=" + this.itemIndex + ", item=" + this.item + ")";
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String str) {
        this.groupName = str;
    }

    public final String getGroupType() {
        return this.groupType;
    }

    public final void setGroupType(String str) {
        this.groupType = str;
    }

    public final String getGroupDisplayName() {
        return this.groupDisplayName;
    }

    public final void setGroupDisplayName(String str) {
        this.groupDisplayName = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final int getItemIndex() {
        return this.itemIndex;
    }

    public final void setItemIndex(int i2) {
        this.itemIndex = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSelectedGroupItem(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, net.one97.paytm.recharge.model.v4.CJRAggsItem r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0024
            r10 = 0
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002b
            r12 = r0
            goto L_0x002c
        L_0x002b:
            r12 = r11
        L_0x002c:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, net.one97.paytm.recharge.model.v4.CJRAggsItem, int, kotlin.g.b.g):void");
    }

    public final CJRAggsItem getItem() {
        return this.item;
    }

    public final void setItem(CJRAggsItem cJRAggsItem) {
        this.item = cJRAggsItem;
    }

    public CJRSelectedGroupItem(String str, String str2, String str3, String str4, int i2, CJRAggsItem cJRAggsItem) {
        this.groupName = str;
        this.groupType = str2;
        this.groupDisplayName = str3;
        this.value = str4;
        this.itemIndex = i2;
        this.item = cJRAggsItem;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSelectedGroupItem(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r8 = 0
            r9 = 0
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.g.b.g):void");
    }

    public CJRSelectedGroupItem(String str, String str2, String str3, String str4, int i2) {
        this(str, str2, str3, str4, i2, (CJRAggsItem) null);
    }
}
