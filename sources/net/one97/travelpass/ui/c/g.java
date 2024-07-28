package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.model.VerticalData;

public final class g extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30644a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f30645b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        if (textView != null) {
            this.f30644a = textView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tab_container);
            if (linearLayout != null) {
                this.f30645b = linearLayout;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        String str = null;
        if (!(b2 instanceof VerticalData)) {
            b2 = null;
        }
        VerticalData verticalData = (VerticalData) b2;
        TextView textView = this.f30644a;
        if (textView != null) {
            if (verticalData != null) {
                str = verticalData.getTitle();
            }
            textView.setText(str);
        }
        if (jVar.h()) {
            LinearLayout linearLayout = this.f30645b;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.pre_tp_bg_btn_coupon_add_selected);
            }
            TextView textView2 = this.f30644a;
            if (textView2 != null) {
                if (context == null) {
                    k.a();
                }
                textView2.setTextColor(b.c(context, R.color.white));
            }
        } else {
            LinearLayout linearLayout2 = this.f30645b;
            if (linearLayout2 != null) {
                linearLayout2.setBackgroundResource(R.drawable.pre_tp_bg_btn_coupon_add);
            }
            TextView textView3 = this.f30644a;
            if (textView3 != null) {
                if (context == null) {
                    k.a();
                }
                textView3.setTextColor(b.c(context, R.color.theme_accent_color));
            }
        }
        LinearLayout linearLayout3 = this.f30645b;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new a(cVar, jVar));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30647b;

        a(c cVar, j jVar) {
            this.f30646a = cVar;
            this.f30647b = jVar;
        }

        public final void onClick(View view) {
            c cVar = this.f30646a;
            if (cVar != null) {
                c.a.a(cVar, this.f30647b, (Integer) null, (Integer) null, 6);
            }
        }
    }
}
