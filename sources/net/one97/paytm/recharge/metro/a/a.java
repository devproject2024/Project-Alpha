package net.one97.paytm.recharge.metro.a;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.c;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public final class a extends RecyclerView.a<C1221a> {

    /* renamed from: a  reason: collision with root package name */
    CJRMetroStationModel f63132a;

    /* renamed from: b  reason: collision with root package name */
    public List<CJRMetroStationModel> f63133b;

    /* renamed from: c  reason: collision with root package name */
    final c.a f63134c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63135d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f63136e = 0;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1221a aVar = (C1221a) vVar;
        CJRMetroStationModel cJRMetroStationModel = this.f63133b.get(i2);
        if (this.f63135d) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(cJRMetroStationModel.getName().substring(0, this.f63136e));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00bbfb")), 0, spannableString.length(), 0);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(cJRMetroStationModel.getName().substring(this.f63136e));
            aVar.f63137a.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        aVar.f63137a.setText(cJRMetroStationModel.getName());
    }

    public a(CJRMetroStationModel cJRMetroStationModel, List<CJRMetroStationModel> list, c.a aVar) {
        this.f63132a = cJRMetroStationModel;
        this.f63133b = list;
        this.f63134c = aVar;
    }

    public final int getItemViewType(int i2) {
        return (this.f63132a == null || !this.f63133b.get(i2).getId().equalsIgnoreCase(this.f63132a.getId())) ? 1 : 2;
    }

    public final int getItemCount() {
        return this.f63133b.size();
    }

    /* renamed from: net.one97.paytm.recharge.metro.a.a$a  reason: collision with other inner class name */
    public class C1221a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63137a;

        public C1221a(View view) {
            super(view);
            this.f63137a = (TextView) view.findViewById(R.id.tv_station_name);
            this.itemView.setOnClickListener(new View.OnClickListener(a.this) {
                public final void onClick(View view) {
                    if (C1221a.this.getItemViewType() != 2 && a.this.f63134c != null) {
                        CJRMetroStationModel cJRMetroStationModel = a.this.f63133b.get(C1221a.this.getAdapterPosition());
                        if (a.this.f63132a == null) {
                            a.this.f63134c.a(cJRMetroStationModel, (CJRMetroStationModel) null);
                        } else {
                            a.this.f63134c.a(a.this.f63132a, cJRMetroStationModel);
                        }
                    }
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        if (i2 == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mumbai_metro_station_list_not_selected_itemt, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mumbai_metro_station_list_selected_item, viewGroup, false);
        }
        return new C1221a(view);
    }
}
