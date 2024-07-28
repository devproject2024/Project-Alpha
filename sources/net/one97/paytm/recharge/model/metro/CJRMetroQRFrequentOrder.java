package net.one97.paytm.recharge.model.metro;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;

public class CJRMetroQRFrequentOrder extends CJRFrequentOrder {
    @b(a = "destination")
    private CJRMetroStationModel destination;
    @b(a = "code")
    private int journeyTypeCode;
    @b(a = "passengers")
    private int passengers;
    @b(a = "product_label")
    private String productLabel;
    @b(a = "product_sub_type")
    private String productSubType;
    @b(a = "product_type")
    private String productType;
    @b(a = "source")
    private CJRMetroStationModel source;

    public String getRechargeNumber() {
        return null;
    }

    public CJRMetroStationModel getSource() {
        return this.source;
    }

    public void setSource(CJRMetroStationModel cJRMetroStationModel) {
        this.source = cJRMetroStationModel;
    }

    public CJRMetroStationModel getDestination() {
        return this.destination;
    }

    public void setDestination(CJRMetroStationModel cJRMetroStationModel) {
        this.destination = cJRMetroStationModel;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public int getJourneyTypeCode() {
        return this.journeyTypeCode;
    }

    public void setJourneyTypeCode(int i2) {
        this.journeyTypeCode = i2;
    }

    public String getCreatedDescription() {
        return this.mCreatedAt;
    }

    public String getJourneyStation() {
        CJRMetroStationModel cJRMetroStationModel;
        CJRMetroStationModel cJRMetroStationModel2 = this.source;
        if (cJRMetroStationModel2 == null || TextUtils.isEmpty(cJRMetroStationModel2.getName()) || (cJRMetroStationModel = this.destination) == null || TextUtils.isEmpty(cJRMetroStationModel.getName())) {
            return null;
        }
        return this.source.getName() + " to " + this.destination.getName();
    }

    public String getProductType() {
        return this.productType;
    }

    public String getProductLabel() {
        return this.productLabel;
    }

    public String getProductSubType() {
        return this.productSubType;
    }

    public void setProductSubType(String str) {
        this.productSubType = str;
    }
}
