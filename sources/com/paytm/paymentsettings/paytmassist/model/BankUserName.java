package com.paytm.paymentsettings.paytmassist.model;

import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BankUserName implements IJRDataModel {
    private boolean isSelected;
    private String mBankChannelCode;
    private String mBankLogoUrl;
    private String mBankName;
    private ArrayList<String> mUserNameList;

    public static /* synthetic */ BankUserName copy$default(BankUserName bankUserName, String str, String str2, ArrayList<String> arrayList, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankUserName.mBankName;
        }
        if ((i2 & 2) != 0) {
            str2 = bankUserName.mBankLogoUrl;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            arrayList = bankUserName.mUserNameList;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            z = bankUserName.isSelected;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str3 = bankUserName.mBankChannelCode;
        }
        return bankUserName.copy(str, str4, arrayList2, z2, str3);
    }

    public final String component1() {
        return this.mBankName;
    }

    public final String component2() {
        return this.mBankLogoUrl;
    }

    public final ArrayList<String> component3() {
        return this.mUserNameList;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final String component5() {
        return this.mBankChannelCode;
    }

    public final BankUserName copy(String str, String str2, ArrayList<String> arrayList, boolean z, String str3) {
        return new BankUserName(str, str2, arrayList, z, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankUserName)) {
            return false;
        }
        BankUserName bankUserName = (BankUserName) obj;
        return k.a((Object) this.mBankName, (Object) bankUserName.mBankName) && k.a((Object) this.mBankLogoUrl, (Object) bankUserName.mBankLogoUrl) && k.a((Object) this.mUserNameList, (Object) bankUserName.mUserNameList) && this.isSelected == bankUserName.isSelected && k.a((Object) this.mBankChannelCode, (Object) bankUserName.mBankChannelCode);
    }

    public final int hashCode() {
        String str = this.mBankName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mBankLogoUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.mUserNameList;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str3 = this.mBankChannelCode;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "BankUserName(mBankName=" + this.mBankName + ", mBankLogoUrl=" + this.mBankLogoUrl + ", mUserNameList=" + this.mUserNameList + ", isSelected=" + this.isSelected + ", mBankChannelCode=" + this.mBankChannelCode + ")";
    }

    public BankUserName(String str, String str2, ArrayList<String> arrayList, boolean z, String str3) {
        this.mBankName = str;
        this.mBankLogoUrl = str2;
        this.mUserNameList = arrayList;
        this.isSelected = z;
        this.mBankChannelCode = str3;
    }

    public final String getMBankChannelCode() {
        return this.mBankChannelCode;
    }

    public final String getMBankLogoUrl() {
        return this.mBankLogoUrl;
    }

    public final String getMBankName() {
        return this.mBankName;
    }

    public final ArrayList<String> getMUserNameList() {
        return this.mUserNameList;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setMBankChannelCode(String str) {
        this.mBankChannelCode = str;
    }

    public final void setMBankLogoUrl(String str) {
        this.mBankLogoUrl = str;
    }

    public final void setMBankName(String str) {
        this.mBankName = str;
    }

    public final void setMUserNameList(ArrayList<String> arrayList) {
        this.mUserNameList = arrayList;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
