package net.one97.paytm.marketplace.search.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.marketplace.search.a.c;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.l;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRGridProduct> f53382a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f53383b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Object> f53384c = null;

    public c(ArrayList<CJRGridProduct> arrayList, Activity activity) {
        this.f53382a = arrayList;
        this.f53383b = activity;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shopping_offer_grid_item, viewGroup, false));
        aVar.f53387c.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ c.a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                c.this.a(this.f$1, view);
            }
        });
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, View view) {
        ArrayList<CJRGridProduct> arrayList;
        int adapterPosition = aVar.getAdapterPosition();
        if (adapterPosition != -1 && (arrayList = this.f53382a) != null && arrayList.size() > adapterPosition) {
            CJRGridProduct cJRGridProduct = this.f53382a.get(adapterPosition);
            Activity activity = this.f53383b;
            if (activity instanceof AJRSearchActivity) {
                ((AJRSearchActivity) activity).a(cJRGridProduct.getURL(), cJRGridProduct);
            }
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRGridProduct cJRGridProduct = this.f53382a.get(i2);
        String a2 = l.a(cJRGridProduct.getImageUrl());
        aVar.f53392h.setVisibility(8);
        aVar.f53392h.setTag(a2);
        aVar.f53385a.setTag(a2);
        ProgressBar progressBar = aVar.f53392h;
        progressBar.setVisibility(0);
        aVar.f53386b.setText(cJRGridProduct.getName());
        aVar.f53393i.setText(cJRGridProduct.getBrand());
        try {
            if (cJRGridProduct.getDiscountedPrice() != null) {
                if (!cJRGridProduct.getDiscountedPrice().equalsIgnoreCase("0")) {
                    aVar.f53388d.setText(String.format("%s%s", new Object[]{this.f53383b.getString(R.string.rupee_symbol), b.x(cJRGridProduct.getDiscountedPrice().trim())}));
                } else {
                    aVar.f53388d.setText(R.string.grid_free);
                }
            }
        } catch (NumberFormatException unused) {
        }
        aVar.f53390f.setVisibility(8);
        if (cJRGridProduct.getActualPrice() == null || cJRGridProduct.getDiscountedPrice().equalsIgnoreCase(cJRGridProduct.getActualPrice())) {
            aVar.f53391g.setVisibility(8);
        } else {
            String str = this.f53383b.getString(R.string.rupee_symbol) + b.x(cJRGridProduct.getDiscountedPrice());
            aVar.f53389e.setText(this.f53383b.getString(R.string.rupee_symbol) + b.x(cJRGridProduct.getActualPrice()));
            if (str.length() > 11) {
                aVar.f53391g.setVisibility(0);
            } else {
                aVar.f53391g.setVisibility(0);
                if (cJRGridProduct.getDiscountPercent() == null || cJRGridProduct.getDiscountedPrice().trim().length() <= 0) {
                    aVar.f53390f.setVisibility(8);
                } else if (Integer.parseInt(cJRGridProduct.getDiscountPercent()) > 0) {
                    aVar.f53390f.setText(String.format("%s%% Off", new Object[]{cJRGridProduct.getDiscountPercent()}));
                    aVar.f53390f.setVisibility(0);
                } else {
                    aVar.f53390f.setVisibility(8);
                }
            }
        }
        if (a2 != null) {
            b.a.C0750a a3 = com.paytm.utility.b.b.a(this.f53383b);
            a3.f43753a = a2;
            a3.a(aVar.f53385a);
        }
        progressBar.setVisibility(8);
    }

    public final int getItemCount() {
        ArrayList<CJRGridProduct> arrayList = this.f53382a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f53385a;

        /* renamed from: b  reason: collision with root package name */
        TextView f53386b;

        /* renamed from: c  reason: collision with root package name */
        ConstraintLayout f53387c;

        /* renamed from: d  reason: collision with root package name */
        TextView f53388d;

        /* renamed from: e  reason: collision with root package name */
        TextView f53389e;

        /* renamed from: f  reason: collision with root package name */
        TextView f53390f;

        /* renamed from: g  reason: collision with root package name */
        Group f53391g;

        /* renamed from: h  reason: collision with root package name */
        ProgressBar f53392h;

        /* renamed from: i  reason: collision with root package name */
        TextView f53393i;

        a(View view) {
            super(view);
            this.f53387c = (ConstraintLayout) view.findViewById(R.id.lyt_grid_item);
            this.f53385a = (ImageView) view.findViewById(R.id.product_image);
            this.f53386b = (TextView) view.findViewById(R.id.product_name);
            this.f53388d = (TextView) view.findViewById(R.id.discounted_price);
            this.f53389e = (TextView) view.findViewById(R.id.actual_price);
            this.f53390f = (TextView) view.findViewById(R.id.discount_percent);
            this.f53391g = (Group) view.findViewById(R.id.layout_actual_price);
            this.f53392h = (ProgressBar) view.findViewById(R.id.img_loading);
            this.f53393i = (TextView) view.findViewById(R.id.brand_name);
        }
    }
}
