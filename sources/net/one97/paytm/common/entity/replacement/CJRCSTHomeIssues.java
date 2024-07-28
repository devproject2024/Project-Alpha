package net.one97.paytm.common.entity.replacement;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTHomeIssues implements IJRDataModel {
    private String id;
    private boolean isLoggedIn;
    private ArrayList<CJRReplacementReason> reasonsList;

    public void setId(String str) {
        this.id = str;
    }

    public void setReasonsList(ArrayList<CJRReplacementReason> arrayList) {
        this.reasonsList = arrayList;
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<CJRReplacementReason> getReasonsList() {
        return this.reasonsList;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void setLoggedIn(boolean z) {
        this.isLoggedIn = z;
    }
}
