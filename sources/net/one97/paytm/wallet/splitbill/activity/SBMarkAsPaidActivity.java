package net.one97.paytm.wallet.splitbill.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;

public class SBMarkAsPaidActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f72007a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Button f72008b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f72009c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f72010d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextView f72011e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f72012f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f72013g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f72014h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f72015i;
    private String j;
    private Double k;
    private Double l;
    private Double m;
    private boolean n = false;
    /* access modifiers changed from: private */
    public LottieAnimationView o;
    private TextWatcher p = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SBMarkAsPaidActivity.this.f72011e.setVisibility(8);
            if (charSequence.toString().length() > 0) {
                SBMarkAsPaidActivity.this.f72010d.setTextColor(SBMarkAsPaidActivity.this.getResources().getColor(R.color.color_222222));
            } else {
                SBMarkAsPaidActivity.this.f72010d.setTextColor(SBMarkAsPaidActivity.this.getResources().getColor(R.color.color_b8c2cb));
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_layout_mark_as_paid);
        if (getIntent() != null) {
            if (getIntent().hasExtra("amount")) {
                this.k = Double.valueOf(getIntent().getDoubleExtra("amount", 0.0d));
                this.l = Double.valueOf(Math.abs(this.k.doubleValue()));
            }
            if (getIntent().hasExtra("mode")) {
                this.f72013g = getIntent().getStringExtra("mode");
            }
            if (getIntent().hasExtra("payerId")) {
                this.f72014h = getIntent().getStringExtra("payerId");
            }
            if (getIntent().hasExtra("payeeId")) {
                this.f72015i = getIntent().getStringExtra("payeeId");
            }
            if (getIntent().hasExtra("fromHome")) {
                this.n = getIntent().getBooleanExtra("fromHome", false);
            }
            if (getIntent().hasExtra("user_name")) {
                this.j = getIntent().getStringExtra("user_name");
            }
        }
        this.f72007a = (ImageView) findViewById(R.id.split_back_button);
        this.f72008b = (Button) findViewById(R.id.proceedToBill);
        this.f72010d = (TextView) findViewById(R.id.sb_rupees_symbol);
        this.f72012f = (TextView) findViewById(R.id.tvUserName);
        if (!TextUtils.isEmpty(this.j)) {
            this.f72012f.setText(this.j);
        } else {
            this.f72012f.setText("Receiver");
        }
        this.f72009c = (EditText) findViewById(R.id.et_amount);
        this.o = (LottieAnimationView) findViewById(R.id.lav_lottie_loader);
        this.f72011e = (TextView) findViewById(R.id.amount_error);
        this.f72009c.addTextChangedListener(this.p);
        this.f72009c.setTypeface(Typeface.create("sans-serif-medium", 0));
        EditText editText = this.f72009c;
        editText.setText(b.a(Double.valueOf(Math.abs(this.k.doubleValue()))));
        this.f72009c.setSelection(b.a(Double.valueOf(Math.abs(this.k.doubleValue()))).length());
        this.f72007a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBMarkAsPaidActivity.this.finish();
            }
        });
        this.f72008b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(SBMarkAsPaidActivity.this.f72009c.getText().toString().trim())) {
                    SBMarkAsPaidActivity.this.f72008b.setBackgroundColor(SBMarkAsPaidActivity.this.getResources().getColor(R.color.grid_offer_blue));
                    SBMarkAsPaidActivity.this.f72008b.setClickable(false);
                    try {
                        a.a(SBMarkAsPaidActivity.this.o);
                    } catch (Exception e2) {
                        q.d(String.valueOf(e2));
                    }
                    String trim = SBMarkAsPaidActivity.this.f72009c.getText().toString().trim();
                    SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
                    sBMarkAsPaid.setPaymentMode(SBMarkAsPaidActivity.this.f72013g);
                    sBMarkAsPaid.setPayeeId(SBMarkAsPaidActivity.this.f72015i);
                    sBMarkAsPaid.setPayerId(SBMarkAsPaidActivity.this.f72014h);
                    sBMarkAsPaid.setTotalAmount(trim);
                    if (com.paytm.utility.b.c((Context) SBMarkAsPaidActivity.this)) {
                        SBMarkAsPaidActivity.a(SBMarkAsPaidActivity.this, sBMarkAsPaid);
                        return;
                    }
                    SBMarkAsPaidActivity.this.f72008b.setBackgroundColor(SBMarkAsPaidActivity.this.getResources().getColor(R.color.paytm_blue));
                    SBMarkAsPaidActivity.this.f72008b.setClickable(true);
                    try {
                        a.b(SBMarkAsPaidActivity.this.o);
                    } catch (Exception unused) {
                    }
                    Toast.makeText(SBMarkAsPaidActivity.this, "Please check your internet connection.", 0).show();
                    return;
                }
                SBMarkAsPaidActivity.this.f72011e.setVisibility(0);
            }
        });
    }

    private void a(String str, String str2, boolean z) {
        Intent intent = new Intent(this, SBLandingPageActivity.class);
        intent.putExtra("from", "mark_as_paid");
        intent.putExtra("mark_as_paid_status", z);
        intent.putExtra("mark_as_paid_message", str);
        intent.putExtra("mark_as_paid_sub_message", str2);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SBMarkAsPaid sBMarkAsPaid, f fVar) {
        String str;
        String str2;
        f fVar2 = fVar;
        if (fVar2.f55796a == h.SUCCESS) {
            this.f72008b.setBackgroundColor(getResources().getColor(R.color.paytm_blue));
            this.f72008b.setClickable(true);
            try {
                a.b(this.o);
            } catch (Exception unused) {
            }
            if (!(fVar2.f55797b instanceof SBUserSettlementBaseResponse)) {
                return;
            }
            if (((SBUserSettlementBaseResponse) fVar2.f55797b).getSuccess() == null || ((SBUserSettlementBaseResponse) fVar2.f55797b).getMessage() == null) {
                Intent intent = new Intent();
                intent.putExtra("mark_as_paid_message", getString(R.string.mark_as_paid_failure));
                intent.putExtra("mark_as_paid_status", false);
                setResult(-1, intent);
                finish();
                ArrayList arrayList = new ArrayList();
                arrayList.add("user2user");
                arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                arrayList.add(sBMarkAsPaid.getPaymentMode());
                b.a(this, "split_bill", "splitbill_markPay_success", arrayList, sBMarkAsPaid.getTotalAmount(), "/splitbill/markaspaid", "split_bill");
                return;
            }
            if (Double.parseDouble(this.f72009c.getText().toString()) == this.l.doubleValue()) {
                str2 = "Your bills with " + this.j + " have been settled up";
                str = "mark_as_paid_status";
            } else if (this.k.doubleValue() < 0.0d) {
                str = "mark_as_paid_status";
                this.m = Double.valueOf(Double.parseDouble(new DecimalFormat("#.##").format(this.l.doubleValue() - Double.parseDouble(this.f72009c.getText().toString()))));
                if (this.m.doubleValue() > 0.0d) {
                    str2 = this.j + " needs to pay you ₹" + b.a(Double.valueOf(Math.abs(this.m.doubleValue()))) + " to settle up";
                } else {
                    str2 = "You need to pay " + this.j + " ₹" + b.a(Double.valueOf(Math.abs(this.m.doubleValue()))) + " to settle up";
                }
            } else {
                str = "mark_as_paid_status";
                this.m = Double.valueOf(Double.parseDouble(new DecimalFormat("#.##").format(this.l.doubleValue() - Double.parseDouble(this.f72009c.getText().toString()))));
                if (this.m.doubleValue() > 0.0d) {
                    str2 = "You need to pay " + this.j + " ₹" + b.a(Double.valueOf(Math.abs(this.m.doubleValue()))) + " to settle up";
                } else {
                    str2 = this.j + " needs to pay you ₹" + b.a(Double.valueOf(Math.abs(this.m.doubleValue()))) + " to settle up";
                }
            }
            if (this.n) {
                if (((SBUserSettlementBaseResponse) fVar2.f55797b).getSuccess().booleanValue()) {
                    a(FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(this.f72009c.getText().toString()))) + " Marked as Paid", str2, true);
                } else {
                    a(getString(R.string.mark_as_paid_failure), "", false);
                }
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("mark_as_paid_message", FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(this.f72009c.getText().toString()))) + " Marked as Paid");
                intent2.putExtra("mark_as_paid_sub_message", str2);
                intent2.putExtra(str, ((SBUserSettlementBaseResponse) fVar2.f55797b).getSuccess());
                setResult(-1, intent2);
                finish();
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("user2user");
            arrayList2.add("success");
            arrayList2.add(sBMarkAsPaid.getPaymentMode());
            b.a(this, "split_bill", "splitbill_markPay_success", arrayList2, sBMarkAsPaid.getTotalAmount(), "/splitbill/markaspaid", "split_bill");
            return;
        }
        String str3 = "mark_as_paid_status";
        if (fVar2.f55796a == h.ERROR) {
            g gVar = fVar2.f55798c;
            this.f72008b.setBackgroundColor(getResources().getColor(R.color.paytm_blue));
            this.f72008b.setClickable(true);
            try {
                a.b(this.o);
            } catch (Exception unused2) {
            }
            if (gVar == null || !(gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                Intent intent3 = new Intent();
                intent3.putExtra("mark_as_paid_message", getString(R.string.mark_as_paid_failure));
                intent3.putExtra(str3, false);
                setResult(-1, intent3);
                finish();
            } else {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBMarkAsPaidActivity.class.getName(), (Bundle) null, false);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("user2user");
            arrayList3.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            arrayList3.add(sBMarkAsPaid.getPaymentMode());
            b.a(this, "split_bill", "splitbill_markPay_success", arrayList3, sBMarkAsPaid.getTotalAmount(), "/splitbill/markaspaid", "split_bill");
        }
    }

    static /* synthetic */ void a(SBMarkAsPaidActivity sBMarkAsPaidActivity, SBMarkAsPaid sBMarkAsPaid) {
        String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(sBMarkAsPaidActivity, "getMarkAsPaidURL")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(sBMarkAsPaidActivity, "getMarkAsPaidURL") : "https://prms.paytmbank.com/prms/ext/v1/user/payment";
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", b.class.getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(sBMarkAsPaidActivity));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("content-type", "application/json");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        com.google.gson.g gVar = new com.google.gson.g();
        gVar.f39467e = false;
        new net.one97.paytm.network.b(stringFromGTM, new SBUserSettlementBaseResponse(), hashMap, hashMap2, gVar.a().b(sBMarkAsPaid)).c().observeForever(new z(sBMarkAsPaid) {
            private final /* synthetic */ SBMarkAsPaid f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                SBMarkAsPaidActivity.this.a(this.f$1, (f) obj);
            }
        });
    }
}
