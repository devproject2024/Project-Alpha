package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BalanceInfoV2 implements IJRDataModel {
    @b(a = "accountBalance")
    private AccountBalanceV2 accountBalance;
    @b(a = "additionalProperties")
    private HashMap<String, Object> additionalProperties;
    @b(a = "extendInfo")
    private final ExtendInfoV2 extendInfo;
    @b(a = "payerAccountNo")
    private String payerAccountNo;
    @b(a = "subWalletDetails")
    private ArrayList<SubWalletDetailV2> subWalletDetailV2;

    public static /* synthetic */ BalanceInfoV2 copy$default(BalanceInfoV2 balanceInfoV2, String str, AccountBalanceV2 accountBalanceV2, ExtendInfoV2 extendInfoV2, HashMap<String, Object> hashMap, ArrayList<SubWalletDetailV2> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = balanceInfoV2.payerAccountNo;
        }
        if ((i2 & 2) != 0) {
            accountBalanceV2 = balanceInfoV2.accountBalance;
        }
        AccountBalanceV2 accountBalanceV22 = accountBalanceV2;
        if ((i2 & 4) != 0) {
            extendInfoV2 = balanceInfoV2.extendInfo;
        }
        ExtendInfoV2 extendInfoV22 = extendInfoV2;
        if ((i2 & 8) != 0) {
            hashMap = balanceInfoV2.additionalProperties;
        }
        HashMap<String, Object> hashMap2 = hashMap;
        if ((i2 & 16) != 0) {
            arrayList = balanceInfoV2.subWalletDetailV2;
        }
        return balanceInfoV2.copy(str, accountBalanceV22, extendInfoV22, hashMap2, arrayList);
    }

    public final String component1() {
        return this.payerAccountNo;
    }

    public final AccountBalanceV2 component2() {
        return this.accountBalance;
    }

    public final ExtendInfoV2 component3() {
        return this.extendInfo;
    }

    public final HashMap<String, Object> component4() {
        return this.additionalProperties;
    }

    public final ArrayList<SubWalletDetailV2> component5() {
        return this.subWalletDetailV2;
    }

    public final BalanceInfoV2 copy(String str, AccountBalanceV2 accountBalanceV2, ExtendInfoV2 extendInfoV2, HashMap<String, Object> hashMap, ArrayList<SubWalletDetailV2> arrayList) {
        return new BalanceInfoV2(str, accountBalanceV2, extendInfoV2, hashMap, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceInfoV2)) {
            return false;
        }
        BalanceInfoV2 balanceInfoV2 = (BalanceInfoV2) obj;
        return k.a((Object) this.payerAccountNo, (Object) balanceInfoV2.payerAccountNo) && k.a((Object) this.accountBalance, (Object) balanceInfoV2.accountBalance) && k.a((Object) this.extendInfo, (Object) balanceInfoV2.extendInfo) && k.a((Object) this.additionalProperties, (Object) balanceInfoV2.additionalProperties) && k.a((Object) this.subWalletDetailV2, (Object) balanceInfoV2.subWalletDetailV2);
    }

    public final int hashCode() {
        String str = this.payerAccountNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AccountBalanceV2 accountBalanceV2 = this.accountBalance;
        int hashCode2 = (hashCode + (accountBalanceV2 != null ? accountBalanceV2.hashCode() : 0)) * 31;
        ExtendInfoV2 extendInfoV2 = this.extendInfo;
        int hashCode3 = (hashCode2 + (extendInfoV2 != null ? extendInfoV2.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap = this.additionalProperties;
        int hashCode4 = (hashCode3 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        ArrayList<SubWalletDetailV2> arrayList = this.subWalletDetailV2;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "BalanceInfoV2(payerAccountNo=" + this.payerAccountNo + ", accountBalance=" + this.accountBalance + ", extendInfo=" + this.extendInfo + ", additionalProperties=" + this.additionalProperties + ", subWalletDetailV2=" + this.subWalletDetailV2 + ")";
    }

    public BalanceInfoV2(String str, AccountBalanceV2 accountBalanceV2, ExtendInfoV2 extendInfoV2, HashMap<String, Object> hashMap, ArrayList<SubWalletDetailV2> arrayList) {
        this.payerAccountNo = str;
        this.accountBalance = accountBalanceV2;
        this.extendInfo = extendInfoV2;
        this.additionalProperties = hashMap;
        this.subWalletDetailV2 = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BalanceInfoV2(String str, AccountBalanceV2 accountBalanceV2, ExtendInfoV2 extendInfoV2, HashMap hashMap, ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : accountBalanceV2, (i2 & 4) != 0 ? null : extendInfoV2, hashMap, (i2 & 16) != 0 ? null : arrayList);
    }

    public final AccountBalanceV2 getAccountBalance() {
        return this.accountBalance;
    }

    public final HashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final ExtendInfoV2 getExtendInfo() {
        return this.extendInfo;
    }

    public final String getPayerAccountNo() {
        return this.payerAccountNo;
    }

    public final ArrayList<SubWalletDetailV2> getSubWalletDetailV2() {
        return this.subWalletDetailV2;
    }

    public final void setAccountBalance(AccountBalanceV2 accountBalanceV2) {
        this.accountBalance = accountBalanceV2;
    }

    public final void setAdditionalProperties(HashMap<String, Object> hashMap) {
        this.additionalProperties = hashMap;
    }

    public final void setPayerAccountNo(String str) {
        this.payerAccountNo = str;
    }

    public final void setSubWalletDetailV2(ArrayList<SubWalletDetailV2> arrayList) {
        this.subWalletDetailV2 = arrayList;
    }
}
