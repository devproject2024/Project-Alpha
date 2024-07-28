package net.one97.paytm.hotel4.service.model.ordersummary;

import androidx.core.g.d;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.hotel4.service.model.details.Address;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.HotelPolicy;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.details.TnC;

public class MetaData extends IJRPaytmDataModel {
    @a
    public Address address;
    @a
    public String cancellationPolicy;
    @a
    public String checkInDate;
    @a
    public String checkOutDate;
    @a
    public String city;
    @a
    public CustomerDetails customerDetails;
    @a
    public Integer guestCount;
    @a
    public String hotelId;
    @a
    public HotelPolicy hotelPolicy;
    @a
    public Integer index;
    @a
    public String mealPlan;
    @a
    @b(a = "merchant_phone")
    public ArrayList<String> merchantPhone = null;
    @a
    public String name;
    @a
    public Integer numNights;
    @a
    public String numRooms;
    @a
    @b(a = "paytm_images")
    public PaytmImages paytmImages;
    @a
    public String phone;
    @a
    public PriceData priceData;
    @a
    public String roomBedType;
    @a
    public String roomName;
    @a
    public List<CJRRoom> roomsDetails = null;
    @a
    public String supplierName;
    @a
    public TnC tnc;

    public List<d<String, String>> getTaxes() {
        ArrayList arrayList = new ArrayList();
        PriceData priceData2 = this.priceData;
        if (priceData2 == null) {
            return arrayList;
        }
        if (priceData2.finalCGST > 0) {
            arrayList.add(new d("CGST@10%", "₹ " + this.priceData.finalCGST));
        }
        if (this.priceData.finalSGST > 0) {
            arrayList.add(new d("SGST@10%", "₹ " + this.priceData.finalSGST));
        }
        if (this.priceData.finalIGST > 0) {
            arrayList.add(new d("IGST@10%", "₹ " + this.priceData.finalIGST));
        }
        if (this.priceData.finalUTGST > 0) {
            arrayList.add(new d("UTGST@10%", "₹ " + this.priceData.finalUTGST));
        }
        if (this.priceData.finalTax > 0) {
            arrayList.add(new d("Total Tax", "₹ " + this.priceData.finalTax));
        }
        return arrayList;
    }

    public String getCheckInTime() {
        return this.hotelPolicy.getCheckInTime() + " Check-in";
    }

    public String getCheckOutTime() {
        return this.hotelPolicy.getCheckOutTime() + " Check-out";
    }
}
