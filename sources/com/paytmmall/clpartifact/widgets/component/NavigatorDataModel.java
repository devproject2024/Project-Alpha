package com.paytmmall.clpartifact.widgets.component;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class NavigatorDataModel {
    private final List<View> groupList;
    private final int request;

    public static /* synthetic */ NavigatorDataModel copy$default(NavigatorDataModel navigatorDataModel, int i2, List<View> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = navigatorDataModel.request;
        }
        if ((i3 & 2) != 0) {
            list = navigatorDataModel.groupList;
        }
        return navigatorDataModel.copy(i2, list);
    }

    public final int component1() {
        return this.request;
    }

    public final List<View> component2() {
        return this.groupList;
    }

    public final NavigatorDataModel copy(int i2, List<? extends View> list) {
        return new NavigatorDataModel(i2, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NavigatorDataModel) {
                NavigatorDataModel navigatorDataModel = (NavigatorDataModel) obj;
                if (!(this.request == navigatorDataModel.request) || !k.a((Object) this.groupList, (Object) navigatorDataModel.groupList)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.request * 31;
        List<View> list = this.groupList;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "NavigatorDataModel(request=" + this.request + ", groupList=" + this.groupList + ")";
    }

    public NavigatorDataModel(int i2, List<? extends View> list) {
        this.request = i2;
        this.groupList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigatorDataModel(int i2, List list, int i3, g gVar) {
        this(i2, (i3 & 2) != 0 ? null : list);
    }

    public final List<View> getGroupList() {
        return this.groupList;
    }

    public final int getRequest() {
        return this.request;
    }
}
