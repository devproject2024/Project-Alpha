package com.travel.train.f;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.model.ReferPromocodeScreenValidationModel;
import com.travel.train.model.ReferralValidationModel;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f26662a;

    /* renamed from: b  reason: collision with root package name */
    private ReferPromocodeScreenValidationModel f26663b;

    /* renamed from: c  reason: collision with root package name */
    private a f26664c;

    /* renamed from: d  reason: collision with root package name */
    private String f26665d;

    /* renamed from: e  reason: collision with root package name */
    private String f26666e;

    /* renamed from: f  reason: collision with root package name */
    private String f26667f;

    /* renamed from: g  reason: collision with root package name */
    private String f26668g = "CJRRefrlPromocodeScreenValidPresenter";

    public interface a {
        void a(boolean z, String str);
    }

    public c(Context context, a aVar, String str) {
        this.f26662a = context;
        this.f26665d = str;
        this.f26664c = aVar;
        com.travel.train.b.a();
        String s = com.travel.train.b.b().s();
        if (!TextUtils.isEmpty(s)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f26662a));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("referralcode", this.f26665d);
                jSONObject.put("userid", com.paytm.utility.b.n(this.f26662a));
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
            if (com.paytm.utility.b.c(this.f26662a)) {
                new ArrayList().add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
                com.paytm.network.a aVar2 = new com.paytm.network.a(this.f26662a, a.C0715a.POST, s, hashMap, jSONObject.toString(), new ReferPromocodeScreenValidationModel(), this);
                aVar2.f42860d = true;
                aVar2.a();
            }
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ReferPromocodeScreenValidationModel) {
            this.f26663b = (ReferPromocodeScreenValidationModel) iJRPaytmDataModel;
            ReferPromocodeScreenValidationModel referPromocodeScreenValidationModel = this.f26663b;
            if (referPromocodeScreenValidationModel != null) {
                if (referPromocodeScreenValidationModel.getMessage() != null) {
                    this.f26666e = this.f26663b.getMessage();
                }
                if (this.f26663b.getBody() != null) {
                    this.f26667f = this.f26663b.getBody();
                }
                String str = this.f26666e;
                if (str == null || !str.equalsIgnoreCase("Success")) {
                    this.f26664c.a(false, this.f26666e);
                } else {
                    this.f26664c.a(true, "");
                }
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (i2 == 503 && (iJRPaytmDataModel instanceof ReferralValidationModel)) {
            this.f26663b = (ReferPromocodeScreenValidationModel) iJRPaytmDataModel;
            ReferPromocodeScreenValidationModel referPromocodeScreenValidationModel = this.f26663b;
            if (referPromocodeScreenValidationModel != null && referPromocodeScreenValidationModel.getMessage() != null) {
                String message = this.f26663b.getMessage();
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f26662a);
                builder.setTitle(this.f26662a.getResources().getString(R.string.failure));
                builder.setMessage(message);
                builder.setPositiveButton(this.f26662a.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        }
    }
}
