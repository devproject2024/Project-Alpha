package net.one97.paytm.common.entity.events;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPrevalidateResponseModel implements IJRDataModel {
    private String addOnId;
    private CJREventAddOnItemsModel addOnItems;
    private CJREventsConvenienceFee convFeeResponse;
    private String fbProductId;
    ArrayList<CJREventFnBAddOnModel> mSelectedFnBAddOnList;
    ArrayList<CJREventFnBAddOnModel> mSelectedMerchandiseAddOnList;
    private String merchProductId;

    public CJREventAddOnItemsModel getAddOnItems() {
        return this.addOnItems;
    }

    public void setAddOnItems(CJREventAddOnItemsModel cJREventAddOnItemsModel) {
        this.addOnItems = cJREventAddOnItemsModel;
    }

    public String getAddOnId() {
        return this.addOnId;
    }

    public void setAddOnId(String str) {
        this.addOnId = str;
    }

    public String getFbProductId() {
        return this.fbProductId;
    }

    public void setFbProductId(String str) {
        this.fbProductId = str;
    }

    public String getMerchProductId() {
        return this.merchProductId;
    }

    public void setMerchProductId(String str) {
        this.merchProductId = str;
    }

    public ArrayList<CJREventFnBAddOnModel> getmSelectedFnBAddOnList() {
        return this.mSelectedFnBAddOnList;
    }

    public void setmSelectedFnBAddOnList(ArrayList<CJREventFnBAddOnModel> arrayList) {
        this.mSelectedFnBAddOnList = arrayList;
    }

    public ArrayList<CJREventFnBAddOnModel> getmSelectedMerchandiseAddOnList() {
        return this.mSelectedMerchandiseAddOnList;
    }

    public void setmSelectedMerchandiseAddOnList(ArrayList<CJREventFnBAddOnModel> arrayList) {
        this.mSelectedMerchandiseAddOnList = arrayList;
    }

    public CJREventsConvenienceFee getConvFeeResponse() {
        return this.convFeeResponse;
    }

    public void setConvFeeResponse(CJREventsConvenienceFee cJREventsConvenienceFee) {
        this.convFeeResponse = cJREventsConvenienceFee;
    }
}
