package com.alipay.mobile.nebula.webview;

public interface APWebBackForwardList {
    int getCurrentIndex();

    APWebHistoryItem getCurrentItem();

    APWebHistoryItem getItemAtIndex(int i2);

    int getSize();
}
