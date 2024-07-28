package com.paytm.business.merchantprofile.model.edc;

import com.business.common_module.f.a;
import com.google.gson.a.c;
import java.util.List;

public class RentalPlanDetailsModel extends a {
    @c(a = "results")
    public Results results;
    @c(a = "status")
    public String status;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public String statusMessage;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public Results getResults() {
        return this.results;
    }

    public void setResults(Results results2) {
        this.results = results2;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public class Results {
        @c(a = "rentalSummary")
        public List<RentalSummaryData> rentalSummary;
        @c(a = "usageDeposit")
        public double usageDeposit;

        public Results(RentalPlanDetailsModel rentalPlanDetailsModel) {
        }

        public double getUsageDeposit() {
            return this.usageDeposit;
        }

        public List<RentalSummaryData> getRentalSummary() {
            return this.rentalSummary;
        }

        public void setRentalSummary(List<RentalSummaryData> list) {
            this.rentalSummary = list;
        }

        public void setUsageDeposit(double d2) {
            this.usageDeposit = d2;
        }
    }

    public class RentalSummaryData {
        @c(a = "deviceCount")
        public String deviceCount;
        @c(a = "planType")
        public String planType;
        @c(a = "totalRental")
        public double totalRental;

        public RentalSummaryData(RentalPlanDetailsModel rentalPlanDetailsModel) {
        }

        public double getTotalRental() {
            return this.totalRental;
        }

        public String getDeviceCount() {
            return this.deviceCount;
        }

        public String getPlanType() {
            return this.planType;
        }

        public void setDeviceCount(String str) {
            this.deviceCount = str;
        }

        public void setPlanType(String str) {
            this.planType = str;
        }

        public void setTotalRental(double d2) {
            this.totalRental = d2;
        }
    }
}
