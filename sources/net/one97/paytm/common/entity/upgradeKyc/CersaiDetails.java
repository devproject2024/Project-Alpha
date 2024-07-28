package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CersaiDetails implements IJRDataModel {
    @b(a = "address")
    private Address address;
    @b(a = "annualIncome")
    private String annualIncome;
    @b(a = "maritalStatus")
    private String maritalStatus;
    @b(a = "profession")
    private String profession;
    @b(a = "professionCategory")
    private String professionCategory;
    @b(a = "relationships")
    private ArrayList<RelationShipDetails> relationships;

    public CersaiDetails() {
        this((String) null, (String) null, (String) null, (String) null, (Address) null, (ArrayList) null, 63, (g) null);
    }

    public static /* synthetic */ CersaiDetails copy$default(CersaiDetails cersaiDetails, String str, String str2, String str3, String str4, Address address2, ArrayList<RelationShipDetails> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cersaiDetails.maritalStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = cersaiDetails.professionCategory;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = cersaiDetails.profession;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = cersaiDetails.annualIncome;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            address2 = cersaiDetails.address;
        }
        Address address3 = address2;
        if ((i2 & 32) != 0) {
            arrayList = cersaiDetails.relationships;
        }
        return cersaiDetails.copy(str, str5, str6, str7, address3, arrayList);
    }

    public final String component1() {
        return this.maritalStatus;
    }

    public final String component2() {
        return this.professionCategory;
    }

    public final String component3() {
        return this.profession;
    }

    public final String component4() {
        return this.annualIncome;
    }

    public final Address component5() {
        return this.address;
    }

    public final ArrayList<RelationShipDetails> component6() {
        return this.relationships;
    }

    public final CersaiDetails copy(String str, String str2, String str3, String str4, Address address2, ArrayList<RelationShipDetails> arrayList) {
        return new CersaiDetails(str, str2, str3, str4, address2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CersaiDetails)) {
            return false;
        }
        CersaiDetails cersaiDetails = (CersaiDetails) obj;
        return k.a((Object) this.maritalStatus, (Object) cersaiDetails.maritalStatus) && k.a((Object) this.professionCategory, (Object) cersaiDetails.professionCategory) && k.a((Object) this.profession, (Object) cersaiDetails.profession) && k.a((Object) this.annualIncome, (Object) cersaiDetails.annualIncome) && k.a((Object) this.address, (Object) cersaiDetails.address) && k.a((Object) this.relationships, (Object) cersaiDetails.relationships);
    }

    public final int hashCode() {
        String str = this.maritalStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.professionCategory;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.profession;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.annualIncome;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Address address2 = this.address;
        int hashCode5 = (hashCode4 + (address2 != null ? address2.hashCode() : 0)) * 31;
        ArrayList<RelationShipDetails> arrayList = this.relationships;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CersaiDetails(maritalStatus=" + this.maritalStatus + ", professionCategory=" + this.professionCategory + ", profession=" + this.profession + ", annualIncome=" + this.annualIncome + ", address=" + this.address + ", relationships=" + this.relationships + ")";
    }

    public CersaiDetails(String str, String str2, String str3, String str4, Address address2, ArrayList<RelationShipDetails> arrayList) {
        this.maritalStatus = str;
        this.professionCategory = str2;
        this.profession = str3;
        this.annualIncome = str4;
        this.address = address2;
        this.relationships = arrayList;
    }

    public final String getMaritalStatus() {
        return this.maritalStatus;
    }

    public final void setMaritalStatus(String str) {
        this.maritalStatus = str;
    }

    public final String getProfessionCategory() {
        return this.professionCategory;
    }

    public final void setProfessionCategory(String str) {
        this.professionCategory = str;
    }

    public final String getProfession() {
        return this.profession;
    }

    public final void setProfession(String str) {
        this.profession = str;
    }

    public final String getAnnualIncome() {
        return this.annualIncome;
    }

    public final void setAnnualIncome(String str) {
        this.annualIncome = str;
    }

    public final Address getAddress() {
        return this.address;
    }

    public final void setAddress(Address address2) {
        this.address = address2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CersaiDetails(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, net.one97.paytm.common.entity.upgradeKyc.Address r9, java.util.ArrayList r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = ""
        L_0x0006:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto L_0x000d
            r12 = r0
            goto L_0x000e
        L_0x000d:
            r12 = r6
        L_0x000e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.CersaiDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.common.entity.upgradeKyc.Address, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final ArrayList<RelationShipDetails> getRelationships() {
        return this.relationships;
    }

    public final void setRelationships(ArrayList<RelationShipDetails> arrayList) {
        this.relationships = arrayList;
    }
}
