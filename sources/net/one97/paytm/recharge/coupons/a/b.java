package net.one97.paytm.recharge.coupons.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.a;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.recharge.legacy.catalog.b.f;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private Context f62181a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f62182b = new ArrayList<>();

    public b(Context context, ArrayList<String> arrayList) {
        this.f62181a = context;
        this.f62182b = arrayList;
    }

    public final int getCount() {
        ArrayList<String> arrayList = this.f62182b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        ImageView imageView = new ImageView(this.f62181a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
        String str = this.f62182b.get(i2);
        if (f.a()) {
            str = str + ".webp";
        }
        w.a().a(str).a(imageView, (e) null);
        "mImageUrl :: ".concat(String.valueOf(str));
        com.paytm.utility.b.j();
        viewGroup.addView(imageView);
        return imageView;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
