package com.one97.travelpass.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.b;
import net.one97.travelpass.ordersummary.model.OrderSummaryFiled;

public final class a extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f21324a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21325b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f21326c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f21327d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        this.f21324a = !(textView instanceof TextView) ? null : textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_price);
        this.f21325b = !(textView2 instanceof TextView) ? null : textView2;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_icon);
        this.f21326c = !(imageView instanceof ImageView) ? null : imageView;
        this.f21327d = (LinearLayout) view.findViewById(R.id.all_promo_container);
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, com.one97.travelpass.a.b bVar) {
        Resources resources;
        Resources resources2;
        Context context2 = context;
        k.c(aVar, "viewHolderModelTP");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryFiled)) {
            a2 = null;
        }
        OrderSummaryFiled orderSummaryFiled = (OrderSummaryFiled) a2;
        if (orderSummaryFiled != null) {
            TextView textView = this.f21324a;
            if (textView != null) {
                textView.setText(orderSummaryFiled.getLabel());
            }
            Collection values = orderSummaryFiled.getValues();
            if (!(values == null || values.isEmpty())) {
                TextView textView2 = this.f21325b;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                LinearLayout linearLayout = this.f21327d;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                for (OrderSummaryFiled.a next : orderSummaryFiled.getValues()) {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.promo_view, this.f21327d, false);
                    LinearLayout linearLayout2 = this.f21327d;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(inflate);
                    }
                    ImageView imageView = inflate != null ? (ImageView) inflate.findViewById(R.id.copy_img) : null;
                    if (!(imageView instanceof ImageView)) {
                        imageView = null;
                    }
                    ResourceUtils.loadTPassImagesFromCDN$default(imageView, "copy_img.png", false, false, (n.a) null, 16, (Object) null);
                    TextView textView3 = inflate != null ? (TextView) inflate.findViewById(R.id.tv_promocode) : null;
                    if (!(textView3 instanceof TextView)) {
                        textView3 = null;
                    }
                    if (textView3 != null) {
                        k.a((Object) next, "promo");
                        textView3.setText(next.a());
                    }
                    if (textView3 != null) {
                        Float valueOf = (context2 == null || (resources2 = context.getResources()) == null) ? null : Float.valueOf(resources2.getDimension(R.dimen.dimen_15sp));
                        if (valueOf == null) {
                            k.a();
                        }
                        textView3.setTextSize(0, valueOf.floatValue());
                    }
                    ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                    if (layoutParams != null) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 50, 0, 0);
                        inflate.setLayoutParams(layoutParams2);
                        k.a((Object) next, "promo");
                        if (next.b() != null) {
                            TextView textView4 = this.f21325b;
                            if (textView4 != null) {
                                textView4.setVisibility(8);
                            }
                            if (inflate != null) {
                                inflate.setVisibility(0);
                            }
                            if (textView3 != null) {
                                textView3.setText(next.a());
                            }
                            Boolean b2 = next.b();
                            k.a((Object) b2, "promo.copy");
                            if (b2.booleanValue()) {
                                if (inflate != null) {
                                    inflate.setOnClickListener(new C0421a(this, context2, next));
                                }
                                if (imageView != null) {
                                    imageView.setOnClickListener(new b(this, context2, next));
                                }
                            } else {
                                if (imageView != null) {
                                    imageView.setVisibility(8);
                                }
                                if (textView3 != null) {
                                    Context context3 = textView3.getContext();
                                    Integer valueOf2 = (context3 == null || (resources = context3.getResources()) == null) ? null : Integer.valueOf(resources.getColor(R.color.color_9e9e9e));
                                    if (valueOf2 == null) {
                                        k.a();
                                    }
                                    textView3.setTextColor(valueOf2.intValue());
                                }
                                if (textView3 != null) {
                                    textView3.setPaintFlags(textView3.getPaintFlags() | 16);
                                }
                            }
                        } else {
                            TextView textView5 = this.f21325b;
                            if (textView5 != null) {
                                textView5.setText(orderSummaryFiled.getValue());
                            }
                            TextView textView6 = this.f21325b;
                            if (textView6 != null) {
                                textView6.setVisibility(0);
                            }
                            if (inflate != null) {
                                inflate.setVisibility(8);
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                }
            } else {
                CharSequence value = orderSummaryFiled.getValue();
                if (!(value == null || p.a(value))) {
                    TextView textView7 = this.f21325b;
                    if (textView7 != null) {
                        textView7.setText(orderSummaryFiled.getValue());
                    }
                    TextView textView8 = this.f21325b;
                    if (textView8 != null) {
                        textView8.setVisibility(0);
                    }
                    LinearLayout linearLayout3 = this.f21327d;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                }
            }
            String icon = orderSummaryFiled.getIcon();
            k.a((Object) icon, "dataModel.icon");
            if (icon != null && context2 != null) {
                b.a aVar2 = com.paytm.utility.b.b.f43744a;
                b.a.C0750a a3 = b.a.a(context);
                a3.f43753a = icon;
                a3.m = true;
                Drawable a4 = androidx.core.content.b.a(context2, R.drawable.travelpass_placeholder_default);
                if (a4 == null) {
                    k.a();
                }
                k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                b.a.C0750a b3 = a3.b(a4);
                Drawable a5 = androidx.core.content.b.a(context2, R.drawable.travelpass_placeholder_default);
                if (a5 == null) {
                    k.a();
                }
                k.a((Object) a5, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                b.a.C0750a.a(b3.a((Object) a5), this.f21326c, (com.paytm.utility.b.b.b) null, 2);
            }
        }
    }

    /* renamed from: com.one97.travelpass.b.a$a  reason: collision with other inner class name */
    static final class C0421a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21328a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21329b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrderSummaryFiled.a f21330c;

        C0421a(a aVar, Context context, OrderSummaryFiled.a aVar2) {
            this.f21328a = aVar;
            this.f21329b = context;
            this.f21330c = aVar2;
        }

        public final void onClick(View view) {
            if (this.f21329b != null) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                b.a.a(this.f21329b);
            }
            a aVar2 = this.f21328a;
            OrderSummaryFiled.a aVar3 = this.f21330c;
            k.a((Object) aVar3, "promo");
            aVar2.a(aVar3.a());
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrderSummaryFiled.a f21333c;

        b(a aVar, Context context, OrderSummaryFiled.a aVar2) {
            this.f21331a = aVar;
            this.f21332b = context;
            this.f21333c = aVar2;
        }

        public final void onClick(View view) {
            if (this.f21332b != null) {
                b.a aVar = net.one97.travelpass.e.b.f30322a;
                b.a.a(this.f21332b);
            }
            a aVar2 = this.f21331a;
            OrderSummaryFiled.a aVar3 = this.f21333c;
            k.a((Object) aVar3, "promo");
            aVar2.a(aVar3.a());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4) {
        /*
            r3 = this;
            android.widget.LinearLayout r0 = r3.f21327d
            r1 = 0
            if (r0 == 0) goto L_0x0012
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x0012
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            boolean r2 = r0 instanceof android.text.ClipboardManager
            if (r2 != 0) goto L_0x0018
            r0 = r1
        L_0x0018:
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            if (r0 == 0) goto L_0x0022
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0022:
            android.widget.LinearLayout r0 = r3.f21327d
            if (r0 == 0) goto L_0x002a
            android.content.Context r1 = r0.getContext()
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Promocode "
            r0.<init>(r2)
            r0.append(r4)
            java.lang.String r4 = " Copied"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r1, r4, r0)
            r4.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.one97.travelpass.b.a.a(java.lang.String):void");
    }
}
