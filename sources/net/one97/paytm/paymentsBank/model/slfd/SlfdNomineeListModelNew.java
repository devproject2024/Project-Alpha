package net.one97.paytm.paymentsBank.model.slfd;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdNomineeListModelNew extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<SlfdNomineeModel> nomineeList;

    public final ArrayList<SlfdNomineeModel> getNomineeList() {
        return this.nomineeList;
    }

    public final void setNomineeList(ArrayList<SlfdNomineeModel> arrayList) {
        this.nomineeList = arrayList;
    }
}
