package net.one97.paytm.v2.features.cashbacklanding.c;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20150b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    String f20151c = "";

    /* renamed from: d  reason: collision with root package name */
    private final int f20152d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20153e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20154f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f20155g;

    public final void a(String str) {
        k.c(str, "offerType");
    }

    public final void a(ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList) {
        String str;
        k.c(arrayList, "data");
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList2 = this.f20150b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList3 = this.f20150b;
        if (arrayList3 != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList4 = this.f20154f;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
        Iterator<net.one97.paytm.v2.features.cashbacklanding.model.a> it2 = arrayList.iterator();
        String str2 = "";
        while (it2.hasNext()) {
            net.one97.paytm.v2.features.cashbacklanding.model.a next = it2.next();
            if (next.m != null) {
                d.a aVar = d.f20859a;
                Long l = next.m;
                if (l == null) {
                    k.a();
                }
                str = d.a.a(l.longValue(), "MMMM yyyy");
            } else {
                str = "";
            }
            if (this.f20154f.size() == 0) {
                net.one97.paytm.v2.features.cashbacklanding.model.a aVar2 = new net.one97.paytm.v2.features.cashbacklanding.model.a((String) null, (String) null, (String) null, (String) null, 0, 63);
                aVar2.n = str;
                this.f20154f.add(aVar2);
            } else if (!p.a(str, str2, true)) {
                net.one97.paytm.v2.features.cashbacklanding.model.a aVar3 = new net.one97.paytm.v2.features.cashbacklanding.model.a((String) null, (String) null, (String) null, (String) null, 0, 63);
                aVar3.n = str;
                this.f20154f.add(aVar3);
            }
            this.f20154f.add(next);
            str2 = str;
        }
        if (this.f20155g) {
            ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList5 = this.f20154f;
            a.C0382a.C0383a aVar4 = a.C0382a.f20768a;
            arrayList5.add(new net.one97.paytm.v2.features.cashbacklanding.model.a((String) null, (String) null, (String) null, (String) null, a.C0382a.f20774g, 32));
        }
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f20153e) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cashback_points_list_item, viewGroup, false);
            if (inflate == null) {
                k.a();
            }
            return new b(this, inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_headling_layout, viewGroup, false);
        if (inflate2 == null) {
            k.a();
        }
        return new a(this, inflate2);
    }

    public final int getItemCount() {
        return this.f20154f.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CharSequence charSequence;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        String str;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        k.c(vVar, "holder");
        net.one97.paytm.v2.features.cashbacklanding.model.a aVar = this.f20154f.get(i2);
        k.a((Object) aVar, "viewList[position]");
        net.one97.paytm.v2.features.cashbacklanding.model.a aVar2 = aVar;
        if (vVar instanceof b) {
            b bVar = (b) vVar;
            k.c(aVar2, "offer");
            View view = bVar.itemView;
            k.a((Object) view, "itemView");
            TextView textView = (TextView) view.findViewById(R.id.cashbackPointsTitle);
            k.a((Object) textView, "itemView.cashbackPointsTitle");
            textView.setText(aVar2.f20290c);
            View view2 = bVar.itemView;
            k.a((Object) view2, "itemView");
            TextView textView2 = (TextView) view2.findViewById(R.id.amount);
            k.a((Object) textView2, "itemView.amount");
            int i3 = aVar2.f20293f;
            a.C0382a.C0383a aVar3 = a.C0382a.f20768a;
            if (i3 == a.C0382a.f20776i) {
                View view3 = bVar.itemView;
                k.a((Object) view3, "itemView");
                TextView textView3 = (TextView) view3.findViewById(R.id.rupeeAmount);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                d.a aVar4 = d.f20859a;
                charSequence = d.a.e(aVar2.f20291d);
            } else {
                d.a aVar5 = d.f20859a;
                charSequence = d.a.e(aVar2.f20291d);
            }
            textView2.setText(charSequence);
            CharSequence charSequence2 = aVar2.f20289b;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                aa a2 = w.a().a(aVar2.f20289b).a(R.drawable.cashback_placeholder);
                ImageView imageView = bVar.f20157a;
                int i4 = (imageView == null || (layoutParams4 = imageView.getLayoutParams()) == null) ? 0 : layoutParams4.width;
                ImageView imageView2 = bVar.f20157a;
                a2.a(i4, (imageView2 == null || (layoutParams3 = imageView2.getLayoutParams()) == null) ? 0 : layoutParams3.height).a(bVar.f20157a);
            }
            if (aVar2.f20292e) {
                View view4 = bVar.itemView;
                k.a((Object) view4, "itemView");
                TextView textView4 = (TextView) view4.findViewById(R.id.dateStatus);
                if (textView4 != null) {
                    textView4.setTextColor(Color.parseColor("#FF9D00"));
                    textView4.setText(textView4.getResources().getText(R.string.pending));
                }
                View view5 = bVar.itemView;
                k.a((Object) view5, "itemView");
                ((TextView) view5.findViewById(R.id.amount)).setTextColor(Color.parseColor("#FF9D00"));
                View view6 = bVar.itemView;
                k.a((Object) view6, "itemView");
                ((TextView) view6.findViewById(R.id.rupeeAmount)).setTextColor(Color.parseColor("#FF9D00"));
            } else {
                View view7 = bVar.itemView;
                k.a((Object) view7, "itemView");
                TextView textView5 = (TextView) view7.findViewById(R.id.dateStatus);
                if (textView5 != null) {
                    textView5.setTextColor(Color.parseColor("#8BA6C1"));
                    if (aVar2.m != null) {
                        d.a aVar6 = d.f20859a;
                        Long l = aVar2.m;
                        if (l == null) {
                            k.a();
                        }
                        str = d.a.a(l.longValue(), "dd MMMM");
                    } else {
                        str = "";
                    }
                    textView5.setText(str);
                }
                View view8 = bVar.itemView;
                k.a((Object) view8, "itemView");
                ((TextView) view8.findViewById(R.id.amount)).setTextColor(Color.parseColor("#21C17A"));
                View view9 = bVar.itemView;
                k.a((Object) view9, "itemView");
                ((TextView) view9.findViewById(R.id.rupeeAmount)).setTextColor(Color.parseColor("#21C17A"));
            }
            bVar.itemView.setOnClickListener(new b.a(bVar, aVar2));
            int i5 = aVar2.f20293f;
            a.C0382a.C0383a aVar7 = a.C0382a.f20768a;
            if (i5 == a.C0382a.f20776i) {
                aa a3 = w.a().a(aVar2.o).a(R.drawable.cashback_placeholder);
                ImageView imageView3 = bVar.f20157a;
                int i6 = (imageView3 == null || (layoutParams2 = imageView3.getLayoutParams()) == null) ? 0 : layoutParams2.width;
                ImageView imageView4 = bVar.f20157a;
                aa a4 = a3.a(i6, (imageView4 == null || (layoutParams = imageView4.getLayoutParams()) == null) ? 0 : layoutParams.height);
                View view10 = bVar.itemView;
                k.a((Object) view10, "itemView");
                a4.a((ImageView) view10.findViewById(R.id.offerImage));
                View view11 = bVar.itemView;
                k.a((Object) view11, "itemView");
                ImageView imageView5 = (ImageView) view11.findViewById(R.id.offerImage);
                k.a((Object) imageView5, "itemView.offerImage");
                imageView5.setVisibility(0);
                View view12 = bVar.itemView;
                k.a((Object) view12, "itemView");
                ImageView imageView6 = (ImageView) view12.findViewById(R.id.offerImagebg);
                k.a((Object) imageView6, "itemView.offerImagebg");
                imageView6.setVisibility(0);
                return;
            }
            View view13 = bVar.itemView;
            k.a((Object) view13, "itemView");
            ImageView imageView7 = (ImageView) view13.findViewById(R.id.offerImage);
            k.a((Object) imageView7, "itemView.offerImage");
            imageView7.setVisibility(8);
            View view14 = bVar.itemView;
            k.a((Object) view14, "itemView");
            ImageView imageView8 = (ImageView) view14.findViewById(R.id.offerImagebg);
            k.a((Object) imageView8, "itemView.offerImagebg");
            imageView8.setVisibility(8);
        } else if (vVar instanceof a) {
            k.c(aVar2, "offer");
            View view15 = ((a) vVar).itemView;
            k.a((Object) view15, "itemView");
            TextView textView6 = (TextView) view15.findViewById(R.id.heading);
            k.a((Object) textView6, "itemView.heading");
            textView6.setText(aVar2.n);
        }
    }

    public final int getItemViewType(int i2) {
        String str;
        net.one97.paytm.v2.features.cashbacklanding.model.a aVar;
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList = this.f20154f;
        if (arrayList == null || (aVar = arrayList.get(i2)) == null) {
            str = null;
        } else {
            str = aVar.n;
        }
        if (str == null) {
            return this.f20153e;
        }
        return this.f20152d;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f20157a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f20158b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20158b = cVar;
            this.f20157a = (ImageView) view.findViewById(R.id.offerLogo);
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f20159a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.v2.features.cashbacklanding.model.a f20160b;

            a(b bVar, net.one97.paytm.v2.features.cashbacklanding.model.a aVar) {
                this.f20159a = bVar;
                this.f20160b = aVar;
            }

            public final void onClick(View view) {
                m<? super Integer, ? super String, x> mVar;
                d.a aVar = d.f20859a;
                View view2 = this.f20159a.itemView;
                k.a((Object) view2, "itemView");
                d.a.a(view2);
                ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList = this.f20159a.f20158b.f20150b;
                int intValue = (arrayList != null ? Integer.valueOf(arrayList.indexOf(this.f20160b)) : null).intValue();
                if (intValue >= 0 && (mVar = this.f20159a.f20158b.f20149a) != null) {
                    mVar.invoke(Integer.valueOf(intValue), this.f20159a.f20158b.f20151c);
                }
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20156a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f20156a = cVar;
        }
    }
}
