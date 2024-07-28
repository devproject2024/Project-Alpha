package com.travel.train.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRCountryCodeList;
import com.travel.train.model.trainticket.CJRCountryList;
import com.travel.train.model.trainticket.CJRIRCTCUserAvailability;
import com.travel.train.model.trainticket.CJRIRCTCUserRegister;
import com.travel.train.model.trainticket.CJRPincodeResponse;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f27512a;

    /* renamed from: b  reason: collision with root package name */
    private String f27513b = "CJRIRCTCRegistrationUtil";

    /* renamed from: c  reason: collision with root package name */
    private a f27514c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27515d = false;

    public interface a {
        void a();

        void a(CJRCountryCodeList cJRCountryCodeList);

        void a(CJRCountryList cJRCountryList);

        void a(CJRIRCTCUserAvailability cJRIRCTCUserAvailability);

        void a(CJRIRCTCUserRegister cJRIRCTCUserRegister);

        void a(CJRPincodeResponse cJRPincodeResponse);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRPincodeResponse) {
            CJRPincodeResponse cJRPincodeResponse = (CJRPincodeResponse) iJRPaytmDataModel;
            a aVar = this.f27514c;
            if (aVar != null) {
                aVar.a(cJRPincodeResponse);
            }
        } else if (iJRPaytmDataModel instanceof CJRCountryList) {
            CJRCountryList cJRCountryList = (CJRCountryList) iJRPaytmDataModel;
            a aVar2 = this.f27514c;
            if (aVar2 != null) {
                aVar2.a(cJRCountryList);
            }
        } else if (iJRPaytmDataModel instanceof CJRIRCTCUserRegister) {
            CJRIRCTCUserRegister cJRIRCTCUserRegister = (CJRIRCTCUserRegister) iJRPaytmDataModel;
            a aVar3 = this.f27514c;
            if (aVar3 != null) {
                aVar3.a(cJRIRCTCUserRegister);
            }
        } else if (iJRPaytmDataModel instanceof CJRIRCTCUserAvailability) {
            CJRIRCTCUserAvailability cJRIRCTCUserAvailability = (CJRIRCTCUserAvailability) iJRPaytmDataModel;
            a aVar4 = this.f27514c;
            if (aVar4 != null) {
                aVar4.a(cJRIRCTCUserAvailability);
            }
        } else if (iJRPaytmDataModel instanceof CJRCountryCodeList) {
            CJRCountryCodeList cJRCountryCodeList = (CJRCountryCodeList) iJRPaytmDataModel;
            a aVar5 = this.f27514c;
            if (aVar5 != null) {
                aVar5.a(cJRCountryCodeList);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            if (this.f27514c != null) {
                this.f27514c.a((CJRIRCTCUserRegister) null);
                this.f27514c.a((CJRPincodeResponse) null);
            }
            com.travel.train.model.a aVar = new com.travel.train.model.a();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (networkResponse.data != null) {
                    try {
                        aVar = (com.travel.train.model.a) new f().a(new String(networkResponse.data), aVar.getClass());
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            if (i2 != 401) {
                if (i2 != 410) {
                    if (!(i2 == 449 || i2 == 499 || i2 == 502 || i2 == 503)) {
                        if (i2 != 504) {
                            if (aVar == null || aVar.getStatus() == null || aVar.getStatus().getMessage() == null || TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) || TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                                if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                    if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                        com.travel.train.b.a();
                                        if (!com.travel.train.b.b().a(f27512a, (Exception) networkCustomError, "error.trains@paytm.com")) {
                                            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                                Context context = f27512a;
                                                com.paytm.utility.b.b(context, context.getResources().getString(R.string.network_error_heading), f27512a.getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                                return;
                                            }
                                            com.paytm.utility.b.b(f27512a, f27512a.getResources().getString(R.string.error_data_display), f27512a.getResources().getString(R.string.trains_message_error_data_display));
                                            return;
                                        }
                                    }
                                    String string = f27512a.getResources().getString(R.string.network_error_message_train);
                                    Context context2 = f27512a;
                                    com.paytm.utility.b.b(context2, context2.getResources().getString(R.string.network_error_heading), string);
                                    return;
                                }
                                com.paytm.utility.b.b(f27512a, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                return;
                            } else if (!this.f27515d) {
                                com.paytm.utility.b.b(f27512a, aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                                return;
                            } else {
                                this.f27514c.a();
                                return;
                            }
                        }
                    }
                    com.paytm.utility.b.b(f27512a, networkCustomError.getMessage(), networkCustomError.getMessage());
                    return;
                }
            }
            com.travel.train.b.a();
            com.travel.train.b.b().a((Activity) f27512a, networkCustomError);
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public c(Context context, a aVar) {
        f27512a = context;
        this.f27514c = aVar;
    }

    public c(Context context, a aVar, byte b2) {
        f27512a = context;
        this.f27514c = aVar;
        this.f27515d = true;
    }

    public final void a(String str) {
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().X());
        sb.append("?pin=");
        sb.append(str);
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            String b2 = o.b(f27512a, com.paytm.utility.b.s(f27512a, sb2));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = f27512a;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = n.b(f27512a);
            bVar.f42885i = new CJRPincodeResponse();
            bVar.j = this;
            com.paytm.network.a l = bVar.l();
            l.f42859c = false;
            if (com.paytm.utility.b.c(f27512a)) {
                l.a();
            } else {
                a(l);
            }
        } else {
            Context context = f27512a;
            com.paytm.utility.b.b(context, context.getString(R.string.error), f27512a.getString(R.string.msg_invalid_url_train));
        }
    }

    public final void a(final com.paytm.network.a aVar) {
        Context context = f27512a;
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(f27512a.getString(R.string.no_connection));
            builder.setMessage(f27512a.getString(R.string.no_internet_train));
            builder.setPositiveButton(f27512a.getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    if (com.paytm.utility.b.c(c.f27512a)) {
                        aVar.a();
                    } else {
                        c.this.a(aVar);
                    }
                }
            });
            builder.show();
        }
    }

    public final void a(String str, String str2) {
        com.travel.train.b.a();
        String aa = com.travel.train.b.b().aa();
        if (URLUtil.isValidUrl(aa)) {
            Uri.Builder buildUpon = Uri.parse(o.b(f27512a, com.paytm.utility.b.s(f27512a, aa))).buildUpon();
            buildUpon.appendQueryParameter(str, str2);
            String builder = buildUpon.toString();
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = f27512a;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = builder;
            bVar.f42882f = n.b(f27512a);
            bVar.f42885i = new CJRIRCTCUserAvailability();
            bVar.j = this;
            com.paytm.network.a l = bVar.l();
            l.f42859c = false;
            if (com.paytm.utility.b.c(f27512a)) {
                l.a();
            } else {
                a(l);
            }
        } else {
            Context context = f27512a;
            com.paytm.utility.b.b(context, context.getString(R.string.error), f27512a.getString(R.string.msg_invalid_url_train));
        }
    }
}
