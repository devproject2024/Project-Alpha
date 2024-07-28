package net.one97.paytm.o2o.movies.common.movies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieUpvoteResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error_message")
    private String mErrorMessage;
    @b(a = "status")
    private String mStatus;

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public String getmErrorMessage() {
        return this.mErrorMessage;
    }

    public void setmErrorMessage(String str) {
        this.mErrorMessage = str;
    }
}
