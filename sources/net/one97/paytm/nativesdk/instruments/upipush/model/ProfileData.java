package net.one97.paytm.nativesdk.instruments.upipush.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class ProfileData implements BaseDataModel {
    private List<VpaBankAccountDetail> bankAccounts;
    private boolean deviceBinded;
    private boolean isInitilized;
    private String profileStatus;
    private String upiLinkedMobileNumber;
    private List<VpaAccountDetail> vpaDetails;

    public static /* synthetic */ ProfileData copy$default(ProfileData profileData, List<VpaAccountDetail> list, List<VpaBankAccountDetail> list2, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = profileData.vpaDetails;
        }
        if ((i2 & 2) != 0) {
            list2 = profileData.bankAccounts;
        }
        List<VpaBankAccountDetail> list3 = list2;
        if ((i2 & 4) != 0) {
            str = profileData.profileStatus;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = profileData.upiLinkedMobileNumber;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            z = profileData.deviceBinded;
        }
        return profileData.copy(list, list3, str3, str4, z);
    }

    public final List<VpaAccountDetail> component1() {
        return this.vpaDetails;
    }

    public final List<VpaBankAccountDetail> component2() {
        return this.bankAccounts;
    }

    public final String component3() {
        return this.profileStatus;
    }

    public final String component4() {
        return this.upiLinkedMobileNumber;
    }

    public final boolean component5() {
        return this.deviceBinded;
    }

    public final ProfileData copy(List<VpaAccountDetail> list, List<VpaBankAccountDetail> list2, String str, String str2, boolean z) {
        return new ProfileData(list, list2, str, str2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileData)) {
            return false;
        }
        ProfileData profileData = (ProfileData) obj;
        return k.a((Object) this.vpaDetails, (Object) profileData.vpaDetails) && k.a((Object) this.bankAccounts, (Object) profileData.bankAccounts) && k.a((Object) this.profileStatus, (Object) profileData.profileStatus) && k.a((Object) this.upiLinkedMobileNumber, (Object) profileData.upiLinkedMobileNumber) && this.deviceBinded == profileData.deviceBinded;
    }

    public final int hashCode() {
        List<VpaAccountDetail> list = this.vpaDetails;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<VpaBankAccountDetail> list2 = this.bankAccounts;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.profileStatus;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.upiLinkedMobileNumber;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.deviceBinded;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "ProfileData(vpaDetails=" + this.vpaDetails + ", bankAccounts=" + this.bankAccounts + ", profileStatus=" + this.profileStatus + ", upiLinkedMobileNumber=" + this.upiLinkedMobileNumber + ", deviceBinded=" + this.deviceBinded + ")";
    }

    public ProfileData(List<VpaAccountDetail> list, List<VpaBankAccountDetail> list2, String str, String str2, boolean z) {
        this.vpaDetails = list;
        this.bankAccounts = list2;
        this.profileStatus = str;
        this.upiLinkedMobileNumber = str2;
        this.deviceBinded = z;
    }

    public final List<VpaAccountDetail> getVpaDetails() {
        return this.vpaDetails;
    }

    public final void setVpaDetails(List<VpaAccountDetail> list) {
        this.vpaDetails = list;
    }

    public final List<VpaBankAccountDetail> getBankAccounts() {
        return this.bankAccounts;
    }

    public final void setBankAccounts(List<VpaBankAccountDetail> list) {
        this.bankAccounts = list;
    }

    public final String getProfileStatus() {
        return this.profileStatus;
    }

    public final void setProfileStatus(String str) {
        this.profileStatus = str;
    }

    public final String getUpiLinkedMobileNumber() {
        return this.upiLinkedMobileNumber;
    }

    public final void setUpiLinkedMobileNumber(String str) {
        this.upiLinkedMobileNumber = str;
    }

    public final boolean getDeviceBinded() {
        return this.deviceBinded;
    }

    public final void setDeviceBinded(boolean z) {
        this.deviceBinded = z;
    }

    public final void init() {
        if (!this.isInitilized) {
            VpaAccountDetail vpaAccountDetail = null;
            HashMap hashMap = new HashMap();
            List<VpaAccountDetail> list = this.vpaDetails;
            if (list != null) {
                for (VpaAccountDetail vpaAccountDetail2 : list) {
                    if (vpaAccountDetail2.getPrimary()) {
                        vpaAccountDetail = vpaAccountDetail2;
                    }
                    String defaultDebitAccRefId = vpaAccountDetail2.getDefaultDebitAccRefId();
                    if (defaultDebitAccRefId != null) {
                        if (hashMap.get(defaultDebitAccRefId) != null) {
                            Object obj = hashMap.get(defaultDebitAccRefId);
                            if (obj == null) {
                                k.a();
                            }
                            if (((VpaAccountDetail) obj).getPrimary()) {
                            }
                        }
                        hashMap.put(defaultDebitAccRefId, vpaAccountDetail2);
                    }
                }
            }
            List<VpaBankAccountDetail> list2 = this.bankAccounts;
            if (list2 != null) {
                for (VpaBankAccountDetail vpaBankAccountDetail : list2) {
                    Map map = hashMap;
                    if (map.get(vpaBankAccountDetail.getAccRefId()) != null) {
                        vpaBankAccountDetail.setVpaDetail((VpaAccountDetail) map.get(vpaBankAccountDetail.getAccRefId()));
                    } else {
                        vpaBankAccountDetail.setVpaDetail(vpaAccountDetail);
                    }
                }
            }
            this.isInitilized = true;
        }
    }
}
