package net.one97.paytm.o2o.movies.viewmodel;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDisclaimerModel extends IJRPaytmDataModel implements IJRDataModel {
    public List<String> disclaimers;
}
