package com.alipay.mobile.nebula.util.monitor;

public class H5MonitorModel extends H5BaseMonitorModel {
    private static final String CONTAINER_NAME = "H5Container";
    private static String CONTAINER_VERSION = "10.5.10";
    public static final String EXCEPTION_CREATE_FILE = "ContainerCreateFileFail";
    public static final String EXCEPTION_DOWNLOAD_JUMP_URL_INVALID = "ContainerDownloadJumpUrlFail";
    public static final String EXCEPTION_JSAPI_CALL = "ContainerJSApiCallFail";
    public static final String EXCEPTION_MATCH_RES = "ContainerMatchResFail";
    public static final String EXCEPTION_OFFLINE_DOWNLOAD = "ContainerOfflineDownloadFail";
    public static final String EXCEPTION_OFFLINE_LOAD = "ContainerOfflineLoadFail";
    public static final String EXCEPTION_OFFLINE_UNZIP = "ContainerOfflineUnzipFail";
    public static final String EXCEPTION_OFFLINE_VERIFY = "ContainerOfflineVerifyFail";
    public static final String EXCEPTION_PAGE_LOAD = "ContainerLoadPageFail";
    public static final String EXCEPTION_RESET_DATABASE = "ContainerResetDatabaseFail";
    public static final String EXCEPTION_UNZIP_FLOW = "ContainerUnzipFlowFail";
    public static final String EXCEPTION_VERIFY_FLOW = "ContainerVerifyFlowFail";
    private static final String KEY_CONFIG = "configs";
    private static final String KEY_CONTAINER_NAME = "sn";
    private static final String KEY_CONTAINER_VERSION = "sv";
    private static final String KEY_COST_TIME = "timeCost";
    private static final String KEY_EXCEPTION_MESSAGE = "exceptionMessage";
    private static final String KEY_EXCEPTION_NAME = "exceptionName";
    private static final String KEY_JSAPI = "jsapi";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_PACKAGE_VERSION = "pkv";
    private static final String KEY_STEP = "step";
    private static final String KEY_SUBAPP_ID = "subappId";
    private static final String KEY_URL = "url";
    public static final String SEED_ID_APP_LAUNCH = "H5_CONTAINER_APP_LAUNCH";
    public static final String SEED_ID_CONFIG_UPDATE = "H5_CONTAINER_CONFIG_UPDATE";
    public static final String SEED_ID_FIRST_LAUNCH = "H5_CONTAINER_FIRST_LAUNCH";
    public static final String SEED_ID_HTTP_REQUEST = "H5_CONTAINER_HTTP_REQUEST";
    public static final String SEED_ID_INIT_CONTAINER = "H5_CONTAINER_INIT";
    public static final String SEED_ID_JSAPI_CALL = "H5_CONTAINER_JSAPI_CALL";
    public static final String SEED_ID_MATCH_RES = "H5_CONTAINER_MATCH_RES";
    public static final String SEED_ID_MATCH_RES_FALLBACK = "H5_CONTAINER_MATCH_RES_FALLBACK";
    public static final String SEED_ID_OFFLINE_DOWNLOAD = "H5_CONTAINER_OFFLINE_DOWNLOAD";
    public static final String SEED_ID_OFFLINE_LOAD = "H5_CONTAINER_OFFLINE_LOAD";
    public static final String SEED_ID_OFFLINE_UNZIP = "H5_CONTAINER_OFFLINE_UNZIP";
    public static final String SEED_ID_OFFLINE_VERIFY = "H5_CONTAINER_OFFLINE_VERIFY";
    public static final String SEED_ID_OPEN_APP = "H5_CONTAINER_OPEN_APP";
    public static final String SEED_ID_PAGE_LOAD = "H5_CONTAINER_PAGE_LOAD";
    public static final String SEED_ID_PREPARE_RES = "H5_CONTAINER_PREPARE_RES";
    public static final String SEED_ID_RESET_DATABASE = "H5_CONTAINER_RESET_DATABASE";
    public static final String SEED_ID_RPC = "H5_CONTAINER_RPC";
    private static final String STEP_FAIL = "fail";
    private static final String STEP_START = "start";
    private static final String STEP_SUCCESS = "success";

    public H5MonitorModel() {
        getExtParams().put(KEY_CONTAINER_NAME, CONTAINER_NAME);
        getExtParams().put(KEY_CONTAINER_VERSION, CONTAINER_VERSION);
    }

    public H5MonitorModel appendSubappId(String str) {
        getExtParams().put(KEY_SUBAPP_ID, str);
        return this;
    }

    public H5MonitorModel appendPackageVersion(String str) {
        getExtParams().put(KEY_PACKAGE_VERSION, str);
        return this;
    }

    public H5MonitorModel appendJSApi(String str) {
        getExtParams().put(KEY_JSAPI, str);
        return this;
    }

    public H5MonitorModel start() {
        getExtParams().put(KEY_STEP, "start");
        return this;
    }

    public H5MonitorModel success() {
        getExtParams().put(KEY_STEP, "success");
        return this;
    }

    public H5MonitorModel fail() {
        getExtParams().put(KEY_STEP, "fail");
        return this;
    }

    public H5MonitorModel appendUrl(String str) {
        getExtParams().put("url", str);
        return this;
    }

    public H5MonitorModel appendCostTime(long j) {
        getExtParams().put(KEY_COST_TIME, String.valueOf(j));
        return this;
    }

    public H5MonitorModel exceptionType(String str) {
        setExceptionType(str);
        return this;
    }

    public H5MonitorModel appendMessage(String str) {
        getExtParams().put("message", str);
        return this;
    }

    public H5MonitorModel seedId(String str) {
        setSeedId(str);
        return this;
    }

    public H5MonitorModel appendConfigs(String str) {
        getExtParams().put(KEY_CONFIG, str);
        return this;
    }

    public H5MonitorModel appendMd5(String str) {
        getExtParams().put(KEY_MD5, str);
        return this;
    }

    public H5MonitorModel appendExceptionName(String str) {
        getExtParams().put(KEY_EXCEPTION_NAME, str);
        return this;
    }

    public H5MonitorModel appendExceptionMessage(String str) {
        getExtParams().put(KEY_EXCEPTION_MESSAGE, str);
        return this;
    }

    public H5MonitorModel appendExtParams(String str, String str2) {
        getExtParams().put(str, str2);
        return this;
    }
}
