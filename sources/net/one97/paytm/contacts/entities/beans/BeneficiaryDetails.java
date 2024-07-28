package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails;

public final class BeneficiaryDetails extends IJRPaytmDataModel implements IJRDataModel {
    private String name;
    private String nickname;
    private PaymentInstrumentDetails paymentInstruments;
    private String subtitleDetail;
    private String type;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getSubtitleDetail() {
        return this.subtitleDetail;
    }

    public final void setSubtitleDetail(String str) {
        this.subtitleDetail = str;
    }

    public final PaymentInstrumentDetails getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public final void setPaymentInstruments(PaymentInstrumentDetails paymentInstrumentDetails) {
        this.paymentInstruments = paymentInstrumentDetails;
    }
}
