package com.paytm.contactsSdk.api;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import androidx.work.e;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.gson.f;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;
import com.paytm.contactsSdk.api.callback.EnrichedContactsCallback;
import com.paytm.contactsSdk.api.callback.EnrichedPhoneNumbersCallback;
import com.paytm.contactsSdk.api.helper.ContactsProviderHelper;
import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;
import com.paytm.contactsSdk.api.p002enum.ContactsConsentStrategy;
import com.paytm.contactsSdk.api.p002enum.ContactsErrorType;
import com.paytm.contactsSdk.api.p002enum.FetchContactType;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import com.paytm.contactsSdk.api.query.EnrichmentQuery;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.manager.LocalSyncManager;
import com.paytm.contactsSdk.models.MappingInfo;
import com.paytm.contactsSdk.repo.ContactsRepo;
import com.paytm.contactsSdk.repo.EnrichmentRepo;
import com.paytm.contactsSdk.workManager.ServerSyncManager;
import com.paytm.utility.c.a.b;
import com.paytm.utility.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.h;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.listener.GetConsentListener;
import net.one97.paytm.ups.listener.UpdateConsentListener;
import net.one97.paytm.ups.repository.UpsConsentRepository;

public final class ContactsProvider implements ContactsProviderHelper {
    public static final ContactsProvider INSTANCE;
    /* access modifiers changed from: private */
    public static ContactsSDKMetaInfo contactSDKMetaInfo;
    private static final g contactsRepo$delegate = h.a(ContactsProvider$contactsRepo$2.INSTANCE);
    private static final g dynamicMapping$delegate = h.a(ContactsProvider$dynamicMapping$2.INSTANCE);
    private static final g enrichmentRepo$delegate = h.a(ContactsProvider$enrichmentRepo$2.INSTANCE);
    private static final g gson$delegate = h.a(ContactsProvider$gson$2.INSTANCE);
    /* access modifiers changed from: private */
    public static WeakReference<ContactsSDKMetaInfoCallback> syncCallback;
    private static int totalContactsToSync;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ContactsConsentStrategy.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ContactsConsentStrategy.ALWAYS_REQUEST_FROM_SERVER.ordinal()] = 1;
            $EnumSwitchMapping$0[ContactsConsentStrategy.USE_LOCAL_CACHED.ordinal()] = 2;
            $EnumSwitchMapping$0[ContactsConsentStrategy.REQUEST_SERVER_IF_NOT_AVAILABLE_LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0[ContactsConsentStrategy.NO_CONSENT_CHECK.ordinal()] = 4;
            int[] iArr2 = new int[FetchContactType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[FetchContactType.ALL.ordinal()] = 1;
            $EnumSwitchMapping$1[FetchContactType.SEARCH_BY_NAME.ordinal()] = 2;
            $EnumSwitchMapping$1[FetchContactType.CONTACTS_FROM_PAGE_NUMBER.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final ContactsRepo getContactsRepo() {
        return (ContactsRepo) contactsRepo$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final HashMap<String, MappingInfo> getDynamicMapping() {
        return (HashMap) dynamicMapping$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EnrichmentRepo getEnrichmentRepo() {
        return (EnrichmentRepo) enrichmentRepo$delegate.getValue();
    }

    private final f getGson() {
        return (f) gson$delegate.getValue();
    }

    static {
        ContactsProvider contactsProvider = new ContactsProvider();
        INSTANCE = contactsProvider;
        contactsProvider.initializeDynamicMapping();
    }

    private ContactsProvider() {
    }

    public final int getTotalContactsToSync$contacts_sdk_release() {
        return totalContactsToSync;
    }

    public final void setTotalContactsToSync$contacts_sdk_release(int i2) {
        totalContactsToSync = i2;
    }

    private final void initializeDynamicMapping() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new ContactsProvider$initializeDynamicMapping$1((d) null), 2, (Object) null);
    }

    public final EnrichmentRepo getEnrichmentRepo$contacts_sdk_release() {
        return getEnrichmentRepo();
    }

    public final HashMap<String, MappingInfo> getDynamicMapping$contacts_sdk_release() {
        return getDynamicMapping();
    }

    public final void syncContacts$contacts_sdk_release() {
        if (!ContactsSdk.INSTANCE.updateSyncInProgress$contacts_sdk_release()) {
            getClass().getName();
            return;
        }
        b bVar = b.f43777a;
        if (b.a((Context) ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getApplicationContext(), new String[]{"android.permission.READ_CONTACTS"})) {
            ContactsSdk.INSTANCE.registerContactObserver$contacts_sdk_release();
            LocalSyncManager.INSTANCE.localDbSync();
            if (totalContactsToSync == 0) {
                totalContactsToSync = 1;
            }
            ServerSyncManager.INSTANCE.syncContactsAsync(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getApplicationContext());
        }
        ContactsSdk.INSTANCE.resetSyncInProgress$contacts_sdk_release();
    }

    public final void forceSync(ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback) {
        if (contactsSDKMetaInfoCallback != null) {
            syncCallback = new WeakReference<>(contactsSDKMetaInfoCallback);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new ContactsProvider$forceSync$1((d) null), 2, (Object) null);
    }

    public final void postProgressUpdateFromLooperThread$contacts_sdk_release(e eVar) {
        ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback;
        String a2;
        k.c(eVar, "progressData");
        WeakReference<ContactsSDKMetaInfoCallback> weakReference = syncCallback;
        if (weakReference != null && (contactsSDKMetaInfoCallback = (ContactsSDKMetaInfoCallback) weakReference.get()) != null && (a2 = eVar.a("meta")) != null) {
            Object a3 = INSTANCE.getGson().a(a2, ContactsSDKMetaInfo.class);
            k.a(a3, "gson.fromJson(metaValue,…sSDKMetaInfo::class.java)");
            contactsSDKMetaInfoCallback.onMetaInfoAvailable((ContactsSDKMetaInfo) a3);
        }
    }

    public final void setMetadata$contacts_sdk_release(ContactsSDKMetaInfo contactsSDKMetaInfo) {
        k.c(contactsSDKMetaInfo, "info");
        getClass().getName();
        q.d("setMetadata : ".concat(String.valueOf(contactsSDKMetaInfo)));
        contactSDKMetaInfo = contactsSDKMetaInfo;
        publishMetaInfo(contactsSDKMetaInfo);
    }

    private final void publishMetaInfo(ContactsSDKMetaInfo contactsSDKMetaInfo) {
        ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback;
        WeakReference<ContactsSDKMetaInfoCallback> weakReference = syncCallback;
        if (weakReference != null && (contactsSDKMetaInfoCallback = (ContactsSDKMetaInfoCallback) weakReference.get()) != null) {
            String.valueOf(contactsSDKMetaInfo);
            new Handler(Looper.getMainLooper()).post(new ContactsProvider$publishMetaInfo$$inlined$let$lambda$1(contactsSDKMetaInfoCallback, contactsSDKMetaInfo));
        }
    }

    public final void registerContactSyncMetaInfoCallback(ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback) {
        k.c(contactsSDKMetaInfoCallback, "metaInfoCallback");
        syncCallback = new WeakReference<>(contactsSDKMetaInfoCallback);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new ContactsProvider$registerContactSyncMetaInfoCallback$1((d) null), 2, (Object) null);
    }

    public final void fetchContacts(ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        k.c(contactsQueryCallback, "contactCallbackInterface");
        k.c(contactsQuery, "contactsQuery");
        if (!ContactsSdk.INSTANCE.isLoggedIn()) {
            contactsQueryCallback.onContactsAvailable((Cursor) null, ContactsErrorType.NOT_LOGGED_IN);
            return;
        }
        b bVar = b.f43777a;
        if (!b.a((Context) ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getApplicationContext(), new String[]{"android.permission.READ_CONTACTS"})) {
            contactsQueryCallback.onContactsAvailable((Cursor) null, ContactsErrorType.CONTACT_PERMISSION_NOT_GRANTED);
        } else {
            fetchContactsInternal(contactsQuery, contactsQueryCallback);
        }
    }

    public final void onLogout$contacts_sdk_release(Context context) {
        k.c(context, "context");
        clearDynamicMappingHashMap$contacts_sdk_release();
        ServerSyncManager.INSTANCE.stopAllWorkManagers(context);
    }

    public final void clearDynamicMappingHashMap$contacts_sdk_release() {
        getDynamicMapping().clear();
    }

    public final void updateConsent(boolean z, UpdateConsentListener updateConsentListener) {
        k.c(updateConsentListener, "listener");
        UpsConsentRepository.INSTANCE.updateConsent(ContactsConstant.CONTACTS_CONSENT_KEY, z, updateConsentListener);
    }

    public final void getConsent$contacts_sdk_release(GetConsentListener getConsentListener) {
        k.c(getConsentListener, "listener");
        UpsConsentRepository.INSTANCE.getConsent(ContactsConstant.INSTANCE.getGET_CONTACT_CONSENT_KEY_LIST(), getConsentListener);
    }

    private final void fetchContactsInternal(ContactsQuery contactsQuery, ContactsQueryCallback contactsQueryCallback) {
        if (ContactsSdk.INSTANCE.initDone()) {
            INSTANCE.checkConsent(contactsQuery, contactsQueryCallback);
            return;
        }
        INSTANCE.getClass().getName();
        INSTANCE.sendCallback((Cursor) null, true, ContactsErrorType.SDK_INIT_NOT_CALLED, contactsQueryCallback);
    }

    private final void checkConsent(ContactsQuery contactsQuery, ContactsQueryCallback contactsQueryCallback) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[contactsQuery.getContactsConsentStrategy().ordinal()];
        if (i2 == 1) {
            ContactsConsent.INSTANCE.getConsentFromServer(new ContactsProvider$checkConsent$1(this), contactsQueryCallback, contactsQuery);
        } else if (i2 == 2) {
            ContactsConsent.INSTANCE.getConsentFromLocalDB(new ContactsProvider$checkConsent$2(this), contactsQueryCallback, contactsQuery);
        } else if (i2 == 3) {
            ContactsConsent.INSTANCE.getConsentFromLocalDBThenServer(new ContactsProvider$checkConsent$3(this), contactsQueryCallback, contactsQuery);
        } else if (i2 == 4) {
            handleContactsQuery(contactsQueryCallback, contactsQuery);
        }
    }

    private final void startReadingContactAndPublishing(ContactsQueryCallback contactsQueryCallback) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$startReadingContactAndPublishing$1(contactsQueryCallback, (d) null), 3, (Object) null);
    }

    private final void startReadingContactsByNameAndPublish(ContactsQueryCallback contactsQueryCallback, String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$startReadingContactsByNameAndPublish$1(str, contactsQueryCallback, (d) null), 3, (Object) null);
        }
    }

    private final void startReadingContactsByPagination(ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$startReadingContactsByPagination$1(contactsQuery, contactsQueryCallback, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onConsentResultAvailable(boolean z, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        if (z) {
            handleContactsQuery(contactsQueryCallback, contactsQuery);
            return;
        }
        getClass().getName();
        contactsQueryCallback.onContactsAvailable((Cursor) null, ContactsErrorType.CONTACT_CONSENT_NOT_ACCEPTED);
    }

    private final void handleContactsQuery(ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[contactsQuery.getQueryType().ordinal()];
        boolean z = true;
        if (i2 == 1) {
            startReadingContactAndPublishing(contactsQueryCallback);
        } else if (i2 == 2) {
            if (contactsQuery.getSearchName().length() <= 0) {
                z = false;
            }
            if (z) {
                startReadingContactsByNameAndPublish(contactsQueryCallback, contactsQuery.getSearchName());
            } else {
                startReadingContactAndPublishing(contactsQueryCallback);
            }
        } else if (i2 == 3) {
            startReadingContactsByPagination(contactsQueryCallback, contactsQuery);
        }
    }

    /* access modifiers changed from: private */
    public final void sendCallback(Cursor cursor, boolean z, ContactsErrorType contactsErrorType, ContactsQueryCallback contactsQueryCallback) {
        if (!z) {
            contactsQueryCallback.onContactsAvailable(cursor, ContactsErrorType.NO_ERROR);
        } else {
            contactsQueryCallback.onContactsAvailable((Cursor) null, contactsErrorType);
        }
    }

    public final void getEnrichedPhoneNumbers(EnrichedPhoneNumbersCallback enrichedPhoneNumbersCallback, EnrichmentQuery enrichmentQuery) {
        k.c(enrichedPhoneNumbersCallback, H5Event.TYPE_CALL_BACK);
        k.c(enrichmentQuery, "enrichmentQuery");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$getEnrichedPhoneNumbers$1(enrichmentQuery, enrichedPhoneNumbersCallback, (d) null), 3, (Object) null);
    }

    public final void getEnrichedContacts(EnrichedContactsCallback enrichedContactsCallback, EnrichmentQuery enrichmentQuery) {
        k.c(enrichedContactsCallback, H5Event.TYPE_CALL_BACK);
        k.c(enrichmentQuery, "enrichmentQuery");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$getEnrichedContacts$1(enrichmentQuery, enrichedContactsCallback, (d) null), 3, (Object) null);
    }

    public final void getEnrichedContactsPaginated(EnrichedContactsCallback enrichedContactsCallback, EnrichmentQuery enrichmentQuery) {
        k.c(enrichedContactsCallback, H5Event.TYPE_CALL_BACK);
        k.c(enrichmentQuery, "enrichmentQuery");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new ContactsProvider$getEnrichedContactsPaginated$1(enrichmentQuery, enrichedContactsCallback, (d) null), 3, (Object) null);
    }
}
