package net.one97.paytm.managebeneficiary;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.i.f;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f53247a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f53248b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f53249c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f53250d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f53251e;

    /* renamed from: f  reason: collision with root package name */
    private String f53252f;

    /* renamed from: g  reason: collision with root package name */
    private String f53253g;

    /* renamed from: h  reason: collision with root package name */
    private String f53254h;

    /* renamed from: i  reason: collision with root package name */
    private String f53255i;
    private Context j;
    private AppCompatEditText k;
    /* access modifiers changed from: private */
    public TextInputLayout l;
    private C0953a m;
    private TextWatcher n = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            a.this.l.setError("");
        }
    };

    /* renamed from: net.one97.paytm.managebeneficiary.a$a  reason: collision with other inner class name */
    public interface C0953a {
        void a(boolean z);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = context;
        if (context instanceof AddNewBeneficiaryV2Activity) {
            this.m = (AddNewBeneficiaryV2Activity) context;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f53253g = arguments.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
            this.f53254h = arguments.getString("accountHolderName");
            this.f53255i = arguments.getString("ifsc");
            this.f53252f = arguments.getString("bankName");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.add_beneficiary_bottom_sheet, viewGroup, false);
        this.f53247a = (ImageView) inflate.findViewById(R.id.bottomsheetclose);
        this.f53248b = (TextView) inflate.findViewById(R.id.bottomsheetbutton_proceed);
        this.f53250d = (TextView) inflate.findViewById(R.id.benef_bs_account_holder_name);
        this.f53249c = (TextView) inflate.findViewById(R.id.benef_bs_bank_name);
        this.f53251e = (TextView) inflate.findViewById(R.id.benef_bs_ifsc);
        this.l = (TextInputLayout) inflate.findViewById(R.id.layout_account_number_bs);
        this.k = (AppCompatEditText) inflate.findViewById(R.id.edit_account_number_bs);
        this.f53249c.setText(this.f53252f);
        this.f53250d.setText(this.f53254h);
        this.f53251e.setText(this.f53255i);
        this.f53247a.setOnClickListener(this);
        this.f53248b.setOnClickListener(this);
        this.k.setLongClickable(false);
        this.k.addTextChangedListener(this.n);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bottomsheetclose) {
            this.m.a(false);
            dismiss();
        } else if (id == R.id.bottomsheetbutton_proceed) {
            String obj = this.k.getText().toString();
            if (TextUtils.isEmpty(obj) || !obj.equalsIgnoreCase(this.f53253g)) {
                this.m.a(false);
                this.l.setError(this.j.getString(R.string.pb_mb_account_number_not_macth));
                return;
            }
            this.m.a(true);
            dismiss();
        }
    }
}
