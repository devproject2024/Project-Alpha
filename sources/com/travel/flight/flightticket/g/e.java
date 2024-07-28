package com.travel.flight.flightticket.g;

import android.text.TextUtils;
import com.travel.flight.flightticket.f.b;
import com.travel.flight.flightticket.h.a;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail;
import java.util.ArrayList;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public a f25023a;

    public e(b bVar) {
        this.f25023a = new a(bVar);
    }

    public static double a(CJRFlightDetails cJRFlightDetails, boolean z) {
        double d2;
        int selectedDays;
        double d3 = 0.0d;
        if (cJRFlightDetails.getmRepriceFareDetails() == null || cJRFlightDetails.getmRepriceFareDetails().getmTotalFare() == null || TextUtils.isEmpty(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare())) {
            d2 = 0.0d;
        } else {
            d2 = Double.parseDouble(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare());
            if (cJRFlightDetails.getmRepriceFareDetails().getTotalModifyCharges() != null) {
                d2 += (double) cJRFlightDetails.getmRepriceFareDetails().getTotalModifyCharges().intValue();
            }
        }
        double intValue = d2 + ((double) (cJRFlightDetails.getmConvenienceFee() != null ? (float) cJRFlightDetails.getmConvenienceFee().getMtotalConFee().intValue() : 0.0f));
        if (!(!z || cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().size() <= 0 || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0) == null)) {
            double totalPremium = cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getTotalPremium();
            if (cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getUserInputInfo() != null && cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).isOne_way_international() && (selectedDays = cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getUserInputInfo().getSelectedDays()) > 0) {
                totalPremium *= (double) selectedDays;
            }
            intValue += totalPremium;
        }
        if (!(!cJRFlightDetails.isInsuranceCancelProtectApplied() || cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().size() <= 0 || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0) == null)) {
            intValue += cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getTotalPremium();
        }
        if (cJRFlightDetails.getBundleList() == null || cJRFlightDetails.getBundleList().size() <= 0) {
            return intValue;
        }
        if (cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0) {
            try {
                double d4 = 0.0d;
                for (FlightSellingBundleResponseData product_selling_price : cJRFlightDetails.getBundleList()) {
                    d4 += product_selling_price.getProduct_selling_price();
                }
                d3 = d4;
            } catch (Exception unused) {
            }
        }
        return intValue + d3;
    }

    public static double a(CJRFlightDetails cJRFlightDetails) {
        double d2;
        double d3 = 0.0d;
        if (cJRFlightDetails.getmRepriceFareDetails() == null || cJRFlightDetails.getmRepriceFareDetails().getmTotalFare() == null || TextUtils.isEmpty(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare())) {
            d2 = 0.0d;
        } else {
            d2 = Double.parseDouble(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare());
            if (cJRFlightDetails.getmRepriceFareDetails().getTotalModifyCharges() != null) {
                d2 += (double) cJRFlightDetails.getmRepriceFareDetails().getTotalModifyCharges().intValue();
            }
        }
        if (!(!cJRFlightDetails.isInsuranceApplied() || cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().size() <= 0 || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0) == null)) {
            d2 += cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getTotalPremium();
        }
        if (cJRFlightDetails.getBundleList() == null || cJRFlightDetails.getBundleList().size() <= 0) {
            return d2;
        }
        if (cJRFlightDetails.getBundleList() != null && cJRFlightDetails.getBundleList().size() > 0) {
            try {
                double d4 = 0.0d;
                for (FlightSellingBundleResponseData product_selling_price : cJRFlightDetails.getBundleList()) {
                    d4 += product_selling_price.getProduct_selling_price();
                }
                d3 = d4;
            } catch (Exception unused) {
            }
        }
        return d2 + d3;
    }

    public static String b(CJRFlightDetails cJRFlightDetails) {
        ArrayList<CJRInsurancePriceDetail> priceDetails;
        try {
            if (cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0) == null || (priceDetails = cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getPriceDetails()) == null || priceDetails.size() <= 0) {
                return "";
            }
            return priceDetails.get(0).getPremiumPerPassenger();
        } catch (Exception e2) {
            e2.getStackTrace();
            return "";
        }
    }

    public static double a(double d2, CJRFlightDetails cJRFlightDetails) {
        double intValue = d2 + ((double) (cJRFlightDetails.getmConvenienceFee() != null ? (float) cJRFlightDetails.getmConvenienceFee().getMtotalConFee().intValue() : 0.0f));
        if (!(!cJRFlightDetails.isInsuranceApplied() || cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().size() <= 0 || cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0) == null)) {
            intValue += cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).getTotalPremium();
        }
        return (!cJRFlightDetails.isInsuranceCancelProtectApplied() || cJRFlightDetails.getInsuranceData() == null || cJRFlightDetails.getInsuranceData().getBody() == null || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail() == null || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().size() <= 0 || cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0) == null) ? intValue : intValue + cJRFlightDetails.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getTotalPremium();
    }
}
