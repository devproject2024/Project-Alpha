package net.one97.paytm.paymentsBank.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.paymentsBank.R;

public class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f17300a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<PBCJRAddress> f17301b;

    /* renamed from: c  reason: collision with root package name */
    private int f17302c = -1;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.bankCommon.f.a f17303d;

    public /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        PBCJRAddress pBCJRAddress = this.f17301b.get(i2);
        if (TextUtils.isEmpty(pBCJRAddress.getFulladdress())) {
            StringBuilder sb = new StringBuilder();
            sb.append(pBCJRAddress.getAddress1());
            if (!TextUtils.isEmpty(pBCJRAddress.getAddress2())) {
                sb.append(", ");
                sb.append(pBCJRAddress.getAddress2());
            }
            if (!TextUtils.isEmpty(pBCJRAddress.getCity())) {
                sb.append(", ");
                sb.append(pBCJRAddress.getCity());
            }
            if (!TextUtils.isEmpty(pBCJRAddress.getState())) {
                sb.append(", ");
                sb.append(pBCJRAddress.getState());
            }
            if (!TextUtils.isEmpty(pBCJRAddress.getPin())) {
                sb.append(" - ");
                sb.append(pBCJRAddress.getPin());
            }
            aVar.f17306c.setText(sb.toString());
        } else {
            aVar.f17306c.setText(pBCJRAddress.getFulladdress());
        }
        aVar.f17305b.setText(pBCJRAddress.getName());
        aVar.f17307d.setText(pBCJRAddress.getMobile());
        if (pBCJRAddress.isChecked()) {
            aVar.f17304a.setChecked(true);
            this.f17302c = i2;
        } else {
            aVar.f17304a.setChecked(false);
        }
        aVar.f17304a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(pBCJRAddress, i2) {
            private final /* synthetic */ PBCJRAddress f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                c.this.a(this.f$1, this.f$2, compoundButton, z);
            }
        });
    }

    public c(Context context, ArrayList<PBCJRAddress> arrayList, net.one97.paytm.bankCommon.f.a aVar) {
        this.f17300a = context;
        this.f17301b = arrayList;
        this.f17303d = aVar;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_horizontal_address, viewGroup, false));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(PBCJRAddress pBCJRAddress, int i2, CompoundButton compoundButton, boolean z) {
        if (z) {
            pBCJRAddress.setIsChecked(true);
            int i3 = this.f17302c;
            if (i3 != -1) {
                this.f17301b.get(i3).setIsChecked(false);
            }
            this.f17303d.a(this.f17302c, i2);
            this.f17302c = i2;
        }
    }

    public int getItemCount() {
        return this.f17301b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RadioButton f17304a;

        /* renamed from: b  reason: collision with root package name */
        TextView f17305b;

        /* renamed from: c  reason: collision with root package name */
        TextView f17306c;

        /* renamed from: d  reason: collision with root package name */
        TextView f17307d;

        public a(View view) {
            super(view);
            this.f17304a = (RadioButton) view.findViewById(R.id.rb_address);
            this.f17305b = (TextView) view.findViewById(R.id.tv_name);
            this.f17306c = (TextView) view.findViewById(R.id.tv_address);
            this.f17307d = (TextView) view.findViewById(R.id.tv_contact);
        }
    }
}
