package net.one97.travelpass.f;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.j;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.c.j;

public final class r extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30408a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30409b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30410c;

    /* renamed from: d  reason: collision with root package name */
    private View f30411d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f30412e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.how_to_container);
        if (linearLayout != null) {
            this.f30412e = linearLayout;
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                this.f30408a = textView;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_description);
                if (textView2 != null) {
                    this.f30409b = textView2;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_heading);
                    if (textView3 != null) {
                        this.f30410c = textView3;
                        View findViewById = view.findViewById(R.id.view_vertical_line);
                        if (findViewById != null) {
                            this.f30411d = findViewById;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.view.View");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof TravelPassMetaData.TypeCardData)) {
            b2 = null;
        }
        TravelPassMetaData.TypeCardData typeCardData = (TravelPassMetaData.TypeCardData) b2;
        if (typeCardData != null) {
            new StringBuilder("inside how to use ... isFirstElement ").append(jVar.d());
            new StringBuilder("inside how to use ... isLastElement ").append(jVar.f());
            if (jVar.d()) {
                this.f30410c.setVisibility(0);
            } else {
                this.f30410c.setVisibility(8);
            }
            if (jVar.f()) {
                this.f30411d.setVisibility(8);
                a(this.f30412e, 10);
            } else {
                this.f30411d.setVisibility(0);
                a(this.f30412e, 0);
            }
            this.f30408a.setText(typeCardData.getHeading());
            this.f30409b.setText(typeCardData.getText());
            k.c(typeCardData, "data");
            k.c(jVar, "viewHolderModel");
            k.c(cVar, "itemClickListener");
            CharSequence highlight = typeCardData.getHighlight();
            boolean z = true;
            if (!(highlight == null || p.a(highlight))) {
                CharSequence highlightColor = typeCardData.getHighlightColor();
                if (!(highlightColor == null || p.a(highlightColor))) {
                    CharSequence highlight2 = typeCardData.getHighlight();
                    if (highlight2 != null && !p.a(highlight2)) {
                        z = false;
                    }
                    if (!z) {
                        String text = typeCardData.getText();
                        k.a((Object) text, "data.text");
                        String highlight3 = typeCardData.getHighlight();
                        k.a((Object) highlight3, "data.highlight");
                        if (p.a((CharSequence) text, highlight3, 0, false, 6) != -1) {
                            ClickableSpan aVar = new a(this, cVar, jVar);
                            TextView textView = this.f30409b;
                            if (textView != null) {
                                j.a aVar2 = net.one97.travelpass.e.j.f30335a;
                                String highlightColor2 = typeCardData.getHighlightColor();
                                k.a((Object) highlightColor2, "data.highlightColor");
                                String text2 = typeCardData.getText();
                                k.a((Object) text2, "data.text");
                                String highlight4 = typeCardData.getHighlight();
                                k.a((Object) highlight4, "data.highlight");
                                textView.setText(j.a.a(highlightColor2, text2, highlight4, aVar));
                            }
                            TextView textView2 = this.f30409b;
                            if (textView2 != null) {
                                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f30413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f30414b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ui.c.j f30415c;

        a(r rVar, c cVar, net.one97.travelpass.ui.c.j jVar) {
            this.f30413a = rVar;
            this.f30414b = cVar;
            this.f30415c = jVar;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            c cVar = this.f30414b;
            if (cVar != null) {
                net.one97.travelpass.ui.c.j jVar = this.f30415c;
                Integer valueOf = Integer.valueOf(this.f30413a.getPosition());
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                cVar.onItemClickedItem(jVar, valueOf, Integer.valueOf(net.one97.travelpass.ui.a.d()));
            }
        }
    }

    private static void a(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, i2);
                view.requestLayout();
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }
}
