package com.alipay.mobile.nebulacore.tabbar;

import com.alipay.mobile.nebulacore.ui.H5Fragment;
import java.util.HashMap;
import java.util.Map;

public class H5SessionTabManager {
    private int currentIndex = -1;
    private Map<Integer, H5Fragment> tabFragments = new HashMap();

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int i2) {
        this.currentIndex = i2;
    }

    public void addTabFragment(int i2, H5Fragment h5Fragment) {
        Map<Integer, H5Fragment> map = this.tabFragments;
        if (map != null) {
            map.put(Integer.valueOf(i2), h5Fragment);
        }
    }

    public H5Fragment getTabFragmentByIndex(int i2) {
        Map<Integer, H5Fragment> map = this.tabFragments;
        if (map != null) {
            return map.get(Integer.valueOf(i2));
        }
        return null;
    }

    public Map<Integer, H5Fragment> getTabFragments() {
        return this.tabFragments;
    }

    public void clearTabFragments() {
        this.currentIndex = -1;
        Map<Integer, H5Fragment> map = this.tabFragments;
        if (map != null) {
            map.clear();
        }
    }

    public int countTabFragments() {
        Map<Integer, H5Fragment> map = this.tabFragments;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public H5Fragment getCurrentFragment() {
        Map<Integer, H5Fragment> map = this.tabFragments;
        if (map != null) {
            return map.get(Integer.valueOf(this.currentIndex));
        }
        return null;
    }
}
