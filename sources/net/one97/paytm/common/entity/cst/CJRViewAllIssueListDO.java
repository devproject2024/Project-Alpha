package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRViewAllIssueListDO extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRViewAllIssuesDO> listOfIssues;

    public List<CJRViewAllIssuesDO> getListOfIssues() {
        return this.listOfIssues;
    }

    public void setListOfIssues(List<CJRViewAllIssuesDO> list) {
        this.listOfIssues = list;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRViewAllIssueListDO cJRViewAllIssueListDO = new CJRViewAllIssueListDO();
        cJRViewAllIssueListDO.setListOfIssues(new ArrayList(Arrays.asList((CJRViewAllIssuesDO[]) fVar.a(str, CJRViewAllIssuesDO[].class))));
        return cJRViewAllIssueListDO;
    }
}
