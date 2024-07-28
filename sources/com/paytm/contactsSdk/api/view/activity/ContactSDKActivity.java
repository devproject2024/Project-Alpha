package com.paytm.contactsSdk.api.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.core.app.a;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.q;
import com.paytm.contactsSdk.R;
import com.paytm.contactsSdk.api.model.ConsentUIMetaInfo;
import com.paytm.contactsSdk.api.model.ContactsSDKState;
import com.paytm.contactsSdk.api.p002enum.ContactsErrorType;
import com.paytm.contactsSdk.api.view.dialog.ConsentDialog;
import com.paytm.contactsSdk.api.viewModel.ContactSyncViewModel;
import com.paytm.utility.c.a.b;
import com.paytm.utility.s;
import java.util.HashMap;
import kotlin.a.f;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;

public class ContactSDKActivity extends PaytmActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public ConsentDialog consentDialog;
    /* access modifiers changed from: private */
    public final View.OnClickListener contactSDKAllowClickListener = new ContactSDKActivity$contactSDKAllowClickListener$1(this);
    /* access modifiers changed from: private */
    public final View.OnClickListener contactSDKSkipClickListener = new ContactSDKActivity$contactSDKSkipClickListener$1(this);
    protected ContactSyncViewModel syncContactsVM;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final ContactSyncViewModel getSyncContactsVM() {
        ContactSyncViewModel contactSyncViewModel = this.syncContactsVM;
        if (contactSyncViewModel == null) {
            k.a("syncContactsVM");
        }
        return contactSyncViewModel;
    }

    /* access modifiers changed from: protected */
    public final void setSyncContactsVM(ContactSyncViewModel contactSyncViewModel) {
        k.c(contactSyncViewModel, "<set-?>");
        this.syncContactsVM = contactSyncViewModel;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai a2 = new al(this).a(ContactSyncViewModel.class);
        k.a((Object) a2, "ViewModelProvider(this)[…yncViewModel::class.java]");
        this.syncContactsVM = (ContactSyncViewModel) a2;
        registerObserver();
        ContactSyncViewModel contactSyncViewModel = this.syncContactsVM;
        if (contactSyncViewModel == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel.checkIfContactsSDKLocalSyncEnabled();
    }

    private final void registerObserver() {
        ContactSyncViewModel contactSyncViewModel = this.syncContactsVM;
        if (contactSyncViewModel == null) {
            k.a("syncContactsVM");
        }
        q qVar = this;
        contactSyncViewModel.getContactsSDKLocalSyncEnabled().observe(qVar, new ContactSDKActivity$registerObserver$1(this));
        ContactSyncViewModel contactSyncViewModel2 = this.syncContactsVM;
        if (contactSyncViewModel2 == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel2.getContactsSDKRemoteSyncEnabled().observe(qVar, new ContactSDKActivity$registerObserver$2(this));
        ContactSyncViewModel contactSyncViewModel3 = this.syncContactsVM;
        if (contactSyncViewModel3 == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel3.getLocalConsent().observe(qVar, new ContactSDKActivity$registerObserver$3(this));
        ContactSyncViewModel contactSyncViewModel4 = this.syncContactsVM;
        if (contactSyncViewModel4 == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel4.getConsentUpdateLiveData().observe(qVar, new ContactSDKActivity$registerObserver$4(this));
    }

    /* access modifiers changed from: private */
    public final void permissionCheck() {
        b bVar = b.f43777a;
        if (!b.a((Context) this, new String[]{"android.permission.READ_CONTACTS"})) {
            a.a(this, new String[]{"android.permission.READ_CONTACTS"}, 200);
            return;
        }
        ContactSyncViewModel contactSyncViewModel = this.syncContactsVM;
        if (contactSyncViewModel == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel.startSync();
        ContactsSDKState contactsSDKState = new ContactsSDKState(true, ContactsErrorType.NO_ERROR);
        ContactSyncViewModel contactSyncViewModel2 = this.syncContactsVM;
        if (contactSyncViewModel2 == null) {
            k.a("syncContactsVM");
        }
        contactSyncViewModel2.getContactsSDKReadyLiveData().postValue(contactsSDKState);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 200 && f.a((T[]) strArr, "android.permission.READ_CONTACTS")) {
            ContactSyncViewModel contactSyncViewModel = this.syncContactsVM;
            if (contactSyncViewModel == null) {
                k.a("syncContactsVM");
            }
            contactSyncViewModel.startSync();
            ContactsSDKState contactsSDKState = new ContactsSDKState(true, ContactsErrorType.NO_ERROR);
            ContactSyncViewModel contactSyncViewModel2 = this.syncContactsVM;
            if (contactSyncViewModel2 == null) {
                k.a("syncContactsVM");
            }
            contactSyncViewModel2.getContactsSDKReadyLiveData().postValue(contactsSDKState);
        }
        if (s.a(strArr, iArr, "android.permission.READ_CONTACTS", this) == 0) {
            c.a aVar = new c.a(this);
            aVar.b(R.string.permission_contacts_sdk);
            aVar.a(true);
            aVar.a((CharSequence) "Open Settings", (DialogInterface.OnClickListener) new ContactSDKActivity$onRequestPermissionsResult$1(this));
            c a2 = aVar.a();
            k.a((Object) a2, "builder.create()");
            a2.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void showConsentUI(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        k.c(onClickListener, "allowClickListener");
        k.c(onClickListener2, "skipClickListener");
        ConsentDialog consentDialog2 = this.consentDialog;
        if (consentDialog2 != null) {
            consentDialog2.dismiss();
        }
        this.consentDialog = new ConsentDialog(this, onClickListener, onClickListener2, getConsentUIMetaInfo());
        ConsentDialog consentDialog3 = this.consentDialog;
        if (consentDialog3 == null) {
            k.a();
        }
        consentDialog3.show();
    }

    /* access modifiers changed from: protected */
    public final ConsentUIMetaInfo getConsentUIMetaInfo() {
        return new ConsentUIMetaInfo.Builder().build();
    }
}
