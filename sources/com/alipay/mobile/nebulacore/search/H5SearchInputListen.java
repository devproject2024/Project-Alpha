package com.alipay.mobile.nebulacore.search;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.search.H5InputListen;

public class H5SearchInputListen implements H5InputListen {
    private H5Page h5Page;

    public H5SearchInputListen(H5Page h5Page2) {
        this.h5Page = h5Page2;
    }

    public void onChange(String str) {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            e eVar = new e();
            eVar.put("value", (Object) str);
            e eVar2 = new e();
            eVar2.put("data", (Object) eVar);
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didTextChange", eVar2, (H5CallBack) null);
        }
    }

    public void onFocus() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didFocus", (e) null, (H5CallBack) null);
        }
    }

    public void onBlur() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didBlur", (e) null, (H5CallBack) null);
        }
    }

    public void onSubmit(String str) {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            e eVar = new e();
            eVar.put("value", (Object) str);
            e eVar2 = new e();
            eVar2.put("data", (Object) eVar);
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didSubmit", eVar2, (H5CallBack) null);
        }
    }

    public void onCancel() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didCancel", (e) null, (H5CallBack) null);
        }
    }

    public void onVoiceBtnClick() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didVoiceBtnClick", (e) null, (H5CallBack) null);
        }
    }

    public void entranceClick() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getBridge() != null) {
            this.h5Page.getBridge().sendToWeb("h5SearchBar_didEntranceClick", (e) null, (H5CallBack) null);
        }
    }

    public void back() {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null) {
            h5Page2.sendEvent(H5Plugin.InternalEvents.H5_TOOLBAR_BACK, (e) null);
        }
    }
}
