package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroHomeCityBottomSheetModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "deeplinks")
    public List<CJRDeepLinksModel> deeplinks;
    @b(a = "img_url")
    public String img_url;
    @b(a = "is_enabled")
    public Boolean is_enabled;
    @b(a = "modeid")
    public String modeid;
    @b(a = "name")
    public String name;
    @b(a = "pre_selected")
    public Boolean pre_selected;
    @b(a = "tag")
    public String tag;

    public CJRMetroHomeCityBottomSheetModel(String str, String str2, String str3, Boolean bool, String str4, Boolean bool2, List<CJRDeepLinksModel> list) {
        this.name = str;
        this.modeid = str2;
        this.img_url = str3;
        this.is_enabled = bool;
        this.tag = str4;
        this.pre_selected = bool2;
        this.deeplinks = list;
    }
}
