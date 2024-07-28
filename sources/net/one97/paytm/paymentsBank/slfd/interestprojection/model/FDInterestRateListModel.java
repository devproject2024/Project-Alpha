package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class FDInterestRateListModel extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @b(a = "effectiveDate")
    private String effectiveDate = "";
    @com.google.gsonhtcfix.a.a
    @b(a = "fdInterestRateList")
    private List<a> fdInterestRateList = new ArrayList();

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(String str) {
        this.effectiveDate = str;
    }

    public List<a> getFdInterestRateList() {
        return this.fdInterestRateList;
    }

    public void setFdInterestRateList(List<a> list) {
        this.fdInterestRateList = list;
    }

    public class a {
        @com.google.gsonhtcfix.a.a
        @b(a = "displayName")

        /* renamed from: a  reason: collision with root package name */
        private String f19206a;
        @com.google.gsonhtcfix.a.a
        @b(a = "interestRate")

        /* renamed from: b  reason: collision with root package name */
        private String f19207b;

        public final String a() {
            return this.f19206a;
        }

        public final String b() {
            return this.f19207b;
        }
    }
}
