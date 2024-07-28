package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantLimitInfoV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "excludedPaymodes")
    private ArrayList<String> excludedPaymodes;
    @b(a = "merchantPaymodesLimits")
    private List<MerchantPaymodesLimits> merchantPaymodesLimits;
    @b(a = "merchantRemainingLimits")
    private ArrayList<MerchantRemainingLimitsV2> merchantRemainingLimits;
    @b(a = "message")
    private String message;

    public MerchantLimitInfoV2() {
        this((ArrayList) null, (ArrayList) null, (String) null, (List) null, 15, (g) null);
    }

    public static /* synthetic */ MerchantLimitInfoV2 copy$default(MerchantLimitInfoV2 merchantLimitInfoV2, ArrayList<MerchantRemainingLimitsV2> arrayList, ArrayList<String> arrayList2, String str, List<MerchantPaymodesLimits> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = merchantLimitInfoV2.merchantRemainingLimits;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = merchantLimitInfoV2.excludedPaymodes;
        }
        if ((i2 & 4) != 0) {
            str = merchantLimitInfoV2.message;
        }
        if ((i2 & 8) != 0) {
            list = merchantLimitInfoV2.merchantPaymodesLimits;
        }
        return merchantLimitInfoV2.copy(arrayList, arrayList2, str, list);
    }

    public final ArrayList<MerchantRemainingLimitsV2> component1() {
        return this.merchantRemainingLimits;
    }

    public final ArrayList<String> component2() {
        return this.excludedPaymodes;
    }

    public final String component3() {
        return this.message;
    }

    public final List<MerchantPaymodesLimits> component4() {
        return this.merchantPaymodesLimits;
    }

    public final MerchantLimitInfoV2 copy(ArrayList<MerchantRemainingLimitsV2> arrayList, ArrayList<String> arrayList2, String str, List<MerchantPaymodesLimits> list) {
        return new MerchantLimitInfoV2(arrayList, arrayList2, str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantLimitInfoV2)) {
            return false;
        }
        MerchantLimitInfoV2 merchantLimitInfoV2 = (MerchantLimitInfoV2) obj;
        return k.a((Object) this.merchantRemainingLimits, (Object) merchantLimitInfoV2.merchantRemainingLimits) && k.a((Object) this.excludedPaymodes, (Object) merchantLimitInfoV2.excludedPaymodes) && k.a((Object) this.message, (Object) merchantLimitInfoV2.message) && k.a((Object) this.merchantPaymodesLimits, (Object) merchantLimitInfoV2.merchantPaymodesLimits);
    }

    public final int hashCode() {
        ArrayList<MerchantRemainingLimitsV2> arrayList = this.merchantRemainingLimits;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<String> arrayList2 = this.excludedPaymodes;
        int hashCode2 = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        String str = this.message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<MerchantPaymodesLimits> list = this.merchantPaymodesLimits;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MerchantLimitInfoV2(merchantRemainingLimits=" + this.merchantRemainingLimits + ", excludedPaymodes=" + this.excludedPaymodes + ", message=" + this.message + ", merchantPaymodesLimits=" + this.merchantPaymodesLimits + ")";
    }

    public MerchantLimitInfoV2(ArrayList<MerchantRemainingLimitsV2> arrayList, ArrayList<String> arrayList2, String str, List<MerchantPaymodesLimits> list) {
        this.merchantRemainingLimits = arrayList;
        this.excludedPaymodes = arrayList2;
        this.message = str;
        this.merchantPaymodesLimits = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantLimitInfoV2(ArrayList arrayList, ArrayList arrayList2, String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : arrayList2, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : list);
    }

    public final ArrayList<String> getExcludedPaymodes() {
        return this.excludedPaymodes;
    }

    public final List<MerchantPaymodesLimits> getMerchantPaymodesLimits() {
        return this.merchantPaymodesLimits;
    }

    public final ArrayList<MerchantRemainingLimitsV2> getMerchantRemainingLimits() {
        return this.merchantRemainingLimits;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setExcludedPaymodes(ArrayList<String> arrayList) {
        this.excludedPaymodes = arrayList;
    }

    public final void setMerchantPaymodesLimits(List<MerchantPaymodesLimits> list) {
        this.merchantPaymodesLimits = list;
    }

    public final void setMerchantRemainingLimits(ArrayList<MerchantRemainingLimitsV2> arrayList) {
        this.merchantRemainingLimits = arrayList;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
