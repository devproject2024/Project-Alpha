package net.one97.travelpass.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.travelpass.R;
import net.one97.travelpass.model.CJRErrorStatus;
import net.one97.travelpass.model.CJRMessageFormat;

public class f extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f30720a;

    public void a() {
        HashMap hashMap = this.f30720a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.b((Context) getActivity());
    }

    public int getTheme() {
        return R.style.TPBottomSheetDialogTheme;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void a(Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        net.one97.travelpass.model.a aVar = new net.one97.travelpass.model.a();
        String str = null;
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new com.google.gsonhtcfix.f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…cjrErrorFormat.javaClass)");
                    aVar = (net.one97.travelpass.model.a) a2;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if ((num != null && num.intValue() == 401) || ((num != null && num.intValue() == 410) || (num != null && num.intValue() == 403))) {
            a(networkCustomError);
        } else if ((num != null && num.intValue() == 449) || ((num != null && num.intValue() == 499) || ((num != null && num.intValue() == 502) || ((num != null && num.intValue() == 503) || (num != null && num.intValue() == 504))))) {
            Context context = getContext();
            String message = networkCustomError != null ? networkCustomError.getMessage() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getMessage();
            }
            b.b(context, message, str);
        } else {
            if (aVar.getStatus() != null) {
                CJRErrorStatus status = aVar.getStatus();
                k.a((Object) status, "cjrErrorFormat.status");
                if (status.getMessage() != null) {
                    CJRErrorStatus status2 = aVar.getStatus();
                    k.a((Object) status2, "cjrErrorFormat.status");
                    CJRMessageFormat message2 = status2.getMessage();
                    k.a((Object) message2, "cjrErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message2.getTitle())) {
                        CJRErrorStatus status3 = aVar.getStatus();
                        k.a((Object) status3, "cjrErrorFormat.status");
                        CJRMessageFormat message3 = status3.getMessage();
                        k.a((Object) message3, "cjrErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message3.getMessage())) {
                            Context context2 = getContext();
                            CJRErrorStatus status4 = aVar.getStatus();
                            k.a((Object) status4, "cjrErrorFormat.status");
                            CJRMessageFormat message4 = status4.getMessage();
                            k.a((Object) message4, "cjrErrorFormat.status.message");
                            String title = message4.getTitle();
                            CJRErrorStatus status5 = aVar.getStatus();
                            k.a((Object) status5, "cjrErrorFormat.status");
                            CJRMessageFormat message5 = status5.getMessage();
                            k.a((Object) message5, "cjrErrorFormat.status.message");
                            b.b(context2, title, message5.getMessage());
                            return;
                        }
                    }
                }
            }
            if ((networkCustomError != null ? networkCustomError.getAlertTitle() : null) == null || networkCustomError.getAlertMessage() == null) {
                if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getMessage() : null)) {
                    if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == NetworkCustomError.ErrorType.ParsingError) {
                        String string = getResources().getString(R.string.tp_message_error_data_display);
                        k.a((Object) string, "resources.getString(\n   …ssage_error_data_display)");
                        String string2 = getResources().getString(R.string.tp_error_data_display);
                        k.a((Object) string2, "resources.getString(\n   …ng.tp_error_data_display)");
                        b.b(getContext(), string2, string);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.tp_network_error_message));
                    sb.append(" ");
                    if (networkCustomError != null) {
                        str = networkCustomError.getUrl();
                    }
                    sb.append(str);
                    b.b(getContext(), getResources().getString(R.string.tp_network_error_heading), sb.toString());
                } else if (iJRPaytmDataModel != null) {
                    a(iJRPaytmDataModel);
                } else {
                    String string3 = getResources().getString(R.string.tp_network_error_message);
                    k.a((Object) string3, "resources.getString(R.st…tp_network_error_message)");
                    b.b(getContext(), getResources().getString(R.string.tp_network_error_heading), string3);
                }
            } else {
                b.b(getContext(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.paytm.network.model.IJRPaytmDataModel r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0072
            boolean r2 = r5 instanceof net.one97.travelpass.model.TravelPassCheckoutModel
            if (r2 == 0) goto L_0x0072
            net.one97.travelpass.model.TravelPassCheckoutModel r5 = (net.one97.travelpass.model.TravelPassCheckoutModel) r5
            net.one97.travelpass.model.TravelPassCheckoutModel$CartBody r2 = r5.getBody()
            r3 = 0
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.getError()
            goto L_0x0017
        L_0x0016:
            r2 = r3
        L_0x0017:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0024
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = 1
        L_0x0025:
            if (r2 != 0) goto L_0x0032
            net.one97.travelpass.model.TravelPassCheckoutModel$CartBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x0074
            java.lang.String r3 = r5.getError()
            goto L_0x0074
        L_0x0032:
            net.one97.travelpass.model.TravelPassCheckoutModel$CartBody r2 = r5.getBody()
            if (r2 == 0) goto L_0x003d
            java.lang.String r2 = r2.getMessage()
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x004b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r2 = 0
            goto L_0x004c
        L_0x004b:
            r2 = 1
        L_0x004c:
            if (r2 != 0) goto L_0x0059
            net.one97.travelpass.model.TravelPassCheckoutModel$CartBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x0074
            java.lang.String r3 = r5.getMessage()
            goto L_0x0074
        L_0x0059:
            java.lang.String r2 = r5.getMessage()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x006a
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r2 = 0
            goto L_0x006b
        L_0x006a:
            r2 = 1
        L_0x006b:
            if (r2 != 0) goto L_0x0072
            java.lang.String r3 = r5.getMessage()
            goto L_0x0074
        L_0x0072:
            java.lang.String r3 = ""
        L_0x0074:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x007f
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0080
        L_0x007f:
            r0 = 1
        L_0x0080:
            if (r0 != 0) goto L_0x0093
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r0 = r4.getResources()
            int r1 = net.one97.travelpass.R.string.travel_pass_error
            java.lang.String r0 = r0.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r0, (java.lang.String) r3)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.f.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private final void a(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !isDetached()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "this.activity!!");
            if (!activity.isFinishing()) {
                k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                net.one97.travelpass.d.b().a((Activity) getActivity(), (Exception) networkCustomError);
            }
        }
    }
}
