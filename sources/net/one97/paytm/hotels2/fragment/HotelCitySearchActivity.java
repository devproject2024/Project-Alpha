package net.one97.paytm.hotels2.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.hotel4.service.model.PopularRecentDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.view.a.j;
import net.one97.paytm.hotel4.view.a.v;
import net.one97.paytm.hotel4.view.ui.a.o;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class HotelCitySearchActivity extends PaytmActivity implements j.a, v.a {
    private o mHotelSearch;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hotel4_city_search_layout);
        this.mHotelSearch = new o();
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.h4_container;
        o oVar = this.mHotelSearch;
        if (oVar == null) {
            k.a("mHotelSearch");
        }
        a2.b(i2, oVar).c();
    }

    public final void autoSuggestOnItemClick(AutoSearchDataItem autoSearchDataItem, int i2, String str) {
        k.c(autoSearchDataItem, "selectedRowData");
        k.c(str, "searchInput");
        sendPulseEventHotelAutoSuggestOnItemClick(autoSearchDataItem, i2, str);
        Intent intent = new Intent();
        intent.putExtra("localitySearchType", "searched");
        intent.putExtra("selected_data_autoSuggest", autoSearchDataItem);
        setResult(-1, intent);
        finish();
    }

    private final void sendPulseEventHotelAutoSuggestOnItemClick(AutoSearchDataItem autoSearchDataItem, int i2, String str) {
        HashMap hashMap = new HashMap();
        if (autoSearchDataItem.getDisplay() != null) {
            Map map = hashMap;
            List<String> display = autoSearchDataItem.getDisplay();
            if (display != null) {
                map.put("event_label", display);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        if (str != null) {
            map2.put("event_label2", str);
            Integer viewTypeCount = autoSearchDataItem.getViewTypeCount();
            if (viewTypeCount == null) {
                k.a();
            }
            if (viewTypeCount.intValue() >= 0) {
                Integer viewTypeCount2 = autoSearchDataItem.getViewTypeCount();
                if (viewTypeCount2 == null) {
                    k.a();
                }
                map2.put("event_label3", Integer.valueOf(viewTypeCount2.intValue() + 1));
            } else {
                map2.put("event_label3", Integer.valueOf(i2));
            }
            String type = autoSearchDataItem.getType();
            if (type != null) {
                map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, type);
                c.b().a("customEvent", "HomePage", "hotels_home", "suggest_selected", map2);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    private final void sendPulseEventHotelPopularRecentOnItemClick(PopularRecentDataItem popularRecentDataItem, int i2, String str) {
        HashMap hashMap = new HashMap();
        if (popularRecentDataItem.getName() != null) {
            Map map = hashMap;
            String name = popularRecentDataItem.getName();
            if (name != null) {
                map.put("event_label", name);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        if (str != null) {
            map2.put("event_label2", str);
            map2.put("event_label3", Integer.valueOf(i2));
            map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, "Popular");
            c.b().a("customEvent", "HomePage", "hotels_home", "suggest_selected", map2);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    public final void trendingRecentOnItemClick(Object obj, int i2, String str) {
        k.c(obj, "selectedRowData");
        k.c(str, "searchInput");
        Intent intent = new Intent();
        intent.putExtra("localitySearchType", "trendingSearch");
        if (obj instanceof AutoSearchDataItem) {
            autoSuggestOnItemClick((AutoSearchDataItem) obj, i2, str);
            return;
        }
        if (obj instanceof PopularRecentDataItem) {
            sendPulseEventHotelPopularRecentOnItemClick((PopularRecentDataItem) obj, i2, str);
            intent.putExtra("selected_data_popular", (Serializable) obj);
        }
        setResult(-1, intent);
        finish();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        o oVar = this.mHotelSearch;
        if (oVar == null) {
            k.a("mHotelSearch");
        }
        if (oVar != null) {
            oVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 115) {
            o oVar = this.mHotelSearch;
            if (oVar == null) {
                k.a("mHotelSearch");
            }
            oVar.onActivityResult(i2, i3, intent);
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        a.a(context);
        a.b(context);
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        if (c.a() == null) {
            CJRHotelsUtilsLib.a(context);
        }
        super.attachBaseContext(context);
        Context context2 = this;
        a.b(context2);
        a.a(context2);
    }
}
