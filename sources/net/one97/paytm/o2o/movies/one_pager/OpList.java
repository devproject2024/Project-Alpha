package net.one97.paytm.o2o.movies.one_pager;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpList extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "categorywiseList")
    public HashMap<String, List<String>> categorywiseList;
    @c(a = "groupwiseList")
    public HashMap<String, List<String>> groupwiseList;
    @c(a = "masterList")
    public HashMap<String, OpFeaturedModel> masterList;
}
