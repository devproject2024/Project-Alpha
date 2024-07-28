package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBeneficiaryLimits implements IJRDataModel {
    @b(a = "ruleId")
    private String ruleId;
    @b(a = "ruleParams")
    private CJRBeneficiaryRuleParams ruleParams;

    public String getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(String str) {
        this.ruleId = str;
    }

    public CJRBeneficiaryRuleParams getRuleParams() {
        return this.ruleParams;
    }

    public void setRuleParams(CJRBeneficiaryRuleParams cJRBeneficiaryRuleParams) {
        this.ruleParams = cJRBeneficiaryRuleParams;
    }
}
