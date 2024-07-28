package net.one97.paytm.paymentsBank.customView;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.utils.i;
import net.one97.paytm.paymentsBank.utils.q;

public class CustomNumberToTextEditTextView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f18214a;

    /* renamed from: b  reason: collision with root package name */
    private TextInputLayout f18215b;

    /* renamed from: c  reason: collision with root package name */
    private CustomAmountTextInputEditText f18216c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18217d;

    /* renamed from: e  reason: collision with root package name */
    private c f18218e;

    /* renamed from: f  reason: collision with root package name */
    private int f18219f = -1;

    /* renamed from: g  reason: collision with root package name */
    private a f18220g;

    public interface a {
        void a();

        void a(long j);
    }

    public void setTypeFaceStyle(int i2) {
    }

    public CustomAmountTextInputEditText getEdtAmount() {
        return this.f18216c;
    }

    public CustomNumberToTextEditTextView(Context context) {
        super(context);
        this.f18214a = context;
        a();
    }

    public void setEditTextListener(a aVar) {
        this.f18220g = aVar;
    }

    public CustomNumberToTextEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18214a = context;
        a();
    }

    private void a() {
        inflate(this.f18214a, R.layout.view_number_to_text_edit_text, this);
        this.f18215b = (TextInputLayout) findViewById(R.id.amount_til);
        this.f18216c = (CustomAmountTextInputEditText) findViewById(R.id.tiet_amount);
        this.f18217d = (TextView) findViewById(R.id.tv_redeem_words);
        this.f18216c.setMaxDigitsAfterDecimalPoint(8);
        int i2 = this.f18219f;
        if (i2 != -1) {
            this.f18216c.setMaxDigitsBeforeDecimalPoint(i2);
        }
        this.f18216c.setDecimalFormat("##,##,##,##,##0.");
        this.f18216c.setIntegerFormat("##,##,##,##,##0");
        this.f18216c.a();
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f18216c;
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([0-9]{1})([0-9,]{0,");
        sb.append(this.f18216c.getMaxDigitsBeforeDecimalPoint() - 1);
        sb.append("})?)(?:\\.[0-9]{0,");
        sb.append(this.f18216c.getMaxDigitsAfterDecimalPoint() - 1);
        sb.append("})?");
        customAmountTextInputEditText.setRegex(sb.toString());
        this.f18218e = q.a(this.f18216c).debounce(100, TimeUnit.MILLISECONDS).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new g() {
            public final void accept(Object obj) {
                CustomNumberToTextEditTextView.this.a((String) obj);
            }
        });
    }

    public void setNoOfDigitBeforeDecimal(int i2) {
        this.f18219f = i2;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.f18215b.setError((CharSequence) null);
        this.f18215b.setErrorEnabled(false);
        try {
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(str);
            if (TextUtils.isEmpty(ab)) {
                this.f18217d.setText("");
                this.f18220g.a();
                return;
            }
            long parseLong = Long.parseLong(net.one97.paytm.bankCommon.mapping.a.ab(ab));
            this.f18217d.setText(this.f18214a.getString(R.string.fd_rupees, new Object[]{i.a(parseLong)}));
            this.f18217d.setVisibility(0);
            this.f18220g.a(parseLong);
        } catch (NumberFormatException e2) {
            com.paytm.utility.q.b(e2.getMessage());
            this.f18217d.setVisibility(4);
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (!this.f18218e.isDisposed()) {
            this.f18218e.dispose();
        }
    }
}
