package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.i;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.d.r;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycSlotPickerActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONObject;

public final class KycDoorStepActivity extends UpgradeKycBaseActivity implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f66107b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    boolean f66108a;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.c.e f66109d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.kycV3.b.a f66110e;

    /* renamed from: f  reason: collision with root package name */
    private final d f66111f = new d(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f66112g;

    public final View a(int i2) {
        if (this.f66112g == null) {
            this.f66112g = new HashMap();
        }
        View view = (View) this.f66112g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66112g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycDoorStepActivity f66113a;

        b(KycDoorStepActivity kycDoorStepActivity) {
            this.f66113a = kycDoorStepActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f66156a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66113a.a(R.id.wallet_loader));
                    List list = (List) bVar.f66169b;
                    if (list == null || !(!list.isEmpty())) {
                        KycDoorStepActivity.d(this.f66113a);
                        return;
                    }
                    a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
                    Context applicationContext = this.f66113a.getApplicationContext();
                    k.a((Object) applicationContext, "applicationContext");
                    net.one97.paytm.upgradeKyc.kycV3.b.a a2 = a.C1325a.a(applicationContext);
                    ResultType resulttype = bVar.f66169b;
                    if (resulttype == null) {
                        k.a();
                    }
                    List list2 = (List) resulttype;
                    k.c(list2, "list");
                    Collection collection = list2;
                    if (true ^ collection.isEmpty()) {
                        a2.f66164a.clear();
                        a2.f66164a.addAll(collection);
                    }
                    KycSlotPickerActivity.a aVar2 = KycSlotPickerActivity.f66132i;
                    KycDoorStepActivity kycDoorStepActivity = this.f66113a;
                    KycSlotPickerActivity.a.a(kycDoorStepActivity, false, kycDoorStepActivity.f66108a, false, 8);
                    this.f66113a.finish();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66113a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66113a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66113a.a(R.id.wallet_loader));
                        KycDoorStepActivity.d(this.f66113a);
                    }
                }
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<UADPincode>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycDoorStepActivity f66114a;

        c(KycDoorStepActivity kycDoorStepActivity) {
            this.f66114a = kycDoorStepActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            UADPincode uADPincode;
            ArrayList<UADPincode.SubPincode> pincodeList;
            ArrayList<UADPincode.SubPincode> pincodeList2;
            UADPincode.SubPincode subPincode;
            ArrayList<UADPincode.SubPincode> pincodeList3;
            UADPincode.SubPincode subPincode2;
            NetworkCustomError networkCustomError;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar == null || (networkCustomError = bVar.f66170c) == null || (str = networkCustomError.getMessage()) == null) {
                str = this.f66114a.getString(R.string.kyc_something_went_wrong);
            }
            String str2 = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = d.f66157b[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66114a.a(R.id.wallet_loader));
                    UADPincode uADPincode2 = (UADPincode) bVar.f66169b;
                    if ((uADPincode2 != null ? uADPincode2.getResponseCode() : null) != null) {
                        UADPincode uADPincode3 = (UADPincode) bVar.f66169b;
                        if (k.a((Object) uADPincode3 != null ? uADPincode3.getResponseCode() : null, (Object) "200")) {
                            UADPincode uADPincode4 = (UADPincode) bVar.f66169b;
                            if ((uADPincode4 != null ? uADPincode4.getPincodeMap() : null) != null) {
                                UADPincode uADPincode5 = (UADPincode) bVar.f66169b;
                                Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode5 != null ? uADPincode5.getPincodeMap() : null;
                                Set<String> keySet = pincodeMap != null ? pincodeMap.keySet() : null;
                                System.out.println("All keys are: ".concat(String.valueOf(keySet)));
                                if (keySet != null) {
                                    for (String next : keySet) {
                                        System.out.println(next + ": " + pincodeMap.get(next));
                                        List<UADPincode.SubPincode> list = pincodeMap.get(next);
                                        if (list != null) {
                                            List list2 = list;
                                            ((TextInputEditText) this.f66114a.a(R.id.kyc_state)).setText(((UADPincode.SubPincode) list2.get(0)).getState());
                                            ((TextInputEditText) this.f66114a.a(R.id.kyc_edit_txt_city)).setText(((UADPincode.SubPincode) list2.get(0)).getTier3Value());
                                        } else {
                                            throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.upgradeKyc.UADPincode.SubPincode>");
                                        }
                                    }
                                }
                            } else {
                                Snackbar.a((View) (ScrollView) this.f66114a.a(R.id.fragment_request_vist_scroll_parent), (CharSequence) this.f66114a.getString(R.string.msg_invalid_pin), -1).c();
                            }
                            UADPincode uADPincode6 = (UADPincode) bVar.f66169b;
                            if ((uADPincode6 != null ? uADPincode6.getPincodeList() : null) != null && (uADPincode = (UADPincode) bVar.f66169b) != null && (pincodeList = uADPincode.getPincodeList()) != null && (!pincodeList.isEmpty())) {
                                TextInputEditText textInputEditText = (TextInputEditText) this.f66114a.a(R.id.kyc_state);
                                UADPincode uADPincode7 = (UADPincode) bVar.f66169b;
                                textInputEditText.setText((uADPincode7 == null || (pincodeList3 = uADPincode7.getPincodeList()) == null || (subPincode2 = pincodeList3.get(0)) == null) ? null : subPincode2.getState());
                                TextInputEditText textInputEditText2 = (TextInputEditText) this.f66114a.a(R.id.kyc_edit_txt_city);
                                UADPincode uADPincode8 = (UADPincode) bVar.f66169b;
                                if (!(uADPincode8 == null || (pincodeList2 = uADPincode8.getPincodeList()) == null || (subPincode = pincodeList2.get(0)) == null)) {
                                    str2 = subPincode.getTier3Value();
                                }
                                textInputEditText2.setText(str2);
                                return;
                            }
                            return;
                        }
                    }
                    Snackbar.a((View) (ScrollView) this.f66114a.a(R.id.fragment_request_vist_scroll_parent), (CharSequence) str, -1).c();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66114a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66114a;
                    NetworkCustomError networkCustomError2 = bVar.f66170c;
                    if (networkCustomError2 == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError2)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66114a.a(R.id.wallet_loader));
                        Snackbar.a((View) (ScrollView) this.f66114a.a(R.id.fragment_request_vist_scroll_parent), (CharSequence) str, -1).c();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.kycV3.c.e b(KycDoorStepActivity kycDoorStepActivity) {
        net.one97.paytm.upgradeKyc.kycV3.c.e eVar = kycDoorStepActivity.f66109d;
        if (eVar == null) {
            k.a("viewModel");
        }
        return eVar;
    }

    public final int a() {
        return R.layout.activity_request_visit_v2;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Activity activity, boolean z) {
            k.c(activity, "activity");
            Intent intent = new Intent(activity, KycDoorStepActivity.class);
            intent.putExtra("isAddressChange", z);
            activity.startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("/kyc/dorstep", "kyc_new", "signal");
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra("isAddressChange", false);
        }
        this.f66108a = z;
        this.f66109d = (net.one97.paytm.upgradeKyc.kycV3.c.e) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.kycV3.c.e.class);
        a.C1325a aVar = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        this.f66110e = a.C1325a.a(applicationContext);
        ((Button) a(R.id.fragment_request_visit_button_book)).setOnClickListener(new e(this));
        ((TextInputEditText) a(R.id.kyc_edit_txt_pin)).addTextChangedListener(this.f66111f);
        net.one97.paytm.upgradeKyc.kycV3.c.e eVar = this.f66109d;
        if (eVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        eVar.f66224b.observe(qVar, new b(this));
        net.one97.paytm.upgradeKyc.kycV3.c.e eVar2 = this.f66109d;
        if (eVar2 == null) {
            k.a("viewModel");
        }
        eVar2.f66225c.observe(qVar, new c(this));
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.kyc_edit_customer_name);
        k.a((Object) textInputEditText, "kyc_edit_customer_name");
        View.OnFocusChangeListener onFocusChangeListener = this;
        textInputEditText.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.kyc_edit_txt_address_1);
        k.a((Object) textInputEditText2, "kyc_edit_txt_address_1");
        textInputEditText2.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.kyc_edit_txt_address_2);
        k.a((Object) textInputEditText3, "kyc_edit_txt_address_2");
        textInputEditText3.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.kyc_edit_customer_landmark);
        k.a((Object) textInputEditText4, "kyc_edit_customer_landmark");
        textInputEditText4.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.kyc_edit_txt_pin);
        k.a((Object) textInputEditText5, "kyc_edit_txt_pin");
        textInputEditText5.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText6 = (TextInputEditText) a(R.id.kyc_edit_txt_city);
        k.a((Object) textInputEditText6, "kyc_edit_txt_city");
        textInputEditText6.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText7 = (TextInputEditText) a(R.id.kyc_state);
        k.a((Object) textInputEditText7, "kyc_state");
        textInputEditText7.setOnFocusChangeListener(onFocusChangeListener);
        TextInputEditText textInputEditText8 = (TextInputEditText) a(R.id.kyc_edit_txt_mobile_number);
        k.a((Object) textInputEditText8, "kyc_edit_txt_mobile_number");
        textInputEditText8.setOnFocusChangeListener(onFocusChangeListener);
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycDoorStepActivity f66116a;

        e(KycDoorStepActivity kycDoorStepActivity) {
            this.f66116a = kycDoorStepActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66116a, "/kyc/dorstep", "proceed_button_clicked", (HashMap) null, (String) null, 12);
            if (KycDoorStepActivity.a(this.f66116a)) {
                net.one97.paytm.upgradeKyc.kycV3.c.e b2 = KycDoorStepActivity.b(this.f66116a);
                TextInputEditText textInputEditText = (TextInputEditText) this.f66116a.a(R.id.kyc_edit_txt_pin);
                k.a((Object) textInputEditText, "kyc_edit_txt_pin");
                b2.a(String.valueOf(textInputEditText.getText()));
                KycDoorStepActivity.c(this.f66116a);
            }
        }
    }

    private static boolean a(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0) && str.length() > 5) {
            if (str != null) {
                char[] charArray = str.toCharArray();
                k.a((Object) charArray, "(this as java.lang.String).toCharArray()");
                k.d(charArray, "$this$asList");
                return !(new HashSet(new i.a(charArray)).size() >= 3);
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycDoorStepActivity f66115a;

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        d(KycDoorStepActivity kycDoorStepActivity) {
            this.f66115a = kycDoorStepActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 6) {
                net.one97.paytm.upgradeKyc.kycV3.c.e b2 = KycDoorStepActivity.b(this.f66115a);
                String obj = charSequence.toString();
                k.c(obj, "pinCode");
                b2.f66223a.setValue(obj);
            }
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z && view != null) {
            if (view.getId() == R.id.kyc_edit_txt_address_1) {
                UpgradeKycBaseActivity.a(this, "/kyc/dorstep", "houseno_entered", (HashMap) null, (String) null, 12);
            }
            if (view.getId() == R.id.kyc_edit_txt_address_2) {
                UpgradeKycBaseActivity.a(this, "/kyc/dorstep", "area_entered", (HashMap) null, (String) null, 12);
            }
            if (view.getId() == R.id.kyc_edit_txt_pin) {
                UpgradeKycBaseActivity.a(this, "/kyc/dorstep", "pincode_entered", (HashMap) null, (String) null, 12);
            }
            if (view.getId() == R.id.kyc_edit_txt_city) {
                UpgradeKycBaseActivity.a(this, "/kyc/dorstep", "city_entered", (HashMap) null, (String) null, 12);
            }
            if (view.getId() == R.id.kyc_state) {
                UpgradeKycBaseActivity.a(this, "/kyc/dorstep", "state_entered", (HashMap) null, (String) null, 12);
            }
        }
    }

    public static final /* synthetic */ boolean a(KycDoorStepActivity kycDoorStepActivity) {
        TextInputEditText textInputEditText = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_customer_name);
        k.a((Object) textInputEditText, "kyc_edit_customer_name");
        if (a(String.valueOf(textInputEditText.getText()))) {
            Snackbar.a((View) (RelativeLayout) kycDoorStepActivity.a(R.id.doorstep_parent_lyt), (CharSequence) kycDoorStepActivity.getString(R.string.error_name), -1).c();
            return false;
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_address_1);
        k.a((Object) textInputEditText2, "kyc_edit_txt_address_1");
        if (a(String.valueOf(textInputEditText2.getText()))) {
            Snackbar.a((View) (RelativeLayout) kycDoorStepActivity.a(R.id.doorstep_parent_lyt), (CharSequence) kycDoorStepActivity.getString(R.string.error_house), -1).c();
            return false;
        }
        TextInputEditText textInputEditText3 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_address_2);
        k.a((Object) textInputEditText3, "kyc_edit_txt_address_2");
        if (a(String.valueOf(textInputEditText3.getText()))) {
            Snackbar.a((View) (RelativeLayout) kycDoorStepActivity.a(R.id.doorstep_parent_lyt), (CharSequence) kycDoorStepActivity.getString(R.string.error_area), -1).c();
            return false;
        }
        TextInputEditText textInputEditText4 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_mobile_number);
        k.a((Object) textInputEditText4, "kyc_edit_txt_mobile_number");
        if (!TextUtils.isEmpty(textInputEditText4.getText())) {
            TextInputEditText textInputEditText5 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_customer_landmark);
            k.a((Object) textInputEditText5, "kyc_edit_customer_landmark");
            if (!TextUtils.isEmpty(textInputEditText5.getText())) {
                TextInputEditText textInputEditText6 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_pin);
                k.a((Object) textInputEditText6, "kyc_edit_txt_pin");
                if (!TextUtils.isEmpty(textInputEditText6.getText())) {
                    TextInputEditText textInputEditText7 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_city);
                    k.a((Object) textInputEditText7, "kyc_edit_txt_city");
                    if (!TextUtils.isEmpty(textInputEditText7.getText())) {
                        TextInputEditText textInputEditText8 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_state);
                        k.a((Object) textInputEditText8, "kyc_state");
                        if (!TextUtils.isEmpty(textInputEditText8.getText())) {
                            TextInputEditText textInputEditText9 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_mobile_number);
                            k.a((Object) textInputEditText9, "kyc_edit_txt_mobile_number");
                            if (String.valueOf(textInputEditText9.getText()).length() >= 10) {
                                return true;
                            }
                            Snackbar.a((View) (RelativeLayout) kycDoorStepActivity.a(R.id.doorstep_parent_lyt), (CharSequence) kycDoorStepActivity.getString(R.string.error_alt_phone), -1).c();
                            return false;
                        }
                    }
                }
            }
        }
        Snackbar.a((View) (RelativeLayout) kycDoorStepActivity.a(R.id.doorstep_parent_lyt), (CharSequence) kycDoorStepActivity.getString(R.string.error_fill_details), -1).c();
        return false;
    }

    public static final /* synthetic */ void c(KycDoorStepActivity kycDoorStepActivity) {
        JSONObject jSONObject = new JSONObject();
        TextInputEditText textInputEditText = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_customer_name);
        k.a((Object) textInputEditText, "kyc_edit_customer_name");
        jSONObject.put("name", textInputEditText.getText());
        TextInputEditText textInputEditText2 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_mobile_number);
        k.a((Object) textInputEditText2, "kyc_edit_txt_mobile_number");
        jSONObject.put("altPhoneNumber", textInputEditText2.getText());
        Context context = kycDoorStepActivity;
        jSONObject.put("customerId", com.paytm.utility.b.n(context));
        jSONObject.put("leadSource", "App");
        if (kycDoorStepActivity.f66108a) {
            jSONObject.put("addressChanged", "true");
        } else {
            jSONObject.put("addressChanged", "false");
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(context))) {
            jSONObject.put("phoneNumber", com.paytm.utility.b.l(context));
        }
        JSONObject jSONObject2 = new JSONObject();
        TextInputEditText textInputEditText3 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_address_1);
        k.a((Object) textInputEditText3, "kyc_edit_txt_address_1");
        jSONObject2.put("addressLine1", textInputEditText3.getText());
        TextInputEditText textInputEditText4 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_address_2);
        k.a((Object) textInputEditText4, "kyc_edit_txt_address_2");
        jSONObject2.put("addressLine2", textInputEditText4.getText());
        TextInputEditText textInputEditText5 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_pin);
        k.a((Object) textInputEditText5, "kyc_edit_txt_pin");
        jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, textInputEditText5.getText());
        TextInputEditText textInputEditText6 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_city);
        k.a((Object) textInputEditText6, "kyc_edit_txt_city");
        jSONObject2.put("city", textInputEditText6.getText());
        TextInputEditText textInputEditText7 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_state);
        k.a((Object) textInputEditText7, "kyc_state");
        jSONObject2.put("state", textInputEditText7.getText());
        TextInputEditText textInputEditText8 = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_customer_landmark);
        k.a((Object) textInputEditText8, "kyc_edit_customer_landmark");
        jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_LANDMARK, textInputEditText8.getText());
        jSONObject.put("kycAddress", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("number", "");
        jSONObject3.put("type", "");
        jSONObject.put("kycDocument", jSONObject3);
        if (kycDoorStepActivity.f66110e != null) {
            net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
        }
    }

    public static final /* synthetic */ void d(KycDoorStepActivity kycDoorStepActivity) {
        r rVar = new r();
        Bundle bundle = new Bundle();
        TextInputEditText textInputEditText = (TextInputEditText) kycDoorStepActivity.a(R.id.kyc_edit_txt_pin);
        k.a((Object) textInputEditText, "kyc_edit_txt_pin");
        bundle.putString(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, String.valueOf(textInputEditText.getText()));
        rVar.setArguments(bundle);
        rVar.show(kycDoorStepActivity.getSupportFragmentManager(), rVar.getTag());
    }
}
