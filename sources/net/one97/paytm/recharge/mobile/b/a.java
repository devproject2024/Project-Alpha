package net.one97.paytm.recharge.mobile.b;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.n;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.c.e;

public class a extends p.d {

    /* renamed from: c  reason: collision with root package name */
    CJRFrequentOrder f63677c;

    /* renamed from: d  reason: collision with root package name */
    private final String f63678d = "dd MMM, yyyy";

    /* renamed from: e  reason: collision with root package name */
    private final TextView f63679e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f63680f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f63681g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f63682h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f63683i;
    private final View j;
    private final TextView k;
    private final TextView l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, CJRRecentOrderV8.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(aVar, "options");
        View findViewById = view.findViewById(R.id.beneficiary_name);
        if (findViewById != null) {
            this.f63679e = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.beneficiary_circle);
            if (findViewById2 != null) {
                this.f63680f = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.beneficiary_number);
                if (findViewById3 != null) {
                    this.f63681g = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.beneficiary_no_name_icon);
                    if (findViewById4 != null) {
                        this.f63682h = (ImageView) findViewById4;
                        this.f63683i = (ViewGroup) view.findViewById(R.id.parent_layout);
                        this.j = view.findViewById(R.id.separator);
                        View findViewById5 = view.findViewById(R.id.txt_automatic_bill_scheduled);
                        if (findViewById5 != null) {
                            this.k = (TextView) findViewById5;
                            View findViewById6 = view.findViewById(R.id.last_recharge_done);
                            if (findViewById6 != null) {
                                this.l = (TextView) findViewById6;
                                c();
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    /* renamed from: net.one97.paytm.recharge.mobile.b.a$a  reason: collision with other inner class name */
    static final class C1240a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63684a;

        C1240a(a aVar) {
            this.f63684a = aVar;
        }

        public final void onClick(View view) {
            CJRFrequentOrder cJRFrequentOrder;
            p.a aVar;
            e eVar = e.INSTANCE;
            k.a((Object) view, "view");
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63684a.f63677c) != null && (aVar = this.f63684a.f60653b.f61927e) != null) {
                aVar.c(cJRFrequentOrder, this.f63684a.getAdapterPosition());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f63683i.setOnClickListener(new C1240a(this));
    }

    public void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        k.c(cJRFrequentOrder, "recentOrder");
        this.f63677c = cJRFrequentOrder;
        String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
        this.f63681g.setText(rechargeNumber);
        n nVar = n.f61679a;
        k.a((Object) rechargeNumber, "rechargeNumber");
        ContactItemModel a2 = n.a(rechargeNumber);
        if (a2 != null) {
            k.c(a2, "contact");
            k.c(cJRFrequentOrder, "recentOrder");
            String name = a2.getName();
            if (name == null) {
                name = "";
            }
            CharSequence charSequence = name;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f63679e.setVisibility(0);
                this.f63679e.setText(charSequence);
                cJRFrequentOrder.setContactName(name);
                this.f63681g.setTextColor(Color.parseColor("#8f969c"));
                this.f63681g.setTextSize(2, 12.0f);
            } else {
                this.f63679e.setVisibility(8);
                TextView textView = this.f63681g;
                View view = this.itemView;
                k.a((Object) view, "itemView");
                textView.setTextColor(b.c(view.getContext(), R.color.color_222222));
                this.f63681g.setTextSize(2, 15.0f);
            }
            String photoUri = a2.getPhotoUri();
            if (photoUri == null) {
                photoUri = "";
            }
            if (!TextUtils.isEmpty(photoUri)) {
                this.f63682h.setVisibility(0);
                this.f63680f.setVisibility(8);
                w.a().a(photoUri).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(this.f63682h);
            } else {
                this.f63681g.setTextColor(Color.parseColor("#8f969c"));
                this.f63681g.setTextSize(2, 12.0f);
                this.f63682h.setVisibility(0);
                String operatorLogoURL = cJRFrequentOrder.getOperatorLogoURL();
                if (!TextUtils.isEmpty(operatorLogoURL)) {
                    this.f63682h.setVisibility(0);
                    this.f63680f.setVisibility(8);
                    w.a().a(operatorLogoURL).a(this.f63682h);
                } else {
                    this.f63682h.setVisibility(8);
                    this.f63680f.setVisibility(8);
                }
            }
        } else {
            a aVar = this;
            k.c(cJRFrequentOrder, "recentOrder");
            aVar.f63679e.setVisibility(8);
            TextView textView2 = aVar.f63681g;
            View view2 = aVar.itemView;
            k.a((Object) view2, "itemView");
            textView2.setTextColor(b.c(view2.getContext(), R.color.color_222222));
            aVar.f63681g.setTextSize(2, 15.0f);
            aVar.f63682h.setVisibility(0);
            String operatorLogoURL2 = cJRFrequentOrder.getOperatorLogoURL();
            if (!TextUtils.isEmpty(operatorLogoURL2)) {
                aVar.f63682h.setVisibility(0);
                aVar.f63680f.setVisibility(8);
                w.a().a(operatorLogoURL2).a(aVar.f63682h);
            } else {
                aVar.f63682h.setVisibility(8);
                aVar.f63680f.setVisibility(8);
            }
        }
        CharSequence b2 = b(cJRFrequentOrder);
        if (TextUtils.isEmpty(b2)) {
            this.k.setVisibility(8);
            TextView textView3 = this.l;
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            Context context = view3.getContext();
            int i3 = R.string.v8_recent_last_recharge_on;
            d dVar = d.f64967a;
            String rechargeAmount = cJRFrequentOrder.getRechargeAmount();
            k.a((Object) rechargeAmount, "recentOrder.rechargeAmount");
            textView3.setText(context.getString(i3, new Object[]{a(cJRFrequentOrder), d.a(rechargeAmount, false, 2, false, 10), ab.a(cJRFrequentOrder.getPaidOn(), this.f63678d)}));
            this.l.setVisibility(0);
        } else {
            this.k.setText(b2);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
        this.f63680f.setVisibility(8);
    }
}
