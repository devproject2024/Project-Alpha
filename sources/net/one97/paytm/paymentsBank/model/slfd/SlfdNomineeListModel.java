package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdNomineeListModel extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<SlfdNomineeModel> nomineeList;

    public final ArrayList<SlfdNomineeModel> getNomineeList() {
        return this.nomineeList;
    }

    public final void setNomineeList(ArrayList<SlfdNomineeModel> arrayList) {
        this.nomineeList = arrayList;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        SlfdNomineeListModel slfdNomineeListModel = new SlfdNomineeListModel();
        slfdNomineeListModel.nomineeList = fVar != null ? (ArrayList) fVar.a(str, new ArrayList().getClass()) : null;
        return slfdNomineeListModel;
    }
}
