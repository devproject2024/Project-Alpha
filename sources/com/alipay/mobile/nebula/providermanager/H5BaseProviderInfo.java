package com.alipay.mobile.nebula.providermanager;

import com.alipay.mobile.nebula.permission.H5PermissionManager;
import com.alipay.mobile.nebula.provider.H5RpcProxyProvider;
import com.alipay.mobile.nebula.provider.H5StartParamCheck;
import com.alipay.mobile.nebula.provider.H5TimeService;
import com.alipay.mobile.nebula.tinypermission.H5ApiManager;
import com.alipay.mobile.nebula.view.IH5TinyPopMenu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5BaseProviderInfo {
    public static final String nebulaappproxy = "android-phone-wallet-nebulaappproxy";
    public static final String nebulabiz = "android-phone-wallet-nebulabiz";
    public static final String nebulacore = "android-phone-wallet-nebulacore";
    public static final String nebulauc = "android-phone-wallet-nebulauc";
    public static Map<String, H5ProviderConfig> providerInfoMap = null;
    public static final String tinyappservice = "android-phone-wallet-tinyappservice";

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        providerInfoMap = concurrentHashMap;
        concurrentHashMap.put("com.alipay.mobile.nebula.provider.H5TraceProvider", new H5ProviderConfig(nebulacore, "com.alipay.mobile.nebulacore.dev.trace.H5TraceProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LogProvider", new H5ProviderConfig(nebulacore, "com.alipay.mobile.nebulacore.wallet.WalletLogProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ThreadPoolProvider", new H5ProviderConfig(nebulacore, "com.alipay.mobile.nebulacore.wallet.WalletThreadPoolProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ABTestProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5ABTestProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5APMTool", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5APMToolImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5EnvProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletEnvProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ConfigProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletConfigProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5CacheProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletCacheProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5PreRpcProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletPreRpcProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LocationDialogProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletLocationDialogProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ChannelProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletChannelProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ImageProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletImageProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ImageUploadProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletImageUploadProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5CardShareProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletCardShareProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LastKnowLocationProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.WalletLastKnowLocationProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5AppProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.baseprovider.H5BaseAppProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5JSApiPermissionProviderImp"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5DialogManagerProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5WalletDialogProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ListPopDialogProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5WalletListPopDialogProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ToastProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5WalletToastProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5SharePanelProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5SharePanelProviderImp"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.appcenter.H5AppCenterPresetProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5InputBoardProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5InputBoardProviderImpEx"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5BugMeRpcAuthProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5BugMeRpcAuthProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LoginProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5LoginProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ActionSheetProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5AntUIActionSheetProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.search.H5SearchView", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5SearchViewImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.resourcehandler.H5ResourceHandler", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5ResourceHandlerImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5478Provider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5478ProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LoadingDialog", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5LoadingDialogImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5SimpleRpcProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5SimpleRpcProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5OpenAuthProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5OpenAuthProviderImpl"));
        providerInfoMap.put(H5RpcProxyProvider.class.getName(), new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5RpcProxyProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5FallbackStreamProvider", new H5ProviderConfig(nebulauc, "com.alipay.mobile.nebulauc.impl.network.provider.UCFallbackStreamProvider"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5WebViewPathProvider", new H5ProviderConfig(nebulauc, "com.alipay.mobile.nebulauc.provider.UcPathProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5AppBizRpcProvider", new H5ProviderConfig(nebulaappproxy, "com.alipay.mobile.nebulaappproxy.provider.WalletAppBizRpcImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.appcenter.download.H5ExternalDownloadManager", new H5ProviderConfig(nebulaappproxy, "com.alipay.mobile.nebulaappproxy.api.download.H5ExternalDownloadManagerImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5PatchProvider", new H5ProviderConfig(nebulaappproxy, "com.alipay.mobile.nebulaappproxy.provider.H5PatchProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5AppSyncDataHandler", new H5ProviderConfig(nebulaappproxy, "com.alipay.mobile.nebulaappproxy.provider.H5AppSyncDataHandlerImpl"));
        providerInfoMap.put(H5ApiManager.class.getName(), new H5ProviderConfig(tinyappservice, "com.alipay.mobile.tinyappservice.tinypermission.H5ApiManagerImpl"));
        providerInfoMap.put(IH5TinyPopMenu.class.getName(), new H5ProviderConfig(tinyappservice, "com.alipay.mobile.tinyappservice.dynamicpanel.H5TinyPopMenu"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5LottieViewProvider", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5LottieViewProviderImpl"));
        providerInfoMap.put("com.alipay.mobile.nebula.provider.H5ErrorPageView", new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5ErrorPageViewImpl"));
        providerInfoMap.put(H5StartParamCheck.class.getName(), new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5StartParamCheckImpl"));
        providerInfoMap.put(H5TimeService.class.getName(), new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5TimeServiceImpl"));
        providerInfoMap.put(H5PermissionManager.class.getName(), new H5ProviderConfig(nebulabiz, "com.alipay.mobile.nebulabiz.provider.H5PermissionManagerImpl"));
    }
}
