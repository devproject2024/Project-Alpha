package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;

public class h extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f13344a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private View f13345b;

    /* renamed from: d  reason: collision with root package name */
    private Context f13346d;

    /* renamed from: e  reason: collision with root package name */
    private InstrumentInfo f13347e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13348f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13349g;

    /* renamed from: h  reason: collision with root package name */
    private String f13350h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13351i;
    private g j;
    private TextView k;
    private TextView l;
    private View m;

    public final String a() {
        return "UPI_ONBOARDING";
    }

    public final void a(String str) {
    }

    public final void b() {
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13347e = instrumentInfo;
        b(instrumentInfo);
        return this.f13345b;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13348f.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (b.f().b(instrumentInfo) && b.f().d(instrumentInfo.getPayMode())) {
            this.f13351i.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13348f.setTextColor(androidx.core.content.b.c(this.f13346d, R.color.black));
            this.f13348f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        }
        this.f13349g.setText(instrumentInfo.getDisplaySecondaryInfo());
        this.k.setVisibility(8);
        b.f();
        b.a(this.f13346d, (ImageView) this.f13345b.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        if (instrumentInfo != null && "UPI_ONBOARDING".equalsIgnoreCase(instrumentInfo.getPayMode())) {
            String trim = instrumentInfo.getmDisplayPrimaryInfo2().trim();
            if (!TextUtils.isEmpty(trim)) {
                this.l.setVisibility(0);
                this.l.setText(trim);
                this.l.setTextColor(androidx.core.content.b.c(this.f13346d, R.color.promotion_text_color));
            }
            ((ImageView) this.f13345b.findViewById(R.id.iv_card_type)).setImageDrawable(this.f13346d.getResources().getDrawable(R.drawable.ic_bhim));
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        b.f().z = view.getTag() != null ? ((Boolean) view.getTag()).booleanValue() : false;
        if (id != R.id.lyt_paytm_instrument && id != R.id.tv_instrument_secondary_info) {
            return;
        }
        if (b.f().J == null || b.f().H == null || !b.f().L) {
            if (b.f().t(this.j.d())) {
                this.j.n();
            }
            b.f();
            if (!b.q(this.f13347e.getPayMode())) {
                this.j.a("0".equalsIgnoreCase(b.f().A) ? this.f13346d.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13346d.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                return;
            }
            this.f13350h = this.j.d();
            this.f13351i.setChecked(true);
            this.f13351i.setButtonDrawable(androidx.core.content.b.a(this.f13346d, R.drawable.ic_radio_active));
            this.j.d("UPI_ONBOARDING");
            this.f13348f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            this.j.f(true);
            if (this.j != null) {
                this.f13347e.setUniqueId("UPI_ONBOARDING");
                this.j.a(this.f13347e, "uncheck");
                this.j.a(this.f13347e, "updateSelection");
                this.j.a(this.f13347e, "sectionClose");
                return;
            }
            return;
        }
        this.f51247c = false;
    }

    public final void a(g gVar) {
        this.j = gVar;
    }

    public final void a(boolean z) {
        if (z) {
            this.f13345b.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13351i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13346d, R.drawable.ic_radio_inactive));
        }
        this.f13348f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public final void b(boolean z) {
        if (z) {
            this.f13345b.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13351i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13346d, R.drawable.ic_radio_inactive));
        }
        this.f13348f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public final View c() {
        return this.f13345b;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return "UPI_ONBOARDING".equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13347e.getPriority();
    }

    public final boolean f() {
        if (this.f13347e.getmIsDisabled() == null) {
            return false;
        }
        return this.f13347e.getmIsDisabled().getStatus().booleanValue();
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13345b = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13346d = context;
        this.f13347e = instrumentInfo;
        this.f13350h = str;
        this.f13348f = (TextView) this.f13345b.findViewById(R.id.tv_instrument_primary_info);
        this.f13349g = (TextView) this.f13345b.findViewById(R.id.tv_instrument_secondary_info);
        this.k = (TextView) this.f13345b.findViewById(R.id.tv_instrument_primary_info_2);
        this.l = (TextView) this.f13345b.findViewById(R.id.tv_instrument_secondary_info_3);
        this.f13351i = (RadioButton) this.f13345b.findViewById(R.id.rb_instrumentInfo);
        this.m = this.f13345b.findViewById(R.id.divider);
        this.f13345b.findViewById(R.id.tv_instrument_secondary_info).setClickable(false);
        this.f13345b.findViewById(R.id.tv_instrument_secondary_info).setFocusable(false);
        this.m.setVisibility(0);
        this.f13345b.setOnClickListener(this);
        b(instrumentInfo);
    }
}
