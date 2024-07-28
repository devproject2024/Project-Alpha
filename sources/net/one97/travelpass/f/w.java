package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.c.j;

public final class w extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f30450a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30451b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30452c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f30453d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f30454e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f30455f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f30456g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f30457h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30450a = (RelativeLayout) view.findViewById(R.id.about_info_layout);
        this.f30451b = (ImageView) view.findViewById(R.id.details_image);
        this.f30452c = (TextView) view.findViewById(R.id.header_title);
        this.f30453d = (ImageView) view.findViewById(R.id.details_img1);
        this.f30454e = (TextView) view.findViewById(R.id.details_desc1);
        this.f30455f = (ImageView) view.findViewById(R.id.details_img2);
        this.f30456g = (TextView) view.findViewById(R.id.details_desc2);
        this.f30457h = (TextView) view.findViewById(R.id.about_page_button);
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof TravelPassMetaData.PassAboutInfo)) {
            b2 = null;
        }
        TravelPassMetaData.PassAboutInfo passAboutInfo = (TravelPassMetaData.PassAboutInfo) b2;
        if (passAboutInfo != null) {
            TextView textView = this.f30452c;
            if (textView != null) {
                textView.setText(passAboutInfo.topDesc);
            }
            TextView textView2 = this.f30454e;
            if (textView2 != null) {
                textView2.setText(passAboutInfo.text1);
            }
            TextView textView3 = this.f30456g;
            if (textView3 != null) {
                textView3.setText(passAboutInfo.text2);
            }
            if (context != null) {
                b.a aVar = b.f43744a;
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = passAboutInfo.topLogoUrl;
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
                b.a.C0750a.a(b3.a((Object) a4), this.f30451b, (com.paytm.utility.b.b.b) null, 2);
                b.a aVar2 = b.f43744a;
                b.a.C0750a a5 = b.a.a(context);
                a5.f43753a = passAboutInfo.smallImage1;
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
                b.a.C0750a.a(b4.a((Object) a7), this.f30453d, (com.paytm.utility.b.b.b) null, 2);
                b.a aVar3 = b.f43744a;
                b.a.C0750a a8 = b.a.a(context);
                a8.f43753a = passAboutInfo.smallImage2;
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
                b.a.C0750a.a(b5.a((Object) a10), this.f30455f, (com.paytm.utility.b.b.b) null, 2);
            }
            if (passAboutInfo.mType != null) {
                RelativeLayout relativeLayout = this.f30450a;
                if (relativeLayout != null) {
                    if (context == null) {
                        k.a();
                    }
                    relativeLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.windowBackground));
                }
                TextView textView4 = this.f30452c;
                if (textView4 != null) {
                    if (context == null) {
                        k.a();
                    }
                    textView4.setTextColor(androidx.core.content.b.c(context, R.color.color_536e92));
                }
                TextView textView5 = this.f30454e;
                if (textView5 != null) {
                    if (context == null) {
                        k.a();
                    }
                    textView5.setTextColor(androidx.core.content.b.c(context, R.color.color_536e92));
                }
                TextView textView6 = this.f30456g;
                if (textView6 != null) {
                    if (context == null) {
                        k.a();
                    }
                    textView6.setTextColor(androidx.core.content.b.c(context, R.color.color_536e92));
                }
                ImageView imageView = this.f30451b;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                net.one97.travelpass.ui.b.b bVar = passAboutInfo.mType;
                if (bVar != null) {
                    int i3 = x.f30460a[bVar.ordinal()];
                    if (i3 == 1) {
                        TextView textView7 = this.f30457h;
                        if (textView7 != null) {
                            textView7.setVisibility(0);
                        }
                        TextView textView8 = this.f30452c;
                        if (textView8 != null) {
                            textView8.setVisibility(8);
                        }
                    } else if (i3 == 2) {
                        TextView textView9 = this.f30457h;
                        if (textView9 != null) {
                            textView9.setVisibility(8);
                        }
                        TextView textView10 = this.f30452c;
                        if (textView10 != null) {
                            textView10.setVisibility(0);
                        }
                    }
                }
            }
            TextView textView11 = this.f30457h;
            if (textView11 != null) {
                textView11.setOnClickListener(new a(cVar, jVar));
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30458a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30459b;

        a(c cVar, j jVar) {
            this.f30458a = cVar;
            this.f30459b = jVar;
        }

        public final void onClick(View view) {
            c.a.a(this.f30458a, this.f30459b, (Integer) null, (Integer) null, 6);
        }
    }
}
