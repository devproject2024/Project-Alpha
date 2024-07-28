package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CityBusQRModel extends IJRPaytmDataModel {
    @b(a = "citybus_qr_code")
    private List<CitybusQrCode> citybusQrCode = null;

    public List<CitybusQrCode> getCitybusQrCode() {
        return this.citybusQrCode;
    }
}
