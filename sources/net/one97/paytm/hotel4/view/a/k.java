package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fo;

public final class k extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28703b;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        kotlin.g.b.k.c(viewDataBinding, "binding");
        kotlin.g.b.k.c(str, "item");
        if (viewDataBinding instanceof fo) {
            fo foVar = (fo) viewDataBinding;
            foVar.a(f.a(str));
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
            foVar.b(str);
        }
    }

    public k() {
        super(new h.c<String>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                kotlin.g.b.k.c(str, "oldItem");
                kotlin.g.b.k.c(str2, "newItem");
                return kotlin.g.b.k.a((Object) str, (Object) str2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                kotlin.g.b.k.c(str, "oldItem");
                kotlin.g.b.k.c(str2, "newItem");
                return kotlin.g.b.k.a((Object) str, (Object) str2);
            }
        });
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        kotlin.g.b.k.c(viewGroup, "parent");
        this.f28703b = viewGroup.getContext();
        ViewDataBinding a2 = androidx.databinding.f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_image_text_bottomsheet_items, viewGroup, false);
        kotlin.g.b.k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
