package net.one97.paytm.common.entity.movies.moviepass;

import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMoviePassRedeemDataModel implements IJRDataModel {
    private String image;
    private String step;

    public CJRMoviePassRedeemDataModel(String str, String str2) {
        k.c(str, "step");
        k.c(str2, H5ResourceHandlerUtil.IMAGE);
        this.step = str;
        this.image = str2;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getStep() {
        return this.step;
    }

    public final void setImage(String str) {
        k.c(str, "<set-?>");
        this.image = str;
    }

    public final void setStep(String str) {
        k.c(str, "<set-?>");
        this.step = str;
    }
}
