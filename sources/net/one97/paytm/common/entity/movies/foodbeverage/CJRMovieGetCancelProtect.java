package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieGetCancelProtect extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "configuration")
    private CJRGetMovieCancelProtectConfiguration configuration;
    @c(a = "meta_data")
    private CJRGetMovieCancelProtectMetadata meta_data;
    @c(a = "product_id")
    private Integer product_id;
    @c(a = "qty")
    private Integer qty;

    public Integer getProductId() {
        return this.product_id;
    }

    public void setProductId(Integer num) {
        this.product_id = num;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer num) {
        this.qty = num;
    }

    public CJRGetMovieCancelProtectMetadata getMeta_data() {
        return this.meta_data;
    }

    public void setMeta_data(CJRGetMovieCancelProtectMetadata cJRGetMovieCancelProtectMetadata) {
        this.meta_data = cJRGetMovieCancelProtectMetadata;
    }

    public CJRGetMovieCancelProtectConfiguration getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(CJRGetMovieCancelProtectConfiguration cJRGetMovieCancelProtectConfiguration) {
        this.configuration = cJRGetMovieCancelProtectConfiguration;
    }
}
