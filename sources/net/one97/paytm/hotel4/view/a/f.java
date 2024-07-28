package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotels2.R;

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28682a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f28683b;

    public final int getItemPosition(Object obj) {
        k.c(obj, "object");
        return -2;
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final Parcelable saveState() {
        return null;
    }

    public f(Context context, List<String> list) {
        this.f28682a = context;
        this.f28683b = list;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f28682a).inflate(R.layout.h4_gallery_selected_item, viewGroup, false);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.image_list_gallery);
            List<String> list = this.f28683b;
            String str = list != null ? list.get(i2) : null;
            a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
            a.C0498a.b(imageView, str, 0);
            ((ViewPager) viewGroup).addView(viewGroup2);
            return viewGroup2;
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final int getCount() {
        List<String> list = this.f28683b;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            k.a();
        }
        return list.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        k.c(view, "view");
        k.c(obj, "object");
        return k.a((Object) view, obj);
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        ((ViewPager) viewGroup).removeView((View) obj);
    }
}
