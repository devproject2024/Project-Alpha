package net.one97.paytm.recharge.model.imps;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRImpsRefundModel extends IJRPaytmDataModel {
    private CJRImpsRefundBodyModel body;
    private CJRImpsRefundHeadModel head;

    public CJRImpsRefundModel() {
    }

    public CJRImpsRefundModel(CJRImpsRefundHeadModel cJRImpsRefundHeadModel, CJRImpsRefundBodyModel cJRImpsRefundBodyModel) {
        this();
        this.head = cJRImpsRefundHeadModel;
        this.body = cJRImpsRefundBodyModel;
    }

    public final CJRImpsRefundHeadModel getHead() {
        return this.head;
    }

    public final void setHead(CJRImpsRefundHeadModel cJRImpsRefundHeadModel) {
        this.head = cJRImpsRefundHeadModel;
    }

    public final CJRImpsRefundBodyModel getBody() {
        return this.body;
    }

    public final void setBody(CJRImpsRefundBodyModel cJRImpsRefundBodyModel) {
        this.body = cJRImpsRefundBodyModel;
    }
}
