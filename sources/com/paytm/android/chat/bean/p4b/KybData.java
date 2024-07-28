package com.paytm.android.chat.bean.p4b;

import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;

public final class KybData implements Serializable {
    private List<KybChannel> channels;
    private String id;
    private String name;

    public static /* synthetic */ KybData copy$default(KybData kybData, String str, String str2, List<KybChannel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kybData.id;
        }
        if ((i2 & 2) != 0) {
            str2 = kybData.name;
        }
        if ((i2 & 4) != 0) {
            list = kybData.channels;
        }
        return kybData.copy(str, str2, list);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final List<KybChannel> component3() {
        return this.channels;
    }

    public final KybData copy(String str, String str2, List<KybChannel> list) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(list, "channels");
        return new KybData(str, str2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KybData)) {
            return false;
        }
        KybData kybData = (KybData) obj;
        return k.a((Object) this.id, (Object) kybData.id) && k.a((Object) this.name, (Object) kybData.name) && k.a((Object) this.channels, (Object) kybData.channels);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<KybChannel> list = this.channels;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "KybData(id=" + this.id + ", name=" + this.name + ", channels=" + this.channels + ")";
    }

    public KybData(String str, String str2, List<KybChannel> list) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(list, "channels");
        this.id = str;
        this.name = str2;
        this.channels = list;
    }

    public final List<KybChannel> getChannels() {
        return this.channels;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setChannels(List<KybChannel> list) {
        k.c(list, "<set-?>");
        this.channels = list;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }
}
