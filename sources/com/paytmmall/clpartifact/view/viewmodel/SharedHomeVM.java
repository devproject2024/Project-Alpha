package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.graphics.Point;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class SharedHomeVM extends a {
    public static final int ANIMATE_FLOATING_NAV = ANIMATE_FLOATING_NAV;
    public static final Companion Companion = new Companion((g) null);
    public static final int GET_NAV_POSITION = GET_NAV_POSITION;
    public static final int INITKYCFORNAME = INITKYCFORNAME;
    public static final int OPEN_LEFT = 1004;
    /* access modifiers changed from: private */
    public static final int OPEN_SEARCH = 1003;
    /* access modifiers changed from: private */
    public static final int RUNTIME_PAYTMLOGO_ANIMATION = 1010;
    public static final int SCAN_CLICK = 1006;
    /* access modifiers changed from: private */
    public static final int SCROLL_TO_TOP = 1002;
    public static final int SEARCH_SCREEN = 1007;
    /* access modifiers changed from: private */
    public static final int SETIMAGE = 1012;
    /* access modifiers changed from: private */
    public static final int SETPROFILE_NAMEINTOOLBAR = 1011;
    /* access modifiers changed from: private */
    public static final int SETSEC_NAME = SETSEC_NAME;
    public static final int SET_NAME = 1009;
    public static final int SET_NAV_POSITION = SET_NAV_POSITION;
    public static final int SHOW_POPUP = 1005;
    public static final int UPDATE_CATEGORY_MAPS = 1001;
    public static final int UPDATE_NON_RV_WIDGETS = UPDATE_NON_RV_WIDGETS;
    public static final int UPDATE_NOTIFICATION_ICON = UPDATE_NOTIFICATION_ICON;
    public static final int UPDATE_SCREEN = 1008;
    /* access modifiers changed from: private */
    public static final int USER_GREETINGS = USER_GREETINGS;
    private final SingleEventLiveData<HomeParentActionModel> actionLiveData = new SingleEventLiveData<>();
    private final y<Boolean> isScanBtnVisible = new y<>();
    private final LiveData<HomeParentActionModel> parentActionLiveData = new SingleEventLiveData();

    public final void runAnimationAndDisplayGreeting() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedHomeVM(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getSCROLL_TO_TOP() {
            return SharedHomeVM.SCROLL_TO_TOP;
        }

        public final int getOPEN_SEARCH() {
            return SharedHomeVM.OPEN_SEARCH;
        }

        public final int getRUNTIME_PAYTMLOGO_ANIMATION() {
            return SharedHomeVM.RUNTIME_PAYTMLOGO_ANIMATION;
        }

        public final int getSETPROFILE_NAMEINTOOLBAR() {
            return SharedHomeVM.SETPROFILE_NAMEINTOOLBAR;
        }

        public final int getSETIMAGE() {
            return SharedHomeVM.SETIMAGE;
        }

        public final int getSETSEC_NAME() {
            return SharedHomeVM.SETSEC_NAME;
        }

        public final int getUSER_GREETINGS() {
            return SharedHomeVM.USER_GREETINGS;
        }
    }

    public final y<Boolean> isScanBtnVisible() {
        return this.isScanBtnVisible;
    }

    public final SingleEventLiveData<HomeParentActionModel> getActionLiveData() {
        return this.actionLiveData;
    }

    public final LiveData<HomeParentActionModel> getParentActionLiveData() {
        return this.parentActionLiveData;
    }

    public final void scrollToTop() {
        this.actionLiveData.setValue(new HomeParentActionModel(SCROLL_TO_TOP, new HashMap()));
    }

    public final void setName() {
        this.actionLiveData.setValue(new HomeParentActionModel(SET_NAME, new HashMap()));
    }

    public final void addCategoryUrlMap(HomeParentActionModel homeParentActionModel) {
        k.c(homeParentActionModel, "actionModel");
        LiveData<HomeParentActionModel> liveData = this.parentActionLiveData;
        if (liveData != null) {
            ((y) liveData).postValue(homeParentActionModel);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
    }

    public final void openScanScreen(HomeParentActionModel homeParentActionModel) {
        k.c(homeParentActionModel, "actionModel");
        LiveData<HomeParentActionModel> liveData = this.parentActionLiveData;
        if (liveData != null) {
            ((y) liveData).postValue(homeParentActionModel);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
    }

    public final void updateWidgetDetails(HomeParentActionModel homeParentActionModel) {
        k.c(homeParentActionModel, "actionModel");
        LiveData<HomeParentActionModel> liveData = this.parentActionLiveData;
        if (liveData != null) {
            ((y) liveData).setValue(homeParentActionModel);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
    }

    public final void setProfileNameOverToolBar() {
        this.actionLiveData.setValue(new HomeParentActionModel(SETPROFILE_NAMEINTOOLBAR, new HashMap()));
    }

    public final void getSecondaryUserName() {
        this.actionLiveData.setValue(new HomeParentActionModel(SETSEC_NAME, new HashMap()));
    }

    public final void setUserGreeting(String str, boolean z) {
        k.c(str, "profileName");
        Map hashMap = new HashMap();
        hashMap.put(CLPConstants.PROFILE_NAME, str);
        hashMap.put(CLPConstants.IS_CAMEL_CASING, Boolean.valueOf(z));
        this.actionLiveData.setValue(new HomeParentActionModel(USER_GREETINGS, hashMap));
    }

    public final void setNotificationData(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.FLAG_NOTIFICATIONS_UNREAD_COUNT, Integer.valueOf(i2));
        this.actionLiveData.setValue(new HomeParentActionModel(UPDATE_NOTIFICATION_ICON, hashMap));
    }

    public final void setActionImage() {
        this.actionLiveData.setValue(new HomeParentActionModel(SETIMAGE, new HashMap()));
    }

    public final void addPopupProvider(HomeParentActionModel homeParentActionModel) {
        k.c(homeParentActionModel, "homeParenActionModel");
        LiveData<HomeParentActionModel> liveData = this.parentActionLiveData;
        if (liveData != null) {
            ((y) liveData).setValue(homeParentActionModel);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
    }

    public final void animateFloatingView(String str) {
        k.c(str, "key");
        SingleEventLiveData<HomeParentActionModel> singleEventLiveData = this.actionLiveData;
        int i2 = ANIMATE_FLOATING_NAV;
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.FLOATING_NAV_KEY, str);
        singleEventLiveData.setValue(new HomeParentActionModel(i2, hashMap));
    }

    public final void getAnimationPoint(String str) {
        k.c(str, "key");
        SingleEventLiveData<HomeParentActionModel> singleEventLiveData = this.actionLiveData;
        int i2 = GET_NAV_POSITION;
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.FLOATING_NAV_KEY, str);
        singleEventLiveData.setValue(new HomeParentActionModel(i2, hashMap));
    }

    public final void setAnimationPoint(Point point) {
        k.c(point, "point");
        LiveData<HomeParentActionModel> liveData = this.parentActionLiveData;
        if (liveData != null) {
            int i2 = SET_NAV_POSITION;
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.FLOATING_NAV_POINT, point);
            ((y) liveData).setValue(new HomeParentActionModel(i2, hashMap));
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
    }
}
