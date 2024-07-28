package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieLoyaltyTermsContent implements IJRDataModel {
    @b(a = "headLine")
    private String headLine;
    @b(a = "subPoints")
    private ArrayList<String> subPoints;

    public String getHeadLine() {
        return this.headLine;
    }

    public ArrayList<String> getSubpoints() {
        return this.subPoints;
    }
}
