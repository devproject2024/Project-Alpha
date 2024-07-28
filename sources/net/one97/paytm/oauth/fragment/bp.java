package net.one97.paytm.oauth.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.i.f;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.g.i;
import net.one97.paytm.oauth.utils.p;

public final class bp extends f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56503b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public boolean f56504a;

    /* renamed from: c  reason: collision with root package name */
    private i f56505c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<bq> f56506d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.oauth.c.b f56507e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56508f;

    public final View a(int i2) {
        if (this.f56508f == null) {
            this.f56508f = new HashMap();
        }
        View view = (View) this.f56508f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56508f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<e<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bp f56509a;

        c(bp bpVar) {
            this.f56509a = bpVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            e eVar = (e) obj;
            if (eVar != null && eVar.f52602a == 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) t;
                    if (iJRPaytmDataModel != null) {
                        try {
                            CJRHomePageLayoutV2 cJRHomePageLayoutV2 = ((CJRHomePageV2) iJRPaytmDataModel).mPage.get(0).mHomePageLayoutList.get(0);
                            k.a((Object) cJRHomePageLayoutV2, "resModel.mPage[0].mHomePageLayoutList[0]");
                            ArrayList<CJRHomePageItem> homePageItemList = cJRHomePageLayoutV2.getHomePageItemList();
                            if (homePageItemList != null && homePageItemList.size() > 0) {
                                int size = homePageItemList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    CJRHomePageItem cJRHomePageItem = homePageItemList.get(i2);
                                    ArrayList a2 = this.f56509a.f56506d;
                                    k.a((Object) cJRHomePageItem, "model");
                                    String imageUrl = cJRHomePageItem.getImageUrl();
                                    k.a((Object) imageUrl, "model.imageUrl");
                                    String url = cJRHomePageItem.getURL();
                                    k.a((Object) url, "model.url");
                                    a2.add(new bq(imageUrl, url));
                                }
                                bp.b(this.f56509a).notifyDataSetChanged();
                                if (this.f56509a.f56506d.size() > 1) {
                                    CirclePageIndicator circlePageIndicator = (CirclePageIndicator) this.f56509a.a(R.id.viewPagerIndicator);
                                    if (circlePageIndicator != null) {
                                        circlePageIndicator.setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                                CirclePageIndicator circlePageIndicator2 = (CirclePageIndicator) this.f56509a.a(R.id.viewPagerIndicator);
                                if (circlePageIndicator2 != null) {
                                    circlePageIndicator2.setVisibility(4);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageV2");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.oauth.c.b b(bp bpVar) {
        net.one97.paytm.oauth.c.b bVar = bpVar.f56507e;
        if (bVar == null) {
            k.a("pagerAdapter");
        }
        return bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56510a = new d();

        d() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById2 == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheetInternal!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(d.f56510a);
        }
        return layoutInflater.inflate(R.layout.fragment_dialog_bottom_sign_up, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f56507e = new net.one97.paytm.oauth.c.b(this, this.f56506d);
        ViewPager viewPager = (ViewPager) a(R.id.viewPager);
        if (viewPager != null) {
            net.one97.paytm.oauth.c.b bVar = this.f56507e;
            if (bVar == null) {
                k.a("pagerAdapter");
            }
            viewPager.setAdapter(bVar);
        }
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) a(R.id.viewPagerIndicator);
        if (circlePageIndicator != null) {
            circlePageIndicator.setViewPager((ViewPager) a(R.id.viewPager));
        }
        CirclePageIndicator circlePageIndicator2 = (CirclePageIndicator) a(R.id.viewPagerIndicator);
        if (circlePageIndicator2 != null) {
            circlePageIndicator2.setVisibility(4);
        }
        ViewPager viewPager2 = (ViewPager) a(R.id.viewPager);
        if (viewPager2 != null) {
            viewPager2.addOnPageChangeListener(new b());
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.btnCreateAccount);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.txtDoItLater);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        Fragment fragment = this;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        ai a2 = am.a(fragment, (al.b) new net.one97.paytm.oauth.g.b(application, new String[0])).a(i.class);
        k.a((Object) a2, "ViewModelProviders.of(th…tomViewModel::class.java)");
        this.f56505c = (i) a2;
        i iVar = this.f56505c;
        if (iVar == null) {
            k.a("signUpViewModel");
        }
        y yVar = new y();
        com.paytm.network.a e2 = net.one97.paytm.oauth.b.b.e(new i.a(yVar), bp.class.getName());
        if (!com.paytm.utility.b.c((Context) iVar.getApplication())) {
            yVar.setValue(e.b(e2));
        } else if (e2 != null) {
            e2.a();
        }
        yVar.observe(getViewLifecycleOwner(), new c(this));
        a("signup_popup_loaded", new ArrayList());
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        try {
            if (!this.f56504a) {
                a("popup_discarded", new ArrayList());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDismiss(dialogInterface);
    }

    public static final class b implements ViewPager.e {
        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        public final void onPageSelected(int i2) {
        }

        b() {
        }
    }

    public final void onClick(View view) {
        this.f56504a = true;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnCreateAccount;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("create_account_clicked", new ArrayList());
            OauthModule.b().launchAJRAuthActivity(getContext(), new Bundle());
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.txtDoItLater;
        if (valueOf != null && valueOf.intValue() == i3) {
            a("do_it_later_clicked", new ArrayList());
            dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "signup_prompt", str, arrayList, (String) null, "/signup_prompt", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56508f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
