package net.one97.paytm.common.entity.wallet;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Contacts implements IJRDataModel {
    private List<ContactInfo> contacts;
    private boolean isContactSyncWithServer;

    public static /* synthetic */ Contacts copy$default(Contacts contacts2, boolean z, List<ContactInfo> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = contacts2.isContactSyncWithServer;
        }
        if ((i2 & 2) != 0) {
            list = contacts2.contacts;
        }
        return contacts2.copy(z, list);
    }

    public final boolean component1() {
        return this.isContactSyncWithServer;
    }

    public final List<ContactInfo> component2() {
        return this.contacts;
    }

    public final Contacts copy(boolean z, List<ContactInfo> list) {
        return new Contacts(z, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Contacts) {
                Contacts contacts2 = (Contacts) obj;
                if (!(this.isContactSyncWithServer == contacts2.isContactSyncWithServer) || !k.a((Object) this.contacts, (Object) contacts2.contacts)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isContactSyncWithServer;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        List<ContactInfo> list = this.contacts;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "Contacts(isContactSyncWithServer=" + this.isContactSyncWithServer + ", contacts=" + this.contacts + ")";
    }

    public Contacts(boolean z, List<ContactInfo> list) {
        this.isContactSyncWithServer = z;
        this.contacts = list;
    }

    public final List<ContactInfo> getContacts() {
        return this.contacts;
    }

    public final boolean isContactSyncWithServer() {
        return this.isContactSyncWithServer;
    }

    public final void setContactSyncWithServer(boolean z) {
        this.isContactSyncWithServer = z;
    }

    public final void setContacts(List<ContactInfo> list) {
        this.contacts = list;
    }
}
