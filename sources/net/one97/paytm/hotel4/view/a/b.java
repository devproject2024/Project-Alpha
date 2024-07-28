package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fc;

public final class b extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28673b;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "item");
        if (viewDataBinding instanceof fc) {
            fc fcVar = (fc) viewDataBinding;
            fcVar.a(f.a(str));
            if (str.equals("twentyFourHrCheckIn")) {
                str = "24 * 7 CheckIn";
            } else if (str.equals("airConditioning")) {
                str = "Air Conditioning";
            } else if (str.equals("wifi")) {
                str = "Wifi";
            } else if (str.equals("roomService")) {
                str = "Room Service";
            } else if (str.equals("restaurant")) {
                str = "Restaurant";
            } else if (str.equals("bar")) {
                str = "Bar";
            } else if (str.equals("gym")) {
                str = "Gym";
            } else if (str.equals("swimmingPool")) {
                str = "Swimming Pool";
            } else if (str.equals("businessCentre")) {
                str = "Business Centre";
            } else if (str.equals("parking")) {
                str = "Free Parking";
            } else if (str.equals("minibar")) {
                str = "Minibar";
            } else if (str.equals("television")) {
                str = "Television";
            } else if (str.equals("telephone")) {
                str = "Telephone";
            } else if (str.equals("iron")) {
                str = "Iron";
            } else if (str.equals("hairdryer")) {
                str = "Hairdryer";
            } else if (str.equals("toiletries")) {
                str = "Toiletries";
            }
            fcVar.b(str);
        }
    }

    public b() {
        super(new h.c<String>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return k.a((Object) str, (Object) str2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                k.c(str, "oldItem");
                k.c(str2, "newItem");
                return k.a((Object) str, (Object) str2);
            }
        });
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28673b = viewGroup.getContext();
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_amenities_list_items, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
