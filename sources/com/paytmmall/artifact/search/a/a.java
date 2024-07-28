package com.paytmmall.artifact.search.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.a.b;
import com.paytmmall.artifact.d.a.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.grid.entity.CJRGridProduct;
import com.paytmmall.artifact.search.a.a;
import com.paytmmall.artifact.search.activity.AJRSearchActivity;
import com.paytmmall.artifact.widget.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private String f15892a = "CJRHorizontalGridItemAdapter";

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRGridProduct> f15893b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f15894c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Object> f15895d;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a() {
    }

    public a(ArrayList<CJRGridProduct> arrayList, Activity activity) {
        this.f15893b = arrayList;
        this.f15894c = activity;
        this.f15895d = null;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        C0214a aVar = new C0214a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mall_grid_item_v2_horizontal, viewGroup, false));
        aVar.f15898c.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ a.C0214a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.this.a(this.f$1, view);
            }
        });
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(C0214a aVar, View view) {
        ArrayList<CJRGridProduct> arrayList;
        int adapterPosition = aVar.getAdapterPosition();
        if (adapterPosition != -1 && (arrayList = this.f15893b) != null && arrayList.size() > adapterPosition) {
            CJRGridProduct cJRGridProduct = this.f15893b.get(adapterPosition);
            Activity activity = this.f15894c;
            if (activity instanceof AJRSearchActivity) {
                cJRGridProduct.getURL();
                ((AJRSearchActivity) activity).b();
            }
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0214a aVar = (C0214a) vVar;
        CJRGridProduct cJRGridProduct = this.f15893b.get(i2);
        String d2 = d.d(cJRGridProduct.getImageUrl());
        aVar.f15904i.setVisibility(8);
        aVar.f15904i.setTag(d2);
        aVar.f15896a.setTag(d2);
        ProgressBar progressBar = aVar.f15904i;
        progressBar.setVisibility(0);
        aVar.f15897b.setText(cJRGridProduct.getName());
        String offerTag = cJRGridProduct.getOfferTag();
        if (!TextUtils.isEmpty(offerTag)) {
            aVar.j.setVisibility(0);
            aVar.k.setText(offerTag);
        } else {
            aVar.j.setVisibility(8);
        }
        try {
            if (cJRGridProduct.getDiscountedPrice() != null) {
                if (!cJRGridProduct.getDiscountedPrice().equalsIgnoreCase("0")) {
                    aVar.f15899d.setText(String.format("%s%s", new Object[]{this.f15894c.getString(R.string.rupee_symbol), d.c(cJRGridProduct.getDiscountedPrice())}));
                } else {
                    aVar.f15899d.setText(R.string.grid_free);
                }
            }
        } catch (NumberFormatException unused) {
        }
        aVar.f15901f.setVisibility(8);
        if (cJRGridProduct.isInStock()) {
            aVar.f15902g.setVisibility(8);
        } else {
            aVar.f15902g.setVisibility(0);
        }
        if (cJRGridProduct.getActualPrice() == null || cJRGridProduct.getDiscountedPrice().equalsIgnoreCase(cJRGridProduct.getActualPrice())) {
            aVar.f15903h.setVisibility(8);
        } else {
            String str = this.f15894c.getString(R.string.rupee_symbol) + d.c(cJRGridProduct.getDiscountedPrice());
            aVar.f15900e.setText(this.f15894c.getString(R.string.rupee_symbol) + d.c(cJRGridProduct.getActualPrice()));
            if (str.length() > 11) {
                aVar.f15903h.setVisibility(0);
            } else {
                aVar.f15903h.setVisibility(0);
                if (cJRGridProduct.getDiscountPercent() == null || cJRGridProduct.getDiscountedPrice().trim().length() <= 0) {
                    aVar.f15901f.setVisibility(8);
                } else if (Integer.parseInt(cJRGridProduct.getDiscountPercent()) > 0) {
                    aVar.f15901f.setText(String.format(" -%s%% ", new Object[]{cJRGridProduct.getDiscountPercent()}));
                    aVar.f15901f.setVisibility(0);
                } else {
                    aVar.f15901f.setVisibility(8);
                }
            }
        }
        if (d2 != null) {
            ImageView imageView = aVar.f15896a;
            int i3 = R.drawable.mall_picasso_default_placeholder;
            c.a(d2, imageView, i3, i3, new b(progressBar) {
                private final /* synthetic */ ProgressBar f$0;

                {
                    this.f$0 = r1;
                }

                public final void onSuccess() {
                    this.f$0.setVisibility(8);
                }
            }, $$Lambda$a$LUzAodfbU5UyE_uWlwFw8Lq2u30.INSTANCE);
            return;
        }
        progressBar.setVisibility(8);
    }

    public final int getItemCount() {
        ArrayList<CJRGridProduct> arrayList = this.f15893b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: com.paytmmall.artifact.search.a.a$a  reason: collision with other inner class name */
    public class C0214a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f15896a;

        /* renamed from: b  reason: collision with root package name */
        TextView f15897b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f15898c;

        /* renamed from: d  reason: collision with root package name */
        TextView f15899d;

        /* renamed from: e  reason: collision with root package name */
        TextView f15900e;

        /* renamed from: f  reason: collision with root package name */
        TextView f15901f;

        /* renamed from: g  reason: collision with root package name */
        RoboTextView f15902g;

        /* renamed from: h  reason: collision with root package name */
        RelativeLayout f15903h;

        /* renamed from: i  reason: collision with root package name */
        ProgressBar f15904i;
        LinearLayout j;
        TextView k;

        C0214a(View view) {
            super(view);
            this.f15898c = (RelativeLayout) view.findViewById(R.id.lyt_grid_item);
            this.f15896a = (ImageView) view.findViewById(R.id.product_image);
            this.f15902g = (RoboTextView) view.findViewById(R.id.txt_out_of_stock);
            this.f15897b = (TextView) view.findViewById(R.id.product_name);
            this.f15899d = (TextView) view.findViewById(R.id.discounted_price);
            this.f15900e = (TextView) view.findViewById(R.id.actual_price);
            this.f15901f = (TextView) view.findViewById(R.id.discount_percent);
            this.f15903h = (RelativeLayout) view.findViewById(R.id.layout_actual_price);
            this.f15904i = (ProgressBar) view.findViewById(R.id.img_loading);
            this.j = (LinearLayout) view.findViewById(R.id.offer_tag_container);
            this.k = (TextView) view.findViewById(R.id.offer_tag);
            d.a((TextView) this.f15902g);
            d.b(this.f15897b);
            view.getContext();
            d.c(this.f15899d);
            d.b(this.f15900e);
            view.getContext();
            d.c(this.f15901f);
            d.b(this.k);
        }
    }
}
