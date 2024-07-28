package common.landing.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import common.landing.b.a;
import kotlin.g.b.k;
import net.one97.paytm.insurance.R;

public final class a extends RecyclerView.a<C0178a> {

    /* renamed from: a  reason: collision with root package name */
    final a.C0181a f13464a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f13465b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0178a aVar = (C0178a) vVar;
        k.c(aVar, "holder");
        this.f13464a.a(aVar, i2);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_buy_pay, viewGroup, false);
        k.a((Object) inflate, "view");
        return new C0178a(this, inflate);
    }

    public a(a.C0181a aVar, Context context) {
        k.c(aVar, "mPresenter");
        this.f13464a = aVar;
        this.f13465b = context;
    }

    public final int getItemCount() {
        return this.f13464a.b();
    }

    /* renamed from: common.landing.a.a$a  reason: collision with other inner class name */
    public final class C0178a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f13466a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f13467b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f13468c;

        /* renamed from: d  reason: collision with root package name */
        private final View f13469d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0178a(a aVar, View view) {
            super(view);
            k.c(view, "mView");
            this.f13468c = aVar;
            this.f13469d = view;
            View view2 = this.itemView;
            ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.ivBuyPay) : null;
            this.f13467b = !(imageView instanceof ImageView) ? null : imageView;
            View view3 = this.itemView;
            TextView textView = view3 != null ? (TextView) view3.findViewById(R.id.tvTitle) : null;
            this.f13466a = !(textView instanceof TextView) ? null : textView;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" '");
            TextView textView = this.f13466a;
            sb.append(textView != null ? textView.getText() : null);
            sb.append("'");
            return sb.toString();
        }

        /* renamed from: common.landing.a.a$a$a  reason: collision with other inner class name */
        public static final class C0179a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0178a f13470a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f13471b;

            public C0179a(C0178a aVar, int i2) {
                this.f13470a = aVar;
                this.f13471b = i2;
            }

            public final void onClick(View view) {
                this.f13470a.f13468c.f13464a.a(this.f13471b);
            }
        }
    }
}
