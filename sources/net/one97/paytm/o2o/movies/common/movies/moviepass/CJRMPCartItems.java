package net.one97.paytm.o2o.movies.common.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel;

public final class CJRMPCartItems implements IJRDataModel {
    private CJRMPPrevalidateConfigModel configuration;
    private CJRMPMataDataModel meta_data;
    private String product_id;
    private String qty;

    public CJRMPCartItems(String str, String str2, CJRMPPrevalidateConfigModel cJRMPPrevalidateConfigModel, CJRMPMataDataModel cJRMPMataDataModel) {
        this.product_id = str;
        this.qty = str2;
        this.configuration = cJRMPPrevalidateConfigModel;
        this.meta_data = cJRMPMataDataModel;
    }

    public final String getProduct_id() {
        return this.product_id;
    }

    public final void setProduct_id(String str) {
        this.product_id = str;
    }

    public final String getQty() {
        return this.qty;
    }

    public final void setQty(String str) {
        this.qty = str;
    }

    public final CJRMPPrevalidateConfigModel getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration(CJRMPPrevalidateConfigModel cJRMPPrevalidateConfigModel) {
        this.configuration = cJRMPPrevalidateConfigModel;
    }

    public final CJRMPMataDataModel getMeta_data() {
        return this.meta_data;
    }

    public final void setMeta_data(CJRMPMataDataModel cJRMPMataDataModel) {
        this.meta_data = cJRMPMataDataModel;
    }
}
