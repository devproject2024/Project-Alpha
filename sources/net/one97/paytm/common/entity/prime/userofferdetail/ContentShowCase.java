package net.one97.paytm.common.entity.prime.userofferdetail;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;

public class ContentShowCase implements IJRDataModel {
    private String id;
    private String layout;
    private ArrayList<CJRHomePageLayoutV2> views;

    public ArrayList<CJRHomePageLayoutV2> getViews() {
        return this.views;
    }

    public String getId() {
        return this.id;
    }

    public String getLayout() {
        return this.layout;
    }
}
