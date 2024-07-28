package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public final class a extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f71723a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<net.one97.paytm.wallet.splitbill.model.a> f71724b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<net.one97.paytm.wallet.splitbill.model.a> f71725c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f71726d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.wallet.splitbill.b.a f71727e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71728f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f71729g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f71730h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f71731i = 2;
    private ArrayList<String> j = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    public final int getSectionForPosition(int i2) {
        return 0;
    }

    public a(Context context, List<net.one97.paytm.wallet.splitbill.model.a> list, net.one97.paytm.wallet.splitbill.b.a aVar, ArrayList<SBContactDetail> arrayList, boolean z) {
        this.f71724b.addAll(list);
        this.f71725c.addAll(list);
        this.f71723a = context;
        this.f71727e = aVar;
        this.f71728f = arrayList;
        this.f71729g = z;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f71730h) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_item_contact_section, viewGroup, false));
        }
        return new C1462a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_item_contact_list, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        if (vVar instanceof C1462a) {
            final C1462a aVar = (C1462a) vVar;
            final SBContactDetail sBContactDetail = this.f71724b.get(i2).f72243b;
            aVar.f71739c.setBackgroundColor(Color.parseColor(this.j.get(i2 % 10)));
            String photoUri = sBContactDetail.getPhotoUri();
            String str = sBContactDetail.getmName();
            aVar.f71738b.setText(sBContactDetail.getmName());
            aVar.f71740d.setText(sBContactDetail.getMobile());
            if (!TextUtils.isEmpty(str)) {
                aVar.f71738b.setText(sBContactDetail.getmName());
                aVar.f71739c.setText(net.one97.paytm.wallet.utility.a.d(str));
            } else {
                aVar.f71737a.setVisibility(0);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                aVar.f71737a.setVisibility(0);
                aVar.f71739c.setVisibility(8);
                w.a().a(photoUri).a(this.f71723a.getResources().getDrawable(R.drawable.profile_logout)).b(R.drawable.profile_logout).a(aVar.f71737a, (e) null);
            } else {
                aVar.f71737a.setVisibility(8);
                aVar.f71739c.setVisibility(0);
            }
            if (sBContactDetail.isSelected()) {
                aVar.f71741e.setVisibility(0);
                aVar.f71739c.setVisibility(8);
            } else {
                aVar.f71741e.setVisibility(8);
                aVar.f71737a.setVisibility(8);
                aVar.f71739c.setVisibility(0);
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (sBContactDetail.isSelected()) {
                        if (!com.paytm.utility.b.ab(a.this.f71723a).equalsIgnoreCase(sBContactDetail.getMobile())) {
                            sBContactDetail.setSelected(false);
                            aVar.f71741e.setVisibility(8);
                            aVar.f71737a.setVisibility(8);
                            aVar.f71739c.setVisibility(0);
                        }
                        a.this.f71727e.a(sBContactDetail, i2);
                        return;
                    }
                    if (!com.paytm.utility.b.ab(a.this.f71723a).equalsIgnoreCase(sBContactDetail.getMobile())) {
                        sBContactDetail.setSelected(true);
                        aVar.f71741e.setVisibility(0);
                        aVar.f71739c.setVisibility(8);
                    }
                    a.this.f71727e.a(sBContactDetail, i2);
                }
            });
        } else if (vVar instanceof b) {
            ((b) vVar).f71743a.setText(this.f71724b.get(i2).f72244c);
        }
    }

    public final int getItemCount() {
        List<net.one97.paytm.wallet.splitbill.model.a> list = this.f71724b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return this.f71724b.get(i2).f72242a ? this.f71730h : this.f71731i;
    }

    public final int getPositionForSection(int i2) {
        return this.f71726d.get(i2).intValue();
    }

    public final Object[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        this.f71726d = new ArrayList<>(26);
        int size = this.f71724b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f71724b.get(i2).f72242a) {
                String upperCase = String.valueOf(this.f71724b.get(i2).f72243b.getmName().charAt(0)).toUpperCase();
                if (!arrayList.contains(upperCase)) {
                    arrayList.add(upperCase);
                    this.f71726d.add(Integer.valueOf(i2));
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    a aVar = a.this;
                    List unused = aVar.f71724b = aVar.f71725c;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (net.one97.paytm.wallet.splitbill.model.a aVar2 : a.this.f71725c) {
                        if (!aVar2.f72242a && aVar2.f72243b.getmName().toLowerCase().contains(charSequence2)) {
                            arrayList.add(aVar2);
                        }
                    }
                    List unused2 = a.this.f71724b = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a.this.f71724b;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = a.this.f71724b = (ArrayList) filterResults.values;
                if (a.this.f71724b.size() <= 0) {
                    a.this.f71727e.c();
                } else {
                    a.this.f71727e.d();
                }
                a.this.notifyDataSetChanged();
            }
        };
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71743a;

        public b(View view) {
            super(view);
            this.f71743a = (TextView) view.findViewById(R.id.tv_section_label);
        }
    }

    /* renamed from: net.one97.paytm.wallet.splitbill.a.a$a  reason: collision with other inner class name */
    public class C1462a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71737a = ((ImageView) this.itemView.findViewById(R.id.beneficiary_circle_img));

        /* renamed from: b  reason: collision with root package name */
        TextView f71738b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71739c = ((TextView) this.itemView.findViewById(R.id.beneficiary_circle_txt));

        /* renamed from: d  reason: collision with root package name */
        TextView f71740d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f71741e;

        public C1462a(View view) {
            super(view);
            this.f71738b = (TextView) view.findViewById(R.id.tv_contact_name);
            this.f71740d = (TextView) view.findViewById(R.id.contact_no);
            this.f71741e = (ImageView) view.findViewById(R.id.imgTick);
        }
    }
}
