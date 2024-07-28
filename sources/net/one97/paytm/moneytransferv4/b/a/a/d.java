package net.one97.paytm.moneytransferv4.b.a.a;

import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;

public interface d {
    void a(InstrumentMeta instrumentMeta);

    void a(ContactDetail contactDetail, int i2);

    void a(ContactsResponse contactsResponse, String str);

    void a(AccountProviderBody.AccountProvider accountProvider);

    void a(UpiPendingRequestModel upiPendingRequestModel);

    void c();

    void d();

    void e();

    void f();

    void g();

    void h();
}
