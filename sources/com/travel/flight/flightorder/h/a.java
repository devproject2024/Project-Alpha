package com.travel.flight.flightorder.h;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.flightorder.g.c;
import com.travel.flight.pojo.CJRHotelOptions;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.flight.pojo.flightticket.CJRNPSCaptureDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytmflight.common.entity.flightticket.CJRAncillaryCard;
import net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation;
import net.one97.paytmflight.common.shopping.CJRFlightImageData;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f24415a;

    /* renamed from: b  reason: collision with root package name */
    public c f24416b;

    public a(Context context) {
        this.f24415a = context;
    }

    public static boolean a(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        if (cJRFlightOrderSummaryResponse != null) {
            try {
                if (cJRFlightOrderSummaryResponse.getBody() == null || cJRFlightOrderSummaryResponse.getBody().getItems() == null || cJRFlightOrderSummaryResponse.getBody().getItems().size() == 0) {
                    return false;
                }
                Iterator<CJROrderSummaryItems> it2 = cJRFlightOrderSummaryResponse.getBody().getItems().iterator();
                while (it2.hasNext()) {
                    CJROrderSummaryItems next = it2.next();
                    if (com.travel.flight.flightorder.i.b.a(next) && !TextUtils.isEmpty(next.getF_Dir())) {
                        if (next.getF_Dir().equalsIgnoreCase("R") || next.getF_Dir().equalsIgnoreCase("OR")) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        c cVar = this.f24416b;
        if (cVar != null) {
            if (iJRPaytmDataModel instanceof CJRFlightImageData) {
                cVar.a(((CJRFlightImageData) iJRPaytmDataModel).getBody());
            } else if (iJRPaytmDataModel instanceof CJROrderSummaryCancellation) {
                cVar.a((CJROrderSummaryCancellation) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRHotelOptions) {
                cVar.a((CJRHotelOptions) iJRPaytmDataModel);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f24416b.g();
    }

    public static boolean b(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        if (cJRFlightOrderSummaryResponse == null || cJRFlightOrderSummaryResponse.getBody() == null || cJRFlightOrderSummaryResponse.getBody().getAncillary_card() == null) {
            return false;
        }
        try {
            for (CJRAncillaryCard type : cJRFlightOrderSummaryResponse.getBody().getAncillary_card()) {
                if ("Baggage".equalsIgnoreCase(type.getType())) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        try {
            return cJRFlightOrderSummaryResponse.getBody().getAddon_travel_ins_card() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        if (cJRFlightOrderSummaryResponse == null || cJRFlightOrderSummaryResponse.getBody() == null || cJRFlightOrderSummaryResponse.getBody().getAncillary_card() == null) {
            return false;
        }
        try {
            for (CJRAncillaryCard type : cJRFlightOrderSummaryResponse.getBody().getAncillary_card()) {
                if ("Meal".equalsIgnoreCase(type.getType())) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static CJRNPSCaptureDataModel a(String str, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        return new CJRNPSCaptureDataModel.a().a(str).a(e(cJRFlightOrderSummaryResponse)).f25438a;
    }

    private static ArrayList<String> e(CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CJROrderSummaryItems> it2 = cJRFlightOrderSummaryResponse.getBody().getItems().iterator();
        while (it2.hasNext()) {
            arrayList.add(String.valueOf(it2.next().getId()));
        }
        return arrayList;
    }
}
