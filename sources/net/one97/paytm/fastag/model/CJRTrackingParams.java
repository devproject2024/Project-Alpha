package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrackingParams extends IJRPaytmDataModel {
    @b(a = "benchmark_price")
    private double benchmarkPrice;
    @b(a = "courier_name")
    private String courierName;
    @b(a = "is_lmd_merchant")
    private boolean lmd_merchant;
    @b(a = "pickup_code")
    private String mPickupCode;
    @b(a = "parsed_return_pickup_address")
    private CJRAddress mReturnAddress;
    @b(a = "merchant_id")
    private int merchantId;
    @b(a = "return_next_step_template")
    private CJRNextStep nextStep;
    @b(a = "is_serviceable")
    private boolean serviceable;
    @b(a = "shipper_id")
    private int shipperId;
    @b(a = "tracking_number")
    private String trackinNumber;

    public CJRAddress getmReturnAddress() {
        return this.mReturnAddress;
    }

    public boolean isLmd_merchant() {
        return this.lmd_merchant;
    }

    public boolean isServiceable() {
        return this.serviceable;
    }

    public String getCourierName() {
        return this.courierName;
    }

    public int getShipperId() {
        return this.shipperId;
    }

    public String getTrackinNumber() {
        return this.trackinNumber;
    }

    public int getMerchantId() {
        return this.merchantId;
    }

    public double getBenchmarkPrice() {
        return this.benchmarkPrice;
    }

    public CJRNextStep getNextStep() {
        return this.nextStep;
    }

    public String getmPickupCode() {
        return this.mPickupCode;
    }

    public void setmPickupCode(String str) {
        this.mPickupCode = str;
    }
}
