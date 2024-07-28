package com.alipay.mobile.nebula.appcenter;

import java.util.Map;

public class H5PresetPkg {
    private Map<String, H5PresetInfo> preSetInfo;
    private String presetPath;

    public String getPresetPath() {
        return this.presetPath;
    }

    public void setPresetPath(String str) {
        this.presetPath = str;
    }

    public Map<String, H5PresetInfo> getPreSetInfo() {
        return this.preSetInfo;
    }

    public void setPreSetInfo(Map<String, H5PresetInfo> map) {
        this.preSetInfo = map;
    }
}
