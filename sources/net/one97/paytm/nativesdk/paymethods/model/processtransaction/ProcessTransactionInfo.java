package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class ProcessTransactionInfo implements Serializable {
    private Body body;
    private Head head;

    public static /* synthetic */ ProcessTransactionInfo copy$default(ProcessTransactionInfo processTransactionInfo, Head head2, Body body2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            head2 = processTransactionInfo.head;
        }
        if ((i2 & 2) != 0) {
            body2 = processTransactionInfo.body;
        }
        return processTransactionInfo.copy(head2, body2);
    }

    public final Head component1() {
        return this.head;
    }

    public final Body component2() {
        return this.body;
    }

    public final ProcessTransactionInfo copy(Head head2, Body body2) {
        return new ProcessTransactionInfo(head2, body2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessTransactionInfo)) {
            return false;
        }
        ProcessTransactionInfo processTransactionInfo = (ProcessTransactionInfo) obj;
        return k.a((Object) this.head, (Object) processTransactionInfo.head) && k.a((Object) this.body, (Object) processTransactionInfo.body);
    }

    public final int hashCode() {
        Head head2 = this.head;
        int i2 = 0;
        int hashCode = (head2 != null ? head2.hashCode() : 0) * 31;
        Body body2 = this.body;
        if (body2 != null) {
            i2 = body2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ProcessTransactionInfo(head=" + this.head + ", body=" + this.body + ")";
    }

    public ProcessTransactionInfo(Head head2, Body body2) {
        this.head = head2;
        this.body = body2;
    }

    public final Head getHead() {
        return this.head;
    }

    public final void setHead(Head head2) {
        this.head = head2;
    }

    public final Body getBody() {
        return this.body;
    }

    public final void setBody(Body body2) {
        this.body = body2;
    }
}
