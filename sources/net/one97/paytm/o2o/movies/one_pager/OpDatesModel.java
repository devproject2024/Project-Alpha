package net.one97.paytm.o2o.movies.one_pager;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class OpDatesModel extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "today")
    public String today;
    @c(a = "today_date_string")
    public String today_date_string;
    @c(a = "tomorrow")
    public String tomorrow;
    @c(a = "tomorrow_date_string")
    public String tomorrow_date_string;
    @c(a = "weekend")
    public String weekend;
    @c(a = "weekend_date_string")
    public String weekend_date_string;
}
