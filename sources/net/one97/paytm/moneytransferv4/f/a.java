package net.one97.paytm.moneytransferv4.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.moneytransfer.c.ag;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.f.b;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.AnimationUtils;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55405a;

    /* renamed from: b  reason: collision with root package name */
    public String f55406b = "";

    /* renamed from: c  reason: collision with root package name */
    public ThemeData f55407c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55408d;

    /* renamed from: e  reason: collision with root package name */
    private b f55409e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ag f55410f;

    /* renamed from: g  reason: collision with root package name */
    private final b.C1023b f55411g;

    /* renamed from: h  reason: collision with root package name */
    private final WeakReference<Activity> f55412h;

    /* renamed from: i  reason: collision with root package name */
    private DealsEntity f55413i;

    public final void onClick(View view) {
    }

    public a(ag agVar, b.C1023b bVar, WeakReference<Activity> weakReference, DealsEntity dealsEntity) {
        ArrayList<CJRGridProduct> grid_layout;
        k.c(agVar, "viewBinding");
        this.f55410f = agVar;
        this.f55411g = bVar;
        this.f55412h = weakReference;
        this.f55413i = dealsEntity;
        LinearLayout linearLayout = this.f55410f.f53636a;
        k.a((Object) linearLayout, "viewBinding.accountLoadingLayout");
        this.f55408d = linearLayout.getContext();
        DealsEntity dealsEntity2 = this.f55413i;
        Activity activity = null;
        if ((dealsEntity2 != null ? dealsEntity2.getGrid_layout() : null) != null) {
            DealsEntity dealsEntity3 = this.f55413i;
            if (((dealsEntity3 == null || (grid_layout = dealsEntity3.getGrid_layout()) == null) ? 0 : grid_layout.size()) >= 3) {
                CJRGridProduct cJRGridProduct = new CJRGridProduct();
                cJRGridProduct.setName("Classic");
                cJRGridProduct.setSelected(true);
                cJRGridProduct.setHasBorder(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cJRGridProduct);
                DealsEntity dealsEntity4 = this.f55413i;
                ArrayList<CJRGridProduct> grid_layout2 = dealsEntity4 != null ? dealsEntity4.getGrid_layout() : null;
                if (grid_layout2 == null) {
                    k.a();
                }
                arrayList.addAll(grid_layout2);
                DealsEntity dealsEntity5 = new DealsEntity();
                dealsEntity5.setGrid_layout(arrayList);
                this.f55409e = new b(dealsEntity5.getGrid_layout(), this.f55411g);
                WeakReference<Activity> weakReference2 = this.f55412h;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(weakReference2 != null ? (Activity) weakReference2.get() : activity, 0, false);
                RecyclerView recyclerView = this.f55410f.J;
                k.a((Object) recyclerView, "viewBinding.themeRecycleView");
                recyclerView.setLayoutManager(linearLayoutManager);
                RecyclerView recyclerView2 = this.f55410f.J;
                k.a((Object) recyclerView2, "viewBinding.themeRecycleView");
                b bVar2 = this.f55409e;
                if (bVar2 == null) {
                    k.a("themesAdapter");
                }
                recyclerView2.setAdapter(bVar2);
                a();
            }
        }
    }

    public final void a(int i2) {
        this.f55410f.y.setHintTextColor(i2);
        this.f55410f.f53641f.setHintTextColor(i2);
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f55410f.f53641f;
        k.a((Object) customAmountTextInputEditText, "viewBinding.amountEt");
        if (String.valueOf(customAmountTextInputEditText.getText()).length() == 0) {
            this.f55410f.F.setTextColor(i2);
        }
    }

    public final void a(float f2) {
        View view = this.f55410f.z;
        k.a((Object) view, "messageUnderLine");
        view.setAlpha(f2);
    }

    public final void b(int i2) {
        WeakReference<Activity> weakReference = this.f55412h;
        if (weakReference != null && ((Activity) weakReference.get()) != null) {
            com.paytm.utility.b.a((Activity) this.f55412h.get(), i2);
        }
    }

    public final void c(int i2) {
        this.f55410f.E.setBackgroundColor(i2);
        this.f55410f.v.setBackgroundColor(i2);
        this.f55410f.p.setBackgroundColor(i2);
    }

    public final void d(int i2) {
        ag agVar = this.f55410f;
        agVar.O.setTextColor(i2);
        agVar.q.setTextColor(i2);
        agVar.M.setTextColor(i2);
        agVar.N.setTextColor(i2);
        agVar.f53641f.setTextColor(i2);
        agVar.y.setTextColor(i2);
        agVar.L.setTextColor(i2);
        agVar.f53640e.setTextColor(androidx.core.graphics.a.b(i2, (int) (((double) Color.alpha(i2)) * 0.6d)));
        f(i2);
        g(i2);
        h(i2);
    }

    private final void f(int i2) {
        TextView textView = this.f55410f.F;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f55410f.f53641f;
        k.a((Object) customAmountTextInputEditText, "viewBinding.amountEt");
        if (!TextUtils.isEmpty(customAmountTextInputEditText.getText())) {
            textView.setTextColor(i2);
        } else {
            textView.setTextColor(f.c("#506d85"));
        }
    }

    public final void a(String str) {
        LottieAnimationView lottieAnimationView = this.f55410f.I;
        if (!TextUtils.isEmpty(str)) {
            AnimationUtils.setJsonLottieAnimation(lottieAnimationView, str);
        } else {
            f.a((View) lottieAnimationView);
        }
    }

    private final void g(int i2) {
        m.a(this.f55410f.r, i2);
    }

    private final void h(int i2) {
        m.a(this.f55410f.m, i2);
    }

    public final void e(int i2) {
        ag agVar = this.f55410f;
        m.a(agVar.G, i2);
        agVar.P.setTextColor(i2);
        agVar.z.setBackgroundColor(i2);
    }

    /* renamed from: net.one97.paytm.moneytransferv4.f.a$a  reason: collision with other inner class name */
    static final class C1022a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55414a;

        C1022a(a aVar) {
            this.f55414a = aVar;
        }

        public final void run() {
            RecyclerView recyclerView = this.f55414a.f55410f.J;
            k.a((Object) recyclerView, "viewBinding.themeRecycleView");
            f.b((View) recyclerView);
        }
    }

    public final void a() {
        new Handler().postDelayed(new C1022a(this), 600);
    }

    public final void b() {
        RecyclerView recyclerView = this.f55410f.J;
        k.a((Object) recyclerView, "viewBinding.themeRecycleView");
        f.a((View) recyclerView);
    }
}
