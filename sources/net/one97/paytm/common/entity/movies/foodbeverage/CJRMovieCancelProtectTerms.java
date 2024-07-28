package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieCancelProtectTerms implements IJRDataModel {
    @b(a = "heading")
    private String heading;
    @b(a = "content")
    private ArrayList<String> mContent;

    public String getHeading() {
        return this.heading;
    }

    public ArrayList<String> getContent() {
        return this.mContent;
    }
}
