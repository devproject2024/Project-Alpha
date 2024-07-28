package net.one97.paytm.pushnotifcation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.notification.PaytmNotificationReceiver;
import com.paytm.notification.models.PushMessage;
import com.paytmmall.clpartifact.utils.SFInterface;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.notification.c;
import net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;

public class NotificationActionReceiver extends PaytmNotificationReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f59812a = NotificationActionReceiver.class.getName();

    public final void a(PushMessage pushMessage) {
    }

    public final void a(Context context, PushMessage pushMessage) {
        super.a(context, pushMessage);
        if (pushMessage.getBundle() != null) {
            String valueOf = String.valueOf(pushMessage.getBundle().get("url"));
            if (!TextUtils.isEmpty(valueOf) && valueOf.contains("featuretype=getpendingrequests")) {
                SFInterface.INSTANCE.notifySuccessTransaction("");
            }
        }
    }

    public final void b(Context context, PushMessage pushMessage) {
        new c().a(context.getApplicationContext(), new a(pushMessage));
    }

    public final void c(final Context context, PushMessage pushMessage) {
        if (pushMessage != null && pushMessage.getBundle() != null) {
            Bundle bundle = pushMessage.getBundle();
            if ("true".equalsIgnoreCase(bundle.getString("showConfirmationScreen"))) {
                ShowCodePushModel showCodePushModel = new ShowCodePushModel();
                showCodePushModel.setOrderId(bundle.getString("orderId"));
                showCodePushModel.setMerchantName(bundle.getString("merchantName"));
                showCodePushModel.setAmount(bundle.getString("amount"));
                showCodePushModel.setMerchantLogoUrl(bundle.getString("merchantLogoUrl"));
                showCodePushModel.setStatus(bundle.getString("status"));
                showCodePushModel.setTxnId(bundle.getString("txnId"));
                showCodePushModel.setTimeStamp(bundle.getString("timestamp"));
                Intent intent = new Intent("com.android.wallet.SILENT_PUSH_TOTP");
                intent.putExtra("TOTP_DATA", showCodePushModel);
                context.sendBroadcast(intent);
            }
            if ("true".equalsIgnoreCase(bundle.getString("refreshOauthContext"))) {
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.j.c.a();
                sb.append(net.one97.paytm.j.c.w());
                sb.append("?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE,password_status,kyc_state");
                d.a(context, sb.toString(), new b() {
                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    }

                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                            l.a((CJRUserInfoV2) iJRPaytmDataModel, context);
                            a.a(context).a(new Intent("net.one97.paytm.action.ACTION_REFRESH_PSA"));
                        }
                    }
                }, t.f(context), (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRUserInfoV2(), a.c.AUTH, a.b.SILENT).a();
            }
        }
    }
}
