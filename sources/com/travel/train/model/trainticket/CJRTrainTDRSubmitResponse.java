package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTDRSubmitResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainTDRSubmitBody body;
    @b(a = "code")
    private String mCode;
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainTDRSubmitBody getBody() {
        return this.body;
    }

    public String getmError() {
        return this.mError;
    }

    public String getmCode() {
        return this.mCode;
    }

    public class CJRTrainTDRSubmitBody implements IJRDataModel {
        @b(a = "message_html")
        private String messageHtml;
        @b(a = "title_text")
        private String titleText;

        public CJRTrainTDRSubmitBody() {
        }

        public String getTitleText() {
            return this.titleText;
        }

        public String getMessageHtml() {
            return this.messageHtml;
        }
    }
}
