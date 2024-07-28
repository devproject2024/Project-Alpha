package net.one97.paytm.landingpage;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.utils.r;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f52739a = "StoreFrontIconController";

    public static void a(String str, final b bVar, Context context) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            String a2 = a.a(context);
            String q = a.q(context);
            if (!TextUtils.isEmpty(a2) && a.p(context)) {
                hashMap.put("user_id", a2);
            }
            if (!TextUtils.isEmpty(q)) {
                hashMap.put(AppConstants.SSO_TOKEN, q);
            }
            hashMap.put("Content-Type", "application/json");
            new HashMap().put("", f52739a);
            com.paytm.network.a a3 = d.a(context, str, new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        bVar.onApiSuccess((CJRHomePageV2) iJRPaytmDataModel);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    try {
                        if (networkCustomError instanceof NetworkCustomError) {
                            bVar.handleErrorCode(0, (IJRPaytmDataModel) null, networkCustomError);
                        }
                    } catch (Exception unused) {
                    }
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.POST, (String) null, new CJRHomePageV2(), a.c.HOME, a.b.SILENT);
            if (com.paytm.utility.a.m(context)) {
                a3.a();
            }
        }
    }

    public static ArrayList<CJRHomePageItem> a(CJRHomePageV2 cJRHomePageV2) {
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        ArrayList<CJRHomePageItem> arrayList2 = new ArrayList<>();
        Iterator<CJRHomePageLayoutV2> it2 = b(cJRHomePageV2).iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            int i3 = i2 + 1;
            next.setWidgetPosition(i2);
            arrayList.add(next);
            ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
            Iterator<CJRHomePageItem> it3 = homePageItemList.iterator();
            while (it3.hasNext()) {
                CJRHomePageItem next2 = it3.next();
                next2.setParentId(next.getParentID());
                next2.setPromoName("/-category_icons_all_list");
                next2.setmContainerInstanceID(r.a(next));
            }
            arrayList2.addAll(homePageItemList);
            i2 = i3;
        }
        return arrayList2;
    }

    private static ArrayList<CJRHomePageLayoutV2> b(CJRHomePageV2 cJRHomePageV2) {
        ArrayList<CJRHomePageDetailV2> arrayList = cJRHomePageV2.getmPage();
        ArrayList<CJRHomePageLayoutV2> arrayList2 = new ArrayList<>();
        Iterator<CJRHomePageDetailV2> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            net.one97.paytm.common.b.a b2 = d.b();
            d.b().a();
            arrayList2.addAll(it2.next().pageRowItems(false, b2.a(SmartIconGridConstants.SHOW_NEW_WIDGETS, true)));
        }
        return arrayList2;
    }

    public static ArrayList<CJRHomePageItem> a(CJRHomePageV2 cJRHomePageV2, String str, String str2) {
        ArrayList<CJRHomePageItem> homePageItemList;
        ArrayList<String> arrayList;
        if (!((cJRHomePageV2 == null || cJRHomePageV2.getmPage() == null || cJRHomePageV2.getmPage().size() <= 0) ? false : true)) {
            return null;
        }
        ArrayList<CJRHomePageItem> arrayList2 = new ArrayList<>();
        Iterator<CJRHomePageDetailV2> it2 = cJRHomePageV2.getmPage().iterator();
        while (it2.hasNext()) {
            CJRHomePageDetailV2 next = it2.next();
            if (str2.equals(next.getmId()) && next.getHomePageLayoutList() != null && next.getHomePageLayoutList().size() > 0 && (homePageItemList = next.getHomePageLayoutList().get(0).getHomePageItemList()) != null && homePageItemList.size() > 0) {
                Iterator<CJRHomePageItem> it3 = homePageItemList.iterator();
                while (it3.hasNext()) {
                    CJRHomePageItem next2 = it3.next();
                    if (next2.getmGroupViewId() != null && (arrayList = next2.getmGroupViewId().getmSearchKeywords()) != null && arrayList.size() > 0) {
                        Iterator<String> it4 = arrayList.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                if (it4.next().toLowerCase().contains(str.toLowerCase())) {
                                    arrayList2.add(next2);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList2;
    }
}
