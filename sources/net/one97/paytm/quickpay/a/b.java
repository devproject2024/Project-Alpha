package net.one97.paytm.quickpay.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.paytm_finance.R;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRHomePageItem> f59839a;

    /* renamed from: b  reason: collision with root package name */
    private Context f59840b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        Resources resources;
        a aVar = (a) vVar;
        CJRHomePageItem cJRHomePageItem = this.f59839a.get(i2);
        aVar.f59841a.setText(TextUtils.isEmpty(cJRHomePageItem.getName()) ? this.f59840b.getResources().getText(R.string.qp_add_other) : cJRHomePageItem.getName());
        aVar.f59843c.setSelected(cJRHomePageItem.isSelected());
        TextView textView = aVar.f59841a;
        if (cJRHomePageItem.isSelected()) {
            resources = this.f59840b.getResources();
            i3 = R.color.white;
        } else {
            resources = this.f59840b.getResources();
            i3 = R.color.color_00b9f5;
        }
        textView.setTextColor(resources.getColor(i3));
        aVar.f59842b.setVisibility(TextUtils.isEmpty(cJRHomePageItem.getName()) ? 0 : 8);
        aVar.f59842b.setSelected(cJRHomePageItem.isSelected());
    }

    public final int getItemCount() {
        List<CJRHomePageItem> list = this.f59839a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59841a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59842b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f59843c;

        public a(View view) {
            super(view);
            this.f59841a = (TextView) view.findViewById(R.id.txt_payment_reminder);
            this.f59843c = (LinearLayout) view.findViewById(R.id.ll_qp_container);
            this.f59842b = (ImageView) view.findViewById(R.id.ic_add_qp);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_default_payment_reminder, (ViewGroup) null));
    }
}
