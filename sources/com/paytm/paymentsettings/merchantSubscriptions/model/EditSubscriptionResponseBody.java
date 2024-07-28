package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EditSubscriptionResponseBody extends IJRPaytmDataModel {
    @b(a = "resultInfo")
    private final EditSubscriptionResponseResultInfo resultInfo;
    @b(a = "state")
    private final String state;

    public EditSubscriptionResponseBody() {
        this((String) null, (EditSubscriptionResponseResultInfo) null, 3, (g) null);
    }

    public static /* synthetic */ EditSubscriptionResponseBody copy$default(EditSubscriptionResponseBody editSubscriptionResponseBody, String str, EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editSubscriptionResponseBody.state;
        }
        if ((i2 & 2) != 0) {
            editSubscriptionResponseResultInfo = editSubscriptionResponseBody.resultInfo;
        }
        return editSubscriptionResponseBody.copy(str, editSubscriptionResponseResultInfo);
    }

    public final String component1() {
        return this.state;
    }

    public final EditSubscriptionResponseResultInfo component2() {
        return this.resultInfo;
    }

    public final EditSubscriptionResponseBody copy(String str, EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo) {
        return new EditSubscriptionResponseBody(str, editSubscriptionResponseResultInfo);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditSubscriptionResponseBody)) {
            return false;
        }
        EditSubscriptionResponseBody editSubscriptionResponseBody = (EditSubscriptionResponseBody) obj;
        return k.a((Object) this.state, (Object) editSubscriptionResponseBody.state) && k.a((Object) this.resultInfo, (Object) editSubscriptionResponseBody.resultInfo);
    }

    public final int hashCode() {
        String str = this.state;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo = this.resultInfo;
        if (editSubscriptionResponseResultInfo != null) {
            i2 = editSubscriptionResponseResultInfo.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EditSubscriptionResponseBody(state=" + this.state + ", resultInfo=" + this.resultInfo + ")";
    }

    public final String getState() {
        return this.state;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditSubscriptionResponseBody(String str, EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : editSubscriptionResponseResultInfo);
    }

    public final EditSubscriptionResponseResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public EditSubscriptionResponseBody(String str, EditSubscriptionResponseResultInfo editSubscriptionResponseResultInfo) {
        this.state = str;
        this.resultInfo = editSubscriptionResponseResultInfo;
    }
}
