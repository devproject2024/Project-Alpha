package net.one97.paytm.recharge.metro.d;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.a.e;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceModel;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f63463a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f63464b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f63465c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f63466d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        k.c(view, "itemView");
        this.f63463a = (CheckBox) view.findViewById(R.id.radio_btn);
        this.f63464b = (TextView) view.findViewById(R.id.no_trips);
        this.f63465c = (TextView) view.findViewById(R.id.txt_validity);
        this.f63466d = (TextView) view.findViewById(R.id.txt_price);
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63467a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMetroPriceModel f63468b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e.a f63469c;

        public a(e eVar, CJRMetroPriceModel cJRMetroPriceModel, e.a aVar) {
            this.f63467a = eVar;
            this.f63468b = cJRMetroPriceModel;
            this.f63469c = aVar;
        }

        public final void onClick(View view) {
            if (!this.f63468b.isSelected()) {
                this.f63468b.setSelected(true);
                View view2 = this.f63467a.itemView;
                k.a((Object) view2, "itemView");
                view2.setSelected(true);
                CheckBox checkBox = this.f63467a.f63463a;
                if (checkBox != null) {
                    checkBox.setChecked(true);
                }
                this.f63467a.a(true);
                e.a aVar = this.f63469c;
                if (aVar != null) {
                    aVar.a(this.f63467a.getAdapterPosition());
                }
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            TextView textView = this.f63464b;
            if (textView != null) {
                textView.setTypeface(textView.getTypeface(), 1);
            }
            TextView textView2 = this.f63465c;
            if (textView2 != null) {
                textView2.setTypeface(textView2.getTypeface(), 1);
            }
            TextView textView3 = this.f63466d;
            if (textView3 != null) {
                textView3.setTypeface(textView3.getTypeface(), 1);
            }
        }
    }
}
