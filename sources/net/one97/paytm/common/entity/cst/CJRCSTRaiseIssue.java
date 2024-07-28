package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTRaiseIssue implements IJRDataModel {
    @a
    @b(a = "display_chatbot")
    private boolean displayChatbot;
    @a
    @b(a = "node")
    private CJRCSTRaiseIssueNode node;
    @a
    @b(a = "path")
    private ArrayList<CJRCSTRaiseIssue> path;
    @a
    @b(a = "question")
    private String question;
    @a
    @b(a = "type")
    private String type;

    public boolean isDisplayChatbot() {
        return this.displayChatbot;
    }

    public void setDisplayChatbot(boolean z) {
        this.displayChatbot = z;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

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
