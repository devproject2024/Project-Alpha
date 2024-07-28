package net.one97.paytm.upi.mandate.view.model;

import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.mandate.utils.v;

public final class UpdateInfo implements UpiBaseDataModel {
    private final String amount;
    private final String pauseEndDate;
    private final String pauseStartDate;
    private final v update;
    private final String validityEndDate;

    public static /* synthetic */ UpdateInfo copy$default(UpdateInfo updateInfo, String str, String str2, String str3, v vVar, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = updateInfo.validityEndDate;
        }
        if ((i2 & 2) != 0) {
            str2 = updateInfo.pauseStartDate;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = updateInfo.pauseEndDate;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            vVar = updateInfo.update;
        }
        v vVar2 = vVar;
        if ((i2 & 16) != 0) {
            str4 = updateInfo.amount;
        }
        return updateInfo.copy(str, str5, str6, vVar2, str4);
    }

    public final String component1() {
        return this.validityEndDate;
    }

    public final String component2() {
        return this.pauseStartDate;
    }

    public final String component3() {
        return this.pauseEndDate;
    }

    public final v component4() {
        return this.update;
    }

    public final String component5() {
        return this.amount;
    }

    public final UpdateInfo copy(String str, String str2, String str3, v vVar, String str4) {
        k.c(vVar, "update");
        k.c(str4, "amount");
        return new UpdateInfo(str, str2, str3, vVar, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateInfo)) {
            return false;
        }
        UpdateInfo updateInfo = (UpdateInfo) obj;
        return k.a((Object) this.validityEndDate, (Object) updateInfo.validityEndDate) && k.a((Object) this.pauseStartDate, (Object) updateInfo.pauseStartDate) && k.a((Object) this.pauseEndDate, (Object) updateInfo.pauseEndDate) && k.a((Object) this.update, (Object) updateInfo.update) && k.a((Object) this.amount, (Object) updateInfo.amount);
    }

    public final int hashCode() {
        String str = this.validityEndDate;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pauseStartDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pauseEndDate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        v vVar = this.update;
        int hashCode4 = (hashCode3 + (vVar != null ? vVar.hashCode() : 0)) * 31;
        String str4 = this.amount;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "UpdateInfo(validityEndDate=" + this.validityEndDate + ", pauseStartDate=" + this.pauseStartDate + ", pauseEndDate=" + this.pauseEndDate + ", update=" + this.update + ", amount=" + this.amount + ")";
    }

    public UpdateInfo(String str, String str2, String str3, v vVar, String str4) {
        k.c(vVar, "update");
        k.c(str4, "amount");
        this.validityEndDate = str;
        this.pauseStartDate = str2;
        this.pauseEndDate = str3;
        this.update = vVar;
        this.amount = str4;
    }

    public final String getValidityEndDate() {
        return this.validityEndDate;
    }

    public final String getPauseStartDate() {
        return this.pauseStartDate;
    }

    public final String getPauseEndDate() {
        return this.pauseEndDate;
    }

    public final v getUpdate() {
        return this.update;
    }

    public final String getAmount() {
        return this.amount;
    }
}
