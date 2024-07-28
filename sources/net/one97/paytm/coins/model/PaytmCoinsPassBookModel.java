package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PaytmCoinsPassBookModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private ResponseModel response;

    public PaytmCoinsPassBookModel() {
        this((ResponseModel) null, 1, (g) null);
    }

    public static /* synthetic */ PaytmCoinsPassBookModel copy$default(PaytmCoinsPassBookModel paytmCoinsPassBookModel, ResponseModel responseModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            responseModel = paytmCoinsPassBookModel.response;
        }
        return paytmCoinsPassBookModel.copy(responseModel);
    }

    public final ResponseModel component1() {
        return this.response;
    }

    public final PaytmCoinsPassBookModel copy(ResponseModel responseModel) {
        return new PaytmCoinsPassBookModel(responseModel);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PaytmCoinsPassBookModel) && k.a((Object) this.response, (Object) ((PaytmCoinsPassBookModel) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        ResponseModel responseModel = this.response;
        if (responseModel != null) {
            return responseModel.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PaytmCoinsPassBookModel(response=" + this.response + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaytmCoinsPassBookModel(ResponseModel responseModel, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : responseModel);
    }

    public final ResponseModel getResponse() {
        return this.response;
    }

    public final void setResponse(ResponseModel responseModel) {
        this.response = responseModel;
    }

    public PaytmCoinsPassBookModel(ResponseModel responseModel) {
        this.response = responseModel;
    }
}
