package net.one97.paytm.upgradeKyc.kycV3.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.TimeSlots;
import net.one97.paytm.upgradeKyc.R;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<IJRDataModel> f66049a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f66050b;

    /* renamed from: c  reason: collision with root package name */
    private final int f66051c = 1;

    /* renamed from: d  reason: collision with root package name */
    private final C1323b f66052d;

    /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.b$b  reason: collision with other inner class name */
    public interface C1323b {
        void a(String str, int i2);

        void b(String str, int i2);
    }

    public b(C1323b bVar) {
        k.c(bVar, "slotClickListener");
        this.f66052d = bVar;
    }

    public final void a(List<? extends IJRDataModel> list) {
        k.c(list, "itemList");
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.f66049a.clear();
            this.f66049a.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f66051c) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kyc_slot_picker_date_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…date_item, parent, false)");
            return new a(inflate, this.f66052d);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kyc_slot_picker_date_item, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…date_item, parent, false)");
        return new a(inflate2, this.f66052d);
    }

    public final int getItemCount() {
        return this.f66049a.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f66049a.get(i2) instanceof TimeSlots) {
            return this.f66051c;
        }
        return this.f66050b;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof a) {
            vVar.setIsRecyclable(false);
            IJRDataModel iJRDataModel = this.f66049a.get(i2);
            if (iJRDataModel instanceof TimeSlots) {
                a aVar = (a) vVar;
                TimeSlots timeSlots = (TimeSlots) iJRDataModel;
                k.c(timeSlots, "item");
                TextView textView = aVar.f66053a;
                k.a((Object) textView, "title");
                textView.setText(timeSlots.getDate());
                if (i2 == 0) {
                    TextView textView2 = aVar.f66053a;
                    k.a((Object) textView2, "title");
                    textView2.setActivated(true);
                    TextView textView3 = aVar.f66053a;
                    View view = aVar.itemView;
                    k.a((Object) view, "itemView");
                    textView3.setTextColor(androidx.core.content.b.c(view.getContext(), com.paytm.utility.R.color.white));
                }
                aVar.f66053a.setOnClickListener(new a.C1322a(aVar, timeSlots));
            }
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2, List<Object> list) {
        k.c(vVar, "holder");
        k.c(list, "payloads");
        super.onBindViewHolder(vVar, i2, list);
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (k.a(obj, (Object) "daySelected")) {
                if (vVar instanceof a) {
                    a aVar = (a) vVar;
                    TextView textView = aVar.f66053a;
                    TextView textView2 = aVar.f66053a;
                    k.a((Object) textView2, "holder.title");
                    textView.setTextColor(androidx.core.content.b.c(textView2.getContext(), com.paytm.utility.R.color.white));
                    TextView textView3 = aVar.f66053a;
                    k.a((Object) textView3, "holder.title");
                    textView3.setActivated(true);
                }
            } else if (k.a(obj, (Object) "dayUnselected") && (vVar instanceof a)) {
                a aVar2 = (a) vVar;
                TextView textView4 = aVar2.f66053a;
                TextView textView5 = aVar2.f66053a;
                k.a((Object) textView5, "holder.title");
                textView4.setTextColor(androidx.core.content.b.c(textView5.getContext(), com.paytm.utility.R.color.black));
                TextView textView6 = aVar2.f66053a;
                k.a((Object) textView6, "holder.title");
                textView6.setActivated(false);
            }
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f66053a;

        /* renamed from: b  reason: collision with root package name */
        final C1323b f66054b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, C1323b bVar) {
            super(view);
            k.c(view, "itemView");
            k.c(bVar, "listener");
            this.f66054b = bVar;
            this.f66053a = (TextView) view.findViewById(R.id.slot_date);
        }

        /* renamed from: net.one97.paytm.upgradeKyc.kycV3.a.b$a$a  reason: collision with other inner class name */
        static final class C1322a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f66055a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TimeSlots f66056b;

            C1322a(a aVar, TimeSlots timeSlots) {
                this.f66055a = aVar;
                this.f66056b = timeSlots;
            }

            public final void onClick(View view) {
                C1323b bVar = this.f66055a.f66054b;
                String date = this.f66056b.getDate();
                if (date == null) {
                    k.a();
                }
                bVar.a(date, this.f66055a.getAdapterPosition());
            }
        }
    }
}
