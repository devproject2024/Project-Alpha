package net.one97.paytm.paymentsBank.slfd.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<BookingResponseListItem> f19007a;

    public c(List<BookingResponseListItem> list) {
        k.c(list, "itemList");
        this.f19007a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        BookingResponseListItem bookingResponseListItem = this.f19007a.get(i2);
        k.c(bookingResponseListItem, "bookingResponseListItem");
        ((TextView) aVar.f19010c.getValue()).setText(aVar.f19009b.getString(R.string.fd_num, new Object[]{bookingResponseListItem.getFdNumber()}));
        ((TextView) aVar.f19011d.getValue()).setText(aVar.f19009b.getString(R.string.fd_create_fd_roi, new Object[]{String.valueOf(bookingResponseListItem.getRateOfInterestPa())}));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_create_fd, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f19007a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ i[] f19008a;

        /* renamed from: b  reason: collision with root package name */
        final Context f19009b;

        /* renamed from: c  reason: collision with root package name */
        final g f19010c;

        /* renamed from: d  reason: collision with root package name */
        final g f19011d;

        static {
            Class<a> cls = a.class;
            f19008a = new i[]{y.a((v) new w(y.b(cls), "tvFdNumber", "getTvFdNumber()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "tvFdInterest", "getTvFdInterest()Landroid/widget/TextView;"))};
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f19009b = view.getContext();
            this.f19010c = h.a(new b(view));
            this.f19011d = h.a(new C0331a(view));
        }

        static final class b extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                View findViewById = this.$itemView.findViewById(R.id.tv_fd_number);
                if (findViewById != null) {
                    return (TextView) findViewById;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.slfd.common.view.c$a$a  reason: collision with other inner class name */
        static final class C0331a extends l implements kotlin.g.a.a<TextView> {
            final /* synthetic */ View $itemView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0331a(View view) {
                super(0);
                this.$itemView = view;
            }

            public final TextView invoke() {
                View findViewById = this.$itemView.findViewById(R.id.tv_fd_interest);
                if (findViewById != null) {
                    return (TextView) findViewById;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        }
    }
}
