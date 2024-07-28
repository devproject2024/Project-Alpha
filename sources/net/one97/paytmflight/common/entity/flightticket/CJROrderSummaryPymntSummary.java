package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryPymntSummary implements IJRDataModel {
    private ArrayList<CJROrderSummarySummary> summary;
    private CJROrderSummaryTaxBreakUp tax_break_up;

    public ArrayList<CJROrderSummarySummary> getSummary() {
        return this.summary;
    }

    public void setSummary(ArrayList<CJROrderSummarySummary> arrayList) {
        this.summary = arrayList;
    }

    public CJROrderSummaryTaxBreakUp getTax_break_up() {
        return this.tax_break_up;
    }

    public void setTax_break_up(CJROrderSummaryTaxBreakUp cJROrderSummaryTaxBreakUp) {
        this.tax_break_up = cJROrderSummaryTaxBreakUp;
    }
}
