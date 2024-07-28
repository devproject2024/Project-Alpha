package com.alipay.mobile.nebulacore.prerender;

import android.os.Bundle;
import android.os.Handler;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H5PreRenderPool {
    public static final int CONTAINSMODE_CONTENT = 0;
    public static final int CONTAINSMODE_CONTENT_URL = 2;
    public static final int CONTAINSMODE_POINT = 1;
    private static H5PreRenderPool instance;
    private boolean isIntercept;
    private List<H5Fragment> preFragmentList;
    private Handler preHandler;
    private List<e> preParamContentList;
    private Map<Bundle, Integer> preParamPointMap;
    private Runnable preRunnable;
    private List<String> preUrlList;

    private H5PreRenderPool() {
        this.preFragmentList = null;
        this.preParamPointMap = null;
        this.preParamContentList = null;
        this.preUrlList = null;
        this.preFragmentList = new ArrayList();
        this.preParamPointMap = new HashMap();
        this.preParamContentList = new ArrayList();
        this.preUrlList = new ArrayList();
    }

    public static H5PreRenderPool getInstance() {
        if (instance == null) {
            synchronized (H5PreRenderPool.class) {
                if (instance == null) {
                    instance = new H5PreRenderPool();
                }
            }
        }
        return instance;
    }

    public int getPreFragmentCount() {
        List<H5Fragment> list = this.preFragmentList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public b getUrls() {
        b bVar = new b();
        List<String> list = this.preUrlList;
        if (list != null) {
            for (String add : list) {
                bVar.add(add);
            }
        }
        return bVar;
    }

    public boolean containsPoolKey(Bundle bundle, int i2) {
        if (i2 == 0) {
            List<e> list = this.preParamContentList;
            if (list == null || !list.contains(H5Utils.toJSONObject(bundle))) {
                return false;
            }
        } else if (i2 == 1) {
            Map<Bundle, Integer> map = this.preParamPointMap;
            if (map == null || !map.containsKey(bundle)) {
                return false;
            }
        } else if (i2 != 2) {
            return false;
        } else {
            String stripAnchor = stripAnchor(H5Utils.getString(bundle, "url"));
            List<String> list2 = this.preUrlList;
            if (list2 == null || !list2.contains(stripAnchor)) {
                return false;
            }
        }
        return true;
    }

    private String stripAnchor(String str) {
        int indexOf = str.indexOf(35);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public void putPreFragment(Bundle bundle, H5Fragment h5Fragment) {
        List<e> list = this.preParamContentList;
        if (list != null) {
            list.add(H5Utils.toJSONObject(bundle));
        }
        if (this.preUrlList != null) {
            this.preUrlList.add(stripAnchor(H5Utils.getString(bundle, "url")));
        }
        List<H5Fragment> list2 = this.preFragmentList;
        if (list2 != null) {
            list2.add(h5Fragment);
        }
    }

    public int getCurrentIndex(H5Fragment h5Fragment) {
        List<H5Fragment> list = this.preFragmentList;
        if (list != null) {
            return list.indexOf(h5Fragment);
        }
        return -1;
    }

    public void putPreFragmentBundle(Bundle bundle, Integer num) {
        Map<Bundle, Integer> map = this.preParamPointMap;
        if (map != null) {
            map.put(bundle, num);
        }
    }

    public H5Fragment getPreFragment(Bundle bundle, int i2) {
        H5Fragment h5Fragment;
        if (i2 == 0) {
            List<e> list = this.preParamContentList;
            int indexOf = list != null ? list.indexOf(H5Utils.toJSONObject(bundle)) : -1;
            if (indexOf == -1) {
                return null;
            }
            h5Fragment = this.preFragmentList.get(indexOf);
        } else if (i2 == 1) {
            Map<Bundle, Integer> map = this.preParamPointMap;
            int intValue = map != null ? map.get(bundle).intValue() : -1;
            if (intValue == -1) {
                return null;
            }
            h5Fragment = this.preFragmentList.get(intValue);
        } else if (i2 != 2) {
            return null;
        } else {
            String stripAnchor = stripAnchor(H5Utils.getString(bundle, "url"));
            List<String> list2 = this.preUrlList;
            int indexOf2 = list2 != null ? list2.indexOf(stripAnchor) : -1;
            if (indexOf2 == -1) {
                return null;
            }
            h5Fragment = this.preFragmentList.get(indexOf2);
        }
        return h5Fragment;
    }

    public void removeFragment(Bundle bundle) {
        Integer num = this.preParamPointMap.get(bundle);
        int intValue = num != null ? num.intValue() : -1;
        if (intValue >= 0) {
            this.preParamPointMap.remove(bundle);
        }
        int size = this.preParamContentList.size();
        if (intValue >= 0 && intValue < size) {
            this.preParamContentList.remove(intValue);
        }
        int size2 = this.preFragmentList.size();
        if (intValue >= 0 && intValue < size2) {
            this.preFragmentList.remove(intValue);
        }
        int size3 = this.preUrlList.size();
        if (intValue >= 0 && intValue < size3) {
            this.preUrlList.remove(intValue);
        }
    }

    public List<H5Fragment> getPreFragmentList() {
        return this.preFragmentList;
    }

    public Map<Bundle, Integer> getPreParamPointMap() {
        return this.preParamPointMap;
    }

    public List<e> getPreParamContentList() {
        return this.preParamContentList;
    }

    public List<String> getPreUrlList() {
        return this.preUrlList;
    }

    public boolean isIntercept() {
        return this.isIntercept;
    }

    public void setIsIntercept(boolean z) {
        this.isIntercept = z;
    }

    public Handler getPreHandler() {
        return this.preHandler;
    }

    public void setPreHandler(Handler handler) {
        this.preHandler = handler;
    }

    public Runnable getPreRunnable() {
        return this.preRunnable;
    }

    public void setPreRunnable(Runnable runnable) {
        this.preRunnable = runnable;
    }

    public void release() {
        List<H5Fragment> list = this.preFragmentList;
        if (list != null) {
            list.clear();
        }
        Map<Bundle, Integer> map = this.preParamPointMap;
        if (map != null) {
            map.clear();
        }
        List<e> list2 = this.preParamContentList;
        if (list2 != null) {
            list2.clear();
        }
        List<String> list3 = this.preUrlList;
        if (list3 != null) {
            list3.clear();
        }
        this.preHandler = null;
        this.preRunnable = null;
    }
}
