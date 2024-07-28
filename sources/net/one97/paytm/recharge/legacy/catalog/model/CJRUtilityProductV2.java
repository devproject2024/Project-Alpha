package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityProductV2 implements IJRDataModel {
    @b(a = "attributes")
    private CJRUtilityAttributesV2 attributes;
    @b(a = "conv_fee")
    private boolean convenienceFee;
    private String displayName;
    @b(a = "fee_type_key")
    private String feeTypeKey;
    @b(a = "filter_name")
    private String filterName;
    @b(a = "id")
    private long id;
    @b(a = "input_fields")
    private List<CJRUtilityInputFieldsV2> inputFields = new ArrayList();
    @b(a = "pay_type_supported")
    private HashMap<String, Integer> payTypeSupported;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public CJRUtilityAttributesV2 getAttributes() {
        return this.attributes;
    }

    public void setAttributes(CJRUtilityAttributesV2 cJRUtilityAttributesV2) {
        this.attributes = cJRUtilityAttributesV2;
    }

    public List<CJRUtilityInputFieldsV2> getInputFields() {
        return this.inputFields;
    }

    public void setInputFields(List<CJRUtilityInputFieldsV2> list) {
        this.inputFields = list;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getFilterName() {
        return this.filterName;
    }

    public void setFilterName(String str) {
        this.filterName = str;
    }

    public String getFeeTypeKey() {
        return this.feeTypeKey;
    }

    public void setFeeTypeKey(String str) {
        this.feeTypeKey = str;
    }

    public boolean isConvenienceFee() {
        return this.convenienceFee;
    }

    public void setConvenienceFee(boolean z) {
        this.convenienceFee = z;
    }

    public HashMap<String, Integer> getPayTypeSupported() {
        return this.payTypeSupported;
    }

    public void setPayTypeSupported(HashMap<String, Integer> hashMap) {
        this.payTypeSupported = hashMap;
    }
}
