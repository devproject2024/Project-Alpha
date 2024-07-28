package com.travel.bus.busticket.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.model.PincodeResponse;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;

public final class x implements b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f22478a;

    /* renamed from: b  reason: collision with root package name */
    private a f22479b;

    public interface a {
        void a(PincodeResponse pincodeResponse);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof PincodeResponse)) {
            PincodeResponse pincodeResponse = (PincodeResponse) iJRPaytmDataModel;
            a aVar = this.f22479b;
            if (aVar != null) {
                aVar.a(pincodeResponse);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            if (this.f22479b != null) {
                this.f22479b.a((PincodeResponse) null);
            }
            CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        cJRNewErrorFormat = (CJRNewErrorFormat) new f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (i2 != 401) {
                if (i2 != 410) {
                    if (!(i2 == 449 || i2 == 499 || i2 == 502 || i2 == 503)) {
                        if (i2 != 504) {
                            if (cJRNewErrorFormat != null && cJRNewErrorFormat.getStatus() != null && cJRNewErrorFormat.getStatus().getMessage() != null && !TextUtils.isEmpty(cJRNewErrorFormat.getStatus().getMessage().f22819b) && !TextUtils.isEmpty(cJRNewErrorFormat.getStatus().getMessage().f22820c)) {
                                com.paytm.utility.b.b(f22478a, cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c);
                                return;
                            } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                String string = f22478a.getResources().getString(R.string.network_error_message);
                                Context context = f22478a;
                                com.paytm.utility.b.b(context, context.getResources().getString(R.string.network_error_heading), string);
                                return;
                            } else {
                                com.paytm.utility.b.b(f22478a, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                return;
                            }
                        }
                    }
                    com.paytm.utility.b.b(f22478a, networkCustomError.getMessage(), networkCustomError.getMessage());
                    return;
                }
            }
            com.travel.bus.a.a();
            com.travel.bus.a.b().a((Activity) f22478a, networkCustomError);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public x(Context context, a aVar) {
        f22478a = context;
        this.f22479b = aVar;
    }

    public final void a(final com.paytm.network.a aVar) {
        Context context = f22478a;
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(f22478a.getString(R.string.no_connection));
            builder.setMessage(f22478a.getString(R.string.no_internet));
            builder.setPositiveButton(f22478a.getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    if (com.paytm.utility.b.c(x.f22478a)) {
                        aVar.a();
                    } else {
                        x.this.a(aVar);
                    }
                }
            });
            builder.show();
        }
    }
}
