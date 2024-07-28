package com.paytm.contactsSdk.api.viewModel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;
import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;
import com.paytm.contactsSdk.api.model.ContactsSDKState;
import java.util.Map;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class ContactSyncViewModel extends ai implements ContactsSDKMetaInfoCallback {
    private final y<Map<String, Boolean>> consentUpdateLiveData = new y<>();
    private final y<Boolean> contactsSDKLocalSyncEnabled = new y<>();
    private final y<ContactsSDKState> contactsSDKReadyLiveData = new y<>();
    private final y<Boolean> contactsSDKRemoteSyncEnabled = new y<>();
    private final y<Boolean> localConsent = new y<>();

    public final y<Boolean> getContactsSDKLocalSyncEnabled() {
        return this.contactsSDKLocalSyncEnabled;
    }

    public final y<Boolean> getContactsSDKRemoteSyncEnabled() {
        return this.contactsSDKRemoteSyncEnabled;
    }

    public final y<ContactsSDKState> getContactsSDKReadyLiveData() {
        return this.contactsSDKReadyLiveData;
    }

    public final y<Map<String, Boolean>> getConsentUpdateLiveData() {
        return this.consentUpdateLiveData;
    }

    public final y<Boolean> getLocalConsent() {
        return this.localConsent;
    }

    public final void startSync() {
        ContactsProvider.INSTANCE.forceSync(this);
    }

    public final void checkIfContactsSDKRemoteSyncEnabled() {
        this.contactsSDKRemoteSyncEnabled.postValue(Boolean.valueOf(ContactsSdk.INSTANCE.isContactsSDKRemoteSyncEnabled$contacts_sdk_release()));
    }

    public final void checkIfContactsSDKLocalSyncEnabled() {
        this.contactsSDKLocalSyncEnabled.postValue(Boolean.valueOf(ContactsSdk.INSTANCE.isContactsSDKLocalSyncEnabled$contacts_sdk_release()));
    }

    public final void updateConsent() {
        ContactsProvider.INSTANCE.updateConsent(true, new ContactSyncViewModel$updateConsent$1(this));
    }

    public final void isConsentAvailable() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new ContactSyncViewModel$isConsentAvailable$1(this, (d) null), 2, (Object) null);
    }

    public final void onMetaInfoAvailable(ContactsSDKMetaInfo contactsSDKMetaInfo) {
        k.c(contactsSDKMetaInfo, "contactsSDKMetaInfo");
        getClass().getName();
    }
}
