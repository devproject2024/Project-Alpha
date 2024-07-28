package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTDRReasons extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "header_text")
    private String headerText;
    @b(a = "reasons")
    private ArrayList<ReasonItem> reasons;
    @b(a = "tip_text")
    private String tipText;

    public String getHeaderText() {
        return this.headerText;
    }

    public String getTipText() {
        return this.tipText;
    }

    public ArrayList<ReasonItem> getReasons() {
        return this.reasons;
    }

    public class ReasonItem implements IJRDataModel {
        private boolean isSelected = false;
        @b(a = "reason_disclaimer_html")
        private String reasonDisclaimer;
        @b(a = "id")
        private Integer reasonId;
        @b(a = "reason_text")
        private String reasonText;

        public ReasonItem() {
        }

        public String getReasonText() {
            return this.reasonText;
        }

        public String getReasonDisclaimer() {
            return this.reasonDisclaimer;
        }

        public Integer getReasonId() {
            return this.reasonId;
        }

        public boolean isSelected() {
            return this.isSelected;
        }
    }
}
