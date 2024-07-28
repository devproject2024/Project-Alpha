package net.one97.paytm.upi.profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.android.chat.utils.KeyList;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.profile.a.c;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiConstants;

public class g extends h implements c.b {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f68250a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f68251b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68252c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f68253d;

    /* renamed from: e  reason: collision with root package name */
    private AppCompatEditText f68254e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f68255f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68256g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68257h;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f68251b = (c.a) obj;
    }

    public static g d() {
        return new g();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_create_vpa, viewGroup, false);
        this.f68252c = (TextView) inflate.findViewById(R.id.tv_proceed);
        this.f68254e = (AppCompatEditText) inflate.findViewById(R.id.edt_enter_vpa);
        this.f68250a = (TextInputLayout) inflate.findViewById(R.id.edt_enter_vpa_parent);
        this.f68255f = (ProgressBar) inflate.findViewById(R.id.pb_progress);
        this.f68253d = (RelativeLayout) inflate.findViewById(R.id.ll_add_vpa_container);
        this.f68256g = (TextView) inflate.findViewById(R.id.tv_bank_name);
        this.f68257h = (TextView) inflate.findViewById(R.id.tv_registration_status);
        b(getString(R.string.upi_create_vpa_new), getString(R.string.upi_create_vpa_msg));
        this.f68252c.setText(R.string.submit);
        this.f68255f.setVisibility(8);
        this.f68253d.setVisibility(0);
        this.f68252c.setVisibility(0);
        this.f68254e.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                g.this.f68250a.setError((CharSequence) null);
            }
        });
        this.f68252c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.f68251b.a(g.this.f68254e.getText().toString());
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f68251b.e();
    }

    public final void a() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f68254e.getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b(getString(R.string.upi_creating_payment_address), "");
        this.f68255f.setVisibility(0);
        this.f68253d.setVisibility(8);
        this.f68252c.setVisibility(8);
    }

    public final void a(String str, String str2) {
        e();
        if (TextUtils.isEmpty(str)) {
            this.f68250a.setError(getString(R.string.upi_some_went_wrong));
        } else if ("5".equals(str) || "74".equals(str)) {
            this.f68250a.setError(getString(R.string.upi_vpa_unavailable));
        } else {
            this.f68250a.setError(str2);
            if ("1006".equals(str)) {
                a((int) KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
            }
        }
        this.f68252c.setText(R.string.submit);
        b(getString(R.string.upi_create_vpa_new), getString(R.string.upi_create_vpa_msg));
    }

    public final void a(String str) {
        this.f68251b.b(str);
    }

    public final void b() {
        Toast.makeText(getActivity(), R.string.upi_vpa_save_success, 1).show();
        if (getActivity() != null) {
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }

    public final void b(String str) {
        b(getString(R.string.upi_vpa_save_error), getString(R.string.upi_press_retry_to_create_profile));
        if ("100".equals(str)) {
            this.f68250a.setError(getString(R.string.upi_lifetime_max_vpa));
        } else {
            this.f68250a.setError(getString(R.string.upi_some_went_wrong));
            if ("1006".equals(str)) {
                a((int) KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE);
            }
        }
        this.f68252c.setText(R.string.retry);
        e();
    }

    public final void c() {
        b(getString(R.string.upi_vpa_save_error), getString(R.string.upi_press_retry_to_create_profile));
        this.f68250a.setError(getString(R.string.upi_some_went_wrong));
        this.f68252c.setText(R.string.retry);
        e();
    }

    public final void a(UpiConstants.UpiVpaValidationError upiVpaValidationError) {
        if (UpiConstants.UpiVpaValidationError.MAX_LENGTH_BREACH.equals(upiVpaValidationError)) {
            this.f68250a.setError(getString(R.string.upi_vpa_length_breach));
        } else if (UpiConstants.UpiVpaValidationError.INVALID_CHARS.equals(upiVpaValidationError)) {
            this.f68250a.setError(getString(R.string.upi_invalid_vpa));
        } else if (UpiConstants.UpiVpaValidationError.EMPTY_VPA.equals(upiVpaValidationError)) {
            this.f68250a.setError(getString(R.string.upi_empty_vpa_error));
        } else if (UpiConstants.UpiVpaValidationError.ALPHANUMERIC_ERROR.equals(upiVpaValidationError)) {
            this.f68250a.setError(getString(R.string.upi_vpa_unavailable));
        }
    }

    private void e() {
        this.f68255f.setVisibility(8);
        this.f68253d.setVisibility(0);
        this.f68252c.setVisibility(0);
    }

    private void b(String str, String str2) {
        this.f68256g.setText(str);
        this.f68257h.setText(str2);
    }

    private void a(int i2) {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        startActivityForResult(intent, i2);
    }

    public void onDetach() {
        super.onDetach();
        this.f68251b.f();
    }
}
