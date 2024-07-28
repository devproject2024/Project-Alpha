package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;

public abstract class CJRBaseHeaderListLayoutV8 extends ShimmerFrameLayout {

    /* renamed from: d  reason: collision with root package name */
    public View f61845d;

    /* renamed from: e  reason: collision with root package name */
    private a f61846e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f61847f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f61848a;
    }

    public View b(int i2) {
        if (this.f61847f == null) {
            this.f61847f = new HashMap();
        }
        View view = (View) this.f61847f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61847f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getShimmerLayoutId() {
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBaseHeaderListLayoutV8(Context context, a aVar) {
        super(context);
        k.c(aVar, "baseOption");
        this.f61846e = aVar;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), this, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        linearLayoutManager.setStackFromEnd(true);
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.h a2 = a(this.f61846e);
        if (a2 != null) {
            ((RecyclerView) b(R.id.recycler_view)).addItemDecoration(a2);
        }
        RecyclerView recyclerView2 = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView2, "recycler_view");
        recyclerView2.setNestedScrollingEnabled(false);
        try {
            FrameLayout frameLayout = (FrameLayout) b(R.id.item_recycler_shimmer);
            if (frameLayout != null) {
                frameLayout.addView(LayoutInflater.from(getContext()).inflate(getShimmerLayoutId(), (ViewGroup) null));
            }
            FrameLayout frameLayout2 = (FrameLayout) b(R.id.item_recycler_shimmer);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            a();
        } catch (Resources.NotFoundException | Exception unused) {
        }
    }

    public final View getView() {
        View view = this.f61845d;
        if (view == null) {
            k.a("view");
        }
        return view;
    }

    public final void setView(View view) {
        k.c(view, "<set-?>");
        this.f61845d = view;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.v8_content_promos_view;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.h a(a aVar) {
        k.c(aVar, "mBaseOption");
        i iVar = new i(getContext(), 1);
        Drawable a2 = androidx.core.content.b.a(getContext(), R.drawable.divider);
        if (a2 != null) {
            iVar.a(a2);
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) b(R.id.txt_title);
            k.a((Object) textView, "txt_title");
            textView.setText(charSequence);
            TextView textView2 = (TextView) b(R.id.txt_title);
            k.a((Object) textView2, "txt_title");
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = (TextView) b(R.id.txt_title);
        k.a((Object) textView3, "txt_title");
        textView3.setVisibility(8);
    }

    public void setTitleBackgroundTransparent() {
        TextView textView = (TextView) b(R.id.txt_title);
        if (textView != null) {
            textView.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.white));
        }
    }

    public final void a(int i2) {
        TextView textView = (TextView) b(R.id.txt_title);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.b.c(getContext(), i2));
        }
    }

    public final void setTitleBackgroundColor(int i2) {
        TextView textView = (TextView) b(R.id.txt_title);
        if (textView != null) {
            textView.setBackgroundColor(androidx.core.content.b.c(getContext(), i2));
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView, "txt_viewall");
            textView.setText(charSequence);
            TextView textView2 = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView2, "txt_viewall");
            textView2.setActivated(true);
            TextView textView3 = (TextView) b(R.id.txt_title);
            k.a((Object) textView3, "txt_title");
            textView3.setVisibility(0);
            TextView textView4 = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView4, "txt_viewall");
            textView4.setVisibility(0);
            ((TextView) b(R.id.txt_viewall)).setOnClickListener(new b(this));
            return;
        }
        TextView textView5 = (TextView) b(R.id.txt_viewall);
        k.a((Object) textView5, "txt_viewall");
        textView5.setVisibility(8);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseHeaderListLayoutV8 f61849a;

        b(CJRBaseHeaderListLayoutV8 cJRBaseHeaderListLayoutV8) {
            this.f61849a = cJRBaseHeaderListLayoutV8;
        }

        public final void onClick(View view) {
            this.f61849a.d();
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        TextView textView = (TextView) b(R.id.txt_viewall);
        k.a((Object) textView, "txt_viewall");
        if (textView.isActivated()) {
            TextView textView2 = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView2, "txt_viewall");
            textView2.setActivated(false);
            ((TextView) b(R.id.txt_viewall)).setText(R.string.action_view_less);
            return true;
        }
        ((TextView) b(R.id.txt_viewall)).setText(R.string.action_view_all);
        TextView textView3 = (TextView) b(R.id.txt_viewall);
        k.a((Object) textView3, "txt_viewall");
        textView3.setActivated(true);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|(1:3)|4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r2 = this;
            int r0 = net.one97.paytm.recharge.R.id.item_recycler_shimmer     // Catch:{ IllegalStateException -> 0x000f }
            android.view.View r0 = r2.b((int) r0)     // Catch:{ IllegalStateException -> 0x000f }
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0     // Catch:{ IllegalStateException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            r1 = 8
            r0.setVisibility(r1)     // Catch:{ IllegalStateException -> 0x000f }
        L_0x000f:
            super.b()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CJRBaseHeaderListLayoutV8.b():void");
    }
}
