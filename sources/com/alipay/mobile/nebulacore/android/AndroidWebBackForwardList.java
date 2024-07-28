package com.alipay.mobile.nebulacore.android;

import android.webkit.WebBackForwardList;
import com.alipay.mobile.nebula.webview.APWebBackForwardList;
import com.alipay.mobile.nebula.webview.APWebHistoryItem;

public class AndroidWebBackForwardList implements APWebBackForwardList {
    private WebBackForwardList mList;

    public AndroidWebBackForwardList(WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    public int getCurrentIndex() {
        WebBackForwardList webBackForwardList = this.mList;
        if (webBackForwardList == null) {
            return -1;
        }
        return webBackForwardList.getCurrentIndex();
    }

    public APWebHistoryItem getCurrentItem() {
        WebBackForwardList webBackForwardList = this.mList;
        if (webBackForwardList == null || webBackForwardList.getCurrentItem() == null) {
            return null;
        }
        return (APWebHistoryItem) DynamicProxy.dynamicProxy(APWebHistoryItem.class, this.mList.getCurrentItem());
    }

    public APWebHistoryItem getItemAtIndex(int i2) {
        WebBackForwardList webBackForwardList = this.mList;
        if (webBackForwardList == null || webBackForwardList.getItemAtIndex(i2) == null) {
            return null;
        }
        return (APWebHistoryItem) DynamicProxy.dynamicProxy(APWebHistoryItem.class, this.mList.getItemAtIndex(i2));
    }

    public int getSize() {
        WebBackForwardList webBackForwardList = this.mList;
        if (webBackForwardList == null) {
            return 0;
        }
        return webBackForwardList.getSize();
    }

    public String toString() {
        return super.toString();
    }
}
