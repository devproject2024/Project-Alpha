package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class UtilityThinBannersLayout extends RelativeLayout implements ai {

    /* renamed from: a  reason: collision with root package name */
    private final String f62124a = CLPConstants.GA_CHANNEL_NAME;

    /* renamed from: b  reason: collision with root package name */
    private final String f62125b;

    /* renamed from: c  reason: collision with root package name */
    private final b f62126c;

    public interface b {
        void a(CJRHomePageItem cJRHomePageItem);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UtilityThinBannersLayout(Context context, String str, b bVar) {
        super(context);
        k.c(bVar, "utilityBannerListener");
        this.f62125b = str;
        this.f62126c = bVar;
        LayoutInflater.from(context).inflate(R.layout.lyt_mobile_recharge_thin_banner, this, true);
        setVisibility(8);
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.PLAN_BANNER.name());
        }
        if (!TextUtils.isEmpty(this.f62125b) && !p.a("N/A", this.f62125b, true)) {
            HashMap hashMap = new HashMap();
            String a3 = k.a(this.f62125b, (Object) c.a(getContext(), true));
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.b.c(getContext())) {
                Context context2 = getContext();
                k.a((Object) context2, "context");
                context2.getApplicationContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("loadBanners", a3, (ai) this, (IJRPaytmDataModel) new CJRHomePageV2(), (Map<String, String>) null, (Map<String, String>) null, (String) null, (Object) a2));
            }
        }
    }

    public final String getUrl() {
        return this.f62125b;
    }

    public final b getUtilityBannerListener() {
        return this.f62126c;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        k.c(networkCustomError, "error");
        if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJRHomePageV2) {
            setBannerHorizontalList((CJRHomePageV2) iJRPaytmDataModel);
        }
    }

    public final String getHOME_PAGE() {
        return this.f62124a;
    }

    private final void setBannerHorizontalList(CJRHomePageV2 cJRHomePageV2) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.imageviewPager);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.deals_banner_nearby_view_page_indicator);
        if (cJRHomePageV2.getmPage() != null) {
            ArrayList<CJRHomePageDetailV2> arrayList = cJRHomePageV2.getmPage();
            k.a((Object) arrayList, "homePageV2.getmPage()");
            if ((!arrayList.isEmpty()) && cJRHomePageV2.getmPage().get(0) != null) {
                ArrayList<CJRHomePageLayoutV2> arrayList2 = cJRHomePageV2.getmPage().get(0).mHomePageLayoutList;
                k.a((Object) arrayList2, "homePageV2.getmPage()[0].mHomePageLayoutList");
                if ((!arrayList2.isEmpty()) && cJRHomePageV2.getmPage().get(0).mHomePageLayoutList.get(0) != null) {
                    CJRHomePageLayoutV2 cJRHomePageLayoutV2 = cJRHomePageV2.getmPage().get(0).mHomePageLayoutList.get(0);
                    k.a((Object) cJRHomePageLayoutV2, "homePageV2.getmPage()[0].mHomePageLayoutList[0]");
                    ArrayList<CJRHomePageItem> homePageItemList = cJRHomePageLayoutV2.getHomePageItemList();
                    k.a((Object) homePageItemList, "homePageV2.getmPage()[0]…tList[0].homePageItemList");
                    if (!homePageItemList.isEmpty()) {
                        Context context = getContext();
                        k.a((Object) context, "context");
                        CJRHomePageLayoutV2 cJRHomePageLayoutV22 = cJRHomePageV2.getmPage().get(0).mHomePageLayoutList.get(0);
                        k.a((Object) cJRHomePageLayoutV22, "homePageV2.getmPage()[0].mHomePageLayoutList[0]");
                        a aVar = new a(this, context, cJRHomePageLayoutV22.getHomePageItemList(), this.f62126c);
                        k.a((Object) viewPager, "viewPager");
                        viewPager.setAdapter(aVar);
                        viewPager.setPageMargin(com.paytm.utility.b.c(10));
                        circlePageIndicator.setViewPager(viewPager);
                        CJRHomePageLayoutV2 cJRHomePageLayoutV23 = cJRHomePageV2.getmPage().get(0).mHomePageLayoutList.get(0);
                        k.a((Object) cJRHomePageLayoutV23, "homePageV2.getmPage()[0].mHomePageLayoutList[0]");
                        if (cJRHomePageLayoutV23.getHomePageItemList().size() == 1) {
                            k.a((Object) circlePageIndicator, "indicator");
                            circlePageIndicator.setVisibility(8);
                        } else {
                            k.a((Object) circlePageIndicator, "indicator");
                            circlePageIndicator.setVisibility(0);
                        }
                        setVisibility(0);
                    }
                }
            }
        }
    }

    public final class a extends androidx.viewpager.widget.a {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<CJRHomePageItem> f62127a;

        /* renamed from: b  reason: collision with root package name */
        b f62128b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UtilityThinBannersLayout f62129c;

        /* renamed from: d  reason: collision with root package name */
        private final LayoutInflater f62130d;

        /* renamed from: e  reason: collision with root package name */
        private final Context f62131e;

        public final int getItemPosition(Object obj) {
            k.c(obj, "object");
            return -2;
        }

        public a(UtilityThinBannersLayout utilityThinBannersLayout, Context context, ArrayList<CJRHomePageItem> arrayList, b bVar) {
            k.c(context, "mActivity");
            k.c(bVar, "utilityBannerListener");
            this.f62129c = utilityThinBannersLayout;
            this.f62131e = context;
            this.f62127a = arrayList;
            this.f62128b = bVar;
            LayoutInflater from = LayoutInflater.from(this.f62131e);
            k.a((Object) from, "LayoutInflater.from(mActivity)");
            this.f62130d = from;
            ArrayList<CJRHomePageItem> arrayList2 = this.f62127a;
            if (arrayList2 != null) {
                if (arrayList2 == null) {
                    k.a();
                }
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ArrayList<CJRHomePageItem> arrayList3 = this.f62127a;
                    if (arrayList3 == null) {
                        k.a();
                    }
                    CJRHomePageItem cJRHomePageItem = arrayList3.get(size);
                    k.a((Object) cJRHomePageItem, "carouselItems!![i]");
                    CharSequence imageUrl = cJRHomePageItem.getImageUrl();
                    if (imageUrl == null || p.a(imageUrl)) {
                        ArrayList<CJRHomePageItem> arrayList4 = this.f62127a;
                        if (arrayList4 == null) {
                            k.a();
                        }
                        arrayList4.remove(size);
                    }
                }
            }
        }

        public final int getCount() {
            ArrayList<CJRHomePageItem> arrayList = this.f62127a;
            if (arrayList == null) {
                k.a();
            }
            return arrayList.size();
        }

        public final boolean isViewFromObject(View view, Object obj) {
            k.c(view, "view");
            k.c(obj, "object");
            return k.a((Object) view, obj);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "container");
            boolean z = false;
            View inflate = this.f62130d.inflate(R.layout.utility_image_widget_viewpager_item, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.viewpager_image);
            if (findViewById != null) {
                ImageView imageView = (ImageView) findViewById;
                ArrayList<CJRHomePageItem> arrayList = this.f62127a;
                if (arrayList != null) {
                    if (arrayList == null) {
                        k.a();
                    }
                    if (arrayList.size() > i2) {
                        ArrayList<CJRHomePageItem> arrayList2 = this.f62127a;
                        if (arrayList2 == null) {
                            k.a();
                        }
                        CJRHomePageItem cJRHomePageItem = arrayList2.get(i2);
                        k.a((Object) cJRHomePageItem, "carouselItems!![position]");
                        CharSequence imageUrl = cJRHomePageItem.getImageUrl();
                        if (imageUrl == null || p.a(imageUrl)) {
                            z = true;
                        }
                        if (!z) {
                            w a2 = w.a();
                            ArrayList<CJRHomePageItem> arrayList3 = this.f62127a;
                            if (arrayList3 == null) {
                                k.a();
                            }
                            CJRHomePageItem cJRHomePageItem2 = arrayList3.get(i2);
                            k.a((Object) cJRHomePageItem2, "carouselItems!![position]");
                            a2.a(cJRHomePageItem2.getImageUrl()).a(-1).a(imageView);
                        }
                    }
                }
                inflate.setOnClickListener(new C1192a(this, i2));
                viewGroup.addView(inflate);
                k.a((Object) inflate, "view");
                return inflate;
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }

        /* renamed from: net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout$a$a  reason: collision with other inner class name */
        static final class C1192a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f62132a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f62133b;

            C1192a(a aVar, int i2) {
                this.f62132a = aVar;
                this.f62133b = i2;
            }

            public final void onClick(View view) {
                a aVar = this.f62132a;
                int i2 = this.f62133b;
                ArrayList<CJRHomePageItem> arrayList = aVar.f62127a;
                if (arrayList != null && arrayList.size() > i2) {
                    b bVar = aVar.f62128b;
                    CJRHomePageItem cJRHomePageItem = arrayList.get(i2);
                    k.a((Object) cJRHomePageItem, "it[position]");
                    bVar.a(cJRHomePageItem);
                }
            }
        }

        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            k.c(viewGroup, "container");
            k.c(obj, "object");
            View view = (View) obj;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).removeAllViews();
            }
            view.setOnClickListener((View.OnClickListener) null);
            view.removeCallbacks((Runnable) null);
            viewGroup.removeView(view);
        }
    }
}
