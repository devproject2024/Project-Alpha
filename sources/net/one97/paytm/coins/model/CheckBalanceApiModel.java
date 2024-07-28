package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CheckBalanceApiModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private BalanceModel response;

    public CheckBalanceApiModel() {
        this((BalanceModel) null, 1, (g) null);
    }

    public static /* synthetic */ CheckBalanceApiModel copy$default(CheckBalanceApiModel checkBalanceApiModel, BalanceModel balanceModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            balanceModel = checkBalanceApiModel.response;
        }
        return checkBalanceApiModel.copy(balanceModel);
    }

    public final BalanceModel component1() {
        return this.response;
    }

    public final CheckBalanceApiModel copy(BalanceModel balanceModel) {
        return new CheckBalanceApiModel(balanceModel);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CheckBalanceApiModel) && k.a((Object) this.response, (Object) ((CheckBalanceApiModel) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        BalanceModel balanceModel = this.response;
        if (balanceModel != null) {
            return balanceModel.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CheckBalanceApiModel(response=" + this.response + ")";
    }

    public CheckBalanceApiModel(BalanceModel balanceModel) {
        this.response = balanceModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckBalanceApiModel(BalanceModel balanceModel, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : balanceModel);
    }

    public final BalanceModel getResponse() {
        return this.response;
    }

    public final void setResponse(BalanceModel balanceModel) {
        this.response = balanceModel;
    }
}
