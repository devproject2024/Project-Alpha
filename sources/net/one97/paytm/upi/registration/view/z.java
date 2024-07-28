package net.one97.paytm.upi.registration.view;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.upi.R;

public final class z extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    int f69097a;

    /* renamed from: b  reason: collision with root package name */
    final List<String> f69098b;

    /* renamed from: c  reason: collision with root package name */
    final b<String, x> f69099c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        String str = this.f69098b.get(i2);
        k.c(str, "vpa");
        aVar.f69100a.setChecked(aVar.f69101b.f69097a == aVar.getAdapterPosition());
        aVar.f69100a.setText(str);
        if (aVar.f69100a.isChecked()) {
            aVar.f69100a.setTypeface(Typeface.SANS_SERIF, 1);
        } else {
            aVar.f69100a.setTypeface(Typeface.SANS_SERIF, 0);
        }
        aVar.f69100a.setOnCheckedChangeListener(new a.C1398a(aVar));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vpa_suggestion_item_view, viewGroup, false);
        k.a((Object) inflate, "v");
        return new a(this, inflate);
    }

    public z(List<String> list, b<? super String, x> bVar) {
        k.c(list, "vpaList");
        k.c(bVar, "onVpaClick");
        this.f69098b = list;
        this.f69099c = bVar;
    }

    public final int getItemCount() {
        return this.f69098b.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RadioButton f69100a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f69101b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z zVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f69101b = zVar;
            View findViewById = view.findViewById(R.id.radioBtnVpa);
            k.a((Object) findViewById, "itemView.findViewById(R.id.radioBtnVpa)");
            this.f69100a = (RadioButton) findViewById;
        }

        /* renamed from: net.one97.paytm.upi.registration.view.z$a$a  reason: collision with other inner class name */
        static final class C1398a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f69102a;

            C1398a(a aVar) {
                this.f69102a = aVar;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                k.a((Object) compoundButton, "btn");
                if (compoundButton.isPressed() && z) {
                    int i2 = this.f69102a.f69101b.f69097a;
                    this.f69102a.f69101b.f69097a = this.f69102a.getAdapterPosition();
                    this.f69102a.f69100a.setTypeface(this.f69102a.f69100a.getTypeface(), 1);
                    this.f69102a.f69101b.notifyItemChanged(i2, new Object());
                    this.f69102a.f69101b.f69099c.invoke(this.f69102a.f69101b.f69098b.get(this.f69102a.getAdapterPosition()));
                }
            }
        }
    }
}
