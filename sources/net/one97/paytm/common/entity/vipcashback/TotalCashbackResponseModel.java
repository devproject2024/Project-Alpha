package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TotalCashbackResponseModel extends IJRPaytmDataModel {
    @b(a = "response")
    private List<TotalCashbackModel> response;

    public TotalCashbackResponseModel() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ TotalCashbackResponseModel copy$default(TotalCashbackResponseModel totalCashbackResponseModel, List<TotalCashbackModel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = totalCashbackResponseModel.response;
        }
        return totalCashbackResponseModel.copy(list);
    }

    public final List<TotalCashbackModel> component1() {
        return this.response;
    }

    public final TotalCashbackResponseModel copy(List<TotalCashbackModel> list) {
        return new TotalCashbackResponseModel(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TotalCashbackResponseModel) && k.a((Object) this.response, (Object) ((TotalCashbackResponseModel) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        List<TotalCashbackModel> list = this.response;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "TotalCashbackResponseModel(response=" + this.response + ")";
    }

    public TotalCashbackResponseModel(List<TotalCashbackModel> list) {
        this.response = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TotalCashbackResponseModel(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<TotalCashbackModel> getResponse() {
        return this.response;
    }

    public final void setResponse(List<TotalCashbackModel> list) {
        this.response = list;
    }
}
