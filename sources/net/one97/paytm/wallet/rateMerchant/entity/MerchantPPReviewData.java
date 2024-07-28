package net.one97.paytm.wallet.rateMerchant.entity;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class MerchantPPReviewData implements IJRDataModel {
    @b(a = "categories")
    private final List<String> categories;
    @b(a = "clientId")
    private String clientId;
    @b(a = "clientSecret")
    private String clientSecret;
    @b(a = "contractId")
    private String contractId;
    @b(a = "numFollowers")
    private Integer followersCount;
    @b(a = "isEligible")
    private boolean isEligible;
    @b(a = "businessName")
    private final String merchantName;
    @b(a = "redirectionLink")
    private String offerRedirectionLink;
    @b(a = "question")
    private final ReviewQuestion questions;
    @b(a = "rating")
    private Float rating;
    @b(a = "remainingQuestionCount")
    private final Integer remainingQuestionCount;
    @b(a = "review")
    private String review;
    @b(a = "totalQuestionCount")
    private final Integer totalQuestionCount;

    public static /* synthetic */ MerchantPPReviewData copy$default(MerchantPPReviewData merchantPPReviewData, boolean z, Float f2, String str, String str2, String str3, List list, ReviewQuestion reviewQuestion, String str4, String str5, Integer num, Integer num2, String str6, Integer num3, int i2, Object obj) {
        MerchantPPReviewData merchantPPReviewData2 = merchantPPReviewData;
        int i3 = i2;
        return merchantPPReviewData.copy((i3 & 1) != 0 ? merchantPPReviewData2.isEligible : z, (i3 & 2) != 0 ? merchantPPReviewData2.rating : f2, (i3 & 4) != 0 ? merchantPPReviewData2.review : str, (i3 & 8) != 0 ? merchantPPReviewData2.contractId : str2, (i3 & 16) != 0 ? merchantPPReviewData2.clientId : str3, (i3 & 32) != 0 ? merchantPPReviewData2.categories : list, (i3 & 64) != 0 ? merchantPPReviewData2.questions : reviewQuestion, (i3 & 128) != 0 ? merchantPPReviewData2.clientSecret : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? merchantPPReviewData2.merchantName : str5, (i3 & 512) != 0 ? merchantPPReviewData2.totalQuestionCount : num, (i3 & TarConstants.EOF_BLOCK) != 0 ? merchantPPReviewData2.remainingQuestionCount : num2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? merchantPPReviewData2.offerRedirectionLink : str6, (i3 & 4096) != 0 ? merchantPPReviewData2.followersCount : num3);
    }

    public final boolean component1() {
        return this.isEligible;
    }

    public final Integer component10() {
        return this.totalQuestionCount;
    }

    public final Integer component11() {
        return this.remainingQuestionCount;
    }

    public final String component12() {
        return this.offerRedirectionLink;
    }

    public final Integer component13() {
        return this.followersCount;
    }

    public final Float component2() {
        return this.rating;
    }

    public final String component3() {
        return this.review;
    }

    public final String component4() {
        return this.contractId;
    }

    public final String component5() {
        return this.clientId;
    }

    public final List<String> component6() {
        return this.categories;
    }

    public final ReviewQuestion component7() {
        return this.questions;
    }

    public final String component8() {
        return this.clientSecret;
    }

    public final String component9() {
        return this.merchantName;
    }

    public final MerchantPPReviewData copy(boolean z, Float f2, String str, String str2, String str3, List<String> list, ReviewQuestion reviewQuestion, String str4, String str5, Integer num, Integer num2, String str6, Integer num3) {
        return new MerchantPPReviewData(z, f2, str, str2, str3, list, reviewQuestion, str4, str5, num, num2, str6, num3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MerchantPPReviewData) {
                MerchantPPReviewData merchantPPReviewData = (MerchantPPReviewData) obj;
                if (!(this.isEligible == merchantPPReviewData.isEligible) || !k.a((Object) this.rating, (Object) merchantPPReviewData.rating) || !k.a((Object) this.review, (Object) merchantPPReviewData.review) || !k.a((Object) this.contractId, (Object) merchantPPReviewData.contractId) || !k.a((Object) this.clientId, (Object) merchantPPReviewData.clientId) || !k.a((Object) this.categories, (Object) merchantPPReviewData.categories) || !k.a((Object) this.questions, (Object) merchantPPReviewData.questions) || !k.a((Object) this.clientSecret, (Object) merchantPPReviewData.clientSecret) || !k.a((Object) this.merchantName, (Object) merchantPPReviewData.merchantName) || !k.a((Object) this.totalQuestionCount, (Object) merchantPPReviewData.totalQuestionCount) || !k.a((Object) this.remainingQuestionCount, (Object) merchantPPReviewData.remainingQuestionCount) || !k.a((Object) this.offerRedirectionLink, (Object) merchantPPReviewData.offerRedirectionLink) || !k.a((Object) this.followersCount, (Object) merchantPPReviewData.followersCount)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isEligible;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        Float f2 = this.rating;
        int i3 = 0;
        int hashCode = (i2 + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str = this.review;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.contractId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<String> list = this.categories;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        ReviewQuestion reviewQuestion = this.questions;
        int hashCode6 = (hashCode5 + (reviewQuestion != null ? reviewQuestion.hashCode() : 0)) * 31;
        String str4 = this.clientSecret;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.merchantName;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.totalQuestionCount;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.remainingQuestionCount;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str6 = this.offerRedirectionLink;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num3 = this.followersCount;
        if (num3 != null) {
            i3 = num3.hashCode();
        }
        return hashCode11 + i3;
    }

    public final String toString() {
        return "MerchantPPReviewData(isEligible=" + this.isEligible + ", rating=" + this.rating + ", review=" + this.review + ", contractId=" + this.contractId + ", clientId=" + this.clientId + ", categories=" + this.categories + ", questions=" + this.questions + ", clientSecret=" + this.clientSecret + ", merchantName=" + this.merchantName + ", totalQuestionCount=" + this.totalQuestionCount + ", remainingQuestionCount=" + this.remainingQuestionCount + ", offerRedirectionLink=" + this.offerRedirectionLink + ", followersCount=" + this.followersCount + ")";
    }

    public MerchantPPReviewData(boolean z, Float f2, String str, String str2, String str3, List<String> list, ReviewQuestion reviewQuestion, String str4, String str5, Integer num, Integer num2, String str6, Integer num3) {
        this.isEligible = z;
        this.rating = f2;
        this.review = str;
        this.contractId = str2;
        this.clientId = str3;
        this.categories = list;
        this.questions = reviewQuestion;
        this.clientSecret = str4;
        this.merchantName = str5;
        this.totalQuestionCount = num;
        this.remainingQuestionCount = num2;
        this.offerRedirectionLink = str6;
        this.followersCount = num3;
    }

    public final boolean isEligible() {
        return this.isEligible;
    }

    public final void setEligible(boolean z) {
        this.isEligible = z;
    }

    public final Float getRating() {
        return this.rating;
    }

    public final void setRating(Float f2) {
        this.rating = f2;
    }

    public final String getReview() {
        return this.review;
    }

    public final void setReview(String str) {
        this.review = str;
    }

    public final String getContractId() {
        return this.contractId;
    }

    public final void setContractId(String str) {
        this.contractId = str;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final ReviewQuestion getQuestions() {
        return this.questions;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final void setClientSecret(String str) {
        this.clientSecret = str;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MerchantPPReviewData(boolean r15, java.lang.Float r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List r20, net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestion r21, java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.Integer r25, java.lang.String r26, java.lang.Integer r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            r11 = 0
            if (r10 == 0) goto L_0x004d
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            goto L_0x004f
        L_0x004d:
            r10 = r24
        L_0x004f:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r2 = r26
        L_0x0061:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            goto L_0x006c
        L_0x006a:
            r0 = r27
        L_0x006c:
            r16 = r14
            r17 = r15
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r12
            r28 = r2
            r29 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData.<init>(boolean, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, java.util.List, net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestion, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final Integer getTotalQuestionCount() {
        return this.totalQuestionCount;
    }

    public final Integer getRemainingQuestionCount() {
        return this.remainingQuestionCount;
    }

    public final String getOfferRedirectionLink() {
        return this.offerRedirectionLink;
    }

    public final void setOfferRedirectionLink(String str) {
        this.offerRedirectionLink = str;
    }

    public final Integer getFollowersCount() {
        return this.followersCount;
    }

    public final void setFollowersCount(Integer num) {
        this.followersCount = num;
    }
}
