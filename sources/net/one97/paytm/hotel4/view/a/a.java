package net.one97.paytm.hotel4.view.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.utils.t;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.cc;

public final class a extends RecyclerView.a<C0501a> {

    /* renamed from: a  reason: collision with root package name */
    b f28667a;

    /* renamed from: b  reason: collision with root package name */
    private cc f28668b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f28669c;

    public interface b {
        void a();
    }

    public a(List<String> list) {
        k.c(list, "amenities");
        this.f28669c = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0501a aVar = (C0501a) vVar;
        k.c(aVar, "holder");
        if (i2 == 4) {
            aVar.a("+" + (this.f28669c.size() - i2));
        } else {
            aVar.a(this.f28669c.get(i2));
        }
        aVar.itemView.setOnClickListener(new c(this));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        cc a2 = cc.a(t.a(viewGroup, R.layout.h4_list_item_amenity));
        k.a((Object) a2, "H4ListItemAmenityBinding…ut.h4_list_item_amenity))");
        this.f28668b = a2;
        cc ccVar = this.f28668b;
        if (ccVar == null) {
            k.a("itemBinding");
        }
        return new C0501a(this, ccVar);
    }

    public final int getItemCount() {
        if (this.f28669c.size() > 4) {
            return 5;
        }
        return this.f28669c.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28672a;

        c(a aVar) {
            this.f28672a = aVar;
        }

        public final void onClick(View view) {
            b bVar = this.f28672a.f28667a;
            if (bVar == null) {
                k.a();
            }
            bVar.a();
        }
    }

    /* renamed from: net.one97.paytm.hotel4.view.a.a$a  reason: collision with other inner class name */
    public final class C0501a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28670a;

        /* renamed from: b  reason: collision with root package name */
        private final cc f28671b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0501a(a aVar, cc ccVar) {
            super(ccVar.getRoot());
            k.c(ccVar, "itemBinding");
            this.f28670a = aVar;
            this.f28671b = ccVar;
        }

        public final void a(String str) {
            k.c(str, "amenity");
            this.f28671b.a(str);
            this.f28671b.b(str);
        }
    }
}
