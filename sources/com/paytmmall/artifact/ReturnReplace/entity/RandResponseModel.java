package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.CJRCustomTextModel;
import com.paytmmall.artifact.order.entity.impsdataentity.CJRPostReturnRefundConsultView;
import java.util.ArrayList;

public class RandResponseModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "custom_texts")
    private CJRCustomTextModel custom_texts;
    public String message;
    @b(a = "refundConsultInfo")
    private CJRPostReturnRefundConsultView refundConsultInfo;
    @b(a = "template")
    public ArrayList<ReturnResponseTitle> returnResponseTitleArrayList;
    public String statusCode;

    public static class ReturnResponseSubTitle extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "deeplink")
        public String deeplink;
        @b(a = "heading")
        public String heading;
        @b(a = "__highlightedText")
        public String highlightedText;
    }

    public static class ReturnResponseTitle extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "Subtitles")
        public ArrayList<ReturnResponseSubTitle> returnResponseSubTitleArrayList;
        @b(a = "title")
        public String title;
    }

    public String getMessage() {
        return this.message;
    }

    public CJRPostReturnRefundConsultView getRefundConsultInfo() {
        return this.refundConsultInfo;
    }

    public CJRCustomTextModel getCustom_texts() {
        return this.custom_texts;
    }

    public void setCustom_texts(CJRCustomTextModel cJRCustomTextModel) {
        this.custom_texts = cJRCustomTextModel;
    }
}
