package net.one97.paytm.o2o.movies.one_pager;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpBrowseCategory extends IJRPaytmDataModel implements IJRDataModel {
    public String bgColor;
    public String deeplink;
    public String displayName;
    public int drawableId;
    public String type;
}
