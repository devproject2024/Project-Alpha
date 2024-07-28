package net.one97.paytm.common.entity.amPark;

import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;

public class AmParkBookingModel {
    private CJRAddressDetailModel mAddressDetail;
    private CJRParticularAmParkDescriptionModel mEventDescriptionModel;
    private AmParkUserSelectionModel mEventUserSelectionModel = new AmParkUserSelectionModel();

    public void setAddressDetail(CJRAddressDetailModel cJRAddressDetailModel) {
        this.mAddressDetail = cJRAddressDetailModel;
    }

    public CJRAddressDetailModel getAddressDetail() {
        return this.mAddressDetail;
    }

    public void setSelectedAddressModel(CJRAddressDetailModel cJRAddressDetailModel) {
        this.mEventUserSelectionModel.setAddressDetailModel(cJRAddressDetailModel);
    }

    public CJRAddressDetailModel getSelectedAddressModel() {
        return this.mEventUserSelectionModel.getAddressDetailModel();
    }

    public void setSelectedDate(String str) {
        this.mEventUserSelectionModel.setSelectedDate(str);
    }

    public String getSelectedDate() {
        return this.mEventUserSelectionModel.getSelectedDate();
    }

    public void setSelectedTime(CJRAmParkDateTimeModel.Time time) {
        this.mEventUserSelectionModel.setSelectedTime(time);
    }

    public CJRAmParkDateTimeModel.Time getSelectedTime() {
        return this.mEventUserSelectionModel.getSelectedTime();
    }

    public void setEventDescriptionModel(CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel) {
        this.mEventDescriptionModel = cJRParticularAmParkDescriptionModel;
    }

    public CJRParticularAmParkDescriptionModel getEventDescriptionModel() {
        return this.mEventDescriptionModel;
    }
}
