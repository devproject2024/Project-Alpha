package com.alipay.mobile.nebulacore.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.tabbar.H5PageTabBar;
import com.alipay.mobile.nebulacore.view.H5FontBar;
import com.alipay.mobile.nebulacore.view.H5NavigationBar;

public class H5ViewHolder {
    public static final String TAG = "H5ViewHolder";
    private H5FontBar h5FontBar;
    private H5NavigationBar h5NavBar;
    private H5PageImpl h5Page;
    private H5PageTabBar h5Tabbar;
    private H5TransWebContent h5TransWebContainer;
    private H5WebContent h5WebContainer;
    private View h5WebContent;
    private ViewGroup rootView;

    public H5NavigationBar getH5NavBar() {
        return this.h5NavBar;
    }

    public void setH5NavBar(H5NavigationBar h5NavigationBar) {
        this.h5NavBar = h5NavigationBar;
    }

    public H5PageTabBar getH5Tabbar() {
        return this.h5Tabbar;
    }

    public void setH5Tabbar(H5PageTabBar h5PageTabBar) {
        this.h5Tabbar = h5PageTabBar;
    }

    public H5FontBar getH5FontBar() {
        return this.h5FontBar;
    }

    public void setH5FontBar(H5FontBar h5FontBar2) {
        this.h5FontBar = h5FontBar2;
    }

    public H5WebContent getH5WebContainer() {
        return this.h5WebContainer;
    }

    public void setH5WebContainer(H5WebContent h5WebContent2) {
        this.h5WebContainer = h5WebContent2;
    }

    public H5LoadingView getH5LoadingView() {
        if (getH5WebContainer() != null) {
            return getH5WebContainer().getH5LoadingView();
        }
        return null;
    }

    public H5TransWebContent getH5TransWebContainer() {
        return this.h5TransWebContainer;
    }

    public void setH5TransWebContainer(H5TransWebContent h5TransWebContent) {
        this.h5TransWebContainer = h5TransWebContent;
    }

    public View getH5WebContent() {
        return this.h5WebContent;
    }

    public void setH5WebContent(View view) {
        this.h5WebContent = view;
    }

    public H5PageImpl getH5Page() {
        return this.h5Page;
    }

    public void setH5Page(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
    }

    public ViewGroup getRootView() {
        return this.rootView;
    }

    public void setRootView(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshView() {
        /*
            r11 = this;
            android.view.ViewGroup r0 = r11.rootView
            java.lang.String r1 = "H5ViewHolder"
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "root contentView is null"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r0)
            return
        L_0x000c:
            com.alipay.mobile.nebulacore.core.H5PageImpl r0 = r11.h5Page
            android.os.Bundle r0 = r0.getParams()
            r2 = 0
            java.lang.String r3 = "transparent"
            boolean r3 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r0, (java.lang.String) r3, (boolean) r2)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "transActivityFlag "
            java.lang.String r4 = r5.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r1, r4)
            android.view.ViewGroup r4 = r11.rootView
            r4.removeAllViews()
            r4 = -1
            if (r3 != 0) goto L_0x01ce
            com.alipay.mobile.nebulacore.view.H5NavigationBar r3 = r11.getH5NavBar()
            if (r3 == 0) goto L_0x005d
            com.alipay.mobile.nebulacore.view.H5NavigationBar r3 = r11.getH5NavBar()
            android.view.View r3 = r3.getContent()
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = "add nav bar"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r3)
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r3.<init>(r4, r5)
            r5 = 10
            r3.addRule(r5)
            android.view.ViewGroup r5 = r11.rootView
            com.alipay.mobile.nebulacore.view.H5NavigationBar r6 = r11.getH5NavBar()
            android.view.View r6 = r6.getContent()
            r5.addView(r6, r2, r3)
        L_0x005d:
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r3 = r11.getH5Tabbar()
            if (r3 == 0) goto L_0x009a
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r3 = r11.getH5Tabbar()
            android.view.View r3 = r3.getContent()
            if (r3 == 0) goto L_0x009a
            java.lang.String r3 = "add tab bar"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r3)
            android.content.res.Resources r3 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r5 = com.alipay.mobile.nebulacore.R.dimen.h5_bottom_height_tab
            float r3 = r3.getDimension(r5)
            int r3 = (int) r3
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r4, r3)
            r3 = 12
            r5.addRule(r3)
            android.view.ViewGroup r3 = r11.rootView
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r6 = r11.getH5Tabbar()
            android.view.View r6 = r6.getContent()
            android.view.ViewGroup r7 = r11.rootView
            int r7 = r7.getChildCount()
            r3.addView(r6, r7, r5)
        L_0x009a:
            com.alipay.mobile.nebulacore.ui.H5WebContent r3 = r11.getH5WebContainer()
            if (r3 == 0) goto L_0x01f0
            com.alipay.mobile.nebulacore.ui.H5WebContent r3 = r11.getH5WebContainer()
            android.view.View r3 = r3.getContent()
            if (r3 == 0) goto L_0x01f0
            com.alipay.mobile.nebulacore.ui.H5WebContent r3 = r11.getH5WebContainer()
            android.view.View r3 = r3.getContent()
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r4, r4)
            if (r0 == 0) goto L_0x013b
            java.lang.String r4 = "transparentTitle"
            boolean r6 = r0.containsKey(r4)
            if (r6 == 0) goto L_0x013b
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r4)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x013b
            java.lang.String r6 = "always"
            boolean r6 = android.text.TextUtils.equals(r6, r4)
            r7 = 1
            if (r6 != 0) goto L_0x00e0
            java.lang.String r6 = "auto"
            boolean r6 = android.text.TextUtils.equals(r6, r4)
            if (r6 == 0) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r6 = 0
            goto L_0x00e1
        L_0x00e0:
            r6 = 1
        L_0x00e1:
            java.lang.String r8 = "custom"
            boolean r4 = android.text.TextUtils.equals(r8, r4)
            if (r4 == 0) goto L_0x013c
            java.lang.String r4 = "backBtnImage"
            boolean r8 = r0.containsKey(r4)
            if (r8 == 0) goto L_0x013c
            java.lang.String r8 = "backBtnTextColor"
            boolean r9 = r0.containsKey(r8)
            if (r9 == 0) goto L_0x013c
            java.lang.String r9 = "titleColor"
            boolean r10 = r0.containsKey(r9)
            if (r10 == 0) goto L_0x013c
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r4)
            int r6 = com.alipay.mobile.nebula.util.H5Utils.getInt((android.os.Bundle) r0, (java.lang.String) r8)
            int r8 = com.alipay.mobile.nebula.util.H5Utils.getInt((android.os.Bundle) r0, (java.lang.String) r9)
            java.lang.String r9 = "titlebarBackgroundImagePath"
            java.lang.String r10 = ""
            java.lang.String r9 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r9, (java.lang.String) r10)
            boolean r10 = android.text.TextUtils.isEmpty(r4)
            if (r10 != 0) goto L_0x012e
            java.lang.String r10 = "default"
            boolean r4 = android.text.TextUtils.equals(r4, r10)
            if (r4 == 0) goto L_0x012c
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r6 != r4) goto L_0x012c
            if (r8 != r4) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r4 = 0
            goto L_0x012f
        L_0x012e:
            r4 = 1
        L_0x012f:
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            if (r4 == 0) goto L_0x0138
            if (r6 != 0) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r7 = 0
        L_0x0139:
            r6 = r7
            goto L_0x013c
        L_0x013b:
            r6 = 0
        L_0x013c:
            if (r6 == 0) goto L_0x0169
            java.lang.String r4 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "transTitle:"
            java.lang.String r4 = r6.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r1, r4)
            r1 = 6
            r5.addRule(r1)
            com.alipay.mobile.nebulacore.ui.H5WebContent r1 = r11.getH5WebContainer()
            if (r1 == 0) goto L_0x0196
            com.alipay.mobile.nebulacore.ui.H5WebContent r1 = r11.getH5WebContainer()
            android.content.res.Resources r4 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r6 = com.alipay.mobile.nebulacore.R.dimen.h5_title_height
            float r4 = r4.getDimension(r6)
            int r4 = (int) r4
            r1.setUrlProviderMargin(r4)
            goto L_0x0196
        L_0x0169:
            com.alipay.mobile.nebulacore.view.H5NavigationBar r1 = r11.getH5NavBar()
            if (r1 == 0) goto L_0x0196
            com.alipay.mobile.nebulacore.view.H5NavigationBar r1 = r11.getH5NavBar()
            android.view.View r1 = r1.getContent()
            if (r1 == 0) goto L_0x0196
            r1 = 3
            com.alipay.mobile.nebulacore.view.H5NavigationBar r4 = r11.getH5NavBar()
            android.view.View r4 = r4.getContent()
            int r4 = r4.getId()
            r5.addRule(r1, r4)
            com.alipay.mobile.nebulacore.ui.H5WebContent r1 = r11.getH5WebContainer()
            if (r1 == 0) goto L_0x0196
            com.alipay.mobile.nebulacore.ui.H5WebContent r1 = r11.getH5WebContainer()
            r1.setUrlProviderMargin(r2)
        L_0x0196:
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r1 = r11.getH5Tabbar()
            if (r1 == 0) goto L_0x01b6
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r1 = r11.getH5Tabbar()
            android.view.View r1 = r1.getContent()
            if (r1 == 0) goto L_0x01b6
            r1 = 2
            com.alipay.mobile.nebulacore.tabbar.H5PageTabBar r4 = r11.getH5Tabbar()
            android.view.View r4 = r4.getContent()
            int r4 = r4.getId()
            r5.addRule(r1, r4)
        L_0x01b6:
            android.view.ViewGroup r1 = r11.rootView
            r1.addView(r3, r2, r5)
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.isDelayRender(r0)
            if (r0 == 0) goto L_0x01c6
            android.view.ViewGroup r0 = r11.rootView
            r11.animateRootView(r0)
        L_0x01c6:
            com.alipay.mobile.nebulacore.core.H5PageImpl r0 = r11.h5Page
            if (r0 == 0) goto L_0x01cd
            r0.checkIfShowLoadingView()
        L_0x01cd:
            return
        L_0x01ce:
            com.alipay.mobile.nebulacore.ui.H5TransWebContent r0 = r11.getH5TransWebContainer()
            if (r0 == 0) goto L_0x01f0
            com.alipay.mobile.nebulacore.ui.H5TransWebContent r0 = r11.getH5TransWebContainer()
            android.view.View r0 = r0.getContent()
            if (r0 == 0) goto L_0x01f0
            com.alipay.mobile.nebulacore.ui.H5TransWebContent r0 = r11.getH5TransWebContainer()
            android.view.View r0 = r0.getContent()
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r4, r4)
            android.view.ViewGroup r3 = r11.rootView
            r3.addView(r0, r2, r1)
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5ViewHolder.refreshView():void");
    }

    private void animateRootView(final View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
        alphaAnimation.setDuration(300);
        view.startAnimation(alphaAnimation);
        view.postDelayed(new Runnable() {
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(200);
                view.startAnimation(alphaAnimation);
            }
        }, 300);
    }
}
