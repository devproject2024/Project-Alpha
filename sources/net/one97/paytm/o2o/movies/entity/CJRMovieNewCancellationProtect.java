package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel;
import org.json.JSONObject;

public class CJRMovieNewCancellationProtect extends CJRMovieICancelProtectModel {
    @b(a = "upgrades")
    private CJRCPUpgrade cpUpgrade;
    @b(a = "isCancellable")
    private Boolean isCancellable;
    public String metaObject;
    @b(a = "terms_and_slabs")
    private CJRCPTermsAndCond termsAndSlab;
    @b(a = "ui_label_new")
    private String ui_label_new;

    public String getUi_label_new() {
        return this.ui_label_new;
    }

    public CJRCPTermsAndCond getTermsAndSlab() {
        return this.termsAndSlab;
    }

    public CJRCPUpgrade getCpUpgrade() {
        return this.cpUpgrade;
    }

    public Boolean getIsCancellable() {
        return this.isCancellable;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("meta")) {
            ((CJRMovieNewCancellationProtect) parseResponse).metaObject = jSONObject.getJSONObject("meta").toString();
        }
        return parseResponse;
    }
}
