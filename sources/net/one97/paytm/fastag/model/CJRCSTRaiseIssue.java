package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRCSTRaiseIssue extends IJRPaytmDataModel {
    @a
    @b(a = "node")
    private CJRCSTRaiseIssueNode node;
    @a
    @b(a = "path")
    private ArrayList<CJRCSTRaiseIssue> path;
    @a
    @b(a = "type")
    private String type;

    public ArrayList<CJRCSTRaiseIssue> getPath() {
        return this.path;
    }

    public void setPath(ArrayList<CJRCSTRaiseIssue> arrayList) {
        this.path = arrayList;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CJRCSTRaiseIssueNode getNode() {
        return this.node;
    }

    public void setNode(CJRCSTRaiseIssueNode cJRCSTRaiseIssueNode) {
        this.node = cJRCSTRaiseIssueNode;
    }

    public String toString() {
        CJRCSTRaiseIssueNode cJRCSTRaiseIssueNode = this.node;
        return cJRCSTRaiseIssueNode != null ? cJRCSTRaiseIssueNode.getTemplate() : "";
    }
}
