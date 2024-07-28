package net.one97.paytm.recharge.mobile_v3.c;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.utils.n;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.e;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public class d extends p.d {

    /* renamed from: c  reason: collision with root package name */
    final CJRRechargeLottieAnimationView f63900c;

    /* renamed from: d  reason: collision with root package name */
    CJRFrequentOrder f63901d;

    /* renamed from: e  reason: collision with root package name */
    private final String f63902e = "dd MMM, yyyy";

    /* renamed from: f  reason: collision with root package name */
    private final TextView f63903f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f63904g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f63905h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f63906i;
    private final ViewGroup j;
    private final View k;
    private final TextView l;
    private final TextView m;
    private final String n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, CJRRecentOrderV8.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
        k.c(aVar, "options");
        View findViewById = view.findViewById(R.id.beneficiary_name);
        if (findViewById != null) {
            this.f63903f = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.beneficiary_circle);
            if (findViewById2 != null) {
                this.f63904g = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.beneficiary_number);
                if (findViewById3 != null) {
                    this.f63905h = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.beneficiary_no_name_icon);
                    if (findViewById4 != null) {
                        this.f63906i = (ImageView) findViewById4;
                        this.j = (ViewGroup) view.findViewById(R.id.parent_layout);
                        this.k = view.findViewById(R.id.separator);
                        View findViewById5 = view.findViewById(R.id.txt_automatic_bill_scheduled);
                        if (findViewById5 != null) {
                            this.l = (TextView) findViewById5;
                            View findViewById6 = view.findViewById(R.id.last_recharge_done);
                            if (findViewById6 != null) {
                                this.m = (TextView) findViewById6;
                                View findViewById7 = view.findViewById(R.id.loader_animation);
                                this.f63900c = (CJRRechargeLottieAnimationView) (!(findViewById7 instanceof CJRRechargeLottieAnimationView) ? null : findViewById7);
                                this.n = "#506d85";
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

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63907a;

        a(d dVar) {
            this.f63907a = dVar;
        }

        public final void onClick(View view) {
            CJRFrequentOrder cJRFrequentOrder;
            e eVar = e.INSTANCE;
            k.a((Object) view, "view");
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (!eVar.validateIsAlreadyClicked(context, e.INSTANCE.getDELAY_1000_MILLI()) && (cJRFrequentOrder = this.f63907a.f63901d) != null) {
                this.f63907a.d();
                p.a aVar = this.f63907a.f60653b.f61927e;
                if (aVar != null) {
                    aVar.c(cJRFrequentOrder, this.f63907a.getAdapterPosition());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.j.setOnClickListener(new a(this));
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63908a;

        b(d dVar) {
            this.f63908a = dVar;
        }

        public final void run() {
            ai.a(this.f63908a.f63900c);
            this.f63908a.f63900c.playAnimation();
        }
    }

    public final void d() {
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = this.f63900c;
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.postDelayed(new b(this), 200);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63909a;

        c(d dVar) {
            this.f63909a = dVar;
        }

        public final void run() {
            this.f63909a.f63900c.cancelAnimation();
            this.f63909a.f63900c.setVisibility(4);
        }
    }

    public final void e() {
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = this.f63900c;
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.postDelayed(new c(this), 200);
        }
    }

    public void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
        String str;
        CJRBillDetails cJRBillDetails;
        k.c(cJRFrequentOrder, "recentOrder");
        this.f63901d = cJRFrequentOrder;
        String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
        this.f63905h.setText(rechargeNumber);
        n nVar = n.f61679a;
        k.a((Object) rechargeNumber, "rechargeNumber");
        ContactItemModel a2 = n.a(rechargeNumber);
        String str2 = "";
        if (a2 != null) {
            k.c(a2, "contact");
            k.c(cJRFrequentOrder, "recentOrder");
            String name = a2.getName();
            if (name == null) {
                name = str2;
            }
            CharSequence charSequence = name;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f63903f.setVisibility(0);
                this.f63903f.setText(charSequence);
                cJRFrequentOrder.setContactName(name);
                this.f63905h.setTextColor(Color.parseColor("#8f969c"));
                this.f63905h.setTextSize(2, 12.0f);
            } else {
                this.f63903f.setVisibility(8);
                TextView textView = this.f63905h;
                View view = this.itemView;
                k.a((Object) view, "itemView");
                textView.setTextColor(androidx.core.content.b.c(view.getContext(), R.color.color_222222));
                this.f63905h.setTextSize(2, 15.0f);
            }
            String photoUri = a2.getPhotoUri();
            if (photoUri == null) {
                photoUri = str2;
            }
            if (!TextUtils.isEmpty(photoUri)) {
                this.f63906i.setVisibility(0);
                this.f63904g.setVisibility(8);
                w.a().a(photoUri).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(this.f63906i);
            } else {
                this.f63905h.setTextColor(Color.parseColor("#8f969c"));
                this.f63905h.setTextSize(2, 12.0f);
                this.f63906i.setVisibility(0);
                String operatorLogoURL = cJRFrequentOrder.getOperatorLogoURL();
                if (!TextUtils.isEmpty(operatorLogoURL)) {
                    this.f63906i.setVisibility(0);
                    this.f63904g.setVisibility(8);
                    w.a().a(operatorLogoURL).a(this.f63906i);
                } else {
                    this.f63906i.setVisibility(8);
                    this.f63904g.setVisibility(8);
                }
            }
        } else {
            d dVar = this;
            k.c(cJRFrequentOrder, "recentOrder");
            dVar.f63903f.setVisibility(8);
            TextView textView2 = dVar.f63905h;
            View view2 = dVar.itemView;
            k.a((Object) view2, "itemView");
            textView2.setTextColor(androidx.core.content.b.c(view2.getContext(), R.color.color_222222));
            dVar.f63905h.setTextSize(2, 15.0f);
            dVar.f63906i.setVisibility(0);
            String operatorLogoURL2 = cJRFrequentOrder.getOperatorLogoURL();
            if (!TextUtils.isEmpty(operatorLogoURL2)) {
                dVar.f63906i.setVisibility(0);
                dVar.f63904g.setVisibility(8);
                w.a().a(operatorLogoURL2).a(dVar.f63906i);
            } else {
                dVar.f63906i.setVisibility(8);
                dVar.f63904g.setVisibility(8);
            }
        }
        List<CJRBillDetails> list = cJRFrequentOrder.getmBillDetails();
        if (list == null || !list.isEmpty()) {
            CJRBillDetails cJRBillDetails2 = list.get(0);
            k.a((Object) cJRBillDetails2, "billsList[0]");
            String label = cJRBillDetails2.getLabel();
            if (label != null) {
                str2 = label;
            }
        }
        if ((list != null && list.isEmpty()) || (cJRBillDetails = list.get(0)) == null || (str = cJRBillDetails.getBillsLabelColor()) == null) {
            str = this.n;
        }
        CharSequence charSequence2 = str2;
        if (TextUtils.isEmpty(charSequence2) || !ba.c(list.get(0))) {
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                textView4.setText(cJRFrequentOrder.getmCreatedAt());
            }
            TextView textView5 = this.m;
            if (textView5 != null) {
                View view3 = this.itemView;
                k.a((Object) view3, "itemView");
                textView5.setTextColor(androidx.core.content.b.c(view3.getContext(), R.color.v3_text_2));
            }
            TextView textView6 = this.m;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
        } else {
            TextView textView7 = this.l;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView textView8 = this.m;
            if (textView8 != null) {
                textView8.setText(charSequence2);
            }
            TextView textView9 = this.m;
            if (textView9 != null) {
                textView9.setTextColor(ba.c(str, this.n));
            }
            TextView textView10 = this.m;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
        }
        this.f63904g.setVisibility(8);
        k.c(cJRFrequentOrder, "recentOrder");
        String str3 = this.f60652a;
        if (g.c(str3)) {
            String rechargeNumber2 = cJRFrequentOrder.getRechargeNumber();
            k.a((Object) rechargeNumber2, "recentOrder.rechargeNumber");
            int a3 = kotlin.m.p.a((CharSequence) rechargeNumber2, str3, 0, false, 6);
            if (a3 != -1) {
                SpannableString spannableString = new SpannableString(cJRFrequentOrder.getRechargeNumber());
                View view4 = this.itemView;
                k.a((Object) view4, "itemView");
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(view4.getContext(), R.color.color_00ACED)), a3, str3.length() + a3, 18);
                TextView textView11 = this.f63905h;
                if (textView11 != null) {
                    textView11.setText(spannableString);
                }
            }
        }
    }
}
