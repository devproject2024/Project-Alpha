package net.one97.paytm.recharge.model.metro;

import com.google.gson.b.a;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRMetroTnCListModel extends IJRPaytmDataModel {
    private List<String> mTnCList;

    public List<String> getmTnCList() {
        return this.mTnCList;
    }

    public void setmTnCList(List<String> list) {
        this.mTnCList = list;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRMetroTnCListModel cJRMetroTnCListModel = new CJRMetroTnCListModel();
        List list = (List) new f().a(str, new a<List<String>>() {
        }.getType());
        if (list == null || list.size() != 0) {
            cJRMetroTnCListModel.setmTnCList(list);
        } else {
            cJRMetroTnCListModel.setmTnCList((List<String>) null);
        }
        return cJRMetroTnCListModel;
    }
}
