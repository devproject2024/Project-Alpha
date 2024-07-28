package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.o2o.movies.adapter.ad;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.customui.SlidingViewPager;
import net.one97.paytm.o2o.movies.utils.n;

public final class ar {

    /* renamed from: a  reason: collision with root package name */
    final String f74458a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public SlidingViewPager f74459b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f74460c;

    /* renamed from: d  reason: collision with root package name */
    String f74461d;

    /* renamed from: e  reason: collision with root package name */
    long f74462e;

    /* renamed from: f  reason: collision with root package name */
    int f74463f = 0;

    /* renamed from: g  reason: collision with root package name */
    Context f74464g;

    /* renamed from: h  reason: collision with root package name */
    private final long f74465h = 2;

    /* renamed from: i  reason: collision with root package name */
    private CJRHomePageLayoutV2 f74466i;
    private long j;
    private ad.a k;

    public ar(final SlidingViewPager slidingViewPager, final CJRHomePageLayoutV2 cJRHomePageLayoutV2, Context context, ad.a aVar, String str) {
        this.f74466i = cJRHomePageLayoutV2;
        this.f74464g = context;
        this.f74461d = str;
        this.k = aVar;
        c.a();
        this.j = (long) b.f75032a.f75033b.getIntFromGTM("banner_swipe_duration", 0);
        long j2 = this.j;
        this.f74462e = (j2 == 0 ? 2 : j2) * 1000;
        try {
            this.f74459b = slidingViewPager;
            this.f74460c = new Runnable() {
                public final void run() {
                    if (cJRHomePageLayoutV2.getHomePageItemList().size() > 1) {
                        CJRHomePageLayoutV2 cJRHomePageLayoutV2 = cJRHomePageLayoutV2;
                        if (!(cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getHomePageItemList() == null)) {
                            if (ar.this.f74463f == (cJRHomePageLayoutV2.getHomePageItemList().size() + (cJRHomePageLayoutV2.getHomePageItemList().size() * 1000)) - 2) {
                                ar.this.f74463f = 0;
                            }
                            SlidingViewPager slidingViewPager = slidingViewPager;
                            ar arVar = ar.this;
                            int i2 = arVar.f74463f;
                            arVar.f74463f = i2 + 1;
                            slidingViewPager.setCurrentItem(i2, true);
                        }
                        slidingViewPager.postDelayed(this, ar.this.f74462e);
                    }
                }
            };
            slidingViewPager.postDelayed(this.f74460c, this.f74462e);
            slidingViewPager.setOnTouchListener(new View.OnTouchListener(slidingViewPager) {
                private final /* synthetic */ SlidingViewPager f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return ar.this.a(this.f$1, view, motionEvent);
                }
            });
            slidingViewPager.addOnPageChangeListener(new ViewPager.e() {
                public final void onPageScrollStateChanged(int i2) {
                }

                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                public final void onPageSelected(int i2) {
                    ar.this.f74463f = i2;
                    CJRHomePageItem cJRHomePageItem = cJRHomePageLayoutV2.getHomePageItemList().get(i2 % cJRHomePageLayoutV2.getHomePageItemList().size());
                    if (!cJRHomePageItem.isItemViewed()) {
                        cJRHomePageItem.setItemViewed();
                        ar arVar = ar.this;
                        CJRHomePageLayoutV2 cJRHomePageLayoutV2 = cJRHomePageLayoutV2;
                        try {
                            int size = i2 % cJRHomePageLayoutV2.getHomePageItemList().size();
                            CJRHomePageItem cJRHomePageItem2 = cJRHomePageLayoutV2.getHomePageItemList().get(size);
                            cJRHomePageItem2.setParentItem("-" + cJRHomePageLayoutV2.getName());
                            String containerInstanceId = b.f75032a.f75033b.getContainerInstanceId(cJRHomePageLayoutV2);
                            if (containerInstanceId != null) {
                                cJRHomePageItem2.setmContainerInstanceID(containerInstanceId);
                            } else {
                                cJRHomePageItem2.setmContainerInstanceID("");
                            }
                            b.f75032a.f75033b.sendPromotionImpression(cJRHomePageItem2, arVar.f74464g, size, "/movies/" + arVar.f74461d);
                            q.d("triggerGTMPromotionImpression: " + cJRHomePageItem2.getListId() + ": " + cJRHomePageItem2.getName());
                        } catch (Exception unused) {
                        }
                        ar arVar2 = ar.this;
                        CJRHomePageLayoutV2 cJRHomePageLayoutV22 = cJRHomePageLayoutV2;
                        try {
                            int size2 = i2 % cJRHomePageLayoutV22.getHomePageItemList().size();
                            CJRHomePageItem cJRHomePageItem3 = cJRHomePageLayoutV22.getHomePageItemList().get(size2);
                            HashMap hashMap = new HashMap();
                            HashMap hashMap2 = new HashMap();
                            HashMap hashMap3 = new HashMap();
                            ArrayList arrayList = new ArrayList();
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("id", cJRHomePageItem3.getItemID());
                            hashMap4.put("name", cJRHomePageItem3.getName());
                            hashMap4.put("creative", cJRHomePageItem3.getImageUrl());
                            hashMap4.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(size2 + 1));
                            arrayList.add(hashMap4);
                            hashMap3.put("promotions", arrayList);
                            hashMap2.put("promoView", hashMap3);
                            hashMap.put("ecommerce", hashMap2);
                            hashMap.put("vertical_name", "Entertainment - Movies");
                            b.f75032a.f75033b.sendEnhancedEcommerceEvent("promotionImpression", hashMap, arVar2.f74464g);
                            q.d("sendMovieBannerPromoImpression: " + cJRHomePageItem3.getListId() + ": " + cJRHomePageItem3.getName());
                        } catch (Exception unused2) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(SlidingViewPager slidingViewPager, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            slidingViewPager.removeCallbacks(this.f74460c);
            return false;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            slidingViewPager.postDelayed(this.f74460c, this.f74462e);
            return false;
        }
    }

    public final void a(ar arVar) {
        try {
            if (this.f74466i != null) {
                this.f74463f = 0;
                ad adVar = new ad(this.f74466i, arVar.f74459b, this.f74461d);
                SlidingViewPager slidingViewPager = arVar.f74459b;
                int b2 = n.b(slidingViewPager.getContext());
                slidingViewPager.setBackground((Drawable) null);
                int a2 = b2 - n.a(20, slidingViewPager.getContext());
                adVar.f74275b = a2;
                adVar.f74274a = (int) (((double) a2) / 1.69d);
                arVar.f74459b.setAdapter(adVar);
                adVar.f74276c = this.k;
                if (this.f74466i.getHomePageItemList().size() > 1) {
                    arVar.f74459b.post(new Runnable(arVar) {
                        private final /* synthetic */ ar f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ar.this.c(this.f$1);
                        }
                    });
                    arVar.f74459b.postDelayed(new Runnable(arVar) {
                        private final /* synthetic */ ar f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ar.this.b(this.f$1);
                        }
                    }, 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(ar arVar) {
        arVar.f74459b.setCurrentItem((this.f74466i.getHomePageItemList().size() * 10) - 1, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ar arVar) {
        arVar.f74459b.setCurrentItem(this.f74466i.getHomePageItemList().size() * 10, true);
    }
}
