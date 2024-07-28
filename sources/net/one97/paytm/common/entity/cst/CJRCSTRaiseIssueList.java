package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTRaiseIssueList extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRCSTRaiseIssue> raiseIssueList;

    public List<CJRCSTRaiseIssue> getRaiseIssueList() {
        return this.raiseIssueList;
    }

    public void setRaiseIssueList(List<CJRCSTRaiseIssue> list) {
        this.raiseIssueList = list;
    }

    public boolean isContainingCTA() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list == null) {
            return false;
        }
        for (CJRCSTRaiseIssue next : list) {
            if (next != null && Item.KEY_CTA.equalsIgnoreCase(next.getType())) {
                return true;
            }
        }
        return false;
    }

    public boolean isContainingIssues() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list == null) {
            return false;
        }
        for (CJRCSTRaiseIssue next : list) {
            if (next != null && "issue".equalsIgnoreCase(next.getType())) {
                return true;
            }
        }
        return false;
    }

    public CJRCSTRaiseIssue getMessageTypeObject() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list == null) {
            return null;
        }
        for (CJRCSTRaiseIssue next : list) {
            if (next != null && "message".equalsIgnoreCase(next.getType())) {
                return next;
            }
        }
        return null;
    }

    public List<CJRCSTRaiseIssue> getCTATypeObjects() {
        ArrayList arrayList = new ArrayList();
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list != null) {
            for (CJRCSTRaiseIssue next : list) {
                if (next != null && Item.KEY_CTA.equalsIgnoreCase(next.getType())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<CJRCSTRaiseIssue> getIssueTypeObjects() {
        ArrayList<CJRCSTRaiseIssue> arrayList = new ArrayList<>();
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list != null) {
            for (CJRCSTRaiseIssue next : list) {
                if (next != null && "issue".equalsIgnoreCase(next.getType())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean containsMetaData() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list == null) {
            return false;
        }
        for (CJRCSTRaiseIssue next : list) {
            if (next != null && next.getType() != null && "metadata".equalsIgnoreCase(next.getType())) {
                return true;
            }
        }
        return false;
    }

    public CJRCSTRaiseIssue getPathList() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        CJRCSTRaiseIssue cJRCSTRaiseIssue = null;
        if (list != null) {
            for (CJRCSTRaiseIssue next : list) {
                if (!(next == null || next.getType() == null || !"bypass".equalsIgnoreCase(next.getType()) || next.getPath() == null || next.getPath().size() <= 0)) {
                    cJRCSTRaiseIssue = next;
                }
            }
        }
        return cJRCSTRaiseIssue;
    }

    public ArrayList<CSTAttributes> getMetaData() {
        List<CJRCSTRaiseIssue> list = this.raiseIssueList;
        if (list == null) {
            return null;
        }
        for (CJRCSTRaiseIssue next : list) {
            if (next != null && next.getType() != null && "metadata".equalsIgnoreCase(next.getType())) {
                return next.getNode().getAttributes();
            }
        }
        return null;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRCSTRaiseIssueList cJRCSTRaiseIssueList = new CJRCSTRaiseIssueList();
        cJRCSTRaiseIssueList.setRaiseIssueList(new ArrayList(Arrays.asList((CJRCSTRaiseIssue[]) fVar.a(str, CJRCSTRaiseIssue[].class))));
        return cJRCSTRaiseIssueList;
    }
}
