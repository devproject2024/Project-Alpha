package net.one97.paytm.common.entity.wallet.chatintegration;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MTSDKReceiverDetail extends IJRPaytmDataModel implements IJRDataModel {
    private final String amount;
    private final String comment;
    private final Boolean isAmountEditable;
    private final String logo;
    private final String name;
    private final IJRDataModel paymentOption;
    private final MTSDKTransferDetail transferDetail;

    public static /* synthetic */ MTSDKReceiverDetail copy$default(MTSDKReceiverDetail mTSDKReceiverDetail, MTSDKTransferDetail mTSDKTransferDetail, String str, String str2, String str3, Boolean bool, String str4, IJRDataModel iJRDataModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mTSDKTransferDetail = mTSDKReceiverDetail.transferDetail;
        }
        if ((i2 & 2) != 0) {
            str = mTSDKReceiverDetail.name;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = mTSDKReceiverDetail.logo;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = mTSDKReceiverDetail.amount;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            bool = mTSDKReceiverDetail.isAmountEditable;
        }
        Boolean bool2 = bool;
        if ((i2 & 32) != 0) {
            str4 = mTSDKReceiverDetail.comment;
        }
        String str8 = str4;
        if ((i2 & 64) != 0) {
            iJRDataModel = mTSDKReceiverDetail.paymentOption;
        }
        return mTSDKReceiverDetail.copy(mTSDKTransferDetail, str5, str6, str7, bool2, str8, iJRDataModel);
    }

    public final MTSDKTransferDetail component1() {
        return this.transferDetail;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.logo;
    }

    public final String component4() {
        return this.amount;
    }

    public final Boolean component5() {
        return this.isAmountEditable;
    }

    public final String component6() {
        return this.comment;
    }

    public final IJRDataModel component7() {
        return this.paymentOption;
    }

    public final MTSDKReceiverDetail copy(MTSDKTransferDetail mTSDKTransferDetail, String str, String str2, String str3, Boolean bool, String str4, IJRDataModel iJRDataModel) {
        k.c(mTSDKTransferDetail, "transferDetail");
        k.c(str, "name");
        return new MTSDKReceiverDetail(mTSDKTransferDetail, str, str2, str3, bool, str4, iJRDataModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MTSDKReceiverDetail)) {
            return false;
        }
        MTSDKReceiverDetail mTSDKReceiverDetail = (MTSDKReceiverDetail) obj;
        return k.a((Object) this.transferDetail, (Object) mTSDKReceiverDetail.transferDetail) && k.a((Object) this.name, (Object) mTSDKReceiverDetail.name) && k.a((Object) this.logo, (Object) mTSDKReceiverDetail.logo) && k.a((Object) this.amount, (Object) mTSDKReceiverDetail.amount) && k.a((Object) this.isAmountEditable, (Object) mTSDKReceiverDetail.isAmountEditable) && k.a((Object) this.comment, (Object) mTSDKReceiverDetail.comment) && k.a((Object) this.paymentOption, (Object) mTSDKReceiverDetail.paymentOption);
    }

    public final int hashCode() {
        MTSDKTransferDetail mTSDKTransferDetail = this.transferDetail;
        int i2 = 0;
        int hashCode = (mTSDKTransferDetail != null ? mTSDKTransferDetail.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.logo;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.isAmountEditable;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str4 = this.comment;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        IJRDataModel iJRDataModel = this.paymentOption;
        if (iJRDataModel != null) {
            i2 = iJRDataModel.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MTSDKReceiverDetail(transferDetail=" + this.transferDetail + ", name=" + this.name + ", logo=" + this.logo + ", amount=" + this.amount + ", isAmountEditable=" + this.isAmountEditable + ", comment=" + this.comment + ", paymentOption=" + this.paymentOption + ")";
    }

    public final MTSDKTransferDetail getTransferDetail() {
        return this.transferDetail;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MTSDKReceiverDetail(MTSDKTransferDetail mTSDKTransferDetail, String str, String str2, String str3, Boolean bool, String str4, IJRDataModel iJRDataModel, int i2, g gVar) {
        this(mTSDKTransferDetail, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? Boolean.FALSE : bool, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : iJRDataModel);
    }

    public final Boolean isAmountEditable() {
        return this.isAmountEditable;
    }

    public final String getComment() {
        return this.comment;
    }

    public final IJRDataModel getPaymentOption() {
        return this.paymentOption;
    }

    public MTSDKReceiverDetail(MTSDKTransferDetail mTSDKTransferDetail, String str, String str2, String str3, Boolean bool, String str4, IJRDataModel iJRDataModel) {
        k.c(mTSDKTransferDetail, "transferDetail");
        k.c(str, "name");
        this.transferDetail = mTSDKTransferDetail;
        this.name = str;
        this.logo = str2;
        this.amount = str3;
        this.isAmountEditable = bool;
        this.comment = str4;
        this.paymentOption = iJRDataModel;
    }
}
