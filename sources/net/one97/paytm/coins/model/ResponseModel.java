package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "loyaltyPoints")
    private ArrayList<LoyaltyModel> loyaltyPoints;
    @b(a = "paginator")
    private PaginatorModel paginator;
    @b(a = "result")
    private ResultModel result;

    public ResponseModel() {
        this((ResultModel) null, (ArrayList) null, (PaginatorModel) null, 7, (g) null);
    }

    public static /* synthetic */ ResponseModel copy$default(ResponseModel responseModel, ResultModel resultModel, ArrayList<LoyaltyModel> arrayList, PaginatorModel paginatorModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resultModel = responseModel.result;
        }
        if ((i2 & 2) != 0) {
            arrayList = responseModel.loyaltyPoints;
        }
        if ((i2 & 4) != 0) {
            paginatorModel = responseModel.paginator;
        }
        return responseModel.copy(resultModel, arrayList, paginatorModel);
    }

    public final ResultModel component1() {
        return this.result;
    }

    public final ArrayList<LoyaltyModel> component2() {
        return this.loyaltyPoints;
    }

    public final PaginatorModel component3() {
        return this.paginator;
    }

    public final ResponseModel copy(ResultModel resultModel, ArrayList<LoyaltyModel> arrayList, PaginatorModel paginatorModel) {
        return new ResponseModel(resultModel, arrayList, paginatorModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseModel)) {
            return false;
        }
        ResponseModel responseModel = (ResponseModel) obj;
        return k.a((Object) this.result, (Object) responseModel.result) && k.a((Object) this.loyaltyPoints, (Object) responseModel.loyaltyPoints) && k.a((Object) this.paginator, (Object) responseModel.paginator);
    }

    public final int hashCode() {
        ResultModel resultModel = this.result;
        int i2 = 0;
        int hashCode = (resultModel != null ? resultModel.hashCode() : 0) * 31;
        ArrayList<LoyaltyModel> arrayList = this.loyaltyPoints;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        PaginatorModel paginatorModel = this.paginator;
        if (paginatorModel != null) {
            i2 = paginatorModel.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ResponseModel(result=" + this.result + ", loyaltyPoints=" + this.loyaltyPoints + ", paginator=" + this.paginator + ")";
    }

    public final ResultModel getResult() {
        return this.result;
    }

    public final void setResult(ResultModel resultModel) {
        this.result = resultModel;
    }

    public final ArrayList<LoyaltyModel> getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public final void setLoyaltyPoints(ArrayList<LoyaltyModel> arrayList) {
        this.loyaltyPoints = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseModel(ResultModel resultModel, ArrayList arrayList, PaginatorModel paginatorModel, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : resultModel, (i2 & 2) != 0 ? null : arrayList, (i2 & 4) != 0 ? null : paginatorModel);
    }

    public final PaginatorModel getPaginator() {
        return this.paginator;
    }

    public final void setPaginator(PaginatorModel paginatorModel) {
        this.paginator = paginatorModel;
    }

    public ResponseModel(ResultModel resultModel, ArrayList<LoyaltyModel> arrayList, PaginatorModel paginatorModel) {
        this.result = resultModel;
        this.loyaltyPoints = arrayList;
        this.paginator = paginatorModel;
    }
}
