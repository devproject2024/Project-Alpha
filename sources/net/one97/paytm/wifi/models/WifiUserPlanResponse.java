package net.one97.paytm.wifi.models;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import org.json.JSONObject;

public final class WifiUserPlanResponse extends IJRPaytmDataModel {
    private String connectionError;
    private boolean deducedStatus;
    private String deducedStatusDetails;
    private JSONObject etc;
    private String operatorErrorCode;
    private String operatorErrorMessage;
    private List<WifiPlanArray> plansArray;

    public final boolean getDeducedStatus() {
        return this.deducedStatus;
    }

    public final void setDeducedStatus(boolean z) {
        this.deducedStatus = z;
    }

    public final String getDeducedStatusDetails() {
        return this.deducedStatusDetails;
    }

    public final void setDeducedStatusDetails(String str) {
        this.deducedStatusDetails = str;
    }

    public final String getConnectionError() {
        return this.connectionError;
    }

    public final void setConnectionError(String str) {
        this.connectionError = str;
    }

    public final String getOperatorErrorCode() {
        return this.operatorErrorCode;
    }

    public final void setOperatorErrorCode(String str) {
        this.operatorErrorCode = str;
    }

    public final String getOperatorErrorMessage() {
        return this.operatorErrorMessage;
    }

    public final void setOperatorErrorMessage(String str) {
        this.operatorErrorMessage = str;
    }

    public final JSONObject getEtc() {
        return this.etc;
    }

    public final void setEtc(JSONObject jSONObject) {
        this.etc = jSONObject;
    }

    public final List<WifiPlanArray> getPlansArray() {
        return this.plansArray;
    }

    public final void setPlansArray(List<WifiPlanArray> list) {
        this.plansArray = list;
    }
}
