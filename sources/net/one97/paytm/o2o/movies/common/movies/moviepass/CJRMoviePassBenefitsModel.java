package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassBenefitsModel implements IJRDataModel {
    @b(a = "is_enabled")
    private boolean isEnabled;
    @b(a = "list")
    private List<CJRMoviePassBenefit> moviePassBenefits;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public List<CJRMoviePassBenefit> getMoviePassBenefits() {
        return this.moviePassBenefits;
    }

    public void setMoviePassBenefits(List<CJRMoviePassBenefit> list) {
        this.moviePassBenefits = list;
    }
}
