package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class MerchantStage extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "stage")
    private ArrayList<Integer> stage;
    @b(a = "stage_gratification_text")
    private String stageGratificationText;
    @b(a = "stage_screen_construct1")
    private String stageScreenConstruct1;
    @b(a = "stage_status")
    private String stageStatus;
    @b(a = "stage_success_txn_count")
    private int stageSuccessTxnCount;
    @b(a = "stage_total_txn_count")
    private int stageTotalTxnCount;
    @b(a = "tasks")
    private ArrayList<MerchantTasksItem> tasks;

    public ArrayList<Integer> getStage() {
        return this.stage;
    }

    public String getStageGratificationText() {
        return this.stageGratificationText;
    }

    public int getStageTotalTxnCount() {
        return this.stageTotalTxnCount;
    }

    public String getStageStatus() {
        return this.stageStatus;
    }

    public String getStageScreenConstruct1() {
        return this.stageScreenConstruct1;
    }

    public ArrayList<MerchantTasksItem> getTasks() {
        return this.tasks;
    }

    public int getStageSuccessTxnCount() {
        return this.stageSuccessTxnCount;
    }
}
