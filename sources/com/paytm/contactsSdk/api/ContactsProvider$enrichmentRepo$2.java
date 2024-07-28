package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.repo.EnrichmentRepo;
import kotlin.g.a.a;
import kotlin.g.b.l;

final class ContactsProvider$enrichmentRepo$2 extends l implements a<EnrichmentRepo> {
    public static final ContactsProvider$enrichmentRepo$2 INSTANCE = new ContactsProvider$enrichmentRepo$2();

    ContactsProvider$enrichmentRepo$2() {
        super(0);
    }

    public final EnrichmentRepo invoke() {
        return new EnrichmentRepo();
    }
}
