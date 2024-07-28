package net.one97.travelpass.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.b.q;
import net.one97.travelpass.model.BookingDetailsResponse;

public final class b extends RecyclerView.a<C0520b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f30612a;

    /* renamed from: b  reason: collision with root package name */
    private List<BookingDetailsResponse.BookingItems> f30613b;

    /* renamed from: c  reason: collision with root package name */
    private a f30614c;

    public interface a {
        void a(BookingDetailsResponse.BookingItems bookingItems);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0520b bVar = (C0520b) vVar;
        k.c(bVar, "holder");
        List<BookingDetailsResponse.BookingItems> list = this.f30613b;
        BookingDetailsResponse.BookingItems bookingItems = list != null ? list.get(i2) : null;
        q qVar = bVar.f30615a;
        if (qVar != null) {
            qVar.a(bookingItems);
        }
        q qVar2 = bVar.f30615a;
        if (qVar2 != null) {
            qVar2.a(Integer.valueOf(i2));
        }
        q qVar3 = bVar.f30615a;
        if (qVar3 != null) {
            qVar3.executePendingBindings();
        }
        q qVar4 = bVar.f30615a;
        if (qVar4 != null) {
            qVar4.a(this.f30614c);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.redemption_list_item, viewGroup, false);
        if (!(a2 instanceof q)) {
            a2 = null;
        }
        q qVar = (q) a2;
        if (qVar == null) {
            k.a();
        }
        return new C0520b(qVar);
    }

    public b(Context context, List<BookingDetailsResponse.BookingItems> list, a aVar) {
        this.f30612a = context;
        this.f30613b = list;
        this.f30614c = aVar;
    }

    public final int getItemCount() {
        List<BookingDetailsResponse.BookingItems> list = this.f30613b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: net.one97.travelpass.ui.a.b$b  reason: collision with other inner class name */
    public static final class C0520b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        q f30615a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0520b(q qVar) {
            super(qVar.getRoot());
            k.c(qVar, "binding");
            this.f30615a = qVar;
        }
    }
}
