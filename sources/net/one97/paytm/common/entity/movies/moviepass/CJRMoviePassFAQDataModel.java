package net.one97.paytm.common.entity.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassFAQDataModel implements IJRDataModel {
    private final String ans;
    private final String ques;

    public final String getQues() {
        return this.ques;
    }

    public final String getAns() {
        return this.ans;
    }
}
