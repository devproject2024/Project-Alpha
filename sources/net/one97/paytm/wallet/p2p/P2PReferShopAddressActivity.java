package net.one97.paytm.wallet.p2p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import net.one97.paytm.common.entity.wallet.universalp2p.P2PreferShopResponse;
import net.one97.paytm.common.entity.wallet.universalp2p.PinCodeInfoResponse;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class P2PReferShopAddressActivity extends P2PAppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f71520a = P2PReferShopAddressActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private String f71521b;

    /* renamed from: c  reason: collision with root package name */
    private String f71522c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f71523e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f71524f;

    /* renamed from: g  reason: collision with root package name */
    private AppCompatEditText f71525g;

    /* renamed from: h  reason: collision with root package name */
    private AppCompatEditText f71526h;

    /* renamed from: i  reason: collision with root package name */
    private AppCompatEditText f71527i;
    private AppCompatEditText j;
    private AppCompatEditText k;
    private AppCompatEditText l;
    private AppCompatEditText m;
    /* access modifiers changed from: private */
    public TextInputLayout n;
    /* access modifiers changed from: private */
    public TextInputLayout o;
    /* access modifiers changed from: private */
    public TextInputLayout p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    /* access modifiers changed from: private */
    public TextInputLayout r;
    /* access modifiers changed from: private */
    public TextInputLayout s;
    /* access modifiers changed from: private */
    public TextInputLayout t;
    private TextWatcher u = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            P2PReferShopAddressActivity.this.n.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.o.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.p.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.q.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.r.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.s.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.t.setError((CharSequence) null);
        }
    };
    private TextWatcher v = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = P2PReferShopAddressActivity.this.f71524f = false;
            P2PReferShopAddressActivity.this.n.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.o.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.p.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.q.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.r.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.s.setError((CharSequence) null);
            P2PReferShopAddressActivity.this.t.setError((CharSequence) null);
            String trim = charSequence.toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() == 6) {
                P2PReferShopAddressActivity.a(P2PReferShopAddressActivity.this, trim);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_refer_shop_address);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.f71521b = getIntent().getStringExtra("NUMBER");
        this.f71522c = getIntent().getStringExtra("NAME");
        this.f71525g = (AppCompatEditText) findViewById(R.id.shopkeeper_number_et);
        this.f71526h = (AppCompatEditText) findViewById(R.id.shop_name_et);
        this.f71527i = (AppCompatEditText) findViewById(R.id.address_line_one_et);
        this.j = (AppCompatEditText) findViewById(R.id.address_line_two_et);
        this.k = (AppCompatEditText) findViewById(R.id.pin_code_et);
        this.l = (AppCompatEditText) findViewById(R.id.city_et);
        this.m = (AppCompatEditText) findViewById(R.id.state_et);
        this.n = (TextInputLayout) findViewById(R.id.shopkeeper_number_til);
        this.o = (TextInputLayout) findViewById(R.id.shop_name_til);
        this.p = (TextInputLayout) findViewById(R.id.address_line_one_til);
        this.q = (TextInputLayout) findViewById(R.id.address_line_two_til);
        this.r = (TextInputLayout) findViewById(R.id.pin_code_til);
        this.s = (TextInputLayout) findViewById(R.id.city_til);
        this.t = (TextInputLayout) findViewById(R.id.state_til);
        findViewById(R.id.proceed_btn).setOnClickListener(this);
        findViewById(R.id.p2p_back_arrow_iv).setOnClickListener(this);
        this.f71525g.addTextChangedListener(this.u);
        this.f71526h.addTextChangedListener(this.u);
        this.f71527i.addTextChangedListener(this.u);
        this.j.addTextChangedListener(this.u);
        this.k.addTextChangedListener(this.v);
        this.l.addTextChangedListener(this.u);
        this.m.addTextChangedListener(this.u);
        if (!TextUtils.isEmpty(this.f71521b)) {
            this.f71525g.setText(this.f71521b);
        }
        if (!TextUtils.isEmpty(this.f71522c)) {
            this.f71526h.setText(this.f71522c);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.p2p_back_arrow_iv) {
            finish();
        } else if (id == R.id.proceed_btn) {
            boolean z = false;
            if (!com.paytm.utility.b.b(this.f71525g.getText().toString().trim())) {
                this.n.setError(getResources().getString(R.string.enter_valid_mobile_number));
            } else if (com.paytm.utility.b.l((Context) this) != null && com.paytm.utility.b.l((Context) this).equalsIgnoreCase(this.f71525g.getText().toString().trim())) {
                this.n.setError(getResources().getString(R.string.accept_payment_own_mobile_error));
            } else if (TextUtils.isEmpty(this.f71527i.getText().toString().trim())) {
                this.p.setError(getResources().getString(R.string.refer_address));
            } else if (TextUtils.isEmpty(this.k.getText().toString().trim())) {
                this.r.setError(getResources().getString(R.string.refer_pin_code_message));
            } else if (!this.f71524f) {
                this.r.setError(getResources().getString(R.string.refer_pin_code_valid_message));
            } else if (TextUtils.isEmpty(this.l.getText().toString().trim())) {
                this.s.setError(getResources().getString(R.string.refer_city_message));
            } else if (TextUtils.isEmpty(this.m.getText().toString().trim())) {
                this.t.setError(getResources().getString(R.string.refer_state_message));
            } else {
                z = true;
            }
            if (z) {
                final String trim = this.f71526h.getText().toString().trim();
                final String trim2 = this.f71525g.getText().toString().trim();
                String trim3 = this.f71527i.getText().toString().trim();
                String trim4 = this.j.getText().toString().trim();
                String trim5 = this.k.getText().toString().trim();
                String trim6 = this.l.getText().toString().trim();
                String trim7 = this.m.getText().toString().trim();
                if (!TextUtils.isEmpty(trim4)) {
                    this.f71523e = trim3 + " " + trim4 + " " + trim6 + ", " + trim7 + ", " + trim5;
                } else {
                    this.f71523e = trim3 + " " + trim6 + ", " + trim7 + ", " + trim5;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_LINE1, trim3);
                    jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_LINE2, trim4);
                    jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, trim5);
                    jSONObject.put("city", trim6);
                    jSONObject.put("state", trim7);
                } catch (JSONException unused) {
                }
                if (!com.paytm.utility.b.c((Context) this)) {
                    try {
                        if (!isFinishing()) {
                            final h hVar = new h(this);
                            hVar.setTitle(getResources().getString(R.string.no_connection));
                            hVar.a(getResources().getString(R.string.no_internet));
                            hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                                public final void onClick(View view) {
                                    hVar.cancel();
                                }
                            });
                            hVar.setCancelable(true);
                            hVar.show();
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                } else {
                    a(true);
                    net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((Activity) this).a(new b.e() {
                        public final void a(Object obj) {
                            P2PReferShopAddressActivity.this.a(false);
                            if (obj instanceof P2PreferShopResponse) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("event_category", "refer_shopkeeper_detail");
                                hashMap.put("event_action", "refer_shopkeeper_detail_success");
                                hashMap.put("user_id", com.paytm.utility.b.n((Context) P2PReferShopAddressActivity.this));
                                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
                                hashMap.put("VERTICAL_NAME", "refer_shopkeeper");
                                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(P2PReferShopAddressActivity.this, GAUtil.CUSTOM_EVENT, hashMap);
                                Intent intent = new Intent(P2PReferShopAddressActivity.this, P2PReferShopSuccessActivity.class);
                                intent.putExtra("merchantName", trim);
                                intent.putExtra("merchantMobileNumber", trim2);
                                if (!TextUtils.isEmpty(P2PReferShopAddressActivity.this.f71523e)) {
                                    intent.putExtra("merchant_address", P2PReferShopAddressActivity.this.f71523e);
                                }
                                P2PReferShopAddressActivity.this.startActivity(intent);
                                P2PReferShopAddressActivity.this.finish();
                            }
                        }

                        public final void a(NetworkCustomError networkCustomError) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("event_category", "refer_shopkeeper_detail");
                            hashMap.put("event_action", "refer_shopkeeper_detail_fail");
                            hashMap.put("user_id", com.paytm.utility.b.n((Context) P2PReferShopAddressActivity.this));
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
                            hashMap.put("VERTICAL_NAME", "refer_shopkeeper");
                            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(P2PReferShopAddressActivity.this, GAUtil.CUSTOM_EVENT, hashMap);
                            P2PReferShopAddressActivity.this.a(false);
                            P2PReferShopAddressActivity p2PReferShopAddressActivity = P2PReferShopAddressActivity.this;
                            Toast.makeText(p2PReferShopAddressActivity, p2PReferShopAddressActivity.getResources().getString(R.string.some_went_wrong), 0).show();
                        }
                    }, trim2, trim, jSONObject);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, f fVar) {
        f fVar2 = fVar;
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            PinCodeInfoResponse pinCodeInfoResponse = (PinCodeInfoResponse) fVar2.f55797b;
            if (pinCodeInfoResponse == null) {
                return;
            }
            if ("200".equalsIgnoreCase(pinCodeInfoResponse.getResponseCode())) {
                this.f71524f = true;
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "refer_shopkeeper_detail");
                hashMap.put("event_action", "action");
                hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
                hashMap.put("VERTICAL_NAME", "refer_shopkeeper");
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
                try {
                    JSONArray jSONArray = pinCodeInfoResponse.getAddressDictionary().getJSONArray(str);
                    if (jSONArray != null) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        String string = jSONObject.getString("state");
                        this.l.setText(jSONObject.getString("tier3Value"));
                        this.m.setText(string);
                    }
                } catch (JSONException e2) {
                    q.d(String.valueOf(e2));
                }
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event_category", "refer_shopkeeper_detail");
                hashMap2.put("event_action", "action");
                hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
                hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
                hashMap2.put("VERTICAL_NAME", "refer_shopkeeper");
                hashMap2.put("event_label", "invalid_pin_code");
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap2);
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event_category", "refer_shopkeeper_detail");
            hashMap3.put("event_action", "action");
            hashMap3.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap3.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/refer-shopkeeper");
            hashMap3.put("VERTICAL_NAME", "refer_shopkeeper");
            hashMap3.put("event_label", "invalid_pin_code");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap3);
        }
    }

    static /* synthetic */ void a(P2PReferShopAddressActivity p2PReferShopAddressActivity, String str) {
        if (com.paytm.utility.b.c((Context) p2PReferShopAddressActivity)) {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(p2PReferShopAddressActivity, "obUadPincode");
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", a.q(p2PReferShopAddressActivity));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                jSONObject.put("pincodes", jSONArray);
                jSONObject.put("addressResponseType", "SECONDARY");
                jSONObject.put("tier3Type", "UNIQUE");
                jSONObject.put("secodaryType", "TIER3");
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", p2PReferShopAddressActivity.getClass().getSimpleName());
            new net.one97.paytm.network.b(stringFromGTM, new PinCodeInfoResponse(), hashMap2, hashMap, jSONObject.toString()).c().observeForever(new z(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    P2PReferShopAddressActivity.this.a(this.f$1, (f) obj);
                }
            });
        }
    }
}
