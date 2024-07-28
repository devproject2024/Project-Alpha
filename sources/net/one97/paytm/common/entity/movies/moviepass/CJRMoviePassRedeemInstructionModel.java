package net.one97.paytm.common.entity.movies.moviepass;

import java.util.List;
import kotlin.g.b.g;

public class CJRMoviePassRedeemInstructionModel extends CJRMoviePassBaseInstructionClass {
    private List<CJRMoviePassRedeemDataModel> instructionsData;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMoviePassRedeemInstructionModel(String str, String str2, String str3, String str4, List list, int i2, g gVar) {
        this(str, str2, str3, str4, (i2 & 16) != 0 ? null : list);
    }

    public final List<CJRMoviePassRedeemDataModel> getInstructionsData() {
        return this.instructionsData;
    }

    public final void setInstructionsData(List<CJRMoviePassRedeemDataModel> list) {
        this.instructionsData = list;
    }

    public CJRMoviePassRedeemInstructionModel(String str, String str2, String str3, String str4, List<CJRMoviePassRedeemDataModel> list) {
        super(str, str2, str3, str4);
        this.instructionsData = list;
    }
}
