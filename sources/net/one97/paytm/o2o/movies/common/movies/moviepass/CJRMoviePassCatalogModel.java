package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel;

public class CJRMoviePassCatalogModel extends IJRPaytmDataModel implements IJRDataModel {
    private String currentDate;
    @b(a = "faq")
    private HashMap<String, CJRMoviePassFaqInstructionModel> moviePassFaqInstructionMap;
    @b(a = "passCatalog")
    private ArrayList<CJRMoviePassModelNew> moviePassList;
    @b(a = "howtoredeem")
    private HashMap<String, CJRMoviePassRedeemInstructionModel> moviePassRedeemInstructionMap;
    @b(a = "storeFrontData")
    private CJRMoviePassStorefrontDataModel moviePassStorefrontData;
    @b(a = "t&c")
    private Map<String, CJRMoviePassTncInstructionModel> moviePassTnCInstructionMap;

    public ArrayList<CJRMoviePassModelNew> getMoviePassList() {
        return this.moviePassList;
    }

    public Map<String, CJRMoviePassTncInstructionModel> getMoviePassTnCInstructionMap() {
        return this.moviePassTnCInstructionMap;
    }

    public HashMap<String, CJRMoviePassRedeemInstructionModel> getMoviePassRedeemInstructionMap() {
        return this.moviePassRedeemInstructionMap;
    }

    public HashMap<String, CJRMoviePassFaqInstructionModel> getMoviePassFaqInstructionMap() {
        return this.moviePassFaqInstructionMap;
    }

    public String getCurrentDate() {
        return this.currentDate;
    }

    public CJRMoviePassStorefrontDataModel getMoviePassStorefrontData() {
        return this.moviePassStorefrontData;
    }

    public void setMoviePassStorefrontData(CJRMoviePassStorefrontDataModel cJRMoviePassStorefrontDataModel) {
        this.moviePassStorefrontData = cJRMoviePassStorefrontDataModel;
    }
}
