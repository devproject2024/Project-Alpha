package net.one97.paytm.common.entity.p2p;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ExtraData extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    private String amount;
    private String comment;
    private boolean isAmountEditable;
    private boolean isCommentEditable;
    private boolean isGalleryScan;
    private boolean isMidScan;

    public ExtraData() {
        this((String) null, (String) null, false, false, false, false, 63, (g) null);
    }

    public static /* synthetic */ ExtraData copy$default(ExtraData extraData, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = extraData.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = extraData.comment;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            z = extraData.isAmountEditable;
        }
        boolean z5 = z;
        if ((i2 & 8) != 0) {
            z2 = extraData.isCommentEditable;
        }
        boolean z6 = z2;
        if ((i2 & 16) != 0) {
            z3 = extraData.isGalleryScan;
        }
        boolean z7 = z3;
        if ((i2 & 32) != 0) {
            z4 = extraData.isMidScan;
        }
        return extraData.copy(str, str3, z5, z6, z7, z4);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.comment;
    }

    public final boolean component3() {
        return this.isAmountEditable;
    }

    public final boolean component4() {
        return this.isCommentEditable;
    }

    public final boolean component5() {
        return this.isGalleryScan;
    }

    public final boolean component6() {
        return this.isMidScan;
    }

    public final ExtraData copy(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return new ExtraData(str, str2, z, z2, z3, z4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ExtraData) {
                ExtraData extraData = (ExtraData) obj;
                if (k.a((Object) this.amount, (Object) extraData.amount) && k.a((Object) this.comment, (Object) extraData.comment)) {
                    if (this.isAmountEditable == extraData.isAmountEditable) {
                        if (this.isCommentEditable == extraData.isCommentEditable) {
                            if (this.isGalleryScan == extraData.isGalleryScan) {
                                if (this.isMidScan == extraData.isMidScan) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.amount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.comment;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.isAmountEditable;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isCommentEditable;
        if (z2) {
            z2 = true;
        }
        int i5 = (i4 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isGalleryScan;
        if (z3) {
            z3 = true;
        }
        int i6 = (i5 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isMidScan;
        if (z4) {
            z4 = true;
        }
        return i6 + (z4 ? 1 : 0);
    }

    public final String toString() {
        return "ExtraData(amount=" + this.amount + ", comment=" + this.comment + ", isAmountEditable=" + this.isAmountEditable + ", isCommentEditable=" + this.isCommentEditable + ", isGalleryScan=" + this.isGalleryScan + ", isMidScan=" + this.isMidScan + ")";
    }

    public ExtraData(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.amount = str;
        this.comment = str2;
        this.isAmountEditable = z;
        this.isCommentEditable = z2;
        this.isGalleryScan = z3;
        this.isMidScan = z4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ExtraData(java.lang.String r5, java.lang.String r6, boolean r7, boolean r8, boolean r9, boolean r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r6
        L_0x000e:
            r5 = r11 & 4
            r6 = 0
            if (r5 == 0) goto L_0x0015
            r1 = 0
            goto L_0x0016
        L_0x0015:
            r1 = r7
        L_0x0016:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001c
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = r8
        L_0x001d:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0023
            r3 = 0
            goto L_0x0024
        L_0x0023:
            r3 = r9
        L_0x0024:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002a
            r11 = 0
            goto L_0x002b
        L_0x002a:
            r11 = r10
        L_0x002b:
            r5 = r4
            r6 = r12
            r7 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.ExtraData.<init>(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getComment() {
        return this.comment;
    }

    public final boolean isAmountEditable() {
        return this.isAmountEditable;
    }

    public final boolean isCommentEditable() {
        return this.isCommentEditable;
    }

    public final boolean isGalleryScan() {
        return this.isGalleryScan;
    }

    public final boolean isMidScan() {
        return this.isMidScan;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setAmountEditable(boolean z) {
        this.isAmountEditable = z;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final void setCommentEditable(boolean z) {
        this.isCommentEditable = z;
    }

    public final void setGalleryScan(boolean z) {
        this.isGalleryScan = z;
    }

    public final void setMidScan(boolean z) {
        this.isMidScan = z;
    }
}
