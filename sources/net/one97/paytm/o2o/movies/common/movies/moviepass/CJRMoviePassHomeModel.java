package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMoviePassHomeModel extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRUserMoviePassModel> activePass;
    private String currentDate;
    private String imageUrl;
    private Boolean isSubscribedUser;
    private String message;
    private Boolean passAvailableInCity;
    private Boolean showMoviePassStrip;
    private Integer verticalId;

    public CJRMoviePassHomeModel() {
        this((Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ CJRMoviePassHomeModel copy$default(CJRMoviePassHomeModel cJRMoviePassHomeModel, Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3, List list, int i2, Object obj) {
        CJRMoviePassHomeModel cJRMoviePassHomeModel2 = cJRMoviePassHomeModel;
        int i3 = i2;
        return cJRMoviePassHomeModel.copy((i3 & 1) != 0 ? cJRMoviePassHomeModel2.verticalId : num, (i3 & 2) != 0 ? cJRMoviePassHomeModel2.passAvailableInCity : bool, (i3 & 4) != 0 ? cJRMoviePassHomeModel2.showMoviePassStrip : bool2, (i3 & 8) != 0 ? cJRMoviePassHomeModel2.isSubscribedUser : bool3, (i3 & 16) != 0 ? cJRMoviePassHomeModel2.currentDate : str, (i3 & 32) != 0 ? cJRMoviePassHomeModel2.message : str2, (i3 & 64) != 0 ? cJRMoviePassHomeModel2.imageUrl : str3, (i3 & 128) != 0 ? cJRMoviePassHomeModel2.activePass : list);
    }

    public final Integer component1() {
        return this.verticalId;
    }

    public final Boolean component2() {
        return this.passAvailableInCity;
    }

    public final Boolean component3() {
        return this.showMoviePassStrip;
    }

    public final Boolean component4() {
        return this.isSubscribedUser;
    }

    public final String component5() {
        return this.currentDate;
    }

    public final String component6() {
        return this.message;
    }

    public final String component7() {
        return this.imageUrl;
    }

    public final List<CJRUserMoviePassModel> component8() {
        return this.activePass;
    }

    public final CJRMoviePassHomeModel copy(Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3, List<CJRUserMoviePassModel> list) {
        return new CJRMoviePassHomeModel(num, bool, bool2, bool3, str, str2, str3, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMoviePassHomeModel)) {
            return false;
        }
        CJRMoviePassHomeModel cJRMoviePassHomeModel = (CJRMoviePassHomeModel) obj;
        return k.a((Object) this.verticalId, (Object) cJRMoviePassHomeModel.verticalId) && k.a((Object) this.passAvailableInCity, (Object) cJRMoviePassHomeModel.passAvailableInCity) && k.a((Object) this.showMoviePassStrip, (Object) cJRMoviePassHomeModel.showMoviePassStrip) && k.a((Object) this.isSubscribedUser, (Object) cJRMoviePassHomeModel.isSubscribedUser) && k.a((Object) this.currentDate, (Object) cJRMoviePassHomeModel.currentDate) && k.a((Object) this.message, (Object) cJRMoviePassHomeModel.message) && k.a((Object) this.imageUrl, (Object) cJRMoviePassHomeModel.imageUrl) && k.a((Object) this.activePass, (Object) cJRMoviePassHomeModel.activePass);
    }

    public final int hashCode() {
        Integer num = this.verticalId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Boolean bool = this.passAvailableInCity;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.showMoviePassStrip;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isSubscribedUser;
        int hashCode4 = (hashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str = this.currentDate;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<CJRUserMoviePassModel> list = this.activePass;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "CJRMoviePassHomeModel(verticalId=" + this.verticalId + ", passAvailableInCity=" + this.passAvailableInCity + ", showMoviePassStrip=" + this.showMoviePassStrip + ", isSubscribedUser=" + this.isSubscribedUser + ", currentDate=" + this.currentDate + ", message=" + this.message + ", imageUrl=" + this.imageUrl + ", activePass=" + this.activePass + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRMoviePassHomeModel(java.lang.Integer r10, java.lang.Boolean r11, java.lang.Boolean r12, java.lang.Boolean r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.List r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r10
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0014
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x0015
        L_0x0014:
            r2 = r11
        L_0x0015:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001c
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            goto L_0x001d
        L_0x001c:
            r3 = r12
        L_0x001d:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0024
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            goto L_0x0025
        L_0x0024:
            r4 = r13
        L_0x0025:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r5 = r6
            goto L_0x002d
        L_0x002c:
            r5 = r14
        L_0x002d:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0033
            r7 = r6
            goto L_0x0034
        L_0x0033:
            r7 = r15
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r6
            goto L_0x003c
        L_0x003a:
            r8 = r16
        L_0x003c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r6 = r17
        L_0x0043:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r7
            r17 = r8
            r18 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel.<init>(java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.g.b.g):void");
    }

    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public final void setVerticalId(Integer num) {
        this.verticalId = num;
    }

    public final Boolean getPassAvailableInCity() {
        return this.passAvailableInCity;
    }

    public final void setPassAvailableInCity(Boolean bool) {
        this.passAvailableInCity = bool;
    }

    public final Boolean getShowMoviePassStrip() {
        return this.showMoviePassStrip;
    }

    public final void setShowMoviePassStrip(Boolean bool) {
        this.showMoviePassStrip = bool;
    }

    public final Boolean isSubscribedUser() {
        return this.isSubscribedUser;
    }

    public final void setSubscribedUser(Boolean bool) {
        this.isSubscribedUser = bool;
    }

    public final String getCurrentDate() {
        return this.currentDate;
    }

    public final void setCurrentDate(String str) {
        this.currentDate = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public CJRMoviePassHomeModel(Integer num, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3, List<CJRUserMoviePassModel> list) {
        this.verticalId = num;
        this.passAvailableInCity = bool;
        this.showMoviePassStrip = bool2;
        this.isSubscribedUser = bool3;
        this.currentDate = str;
        this.message = str2;
        this.imageUrl = str3;
        this.activePass = list;
    }

    public final List<CJRUserMoviePassModel> getActivePass() {
        return this.activePass;
    }

    public final void setActivePass(List<CJRUserMoviePassModel> list) {
        this.activePass = list;
    }
}
