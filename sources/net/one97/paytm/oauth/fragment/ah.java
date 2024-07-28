package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.d;
import net.one97.paytm.oauth.d.a;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.g.c;
import net.one97.paytm.oauth.models.DeviceBindingInitResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;
import org.json.JSONException;
import org.json.JSONObject;

public class ah extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f56323a = "";

    /* renamed from: b  reason: collision with root package name */
    String f56324b = "";

    /* renamed from: c  reason: collision with root package name */
    private ProgressViewButton f56325c;

    /* renamed from: d  reason: collision with root package name */
    private String f56326d;

    /* renamed from: e  reason: collision with root package name */
    private String f56327e;

    /* renamed from: f  reason: collision with root package name */
    private ap f56328f;

    /* renamed from: g  reason: collision with root package name */
    private c f56329g;

    /* renamed from: h  reason: collision with root package name */
    private d f56330h;

    /* renamed from: i  reason: collision with root package name */
    private String f56331i = "signup";
    private LottieAnimationView j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f56329g = (c) am.a((Fragment) this).a(c.class);
        Bundle arguments = getArguments();
        if (getArguments() != null) {
            this.f56326d = arguments.getString("login_state_token");
            this.f56327e = arguments.getString("login_mobile");
            this.f56323a = arguments.getString(p.f56797b);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f56323a);
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "claim", "claim_screen_loaded", arrayList, (String) null, "/claim", p.f56796a);
        OauthModule.b().sendOpenScreenWithDeviceInfo("/claim", p.f56796a, getContext().getApplicationContext());
    }

    public static ah a(Bundle bundle) {
        ah ahVar = new ah();
        ahVar.setArguments(bundle);
        return ahVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account_claimable, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.account_exist_title);
        this.f56325c = (ProgressViewButton) inflate.findViewById(R.id.proceed_create_new_account);
        TextView textView2 = (TextView) inflate.findViewById(R.id.login_existing);
        this.j = (LottieAnimationView) inflate.findViewById(R.id.progressLoader);
        if (!TextUtils.isEmpty(this.f56327e)) {
            textView.setText(String.format(getString(R.string.account_already_exist), new Object[]{this.f56327e}));
        }
        this.f56325c.setOnClickListener(this);
        textView2.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof d) {
            this.f56330h = (d) context;
            if (context instanceof ap) {
                this.f56328f = (ap) context;
                return;
            }
            throw new IllegalStateException("Activity must implement " + ap.class.getName());
        }
        throw new IllegalStateException("Activity must implement " + d.class.getName());
    }

    public void onDetach() {
        super.onDetach();
        this.f56328f = null;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.proceed_create_new_account) {
            OauthModule.b().sendGAMultipleLabelEvent(getContext(), "claim", "proceed_to_created_account_clicked", (ArrayList<String>) null, (String) null, "/signup", p.f56796a);
            this.f56331i = "signup";
            this.f56324b = "claim_signup";
            a();
        } else if (view.getId() == R.id.login_existing) {
            OauthModule.b().sendGAMultipleLabelEvent(getContext(), "claim", "login_to_existing_account_clicked", (ArrayList<String>) null, (String) null, "/login", p.f56796a);
            if (OAuthUtils.b()) {
                this.f56331i = "login";
                this.f56324b = "claim_login";
                a();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("login_mobile", this.f56327e);
            bundle.putString(p.f56797b, "/claim");
            this.f56328f.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
        }
    }

    private void a() {
        if (this.f56325c.f56843a) {
            return;
        }
        if (OAuthUtils.b()) {
            c();
        } else {
            b();
        }
    }

    private void b() {
        this.f56325c.c();
        this.f56329g.a((Context) getActivity(), this.f56326d).observe(this, new z() {
            public final void onChanged(Object obj) {
                ah.this.b((e) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(e eVar) {
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c);
        }
    }

    private void c() {
        if ("signup".equalsIgnoreCase(this.f56331i)) {
            this.f56325c.c();
        } else {
            OAuthUtils.a(this.j);
        }
        this.f56329g.a(this.f56331i, this.f56326d).observe(this, new z() {
            public final void onChanged(Object obj) {
                ah.this.a((e) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar) {
        if (eVar.f52602a == 101) {
            a((IJRPaytmDataModel) eVar.f52603b);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b, eVar.f52604c);
        }
    }

    private void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
            SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
            if (WebLogin.RESPONSE_CODE_SUCCESS.equals(simplifiedLoginInit.getResponseCode())) {
                this.f56330h.a(simplifiedLoginInit.getOauthCode(), true, this.f56327e, i.CLAIM);
                return;
            }
            this.f56325c.d();
            b.b((Context) getActivity(), (String) null, simplifiedLoginInit.getMessage());
        } else if (iJRPaytmDataModel instanceof DeviceBindingInitResModel) {
            DeviceBindingInitResModel deviceBindingInitResModel = (DeviceBindingInitResModel) iJRPaytmDataModel;
            if ("BE1400001".equals(deviceBindingInitResModel.getResponseCode())) {
                new ArrayList().add(this.f56323a);
                OauthModule.b().sendGAMultipleLabelEvent(getContext(), "login_signup", "device_binding_successful", (ArrayList<String>) null, this.f56324b, "/login-signup", p.f56796a);
                this.f56330h.a(this.f56327e, this.f56326d, "signup".equalsIgnoreCase(this.f56331i), i.CLAIM);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f56323a);
            arrayList.add(SDKConstants.KEY_API);
            arrayList.add(deviceBindingInitResModel.getMessage());
            OauthModule.b().sendGAMultipleLabelEvent(getContext(), "login_signup", "device_binding_successful", (ArrayList<String>) null, this.f56324b, "/login-signup", p.f56796a);
            this.f56325c.d();
            a.a((Context) getActivity(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
        }
    }

    private void a(ErrorModel errorModel, Throwable th) {
        if ("signup".equalsIgnoreCase(this.f56331i)) {
            this.f56325c.d();
        } else {
            OAuthUtils.a(this.j);
        }
        NetworkCustomError networkCustomError = (NetworkCustomError) th;
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, networkCustomError)) {
            if (l.a(errorModel)) {
                a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
            } else if (errorModel.getStatus() == -1) {
                OAuthUtils.a(getActivity(), getString(R.string.no_connection), getString(R.string.no_internet), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        ah.this.a(dialogInterface, i2);
                    }
                });
            } else if (errorModel.getStatus() == n.f56789h.intValue()) {
                String str = new String(networkCustomError.getNetworkResponse().data);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if ("BE1426002".equals(jSONObject.getString("responseCode")) || "3006".equals(jSONObject.getString("responseCode"))) {
                            Bundle bundle = new Bundle(getArguments());
                            bundle.putString("login_mobile", this.f56327e);
                            bundle.putString(p.f56797b, "/claim");
                            this.f56328f.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
                            Toast.makeText(requireContext(), getString(R.string.lbl_session_expired_proceed_again), 1).show();
                        }
                    } catch (JSONException e2) {
                        q.b(e2.getMessage());
                    }
                }
            } else {
                a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        a();
    }
}
