package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ProfileDetailV2 extends CJRWalletDataModel {
    @b(a = "bankAccounts")
    private ArrayList<BankAccountsV2> bankAccounts;
    @b(a = "deviceBinded")
    private Boolean deviceBinded;
    @b(a = "profileStatus")
    private String profileStatus;
    @b(a = "upiLinkedMobileNumber")
    private String upiLinkedMobileNumber;
    @b(a = "vpaDetails")
    private ArrayList<VpaDetailsV2> vpaDetails;

    public ProfileDetailV2() {
        this((ArrayList) null, (ArrayList) null, (String) null, (String) null, (Boolean) null, 31, (g) null);
    }

    public static /* synthetic */ ProfileDetailV2 copy$default(ProfileDetailV2 profileDetailV2, ArrayList<VpaDetailsV2> arrayList, ArrayList<BankAccountsV2> arrayList2, String str, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = profileDetailV2.vpaDetails;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = profileDetailV2.bankAccounts;
        }
        ArrayList<BankAccountsV2> arrayList3 = arrayList2;
        if ((i2 & 4) != 0) {
            str = profileDetailV2.profileStatus;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = profileDetailV2.upiLinkedMobileNumber;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            bool = profileDetailV2.deviceBinded;
        }
        return profileDetailV2.copy(arrayList, arrayList3, str3, str4, bool);
    }

    public final ArrayList<VpaDetailsV2> component1() {
        return this.vpaDetails;
    }

    public final ArrayList<BankAccountsV2> component2() {
        return this.bankAccounts;
    }

    public final String component3() {
        return this.profileStatus;
    }

    public final String component4() {
        return this.upiLinkedMobileNumber;
    }

    public final Boolean component5() {
        return this.deviceBinded;
    }

    public final ProfileDetailV2 copy(ArrayList<VpaDetailsV2> arrayList, ArrayList<BankAccountsV2> arrayList2, String str, String str2, Boolean bool) {
        return new ProfileDetailV2(arrayList, arrayList2, str, str2, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDetailV2)) {
            return false;
        }
        ProfileDetailV2 profileDetailV2 = (ProfileDetailV2) obj;
        return k.a((Object) this.vpaDetails, (Object) profileDetailV2.vpaDetails) && k.a((Object) this.bankAccounts, (Object) profileDetailV2.bankAccounts) && k.a((Object) this.profileStatus, (Object) profileDetailV2.profileStatus) && k.a((Object) this.upiLinkedMobileNumber, (Object) profileDetailV2.upiLinkedMobileNumber) && k.a((Object) this.deviceBinded, (Object) profileDetailV2.deviceBinded);
    }

    public final int hashCode() {
        ArrayList<VpaDetailsV2> arrayList = this.vpaDetails;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<BankAccountsV2> arrayList2 = this.bankAccounts;
        int hashCode2 = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        String str = this.profileStatus;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.upiLinkedMobileNumber;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.deviceBinded;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ProfileDetailV2(vpaDetails=" + this.vpaDetails + ", bankAccounts=" + this.bankAccounts + ", profileStatus=" + this.profileStatus + ", upiLinkedMobileNumber=" + this.upiLinkedMobileNumber + ", deviceBinded=" + this.deviceBinded + ")";
    }

    public final ArrayList<VpaDetailsV2> getVpaDetails() {
        return this.vpaDetails;
    }

    public final void setVpaDetails(ArrayList<VpaDetailsV2> arrayList) {
        this.vpaDetails = arrayList;
    }

    public final ArrayList<BankAccountsV2> getBankAccounts() {
        return this.bankAccounts;
    }

    public final void setBankAccounts(ArrayList<BankAccountsV2> arrayList) {
        this.bankAccounts = arrayList;
    }

    public final String getProfileStatus() {
        return this.profileStatus;
    }

    public final void setProfileStatus(String str) {
        this.profileStatus = str;
    }

    public ProfileDetailV2(ArrayList<VpaDetailsV2> arrayList, ArrayList<BankAccountsV2> arrayList2, String str, String str2, Boolean bool) {
        this.vpaDetails = arrayList;
        this.bankAccounts = arrayList2;
        this.profileStatus = str;
        this.upiLinkedMobileNumber = str2;
        this.deviceBinded = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProfileDetailV2(java.util.ArrayList r4, java.util.ArrayList r5, java.lang.String r6, java.lang.String r7, java.lang.Boolean r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0022
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
        L_0x0022:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.ProfileDetailV2.<init>(java.util.ArrayList, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Boolean getDeviceBinded() {
        return this.deviceBinded;
    }

    public final String getUpiLinkedMobileNumber() {
        return this.upiLinkedMobileNumber;
    }

    public final void setDeviceBinded(Boolean bool) {
        this.deviceBinded = bool;
    }

    public final void setUpiLinkedMobileNumber(String str) {
        this.upiLinkedMobileNumber = str;
    }
}
