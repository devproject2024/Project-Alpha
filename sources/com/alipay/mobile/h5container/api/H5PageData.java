package com.alipay.mobile.h5container.api;

import android.text.TextUtils;
import com.alipay.mobile.nebula.appcenter.model.H5Refer;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class H5PageData implements Cloneable {
    private static final String[] CREATE_SCENARIO_ARRAY = {"init_uc_unzip", "init_uc", "init", "new", SDKConstants.PUSH_FROM_PUSH, "load"};
    public static final int CREATE_SCENARIO_INIT = 2;
    public static final int CREATE_SCENARIO_INIT_UC = 1;
    public static final int CREATE_SCENARIO_INIT_UC_UNZIP = 0;
    public static final int CREATE_SCENARIO_LOAD = 5;
    public static final int CREATE_SCENARIO_NEW = 3;
    public static final int CREATE_SCENARIO_PUSH = 4;
    public static final int DEFAULT_ERROR_CODE = 7000;
    public static final String FROM_TYPE_HERF_CHANGE = "hrefChange";
    public static final String FROM_TYPE_PUSH_WINDOW = "pushWindow";
    public static final String FROM_TYPE_START_APP = "startApp";
    public static final String FROM_TYPE_SUB_VIEW = "subView";
    public static final String TAG = "H5PageData";
    public static long createAppTime = 0;
    public static boolean firstLaunchFlag = true;
    public static long iconClickTime = -1;
    public static boolean launchAppFlag = false;
    public static long loadUrlStart;
    public static int sCreateScene = -1;
    public static long sCreateTimestamp = -1;
    public static boolean sUseWebViewPool = false;
    public static long swFirstJsApiCallTime;
    public static long walletServiceCreate;
    public static long walletServiceStart;
    public static long webViewCreateEnd;
    public static long webViewCreateStart;
    private int abTestUsedTime;
    private int aliRequestResNum;
    private String eagleId;
    private String errorMsg;
    private int errorSpdyCode;
    private String errorSpdyMsg;
    private boolean isSpdy = false;
    private String jsApiDetail;
    private int mAboutBlankNum;
    private String mAppId;
    private String mAppVersion;
    private long mAppear;
    private long mAppearFromNative;
    private long mComplete;
    private long mContainerVisible;
    private long mCreate;
    private int mCreateScenario = -1;
    private int mCssLoadNum;
    private long mCssLoadSize;
    private int mCssReqNum;
    private long mCssSize;
    private String mCustomParams;
    private long mEnd;
    private int mErrorCode;
    private String mEtype;
    private long mFirstByte;
    private long mFirstVisuallyRender;
    private String mFromType;
    private int mH1RequestCount;
    private int mH2RequestCount;
    private String mH5SessionToken;
    private String mH5Token;
    private long mHeadScreen;
    private long mHtmlLoadSize;
    private long mHtmlSize;
    private String mImageSizeLimit60Urls;
    private int mImgLoadNum;
    private long mImgLoadSize;
    private int mImgReqNum;
    private long mImgSize;
    private String mIsLocal = H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
    private String mIsTinyApp;
    private int mJsLoadNum;
    private long mJsLoadSize;
    private int mJsReqNum;
    private long mJsSize;
    private Map<String, H5JsCallData> mJsapiList = new ConcurrentHashMap();
    private long mLastResponseTimestamp;
    private int mMaxRequestPerClient;
    private int mMaxRequestPerHost;
    private String mNavUrl;
    private long mNavigationStart;
    private int mNum1000;
    private int mNum300;
    private int mNum302;
    private int mNum304;
    private int mNum400;
    private int mNum404;
    private int mNum500;
    private String mOpenAppId;
    private int mOtherLoadNum;
    private long mOtherLoadSize;
    private int mOtherReqNum;
    private long mOtherSize;
    private int mPageIndex;
    private long mPageLoad;
    private long mPageLoadSize;
    private long mPageNetLoad;
    private long mPageSize;
    private String mPageToken;
    private String mPageUrl;
    private String mProtocol;
    private String mProxy;
    private String mPublicId;
    private String mReferUrl;
    private String mReferer;
    private String mReleaseType;
    private int mRequestLoadNum;
    private int mRequestNum;
    private String mResPkgInfo;
    private long mServerResponse;
    private String mSessionId;
    private String mShopId;
    private int mSizeLimit200;
    private String mSizeLimit200Urls;
    private int mSizeLimit60;
    private int mSizeLoadLimit200;
    private int mSizeLoadLimit60;
    private int mSpdyRequestCount;
    private long mSrcClick;
    private long mStart;
    private int mStatusCode;
    private String mStype;
    private String mTitle;
    private String mToken;
    private LinkedList<String> mUrlList = new LinkedList<>();
    private String mVisible;
    private int mWebViewIndex;
    private String mWebViewType;
    private String multimediaID;
    private int netErrorJsNum;
    private int netErrorOtherNum;
    private int netJsReqNum;
    private long netJsSize;
    private long netJsTime;
    private int netOtherReqNum;
    private long netOtherSize;
    private long netOtherTime;
    private int preRender;
    private int reloadType;
    private String requestId;
    private boolean showErrorPage = false;
    private String spmId;
    private int ucCacheResNum;
    private boolean usePreRequest = false;
    private boolean useWebViewPool = false;
    private String xContentVersion = "";

    public H5PageData() {
        clear();
        this.useWebViewPool = sUseWebViewPool;
        sUseWebViewPool = false;
    }

    public H5PageData clone() throws CloneNotSupportedException {
        return (H5PageData) super.clone();
    }

    public void clear() {
        H5Log.d(TAG, "clear");
        this.mSizeLoadLimit200 = 0;
        this.mSizeLimit200 = 0;
        this.mSizeLoadLimit60 = 0;
        this.mSizeLimit60 = 0;
        this.mSizeLimit200Urls = "";
        this.mImageSizeLimit60Urls = "";
        this.mRequestNum = 0;
        this.mOtherReqNum = 0;
        this.mImgReqNum = 0;
        this.mJsReqNum = 0;
        this.mCssReqNum = 0;
        this.mPageIndex = 0;
        this.mOtherSize = 0;
        this.mImgSize = 0;
        this.mJsSize = 0;
        this.mHtmlSize = 0;
        this.mCssSize = 0;
        this.mTitle = "";
        this.mEtype = "";
        this.mStype = "";
        this.mRequestLoadNum = 0;
        this.mOtherLoadNum = 0;
        this.mImgLoadNum = 0;
        this.mCssLoadNum = 0;
        this.mJsLoadNum = 0;
        this.mNum1000 = 0;
        this.mNum500 = 0;
        this.mNum400 = 0;
        this.mNum404 = 0;
        this.mNum300 = 0;
        this.mNum304 = 0;
        this.mNum302 = 0;
        this.mStatusCode = 0;
        this.mErrorCode = DEFAULT_ERROR_CODE;
        this.mAppearFromNative = 0;
        this.mEnd = 0;
        this.mComplete = 0;
        this.mAppear = 0;
        this.mStart = 0;
        this.mFirstByte = 0;
        this.mPageSize = 0;
        this.mHtmlLoadSize = 0;
        this.mCssLoadSize = 0;
        this.mJsLoadSize = 0;
        this.mImgLoadSize = 0;
        this.mOtherLoadSize = 0;
        this.mPageLoadSize = 0;
        this.mVisible = UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT;
        this.mProxy = UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT;
        this.mAboutBlankNum = 0;
        this.mFirstVisuallyRender = 0;
        this.mSpdyRequestCount = 0;
        this.mH1RequestCount = 0;
        this.mH2RequestCount = 0;
        this.mPageLoad = 0;
        this.mContainerVisible = 0;
        this.mSrcClick = 0;
        this.mFromType = "";
        this.mH5SessionToken = "";
        this.mH5Token = "";
        this.mToken = "";
        this.mNavigationStart = 0;
        this.mResPkgInfo = "";
        this.netErrorOtherNum = 0;
        this.netErrorJsNum = 0;
        this.netOtherReqNum = 0;
        this.netJsReqNum = 0;
        this.netOtherTime = 0;
        this.netJsTime = 0;
        this.netOtherSize = 0;
        this.netJsSize = 0;
        this.xContentVersion = "";
        this.requestId = "";
        this.eagleId = "";
        this.multimediaID = "";
        this.jsApiDetail = "";
        this.errorSpdyCode = 0;
        this.errorSpdyMsg = "";
        this.spmId = "";
        this.errorMsg = "";
        this.aliRequestResNum = 0;
        this.ucCacheResNum = 0;
    }

    public boolean isValid() {
        return this.mStart != 0;
    }

    public void onPageStarted(String str) {
        H5Log.d(TAG, "onPageStarted: ".concat(String.valueOf(str)));
        this.mStart = System.currentTimeMillis();
        this.mPageUrl = str;
        this.mStype = getStartType(str);
    }

    public void resetPageToken() {
        this.mPageToken = UUID.randomUUID().toString();
    }

    public void onPageEnded(String str) {
        H5Log.d(TAG, "onPageEnded: ".concat(String.valueOf(str)));
        this.mEnd = System.currentTimeMillis() - this.mStart;
        if (TextUtils.isEmpty(str)) {
            this.mEtype = getEndType();
        } else {
            this.mEtype = str;
        }
        if (this.mAppear > 0) {
            this.mVisible = "Y";
        } else {
            this.mVisible = UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT;
        }
    }

    private String getStartType(String str) {
        String str2;
        if (this.mUrlList.isEmpty()) {
            this.mUrlList.addLast(str);
            H5Log.d(TAG, "open : url = ".concat(String.valueOf(str)));
            this.mReferUrl = H5Refer.referUrl;
            str2 = "open";
        } else if (str.equals(this.mNavUrl)) {
            String last = this.mUrlList.getLast();
            H5Log.d(TAG, "nav : lastUrl".concat(String.valueOf(last)));
            this.mReferUrl = last;
            this.mUrlList.addLast(str);
            str2 = "nav";
        } else {
            String removeLast = this.mUrlList.removeLast();
            H5Log.d(TAG, "resume : lastUrl".concat(String.valueOf(removeLast)));
            this.mReferUrl = removeLast;
            str2 = "resume";
        }
        H5Log.d(TAG, "getStartType : ".concat(str2));
        return str2;
    }

    private String getEndType() {
        return !TextUtils.isEmpty(this.mNavUrl) ? "nav" : "pause";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("index=" + this.mPageIndex);
        sb.append("^error=" + this.mStatusCode);
        sb.append("^visible=Y");
        sb.append("^start=" + this.mStart);
        sb.append("^appear=" + this.mAppear);
        sb.append("^complete=" + this.mComplete);
        sb.append("^end=" + this.mEnd);
        sb.append("^stype=" + this.mStype);
        sb.append("^etype=" + this.mEtype);
        sb.append("^proxy=" + this.mProxy);
        sb.append("^title=" + this.mTitle);
        sb.append("^referer=" + this.mReferer);
        sb.append("^xurl=null");
        sb.append("^pageSize=" + this.mPageSize);
        return sb.toString();
    }

    public String getPageInfo() {
        return "appId=" + this.mAppId + "^version=" + this.mAppVersion + "^publicId=" + this.mPublicId + "^url=" + this.mPageUrl + "^viewId=" + this.mPageUrl + "^refviewId=" + this.mReferUrl;
    }

    public long getStart() {
        return this.mStart;
    }

    public void setStart(long j) {
        H5Log.d(TAG, "setStart: ".concat(String.valueOf(j)));
        this.mStart = j;
    }

    public long getAppear() {
        return this.mAppear;
    }

    public void setAppear(long j) {
        H5Log.d(TAG, "setAppear: ".concat(String.valueOf(j)));
        this.mAppear = j;
    }

    public long getAppearFromNative() {
        return this.mAppearFromNative;
    }

    public void setAppearFromNative(long j) {
        H5Log.d(TAG, "setAppearFromNative: ".concat(String.valueOf(j)));
        this.mAppearFromNative = j;
    }

    public long getFirstByte() {
        return this.mFirstByte;
    }

    public void setFirstByte(long j) {
        H5Log.d(TAG, "setFirstByte: ".concat(String.valueOf(j)));
        this.mFirstByte = j;
    }

    public long getComplete() {
        return this.mComplete;
    }

    public void setComplete(long j) {
        H5Log.d(TAG, "complete: ".concat(String.valueOf(j)));
        this.mComplete = j;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public void setEnd(long j) {
        H5Log.d(TAG, "setEnd: ".concat(String.valueOf(j)));
        this.mEnd = j;
    }

    public long getPageNetLoad() {
        return this.mPageNetLoad;
    }

    public void setPageNetLoad(long j) {
        H5Log.d(TAG, "setPageNetLoad: ".concat(String.valueOf(j)));
        this.mPageNetLoad = j;
    }

    public long getServerResponse() {
        return this.mServerResponse;
    }

    public void setServerResponse(long j) {
        H5Log.d(TAG, "setServerResponse: ".concat(String.valueOf(j)));
        this.mServerResponse = j;
    }

    public long getCreate() {
        return this.mCreate;
    }

    public String getCreateScenario() {
        H5Log.d(TAG, "getCreateScenario: " + this.mCreateScenario);
        int i2 = this.mCreateScenario;
        if (i2 >= 0) {
            try {
                return CREATE_SCENARIO_ARRAY[i2];
            } catch (Throwable th) {
                H5Log.w(TAG, "getCreateScenario", th);
            }
        }
        return "";
    }

    public void setCreateScenario(int i2) {
        H5Log.d(TAG, "setCreateScenario : ".concat(String.valueOf(i2)));
        this.mCreateScenario = i2;
    }

    public static void setInitScenario(long j, int i2) {
        H5Log.d(TAG, "setInitScenario: " + j + ", scenario: " + i2);
        int i3 = sCreateScene;
        if (i3 < 0 || i3 >= i2) {
            sCreateScene = i2;
            sCreateTimestamp = j;
            return;
        }
        H5Log.d(TAG, "setInitScenario fail, sCreateScene: " + sCreateScene + ", sCreateTimestamp: " + sCreateTimestamp);
    }

    public void setCreate(long j, int i2) {
        H5Log.d(TAG, "setCreate: " + j + ", scenario: " + i2);
        if (sCreateScene >= 0) {
            H5Log.d(TAG, "use sCreateScene: " + sCreateScene + ", sCreateTimestamp: " + sCreateTimestamp);
            i2 = sCreateScene;
            j = sCreateTimestamp;
            sCreateScene = -1;
            sCreateTimestamp = -1;
        }
        int i3 = this.mCreateScenario;
        if (i3 < 0 || i3 >= i2) {
            this.mCreate = j;
            this.mCreateScenario = i2;
            return;
        }
        H5Log.d(TAG, "setCreate fail, mCreate: " + this.mCreate + ", mCreateScenario: " + this.mCreateScenario);
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public void setPageIndex(int i2) {
        H5Log.d(TAG, "setPageIndex: ".concat(String.valueOf(i2)));
        this.mPageIndex = i2;
    }

    public int getWebViewIndex() {
        return this.mWebViewIndex;
    }

    public void setWebViewIndex(int i2) {
        H5Log.d(TAG, "setWebViewIndex: ".concat(String.valueOf(i2)));
        this.mWebViewIndex = i2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int i2) {
        H5Log.d(TAG, "setStatusCode: ".concat(String.valueOf(i2)));
        this.mStatusCode = i2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i2) {
        H5Log.d(TAG, "setErrorCode: ".concat(String.valueOf(i2)));
        this.mErrorCode = i2;
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    public void setPageUrl(String str) {
        H5Log.d(TAG, "setPageUrl: ".concat(String.valueOf(str)));
        this.mPageUrl = str;
    }

    public String getReferer() {
        return this.mReferer;
    }

    public void setReferer(String str) {
        H5Log.d(TAG, "setReferer: ".concat(String.valueOf(str)));
        this.mReferer = str;
    }

    public String getVisible() {
        return this.mVisible;
    }

    public void setVisible(String str) {
        H5Log.d(TAG, "setVisible: ".concat(String.valueOf(str)));
        this.mVisible = str;
    }

    public String getReferUrl() {
        return this.mReferUrl;
    }

    public void setReferUrl(String str) {
        H5Log.d(TAG, "setReferUrl: ".concat(String.valueOf(str)));
        this.mReferUrl = str;
    }

    public String getStype() {
        return this.mStype;
    }

    public void setStype(String str) {
        H5Log.d(TAG, "setStype: ".concat(String.valueOf(str)));
        this.mStype = str;
    }

    public String getEtype() {
        return this.mEtype;
    }

    public void setEtype(String str) {
        H5Log.d(TAG, "setEtype: ".concat(String.valueOf(str)));
        this.mEtype = str;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public void setProxy(String str) {
        H5Log.d(TAG, "setProxy: ".concat(String.valueOf(str)));
        this.mProxy = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        H5Log.d(TAG, "setTitle: ".concat(String.valueOf(str)));
        this.mTitle = str;
    }

    public long getPageLoadSize() {
        return this.mPageLoadSize;
    }

    public void setPageLoadSize(long j) {
        H5Log.d(TAG, "setPageLoadSize: ".concat(String.valueOf(j)));
        this.mPageLoadSize = j;
    }

    public long getOtherLoadSize() {
        return this.mOtherLoadSize;
    }

    public void setOtherLoadSize(long j) {
        H5Log.d(TAG, "setOtherLoadSize: ".concat(String.valueOf(j)));
        this.mOtherLoadSize = j;
    }

    public long getImgLoadSize() {
        return this.mImgLoadSize;
    }

    public void setImgLoadSize(long j) {
        H5Log.d(TAG, "setImgLoadSize: ".concat(String.valueOf(j)));
        this.mImgLoadSize = j;
    }

    public long getJsLoadSize() {
        return this.mJsLoadSize;
    }

    public void setJsLoadSize(long j) {
        H5Log.d(TAG, "setJsLoadSize: ".concat(String.valueOf(j)));
        this.mJsLoadSize = j;
    }

    public long getCssLoadSize() {
        return this.mCssLoadSize;
    }

    public void setCssLoadSize(long j) {
        H5Log.d(TAG, "setCssLoadSize: ".concat(String.valueOf(j)));
        this.mCssLoadSize = j;
    }

    public long getHtmlLoadSize() {
        return this.mHtmlLoadSize;
    }

    public void setHtmlLoadSize(long j) {
        H5Log.d(TAG, "setHtmlLoadSize: ".concat(String.valueOf(j)));
        this.mHtmlLoadSize = j;
    }

    public int getCssReqNum() {
        return this.mCssReqNum;
    }

    public void setCssReqNum(int i2) {
        H5Log.d(TAG, "setCssReqNum: ".concat(String.valueOf(i2)));
        this.mCssReqNum = i2;
    }

    public int getJsReqNum() {
        return this.mJsReqNum;
    }

    public void setJsReqNum(int i2) {
        H5Log.d(TAG, "setJsReqNum: ".concat(String.valueOf(i2)));
        this.mJsReqNum = i2;
    }

    public int getImgReqNum() {
        return this.mImgReqNum;
    }

    public void setImgReqNum(int i2) {
        H5Log.d(TAG, "setImgReqNum: ".concat(String.valueOf(i2)));
        this.mImgReqNum = i2;
    }

    public int getOtherReqNum() {
        return this.mOtherReqNum;
    }

    public void setOtherReqNum(int i2) {
        H5Log.d(TAG, "setOtherReqNum: ".concat(String.valueOf(i2)));
        this.mOtherReqNum = i2;
    }

    public int getRequestNum() {
        return this.mRequestNum;
    }

    public void setRequestNum(int i2) {
        H5Log.d(TAG, "setRequestNum: ".concat(String.valueOf(i2)));
        this.mRequestNum = i2;
    }

    public long getJsSize() {
        return this.mJsSize;
    }

    public void setJsSize(long j) {
        H5Log.d(TAG, "setJsSize: ".concat(String.valueOf(j)));
        this.mJsSize = j;
    }

    public long getCssSize() {
        return this.mCssSize;
    }

    public void setCssSize(long j) {
        H5Log.d(TAG, "setCssSize: ".concat(String.valueOf(j)));
        this.mCssSize = j;
    }

    public long getImgSize() {
        return this.mImgSize;
    }

    public void setImgSize(long j) {
        H5Log.d(TAG, "setImgSize: ".concat(String.valueOf(j)));
        this.mImgSize = j;
    }

    public long getOtherSize() {
        return this.mOtherSize;
    }

    public void setOtherSize(long j) {
        H5Log.d(TAG, "setOtherSize: ".concat(String.valueOf(j)));
        this.mOtherSize = j;
    }

    public long getHtmlSize() {
        return this.mHtmlSize;
    }

    public void setHtmlSize(long j) {
        H5Log.d(TAG, "setHtmlSize: ".concat(String.valueOf(j)));
        this.mHtmlSize = j;
    }

    public long getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(long j) {
        H5Log.d(TAG, "setPageSize: ".concat(String.valueOf(j)));
        this.mPageSize = j;
    }

    public int getJsLoadNum() {
        return this.mJsLoadNum;
    }

    public void setJsLoadNum(int i2) {
        H5Log.d(TAG, "setJsLoadNum: ".concat(String.valueOf(i2)));
        this.mJsLoadNum = i2;
    }

    public int getCssLoadNum() {
        return this.mCssLoadNum;
    }

    public void setCssLoadNum(int i2) {
        H5Log.d(TAG, "setCssLoadNum: ".concat(String.valueOf(i2)));
        this.mCssLoadNum = i2;
    }

    public int getImgLoadNum() {
        return this.mImgLoadNum;
    }

    public void setImgLoadNum(int i2) {
        H5Log.d(TAG, "setImgLoadNum: ".concat(String.valueOf(i2)));
        this.mImgLoadNum = i2;
    }

    public int getOtherLoadNum() {
        return this.mOtherLoadNum;
    }

    public void setOtherLoadNum(int i2) {
        H5Log.d(TAG, "setOtherLoadNum: ".concat(String.valueOf(i2)));
        this.mOtherLoadNum = i2;
    }

    public int getRequestLoadNum() {
        return this.mRequestLoadNum;
    }

    public void setRequestLoadNum(int i2) {
        H5Log.d(TAG, "setRequestLoadNum: ".concat(String.valueOf(i2)));
        this.mRequestLoadNum = i2;
    }

    public int getSizeLimit60() {
        return this.mSizeLimit60;
    }

    public void setSizeLimit60(int i2) {
        H5Log.d(TAG, "setSizeLimit60: ".concat(String.valueOf(i2)));
        this.mSizeLimit60 = i2;
    }

    public int getSizeLoadLimit60() {
        return this.mSizeLoadLimit60;
    }

    public void setSizeLoadLimit60(int i2) {
        H5Log.d(TAG, "setSizeLoadLimit60: ".concat(String.valueOf(i2)));
        this.mSizeLoadLimit60 = i2;
    }

    public int getSizeLimit200() {
        return this.mSizeLimit200;
    }

    public void setSizeLimit200(int i2) {
        H5Log.d(TAG, "setSizeLimit200: ".concat(String.valueOf(i2)));
        this.mSizeLimit200 = i2;
    }

    public int getSizeLoadLimit200() {
        return this.mSizeLoadLimit200;
    }

    public void setSizeLoadLimit200(int i2) {
        H5Log.d(TAG, "setSizeLoadLimit200: ".concat(String.valueOf(i2)));
        this.mSizeLoadLimit200 = i2;
    }

    public String getImageSizeLimit60Urls() {
        return this.mImageSizeLimit60Urls;
    }

    public void setImageSizeLimit60Urls(String str) {
        H5Log.d(TAG, "setImageSizeLimit60Urls: ".concat(String.valueOf(str)));
        this.mImageSizeLimit60Urls = str;
    }

    public String getSizeLimit200Urls() {
        return this.mSizeLimit200Urls;
    }

    public void setSizeLimit200Urls(String str) {
        H5Log.d(TAG, "setSizeLimit200Urls: ".concat(String.valueOf(str)));
        this.mSizeLimit200Urls = str;
    }

    public int getNum302() {
        return this.mNum302;
    }

    public void setNum302(int i2) {
        H5Log.d(TAG, "setNum302: ".concat(String.valueOf(i2)));
        this.mNum302 = i2;
    }

    public int getNum304() {
        return this.mNum304;
    }

    public void setNum304(int i2) {
        H5Log.d(TAG, "setNum304: ".concat(String.valueOf(i2)));
        this.mNum304 = i2;
    }

    public int getNum300() {
        return this.mNum300;
    }

    public void setNum300(int i2) {
        H5Log.d(TAG, "setNum300: ".concat(String.valueOf(i2)));
        this.mNum300 = i2;
    }

    public int getNum404() {
        return this.mNum404;
    }

    public void setNum404(int i2) {
        H5Log.d(TAG, "setNum404: ".concat(String.valueOf(i2)));
        this.mNum404 = i2;
    }

    public int getNum400() {
        return this.mNum400;
    }

    public void setNum400(int i2) {
        H5Log.d(TAG, "setNum400: ".concat(String.valueOf(i2)));
        this.mNum400 = i2;
    }

    public int getNum500() {
        return this.mNum500;
    }

    public void setNum500(int i2) {
        H5Log.d(TAG, "setNum500: ".concat(String.valueOf(i2)));
        this.mNum500 = i2;
    }

    public int getNum1000() {
        return this.mNum1000;
    }

    public void setNum1000(int i2) {
        H5Log.d(TAG, "setNum1000: ".concat(String.valueOf(i2)));
        this.mNum1000 = i2;
    }

    public String getNavUrl() {
        return this.mNavUrl;
    }

    public void setNavUrl(String str) {
        H5Log.d(TAG, "setNavUrl: ".concat(String.valueOf(str)));
        this.mNavUrl = str;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setAppId(String str) {
        H5Log.d(TAG, "setAppId: ".concat(String.valueOf(str)));
        this.mAppId = str;
    }

    public String getPublicId() {
        return this.mPublicId;
    }

    public void setPublicId(String str) {
        H5Log.d(TAG, "setPublicId: ".concat(String.valueOf(str)));
        this.mPublicId = str;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(String str) {
        H5Log.d(TAG, "setAppVersion: ".concat(String.valueOf(str)));
        this.mAppVersion = str;
    }

    public LinkedList<String> getUrlList() {
        return this.mUrlList;
    }

    public void setUrlList(LinkedList<String> linkedList) {
        H5Log.d(TAG, "setUrlList");
        this.mUrlList = linkedList;
    }

    public String getCustomParams() {
        return this.mCustomParams;
    }

    public void setCustomParams(String str) {
        H5Log.d(TAG, "setCustomParams: ".concat(String.valueOf(str)));
        this.mCustomParams = str;
    }

    public int getAboutBlankNum() {
        return this.mAboutBlankNum;
    }

    public void setAboutBlankNum(int i2) {
        H5Log.d(TAG, "setAboutBlankNum: ".concat(String.valueOf(i2)));
        this.mAboutBlankNum = i2;
    }

    public String getWebViewType() {
        return this.mWebViewType;
    }

    public void setWebViewType(String str) {
        H5Log.d(TAG, "setWebViewType: ".concat(String.valueOf(str)));
        this.mWebViewType = str;
    }

    public String getPageToken() {
        return this.mPageToken;
    }

    public void setPageToken(String str) {
        H5Log.d(TAG, "setPageToken: ".concat(String.valueOf(str)));
        this.mPageToken = str;
    }

    public String getIsLocal() {
        return this.mIsLocal;
    }

    public void setIsLocal(String str) {
        H5Log.d(TAG, "setIsLocal: ".concat(String.valueOf(str)));
        this.mIsLocal = str;
    }

    public String getReleaseType() {
        return this.mReleaseType;
    }

    public void setReleaseType(String str) {
        H5Log.d(TAG, "setReleaseType: ".concat(String.valueOf(str)));
        this.mReleaseType = str;
    }

    public String getIsTinyApp() {
        return this.mIsTinyApp;
    }

    public void setIsTinyApp(String str) {
        H5Log.d(TAG, "setIsTinyApp: ".concat(String.valueOf(str)));
        this.mIsTinyApp = str;
    }

    public String getOpenAppId() {
        return this.mOpenAppId;
    }

    public void setOpenAppId(String str) {
        H5Log.d(TAG, "setOpenAppId: ".concat(String.valueOf(str)));
        this.mOpenAppId = str;
    }

    public String getShopId() {
        return this.mShopId;
    }

    public void setShopId(String str) {
        H5Log.d(TAG, "setShopId: ".concat(String.valueOf(str)));
        this.mShopId = str;
    }

    public long getHeadScreen() {
        return this.mHeadScreen;
    }

    public void setHeadScreen(long j) {
        H5Log.d(TAG, "setHeadScreen: ".concat(String.valueOf(j)));
        this.mHeadScreen = j;
    }

    public int getAbTestUsedTime() {
        return this.abTestUsedTime;
    }

    public void setAbTestUsedTime(int i2) {
        this.abTestUsedTime = i2;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public void setProtocol(String str) {
        H5Log.d(TAG, "setProtocol: ".concat(String.valueOf(str)));
        this.mProtocol = str;
    }

    public int getMaxRequestPerHost() {
        return this.mMaxRequestPerHost;
    }

    public int getMaxRequestPerClient() {
        return this.mMaxRequestPerClient;
    }

    public void setMaxRequest(int i2, int i3) {
        this.mMaxRequestPerClient = i2;
        this.mMaxRequestPerHost = i3;
    }

    public void setFirstVisuallyRender(long j) {
        if (this.mFirstVisuallyRender <= 0) {
            H5Log.d(TAG, "onFirstVisuallyRender: ".concat(String.valueOf(j)));
            this.mFirstVisuallyRender = j;
        }
    }

    public long getFirstVisuallyRender() {
        return this.mFirstVisuallyRender;
    }

    public int getRequestCountByProtocal(String str) {
        if (str.contains("spdy")) {
            return this.mSpdyRequestCount;
        }
        if (str.contains("h2")) {
            return this.mH2RequestCount;
        }
        return this.mH1RequestCount;
    }

    public void updateRequestCountByProtocal(String str) {
        if (getComplete() <= 0 || getPageLoad() <= 0) {
            if (str.contains("spdy")) {
                this.mSpdyRequestCount++;
            } else if (str.contains("h2")) {
                this.mH2RequestCount++;
            } else {
                this.mH1RequestCount++;
            }
            H5Log.d(TAG, "h2count: " + this.mH2RequestCount + " spdycount: " + this.mSpdyRequestCount + "h1count: " + this.mH1RequestCount);
        }
    }

    public void setPageLoad(long j) {
        H5Log.d(TAG, "setPageLoad ".concat(String.valueOf(j)));
        this.mPageLoad = j;
    }

    public long getPageLoad() {
        return this.mPageLoad;
    }

    public long getSrcClick() {
        return this.mSrcClick;
    }

    public void setSrcClick(long j) {
        H5Log.d(TAG, "setSrcClick: ".concat(String.valueOf(j)));
        this.mSrcClick = j;
    }

    public long getContainerVisible() {
        return this.mContainerVisible;
    }

    public void setContainerVisible(long j) {
        H5Log.d(TAG, "setContainerVisible: " + this.mSrcClick);
        this.mContainerVisible = j;
    }

    public String getFromType() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        H5Log.d(TAG, "setFromType: ".concat(String.valueOf(str)));
        this.mFromType = str;
    }

    public int getPreRender() {
        return this.preRender;
    }

    public void setPreRender(int i2) {
        H5Log.d(TAG, "setPreRender: " + this.preRender);
        this.preRender = i2;
    }

    public void setSessionId(String str) {
        H5Log.d(TAG, "setSessionId ".concat(String.valueOf(str)));
        this.mSessionId = str;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        H5Log.d(TAG, "setToken ".concat(String.valueOf(str)));
        this.mToken = str;
    }

    public String getH5Token() {
        return this.mH5Token;
    }

    public void setH5Token(String str) {
        H5Log.d(TAG, "setH5Token ".concat(String.valueOf(str)));
        this.mH5Token = str;
    }

    public String getH5SessionToken() {
        return this.mH5SessionToken;
    }

    public void setH5SessionToken(String str) {
        H5Log.d(TAG, "setH5SessionToken ".concat(String.valueOf(str)));
        this.mH5SessionToken = str;
    }

    public void addJsapiInfo(String str, H5JsCallData h5JsCallData) {
        H5Log.d(TAG, "addJsapiInfo " + h5JsCallData.getAction() + " " + this.mAppId + " " + this.mTitle);
        this.mJsapiList.put(str, h5JsCallData);
    }

    public H5JsCallData getJsapiInfo(String str) {
        return this.mJsapiList.get(str);
    }

    public Map<String, H5JsCallData> getJsapiInfoList() {
        H5Log.d(TAG, "getJsapiInfoList: " + this.mAppId);
        return this.mJsapiList;
    }

    public long getNavigationStart() {
        return this.mNavigationStart;
    }

    public void setNavigationStart(long j) {
        H5Log.d(TAG, "setNavigationStart : ".concat(String.valueOf(j)));
        this.mNavigationStart = j;
    }

    public String getResPkgInfo() {
        return this.mResPkgInfo;
    }

    public void setResPkgInfo(String str) {
        H5Log.d(TAG, "setResPkgInfo : ".concat(String.valueOf(str)));
        this.mResPkgInfo = str;
    }

    public int getNetJsReqNum() {
        return this.netJsReqNum;
    }

    public void setNetJsReqNum(int i2) {
        H5Log.d(TAG, "setNetJsReqNum : ".concat(String.valueOf(i2)));
        this.netJsReqNum = i2;
    }

    public int getNetOtherReqNum() {
        return this.netOtherReqNum;
    }

    public void setNetOtherReqNum(int i2) {
        H5Log.d(TAG, "setNetOtherReqNum : ".concat(String.valueOf(i2)));
        this.netOtherReqNum = i2;
    }

    public int getNetErrorJsNum() {
        return this.netErrorJsNum;
    }

    public void setNetErrorJsNum(int i2) {
        H5Log.d(TAG, "setNetErrorJsNum : ".concat(String.valueOf(i2)));
        this.netErrorJsNum = i2;
    }

    public int getNetErrorOtherNum() {
        return this.netErrorOtherNum;
    }

    public void setNetErrorOtherNum(int i2) {
        H5Log.d(TAG, "setNetErrorOtherNum : ".concat(String.valueOf(i2)));
        this.netErrorOtherNum = i2;
    }

    public long getNetJsSize() {
        return this.netJsSize;
    }

    public void setNetJsSize(long j) {
        H5Log.d(TAG, "setNetJsSize : ".concat(String.valueOf(j)));
        this.netJsSize = j;
    }

    public long getNetOtherSize() {
        return this.netOtherSize;
    }

    public void setNetOtherSize(long j) {
        H5Log.d(TAG, "setNetOtherSize : ".concat(String.valueOf(j)));
        this.netOtherSize = j;
    }

    public long getNetJsTime() {
        return this.netJsTime;
    }

    public void setNetJsTime(long j) {
        H5Log.d(TAG, "setNetJsTime : ".concat(String.valueOf(j)));
        this.netJsTime = j;
    }

    public long getNetOtherTime() {
        return this.netOtherTime;
    }

    public void setNetOtherTime(long j) {
        H5Log.d(TAG, "setNetOtherTime : ".concat(String.valueOf(j)));
        this.netOtherTime = j;
    }

    public String getXContentVersion() {
        return this.xContentVersion;
    }

    public void setXContentVersion(String str) {
        H5Log.d(TAG, "setXContentVersion : ".concat(String.valueOf(str)));
        this.xContentVersion = str;
    }

    public String getEagleId() {
        return this.eagleId;
    }

    public void setEagleId(String str) {
        H5Log.d(TAG, "setEagleId : ".concat(String.valueOf(str)));
        this.eagleId = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        H5Log.d(TAG, "setRequestId : ".concat(String.valueOf(str)));
        this.requestId = str;
    }

    public boolean isUsePreRequest() {
        return this.usePreRequest;
    }

    public void setUsePreRequest(boolean z) {
        H5Log.d(TAG, "setUsePreRequest : ".concat(String.valueOf(z)));
        this.usePreRequest = z;
    }

    public boolean isUseWebViewPool() {
        return this.useWebViewPool;
    }

    public void setUseWebViewPool(boolean z) {
        H5Log.d(TAG, "setUseWebViewPool : ".concat(String.valueOf(z)));
        this.useWebViewPool = z;
    }

    public String getMultimediaID() {
        return this.multimediaID;
    }

    public void setMultimediaID(String str) {
        H5Log.d(TAG, "setMultimediaID : ".concat(String.valueOf(str)));
        this.multimediaID = str;
    }

    public String getJsApiDetail() {
        if (this.jsApiDetail.length() <= 0 || !this.jsApiDetail.endsWith("|")) {
            return this.jsApiDetail.toString();
        }
        String str = this.jsApiDetail;
        return str.substring(0, str.length() - 1);
    }

    public void appendJsApiDetail(String str) {
        H5Log.d(TAG, "appendJsApiDetail : ".concat(String.valueOf(str)));
        this.jsApiDetail += str + "|";
    }

    public boolean isSpdy() {
        return this.isSpdy;
    }

    public void setSpdy(boolean z) {
        H5Log.d(TAG, "setSpdy : ".concat(String.valueOf(z)));
        this.isSpdy = z;
    }

    public int getErrorSpdyCode() {
        return this.errorSpdyCode;
    }

    public void setErrorSpdyCode(int i2) {
        H5Log.d(TAG, "setErrorSpdyCode : ".concat(String.valueOf(i2)));
        this.errorSpdyCode = i2;
    }

    public String getErrorSpdyMsg() {
        return this.errorSpdyMsg;
    }

    public void setErrorSpdyMsg(String str) {
        H5Log.d(TAG, "setErrorSpdyMsg : ".concat(String.valueOf(str)));
        this.errorSpdyMsg = str;
    }

    public String getSpmId() {
        return this.spmId;
    }

    public void setSpmId(String str) {
        H5Log.d(TAG, "setSpmId : ".concat(String.valueOf(str)));
        this.spmId = str;
    }

    public boolean isShowErrorPage() {
        return this.showErrorPage;
    }

    public void setShowErrorPage(boolean z) {
        H5Log.d(TAG, "setShowErrorPage : ".concat(String.valueOf(z)));
        this.showErrorPage = z;
    }

    public int getReloadType() {
        return this.reloadType;
    }

    public void setReloadType(int i2) {
        H5Log.d(TAG, "setReloadType : ".concat(String.valueOf(i2)));
        this.reloadType = i2;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        H5Log.d(TAG, "setErrorMsg : ".concat(String.valueOf(str)));
        this.errorMsg = str;
    }

    public void setLastResponseTimestamp(long j) {
        H5Log.d(TAG, "setLastResponseTimestamp : ".concat(String.valueOf(j)));
        this.mLastResponseTimestamp = j;
    }

    public long getLastResponseTimestamp() {
        long j = this.mLastResponseTimestamp;
        long j2 = this.mStart;
        return j <= j2 ? j2 : j;
    }

    public int getUcCacheResNum() {
        return this.ucCacheResNum;
    }

    public void setUcCacheResNum(int i2) {
        H5Log.d(TAG, "setUcCacheResNum : ".concat(String.valueOf(i2)));
        this.ucCacheResNum = i2;
    }

    public int getAliRequestResNum() {
        return this.aliRequestResNum;
    }

    public void setAliRequestResNum(int i2) {
        this.aliRequestResNum = i2;
    }
}
