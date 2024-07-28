package com.alipay.mobile.nebulacore.dev.sampler;

public class ReportConfig {
    private static ReportConfig sInstance;

    public int getSampleDelay() {
        return 500;
    }

    public static synchronized ReportConfig getInstance() {
        ReportConfig reportConfig;
        synchronized (ReportConfig.class) {
            if (sInstance == null) {
                sInstance = new ReportConfig();
            }
            reportConfig = sInstance;
        }
        return reportConfig;
    }
}
