package net.one97.paytm.contacts.entities.db_entities;

import android.text.TextUtils;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PayeeInfoDetails implements IJRDataModel {
    private long id;
    private Boolean isDeleted;
    private Boolean isDirty;
    private String newContactVisiblity;
    private String payeeInfoId;
    private Integer type;
    private String version;

    public static /* synthetic */ PayeeInfoDetails copy$default(PayeeInfoDetails payeeInfoDetails, long j, String str, Boolean bool, Boolean bool2, Integer num, String str2, String str3, int i2, Object obj) {
        PayeeInfoDetails payeeInfoDetails2 = payeeInfoDetails;
        return payeeInfoDetails.copy((i2 & 1) != 0 ? payeeInfoDetails2.id : j, (i2 & 2) != 0 ? payeeInfoDetails2.payeeInfoId : str, (i2 & 4) != 0 ? payeeInfoDetails2.isDirty : bool, (i2 & 8) != 0 ? payeeInfoDetails2.isDeleted : bool2, (i2 & 16) != 0 ? payeeInfoDetails2.type : num, (i2 & 32) != 0 ? payeeInfoDetails2.newContactVisiblity : str2, (i2 & 64) != 0 ? payeeInfoDetails2.version : str3);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.payeeInfoId;
    }

    public final Boolean component3() {
        return this.isDirty;
    }

    public final Boolean component4() {
        return this.isDeleted;
    }

    public final Integer component5() {
        return this.type;
    }

    public final String component6() {
        return this.newContactVisiblity;
    }

    public final String component7() {
        return this.version;
    }

    public final PayeeInfoDetails copy(long j, String str, Boolean bool, Boolean bool2, Integer num, String str2, String str3) {
        k.c(str, "payeeInfoId");
        return new PayeeInfoDetails(j, str, bool, bool2, num, str2, str3);
    }

    public final String toString() {
        return "PayeeInfoDetails(id=" + this.id + ", payeeInfoId=" + this.payeeInfoId + ", isDirty=" + this.isDirty + ", isDeleted=" + this.isDeleted + ", type=" + this.type + ", newContactVisiblity=" + this.newContactVisiblity + ", version=" + this.version + ")";
    }

    public PayeeInfoDetails(long j, String str, Boolean bool, Boolean bool2, Integer num, String str2, String str3) {
        k.c(str, "payeeInfoId");
        this.id = j;
        this.payeeInfoId = str;
        this.isDirty = bool;
        this.isDeleted = bool2;
        this.type = num;
        this.newContactVisiblity = str2;
        this.version = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayeeInfoDetails(long j, String str, Boolean bool, Boolean bool2, Integer num, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, str, bool, bool2, num, str2, str3);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getPayeeInfoId() {
        return this.payeeInfoId;
    }

    public final void setPayeeInfoId(String str) {
        k.c(str, "<set-?>");
        this.payeeInfoId = str;
    }

    public final Boolean isDirty() {
        return this.isDirty;
    }

    public final void setDirty(Boolean bool) {
        this.isDirty = bool;
    }

    public final Boolean isDeleted() {
        return this.isDeleted;
    }

    public final void setDeleted(Boolean bool) {
        this.isDeleted = bool;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final String getNewContactVisiblity() {
        return this.newContactVisiblity;
    }

    public final void setNewContactVisiblity(String str) {
        this.newContactVisiblity = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PayeeInfoDetails) {
            return p.a(this.payeeInfoId, ((PayeeInfoDetails) obj).payeeInfoId, true);
        }
        return super.equals(obj);
    }

    public final int hashCode() {
        String str = this.payeeInfoId + this.type;
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return super.hashCode();
    }
}
