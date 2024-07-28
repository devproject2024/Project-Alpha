package com.alipay.mobile.h5container.api;

import android.os.Bundle;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import java.util.Stack;

public interface H5Session extends H5CoreNode {
    void addListener(H5Listener h5Listener);

    boolean addPage(H5Page h5Page);

    boolean exitSession();

    String getId();

    Stack<H5Page> getPages();

    Bundle getParams();

    H5Scenario getScenario();

    String getServiceWorkerID();

    long getSessionTag();

    H5Page getTopPage();

    H5ContentProvider getWebProvider();

    void removeAllListener();

    void removeListener(H5Listener h5Listener);

    boolean removePage(H5Page h5Page);

    void setId(String str);

    void setScenario(H5Scenario h5Scenario);

    void setServiceWorkerID(String str);
}
