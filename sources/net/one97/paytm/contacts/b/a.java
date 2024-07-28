package net.one97.paytm.contacts.b;

import java.util.LinkedHashSet;
import java.util.List;
import net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails;
import net.one97.paytm.contacts.entities.db_entities.Configuration;
import net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails;
import net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo;
import net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails;
import net.one97.paytm.contacts.utils.a;

public interface a {
    void a();

    void a(String str);

    void a(String str, int i2);

    void a(String str, String str2, String str3);

    void a(LinkedHashSet<a.c> linkedHashSet);

    void a(LinkedHashSet<a.e> linkedHashSet, Configuration configuration);

    void a(List<PayeeMetaInfo> list);

    void a(Configuration configuration);

    void a(PayeeInfoDetails payeeInfoDetails);

    void a(a.b bVar);

    void a(a.c cVar);

    void a(a.d dVar);

    void a(a.f fVar);

    void b();

    void b(String str);

    void b(String str, int i2);

    void b(LinkedHashSet<a.g> linkedHashSet, Configuration configuration);

    void b(List<PaymentInstrumentDetails> list);

    void b(PayeeInfoDetails payeeInfoDetails);

    void b(a.f fVar);

    void c();

    void c(String str);

    void c(List<BeneficiaryMetaDetails> list);

    void d();

    void d(String str);

    void e();

    void e(String str);

    void f();

    void g();

    void h();
}
