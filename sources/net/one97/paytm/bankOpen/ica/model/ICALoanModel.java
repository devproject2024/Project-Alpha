package net.one97.paytm.bankOpen.ica.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ICALoanModel extends IJRPaytmDataModel {
    private String accountNumber;
    private String bankName;
    private String branchName;
    private String currentPrincipalOutstanding;
    private String ifscCode;
    private String loanAmount;
    private String typeOfLoan;

    public ICALoanModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public static /* synthetic */ ICALoanModel copy$default(ICALoanModel iCALoanModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iCALoanModel.accountNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = iCALoanModel.bankName;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = iCALoanModel.branchName;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = iCALoanModel.currentPrincipalOutstanding;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = iCALoanModel.ifscCode;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = iCALoanModel.loanAmount;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = iCALoanModel.typeOfLoan;
        }
        return iCALoanModel.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.accountNumber;
    }

    public final String component2() {
        return this.bankName;
    }

    public final String component3() {
        return this.branchName;
    }

    public final String component4() {
        return this.currentPrincipalOutstanding;
    }

    public final String component5() {
        return this.ifscCode;
    }

    public final String component6() {
        return this.loanAmount;
    }

    public final String component7() {
        return this.typeOfLoan;
    }

    public final ICALoanModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new ICALoanModel(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ICALoanModel)) {
            return false;
        }
        ICALoanModel iCALoanModel = (ICALoanModel) obj;
        return k.a((Object) this.accountNumber, (Object) iCALoanModel.accountNumber) && k.a((Object) this.bankName, (Object) iCALoanModel.bankName) && k.a((Object) this.branchName, (Object) iCALoanModel.branchName) && k.a((Object) this.currentPrincipalOutstanding, (Object) iCALoanModel.currentPrincipalOutstanding) && k.a((Object) this.ifscCode, (Object) iCALoanModel.ifscCode) && k.a((Object) this.loanAmount, (Object) iCALoanModel.loanAmount) && k.a((Object) this.typeOfLoan, (Object) iCALoanModel.typeOfLoan);
    }

    public final int hashCode() {
        String str = this.accountNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.branchName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currentPrincipalOutstanding;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ifscCode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.loanAmount;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.typeOfLoan;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "ICALoanModel(accountNumber=" + this.accountNumber + ", bankName=" + this.bankName + ", branchName=" + this.branchName + ", currentPrincipalOutstanding=" + this.currentPrincipalOutstanding + ", ifscCode=" + this.ifscCode + ", loanAmount=" + this.loanAmount + ", typeOfLoan=" + this.typeOfLoan + ")";
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchName(String str) {
        this.branchName = str;
    }

    public final String getCurrentPrincipalOutstanding() {
        return this.currentPrincipalOutstanding;
    }

    public final void setCurrentPrincipalOutstanding(String str) {
        this.currentPrincipalOutstanding = str;
    }

    public final String getIfscCode() {
        return this.ifscCode;
    }

    public final void setIfscCode(String str) {
        this.ifscCode = str;
    }

    public final String getLoanAmount() {
        return this.loanAmount;
    }

    public final void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ICALoanModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.model.ICALoanModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTypeOfLoan() {
        return this.typeOfLoan;
    }

    public final void setTypeOfLoan(String str) {
        this.typeOfLoan = str;
    }

    public ICALoanModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.accountNumber = str;
        this.bankName = str2;
        this.branchName = str3;
        this.currentPrincipalOutstanding = str4;
        this.ifscCode = str5;
        this.loanAmount = str6;
        this.typeOfLoan = str7;
    }
}
