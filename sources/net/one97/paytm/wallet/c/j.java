package net.one97.paytm.wallet.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.i.h;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.f.m;

public class j extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f70046a = j.class.getName();

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f70047b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f70048c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f70049d;

    /* renamed from: e  reason: collision with root package name */
    private Button f70050e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f70051f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f70052g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70053h;

    /* renamed from: i  reason: collision with root package name */
    private m f70054i;

    public static j a() {
        return new j();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.qr_request_gen_fragment, viewGroup, false);
        this.f70050e = (Button) inflate.findViewById(R.id.gen_qr_btn);
        this.f70048c = (EditText) inflate.findViewById(R.id.qr_request_money_amount);
        this.f70049d = (EditText) inflate.findViewById(R.id.qr_request_remarks);
        this.f70047b = (RelativeLayout) inflate.findViewById(R.id.wave_bg);
        this.f70052g = inflate.findViewById(R.id.remarks_separator);
        this.f70051f = inflate.findViewById(R.id.amount_separator);
        m mVar = this.f70054i;
        if (mVar != null) {
            mVar.a(getString(R.string.request_money));
        }
        try {
            b.a().sendGTMOpenScreenWithDeviceInfo(getActivity(), "/wallet/request-money/qr", "Wallet");
        } catch (Exception unused) {
        }
        this.f70053h = (TextView) inflate.findViewById(R.id.txt_amount_error);
        this.f70048c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    try {
                        j.this.f70051f.setBackgroundResource(R.drawable.edit_view_divider_selected);
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                } else {
                    j.this.f70051f.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f70049d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    try {
                        j.this.f70052g.setBackgroundResource(R.drawable.edit_view_divider_selected);
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                } else {
                    j.this.f70052g.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
        this.f70048c.requestFocus();
        this.f70048c.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                j.this.a(false, (String) null);
            }
        });
        this.f70050e.setOnClickListener(this);
        this.f70047b.setOnClickListener(this);
        String stringFromGTM = b.a().getStringFromGTM(getActivity(), "max_digit_paytmcash");
        int parseInt = !TextUtils.isEmpty(stringFromGTM) ? Integer.parseInt(stringFromGTM) : 0;
        if (parseInt <= 0) {
            parseInt = 5;
        }
        this.f70048c.setFilters(new InputFilter[]{com.paytm.utility.b.a(parseInt)});
        return inflate;
    }

    public void onAttach(Activity activity) {
        if (activity instanceof AJRQRActivity) {
            this.f70054i = (m) activity;
        }
        super.onAttach(activity);
    }

    private void a(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(str).setMessage(str2).setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                j.this.f70048c.setText("");
            }
        });
        builder.show();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.gen_qr_btn) {
            b();
            Double valueOf = Double.valueOf(0.0d);
            if (!TextUtils.isEmpty(this.f70048c.getText())) {
                try {
                    valueOf = Double.valueOf(Double.parseDouble(this.f70048c.getText().toString()));
                    if (valueOf.doubleValue() < 1.0d) {
                        a(getString(R.string.transaction_limit_header), getString(R.string.transaction_limit_message_min_request));
                        return;
                    } else if (valueOf.doubleValue() > n.j.doubleValue()) {
                        a(getString(R.string.transaction_limit_header), getString(R.string.transaction_limit_message_request));
                        return;
                    }
                } catch (NumberFormatException unused) {
                    a(true, getString(R.string.wallet_amount_error));
                    return;
                }
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("wallet_request_qr_amount", String.valueOf(valueOf));
                hashMap.put("wallet_request_qr_comment", this.f70049d.getText().toString());
                b.a().sendCustomGTMEvent(getActivity(), "wallet_request_generate_qr_clicked", hashMap);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
            b.a().startQRDisplayActivity(getActivity(), valueOf, this.f70049d.getText().toString());
        } else if (id == R.id.qr_header_close_menu) {
            b();
            getActivity().onBackPressed();
        } else if (id == R.id.wave_bg) {
            this.f70048c.requestFocus();
            if (getActivity() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                View currentFocus = getActivity().getCurrentFocus();
                if (currentFocus != null) {
                    inputMethodManager.showSoftInput(currentFocus, 1);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str) {
        if (z && str != null) {
            if (this.f70053h.getVisibility() != 0) {
                this.f70053h.setVisibility(0);
            }
            this.f70053h.setText(str);
            this.f70051f.setBackgroundResource(R.drawable.edit_view_divider_error);
        } else if (this.f70053h.getVisibility() == 0) {
            this.f70053h.setVisibility(4);
            this.f70053h.setText("");
            if (this.f70048c.hasFocus()) {
                this.f70051f.setBackgroundResource(R.drawable.edit_view_divider_selected);
            } else {
                this.f70051f.setBackgroundResource(R.drawable.edit_view_divider);
            }
        }
    }

    private void b() {
        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            View currentFocus = getActivity().getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 1);
            }
        }
    }
}
