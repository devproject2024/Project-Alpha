package net.one97.paytm.paymentsBank.createfd.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CreateFdModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "order_id")
    private String orderId;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txn_id;

    public CreateFdModel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ CreateFdModel copy$default(CreateFdModel createFdModel, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createFdModel.message;
        }
        if ((i2 & 2) != 0) {
            str2 = createFdModel.orderId;
        }
        if ((i2 & 4) != 0) {
            str3 = createFdModel.status;
        }
        if ((i2 & 8) != 0) {
            str4 = createFdModel.txn_id;
        }
        return createFdModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.txn_id;
    }

    public final CreateFdModel copy(String str, String str2, String str3, String str4) {
        return new CreateFdModel(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateFdModel)) {
            return false;
        }
        CreateFdModel createFdModel = (CreateFdModel) obj;
        return k.a((Object) this.message, (Object) createFdModel.message) && k.a((Object) this.orderId, (Object) createFdModel.orderId) && k.a((Object) this.status, (Object) createFdModel.status) && k.a((Object) this.txn_id, (Object) createFdModel.txn_id);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.txn_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CreateFdModel(message=" + this.message + ", orderId=" + this.orderId + ", status=" + this.status + ", txn_id=" + this.txn_id + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public CreateFdModel(String str, String str2, String str3, String str4) {
        this.message = str;
        this.orderId = str2;
        this.status = str3;
        this.txn_id = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateFdModel(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
    }

    public final String getTxn_id() {
        return this.txn_id;
    }

    public final void setTxn_id(String str) {
        this.txn_id = str;
    }
}
