package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private final EditSubscriptionResponseBody body;
    @b(a = "head")
    private final EditSubscriptionResponseHead head;

    public EditSubscriptionResponse() {
        this((EditSubscriptionResponseHead) null, (EditSubscriptionResponseBody) null, 3, (g) null);
    }

    public static /* synthetic */ EditSubscriptionResponse copy$default(EditSubscriptionResponse editSubscriptionResponse, EditSubscriptionResponseHead editSubscriptionResponseHead, EditSubscriptionResponseBody editSubscriptionResponseBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            editSubscriptionResponseHead = editSubscriptionResponse.head;
        }
        if ((i2 & 2) != 0) {
            editSubscriptionResponseBody = editSubscriptionResponse.body;
        }
        return editSubscriptionResponse.copy(editSubscriptionResponseHead, editSubscriptionResponseBody);
    }

    public final EditSubscriptionResponseHead component1() {
        return this.head;
    }

    public final EditSubscriptionResponseBody component2() {
        return this.body;
    }

    public final EditSubscriptionResponse copy(EditSubscriptionResponseHead editSubscriptionResponseHead, EditSubscriptionResponseBody editSubscriptionResponseBody) {
        return new EditSubscriptionResponse(editSubscriptionResponseHead, editSubscriptionResponseBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionResponse)) {
            return false;
        }
        EditSubscriptionResponse editSubscriptionResponse = (EditSubscriptionResponse) obj;
        return k.a((Object) this.head, (Object) editSubscriptionResponse.head) && k.a((Object) this.body, (Object) editSubscriptionResponse.body);
    }

    public final int hashCode() {
        EditSubscriptionResponseHead editSubscriptionResponseHead = this.head;
        int i2 = 0;
        int hashCode = (editSubscriptionResponseHead != null ? editSubscriptionResponseHead.hashCode() : 0) * 31;
        EditSubscriptionResponseBody editSubscriptionResponseBody = this.body;
        if (editSubscriptionResponseBody != null) {
            i2 = editSubscriptionResponseBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EditSubscriptionResponse(head=" + this.head + ", body=" + this.body + ")";
    }

    public final EditSubscriptionResponseHead getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditSubscriptionResponse(EditSubscriptionResponseHead editSubscriptionResponseHead, EditSubscriptionResponseBody editSubscriptionResponseBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : editSubscriptionResponseHead, (i2 & 2) != 0 ? null : editSubscriptionResponseBody);
    }

    public final EditSubscriptionResponseBody getBody() {
        return this.body;
    }

    public EditSubscriptionResponse(EditSubscriptionResponseHead editSubscriptionResponseHead, EditSubscriptionResponseBody editSubscriptionResponseBody) {
        this.head = editSubscriptionResponseHead;
        this.body = editSubscriptionResponseBody;
    }
}
