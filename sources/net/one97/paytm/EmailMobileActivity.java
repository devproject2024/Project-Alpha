package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.google.android.gms.auth.api.credentials.Credential;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJREmailOtpStatus;
import net.one97.paytm.common.entity.CJREmailResendOtpStatus;
import net.one97.paytm.common.entity.CJRGetOTP;
import net.one97.paytm.common.entity.CJRGetValidateResendOTP;
import net.one97.paytm.common.entity.CJRMobileOtpStatus;
import net.one97.paytm.common.entity.CJRMobileResendOtpStatus;
import net.one97.paytm.common.entity.CJROTPStatus;
import net.one97.paytm.common.entity.CJRPhoneStatus;
import net.one97.paytm.common.entity.CJRStatus;
import net.one97.paytm.common.entity.CJRUserDefaultInfo;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.CJRValidateEmailOtpStatus;
import net.one97.paytm.common.entity.CJRValidateMobileOtpStatus;
import net.one97.paytm.common.entity.auth.CheckUserWallet;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.widgets.CustomEditText;
import net.one97.paytm.common.widgets.EditTextWithLabel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.j.c;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.activity.MergeAccountActivity;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.CJRSmsReceiver;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ah;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailMobileActivity extends CJRActionBarBaseActivity implements p, q, s, ah, w {
    private LinearLayout C;
    private ImageView D;
    private TextView E;
    private e F;
    private g G;
    private f H;
    private j I;
    private CJRSmsReceiver J;
    private boolean K = false;
    private String L;
    private boolean M;
    private String N;
    private boolean O = false;
    private boolean P;
    private boolean Q = false;
    private String R;
    private ImageView S;
    private ImageView T;
    private boolean U = false;
    /* access modifiers changed from: private */
    public AppCompatEditText V;
    private AppCompatEditText W;
    private final String X;
    private final String Y;

    /* renamed from: a  reason: collision with root package name */
    private Resources f51826a;

    /* renamed from: b  reason: collision with root package name */
    private String f51827b;

    /* renamed from: c  reason: collision with root package name */
    private String f51828c;

    /* renamed from: d  reason: collision with root package name */
    private String f51829d;

    /* renamed from: e  reason: collision with root package name */
    private String f51830e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f51831f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f51832g;

    /* renamed from: h  reason: collision with root package name */
    private CJRUserInfoV2 f51833h;

    /* renamed from: i  reason: collision with root package name */
    private CJRUserInfoV2 f51834i;
    private boolean j;
    private boolean k;
    private LinearLayout l;

    public final void a() {
    }

    public EmailMobileActivity() {
        Class<EmailMobileActivity> cls = EmailMobileActivity.class;
        this.X = cls.getName();
        this.Y = cls.getName();
    }

    private static String d(String str, String str2) {
        String str3 = "";
        if (str2 == null || str.isEmpty() || str2.isEmpty()) {
            return str3;
        }
        Matcher matcher = Pattern.compile(str).matcher(str2);
        if (matcher.find()) {
            str3 = matcher.group();
        }
        return str3.trim();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.fragment_profile_email, (ViewGroup) null));
        CJRUserDefaultInfo cJRUserDefaultInfo = new CJRUserDefaultInfo();
        this.f51834i = new CJRUserInfoV2();
        this.f51834i.setUserDefaultInfo(cJRUserDefaultInfo);
        this.f51826a = getResources();
        this.f51833h = new CJRUserInfoV2();
        o();
        p();
        c(getResources().getString(R.string.save));
        a(a.t(this) * 2);
        this.f51826a = getResources();
        this.f51827b = getIntent().getStringExtra("mobile_email");
        this.f51833h = (CJRUserInfoV2) getIntent().getExtras().getSerializable("extra_home_data");
        this.V = (AppCompatEditText) findViewById(R.id.new_mobile);
        this.W = (AppCompatEditText) findViewById(R.id.new_email);
        float t = (float) a.t(this);
        this.f51831f = (RelativeLayout) findViewById(R.id.table_row_1);
        int i2 = (int) (((double) t) * 2.5d);
        this.f51831f.getLayoutParams().height = i2;
        int i3 = ((int) t) / 2;
        this.f51831f.setPadding(i3, 0, i3, 0);
        this.f51832g = (RelativeLayout) findViewById(R.id.table_row_2);
        this.f51832g.getLayoutParams().height = i2;
        this.f51832g.setPadding(i3, 0, i3, 0);
        this.l = (LinearLayout) findViewById(R.id.lyt_verify_mobile);
        this.C = (LinearLayout) findViewById(R.id.lyt_verify_email);
        this.E = (TextView) findViewById(R.id.text_verify_mobile);
        this.D = (ImageView) findViewById(R.id.img_verify_mobile);
        this.S = (ImageView) findViewById(R.id.cross_button_mobile);
        this.T = (ImageView) findViewById(R.id.cross_button_email);
        g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).c(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() != null) {
                        upiAvailabilityModel.getResponse().isUpiUser();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (upiCustomVolleyError != null && UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
                    r.a((Activity) EmailMobileActivity.this, (Exception) upiCustomVolleyError, EmailMobileActivity.class.getName(), EmailMobileActivity.this.getIntent().getExtras());
                }
            }
        }, this.X, this.Y);
        if (this.f51827b.equalsIgnoreCase("mobile")) {
            setTitle(this.f51826a.getString(R.string.mobile_no));
            this.T.setVisibility(8);
            this.S.setVisibility(0);
            this.f51830e = getIntent().getStringExtra("verify_mobile_email");
            String str = this.f51830e;
            if (str == null || !str.equalsIgnoreCase("mobile")) {
                String str2 = this.f51830e;
                if (str2 == null || !str2.equalsIgnoreCase("mobileadd")) {
                    d();
                    return;
                }
                c(getResources().getString(R.string.save));
                d();
                return;
            }
            String phone = this.f51833h.getUserDefaultInfo().getPhone();
            this.f51834i.getUserDefaultInfo().setPhone(phone);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View inflate = getLayoutInflater().inflate(R.layout.layout_verify_mob, (ViewGroup) null);
            EditTextWithLabel editTextWithLabel = (EditTextWithLabel) inflate.findViewById(R.id.mobile);
            editTextWithLabel.setText(phone);
            builder.setInverseBackgroundForced(true);
            builder.setCancelable(false);
            builder.setView(inflate);
            AlertDialog show = builder.show();
            ((Button) inflate.findViewById(R.id.button_send_otp)).setOnClickListener(new View.OnClickListener(editTextWithLabel, (TextView) inflate.findViewById(R.id.txt_error_msg), show) {
                private final /* synthetic */ EditTextWithLabel f$1;
                private final /* synthetic */ TextView f$2;
                private final /* synthetic */ AlertDialog f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    EmailMobileActivity.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
            ((Button) inflate.findViewById(R.id.button_cancel)).setOnClickListener(new View.OnClickListener(show) {
                private final /* synthetic */ AlertDialog f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
        } else if (this.f51827b.equalsIgnoreCase(AppConstants.KEY_EMAIL)) {
            this.T.setVisibility(0);
            this.S.setVisibility(8);
            setTitle(this.f51826a.getString(R.string.email));
            this.f51829d = getIntent().getStringExtra(AppConstants.KEY_EMAIL);
            this.f51830e = getIntent().getStringExtra("verify_mobile_email");
            String str3 = this.f51830e;
            if (str3 == null || !str3.equalsIgnoreCase(AppConstants.KEY_EMAIL)) {
                String str4 = this.f51830e;
                if (str4 != null && str4.equalsIgnoreCase("emailadd")) {
                    c(getResources().getString(R.string.save));
                }
                this.f51829d = getIntent().getStringExtra(AppConstants.KEY_EMAIL);
                this.f51832g.setVisibility(8);
                this.f51831f.setVisibility(0);
                this.W.requestFocus();
                getWindow().setSoftInputMode(4);
                if (!TextUtils.isEmpty(this.f51829d)) {
                    this.W.setText(this.f51829d);
                    try {
                        this.W.setSelection(this.W.getText().length());
                    } catch (Exception e2) {
                        if (b.v) {
                            q.b(e2.getMessage());
                        }
                    }
                } else {
                    OAuthUtils.a((Activity) this, (Fragment) null, false);
                }
                this.T.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        EmailMobileActivity.this.a(view);
                    }
                });
                return;
            }
            String str5 = this.f51829d;
            this.f51834i.getUserDefaultInfo().setEmail(str5);
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_verify_email, (ViewGroup) null);
            CustomEditText customEditText = (CustomEditText) inflate2.findViewById(R.id.email);
            customEditText.setText(str5);
            builder2.setInverseBackgroundForced(true);
            builder2.setCancelable(false);
            builder2.setView(inflate2);
            AlertDialog show2 = builder2.show();
            ((Button) inflate2.findViewById(R.id.button_cancel)).setOnClickListener(new View.OnClickListener(show2) {
                private final /* synthetic */ AlertDialog f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    this.f$0.dismiss();
                }
            });
            ((Button) inflate2.findViewById(R.id.button_send_link)).setOnClickListener(new View.OnClickListener(customEditText, (TextView) inflate2.findViewById(R.id.txt_error_msg), show2) {
                private final /* synthetic */ CustomEditText f$1;
                private final /* synthetic */ TextView f$2;
                private final /* synthetic */ AlertDialog f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    EmailMobileActivity.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a((Context) this, "android.permission.RECEIVE_SMS") != 0) {
            requestPermissions(new String[]{"android.permission.RECEIVE_SMS"}, 0);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        j();
        c(getResources().getString(R.string.save));
        a(com.paytm.utility.a.t(this) * 2);
        return super.onPrepareOptionsMenu(menu);
    }

    private void d() {
        this.f51828c = getIntent().getStringExtra("mobileNumber");
        this.f51832g.setVisibility(0);
        this.f51831f.setVisibility(8);
        this.V.requestFocus();
        getWindow().setSoftInputMode(4);
        if (!TextUtils.isEmpty(this.f51828c)) {
            this.V.setText(this.f51828c);
        }
        try {
            this.V.setSelection(this.V.getText().length());
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        this.S.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EmailMobileActivity.this.V.setText("");
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.W.setText("");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        f fVar;
        f fVar2;
        e eVar;
        e eVar2;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if (!isFinishing()) {
            boolean z = true;
            if (iJRPaytmDataModel2 instanceof CJRUserInfo) {
                CJRUserInfo cJRUserInfo = (CJRUserInfo) iJRPaytmDataModel2;
                if (cJRUserInfo == null || cJRUserInfo.getStatus() == null || cJRUserInfo.getHttpCode() != 200) {
                    z = false;
                }
                if (!z) {
                    b.b((Context) this, cJRUserInfo.getStatus(), cJRUserInfo.getMessage());
                    return;
                }
                this.f51833h = l.a(cJRUserInfo);
                l.a(cJRUserInfo, (Context) this);
                if (this.O) {
                    b.b((Context) this, "", this.f51826a.getString(R.string.msg_verification_link_sent));
                    this.O = false;
                } else {
                    a("", (CharSequence) getResources().getString(R.string.profile_info_update_message));
                    OauthModule.b().resetSimChangedPromptAttributes(this);
                }
                l.a(cJRUserInfo, (Context) this);
            } else if (iJRPaytmDataModel2 instanceof CJRPhoneStatus) {
                CJRPhoneStatus cJRPhoneStatus = (CJRPhoneStatus) iJRPaytmDataModel2;
                if (!cJRPhoneStatus.isAvailable()) {
                    b.b((Context) this, "", this.f51826a.getString(R.string.mobile_already_registered_message, new Object[]{this.f51834i.getUserDefaultInfo().getPhone()}));
                    this.Q = false;
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mobile", cJRPhoneStatus.getPhoneNo());
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
                c.a();
                String a2 = c.a("userInfoUpdation", (String) null);
                Map<String, String> e3 = t.e(this);
                this.Q = true;
                d.a(this, a2, this, e3, e(), a.C0715a.PUT, jSONObject.toString(), new CJRUserInfo(), a.c.AUTH, a.b.USER_FACING).a();
            } else if (iJRPaytmDataModel2 instanceof CJRStatus) {
                CJRStatus cJRStatus = (CJRStatus) iJRPaytmDataModel2;
                if (cJRStatus != null) {
                    String status = cJRStatus.getStatus();
                    String string = getResources().getString(R.string.profile_verification_link_send_message);
                    cJRStatus.getmResponseCode();
                    if (status != null && status.trim().length() > 0 && status.equalsIgnoreCase("SUCCESS")) {
                        a("", (CharSequence) string);
                    } else if (cJRStatus == null || cJRStatus.getError() == null || cJRStatus.getError().trim().length() <= 0) {
                        a("", (CharSequence) getResources().getString(R.string.profile_something_went_wrong_message));
                    } else {
                        a("", (CharSequence) cJRStatus.getError());
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJREmailOtpStatus) {
                f();
                CJREmailOtpStatus cJREmailOtpStatus = (CJREmailOtpStatus) iJRPaytmDataModel2;
                if (cJREmailOtpStatus != null) {
                    String status2 = cJREmailOtpStatus.getStatus();
                    String str2 = cJREmailOtpStatus.getmResponseCode();
                    String state = cJREmailOtpStatus.getState();
                    String message = cJREmailOtpStatus.getMessage();
                    if (status2 != null && status2.trim().length() > 0) {
                        if (status2.equalsIgnoreCase("SUCCESS")) {
                            if (str2 == null || !str2.equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                if (str2 != null && str2.equalsIgnoreCase("02") && state != null && state.trim().length() > 0) {
                                    e eVar3 = this.F;
                                    if (eVar3 != null && eVar3.isShowing()) {
                                        this.F.dismiss();
                                    }
                                    this.F = new e(this, getResources().getString(R.string.update_email__mobile_otp) + " " + this.f51833h.getUserDefaultInfo().getPhone(), state, this);
                                    this.F.setCanceledOnTouchOutside(false);
                                    this.F.show();
                                }
                            } else if (message != null && message.trim().length() > 0) {
                                e eVar4 = this.F;
                                if (eVar4 != null && eVar4.isShowing()) {
                                    this.F.dismiss();
                                }
                                a("", (CharSequence) message);
                            }
                        } else if (message != null && message.trim().length() > 0) {
                            a("", (CharSequence) message);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRValidateEmailOtpStatus) {
                f();
                CJRValidateEmailOtpStatus cJRValidateEmailOtpStatus = (CJRValidateEmailOtpStatus) iJRPaytmDataModel2;
                if (cJRValidateEmailOtpStatus != null) {
                    String status3 = cJRValidateEmailOtpStatus.getStatus();
                    String str3 = cJRValidateEmailOtpStatus.getmResponseCode();
                    String message2 = cJRValidateEmailOtpStatus.getMessage();
                    if (status3 != null && status3.trim().length() > 0) {
                        if (status3.equalsIgnoreCase("SUCCESS")) {
                            if (message2 != null && message2.trim().length() > 0) {
                                e eVar5 = this.F;
                                if (eVar5 != null && eVar5.isShowing()) {
                                    this.F.dismiss();
                                }
                                if (str3 == null || !str3.equalsIgnoreCase("05")) {
                                    String string2 = getResources().getString(R.string.profile_verify_email_msg);
                                    CharSequence g2 = g(message2);
                                    this.U = true;
                                    a(string2, g2);
                                    return;
                                }
                                String string3 = getResources().getString(R.string.profile_check_email_msg);
                                if (!TextUtils.isEmpty(message2)) {
                                    CharSequence g3 = g(message2);
                                    this.U = true;
                                    a(string3, g3);
                                }
                            }
                        } else if (message2 != null && message2.trim().length() > 0 && (eVar2 = this.F) != null && eVar2.isShowing()) {
                            this.F.a(message2);
                            this.F.a(true);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJREmailResendOtpStatus) {
                f();
                CJREmailResendOtpStatus cJREmailResendOtpStatus = (CJREmailResendOtpStatus) iJRPaytmDataModel2;
                if (cJREmailResendOtpStatus != null) {
                    String status4 = cJREmailResendOtpStatus.getStatus();
                    String message3 = cJREmailResendOtpStatus.getMessage();
                    if (status4 == null || !status4.equalsIgnoreCase("SUCCESS")) {
                        e eVar6 = this.F;
                        if (eVar6 != null && eVar6.isShowing()) {
                            this.F.a(message3);
                            this.F.a(true);
                            this.F.b(true);
                        }
                    } else if (cJREmailResendOtpStatus.getmResponseCode() != null && cJREmailResendOtpStatus.getmResponseCode().equals("06") && (eVar = this.F) != null) {
                        eVar.f52367b = cJREmailResendOtpStatus.getState();
                        if (this.F.isShowing()) {
                            this.F.b(true);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRMobileOtpStatus) {
                f();
                CJRMobileOtpStatus cJRMobileOtpStatus = (CJRMobileOtpStatus) iJRPaytmDataModel2;
                if (cJRMobileOtpStatus != null) {
                    String status5 = cJRMobileOtpStatus.getStatus();
                    String str4 = cJRMobileOtpStatus.getmResponseCode();
                    String state2 = cJRMobileOtpStatus.getState();
                    String message4 = cJRMobileOtpStatus.getMessage();
                    if (status5 == null || !status5.equalsIgnoreCase("SUCCESS")) {
                        if (message4 != null && message4.trim().length() > 0) {
                            a("", (CharSequence) message4);
                        }
                    } else if (str4 != null && str4.trim().length() > 0) {
                        if (str4.equalsIgnoreCase("03")) {
                            f((String) null, state2);
                        } else if (str4.equalsIgnoreCase("04")) {
                            e(state2, (String) null);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRMobileResendOtpStatus) {
                CJRMobileResendOtpStatus cJRMobileResendOtpStatus = (CJRMobileResendOtpStatus) iJRPaytmDataModel2;
                if (cJRMobileResendOtpStatus != null) {
                    String status6 = cJRMobileResendOtpStatus.getStatus();
                    String message5 = cJRMobileResendOtpStatus.getMessage();
                    if (status6 != null && status6.equalsIgnoreCase("SUCCESS")) {
                        String str5 = this.L;
                        if (str5 != null && str5.trim().length() > 0) {
                            if (this.L.equalsIgnoreCase("current")) {
                                g gVar = this.G;
                                if (gVar != null && gVar.isShowing()) {
                                    this.G.a(true);
                                    g gVar2 = this.G;
                                    if (!TextUtils.isEmpty(message5) && gVar2.f52391b != null) {
                                        gVar2.f52391b.setVisibility(0);
                                        gVar2.f52391b.setTextColor(androidx.core.content.b.c(gVar2.getContext(), R.color.green));
                                        gVar2.f52391b.setText(message5);
                                    }
                                    if (cJRMobileResendOtpStatus.getmResponseCode() != null && cJRMobileResendOtpStatus.getmResponseCode().equals("06") && cJRMobileResendOtpStatus.getState() != null) {
                                        this.G.f52392c = cJRMobileResendOtpStatus.getState();
                                    }
                                }
                            } else if (this.L.equalsIgnoreCase("new") && (fVar2 = this.H) != null && fVar2.isShowing()) {
                                this.H.b(true);
                                f fVar3 = this.H;
                                if (!TextUtils.isEmpty(message5) && fVar3.f52378a != null) {
                                    fVar3.f52378a.setVisibility(0);
                                    fVar3.f52378a.setTextColor(androidx.core.content.b.c(fVar3.getContext(), R.color.green));
                                    fVar3.f52378a.setText(message5);
                                }
                                if (cJRMobileResendOtpStatus.getmResponseCode() != null && cJRMobileResendOtpStatus.getmResponseCode().equals("06") && cJRMobileResendOtpStatus.getState() != null) {
                                    this.H.f52379b = cJRMobileResendOtpStatus.getState();
                                }
                            }
                        }
                    } else if (message5 != null && message5.trim().length() > 0 && (str = this.L) != null && str.trim().length() > 0) {
                        if (this.L.equalsIgnoreCase("current")) {
                            g gVar3 = this.G;
                            if (gVar3 != null && gVar3.isShowing()) {
                                this.G.a(true);
                                this.G.a(message5);
                            }
                        } else if (this.L.equalsIgnoreCase("new") && (fVar = this.H) != null && fVar.isShowing()) {
                            this.H.b(true);
                            this.H.a(message5);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRValidateMobileOtpStatus) {
                final CJRValidateMobileOtpStatus cJRValidateMobileOtpStatus = (CJRValidateMobileOtpStatus) iJRPaytmDataModel2;
                if (cJRValidateMobileOtpStatus != null) {
                    String status7 = cJRValidateMobileOtpStatus.getStatus();
                    String str6 = cJRValidateMobileOtpStatus.getmResponseCode();
                    String message6 = cJRValidateMobileOtpStatus.getMessage();
                    if (status7 != null && status7.equalsIgnoreCase("SUCCESS")) {
                        f fVar4 = this.H;
                        if (fVar4 != null && fVar4.isShowing()) {
                            this.H.dismiss();
                        }
                        if (str6 == null || !str6.equals("05")) {
                            if (str6 != null && str6.equals("06")) {
                                final net.one97.paytm.oauth.d.a aVar = new net.one97.paytm.oauth.d.a(this);
                                String string4 = getString(R.string.merge_mobile_verified);
                                aVar.f52598c.setVisibility(0);
                                aVar.f52596a.setVisibility(8);
                                if (TextUtils.isEmpty(string4)) {
                                    aVar.f52598c.setText(aVar.f52597b.getString(net.one97.paytm.oauth.R.string.alert));
                                } else {
                                    aVar.f52598c.setText(string4);
                                }
                                aVar.a(getString(R.string.merge_account_verified));
                                aVar.a(-1, (CharSequence) getString(R.string.yes_i_did), (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        aVar.cancel();
                                        if (cJRValidateMobileOtpStatus.getState() != null) {
                                            EmailMobileActivity emailMobileActivity = EmailMobileActivity.this;
                                            String state = cJRValidateMobileOtpStatus.getState();
                                            try {
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("Authorization", b.m());
                                                hashMap.put("Content-Type", "application/json");
                                                hashMap.put("session_token", t.c((Context) emailMobileActivity));
                                                c.a();
                                                String e2 = b.e((Context) emailMobileActivity, c.a("userWallet", (String) null));
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("state", state);
                                                jSONObject.put("doNotRedirect", true);
                                                String jSONObject2 = jSONObject.toString();
                                                com.paytm.network.a a2 = d.a(emailMobileActivity, e2, emailMobileActivity, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject2, new CheckUserWallet(), a.c.AUTH, a.b.USER_FACING);
                                                if (com.paytm.utility.a.m(emailMobileActivity)) {
                                                    emailMobileActivity.a((Context) emailMobileActivity, emailMobileActivity.getString(R.string.please_wait_progress_msg));
                                                    a2.a();
                                                    return;
                                                }
                                                r.a(a2, (Context) emailMobileActivity, (DialogInterface.OnCancelListener) emailMobileActivity);
                                            } catch (Exception e3) {
                                                if (b.v) {
                                                    q.b(e3.getMessage());
                                                }
                                            }
                                        }
                                    }
                                });
                                aVar.a(-2, (CharSequence) getString(R.string.no_i_didnt), (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        if (cJRValidateMobileOtpStatus.getState() != null) {
                                            EmailMobileActivity.this.a(cJRValidateMobileOtpStatus.getState(), true);
                                        }
                                    }
                                });
                                aVar.show();
                            }
                        } else if (!TextUtils.isEmpty(message6)) {
                            String string5 = getResources().getString(R.string.there_you_go);
                            String phone = this.f51834i.getUserDefaultInfo().getPhone();
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            View inflate = getLayoutInflater().inflate(R.layout.layout_sucess_otp_dialog, (ViewGroup) null);
                            ((TextView) inflate.findViewById(R.id.dialog_title)).setText(string5);
                            ((TextView) inflate.findViewById(R.id.sucess_msg)).setText("Your number has been updated to");
                            ((TextView) inflate.findViewById(R.id.sucess_number)).setText(phone);
                            builder.setInverseBackgroundForced(true);
                            builder.setCancelable(false);
                            builder.setView(inflate);
                            ((Button) inflate.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener(builder.show(), phone) {
                                private final /* synthetic */ AlertDialog f$1;
                                private final /* synthetic */ String f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    EmailMobileActivity.this.a(this.f$1, this.f$2, view);
                                }
                            });
                            com.paytm.utility.a.c();
                            StringBuilder sb = new StringBuilder();
                            c.a();
                            sb.append(c.a(PaymentsGTMConstants.USER_DETAILS, (String) null));
                            sb.append("?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE");
                            com.paytm.network.a a3 = d.a(this, sb.toString(), new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    if (!EmailMobileActivity.this.isFinishing() && (iJRPaytmDataModel instanceof CJRUserInfoV2)) {
                                        EmailMobileActivity.b(EmailMobileActivity.this, (CJRUserInfoV2) iJRPaytmDataModel);
                                    }
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    EmailMobileActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                                }
                            }, t.f(this), e(), a.C0715a.GET, (String) null, new CJRUserInfoV2(), a.c.AUTH, a.b.SILENT);
                            if (com.paytm.utility.a.m(this)) {
                                a3.a();
                            } else {
                                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
                            }
                        }
                    } else if (status7 != null && status7.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) && str6 != null && str6.trim().length() > 0) {
                        if (str6.equalsIgnoreCase("772")) {
                            f fVar5 = this.H;
                            if (fVar5 != null && fVar5.isShowing()) {
                                this.H.a(true);
                                this.H.a(message6);
                            }
                        } else if (str6.equalsIgnoreCase("771")) {
                            f fVar6 = this.H;
                            if (fVar6 != null && fVar6.isShowing()) {
                                this.H.dismiss();
                            }
                            e(this.N, message6);
                        } else {
                            f fVar7 = this.H;
                            if (fVar7 != null && fVar7.isShowing()) {
                                this.H.a(true);
                                this.H.a(message6);
                            }
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJROTPStatus) {
                CJROTPStatus cJROTPStatus = (CJROTPStatus) iJRPaytmDataModel2;
                if (cJROTPStatus == null) {
                    return;
                }
                if ("SUCCESS".equalsIgnoreCase(cJROTPStatus.getStatus())) {
                    j jVar = this.I;
                    if (jVar != null && jVar.isShowing()) {
                        this.I.dismiss();
                    }
                    com.paytm.utility.a.c();
                    StringBuilder sb2 = new StringBuilder();
                    c.a();
                    sb2.append(c.a(PaymentsGTMConstants.USER_DETAILS, (String) null));
                    sb2.append("?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE");
                    com.paytm.network.a a4 = d.a(this, sb2.toString(), new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (!EmailMobileActivity.this.isFinishing() && (iJRPaytmDataModel instanceof CJRUserInfoV2)) {
                                EmailMobileActivity.c(EmailMobileActivity.this, (CJRUserInfoV2) iJRPaytmDataModel);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            EmailMobileActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                        }
                    }, t.f(this), e(), a.C0715a.GET, (String) null, new CJRUserInfoV2(), a.c.AUTH, a.b.USER_FACING);
                    if (com.paytm.utility.a.m(this)) {
                        a4.a();
                    } else {
                        r.a(a4, (Context) this, (DialogInterface.OnCancelListener) this);
                    }
                    a("", (CharSequence) this.f51826a.getString(R.string.msg_mobile_verified));
                    return;
                }
                j jVar2 = this.I;
                if (jVar2 != null && jVar2.isShowing()) {
                    this.I.a(cJROTPStatus.getErrorMsg());
                    this.I.a(true);
                }
            } else if (iJRPaytmDataModel2 instanceof CJRGetOTP) {
                f();
                CJRGetOTP cJRGetOTP = (CJRGetOTP) iJRPaytmDataModel2;
                if (cJRGetOTP == null) {
                    return;
                }
                if (cJRGetOTP.getStatus() != null && cJRGetOTP.getStatus().equalsIgnoreCase("SUCCESS")) {
                    j jVar3 = this.I;
                    if (jVar3 != null && jVar3.isShowing()) {
                        this.I.dismiss();
                    }
                    this.I = new j(this, getResources().getString(R.string.profile_otp_msg), this);
                    this.I.setCanceledOnTouchOutside(true);
                    this.I.show();
                } else if (cJRGetOTP.getErrorMsg() != null && cJRGetOTP.getErrorMsg().trim().length() > 0) {
                    a("", (CharSequence) cJRGetOTP.getErrorMsg());
                }
            } else if (iJRPaytmDataModel2 instanceof CJRGetValidateResendOTP) {
                f();
                CJRGetValidateResendOTP cJRGetValidateResendOTP = (CJRGetValidateResendOTP) iJRPaytmDataModel2;
                if (cJRGetValidateResendOTP != null) {
                    String status8 = cJRGetValidateResendOTP.getStatus();
                    String errorMsg = cJRGetValidateResendOTP.getErrorMsg();
                    if (status8 == null || status8.trim().length() <= 0 || !status8.equalsIgnoreCase("SUCCESS")) {
                        j jVar4 = this.I;
                        if (jVar4 != null && jVar4.isShowing()) {
                            this.I.a(errorMsg);
                            this.I.b(true);
                            return;
                        }
                        return;
                    }
                    j jVar5 = this.I;
                    if (jVar5 != null && jVar5.isShowing()) {
                        this.I.b(true);
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CheckUserWallet) {
                m();
                final CheckUserWallet checkUserWallet = (CheckUserWallet) iJRPaytmDataModel2;
                if (checkUserWallet != null && checkUserWallet.getStatus() != null) {
                    if (checkUserWallet.getStatus().equalsIgnoreCase("success")) {
                        if (checkUserWallet.getResponseCode() != null && checkUserWallet.getResponseCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            if (checkUserWallet.getWalletType() != null && checkUserWallet.getWalletType().equalsIgnoreCase("prime")) {
                                final net.one97.paytm.oauth.d.a aVar2 = new net.one97.paytm.oauth.d.a(this);
                                aVar2.setTitle((CharSequence) null);
                                aVar2.setCancelable(false);
                                aVar2.a(checkUserWallet.getMessage());
                                aVar2.a(-1, (CharSequence) getString(R.string.dialog_continue), (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        aVar2.cancel();
                                        if (checkUserWallet.getState() != null) {
                                            EmailMobileActivity.this.a(checkUserWallet.getState(), false);
                                        }
                                    }
                                });
                                aVar2.a(-2, (CharSequence) getString(R.string.cancel), (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        aVar2.cancel();
                                        if (checkUserWallet.getState() != null) {
                                            EmailMobileActivity.this.a(checkUserWallet.getState(), false);
                                        }
                                    }
                                });
                                aVar2.show();
                            } else if (checkUserWallet.getState() != null) {
                                a(checkUserWallet.getState(), false);
                            }
                        }
                    } else if (!TextUtils.isEmpty(checkUserWallet.getMessage())) {
                        b.b((Context) this, getString(R.string.error), checkUserWallet.getMessage());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        Intent intent = new Intent(this, MergeAccountActivity.class);
        intent.putExtra("state", str);
        intent.putExtra("openConsentDialog", z);
        startActivity(intent);
    }

    private HashMap<String, String> e() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("screen_name", getLocalClassName());
        return hashMap;
    }

    private static CharSequence g(String str) {
        String d2 = d("(\\w+)(\\.\\w+)*@(\\w+\\.)(\\w+)(\\.\\w+)*", str);
        return Html.fromHtml(str.replaceFirst(d2, "<p dir=\"ltr\"><font color =\"#00baf2\"><a href=\"" + d2 + "\">" + d2 + "</a></font></p>"));
    }

    private void f() {
        try {
            if (!isFinishing() && this.J == null) {
                this.J = new CJRSmsReceiver();
                this.J.f69560a = this;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                intentFilter.setPriority(1000);
                registerReceiver(this.J, intentFilter);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : register");
                com.paytm.utility.a.c();
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void e(String str, String str2) {
        this.N = str;
        g gVar = this.G;
        if (gVar != null && gVar.isShowing()) {
            this.G.dismiss();
        }
        this.G = new g(this, String.format(getString(R.string.profile_otp_old_mobile_msg), new Object[]{this.f51833h.getUserDefaultInfo().getPhone()}), str, this);
        this.G.setCanceledOnTouchOutside(false);
        this.G.show();
        if (str2 != null && str2.trim().length() > 0) {
            this.G.a(str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, String str, View view) {
        alertDialog.dismiss();
        Intent intent = new Intent();
        intent.putExtra("mobileNumber", str);
        setResult(-1, intent);
        v();
        finish();
    }

    /* access modifiers changed from: private */
    public void a(CJRUserInfoV2 cJRUserInfoV2) {
        this.f51834i = cJRUserInfoV2;
        String phone = cJRUserInfoV2.getUserDefaultInfo().getPhone();
        if (!phone.equals(this.f51833h.getUserDefaultInfo().getPhone())) {
            this.j = true;
        }
        if (this.j) {
            this.j = false;
            h(phone);
            return;
        }
        onBackPressed();
    }

    private void h(String str) {
        c.a();
        String a2 = c.a("updatePhoneV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContactColumn.PHONE_NUMBER, str);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b(getApplicationContext()));
            com.paytm.network.a a3 = d.a(this, a2, this, e3, (Map<String, String>) null, a.C0715a.PUT, jSONObject.toString(), new CJRMobileOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(getApplicationContext())) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    private void f(String str, String str2) {
        f fVar = this.H;
        if (fVar != null && fVar.isShowing()) {
            this.H.dismiss();
        }
        this.H = new f(this, String.format(getString(R.string.profile_otp_new_msg_mobile_msg), new Object[]{this.f51834i.getUserDefaultInfo().getPhone()}), str2, str, this);
        this.H.setCanceledOnTouchOutside(false);
        this.H.show();
    }

    private void u() {
        try {
            if (this.J != null) {
                unregisterReceiver(this.J);
                this.J.f69560a = null;
                this.J = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                com.paytm.utility.a.c();
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void a(String str) {
        this.L = "current";
        g(str, "current");
    }

    private void g(String str, String str2) {
        c.a();
        String a2 = c.a("profileResendOTPV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    jSONObject.put("state", str);
                } catch (JSONException e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
            jSONObject.put("type", str2);
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b((Context) this));
            this.M = true;
            com.paytm.network.a a3 = d.a(this, a2, this, e3, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRMobileResendOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    public final void a(String str, String str2) {
        if (str2 != null && str2.trim().length() > 0) {
            g gVar = this.G;
            if (gVar != null && gVar.isShowing()) {
                this.G.dismiss();
            }
            f(str, str2);
        }
    }

    public final void b(String str) {
        this.L = "new";
        g(str, "new");
    }

    public final void e(String str) {
        String userId = this.f51833h.getUserId();
        if (str != null && str.trim().length() > 0) {
            c.a();
            String a2 = c.a("validatePhone", (String) null);
            Map<String, String> e2 = t.e(this);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", userId);
                jSONObject.put("otp", str);
            } catch (Exception e3) {
                if (b.v) {
                    q.b(e3.getMessage());
                }
            }
            com.paytm.network.a a3 = d.a(this, a2, this, e2, e(), a.C0715a.POST, jSONObject.toString(), new CJROTPStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    public final void b(String str, String str2) {
        String e2;
        String e3;
        String e4;
        if (!isFinishing()) {
            g gVar = this.G;
            if (!(gVar == null || !gVar.isShowing() || (e4 = b.e(str, str2)) == null)) {
                g gVar2 = this.G;
                if (!(e4 == null || gVar2.f52390a == null)) {
                    gVar2.f52390a.setText(e4);
                }
                u();
            }
            e eVar = this.F;
            if (!(eVar == null || !eVar.isShowing() || (e3 = b.e(str, str2)) == null)) {
                e eVar2 = this.F;
                if (!(e3 == null || eVar2.f52366a == null)) {
                    eVar2.f52366a.setText(e3);
                }
                u();
            }
            j jVar = this.I;
            if (jVar != null && jVar.isShowing() && (e2 = b.e(str, str2)) != null) {
                j jVar2 = this.I;
                if (!(e2 == null || jVar2.f52407a == null)) {
                    jVar2.f52407a.setText(e2);
                }
                u();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(EditTextWithLabel editTextWithLabel, TextView textView, AlertDialog alertDialog, View view) {
        String obj = editTextWithLabel.getText().toString();
        if (obj == null || obj.trim().length() != 10) {
            textView.setVisibility(0);
            textView.setText(this.f51826a.getString(R.string.invalid_mobile_number));
            return;
        }
        alertDialog.dismiss();
        if (this.f51833h.getUserDefaultInfo().getPhone() == null || !this.f51833h.getUserDefaultInfo().getPhone().equalsIgnoreCase(obj)) {
            h(obj);
            return;
        }
        c.a();
        String a2 = c.a("getOTP", (String) null);
        Map<String, String> e2 = t.e(getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f51833h.getUserId());
            jSONObject.put(ContactColumn.PHONE_NUMBER, this.f51833h.getUserDefaultInfo().getPhone());
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
        }
        com.paytm.network.a a3 = d.a(this, a2, this, e2, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRGetOTP(), a.c.AUTH, a.b.USER_FACING);
        if (com.paytm.utility.a.m(getApplicationContext())) {
            a3.a();
        } else {
            r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CustomEditText customEditText, TextView textView, AlertDialog alertDialog, View view) {
        String text = customEditText.getText();
        if (text.trim().length() == 0) {
            textView.setVisibility(0);
            textView.setText(this.f51826a.getString(R.string.invalid_email_id_message));
            return;
        }
        alertDialog.dismiss();
        if (text.equals(this.f51833h.getUserDefaultInfo().getEmail())) {
            c.a();
            String a2 = c.a("emailVerificationLink", (String) null);
            Map<String, String> e2 = t.e(this);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", this.f51833h.getUserId());
                jSONObject.put(AppConstants.KEY_EMAIL, this.f51833h.getUserDefaultInfo().getEmail());
            } catch (Exception e3) {
                if (b.v) {
                    q.b(e3.getMessage());
                }
            }
            com.paytm.network.a a3 = d.a(this, a2, this, e2, e(), a.C0715a.POST, jSONObject.toString(), new CJRStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        } else {
            i(text);
        }
    }

    private void i(String str) {
        c.a();
        String a2 = c.a("updateEmailV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AppConstants.KEY_EMAIL, str);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b((Context) this));
            com.paytm.network.a a3 = d.a(this, a2, this, e3, e(), a.C0715a.PUT, jSONObject.toString(), new CJREmailOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    private void a(String str, CharSequence charSequence) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.layout_sucess_otp_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sucess_msg);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sucess_number);
        View findViewById = inflate.findViewById(R.id.seperator);
        if (str == null || str.trim().length() <= 0) {
            textView.setVisibility(8);
            findViewById.setVisibility(8);
        } else {
            textView.setText(str);
        }
        textView3.setVisibility(8);
        textView2.setText(charSequence);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        button.setText(R.string.ok);
        builder.setInverseBackgroundForced(true);
        builder.setCancelable(false);
        builder.setView(inflate);
        AlertDialog show = builder.show();
        button.setOnClickListener(new View.OnClickListener(show) {
            private final /* synthetic */ AlertDialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                EmailMobileActivity.this.b(this.f$1, view);
            }
        });
        if (this.U) {
            TextView textView4 = (TextView) inflate.findViewById(R.id.btnNegative);
            textView4.setVisibility(0);
            textView4.setText(getString(R.string.lbl_open_email_app));
            textView4.setOnClickListener(new View.OnClickListener(show) {
                private final /* synthetic */ AlertDialog f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    EmailMobileActivity.this.a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        if (this.U) {
            this.U = false;
            v();
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        if (this.U) {
            OAuthUtils.a((Context) this, getString(R.string.lbl_select_app_to_verify_link));
            this.U = false;
            finish();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing() && !d.a().a((Activity) this, networkCustomError)) {
            this.R = this.f51826a.getString(R.string.network_error_message) + " " + networkCustomError.getUrl();
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                r.a((Activity) this, (Exception) networkCustomError, EmailMobileActivity.class.getName(), getIntent().getExtras());
            } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                runOnUiThread(new Runnable(networkCustomError) {
                    private final /* synthetic */ NetworkCustomError f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        EmailMobileActivity.this.b(this.f$1);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
            b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
        } else if (networkCustomError.getMessage() != null && networkCustomError.getAlertMessage() != null) {
            b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
        }
    }

    public final void c() {
        if (this.O) {
            this.O = false;
            this.P = false;
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        u();
        super.onStop();
    }

    public void onEditViewClick(View view) {
        super.onEditViewClick(view);
        CJRUserInfoV2 cJRUserInfoV2 = new CJRUserInfoV2();
        CJRUserDefaultInfo cJRUserDefaultInfo = new CJRUserDefaultInfo();
        cJRUserInfoV2.setUserDefaultInfo(cJRUserDefaultInfo);
        if (this.f51827b.equalsIgnoreCase("mobile")) {
            if (!b.b(this.V.getText().toString())) {
                a("", (CharSequence) this.f51826a.getString(R.string.invalid_mobile_message));
                return;
            }
            cJRUserDefaultInfo.setPhone(this.V.getText().toString());
            if (!ag.a(getApplicationContext()).b("is_upi_user", false, true)) {
                a(cJRUserInfoV2);
            } else if (!cJRUserInfoV2.getUserDefaultInfo().getPhone().equals(this.f51833h.getUserDefaultInfo().getPhone())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setMessage(R.string.upi_change_mobile_msg);
                builder.setPositiveButton(R.string.continue_text, new DialogInterface.OnClickListener(cJRUserInfoV2) {
                    private final /* synthetic */ CJRUserInfoV2 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        EmailMobileActivity.this.a(this.f$1, dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(R.string.cancel, $$Lambda$EmailMobileActivity$y1HK94svx5KZHy8nXVv7eGOtWY.INSTANCE);
                builder.show();
            } else {
                onBackPressed();
            }
        } else if (!this.f51827b.equalsIgnoreCase(AppConstants.KEY_EMAIL)) {
            v();
            finish();
        } else if (!b.d(this.W.getText().toString())) {
            a("", (CharSequence) this.f51826a.getString(R.string.invalid_email_id_message));
        } else {
            cJRUserDefaultInfo.setEmail(this.W.getText().toString());
            this.f51834i = cJRUserInfoV2;
            String email = cJRUserInfoV2.getUserDefaultInfo().getEmail();
            if (!email.equals(this.f51833h.getUserDefaultInfo().getEmail())) {
                this.k = true;
            }
            if (this.k) {
                this.k = false;
                i(email);
                return;
            }
            onBackPressed();
        }
    }

    private void v() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            inputMethodManager.hideSoftInputFromWindow(this.V.getWindowToken(), 0);
            inputMethodManager.hideSoftInputFromWindow(this.W.getWindowToken(), 0);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        v();
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1094 && i3 == -1 && intent != null) {
            this.W.setText(((Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential")).f8122a);
            try {
                this.W.setSelection(this.W.getText().length());
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        c.a();
        String a2 = c.a("profileValidateOTPV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            if (str3 != null) {
                try {
                    jSONObject.put("state", str3);
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
            if (str != null && str.trim().length() > 0) {
                jSONObject.put("currentPhoneOtp", str);
            }
            if (str2 != null) {
                jSONObject.put("updatedPhoneOtp", str2);
            }
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b((Context) this));
            com.paytm.network.a a3 = d.a(this, a2, this, e3, e(), a.C0715a.POST, jSONObject.toString(), new CJRValidateMobileOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    public final void b() {
        c.a();
        String a2 = c.a("getOTP", (String) null);
        Map<String, String> e2 = t.e(this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f51833h.getUserId());
            jSONObject.put(ContactColumn.PHONE_NUMBER, this.f51833h.getUserDefaultInfo().getPhone());
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
        }
        com.paytm.network.a a3 = d.a(this, a2, this, e2, e(), a.C0715a.POST, jSONObject.toString(), new CJRGetValidateResendOTP(), a.c.AUTH, a.b.USER_FACING);
        if (com.paytm.utility.a.m(this)) {
            a3.a();
        } else {
            r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    public final void f(String str) {
        c.a();
        String a2 = c.a("profileResendOTPV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                try {
                    jSONObject.put("state", str);
                } catch (JSONException e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
            jSONObject.put("type", "current");
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b((Context) this));
            this.M = true;
            com.paytm.network.a a3 = d.a(this, a2, this, e3, e(), a.C0715a.POST, jSONObject.toString(), new CJREmailResendOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    public final void c(String str, String str2) {
        c.a();
        String a2 = c.a("profileValidateOTPV3", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject();
            if (str2 != null) {
                try {
                    jSONObject.put("state", str2);
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
            jSONObject.put("currentPhoneOtp", str);
            Map<String, String> e3 = t.e(this);
            e3.put("session_token", t.b((Context) this));
            com.paytm.network.a a3 = d.a(this, a2, this, e3, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRValidateEmailOtpStatus(), a.c.AUTH, a.b.USER_FACING);
            if (com.paytm.utility.a.m(this)) {
                a3.a();
            } else {
                r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(final CJRUserInfoV2 cJRUserInfoV2, DialogInterface dialogInterface, int i2) {
        net.one97.paytm.upi.profile.b.b a2 = g.a();
        a((Context) this, getString(R.string.upi_deleting_profile));
        if (a2 != null) {
            a2.b((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    EmailMobileActivity.this.m();
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (baseUpiResponse.isSuccess() && "0".equals(baseUpiResponse.getResponse())) {
                            EmailMobileActivity.this.a(cJRUserInfoV2);
                        } else if (TextUtils.isEmpty(baseUpiResponse.getMessage())) {
                            Toast.makeText(EmailMobileActivity.this, R.string.some_went_wrong, 1).show();
                        } else {
                            Toast.makeText(EmailMobileActivity.this, baseUpiResponse.getMessage(), 1).show();
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    EmailMobileActivity.this.m();
                    Toast.makeText(EmailMobileActivity.this, R.string.some_went_wrong, 1).show();
                }
            }, this.X, this.Y);
        }
        dialogInterface.dismiss();
    }

    static /* synthetic */ void b(EmailMobileActivity emailMobileActivity, CJRUserInfoV2 cJRUserInfoV2) {
        if (!emailMobileActivity.K) {
            emailMobileActivity.K = true;
        }
        emailMobileActivity.f51833h = cJRUserInfoV2;
        if (cJRUserInfoV2 != null) {
            l.a(cJRUserInfoV2, (Context) emailMobileActivity);
        }
    }

    static /* synthetic */ void c(EmailMobileActivity emailMobileActivity, CJRUserInfoV2 cJRUserInfoV2) {
        if (!emailMobileActivity.K) {
            emailMobileActivity.K = true;
        }
        emailMobileActivity.f51833h = cJRUserInfoV2;
        if (cJRUserInfoV2 != null) {
            l.a(cJRUserInfoV2, (Context) emailMobileActivity);
        }
    }
}
