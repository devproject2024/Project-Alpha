package net.one97.paytm.vipcashback.c;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f20737a = {y.a((v) new w(y.b(e.class), "secondCard", "getSecondCard()Landroid/widget/RelativeLayout;"))};

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.v2.features.b.c.a f20738b;

    /* renamed from: c  reason: collision with root package name */
    VIPCashBackOfferV4 f20739c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<ScratchCard> f20740d;

    /* renamed from: e  reason: collision with root package name */
    final ViewGroup f20741e;

    /* renamed from: f  reason: collision with root package name */
    final FragmentActivity f20742f;

    /* renamed from: g  reason: collision with root package name */
    final net.one97.paytm.cashback.posttxn.a f20743g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f20744h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public View f20745i;
    private int j = this.f20742f.getResources().getDimensionPixelOffset(R.dimen.dimen_24dp);
    private int k = this.f20742f.getResources().getDimensionPixelOffset(R.dimen.dimen_70dp);
    /* access modifiers changed from: private */
    public Point l;
    /* access modifiers changed from: private */
    public final String m = "Cashback";
    private final kotlin.g n = kotlin.h.a(new i(this));
    /* access modifiers changed from: private */
    public boolean o;

    static final class f<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f20751a = new f();

        f() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static final class c<T> implements z<ArrayList<ScratchCardData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20748a;

        c(e eVar) {
            this.f20748a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (this.f20748a.f20745i != null) {
                this.f20748a.f20741e.removeView(this.f20748a.f20745i);
            }
            this.f20748a.f20744h = (arrayList != null ? arrayList.size() : 0) > 1;
            if (this.f20748a.f20744h) {
                e eVar = this.f20748a;
                eVar.f20745i = LayoutInflater.from(eVar.f20742f).inflate(net.one97.paytm.vipcashback.R.layout.posttxn_multi_scratchcard_layout, (ViewGroup) null);
            } else {
                e eVar2 = this.f20748a;
                eVar2.f20745i = LayoutInflater.from(eVar2.f20742f).inflate(net.one97.paytm.vipcashback.R.layout.posttxn_scratchcard_layout, (ViewGroup) null);
            }
            this.f20748a.f20741e.addView(this.f20748a.f20745i);
            i.a aVar = net.one97.paytm.vipcashback.f.i.f20896a;
            Object obj2 = arrayList.get(0);
            k.a(obj2, "it[0]");
            View a2 = i.a.a((ScratchCardData) obj2, this.f20748a.f20742f, false, TarConstants.EOF_BLOCK);
            RelativeLayout relativeLayout = (RelativeLayout) this.f20748a.f20741e.findViewById(net.one97.paytm.vipcashback.R.id.firstCard);
            relativeLayout.addView(a2);
            ImageView imageView = (ImageView) relativeLayout.findViewById(net.one97.paytm.vipcashback.R.id.closeView);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(net.one97.paytm.vipcashback.R.id.close);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            if (a2 != null) {
                a2.setAlpha(0.0f);
            }
            if (this.f20748a.f20744h) {
                i.a aVar2 = net.one97.paytm.vipcashback.f.i.f20896a;
                Object obj3 = arrayList.get(1);
                k.a(obj3, "it[1]");
                final View a3 = i.a.a((ScratchCardData) obj3, this.f20748a.f20742f, false, 1536);
                e.d(this.f20748a).addView(a3);
                ImageView imageView3 = (ImageView) e.d(this.f20748a).findViewById(net.one97.paytm.vipcashback.R.id.closeView);
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                ImageView imageView4 = (ImageView) e.d(this.f20748a).findViewById(net.one97.paytm.vipcashback.R.id.close);
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                ImageView imageView5 = (ImageView) e.d(this.f20748a).findViewById(net.one97.paytm.vipcashback.R.id.cashBackUnit);
                if (imageView5 != null) {
                    imageView5.setVisibility(8);
                }
                ImageView imageView6 = (ImageView) e.d(this.f20748a).findViewById(net.one97.paytm.vipcashback.R.id.cbLogo);
                if (imageView6 != null) {
                    imageView6.setVisibility(8);
                }
                if (a3 != null) {
                    a3.setAlpha(0.0f);
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ c this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        static final class d<T> implements z<NetworkCustomError> {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f20749a;

                            d(e eVar) {
                                this.f20749a = eVar;
                            }

                            public final /* synthetic */ void onChanged(Object obj) {
                                NetworkCustomError networkCustomError = (NetworkCustomError) obj;
                                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                                k.a((Object) networkCustomError, "it");
                                d.a.a(networkCustomError, this.f20749a.f20742f, Boolean.FALSE, 8);
                            }
                        }

                        /* renamed from: net.one97.paytm.vipcashback.c.e$e  reason: collision with other inner class name */
                        static final class C0381e<T> implements z<com.paytm.network.a> {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f20750a;

                            C0381e(e eVar) {
                                this.f20750a = eVar;
                            }

                            public final /* synthetic */ void onChanged(Object obj) {
                                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                                d.a.a(this.f20750a.f20742f, (com.paytm.network.a) obj, false);
                            }
                        }

                        public e(ViewGroup viewGroup, FragmentActivity fragmentActivity, net.one97.paytm.cashback.posttxn.a aVar) {
                            k.c(viewGroup, "decorView");
                            k.c(fragmentActivity, "activity");
                            this.f20741e = viewGroup;
                            this.f20742f = fragmentActivity;
                            this.f20743g = aVar;
                        }

                        static final class i extends l implements kotlin.g.a.a<RelativeLayout> {
                            final /* synthetic */ e this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            i(e eVar) {
                                super(0);
                                this.this$0 = eVar;
                            }

                            public final RelativeLayout invoke() {
                                return (RelativeLayout) this.this$0.f20741e.findViewById(net.one97.paytm.vipcashback.R.id.secondCard);
                            }
                        }

                        public static final class a implements Animation.AnimationListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ e f20746a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ RelativeLayout f20747b;

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationStart(Animation animation) {
                            }

                            a(e eVar, RelativeLayout relativeLayout) {
                                this.f20746a = eVar;
                                this.f20747b = relativeLayout;
                            }

                            public final void onAnimationEnd(Animation animation) {
                                if (this.f20746a.f20744h) {
                                    RelativeLayout relativeLayout = (RelativeLayout) this.f20746a.f20741e.findViewById(net.one97.paytm.vipcashback.R.id.shadowView);
                                    k.a((Object) relativeLayout, "shadowCard");
                                    relativeLayout.setVisibility(0);
                                    relativeLayout.setAlpha(0.0f);
                                    if (!this.f20746a.o) {
                                        this.f20746a.o = true;
                                        relativeLayout.animate().alpha(1.0f).setDuration(500);
                                    }
                                    if (k.a((Object) this.f20747b, (Object) e.d(this.f20746a))) {
                                        e.a((View) relativeLayout);
                                    }
                                }
                                e.a((View) this.f20747b);
                            }
                        }

                        public static final class j implements Animator.AnimatorListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ ViewPropertyAnimator f20754a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ e f20755b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ x.e f20756c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ x.c f20757d;

                            /* renamed from: e  reason: collision with root package name */
                            final /* synthetic */ View f20758e;

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            j(ViewPropertyAnimator viewPropertyAnimator, e eVar, x.e eVar2, x.c cVar, View view) {
                                this.f20754a = viewPropertyAnimator;
                                this.f20755b = eVar;
                                this.f20756c = eVar2;
                                this.f20757d = cVar;
                                this.f20758e = view;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                ViewPropertyAnimator animate = this.f20758e.animate();
                                if (animate != null) {
                                    animate.scaleX(0.0f);
                                    animate.scaleY(0.0f);
                                }
                                this.f20754a.setListener((Animator.AnimatorListener) null);
                                if (this.f20755b.f20743g instanceof net.one97.paytm.cashback.posttxn.b) {
                                    net.one97.paytm.cashback.posttxn.b bVar = (net.one97.paytm.cashback.posttxn.b) this.f20755b.f20743g;
                                    if (bVar != null) {
                                        bVar.a(this.f20755b.m, true);
                                    }
                                } else {
                                    net.one97.paytm.cashback.posttxn.a aVar = this.f20755b.f20743g;
                                    if (aVar != null) {
                                        aVar.onAnimationEnd(this.f20755b.m);
                                    }
                                }
                                View b2 = this.f20755b.f20745i;
                                if (b2 != null) {
                                    ViewGroup viewGroup = this.f20755b.f20741e;
                                    if (viewGroup != null) {
                                        viewGroup.removeView(b2);
                                    }
                                    this.f20755b.f20745i = null;
                                }
                            }
                        }

                        public static final class h implements Animator.AnimatorListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ LottieAnimationView f20752a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ e f20753b;

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            h(LottieAnimationView lottieAnimationView, e eVar) {
                                this.f20752a = lottieAnimationView;
                                this.f20753b = eVar;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                this.f20752a.setVisibility(8);
                                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                    int label;
                                    private CoroutineScope p$;
                                    final /* synthetic */ h this$0;

                                    {
                                        this.this$0 = r1;
                                    }

                                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                        k.c(dVar, "completion");
                                        AnonymousClass1 r0 = 

                                        public static final /* synthetic */ RelativeLayout d(e eVar) {
                                            return (RelativeLayout) eVar.n.getValue();
                                        }

                                        @kotlin.d.b.a.f(b = "ScratchCardController.kt", c = {176, 179}, d = "invokeSuspend", e = "net/one97/paytm/vipcashback/helper/ScratchCardController$cardEntryAnim$2")
                                        static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                            final /* synthetic */ Animation $translateAnim;
                                            final /* synthetic */ View $view;
                                            int label;
                                            private CoroutineScope p$;

                                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                            b(View view, Animation animation, kotlin.d.d dVar) {
                                                super(2, dVar);
                                                this.$view = view;
                                                this.$translateAnim = animation;
                                            }

                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                k.c(dVar, "completion");
                                                b bVar = new b(this.$view, this.$translateAnim, dVar);
                                                bVar.p$ = (CoroutineScope) obj;
                                                return bVar;
                                            }

                                            public final Object invoke(Object obj, Object obj2) {
                                                return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                                int i2 = this.label;
                                                if (i2 != 0) {
                                                    if (i2 != 1) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    } else if (obj instanceof p.b) {
                                                        throw ((p.b) obj).exception;
                                                    }
                                                } else if (!(obj instanceof p.b)) {
                                                    this.$view.startAnimation(this.$translateAnim);
                                                    this.label = 1;
                                                    if (DelayKt.delay(20, this) == aVar) {
                                                        return aVar;
                                                    }
                                                } else {
                                                    throw ((p.b) obj).exception;
                                                }
                                                View view = this.$view;
                                                if (view != null) {
                                                    view.setAlpha(1.0f);
                                                }
                                                return kotlin.x.f47997a;
                                            }
                                        }

                                        @kotlin.d.b.a.f(b = "ScratchCardController.kt", c = {58}, d = "invokeSuspend", e = "net/one97/paytm/vipcashback/helper/ScratchCardController$loadCards$1")
                                        static final class g extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                            int label;
                                            private CoroutineScope p$;
                                            final /* synthetic */ e this$0;

                                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                            g(e eVar, kotlin.d.d dVar) {
                                                super(2, dVar);
                                                this.this$0 = eVar;
                                            }

                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                k.c(dVar, "completion");
                                                g gVar = new g(this.this$0, dVar);
                                                gVar.p$ = (CoroutineScope) obj;
                                                return gVar;
                                            }

                                            public final Object invoke(Object obj, Object obj2) {
                                                return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                                if (this.label != 0) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                } else if (!(obj instanceof p.b)) {
                                                    e eVar = this.this$0;
                                                    net.one97.paytm.cashback.posttxn.a aVar2 = eVar.f20743g;
                                                    eVar.l = aVar2 != null ? aVar2.getFloatingWidgetPos(this.this$0.m) : null;
                                                    return kotlin.x.f47997a;
                                                } else {
                                                    throw ((p.b) obj).exception;
                                                }
                                            }
                                        }

                                        public static final /* synthetic */ void a(e eVar, View view, RelativeLayout relativeLayout) {
                                            Animation loadAnimation = AnimationUtils.loadAnimation(eVar.f20742f.getApplicationContext(), net.one97.paytm.vipcashback.R.anim.small_card_open);
                                            k.a((Object) loadAnimation, "AnimationUtils.loadAnima…small_card_open\n        )");
                                            loadAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
                                            loadAnimation.setFillBefore(false);
                                            loadAnimation.setFillEnabled(true);
                                            loadAnimation.setAnimationListener(new a(eVar, relativeLayout));
                                            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new b(view, loadAnimation, (kotlin.d.d) null), 3, (Object) null);
                                        }

                                        public static final /* synthetic */ void b(e eVar, View view) {
                                            if (view != null) {
                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
                                                if (lottieAnimationView != null) {
                                                    lottieAnimationView.setVisibility(0);
                                                    lottieAnimationView.setImageAssetsFolder("images/");
                                                    lottieAnimationView.setAnimation("loadScratch.json");
                                                    lottieAnimationView.setSpeed(1.8f);
                                                    lottieAnimationView.addAnimatorListener(new h(lottieAnimationView, eVar));
                                                    lottieAnimationView.playAnimation();
                                                    return;
                                                }
                                                return;
                                            }
                                            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                                        }

                                        public static final /* synthetic */ void a(View view) {
                                            androidx.dynamicanimation.a.d dVar = (androidx.dynamicanimation.a.d) new androidx.dynamicanimation.a.d(view, androidx.dynamicanimation.a.d.f14560b).a();
                                            androidx.dynamicanimation.a.e eVar = new androidx.dynamicanimation.a.e();
                                            eVar.c();
                                            eVar.a();
                                            eVar.b();
                                            k.a((Object) dVar, "springAnim");
                                            dVar.a(eVar);
                                            dVar.b();
                                        }

                                        public static final /* synthetic */ void c(e eVar, View view) {
                                            Point point;
                                            Point point2;
                                            Point point3;
                                            Point point4 = eVar.l;
                                            if (point4 == null || ((point4 != null && point4.x == -1) || (((point = eVar.l) != null && point.y == -1) || (((point2 = eVar.l) != null && point2.x == 0) || ((point3 = eVar.l) != null && point3.y == 0))))) {
                                                Resources resources = eVar.f20742f.getResources();
                                                k.a((Object) resources, "activity.resources");
                                                Resources resources2 = eVar.f20742f.getResources();
                                                k.a((Object) resources2, "activity.resources");
                                                eVar.l = new Point(resources.getDisplayMetrics().widthPixels / 2, resources2.getDisplayMetrics().heightPixels);
                                            }
                                            int[] iArr = new int[2];
                                            view.getLocationOnScreen(iArr);
                                            Point point5 = eVar.l;
                                            T t = null;
                                            Integer valueOf = point5 != null ? Integer.valueOf(point5.x + (eVar.j / 2)) : null;
                                            int i2 = 0;
                                            int width = iArr[0] + (view.getWidth() / 2);
                                            x.c cVar = new x.c();
                                            if (valueOf != null) {
                                                i2 = valueOf.intValue();
                                            }
                                            cVar.element = width - i2;
                                            Point point6 = eVar.l;
                                            Integer valueOf2 = point6 != null ? Integer.valueOf(point6.y + (eVar.k / 10)) : null;
                                            int height = iArr[1] + (view.getHeight() / 2);
                                            x.e eVar2 = new x.e();
                                            if (valueOf2 != null) {
                                                t = Integer.valueOf(valueOf2.intValue() - height);
                                            }
                                            eVar2.element = t;
                                            ViewPropertyAnimator animate = view.animate();
                                            if (animate != null) {
                                                animate.setDuration(500);
                                                animate.scaleX(0.0f);
                                                animate.scaleY(0.0f);
                                                Integer num = (Integer) eVar2.element;
                                                if (num != null) {
                                                    animate.translationX(((float) cVar.element) * -1.0f).translationY((float) num.intValue());
                                                }
                                                animate.setListener(new j(animate, eVar, eVar2, cVar, view));
                                            }
                                        }
                                    }
