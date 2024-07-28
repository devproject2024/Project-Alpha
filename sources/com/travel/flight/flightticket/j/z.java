package com.travel.flight.flightticket.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightticket.a.i;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.CJRFlightPromoBody;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightOffer;
import com.travel.flight.pojo.flightticket.CJRFlightPromoMessage;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.views.EllipsisTextView;
import com.travel.utils.n;

public final class z extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    Context f25247a;

    /* renamed from: b  reason: collision with root package name */
    public CJRFlightPromoResponse f25248b;

    /* renamed from: c  reason: collision with root package name */
    public CJRFlightDetails f25249c;

    /* renamed from: d  reason: collision with root package name */
    public CJRFlightOffer f25250d;

    /* renamed from: e  reason: collision with root package name */
    public String f25251e;

    /* renamed from: f  reason: collision with root package name */
    public CJRFlightSearchInput f25252f;

    /* renamed from: g  reason: collision with root package name */
    public String f25253g;

    /* renamed from: h  reason: collision with root package name */
    private View f25254h;

    /* renamed from: i  reason: collision with root package name */
    private View f25255i;
    private ImageView j = ((ImageView) this.f25255i.findViewById(R.id.remove_promocode));
    private TextView k;
    private k l;
    private TextView m;

    public z(Context context, View view, k kVar) {
        super(view);
        this.f25247a = context;
        this.f25254h = view.findViewById(R.id.lyt_offers);
        this.f25255i = view.findViewById(R.id.lyt_promo_applied);
        this.k = (TextView) view.findViewById(R.id.txt_hv_promo);
        this.l = kVar;
        this.m = (TextView) view.findViewById(R.id.txt_offers_count);
        this.f25255i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (z.a(z.this)) {
                    z.this.c();
                } else {
                    z.b(z.this);
                }
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                z zVar = z.this;
                AlertDialog.Builder builder = new AlertDialog.Builder(zVar.f25247a);
                Resources resources = zVar.f25247a.getResources();
                builder.setTitle(resources.getString(R.string.remove_code_title)).setMessage(resources.getString(R.string.remove_code_msg)).setCancelable(false);
                builder.setPositiveButton(resources.getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        z.c(z.this);
                    }
                });
                builder.setNegativeButton(resources.getString(R.string.no), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (z.a(z.this)) {
                    z.this.c();
                } else {
                    z.b(z.this);
                }
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (z.a(z.this)) {
                    z.this.c();
                } else {
                    z.b(z.this);
                }
            }
        });
        ResourceUtils.loadFlightImagesFromCDN(this.j, "close_icon.png", false, false, n.a.V1);
    }

    public final void a() {
        CJRFlightPromoResponse cJRFlightPromoResponse = this.f25248b;
        if (cJRFlightPromoResponse == null || cJRFlightPromoResponse.getBody() == null || TextUtils.isEmpty(this.f25248b.getBody().getPromostatus()) || !this.f25248b.getBody().getPromostatus().trim().equalsIgnoreCase("SUCCESS")) {
            this.f25255i.setVisibility(8);
            b();
            return;
        }
        this.f25254h.setVisibility(8);
        d();
    }

    private void d() {
        CJRFlightPromoBody body;
        CJRFlightPromoResponse cJRFlightPromoResponse = this.f25248b;
        if (cJRFlightPromoResponse != null && (body = cJRFlightPromoResponse.getBody()) != null && !TextUtils.isEmpty(body.getPromostatus()) && body.getPromostatus().trim().equalsIgnoreCase("SUCCESS")) {
            this.f25255i.setVisibility(0);
            TextView textView = (TextView) this.f25255i.findViewById(R.id.applied_promocode_txt);
            EllipsisTextView ellipsisTextView = (EllipsisTextView) this.f25255i.findViewById(R.id.offer_amount_applied);
            TextView textView2 = (TextView) this.f25255i.findViewById(R.id.offer_amount_applied_2);
            ellipsisTextView.setEllipsesListener(new EllipsisTextView.a(textView2) {
                private final /* synthetic */ TextView f$1;

                {
                    this.f$1 = r2;
                }

                public final void ellipsisStateChanged(boolean z) {
                    z.a(EllipsisTextView.this, this.f$1, z);
                }
            });
            TextView textView3 = (TextView) this.f25255i.findViewById(R.id.txt_promo_success_message);
            CJRFlightPromoMessage message = this.f25248b.getStatus().getMessage();
            if (!TextUtils.isEmpty(body.getPaytmPromocode())) {
                textView.setText(this.f25247a.getString(R.string.flight_promocode_appled_title, new Object[]{body.getPaytmPromocode()}));
            } else {
                textView.setText("");
            }
            if (body.getPaytmDiscount() > 0) {
                ellipsisTextView.setText(this.f25247a.getString(R.string.rupee_discount, new Object[]{Integer.valueOf(body.getPaytmDiscount())}));
                textView2.setText(this.f25247a.getString(R.string.rupee_discount, new Object[]{Integer.valueOf(body.getPaytmDiscount())}));
                ellipsisTextView.setVisibility(0);
            } else if (body.getPaytmCashback() > 0 || body.getPaytmPgcashback() > 0) {
                ellipsisTextView.setText(this.f25247a.getString(R.string.rupee_cashback, new Object[]{Integer.valueOf(body.getPaytmCashback() + body.getPaytmPgcashback())}));
                textView2.setText(this.f25247a.getString(R.string.rupee_cashback, new Object[]{Integer.valueOf(body.getPaytmCashback() + body.getPaytmPgcashback())}));
                ellipsisTextView.setVisibility(0);
            } else {
                ellipsisTextView.setVisibility(8);
                textView2.setVisibility(8);
            }
            if (message == null || TextUtils.isEmpty(message.getTitle())) {
                textView3.setText("");
                return;
            }
            textView3.setText(message.getTitle() + message.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(EllipsisTextView ellipsisTextView, TextView textView, boolean z) {
        if (z) {
            ellipsisTextView.setVisibility(8);
            textView.setVisibility(0);
            return;
        }
        ellipsisTextView.setVisibility(0);
        textView.setVisibility(8);
    }

    public final void b() {
        this.f25255i.setVisibility(8);
        CJRFlightOffer cJRFlightOffer = this.f25250d;
        if (cJRFlightOffer == null || cJRFlightOffer.getmOffers().getmOfferCodes() == null || this.f25250d.getmOffers().getmOfferCodes().size() <= 2) {
            CJRFlightOffer cJRFlightOffer2 = this.f25250d;
            if (cJRFlightOffer2 == null || cJRFlightOffer2.getmOffers().getmOfferCodes() == null || this.f25250d.getmOffers().getmOfferCodes().size() > 2) {
                this.f25254h.setVisibility(0);
                this.f25254h.findViewById(R.id.lyt_offers_list).setVisibility(8);
                this.m.setVisibility(8);
                this.f25254h.findViewById(R.id.txt_hv_promo).setVisibility(0);
                e();
                return;
            }
            this.f25254h.setVisibility(0);
            this.f25254h.findViewById(R.id.lyt_offers_list).setVisibility(0);
            this.f25254h.findViewById(R.id.txt_hv_promo).setVisibility(0);
            this.m.setVisibility(8);
            e();
            f();
            return;
        }
        this.f25254h.setVisibility(0);
        this.f25254h.findViewById(R.id.lyt_offers_list).setVisibility(0);
        this.m.setVisibility(0);
        this.f25254h.findViewById(R.id.txt_hv_promo).setVisibility(8);
        this.f25254h.findViewById(R.id.txt_error);
        e();
        f();
        int size = this.f25250d.getmOffers().getmOfferCodes().size() - 2;
        if (size > 0) {
            this.m.setText(this.f25247a.getString(R.string.flight_promocode_info_text, new Object[]{Integer.valueOf(size)}));
            this.m.setVisibility(0);
            return;
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void e() {
        View view = this.f25254h;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.txt_error);
            if (!TextUtils.isEmpty(this.f25253g)) {
                textView.setText(this.f25253g);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    private void f() {
        LinearLayout linearLayout = (LinearLayout) this.f25254h.findViewById(R.id.lyt_offers_list_container);
        linearLayout.removeAllViews();
        i iVar = new i(this.f25247a, this.f25250d.getmOffers().getmOfferCodes(), this.l);
        for (int i2 = 0; i2 < iVar.getCount(); i2++) {
            linearLayout.addView(iVar.getView(i2, (View) null, (ViewGroup) null));
        }
    }

    public final void c() {
        this.l.openPromoScreen();
    }

    static /* synthetic */ boolean a(z zVar) {
        String b2 = com.travel.flight.utils.i.a(zVar.f25247a.getApplicationContext()).b("sso_token=", "", true);
        if (b2 == null || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void b(z zVar) {
        Intent intent = new Intent();
        b.a();
        b.b().a(zVar.f25247a, intent);
    }

    static /* synthetic */ void c(z zVar) {
        k kVar = zVar.l;
        if (kVar != null) {
            kVar.reviewIternaryActionClick("", (Intent) null, Boolean.FALSE, c.ON_PROMO_REMOVED);
        }
        zVar.f25248b = null;
        zVar.a();
    }
}
