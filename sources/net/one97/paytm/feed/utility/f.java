package net.one97.paytm.feed.utility;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class f extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Context f35391a;

    /* renamed from: b  reason: collision with root package name */
    private float f35392b;

    /* renamed from: c  reason: collision with root package name */
    private float f35393c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f35394d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f35395e = 0.0f;

    public f(Context context, float f2) {
        k.c(context, "context");
        this.f35392b = f2;
        this.f35391a = context;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        if (this.f35392b != 0.0f) {
            r rVar = r.f35432a;
            rect.bottom = (int) r.a(this.f35392b, this.f35391a);
        }
        if (this.f35395e != 0.0f) {
            r rVar2 = r.f35432a;
            rect.top = (int) r.a(this.f35395e, this.f35391a);
        }
        if (this.f35393c != 0.0f) {
            r rVar3 = r.f35432a;
            rect.left = (int) r.a(this.f35393c, this.f35391a);
        }
        if (this.f35394d != 0.0f) {
            r rVar4 = r.f35432a;
            rect.right = (int) r.a(this.f35394d, this.f35391a);
        }
    }
}
