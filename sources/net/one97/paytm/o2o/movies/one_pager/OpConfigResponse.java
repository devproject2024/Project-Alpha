package net.one97.paytm.o2o.movies.one_pager;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpConfigResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "category_section")
    public List<OpSection> category_section;
    @c(a = "featured_section")
    public List<OpSection> featured_section;
}
