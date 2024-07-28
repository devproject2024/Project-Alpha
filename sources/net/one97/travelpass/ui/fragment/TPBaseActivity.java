package net.one97.travelpass.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.travelpass.R;
import net.one97.travelpass.model.CJRErrorStatus;
import net.one97.travelpass.model.CJRMessageFormat;
import net.one97.travelpass.model.a;

public class TPBaseActivity extends PaytmActivity {
    public final void a(Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a aVar = new a();
        String str = null;
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…cjrErrorFormat.javaClass)");
                    aVar = (a) a2;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if ((num != null && num.intValue() == 401) || ((num != null && num.intValue() == 410) || (num != null && num.intValue() == 403))) {
            a(networkCustomError);
        } else if ((num != null && num.intValue() == 449) || ((num != null && num.intValue() == 499) || ((num != null && num.intValue() == 502) || ((num != null && num.intValue() == 503) || (num != null && num.intValue() == 504))))) {
            Context context = this;
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getAlertMessage();
            }
            b.b(context, alertTitle, str);
        } else {
            if (aVar.getStatus() != null) {
                CJRErrorStatus status = aVar.getStatus();
                k.a((Object) status, "cjrErrorFormat.status");
                if (status.getMessage() != null) {
                    CJRErrorStatus status2 = aVar.getStatus();
                    k.a((Object) status2, "cjrErrorFormat.status");
                    CJRMessageFormat message = status2.getMessage();
                    k.a((Object) message, "cjrErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message.getTitle())) {
                        CJRErrorStatus status3 = aVar.getStatus();
                        k.a((Object) status3, "cjrErrorFormat.status");
                        CJRMessageFormat message2 = status3.getMessage();
                        k.a((Object) message2, "cjrErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message2.getMessage())) {
                            CJRErrorStatus status4 = aVar.getStatus();
                            k.a((Object) status4, "cjrErrorFormat.status");
                            CJRMessageFormat message3 = status4.getMessage();
                            k.a((Object) message3, "cjrErrorFormat.status.message");
                            String title = message3.getTitle();
                            CJRErrorStatus status5 = aVar.getStatus();
                            k.a((Object) status5, "cjrErrorFormat.status");
                            CJRMessageFormat message4 = status5.getMessage();
                            k.a((Object) message4, "cjrErrorFormat.status.message");
                            b.b((Context) this, title, message4.getMessage());
                            return;
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getMessage() : null)) {
                if (!((networkCustomError != null ? networkCustomError.getAlertTitle() : null) == null || networkCustomError.getAlertMessage() == null)) {
                    b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    return;
                }
            }
            if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getMessage() : null)) {
                if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == NetworkCustomError.ErrorType.ParsingError) {
                    String string = getResources().getString(R.string.tp_message_error_data_display);
                    k.a((Object) string, "resources.getString(\n   …ssage_error_data_display)");
                    String string2 = getResources().getString(R.string.tp_error_data_display);
                    k.a((Object) string2, "resources.getString(\n   …ng.tp_error_data_display)");
                    b.b((Context) this, string2, string);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(R.string.tp_network_error_message));
                sb.append(" ");
                if (networkCustomError != null) {
                    str = networkCustomError.getUrl();
                }
                sb.append(str);
                b.b((Context) this, getResources().getString(R.string.tp_network_error_heading), sb.toString());
            } else if (iJRPaytmDataModel != null) {
                a(iJRPaytmDataModel);
            } else {
                String string3 = getResources().getString(R.string.tp_network_error_message);
                k.a((Object) string3, "resources.getString(R.st…tp_network_error_message)");
                b.b((Context) this, getResources().getString(R.string.tp_network_error_heading), string3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.paytm.network.model.IJRPaytmDataModel r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0172
            boolean r0 = r6 instanceof net.one97.travelpass.model.TravelPass
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0077
            net.one97.travelpass.model.TravelPass r6 = (net.one97.travelpass.model.TravelPass) r6
            net.one97.travelpass.model.TravelPassData r0 = r6.getBody()
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getError()
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0026
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r0 = 0
            goto L_0x0027
        L_0x0026:
            r0 = 1
        L_0x0027:
            if (r0 != 0) goto L_0x0036
            net.one97.travelpass.model.TravelPassData r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
        L_0x0033:
            r4 = r3
            goto L_0x0154
        L_0x0036:
            net.one97.travelpass.model.TravelPassData r0 = r6.getBody()
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getMessage()
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x004f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r0 = 0
            goto L_0x0050
        L_0x004f:
            r0 = 1
        L_0x0050:
            if (r0 != 0) goto L_0x005d
            net.one97.travelpass.model.TravelPassData r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x005d:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x006e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r0 = 0
            goto L_0x006f
        L_0x006e:
            r0 = 1
        L_0x006f:
            if (r0 != 0) goto L_0x0154
            java.lang.String r4 = r6.getMessage()
            goto L_0x0154
        L_0x0077:
            boolean r0 = r6 instanceof net.one97.travelpass.model.MyPassesResponse
            if (r0 == 0) goto L_0x00e6
            net.one97.travelpass.model.MyPassesResponse r6 = (net.one97.travelpass.model.MyPassesResponse) r6
            net.one97.travelpass.model.MyPasses r0 = r6.getBody()
            if (r0 == 0) goto L_0x0088
            java.lang.String r0 = r0.getError()
            goto L_0x0089
        L_0x0088:
            r0 = r3
        L_0x0089:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0096
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            r0 = 0
            goto L_0x0097
        L_0x0096:
            r0 = 1
        L_0x0097:
            if (r0 != 0) goto L_0x00a4
            net.one97.travelpass.model.MyPasses r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
            goto L_0x0033
        L_0x00a4:
            net.one97.travelpass.model.MyPasses r0 = r6.getBody()
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getMessage()
            goto L_0x00b0
        L_0x00af:
            r0 = r3
        L_0x00b0:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00bd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00bb
            goto L_0x00bd
        L_0x00bb:
            r0 = 0
            goto L_0x00be
        L_0x00bd:
            r0 = 1
        L_0x00be:
            if (r0 != 0) goto L_0x00cc
            net.one97.travelpass.model.MyPasses r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x00cc:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00dd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00db
            goto L_0x00dd
        L_0x00db:
            r0 = 0
            goto L_0x00de
        L_0x00dd:
            r0 = 1
        L_0x00de:
            if (r0 != 0) goto L_0x0154
            java.lang.String r4 = r6.getMessage()
            goto L_0x0154
        L_0x00e6:
            boolean r0 = r6 instanceof net.one97.travelpass.ordersummary.model.OrderSummary
            if (r0 == 0) goto L_0x0154
            net.one97.travelpass.ordersummary.model.OrderSummary r6 = (net.one97.travelpass.ordersummary.model.OrderSummary) r6
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r6.getBody()
            if (r0 == 0) goto L_0x00f7
            java.lang.String r0 = r0.getError()
            goto L_0x00f8
        L_0x00f7:
            r0 = r3
        L_0x00f8:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0105
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r0 = 0
            goto L_0x0106
        L_0x0105:
            r0 = 1
        L_0x0106:
            if (r0 != 0) goto L_0x0114
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
            goto L_0x0033
        L_0x0114:
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r6.getBody()
            if (r0 == 0) goto L_0x011f
            java.lang.String r0 = r0.getMessage()
            goto L_0x0120
        L_0x011f:
            r0 = r3
        L_0x0120:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x012d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r0 = 0
            goto L_0x012e
        L_0x012d:
            r0 = 1
        L_0x012e:
            if (r0 != 0) goto L_0x013c
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x013c:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x014d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r0 = 0
            goto L_0x014e
        L_0x014d:
            r0 = 1
        L_0x014e:
            if (r0 != 0) goto L_0x0154
            java.lang.String r4 = r6.getMessage()
        L_0x0154:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x015f
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0160
        L_0x015f:
            r1 = 1
        L_0x0160:
            if (r1 != 0) goto L_0x0172
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            android.content.res.Resources r0 = r5.getResources()
            int r1 = net.one97.travelpass.R.string.travel_pass_error
            java.lang.String r0 = r0.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r0, (java.lang.String) r4)
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.TPBaseActivity.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private final void a(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
            net.one97.travelpass.d.b().a((Activity) this, (Exception) networkCustomError);
        }
    }
}
