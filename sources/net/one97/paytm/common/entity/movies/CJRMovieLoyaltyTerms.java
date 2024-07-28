package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieLoyaltyTerms implements IJRDataModel {
    @b(a = "heading")
    private String heading;
    @b(a = "content")
    private ArrayList<CJRMovieLoyaltyTermsContent> mContent;

    public String getHeading() {
        return this.heading;
    }

    public ArrayList<CJRMovieLoyaltyTermsContent> getContent() {
        return this.mContent;
    }
}
