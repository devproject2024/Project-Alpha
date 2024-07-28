package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashBackTransactionV4 extends IJRPaytmDataModel {
    @b(a = "created_at")
    private String created_at;
    @b(a = "merchant_name")
    private String merchant_name;
    @b(a = "order_id")
    private String order_id;
    @b(a = "order_name")
    private String order_name;
    @b(a = "payee_name")
    private String payee_name;
    @b(a = "progress_screen_construct")
    private String progressScreenConstruct;
    @b(a = "stage")
    private String stage;
    @b(a = "stage_object")
    private CashbackStageItemV4 stages;
    @b(a = "status")
    private String status;
    @b(a = "txn_amount")
    private String txn_amount;
    @b(a = "txn_id")
    private String txn_id;
    @b(a = "txn_source")
    private String txn_source;
    @b(a = "txn_type")
    private String txn_type;

    public String getOrder_name() {
        return this.order_name;
    }

    public String getPayee_name() {
        return this.payee_name;
    }

    public String getMerchant_name() {
        return this.merchant_name;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getTxn_amount() {
        return this.txn_amount;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public String getTxn_type() {
        return this.txn_type;
    }

    public String getTxn_source() {
        return this.txn_source;
    }

    public String getProgressScreenConstruct() {
        return this.progressScreenConstruct;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStage() {
        return this.stage;
    }

    public CashbackStageItemV4 getStages() {
        return this.stages;
    }
}
