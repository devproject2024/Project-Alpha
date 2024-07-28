package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public class CJRMetroRefundDescriptionModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "actions")
    private List<CJROrderSummaryAction> actions;
    @b(a = "post_actions")
    private List<Map<String, Double>> amounts;
    private List<CJRAmountDescription> descriptions;

    public List<CJRAmountDescription> getAmountDestribution() {
        List<Map<String, Double>> list = this.amounts;
        if (list == null || list.size() == 0) {
            this.descriptions = new ArrayList(0);
        }
        if (this.descriptions == null) {
            this.descriptions = new ArrayList(this.amounts.get(0).size());
            List<Map<String, Double>> list2 = this.amounts;
            if (list2 != null) {
                for (Map.Entry entry : list2.get(0).entrySet()) {
                    this.descriptions.add(new CJRAmountDescription((String) entry.getKey(), (Double) entry.getValue()));
                }
            }
        }
        return this.descriptions;
    }

    public List<CJROrderSummaryAction> getActions() {
        return this.actions;
    }

    public class CJRAmountDescription implements Comparable<CJRAmountDescription>, IJRDataModel {
        private Double amount;
        private String label;

        public CJRAmountDescription(String str, Double d2) {
            this.label = str;
            this.amount = d2;
        }

        public String getLabel() {
            return this.label;
        }

        public Double getAmount() {
            return this.amount;
        }

        public int compareTo(CJRAmountDescription cJRAmountDescription) {
            return this.amount.compareTo(cJRAmountDescription.amount);
        }

        public String toString() {
            return this.label + " : " + this.amount;
        }
    }
}
