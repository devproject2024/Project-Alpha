package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.ContactsSDKApplicationInterface;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.helper.ContactsConsentHelper;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Map;
import kotlin.d.d;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.repository.UpsConsentRepository;

public final class ContactsConsent implements ContactsConsentHelper {
    public static final ContactsConsent INSTANCE = new ContactsConsent();
    /* access modifiers changed from: private */
    public static boolean isMigrationInProgress;

    private ContactsConsent() {
    }

    public final void getConsentFromServer(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        k.c(qVar, "onConsentResultAvailable");
        k.c(contactsQueryCallback, "contactsQueryCallback");
        k.c(contactsQuery, "contactsQuery");
        ContactsProvider.INSTANCE.getConsent$contacts_sdk_release(new ContactsConsent$getConsentFromServer$1(qVar, contactsQueryCallback, contactsQuery));
    }

    public final void getConsentFromLocalDB(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        k.c(qVar, "onConsentResultAvailable");
        k.c(contactsQueryCallback, "contactsQueryCallback");
        k.c(contactsQuery, "contactsQuery");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new ContactsConsent$getConsentFromLocalDB$1(qVar, contactsQueryCallback, contactsQuery, (d) null), 2, (Object) null);
    }

    public final void getConsentFromLocalDBThenServer(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        k.c(qVar, "onConsentResultAvailable");
        k.c(contactsQueryCallback, "contactsQueryCallback");
        k.c(contactsQuery, "contactsQuery");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new ContactsConsent$getConsentFromLocalDBThenServer$1(qVar, contactsQueryCallback, contactsQuery, (d) null), 2, (Object) null);
    }

    public final boolean checkLocalConsent() {
        Map<String, Boolean> checkConsentsAvailable = UpsConsentRepository.INSTANCE.checkConsentsAvailable(ContactsConstant.INSTANCE.getGET_CONTACT_CONSENT_KEY_LIST());
        if (!checkConsentsAvailable.containsKey(ContactsConstant.CONTACTS_CONSENT_KEY) && ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().isConsentStatusAvailableInSmsSdk()) {
            return performConsentMigration();
        }
        if (!(!checkConsentsAvailable.isEmpty())) {
            return false;
        }
        Boolean bool = checkConsentsAvailable.get(ContactsConstant.CONTACTS_CONSENT_KEY);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalStateException("".toString());
    }

    private final boolean performConsentMigration() {
        com.paytm.utility.q.d("Performing Migration " + System.currentTimeMillis());
        ContactsSDKApplicationInterface contactsSDKApplicationInterface$contacts_sdk_release = ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release();
        boolean consentStatusFromSmsSdk = contactsSDKApplicationInterface$contacts_sdk_release.getConsentStatusFromSmsSdk();
        com.paytm.utility.q.d("Read from SMS SDK " + System.currentTimeMillis());
        if (!isMigrationInProgress) {
            isMigrationInProgress = true;
            com.paytm.utility.q.d("Stared UpdateConsent in UPS " + System.currentTimeMillis());
            ContactsProvider.INSTANCE.updateConsent(consentStatusFromSmsSdk, new ContactsConsent$performConsentMigration$1(contactsSDKApplicationInterface$contacts_sdk_release));
        }
        return consentStatusFromSmsSdk;
    }
}
