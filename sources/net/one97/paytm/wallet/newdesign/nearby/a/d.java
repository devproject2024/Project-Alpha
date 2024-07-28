package net.one97.paytm.wallet.newdesign.nearby.a;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;

public final class d extends RecyclerView.a<a> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public int f71034a;

    /* renamed from: b  reason: collision with root package name */
    public b f71035b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f71036c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f71037d;

    /* renamed from: e  reason: collision with root package name */
    private List<NearbyCategorySubCategoryModal.CategoryDetail> f71038e = new ArrayList();

    public interface b {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        aVar.f71039a.setText(this.f71038e.get(i2).getCategoryName());
        if (this.f71034a == i2) {
            aVar.f71040b.setVisibility(0);
            aVar.f71039a.setTextColor(Color.parseColor("#222222"));
            aVar.f71039a.setTypeface(w.a(this.f71036c, "Roboto-Bold.ttf"));
        } else {
            aVar.f71039a.setTextColor(Color.parseColor("#666666"));
            aVar.f71040b.setVisibility(4);
            aVar.f71039a.setTypeface(w.a(this.f71036c, "Roboto-Medium.ttf"));
        }
        aVar.f71041c.setTag(Integer.valueOf(i2));
        aVar.f71041c.setOnClickListener(this);
    }

    public d(Context context, int i2, List<NearbyCategorySubCategoryModal.CategoryDetail> list) {
        this.f71036c = context;
        this.f71034a = i2;
        this.f71037d = LayoutInflater.from(context);
        this.f71038e = list;
    }

    public final int getItemCount() {
        List<NearbyCategorySubCategoryModal.CategoryDetail> list = this.f71038e;
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
                b bVar = this.f71035b;
                if (bVar != null) {
                    bVar.a(num.intValue());
                }
            }
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RoboTextView f71039a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f71040b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f71041c;

        public a(View view) {
            super(view);
            this.f71039a = (RoboTextView) view.findViewById(R.id.category_item_name_tv);
            this.f71040b = (ImageView) view.findViewById(R.id.category_img_selected);
            this.f71041c = (LinearLayout) view.findViewById(R.id.ll_category_item);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f71037d.inflate(R.layout.nearby_category_item, viewGroup, false));
    }
}
