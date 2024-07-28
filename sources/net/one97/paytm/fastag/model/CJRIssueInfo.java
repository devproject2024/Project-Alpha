package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRIssueInfo extends IJRPaytmDataModel {
    private final String ISSUE_ID = "issue_id";
    @b(a = "issue_id")
    private String issueId;

    public JSONObject getIssueJSON(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_id", String.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String str) {
        this.issueId = str;
    }
}
