package net.one97.paytm.recharge.model.creditcard;

public final class CJRCreditCardTokenizationModel extends CJRCreditCardModel {
    public CJRCreditCardTokenizationModel() {
        super((CJRCreditCardHeadModel) null, (CJRCreditCardBodyModel) null);
    }

    public CJRCreditCardTokenizationModel(CJRCreditCardHeadModel cJRCreditCardHeadModel, CJRCreditCardBodyModel cJRCreditCardBodyModel) {
        super(cJRCreditCardHeadModel, cJRCreditCardBodyModel);
    }
}
