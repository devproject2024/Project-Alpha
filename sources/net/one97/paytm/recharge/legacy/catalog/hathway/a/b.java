package net.one97.paytm.recharge.legacy.catalog.hathway.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.shopping.CJRDthPlanInfo;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.common.entity.shopping.CJRService;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.hathway.a.c;

@Deprecated
public final class b extends RecyclerView.a<RecyclerView.v> implements c.b {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f62930a;

    /* renamed from: b  reason: collision with root package name */
    public CJRDthPlanInfo f62931b;

    /* renamed from: c  reason: collision with root package name */
    Activity f62932c;

    /* renamed from: d  reason: collision with root package name */
    boolean f62933d = false;

    /* renamed from: e  reason: collision with root package name */
    net.one97.paytm.recharge.legacy.catalog.hathway.c.a f62934e;

    /* renamed from: f  reason: collision with root package name */
    c f62935f;

    public b(Activity activity, RecyclerView recyclerView, CJRDthPlanInfo cJRDthPlanInfo, net.one97.paytm.recharge.legacy.catalog.hathway.c.a aVar) {
        this.f62930a = recyclerView;
        this.f62931b = cJRDthPlanInfo;
        this.f62932c = activity;
        this.f62934e = aVar;
        q.d("In setParent");
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        q.d("In ViewHolder");
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cable_check_box_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        Integer num;
        q.d("In BindViewHolder" + i2 + this.f62931b.getServices().size());
        if (i2 < this.f62931b.getServices().size()) {
            CJRService cJRService = this.f62931b.getServices().get(i2);
            Integer num2 = 0;
            a aVar = (a) vVar;
            TextView textView = aVar.f62936a;
            TextView textView2 = aVar.f62940e;
            TextView textView3 = aVar.f62937b;
            if (cJRService != null && !TextUtils.isEmpty(cJRService.getConnectiontype()) && !TextUtils.isEmpty(cJRService.getConnectiontype())) {
                String str = cJRService.getConnectiontype() + " -" + cJRService.getVCNo();
                if (cJRService.getmTotalCableAmount() != null) {
                    num = cJRService.getmTotalCableAmount();
                } else {
                    for (CJRPlanExpiryDetails amount : cJRService.getPlanExpiryDetails()) {
                        num2 = Integer.valueOf(num2.intValue() + Integer.parseInt(amount.getAmount()));
                    }
                    cJRService.setmTotalCableAmount(num2);
                    num = num2;
                }
                if (!(textView == null || textView2 == null)) {
                    textView.setText(str);
                    textView2.setText(String.valueOf(num));
                }
                textView3.setText(this.f62932c.getResources().getString(R.string.view_details_re));
            }
        }
    }

    public final int getItemCount() {
        q.d("In getItemCount");
        CJRDthPlanInfo cJRDthPlanInfo = this.f62931b;
        if (cJRDthPlanInfo == null || cJRDthPlanInfo.getServices().isEmpty()) {
            return 0;
        }
        return this.f62931b.getServices().size();
    }

    public final void a(Integer num, boolean z, int i2) {
        CJRService cJRService = this.f62931b.getServices().get(i2);
        int intValue = cJRService.getmTotalCableAmount().intValue() + (num.intValue() * (z ? 1 : -1));
        cJRService.setmTotalCableAmount(Integer.valueOf(intValue));
        RecyclerView.v findViewHolderForAdapterPosition = this.f62930a.findViewHolderForAdapterPosition(i2);
        if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof a)) {
            ((a) findViewHolderForAdapterPosition).f62940e.setText(String.valueOf(intValue));
        }
    }

    public class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f62936a;

        /* renamed from: b  reason: collision with root package name */
        TextView f62937b;

        /* renamed from: c  reason: collision with root package name */
        public CheckBox f62938c;

        /* renamed from: d  reason: collision with root package name */
        public View f62939d;

        /* renamed from: e  reason: collision with root package name */
        TextView f62940e;

        /* renamed from: f  reason: collision with root package name */
        public RecyclerView f62941f;

        a(View view) {
            super(view);
            this.f62936a = (TextView) view.findViewById(R.id.cable_name);
            this.f62938c = (CheckBox) view.findViewById(R.id.utility_check_box);
            this.f62940e = (TextView) view.findViewById(R.id.cable_price);
            this.f62937b = (TextView) view.findViewById(R.id.cable_view_details);
            this.f62941f = (RecyclerView) view.findViewById(R.id.rv_cable_child_list);
            this.f62939d = view.findViewById(R.id.cable_view_seperator);
            this.f62941f.setVisibility(8);
            this.f62938c.setChecked(true);
            this.f62939d.setVisibility(8);
            this.f62941f.setHasFixedSize(true);
            this.f62941f.setLayoutManager(new LinearLayoutManager(b.this.f62932c.getBaseContext()));
            this.f62937b.setOnClickListener(this);
            this.f62938c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(b.this) {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    int parseInt;
                    if (compoundButton.getTag() == null || ((Boolean) compoundButton.getTag()).booleanValue()) {
                        int adapterPosition = a.this.getAdapterPosition();
                        int i2 = 0;
                        CJRService cJRService = b.this.f62931b.getServices().get(adapterPosition);
                        if (a.this.f62941f == null || a.this.f62941f.getAdapter() == null) {
                            i2 = b.this.f62931b.getServices().get(adapterPosition).getAmount();
                        } else {
                            for (CJRPlanExpiryDetails next : cJRService.getPlanExpiryDetails()) {
                                if (z && !next.isChecked()) {
                                    parseInt = Integer.parseInt(next.getAmount());
                                } else if (!z && next.isChecked()) {
                                    parseInt = Integer.parseInt(next.getAmount());
                                }
                                i2 += parseInt;
                            }
                        }
                        b.this.f62934e.a(Integer.valueOf(i2), z);
                        b.this.a(Integer.valueOf(i2), z, adapterPosition);
                        for (CJRPlanExpiryDetails checked : cJRService.getPlanExpiryDetails()) {
                            checked.setChecked(z);
                        }
                        if (a.this.f62941f != null && a.this.f62941f.getAdapter() != null) {
                            a.this.f62941f.getAdapter().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    compoundButton.setTag(Boolean.TRUE);
                }
            });
        }

        public final void onClick(View view) {
            getLayoutPosition();
            int adapterPosition = getAdapterPosition();
            if (!b.this.f62933d) {
                RecyclerView recyclerView = this.f62941f;
                if (recyclerView != null) {
                    if (recyclerView.getAdapter() == null && b.this.f62931b != null && !b.this.f62931b.getServices().get(adapterPosition).getPlanExpiryDetails().isEmpty()) {
                        b bVar = b.this;
                        bVar.f62935f = new c(bVar.f62932c, b.this.f62931b.getServices().get(adapterPosition).getPlanExpiryDetails(), b.this.f62934e, b.this.f62931b.getServices().get(adapterPosition), this.f62938c, b.this);
                        b.this.f62935f.f62947a = adapterPosition;
                        this.f62941f.setAdapter(b.this.f62935f);
                    }
                    this.f62941f.setVisibility(0);
                    b.this.f62933d = true;
                    return;
                }
                return;
            }
            RecyclerView recyclerView2 = this.f62941f;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
                b.this.f62933d = false;
            }
        }
    }
}
