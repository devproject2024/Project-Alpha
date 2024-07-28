package net.one97.paytm.wallet.newdesign.nearby.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> f71007a;

    /* renamed from: b  reason: collision with root package name */
    private Context f71008b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> f71009c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private AdapterView.OnItemClickListener f71010d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String logoUrl;
        a aVar = (a) vVar;
        NearbyCategorySubCategoryModal.CategoryDetail categoryDetail = this.f71007a.get(i2);
        aVar.f71012b.setText(categoryDetail.getCategoryName());
        if (!(categoryDetail.getSubCategoryDetails() == null || categoryDetail.getSubCategoryDetails().size() <= 0 || (logoUrl = categoryDetail.getSubCategoryDetails().get(0).getLogoUrl()) == null)) {
            w.a().a(logoUrl).a(aVar.f71011a, (e) null);
        }
        aVar.f71013c.setOnClickListener(new View.OnClickListener(categoryDetail, i2) {
            private final /* synthetic */ NearbyCategorySubCategoryModal.CategoryDetail f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                b.this.a(this.f$1, this.f$2, view);
            }
        });
    }

    public b(Context context, ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        this.f71008b = context;
        this.f71007a = arrayList;
        this.f71010d = onItemClickListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NearbyCategorySubCategoryModal.CategoryDetail categoryDetail, int i2, View view) {
        String categoryName = categoryDetail.getCategoryName();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "nearby");
            hashMap.put("new_wallet_nearby_category_name", categoryName);
            d.a aVar = d.f71130b;
            d.a.b().a("new_wallet_nearby_category_clicked", (HashMap<String, Object>) hashMap, this.f71008b);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        this.f71010d.onItemClick((AdapterView) null, (View) null, i2, -1);
    }

    public final int getItemCount() {
        ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList = this.f71009c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void a(boolean z, boolean z2) {
        if (!z2) {
            int size = this.f71009c.size();
            if (z) {
                ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList = this.f71009c;
                ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList2 = this.f71007a;
                arrayList.addAll(size, new ArrayList(arrayList2.subList(size, arrayList2.size())));
                notifyItemRangeInserted(size, this.f71007a.size() - size);
                return;
            }
            ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList3 = this.f71009c;
            ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList4 = this.f71007a;
            arrayList3.removeAll(new ArrayList(arrayList4.subList(8, arrayList4.size())));
            notifyItemRangeRemoved(8, this.f71009c.size());
        } else if (this.f71007a.size() > 8) {
            this.f71009c.addAll(new ArrayList(this.f71007a.subList(0, 8)));
            notifyItemRangeInserted(0, 8);
        } else {
            this.f71009c.addAll(this.f71007a);
            notifyItemRangeInserted(0, this.f71007a.size());
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71011a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71012b;

        /* renamed from: c  reason: collision with root package name */
        LinearLayout f71013c;

        public a(View view) {
            super(view);
            this.f71013c = (LinearLayout) view.findViewById(R.id.ll_category);
            this.f71011a = (ImageView) view.findViewById(R.id.iv_category_icon);
            this.f71012b = (TextView) view.findViewById(R.id.tv_category_name);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f71008b).inflate(R.layout.nb_item_nearby_category, (ViewGroup) null));
    }
}
