package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.e.b;
import net.one97.travelpass.model.PartnersOfferData;
import net.one97.travelpass.ui.c.j;

public final class u extends RecyclerView.v implements com.one97.travelpass.a.d {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30426a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30427b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f30428c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30429d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.offer_image);
        if (imageView != null) {
            this.f30426a = imageView;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.partner_image);
            if (imageView2 != null) {
                this.f30427b = imageView2;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.promo_container);
                if (linearLayout != null) {
                    this.f30428c = linearLayout;
                    TextView textView = (TextView) view.findViewById(R.id.tv_promocode);
                    if (textView != null) {
                        this.f30429d = textView;
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void a(Context context, int i2, j jVar, com.one97.travelpass.a.c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof PartnersOfferData)) {
            b2 = null;
        }
        PartnersOfferData partnersOfferData = (PartnersOfferData) b2;
        if (partnersOfferData != null) {
            boolean z = true;
            if (partnersOfferData.getPromocode() != null) {
                if (partnersOfferData != null) {
                    LinearLayout linearLayout = this.f30428c;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    ImageView imageView = this.f30427b;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    String mergedImageUrl = partnersOfferData.getMergedImageUrl();
                    CharSequence charSequence = mergedImageUrl;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                    if (!z && context != null) {
                        b.a aVar = com.paytm.utility.b.b.f43744a;
                        b.a.C0750a a2 = b.a.a(context);
                        a2.f43753a = mergedImageUrl;
                        Drawable a3 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                        if (a3 == null) {
                            k.a();
                        }
                        k.a((Object) a3, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                        b.a.C0750a b3 = a2.b(a3);
                        Drawable a4 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                        if (a4 == null) {
                            k.a();
                        }
                        k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                        b.a.C0750a.a(b3.a((Object) a4), this.f30426a, (com.paytm.utility.b.b.b) null, 2);
                    }
                    ImageView imageView2 = this.f30426a;
                    if (imageView2 != null) {
                        imageView2.setOnClickListener(new a(partnersOfferData, cVar, jVar));
                    }
                    LinearLayout linearLayout2 = this.f30428c;
                    if (linearLayout2 != null) {
                        linearLayout2.setOnClickListener(new b(this, context, partnersOfferData, jVar, cVar));
                    }
                }
            } else if (partnersOfferData != null) {
                LinearLayout linearLayout3 = this.f30428c;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                ImageView imageView3 = this.f30427b;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                String imageUrl = partnersOfferData.getImageUrl();
                CharSequence charSequence2 = imageUrl;
                if (!(charSequence2 == null || charSequence2.length() == 0) && context != null) {
                    b.a aVar2 = com.paytm.utility.b.b.f43744a;
                    b.a.C0750a a5 = b.a.a(context);
                    a5.f43753a = imageUrl;
                    Drawable a6 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                    if (a6 == null) {
                        k.a();
                    }
                    k.a((Object) a6, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a b4 = a5.b(a6);
                    Drawable a7 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                    if (a7 == null) {
                        k.a();
                    }
                    k.a((Object) a7, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a.a(b4.a((Object) a7), this.f30426a, (com.paytm.utility.b.b.b) null, 2);
                }
                String brandLogoUrl = partnersOfferData.getBrandLogoUrl();
                CharSequence charSequence3 = brandLogoUrl;
                if (!(charSequence3 == null || charSequence3.length() == 0)) {
                    z = false;
                }
                if (!z && context != null) {
                    b.a aVar3 = com.paytm.utility.b.b.f43744a;
                    b.a.C0750a a8 = b.a.a(context);
                    a8.f43753a = brandLogoUrl;
                    Drawable a9 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                    if (a9 == null) {
                        k.a();
                    }
                    k.a((Object) a9, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a b5 = a8.b(a9);
                    Drawable a10 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                    if (a10 == null) {
                        k.a();
                    }
                    k.a((Object) a10, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a.a(b5.a((Object) a10), this.f30427b, (com.paytm.utility.b.b.b) null, 2);
                }
                ImageView imageView4 = this.f30426a;
                if (imageView4 != null) {
                    imageView4.setOnClickListener(new c(partnersOfferData, cVar, jVar));
                }
                ImageView imageView5 = this.f30427b;
                if (imageView5 != null) {
                    imageView5.setOnClickListener(new d(partnersOfferData, cVar, jVar));
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PartnersOfferData f30438a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.c f30439b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f30440c;

        c(PartnersOfferData partnersOfferData, com.one97.travelpass.a.c cVar, j jVar) {
            this.f30438a = partnersOfferData;
            this.f30439b = cVar;
            this.f30440c = jVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.c cVar;
            if (this.f30438a.isClickable() && (cVar = this.f30439b) != null) {
                j jVar = this.f30440c;
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                c.a.a(cVar, jVar, (Integer) null, Integer.valueOf(net.one97.travelpass.ui.a.b()), 2);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PartnersOfferData f30441a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.c f30442b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f30443c;

        d(PartnersOfferData partnersOfferData, com.one97.travelpass.a.c cVar, j jVar) {
            this.f30441a = partnersOfferData;
            this.f30442b = cVar;
            this.f30443c = jVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.c cVar;
            if (this.f30441a.isClickable() && (cVar = this.f30442b) != null) {
                j jVar = this.f30443c;
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                c.a.a(cVar, jVar, (Integer) null, Integer.valueOf(net.one97.travelpass.ui.a.b()), 2);
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PartnersOfferData f30430a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.c f30431b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f30432c;

        a(PartnersOfferData partnersOfferData, com.one97.travelpass.a.c cVar, j jVar) {
            this.f30430a = partnersOfferData;
            this.f30431b = cVar;
            this.f30432c = jVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.c cVar;
            if (this.f30430a.isClickable() && (cVar = this.f30431b) != null) {
                j jVar = this.f30432c;
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                c.a.a(cVar, jVar, (Integer) null, Integer.valueOf(net.one97.travelpass.ui.a.b()), 2);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f30433a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f30434b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PartnersOfferData f30435c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f30436d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.c f30437e;

        b(u uVar, Context context, PartnersOfferData partnersOfferData, j jVar, com.one97.travelpass.a.c cVar) {
            this.f30433a = uVar;
            this.f30434b = context;
            this.f30435c = partnersOfferData;
            this.f30436d = jVar;
            this.f30437e = cVar;
        }

        public final void onClick(View view) {
            if (!(this.f30434b == null || this.f30435c == null)) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                Context context = this.f30434b;
                String partnerOfferId = this.f30435c.getPartnerOfferId();
                k.a((Object) partnerOfferId, "partnersOfferData.partnerOfferId");
                k.c(context, "context");
                k.c(partnerOfferId, "offerId");
                b.a.a(context, net.one97.travelpass.e.b.k, net.one97.travelpass.e.b.o, partnerOfferId, (String) null, (String) null, (String) null, net.one97.travelpass.e.b.f30327f, (String) null, 368);
            }
            j jVar = this.f30436d;
            com.one97.travelpass.a.c cVar = this.f30437e;
            PartnersOfferData partnersOfferData = this.f30435c;
            if (partnersOfferData != null) {
                partnersOfferData.getPromocode();
            }
            k.c(jVar, "viewHolderModel");
            if (cVar != null) {
                net.one97.travelpass.ui.a aVar2 = net.one97.travelpass.ui.a.f30575a;
                c.a.a(cVar, jVar, (Integer) null, Integer.valueOf(net.one97.travelpass.ui.a.h()), 2);
            }
        }
    }
}
