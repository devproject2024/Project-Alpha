package com.paytmmall.artifact.search.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.a.c;
import com.paytmmall.artifact.d.e;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.search.entity.CJRSearchPopularProduct;
import com.paytmmall.artifact.widget.RoboTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public final class d extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f15941a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRSearchPopularProduct> f15942b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f15943c = new View.OnClickListener() {
        public final void onClick(final View view) {
            if (view.getTag() instanceof Integer) {
                t.a(d.this.f15941a, "product", (HashMap<String, Serializable>) new HashMap<String, Serializable>() {
                    {
                        put("cart_item_url", d.this.f15942b.get(((Integer) view.getTag()).intValue()).getmUrl());
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
        if (i2 < this.f15942b.size() && (cJRSearchPopularProduct = this.f15942b.get(i2)) != null) {
            if (cJRSearchPopularProduct.getmText() != null) {
                aVar.f15946b.setText(cJRSearchPopularProduct.getmText());
            }
            if (cJRSearchPopularProduct.getmPrice() != null) {
                aVar.f15947c.setText(this.f15941a.getString(R.string.cashback_text, new Object[]{e.a(String.valueOf(cJRSearchPopularProduct.getmPrice()))}));
            }
            if (cJRSearchPopularProduct.getmImageUrl() != null) {
                c.a(cJRSearchPopularProduct.getmImageUrl(), aVar.f15945a);
            }
            aVar.f15948d.setTag(Integer.valueOf(i2));
            aVar.f15948d.setOnClickListener(this.f15943c);
        }
    }

    d(Context context, ArrayList<CJRSearchPopularProduct> arrayList) {
        this.f15941a = context;
        this.f15942b = arrayList;
    }

    public final int getItemCount() {
        return this.f15942b.size();
    }

    static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f15945a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f15946b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f15947c;

        /* renamed from: d  reason: collision with root package name */
        LinearLayout f15948d;

        a(View view) {
            super(view);
            this.f15945a = (ImageView) view.findViewById(R.id.product_image);
            this.f15946b = (RoboTextView) view.findViewById(R.id.product_name);
            this.f15947c = (RoboTextView) view.findViewById(R.id.product_price);
            this.f15948d = (LinearLayout) view.findViewById(R.id.lyt_popular_product_item);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mall_lyt_popular_search_product, viewGroup, false));
    }
}
