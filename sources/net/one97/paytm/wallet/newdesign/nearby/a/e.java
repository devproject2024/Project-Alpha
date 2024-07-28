package net.one97.paytm.wallet.newdesign.nearby.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;

public final class e extends RecyclerView.a<a> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public b f71043a;

    /* renamed from: b  reason: collision with root package name */
    private List<NearbyCategorySubCategoryModal.SubCategoryDetail> f71044b = new ArrayList();

    public interface b {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        aVar.f71045a.setText(this.f71044b.get(i2).getSubCategoryName());
        aVar.f71045a.setTag(Integer.valueOf(i2));
        aVar.f71045a.setOnClickListener(this);
    }

    public e(List<NearbyCategorySubCategoryModal.SubCategoryDetail> list) {
        this.f71044b = list;
        new ArrayList();
    }

    public final int getItemCount() {
        List<NearbyCategorySubCategoryModal.SubCategoryDetail> list = this.f71044b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void onClick(View view) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                Integer num = (Integer) tag;
                b bVar = this.f71043a;
                if (bVar != null) {
                    bVar.a(num.intValue());
                }
            }
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f71045a;

        public a(View view) {
            super(view);
            this.f71045a = (TextView) view.findViewById(R.id.subcategory_item_name_tv);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nb_nearbysubcategory_row, viewGroup, false));
    }
}
