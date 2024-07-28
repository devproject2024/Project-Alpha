package com.business.merchant_payments.model.kyc;

import com.business.common_module.e.b;
import com.business.merchant_payments.profile.model.kyc.ExtendedInfo;
import java.util.List;
import kotlin.g.b.k;

public final class Results {
    public final BankEditStatus bankEditStatus;
    public final Banks banks;
    public final BwFrequency bwFrequency;
    public final ExtendedInfo extendedInfo;
    public final List<Kyc> kyc;
    public final b updatedContext;

    public static /* synthetic */ Results copy$default(Results results, BankEditStatus bankEditStatus2, Banks banks2, BwFrequency bwFrequency2, List<Kyc> list, ExtendedInfo extendedInfo2, b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bankEditStatus2 = results.bankEditStatus;
        }
        if ((i2 & 2) != 0) {
            banks2 = results.banks;
        }
        Banks banks3 = banks2;
        if ((i2 & 4) != 0) {
            bwFrequency2 = results.bwFrequency;
        }
        BwFrequency bwFrequency3 = bwFrequency2;
        if ((i2 & 8) != 0) {
            list = results.kyc;
        }
        List<Kyc> list2 = list;
        if ((i2 & 16) != 0) {
            extendedInfo2 = results.extendedInfo;
        }
        ExtendedInfo extendedInfo3 = extendedInfo2;
        if ((i2 & 32) != 0) {
            bVar = results.updatedContext;
        }
        return results.copy(bankEditStatus2, banks3, bwFrequency3, list2, extendedInfo3, bVar);
    }

    public final BankEditStatus component1() {
        return this.bankEditStatus;
    }

    public final Banks component2() {
        return this.banks;
    }

    public final BwFrequency component3() {
        return this.bwFrequency;
    }

    public final List<Kyc> component4() {
        return this.kyc;
    }

    public final ExtendedInfo component5() {
        return this.extendedInfo;
    }

    public final b component6() {
        return this.updatedContext;
    }

    public final Results copy(BankEditStatus bankEditStatus2, Banks banks2, BwFrequency bwFrequency2, List<Kyc> list, ExtendedInfo extendedInfo2, b bVar) {
        k.d(bankEditStatus2, "bankEditStatus");
        k.d(banks2, "banks");
        k.d(bwFrequency2, "bwFrequency");
        k.d(list, "kyc");
        k.d(extendedInfo2, "extendedInfo");
        k.d(bVar, "updatedContext");
        return new Results(bankEditStatus2, banks2, bwFrequency2, list, extendedInfo2, bVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Results)) {
            return false;
        }
        Results results = (Results) obj;
        return k.a((Object) this.bankEditStatus, (Object) results.bankEditStatus) && k.a((Object) this.banks, (Object) results.banks) && k.a((Object) this.bwFrequency, (Object) results.bwFrequency) && k.a((Object) this.kyc, (Object) results.kyc) && k.a((Object) this.extendedInfo, (Object) results.extendedInfo) && k.a((Object) this.updatedContext, (Object) results.updatedContext);
    }

    public final int hashCode() {
        BankEditStatus bankEditStatus2 = this.bankEditStatus;
        int i2 = 0;
        int hashCode = (bankEditStatus2 != null ? bankEditStatus2.hashCode() : 0) * 31;
        Banks banks2 = this.banks;
        int hashCode2 = (hashCode + (banks2 != null ? banks2.hashCode() : 0)) * 31;
        BwFrequency bwFrequency2 = this.bwFrequency;
        int hashCode3 = (hashCode2 + (bwFrequency2 != null ? bwFrequency2.hashCode() : 0)) * 31;
        List<Kyc> list = this.kyc;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        ExtendedInfo extendedInfo2 = this.extendedInfo;
        int hashCode5 = (hashCode4 + (extendedInfo2 != null ? extendedInfo2.hashCode() : 0)) * 31;
        b bVar = this.updatedContext;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "Results(bankEditStatus=" + this.bankEditStatus + ", banks=" + this.banks + ", bwFrequency=" + this.bwFrequency + ", kyc=" + this.kyc + ", extendedInfo=" + this.extendedInfo + ", updatedContext=" + this.updatedContext + ")";
    }

    public Results(BankEditStatus bankEditStatus2, Banks banks2, BwFrequency bwFrequency2, List<Kyc> list, ExtendedInfo extendedInfo2, b bVar) {
        k.d(bankEditStatus2, "bankEditStatus");
        k.d(banks2, "banks");
        k.d(bwFrequency2, "bwFrequency");
        k.d(list, "kyc");
        k.d(extendedInfo2, "extendedInfo");
        k.d(bVar, "updatedContext");
        this.bankEditStatus = bankEditStatus2;
        this.banks = banks2;
        this.bwFrequency = bwFrequency2;
        this.kyc = list;
        this.extendedInfo = extendedInfo2;
        this.updatedContext = bVar;
    }

    public final BankEditStatus getBankEditStatus() {
        return this.bankEditStatus;
    }

    public final Banks getBanks() {
        return this.banks;
    }

    public final BwFrequency getBwFrequency() {
        return this.bwFrequency;
    }

    public final List<Kyc> getKyc() {
        return this.kyc;
    }

    public final ExtendedInfo getExtendedInfo() {
        return this.extendedInfo;
    }

    public final b getUpdatedContext() {
        return this.updatedContext;
    }
}
