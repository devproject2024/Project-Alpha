package net.one97.paytm.bankCommon.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.TextView;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.i.h;

public class c extends h implements View.OnClickListener, PinEntryView.b {

    /* renamed from: a  reason: collision with root package name */
    public b f16236a;

    /* renamed from: b  reason: collision with root package name */
    public a f16237b;

    /* renamed from: c  reason: collision with root package name */
    public d f16238c;

    /* renamed from: d  reason: collision with root package name */
    private Context f16239d;

    /* renamed from: e  reason: collision with root package name */
    private PinEntryView f16240e;

    /* renamed from: f  reason: collision with root package name */
    private View f16241f;

    /* renamed from: g  reason: collision with root package name */
    private CheckBox f16242g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16243h = false;

    /* renamed from: i  reason: collision with root package name */
    private TextView f16244i;

    public interface a {
        void a();
    }

    public interface b {
        void a(String str, c cVar);

        void a(boolean z);

        void b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f16239d = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pb_fragment_passcode, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f16240e = (PinEntryView) getView().findViewById(R.id.otpView);
        this.f16240e.setOnPinEnteredListener(this);
        this.f16241f = getView().findViewById(R.id.payment_bank_set_passcode_btn_back);
        this.f16242g = (CheckBox) getView().findViewById(R.id.payment_bank_set_passcode_img_show_hide);
        this.f16242g.setOnClickListener(this);
        this.f16241f.setOnClickListener(this);
        this.f16240e.requestFocus();
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("extraForgotPasscode")) {
            this.f16244i = (TextView) getView().findViewById(R.id.tv_forgot_passcode);
            TextView textView = this.f16244i;
            if (textView != null) {
                textView.setText(arguments.getString("extraForgotPasscode"));
                if (this.f16237b != null) {
                    this.f16244i.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            c.this.f16237b.a();
                        }
                    });
                }
            }
        }
    }

    public final void a() {
        this.f16240e.setText("");
        this.f16240e.requestFocus();
        this.f16243h = false;
        d();
        ((InputMethodManager) this.f16239d.getSystemService("input_method")).showSoftInput(this.f16240e.getEditText(), 1);
    }

    private void d() {
        int i2 = this.f16243h ? R.color.bank_open_passcode_error_color_ffefef : R.color.bank_open_prv_passcode_color;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16239d.getResources().getDrawable(i2, this.f16239d.getTheme());
        } else {
            this.f16239d.getResources().getDrawable(i2);
        }
        this.f16240e.setDigitBackground(i2);
    }

    public void onClick(View view) {
        if (view == this.f16241f) {
            b bVar = this.f16236a;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        CheckBox checkBox = this.f16242g;
        if (view != checkBox) {
            return;
        }
        if (!checkBox.isChecked()) {
            this.f16240e.setMask("•");
            PinEntryView pinEntryView = this.f16240e;
            pinEntryView.setText(pinEntryView.getText().toString());
            return;
        }
        this.f16240e.setMask((String) null);
        PinEntryView pinEntryView2 = this.f16240e;
        pinEntryView2.setText(pinEntryView2.getText().toString());
    }

    public final void b() {
        this.f16241f.setVisibility(0);
    }

    public final void a(boolean z) {
        if (this.f16243h != z) {
            this.f16243h = z;
            if (this.f16243h) {
                this.f16240e.setText("");
                this.f16240e.requestFocus();
            }
            d();
            b bVar = this.f16236a;
            if (bVar != null) {
                bVar.a(z);
            }
        }
    }

    public final void a(String str) {
        b bVar;
        String obj = this.f16240e.getText().toString();
        if (obj.length() == this.f16240e.getDigits() && (bVar = this.f16236a) != null) {
            bVar.a(obj, this);
        }
    }

    public final void af_() {
        a(false);
    }
}
