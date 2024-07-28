package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class ProfileTicketStatus extends a {
    public static final long serialVersionUID = 1;
    @c(a = "bankDetails")
    public TicketItem bankDetails;
    @c(a = "deactivateMerchant")
    public TicketItem deactivateMerchant;
    @c(a = "displayName")
    public TicketItem displayName;
    @c(a = "gstin")
    public TicketItem gstin;
    @c(a = "gstinOE")
    public TicketItem gstinOE;
    @c(a = "reactivateLead")
    public TicketItem reactivateMerchant;

    public TicketItem getReactivateMerchant() {
        return this.reactivateMerchant;
    }

    public TicketItem getGstin() {
        return this.gstin;
    }

    public TicketItem getBankDetails() {
        return this.bankDetails;
    }

    public TicketItem getDisplayName() {
        return this.displayName;
    }

    public TicketItem getDeactivateMerchant() {
        return this.deactivateMerchant;
    }

    public TicketItem getGstinOE() {
        return this.gstinOE;
    }

    public void setGstinOE(TicketItem ticketItem) {
        this.gstinOE = ticketItem;
    }

    public static class TicketItem {
        public String caseId;
        public String status;

        public String getCaseId() {
            return this.caseId;
        }

        public void setCaseId(String str) {
            this.caseId = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }
}
