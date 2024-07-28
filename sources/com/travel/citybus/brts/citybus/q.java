package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.brts.a;
import com.travel.citybus.brts.citybus.y;
import com.travel.citybus.brts.f;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggestResponseModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class q implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f23319a;

    /* renamed from: b  reason: collision with root package name */
    private final y.a f23320b;

    public q(y.a aVar) {
        k.c(aVar, "view");
        this.f23320b = aVar;
    }

    public final void a(String str, String str2, Context context) {
        String str3;
        k.c(str2, "productId");
        k.c(context, "context");
        boolean z = true;
        this.f23320b.a(true);
        this.f23319a = str;
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        String str4 = a.f23179g;
        k.a((Object) str4, "BRTSConstants.PRODUCT_ID");
        hashMap.put(str4, str2);
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusSuggestURL");
        if (TextUtils.isEmpty(a2)) {
            a2 = a.f23181i;
        }
        if (!TextUtils.isEmpty(a2)) {
            if (str != null) {
                if (str.length() <= 0) {
                    z = false;
                }
                if (z) {
                    str3 = a2 + '/' + str;
                    Uri.Builder buildUpon = Uri.parse(str3).buildUpon();
                    buildUpon.appendQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, "10");
                    com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.c.TRANSPORT_BRTS).a(a.b.SILENT).c(q.class.getSimpleName()).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CJRCityAutoSuggestResponseModel()).a((b) this).l();
                    l.b(false);
                    l.a();
                }
            }
            str3 = a2 + "/ ";
            Uri.Builder buildUpon2 = Uri.parse(str3).buildUpon();
            buildUpon2.appendQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, "10");
            com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.c.TRANSPORT_BRTS).a(a.b.SILENT).c(q.class.getSimpleName()).a(a.C0715a.GET).a(buildUpon2.build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CJRCityAutoSuggestResponseModel()).a((b) this).l();
            l2.b(false);
            l2.a();
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            this.f23320b.a(false);
            y.a aVar = this.f23320b;
            String alertTitle = networkCustomError.getAlertTitle();
            k.a((Object) alertTitle, "networkError.alertTitle");
            String alertMessage = networkCustomError.getAlertMessage();
            k.a((Object) alertMessage, "networkError.alertMessage");
            aVar.a(alertTitle, alertMessage);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z = false;
        this.f23320b.a(false);
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRCityAutoSuggestResponseModel)) {
            this.f23320b.a(false);
            List<CJRCityAutoSuggest> list = ((CJRCityAutoSuggestResponseModel) iJRPaytmDataModel).getResponse().getList();
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (!z) {
                this.f23320b.a(list);
            } else {
                this.f23320b.a();
            }
        }
    }
}
