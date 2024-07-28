package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLogisticInfoModel implements IJRDataModel {
    @b(a = "cod_enabled")
    private int codEnable;
    @b(a = "delivery_description")
    private String deliveryDescription;
    @b(a = "delivery_type")
    private int deliveryType;
    @b(a = "is_PFA_Warehouse")
    private int isPFA;
    @b(a = "max_delivery_days")
    private String maxDeliveryDays;
    @b(a = "min_delivery_days")
    private String minDeliveryDays;
    @b(a = "non_shippable")
    private int nomShippable;
    @b(a = "paytm_promise_badge")
    private String paytmPromiseBadge;
    @b(a = "type")
    private String type;

    public int getCodEnable() {
        return this.codEnable;
    }

    public int getNomShippable() {
        return this.nomShippable;
    }

    public int getDeliveryType() {
        return this.deliveryType;
    }

    public String getDeliveryDescription() {
        return this.deliveryDescription;
    }

    public String getMaxDeliveryDays() {
        return this.maxDeliveryDays;
    }

    public String getMinDeliveryDays() {
        return this.minDeliveryDays;
    }

    public String getType() {
        return this.type;
    }

    public int getIsPFA() {
        return this.isPFA;
    }

    public String getPaytmPromiseBadge() {
        return this.paytmPromiseBadge;
    }
}
