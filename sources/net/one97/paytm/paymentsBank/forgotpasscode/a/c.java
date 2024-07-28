package net.one97.paytm.paymentsBank.forgotpasscode.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.payments.activity.AJRChangePasscode;
import net.one97.paytm.payments.model.CJROauthAadharValidate;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.p;
import net.one97.paytm.paymentsBank.pdc.b.a;
import net.one97.paytm.paymentsBank.utils.m;

public class c extends p implements a {

    /* renamed from: a  reason: collision with root package name */
    private View f18380a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f18381b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18382c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18383d;

    /* renamed from: e  reason: collision with root package name */
    private PinEntryView f18384e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f18385f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f18386g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18387h;

    /* renamed from: i  reason: collision with root package name */
    private String f18388i;
    private d j;
    /* access modifiers changed from: private */
    public int k = 4;
    private TextView l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(20);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18380a = layoutInflater.inflate(R.layout.ppb_fragment_aadhar_validate_passcode_v2, (ViewGroup) null, false);
        return this.f18380a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.l = (TextView) a(R.id.hint_tv);
        a(R.id.iv_motif);
        this.f18381b = (TextView) a(R.id.titleTv);
        this.f18382c = (TextView) a(R.id.subTitleTv);
        this.f18383d = (TextView) a(R.id.descTv);
        this.f18384e = (PinEntryView) a(R.id.otpView);
        this.f18385f = (EditText) a(R.id.et_driving_license);
        this.f18386g = (TextView) a(R.id.forgot_passcode_error_text);
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
        this.f18384e.setOnPinEnteredListener(new PinEntryView.b() {
            public final void a(String str) {
                c.this.a(str);
            }

            public final void af_() {
                c.this.f18386g.setVisibility(8);
                c.this.a(R.color.color_fafafa, (Object) null);
            }
        });
        this.f18385f.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (c.this.f18385f.getText().length() == c.this.k) {
                    c.d(c.this);
                }
            }
        });
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("subTitle");
        String string3 = getArguments().getString("desc");
        this.f18387h = getArguments().getBoolean("et_enabled");
        this.f18388i = getArguments().getString("challengeType");
        String string4 = getArguments().getString("accno");
        this.k = getArguments().getInt("digits", 4);
        this.f18384e.setDigits(this.k);
        new InputFilter[1][0] = new InputFilter.LengthFilter(this.k);
        this.f18385f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.k)});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        if (!TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string2) && string2.contains(string4)) {
            spannableStringBuilder.setSpan(new StyleSpan(1), string2.indexOf(string4), string2.indexOf(string4) + string4.length(), 18);
        }
        this.f18381b.setText(string);
        this.f18382c.setText(spannableStringBuilder);
        this.f18383d.setText(string3);
        if (this.f18387h) {
            this.f18385f.setVisibility(0);
            this.f18384e.setVisibility(8);
            this.l.setVisibility(0);
        } else {
            this.f18385f.setVisibility(8);
            this.f18384e.setVisibility(0);
            this.l.setVisibility(8);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                c.this.a();
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        EditText editText;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (!this.f18387h) {
                editText = this.f18384e.getEditText();
            } else {
                editText = this.f18385f;
            }
            editText.requestFocus();
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = (d) getActivity();
    }

    private View a(int i2) {
        return this.f18380a.findViewById(i2);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("challengeType", this.f18388i);
        hashMap.put("challengeVal", str);
        d dVar = this.j;
        if (dVar != null) {
            dVar.onFragmentAction(100, hashMap);
        }
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        if (iJRPaytmDataModel != null) {
            q();
            if (iJRPaytmDataModel instanceof CJROauthAadharValidate) {
                CJROauthAadharValidate cJROauthAadharValidate = (CJROauthAadharValidate) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(cJROauthAadharValidate.getAccessToken())) {
                    Intent intent = new Intent(getActivity(), AJRChangePasscode.class);
                    intent.putExtra("forgot_passcode_access", cJROauthAadharValidate.getAccessToken());
                    startActivity(intent);
                    getActivity().finish();
                } else if ("FAILURE".equalsIgnoreCase(cJROauthAadharValidate.getStatus())) {
                    b.b((Context) getActivity(), getString(R.string.error), cJROauthAadharValidate.getMessage());
                } else {
                    b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        m.a(getActivity(), "passcode_forgot_enter_kyc_back", "forgot passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        getActivity().onBackPressed();
    }

    public final void a(Object obj) {
        this.f18384e.a();
        a(R.color.fp_color_ffefef, obj);
        this.f18385f.setText("");
    }

    public final void a(int i2, Object obj) {
        PinEntryView pinEntryView = this.f18384e;
        if (pinEntryView != null) {
            pinEntryView.setDigitBackground(i2);
        }
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                this.f18384e.setDigitCurserInitialState("");
                this.f18386g.setText(str);
                this.f18386g.setVisibility(0);
                return;
            }
        }
        this.f18386g.setVisibility(8);
    }

    static /* synthetic */ void d(c cVar) {
        if (cVar.f18387h) {
            if (TextUtils.isEmpty(cVar.f18385f.getText()) || cVar.f18385f.getText().length() != cVar.k) {
                net.one97.paytm.bankCommon.mapping.a.b((Context) cVar.getActivity(), cVar.getString(R.string.error), cVar.getString(R.string.pb_ovd_pls_enter_valid_number));
            } else {
                cVar.a(cVar.f18385f.getText().toString());
            }
        } else if (TextUtils.isEmpty(cVar.f18384e.getText()) || cVar.f18384e.getText().length() != cVar.k) {
            net.one97.paytm.bankCommon.mapping.a.b((Context) cVar.getActivity(), cVar.getString(R.string.error), cVar.getString(R.string.pb_ovd_pls_enter_valid_number));
        } else {
            cVar.a(cVar.f18384e.getText().toString());
        }
    }
}
