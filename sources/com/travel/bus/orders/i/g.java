package com.travel.bus.orders.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.f.c;
import com.travel.bus.orders.h.b;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryRatingBody;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryRatingItem;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;

public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    Context f22695a;

    /* renamed from: b  reason: collision with root package name */
    c f22696b;

    /* renamed from: c  reason: collision with root package name */
    CJRBusOrderSummaryRatingBody f22697c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f22698d;

    /* renamed from: e  reason: collision with root package name */
    List<CJRBusOrderSummaryRatingItem> f22699e;

    /* renamed from: f  reason: collision with root package name */
    LinearLayout f22700f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f22701g;

    /* renamed from: h  reason: collision with root package name */
    TextView f22702h;

    /* renamed from: i  reason: collision with root package name */
    TextView f22703i;
    View j;
    Boolean k;
    String l;
    private String m = null;
    private CJRBusOrderSummary n;

    public g(Context context, View view, c cVar, CJRBusOrderSummaryRatingBody cJRBusOrderSummaryRatingBody, CJRBusOrderSummary cJRBusOrderSummary) {
        super(view);
        this.f22695a = context;
        this.f22697c = cJRBusOrderSummaryRatingBody;
        this.f22696b = cVar;
        this.n = cJRBusOrderSummary;
        this.l = a();
        this.f22700f = (LinearLayout) view.findViewById(R.id.rating_capture_bar);
        this.f22701g = (LinearLayout) view.findViewById(R.id.rating_display_bar);
        this.f22702h = (TextView) view.findViewById(R.id.heading_text);
        this.f22703i = (TextView) view.findViewById(R.id.footer_text);
        this.f22698d = (ImageView) view.findViewById(R.id.footer_img);
        this.j = view.findViewById(R.id.view1);
        this.f22700f.setVisibility(8);
        this.f22701g.setVisibility(8);
        this.j.setVisibility(8);
    }

    private String a() {
        String str = null;
        try {
            if (this.n != null && this.n.getOrderedCartList() != null) {
                Iterator<CJRBusOrderedCart> it2 = this.n.getOrderedCartList().iterator();
                while (it2.hasNext()) {
                    CJRBusOrderedCart next = it2.next();
                    if (b.b(next) && next != null) {
                        Object metaDataResponse = next.getMetaDataResponse();
                        f fVar = new f();
                        CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse = (CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class);
                        if (cJRBusOrderSummaryMetaDataResponse != null) {
                            str = cJRBusOrderSummaryMetaDataResponse.getTravelName() != null ? cJRBusOrderSummaryMetaDataResponse.getTravelName() : "";
                            if (!TextUtils.isEmpty(str)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ImageView imageView, View view) {
        c cVar = this.f22696b;
        String str = this.f22697c.getmSecret();
        int intValue = ((Integer) imageView.getTag()).intValue();
        String str2 = this.f22697c.getmChannel();
        this.f22697c.getFooter().getMessage();
        cVar.a(str, intValue, str2, this.l);
    }

    public final void a(c.b bVar) {
        CJRBusOrderSummaryRatingBody cJRBusOrderSummaryRatingBody = this.f22697c;
        if (cJRBusOrderSummaryRatingBody != null && cJRBusOrderSummaryRatingBody.getIsTripCompleted() != null && this.f22697c.getIsTripCompleted().booleanValue()) {
            if (!(this.f22697c.getIsEditable() == null || this.f22697c.getmSecret() == null || this.f22697c.getmSecret().isEmpty())) {
                this.k = this.f22697c.getIsEditable();
            }
            CJRBusOrderSummaryRatingBody cJRBusOrderSummaryRatingBody2 = this.f22697c;
            if (!(cJRBusOrderSummaryRatingBody2 == null || cJRBusOrderSummaryRatingBody2.getIsTripCompleted() == null || !this.f22697c.getIsTripCompleted().booleanValue() || this.f22697c.getRating() == null || this.f22697c.getRating().size() <= 0)) {
                this.f22699e = this.f22697c.getRating();
                LayoutInflater layoutInflater = (LayoutInflater) this.f22695a.getSystemService("layout_inflater");
                int f2 = com.paytm.utility.b.f(this.f22695a);
                this.f22700f.removeAllViews();
                this.f22701g.removeAllViews();
                for (int i2 = 0; i2 < this.f22699e.size(); i2++) {
                    String iconUrl = this.f22699e.get(i2).getIconUrl();
                    if (iconUrl != null && !iconUrl.isEmpty()) {
                        if (this.k.booleanValue()) {
                            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.pre_b_bus_order_summary_rating_star_lyt, (ViewGroup) null);
                            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.img_star);
                            imageView.setTag(Integer.valueOf(i2 + 1));
                            this.f22700f.addView(linearLayout);
                            imageView.setOnClickListener(new View.OnClickListener(imageView) {
                                private final /* synthetic */ ImageView f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onClick(View view) {
                                    g.this.a(this.f$1, view);
                                }
                            });
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.setMargins(0, 0, 0, 0);
                            if (i2 < this.f22699e.size() - 1) {
                                layoutParams.setMargins(0, 0, f2, 0);
                            }
                            linearLayout.setLayoutParams(layoutParams);
                            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f22695a);
                            a2.f43753a = iconUrl;
                            b.a.C0750a b2 = a2.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon)).b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon));
                            b2.m = true;
                            b2.o = true;
                            b2.a(imageView, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                                public final /* bridge */ /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
                                }

                                public final void onError(Exception exc) {
                                    q.c(exc.getMessage());
                                }
                            });
                        } else {
                            LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.pre_b_bus_order_summary_rating_display_star, (ViewGroup) null);
                            ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.img_star);
                            imageView2.setTag(Integer.valueOf(i2 + 1));
                            this.f22701g.addView(linearLayout2);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                            layoutParams2.setMargins(0, 0, 0, 0);
                            if (i2 < this.f22699e.size() - 1) {
                                layoutParams2.setMargins(0, 0, f2 / 4, 0);
                            }
                            linearLayout2.setLayoutParams(layoutParams2);
                            b.a.C0750a a3 = com.paytm.utility.b.b.a(this.f22695a);
                            a3.f43753a = iconUrl;
                            b.a.C0750a b3 = a3.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon)).b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon));
                            b3.m = true;
                            b3.o = true;
                            b3.a(imageView2, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                                public final /* bridge */ /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
                                }

                                public final void onError(Exception exc) {
                                    q.c(exc.getMessage());
                                }
                            });
                        }
                    }
                }
                if (this.k.booleanValue()) {
                    this.f22700f.setVisibility(0);
                    this.f22701g.setVisibility(8);
                    this.j.setVisibility(0);
                    this.f22702h.setTextColor(this.f22695a.getResources().getColor(R.color.color_222222));
                    ResourceUtils.loadBusImagesFromCDN(this.f22698d, "tip_1.png", false, true, n.a.V1);
                } else {
                    this.f22701g.setVisibility(0);
                    this.f22700f.setVisibility(8);
                    this.j.setVisibility(8);
                    this.f22702h.setTextColor(this.f22695a.getResources().getColor(R.color.color_3063ad));
                    ResourceUtils.loadBusImagesFromCDN(this.f22698d, "info.png", false, true, n.a.V1);
                }
            }
            if (!(this.f22697c.getHeader() == null || this.f22697c.getHeader().getTitle() == null || this.f22697c.getHeader().getTitle().isEmpty())) {
                this.f22702h.setText(this.f22697c.getHeader().getTitle());
            }
            if (!(this.f22697c.getFooter() == null || this.f22697c.getFooter().getMessage() == null || this.f22697c.getFooter().getMessage().isEmpty())) {
                this.f22703i.setText(this.f22697c.getFooter().getMessage());
            }
            if (!(this.f22697c.getFooter() == null || this.f22697c.getFooter().getLinkTarget() == null || this.f22697c.getFooter().getLinkTarget().getUrl() == null || this.f22697c.getFooter().getLinkText() == null || this.f22697c.getFooter().getLinkTarget().getUrl().isEmpty())) {
                this.f22703i.append(this.f22697c.getFooter().getLinkText());
                this.m = this.f22697c.getFooter().getLinkTarget().getUrl();
            }
            if (this.f22697c.getFooter() != null && this.f22697c.getFooter().getLinkTarget() != null && !TextUtils.isEmpty(this.f22697c.getFooter().getLinkTarget().getUrl())) {
                String str = this.f22697c.getFooter().getMessage() + this.f22697c.getFooter().getLinkText();
                if (this.m != null) {
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            if (g.this.f22696b != null) {
                                com.travel.bus.orders.f.c cVar = g.this.f22696b;
                                String str = g.this.f22697c.getmSecret();
                                int intValue = g.this.f22697c.getRatingCount().intValue();
                                String str2 = g.this.f22697c.getmChannel();
                                g.this.f22697c.getFooter().getMessage();
                                cVar.a(str, intValue, str2, g.this.l);
                            }
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(androidx.core.content.b.c(g.this.f22695a, R.color.color_00b8f8));
                            textPaint.setUnderlineText(false);
                        }
                    }, str.length() - this.f22697c.getFooter().getLinkText().length(), str.length(), 0);
                    this.f22703i.setText(spannableString);
                    this.f22703i.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        }
    }
}
