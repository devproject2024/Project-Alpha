package net.one97.paytm.moneytransfer.utils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.view.a.f;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.util.AnimationUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54179a;

    /* renamed from: b  reason: collision with root package name */
    public String f54180b;

    /* renamed from: c  reason: collision with root package name */
    public ThemeData f54181c;

    /* renamed from: d  reason: collision with root package name */
    public final View f54182d;

    /* renamed from: e  reason: collision with root package name */
    private final long f54183e = 200;

    /* renamed from: f  reason: collision with root package name */
    private final String f54184f = "rotation";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54185g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f54186h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f54187i;
    private LottieAnimationView j;
    private boolean k;
    private final f.b l;
    private final WeakReference<Activity> m;
    private DealsEntity n;

    public n(View view, f.b bVar, WeakReference<Activity> weakReference, DealsEntity dealsEntity) {
        DealsEntity dealsEntity2;
        ArrayList<CJRGridProduct> grid_layout;
        this.f54182d = view;
        this.l = bVar;
        this.m = weakReference;
        this.n = dealsEntity;
        View view2 = this.f54182d;
        Activity activity = null;
        this.f54185g = view2 != null ? (ImageView) view2.findViewById(R.id.thumbnail5) : null;
        View view3 = this.f54182d;
        this.f54186h = view3 != null ? (RecyclerView) view3.findViewById(R.id.themeRecycleView) : null;
        View view4 = this.f54182d;
        this.f54187i = view4 != null ? (LinearLayout) view4.findViewById(R.id.condensed_p2p_themes) : null;
        View view5 = this.f54182d;
        this.j = view5 != null ? (LottieAnimationView) view5.findViewById(R.id.theme_animation) : null;
        this.f54180b = "";
        LinearLayout linearLayout = this.f54187i;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DealsEntity dealsEntity3 = this.n;
        if ((dealsEntity3 != null ? dealsEntity3.getGrid_layout() : null) != null) {
            DealsEntity dealsEntity4 = this.n;
            if (((dealsEntity4 == null || (grid_layout = dealsEntity4.getGrid_layout()) == null) ? 0 : grid_layout.size()) >= 3) {
                View view6 = this.f54182d;
                Context context = view6 != null ? view6.getContext() : null;
                if (!(context == null || (dealsEntity2 = this.n) == null)) {
                    w a2 = w.a();
                    CJRGridProduct cJRGridProduct = dealsEntity2.getGrid_layout().get(0);
                    aa a3 = a2.a(cJRGridProduct != null ? cJRGridProduct.getImageUrl() : null);
                    Drawable a4 = androidx.core.content.b.a(context, R.drawable.p2p_circle_placeholder);
                    if (a4 == null) {
                        k.a();
                    }
                    aa a5 = a3.a(a4);
                    View view7 = this.f54182d;
                    ImageView imageView = view7 != null ? (ImageView) view7.findViewById(R.id.thumbnail2) : null;
                    if (imageView != null) {
                        a5.a(imageView);
                        w a6 = w.a();
                        CJRGridProduct cJRGridProduct2 = dealsEntity2.getGrid_layout().get(1);
                        aa a7 = a6.a(cJRGridProduct2 != null ? cJRGridProduct2.getImageUrl() : null);
                        Drawable a8 = androidx.core.content.b.a(context, R.drawable.p2p_circle_placeholder);
                        if (a8 == null) {
                            k.a();
                        }
                        aa a9 = a7.a(a8);
                        View view8 = this.f54182d;
                        ImageView imageView2 = view8 != null ? (ImageView) view8.findViewById(R.id.thumbnail3) : null;
                        if (imageView2 != null) {
                            a9.a(imageView2);
                            w a10 = w.a();
                            CJRGridProduct cJRGridProduct3 = dealsEntity2.getGrid_layout().get(2);
                            aa a11 = a10.a(cJRGridProduct3 != null ? cJRGridProduct3.getImageUrl() : null);
                            Drawable a12 = androidx.core.content.b.a(context, R.drawable.p2p_circle_placeholder);
                            if (a12 == null) {
                                k.a();
                            }
                            aa a13 = a11.a(a12);
                            View view9 = this.f54182d;
                            ImageView imageView3 = view9 != null ? (ImageView) view9.findViewById(R.id.thumbnail4) : null;
                            if (imageView3 != null) {
                                a13.a(imageView3);
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.ImageView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                }
                CJRGridProduct cJRGridProduct4 = new CJRGridProduct();
                cJRGridProduct4.setName("Classic");
                cJRGridProduct4.setSelected(true);
                cJRGridProduct4.setHasBorder(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cJRGridProduct4);
                DealsEntity dealsEntity5 = this.n;
                ArrayList<CJRGridProduct> grid_layout2 = dealsEntity5 != null ? dealsEntity5.getGrid_layout() : null;
                if (grid_layout2 == null) {
                    k.a();
                }
                arrayList.addAll(grid_layout2);
                DealsEntity dealsEntity6 = new DealsEntity();
                dealsEntity6.setGrid_layout(arrayList);
                f fVar = new f(dealsEntity6.getGrid_layout(), this.l);
                WeakReference<Activity> weakReference2 = this.m;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(weakReference2 != null ? (Activity) weakReference2.get() : activity, 0, false);
                RecyclerView recyclerView = this.f54186h;
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
                RecyclerView recyclerView2 = this.f54186h;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(fVar);
                }
                LinearLayout linearLayout2 = this.f54187i;
                if (linearLayout2 != null) {
                    linearLayout2.setOnClickListener(this);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r0v18, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r0v22, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00fe
            int r5 = r5.getId()
            int r0 = net.one97.paytm.moneytransfer.R.id.condensed_p2p_themes
            if (r5 != r0) goto L_0x00fe
            boolean r5 = r4.k
            r0 = 0
            r1 = 0
            if (r5 != 0) goto L_0x00d2
            androidx.recyclerview.widget.RecyclerView r5 = r4.f54186h
            if (r5 == 0) goto L_0x0017
            r5.setVisibility(r1)
        L_0x0017:
            android.view.View r5 = r4.f54182d
            if (r5 == 0) goto L_0x0020
            android.content.Context r5 = r5.getContext()
            goto L_0x0021
        L_0x0020:
            r5 = r0
        L_0x0021:
            int r2 = net.one97.paytm.moneytransfer.R.anim.zoom_in
            android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r5, r2)
            net.one97.paytm.moneytransfer.utils.n$b r2 = new net.one97.paytm.moneytransfer.utils.n$b
            r2.<init>(r4)
            android.view.animation.Animation$AnimationListener r2 = (android.view.animation.Animation.AnimationListener) r2
            r5.setAnimationListener(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r4.f54186h
            if (r2 == 0) goto L_0x0038
            r2.startAnimation(r5)
        L_0x0038:
            r5 = 1
            r4.k = r5
            java.lang.String r2 = r4.f54180b
            java.lang.String r3 = ""
            boolean r5 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r5)
            r2 = 4
            java.lang.String r3 = "null cannot be cast to non-null type android.widget.ImageView"
            if (r5 == 0) goto L_0x0061
            android.view.View r5 = r4.f54182d
            if (r5 == 0) goto L_0x0055
            int r0 = net.one97.paytm.moneytransfer.R.id.motif_iv_bg
            android.view.View r5 = r5.findViewById(r0)
            r0 = r5
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0055:
            if (r0 == 0) goto L_0x005b
            r0.setVisibility(r1)
            goto L_0x0073
        L_0x005b:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x0061:
            android.view.View r5 = r4.f54182d
            if (r5 == 0) goto L_0x006e
            int r0 = net.one97.paytm.moneytransfer.R.id.motif_iv_bg
            android.view.View r5 = r5.findViewById(r0)
            r0 = r5
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x006e:
            if (r0 == 0) goto L_0x00cc
            r0.setVisibility(r2)
        L_0x0073:
            android.view.View r5 = r4.f54182d
            if (r5 == 0) goto L_0x00cb
            androidx.recyclerview.widget.RecyclerView r0 = r4.f54186h
            if (r0 == 0) goto L_0x007e
            r0.setVisibility(r1)
        L_0x007e:
            int r0 = net.one97.paytm.moneytransfer.R.id.thumbnail1
            android.view.View r0 = r5.findViewById(r0)
            if (r0 == 0) goto L_0x00c5
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.thumbnail2
            android.view.View r0 = r5.findViewById(r0)
            if (r0 == 0) goto L_0x00bf
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.thumbnail3
            android.view.View r0 = r5.findViewById(r0)
            if (r0 == 0) goto L_0x00b9
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.thumbnail4
            android.view.View r5 = r5.findViewById(r0)
            if (r5 == 0) goto L_0x00b3
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setVisibility(r2)
            return
        L_0x00b3:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x00b9:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x00bf:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x00c5:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x00cb:
            return
        L_0x00cc:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x00d2:
            androidx.recyclerview.widget.RecyclerView r5 = r4.f54186h
            if (r5 == 0) goto L_0x00fe
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x00fe
            android.view.View r5 = r4.f54182d
            if (r5 == 0) goto L_0x00e4
            android.content.Context r0 = r5.getContext()
        L_0x00e4:
            int r5 = net.one97.paytm.moneytransfer.R.anim.zoom_out_p2p
            android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r0, r5)
            net.one97.paytm.moneytransfer.utils.n$a r0 = new net.one97.paytm.moneytransfer.utils.n$a
            r0.<init>(r4)
            android.view.animation.Animation$AnimationListener r0 = (android.view.animation.Animation.AnimationListener) r0
            r5.setAnimationListener(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r4.f54186h
            if (r0 == 0) goto L_0x00fb
            r0.startAnimation(r5)
        L_0x00fb:
            r4.k = r1
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.utils.n.onClick(android.view.View):void");
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54189a;

        public final void onAnimationEnd(Animation animation) {
            k.c(animation, "animation");
        }

        public final void onAnimationRepeat(Animation animation) {
            k.c(animation, "animation");
        }

        b(n nVar) {
            this.f54189a = nVar;
        }

        public final void onAnimationStart(Animation animation) {
            k.c(animation, "animation");
            n nVar = this.f54189a;
            n.a(nVar, nVar.f54185g);
        }
    }

    public static final class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f54188a;

        public final void onAnimationRepeat(Animation animation) {
            k.c(animation, "animation");
        }

        a(n nVar) {
            this.f54188a = nVar;
        }

        public final void onAnimationStart(Animation animation) {
            k.c(animation, "animation");
            n nVar = this.f54188a;
            n.b(nVar, nVar.f54185g);
        }

        /* JADX WARNING: type inference failed for: r5v21, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onAnimationEnd(android.view.animation.Animation r5) {
            /*
                r4 = this;
                java.lang.String r0 = "animation"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                java.lang.String r5 = r5.f54180b
                java.lang.String r0 = ""
                r1 = 1
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r0, (boolean) r1)
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.ImageView"
                r1 = 0
                r2 = 0
                if (r5 == 0) goto L_0x0036
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                android.view.View r5 = r5.f54182d
                if (r5 == 0) goto L_0x0029
                int r3 = net.one97.paytm.moneytransfer.R.id.motif_iv_bg
                android.view.View r5 = r5.findViewById(r3)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                goto L_0x002a
            L_0x0029:
                r5 = r2
            L_0x002a:
                if (r5 == 0) goto L_0x0030
                r5.setVisibility(r1)
                goto L_0x0036
            L_0x0030:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r0)
                throw r5
            L_0x0036:
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                androidx.recyclerview.widget.RecyclerView r5 = r5.f54186h
                if (r5 == 0) goto L_0x0043
                r3 = 8
                r5.setVisibility(r3)
            L_0x0043:
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                android.view.View r5 = r5.f54182d
                if (r5 == 0) goto L_0x0054
                int r3 = net.one97.paytm.moneytransfer.R.id.thumbnail1
                android.view.View r5 = r5.findViewById(r3)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                goto L_0x0055
            L_0x0054:
                r5 = r2
            L_0x0055:
                if (r5 == 0) goto L_0x00b1
                r5.setVisibility(r1)
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                android.view.View r5 = r5.f54182d
                if (r5 == 0) goto L_0x006b
                int r3 = net.one97.paytm.moneytransfer.R.id.thumbnail2
                android.view.View r5 = r5.findViewById(r3)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                goto L_0x006c
            L_0x006b:
                r5 = r2
            L_0x006c:
                if (r5 == 0) goto L_0x00ab
                r5.setVisibility(r1)
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                android.view.View r5 = r5.f54182d
                if (r5 == 0) goto L_0x0082
                int r3 = net.one97.paytm.moneytransfer.R.id.thumbnail3
                android.view.View r5 = r5.findViewById(r3)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                goto L_0x0083
            L_0x0082:
                r5 = r2
            L_0x0083:
                if (r5 == 0) goto L_0x00a5
                r5.setVisibility(r1)
                net.one97.paytm.moneytransfer.utils.n r5 = r4.f54188a
                android.view.View r5 = r5.f54182d
                if (r5 == 0) goto L_0x0099
                int r2 = net.one97.paytm.moneytransfer.R.id.thumbnail4
                android.view.View r5 = r5.findViewById(r2)
                r2 = r5
                android.widget.ImageView r2 = (android.widget.ImageView) r2
            L_0x0099:
                if (r2 == 0) goto L_0x009f
                r2.setVisibility(r1)
                return
            L_0x009f:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r0)
                throw r5
            L_0x00a5:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r0)
                throw r5
            L_0x00ab:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r0)
                throw r5
            L_0x00b1:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.utils.n.a.onAnimationEnd(android.view.animation.Animation):void");
        }
    }

    public final void a(int i2) {
        WeakReference<Activity> weakReference = this.m;
        if (weakReference != null && ((Activity) weakReference.get()) != null) {
            WeakReference<Activity> weakReference2 = this.m;
            com.paytm.utility.b.a(weakReference2 != null ? (Activity) weakReference2.get() : null, i2);
        }
    }

    public final void b(int i2) {
        View view = this.f54182d;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public final void c(int i2) {
        View findViewById;
        View view = this.f54182d;
        if (view != null && (findViewById = view.findViewById(R.id.toolbar_layout)) != null) {
            findViewById.setBackgroundColor(i2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.f54182d
            r1 = 0
            if (r0 == 0) goto L_0x00af
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_receiver_name
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.headerBankLogoName
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_receiver_acc_number
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.tv_receiver_ifsc
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.amount_et
            android.view.View r2 = r0.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.edit_p2b_comment
            android.view.View r2 = r0.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.transfered_from
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setTextColor(r5)
            int r2 = net.one97.paytm.moneytransfer.R.id.amount_error_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setTextColor(r5)
            android.view.View r0 = r4.f54182d
            if (r0 == 0) goto L_0x006a
            int r2 = net.one97.paytm.moneytransfer.R.id.amount_et
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x006b
        L_0x006a:
            r0 = r1
        L_0x006b:
            if (r0 == 0) goto L_0x0072
            java.lang.CharSequence r2 = r0.getText()
            goto L_0x0073
        L_0x0072:
            r2 = r1
        L_0x0073:
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x008b
            android.view.View r0 = r4.f54182d
            if (r0 == 0) goto L_0x00af
            int r2 = net.one97.paytm.moneytransfer.R.id.rupee_prefix_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00af
            r0.setTextColor(r5)
            goto L_0x00af
        L_0x008b:
            android.view.View r2 = r4.f54182d
            if (r2 == 0) goto L_0x00af
            int r3 = net.one97.paytm.moneytransfer.R.id.rupee_prefix_tv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x00a0
            android.content.Context r0 = r0.getContext()
            goto L_0x00a1
        L_0x00a0:
            r0 = r1
        L_0x00a1:
            if (r0 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            int r3 = net.one97.paytm.moneytransfer.R.color.edittext_hint_color
            int r0 = androidx.core.content.b.c(r0, r3)
            r2.setTextColor(r0)
        L_0x00af:
            android.view.View r0 = r4.f54182d
            if (r0 == 0) goto L_0x00bc
            int r2 = net.one97.paytm.moneytransfer.R.id.iv_back_button1
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x00bd
        L_0x00bc:
            r0 = r1
        L_0x00bd:
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r0, (int) r5)
            android.view.View r0 = r4.f54182d
            if (r0 == 0) goto L_0x00cd
            int r1 = net.one97.paytm.moneytransfer.R.id.bankarrow
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x00cd:
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r1, (int) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.utils.n.d(int):void");
    }

    public final void e(int i2) {
        View view;
        EditText editText;
        if (Build.VERSION.SDK_INT >= 21 && (view = this.f54182d) != null && (editText = (EditText) view.findViewById(R.id.edit_p2b_comment)) != null) {
            editText.setBackgroundTintList(ColorStateList.valueOf(i2));
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            AnimationUtils.setJsonLottieAnimation(this.j, str);
            return;
        }
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
    }

    public final void f(int i2) {
        View findViewById;
        TextView textView;
        TextView textView2;
        View findViewById2;
        View view = this.f54182d;
        m.a(view != null ? (ImageView) view.findViewById(R.id.selectedBankDownArrowTV) : null, i2);
        View view2 = this.f54182d;
        if (!(view2 == null || (findViewById2 = view2.findViewById(R.id.v_uni_et_sep_2)) == null)) {
            findViewById2.setBackgroundColor(i2);
        }
        View view3 = this.f54182d;
        if (!(view3 == null || (textView2 = (TextView) view3.findViewById(R.id.txt_add_desc)) == null)) {
            textView2.setTextColor(i2);
        }
        View view4 = this.f54182d;
        if (!(view4 == null || (textView = (TextView) view4.findViewById(R.id.tv_selected_source_label)) == null)) {
            textView.setTextColor(i2);
        }
        View view5 = this.f54182d;
        if (view5 != null && (findViewById = view5.findViewById(R.id.v_uni_et_sep_1)) != null) {
            findViewById.setBackgroundColor(i2);
        }
    }

    public final void a() {
        Context context;
        View view = this.f54182d;
        if (view != null && (context = view.getContext()) != null) {
            a(androidx.core.content.b.c(context, R.color.color_ffffff));
        }
    }

    public static final /* synthetic */ void a(n nVar, View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, nVar.f54184f, new float[]{0.0f, -180.0f});
        k.a((Object) ofFloat, CLConstants.MODE_ROTATE);
        ofFloat.setDuration(nVar.f54183e);
        ofFloat.start();
    }

    public static final /* synthetic */ void b(n nVar, View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, nVar.f54184f, new float[]{-180.0f, 0.0f});
        k.a((Object) ofFloat, CLConstants.MODE_ROTATE);
        ofFloat.setDuration(nVar.f54183e);
        ofFloat.start();
    }
}
