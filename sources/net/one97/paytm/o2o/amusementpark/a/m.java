package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.q;

public final class m extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    List<Boolean> f73226a;

    /* renamed from: b  reason: collision with root package name */
    List<CJRSeatDetailsModel> f73227b;

    /* renamed from: c  reason: collision with root package name */
    Context f73228c;

    /* renamed from: d  reason: collision with root package name */
    a f73229d;

    /* renamed from: e  reason: collision with root package name */
    int f73230e;

    /* renamed from: f  reason: collision with root package name */
    private int f73231f;

    public interface a {
        RecyclerView.v a(int i2);

        void a(int i2, int i3);

        void b(int i2, int i3);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.park_layout_package_info, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRSeatDetailsModel cJRSeatDetailsModel = this.f73227b.get(i2);
        if (cJRSeatDetailsModel != null) {
            b bVar = (b) vVar;
            bVar.f73240i = i2;
            if (net.one97.paytm.o2o.amusementpark.f.b.b(cJRSeatDetailsModel.getSeatType()) || net.one97.paytm.o2o.amusementpark.f.b.b(cJRSeatDetailsModel.getmPackageType())) {
                TextView textView = bVar.f73232a;
                textView.setText(cJRSeatDetailsModel.getSeatType() + " " + cJRSeatDetailsModel.getmPackageType());
            } else {
                TextView textView2 = bVar.f73232a;
                textView2.setText(cJRSeatDetailsModel.getSeatType() + " ( " + cJRSeatDetailsModel.getmPackageType() + " )");
            }
            TextView textView3 = bVar.f73233b;
            textView3.setText(m.this.f73228c.getString(R.string.rupee_symbol) + cJRSeatDetailsModel.getPrice());
            String seatDescription = cJRSeatDetailsModel.getSeatDescription();
            if (seatDescription == null || seatDescription.length() <= 0) {
                bVar.f73234c.setVisibility(8);
            } else {
                bVar.f73234c.setText(seatDescription);
            }
            bVar.f73235d.setText(cJRSeatDetailsModel.getmPackageDescription());
            if (m.this.f73227b.get(bVar.f73240i).getSeatsAvailable() > 0) {
                bVar.itemView.findViewById(R.id.package_info_holder).setOnClickListener(bVar.j);
                CJRSeatDetailsModel cJRSeatDetailsModel2 = m.this.f73227b.get(bVar.f73240i);
                int seatLimit = cJRSeatDetailsModel2.getSeatLimit();
                if (seatLimit > cJRSeatDetailsModel2.getSeatsAvailable()) {
                    seatLimit = cJRSeatDetailsModel2.getSeatsAvailable();
                }
                q qVar = bVar.f73239h;
                int i3 = bVar.f73240i;
                int selectedQuantityAtStart = cJRSeatDetailsModel2.getSelectedQuantityAtStart();
                qVar.f73285a = seatLimit;
                qVar.f73287c = i3;
                qVar.f73286b = selectedQuantityAtStart;
                qVar.notifyDataSetChanged();
                bVar.f73236e.getLayoutManager().scrollToPosition(cJRSeatDetailsModel2.getSelectedQuantityAtStart() - 1);
                if (cJRSeatDetailsModel.getSelectedQuantityAtStart() > 0) {
                    bVar.a(false);
                    if (m.this.f73229d != null) {
                        cJRSeatDetailsModel.setSelectedQuantity(0);
                        m.this.f73229d.a(cJRSeatDetailsModel.getSelectedQuantityAtStart(), bVar.f73240i);
                        return;
                    }
                    return;
                }
                return;
            }
            bVar.f73238g.setVisibility(0);
            bVar.f73232a.setEnabled(false);
            bVar.f73233b.setEnabled(false);
        }
    }

    public final int getItemCount() {
        return this.f73231f;
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f73232a = null;

        /* renamed from: b  reason: collision with root package name */
        TextView f73233b = null;

        /* renamed from: c  reason: collision with root package name */
        TextView f73234c = null;

        /* renamed from: d  reason: collision with root package name */
        TextView f73235d = null;

        /* renamed from: e  reason: collision with root package name */
        RecyclerView f73236e = null;

        /* renamed from: f  reason: collision with root package name */
        View f73237f = null;

        /* renamed from: g  reason: collision with root package name */
        TextView f73238g = null;

        /* renamed from: h  reason: collision with root package name */
        q f73239h;

        /* renamed from: i  reason: collision with root package name */
        int f73240i = -1;
        View.OnClickListener j = new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar;
                if (view.getId() != R.id.package_info_holder) {
                    return;
                }
                if (b.this.f73237f.getVisibility() == 0) {
                    b.this.a(false);
                    m.this.f73226a.set(b.this.f73240i, Boolean.FALSE);
                    m.this.f73230e = -1;
                    return;
                }
                b.this.a(true);
                m.this.f73226a.set(b.this.f73240i, Boolean.TRUE);
                m mVar = m.this;
                if (!(mVar.f73229d == null || mVar.f73230e == -1 || (bVar = (b) mVar.f73229d.a(mVar.f73230e)) == null)) {
                    bVar.a(false);
                }
                m.this.f73230e = b.this.f73240i;
            }
        };
        private TextView l = null;
        private q.b m = new q.b() {
            public final void a(int i2, int i3) {
                m.this.f73227b.get(i3).setSelectedQuantityAtStart(i2);
                if (m.this.f73229d != null) {
                    m.this.f73229d.b(i2, i3);
                }
            }
        };

        public b(View view) {
            super(view);
            this.f73237f = view.findViewById(R.id.ll_package_info);
            this.f73232a = (TextView) view.findViewById(R.id.tv_package_name);
            this.f73233b = (TextView) view.findViewById(R.id.tv_package_amount);
            this.f73234c = (TextView) view.findViewById(R.id.tv_package_category_desc);
            this.f73235d = (TextView) view.findViewById(R.id.tv_package_desc);
            this.l = (TextView) view.findViewById(R.id.tv_package_tckts_count);
            this.f73238g = (TextView) view.findViewById(R.id.tv_sold_out);
            this.f73236e = (RecyclerView) view.findViewById(R.id.rv_visitor_count_container);
            this.f73236e.setLayoutManager(new LinearLayoutManager(m.this.f73228c, 0, false));
            this.f73236e.addItemDecoration(new RecyclerView.h() {
                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    rect.right = (int) (m.this.f73228c.getResources().getDisplayMetrics().density * 5.0f);
                }
            });
            this.f73239h = new q(this.m);
            this.f73236e.setAdapter(this.f73239h);
        }

        private void b(boolean z) {
            int selectedQuantityAtStart = m.this.f73227b.get(this.f73240i).getSelectedQuantityAtStart();
            if (z) {
                if (selectedQuantityAtStart > 0) {
                    String string = m.this.f73228c.getString(R.string.text_tickets);
                    TextView textView = this.l;
                    textView.setText(String.valueOf(selectedQuantityAtStart) + " " + string);
                } else {
                    z = false;
                }
            }
            if (z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        }

        public final void a(boolean z) {
            if (z) {
                this.f73237f.setVisibility(0);
            } else {
                this.f73237f.setVisibility(8);
            }
            b(!z);
        }
    }
}
