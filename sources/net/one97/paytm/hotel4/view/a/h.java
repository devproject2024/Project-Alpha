package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import kotlin.g.b.k;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fg;

public final class h extends c<String> {

    /* renamed from: b  reason: collision with root package name */
    private Context f28686b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28687c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28688d;

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        String str = (String) obj;
        k.c(viewDataBinding, "binding");
        k.c(str, "item");
        if (viewDataBinding instanceof fg) {
            if (this.f28688d) {
                TextView textView = ((fg) viewDataBinding).f29707b;
                k.a((Object) textView, "binding.tvText");
                textView.setText(Html.fromHtml(str));
            } else {
                TextView textView2 = ((fg) viewDataBinding).f29707b;
                k.a((Object) textView2, "binding.tvText");
                textView2.setText(str);
            }
            if (this.f28687c) {
                ImageView imageView = ((fg) viewDataBinding).f29706a;
                k.a((Object) imageView, "binding.ivBullet");
                imageView.setVisibility(0);
                return;
            }
            ImageView imageView2 = ((fg) viewDataBinding).f29706a;
            k.a((Object) imageView2, "binding.ivBullet");
            imageView2.setVisibility(8);
        }
    }

    public h(boolean z, boolean z2) {
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
        this.f28687c = z;
        this.f28688d = z2;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28686b = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hotel4_bullet_list, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }
}
