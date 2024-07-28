package net.one97.paytm.common.entity.wallet.chatintegration;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MTSDKPayRequestor extends IJRPaytmDataModel implements IJRDataModel {
    private final MTSDKReceiverDetail receiverDetails;
    private final int source;

    public static /* synthetic */ MTSDKPayRequestor copy$default(MTSDKPayRequestor mTSDKPayRequestor, int i2, MTSDKReceiverDetail mTSDKReceiverDetail, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = mTSDKPayRequestor.source;
        }
        if ((i3 & 2) != 0) {
            mTSDKReceiverDetail = mTSDKPayRequestor.receiverDetails;
        }
        return mTSDKPayRequestor.copy(i2, mTSDKReceiverDetail);
    }

    public final int component1() {
        return this.source;
    }

    public final MTSDKReceiverDetail component2() {
        return this.receiverDetails;
    }

    public final MTSDKPayRequestor copy(int i2, MTSDKReceiverDetail mTSDKReceiverDetail) {
        k.c(mTSDKReceiverDetail, "receiverDetails");
        return new MTSDKPayRequestor(i2, mTSDKReceiverDetail);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MTSDKPayRequestor) {
                MTSDKPayRequestor mTSDKPayRequestor = (MTSDKPayRequestor) obj;
                if (!(this.source == mTSDKPayRequestor.source) || !k.a((Object) this.receiverDetails, (Object) mTSDKPayRequestor.receiverDetails)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.source * 31;
        MTSDKReceiverDetail mTSDKReceiverDetail = this.receiverDetails;
        return i2 + (mTSDKReceiverDetail != null ? mTSDKReceiverDetail.hashCode() : 0);
    }

    public final String toString() {
        return "MTSDKPayRequestor(source=" + this.source + ", receiverDetails=" + this.receiverDetails + ")";
    }

    public final int getSource() {
        return this.source;
    }

    public final MTSDKReceiverDetail getReceiverDetails() {
        return this.receiverDetails;
    }

    public MTSDKPayRequestor(int i2, MTSDKReceiverDetail mTSDKReceiverDetail) {
        k.c(mTSDKReceiverDetail, "receiverDetails");
        this.source = i2;
        this.receiverDetails = mTSDKReceiverDetail;
    }
}
