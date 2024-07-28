package net.one97.travelpass.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.one97.travelpass.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.model.PassData;
import net.one97.travelpass.ui.c.j;

public final class a extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    c f30033a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<j> f30034b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30035c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f30036d;

    public a(Context context, j jVar, c cVar) {
        k.c(cVar, "itemClickListener");
        this.f30035c = context;
        Integer num = null;
        this.f30034b = jVar != null ? jVar.a() : null;
        ArrayList<j> arrayList = this.f30034b;
        this.f30036d = arrayList != null ? Integer.valueOf(arrayList.size()) : num;
        this.f30033a = cVar;
    }

    public final int getCount() {
        Integer num = this.f30036d;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        k.c(view, "p0");
        k.c(obj, "p1");
        return k.a((Object) view, obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f30035c).inflate(R.layout.vh_travel_images_item, viewGroup, false);
        Integer num = this.f30036d;
        if (num == null) {
            k.a();
        }
        int intValue = i2 % num.intValue();
        View findViewById = inflate.findViewById(R.id.image_item);
        if (findViewById != null) {
            ImageView imageView = (ImageView) findViewById;
            x.e eVar = new x.e();
            ArrayList<j> arrayList = this.f30034b;
            eVar.element = arrayList != null ? (j) arrayList.get(intValue) : null;
            j jVar = (j) eVar.element;
            IJRPaytmDataModel b2 = jVar != null ? jVar.b() : null;
            if (b2 != null) {
                PassData passData = (PassData) b2;
                if (!(passData == null || this.f30035c == null)) {
                    String imageUrl = passData.getImageUrl();
                    k.a((Object) imageUrl, "passData.imageUrl");
                    b.a aVar = b.f43744a;
                    Context context = this.f30035c;
                    if (context == null) {
                        k.a();
                    }
                    b.a.C0750a a2 = b.a.a(context);
                    a2.f43753a = imageUrl;
                    a2.m = true;
                    Context context2 = this.f30035c;
                    if (context2 == null) {
                        k.a();
                    }
                    Drawable a3 = androidx.core.content.b.a(context2, R.drawable.travelpass_placeholder_default);
                    if (a3 == null) {
                        k.a();
                    }
                    k.a((Object) a3, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a b3 = a2.b(a3);
                    Context context3 = this.f30035c;
                    if (context3 == null) {
                        k.a();
                    }
                    Drawable a4 = androidx.core.content.b.a(context3, R.drawable.travelpass_placeholder_default);
                    if (a4 == null) {
                        k.a();
                    }
                    k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                    b.a.C0750a.a(b3.a((Object) a4), imageView, (com.paytm.utility.b.b.b) null, 2);
                }
                inflate.setOnClickListener(new C0509a(this, eVar, i2));
                viewGroup.addView(inflate);
                k.a((Object) inflate, "view");
                return inflate;
            }
            throw new u("null cannot be cast to non-null type net.one97.travelpass.model.PassData");
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    /* renamed from: net.one97.travelpass.a.a$a  reason: collision with other inner class name */
    static final class C0509a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f30038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30039c;

        C0509a(a aVar, x.e eVar, int i2) {
            this.f30037a = aVar;
            this.f30038b = eVar;
            this.f30039c = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f30037a.f30033a;
            if (cVar != null) {
                c.a.a(cVar, (j) this.f30038b.element, Integer.valueOf(this.f30039c), (Integer) null, 4);
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        View view = (View) obj;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        view.setOnClickListener((View.OnClickListener) null);
        view.removeCallbacks((Runnable) null);
        viewGroup.removeView(view);
    }
}
