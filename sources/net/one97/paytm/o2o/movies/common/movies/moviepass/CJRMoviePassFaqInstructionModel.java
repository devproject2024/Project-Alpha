package net.one97.paytm.o2o.movies.common.movies.moviepass;

import java.util.List;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassBaseInstructionClass;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassFAQDataModel;

public class CJRMoviePassFaqInstructionModel extends CJRMoviePassBaseInstructionClass {
    private List<CJRMoviePassFAQDataModel> instructionsData;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMoviePassFaqInstructionModel(String str, String str2, String str3, String str4, List list, int i2, g gVar) {
        this(str, str2, str3, str4, (i2 & 16) != 0 ? null : list);
    }

    public final List<CJRMoviePassFAQDataModel> getInstructionsData() {
        return this.instructionsData;
    }

    public final void setInstructionsData(List<CJRMoviePassFAQDataModel> list) {
        this.instructionsData = list;
    }

    public CJRMoviePassFaqInstructionModel(String str, String str2, String str3, String str4, List<CJRMoviePassFAQDataModel> list) {
        super(str, str2, str3, str4);
        this.instructionsData = list;
    }
}
