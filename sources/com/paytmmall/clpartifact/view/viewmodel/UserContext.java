package com.paytmmall.clpartifact.view.viewmodel;

import com.google.gson.a.c;
import com.paytmmall.clpartifact.modal.clpCommon.User;
import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UserContext implements Serializable {
    @c(a = "request_id")
    private final String mrequestid;
    @c(a = "user")
    private final User user;

    public static /* synthetic */ UserContext copy$default(UserContext userContext, User user2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            user2 = userContext.user;
        }
        if ((i2 & 2) != 0) {
            str = userContext.mrequestid;
        }
        return userContext.copy(user2, str);
    }

    public final User component1() {
        return this.user;
    }

    public final String component2() {
        return this.mrequestid;
    }

    public final UserContext copy(User user2, String str) {
        return new UserContext(user2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserContext)) {
            return false;
        }
        UserContext userContext = (UserContext) obj;
        return k.a((Object) this.user, (Object) userContext.user) && k.a((Object) this.mrequestid, (Object) userContext.mrequestid);
    }

    public final int hashCode() {
        User user2 = this.user;
        int i2 = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        String str = this.mrequestid;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UserContext(user=" + this.user + ", mrequestid=" + this.mrequestid + ")";
    }

    public UserContext(User user2, String str) {
        this.user = user2;
        this.mrequestid = str;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserContext(User user2, String str, int i2, g gVar) {
        this(user2, (i2 & 2) != 0 ? null : str);
    }

    public final String getMrequestid() {
        return this.mrequestid;
    }
}
