package net.one97.paytm.hotel4.service.a;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.HotelDetails;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.hotels2.utils.e;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public y<HotelDetails> f28593a;

    /* renamed from: b  reason: collision with root package name */
    public y<ErrorData> f28594b;

    /* renamed from: c  reason: collision with root package name */
    private Application f28595c;

    /* renamed from: d  reason: collision with root package name */
    private String f28596d = "";

    public a(Application application) {
        this.f28595c = application;
    }

    public final void a(y<HotelDetails> yVar, y<ErrorData> yVar2, SRPDataItem sRPDataItem, CJRHotelSearchInput cJRHotelSearchInput, String str) {
        k.c(yVar, "sucessListener");
        k.c(yVar2, "failureListener");
        k.c(sRPDataItem, "selectedData");
        this.f28593a = yVar;
        this.f28594b = yVar2;
        k.a((Object) e.a(), "HotelsGTMLoader.getInstance()");
        Uri.Builder buildUpon = Uri.parse(e.r()).buildUpon();
        buildUpon.appendQueryParameter("requestId", str);
        HashMap hashMap = new HashMap();
        String a2 = c.b().a((Context) this.f28595c);
        if (a2 == null) {
            this.f28596d = "";
        } else {
            this.f28596d = a2;
        }
        String str2 = this.f28596d;
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(AppConstants.SSO_TOKEN, str2);
        }
        JSONObject jSONObject = new JSONObject();
        if (sRPDataItem.getExtras().getOtas() != null) {
            jSONObject.put("otas", sRPDataItem.getExtras().getOtas());
        }
        if (sRPDataItem.getExtras().getCityId() != null) {
            jSONObject.put("city_id", sRPDataItem.getExtras().getCityId());
        }
        if (sRPDataItem.getExtras().getAxisHc() != null) {
            jSONObject.put("axis_hc", sRPDataItem.getExtras().getAxisHc());
        }
        JSONObject jSONObject2 = new JSONObject();
        if (cJRHotelSearchInput == null) {
            k.a();
        }
        jSONObject2.put("city", cJRHotelSearchInput.getCity());
        jSONObject2.put("ota_data", jSONObject.toString());
        jSONObject2.put("check_out_date", cJRHotelSearchInput.getCheckOutDate());
        jSONObject2.put("channel", "mobile");
        ArrayList<CJRRoom> rooms = cJRHotelSearchInput.getRooms();
        if (rooms == null) {
            k.a();
        }
        jSONObject2.put("num_rooms", rooms.size());
        jSONObject2.put("hotel_id", sRPDataItem.getPaytmId());
        jSONObject2.put("rooms_details", new f().b(cJRHotelSearchInput.getRooms()));
        jSONObject2.put("paytm_id", sRPDataItem.getPaytmId());
        jSONObject2.put("check_in_date", cJRHotelSearchInput.getCheckInDate());
        com.paytm.network.a l = new b().a((Context) this.f28595c).a(a.b.SILENT).c("8").a(a.c.HOTELS).a(a.C0715a.POST).a(buildUpon.build().toString()).h().a((Map<String, String>) hashMap).b((Map) null).b(jSONObject2.toString()).a((IJRPaytmDataModel) new HotelDetails()).a((com.paytm.network.listener.b) new C0496a()).a(true).l();
        k.a((Object) l, "networking");
        l.a(true);
        l.a();
    }

    /* renamed from: net.one97.paytm.hotel4.service.a.a$a  reason: collision with other inner class name */
    public final class C0496a implements com.paytm.network.listener.b {
        public C0496a() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y<HotelDetails> yVar = a.this.f28593a;
            if (yVar == null) {
                k.a("sucessListener");
            }
            if (!(iJRPaytmDataModel instanceof HotelDetails)) {
                iJRPaytmDataModel = null;
            }
            yVar.postValue((HotelDetails) iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String str = null;
            Integer valueOf = networkCustomError != null ? Integer.valueOf(networkCustomError.getStatusCode()) : null;
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getAlertMessage();
            }
            ErrorData errorData = new ErrorData(valueOf, alertTitle, str);
            y<ErrorData> yVar = a.this.f28594b;
            if (yVar == null) {
                k.a("failureListener");
            }
            yVar.postValue(errorData);
        }
    }
}
