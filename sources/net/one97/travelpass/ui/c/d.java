package net.one97.travelpass.ui.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.j;
import net.one97.travelpass.model.TravelPassMetaData;

public final class d extends RecyclerView.v implements com.one97.travelpass.a.d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30627a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30628b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30627a = (TextView) view.findViewById(R.id.tv_item_text);
        this.f30628b = (ImageView) view.findViewById(R.id.img_icon);
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (b2 != null) {
            TravelPassMetaData.KnowMore knowMore = (TravelPassMetaData.KnowMore) b2;
            TextView textView = this.f30627a;
            if (textView != null) {
                textView.setText(knowMore.getText());
            }
            String icon = knowMore.getIcon();
            CharSequence charSequence = icon;
            boolean z = true;
            if (!(charSequence == null || charSequence.length() == 0) && context != null) {
                b.a aVar = b.f43744a;
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = icon;
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
                b.a.C0750a.a(b3.a((Object) a4), this.f30628b, (com.paytm.utility.b.b.b) null, 2);
            }
            k.c(knowMore, "knowMore");
            k.c(jVar, "viewHolderModel");
            k.c(cVar, "itemClickListener");
            CharSequence highlight = knowMore.getHighlight();
            if (highlight != null && !p.a(highlight)) {
                z = false;
            }
            if (!z) {
                String text = knowMore.getText();
                k.a((Object) text, "knowMore.text");
                String highlight2 = knowMore.getHighlight();
                k.a((Object) highlight2, "knowMore.highlight");
                if (p.a((CharSequence) text, highlight2, 0, false, 6) != -1) {
                    ClickableSpan aVar2 = new a(this, cVar, jVar);
                    TextView textView2 = this.f30627a;
                    if (textView2 != null) {
                        j.a aVar3 = j.f30335a;
                        String highlightColor = knowMore.getHighlightColor();
                        k.a((Object) highlightColor, "knowMore.highlightColor");
                        String text2 = knowMore.getText();
                        k.a((Object) text2, "knowMore.text");
                        String highlight3 = knowMore.getHighlight();
                        k.a((Object) highlight3, "knowMore.highlight");
                        textView2.setText(j.a.a(highlightColor, text2, highlight3, aVar2));
                    }
                    TextView textView3 = this.f30627a;
                    if (textView3 != null) {
                        textView3.setMovementMethod(LinkMovementMethod.getInstance());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.travelpass.model.TravelPassMetaData.KnowMore");
    }

    public static final class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f30629a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f30630b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f30631c;

        a(d dVar, c cVar, j jVar) {
            this.f30629a = dVar;
            this.f30630b = cVar;
            this.f30631c = jVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            c cVar = this.f30630b;
            if (cVar != null) {
                j jVar = this.f30631c;
                Integer valueOf = Integer.valueOf(this.f30629a.getPosition());
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                cVar.onItemClickedItem(jVar, valueOf, Integer.valueOf(net.one97.travelpass.ui.a.d()));
            }
        }
    }
}
