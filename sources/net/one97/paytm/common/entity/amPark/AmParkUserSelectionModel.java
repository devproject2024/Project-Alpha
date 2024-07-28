package net.one97.paytm.common.entity.amPark;

import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;

public class AmParkUserSelectionModel {
    private CJRAddressDetailModel mAddressDetailModel;
    private String mDate;
    private CJRAmParkDateTimeModel.Time mTime;
    private AmParkTravellerResponseModel mTravellerResponseModel;
    private List<CJRSeatDetailsModel> mUserSelectedSeatList;

    public CJRAddressDetailModel getAddressDetailModel() {
        return this.mAddressDetailModel;
    }

    public void setAddressDetailModel(CJRAddressDetailModel cJRAddressDetailModel) {
        this.mAddressDetailModel = cJRAddressDetailModel;
    }

    public String getSelectedDate() {
        return this.mDate;
    }

    public void setSelectedDate(String str) {
        this.mDate = str;
    }

    public CJRAmParkDateTimeModel.Time getSelectedTime() {
        return this.mTime;
    }

    public void setSelectedTime(CJRAmParkDateTimeModel.Time time) {
        this.mTime = time;
    }

    public List<CJRSeatDetailsModel> getSelectedSeatsList() {
        return this.mUserSelectedSeatList;
    }

    public void setSelectedSeatList(List<CJRSeatDetailsModel> list) {
        this.mUserSelectedSeatList = list;
    }

    public AmParkTravellerResponseModel getTravellerResponseModel() {
        return this.mTravellerResponseModel;
    }

    public void setTravellerResponseModel(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        this.mTravellerResponseModel = amParkTravellerResponseModel;
    }
}
