package net.one97.paytm.auth.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.offline.OfflineLeadOTPModel;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends AsyncTask<Void, Void, Void> implements b {

    /* renamed from: a  reason: collision with root package name */
    boolean f49107a;

    /* renamed from: b  reason: collision with root package name */
    private String f49108b = a.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f49109c;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface) {
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    public a(Context context) {
        this.f49109c = context;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof OfflineLeadOTPModel) {
            OfflineLeadOTPModel offlineLeadOTPModel = (OfflineLeadOTPModel) iJRPaytmDataModel;
            if (offlineLeadOTPModel.status.equalsIgnoreCase("success")) {
                WalletSharedPrefs.INSTANCE.storeOfflineCounterCachedTime(this.f49109c, System.currentTimeMillis());
                WalletSharedPrefs.INSTANCE.storeUserDeviceMap(this.f49109c, offlineLeadOTPModel.ud_map);
                WalletSharedPrefs.INSTANCE.storeCGCPHeader(this.f49109c, offlineLeadOTPModel.cgcp_offline_header);
                if (offlineLeadOTPModel.otp_config != null) {
                    WalletSharedPrefs.INSTANCE.storeServerTime(this.f49109c, offlineLeadOTPModel.otp_config.epoch_time);
                    WalletSharedPrefs.INSTANCE.storeOfflineTimeCounter(this.f49109c, (long) offlineLeadOTPModel.otp_config.time_interval);
                }
            }
            if (!this.f49107a) {
                b();
            }
        } else if (iJRPaytmDataModel instanceof CJRShoppingCart) {
            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
            if (cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null) {
                t.b(this.f49109c, "0");
                t.a(this.f49109c, 0);
            } else {
                t.b(this.f49109c, cJRShoppingCart.getCart().getFinalPrice());
                t.a(this.f49109c, cJRShoppingCart.getCart().getCartItems().size());
                t.a(this.f49109c, cJRShoppingCart.getCart().getmCartId());
                new StringBuilder("cart id ").append(cJRShoppingCart.getCart().getmCartId());
                com.paytm.utility.a.c();
                d.a().a(cJRShoppingCart);
            }
            c();
        } else if (iJRPaytmDataModel instanceof KYCStatusV2) {
            KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
            j.a(this.f49109c.getApplicationContext(), kYCStatusV2.getIsKycDone());
            j.a(this.f49109c.getApplicationContext(), kYCStatusV2.isMinKycStatus());
            j.b(this.f49109c.getApplicationContext(), kYCStatusV2.isMinKycEligible());
            if (!TextUtils.isEmpty(kYCStatusV2.getKycType())) {
                j.c(this.f49109c.getApplicationContext(), kYCStatusV2.getKycType());
            }
            if (kYCStatusV2.isKycExpired() == 0 || kYCStatusV2.isKycExpired() == 1) {
                j.b(this.f49109c.getApplicationContext(), kYCStatusV2.isKycExpired());
            } else {
                j.b(this.f49109c.getApplicationContext(), 0);
            }
            if (!TextUtils.isEmpty(kYCStatusV2.getKycExpiryTime())) {
                j.d(this.f49109c.getApplicationContext(), com.paytm.utility.b.h(kYCStatusV2.getKycExpiryTime(), "dd/MM/yyyy", "dd MMM yyyy"));
            }
            if (!TextUtils.isEmpty(kYCStatusV2.getIsMinor())) {
                j.e(this.f49109c.getApplicationContext(), kYCStatusV2.getIsMinor());
            }
            j.c(this.f49109c.getApplicationContext(), kYCStatusV2.isAadharVerified());
        }
    }

    private void a(com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f49109c);
        builder.setTitle(this.f49109c.getResources().getString(R.string.no_connection));
        builder.setMessage(this.f49109c.getResources().getString(R.string.no_internet));
        builder.setNegativeButton(this.f49109c.getString(R.string.dismiss), $$Lambda$a$2odkRqgwH3oiuX4BAuwMRp7MNdA.INSTANCE);
        builder.setPositiveButton(this.f49109c.getResources().getString(R.string.network_try_again), new DialogInterface.OnClickListener(aVar) {
            private final /* synthetic */ a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                a.this.a(this.f$1, dialogInterface, i2);
            }
        });
        if (Build.VERSION.SDK_INT >= 17) {
            builder.setOnDismissListener($$Lambda$a$rjzXgwN7xfF5EPEQCKOwCSs7s.INSTANCE);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.paytm.network.a aVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (com.paytm.utility.a.m(this.f49109c)) {
            aVar.a();
        } else {
            a(aVar);
        }
    }

    private void b() {
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), this.f49109c);
        String g2 = t.g(this.f49109c);
        c.a();
        String a3 = c.a("cartv2", (String) null);
        t.b(this.f49109c);
        String a4 = com.paytm.utility.c.a(this.f49109c, false);
        if (g2 != null) {
            a3 = a3 + "/" + g2;
        }
        String str = a3 + a4;
        if (com.paytm.utility.a.m(this.f49109c)) {
            d.a(this.f49109c, str, this, a2, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRShoppingCart(), a.c.AUTH, a.b.SILENT).a();
        }
    }

    private void c() {
        if (t.a() != null) {
            c.a();
            String a2 = c.a("cartv2", (String) null);
            String g2 = t.g(this.f49109c);
            if (g2 != null) {
                String str = a2 + "/" + g2;
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, this.f49109c);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", "applypromo");
                    JSONObject jSONObject2 = new JSONObject();
                    Map<String, String> a4 = t.a();
                    if (a4 != null) {
                        for (Map.Entry next : a4.entrySet()) {
                            jSONObject2.put((String) next.getKey(), next.getValue());
                        }
                    }
                    jSONObject.put("item_map", jSONObject2);
                } catch (JSONException e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                }
                d.a(this.f49109c, str, new b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        com.paytm.utility.a.c();
                        CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
                        if ((cJRShoppingCart == null || !cJRShoppingCart.getStatus().getResult().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) && cJRShoppingCart != null && cJRShoppingCart.getCart() != null && cJRShoppingCart.getCart().getPromoStatus().equalsIgnoreCase("success")) {
                            if (cJRShoppingCart.getCart().getCartItems() != null && cJRShoppingCart.getCart().getCartItems().size() > 0) {
                                t.a(a.this.f49109c, cJRShoppingCart.getCart().getCartItems().size());
                                t.b(a.this.f49109c, cJRShoppingCart.getCart().getFinalPrice());
                            }
                            t.h(a.this.f49109c);
                            t.b();
                            t.a(false);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertTitle()) && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                            t.a(true);
                        }
                        t.b();
                    }
                }, a3, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRShoppingCart(), a.c.AUTH, a.b.SILENT).a();
            }
        }
    }

    private Void a() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("session_token", t.c(this.f49109c));
            hashMap.put("version", "2");
            c.a();
            com.paytm.network.a a2 = d.a(this.f49109c, com.paytm.utility.b.e(this.f49109c, c.a("offlineConfig", (String) null)), this, hashMap, (Map<String, String>) null, a.C0715a.POST, "", new OfflineLeadOTPModel(), a.c.AUTH, a.b.SILENT);
            if (com.paytm.utility.a.m(this.f49109c)) {
                a2.a();
            } else {
                a(a2);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        if (!this.f49107a) {
            b();
        }
        c.a();
        String a3 = c.a("min_kyc_status_v3_url", (String) null);
        if (URLUtil.isValidUrl(a3)) {
            String e3 = com.paytm.utility.b.e(this.f49109c.getApplicationContext(), a3);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("session_token", t.b(this.f49109c.getApplicationContext()));
            KYCStatusV2 kYCStatusV2 = new KYCStatusV2();
            if (com.paytm.utility.a.m(this.f49109c.getApplicationContext())) {
                d.a(this.f49109c, e3, this, hashMap2, (Map<String, String>) null, a.C0715a.GET, (String) null, kYCStatusV2, a.c.AUTH, a.b.SILENT).a();
            }
        }
        return null;
    }
}
