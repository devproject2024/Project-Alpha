package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.model.TravelPassMetaData;
import net.one97.travelpass.ui.c.j;

public final class p extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30393a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30394b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f30395c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f30396d;

    /* renamed from: e  reason: collision with root package name */
    private View f30397e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_question);
        if (textView != null) {
            this.f30393a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_ans);
            if (textView2 != null) {
                this.f30394b = textView2;
                ImageView imageView = (ImageView) view.findViewById(R.id.plus_icon);
                if (imageView != null) {
                    this.f30395c = imageView;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.faq_container);
                    if (linearLayout != null) {
                        this.f30396d = linearLayout;
                        View findViewById = view.findViewById(R.id.seperator);
                        k.a((Object) findViewById, "itemView?.findViewById(R.id.seperator)");
                        this.f30397e = findViewById;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        new StringBuilder("inside Travel FAQ ").append(jVar.c());
        IJRPaytmDataModel b2 = jVar.b();
        if (b2 != null) {
            TravelPassMetaData.FaqContent faqContent = (TravelPassMetaData.FaqContent) b2;
            this.f30393a.setText(faqContent.getHeading());
            this.f30394b.setText(faqContent.getSubheading());
            k.c(jVar, "viewHolderModel");
            if (jVar.h()) {
                this.f30394b.setVisibility(0);
                ImageView imageView = this.f30395c;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.ic_remove_black_24dp);
                }
            } else {
                this.f30394b.setVisibility(8);
                ImageView imageView2 = this.f30395c;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.ic_add_black_24dp);
                }
            }
            if (jVar.f()) {
                this.f30397e.setVisibility(8);
            }
            this.f30396d.setOnClickListener(new a(cVar, jVar, i2));
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.travelpass.model.TravelPassMetaData.FaqContent");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30398a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30399b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30400c;

        a(c cVar, j jVar, int i2) {
            this.f30398a = cVar;
            this.f30399b = jVar;
            this.f30400c = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f30398a;
            if (cVar != null) {
                c.a.a(cVar, this.f30399b, Integer.valueOf(this.f30400c), (Integer) null, 4);
            }
        }
    }
}
