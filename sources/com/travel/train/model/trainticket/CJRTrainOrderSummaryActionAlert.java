package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryActionAlert extends IJRPaytmDataModel implements IJRDataModel {
    private String cancelButton;
    private String heading;
    private String message;
    private String okbutton;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOkbutton() {
        return this.okbutton;
    }

    public String getCancelButton() {
        return this.cancelButton;
    }
}
