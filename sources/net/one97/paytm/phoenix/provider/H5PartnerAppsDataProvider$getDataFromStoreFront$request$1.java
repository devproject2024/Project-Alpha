package net.one97.paytm.phoenix.provider;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.h5.model.partner.PartnerHomePageModel;
import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;

public final class H5PartnerAppsDataProvider$getDataFromStoreFront$request$1 implements b {
    final /* synthetic */ H5PartnerAppsDataProvider.StoreFrontDataFetched $callback;

    H5PartnerAppsDataProvider$getDataFromStoreFront$request$1(H5PartnerAppsDataProvider.StoreFrontDataFetched storeFrontDataFetched) {
        this.$callback = storeFrontDataFetched;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (i2 == -1) {
            this.$callback.onError("NW");
        } else {
            this.$callback.onError("SR");
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        Iterator it2;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if (iJRPaytmDataModel2 instanceof PartnerHomePageModel) {
            PartnerHomePageModel partnerHomePageModel = (PartnerHomePageModel) iJRPaytmDataModel2;
            ArrayList<CJRHomePageDetailV2> arrayList = partnerHomePageModel.getmPage();
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ArrayList<CJRHomePageLayoutV2> arrayList2 = ((CJRHomePageDetailV2) it3.next()).mHomePageLayoutList;
                    if (arrayList2 != null) {
                        for (CJRHomePageLayoutV2 cJRHomePageLayoutV2 : arrayList2) {
                            k.a((Object) cJRHomePageLayoutV2, "views");
                            String name = cJRHomePageLayoutV2.getName();
                            ArrayList<CJRHomePageItem> homePageItemList = cJRHomePageLayoutV2.getHomePageItemList();
                            if (homePageItemList != null) {
                                for (CJRHomePageItem cJRHomePageItem : homePageItemList) {
                                    k.a((Object) cJRHomePageItem, "item");
                                    String url = cJRHomePageItem.getURL();
                                    String str = "";
                                    String str2 = url == null ? str : url;
                                    String str3 = str;
                                    for (String str4 : p.a((CharSequence) p.a(str2, "paytmmp://mini-app?", str, false), new String[]{AppConstants.AND_SIGN})) {
                                        if (p.b(str4, "url=", false)) {
                                            try {
                                                it2 = it3;
                                                try {
                                                    int a2 = p.a((CharSequence) str2, "&url=", 0, false, 6) + 5;
                                                    int length = str2.length();
                                                    if (str2 != null) {
                                                        String substring = str2.substring(a2, length);
                                                        k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                        str3 = p.b(p.a(substring, (CharSequence) "\""), (CharSequence) "\"");
                                                    } else {
                                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    q.b(e.getMessage());
                                                    it3 = it2;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                it2 = it3;
                                                q.b(e.getMessage());
                                                it3 = it2;
                                            }
                                        } else {
                                            it2 = it3;
                                            if (p.b(str4, "sId=", false)) {
                                                try {
                                                    int length2 = str4.length();
                                                    if (str4 != null) {
                                                        String substring2 = str4.substring(4, length2);
                                                        k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                        str = p.b(p.a(substring2, (CharSequence) "\""), (CharSequence) "\"");
                                                    } else {
                                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                                    }
                                                } catch (Exception e4) {
                                                    q.b(e4.getMessage());
                                                }
                                            } else if (p.b(str4, "aId=", false)) {
                                                try {
                                                    int length3 = str4.length();
                                                    if (str4 != null) {
                                                        String substring3 = str4.substring(4, length3);
                                                        k.a((Object) substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                        str = p.b(p.a(substring3, (CharSequence) "\""), (CharSequence) "\"");
                                                    } else {
                                                        throw new u("null cannot be cast to non-null type java.lang.String");
                                                    }
                                                } catch (Exception e5) {
                                                    q.b(e5.getMessage());
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                        it3 = it2;
                                    }
                                    Iterator it4 = it3;
                                    boolean z = true;
                                    if (str.length() > 0) {
                                        if (str3.length() <= 0) {
                                            z = false;
                                        }
                                        if (z) {
                                            String name2 = cJRHomePageItem.getName();
                                            k.a((Object) name2, "item.name");
                                            String imageUrl = cJRHomePageItem.getImageUrl();
                                            k.a((Object) imageUrl, "item.imageUrl");
                                            k.a((Object) name, "category");
                                            H5PartnerAppsDataProvider.appData.put(str, new MiniAppData(str3, name2, imageUrl, name));
                                        }
                                    }
                                    it3 = it4;
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
            String responseRaw = partnerHomePageModel.getResponseRaw();
            if (responseRaw != null) {
                H5PartnerAppsDataProvider.partnerRawData = responseRaw;
            }
            this.$callback.onDataFetched();
            return;
        }
        this.$callback.onError("SR");
    }
}
