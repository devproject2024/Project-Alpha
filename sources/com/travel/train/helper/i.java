package com.travel.train.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.gsonhtcfix.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.g;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.travellerProfile.a.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public g f27313a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchInput f27314b;

    /* renamed from: c  reason: collision with root package name */
    public String f27315c = "CJRTrainPassengerDetailsPresenter";

    /* renamed from: d  reason: collision with root package name */
    private String f27316d = "";

    public i(g gVar, CJRTrainSearchInput cJRTrainSearchInput) {
        this.f27313a = gVar;
        this.f27314b = cJRTrainSearchInput;
    }

    public final void a() {
        a.a();
        a.a((Context) this.f27313a.e(), com.travel.train.travellerProfile.travel.a.train, (b) this);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27313a.a(iJRPaytmDataModel);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27313a.removeProgressDialog();
        try {
            if (this.f27313a.e() == null || !this.f27313a.e().isFinishing()) {
                String fullUrl = networkCustomError.getFullUrl();
                com.travel.train.b.a();
                if (!fullUrl.contains(com.travel.train.b.b().k())) {
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
                    o.a("train_traveller_details", (aVar == null || aVar.getError() == null) ? networkCustomError.getMessage() : aVar.getError(), "errors", "/trains/traveller-details", this.f27313a.e());
                    if (i2 != 401) {
                        if (i2 != 410) {
                            if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                                String str = aVar.getStatus().getMessage().f27693b;
                                String str2 = aVar.getStatus().getMessage().f27692a;
                                if (this.f27313a.e() == null) {
                                    return;
                                }
                                if (!this.f27313a.e().isFinishing()) {
                                    final h hVar = new h(this.f27313a.e());
                                    hVar.setTitle(str);
                                    hVar.setCancelable(false);
                                    hVar.a(str2);
                                    hVar.a(-3, this.f27313a.e().getString(R.string.ok), new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            hVar.cancel();
                                        }
                                    });
                                    hVar.setOnKeyListener(new DialogInterface.OnKeyListener() {
                                        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                                            if (i2 != 4) {
                                                return true;
                                            }
                                            dialogInterface.cancel();
                                            return true;
                                        }
                                    });
                                    hVar.show();
                                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                                    Window window = hVar.getWindow();
                                    layoutParams.copyFrom(window.getAttributes());
                                    layoutParams.width = -1;
                                    layoutParams.height = -2;
                                    window.setAttributes(layoutParams);
                                    return;
                                }
                                return;
                            } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                    com.travel.train.b.a();
                                    if (!com.travel.train.b.b().a((Context) this.f27313a.e(), (Exception) networkCustomError, "error.trains@paytm.com")) {
                                        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                            com.paytm.utility.b.b((Context) this.f27313a.e(), this.f27313a.e().getResources().getString(R.string.network_error_heading), this.f27313a.e().getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                            return;
                                        }
                                        com.paytm.utility.b.b((Context) this.f27313a.e(), this.f27313a.e().getResources().getString(R.string.error_data_display), this.f27313a.e().getResources().getString(R.string.trains_message_error_data_display));
                                        return;
                                    }
                                }
                                com.paytm.utility.b.b((Context) this.f27313a.e(), this.f27313a.e().getResources().getString(R.string.network_error_heading), this.f27313a.e().getResources().getString(R.string.network_error_message_train));
                                return;
                            } else {
                                com.paytm.utility.b.b((Context) this.f27313a.e(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                return;
                            }
                        }
                    }
                    this.f27313a.showSessionTimeoutAlert(networkCustomError);
                }
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public final String b() {
        return com.paytm.utility.b.n((Context) this.f27313a.e()) != null ? com.paytm.utility.b.n((Context) this.f27313a.e()) : "";
    }

    public static String a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, int i2, Boolean bool) {
        if (cJRTrainSearchResultsTrain.getMSearchedTrainDepartureTime() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                long time = simpleDateFormat.parse(cJRTrainSearchResultsTrain.getMSearchedTrainDepartureTime()).getTime();
                if (i2 > 0) {
                    time += (long) (i2 * 24 * 60 * 60 * 1000);
                }
                if (bool.booleanValue()) {
                    return com.travel.train.j.i.a(simpleDateFormat.format(new Date(time)), "dd MMM yyyy");
                }
                return com.travel.train.j.i.a(simpleDateFormat.format(new Date(time)), "EEE dd MMM");
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    public final void a(String str, String str2, HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            try {
                hashMap = new HashMap<>();
            } catch (Exception e2) {
                q.c(e2.getMessage());
                return;
            }
        }
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("train_user_id", str2);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.u);
        com.travel.train.b.a();
        com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) this.f27313a.e());
    }

    public final void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this.f27313a.e()) != null ? com.paytm.utility.b.n((Context) this.f27313a.e()) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/traveller-details");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) this.f27313a.e());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(CJRTrainSearchInput cJRTrainSearchInput, CJRTrainGstDetails cJRTrainGstDetails) {
        cJRTrainSearchInput.setmGSTINNumber(cJRTrainGstDetails.getGstIn());
        cJRTrainSearchInput.setmGSTName(cJRTrainGstDetails.getNameOnGst());
        cJRTrainSearchInput.setmGSTFlat(cJRTrainGstDetails.getFlat());
        cJRTrainSearchInput.setmGSTStreet(cJRTrainGstDetails.getStreet());
        cJRTrainSearchInput.setmGSTPinCode(cJRTrainGstDetails.getPin());
        cJRTrainSearchInput.setmGSTState(cJRTrainGstDetails.getState());
        cJRTrainSearchInput.setmGSTCity(cJRTrainGstDetails.getCity());
    }

    public static void a(CJRTrainSearchInput cJRTrainSearchInput) {
        cJRTrainSearchInput.setmGSTINNumber("");
        cJRTrainSearchInput.setmGSTName("");
        cJRTrainSearchInput.setmGSTFlat("");
        cJRTrainSearchInput.setmGSTStreet("");
        cJRTrainSearchInput.setmGSTPinCode("");
        cJRTrainSearchInput.setmGSTState("");
        cJRTrainSearchInput.setmGSTCity("");
    }
}
