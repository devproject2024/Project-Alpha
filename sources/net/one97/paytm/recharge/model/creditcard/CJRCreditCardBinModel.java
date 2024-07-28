package net.one97.paytm.recharge.model.creditcard;

public final class CJRCreditCardBinModel extends CJRCreditCardModel {
    public CJRCreditCardBinModel(CJRCreditCardHeadModel cJRCreditCardHeadModel, CJRCreditCardBodyModel cJRCreditCardBodyModel) {
        super(cJRCreditCardHeadModel, cJRCreditCardBodyModel);
    }

    public CJRCreditCardBinModel() {
        this((CJRCreditCardHeadModel) null, (CJRCreditCardBodyModel) null);
    }
}
