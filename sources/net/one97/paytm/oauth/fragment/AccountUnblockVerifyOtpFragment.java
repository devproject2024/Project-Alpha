package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.gson.o;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.r;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.DoVerify;
import net.one97.paytm.oauth.models.DoViewResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.RenderDataRes;
import net.one97.paytm.oauth.models.ResultInfoRes;
import net.one97.paytm.oauth.models.ResultInfoResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.TerminalPageState;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;

public final class AccountUnblockVerifyOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56083a = {y.a((t) new u(y.b(AccountUnblockVerifyOtpFragment.class), "args", "<v#0>"))};

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.oauth.g.a f56084c;

    /* renamed from: d  reason: collision with root package name */
    private String f56085d;

    /* renamed from: e  reason: collision with root package name */
    private String f56086e;

    /* renamed from: f  reason: collision with root package name */
    private String f56087f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f56088g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f56089h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f56090i;
    private final String j = "true";
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class a<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockVerifyOtpFragment f56091a;

        a(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment) {
            this.f56091a = accountUnblockVerifyOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56091a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockVerifyOtpFragment.a(this.f56091a, (ErrorModel) t, eVar.f52605d, "");
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockVerifyOtpFragment.a(this.f56091a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockVerifyOtpFragment f56092a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56093b;

        b(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment, String str) {
            this.f56092a = accountUnblockVerifyOtpFragment;
            this.f56093b = str;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56092a.a(R.id.btnProceed);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        AccountUnblockVerifyOtpFragment.a(this.f56092a, (ErrorModel) t, eVar.f52605d, this.f56093b);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                AccountUnblockVerifyOtpFragment.a(this.f56092a, (IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public static final class d extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.$this_navArgs = fragment;
        }

        public final Bundle invoke() {
            Bundle arguments = this.$this_navArgs.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verify_number_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RoboTextView roboTextView = (RoboTextView) a(R.id.resendOtp);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new e(this));
        }
        g dVar = new androidx.navigation.d(y.b(q.class), new d(this));
        this.f56085d = ((q) dVar.getValue()).b();
        String a2 = ((q) dVar.getValue()).a();
        if (a2 == null) {
            a2 = "";
        }
        this.f56087f = a2;
        this.f56086e = ((q) dVar.getValue()).c();
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblDesc);
        k.a((Object) roboTextView2, "lblDesc");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.lbl_verify_otp);
        k.a((Object) string, "getString(R.string.lbl_verify_otp)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.f56085d}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        roboTextView2.setText(format);
        ((ProgressViewButton) a(R.id.btnConfirm)).setButtonText(getString(R.string.btn_proceed));
        x.a((x) this, false, 7);
        ai a3 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.a.class);
        k.a((Object) a3, "ViewModelProviders.of(th…ockViewModel::class.java)");
        this.f56084c = (net.one97.paytm.oauth.g.a) a3;
        v.a("/unblock_otp", "diy_unblock", "otp_screen_loaded", (ArrayList) null, 24);
    }

    public static final class e implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockVerifyOtpFragment f56097a;

        e(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment) {
            this.f56097a = accountUnblockVerifyOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56097a.a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.resendOtp;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/unblock_otp", "diy_unblock", "resend_otp_clicked", (ArrayList) null, 24);
            this.f56089h = true;
            a(this.f56087f, "OTP_SMS");
            return;
        }
        int i3 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i3) {
            d();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.f56656b > 0) {
            b();
        }
    }

    private final void a(String str, String str2) {
        if (str2.equals("SAVED_CARD")) {
            this.f56088g = true;
        }
        if (this.f56084c == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.a.b(str, str2).observe(this, new b(this, str2));
    }

    private final void d() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                String[] strArr = new String[3];
                strArr[0] = this.f56090i ? "auto_otp" : "otp";
                strArr[1] = d2;
                strArr[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
                v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
                RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                k.a((Object) roboTextView, "error_text_otp");
                roboTextView.setVisibility(0);
                RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                k.a((Object) roboTextView2, "error_text_otp");
                roboTextView2.setText(charSequence);
                return;
            }
            OAuthUtils.a((Activity) requireActivity());
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            o oVar = new o();
            oVar.a("data", otp);
            if (this.f56084c == null) {
                k.a("viewModel");
            }
            String str = this.f56087f;
            String oVar2 = oVar.toString();
            k.a((Object) oVar2, "obj.toString()");
            net.one97.paytm.oauth.g.a.a(str, oVar2, "OTP_SMS").observe(this, new a(this));
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountUnblockVerifyOtpFragment f56094a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56095b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f56096c;

        c(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment, String str, String str2) {
            this.f56094a = accountUnblockVerifyOtpFragment;
            this.f56095b = str;
            this.f56096c = str2;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AccountUnblockVerifyOtpFragment.a(this.f56094a, this.f56095b, this.f56096c);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        k.c(str, "otp");
        this.f56090i = true;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtp(str);
        }
        d();
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        k.c(aVar, "state");
        int i2 = p.f56608a[aVar.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView != null) {
                roboTextView.setVisibility(0);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.resendOtp);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(8);
            }
        } else if (i2 == 2) {
            String string = getString(R.string.lbl_resend_otp_in_seconds, Long.valueOf(j2 / 1000));
            k.a((Object) string, "getString(R.string.lbl_r…llisUntilFinished / 1000)");
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView3 != null) {
                roboTextView3.setText(string);
            }
        } else if (i2 == 3) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView4 != null) {
                roboTextView4.setVisibility(8);
            }
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.resendOtp);
            if (roboTextView5 != null) {
                roboTextView5.setVisibility(0);
            }
        }
    }

    private final void e() {
        r.a a2 = r.a();
        k.a((Object) a2, "AccountUnblockVerifyOtpF…ionAccountBlockTerminal()");
        a2.c();
        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
    }

    public static final /* synthetic */ void a(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String masked_card_list;
        String a2;
        String a3;
        String a4;
        String a5;
        AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment2 = accountUnblockVerifyOtpFragment;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        List<String> list = null;
        if (iJRPaytmDataModel2 instanceof DoViewResModel) {
            DoViewResModel doViewResModel = (DoViewResModel) iJRPaytmDataModel2;
            String httpStatus = doViewResModel.getHttpStatus();
            if (httpStatus != null && httpStatus.hashCode() == 49586 && httpStatus.equals("200")) {
                ResultInfoRes resultInfo = doViewResModel.getResultInfo();
                if (resultInfo == null || (str5 = resultInfo.getResultCode()) == null) {
                    str5 = "";
                }
                if (!str5.equals("SUCCESS")) {
                    accountUnblockVerifyOtpFragment.e();
                } else if (accountUnblockVerifyOtpFragment2.f56088g) {
                    r.b b2 = r.b();
                    k.a((Object) b2, "AccountUnblockVerifyOtpF…AccountUnblockSavedCard()");
                    b2.b(accountUnblockVerifyOtpFragment2.f56085d);
                    b2.a(accountUnblockVerifyOtpFragment2.f56086e);
                    b2.c(accountUnblockVerifyOtpFragment2.f56087f);
                    RenderDataRes renderData = doViewResModel.getRenderData();
                    if (!(renderData == null || (masked_card_list = renderData.getMasked_card_list()) == null || (a2 = p.a(masked_card_list, "\\", "", false)) == null || (a3 = p.a(a2, "\"", "", false)) == null || (a4 = p.a(a3, "[", "", false)) == null || (a5 = p.a(a4, "]", "", false)) == null)) {
                        list = p.a((CharSequence) a5, new String[]{AppConstants.COMMA});
                    }
                    if (list != null) {
                        String str6 = list.get(0);
                        int length = str6.length() - 4;
                        if (str6 != null) {
                            String substring = str6.substring(length);
                            k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                            b2.d(substring);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    androidx.navigation.fragment.a.a(accountUnblockVerifyOtpFragment).a((androidx.navigation.l) b2);
                } else if (accountUnblockVerifyOtpFragment2.f56089h) {
                    k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                    accountUnblockVerifyOtpFragment2.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                    accountUnblockVerifyOtpFragment.b();
                    x.a((x) accountUnblockVerifyOtpFragment2, false, 7);
                }
            } else {
                accountUnblockVerifyOtpFragment.e();
            }
        } else if (iJRPaytmDataModel2 instanceof DoVerify) {
            DoVerify doVerify = (DoVerify) iJRPaytmDataModel2;
            String httpStatus2 = doVerify.getHttpStatus();
            String str7 = "otp";
            if (httpStatus2 != null && httpStatus2.hashCode() == 49586 && httpStatus2.equals("200")) {
                ResultInfoResModel resultInfo2 = doVerify.getResultInfo();
                String resultCodeId = resultInfo2 != null ? resultInfo2.getResultCodeId() : null;
                if (resultCodeId != null) {
                    int hashCode = resultCodeId.hashCode();
                    if (hashCode != -1950136507) {
                        if (hashCode == -1173940224 && resultCodeId.equals("00000000")) {
                            v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, (ArrayList) null, 24);
                            accountUnblockVerifyOtpFragment2.a(accountUnblockVerifyOtpFragment2.f56087f, "SAVED_CARD");
                            return;
                        }
                    } else if (resultCodeId.equals("12011004")) {
                        String[] strArr = new String[4];
                        if (accountUnblockVerifyOtpFragment2.f56090i) {
                            str7 = "auto_otp";
                        }
                        strArr[0] = str7;
                        strArr[1] = String.valueOf(doVerify.getResultInfo().getResultMsg());
                        strArr[2] = SDKConstants.KEY_API;
                        strArr[3] = "12011004";
                        v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
                        if (k.a((Object) doVerify.getCanRetry(), (Object) accountUnblockVerifyOtpFragment2.j)) {
                            OtpView otpView = (OtpView) accountUnblockVerifyOtpFragment2.a(R.id.otpContainer);
                            if (otpView != null) {
                                otpView.a();
                            }
                            RoboTextView roboTextView = (RoboTextView) accountUnblockVerifyOtpFragment2.a(R.id.error_text_otp);
                            k.a((Object) roboTextView, "error_text_otp");
                            roboTextView.setVisibility(0);
                            RoboTextView roboTextView2 = (RoboTextView) accountUnblockVerifyOtpFragment2.a(R.id.error_text_otp);
                            k.a((Object) roboTextView2, "error_text_otp");
                            roboTextView2.setText(doVerify.getResultInfo().getResultMsg());
                            return;
                        }
                        r.a a6 = r.a();
                        k.a((Object) a6, "AccountUnblockVerifyOtpF…ionAccountBlockTerminal()");
                        a6.c();
                        a6.a(TerminalPageState.IS_LIMIT_EXCEED);
                        androidx.navigation.fragment.a.a(accountUnblockVerifyOtpFragment).a((androidx.navigation.l) a6);
                        return;
                    }
                }
                String[] strArr2 = new String[4];
                if (accountUnblockVerifyOtpFragment2.f56090i) {
                    str7 = "auto_otp";
                }
                strArr2[0] = str7;
                ResultInfoResModel resultInfo3 = doVerify.getResultInfo();
                if (resultInfo3 == null || (str3 = resultInfo3.getResultMsg()) == null) {
                    str3 = accountUnblockVerifyOtpFragment2.getString(R.string.some_went_wrong);
                    k.a((Object) str3, "getString(R.string.some_went_wrong)");
                }
                strArr2[1] = str3;
                strArr2[2] = SDKConstants.KEY_API;
                ResultInfoResModel resultInfo4 = doVerify.getResultInfo();
                if (resultInfo4 == null || (str4 = resultInfo4.getResultCodeId()) == null) {
                    str4 = "";
                }
                strArr2[3] = str4;
                v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr2), 16);
                accountUnblockVerifyOtpFragment.e();
                return;
            }
            String[] strArr3 = new String[4];
            if (accountUnblockVerifyOtpFragment2.f56090i) {
                str7 = "auto_otp";
            }
            strArr3[0] = str7;
            ResultInfoResModel resultInfo5 = doVerify.getResultInfo();
            if (resultInfo5 == null || (str = resultInfo5.getResultMsg()) == null) {
                str = accountUnblockVerifyOtpFragment2.getString(R.string.some_went_wrong);
                k.a((Object) str, "getString(R.string.some_went_wrong)");
            }
            strArr3[1] = str;
            strArr3[2] = SDKConstants.KEY_API;
            ResultInfoResModel resultInfo6 = doVerify.getResultInfo();
            if (resultInfo6 == null || (str2 = resultInfo6.getResultCodeId()) == null) {
                str2 = "";
            }
            strArr3[3] = str2;
            v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr3), 16);
            accountUnblockVerifyOtpFragment.e();
        }
    }

    public static final /* synthetic */ void a(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment, ErrorModel errorModel, String str, String str2) {
        if (OAuthUtils.a((Activity) accountUnblockVerifyOtpFragment.getActivity(), (Fragment) accountUnblockVerifyOtpFragment, errorModel.getCustomError())) {
            return;
        }
        if (errorModel.getStatus() == -1) {
            String string = accountUnblockVerifyOtpFragment.getString(R.string.no_connection);
            k.a((Object) string, "getString(R.string.no_connection)");
            String string2 = accountUnblockVerifyOtpFragment.getString(R.string.no_internet);
            k.a((Object) string2, "getString(R.string.no_internet)");
            OAuthUtils.a(accountUnblockVerifyOtpFragment.requireContext(), string, string2, new c(accountUnblockVerifyOtpFragment, str, str2));
            return;
        }
        String[] strArr = new String[4];
        strArr[0] = accountUnblockVerifyOtpFragment.f56090i ? "auto_otp" : "otp";
        String string3 = accountUnblockVerifyOtpFragment.getString(R.string.some_went_wrong);
        k.a((Object) string3, "getString(R.string.some_went_wrong)");
        strArr[1] = string3;
        strArr[2] = SDKConstants.KEY_API;
        strArr[3] = "";
        v.a("/unblock_otp", "diy_unblock", Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
        accountUnblockVerifyOtpFragment.e();
    }

    public static final /* synthetic */ void a(AccountUnblockVerifyOtpFragment accountUnblockVerifyOtpFragment, String str, String str2) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -333255865) {
                if (hashCode == 1860343963 && str.equals("oauthDoVerify")) {
                    accountUnblockVerifyOtpFragment.d();
                }
            } else if (str.equals("oauthDoView")) {
                accountUnblockVerifyOtpFragment.a(accountUnblockVerifyOtpFragment.f56087f, str2);
            }
        }
    }
}
