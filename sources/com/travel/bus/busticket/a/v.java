package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.e.m;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import java.util.ArrayList;
import java.util.Iterator;

public final class v extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21775a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRBusSearchOperatorTagInfo> f21776b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRBusSearchOperatorTagInfo> f21777c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private a f21778d;

    public interface a {
        void a(ArrayList<CJRBusSearchOperatorTagInfo> arrayList);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public v(Context context, ArrayList<CJRBusSearchOperatorTagInfo> arrayList, a aVar) {
        this.f21775a = context;
        this.f21776b = arrayList;
        this.f21778d = aVar;
        b();
    }

    private void b() {
        Iterator<CJRBusSearchOperatorTagInfo> it2 = this.f21776b.iterator();
        while (it2.hasNext()) {
            CJRBusSearchOperatorTagInfo next = it2.next();
            if (next != null && next.isSelected()) {
                this.f21777c.add(next);
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new m(LayoutInflater.from(this.f21775a).inflate(R.layout.pre_b_lyt_amenity_filter_item, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        m mVar = (m) vVar;
        Context context = this.f21775a;
        CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.f21776b.get(i2);
        mVar.a(context, cJRBusSearchOperatorTagInfo);
        mVar.f22180b.setText(cJRBusSearchOperatorTagInfo.getLabel());
        if (mVar != null) {
            mVar.f22181c.setOnClickListener(new View.OnClickListener(i2, mVar) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ m f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    v.this.a(this.f$1, this.f$2, view);
                }
            });
        }
    }

    public final ArrayList<CJRBusSearchOperatorTagInfo> a() {
        return this.f21777c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, m mVar, View view) {
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList;
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList2 = this.f21776b;
        if (arrayList2 == null || arrayList2.get(i2) == null || !this.f21776b.get(i2).isSelected()) {
            CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.f21776b.get(i2);
            cJRBusSearchOperatorTagInfo.setSelected(true);
            this.f21776b.get(i2).setSelected(true);
            this.f21777c.add(cJRBusSearchOperatorTagInfo);
            mVar.a(this.f21775a, cJRBusSearchOperatorTagInfo);
        } else {
            ArrayList<CJRBusSearchOperatorTagInfo> arrayList3 = this.f21777c;
            if (arrayList3 != null && arrayList3.size() > 0) {
                CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo2 = this.f21776b.get(i2);
                ArrayList arrayList4 = new ArrayList();
                if (!(cJRBusSearchOperatorTagInfo2 == null || (arrayList = this.f21777c) == null || arrayList.size() <= 0)) {
                    Iterator<CJRBusSearchOperatorTagInfo> it2 = this.f21777c.iterator();
                    while (it2.hasNext()) {
                        CJRBusSearchOperatorTagInfo next = it2.next();
                        if (!(next == null || next.getLabel() == null || next.getLabel().equalsIgnoreCase(cJRBusSearchOperatorTagInfo2.getLabel()))) {
                            arrayList4.add(next);
                        }
                    }
                    this.f21777c.clear();
                    this.f21777c.addAll(arrayList4);
                }
                this.f21776b.get(i2).setSelected(false);
                mVar.a(this.f21775a, this.f21776b.get(i2));
                this.f21777c.remove(this.f21776b.get(i2));
            }
        }
        a aVar = this.f21778d;
        if (aVar != null) {
            aVar.a(this.f21777c);
        }
    }

    public final int getItemCount() {
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList = this.f21776b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
