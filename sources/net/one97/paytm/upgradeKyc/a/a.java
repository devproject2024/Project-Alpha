package net.one97.paytm.upgradeKyc.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.utils.l;

public final class a extends RecyclerView.a<C1290a> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f65186a = 0;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<PayTMPartnerListModal.Response> f65187b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f65188c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1290a aVar = (C1290a) vVar;
        PayTMPartnerListModal.Response response = this.f65187b.get(i2);
        if (response != null && response != null) {
            aVar.f65191c.setText(response.cashPointsDetail.displayName);
            if (TextUtils.isEmpty(response.cashPointsDetail.category)) {
                aVar.f65192d.setVisibility(8);
            } else {
                aVar.f65192d.setVisibility(0);
                aVar.f65192d.setText(response.cashPointsDetail.category);
            }
            TextView textView = aVar.f65193e;
            ArrayList<String> arrayList = response.cashPointsDetail.address;
            StringBuilder sb = new StringBuilder();
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (!TextUtils.isEmpty(arrayList.get(i3))) {
                        sb.append(arrayList.get(i3));
                    }
                    if (i3 < size - 1) {
                        sb.append(" ");
                    }
                }
            }
            textView.setText(sb.toString());
            TextView textView2 = aVar.f65194f;
            textView2.setText(new DecimalFormat("##.##").format(response.distanceFromLocation) + " km");
            if (response.cashPointsDetail.contactNo == null || response.cashPointsDetail.contactNo.size() <= 0) {
                aVar.f65195g.setVisibility(8);
            } else {
                aVar.f65195g.setVisibility(0);
            }
            aVar.f65196h.setOnClickListener(this);
            aVar.f65196h.setTag(Integer.valueOf(i2));
            aVar.f65195g.setOnClickListener(this);
            aVar.f65195g.setTag(Integer.valueOf(i2));
        }
    }

    public a(ArrayList<PayTMPartnerListModal.Response> arrayList, Context context) {
        this.f65187b = arrayList;
        this.f65188c = context;
    }

    public final int getItemCount() {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f65187b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        return this.f65187b.get(i2) != null ? 0 : 1;
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_kyc_center_distance) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                if (this.f65187b.get(intValue).cashPointsDetail.location != null && this.f65187b.get(intValue).cashPointsDetail.location.lat != null && this.f65187b.get(intValue).cashPointsDetail.location.lon != null) {
                    l.a();
                    l.a(this.f65187b.get(intValue).cashPointsDetail.location.lat, this.f65187b.get(intValue).cashPointsDetail.location.lon, this.f65188c);
                }
            }
        } else if (id == R.id.layout_call) {
            Object tag2 = view.getTag();
            if (tag2 instanceof Integer) {
                PayTMPartnerListModal.Response response = this.f65187b.get(((Integer) tag2).intValue());
                if (response.cashPointsDetail.contactNo != null && response.cashPointsDetail.contactNo.size() > 0) {
                    this.f65188c.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(response.cashPointsDetail.contactNo.get(0))))));
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.a.a$a  reason: collision with other inner class name */
    public class C1290a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        View f65189a;

        /* renamed from: b  reason: collision with root package name */
        View f65190b;

        /* renamed from: c  reason: collision with root package name */
        TextView f65191c;

        /* renamed from: d  reason: collision with root package name */
        TextView f65192d;

        /* renamed from: e  reason: collision with root package name */
        TextView f65193e;

        /* renamed from: f  reason: collision with root package name */
        TextView f65194f;

        /* renamed from: g  reason: collision with root package name */
        View f65195g;

        /* renamed from: h  reason: collision with root package name */
        View f65196h;

        public C1290a(View view) {
            super(view);
            this.f65189a = view.findViewById(R.id.rl_kyc_center);
            this.f65190b = view.findViewById(R.id.rl_progress_bar);
            this.f65191c = (TextView) view.findViewById(R.id.tv_kyc_center_name);
            this.f65192d = (TextView) view.findViewById(R.id.tv_kyc_center_type);
            this.f65193e = (TextView) view.findViewById(R.id.tv_kyc_center_address);
            this.f65194f = (TextView) view.findViewById(R.id.tv_distance);
            this.f65196h = view.findViewById(R.id.layout_kyc_center_distance);
            this.f65195g = view.findViewById(R.id.layout_call);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        C1290a aVar = new C1290a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kyc_center, viewGroup, false));
        if (i2 == 0) {
            aVar.f65189a.setVisibility(0);
            aVar.f65190b.setVisibility(8);
        } else {
            aVar.f65189a.setVisibility(8);
            aVar.f65190b.setVisibility(0);
        }
        return aVar;
    }
}
