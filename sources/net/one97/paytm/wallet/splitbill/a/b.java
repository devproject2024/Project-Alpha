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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public final class b extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<SBContactDetail> f71745a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<SBContactDetail> f71746b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f71747c;

    /* renamed from: d  reason: collision with root package name */
    private List<net.one97.paytm.wallet.splitbill.model.a> f71748d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<net.one97.paytm.wallet.splitbill.model.a> f71749e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Integer> f71750f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.wallet.splitbill.b.a f71751g;

    /* renamed from: h  reason: collision with root package name */
    private int f71752h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f71753i = 2;
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

    public b(Context context, ArrayList<SBContactDetail> arrayList, net.one97.paytm.wallet.splitbill.b.a aVar) {
        this.f71745a.addAll(arrayList);
        this.f71746b.addAll(arrayList);
        this.f71747c = context;
        this.f71751g = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_item_contact_list, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        if (vVar instanceof a) {
            a aVar = (a) vVar;
            final SBContactDetail sBContactDetail = this.f71745a.get(i2);
            aVar.f71760c.setBackgroundColor(Color.parseColor(this.j.get(i2 % 10)));
            String photoUri = sBContactDetail.getPhotoUri();
            String str = sBContactDetail.getmName();
            aVar.f71759b.setText(sBContactDetail.getmName());
            aVar.f71761d.setText(sBContactDetail.getMobile());
            if (!TextUtils.isEmpty(str)) {
                aVar.f71759b.setText(sBContactDetail.getmName());
                aVar.f71760c.setText(net.one97.paytm.wallet.utility.a.d(str));
            } else {
                aVar.f71758a.setVisibility(0);
            }
            if (!TextUtils.isEmpty(photoUri)) {
                aVar.f71758a.setVisibility(0);
                aVar.f71760c.setVisibility(8);
                w.a().a(photoUri).a(this.f71747c.getResources().getDrawable(R.drawable.profile_logout)).b(R.drawable.profile_logout).a(aVar.f71758a, (e) null);
            } else {
                aVar.f71758a.setVisibility(8);
                aVar.f71760c.setVisibility(0);
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.f71751g.a(sBContactDetail, i2);
                    b.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final int getItemCount() {
        ArrayList<SBContactDetail> arrayList = this.f71745a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    b bVar = b.this;
                    bVar.f71745a = bVar.f71746b;
                } else {
                    ArrayList<SBContactDetail> arrayList = new ArrayList<>();
                    Iterator<SBContactDetail> it2 = b.this.f71746b.iterator();
                    while (it2.hasNext()) {
                        SBContactDetail next = it2.next();
                        if (next.getmName().toLowerCase().contains(charSequence2)) {
                            arrayList.add(next);
                        }
                    }
                    b.this.f71745a = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = b.this.f71745a;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                b.this.f71745a = (ArrayList) filterResults.values;
                if (b.this.f71745a.size() <= 0) {
                    b.this.f71751g.c();
                } else {
                    b.this.f71751g.d();
                }
                b.this.notifyDataSetChanged();
            }
        };
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71758a = ((ImageView) this.itemView.findViewById(R.id.beneficiary_circle_img));

        /* renamed from: b  reason: collision with root package name */
        TextView f71759b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71760c = ((TextView) this.itemView.findViewById(R.id.beneficiary_circle_txt));

        /* renamed from: d  reason: collision with root package name */
        TextView f71761d;

        /* renamed from: f  reason: collision with root package name */
        private TextView f71763f;

        /* renamed from: g  reason: collision with root package name */
        private RelativeLayout f71764g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f71765h;

        public a(View view) {
            super(view);
            this.f71763f = (TextView) view.findViewById(R.id.txt_successrate);
            this.f71764g = (RelativeLayout) view.findViewById(R.id.rl_low_success_bank);
            this.f71759b = (TextView) view.findViewById(R.id.tv_contact_name);
            this.f71761d = (TextView) view.findViewById(R.id.contact_no);
            this.f71765h = (ImageView) view.findViewById(R.id.imgTick);
        }
    }
}
