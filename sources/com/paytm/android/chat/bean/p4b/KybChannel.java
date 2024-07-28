package com.paytm.android.chat.bean.p4b;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class KybChannel implements Serializable {
    private String id;
    private boolean isChannelEnabled;
    private ArrayList<KybUser> listOfKybUser;
    private String name;

    public static /* synthetic */ KybChannel copy$default(KybChannel kybChannel, String str, String str2, boolean z, ArrayList<KybUser> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kybChannel.id;
        }
        if ((i2 & 2) != 0) {
            str2 = kybChannel.name;
        }
        if ((i2 & 4) != 0) {
            z = kybChannel.isChannelEnabled;
        }
        if ((i2 & 8) != 0) {
            arrayList = kybChannel.listOfKybUser;
        }
        return kybChannel.copy(str, str2, z, arrayList);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isChannelEnabled;
    }

    public final ArrayList<KybUser> component4() {
        return this.listOfKybUser;
    }

    public final KybChannel copy(String str, String str2, boolean z, ArrayList<KybUser> arrayList) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(arrayList, "listOfKybUser");
        return new KybChannel(str, str2, z, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KybChannel)) {
            return false;
        }
        KybChannel kybChannel = (KybChannel) obj;
        return k.a((Object) this.id, (Object) kybChannel.id) && k.a((Object) this.name, (Object) kybChannel.name) && this.isChannelEnabled == kybChannel.isChannelEnabled && k.a((Object) this.listOfKybUser, (Object) kybChannel.listOfKybUser);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isChannelEnabled;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        ArrayList<KybUser> arrayList = this.listOfKybUser;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "KybChannel(id=" + this.id + ", name=" + this.name + ", isChannelEnabled=" + this.isChannelEnabled + ", listOfKybUser=" + this.listOfKybUser + ")";
    }

    public KybChannel(String str, String str2, boolean z, ArrayList<KybUser> arrayList) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(arrayList, "listOfKybUser");
        this.id = str;
        this.name = str2;
        this.isChannelEnabled = z;
        this.listOfKybUser = arrayList;
    }

    public final String getId() {
        return this.id;
    }

    public final ArrayList<KybUser> getListOfKybUser() {
        return this.listOfKybUser;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isChannelEnabled() {
        return this.isChannelEnabled;
    }

    public final void setChannelEnabled(boolean z) {
        this.isChannelEnabled = z;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final void setListOfKybUser(ArrayList<KybUser> arrayList) {
        k.c(arrayList, "<set-?>");
        this.listOfKybUser = arrayList;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }
}
