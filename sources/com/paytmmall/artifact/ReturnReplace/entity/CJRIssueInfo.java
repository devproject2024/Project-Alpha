package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRIssueInfo extends IJRPaytmDataModel {
    private final String ISSUE_ID = "issue_id";
    String TAG_LOG = "CJRIssueInfo";
    @b(a = "issue_id")
    private String issueId;

    public JSONObject getIssueJSON(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_id", String.valueOf(i2));
        } catch (JSONException e2) {
            q.c(e2.getMessage());
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
