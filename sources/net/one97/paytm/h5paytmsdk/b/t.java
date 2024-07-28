package net.one97.paytm.h5paytmsdk.b;

import android.location.Address;
import android.location.Geocoder;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.d.b;

public final class t extends ad {
    public t() {
        super("paytmGetAddress");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        e param = h5Event.getParam();
        Double d2 = param.getDouble("latitude");
        double doubleValue = d2 != null ? d2.doubleValue() : 0.0d;
        Double d3 = param.getDouble("longitude");
        double doubleValue2 = d3 != null ? d3.doubleValue() : 0.0d;
        if (doubleValue == 0.0d || doubleValue2 == 0.0d) {
            a(H5Event.Error.INVALID_PARAM, "latitude or longitude cannot be null or 0");
            return true;
        }
        try {
            if (b.a(h5Event.getActivity())) {
                List<Address> fromLocation = new Geocoder(h5Event.getActivity(), Locale.getDefault()).getFromLocation(doubleValue, doubleValue2, 1);
                k.a((Object) fromLocation, "addresses");
                Iterator it2 = fromLocation.iterator();
                if (!it2.hasNext()) {
                    return true;
                }
                Address address = (Address) it2.next();
                String addressLine = address.getAddressLine(0);
                if (addressLine == null) {
                    addressLine = "";
                }
                a(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, (Object) addressLine);
                k.a((Object) address, "it");
                String locality = address.getLocality();
                if (locality == null) {
                    locality = "";
                }
                a("locality", (Object) locality);
                String subLocality = address.getSubLocality();
                if (subLocality == null) {
                    subLocality = "";
                }
                a("subLocality", (Object) subLocality);
                String adminArea = address.getAdminArea();
                if (adminArea == null) {
                    adminArea = "";
                }
                a("admin", (Object) adminArea);
                String subAdminArea = address.getSubAdminArea();
                if (subAdminArea == null) {
                    subAdminArea = "";
                }
                a("subAdmin", (Object) subAdminArea);
                String postalCode = address.getPostalCode();
                if (postalCode == null) {
                    postalCode = "";
                }
                a("postalCode", (Object) postalCode);
                String countryCode = address.getCountryCode();
                if (countryCode == null) {
                    countryCode = "";
                }
                a("countryCode", (Object) countryCode);
                String countryName = address.getCountryName();
                if (countryName == null) {
                    countryName = "";
                }
                a("countryName", (Object) countryName);
                a((Object) null);
                return true;
            }
            a(H5Event.Error.FORBIDDEN, "Network Not available");
            return true;
        } catch (Exception unused) {
            a(H5Event.Error.FORBIDDEN, "Service not Available");
            return true;
        }
    }
}
