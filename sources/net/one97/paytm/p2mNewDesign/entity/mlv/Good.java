package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Good extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "category")
    private String category;
    @b(a = "description")
    private String description;
    @b(a = "extendInfo")
    private ExtendInfo extendInfo;
    @b(a = "merchantGoodsId")
    private Integer merchantGoodsId;
    @b(a = "price")
    private Price price;
    @b(a = "quantity")
    private Integer quantity;
    @b(a = "snapshotUrl")
    private String snapshotUrl;

    public Good() {
        this((Integer) null, (String) null, (Integer) null, (Price) null, (String) null, (String) null, (ExtendInfo) null, 127, (g) null);
    }

    public static /* synthetic */ Good copy$default(Good good, Integer num, String str, Integer num2, Price price2, String str2, String str3, ExtendInfo extendInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = good.merchantGoodsId;
        }
        if ((i2 & 2) != 0) {
            str = good.description;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            num2 = good.quantity;
        }
        Integer num3 = num2;
        if ((i2 & 8) != 0) {
            price2 = good.price;
        }
        Price price3 = price2;
        if ((i2 & 16) != 0) {
            str2 = good.category;
        }
        String str5 = str2;
        if ((i2 & 32) != 0) {
            str3 = good.snapshotUrl;
        }
        String str6 = str3;
        if ((i2 & 64) != 0) {
            extendInfo2 = good.extendInfo;
        }
        return good.copy(num, str4, num3, price3, str5, str6, extendInfo2);
    }

    public final Integer component1() {
        return this.merchantGoodsId;
    }

    public final String component2() {
        return this.description;
    }

    public final Integer component3() {
        return this.quantity;
    }

    public final Price component4() {
        return this.price;
    }

    public final String component5() {
        return this.category;
    }

    public final String component6() {
        return this.snapshotUrl;
    }

    public final ExtendInfo component7() {
        return this.extendInfo;
    }

    public final Good copy(Integer num, String str, Integer num2, Price price2, String str2, String str3, ExtendInfo extendInfo2) {
        return new Good(num, str, num2, price2, str2, str3, extendInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Good)) {
            return false;
        }
        Good good = (Good) obj;
        return k.a((Object) this.merchantGoodsId, (Object) good.merchantGoodsId) && k.a((Object) this.description, (Object) good.description) && k.a((Object) this.quantity, (Object) good.quantity) && k.a((Object) this.price, (Object) good.price) && k.a((Object) this.category, (Object) good.category) && k.a((Object) this.snapshotUrl, (Object) good.snapshotUrl) && k.a((Object) this.extendInfo, (Object) good.extendInfo);
    }

    public final int hashCode() {
        Integer num = this.merchantGoodsId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.quantity;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Price price2 = this.price;
        int hashCode4 = (hashCode3 + (price2 != null ? price2.hashCode() : 0)) * 31;
        String str2 = this.category;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.snapshotUrl;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ExtendInfo extendInfo2 = this.extendInfo;
        if (extendInfo2 != null) {
            i2 = extendInfo2.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "Good(merchantGoodsId=" + this.merchantGoodsId + ", description=" + this.description + ", quantity=" + this.quantity + ", price=" + this.price + ", category=" + this.category + ", snapshotUrl=" + this.snapshotUrl + ", extendInfo=" + this.extendInfo + ")";
    }

    public Good(Integer num, String str, Integer num2, Price price2, String str2, String str3, ExtendInfo extendInfo2) {
        this.merchantGoodsId = num;
        this.description = str;
        this.quantity = num2;
        this.price = price2;
        this.category = str2;
        this.snapshotUrl = str3;
        this.extendInfo = extendInfo2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Good(java.lang.Integer r7, java.lang.String r8, java.lang.Integer r9, net.one97.paytm.p2mNewDesign.entity.mlv.Price r10, java.lang.String r11, java.lang.String r12, net.one97.paytm.p2mNewDesign.entity.mlv.ExtendInfo r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.Good.<init>(java.lang.Integer, java.lang.String, java.lang.Integer, net.one97.paytm.p2mNewDesign.entity.mlv.Price, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.ExtendInfo, int, kotlin.g.b.g):void");
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public final Integer getMerchantGoodsId() {
        return this.merchantGoodsId;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final String getSnapshotUrl() {
        return this.snapshotUrl;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setExtendInfo(ExtendInfo extendInfo2) {
        this.extendInfo = extendInfo2;
    }

    public final void setMerchantGoodsId(Integer num) {
        this.merchantGoodsId = num;
    }

    public final void setPrice(Price price2) {
        this.price = price2;
    }

    public final void setQuantity(Integer num) {
        this.quantity = num;
    }

    public final void setSnapshotUrl(String str) {
        this.snapshotUrl = str;
    }
}
