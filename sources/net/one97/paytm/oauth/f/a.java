package net.one97.paytm.oauth.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.b;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.e.h;
import net.one97.paytm.oauth.e.i;
import net.one97.paytm.oauth.f.b;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.PasswordStrengthLayout;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f55979a = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f55980d = "key_dismiss";

    /* renamed from: e  reason: collision with root package name */
    private static String f55981e = "login_with_other_account";

    /* renamed from: b  reason: collision with root package name */
    public h f55982b;

    /* renamed from: c  reason: collision with root package name */
    public i f55983c;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior f55984f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Button f55985g;

    /* renamed from: h  reason: collision with root package name */
    private b f55986h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextInputLayout f55987i;
    /* access modifiers changed from: private */
    public AppCompatEditText j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    /* access modifiers changed from: private */
    public AppCompatEditText l;
    /* access modifiers changed from: private */
    public View m;
    private LottieAnimationView n;
    private boolean o;
    private boolean p;
    /* access modifiers changed from: private */
    public PasswordStrengthLayout q;
    /* access modifiers changed from: private */
    public boolean r;

    public static a a(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        a aVar = new a();
        bundle.putBoolean(f55980d, z);
        bundle.putBoolean(f55981e, z2);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
        if (getArguments() != null) {
            this.o = getArguments().getBoolean(f55980d);
            this.p = getArguments().getBoolean(f55981e);
        }
        this.f55986h = (b) am.a((Fragment) this).a(b.class);
        setCancelable(this.o);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a("popup_loaded", (ArrayList<String>) new ArrayList());
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                aVar.getWindow().findViewById(com.google.android.material.R.id.design_bottom_sheet).setBackgroundResource(17170445);
                FrameLayout frameLayout = (FrameLayout) aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior unused = a.this.f55984f = BottomSheetBehavior.from(frameLayout);
                }
                a.this.f55984f.setState(3);
            }
        });
        return aVar;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        f55979a = false;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            OAuthUtils.a((Activity) activity);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f55979a = true;
        View inflate = layoutInflater.inflate(R.layout.bottomsheet_create_password, viewGroup, false);
        this.n = (LottieAnimationView) inflate.findViewById(R.id.lottie_loader);
        this.f55985g = (Button) inflate.findViewById(R.id.btnProceed);
        this.f55987i = (TextInputLayout) inflate.findViewById(R.id.til_password);
        this.j = (AppCompatEditText) inflate.findViewById(R.id.et_password);
        this.k = (TextInputLayout) inflate.findViewById(R.id.til_password_reenter);
        this.l = (AppCompatEditText) inflate.findViewById(R.id.et_password_reenter);
        this.q = (PasswordStrengthLayout) inflate.findViewById(R.id.layoutPwdStrength);
        this.m = inflate.findViewById(R.id.progressView);
        this.f55985g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!a.this.r) {
                    if (!OAuthUtils.c(a.this.j.getText().toString())) {
                        a.this.f55987i.setError(a.this.getString(R.string.msg_invalid_password));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("password");
                        arrayList.add(a.this.getString(R.string.msg_invalid_password));
                        arrayList.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        arrayList.add(a.this.q.getPasswordStrengthText());
                        a.this.a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList);
                        return;
                    }
                    a.this.f55987i.setVisibility(8);
                    a.this.q.setVisibility(8);
                    a.this.k.setVisibility(0);
                    a.this.f55985g.setText(a.this.getString(R.string.btn_confirm));
                    boolean unused = a.this.r = true;
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("password");
                    a.this.a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList2);
                } else if (!OAuthUtils.c(a.this.l.getText().toString())) {
                    a.this.k.setError(a.this.getString(R.string.msg_invalid_password));
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add("password");
                    arrayList3.add(a.this.getString(R.string.msg_invalid_password));
                    arrayList3.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                    a.this.a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) arrayList3);
                } else if (!OAuthUtils.a(a.this.j.getText().toString(), a.this.l.getText().toString())) {
                    a.this.k.setError(a.this.getString(R.string.msg_invalid_password_dont_match));
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add("password");
                    arrayList4.add(a.this.getString(R.string.msg_invalid_password_dont_match));
                    arrayList4.add(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                    a.this.a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) arrayList4);
                } else {
                    a.this.a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) new ArrayList());
                    a aVar = a.this;
                    a.a(aVar, aVar.j.getText().toString());
                }
            }
        });
        this.j.setFilters(new InputFilter[]{OAuthUtils.f56746a});
        this.j.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                a.this.f55987i.setError((CharSequence) null);
            }

            public final void afterTextChanged(Editable editable) {
                a.this.q.a(editable.toString());
            }
        });
        this.l.setFilters(new InputFilter[]{OAuthUtils.f56746a});
        this.l.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                a.this.k.setError((CharSequence) null);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.login_with_account);
        if (this.p) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.b(view);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_cross);
        if (this.o) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a(view);
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a("login_to_a_diff_account", (ArrayList<String>) new ArrayList());
        dismissAllowingStateLoss();
        OauthModule.b().signOutAndLogin(getActivity(), true, OAuthUtils.b.SET_PASSWORD);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public void a() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && !OAuthUtils.c((Activity) activity) && (intent = activity.getIntent()) != null) {
            intent.setFlags(536870912);
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "secure_password", str, arrayList, (String) null, "/secure_password", p.f56796a);
    }

    static /* synthetic */ void a(a aVar, String str) {
        aVar.m.setVisibility(0);
        OAuthUtils.a(aVar.n);
        b bVar = aVar.f55986h;
        Context context = aVar.getContext();
        y yVar = new y();
        b.AnonymousClass1 r3 = new com.paytm.network.listener.b(yVar) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ y f55995a;

            {
                this.f55995a = r2;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                this.f55995a.setValue(e.a(iJRPaytmDataModel));
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                this.f55995a.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel), (Throwable) networkCustomError));
            }
        };
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("userPassword");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            hashMap.put("session_token", OauthModule.b().getSSOToken());
            hashMap.put("client_id", com.paytm.utility.b.k());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("password", str);
                jSONObject.put("confirmPassword", str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = net.one97.paytm.oauth.b.b.a(a.class.getName());
            a3.n = a.b.SILENT;
            a3.f42879c = a.C0715a.PUT;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = r3;
            a3.f42885i = new SimplifiedLoginInit();
            com.paytm.network.a l2 = a3.l();
            l2.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                r3.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l2.a();
            }
        }
        yVar.observe(aVar, new z<e<IJRPaytmDataModel>>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f55992a = (!a.class.desiredAssertionStatus());

            public final /* synthetic */ void onChanged(Object obj) {
                String str;
                e eVar = (e) obj;
                if (f55992a || eVar != null) {
                    a.j(a.this);
                    if (eVar.f52602a == 101) {
                        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
                        net.one97.paytm.oauth.utils.q.c(a.this.q.getPasswordStrengthText());
                        net.one97.paytm.oauth.utils.q qVar2 = net.one97.paytm.oauth.utils.q.f56798a;
                        net.one97.paytm.oauth.utils.q.q();
                        if (a.this.f55983c != null) {
                            i unused = a.this.f55983c;
                        }
                        Toast.makeText(((Context) Objects.requireNonNull(a.this.getContext())).getApplicationContext(), R.string.msg_pwd_saved, 0).show();
                        a.this.a();
                        a.this.dismissAllowingStateLoss();
                    } else if (eVar.f52602a == 102) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("password");
                        arrayList.add(SDKConstants.KEY_API);
                        a.this.a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) arrayList);
                        a.this.m.setVisibility(8);
                        ErrorModel errorModel = (ErrorModel) eVar.f52603b;
                        a aVar = a.this;
                        Throwable th = eVar.f52604c;
                        if (!OAuthUtils.a((Activity) aVar.getActivity(), (Fragment) aVar, (NetworkCustomError) th)) {
                            String str2 = null;
                            if (!(th instanceof NetworkCustomError) || errorModel.getStatus() != -1) {
                                str = aVar.getString(R.string.some_went_wrong);
                            } else {
                                str2 = aVar.getString(R.string.no_connection);
                                str = aVar.getString(R.string.no_internet);
                            }
                            OAuthUtils.a(aVar.getActivity(), str2, str, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    a aVar = a.this;
                                    a.a(aVar, aVar.j.getText().toString());
                                }
                            });
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
        });
    }

    static /* synthetic */ void j(a aVar) {
        aVar.m.setVisibility(8);
        OAuthUtils.b(aVar.n);
    }
}
