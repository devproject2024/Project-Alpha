package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFoodBeverageSetResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String mFoodBevResponse;

    public String getmFoodBevResponse() {
        return this.mFoodBevResponse;
    }

    public void setmFoodBevResponse(String str) {
        this.mFoodBevResponse = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRFoodBeverageSetResponse cJRFoodBeverageSetResponse = new CJRFoodBeverageSetResponse();
        cJRFoodBeverageSetResponse.setmFoodBevResponse(str);
        return cJRFoodBeverageSetResponse;
    }
}
