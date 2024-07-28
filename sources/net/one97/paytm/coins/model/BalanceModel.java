package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BalanceModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "activeBalance")
    private String activeBalance;
    @b(a = "exchangeRate")
    private String exchangeRate;
    @b(a = "result")
    private ResultModel result;

    public BalanceModel() {
        this((ResultModel) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ BalanceModel copy$default(BalanceModel balanceModel, ResultModel resultModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resultModel = balanceModel.result;
        }
        if ((i2 & 2) != 0) {
            str = balanceModel.activeBalance;
        }
        if ((i2 & 4) != 0) {
            str2 = balanceModel.exchangeRate;
        }
        return balanceModel.copy(resultModel, str, str2);
    }

    public final ResultModel component1() {
        return this.result;
    }

    public final String component2() {
        return this.activeBalance;
    }

    public final String component3() {
        return this.exchangeRate;
    }

    public final BalanceModel copy(ResultModel resultModel, String str, String str2) {
        return new BalanceModel(resultModel, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceModel)) {
            return false;
        }
        BalanceModel balanceModel = (BalanceModel) obj;
        return k.a((Object) this.result, (Object) balanceModel.result) && k.a((Object) this.activeBalance, (Object) balanceModel.activeBalance) && k.a((Object) this.exchangeRate, (Object) balanceModel.exchangeRate);
    }

    public final int hashCode() {
        ResultModel resultModel = this.result;
        int i2 = 0;
        int hashCode = (resultModel != null ? resultModel.hashCode() : 0) * 31;
        String str = this.activeBalance;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.exchangeRate;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "BalanceModel(result=" + this.result + ", activeBalance=" + this.activeBalance + ", exchangeRate=" + this.exchangeRate + ")";
    }

    public final ResultModel getResult() {
        return this.result;
    }

    public final void setResult(ResultModel resultModel) {
        this.result = resultModel;
    }

    public final String getActiveBalance() {
        return this.activeBalance;
    }

    public final void setActiveBalance(String str) {
        this.activeBalance = str;
    }

    public BalanceModel(ResultModel resultModel, String str, String str2) {
        this.result = resultModel;
        this.activeBalance = str;
        this.exchangeRate = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BalanceModel(ResultModel resultModel, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : resultModel, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final String getExchangeRate() {
        return this.exchangeRate;
    }

    public final void setExchangeRate(String str) {
        this.exchangeRate = str;
    }
}
