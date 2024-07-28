package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AccountReactivationRequestEvent {
    public final Object status;

    public AccountReactivationRequestEvent() {
        this((Object) null, 1, (g) null);
    }

    public static /* synthetic */ AccountReactivationRequestEvent copy$default(AccountReactivationRequestEvent accountReactivationRequestEvent, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = accountReactivationRequestEvent.status;
        }
        return accountReactivationRequestEvent.copy(obj);
    }

    public final Object component1() {
        return this.status;
    }

    public final AccountReactivationRequestEvent copy(Object obj) {
        return new AccountReactivationRequestEvent(obj);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AccountReactivationRequestEvent) && k.a(this.status, ((AccountReactivationRequestEvent) obj).status);
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.status;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "AccountReactivationRequestEvent(status=" + this.status + ")";
    }

    public AccountReactivationRequestEvent(Object obj) {
        this.status = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountReactivationRequestEvent(Object obj, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : obj);
    }

    public final Object getStatus() {
        return this.status;
    }
}
