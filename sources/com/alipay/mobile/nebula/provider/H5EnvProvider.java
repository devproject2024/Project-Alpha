package com.alipay.mobile.nebula.provider;

public interface H5EnvProvider {
    String getLanguage();

    String getLoginId();

    String getProductVersion();

    String getRpcUrl();

    String getSnapshotJsapiSavePath();

    String getmDid();

    boolean goToSchemeService(String str);
}
