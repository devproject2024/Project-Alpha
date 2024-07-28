package net.one97.paytm.marketplace.search.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct;
import net.one97.paytm.paytm_finance.R;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f53418a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRSearchPopularProduct> f53419b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f53420c = new View.OnClickListener() {
        public final void onClick(final View view) {
            if (view.getTag() instanceof Integer) {
                net.one97.paytm.marketplace.a.a(e.this.f53418a, "product", (HashMap<String, Serializable>) new HashMap<String, Serializable>() {
                    {
                        put("cart_item_url", e.this.f53419b.get(((Integer) view.getTag()).intValue()).getmUrl());
                    }
                });
            }
        }
    };

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRSearchPopularProduct cJRSearchPopularProduct;
        a aVar = (a) vVar;
        if (i2 < this.f53419b.size() && (cJRSearchPopularProduct = this.f53419b.get(i2)) != null) {
            if (cJRSearchPopularProduct.getmText() != null) {
                aVar.f53423b.setText(cJRSearchPopularProduct.getmText());
            }
            if (cJRSearchPopularProduct.getmPrice() != null) {
                aVar.f53424c.setText(this.f53418a.getString(R.string.cashback_text, new Object[]{b.x(String.valueOf(cJRSearchPopularProduct.getmPrice()))}));
            }
            if (cJRSearchPopularProduct.getmImageUrl() != null) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f53418a);
                a2.f43753a = cJRSearchPopularProduct.getmImageUrl();
                b.a.C0750a.a(a2, aVar.f53422a, (com.paytm.utility.b.b.b) null, 2);
            }
            aVar.f53425d.setTag(Integer.valueOf(i2));
            aVar.f53425d.setOnClickListener(this.f53420c);
        }
    }

    e(Context context, ArrayList<CJRSearchPopularProduct> arrayList) {
        this.f53418a = context;
        this.f53419b = arrayList;
    }

    public final int getItemCount() {
        return this.f53419b.size();
    }

    static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f53422a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f53423b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f53424c;

        /* renamed from: d  reason: collision with root package name */
        LinearLayout f53425d;

        a(View view) {
            super(view);
            this.f53422a = (ImageView) view.findViewById(R.id.product_image);
            this.f53423b = (RoboTextView) view.findViewById(R.id.product_name);
            this.f53424c = (RoboTextView) view.findViewById(R.id.product_price);
            this.f53425d = (LinearLayout) view.findViewById(R.id.lyt_popular_product_item);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lyt_popular_search_product_paytm, viewGroup, false));
    }
}
