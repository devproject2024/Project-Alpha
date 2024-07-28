package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRIssueInfo implements IJRDataModel {
    private final String ISSUE_ID = "issue_id";
    @b(a = "issue_id")
    private String issueId;

    public JSONObject getIssueJSON(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_id", String.valueOf(i2));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
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
