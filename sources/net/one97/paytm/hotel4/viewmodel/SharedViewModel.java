package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.ScreenNavigationInfo;
import net.one97.paytm.hotel4.service.model.datamodel.HotelConfig;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FiltersItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.utils.c;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SharedViewModel extends ai {
    private String TAG_LOG = "SharedViewModel";
    private Context context;
    private String deepLinkData = "";
    private String filterHotelChainString = "";
    private String filterHotelThemeString = "";
    private List<FiltersItem> filterItemList = new ArrayList();
    private String filterLocalityString = "";
    private y<ScreenNavigationInfo> fragmentIndexToLoad;
    public HotelConfig hotelConfig;
    private boolean isFromFilterAvailableApiCall;
    private y<Boolean> isFromRoomSelection;
    private boolean isHotelSoldOut;
    private boolean isSRPReload;
    private CJRHotelSearchInput searchInput = new CJRHotelSearchInput();
    private HotelSearchResponse searchResponse = new HotelSearchResponse();
    private CJRHotelSearchInput searchTemporaryInput;
    private HashMap<String, ArrayList<String>> selectedSRPFilter = new HashMap<>();

    public final void SharedViewModel() {
    }

    public SharedViewModel() {
        y<Boolean> yVar = new y<>();
        yVar.postValue(Boolean.FALSE);
        this.isFromRoomSelection = yVar;
        this.fragmentIndexToLoad = new y<>();
    }

    public final String getTAG_LOG() {
        return this.TAG_LOG;
    }

    public final void setTAG_LOG(String str) {
        k.c(str, "<set-?>");
        this.TAG_LOG = str;
    }

    public final String getFilterLocalityString() {
        return this.filterLocalityString;
    }

    public final void setFilterLocalityString(String str) {
        this.filterLocalityString = str;
    }

    public final String getFilterHotelChainString() {
        return this.filterHotelChainString;
    }

    public final void setFilterHotelChainString(String str) {
        this.filterHotelChainString = str;
    }

    public final String getFilterHotelThemeString() {
        return this.filterHotelThemeString;
    }

    public final void setFilterHotelThemeString(String str) {
        this.filterHotelThemeString = str;
    }

    public final HashMap<String, ArrayList<String>> getSelectedSRPFilter() {
        return this.selectedSRPFilter;
    }

    public final void setSelectedSRPFilter(HashMap<String, ArrayList<String>> hashMap) {
        k.c(hashMap, "<set-?>");
        this.selectedSRPFilter = hashMap;
    }

    public final CJRHotelSearchInput getSearchInput() {
        return this.searchInput;
    }

    public final void setSearchInput(CJRHotelSearchInput cJRHotelSearchInput) {
        this.searchInput = cJRHotelSearchInput;
    }

    public final CJRHotelSearchInput getSearchTemporaryInput() {
        return this.searchTemporaryInput;
    }

    public final void setSearchTemporaryInput(CJRHotelSearchInput cJRHotelSearchInput) {
        this.searchTemporaryInput = cJRHotelSearchInput;
    }

    public final HotelConfig getHotelConfig() {
        HotelConfig hotelConfig2 = this.hotelConfig;
        if (hotelConfig2 == null) {
            k.a("hotelConfig");
        }
        return hotelConfig2;
    }

    public final void setHotelConfig(HotelConfig hotelConfig2) {
        k.c(hotelConfig2, "<set-?>");
        this.hotelConfig = hotelConfig2;
    }

    public final HotelSearchResponse getSearchResponse() {
        return this.searchResponse;
    }

    public final void setSearchResponse(HotelSearchResponse hotelSearchResponse) {
        this.searchResponse = hotelSearchResponse;
    }

    public final String getDeepLinkData() {
        return this.deepLinkData;
    }

    public final void setDeepLinkData(String str) {
        this.deepLinkData = str;
    }

    public final boolean isSRPReload() {
        return this.isSRPReload;
    }

    public final void setSRPReload(boolean z) {
        this.isSRPReload = z;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final boolean isHotelSoldOut() {
        return this.isHotelSoldOut;
    }

    public final void setHotelSoldOut(boolean z) {
        this.isHotelSoldOut = z;
    }

    public final boolean isFromFilterAvailableApiCall() {
        return this.isFromFilterAvailableApiCall;
    }

    public final void setFromFilterAvailableApiCall(boolean z) {
        this.isFromFilterAvailableApiCall = z;
    }

    public final List<FiltersItem> getFilterItemList() {
        return this.filterItemList;
    }

    public final void setFilterItemList(List<FiltersItem> list) {
        this.filterItemList = list;
    }

    public final y<Boolean> isFromRoomSelection() {
        return this.isFromRoomSelection;
    }

    public final void setFromRoomSelection(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isFromRoomSelection = yVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r3 = r3.getExtra();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSearchResponse(net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x003a
            r2.searchResponse = r3
            boolean r3 = r2.isFromFilterAvailableApiCall
            if (r3 != 0) goto L_0x0041
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r3 = r2.searchResponse
            r0 = 0
            if (r3 == 0) goto L_0x0018
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r3 = r3.getExtra()
            if (r3 == 0) goto L_0x0018
            java.util.List r3 = r3.getFilters()
            goto L_0x0019
        L_0x0018:
            r3 = r0
        L_0x0019:
            if (r3 == 0) goto L_0x0041
            java.util.ArrayList r3 = new java.util.ArrayList
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r1 = r2.searchResponse
            if (r1 == 0) goto L_0x002b
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r1 = r1.getExtra()
            if (r1 == 0) goto L_0x002b
            java.util.List r0 = r1.getFilters()
        L_0x002b:
            if (r0 != 0) goto L_0x0030
            kotlin.g.b.k.a()
        L_0x0030:
            java.util.Collection r0 = (java.util.Collection) r0
            r3.<init>(r0)
            java.util.List r3 = (java.util.List) r3
            r2.filterItemList = r3
            return
        L_0x003a:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r3 = new net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse
            r3.<init>()
            r2.searchResponse = r3
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SharedViewModel.updateSearchResponse(net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse):void");
    }

    public final void updateSearchInput(CJRHotelSearchInput cJRHotelSearchInput) {
        this.searchInput = cJRHotelSearchInput;
    }

    public final y<ScreenNavigationInfo> getFragmentIndexToLoad() {
        return this.fragmentIndexToLoad;
    }

    public final void setFragmentIndexToLoad(y<ScreenNavigationInfo> yVar) {
        k.c(yVar, "<set-?>");
        this.fragmentIndexToLoad = yVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016f, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0172, code lost:
        if (r0 == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0174, code lost:
        r5.fragmentIndexToLoad.postValue(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0179, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0197, code lost:
        throw new java.lang.RuntimeException("Invalid navigation Request " + r6 + " to " + r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void postScreenNavigationEvent(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "from"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "to"
            kotlin.g.b.k.c(r7, r0)
            int r0 = r7.hashCode()
            java.lang.String r1 = "5"
            java.lang.String r2 = "8"
            r3 = 0
            r4 = 1
            switch(r0) {
                case 50: goto L_0x0162;
                case 51: goto L_0x0154;
                case 52: goto L_0x0146;
                case 53: goto L_0x013a;
                case 54: goto L_0x012c;
                case 55: goto L_0x011e;
                case 56: goto L_0x0112;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r0) {
                case 1568: goto L_0x0104;
                case 1600: goto L_0x00f5;
                case 1632: goto L_0x00e6;
                case 1664: goto L_0x00d7;
                case 1696: goto L_0x00c8;
                case 1728: goto L_0x00b9;
                case 1760: goto L_0x00a8;
                case 48657: goto L_0x0097;
                case 50643: goto L_0x0086;
                case 51636: goto L_0x0075;
                case 53622: goto L_0x0064;
                case 1477632: goto L_0x0053;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r0) {
                case 1508416: goto L_0x0042;
                case 1508417: goto L_0x0031;
                case 1508418: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0171
        L_0x0020:
            java.lang.String r0 = "1113"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "1113"
            r0.<init>(r6, r1, r4)
            goto L_0x0172
        L_0x0031:
            java.lang.String r0 = "1112"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "1112"
            r0.<init>(r6, r1, r4)
            goto L_0x0172
        L_0x0042:
            java.lang.String r0 = "1111"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "1111"
            r0.<init>(r2, r1, r4)
            goto L_0x0172
        L_0x0053:
            java.lang.String r0 = "0000"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "0000"
            r0.<init>(r6, r1, r4)
            goto L_0x0172
        L_0x0064:
            java.lang.String r0 = "666"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "666"
            r0.<init>(r6, r1, r3)
            goto L_0x0172
        L_0x0075:
            java.lang.String r0 = "444"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "444"
            r0.<init>(r2, r1, r4)
            goto L_0x0172
        L_0x0086:
            java.lang.String r0 = "333"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r2 = "333"
            r0.<init>(r1, r2, r4)
            goto L_0x0172
        L_0x0097:
            java.lang.String r0 = "111"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "111"
            r0.<init>(r6, r1, r3)
            goto L_0x0172
        L_0x00a8:
            java.lang.String r0 = "77"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            java.lang.String r1 = "77"
            r0.<init>(r6, r1, r3)
            goto L_0x0172
        L_0x00b9:
            java.lang.String r0 = "66"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x00c8:
            java.lang.String r0 = "55"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x00d7:
            java.lang.String r0 = "44"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x00e6:
            java.lang.String r0 = "33"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r4)
            goto L_0x016f
        L_0x00f5:
            java.lang.String r0 = "22"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x0104:
            java.lang.String r0 = "11"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x0112:
            boolean r0 = r7.equals(r2)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r0.<init>(r6, r2, r4)
            goto L_0x0172
        L_0x011e:
            java.lang.String r0 = "7"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r4)
            goto L_0x016f
        L_0x012c:
            java.lang.String r0 = "6"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r4)
            goto L_0x016f
        L_0x013a:
            boolean r0 = r7.equals(r1)
            if (r0 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r0 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r0.<init>(r6, r1, r4)
            goto L_0x0172
        L_0x0146:
            java.lang.String r0 = "4"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x0154:
            java.lang.String r0 = "3"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r3)
            goto L_0x016f
        L_0x0162:
            java.lang.String r0 = "2"
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L_0x0171
            net.one97.paytm.hotel4.service.model.ScreenNavigationInfo r1 = new net.one97.paytm.hotel4.service.model.ScreenNavigationInfo
            r1.<init>(r6, r0, r4)
        L_0x016f:
            r0 = r1
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            if (r0 == 0) goto L_0x017a
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.ScreenNavigationInfo> r6 = r5.fragmentIndexToLoad
            r6.postValue(r0)
            return
        L_0x017a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid navigation Request "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = " to "
            r1.append(r6)
            r1.append(r7)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SharedViewModel.postScreenNavigationEvent(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getExtra();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem> getSRPSortData() {
        /*
            r5 = this;
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r0 = r5.searchResponse
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r0 = r0.getExtra()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getSelectedSortingParam()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0074
            r0 = 0
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r2 = r5.searchResponse
            if (r2 == 0) goto L_0x0023
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r2 = r2.getExtra()
            if (r2 == 0) goto L_0x0023
            java.util.List r2 = r2.getSortKeys()
            goto L_0x0024
        L_0x0023:
            r2 = r1
        L_0x0024:
            if (r2 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x002f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0074
            java.lang.Object r3 = r2.next()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r3 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem) r3
            java.lang.String r3 = r3.getDefault()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r4 = r5.searchResponse
            if (r4 == 0) goto L_0x004e
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r4 = r4.getExtra()
            if (r4 == 0) goto L_0x004e
            java.lang.String r4 = r4.getSelectedSortingParam()
            goto L_0x004f
        L_0x004e:
            r4 = r1
        L_0x004f:
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0071
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r3 = r5.searchResponse
            if (r3 == 0) goto L_0x0071
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r3 = r3.getExtra()
            if (r3 == 0) goto L_0x0071
            java.util.List r3 = r3.getSortKeys()
            if (r3 == 0) goto L_0x0071
            java.lang.Object r3 = r3.get(r0)
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r3 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem) r3
            if (r3 == 0) goto L_0x0071
            r4 = 1
            r3.setSelected(r4)
        L_0x0071:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x0074:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse r0 = r5.searchResponse
            if (r0 == 0) goto L_0x0083
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.Extra r0 = r0.getExtra()
            if (r0 == 0) goto L_0x0083
            java.util.List r0 = r0.getSortKeys()
            return r0
        L_0x0083:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SharedViewModel.getSRPSortData():java.util.List");
    }

    public final List<FiltersItem> getSRPFilters() {
        return this.filterItemList;
    }

    public final void getDataFromIntent(Intent intent) {
        k.c(intent, "data");
        if (intent.hasExtra("hotels_search_input")) {
            Serializable serializableExtra = intent.getSerializableExtra("hotels_search_input");
            if (serializableExtra != null) {
                updateSearchInput((CJRHotelSearchInput) serializableExtra);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.hotels2.entity.CJRHotelSearchInput");
            }
        }
        if (intent.hasExtra("hotels_search_input")) {
            Serializable serializableExtra2 = intent.getSerializableExtra("hotel-checkin-config");
            if (serializableExtra2 != null) {
                this.hotelConfig = (HotelConfig) serializableExtra2;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.datamodel.HotelConfig");
            }
        }
        c.a aVar = c.f28638a;
        if (intent.hasExtra(c.f28639b)) {
            c.a aVar2 = c.f28638a;
            this.deepLinkData = intent.getStringExtra(c.f28639b);
            updateDeepLinkFilter();
            return;
        }
        this.deepLinkData = "";
    }

    public final int getAppliedFilterCount() {
        HashMap<String, ArrayList<String>> hashMap = this.selectedSRPFilter;
        return (hashMap != null ? Integer.valueOf(hashMap.size()) : null).intValue();
    }

    public final void resetSelectedFilter() {
        this.selectedSRPFilter = new HashMap<>();
    }

    public final List<String> getFormattedDate(String str) {
        String format = new SimpleDateFormat("EEEE,MMMM,dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        k.a((Object) format, "checkInStr");
        return p.a((CharSequence) format, new String[]{AppConstants.COMMA});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010c, code lost:
        r0 = r9.searchInput;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010e, code lost:
        if (r0 != null) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0110, code lost:
        r0.setAdultCount(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0113, code lost:
        r0 = r9.searchInput;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        if (r0 != null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
        r0.setChildCount(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011a, code lost:
        r0 = r9.searchInput;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011c, code lost:
        if (r0 == null) goto L_0x011e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00fc */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0164 A[Catch:{ Exception -> 0x0186 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateDeepLinkFilter() {
        /*
            r9 = this;
            java.lang.String r0 = r9.deepLinkData     // Catch:{ Exception -> 0x0186 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x018e
            java.lang.String r0 = r9.deepLinkData     // Catch:{ Exception -> 0x0186 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r1 = "filter_params"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x003b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0186 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0186 }
            java.util.Iterator r0 = r1.keys()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = "obj.keys()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0186 }
        L_0x0026:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0186 }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0186 }
            if (r2 != 0) goto L_0x0037
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0037:
            r9.updateSelectedFilterAsPerDeeplink(r2, r1)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0026
        L_0x003b:
            java.lang.String r0 = r9.deepLinkData     // Catch:{ Exception -> 0x0186 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r1 = "numRooms"
            java.lang.String r1 = r0.getQueryParameter(r1)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r2 = "numAdults"
            java.lang.String r2 = r0.getQueryParameter(r2)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r3 = "numKids"
            java.lang.String r3 = r0.getQueryParameter(r3)     // Catch:{ Exception -> 0x0186 }
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0186 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0186 }
            r5 = 0
            if (r4 != 0) goto L_0x00b9
            if (r1 != 0) goto L_0x0062
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0062:
            int r4 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0186 }
            if (r4 <= 0) goto L_0x00b9
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0186 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0186 }
            if (r4 != 0) goto L_0x00b9
            if (r2 != 0) goto L_0x0076
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0076:
            int r4 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0186 }
            int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0186 }
            if (r4 < r6) goto L_0x00b9
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0092
            if (r3 != 0) goto L_0x008e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x008e:
            int r5 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0186 }
        L_0x0092:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x009d
            int r3 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0186 }
            r0.setAdultCount(r3)     // Catch:{ Exception -> 0x0186 }
        L_0x009d:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x00a4
            r0.setChildCount(r5)     // Catch:{ Exception -> 0x0186 }
        L_0x00a4:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x014e
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0186 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0186 }
            java.util.ArrayList r1 = r9.getRoomDetails(r1, r2, r5)     // Catch:{ Exception -> 0x0186 }
            r0.setRooms(r1)     // Catch:{ Exception -> 0x0186 }
            goto L_0x014e
        L_0x00b9:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0186 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0186 }
            r6 = 1
            if (r4 != 0) goto L_0x011f
            if (r1 != 0) goto L_0x00c8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00fc }
        L_0x00c8:
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x00fc }
            if (r1 <= 0) goto L_0x014e
            java.lang.String r1 = "rooms_details"
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch:{ Exception -> 0x00fc }
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00fc }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00fc }
            if (r1 != 0) goto L_0x014e
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r9.searchInput     // Catch:{ Exception -> 0x00fc }
            if (r1 == 0) goto L_0x00f8
            com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x00fc }
            r4.<init>()     // Catch:{ Exception -> 0x00fc }
            net.one97.paytm.hotel4.viewmodel.SharedViewModel$updateDeepLinkFilter$2 r7 = new net.one97.paytm.hotel4.viewmodel.SharedViewModel$updateDeepLinkFilter$2     // Catch:{ Exception -> 0x00fc }
            r7.<init>()     // Catch:{ Exception -> 0x00fc }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x00fc }
            java.lang.Object r0 = r4.a((java.lang.String) r0, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x00fc }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x00fc }
            r1.setRooms(r0)     // Catch:{ Exception -> 0x00fc }
        L_0x00f8:
            r9.setAdultAndChildCount()     // Catch:{ Exception -> 0x00fc }
            goto L_0x014e
        L_0x00fc:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x014e
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x014e
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x0113
            r0.setAdultCount(r6)     // Catch:{ Exception -> 0x0186 }
        L_0x0113:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x011a
            r0.setChildCount(r5)     // Catch:{ Exception -> 0x0186 }
        L_0x011a:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0147
            goto L_0x014e
        L_0x011f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x014e
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x014e
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0136
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0136:
            r0.setAdultCount(r6)     // Catch:{ Exception -> 0x0186 }
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 == 0) goto L_0x0140
            r0.setChildCount(r5)     // Catch:{ Exception -> 0x0186 }
        L_0x0140:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0147
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0147:
            java.util.ArrayList r1 = r9.getRoomDetails(r6, r6, r5)     // Catch:{ Exception -> 0x0186 }
            r0.setRooms(r1)     // Catch:{ Exception -> 0x0186 }
        L_0x014e:
            java.lang.String r0 = r9.deepLinkData     // Catch:{ Exception -> 0x0186 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0186 }
            java.lang.String r1 = "sort_by"
            java.lang.String r3 = r0.getQueryParameter(r1)     // Catch:{ Exception -> 0x0186 }
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0186 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x0181
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r9.searchInput     // Catch:{ Exception -> 0x0186 }
            if (r0 != 0) goto L_0x016b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x016b:
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem r1 = new net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem     // Catch:{ Exception -> 0x0186 }
            if (r3 != 0) goto L_0x0172
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0186 }
        L_0x0172:
            r4 = 0
            java.lang.String r5 = "sort_by"
            r6 = 0
            r7 = 10
            r8 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0186 }
            r0.setSortBy(r1)     // Catch:{ Exception -> 0x0186 }
        L_0x0181:
            java.lang.String r0 = ""
            r9.deepLinkData = r0     // Catch:{ Exception -> 0x0186 }
            return
        L_0x0186:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SharedViewModel.updateDeepLinkFilter():void");
    }

    private final void updateSelectedFilterAsPerDeeplink(String str, JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int i2 = 0;
            int length = jSONArray.length();
            while (i2 < length) {
                Object obj = jSONArray.get(i2);
                if (obj != null) {
                    arrayList.add((String) obj);
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            this.selectedSRPFilter.put(str, arrayList);
        } catch (Exception unused) {
        }
    }

    public final ArrayList<CJRRoom> getRoomDetails(int i2, int i3, int i4) {
        ArrayList<CJRRoom> arrayList = new ArrayList<>();
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        while (i5 != 0) {
            double d2 = (double) i5;
            int ceil = (int) Math.ceil(((double) i6) / d2);
            int ceil2 = (int) Math.ceil(((double) i7) / d2);
            int i8 = i5;
            CJRRoom cJRRoom = r6;
            CJRRoom cJRRoom2 = new CJRRoom(0, 0, 0, (ArrayList) null, (String) null, (String) null, (String) null, 127, (g) null);
            cJRRoom.setAdultCount(ceil);
            cJRRoom.setChildrenCount(ceil2);
            if (ceil2 > 0) {
                cJRRoom.setChildrenAges(new ArrayList());
                for (int i9 = 0; i9 < ceil2; i9++) {
                    ArrayList<Integer> childrenAges = cJRRoom.getChildrenAges();
                    if (childrenAges != null) {
                        childrenAges.add(5);
                    }
                }
            } else {
                cJRRoom.setChildrenAges(new ArrayList());
            }
            arrayList.add(cJRRoom);
            i6 -= ceil;
            i7 -= ceil2;
            i5 = i8 - 1;
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAdultAndChildCount() {
        /*
            r5 = this;
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList r0 = r0.getRooms()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 0
            if (r0 == 0) goto L_0x004d
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x0016
            java.util.ArrayList r1 = r0.getRooms()
        L_0x0016:
            if (r1 != 0) goto L_0x001b
            kotlin.g.b.k.a()
        L_0x001b:
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x004d
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            java.util.ArrayList r0 = r0.getRooms()
            if (r0 != 0) goto L_0x0031
            kotlin.g.b.k.a()
        L_0x0031:
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0036:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004e
            java.lang.Object r3 = r0.next()
            net.one97.paytm.hotel4.service.model.details.CJRRoom r3 = (net.one97.paytm.hotel4.service.model.details.CJRRoom) r3
            int r4 = r3.getAdultCount()
            int r2 = r2 + r4
            int r3 = r3.getChildrenCount()
            int r1 = r1 + r3
            goto L_0x0036
        L_0x004d:
            r1 = 0
        L_0x004e:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x0055
            r0.setAdultCount(r2)
        L_0x0055:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x005c
            r0.setChildCount(r1)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SharedViewModel.setAdultAndChildCount():void");
    }
}
