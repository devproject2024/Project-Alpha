package net.one97.paytm.wallet.newdesign.addmoney.a;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.newaddmoney.utils.e;
import net.one97.paytm.newaddmoney.view.g;
import net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers;

public final class a extends RecyclerView.a<C1425a> {

    /* renamed from: a  reason: collision with root package name */
    Context f70645a;

    /* renamed from: b  reason: collision with root package name */
    boolean f70646b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.wallet.newdesign.addmoney.b.a f70647c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.newaddmoney.view.a f70648d;

    /* renamed from: e  reason: collision with root package name */
    String f70649e = "";

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<AddMoneyOffers.AddMoneyCodeOffers> f70650f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1425a aVar = (C1425a) vVar;
        final AddMoneyOffers.AddMoneyCodeOffers addMoneyCodeOffers = this.f70650f.get(i2);
        aVar.f70656b.setText(addMoneyCodeOffers.getCode());
        aVar.f70657c.setText(addMoneyCodeOffers.getOfferText());
        if (!addMoneyCodeOffers.isCouponError() || this.f70646b) {
            aVar.f70662h.setVisibility(8);
        } else {
            aVar.f70662h.setText(addMoneyCodeOffers.getErrorMesage());
            aVar.f70662h.setVisibility(0);
        }
        if (addMoneyCodeOffers.getIsOfferApplied()) {
            aVar.f70659e.setBackgroundResource(R.drawable.bg_btn_green_applied);
            aVar.f70661g.setTextColor(this.f70645a.getResources().getColor(R.color.color_21c17a));
            aVar.f70661g.setText(R.string.applied);
        } else {
            aVar.f70659e.setBackgroundResource(R.drawable.bg_add_coupon);
            aVar.f70661g.setTextColor(this.f70645a.getResources().getColor(R.color.paytm_blue));
            aVar.f70661g.setText(R.string.add_money_apply);
        }
        aVar.f70658d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.a(a.this.f70645a, "add_money", "add_money_enter_amount_have_promo_view_T&C", "/home-screen/add-money/", (String) null, (String) null);
                if (a.this.f70648d != null && !TextUtils.isEmpty(addMoneyCodeOffers.getTerms()) && !TextUtils.isEmpty(addMoneyCodeOffers.getTermsTitle())) {
                    g gVar = new g();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("OFFER_DETAIL", Html.fromHtml(addMoneyCodeOffers.getTerms()).toString());
                    bundle.putSerializable("Selected_Coupon_Index", addMoneyCodeOffers.getCode());
                    gVar.setArguments(bundle);
                    gVar.show(a.this.f70648d.getChildFragmentManager(), g.class.getCanonicalName());
                }
            }
        });
        aVar.f70659e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!addMoneyCodeOffers.getIsOfferApplied() && a.this.f70647c != null) {
                    d.a(a.this.f70645a, "add_money", "add_money_enter_amount_have_promo_enter_code_apply", "/home-screen/add-money/", (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{e.a(a.this.f70645a), addMoneyCodeOffers.getCode(), "", a.this.f70649e})), "");
                    a.this.f70647c.a(addMoneyCodeOffers.getCode());
                }
            }
        });
    }

    public a(Context context, List<AddMoneyOffers.AddMoneyCodeOffers> list, net.one97.paytm.wallet.newdesign.addmoney.b.a aVar, net.one97.paytm.newaddmoney.view.a aVar2, String str) {
        this.f70645a = context;
        this.f70650f = new ArrayList<>();
        this.f70650f.addAll(list);
        this.f70646b = true;
        this.f70647c = aVar;
        this.f70648d = aVar2;
        if (!TextUtils.isEmpty(str)) {
            this.f70649e = str;
        }
    }

    public final int getItemCount() {
        return this.f70650f.size();
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.addmoney.a.a$a  reason: collision with other inner class name */
    public class C1425a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RadioButton f70655a;

        /* renamed from: b  reason: collision with root package name */
        TextView f70656b;

        /* renamed from: c  reason: collision with root package name */
        TextView f70657c;

        /* renamed from: d  reason: collision with root package name */
        TextView f70658d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f70659e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f70660f;

        /* renamed from: g  reason: collision with root package name */
        TextView f70661g;

        /* renamed from: h  reason: collision with root package name */
        TextView f70662h;

        public C1425a(View view) {
            super(view);
            this.f70655a = (RadioButton) view.findViewById(R.id.rb_offer_select);
            this.f70656b = (TextView) view.findViewById(R.id.tv_offer_name);
            this.f70657c = (TextView) view.findViewById(R.id.tv_offer_desc);
            this.f70658d = (TextView) view.findViewById(R.id.tv_offer_tnc);
            this.f70659e = (RelativeLayout) view.findViewById(R.id.rl_apply_promo);
            this.f70660f = (ImageView) view.findViewById(R.id.iv_apply_tick);
            this.f70661g = (TextView) view.findViewById(R.id.tv_apply_promo);
            this.f70662h = (TextView) view.findViewById(R.id.tv_offer_error);
            if (a.this.f70646b) {
                this.f70655a.setVisibility(8);
                this.f70659e.setVisibility(0);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1425a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_add_money_offer, viewGroup, false));
    }
}
