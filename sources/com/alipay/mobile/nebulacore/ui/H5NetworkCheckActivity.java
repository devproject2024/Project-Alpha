package com.alipay.mobile.nebulacore.ui;

import com.alipay.mobile.nebulacore.wallet.H5WalletBaseActivity;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class H5NetworkCheckActivity extends H5WalletBaseActivity {
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            int r8 = com.alipay.mobile.nebulacore.R.layout.h5_network_check_activity
            r7.setContentView(r8)
            android.content.Intent r8 = r7.getIntent()
            int r0 = com.alipay.mobile.nebulacore.R.id.h5_error_check_layout
            android.view.View r0 = r7.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            com.alipay.mobile.nebula.provider.H5ProviderManager r1 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5NetworkCheckViewProvider> r2 = com.alipay.mobile.nebula.provider.H5NetworkCheckViewProvider.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r1 = r1.getProvider(r2)
            com.alipay.mobile.nebula.provider.H5NetworkCheckViewProvider r1 = (com.alipay.mobile.nebula.provider.H5NetworkCheckViewProvider) r1
            if (r1 == 0) goto L_0x0031
            android.view.View r1 = r1.getTitleBarView(r7)
            r0.removeAllViews()
            r0.addView(r1)
            goto L_0x0041
        L_0x0031:
            int r0 = com.alipay.mobile.nebulacore.R.id.h5_lv_nav_back
            android.view.View r0 = r7.findViewById(r0)
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            com.alipay.mobile.nebulacore.ui.H5NetworkCheckActivity$1 r1 = new com.alipay.mobile.nebulacore.ui.H5NetworkCheckActivity$1
            r1.<init>()
            r0.setOnClickListener(r1)
        L_0x0041:
            int r0 = com.alipay.mobile.nebulacore.R.id.error_code
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "error_code"
            java.lang.String r2 = r8.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x005d
            java.lang.String r1 = r8.getStringExtra(r1)
            r0.append(r1)
            goto L_0x006a
        L_0x005d:
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r1 = r1.getString(r2)
            r0.append(r1)
        L_0x006a:
            int r0 = com.alipay.mobile.nebulacore.R.id.url
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "url"
            java.lang.String r2 = r8.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0087
            java.lang.String r1 = r8.getStringExtra(r1)
            r0.append(r1)
            goto L_0x0094
        L_0x0087:
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r1 = r1.getString(r2)
            r0.append(r1)
        L_0x0094:
            java.lang.String r0 = "wifi"
            java.lang.Object r0 = r7.getSystemService(r0)
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L_0x00a9
            int r2 = r0.getWifiState()
            android.net.DhcpInfo r1 = r0.getDhcpInfo()
        L_0x00a9:
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r7.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x00c1
            java.lang.String r0 = r0.getExtraInfo()
            if (r0 != 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r3 = r0
        L_0x00c1:
            int r0 = com.alipay.mobile.nebulacore.R.id.state
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.res.Resources r4 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            if (r4 == 0) goto L_0x01c0
            int r5 = com.alipay.mobile.nebulacore.R.string.h5_network_check_wifi
            java.lang.String r5 = r4.getString(r5)
            r0.append(r5)
            if (r2 == 0) goto L_0x010b
            r5 = 1
            if (r2 == r5) goto L_0x0101
            r5 = 2
            if (r2 == r5) goto L_0x00f7
            r5 = 3
            if (r2 == r5) goto L_0x00ed
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
            goto L_0x0114
        L_0x00ed:
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_enabled
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
            goto L_0x0114
        L_0x00f7:
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_enabling
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
            goto L_0x0114
        L_0x0101:
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_disabled
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
            goto L_0x0114
        L_0x010b:
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_disabling
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
        L_0x0114:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "\n"
            r2.<init>(r5)
            int r6 = com.alipay.mobile.nebulacore.R.string.h5_network_check_gate
            java.lang.String r6 = r4.getString(r6)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            if (r1 == 0) goto L_0x013d
            int r2 = r1.gateway
            java.lang.String r2 = r7.intToIp(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x013d
            r0.append(r2)
            goto L_0x0146
        L_0x013d:
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
        L_0x0146:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            int r5 = com.alipay.mobile.nebulacore.R.string.h5_network_check_apn
            java.lang.String r5 = r4.getString(r5)
            r2.append(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 == 0) goto L_0x0160
            int r3 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r3 = r4.getString(r3)
        L_0x0160:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            int r0 = com.alipay.mobile.nebulacore.R.id.dns
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_network_check_ip
            java.lang.String r2 = r4.getString(r2)
            r0.append(r2)
            if (r1 == 0) goto L_0x018d
            int r1 = r1.ipAddress
            java.lang.String r1 = r7.intToIp(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x018d
            r0.append(r1)
            goto L_0x0196
        L_0x018d:
            int r1 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r1 = r4.getString(r1)
            r0.append(r1)
        L_0x0196:
            int r0 = com.alipay.mobile.nebulacore.R.id.reason
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "reason"
            java.lang.String r8 = r8.getStringExtra(r1)
            int r1 = com.alipay.mobile.nebulacore.R.string.h5_network_check_reason
            java.lang.String r1 = r4.getString(r1)
            r0.append(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x01bd
            int r8 = com.alipay.mobile.nebulacore.R.string.h5_network_check_unknow
            java.lang.String r8 = r4.getString(r8)
            r0.append(r8)
            return
        L_0x01bd:
            r0.append(r8)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5NetworkCheckActivity.onCreate(android.os.Bundle):void");
    }

    private String intToIp(int i2) {
        return (i2 & PriceRangeSeekBar.INVALID_POINTER_ID) + AppUtility.CENTER_DOT + ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID) + AppUtility.CENTER_DOT + ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID) + AppUtility.CENTER_DOT + ((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
    }
}
