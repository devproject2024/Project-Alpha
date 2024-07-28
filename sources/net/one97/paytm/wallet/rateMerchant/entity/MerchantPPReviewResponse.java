package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MerchantPPReviewResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private MerchantPPReviewData data;
    @b(a = "meta")
    private b meta;

    public MerchantPPReviewResponse() {
        this((b) null, (MerchantPPReviewData) null, 3, (g) null);
    }

    public static /* synthetic */ MerchantPPReviewResponse copy$default(MerchantPPReviewResponse merchantPPReviewResponse, b bVar, MerchantPPReviewData merchantPPReviewData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bVar = merchantPPReviewResponse.meta;
        }
        if ((i2 & 2) != 0) {
            merchantPPReviewData = merchantPPReviewResponse.data;
        }
        return merchantPPReviewResponse.copy(bVar, merchantPPReviewData);
    }

    public final b component1() {
        return this.meta;
    }

    public final MerchantPPReviewData component2() {
        return this.data;
    }

    public final MerchantPPReviewResponse copy(b bVar, MerchantPPReviewData merchantPPReviewData) {
        return new MerchantPPReviewResponse(bVar, merchantPPReviewData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantPPReviewResponse)) {
            return false;
        }
        MerchantPPReviewResponse merchantPPReviewResponse = (MerchantPPReviewResponse) obj;
        return k.a((Object) this.meta, (Object) merchantPPReviewResponse.meta) && k.a((Object) this.data, (Object) merchantPPReviewResponse.data);
    }

    public final int hashCode() {
        b bVar = this.meta;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        MerchantPPReviewData merchantPPReviewData = this.data;
        if (merchantPPReviewData != null) {
            i2 = merchantPPReviewData.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MerchantPPReviewResponse(meta=" + this.meta + ", data=" + this.data + ")";
    }

    public final b getMeta() {
        return this.meta;
    }

    public final void setMeta(b bVar) {
        this.meta = bVar;
    }

    public MerchantPPReviewResponse(b bVar, MerchantPPReviewData merchantPPReviewData) {
        this.meta = bVar;
        this.data = merchantPPReviewData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantPPReviewResponse(b bVar, MerchantPPReviewData merchantPPReviewData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bVar, (i2 & 2) != 0 ? null : merchantPPReviewData);
    }

    public final MerchantPPReviewData getData() {
        return this.data;
    }

    public final void setData(MerchantPPReviewData merchantPPReviewData) {
        this.data = merchantPPReviewData;
    }
}
