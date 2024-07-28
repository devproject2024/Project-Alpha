package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CashbackStageItemV4 extends IJRPaytmDataModel {
    @b(a = "gratification_objects")
    private ArrayList<GratificationItem> Gratification;
    @b(a = "stage_progress_construct")
    private String stageProgressConstruct;
    @b(a = "stage_status")
    private String stageStatus;
    @b(a = "stage_txn_count")
    private String stageTxnCount;
    @b(a = "stage_success_txn_count")
    private String successTxnCount;
    @b(a = "surprise_stage")
    private boolean surpriseStage;

    public String getStageStatus() {
        return this.stageStatus;
    }

    public boolean isSurpriseStage() {
        return this.surpriseStage;
    }

    public ArrayList<GratificationItem> getGratification() {
        return this.Gratification;
    }

    public String getStageProgressConstruct() {
        return this.stageProgressConstruct;
    }

    public String getSuccessTxnCount() {
        return this.successTxnCount;
    }

    public String getStageTxnCount() {
        return this.stageTxnCount;
    }

    public void setStageStatus(String str) {
        this.stageStatus = str;
    }
}
