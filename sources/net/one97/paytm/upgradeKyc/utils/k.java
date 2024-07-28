package net.one97.paytm.upgradeKyc.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import kotlin.u;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66337a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, NestedScrollView nestedScrollView, View view) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(nestedScrollView, "sv");
            kotlin.g.b.k.c(view, "view");
            view.post(new C1330a(context, view, nestedScrollView));
        }

        /* renamed from: net.one97.paytm.upgradeKyc.utils.k$a$a  reason: collision with other inner class name */
        static final class C1330a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f66338a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f66339b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ NestedScrollView f66340c;

            C1330a(Context context, View view, NestedScrollView nestedScrollView) {
                this.f66338a = context;
                this.f66339b = view;
                this.f66340c = nestedScrollView;
            }

            public final void run() {
                Resources resources = this.f66338a.getResources();
                kotlin.g.b.k.a((Object) resources, "context.resources");
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                kotlin.g.b.k.a((Object) displayMetrics, "context.resources\n      …          .displayMetrics");
                int i2 = displayMetrics.heightPixels;
                int height = this.f66339b.getHeight();
                View view = this.f66339b;
                if (view != null) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    kotlin.g.b.k.a((Object) childAt, "(view as ViewGroup).getChildAt(0)");
                    int height2 = childAt.getHeight();
                    if (height2 != 0) {
                        this.f66340c.b(((height - (height2 * (i2 / height2))) / 2) * -1);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }
}
