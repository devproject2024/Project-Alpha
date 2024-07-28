package common.landing.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.common.landing.a.a;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final a.C0193a f13472a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f13473b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        this.f13472a.a(aVar, i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public b(a.C0193a aVar, Context context) {
        k.c(aVar, "mPresenter");
        this.f13472a = aVar;
        this.f13473b = context;
    }

    public final int getItemCount() {
        return this.f13472a.b();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f13474a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f13475b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f13476c;

        /* renamed from: d  reason: collision with root package name */
        private final View f13477d;

        /* JADX WARNING: type inference failed for: r2v6, types: [android.view.View] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(common.landing.a.b r2, android.view.View r3) {
            /*
                r1 = this;
                java.lang.String r0 = "mView"
                kotlin.g.b.k.c(r3, r0)
                r1.f13476c = r2
                r1.<init>(r3)
                r1.f13477d = r3
                android.view.View r2 = r1.itemView
                r3 = 0
                if (r2 == 0) goto L_0x001a
                int r0 = net.one97.paytm.insurance.R.id.tvCategoryName
                android.view.View r2 = r2.findViewById(r0)
                android.widget.TextView r2 = (android.widget.TextView) r2
                goto L_0x001b
            L_0x001a:
                r2 = r3
            L_0x001b:
                if (r2 == 0) goto L_0x0039
                r1.f13474a = r2
                android.view.View r2 = r1.itemView
                if (r2 == 0) goto L_0x002c
                int r3 = net.one97.paytm.insurance.R.id.ivCategoryIcon
                android.view.View r2 = r2.findViewById(r3)
                r3 = r2
                android.widget.ImageView r3 = (android.widget.ImageView) r3
            L_0x002c:
                if (r3 == 0) goto L_0x0031
                r1.f13475b = r3
                return
            L_0x0031:
                kotlin.u r2 = new kotlin.u
                java.lang.String r3 = "null cannot be cast to non-null type android.widget.ImageView"
                r2.<init>(r3)
                throw r2
            L_0x0039:
                kotlin.u r2 = new kotlin.u
                java.lang.String r3 = "null cannot be cast to non-null type android.widget.TextView"
                r2.<init>(r3)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: common.landing.a.b.a.<init>(common.landing.a.b, android.view.View):void");
        }

        public final String toString() {
            return super.toString() + " '" + this.f13474a.getText() + "'";
        }

        /* renamed from: common.landing.a.b$a$a  reason: collision with other inner class name */
        public static final class C0180a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f13478a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f13479b;

            public C0180a(a aVar, int i2) {
                this.f13478a = aVar;
                this.f13479b = i2;
            }

            public final void onClick(View view) {
                this.f13478a.f13476c.f13472a.a(this.f13479b);
            }
        }
    }
}
