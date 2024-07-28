package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.util.ArrayList;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodData;
import net.one97.paytm.o2o.movies.R;

public class p extends b {

    /* renamed from: a  reason: collision with root package name */
    private View f75408a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f75409b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRSummaryFoodData> f75410c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f75411d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f75412e;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f75408a = layoutInflater.inflate(R.layout.movie_summary_food_fragment, (ViewGroup) null);
        this.f75410c = (ArrayList) getArguments().getSerializable("food_data");
        this.f75409b = (RecyclerView) this.f75408a.findViewById(R.id.id_movie_summary_food_recyclerview);
        this.f75409b.setAdapter(new b(this, (byte) 0));
        this.f75409b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f75411d = getContext();
        this.f75412e = (LayoutInflater) this.f75411d.getSystemService("layout_inflater");
        this.f75408a.findViewById(R.id.toolbar_btn_layout).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                p.this.getActivity().getSupportFragmentManager().d();
            }
        });
        return this.f75408a;
    }

    class b extends RecyclerView.a<a> {
        private b() {
        }

        /* synthetic */ b(p pVar, byte b2) {
            this();
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            CJRSummaryFoodData cJRSummaryFoodData = (CJRSummaryFoodData) p.this.f75410c.get(i2);
            if (cJRSummaryFoodData != null) {
                if (!TextUtils.isEmpty(cJRSummaryFoodData.getItemName())) {
                    aVar.f75415b.setText(cJRSummaryFoodData.getItemName().trim());
                }
                if (!TextUtils.isEmpty(cJRSummaryFoodData.getTotalChargedPrice())) {
                    TextView textView = aVar.f75418e;
                    textView.setText(p.this.f75411d.getString(R.string.rupees) + cJRSummaryFoodData.getTotalChargedPrice());
                }
                if (!TextUtils.isEmpty(cJRSummaryFoodData.getItemImageUrl())) {
                    t a2 = t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory());
                    Context unused = p.this.f75411d;
                    a2.a(cJRSummaryFoodData.getItemImageUrl(), aVar.f75414a, (ProgressBar) null);
                }
                if (cJRSummaryFoodData.getQuantity() > 0) {
                    aVar.f75417d.setVisibility(0);
                    TextView textView2 = aVar.f75417d;
                    textView2.setText(p.this.f75411d.getString(R.string.quantity) + " : " + cJRSummaryFoodData.getQuantity());
                } else {
                    aVar.f75417d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cJRSummaryFoodData.getItemDescription())) {
                    aVar.f75416c.setVisibility(0);
                    aVar.f75416c.setText(cJRSummaryFoodData.getItemDescription());
                    return;
                }
                aVar.f75416c.setVisibility(8);
            }
        }

        public final int getItemCount() {
            return p.this.f75410c.size();
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            p pVar = p.this;
            return new a(pVar.f75412e.inflate(R.layout.movie_summary_food_fragment_item, viewGroup, false));
        }
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f75414a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f75415b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f75416c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f75417d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f75418e;

        public a(View view) {
            super(view);
            this.f75414a = (ImageView) view.findViewById(R.id.id_movie_summary_food_img);
            this.f75415b = (TextView) view.findViewById(R.id.id_movie_summary_food_name);
            this.f75416c = (TextView) view.findViewById(R.id.id_movie_summary_food_desc);
            this.f75417d = (TextView) view.findViewById(R.id.id_movie_summary_food_qty);
            this.f75418e = (TextView) view.findViewById(R.id.id_movie_summary_food_price);
        }
    }
}
