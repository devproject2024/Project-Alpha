package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.impsdataentity.CJRImpsRefundConsultView;
import java.util.ArrayList;

public class CJRItemCancelReasonsResponse extends IJRPaytmDataModel {
    @b(a = "header")
    private String header;
    private String mConsultViewJsonString;
    @b(a = "proceedButton")
    private String proceedButton;
    @b(a = "reasonObjs")
    private ArrayList<CJRCancelReasons> reasonObjs;
    @b(a = "reason_selection_question")
    private String reasonSelectionQuestion;
    @b(a = "refundConsultInfo")
    private CJRImpsRefundConsultView refundConsultInfo;
    @b(a = "successMsg")
    private String successMsg;
    @b(a = "title")
    private String title;
    @b(a = "url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSuccessMsg() {
        return this.successMsg;
    }

    public String getReasonSelectionQuestion() {
        return this.reasonSelectionQuestion;
    }

    public String getHeader() {
        return this.header;
    }

    public String getProceedButton() {
        return this.proceedButton;
    }

    public ArrayList<CJRCancelReasons> getCancelReasonsList() {
        return this.reasonObjs;
    }

    public CJRImpsRefundConsultView getRefundConsultInfo() {
        return this.refundConsultInfo;
    }

    public void setRefundConsultInfo(CJRImpsRefundConsultView cJRImpsRefundConsultView) {
        this.refundConsultInfo = cJRImpsRefundConsultView;
    }

    public String getConsultViewJsonString() {
        return this.mConsultViewJsonString;
    }

    public void setConsultViewJsonString(String str) {
        this.mConsultViewJsonString = str;
    }
}
