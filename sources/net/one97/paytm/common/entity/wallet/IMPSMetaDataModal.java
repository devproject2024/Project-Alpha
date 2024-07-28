package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class IMPSMetaDataModal extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fee_configuration")
    private List<FeeConfiguration> feeConfiguration = null;
    @b(a = "imps_max_limit")
    private Double impsMaxLimit;
    @b(a = "max_amount")
    private Double maxAmount;
    @b(a = "min_amount")
    private Double minAmount;

    public Double getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(Double d2) {
        this.minAmount = d2;
    }

    public Double getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(Double d2) {
        this.maxAmount = d2;
    }

    public Double getImpsMaxLimit() {
        return this.impsMaxLimit;
    }

    public void setImpsMaxLimit(Double d2) {
        this.impsMaxLimit = d2;
    }

    public List<FeeConfiguration> getFeeConfiguration() {
        return this.feeConfiguration;
    }

    public void setFeeConfiguration(List<FeeConfiguration> list) {
        this.feeConfiguration = list;
    }

    public class FeeConfiguration extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "lower_limit")
        private Double lowerLimit;
        @b(a = "type")
        private String type;
        @b(a = "upper_limit")
        private Double upperLimit;
        @b(a = "value")
        private Double value;

        public FeeConfiguration() {
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public Double getValue() {
            return this.value;
        }

        public void setValue(Double d2) {
            this.value = d2;
        }

        public Double getLowerLimit() {
            return this.lowerLimit;
        }

        public void setLowerLimit(Double d2) {
            this.lowerLimit = d2;
        }

        public Double getUpperLimit() {
            return this.upperLimit;
        }

        public void setUpperLimit(Double d2) {
            this.upperLimit = d2;
        }
    }
}
