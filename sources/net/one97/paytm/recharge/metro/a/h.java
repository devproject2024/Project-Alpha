package net.one97.paytm.recharge.metro.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.c;
import net.one97.paytm.recharge.metro.d.f;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private List<? extends IJRDataModel> f63191a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f63192b;

    public h(c.a aVar) {
        k.c(aVar, "listener");
        this.f63192b = aVar;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.metro_journey_recent_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new f(inflate, this.f63192b);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ViewTreeObserver viewTreeObserver;
        TextView textView;
        k.c(vVar, "holder");
        if (vVar instanceof f) {
            List<? extends IJRDataModel> list = this.f63191a;
            String str = null;
            IJRDataModel iJRDataModel = list != null ? (IJRDataModel) list.get(i2) : null;
            if (iJRDataModel != null) {
                CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder = (CJRMetroQRFrequentOrder) iJRDataModel;
                List<? extends IJRDataModel> list2 = this.f63191a;
                Integer valueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (i2 == valueOf.intValue() - 1) {
                    View view = ((f) vVar).f63476g;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                } else {
                    View view2 = ((f) vVar).f63476g;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                }
                f fVar = (f) vVar;
                k.c(cJRMetroQRFrequentOrder, "freqOrder");
                TextView textView2 = fVar.f63471b;
                if (textView2 != null) {
                    CJRMetroStationModel source = cJRMetroQRFrequentOrder.getSource();
                    k.a((Object) source, "freqOrder.source");
                    textView2.setText(source.getName());
                }
                TextView textView3 = fVar.f63472c;
                if (textView3 != null) {
                    CJRMetroStationModel destination = cJRMetroQRFrequentOrder.getDestination();
                    k.a((Object) destination, "freqOrder.destination");
                    textView3.setText(destination.getName());
                }
                if (cJRMetroQRFrequentOrder.getProductSubType().equals("MUMBAI_METRO_RJT") || cJRMetroQRFrequentOrder.getProductSubType().equals("HYDERABAD_METRO_RJT")) {
                    TextView textView4 = fVar.f63474e;
                    if (textView4 != null) {
                        Context context = fVar.f63470a;
                        if (context != null) {
                            str = context.getString(R.string.return_journey_new);
                        }
                        textView4.setText(str);
                    }
                } else if (cJRMetroQRFrequentOrder.getProductSubType().equals("MUMBAI_METRO_SJT") || cJRMetroQRFrequentOrder.getProductSubType().equals("HYDERABAD_METRO_SJT") || cJRMetroQRFrequentOrder.getProductSubType().equals("DELHI_METRO_SJT")) {
                    TextView textView5 = fVar.f63474e;
                    if (textView5 != null) {
                        Context context2 = fVar.f63470a;
                        if (context2 != null) {
                            str = context2.getString(R.string.single_journey);
                        }
                        textView5.setText(str);
                    }
                } else if (cJRMetroQRFrequentOrder.getProductType().equals(c.e.TP.getValue()) && (textView = fVar.f63474e) != null) {
                    Context context3 = fVar.f63470a;
                    if (context3 != null) {
                        str = context3.getString(R.string.metro_trip_pass);
                    }
                    textView.setText(str);
                }
                View view3 = fVar.f63475f;
                if (view3 != null) {
                    view3.setOnClickListener(new f.a(fVar, cJRMetroQRFrequentOrder));
                }
                TextView textView6 = fVar.f63472c;
                if (textView6 != null && (viewTreeObserver = textView6.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(new f.b(fVar));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder");
        }
    }

    public final int getItemCount() {
        List<? extends IJRDataModel> list = this.f63191a;
        Integer num = null;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.intValue() > 5) {
            return 5;
        }
        List<? extends IJRDataModel> list2 = this.f63191a;
        if (list2 != null) {
            num = Integer.valueOf(list2.size());
        }
        if (num == null) {
            k.a();
        }
        return num.intValue();
    }

    public final void a(List<? extends IJRDataModel> list) {
        this.f63191a = list;
        notifyDataSetChanged();
    }
}
