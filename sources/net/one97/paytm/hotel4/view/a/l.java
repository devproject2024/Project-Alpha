package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.paytm.utility.b;
import com.travel.a.c;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.PriceData;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fu;

public final class l extends c<CJRRoom> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28704b;

    /* renamed from: c  reason: collision with root package name */
    private SubRoomOptions f28705c;

    /* renamed from: d  reason: collision with root package name */
    private int f28706d;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        CJRRoom cJRRoom = (CJRRoom) obj;
        k.c(viewDataBinding, "binding");
        k.c(cJRRoom, "item");
        if (viewDataBinding instanceof fu) {
            fu fuVar = (fu) viewDataBinding;
            TextView textView = fuVar.f29766c;
            k.a((Object) textView, "binding.tvRoomDescri");
            textView.setText("Room " + String.valueOf(i2 + 1) + " - " + String.valueOf(cJRRoom.getAdultCount()) + " Adults & " + cJRRoom.getChildrenCount() + " Child");
            StringBuilder sb = new StringBuilder("for ");
            sb.append(String.valueOf(this.f28706d));
            e eVar = e.f28642a;
            sb.append(e.a(" night", "", Integer.valueOf(this.f28706d)));
            sb.append(")");
            String sb2 = sb.toString();
            double d2 = (double) this.f28706d;
            SubRoomOptions subRoomOptions = this.f28705c;
            if (subRoomOptions == null) {
                k.a();
            }
            List<SubRoomProvider> subRoomProviders = subRoomOptions.getSubRoomProviders();
            if (subRoomProviders == null) {
                k.a();
            }
            PriceData priceData = subRoomProviders.get(0).getPriceData();
            if (priceData == null) {
                k.a();
            }
            double finalPrice = d2 * priceData.getFinalPrice();
            TextView textView2 = fuVar.f29764a;
            k.a((Object) textView2, "binding.tvFareDescri");
            StringBuilder sb3 = new StringBuilder("( ");
            Context context = this.f28704b;
            if (context == null) {
                k.a();
            }
            sb3.append(context.getString(R.string.h4_hotels_rupees));
            SubRoomOptions subRoomOptions2 = this.f28705c;
            if (subRoomOptions2 == null) {
                k.a();
            }
            List<SubRoomProvider> subRoomProviders2 = subRoomOptions2.getSubRoomProviders();
            if (subRoomProviders2 == null) {
                k.a();
            }
            PriceData priceData2 = subRoomProviders2.get(0).getPriceData();
            if (priceData2 == null) {
                k.a();
            }
            sb3.append(b.a(priceData2.getFinalPrice()).toString());
            sb3.append("/ night ");
            sb3.append(sb2);
            textView2.setText(sb3.toString());
            a.C0498a aVar = a.f28631a;
            a.C0498a.a(fuVar.f29765b, finalPrice);
        }
    }

    public l(SubRoomOptions subRoomOptions, int i2) {
        super(new h.c<CJRRoom>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                CJRRoom cJRRoom = (CJRRoom) obj;
                CJRRoom cJRRoom2 = (CJRRoom) obj2;
                k.c(cJRRoom, "oldItem");
                k.c(cJRRoom2, "newItem");
                return k.a((Object) cJRRoom, (Object) cJRRoom2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                CJRRoom cJRRoom = (CJRRoom) obj;
                CJRRoom cJRRoom2 = (CJRRoom) obj2;
                k.c(cJRRoom, "oldItem");
                k.c(cJRRoom2, "newItem");
                return k.a((Object) cJRRoom, (Object) cJRRoom2);
            }
        });
        this.f28705c = subRoomOptions;
        this.f28706d = i2;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28704b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_room_config, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
