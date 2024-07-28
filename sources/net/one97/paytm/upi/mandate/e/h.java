package net.one97.paytm.upi.mandate.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.e.y;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineItem;
import net.one97.paytm.upi.util.UpiUtils;

public final class h extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final List<MandateTimeLineItem> f67194a;

    public h(List<MandateTimeLineItem> list) {
        k.c(list, "list");
        this.f67194a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        MandateTimeLineItem mandateTimeLineItem = this.f67194a.get(i2);
        k.c(mandateTimeLineItem, "mandateTimeLineItem");
        y yVar = aVar.f67195a;
        TextView textView = yVar.f66929b;
        k.a((Object) textView, "message");
        textView.setText(mandateTimeLineItem.getMessage());
        TextView textView2 = yVar.f66928a;
        k.a((Object) textView2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        textView2.setText(UpiUtils.getMandateFormattedDate(mandateTimeLineItem.getDate()));
        View view = yVar.f66931d;
        k.a((Object) view, "verticalLine");
        boolean z = true;
        if (aVar.getAdapterPosition() == aVar.f67196b.f67194a.size() - 1) {
            z = false;
        }
        f.a(view, z);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        y a2 = y.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "MandateDetailTimelineIte….context), parent, false)");
        return new a(this, a2);
    }

    public final int getItemCount() {
        return this.f67194a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final y f67195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f67196b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, y yVar) {
            super(yVar.a());
            k.c(yVar, "binding");
            this.f67196b = hVar;
            this.f67195a = yVar;
        }
    }
}
