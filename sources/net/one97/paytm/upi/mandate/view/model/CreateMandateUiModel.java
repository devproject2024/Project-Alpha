package net.one97.paytm.upi.mandate.view.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.mandate.utils.w;
import net.one97.paytm.upi.util.UpiConstants;

public final class CreateMandateUiModel implements UpiBaseDataModel {
    @c(a = "accRefId")
    private final String accRefId;
    @c(a = "amount")
    private final String amount;
    @c(a = "amountValidationError")
    private final w.a amountValidationError;
    @c(a = "creds")
    private final List<BankAccountDetails.BankAccountCredentials> bankCreds;
    @c(a = "category")
    private final String category;
    @c(a = "comments")
    private final String comments;
    @c(a = "dateValidationError")
    private final w.b dateValidationError;
    @c(a = "endDate")
    private final String endDate;
    private final MandateConfirmationUiModel mandateConfirmationUiModel;
    private final String maxDebitAmount;
    @c(a = "payeeAccountName")
    private final String payeeAccountName;
    @c(a = "payeeAccountVpa")
    private final String payeeAccountVpa;
    @c(a = "payeeMcc")
    private final String payeeMcc;
    @c(a = "payeeType")
    private final String payeeType;
    @c(a = "payerBankAcc")
    private final String payerBankAcc;
    @c(a = "payerBankName")
    private final String payerBankName;
    @c(a = "payerIfsc")
    private final String payerIfsc;
    @c(a = "payerVpa")
    private final String payerVpa;
    @c(a = "refCategory")
    private final String refCategory;
    @c(a = "refId")
    private final String refId;
    @c(a = "refUrl")
    private final String refUrl;
    @c(a = "startDate")
    private final String startDate;
    @c(a = "umn")
    private final String umn;
    private final UpdateInfo updateInfo;

    public static /* synthetic */ CreateMandateUiModel copy$default(CreateMandateUiModel createMandateUiModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, String str13, String str14, String str15, String str16, String str17, String str18, w.a aVar, w.b bVar, MandateConfirmationUiModel mandateConfirmationUiModel2, UpdateInfo updateInfo2, String str19, int i2, Object obj) {
        CreateMandateUiModel createMandateUiModel2 = createMandateUiModel;
        int i3 = i2;
        return createMandateUiModel.copy((i3 & 1) != 0 ? createMandateUiModel2.amount : str, (i3 & 2) != 0 ? createMandateUiModel2.payeeAccountVpa : str2, (i3 & 4) != 0 ? createMandateUiModel2.payeeAccountName : str3, (i3 & 8) != 0 ? createMandateUiModel2.comments : str4, (i3 & 16) != 0 ? createMandateUiModel2.payeeMcc : str5, (i3 & 32) != 0 ? createMandateUiModel2.payeeType : str6, (i3 & 64) != 0 ? createMandateUiModel2.category : str7, (i3 & 128) != 0 ? createMandateUiModel2.payerVpa : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? createMandateUiModel2.payerIfsc : str9, (i3 & 512) != 0 ? createMandateUiModel2.payerBankName : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? createMandateUiModel2.payerBankAcc : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? createMandateUiModel2.bankCreds : list, (i3 & 4096) != 0 ? createMandateUiModel2.startDate : str12, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? createMandateUiModel2.endDate : str13, (i3 & 16384) != 0 ? createMandateUiModel2.umn : str14, (i3 & 32768) != 0 ? createMandateUiModel2.refId : str15, (i3 & 65536) != 0 ? createMandateUiModel2.refUrl : str16, (i3 & 131072) != 0 ? createMandateUiModel2.refCategory : str17, (i3 & 262144) != 0 ? createMandateUiModel2.accRefId : str18, (i3 & 524288) != 0 ? createMandateUiModel2.amountValidationError : aVar, (i3 & 1048576) != 0 ? createMandateUiModel2.dateValidationError : bVar, (i3 & 2097152) != 0 ? createMandateUiModel2.mandateConfirmationUiModel : mandateConfirmationUiModel2, (i3 & 4194304) != 0 ? createMandateUiModel2.updateInfo : updateInfo2, (i3 & 8388608) != 0 ? createMandateUiModel2.maxDebitAmount : str19);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component10() {
        return this.payerBankName;
    }

    public final String component11() {
        return this.payerBankAcc;
    }

    public final List<BankAccountDetails.BankAccountCredentials> component12() {
        return this.bankCreds;
    }

    public final String component13() {
        return this.startDate;
    }

    public final String component14() {
        return this.endDate;
    }

    public final String component15() {
        return this.umn;
    }

    public final String component16() {
        return this.refId;
    }

    public final String component17() {
        return this.refUrl;
    }

    public final String component18() {
        return this.refCategory;
    }

    public final String component19() {
        return this.accRefId;
    }

    public final String component2() {
        return this.payeeAccountVpa;
    }

    public final w.a component20() {
        return this.amountValidationError;
    }

    public final w.b component21() {
        return this.dateValidationError;
    }

    public final MandateConfirmationUiModel component22() {
        return this.mandateConfirmationUiModel;
    }

    public final UpdateInfo component23() {
        return this.updateInfo;
    }

    public final String component24() {
        return this.maxDebitAmount;
    }

    public final String component3() {
        return this.payeeAccountName;
    }

    public final String component4() {
        return this.comments;
    }

    public final String component5() {
        return this.payeeMcc;
    }

    public final String component6() {
        return this.payeeType;
    }

    public final String component7() {
        return this.category;
    }

    public final String component8() {
        return this.payerVpa;
    }

    public final String component9() {
        return this.payerIfsc;
    }

    public final CreateMandateUiModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends BankAccountDetails.BankAccountCredentials> list, String str12, String str13, String str14, String str15, String str16, String str17, String str18, w.a aVar, w.b bVar, MandateConfirmationUiModel mandateConfirmationUiModel2, UpdateInfo updateInfo2, String str19) {
        String str20 = str;
        k.c(mandateConfirmationUiModel2, "mandateConfirmationUiModel");
        k.c(str19, "maxDebitAmount");
        return new CreateMandateUiModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, list, str12, str13, str14, str15, str16, str17, str18, aVar, bVar, mandateConfirmationUiModel2, updateInfo2, str19);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateMandateUiModel)) {
            return false;
        }
        CreateMandateUiModel createMandateUiModel = (CreateMandateUiModel) obj;
        return k.a((Object) this.amount, (Object) createMandateUiModel.amount) && k.a((Object) this.payeeAccountVpa, (Object) createMandateUiModel.payeeAccountVpa) && k.a((Object) this.payeeAccountName, (Object) createMandateUiModel.payeeAccountName) && k.a((Object) this.comments, (Object) createMandateUiModel.comments) && k.a((Object) this.payeeMcc, (Object) createMandateUiModel.payeeMcc) && k.a((Object) this.payeeType, (Object) createMandateUiModel.payeeType) && k.a((Object) this.category, (Object) createMandateUiModel.category) && k.a((Object) this.payerVpa, (Object) createMandateUiModel.payerVpa) && k.a((Object) this.payerIfsc, (Object) createMandateUiModel.payerIfsc) && k.a((Object) this.payerBankName, (Object) createMandateUiModel.payerBankName) && k.a((Object) this.payerBankAcc, (Object) createMandateUiModel.payerBankAcc) && k.a((Object) this.bankCreds, (Object) createMandateUiModel.bankCreds) && k.a((Object) this.startDate, (Object) createMandateUiModel.startDate) && k.a((Object) this.endDate, (Object) createMandateUiModel.endDate) && k.a((Object) this.umn, (Object) createMandateUiModel.umn) && k.a((Object) this.refId, (Object) createMandateUiModel.refId) && k.a((Object) this.refUrl, (Object) createMandateUiModel.refUrl) && k.a((Object) this.refCategory, (Object) createMandateUiModel.refCategory) && k.a((Object) this.accRefId, (Object) createMandateUiModel.accRefId) && k.a((Object) this.amountValidationError, (Object) createMandateUiModel.amountValidationError) && k.a((Object) this.dateValidationError, (Object) createMandateUiModel.dateValidationError) && k.a((Object) this.mandateConfirmationUiModel, (Object) createMandateUiModel.mandateConfirmationUiModel) && k.a((Object) this.updateInfo, (Object) createMandateUiModel.updateInfo) && k.a((Object) this.maxDebitAmount, (Object) createMandateUiModel.maxDebitAmount);
    }

    public final int hashCode() {
        String str = this.amount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payeeAccountVpa;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payeeAccountName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.comments;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payeeMcc;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payeeType;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.category;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.payerVpa;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.payerIfsc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.payerBankName;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.payerBankAcc;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        List<BankAccountDetails.BankAccountCredentials> list = this.bankCreds;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        String str12 = this.startDate;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.endDate;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.umn;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.refId;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.refUrl;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.refCategory;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.accRefId;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        w.a aVar = this.amountValidationError;
        int hashCode20 = (hashCode19 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        w.b bVar = this.dateValidationError;
        int hashCode21 = (hashCode20 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        MandateConfirmationUiModel mandateConfirmationUiModel2 = this.mandateConfirmationUiModel;
        int hashCode22 = (hashCode21 + (mandateConfirmationUiModel2 != null ? mandateConfirmationUiModel2.hashCode() : 0)) * 31;
        UpdateInfo updateInfo2 = this.updateInfo;
        int hashCode23 = (hashCode22 + (updateInfo2 != null ? updateInfo2.hashCode() : 0)) * 31;
        String str19 = this.maxDebitAmount;
        if (str19 != null) {
            i2 = str19.hashCode();
        }
        return hashCode23 + i2;
    }

    public final String toString() {
        return "CreateMandateUiModel(amount=" + this.amount + ", payeeAccountVpa=" + this.payeeAccountVpa + ", payeeAccountName=" + this.payeeAccountName + ", comments=" + this.comments + ", payeeMcc=" + this.payeeMcc + ", payeeType=" + this.payeeType + ", category=" + this.category + ", payerVpa=" + this.payerVpa + ", payerIfsc=" + this.payerIfsc + ", payerBankName=" + this.payerBankName + ", payerBankAcc=" + this.payerBankAcc + ", bankCreds=" + this.bankCreds + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", umn=" + this.umn + ", refId=" + this.refId + ", refUrl=" + this.refUrl + ", refCategory=" + this.refCategory + ", accRefId=" + this.accRefId + ", amountValidationError=" + this.amountValidationError + ", dateValidationError=" + this.dateValidationError + ", mandateConfirmationUiModel=" + this.mandateConfirmationUiModel + ", updateInfo=" + this.updateInfo + ", maxDebitAmount=" + this.maxDebitAmount + ")";
    }

    public CreateMandateUiModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends BankAccountDetails.BankAccountCredentials> list, String str12, String str13, String str14, String str15, String str16, String str17, String str18, w.a aVar, w.b bVar, MandateConfirmationUiModel mandateConfirmationUiModel2, UpdateInfo updateInfo2, String str19) {
        MandateConfirmationUiModel mandateConfirmationUiModel3 = mandateConfirmationUiModel2;
        String str20 = str19;
        k.c(mandateConfirmationUiModel3, "mandateConfirmationUiModel");
        k.c(str20, "maxDebitAmount");
        this.amount = str;
        this.payeeAccountVpa = str2;
        this.payeeAccountName = str3;
        this.comments = str4;
        this.payeeMcc = str5;
        this.payeeType = str6;
        this.category = str7;
        this.payerVpa = str8;
        this.payerIfsc = str9;
        this.payerBankName = str10;
        this.payerBankAcc = str11;
        this.bankCreds = list;
        this.startDate = str12;
        this.endDate = str13;
        this.umn = str14;
        this.refId = str15;
        this.refUrl = str16;
        this.refCategory = str17;
        this.accRefId = str18;
        this.amountValidationError = aVar;
        this.dateValidationError = bVar;
        this.mandateConfirmationUiModel = mandateConfirmationUiModel3;
        this.updateInfo = updateInfo2;
        this.maxDebitAmount = str20;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPayeeAccountVpa() {
        return this.payeeAccountVpa;
    }

    public final String getPayeeAccountName() {
        return this.payeeAccountName;
    }

    public final String getComments() {
        return this.comments;
    }

    public final String getPayeeMcc() {
        return this.payeeMcc;
    }

    public final String getPayeeType() {
        return this.payeeType;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final String getPayerIfsc() {
        return this.payerIfsc;
    }

    public final String getPayerBankName() {
        return this.payerBankName;
    }

    public final String getPayerBankAcc() {
        return this.payerBankAcc;
    }

    public final List<BankAccountDetails.BankAccountCredentials> getBankCreds() {
        return this.bankCreds;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getRefUrl() {
        return this.refUrl;
    }

    public final String getRefCategory() {
        return this.refCategory;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final w.a getAmountValidationError() {
        return this.amountValidationError;
    }

    public final w.b getDateValidationError() {
        return this.dateValidationError;
    }

    public final MandateConfirmationUiModel getMandateConfirmationUiModel() {
        return this.mandateConfirmationUiModel;
    }

    public final UpdateInfo getUpdateInfo() {
        return this.updateInfo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CreateMandateUiModel(java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.util.List r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, net.one97.paytm.upi.mandate.utils.w.a r48, net.one97.paytm.upi.mandate.utils.w.b r49, net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r50, net.one97.paytm.upi.mandate.view.model.UpdateInfo r51, java.lang.String r52, int r53, kotlin.g.b.g r54) {
        /*
            r28 = this;
            r0 = r53
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r29
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0012
            r5 = r2
            goto L_0x0014
        L_0x0012:
            r5 = r30
        L_0x0014:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001a
            r6 = r2
            goto L_0x001c
        L_0x001a:
            r6 = r31
        L_0x001c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0022
            r7 = r2
            goto L_0x0024
        L_0x0022:
            r7 = r32
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            r8 = r2
            goto L_0x002c
        L_0x002a:
            r8 = r33
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            r9 = r2
            goto L_0x0034
        L_0x0032:
            r9 = r34
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003a
            r10 = r2
            goto L_0x003c
        L_0x003a:
            r10 = r35
        L_0x003c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0042
            r11 = r2
            goto L_0x0044
        L_0x0042:
            r11 = r36
        L_0x0044:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004a
            r12 = r2
            goto L_0x004c
        L_0x004a:
            r12 = r37
        L_0x004c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0052
            r13 = r2
            goto L_0x0054
        L_0x0052:
            r13 = r38
        L_0x0054:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005a
            r14 = r2
            goto L_0x005c
        L_0x005a:
            r14 = r39
        L_0x005c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r3 = 0
            if (r1 == 0) goto L_0x0063
            r15 = r3
            goto L_0x0065
        L_0x0063:
            r15 = r40
        L_0x0065:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x006c
            r16 = r2
            goto L_0x006e
        L_0x006c:
            r16 = r41
        L_0x006e:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0075
            r17 = r2
            goto L_0x0077
        L_0x0075:
            r17 = r42
        L_0x0077:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x007e
            r18 = r2
            goto L_0x0080
        L_0x007e:
            r18 = r43
        L_0x0080:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0089
            r19 = r2
            goto L_0x008b
        L_0x0089:
            r19 = r44
        L_0x008b:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0093
            r20 = r2
            goto L_0x0095
        L_0x0093:
            r20 = r45
        L_0x0095:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009d
            r21 = r2
            goto L_0x009f
        L_0x009d:
            r21 = r46
        L_0x009f:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a7
            r22 = r2
            goto L_0x00a9
        L_0x00a7:
            r22 = r47
        L_0x00a9:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b1
            r23 = r3
            goto L_0x00b3
        L_0x00b1:
            r23 = r48
        L_0x00b3:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bb
            r24 = r3
            goto L_0x00bd
        L_0x00bb:
            r24 = r49
        L_0x00bd:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c5
            r26 = r3
            goto L_0x00c7
        L_0x00c5:
            r26 = r51
        L_0x00c7:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00cf
            r27 = r2
            goto L_0x00d1
        L_0x00cf:
            r27 = r52
        L_0x00d1:
            r3 = r28
            r25 = r50
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.upi.mandate.utils.w$a, net.one97.paytm.upi.mandate.utils.w$b, net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel, net.one97.paytm.upi.mandate.view.model.UpdateInfo, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMaxDebitAmount() {
        return this.maxDebitAmount;
    }
}
