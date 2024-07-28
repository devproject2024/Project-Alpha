package net.one97.paytm.common.entity.insurance;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.insurance.healthInsurance.SelectQuoteErrorStatus;

public final class SelectQuoteResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String amount;
    private Integer code;
    private Configuration configuration;
    private Boolean error = Boolean.FALSE;
    private String error_message;
    private Object meta_data;
    private Integer productId;
    private Integer product_id;
    private SelectQuoteErrorStatus status;
    private SelectQuoteErrorStatus.SummaryObject summary_object;

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final Integer getProductId() {
        return this.productId;
    }

    public final void setProductId(Integer num) {
        this.productId = num;
    }

    public final Integer getProduct_id() {
        return this.product_id;
    }

    public final void setProduct_id(Integer num) {
        this.product_id = num;
    }

    public final Object getMeta_data() {
        return this.meta_data;
    }

    public final void setMeta_data(Object obj) {
        this.meta_data = obj;
    }

    public final Boolean getError() {
        return this.error;
    }

    public final void setError(Boolean bool) {
        this.error = bool;
    }

    public final String getError_message() {
        return this.error_message;
    }

    public final void setError_message(String str) {
        this.error_message = str;
    }

    public final SelectQuoteErrorStatus.SummaryObject getSummary_object() {
        return this.summary_object;
    }

    public final void setSummary_object(SelectQuoteErrorStatus.SummaryObject summaryObject) {
        this.summary_object = summaryObject;
    }

    public final SelectQuoteErrorStatus getStatus() {
        return this.status;
    }

    public final void setStatus(SelectQuoteErrorStatus selectQuoteErrorStatus) {
        this.status = selectQuoteErrorStatus;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }
}
