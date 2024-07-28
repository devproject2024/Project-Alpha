package net.one97.paytm.recharge.model.creditcard;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCreditCardModel extends IJRPaytmDataModel implements IJRDataModel {
    private CJRCreditCardBodyModel body;
    private CJRCreditCardHeadModel head;

    public CJRCreditCardModel() {
    }

    public CJRCreditCardModel(CJRCreditCardHeadModel cJRCreditCardHeadModel, CJRCreditCardBodyModel cJRCreditCardBodyModel) {
        this();
        this.head = cJRCreditCardHeadModel;
        this.body = cJRCreditCardBodyModel;
    }

    public final CJRCreditCardHeadModel getHead() {
        return this.head;
    }

    public final void setHead(CJRCreditCardHeadModel cJRCreditCardHeadModel) {
        this.head = cJRCreditCardHeadModel;
    }

    public final CJRCreditCardBodyModel getBody() {
        return this.body;
    }

    public final void setBody(CJRCreditCardBodyModel cJRCreditCardBodyModel) {
        this.body = cJRCreditCardBodyModel;
    }
}
