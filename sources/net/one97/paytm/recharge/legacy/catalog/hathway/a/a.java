package net.one97.paytm.recharge.legacy.catalog.hathway.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.recharge.R;

@Deprecated
public final class a extends RecyclerView.a<C1217a> {

    /* renamed from: a  reason: collision with root package name */
    final List<CJRPlanExpiryDetails> f62919a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentActivity f62920b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1217a aVar = (C1217a) vVar;
        CJRPlanExpiryDetails cJRPlanExpiryDetails = this.f62919a.get(i2);
        String packname = cJRPlanExpiryDetails.getPackname();
        if (packname != null) {
            aVar.f62921a.setText(packname);
        }
        String amount = cJRPlanExpiryDetails.getAmount();
        if (amount != null) {
            aVar.f62923c.setText(this.f62920b.getString(R.string.amount_per_month_holder, new Object[]{this.f62920b.getString(R.string.price_container_re, new Object[]{String.valueOf(amount)})}));
        }
        aVar.f62922b.setText(this.f62920b.getResources().getQuantityString(R.plurals.count_channel_placeholder, this.f62919a.size(), new Object[]{Integer.valueOf(this.f62919a.size())}));
        String planduration = cJRPlanExpiryDetails.getPlanduration();
        if (planduration != null) {
            aVar.f62924d.setText(this.f62920b.getString(R.string.cabel_validity_month, new Object[]{planduration}));
        }
        String formatedDateWithFullYear = cJRPlanExpiryDetails.getFormatedDateWithFullYear();
        if (formatedDateWithFullYear != null) {
            aVar.f62925e.setText(this.f62920b.getString(R.string.cabel_expiry, new Object[]{formatedDateWithFullYear}));
        }
        aVar.f62926f.setChecked(cJRPlanExpiryDetails.isChecked());
    }

    public a(List<CJRPlanExpiryDetails> list, FragmentActivity fragmentActivity) {
        this.f62919a = list;
        this.f62920b = fragmentActivity;
    }

    public final int getItemCount() {
        return this.f62919a.size();
    }

    /* renamed from: net.one97.paytm.recharge.legacy.catalog.hathway.a.a$a  reason: collision with other inner class name */
    public class C1217a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f62921a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f62922b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f62923c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f62924d;

        /* renamed from: e  reason: collision with root package name */
        final TextView f62925e;

        /* renamed from: f  reason: collision with root package name */
        public final CheckBox f62926f;

        public C1217a(View view) {
            super(view);
            this.f62926f = (CheckBox) view.findViewById(R.id.cb_recharge_view);
            this.f62921a = (TextView) view.findViewById(R.id.tv_cable_type);
            this.f62922b = (TextView) view.findViewById(R.id.tv_channel_number);
            this.f62923c = (TextView) view.findViewById(R.id.tv_channelamount);
            this.f62924d = (TextView) view.findViewById(R.id.tv_validityView);
            this.f62925e = (TextView) view.findViewById(R.id.tv_expiryView);
            this.f62926f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(a.this) {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.f62919a.get(C1217a.this.getAdapterPosition()).setChecked(z);
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C1217a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_on_group_description, viewGroup, false));
    }
}
