package com.paytm.contactsSdk.api.model;

import com.paytm.contactsSdk.api.p002enum.SyncStage;
import kotlin.g.b.k;

public final class ContactsSDKMetaInfo {
    private final int pendingSyncContactCount;
    private final double syncProgressInPercent;
    private final SyncStage syncStage;
    private final boolean userConsentStatus;

    public static /* synthetic */ ContactsSDKMetaInfo copy$default(ContactsSDKMetaInfo contactsSDKMetaInfo, boolean z, SyncStage syncStage2, double d2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = contactsSDKMetaInfo.userConsentStatus;
        }
        if ((i3 & 2) != 0) {
            syncStage2 = contactsSDKMetaInfo.syncStage;
        }
        SyncStage syncStage3 = syncStage2;
        if ((i3 & 4) != 0) {
            d2 = contactsSDKMetaInfo.syncProgressInPercent;
        }
        double d3 = d2;
        if ((i3 & 8) != 0) {
            i2 = contactsSDKMetaInfo.pendingSyncContactCount;
        }
        return contactsSDKMetaInfo.copy(z, syncStage3, d3, i2);
    }

    public final boolean component1() {
        return this.userConsentStatus;
    }

    public final SyncStage component2() {
        return this.syncStage;
    }

    public final double component3() {
        return this.syncProgressInPercent;
    }

    public final int component4() {
        return this.pendingSyncContactCount;
    }

    public final ContactsSDKMetaInfo copy(boolean z, SyncStage syncStage2, double d2, int i2) {
        k.c(syncStage2, "syncStage");
        return new ContactsSDKMetaInfo(z, syncStage2, d2, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactsSDKMetaInfo)) {
            return false;
        }
        ContactsSDKMetaInfo contactsSDKMetaInfo = (ContactsSDKMetaInfo) obj;
        return this.userConsentStatus == contactsSDKMetaInfo.userConsentStatus && k.a((Object) this.syncStage, (Object) contactsSDKMetaInfo.syncStage) && Double.compare(this.syncProgressInPercent, contactsSDKMetaInfo.syncProgressInPercent) == 0 && this.pendingSyncContactCount == contactsSDKMetaInfo.pendingSyncContactCount;
    }

    public final int hashCode() {
        boolean z = this.userConsentStatus;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        SyncStage syncStage2 = this.syncStage;
        return ((((i2 + (syncStage2 != null ? syncStage2.hashCode() : 0)) * 31) + Double.valueOf(this.syncProgressInPercent).hashCode()) * 31) + Integer.valueOf(this.pendingSyncContactCount).hashCode();
    }

    public ContactsSDKMetaInfo(boolean z, SyncStage syncStage2, double d2, int i2) {
        k.c(syncStage2, "syncStage");
        this.userConsentStatus = z;
        this.syncStage = syncStage2;
        this.syncProgressInPercent = d2;
        this.pendingSyncContactCount = i2;
    }

    public final boolean getUserConsentStatus() {
        return this.userConsentStatus;
    }

    public final SyncStage getSyncStage() {
        return this.syncStage;
    }

    public final double getSyncProgressInPercent() {
        return this.syncProgressInPercent;
    }

    public final int getPendingSyncContactCount() {
        return this.pendingSyncContactCount;
    }

    public final String toString() {
        return "Consent Status - " + this.userConsentStatus + " and Sync Stage = " + this.syncStage + " and Sync Percentage = " + this.syncProgressInPercent + " and Contacts Count = " + this.pendingSyncContactCount;
    }
}
