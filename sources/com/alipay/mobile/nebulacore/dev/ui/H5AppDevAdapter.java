package com.alipay.mobile.nebulacore.dev.ui;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.List;

public class H5AppDevAdapter extends ArrayAdapter<AppInfo> {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public String appId;
    private LayoutInflater inflater;

    public H5AppDevAdapter(Activity activity2, int i2, List<AppInfo> list, String str) {
        super(activity2, i2, list);
        this.inflater = LayoutInflater.from(activity2);
        this.appId = str;
        this.activity = activity2;
    }

    public void setData(List<AppInfo> list) {
        clear();
        addAll(list);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.h5_app_dev_item, viewGroup, false);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.version = (TextView) view.findViewById(R.id.version);
            viewHolder.deleteAppInfo = (TextView) view.findViewById(R.id.delete_appInfo);
            viewHolder.deleteInstall = (TextView) view.findViewById(R.id.delete_app_install);
            viewHolder.downloadView = (TextView) view.findViewById(R.id.download);
            viewHolder.installView = (TextView) view.findViewById(R.id.install);
            view.setTag(viewHolder);
        }
        final AppInfo appInfo = (AppInfo) getItem(i2);
        viewHolder.version.setText(appInfo.version);
        viewHolder.deleteAppInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppDBService appDBService = ((H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())).getAppDBService();
                if (appDBService != null) {
                    appDBService.deleteAppInfo(H5AppDevAdapter.this.appId, appInfo.version);
                    String str = "delete appInfo success";
                    if (H5DevAppList.getInstance().contains(H5AppDevAdapter.this.appId)) {
                        str = "form dev DB  ".concat(str);
                    }
                    Toast.makeText(H5AppDevAdapter.this.activity, str, 0).show();
                }
            }
        });
        viewHolder.deleteInstall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                if (h5AppProvider != null) {
                    String installPath = h5AppProvider.getInstallPath(H5AppDevAdapter.this.appId, appInfo.version);
                    if (TextUtils.isEmpty(installPath)) {
                        H5Environment.showToast(H5AppDevAdapter.this.activity, H5Environment.getResources().getString(R.string.h5_delete_msg), 1);
                        return;
                    }
                    H5FileUtil.delete(installPath);
                    H5FileUtil.delete(h5AppProvider.getDownloadLocalPath(H5AppDevAdapter.this.appId, appInfo.version));
                    String str = "delete app file success";
                    if (H5DevAppList.getInstance().contains(H5AppDevAdapter.this.appId)) {
                        str = "!!!from dev DB  ".concat(str);
                    }
                    Toast.makeText(H5AppDevAdapter.this.activity, str, 0).show();
                }
            }
        });
        final H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider != null) {
            boolean exists = H5FileUtil.exists(h5AppProvider.getDownloadLocalPath(appInfo.app_id, appInfo.version));
            boolean isInstalled = h5AppProvider.isInstalled(appInfo.app_id, appInfo.version);
            if (exists) {
                viewHolder.downloadView.setText(H5Environment.getResources().getString(R.string.h5_dev_download));
                viewHolder.downloadView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        H5FileUtil.delete(h5AppProvider.getDownloadLocalPath(H5AppDevAdapter.this.appId, appInfo.version));
                        Toast.makeText(H5AppDevAdapter.this.activity, "delete success", 0).show();
                    }
                });
            } else {
                viewHolder.downloadView.setText(H5Environment.getResources().getString(R.string.h5_dev_not_download));
            }
            if (isInstalled) {
                viewHolder.installView.setText(H5Environment.getResources().getString(R.string.h5_dev_install));
                viewHolder.installView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        H5FileUtil.delete(h5AppProvider.getInstallPath(H5AppDevAdapter.this.appId, appInfo.version));
                        Toast.makeText(H5AppDevAdapter.this.activity, "delete success", 0).show();
                    }
                });
            } else {
                viewHolder.installView.setText(H5Environment.getResources().getString(R.string.h5_dev_not_install));
            }
        }
        viewHolder.deleteAppInfo.setText(H5Environment.getResources().getString(R.string.h5_dev_delete_appinfo));
        viewHolder.deleteInstall.setText(H5Environment.getResources().getString(R.string.h5_dev_delete_file));
        return view;
    }

    static class ViewHolder {
        TextView deleteAppInfo;
        TextView deleteInstall;
        TextView downloadView;
        TextView installView;
        TextView version;

        private ViewHolder() {
        }
    }
}
