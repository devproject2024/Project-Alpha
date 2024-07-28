package net.one97.paytm.o2o.movies.one_pager;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpSection extends IJRPaytmDataModel implements IJRDataModel {
    public String display_name;
    public boolean isEnabled;
    public boolean isGroup;
    public String name;
    public Integer position;
}
