package net.one97.paytm.p2mNewDesign.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.j;
import com.paytm.utility.q;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.c.r;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f13244a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f13245b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13246c;

    /* renamed from: d  reason: collision with root package name */
    private j f13247d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f13248e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13249f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f13250g;

    /* renamed from: h  reason: collision with root package name */
    private g f13251h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13252i;

    public final void onClick(View view) {
        String str;
        InstrumentInfo instrumentInfo;
        List<InstrumentInfo> list;
        int id = view.getId();
        boolean z = false;
        if (id == R.id.rb_instrumentInfo || id == R.id.rl_pay_mode_pg) {
            if (!this.f13249f) {
                this.f13252i.setButtonDrawable(b.a(this.f13244a, R.drawable.ic_radio_active));
                this.f13249f = true;
                this.f13248e.setVisibility(0);
                InstrumentInfo instrumentInfo2 = new InstrumentInfo();
                instrumentInfo2.setPayMode("BHIM UPI");
                this.f13251h.a(instrumentInfo2, "uncheck");
                this.f13251h.a(instrumentInfo2, "sectionClose");
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                    }
                }, 200);
                this.f13250g.requestFocus();
                this.f13245b.postDelayed(new Runnable() {
                    public final void run() {
                        ((InputMethodManager) d.this.f13244a.getSystemService("input_method")).toggleSoftInput(2, 1);
                    }
                }, 100);
            }
        } else if (id == R.id.payment_proceed_pay_btn_prefill_amount) {
            String obj = this.f13250g.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                Context context = this.f13244a;
                Toast.makeText(context, context.getResources().getString(R.string.enter_vpa_address), 1).show();
            } else if (!obj.contains("@")) {
                Context context2 = this.f13244a;
                Toast.makeText(context2, context2.getResources().getString(R.string.enter_valid_vpa_address), 1).show();
            } else {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b() != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b().size() > 0) {
                    Iterator<PaymentModesV2> it2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        PaymentModesV2 next = it2.next();
                        if ("UPI".equals(next.getPaymentMode())) {
                            Iterator<PayChannelOptionsV2> it3 = next.getPayChannelOptions().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                PayChannelOptionsV2 next2 = it3.next();
                                if ("UPIPUSH".equalsIgnoreCase(next2.getChannelCode())) {
                                    str = next2.getChannelCode();
                                    break;
                                }
                            }
                        }
                    }
                }
                str = null;
                boolean z2 = (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c() == null || str == null || !"UPIPUSH".equalsIgnoreCase(str)) ? false : true;
                if (z2 && (list = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m) != null && list.size() > 0) {
                    instrumentInfo = null;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list.size()) {
                            break;
                        }
                        instrumentInfo = list.get(i2);
                        if ((instrumentInfo instanceof UpiInstrumentInfo) && ((UpiProfileDefaultBank) ((UpiInstrumentInfo) instrumentInfo).getUpiDataModel()).getVirtualAddress().equalsIgnoreCase(obj)) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                } else {
                    instrumentInfo = null;
                }
                if (!z2 || !z) {
                    instrumentInfo = new InstrumentInfo();
                    instrumentInfo.setPayMode("UPI");
                    instrumentInfo.setPaymentDetails(obj);
                    instrumentInfo.setDisplayPrimaryInfo(obj);
                    instrumentInfo.setPaymentTypeId("UPI");
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
                    this.f13251h.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "proceedToPay");
                } else {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
                    this.f13251h.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "proceedToPay");
                }
                if (this.f13246c) {
                    JSONObject jSONObject = instrumentInfo.getmAdditionalParams();
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        jSONObject.put("addMoney", "1");
                    } catch (JSONException e2) {
                        q.d(String.valueOf(e2));
                    }
                    instrumentInfo.setmAdditionalParams(jSONObject);
                }
            }
        } else if (id == R.id.tv_how_it_works) {
            new r().show(this.f13247d, (String) null);
        }
    }

    public final void a() {
        this.f13248e.setVisibility(8);
        this.f13252i.setButtonDrawable(b.a(this.f13244a, R.drawable.ic_radio_inactive));
        this.f13249f = false;
        LinearLayout linearLayout = this.f13245b;
        Context context = this.f13244a;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (linearLayout != null) {
                inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
            }
        }
    }
}
