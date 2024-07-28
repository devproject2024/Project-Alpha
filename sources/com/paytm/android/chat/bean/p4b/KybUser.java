package com.paytm.android.chat.bean.p4b;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.g.b.k;

public final class KybUser implements Serializable {
    private String id;
    private String name;
    private String[] permissions;

    public static /* synthetic */ KybUser copy$default(KybUser kybUser, String str, String str2, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kybUser.id;
        }
        if ((i2 & 2) != 0) {
            str2 = kybUser.name;
        }
        if ((i2 & 4) != 0) {
            strArr = kybUser.permissions;
        }
        return kybUser.copy(str, str2, strArr);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String[] component3() {
        return this.permissions;
    }

    public final KybUser copy(String str, String str2, String[] strArr) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(strArr, "permissions");
        return new KybUser(str, str2, strArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KybUser)) {
            return false;
        }
        KybUser kybUser = (KybUser) obj;
        return k.a((Object) this.id, (Object) kybUser.id) && k.a((Object) this.name, (Object) kybUser.name) && k.a((Object) this.permissions, (Object) kybUser.permissions);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String[] strArr = this.permissions;
        if (strArr != null) {
            i2 = Arrays.hashCode(strArr);
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "KybUser(id=" + this.id + ", name=" + this.name + ", permissions=" + Arrays.toString(this.permissions) + ")";
    }

    public KybUser(String str, String str2, String[] strArr) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(strArr, "permissions");
        this.id = str;
        this.name = str2;
        this.permissions = strArr;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String[] getPermissions() {
        return this.permissions;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final void setPermissions(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.permissions = strArr;
    }
}
