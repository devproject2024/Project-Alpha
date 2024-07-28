package com.alipay.mobile.nebula.basebridge;

import com.alibaba.a.e;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.service.H5Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class H5BaseNebulaService implements H5CoreNode {
    public static final String TAG = "H5BaseNebulaService";
    private List<H5CoreNode> children = new ArrayList();
    protected H5Data h5Data;
    private H5CoreNode parent = null;
    private H5PluginManager pluginManager;

    public void onInitialize(H5CoreNode h5CoreNode) {
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
    }

    public void sendEvent(String str, e eVar) {
    }

    public H5BaseNebulaService() {
        b.a();
        this.pluginManager = ((H5Service) c.a(H5Service.class.getName())).createPluginManager(this);
    }

    public H5CoreNode getParent() {
        return this.parent;
    }

    public void setParent(H5CoreNode h5CoreNode) {
        H5CoreNode h5CoreNode2 = this.parent;
        if (h5CoreNode != h5CoreNode2) {
            if (h5CoreNode2 != null) {
                h5CoreNode2.removeChild(this);
            }
            this.parent = h5CoreNode;
            H5CoreNode h5CoreNode3 = this.parent;
            if (h5CoreNode3 != null) {
                h5CoreNode3.addChild(this);
            }
        }
    }

    public boolean addChild(H5CoreNode h5CoreNode) {
        if (h5CoreNode == null) {
            return false;
        }
        synchronized (H5BaseNebulaService.class) {
            for (H5CoreNode equals : this.children) {
                if (equals.equals(h5CoreNode)) {
                    return false;
                }
            }
            this.children.add(h5CoreNode);
            h5CoreNode.setParent(this);
            return true;
        }
    }

    public boolean removeChild(H5CoreNode h5CoreNode) {
        if (h5CoreNode == null) {
            return false;
        }
        synchronized (H5BaseNebulaService.class) {
            Iterator<H5CoreNode> it2 = this.children.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(h5CoreNode)) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5PluginManager h5PluginManager = this.pluginManager;
        return h5PluginManager != null && h5PluginManager.interceptEvent(h5Event, h5BridgeContext);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5PluginManager h5PluginManager = this.pluginManager;
        return h5PluginManager != null && h5PluginManager.handleEvent(h5Event, h5BridgeContext);
    }

    public void onRelease() {
        H5PluginManager h5PluginManager = this.pluginManager;
        if (h5PluginManager != null) {
            h5PluginManager.onRelease();
            this.pluginManager = null;
        }
        this.h5Data = null;
    }

    public H5PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public H5Data getData() {
        return this.h5Data;
    }

    public void setData(H5Data h5Data2) {
        this.h5Data = h5Data2;
    }
}
