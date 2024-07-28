package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIssueMessageList extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRIssueMessage> listOfIssueMessages;

    public List<CJRIssueMessage> getListOfIssueMessages() {
        return this.listOfIssueMessages;
    }

    public void setListOfIssueMessages(List<CJRIssueMessage> list) {
        this.listOfIssueMessages = list;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRIssueMessageList cJRIssueMessageList = new CJRIssueMessageList();
        cJRIssueMessageList.setListOfIssueMessages(new ArrayList(Arrays.asList((CJRIssueMessage[]) fVar.a(str, CJRIssueMessage[].class))));
        return cJRIssueMessageList;
    }
}
