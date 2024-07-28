package com.one97.travelpass.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.j;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.ui.c.j;

public final class b extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    TextView f21334a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21335b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21336c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f21337d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f21338e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f21339f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f21340g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f21341h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        this.f21335b = !(textView instanceof TextView) ? null : textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_price);
        this.f21336c = !(textView2 instanceof TextView) ? null : textView2;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_icon);
        this.f21337d = !(imageView instanceof ImageView) ? null : imageView;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.promo_container);
        this.f21338e = !(linearLayout instanceof LinearLayout) ? null : linearLayout;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.copy_img);
        this.f21339f = !(imageView2 instanceof ImageView) ? null : imageView2;
        TextView textView3 = (TextView) view.findViewById(R.id.tv_promocode);
        this.f21334a = !(textView3 instanceof TextView) ? null : textView3;
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.view_btn);
        this.f21340g = !(linearLayout2 instanceof LinearLayout) ? null : linearLayout2;
        TextView textView4 = (TextView) view.findViewById(R.id.button_title);
        this.f21341h = !(textView4 instanceof TextView) ? null : textView4;
    }

    public final void a(Context context, int i2, j jVar, com.one97.travelpass.a.c cVar) {
        Context context2;
        Resources resources;
        TextView textView;
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (b2 != null) {
            PassData.PassFields passFields = (PassData.PassFields) b2;
            String label = passFields.getLabel();
            k.a((Object) label, "fieldLabel");
            if (p.a((CharSequence) label, (CharSequence) AppConstants.COLON, true)) {
                TextView textView2 = this.f21335b;
                if (textView2 != null) {
                    textView2.setText(label + " ");
                }
            } else {
                TextView textView3 = this.f21335b;
                if (textView3 != null) {
                    textView3.setText(label + ": ");
                }
            }
            CharSequence color = passFields.getColor();
            boolean z = false;
            if (!(color == null || color.length() == 0) && (textView = this.f21336c) != null) {
                textView.setTextColor(Color.parseColor(passFields.getColor()));
            }
            if (passFields.isCopy() != null) {
                TextView textView4 = this.f21336c;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                LinearLayout linearLayout = this.f21338e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                TextView textView5 = this.f21334a;
                if (textView5 != null) {
                    textView5.setText(passFields.getValue());
                }
                Boolean isCopy = passFields.isCopy();
                k.a((Object) isCopy, "dataModel.isCopy");
                if (isCopy.booleanValue()) {
                    LinearLayout linearLayout2 = this.f21338e;
                    if (linearLayout2 != null) {
                        linearLayout2.setOnClickListener(new a(this, context));
                    }
                    ImageView imageView = this.f21339f;
                    if (imageView != null) {
                        imageView.setOnClickListener(new C0422b(this, context));
                    }
                } else {
                    ImageView imageView2 = this.f21339f;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                    TextView textView6 = this.f21334a;
                    if (textView6 != null) {
                        Integer valueOf = (textView6 == null || (context2 = textView6.getContext()) == null || (resources = context2.getResources()) == null) ? null : Integer.valueOf(resources.getColor(R.color.color_9e9e9e));
                        if (valueOf == null) {
                            k.a();
                        }
                        textView6.setTextColor(valueOf.intValue());
                    }
                    TextView textView7 = this.f21334a;
                    if (textView7 != null) {
                        Integer valueOf2 = textView7 != null ? Integer.valueOf(textView7.getPaintFlags()) : null;
                        if (valueOf2 == null) {
                            k.a();
                        }
                        textView7.setPaintFlags(valueOf2.intValue() | 16);
                    }
                }
            } else {
                TextView textView8 = this.f21336c;
                if (textView8 != null) {
                    textView8.setText(passFields.getValue());
                }
                TextView textView9 = this.f21336c;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                LinearLayout linearLayout3 = this.f21338e;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            }
            if (passFields.getClickable()) {
                CharSequence clickUrl = passFields.getClickUrl();
                if (!(clickUrl == null || clickUrl.length() == 0)) {
                    LinearLayout linearLayout4 = this.f21340g;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                    TextView textView10 = this.f21341h;
                    if (textView10 != null) {
                        textView10.setText(passFields.getClickButtonText());
                    }
                    LinearLayout linearLayout5 = this.f21340g;
                    if (linearLayout5 != null) {
                        linearLayout5.setOnClickListener(new c(cVar, jVar));
                    }
                    String icon = passFields.getIcon();
                    k.a((Object) icon, "dataModel.icon");
                    CharSequence charSequence = icon;
                    if (charSequence == null || charSequence.length() == 0) {
                        z = true;
                    }
                    if (!z && context != null) {
                        b.a aVar = com.paytm.utility.b.b.f43744a;
                        b.a.C0750a a2 = b.a.a(context);
                        a2.f43753a = icon;
                        a2.m = true;
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
                        b.a.C0750a.a(b3.a((Object) a4), this.f21337d, (com.paytm.utility.b.b.b) null, 2);
                        return;
                    }
                    return;
                }
            }
            LinearLayout linearLayout6 = this.f21340g;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
            String icon2 = passFields.getIcon();
            k.a((Object) icon2, "dataModel.icon");
            CharSequence charSequence2 = icon2;
            z = true;
            if (!z) {
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.travelpass.model.PassData.PassFields");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21342a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21343b;

        a(b bVar, Context context) {
            this.f21342a = bVar;
            this.f21343b = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
            r0 = r0.getText();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r2) {
            /*
                r1 = this;
                android.content.Context r2 = r1.f21343b
                if (r2 == 0) goto L_0x000b
                net.one97.travelpass.e.b$a r2 = net.one97.travelpass.e.b.f30322a
                android.content.Context r2 = r1.f21343b
                net.one97.travelpass.e.b.a.a(r2)
            L_0x000b:
                com.one97.travelpass.b.b r2 = r1.f21342a
                android.widget.TextView r0 = r2.f21334a
                if (r0 == 0) goto L_0x001c
                java.lang.CharSequence r0 = r0.getText()
                if (r0 == 0) goto L_0x001c
                java.lang.String r0 = r0.toString()
                goto L_0x001d
            L_0x001c:
                r0 = 0
            L_0x001d:
                r2.a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.one97.travelpass.b.b.a.onClick(android.view.View):void");
        }
    }

    /* renamed from: com.one97.travelpass.b.b$b  reason: collision with other inner class name */
    static final class C0422b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21344a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21345b;

        C0422b(b bVar, Context context) {
            this.f21344a = bVar;
            this.f21345b = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
            r0 = r0.getText();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r2) {
            /*
                r1 = this;
                android.content.Context r2 = r1.f21345b
                if (r2 == 0) goto L_0x000b
                net.one97.travelpass.e.b$a r2 = net.one97.travelpass.e.b.f30322a
                android.content.Context r2 = r1.f21345b
                net.one97.travelpass.e.b.a.a(r2)
            L_0x000b:
                com.one97.travelpass.b.b r2 = r1.f21344a
                android.widget.TextView r0 = r2.f21334a
                if (r0 == 0) goto L_0x001c
                java.lang.CharSequence r0 = r0.getText()
                if (r0 == 0) goto L_0x001c
                java.lang.String r0 = r0.toString()
                goto L_0x001d
            L_0x001c:
                r0 = 0
            L_0x001d:
                r2.a(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.one97.travelpass.b.b.C0422b.onClick(android.view.View):void");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.one97.travelpass.a.c f21346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f21347b;

        c(com.one97.travelpass.a.c cVar, j jVar) {
            this.f21346a = cVar;
            this.f21347b = jVar;
        }

        public final void onClick(View view) {
            com.one97.travelpass.a.c cVar = this.f21346a;
            if (cVar != null) {
                j jVar = this.f21347b;
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                c.a.a(cVar, jVar, (Integer) null, Integer.valueOf(net.one97.travelpass.ui.a.i()), 2);
            }
        }
    }

    public final void a(String str) {
        j.a aVar = net.one97.travelpass.e.j.f30335a;
        LinearLayout linearLayout = this.f21338e;
        j.a.a(linearLayout != null ? linearLayout.getContext() : null, str);
    }
}
