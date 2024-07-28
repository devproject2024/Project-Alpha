package net.one97.travelpass.ordersummary.model;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class TermsConditions implements IJRDataModel {
    @b(a = "_id")
    private String id;
    @b(a = "tncContent")
    private List<String> tncContent;
    @b(a = "tnc_id")
    private Integer tncId;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public List<String> getTncContent() {
        return this.tncContent;
    }

    public void setTncContent(List<String> list) {
        this.tncContent = list;
    }

    public Integer getTncId() {
        return this.tncId;
    }

    public void setTncId(Integer num) {
        this.tncId = num;
    }
}
