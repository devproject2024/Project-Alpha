package net.one97.paytm.contacts.entities.db_entities;

import android.text.TextUtils;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PayeeInfo implements IJRDataModel {
    private long id;
    private String imageUrl;
    private Boolean isDeleted;
    private Boolean isDirty;
    private String name;
    private String nickName;
    private String payeeInfoId;
    private Integer type;
    private String version;

    public static /* synthetic */ PayeeInfo copy$default(PayeeInfo payeeInfo, long j, String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, String str4, String str5, int i2, Object obj) {
        PayeeInfo payeeInfo2 = payeeInfo;
        int i3 = i2;
        return payeeInfo.copy((i3 & 1) != 0 ? payeeInfo2.id : j, (i3 & 2) != 0 ? payeeInfo2.payeeInfoId : str, (i3 & 4) != 0 ? payeeInfo2.name : str2, (i3 & 8) != 0 ? payeeInfo2.nickName : str3, (i3 & 16) != 0 ? payeeInfo2.isDirty : bool, (i3 & 32) != 0 ? payeeInfo2.isDeleted : bool2, (i3 & 64) != 0 ? payeeInfo2.type : num, (i3 & 128) != 0 ? payeeInfo2.version : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? payeeInfo2.imageUrl : str5);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.payeeInfoId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nickName;
    }

    public final Boolean component5() {
        return this.isDirty;
    }

    public final Boolean component6() {
        return this.isDeleted;
    }

    public final Integer component7() {
        return this.type;
    }

    public final String component8() {
        return this.version;
    }

    public final String component9() {
        return this.imageUrl;
    }

    public final PayeeInfo copy(long j, String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, String str4, String str5) {
        k.c(str, "payeeInfoId");
        return new PayeeInfo(j, str, str2, str3, bool, bool2, num, str4, str5);
    }

    public final String toString() {
        return "PayeeInfo(id=" + this.id + ", payeeInfoId=" + this.payeeInfoId + ", name=" + this.name + ", nickName=" + this.nickName + ", isDirty=" + this.isDirty + ", isDeleted=" + this.isDeleted + ", type=" + this.type + ", version=" + this.version + ", imageUrl=" + this.imageUrl + ")";
    }

    public PayeeInfo(long j, String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, String str4, String str5) {
        k.c(str, "payeeInfoId");
        this.id = j;
        this.payeeInfoId = str;
        this.name = str2;
        this.nickName = str3;
        this.isDirty = bool;
        this.isDeleted = bool2;
        this.type = num;
        this.version = str4;
        this.imageUrl = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayeeInfo(long j, String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, String str4, String str5, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, str, str2, str3, bool, bool2, num, str4, str5);
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

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
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

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PayeeInfo) {
            return p.a(this.payeeInfoId, ((PayeeInfo) obj).payeeInfoId, true);
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
