package net.one97.paytm.recharge.coupons.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class CJRDealSelectWidgetV8 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f62295a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRGridProduct> f62296b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRGridProduct> f62297c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView.a<?> f62298d;

    /* renamed from: e  reason: collision with root package name */
    public int f62299e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62300f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62301g;

    /* renamed from: h  reason: collision with root package name */
    public int f62302h;

    /* renamed from: i  reason: collision with root package name */
    public int f62303i;
    public int j;
    /* access modifiers changed from: private */
    public HashMap<String, Bitmap> k = new HashMap<>();
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.coupons.e.b q;
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRDealSelectWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(attributeSet, "attrs");
        this.l = ba.a(25.0f, context);
        this.m = ba.a(25.0f, context);
        this.n = ba.a(12.5f, context);
        this.o = ba.a(75.0f, context);
        this.p = ba.a(45.0f, context);
        this.f62299e = 3;
        LayoutInflater.from(context).inflate(R.layout.v8_widget_deal_select, this, true);
        this.f62296b = new ArrayList<>();
        this.f62297c = new ArrayList<>();
        this.f62298d = new a(this, context, this.f62296b);
        RecyclerView recyclerView = (RecyclerView) a(R.id.expandedRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(this.f62298d);
        recyclerView.setItemAnimator(new g());
        if (context != null) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity != null) {
                this.q = (net.one97.paytm.recharge.coupons.e.b) am.a(fragmentActivity).a(net.one97.paytm.recharge.coupons.e.b.class);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final int getItemSize() {
        return this.f62295a;
    }

    public final void setItemSize(int i2) {
        this.f62295a = i2;
    }

    public final ArrayList<CJRGridProduct> getMasterDataListDealsModel() {
        return this.f62297c;
    }

    public final void setMasterDataListDealsModel(ArrayList<CJRGridProduct> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f62297c = arrayList;
    }

    public final int getAmountTotal() {
        return this.f62302h;
    }

    public final void setAmountTotal(int i2) {
        this.f62302h = i2;
    }

    public final void a() {
        int i2 = this.o;
        int i3 = this.p;
        int i4 = this.f62295a;
        if (i4 > 3) {
            i4 = 3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3 * i4);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.expandedLL);
        k.a((Object) relativeLayout, "expandedLL");
        relativeLayout.setLayoutParams(layoutParams);
    }

    public final void b() {
        RecyclerView recyclerView = (RecyclerView) a(R.id.expandedRV);
        k.a((Object) recyclerView, "expandedRV");
        if (recyclerView.getVisibility() == 0) {
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.expandedRV);
            k.a((Object) recyclerView2, "expandedRV");
            recyclerView2.setVisibility(8);
        } else {
            RecyclerView recyclerView3 = (RecyclerView) a(R.id.expandedRV);
            k.a((Object) recyclerView3, "expandedRV");
            recyclerView3.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.expandedLL);
        k.a((Object) relativeLayout, "expandedLL");
        if (relativeLayout.getVisibility() == 8) {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.expandedLL);
            k.a((Object) relativeLayout2, "expandedLL");
            relativeLayout2.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.expandedLL);
        k.a((Object) relativeLayout3, "expandedLL");
        relativeLayout3.setVisibility(8);
    }

    public final CJRCircleImageViewV8 a(String str, int i2) {
        k.c(str, "url");
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        CJRCircleImageViewV8 cJRCircleImageViewV8 = new CJRCircleImageViewV8(context);
        cJRCircleImageViewV8.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.l, this.m);
        layoutParams.setMargins(this.n * i2, 0, 0, 0);
        cJRCircleImageViewV8.setLayoutParams(layoutParams);
        if (this.k.containsKey(str)) {
            cJRCircleImageViewV8.setImageBitmap(this.k.get(str));
        } else {
            try {
                w.a().a(str).a(R.color.color_909090).a((af) new b(this, str, cJRCircleImageViewV8));
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        return cJRCircleImageViewV8;
    }

    public static final class b implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRDealSelectWidgetV8 f62319a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f62320b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRCircleImageViewV8 f62321c;

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
            k.c(exc, "e");
        }

        public final void onPrepareLoad(Drawable drawable) {
        }

        b(CJRDealSelectWidgetV8 cJRDealSelectWidgetV8, String str, CJRCircleImageViewV8 cJRCircleImageViewV8) {
            this.f62319a = cJRDealSelectWidgetV8;
            this.f62320b = str;
            this.f62321c = cJRCircleImageViewV8;
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            HashMap i2 = this.f62319a.k;
            String str = this.f62320b;
            if (bitmap == null) {
                k.a();
            }
            i2.put(str, bitmap);
            this.f62321c.setImageBitmap(bitmap);
        }
    }

    public final class a extends RecyclerView.a<RecyclerView.v> {

        /* renamed from: a  reason: collision with root package name */
        final Context f62304a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<CJRGridProduct> f62305b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRDealSelectWidgetV8 f62306c;

        public a(CJRDealSelectWidgetV8 cJRDealSelectWidgetV8, Context context, ArrayList<CJRGridProduct> arrayList) {
            k.c(arrayList, "dealList");
            this.f62306c = cJRDealSelectWidgetV8;
            this.f62304a = context;
            this.f62305b = arrayList;
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f62304a).inflate(R.layout.v8_widget_item_deal_select, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(mCon…al_select, parent, false)");
            return new C1198a(this, inflate);
        }

        public final int getItemCount() {
            return this.f62305b.size();
        }

        public final long getItemId(int i2) {
            setHasStableIds(true);
            return super.getItemId(i2);
        }

        public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
            k.c(vVar, "holder");
            if ((vVar instanceof C1198a) && this.f62306c.getMasterDataListDealsModel() != null && !this.f62306c.getMasterDataListDealsModel().isEmpty()) {
                C1198a aVar = (C1198a) vVar;
                aVar.f62307a.removeAllViews();
                CJRGridProduct cJRGridProduct = this.f62306c.getMasterDataListDealsModel().get(i2);
                k.a((Object) cJRGridProduct, "masterDataListDealsModel.get(position)");
                CJRGridProduct cJRGridProduct2 = cJRGridProduct;
                if (this.f62306c.f62300f) {
                    CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = this.f62306c;
                    String imageUrl = cJRGridProduct2.getImageUrl();
                    k.a((Object) imageUrl, "item.imageUrl");
                    aVar.f62307a.addView(cJRDealSelectWidgetV8.a(imageUrl, 0));
                    aVar.f62308b.setAnimation("deal_delete.json");
                    aVar.f62308b.setVisibility(0);
                    aVar.f62308b.setTag(cJRGridProduct2);
                    aVar.f62308b.setProgress(0.0f);
                    TextView textView = aVar.f62311e;
                    String brand = cJRGridProduct2.getBrand();
                    k.a((Object) brand, "item.brand");
                    textView.setText(CJRDealSelectWidgetV8.a(brand));
                    aVar.f62310d.setText(cJRGridProduct2.getDiscountedPrice());
                    try {
                        String discountedPrice = cJRGridProduct2.getDiscountedPrice();
                        k.a((Object) discountedPrice, "item.discountedPrice");
                        int parseInt = Integer.parseInt(discountedPrice);
                        if (parseInt != 0) {
                            TextView textView2 = ((C1198a) vVar).f62310d;
                            StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
                            sb.append(parseInt);
                            textView2.setText(sb);
                            TextView textView3 = ((C1198a) vVar).f62310d;
                            Context context = this.f62306c.getContext();
                            if (context == null) {
                                k.a();
                            }
                            textView3.setTextColor(androidx.core.content.b.c(context, R.color.color_222222));
                        } else {
                            TextView textView4 = ((C1198a) vVar).f62310d;
                            Context context2 = this.f62306c.getContext();
                            k.a((Object) context2, "context");
                            textView4.setText(context2.getResources().getString(R.string.grid_free));
                            TextView textView5 = ((C1198a) vVar).f62310d;
                            Context context3 = this.f62306c.getContext();
                            if (context3 == null) {
                                k.a();
                            }
                            textView5.setTextColor(androidx.core.content.b.c(context3, R.color.color_21c17a));
                        }
                    } catch (Throwable th) {
                        CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                    }
                    aVar.f62310d.setPadding(0, 0, ba.a(50.0f, this.f62306c.getContext()), 0);
                    aVar.f62307a.setLayoutParams(new RelativeLayout.LayoutParams(ba.a(35.0f, this.f62306c.getContext()), -1));
                } else {
                    int size = this.f62306c.getMasterDataListDealsModel().size() - 1;
                    if (size >= 0) {
                        int i3 = 0;
                        while (true) {
                            CJRDealSelectWidgetV8 cJRDealSelectWidgetV82 = this.f62306c;
                            CJRGridProduct cJRGridProduct3 = cJRDealSelectWidgetV82.getMasterDataListDealsModel().get(i3);
                            k.a((Object) cJRGridProduct3, "masterDataListDealsModel.get(i)");
                            String imageUrl2 = cJRGridProduct3.getImageUrl();
                            k.a((Object) imageUrl2, "masterDataListDealsModel.get(i).imageUrl");
                            View a2 = cJRDealSelectWidgetV82.a(imageUrl2, i3);
                            aVar.f62307a.addView(a2);
                            if (i3 >= this.f62306c.f62299e) {
                                View childAt = aVar.f62307a.getChildAt(i3);
                                k.a((Object) childAt, "holder.icon.getChildAt(i)");
                                childAt.setVisibility(8);
                            }
                            if (i3 == this.f62306c.getMasterDataListDealsModel().size() - 1 && this.f62306c.f62301g) {
                                a2.setAnimation(AnimationUtils.loadAnimation(this.f62304a, R.anim.v8_widget_deal_selection_item_add));
                                this.f62306c.f62301g = false;
                            }
                            if (i3 == size) {
                                break;
                            }
                            i3++;
                        }
                    }
                    aVar.f62308b.setVisibility(4);
                    aVar.f62310d.setPadding(0, 0, ba.a(20.0f, this.f62306c.getContext()), 0);
                    aVar.f62311e.setText(this.f62306c.getDealSummaryText());
                    try {
                        if (this.f62306c.getAmountTotal() != 0) {
                            TextView textView6 = ((C1198a) vVar).f62310d;
                            StringBuilder sb2 = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
                            sb2.append(this.f62306c.getAmountTotal());
                            textView6.setText(sb2);
                            TextView textView7 = ((C1198a) vVar).f62310d;
                            Context context4 = this.f62306c.getContext();
                            if (context4 == null) {
                                k.a();
                            }
                            textView7.setTextColor(androidx.core.content.b.c(context4, R.color.color_222222));
                        } else {
                            TextView textView8 = ((C1198a) vVar).f62310d;
                            Context context5 = this.f62306c.getContext();
                            k.a((Object) context5, "context");
                            textView8.setText(context5.getResources().getString(R.string.grid_free));
                            TextView textView9 = ((C1198a) vVar).f62310d;
                            Context context6 = this.f62306c.getContext();
                            if (context6 == null) {
                                k.a();
                            }
                            textView9.setTextColor(androidx.core.content.b.c(context6, R.color.color_21c17a));
                        }
                    } catch (Throwable th2) {
                        CJRRechargeUtilities.INSTANCE.debugLogExceptions(th2);
                    }
                    if (this.f62306c.getMasterDataListDealsModel().size() == 1) {
                        aVar.f62307a.setLayoutParams(new RelativeLayout.LayoutParams(ba.a(35.0f, this.f62306c.getContext()), -1));
                    } else {
                        aVar.f62307a.setLayoutParams(new RelativeLayout.LayoutParams(ba.a(60.0f, this.f62306c.getContext()), -1));
                    }
                }
                aVar.f62308b.setOnClickListener(new d(this, vVar, cJRGridProduct2));
            }
        }

        static final class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f62315a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecyclerView.v f62316b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRGridProduct f62317c;

            d(a aVar, RecyclerView.v vVar, CJRGridProduct cJRGridProduct) {
                this.f62315a = aVar;
                this.f62316b = vVar;
                this.f62317c = cJRGridProduct;
            }

            public final void onClick(View view) {
                if (((C1198a) this.f62316b).f62308b.isEnabled()) {
                    a aVar = this.f62315a;
                    CJRGridProduct cJRGridProduct = this.f62317c;
                    LottieAnimationView lottieAnimationView = ((C1198a) this.f62316b).f62308b;
                    View view2 = ((C1198a) this.f62316b).f62309c;
                    k.c(cJRGridProduct, "item");
                    k.c(lottieAnimationView, "deleteView");
                    k.c(view2, "itemDetails");
                    if (aVar.f62306c.getMasterDataListDealsModel().size() > 0 && aVar.f62306c.getMasterDataListDealsModel().contains(cJRGridProduct)) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(aVar.f62304a, R.anim.v8_widget_deal_selection_item_delete);
                        k.a((Object) loadAnimation, "AnimationUtils.loadAnima…al_selection_item_delete)");
                        view2.startAnimation(loadAnimation);
                        lottieAnimationView.setProgress(0.0f);
                        lottieAnimationView.setSpeed(1.0f);
                        lottieAnimationView.addAnimatorListener(new b(aVar));
                        lottieAnimationView.playAnimation();
                        CJRDealSelectWidgetV8 cJRDealSelectWidgetV8 = aVar.f62306c;
                        cJRDealSelectWidgetV8.setItemSize(cJRDealSelectWidgetV8.getItemSize() - 1);
                        CJRDealSelectWidgetV8 cJRDealSelectWidgetV82 = aVar.f62306c;
                        int amountTotal = cJRDealSelectWidgetV82.getAmountTotal();
                        String discountedPrice = cJRGridProduct.getDiscountedPrice();
                        k.a((Object) discountedPrice, "deleteItem.discountedPrice");
                        cJRDealSelectWidgetV82.setAmountTotal(amountTotal - Integer.parseInt(discountedPrice));
                        String discountedPrice2 = cJRGridProduct.getDiscountedPrice();
                        k.a((Object) discountedPrice2, "deleteItem.discountedPrice");
                        if (((float) Integer.parseInt(discountedPrice2)) > 0.0f) {
                            CJRDealSelectWidgetV8 cJRDealSelectWidgetV83 = aVar.f62306c;
                            cJRDealSelectWidgetV83.j = cJRDealSelectWidgetV83.j - 1;
                        } else {
                            CJRDealSelectWidgetV8 cJRDealSelectWidgetV84 = aVar.f62306c;
                            cJRDealSelectWidgetV84.f62303i = cJRDealSelectWidgetV84.f62303i - 1;
                        }
                        if (aVar.f62306c.getMasterDataListDealsModel().size() > 0) {
                            net.one97.paytm.recharge.coupons.e.b f2 = aVar.f62306c.q;
                            if (f2 != null) {
                                k.c(cJRGridProduct, "dealsModel");
                                f2.f62291c.setValue(cJRGridProduct);
                            }
                            aVar.f62305b.remove(cJRGridProduct);
                            aVar.f62306c.getMasterDataListDealsModel().remove(cJRGridProduct);
                        }
                        new Handler().postDelayed(new c(aVar), 1300);
                    }
                }
                ((C1198a) this.f62316b).f62308b.setEnabled(false);
                ((C1198a) this.f62316b).f62308b.postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f62318a;

                    {
                        this.f62318a = r1;
                    }

                    public final void run() {
                        ((C1198a) this.f62318a.f62316b).f62308b.setEnabled(true);
                    }
                }, 1300);
            }
        }

        /* renamed from: net.one97.paytm.recharge.coupons.widget.CJRDealSelectWidgetV8$a$a  reason: collision with other inner class name */
        public final class C1198a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            RelativeLayout f62307a;

            /* renamed from: b  reason: collision with root package name */
            LottieAnimationView f62308b;

            /* renamed from: c  reason: collision with root package name */
            RelativeLayout f62309c;

            /* renamed from: d  reason: collision with root package name */
            TextView f62310d;

            /* renamed from: e  reason: collision with root package name */
            TextView f62311e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ a f62312f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1198a(a aVar, View view) {
                super(view);
                k.c(view, "itemView");
                this.f62312f = aVar;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.icon);
                if (relativeLayout != null) {
                    this.f62307a = relativeLayout;
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) view.findViewById(R.id.delete);
                    if (cJRRechargeLottieAnimationView != null) {
                        this.f62308b = cJRRechargeLottieAnimationView;
                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.itemDetails);
                        if (relativeLayout2 != null) {
                            this.f62309c = relativeLayout2;
                            TextView textView = (TextView) view.findViewById(R.id.dealBrandAmount);
                            if (textView != null) {
                                this.f62310d = textView;
                                TextView textView2 = (TextView) view.findViewById(R.id.dealBrand);
                                if (textView2 != null) {
                                    this.f62311e = textView2;
                                    return;
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                    }
                    throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                }
                throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
        }

        public static final class b implements Animator.AnimatorListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f62313a;

            public final void onAnimationRepeat(Animator animator) {
            }

            b(a aVar) {
                this.f62313a = aVar;
            }

            public final void onAnimationEnd(Animator animator) {
                net.one97.paytm.recharge.coupons.e.b f2 = this.f62313a.f62306c.q;
                if (f2 != null) {
                    f2.f62292d = false;
                }
            }

            public final void onAnimationCancel(Animator animator) {
                net.one97.paytm.recharge.coupons.e.b f2 = this.f62313a.f62306c.q;
                if (f2 != null) {
                    f2.f62292d = false;
                }
            }

            public final void onAnimationStart(Animator animator) {
                net.one97.paytm.recharge.coupons.e.b f2 = this.f62313a.f62306c.q;
                if (f2 != null) {
                    f2.f62292d = true;
                }
            }
        }

        static final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f62314a;

            c(a aVar) {
                this.f62314a = aVar;
            }

            public final void run() {
                this.f62314a.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public final StringBuilder getDealSummaryText() {
        StringBuilder sb = new StringBuilder("");
        int i2 = this.f62303i;
        if (i2 > 0) {
            sb.append(i2);
            sb.append(" ");
            Context context = getContext();
            k.a((Object) context, "context");
            sb.append(context.getResources().getString(R.string.grid_free));
        }
        if (this.f62303i > 0 && this.j > 0) {
            sb.append(" & ");
        }
        int i3 = this.j;
        if (i3 > 0) {
            sb.append(i3);
            sb.append(" ");
            Context context2 = getContext();
            k.a((Object) context2, "context");
            sb.append(context2.getResources().getString(R.string.paid));
        }
        if (this.f62303i + this.j > 1) {
            sb.append(" ");
            Context context3 = getContext();
            k.a((Object) context3, "context");
            sb.append(context3.getResources().getString(R.string.deals));
        } else {
            sb.append(" ");
            Context context4 = getContext();
            k.a((Object) context4, "context");
            sb.append(context4.getResources().getString(R.string.deal));
        }
        return sb;
    }

    public static final /* synthetic */ String a(String str) {
        List<String> a2 = p.a((CharSequence) str, new String[]{" "});
        int size = a2.size();
        String str2 = "";
        int i2 = 0;
        while (i2 < size && i2 <= 1) {
            str2 = str2 + " " + a2.get(i2);
            i2++;
        }
        return str2;
    }
}
