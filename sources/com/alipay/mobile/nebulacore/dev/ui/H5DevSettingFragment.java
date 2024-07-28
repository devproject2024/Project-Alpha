package com.alipay.mobile.nebulacore.dev.ui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.view.H5Dialog;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H5DevSettingFragment extends Fragment {
    public static final String TAG = "H5DevSettingFragment";
    /* access modifiers changed from: private */
    public EditText appUrlEdit;
    private Button buttonDoApp;
    private Button buttonGetAppInfo;
    private Button buttonH5Rpc;
    private Button configEdit;
    private Button copyDb;
    /* access modifiers changed from: private */
    public EditText editAppId;
    private Button getConfig;
    private Button getDbConfig;
    private Button offline;
    private Button perfTool;
    private Button startAppBtn;
    private Button testCase;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.h5_dev_setting_layout, viewGroup, false);
        initView(inflate);
        initClick();
        return inflate;
    }

    private void initView(View view) {
        this.editAppId = (EditText) view.findViewById(R.id.h5_edit_appId);
        this.buttonGetAppInfo = (Button) view.findViewById(R.id.h5_show_appInfo);
        this.buttonH5Rpc = (Button) view.findViewById(R.id.h5_rpc);
        this.buttonDoApp = (Button) view.findViewById(R.id.h5_do_app);
        this.startAppBtn = (Button) view.findViewById(R.id.h5_startApp);
        this.appUrlEdit = (EditText) view.findViewById(R.id.h5_load_app_url);
        this.getConfig = (Button) view.findViewById(R.id.h5_get_config);
        this.getDbConfig = (Button) view.findViewById(R.id.h5_app_config);
        this.perfTool = (Button) view.findViewById(R.id.h5_perf_tool);
        this.configEdit = (Button) view.findViewById(R.id.config_edit);
        this.offline = (Button) view.findViewById(R.id.h5_offline);
        this.copyDb = (Button) view.findViewById(R.id.h5_copyDB);
        this.testCase = (Button) view.findViewById(R.id.h5_test_case);
    }

    private void initClick() {
        this.buttonGetAppInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppCenterService h5AppCenterService;
                if (!TextUtils.isEmpty(H5DevSettingFragment.this.editAppId.getText()) && (h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())) != null) {
                    String highestAppVersion = h5AppCenterService.getAppDBService().getHighestAppVersion(H5DevSettingFragment.this.editAppId.getText().toString());
                    if (!TextUtils.isEmpty(highestAppVersion)) {
                        H5Dialog h5Dialog = new H5Dialog(H5DevSettingFragment.this.getActivity());
                        AppInfo appInfo = h5AppCenterService.getAppDBService().getAppInfo(H5DevSettingFragment.this.editAppId.getText().toString(), highestAppVersion);
                        if (appInfo != null) {
                            String str = H5DevAppList.getInstance().contains(H5DevSettingFragment.this.editAppId.getText().toString()) ? "!!!data from dev DB " : "";
                            h5Dialog.setMessage((CharSequence) str + appInfo.toString());
                            H5Log.d(H5DevSettingFragment.TAG, appInfo.toString());
                            h5Dialog.show();
                            H5DevSettingFragment.preInstallTinyApp(H5DevSettingFragment.this.editAppId.getText().toString());
                            return;
                        }
                    }
                    H5Dialog h5Dialog2 = new H5Dialog(H5DevSettingFragment.this.getActivity());
                    h5Dialog2.setMessage((CharSequence) "appInfo is null");
                    h5Dialog2.show();
                }
            }
        });
        this.buttonH5Rpc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                if (h5AppProvider != null) {
                    final ProgressDialog progressDialog = new ProgressDialog(H5DevSettingFragment.this.getActivity());
                    progressDialog.setTitle("request...");
                    progressDialog.show();
                    String obj = H5DevSettingFragment.this.editAppId.getText().toString();
                    AnonymousClass1 r3 = new H5AppInstallProcess() {
                        public void prepare(H5AppInstallStep h5AppInstallStep, String str) {
                        }

                        public void onResult(final boolean z, boolean z2) {
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    if (H5DevSettingFragment.this.getActivity() != null && !H5DevSettingFragment.this.getActivity().isFinishing()) {
                                        progressDialog.dismiss();
                                        H5Dialog h5Dialog = new H5Dialog(H5DevSettingFragment.this.getActivity());
                                        h5Dialog.setMessage((CharSequence) "req result " + z);
                                        h5Dialog.show();
                                    }
                                }
                            });
                        }
                    };
                    if (!TextUtils.isEmpty(obj)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(obj, h5AppProvider.getWalletConfigNebulaVersion(obj));
                        h5AppProvider.updateApp(hashMap, true, r3, true, true);
                        return;
                    }
                    h5AppProvider.startUpdateAllApp(r3);
                }
            }
        });
        this.buttonDoApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppDBService appDBService = ((H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())).getAppDBService();
                String obj = H5DevSettingFragment.this.editAppId.getText().toString();
                if (TextUtils.isEmpty(H5DevSettingFragment.this.editAppId.getText())) {
                    Toast.makeText(H5Utils.getContext(), "appId is null", 0).show();
                } else if (appDBService != null) {
                    Map<String, List<AppInfo>> allApp = appDBService.getAllApp();
                    if (allApp == null || allApp.isEmpty()) {
                        Toast.makeText(H5Utils.getContext(), "get appInfo is null", 0).show();
                        return;
                    }
                    List list = allApp.get(H5DevSettingFragment.this.editAppId.getText().toString());
                    if (list != null) {
                        ListView listView = new ListView(H5DevSettingFragment.this.getActivity());
                        listView.setAdapter(new H5AppDevAdapter(H5DevSettingFragment.this.getActivity(), R.layout.h5_app_dev_item, list, obj));
                        AlertDialog create = new AlertDialog.Builder(H5DevSettingFragment.this.getActivity()).create();
                        create.show();
                        Window window = create.getWindow();
                        listView.setBackgroundColor(-1);
                        if (window != null) {
                            window.setContentView(listView);
                        }
                        create.setCanceledOnTouchOutside(false);
                    }
                }
            }
        });
        this.startAppBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(H5DevSettingFragment.this.editAppId.getText())) {
                    Toast.makeText(H5Utils.getContext(), "appId is null", 0).show();
                    return;
                }
                String obj = H5DevSettingFragment.this.appUrlEdit.getText().toString();
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(obj)) {
                    bundle.putString("url", obj);
                }
                b.a();
                b.a().f14954a.a((String) null, H5DevSettingFragment.this.editAppId.getText().toString(), bundle);
            }
        });
        this.getConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String config = H5Environment.getConfig(H5ConfigProvider.KEY_SSO_ALI_WHITE_LIST_DOMAINS);
                String config2 = H5Environment.getConfig(H5ConfigProvider.KEY_SSO_ALIPAY_WHITE_LIST_DOMAINS);
                String config3 = H5Environment.getConfig(H5ConfigProvider.KEY_SSO_SERIOUS_ALI_WHITE_LIST_DOMAINS);
                String config4 = H5Environment.getConfig(H5ConfigProvider.KEY_SSO_PARTNER_WHITE_LIST_DOMAINS);
                String config5 = H5Environment.getConfig(H5ConfigProvider.KEY_SSO_RPC_WHITE_LIST_DOMAINS);
                H5Dialog h5Dialog = new H5Dialog(H5DevSettingFragment.this.getActivity());
                h5Dialog.setMessage((CharSequence) "config h5_AliWhiteList " + config + "\nconfig h5_AlipayWhiteList " + config2 + "\nconfig h5_SeriousAliWhiteList " + config3 + "\nconfig h5_PartnerWhiteList " + config4 + "\nconfig h5_SeriousAliWhiteList " + config3 + "\nconfig h5_rpcWhiteList " + config5 + StringUtility.NEW_LINE);
                h5Dialog.show();
            }
        });
        this.getDbConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
                if (h5AppCenterService != null) {
                    double normalReqRate = h5AppCenterService.getAppDBService().getNormalReqRate();
                    double limitReqRate = h5AppCenterService.getAppDBService().getLimitReqRate();
                    String configExtra = h5AppCenterService.getAppDBService().getConfigExtra();
                    H5Dialog h5Dialog = new H5Dialog(H5DevSettingFragment.this.getActivity());
                    h5Dialog.setMessage((CharSequence) "normalReqRate " + normalReqRate + " limitReqRate:" + limitReqRate + " config:" + configExtra);
                    h5Dialog.show();
                }
            }
        });
        this.perfTool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5DevSettingFragment.this.openPage("http://h5test.inc.alipay.net/perf/h5performance.html");
            }
        });
        this.configEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5DevSettingFragment.this.getActivity().startActivity(new Intent(H5DevSettingFragment.this.getActivity(), H5DevConfigEditActivity.class));
            }
        });
        this.offline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(H5DevSettingFragment.this.editAppId.getText())) {
                    Toast.makeText(H5Utils.getContext(), "appId is null", 0).show();
                    return;
                }
                H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                if (h5AppProvider != null) {
                    h5AppProvider.offlineFromOpenPlat(H5DevSettingFragment.this.editAppId.getText().toString());
                }
                Toast.makeText(H5Utils.getContext(), H5Environment.getResources().getString(R.string.h5_offline_success), 0).show();
            }
        });
        this.copyDb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                    public void run() {
                        final File copyDataBaseToSD = H5DevSettingFragment.copyDataBaseToSD();
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                Toast.makeText(H5Utils.getContext(), H5Environment.getResources().getString(R.string.h5_save_db_success), 0).show();
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(copyDataBaseToSD));
                                intent.setType("*/*");
                                H5DevSettingFragment.this.startActivity(Intent.createChooser(intent, AppConstants.SHARE));
                            }
                        });
                    }
                });
            }
        });
        this.testCase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5DevSettingFragment.this.openPage("http://h5test.inc.alipay.net/case/index.html?__webview_options__=so%3DNO%26pd%3DNO");
            }
        });
    }

    /* access modifiers changed from: private */
    public static void preInstallTinyApp(String str) {
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null) {
            final String tinyCommonApp = h5AppCenterPresetProvider.getTinyCommonApp();
            if (TextUtils.equals(tinyCommonApp, str)) {
                H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                    public final void run() {
                        if (!TextUtils.isEmpty(tinyCommonApp)) {
                            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                            String version = h5AppProvider.getVersion(tinyCommonApp);
                            if (!h5AppProvider.isInstalled(tinyCommonApp, version)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                boolean isAvailable = h5AppProvider.isAvailable(tinyCommonApp, version);
                                if (isAvailable) {
                                    h5AppProvider.installApp(tinyCommonApp, version);
                                } else {
                                    h5AppProvider.downloadApp(tinyCommonApp, version);
                                }
                                H5Log.d(H5DevSettingFragment.TAG, "TinyCommonApp is not install  isAvailable: " + isAvailable + " " + (System.currentTimeMillis() - currentTimeMillis));
                                return;
                            }
                            H5Log.d(H5DevSettingFragment.TAG, "TinyCommonApp is install");
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082 A[SYNTHETIC, Splitter:B:25:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a A[Catch:{ IOException -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095 A[SYNTHETIC, Splitter:B:35:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d A[Catch:{ IOException -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File copyDataBaseToSD() {
        /*
            java.lang.String r0 = "H5DevSettingFragment"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0010
            return r2
        L_0x0010:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = com.alipay.mobile.nebula.util.H5Utils.getContext()
            java.lang.String r5 = "nebula_app"
            java.io.File r4 = r4.getDatabasePath(r5)
            r3.append(r4)
            java.lang.String r4 = ".db"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            java.io.File r3 = new java.io.File
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r5 = "nebula_app.db"
            r3.<init>(r4, r5)
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.io.File) r3)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            r3.createNewFile()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.nio.channels.FileChannel r1 = r4.getChannel()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
            r6 = 0
            long r8 = r1.size()     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
            r5 = r1
            r10 = r2
            r5.transferTo(r6, r8, r10)     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
            if (r1 == 0) goto L_0x0063
            r1.close()     // Catch:{ IOException -> 0x0086 }
        L_0x0063:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0091
        L_0x0069:
            r3 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x0093
        L_0x006e:
            r4 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x0078
        L_0x0073:
            r3 = move-exception
            r1 = r2
            goto L_0x0093
        L_0x0076:
            r4 = move-exception
            r1 = r2
        L_0x0078:
            java.lang.String r5 = "copy dataBase to SD error."
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0092 }
            r4.printStackTrace()     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x0088
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0088
        L_0x0086:
            r1 = move-exception
            goto L_0x008e
        L_0x0088:
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0091
        L_0x008e:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0091:
            return r3
        L_0x0092:
            r3 = move-exception
        L_0x0093:
            if (r2 == 0) goto L_0x009b
            r2.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009b
        L_0x0099:
            r1 = move-exception
            goto L_0x00a1
        L_0x009b:
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x00a4
        L_0x00a1:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x00a4:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.dev.ui.H5DevSettingFragment.copyDataBaseToSD():java.io.File");
    }

    /* access modifiers changed from: private */
    public void openPage(String str) {
        try {
            H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
            if (h5Service != null) {
                Bundle bundle = new Bundle();
                bundle.putString("url", str);
                H5Bundle h5Bundle = new H5Bundle();
                h5Bundle.setParams(bundle);
                h5Service.startPage((f) null, h5Bundle);
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th.getMessage());
        }
    }
}
