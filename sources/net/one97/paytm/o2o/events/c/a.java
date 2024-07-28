package net.one97.paytm.o2o.events.c;

import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.events.CJRInsiderHoldCallResponse;
import net.one97.paytm.common.entity.events.CJRParticularEventDescriptionModel;
import net.one97.paytm.common.entity.events.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.events.EventsTravellerResponseModel;
import net.one97.paytm.o2o.events.b.c;
import net.one97.paytm.o2o.events.common.entity.events.CJRPinCodeValidationModel;
import net.one97.paytm.o2o.events.d.a.b.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public final a.C1479a f73724a;

    /* renamed from: b  reason: collision with root package name */
    public final net.one97.paytm.o2o.events.common.a f73725b = net.one97.paytm.o2o.events.common.a.a();

    public a(a.C1479a aVar) {
        this.f73724a = aVar;
    }

    public final void a(List<CJRSeatDetailsModel> list, int i2, CJRParticularEventDescriptionModel cJRParticularEventDescriptionModel) {
        if (list != null && list.size() != 0 && cJRParticularEventDescriptionModel != null) {
            int i3 = 0;
            if (i2 == -1) {
                i2 = 0;
            }
            for (CJRSeatDetailsModel selectedQuantity : list) {
                i3 += selectedQuantity.getSelectedQuantity();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("providerId", cJRParticularEventDescriptionModel.getProviderId());
                jSONObject.put("entId", cJRParticularEventDescriptionModel.getId());
                jSONObject.put("ticketCount", i3);
                jSONObject.put("providerEventId", cJRParticularEventDescriptionModel.getProviderEventId());
                jSONObject.put("delivery", i2);
                jSONObject.put("seatInfo", a(list));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                this.f73724a.a();
                this.f73725b.a((c.a) this, jSONObject2, c.b.a.TRAVELLER_FORM_INFO);
            }
        }
    }

    private static JSONArray a(List<CJRSeatDetailsModel> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (CJRSeatDetailsModel next : list) {
            if (next.getSelectedQuantity() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("seatId", next.getSeatId());
                jSONObject.put("seatType", next.getSeatType());
                jSONObject.put("count", next.getSelectedQuantity());
                jSONObject.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, next.getSeatDescription());
                jSONObject.put("pricePerSeat", next.getPrice());
                jSONObject.put("providerSeatId", next.getProviderSeatId());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, HashMap<String, c.b.a> hashMap) {
        this.f73724a.b();
        if (iJRPaytmDataModel instanceof CJRPinCodeValidationModel) {
            this.f73724a.a((CJRPinCodeValidationModel) iJRPaytmDataModel, (String) null);
        } else if (iJRPaytmDataModel instanceof EventsTravellerResponseModel) {
            a(hashMap, c.b.a.TRAVELLER_FORM_INFO);
            EventsTravellerResponseModel eventsTravellerResponseModel = (EventsTravellerResponseModel) iJRPaytmDataModel;
            if (eventsTravellerResponseModel != null && eventsTravellerResponseModel.getForm() != null && eventsTravellerResponseModel.getForm().size() != 0) {
                this.f73724a.a(eventsTravellerResponseModel);
            }
        } else if (iJRPaytmDataModel instanceof CJRInsiderHoldCallResponse) {
            a(hashMap, c.b.a.INSIDER_HOLD_CALL_RESPONSE);
            this.f73724a.a((CJRInsiderHoldCallResponse) iJRPaytmDataModel);
        }
    }

    public final void a(String str, c.b.a aVar, String str2, String str3) {
        this.f73724a.b();
        if (aVar == c.b.a.PINCODE_VALIDATION) {
            this.f73724a.a((CJRPinCodeValidationModel) null, str3);
        } else if (aVar == c.b.a.INSIDER_HOLD_CALL_RESPONSE) {
            this.f73724a.a(str, str2, str3);
        }
    }

    private static void a(HashMap<String, c.b.a> hashMap, c.b.a aVar) {
        for (String str : new HashMap(hashMap).keySet()) {
            if (hashMap.get(str).equals(aVar)) {
                hashMap.remove(str);
            }
        }
    }
}
