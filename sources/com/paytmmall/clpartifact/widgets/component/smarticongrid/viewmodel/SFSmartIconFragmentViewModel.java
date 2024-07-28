package com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.paytmmall.clpartifact.widgets.component.NavigatorDataModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class SFSmartIconFragmentViewModel extends a {
    private Application applicationInstance;
    private ArrayList<GroupGridLayoutDataModel> finalList = new ArrayList<>();
    public ArrayList<String> iconViewIds;
    private ArrayList<View> iconViewList = new ArrayList<>();
    private y<NavigatorDataModel> navigatorLiveData = new y<>();
    private SmartIconGridRepository repository = new SmartIconGridRepository();
    public ArrayList<String> tickerViewIds;
    private ArrayList<View> tickerViewList = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SFSmartIconFragmentViewModel(Application application) {
        super(application);
        k.c(application, "applicationInstance");
        this.applicationInstance = application;
    }

    public final Application getApplicationInstance() {
        return this.applicationInstance;
    }

    public final void setApplicationInstance(Application application) {
        k.c(application, "<set-?>");
        this.applicationInstance = application;
    }

    public final SmartIconGridRepository getRepository() {
        return this.repository;
    }

    public final void setRepository(SmartIconGridRepository smartIconGridRepository) {
        k.c(smartIconGridRepository, "<set-?>");
        this.repository = smartIconGridRepository;
    }

    public final ArrayList<String> getIconViewIds() {
        ArrayList<String> arrayList = this.iconViewIds;
        if (arrayList == null) {
            k.a("iconViewIds");
        }
        return arrayList;
    }

    public final void setIconViewIds(ArrayList<String> arrayList) {
        k.c(arrayList, "<set-?>");
        this.iconViewIds = arrayList;
    }

    public final ArrayList<String> getTickerViewIds() {
        ArrayList<String> arrayList = this.tickerViewIds;
        if (arrayList == null) {
            k.a("tickerViewIds");
        }
        return arrayList;
    }

    public final void setTickerViewIds(ArrayList<String> arrayList) {
        k.c(arrayList, "<set-?>");
        this.tickerViewIds = arrayList;
    }

    public final y<NavigatorDataModel> getNavigatorLiveData() {
        return this.navigatorLiveData;
    }

    public final void setNavigatorLiveData(y<NavigatorDataModel> yVar) {
        k.c(yVar, "<set-?>");
        this.navigatorLiveData = yVar;
    }

    public final LiveData<List<GroupGridLayoutDataModel>> loadData() {
        w wVar = new w();
        SmartIconGridRepository smartIconGridRepository = this.repository;
        Context applicationContext = this.applicationInstance.getApplicationContext();
        k.a((Object) applicationContext, "applicationInstance.applicationContext");
        wVar.addSource(SmartIconGridRepository.loadData$default(smartIconGridRepository, applicationContext, false, 2, (Object) null), new SFSmartIconFragmentViewModel$loadData$1(this, wVar));
        return wVar;
    }

    public final void handleApiResponse(HomeResponse homeResponse, w<List<GroupGridLayoutDataModel>> wVar) {
        k.c(wVar, "liveData");
        ArrayList<View> layoutList = getLayoutList(homeResponse);
        if (layoutList != null) {
            ArrayList<View> conbineGroupList = conbineGroupList(layoutList);
            Collection collection = conbineGroupList;
            if (!(collection == null || collection.isEmpty())) {
                this.finalList.clear();
                this.finalList.addAll(getFinalLayout(conbineGroupList, 9));
            }
            wVar.setValue(new ArrayList(this.finalList));
            this.navigatorLiveData.setValue(new NavigatorDataModel(101, conbineGroupList));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.View> */");
    }

    private final ArrayList<View> getLayoutList(HomeResponse homeResponse) {
        List<Page> page = homeResponse != null ? homeResponse.getPage() : null;
        ArrayList<View> arrayList = new ArrayList<>();
        if (page != null) {
            for (Page next : page) {
                k.a((Object) next, "item");
                arrayList.add(next.getViews().get(0));
            }
        }
        return arrayList;
    }

    private final ArrayList<View> makeMainList(ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            k.a();
        }
        Iterator<View> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next());
        }
        return arrayList2;
    }

    private final ArrayList<View> conbineGroupList(ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = this.iconViewIds;
        if (arrayList3 == null) {
            k.a("iconViewIds");
        }
        int size = arrayList3.size();
        for (int i2 = 0; i2 < size; i2++) {
            Iterator<View> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                View next = it2.next();
                k.a((Object) next, "item");
                Long id = next.getId();
                ArrayList<String> arrayList4 = this.iconViewIds;
                if (arrayList4 == null) {
                    k.a("iconViewIds");
                }
                String str = arrayList4.get(i2);
                k.a((Object) str, "iconViewIds[i]");
                long parseLong = Long.parseLong(str);
                if (id != null && id.longValue() == parseLong) {
                    this.iconViewList.add(next);
                    arrayList2.add(next);
                }
            }
        }
        ArrayList<String> arrayList5 = this.tickerViewIds;
        if (arrayList5 == null) {
            k.a("tickerViewIds");
        }
        int size2 = arrayList5.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Iterator<View> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                View next2 = it3.next();
                k.a((Object) next2, "item");
                Long id2 = next2.getId();
                ArrayList<String> arrayList6 = this.tickerViewIds;
                if (arrayList6 == null) {
                    k.a("tickerViewIds");
                }
                String str2 = arrayList6.get(i3);
                k.a((Object) str2, "tickerViewIds[i]");
                long parseLong2 = Long.parseLong(str2);
                if (id2 != null && id2.longValue() == parseLong2) {
                    this.tickerViewList.add(next2);
                }
            }
        }
        if (this.iconViewList.size() > this.tickerViewList.size()) {
            int size3 = this.iconViewList.size();
            for (int size4 = this.tickerViewList.size(); size4 < size3; size4++) {
                this.tickerViewList.add(new View());
            }
        }
        return arrayList2;
    }

    private final ArrayList<GroupGridLayoutDataModel> getFinalLayout(ArrayList<View> arrayList, int i2) {
        Item item;
        ArrayList<GroupGridLayoutDataModel> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        GroupGridLayoutDataModel groupGridLayoutDataModel = null;
        int i3 = 0;
        while (i3 < size) {
            View view = arrayList.get(i3);
            k.a((Object) view, "itemsList[n]");
            int size2 = view.getItems().size();
            GroupGridLayoutDataModel groupGridLayoutDataModel2 = groupGridLayoutDataModel;
            int i4 = 1;
            for (int i5 = 0; i5 < size2; i5++) {
                if (i5 % i2 == 0) {
                    View view2 = arrayList.get(i3);
                    k.a((Object) view2, "itemsList[n]");
                    String title = view2.getTitle();
                    k.a((Object) title, "itemsList[n].title");
                    View view3 = this.tickerViewList.get(i3);
                    k.a((Object) view3, "tickerViewList[n]");
                    Collection items = view3.getItems();
                    if (items == null || items.isEmpty()) {
                        item = new Item();
                    } else {
                        View view4 = this.tickerViewList.get(i3);
                        k.a((Object) view4, "tickerViewList[n]");
                        item = view4.getItems().get(0);
                    }
                    k.a((Object) item, "if (tickerViewList[n].it…ickerViewList[n].items[0]");
                    GroupGridLayoutDataModel groupGridLayoutDataModel3 = new GroupGridLayoutDataModel(title, item, i4, new ArrayList());
                    arrayList2.add(groupGridLayoutDataModel3);
                    i4++;
                    groupGridLayoutDataModel2 = groupGridLayoutDataModel3;
                }
                if (groupGridLayoutDataModel2 == null) {
                    k.a("groupGridLayoutModel");
                }
                ArrayList<Item> mGridItemlist = groupGridLayoutDataModel2.getMGridItemlist();
                View view5 = arrayList.get(i3);
                k.a((Object) view5, "itemsList[n]");
                mGridItemlist.add(view5.getItems().get(i5));
            }
            i3++;
            groupGridLayoutDataModel = groupGridLayoutDataModel2;
        }
        return arrayList2;
    }

    public final w<List<GroupGridLayoutDataModel>> handleApiResponse(HomeResponse homeResponse) {
        k.c(homeResponse, Payload.RESPONSE);
        w<List<GroupGridLayoutDataModel>> wVar = new w<>();
        handleApiResponse(homeResponse, wVar);
        return wVar;
    }
}
