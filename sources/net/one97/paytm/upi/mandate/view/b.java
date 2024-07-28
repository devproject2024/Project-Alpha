package net.one97.paytm.upi.mandate.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;

public abstract class b<D> extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f67508c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    boolean f67509a;

    /* renamed from: b  reason: collision with root package name */
    List<D> f67510b = new ArrayList();

    public abstract RecyclerView.v a(ViewGroup viewGroup);

    public abstract void a();

    public abstract void a(RecyclerView.v vVar, int i2);

    public abstract void b(RecyclerView.v vVar, int i2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.view.b$b  reason: collision with other inner class name */
    public static final class C1372b {

        /* renamed from: a  reason: collision with root package name */
        final String f67511a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof C1372b) && k.a((Object) this.f67511a, (Object) ((C1372b) obj).f67511a);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f67511a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "HeaderItem(msg=" + this.f67511a + ")";
        }

        public C1372b(String str) {
            k.c(str, "msg");
            this.f67511a = str;
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67512a;

        c(b bVar) {
            this.f67512a = bVar;
        }

        public final void onClick(View view) {
            this.f67512a.a();
        }
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.loading_footer_item, viewGroup, false);
            k.a((Object) inflate, "view");
            return new d(inflate);
        } else if (i2 != 2) {
            return a(viewGroup);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mandate_list_header, viewGroup, false);
            k.a((Object) inflate2, "view");
            a aVar = new a(inflate2);
            aVar.f67507b.setOnClickListener(new c(this));
            return aVar;
        }
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            a(vVar, i2);
        } else if (itemViewType == 2) {
            b(vVar, i2);
        }
    }

    public int getItemCount() {
        return this.f67510b.size();
    }

    public int getItemViewType(int i2) {
        if (i2 == this.f67510b.size() - 1 && this.f67509a) {
            return 0;
        }
        if (this.f67510b.get(i2) instanceof C1372b) {
            return 2;
        }
        return 1;
    }
}
