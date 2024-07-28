package net.one97.paytm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.CJRMerchantEntity;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.paytm_finance.R;

public final class x extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRMerchantEntity> f52622a;

    /* renamed from: b  reason: collision with root package name */
    n f52623b;

    /* renamed from: c  reason: collision with root package name */
    Context f52624c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        aVar.f52627a.setText(this.f52622a.get(i2).getClientName());
        aVar.f52628b.setText(String.valueOf(this.f52622a.get(i2).getClientName().trim().charAt(0)));
        aVar.f52629c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(x.this.f52622a.get(i2).getClientName());
                OauthModule.b().sendGAMultipleLabelEvent(x.this.f52624c, "apps_linked_with_paytm", "delink_clicked", arrayList, (String) null, "/apps_linked_with_paytm", p.f56796a);
                x.this.f52623b.a(x.this.f52622a.get(i2).getClientId(), x.this.f52622a.get(i2).getClientName(), i2);
            }
        });
    }

    public x(List<CJRMerchantEntity> list, n nVar, Context context) {
        this.f52622a = list;
        this.f52623b = nVar;
        this.f52624c = context;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RoboTextView f52627a;

        /* renamed from: b  reason: collision with root package name */
        public RoboTextView f52628b;

        /* renamed from: c  reason: collision with root package name */
        public RoboTextView f52629c;

        public a(View view) {
            super(view);
            this.f52627a = (RoboTextView) view.findViewById(R.id.linked_merchant_name);
            this.f52628b = (RoboTextView) view.findViewById(R.id.linked_merchant_logo);
            this.f52629c = (RoboTextView) view.findViewById(R.id.delinkmerchant_tv);
        }
    }

    public final int getItemCount() {
        List<CJRMerchantEntity> list = this.f52622a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f52622a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.linked_merchant_item, viewGroup, false));
    }
}
