package com.paytm.contactsSdk.utils;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;
import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.models.Contact;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.paytm.contactsSdk.utils.ContactPrefUtils;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.z;
import kotlin.g.b.k;
import kotlin.m.p;

public final class ContactUtil {
    public static final ContactUtil INSTANCE = new ContactUtil();

    private ContactUtil() {
    }

    public final ArrayList<Contact> getContactsFromContactPhoneWithSync$contacts_sdk_release(List<ContactWithPhones> list, LocalContactSyncType localContactSyncType) {
        k.c(list, "contactWithPhones");
        k.c(localContactSyncType, "syncType");
        ArrayList<Contact> arrayList = new ArrayList<>();
        for (z zVar : kotlin.a.k.g(list)) {
            arrayList.add(new Contact(((ContactWithPhones) zVar.f47894b).getContact().getId(), ((ContactWithPhones) zVar.f47894b).getContact().getName(), localContactSyncType.ordinal()));
        }
        return arrayList;
    }

    public final void saveLastLocalContactSyncedTime$contacts_sdk_release(Context context, long j) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        companion.getPref(applicationContext).a(ContactsConstant.LAST_LOCAL_CONTACT_SYNCED_TIME, j, false);
    }

    public final long getLastLocalContactSyncedTime$contacts_sdk_release(Context context) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return companion.getPref(applicationContext).b(ContactsConstant.LAST_LOCAL_CONTACT_SYNCED_TIME, 0, false);
    }

    public final void resetLastLocalContactSyncedTime$contacts_sdk_release(Context context) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        companion.getPref(applicationContext).a(ContactsConstant.LAST_LOCAL_CONTACT_SYNCED_TIME, 0, false);
    }

    public final void resetLastEnrichmentDataSyncedTimeStamp$contacts_sdk_release(Context context) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        companion.getPref(applicationContext).a(ContactsConstant.SEARCH_CONTACT_LAST_TIME_STAMP, 0, false);
    }

    public final void saveHealthApiTimestamp$contacts_sdk_release(Context context, long j) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        companion.getPref(applicationContext).a(ContactsConstant.HEALTH_API_LAST_TIME_STAMP, j, false);
    }

    public final long getLastHealthApiTimestamp$contacts_sdk_release(Context context) {
        k.c(context, "context");
        ContactPrefUtils.Companion companion = ContactPrefUtils.Companion;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return companion.getPref(applicationContext).b(ContactsConstant.HEALTH_API_LAST_TIME_STAMP, 0, false);
    }

    public final void resetLastHealthApiTimestamp$contacts_sdk_release(Context context) {
        k.c(context, "context");
        saveHealthApiTimestamp$contacts_sdk_release(context, 0);
    }

    public final void resetAllTimestamps$contacts_sdk_release(Context context) {
        k.c(context, "context");
        resetLastLocalContactSyncedTime$contacts_sdk_release(context);
        resetLastEnrichmentDataSyncedTimeStamp$contacts_sdk_release(context);
        resetLastHealthApiTimestamp$contacts_sdk_release(context);
    }

    public final void sendMetaInfo$contacts_sdk_release(SyncStage syncStage, double d2, int i2) {
        k.c(syncStage, "syncStage");
        ContactsProvider.INSTANCE.setMetadata$contacts_sdk_release(new ContactsSDKMetaInfo(ContactsConsent.INSTANCE.checkLocalConsent(), syncStage, d2, i2));
    }

    public final void sendSyncStoppedMetaInfo$contacts_sdk_release() {
        ContactsProvider.INSTANCE.setMetadata$contacts_sdk_release(new ContactsSDKMetaInfo(ContactsConsent.INSTANCE.checkLocalConsent(), SyncStage.NONE, 0.0d, 0));
    }

    public static /* synthetic */ ListenableWorker.a getSyncWorkerErrorResult$contacts_sdk_release$default(ContactUtil contactUtil, Worker worker, Integer num, NetworkCustomError networkCustomError, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            networkCustomError = null;
        }
        return contactUtil.getSyncWorkerErrorResult$contacts_sdk_release(worker, num, networkCustomError);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r6.networkResponse;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.work.ListenableWorker.a getSyncWorkerErrorResult$contacts_sdk_release(androidx.work.Worker r4, java.lang.Integer r5, com.paytm.network.model.NetworkCustomError r6) {
        /*
            r3 = this;
            java.lang.String r0 = "worker"
            kotlin.g.b.k.c(r4, r0)
            if (r6 == 0) goto L_0x0013
            com.paytm.network.model.NetworkResponse r0 = r6.networkResponse
            if (r0 == 0) goto L_0x0013
            int r0 = r0.statusCode
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0014
        L_0x0013:
            r0 = r5
        L_0x0014:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "statusCode : "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " response statusCode : "
            r1.append(r5)
            if (r6 == 0) goto L_0x0031
            com.paytm.network.model.NetworkResponse r5 = r6.networkResponse
            if (r5 == 0) goto L_0x0031
            int r5 = r5.statusCode
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            r1.append(r5)
            java.lang.String r5 = " FinalErrorCode : "
            r1.append(r5)
            r1.append(r0)
            androidx.work.ListenableWorker$a$a r5 = new androidx.work.ListenableWorker$a$a
            r5.<init>()
            java.lang.String r6 = "ListenableWorker.Result.failure()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r0 != 0) goto L_0x004a
            goto L_0x0052
        L_0x004a:
            int r1 = r0.intValue()
            r2 = 401(0x191, float:5.62E-43)
            if (r1 == r2) goto L_0x0079
        L_0x0052:
            if (r0 != 0) goto L_0x0055
            goto L_0x005e
        L_0x0055:
            int r0 = r0.intValue()
            r1 = 403(0x193, float:5.65E-43)
            if (r0 != r1) goto L_0x005e
            goto L_0x0079
        L_0x005e:
            int r6 = r4.getRunAttemptCount()
            com.paytm.contactsSdk.ContactsSdk r0 = com.paytm.contactsSdk.ContactsSdk.INSTANCE
            com.paytm.contactsSdk.ContactsSDKApplicationInterface r0 = r0.getContactsSDKApplicationInterface$contacts_sdk_release()
            int r0 = r0.workManagerRetryCount()
            if (r6 >= r0) goto L_0x0081
            androidx.work.ListenableWorker$a$b r5 = new androidx.work.ListenableWorker$a$b
            r5.<init>()
            java.lang.String r6 = "ListenableWorker.Result.retry()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            goto L_0x0081
        L_0x0079:
            androidx.work.ListenableWorker$a$a r5 = new androidx.work.ListenableWorker$a$a
            r5.<init>()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
        L_0x0081:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "retryAttemptCount : "
            r6.<init>(r0)
            int r4 = r4.getRunAttemptCount()
            r6.append(r4)
            java.lang.String r4 = " Result: "
            r6.append(r4)
            r6.append(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.utils.ContactUtil.getSyncWorkerErrorResult$contacts_sdk_release(androidx.work.Worker, java.lang.Integer, com.paytm.network.model.NetworkCustomError):androidx.work.ListenableWorker$a");
    }

    public final String getNormalizedPhoneNumber$contacts_sdk_release(String str) {
        k.c(str, ContactColumn.PHONE_NUMBER);
        return p.a(str, " ", "", false);
    }
}
