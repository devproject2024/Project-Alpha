package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashSet;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactsResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String contactId;
    private ContactInfo contactInfo;
    private String contactType;
    private String name;
    private String nickName;
    HashSet<PaymentInstrument> paymentInstruments = new HashSet<>();
    private String status;

    public String getContactId() {
        return this.contactId;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getStatus() {
        return this.status;
    }

    public HashSet<PaymentInstrument> getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public ContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public String getContactType() {
        return this.contactType;
    }
}
