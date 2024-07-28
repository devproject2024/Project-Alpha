package com.paytmmall.clpartifact.view.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.ads.PaytmAdView;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import java.io.Serializable;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

@f(b = "InterstetialActivity.kt", c = {68, 70}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/view/activity/InterstetialActivity$initViews$1")
final class InterstetialActivity$initViews$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Serializable $item;
    final /* synthetic */ x.e $pageItem;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ InterstetialActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterstetialActivity$initViews$1(InterstetialActivity interstetialActivity, x.e eVar, Serializable serializable, d dVar) {
        super(2, dVar);
        this.this$0 = interstetialActivity;
        this.$pageItem = eVar;
        this.$item = serializable;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        InterstetialActivity$initViews$1 interstetialActivity$initViews$1 = new InterstetialActivity$initViews$1(this.this$0, this.$pageItem, this.$item, dVar);
        interstetialActivity$initViews$1.p$ = (CoroutineScope) obj;
        return interstetialActivity$initViews$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((InterstetialActivity$initViews$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    public final Object invokeSuspend(T t) {
        x.e eVar;
        T t2 = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                eVar = (x.e) this.L$0;
                if (t instanceof p.b) {
                    throw ((p.b) t).exception;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (!(t instanceof p.b)) {
            x.e eVar2 = this.$pageItem;
            this.L$0 = eVar2;
            this.label = 1;
            T clientPojo = SFGsonUtils.getClientPojo(this.$item, CJRHomePageItem.class, this);
            if (clientPojo == t2) {
                return t2;
            }
            eVar = eVar2;
            t = clientPojo;
        } else {
            throw ((p.b) t).exception;
        }
        eVar.element = (CJRHomePageItem) t;
        ((ImageView) this.this$0._$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ InterstetialActivity$initViews$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.this$0.onBackPressed();
            }
        });
        ((ConstraintLayout) this.this$0._$_findCachedViewById(R.id.clRoot)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ InterstetialActivity$initViews$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.this$0.onBackPressed();
            }
        });
        if (!this.this$0.isFinishing() && !this.this$0.isDestroyed()) {
            b.a aVar = b.f43744a;
            b.a.C0750a a2 = b.a.a(this.this$0);
            a2.f43753a = this.this$0.getIntent().getStringExtra(CLPConstants.ISV_IMG_URL);
            a2.a((ImageView) (PaytmAdView) this.this$0._$_findCachedViewById(R.id.ivAdvertisement), (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>(this) {
                final /* synthetic */ InterstetialActivity$initViews$1 this$0;

                public final void onError(Exception exc) {
                }

                {
                    this.this$0 = r1;
                }

                public final void onSuccess(Drawable drawable, c cVar) {
                    if (((CJRHomePageItem) this.this$0.$pageItem.element) != null) {
                        GaHandler.getInstance().fireISAdEvent((CJRHomePageItem) this.this$0.$pageItem.element, this.this$0.this$0, "promotionImpression");
                    }
                }
            });
            View findViewById = this.this$0.findViewById(R.id.ivAdvertisement);
            if (findViewById != null) {
                PaytmAdView paytmAdView = (PaytmAdView) findViewById;
                this.this$0.setAddSDK((CJRHomePageItem) this.$pageItem.element, paytmAdView);
                paytmAdView.setOnClickListener(new PaytmAdView.a(this) {
                    final /* synthetic */ InterstetialActivity$initViews$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onAdClick(View view) {
                        String str;
                        CLPArtifact instance;
                        ICLPCommunicationListener communicationListener;
                        ICLPCommunicationListener communicationListener2;
                        ICLPCommunicationListener communicationListener3;
                        String stringExtra = this.this$0.this$0.getIntent().getStringExtra(CLPConstants.ISV_CLICK_URL);
                        if (((CJRHomePageItem) this.this$0.$pageItem.element) != null) {
                            GaHandler.getInstance().fireISAdEvent((CJRHomePageItem) this.this$0.$pageItem.element, this.this$0.this$0, "promotionClick");
                        }
                        if (!TextUtils.isEmpty(stringExtra)) {
                            CLPArtifact instance2 = CLPArtifact.getInstance();
                            if (instance2 == null || (communicationListener3 = instance2.getCommunicationListener()) == null || (str = communicationListener3.getHostScheme()) == null) {
                                str = this.this$0.this$0.DEEPLINK;
                            }
                            kotlin.g.b.k.a((Object) str, "CLPArtifact.getInstance(…              ?: DEEPLINK");
                            kotlin.g.b.k.a((Object) stringExtra, "url");
                            if (kotlin.m.p.b(stringExtra, str, false)) {
                                CLPArtifact instance3 = CLPArtifact.getInstance();
                                if (!(instance3 == null || (communicationListener2 = instance3.getCommunicationListener()) == null)) {
                                    communicationListener2.handleDeepLink(this.this$0.this$0, this.this$0.this$0.getItem(stringExtra, (CJRHomePageItem) this.this$0.$pageItem.element));
                                }
                            } else if (!(!kotlin.m.p.b(stringExtra, this.this$0.this$0.HTTP, false) || (instance = CLPArtifact.getInstance()) == null || (communicationListener = instance.getCommunicationListener()) == null)) {
                                communicationListener.openTargetScreen(this.this$0.this$0, CLPConstants.TargetScreenType.SCREEN_TYPE_EMBED, this.this$0.this$0.getTargetIntent(stringExtra));
                            }
                        }
                        this.this$0.this$0.finish();
                    }
                });
            } else {
                throw new u("null cannot be cast to non-null type com.paytm.ads.PaytmAdView");
            }
        }
        return kotlin.x.f47997a;
    }
}
