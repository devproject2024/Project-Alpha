package net.one97.paytm.o2o.movies.common.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieDetailList implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private String code;
    @b(a = "session_dates")
    private List<String> sessionDates = new ArrayList();

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public List<String> getSessionDates() {
        return this.sessionDates;
    }

    public void setSessionDates(List<String> list) {
        this.sessionDates = list;
    }
}
