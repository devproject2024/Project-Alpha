package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionRequest extends IJRPaytmDataModel {
    @b(a = "body")
    private final EditSubscriptionRequestBody body;
    @b(a = "head")
    private final EditSubscriptionRequestHead head;

    public EditSubscriptionRequest() {
        this((EditSubscriptionRequestHead) null, (EditSubscriptionRequestBody) null, 3, (g) null);
    }

    public static /* synthetic */ EditSubscriptionRequest copy$default(EditSubscriptionRequest editSubscriptionRequest, EditSubscriptionRequestHead editSubscriptionRequestHead, EditSubscriptionRequestBody editSubscriptionRequestBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            editSubscriptionRequestHead = editSubscriptionRequest.head;
        }
        if ((i2 & 2) != 0) {
            editSubscriptionRequestBody = editSubscriptionRequest.body;
        }
        return editSubscriptionRequest.copy(editSubscriptionRequestHead, editSubscriptionRequestBody);
    }

    public final EditSubscriptionRequestHead component1() {
        return this.head;
    }

    public final EditSubscriptionRequestBody component2() {
        return this.body;
    }

    public final EditSubscriptionRequest copy(EditSubscriptionRequestHead editSubscriptionRequestHead, EditSubscriptionRequestBody editSubscriptionRequestBody) {
        return new EditSubscriptionRequest(editSubscriptionRequestHead, editSubscriptionRequestBody);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionRequest)) {
            return false;
        }
        EditSubscriptionRequest editSubscriptionRequest = (EditSubscriptionRequest) obj;
        return k.a((Object) this.head, (Object) editSubscriptionRequest.head) && k.a((Object) this.body, (Object) editSubscriptionRequest.body);
    }

    public final int hashCode() {
        EditSubscriptionRequestHead editSubscriptionRequestHead = this.head;
        int i2 = 0;
        int hashCode = (editSubscriptionRequestHead != null ? editSubscriptionRequestHead.hashCode() : 0) * 31;
        EditSubscriptionRequestBody editSubscriptionRequestBody = this.body;
        if (editSubscriptionRequestBody != null) {
            i2 = editSubscriptionRequestBody.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EditSubscriptionRequest(head=" + this.head + ", body=" + this.body + ")";
    }

    public final EditSubscriptionRequestHead getHead() {
        return this.head;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditSubscriptionRequest(EditSubscriptionRequestHead editSubscriptionRequestHead, EditSubscriptionRequestBody editSubscriptionRequestBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : editSubscriptionRequestHead, (i2 & 2) != 0 ? null : editSubscriptionRequestBody);
    }

    public final EditSubscriptionRequestBody getBody() {
        return this.body;
    }

    public EditSubscriptionRequest(EditSubscriptionRequestHead editSubscriptionRequestHead, EditSubscriptionRequestBody editSubscriptionRequestBody) {
        this.head = editSubscriptionRequestHead;
        this.body = editSubscriptionRequestBody;
    }
}
