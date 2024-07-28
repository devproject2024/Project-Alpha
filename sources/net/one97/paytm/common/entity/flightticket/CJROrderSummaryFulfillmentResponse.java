package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryFulfillmentResponse implements IJRDataModel {
    private String onward_pnr;
    private String operatorRefNumber;
    private String operator_reference_id;
    private String return_pnr;
    private CJROrderSummaryTicket ticket;

    public String getOperatorRefNumber() {
        return this.operatorRefNumber;
    }

    public void setOperatorRefNumber(String str) {
        this.operatorRefNumber = str;
    }

    public String getOnward_pnr() {
        return this.onward_pnr;
    }

    public void setOnward_pnr(String str) {
        this.onward_pnr = str;
    }

    public CJROrderSummaryTicket getTicket() {
        return this.ticket;
    }

    public void setTicket(CJROrderSummaryTicket cJROrderSummaryTicket) {
        this.ticket = cJROrderSummaryTicket;
    }

    public String getOperator_reference_id() {
        return this.operator_reference_id;
    }

    public void setOperator_reference_id(String str) {
        this.operator_reference_id = str;
    }

    public void setReturn_pnr(String str) {
        this.return_pnr = this.return_pnr;
    }

    public String getReturn_pnr() {
        return this.return_pnr;
    }
}
