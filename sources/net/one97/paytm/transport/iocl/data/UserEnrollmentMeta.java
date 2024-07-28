package net.one97.paytm.transport.iocl.data;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class UserEnrollmentMeta implements IJRDataModel {
    @b(a = "allowUpdate")
    private final String allowUpdate;
    @b(a = "dupUCMId")
    private final String dupUCMId;
    @b(a = "memberNumber")
    private final String memberNumber;

    public static /* synthetic */ UserEnrollmentMeta copy$default(UserEnrollmentMeta userEnrollmentMeta, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userEnrollmentMeta.dupUCMId;
        }
        if ((i2 & 2) != 0) {
            str2 = userEnrollmentMeta.memberNumber;
        }
        if ((i2 & 4) != 0) {
            str3 = userEnrollmentMeta.allowUpdate;
        }
        return userEnrollmentMeta.copy(str, str2, str3);
    }

    public final String component1() {
        return this.dupUCMId;
    }

    public final String component2() {
        return this.memberNumber;
    }

    public final String component3() {
        return this.allowUpdate;
    }

    public final UserEnrollmentMeta copy(String str, String str2, String str3) {
        return new UserEnrollmentMeta(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserEnrollmentMeta)) {
            return false;
        }
        UserEnrollmentMeta userEnrollmentMeta = (UserEnrollmentMeta) obj;
        return k.a((Object) this.dupUCMId, (Object) userEnrollmentMeta.dupUCMId) && k.a((Object) this.memberNumber, (Object) userEnrollmentMeta.memberNumber) && k.a((Object) this.allowUpdate, (Object) userEnrollmentMeta.allowUpdate);
    }

    public final int hashCode() {
        String str = this.dupUCMId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.memberNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.allowUpdate;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UserEnrollmentMeta(dupUCMId=" + this.dupUCMId + ", memberNumber=" + this.memberNumber + ", allowUpdate=" + this.allowUpdate + ")";
    }

    public UserEnrollmentMeta(String str, String str2, String str3) {
        this.dupUCMId = str;
        this.memberNumber = str2;
        this.allowUpdate = str3;
    }

    public final String getDupUCMId() {
        return this.dupUCMId;
    }

    public final String getMemberNumber() {
        return this.memberNumber;
    }

    public final String getAllowUpdate() {
        return this.allowUpdate;
    }
}
