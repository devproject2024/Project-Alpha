package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.UpdatePhoneNumberActivity;
import net.one97.paytm.oauth.d;
import net.one97.paytm.oauth.d.a;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.fragment.az;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.g.h;
import net.one97.paytm.oauth.models.DeviceBindingStausResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.OTPPasteEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.oauth.view.b;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public class ai extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f56332a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f56333c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f56334d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f56335e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f56336f;

    /* renamed from: g  reason: collision with root package name */
    private String f56337g;

    /* renamed from: h  reason: collision with root package name */
    private String f56338h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ProgressViewButton f56339i;
    private d j;
    /* access modifiers changed from: private */
    public ap k;
    private h l;
    /* access modifiers changed from: private */
    public OTPPasteEditText[] m;
    /* access modifiers changed from: private */
    public boolean n = false;
    private boolean o;
    private LottieAnimationView p;
    private String q = "";
    private boolean r;
    private boolean s;
    private boolean t;
    private OTPPasteEditText.a u = new OTPPasteEditText.a() {
        public final void a(String str) {
            OTPPasteEditText[] a2 = ai.this.m;
            int length = a2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                a2[i2].setText(String.valueOf(str.charAt(i3)));
                i2++;
                i3++;
            }
        }
    };
    private View.OnFocusChangeListener v = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            ai.this.a(view, z);
        }
    };
    private View.OnKeyListener w = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            int i3 = 0;
            if (i2 != 67 || keyEvent.getAction() != 0) {
                return false;
            }
            OTPPasteEditText oTPPasteEditText = null;
            OTPPasteEditText[] a2 = ai.this.m;
            int length = a2.length;
            while (i3 < length) {
                OTPPasteEditText oTPPasteEditText2 = a2[i3];
                if (view.equals(oTPPasteEditText2)) {
                    ai.a((EditText) oTPPasteEditText2, (EditText) oTPPasteEditText);
                }
                i3++;
                oTPPasteEditText = oTPPasteEditText2;
            }
            return true;
        }
    };
    private TextWatcher x = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (ai.this.n || ai.this.m == null || ai.this.m[5] == null || TextUtils.isEmpty(ai.this.m[5].getText())) {
                ai.this.f56339i.a();
                ai.this.f56339i.setOnClickListener((View.OnClickListener) null);
            } else {
                ai.this.a("otp_entered", (ArrayList<String>) null);
                ai.this.f56339i.b();
                ai.this.f56339i.setOnClickListener(ai.this);
            }
            ai.this.f56333c.setVisibility(8);
            ai.e(ai.this);
        }
    };

    public static Fragment a(Bundle bundle) {
        ai aiVar = new ai();
        aiVar.setArguments(bundle);
        return aiVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ArrayList arrayList = new ArrayList();
        if (getArguments() != null) {
            this.f56337g = arguments.getString("login_state_token");
            this.f56338h = arguments.getString("login_mobile");
            this.s = getArguments().getBoolean("is_from_password", false);
            this.t = getArguments().getBoolean("is_device_binding", false);
            this.q = arguments.getString(p.f56797b);
            arrayList.add(this.q);
            if ("/login-signup".equals(this.q)) {
                if (d()) {
                    OauthModule.b().sendGAMultipleLabelEvent(getContext(), "signup", "signup_otp_screen_loaded", arrayList, (String) null, "/signup-otp", p.f56796a);
                } else {
                    OauthModule.b().sendGAMultipleLabelEvent(getContext(), "login", "login_otp_screen_loaded", arrayList, (String) null, "/login-otp", p.f56796a);
                }
            } else if ("/login-password".equals(this.q)) {
                OauthModule.b().sendGAMultipleLabelEvent(getContext(), "login", "login_otp_screen_loaded", arrayList, (String) null, "/login-otp", p.f56796a);
            }
        }
        this.l = (h) am.a((Fragment) this).a(h.class);
        OauthModule.b().sendOpenScreenWithDeviceInfo(d() ? "/signup-otp" : "/login-otp", p.f56796a, getContext().getApplicationContext());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_login_otp, viewGroup, false);
        this.m = new OTPPasteEditText[6];
        this.m[0] = (OTPPasteEditText) inflate.findViewById(R.id.editext1);
        this.m[1] = (OTPPasteEditText) inflate.findViewById(R.id.editext2);
        this.m[2] = (OTPPasteEditText) inflate.findViewById(R.id.editext3);
        this.m[3] = (OTPPasteEditText) inflate.findViewById(R.id.editext4);
        this.m[4] = (OTPPasteEditText) inflate.findViewById(R.id.editext5);
        this.m[5] = (OTPPasteEditText) inflate.findViewById(R.id.editext6);
        this.f56339i = (ProgressViewButton) inflate.findViewById(R.id.btnConfirm);
        this.f56339i.setButtonText(getString(R.string.login_securely));
        this.f56333c = (TextView) inflate.findViewById(R.id.error_text_otp);
        this.f56332a = (TextView) inflate.findViewById(R.id.resend_otp);
        this.f56334d = (TextView) inflate.findViewById(R.id.txtTimer);
        this.p = (LottieAnimationView) inflate.findViewById(R.id.loader);
        this.f56335e = (TextView) inflate.findViewById(R.id.lblVerifyMobileNumber);
        this.f56336f = (TextView) inflate.findViewById(R.id.lblHavingIssues);
        if (!this.s) {
            this.f56336f.setVisibility(4);
        }
        b bVar = new b();
        for (OTPPasteEditText oTPPasteEditText : this.m) {
            oTPPasteEditText.setTransformationMethod(bVar);
            oTPPasteEditText.addTextChangedListener(this.x);
            oTPPasteEditText.setOnKeyListener(this.w);
            oTPPasteEditText.setOnFocusChangeListener(this.v);
            oTPPasteEditText.setOTPListner(this.u);
        }
        if (!TextUtils.isEmpty(this.f56338h)) {
            this.f56335e.setText(String.format(getString(R.string.lbl_verify_mobile), new Object[]{this.f56338h}));
        }
        this.f56336f.setOnClickListener(this);
        this.f56332a.setOnClickListener(this);
        this.f56339i.a();
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z) {
        Context context;
        int i2;
        if (getActivity() != null) {
            EditText editText = (EditText) view;
            if (z) {
                context = getContext();
                i2 = R.color.color_00b9f5;
            } else {
                context = getContext();
                i2 = R.color.color_002e6e;
            }
            editText.setTextColor(androidx.core.content.b.c(context, i2));
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(false, false, (String) null);
        OAuthUtils.a((EditText) this.m[0]);
    }

    public void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    private boolean e() {
        if (!isVisible()) {
            return false;
        }
        String d2 = d(h());
        if (TextUtils.isEmpty(d2)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.r ? "auto_otp" : "otp");
        arrayList.add(d2);
        arrayList.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList);
        this.f56333c.setVisibility(0);
        this.f56333c.setText(d2);
        this.r = false;
        return false;
    }

    private void f() {
        if (isVisible()) {
            this.f56339i.c();
            this.l.a((Context) getActivity(), h(), this.f56337g).observe(this, new z() {
                public final void onChanged(Object obj) {
                    ai.this.e((e) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(e eVar) {
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
        }
    }

    private void g() {
        if (isVisible()) {
            this.f56339i.c();
            this.l.a(h(), this.f56337g, this.f56338h).observe(this, new z() {
                public final void onChanged(Object obj) {
                    ai.this.d((e) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(e eVar) {
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(e eVar) {
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
        }
    }

    private String h() {
        StringBuilder sb = new StringBuilder();
        for (OTPPasteEditText oTPPasteEditText : this.m) {
            if (!TextUtils.isEmpty(oTPPasteEditText.getText().toString())) {
                sb.append(oTPPasteEditText.getText().toString());
            }
        }
        return sb.toString();
    }

    private void i() {
        OAuthUtils.a(this.p);
        if (this.t) {
            this.l.a(this.f56337g, this.o).observe(this, new z() {
                public final void onChanged(Object obj) {
                    ai.this.b((e) obj);
                }
            });
        } else {
            this.l.a((Context) getActivity(), this.f56337g, this.o).observe(this, new z() {
                public final void onChanged(Object obj) {
                    ai.this.a((e) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(e eVar) {
        OAuthUtils.b(this.p);
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar) {
        OAuthUtils.b(this.p);
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.resend_otp) {
            OAuthUtils.a((Activity) getActivity());
            a("resend_otp_clicked", (ArrayList<String>) null);
            q a2 = getChildFragmentManager().a();
            az.a aVar = az.f56394a;
            az a3 = az.a.a(d());
            ArrayList arrayList = new ArrayList();
            e("resend_popup_loaded");
            a3.a((az.b) new az.b(arrayList, a3) {
                private final /* synthetic */ ArrayList f$1;
                private final /* synthetic */ az f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onOptionSelected(boolean z) {
                    ai.this.a(this.f$1, this.f$2, z);
                }
            });
            a2.a((Fragment) a3, az.class.getName());
            a2.c();
        } else if (view.getId() == R.id.btnConfirm) {
            if (!this.f56339i.f56843a) {
                OAuthUtils.a((Activity) getActivity());
                this.r = false;
                if (e()) {
                    k();
                }
            }
        } else if (view.getId() == R.id.lblHavingIssues) {
            OAuthUtils.a((Activity) getActivity());
            Intent intent = new Intent(requireContext(), UpdatePhoneNumberActivity.class);
            intent.putExtra(p.f56797b, d() ? "/signup" : "/login");
            intent.putExtra("login_mobile", this.f56338h);
            intent.putExtra("stateToken", this.f56337g);
            intent.putExtra("screen_name", "otp_page");
            getActivity().startActivityForResult(intent, 1093);
        }
    }

    private void j() {
        this.n = true;
        for (OTPPasteEditText text : this.m) {
            text.setText("");
        }
        this.n = false;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof d) {
            this.j = (d) context;
            if (context instanceof ap) {
                this.k = (ap) context;
                return;
            }
            throw new IllegalStateException("Activity must implement " + ap.class.getName());
        }
        throw new IllegalStateException("Activity must implement " + d.class.getName());
    }

    public void onDetach() {
        super.onDetach();
        this.j = null;
        this.k = null;
    }

    private void k() {
        if (this.t) {
            g();
        } else {
            f();
        }
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        char c2 = 65535;
        if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
            this.f56339i.d();
            SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
            if ("oauthSimpleResendOtpSv1".equals(str)) {
                j();
                a(simplifiedLoginInit.getResponseCode(), simplifiedLoginInit.getMessage(), simplifiedLoginInit.getStateToken());
                return;
            }
            String str2 = "auto_otp";
            if ("oauthValidateOtpSv1".equals(str)) {
                this.f56339i.d();
                String responseCode = simplifiedLoginInit.getResponseCode();
                switch (responseCode.hashCode()) {
                    case 1537:
                        if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1567008:
                        if (responseCode.equals("3003")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1567011:
                        if (responseCode.equals("3006")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1567012:
                        if (responseCode.equals("3007")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    String oauthCode = simplifiedLoginInit.getOauthCode();
                    net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
                    net.one97.paytm.oauth.utils.q.c(simplifiedLoginInit.getPasswordViolation().booleanValue());
                    this.j.a(oauthCode, d(), this.f56338h, m());
                    l();
                    ArrayList arrayList = new ArrayList();
                    if (c().equals("/login-password")) {
                        if (this.r) {
                            arrayList.add("password_auto_otp");
                        } else {
                            arrayList.add("password_otp");
                        }
                    } else if (this.r) {
                        arrayList.add(str2);
                    } else {
                        arrayList.add("otp");
                    }
                } else if (c2 == 1) {
                    String stateToken = simplifiedLoginInit.getStateToken();
                    Bundle bundle = new Bundle(getArguments());
                    bundle.putString("login_state_token", stateToken);
                    bundle.putString(p.f56797b, "/login-otp");
                    l();
                    this.k.a("FRAGMENT_ACCOUNT_CLAIM", bundle, true);
                } else if (c2 == 2) {
                    Bundle bundle2 = new Bundle(getArguments());
                    bundle2.putString("login_mobile", this.f56338h);
                    this.k.a("FRAGMENT_LOGIN_MOBILE", bundle2, false);
                    Toast.makeText(requireContext(), getString(R.string.lbl_session_expired_proceed_again), 1).show();
                } else if (c2 != 3) {
                    j();
                    if (!TextUtils.isEmpty(simplifiedLoginInit.getMessage())) {
                        String message = simplifiedLoginInit.getMessage();
                        this.f56333c.setVisibility(0);
                        this.f56333c.setText(message);
                        ArrayList arrayList2 = new ArrayList();
                        if (!this.r) {
                            str2 = "otp";
                        }
                        arrayList2.add(str2);
                        arrayList2.add(message);
                        arrayList2.add(SDKConstants.KEY_API);
                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList2);
                        this.r = false;
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    if (!this.r) {
                        str2 = "otp";
                    }
                    arrayList3.add(str2);
                    arrayList3.add(getString(R.string.some_went_wrong));
                    arrayList3.add(SDKConstants.KEY_API);
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList3);
                    com.paytm.utility.b.b((Context) getActivity(), (String) null, getString(R.string.some_went_wrong));
                } else {
                    a.a(requireContext(), simplifiedLoginInit.getMessage(), (View.OnClickListener) new View.OnClickListener() {
                        public final void onClick(View view) {
                            Bundle bundle = new Bundle(ai.this.getArguments());
                            if (ai.this.k != null) {
                                ai.this.k.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
                            }
                        }
                    });
                }
            } else if (!"oauthdevicebindingConfirmSv1".equals(str)) {
            } else {
                if (!"BE1400001".equals(simplifiedLoginInit.getResponseCode())) {
                    this.f56339i.d();
                    j();
                    ArrayList arrayList4 = new ArrayList();
                    if (!this.r) {
                        str2 = "otp";
                    }
                    arrayList4.add(str2);
                    arrayList4.add(simplifiedLoginInit.getMessage());
                    arrayList4.add(SDKConstants.KEY_API);
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList4);
                    this.f56333c.setVisibility(0);
                    this.f56333c.setText(simplifiedLoginInit.getMessage());
                } else if (isVisible()) {
                    this.f56339i.c();
                    this.l.a(this.f56337g).observe(this, new z() {
                        public final void onChanged(Object obj) {
                            ai.this.c((e) obj);
                        }
                    });
                }
            }
        } else if (iJRPaytmDataModel instanceof DeviceBindingStausResModel) {
            DeviceBindingStausResModel deviceBindingStausResModel = (DeviceBindingStausResModel) iJRPaytmDataModel;
            if ("BE1400001".equals(deviceBindingStausResModel.getResponseCode())) {
                String deviceBindingStatus = deviceBindingStausResModel.getData().getDeviceBindingStatus();
                int hashCode = deviceBindingStatus.hashCode();
                if (hashCode != -1809526922) {
                    if (hashCode == 1982485311 && deviceBindingStatus.equals("CONFIRMED")) {
                        c2 = 0;
                    }
                } else if (deviceBindingStatus.equals("CLAIMABLE")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    l();
                    this.j.a(this.f56338h, this.f56337g, d(), m());
                } else if (c2 != 1) {
                    this.f56339i.d();
                    OAuthUtils.a((Activity) getActivity(), deviceBindingStausResModel.getMessage());
                } else {
                    Bundle bundle3 = new Bundle(getArguments());
                    bundle3.putString("login_state_token", this.f56337g);
                    bundle3.putString(p.f56797b, "/login-otp");
                    l();
                    this.k.a("FRAGMENT_ACCOUNT_CLAIM", bundle3, true);
                }
            } else {
                this.f56339i.d();
                OAuthUtils.a((Activity) getActivity(), deviceBindingStausResModel.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
            a(updatePhoneResModel.getResponseCode(), updatePhoneResModel.getMessage(), updatePhoneResModel.getState());
        }
    }

    private void a(String str, String str2, String str3) {
        if (WebLogin.RESPONSE_CODE_SUCCESS.equals(str)) {
            net.one97.paytm.oauth.a.a();
            long b2 = (long) (net.one97.paytm.oauth.a.b() * 1000);
            if (this.o) {
                net.one97.paytm.oauth.a.a();
                b2 = (long) (net.one97.paytm.oauth.a.c() * 1000);
            }
            this.f56656b = b2;
            b();
            a(false, false, (String) null);
            if (!TextUtils.isEmpty(str3)) {
                this.f56337g = str3;
            }
            if (getArguments() != null) {
                getArguments().putString("login_state_token", this.f56337g);
                getArguments().putString("login_mobile", this.f56338h);
                return;
            }
            throw new IllegalStateException("Args can't be null");
        } else if ("708".equals(str)) {
            a.a(requireContext(), str2, (View.OnClickListener) new View.OnClickListener() {
                public final void onClick(View view) {
                    ai.this.a(view);
                }
            });
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.some_went_wrong);
            }
            a.a(requireContext(), str2, (View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Bundle bundle = new Bundle(getArguments());
        ap apVar = this.k;
        if (apVar != null) {
            apVar.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
        }
    }

    private void a(ErrorModel errorModel, Throwable th, String str) {
        this.f56339i.d();
        NetworkCustomError networkCustomError = (NetworkCustomError) th;
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, networkCustomError)) {
            if (l.a(errorModel)) {
                a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
            } else if (errorModel.getStatus() == -1) {
                OAuthUtils.a(getActivity(), getString(R.string.no_connection), getString(R.string.no_internet), new DialogInterface.OnClickListener(str) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        ai.this.a(this.f$1, dialogInterface, i2);
                    }
                });
            } else if (errorModel.getStatus() == n.f56789h.intValue()) {
                Bundle bundle = new Bundle(getArguments());
                bundle.putString("login_mobile", this.f56338h);
                this.k.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
                Toast.makeText(requireContext(), getString(R.string.lbl_session_expired_proceed_again), 1).show();
            } else if (errorModel.getStatus() == n.f56788g.intValue()) {
                String str2 = new String(networkCustomError.networkResponse.data);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        a.a(requireContext(), new JSONObject(str2).getString("message"), (View.OnClickListener) null);
                    } catch (JSONException e2) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                }
            } else {
                a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, DialogInterface dialogInterface, int i2) {
        b(str);
    }

    public final boolean d() {
        if (getArguments() != null) {
            return getArguments().getBoolean("isfromSignup", false);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), d() ? "signup" : "login", str, arrayList, (String) null, d() ? "/signup-otp" : "/login-otp", p.f56796a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList, az azVar, boolean z) {
        this.o = z;
        i();
        e(z ? "resend_otp_call" : "resend_otp_sms");
        azVar.dismissAllowingStateLoss();
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.r ? "auto_otp" : "otp");
        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList);
    }

    private void e(String str) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), d() ? "signup" : "login", str, (ArrayList<String>) null, (String) null, d() ? "/signup" : "/login", p.f56796a);
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ai.this.f(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(String str) {
        int i2 = 0;
        while (true) {
            OTPPasteEditText[] oTPPasteEditTextArr = this.m;
            if (i2 < oTPPasteEditTextArr.length) {
                oTPPasteEditTextArr[i2].setText(String.valueOf(str.charAt(i2)));
                i2++;
            } else {
                this.r = true;
                k();
                OAuthUtils.a((Activity) getActivity());
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        if (isVisible()) {
            if (aVar == x.a.STARTED) {
                this.f56334d.setVisibility(0);
                this.f56332a.setVisibility(8);
            } else if (aVar == x.a.UPDATED) {
                this.f56334d.setText(getString(R.string.lbl_resend_otp_in_seconds, Long.valueOf(j2 / 1000)));
            } else {
                this.f56334d.setVisibility(8);
                this.f56332a.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -422762960: goto L_0x0029;
                case -183116971: goto L_0x001f;
                case 629923750: goto L_0x0015;
                case 1126981863: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "oauthSimpleResendOtpSv1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 0
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "oauthdevicebindingConfirmSv1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 3
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "OauthResendOTPSV1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "oauthValidateOtpSv1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 2
            goto L_0x0034
        L_0x0033:
            r5 = -1
        L_0x0034:
            if (r5 == 0) goto L_0x0045
            if (r5 == r3) goto L_0x0045
            if (r5 == r2) goto L_0x0041
            if (r5 == r1) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r4.g()
        L_0x0040:
            return
        L_0x0041:
            r4.f()
            return
        L_0x0045:
            r4.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.ai.b(java.lang.String):void");
    }

    private i m() {
        return d() ? i.SIGNUP : i.LOGIN;
    }

    static /* synthetic */ void a(EditText editText, EditText editText2) {
        if (!editText.getText().toString().equals("")) {
            editText.setText("");
        } else if (editText2 != null) {
            editText2.setText("");
            editText2.setEnabled(true);
            editText2.requestFocus();
        }
    }

    static /* synthetic */ void e(ai aiVar) {
        for (OTPPasteEditText oTPPasteEditText : aiVar.m) {
            if (TextUtils.isEmpty(oTPPasteEditText.getText().toString())) {
                oTPPasteEditText.requestFocus();
                return;
            }
        }
    }
}
