package net.one97.paytm.paymentsBank.updateInfo.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.updateInfo.model.EmailOtpResponse;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class f extends net.one97.paytm.i.f implements g.a, g.b<IJRPaytmDataModel>, d {

    /* renamed from: a  reason: collision with root package name */
    private Context f19446a;

    /* renamed from: b  reason: collision with root package name */
    private String f19447b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19448c;

    /* renamed from: d  reason: collision with root package name */
    private b f19449d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f19450e;

    public final View a(int i2) {
        if (this.f19450e == null) {
            this.f19450e = new HashMap();
        }
        View view = (View) this.f19450e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f19450e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        EmailOtpResponse emailOtpResponse;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof EmailOtpResponse) && (emailOtpResponse = (EmailOtpResponse) iJRPaytmDataModel) != null) {
            String status = emailOtpResponse.getStatus();
            String mResponseCode = emailOtpResponse.getMResponseCode();
            String state = emailOtpResponse.getState();
            String message = emailOtpResponse.getMessage();
            if (isAdded() && status != null) {
                boolean z = false;
                if (!(p.b(status).toString().length() > 0)) {
                    return;
                }
                if (p.a(status, "SUCCESS", true)) {
                    if (mResponseCode == null || !p.a(mResponseCode, WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                        if (mResponseCode != null && p.a(mResponseCode, "02", true) && state != null) {
                            CharSequence charSequence = state;
                            int length = charSequence.length() - 1;
                            int i2 = 0;
                            boolean z2 = false;
                            while (i2 <= length) {
                                boolean z3 = charSequence.charAt(!z2 ? i2 : length) <= ' ';
                                if (z2) {
                                    if (!z3) {
                                        break;
                                    }
                                    length--;
                                } else if (!z3) {
                                    z2 = true;
                                } else {
                                    i2++;
                                }
                            }
                            if (charSequence.subSequence(i2, length + 1).toString().length() > 0) {
                                z = true;
                            }
                            if (z) {
                                this.f19447b = state;
                                String str = this.f19447b;
                                if (str == null) {
                                    k.a("mState");
                                }
                                String string = getString(R.string.pb_enter_otp_mobile);
                                k.a((Object) string, "getString(R.string.pb_enter_otp_mobile)");
                                this.f19449d = new b(getActivity(), string, this, str);
                                b bVar = this.f19449d;
                                if (bVar == null) {
                                    k.a("mValidateMobileOtpDialog");
                                }
                                bVar.setCanceledOnTouchOutside(true);
                                b bVar2 = this.f19449d;
                                if (bVar2 == null) {
                                    k.a("mValidateMobileOtpDialog");
                                }
                                bVar2.show();
                            }
                        }
                    } else if (message != null) {
                        CharSequence charSequence2 = message;
                        int length2 = charSequence2.length() - 1;
                        int i3 = 0;
                        boolean z4 = false;
                        while (i3 <= length2) {
                            boolean z5 = charSequence2.charAt(!z4 ? i3 : length2) <= ' ';
                            if (z4) {
                                if (!z5) {
                                    break;
                                }
                                length2--;
                            } else if (!z5) {
                                z4 = true;
                            } else {
                                i3++;
                            }
                        }
                        charSequence2.subSequence(i3, length2 + 1).toString().length();
                    }
                } else if (message != null) {
                    CharSequence charSequence3 = message;
                    int length3 = charSequence3.length() - 1;
                    int i4 = 0;
                    boolean z6 = false;
                    while (i4 <= length3) {
                        boolean z7 = charSequence3.charAt(!z6 ? i4 : length3) <= ' ';
                        if (z6) {
                            if (!z7) {
                                break;
                            }
                            length3--;
                        } else if (!z7) {
                            z6 = true;
                        } else {
                            i4++;
                        }
                    }
                    if (charSequence3.subSequence(i4, length3 + 1).toString().length() > 0) {
                        TextView textView = (TextView) a(R.id.tv_update_info_title);
                        k.a((Object) textView, "tv_update_info_title");
                        textView.setText(charSequence3);
                    }
                }
            }
        }
    }

    public final void a() {
        EditText editText = (EditText) a(R.id.et_enter_detail);
        k.a((Object) editText, "et_enter_detail");
        String obj = editText.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            b(obj);
        }
    }

    public final void a(String str) {
        k.c(str, "status");
        if (str.equals("SUCCESS")) {
            TextView textView = (TextView) a(R.id.tv_enter_field);
            k.a((Object) textView, "tv_enter_field");
            textView.setVisibility(8);
            EditText editText = (EditText) a(R.id.et_enter_detail);
            k.a((Object) editText, "et_enter_detail");
            editText.setVisibility(8);
            ((TextView) a(R.id.tv_update_info_title)).setText(R.string.pb_email_post_verify_title);
            TextView textView2 = (TextView) a(R.id.emailid_tv);
            k.a((Object) textView2, "emailid_tv");
            textView2.setVisibility(0);
            TextView textView3 = (TextView) a(R.id.emailid_tv);
            k.a((Object) textView3, "emailid_tv");
            EditText editText2 = (EditText) a(R.id.et_enter_detail);
            k.a((Object) editText2, "et_enter_detail");
            textView3.setText(editText2.getText());
            Button button = (Button) a(R.id.btn_update_info_proceed);
            k.a((Object) button, "btn_update_info_proceed");
            Context context = getContext();
            button.setText(context != null ? context.getString(R.string.ok) : null);
            ((Button) a(R.id.btn_update_info_proceed)).setOnClickListener(new c(this));
            ((TextView) a(R.id.tv_update_info_sub_title)).setText(R.string.pb_email_post_verify_subtitle);
            ImageView imageView = (ImageView) a(R.id.img_bs_cancel);
            k.a((Object) imageView, "img_bs_cancel");
            imageView.setVisibility(8);
            this.f19448c = true;
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f19453a;

        c(f fVar) {
            this.f19453a = fVar;
        }

        public final void onClick(View view) {
            this.f19453a.dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_update_info_bottom_sheet, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "this.context!!");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "this.context!!.applicationContext");
        this.f19446a = applicationContext;
        ((Button) a(R.id.btn_update_info_proceed)).setOnClickListener(new a(this));
        ((ImageView) a(R.id.img_bs_cancel)).setOnClickListener(new b(this));
        TextView textView = (TextView) a(R.id.emailid_tv);
        k.a((Object) textView, "emailid_tv");
        textView.setVisibility(8);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f19451a;

        a(f fVar) {
            this.f19451a = fVar;
        }

        public final void onClick(View view) {
            EditText editText = (EditText) this.f19451a.a(R.id.et_enter_detail);
            k.a((Object) editText, "et_enter_detail");
            if (editText.getVisibility() == 0) {
                EditText editText2 = (EditText) this.f19451a.a(R.id.et_enter_detail);
                k.a((Object) editText2, "et_enter_detail");
                String obj = editText2.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    net.one97.paytm.bankCommon.mapping.c.a(this.f19451a.getActivity(), "bank_verify_email", "input_email_value", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    this.f19451a.b(obj);
                } else {
                    Toast.makeText(this.f19451a.getContext(), this.f19451a.getString(R.string.pb_field_not_be_empty), 0).show();
                }
            } else {
                f fVar = this.f19451a;
                EditText editText3 = (EditText) fVar.a(R.id.et_fill_otp);
                k.a((Object) editText3, "et_fill_otp");
                f.a(fVar, editText3.getText().toString(), "");
            }
            if (this.f19451a.f19448c) {
                this.f19451a.dismiss();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f19452a;

        b(f fVar) {
            this.f19452a = fVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19452a.getActivity(), "bank_verify_email", "ignore", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            this.f19452a.dismiss();
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        String str2;
        Context context = this.f19446a;
        if (context == null) {
            k.a("mContext");
        }
        if (networkCustomError == null || (str = networkCustomError.getAlertTitle()) == null) {
            str = getString(R.string.pb_pdc_something_went_wrong);
        }
        if (networkCustomError == null || (str2 = networkCustomError.getMessage()) == null) {
            str2 = getString(R.string.error);
        }
        com.paytm.utility.b.b(context, str, str2);
    }

    public final void b(String str) {
        k.c(str, AppConstants.KEY_EMAIL);
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.b(), "GTMLoader.getInstance()");
        if (!TextUtils.isEmpty(d.K())) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.KEY_EMAIL, str);
            Context context = this.f19446a;
            if (context == null) {
                k.a("mContext");
            }
            if (com.paytm.utility.b.c(context)) {
                HashMap hashMap2 = new HashMap();
                String simpleName = getClass().getSimpleName();
                k.a((Object) simpleName, "javaClass.simpleName");
                hashMap2.put("screen_name", simpleName);
                Context context2 = this.f19446a;
                if (context2 == null) {
                    k.a("mContext");
                }
                net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.b.a.a(context2, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2);
                a2.a("Update Email Otp Post Request");
                Context context3 = this.f19446a;
                if (context3 == null) {
                    k.a("mContext");
                }
                context3.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(a2);
            }
        }
    }

    public static final /* synthetic */ void a(f fVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        String str3 = fVar.f19447b;
        if (str3 == null) {
            k.a("mState");
        }
        if (TextUtils.isEmpty(str3)) {
            String str4 = fVar.f19447b;
            if (str4 == null) {
                k.a("mState");
            }
            hashMap.put("state", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("currentPhoneOtp", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("updatedPhoneOtp", str2);
        }
        Context context = fVar.f19446a;
        if (context == null) {
            k.a("mContext");
        }
        if (com.paytm.utility.b.c(context)) {
            HashMap hashMap2 = new HashMap();
            String simpleName = fVar.getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap2.put("screen_name", simpleName);
            Context context2 = fVar.f19446a;
            if (context2 == null) {
                k.a("mContext");
            }
            net.one97.paytm.bankCommon.g.f b2 = net.one97.paytm.paymentsBank.b.a.b(context2, (g.b<IJRPaytmDataModel>) fVar, (g.a) fVar, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap, (HashMap<String, String>) hashMap2);
            b2.a("Update Email Otp Post Request");
            Context context3 = fVar.f19446a;
            if (context3 == null) {
                k.a("mContext");
            }
            context3.getApplicationContext();
            net.one97.paytm.bankCommon.g.c.a();
            net.one97.paytm.bankCommon.g.c.a(b2);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19450e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
