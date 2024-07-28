package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRExtensionAttributes implements IJRDataModel {
    @b(a = "bbps_logo_landing")
    private String bbpsLogoLanding;
    @b(a = "bbps_logo_url")
    private String bbpsLogoUrl;
    @b(a = "browsePlansCategory")
    private String browsePlansCategory;
    @b(a = "conv_fee")
    private int convenienceFees;
    @b(a = "errorImage")
    private final String errorImage;
    @b(a = "errorDisplayType")
    private final String errorType;
    @b(a = "operator_grid_column_count")
    private int operatorGridColumnCount;
    @b(a = "prefillFirstRecent")
    private Integer preFillFirstRecent;
    @b(a = "recentTempType")
    private String recentTempType;

    public static /* synthetic */ CJRExtensionAttributes copy$default(CJRExtensionAttributes cJRExtensionAttributes, int i2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i3, int i4, Object obj) {
        CJRExtensionAttributes cJRExtensionAttributes2 = cJRExtensionAttributes;
        int i5 = i4;
        return cJRExtensionAttributes.copy((i5 & 1) != 0 ? cJRExtensionAttributes2.convenienceFees : i2, (i5 & 2) != 0 ? cJRExtensionAttributes2.errorType : str, (i5 & 4) != 0 ? cJRExtensionAttributes2.errorImage : str2, (i5 & 8) != 0 ? cJRExtensionAttributes2.preFillFirstRecent : num, (i5 & 16) != 0 ? cJRExtensionAttributes2.browsePlansCategory : str3, (i5 & 32) != 0 ? cJRExtensionAttributes2.recentTempType : str4, (i5 & 64) != 0 ? cJRExtensionAttributes2.bbpsLogoLanding : str5, (i5 & 128) != 0 ? cJRExtensionAttributes2.bbpsLogoUrl : str6, (i5 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRExtensionAttributes2.operatorGridColumnCount : i3);
    }

    public final int component1() {
        return this.convenienceFees;
    }

    public final String component2() {
        return this.errorType;
    }

    public final String component3() {
        return this.errorImage;
    }

    public final Integer component4() {
        return this.preFillFirstRecent;
    }

    public final String component5() {
        return this.browsePlansCategory;
    }

    public final String component6() {
        return this.recentTempType;
    }

    public final String component7() {
        return this.bbpsLogoLanding;
    }

    public final String component8() {
        return this.bbpsLogoUrl;
    }

    public final int component9() {
        return this.operatorGridColumnCount;
    }

    public final CJRExtensionAttributes copy(int i2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i3) {
        String str7 = str3;
        k.c(str7, "browsePlansCategory");
        String str8 = str4;
        k.c(str8, "recentTempType");
        String str9 = str5;
        k.c(str9, "bbpsLogoLanding");
        String str10 = str6;
        k.c(str10, "bbpsLogoUrl");
        return new CJRExtensionAttributes(i2, str, str2, num, str7, str8, str9, str10, i3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRExtensionAttributes) {
                CJRExtensionAttributes cJRExtensionAttributes = (CJRExtensionAttributes) obj;
                if ((this.convenienceFees == cJRExtensionAttributes.convenienceFees) && k.a((Object) this.errorType, (Object) cJRExtensionAttributes.errorType) && k.a((Object) this.errorImage, (Object) cJRExtensionAttributes.errorImage) && k.a((Object) this.preFillFirstRecent, (Object) cJRExtensionAttributes.preFillFirstRecent) && k.a((Object) this.browsePlansCategory, (Object) cJRExtensionAttributes.browsePlansCategory) && k.a((Object) this.recentTempType, (Object) cJRExtensionAttributes.recentTempType) && k.a((Object) this.bbpsLogoLanding, (Object) cJRExtensionAttributes.bbpsLogoLanding) && k.a((Object) this.bbpsLogoUrl, (Object) cJRExtensionAttributes.bbpsLogoUrl)) {
                    if (this.operatorGridColumnCount == cJRExtensionAttributes.operatorGridColumnCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.convenienceFees * 31;
        String str = this.errorType;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.errorImage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.preFillFirstRecent;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.browsePlansCategory;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.recentTempType;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bbpsLogoLanding;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bbpsLogoUrl;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return ((hashCode6 + i3) * 31) + this.operatorGridColumnCount;
    }

    public final String toString() {
        return "CJRExtensionAttributes(convenienceFees=" + this.convenienceFees + ", errorType=" + this.errorType + ", errorImage=" + this.errorImage + ", preFillFirstRecent=" + this.preFillFirstRecent + ", browsePlansCategory=" + this.browsePlansCategory + ", recentTempType=" + this.recentTempType + ", bbpsLogoLanding=" + this.bbpsLogoLanding + ", bbpsLogoUrl=" + this.bbpsLogoUrl + ", operatorGridColumnCount=" + this.operatorGridColumnCount + ")";
    }

    public CJRExtensionAttributes(int i2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i3) {
        k.c(str3, "browsePlansCategory");
        k.c(str4, "recentTempType");
        k.c(str5, "bbpsLogoLanding");
        k.c(str6, "bbpsLogoUrl");
        this.convenienceFees = i2;
        this.errorType = str;
        this.errorImage = str2;
        this.preFillFirstRecent = num;
        this.browsePlansCategory = str3;
        this.recentTempType = str4;
        this.bbpsLogoLanding = str5;
        this.bbpsLogoUrl = str6;
        this.operatorGridColumnCount = i3;
    }

    public final int getConvenienceFees() {
        return this.convenienceFees;
    }

    public final void setConvenienceFees(int i2) {
        this.convenienceFees = i2;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorImage() {
        return this.errorImage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRExtensionAttributes(int i2, String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i3, int i4, g gVar) {
        this(i2, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? 0 : num, str3, str4, str5, str6, i3);
    }

    public final Integer getPreFillFirstRecent() {
        return this.preFillFirstRecent;
    }

    public final void setPreFillFirstRecent(Integer num) {
        this.preFillFirstRecent = num;
    }

    public final String getBrowsePlansCategory() {
        return this.browsePlansCategory;
    }

    public final void setBrowsePlansCategory(String str) {
        k.c(str, "<set-?>");
        this.browsePlansCategory = str;
    }

    public final String getRecentTempType() {
        return this.recentTempType;
    }

    public final void setRecentTempType(String str) {
        k.c(str, "<set-?>");
        this.recentTempType = str;
    }

    public final String getBbpsLogoLanding() {
        return this.bbpsLogoLanding;
    }

    public final void setBbpsLogoLanding(String str) {
        k.c(str, "<set-?>");
        this.bbpsLogoLanding = str;
    }

    public final String getBbpsLogoUrl() {
        return this.bbpsLogoUrl;
    }

    public final void setBbpsLogoUrl(String str) {
        k.c(str, "<set-?>");
        this.bbpsLogoUrl = str;
    }

    public final int getOperatorGridColumnCount() {
        return this.operatorGridColumnCount;
    }

    public final void setOperatorGridColumnCount(int i2) {
        this.operatorGridColumnCount = i2;
    }

    public final boolean isConvenienceFeeApplicable() {
        return this.convenienceFees == 1;
    }

    public final boolean isPreFillFirstRecentEnabled() {
        Integer num = this.preFillFirstRecent;
        return num != null && num.intValue() == 1;
    }

    public final boolean isBBPSCategoryLogoEnabled() {
        return p.a("1", this.bbpsLogoLanding, true);
    }
}
