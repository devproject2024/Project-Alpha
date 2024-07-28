package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkAutosuggestAmParkModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private CJRAmParkAutosuggestModel parks;

    public CJRAmParkAutosuggestModel getEvents() {
        return this.parks;
    }

    public void setEvents(CJRAmParkAutosuggestModel cJRAmParkAutosuggestModel) {
        this.parks = cJRAmParkAutosuggestModel;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) {
        CJRAmParkAutosuggestModel[] cJRAmParkAutosuggestModelArr = (CJRAmParkAutosuggestModel[]) fVar.a(str, CJRAmParkAutosuggestModel[].class);
        if (cJRAmParkAutosuggestModelArr == null || cJRAmParkAutosuggestModelArr.length <= 0) {
            return new CJRAmParkAutosuggestModel();
        }
        return cJRAmParkAutosuggestModelArr[0];
    }
}
