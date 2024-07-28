package net.one97.paytm.recharge.domain.entities;

public final class CJRCreditCardBinModel extends CJRCreditCardModel {
    public CJRCreditCardBinModel(CJRCreditCardHeadModel cJRCreditCardHeadModel, CJRCreditCardBodyModel cJRCreditCardBodyModel) {
        super(cJRCreditCardHeadModel, cJRCreditCardBodyModel);
    }

    public CJRCreditCardBinModel() {
        this((CJRCreditCardHeadModel) null, (CJRCreditCardBodyModel) null);
    }
}
