package com.alipay.mobile.nebulacore.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.widget.TextView;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.BaseTitleBarPlugin;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5SimpleRpcListener;
import com.alipay.mobile.nebula.provider.H5SharePanelProvider;
import com.alipay.mobile.nebula.provider.H5TransStatusBarColorProvider;
import com.alipay.mobile.nebula.provider.H5ViewProvider;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebula.search.H5InputListen;
import com.alipay.mobile.nebula.search.H5SearchView;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5NavMenuItem;
import com.alipay.mobile.nebula.view.H5TitleView;
import com.alipay.mobile.nebula.view.IH5TinyPopMenu;
import com.alipay.mobile.nebula.webview.H5ScrollChangedCallback;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.search.H5SearchInputListen;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class H5NavigationBar extends H5SimplePlugin {
    private static final String BROADCAST_TITLE_URL = "com.alipay.mobile.h5container.titleRefreshed";
    public static final String FILE_ANDROID_ASSET_PREFIX = "file:///android_asset/";
    private static final String H5_CONFIG_NEW_LOADPAGE = "h5_newloadpage";
    private static final String H5_PAGE_ERROR_FOR_TITLEBAR = "h5PageErrorForTitlebar";
    private static final int KEEP_RATIO = 1;
    private static final String SET_BAR_BOTTOM_LINE_COLOR = "setBarBottomLineColor";
    private static final String SET_TRANSPARENT_TITLE = "setTransparentTitle";
    private static final int STRETCH = 0;
    private static final String TAG = "H5NavigationBar";
    private static final String TRANSPARENT_ALWAYS = "always";
    private static final String TRANSPARENT_AUTO = "auto";
    private static final Map<String, Integer> blueIconFontMap = new HashMap();
    private static final Map<String, Integer> whiteIconFontMap = new HashMap();
    private float alpha;
    private String appId;
    /* access modifiers changed from: private */
    public ColorDrawable contentBgDrawable;
    private View contentView;
    private String defaultTitle;
    /* access modifiers changed from: private */
    public int delayDy;
    /* access modifiers changed from: private */
    public int finalMaxScrollHeight;
    /* access modifiers changed from: private */
    public int finalScale = 1;
    private H5NavMenu h5NavMenu;
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private H5NavMenu h5PopMenu;
    private H5SharePanelProvider h5SharePanelProvider;
    /* access modifiers changed from: private */
    public IH5TinyPopMenu h5TinyPopMenu;
    private View h5TitleDivider;
    private View h5TitleHDivider;
    /* access modifiers changed from: private */
    public H5TitleView h5TitleView;
    private String[] icontype;
    private boolean ifImageTitle;
    private boolean ignorePageTitleFromCallbacks;
    private boolean isPageError = false;
    private boolean isPageFinished = false;
    private boolean isSwitchMode = false;
    private boolean isTinyApp;
    private Drawable mContentBgImage = null;
    private Context mContext;
    private boolean mShowVerticalDivider = true;
    private boolean optionMenuPreventDefault = false;
    private boolean pageStarted;
    private boolean preventScrollTrans = false;
    private boolean preventSetTitleColor = false;
    private boolean readTitle;
    private boolean scrollWithTitleText = false;
    /* access modifiers changed from: private */
    public View searchView = null;
    /* access modifiers changed from: private */
    public int switchThemePoint;
    private boolean transTitle;
    private String transparentTitle = "";
    private boolean useSearch = false;
    private String version;
    private H5ViewHolder viewHolder;

    static {
        blueIconFontMap.put(StringSet.user, Integer.valueOf(R.drawable.h5_user));
        blueIconFontMap.put("info", Integer.valueOf(R.drawable.h5_info));
        blueIconFontMap.put("locate", Integer.valueOf(R.drawable.h5_locate));
        blueIconFontMap.put("add", Integer.valueOf(R.drawable.h5_plus));
        blueIconFontMap.put("scan", Integer.valueOf(R.drawable.h5_richscan));
        blueIconFontMap.put("search", Integer.valueOf(R.drawable.h5_search));
        blueIconFontMap.put("settings", Integer.valueOf(R.drawable.h5_settings));
        blueIconFontMap.put("help", Integer.valueOf(R.drawable.h5_help));
        blueIconFontMap.put(StringSet.filter, Integer.valueOf(R.drawable.h5_filter));
        blueIconFontMap.put("mail", Integer.valueOf(R.drawable.h5_mail));
        blueIconFontMap.put("more", Integer.valueOf(com.alipay.mobile.nebula.R.drawable.h5_titlebar_more_normal));
        whiteIconFontMap.put(StringSet.user, Integer.valueOf(R.drawable.h5_userw));
        whiteIconFontMap.put("info", Integer.valueOf(R.drawable.h5_infow));
        whiteIconFontMap.put("locate", Integer.valueOf(R.drawable.h5_locatew));
        whiteIconFontMap.put("add", Integer.valueOf(R.drawable.h5_plusw));
        whiteIconFontMap.put("scan", Integer.valueOf(R.drawable.h5_richscanw));
        whiteIconFontMap.put("search", Integer.valueOf(R.drawable.h5_searchw));
        whiteIconFontMap.put("settings", Integer.valueOf(R.drawable.h5_settingsw));
        whiteIconFontMap.put("help", Integer.valueOf(R.drawable.h5_helpw));
        whiteIconFontMap.put(StringSet.filter, Integer.valueOf(R.drawable.h5_filterw));
        whiteIconFontMap.put("mail", Integer.valueOf(R.drawable.h5_mailw));
        whiteIconFontMap.put("more", Integer.valueOf(com.alipay.mobile.nebula.R.drawable.h5_white_titlebar_more_normal));
    }

    public H5NavigationBar(Context context, Bundle bundle, H5ViewHolder h5ViewHolder) {
        this.mContext = context;
        this.ignorePageTitleFromCallbacks = false;
        this.ifImageTitle = false;
        this.pageStarted = false;
        this.viewHolder = h5ViewHolder;
        H5ViewProvider h5ViewProvider = (H5ViewProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ViewProvider.class.getName());
        if (h5ViewProvider != null) {
            this.h5TitleView = h5ViewProvider.createTitleView(context);
        }
        if (this.h5TitleView == null) {
            this.h5TitleView = new BaseTitleBarPlugin(context) {
            };
        }
        this.contentView = this.h5TitleView.getContentView();
        this.h5TitleDivider = this.h5TitleView.getDivider();
        this.contentView.setTag("h5_titlebar");
        this.contentBgDrawable = this.h5TitleView.getContentBgView();
        this.h5TitleView.setOptionType(H5Param.OptionType.MENU, 2, false);
        String string = H5Utils.getString(bundle, H5Param.LONG_NAV_SEARCH_BAR_TYPE);
        if (H5Utils.getBoolean(bundle, H5Param.LONG_PACKAGE_LOADING_SHOWN, false) && !"no".equalsIgnoreCase(H5Environment.getConfig(H5_CONFIG_NEW_LOADPAGE))) {
            this.h5TitleView.setTitle(H5Utils.getString(bundle, "walletAppName"));
        }
        if (!TextUtils.isEmpty(string)) {
            H5Log.d(TAG, "navSearchBarType:".concat(String.valueOf(string)));
            this.useSearch = true;
            this.searchView = this.h5TitleView.setTitleBarSearch(bundle);
        }
        showClose(false);
        this.h5NavMenu = new H5NavMenu(context);
        this.isTinyApp = H5Utils.getBoolean(bundle, H5Param.isTinyApp, false);
        this.h5PopMenu = new H5NavMenu(context);
        this.appId = H5Utils.getString(bundle, "appId");
        this.version = H5Utils.getString(bundle, "appVersion");
    }

    public H5SharePanelProvider getH5SharePanelProvider() {
        if (this.h5SharePanelProvider == null) {
            this.h5SharePanelProvider = (H5SharePanelProvider) Nebula.getProviderManager().getProvider(H5SharePanelProvider.class.getName());
        }
        return this.h5SharePanelProvider;
    }

    public void setPage(H5Page h5Page2) {
        int i2;
        boolean z;
        View view;
        H5Page h5Page3 = h5Page2;
        this.preventSetTitleColor = false;
        this.h5Page = h5Page3;
        h5Page3.setH5TitleBar(this.h5TitleView);
        if (this.useSearch) {
            Nebula.getProviderManager().setProvider(H5InputListen.class.getName(), new H5SearchInputListen(h5Page3));
        }
        this.h5NavMenu.setPage(h5Page3);
        this.h5PopMenu.setPage(h5Page3);
        if (needTinyPopMenu(h5Page2)) {
            getTinyPopMenuData(this.mContext);
            View optionMenuContainer = this.h5TitleView.getOptionMenuContainer();
            if (optionMenuContainer != null) {
                optionMenuContainer.setVisibility(8);
            }
        }
        this.h5TitleView.setH5Page(h5Page3);
        Bundle params = h5Page2.getParams();
        boolean z2 = H5Utils.getBoolean(params, "showOptionMenu", true);
        if (!this.isSwitchMode) {
            showNavOptions(z2);
        }
        this.readTitle = H5Utils.getBoolean(params, "readTitle", true);
        showReportBtn(H5Utils.getBoolean(params, "showReportBtn", false), (H5BridgeContext) null);
        e eVar = new e();
        String string = H5Utils.getString(params, H5Param.LONG_TITLE_IMAGE);
        if (!TextUtils.isEmpty(string)) {
            eVar.put(H5ResourceHandlerUtil.IMAGE, (Object) string);
            eVar.put("fromJS", (Object) Boolean.FALSE);
            setTitle(eVar);
        } else {
            String string2 = H5Utils.getString(params, H5Param.LONG_DEFAULT_TITLE);
            if (!TextUtils.isEmpty(string2)) {
                eVar.put("title", (Object) string2);
                eVar.put("fromJS", (Object) Boolean.FALSE);
                setTitle(eVar);
            }
        }
        if (!H5Utils.getBoolean(params, H5Param.LONG_SHOW_TITLEBAR, true) && !H5Environment.isInWallet()) {
            showTitleBar(false);
        }
        showTitleLoading(H5Utils.getBoolean(params, "showTitleLoading", false), (H5BridgeContext) null);
        this.transTitle = false;
        if (params != null && params.containsKey(H5Param.LONG_TRANSPARENT_TITLE)) {
            this.transparentTitle = H5Utils.getString(params, H5Param.LONG_TRANSPARENT_TITLE);
            if (!TextUtils.isEmpty(this.transparentTitle)) {
                this.transTitle = TextUtils.equals(TRANSPARENT_ALWAYS, this.transparentTitle) || TextUtils.equals(TRANSPARENT_AUTO, this.transparentTitle);
                if (TextUtils.equals("custom", this.transparentTitle) && params.containsKey(H5Param.LONG_BACKBTN_IMAGE) && params.containsKey(H5Param.LONG_BACKBTN_TEXTCOLOR) && params.containsKey(H5Param.LONG_TITLE_COLOR)) {
                    String string3 = H5Utils.getString(params, H5Param.LONG_BACKBTN_IMAGE);
                    this.transTitle = (TextUtils.isEmpty(string3) || (TextUtils.equals(string3, "default") && H5Utils.getInt(params, H5Param.LONG_BACKBTN_TEXTCOLOR) == -16777216 && H5Utils.getInt(params, H5Param.LONG_TITLE_COLOR) == -16777216)) && !(TextUtils.isEmpty(H5Utils.getString(params, H5Param.TITLEBAR_BACKGROUND_IMAGE_PATH, "")) ^ true);
                }
                H5Log.d(TAG, "transTitle is " + this.transTitle);
            }
        }
        int i3 = H5Utils.getInt(params, H5Param.LONG_TITLE_BAR_COLOR, -16777216) | -16777216;
        if (i3 != -16777216) {
            setContentBgViewColor(i3);
            this.h5TitleDivider.setBackgroundColor(i3);
            if (i3 != -1) {
                this.h5TitleView.switchToWhiteTheme();
                switchIconFontToWhiteTheme();
            } else {
                this.h5TitleView.switchToBlueTheme();
                switchIconFontToBlueTheme();
            }
        }
        int color = this.contentBgDrawable.getColor() | -16777216;
        if (this.transTitle) {
            if (!(this.mContentBgImage == null || (view = this.contentView) == null)) {
                view.setBackgroundDrawable(this.contentBgDrawable);
            }
            if (TextUtils.equals(this.transparentTitle, TRANSPARENT_AUTO)) {
                this.finalMaxScrollHeight = H5Utils.getInt(params, H5Param.LONG_TITLE_SCROLLDISTANCE);
                int i4 = this.finalMaxScrollHeight / PriceRangeSeekBar.INVALID_POINTER_ID;
                if (i4 == 0) {
                    i4 = 1;
                }
                this.finalScale = i4;
                this.switchThemePoint = (this.finalMaxScrollHeight * 3) / 4;
                H5Log.d(TAG, "transparentTitleBar finalMaxScrollHeight is " + this.finalMaxScrollHeight + ", switchThemePoint is " + this.switchThemePoint);
                z = false;
                this.preventScrollTrans = false;
                calAlphaValue(this.finalMaxScrollHeight, this.finalScale, false);
                switchTheme(color, this.switchThemePoint, false);
                this.delayDy = h5Page2.getWebView().getScrollY();
                if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Utils.getString(params, H5Param.LONG_TRANSPARENT_TITLE_TEXTAUTO))) {
                    this.scrollWithTitleText = true;
                } else {
                    this.scrollWithTitleText = false;
                }
            } else {
                z = false;
                this.alpha = 0.0f;
                this.preventScrollTrans = true;
                this.scrollWithTitleText = false;
            }
            i2 = 8;
            this.h5TitleHDivider.setVisibility(8);
            this.h5TitleHDivider = this.h5TitleView.getHdividerInTitle();
            this.h5TitleHDivider.setVisibility(z ? 1 : 0);
            boolean z3 = H5Utils.getBoolean(h5Page2.getParams(), Nebula.HAS_H5_PKG, z);
            if (color != -1) {
                this.h5TitleHDivider.setBackgroundColor(color);
            } else {
                this.h5TitleHDivider.setBackgroundColor(Color.parseColor("#C6C8C9") | -16777216);
                if (!TextUtils.equals(this.transparentTitle, "custom")) {
                    H5Log.d(TAG, "transTitle appid " + this.appId + ", appVersion " + this.version + ", hasPackage " + z3);
                    if (z3) {
                        this.h5TitleView.switchToWhiteTheme();
                        switchIconFontToWhiteTheme();
                    } else if (!this.isSwitchMode) {
                        this.h5TitleView.switchToBlueTheme();
                        switchIconFontToBlueTheme();
                    }
                }
            }
            transparentTitleBar(this.transparentTitle, params);
        } else {
            i2 = 8;
            this.alpha = 1.0f;
            if (color != -1) {
                this.h5TitleHDivider.setBackgroundColor(color);
            } else {
                this.h5TitleHDivider.setBackgroundColor(Color.parseColor("#C6C8C9") | -16777216);
                this.h5TitleView.switchToBlueTheme();
                switchIconFontToBlueTheme();
            }
            setTitleAlpha();
            this.preventScrollTrans = true;
            this.scrollWithTitleText = false;
            if (params.containsKey(H5Param.LONG_BACKBTN_IMAGE) && params.containsKey(H5Param.LONG_BACKBTN_TEXTCOLOR) && params.containsKey(H5Param.LONG_TITLE_COLOR)) {
                String string4 = H5Utils.getString(params, H5Param.LONG_BACKBTN_IMAGE);
                int i5 = H5Utils.getInt(params, H5Param.LONG_BACKBTN_TEXTCOLOR);
                int i6 = H5Utils.getInt(params, H5Param.LONG_TITLE_COLOR);
                if (!(TextUtils.equals(string4, "default") || i5 == -16777216 || i6 == -16777216)) {
                    this.preventSetTitleColor = true;
                    this.h5TitleView.setBackCloseBtnImage(string4);
                    this.h5TitleView.setTitleTxtColor(i6);
                }
            }
            setBackgroundDrawableFor(this.contentView, params);
        }
        this.mShowVerticalDivider = H5Utils.getBoolean(params, H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, true);
        View view2 = this.h5TitleDivider;
        if (this.mShowVerticalDivider) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        if (this.h5TitleView != null && Nebula.useH5StatusBar(h5Page2)) {
            int i7 = 1325400064;
            H5TransStatusBarColorProvider h5TransStatusBarColorProvider = (H5TransStatusBarColorProvider) Nebula.getProviderManager().getProvider(H5TransStatusBarColorProvider.class.getName());
            if (h5TransStatusBarColorProvider != null) {
                i7 = h5TransStatusBarColorProvider.getColor();
            }
            this.h5TitleView.openTranslucentStatusBarSupport(i7);
        }
        this.isSwitchMode = false;
    }

    private void transparentTitleBar(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            setTitleAlpha();
            if (TextUtils.equals(str, TRANSPARENT_AUTO)) {
                this.h5Page.getWebView().setOnScrollChangedCallback(new H5ScrollChangedCallback() {
                    public void onScroll(int i2, int i3) {
                        H5SearchView h5SearchView;
                        H5NavigationBar h5NavigationBar = H5NavigationBar.this;
                        int unused = h5NavigationBar.delayDy = h5NavigationBar.delayDy + i3;
                        H5NavigationBar h5NavigationBar2 = H5NavigationBar.this;
                        h5NavigationBar2.calAlphaValue(h5NavigationBar2.finalMaxScrollHeight, H5NavigationBar.this.finalScale, true);
                        int color = H5NavigationBar.this.contentBgDrawable.getColor() | -16777216;
                        if (!(H5NavigationBar.this.searchView == null || (h5SearchView = (H5SearchView) Nebula.getProviderManager().getProvider(H5SearchView.class.getName())) == null)) {
                            h5SearchView.setSearchBarColor(color);
                        }
                        H5NavigationBar h5NavigationBar3 = H5NavigationBar.this;
                        h5NavigationBar3.switchTheme(color, h5NavigationBar3.switchThemePoint, true);
                    }
                });
            }
            if (TextUtils.equals(str, "custom")) {
                String string = H5Utils.getString(bundle, H5Param.LONG_BACKBTN_IMAGE, "");
                int i2 = H5Utils.getInt(bundle, H5Param.LONG_TITLE_COLOR);
                this.h5TitleView.setBackCloseBtnImage(string);
                this.h5TitleView.setTitleTxtColor(i2);
            }
        }
    }

    public void setBackgroundDrawableFor(View view, Bundle bundle) {
        if (view != null) {
            String string = H5Utils.getString(bundle, H5Param.TITLEBAR_BACKGROUND_IMAGE_PATH, "");
            if (!TextUtils.isEmpty(string)) {
                if (this.mContentBgImage == null) {
                    this.mContentBgImage = createBackgroundDrawable(string);
                }
                Drawable drawable = this.mContentBgImage;
                if (drawable != null) {
                    view.setBackgroundDrawable(drawable);
                }
            }
        }
    }

    private Drawable createBackgroundDrawable(String str) {
        H5Log.d("open titlebar background image ".concat(String.valueOf(str)));
        if (str.startsWith(FILE_ANDROID_ASSET_PREFIX)) {
            return createDrawableFromAssets(str.replace(FILE_ANDROID_ASSET_PREFIX, ""));
        }
        return createDrawableFromExternalFile(str);
    }

    private Drawable createDrawableFromAssets(String str) {
        InputStream inputStream;
        Drawable drawable = null;
        try {
            inputStream = this.mContext.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream != null) {
                    byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
                    if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        drawable = new NinePatchDrawable(this.mContext.getResources(), decodeStream, ninePatchChunk, new Rect(), (String) null);
                    } else {
                        drawable = adjustBitmapByRatio(decodeStream, 0);
                    }
                }
                H5IOUtils.closeQuietly(inputStream);
                return drawable;
            } catch (IOException unused) {
                try {
                    H5Log.e(TAG, "get background image exception");
                    H5IOUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    H5IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            inputStream = null;
            H5Log.e(TAG, "get background image exception");
            H5IOUtils.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            H5IOUtils.closeQuietly(inputStream);
            throw th;
        }
    }

    private Drawable adjustBitmapByRatio(Bitmap bitmap, int i2) {
        View view;
        if (bitmap == null) {
            return null;
        }
        if (this.mContext == null || (view = this.contentView) == null || view.findViewById(R.id.h5_title_bar_layout) == null) {
            return new BitmapDrawable(bitmap);
        }
        View findViewById = this.contentView.findViewById(R.id.h5_title_bar_layout);
        int screenWidth = H5DimensionUtil.getScreenWidth(this.mContext);
        int i3 = findViewById.getLayoutParams().height;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i3 >= height && screenWidth >= width) {
            return new BitmapDrawable(this.mContext.getResources(), bitmap);
        }
        if (height == 0 || width == 0) {
            return new BitmapDrawable(this.mContext.getResources(), bitmap);
        }
        if (i2 != 1) {
            return new BitmapDrawable(this.mContext.getResources(), Bitmap.createScaledBitmap(bitmap, screenWidth, i3, true));
        }
        float f2 = (float) width;
        float min = Math.min(((float) screenWidth) / f2, ((float) i3) / ((float) height));
        int round = Math.round(f2 * min);
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Bitmap createBitmap2 = Bitmap.createBitmap(screenWidth, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        if (round < screenWidth) {
            canvas.drawBitmap(createBitmap, (float) ((screenWidth - round) / 2), 0.0f, (Paint) null);
        } else {
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        }
        canvas.save();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), createBitmap2);
        bitmap.recycle();
        return bitmapDrawable;
    }

    /* JADX WARNING: type inference failed for: r9v7, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable createDrawableFromExternalFile(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "/../"
            boolean r0 = r9.contains(r0)
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "/"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "file://"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0020
            goto L_0x0063
        L_0x0020:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeFile(r9, r0)
            if (r4 == 0) goto L_0x004e
            byte[] r5 = r4.getNinePatchChunk()
            boolean r9 = android.graphics.NinePatch.isNinePatchChunk(r5)
            if (r9 == 0) goto L_0x0048
            android.graphics.drawable.NinePatchDrawable r9 = new android.graphics.drawable.NinePatchDrawable
            android.content.Context r2 = r8.mContext
            android.content.res.Resources r3 = r2.getResources()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r7 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x004f
        L_0x0048:
            r9 = 0
            android.graphics.drawable.Drawable r9 = r8.adjustBitmapByRatio(r4, r9)
            goto L_0x004f
        L_0x004e:
            r9 = r1
        L_0x004f:
            java.lang.String r0 = r0.outMimeType
            if (r0 == 0) goto L_0x005d
            java.lang.String r2 = "image"
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            return r9
        L_0x005d:
            java.lang.String r9 = "Unknown Image Format"
            com.alipay.mobile.nebula.util.H5Log.d(r9)
            return r1
        L_0x0063:
            java.lang.String r9 = "Invalid External File Path"
            com.alipay.mobile.nebula.util.H5Log.d(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.view.H5NavigationBar.createDrawableFromExternalFile(java.lang.String):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r1.searchView != null) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void switchTheme(int r2, int r3, boolean r4) {
        /*
            r1 = this;
            if (r4 == 0) goto L_0x0005
            int r4 = r1.delayDy
            goto L_0x000f
        L_0x0005:
            com.alipay.mobile.h5container.api.H5Page r4 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r4 = r4.getWebView()
            int r4 = r4.getScrollY()
        L_0x000f:
            boolean r0 = r1.preventScrollTrans
            if (r0 != 0) goto L_0x007c
            r0 = -1
            if (r2 != r0) goto L_0x0049
            int r2 = java.lang.Math.abs(r4)
            if (r2 < r3) goto L_0x0029
            com.alipay.mobile.nebula.view.H5TitleView r2 = r1.h5TitleView
            r2.switchToBlueTheme()
            r1.switchIconFontToBlueTheme()
            android.view.View r2 = r1.searchView
            if (r2 == 0) goto L_0x0049
            goto L_0x0042
        L_0x0029:
            com.alipay.mobile.nebula.view.H5TitleView r2 = r1.h5TitleView
            r2.switchToWhiteTheme()
            r1.switchIconFontToWhiteTheme()
            android.view.View r2 = r1.searchView
            if (r2 == 0) goto L_0x0049
            float r3 = r1.alpha
            r4 = 1041865114(0x3e19999a, float:0.15)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0042
            r2.setAlpha(r3)
            goto L_0x0049
        L_0x0042:
            android.view.View r2 = r1.searchView
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.setAlpha(r3)
        L_0x0049:
            android.graphics.drawable.ColorDrawable r2 = r1.contentBgDrawable
            float r3 = r1.alpha
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = (int) r3
            r2.setAlpha(r3)
            android.view.View r2 = r1.h5TitleHDivider
            float r3 = r1.alpha
            r2.setAlpha(r3)
            boolean r2 = r1.scrollWithTitleText
            if (r2 == 0) goto L_0x007c
            com.alipay.mobile.nebula.view.H5TitleView r2 = r1.h5TitleView
            if (r2 == 0) goto L_0x007c
            android.widget.TextView r2 = r2.getMainTitleView()
            if (r2 == 0) goto L_0x006f
            float r3 = r1.alpha
            r2.setAlpha(r3)
        L_0x006f:
            com.alipay.mobile.nebula.view.H5TitleView r2 = r1.h5TitleView
            android.widget.TextView r2 = r2.getSubTitleView()
            if (r2 == 0) goto L_0x007c
            float r3 = r1.alpha
            r2.setAlpha(r3)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.view.H5NavigationBar.switchTheme(int, int, boolean):void");
    }

    /* access modifiers changed from: private */
    public void calAlphaValue(int i2, int i3, boolean z) {
        int scrollY = z ? this.delayDy : this.h5Page.getWebView().getScrollY();
        if (Math.abs(scrollY) < i2) {
            this.alpha = ((float) Math.abs(scrollY / i3)) / 255.0f;
        } else if (scrollY <= 0) {
            this.alpha = 0.0f;
        } else {
            this.alpha = 1.0f;
        }
    }

    public View getContent() {
        return this.contentView;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.SHOW_TITLE_BAR);
        h5EventFilter.addAction(H5Plugin.CommonEvents.HIDE_TITLE_BAR);
        h5EventFilter.addAction("showTitleLoading");
        h5EventFilter.addAction(H5Plugin.CommonEvents.HIDE_TITLE_LOADING);
        h5EventFilter.addAction("showOptionMenu");
        h5EventFilter.addAction(H5Plugin.CommonEvents.HIDE_OPTION_MENU);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_OPTION_MENU);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_TITLE);
        h5EventFilter.addAction("readTitle");
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_TOOL_MENU);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SHOW_POP_MENU);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_SHOW_TIPS);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_TITLE_COLOR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TITLEBAR_OPTIONS);
        h5EventFilter.addAction(H5_PAGE_ERROR_FOR_TITLEBAR);
        h5EventFilter.addAction(SET_BAR_BOTTOM_LINE_COLOR);
        h5EventFilter.addAction(SET_TRANSPARENT_TITLE);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(action)) {
            this.pageStarted = true;
            this.ignorePageTitleFromCallbacks = false;
            this.h5TitleView.showBackButton(true);
            this.h5TitleDivider.setVisibility(this.mShowVerticalDivider ? 0 : 8);
            Bundle params = this.h5Page.getParams();
            int i2 = H5Utils.getInt(params, H5Param.APP_TYPE, 2);
            if (!H5AppUtil.isPublicAppId(H5Utils.getString(params, "appId")) && i2 == 2) {
                if (this.h5NavMenu.hasMenu(H5Param.MENU_SHARE)) {
                    H5Log.e(TAG, "Share menu has been already existed, won't bother to add more");
                    return true;
                }
                this.h5NavMenu.removeMenu(H5Param.MENU_SHARE_FRIEND);
                Resources resources = H5Environment.getResources();
                int i3 = 0;
                while (true) {
                    if (i3 < this.h5NavMenu.menuList.size()) {
                        if (H5Param.MENU_COPY.equals(((H5NavMenuItem) this.h5NavMenu.menuList.get(i3)).tag) || H5Param.MENU_FAVORITES.equals(((H5NavMenuItem) this.h5NavMenu.menuList.get(i3)).tag)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                this.h5NavMenu.addMenu(i3, new H5NavMenuItem(resources.getString(R.string.h5_menu_share), H5Param.MENU_SHARE_FRIEND, resources.getDrawable(R.drawable.h5_nav_share_friend), false));
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE.equals(action)) {
            setPageTitle(param);
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action)) {
            this.isPageFinished = true;
            if (H5Utils.getBoolean(param, H5Param.PAGE_UPDATED, false)) {
                setPageTitle(param);
            }
            String title = this.h5TitleView.getTitle();
            if (!TextUtils.isEmpty(this.defaultTitle) && TextUtils.isEmpty(title)) {
                this.h5TitleView.setTitle(this.defaultTitle);
            }
            if (this.transTitle && !this.isPageError) {
                boolean z = H5Utils.getBoolean(this.h5Page.getParams(), Nebula.HAS_H5_PKG, false);
                H5Log.d(TAG, "transTitle appid " + this.appId + ", appVersion " + this.version + ", hasPackage " + z);
                if (!z && !TextUtils.equals(this.transparentTitle, "custom")) {
                    this.h5TitleView.switchToWhiteTheme();
                    switchIconFontToWhiteTheme();
                }
            }
        } else if ("showFavorites".equals(action)) {
            if (this.h5NavMenu.hasMenu(H5Param.MENU_FAVORITES)) {
                H5Log.e(TAG, "favorites menu has been already existed");
                return true;
            }
            Resources resources2 = H5Environment.getResources();
            String str = this.h5NavMenu.menuList.size() > 0 ? ((H5NavMenuItem) this.h5NavMenu.menuList.get(0)).tag : "";
            if (H5Param.MENU_COPY.equals(str)) {
                this.h5NavMenu.addMenu(0, new H5NavMenuItem(resources2.getString(R.string.h5_menu_favorites), H5Param.MENU_FAVORITES, resources2.getDrawable(R.drawable.h5_nav_favorites), false));
            }
            if (H5Param.MENU_SHARE_FRIEND.equals(str)) {
                this.h5NavMenu.addMenu(1, new H5NavMenuItem(resources2.getString(R.string.h5_menu_favorites), H5Param.MENU_FAVORITES, resources2.getDrawable(R.drawable.h5_nav_favorites), false));
            }
            h5BridgeContext.sendBridgeResult("status", "true");
        } else if (H5Plugin.InternalEvents.HIDE_FAVORITES.equals(action)) {
            if (this.h5NavMenu.hasMenu(H5Param.MENU_FAVORITES)) {
                this.h5NavMenu.removeMenu(H5Param.MENU_FAVORITES);
                h5BridgeContext.sendBridgeResult("status", "true");
            }
        } else if ("showReportBtn".equals(action)) {
            return showReportBtn(true, h5BridgeContext);
        } else {
            if (H5Plugin.InternalEvents.HIDE_REPORT_BTN.equals(action)) {
                return showReportBtn(false, h5BridgeContext);
            }
        }
        return false;
    }

    private boolean showReportBtn(boolean z, H5BridgeContext h5BridgeContext) {
        if (z) {
            if (this.h5NavMenu.hasMenu(H5Param.MENU_REPORT)) {
                H5Log.e(TAG, "report menu has been already existed");
                return true;
            }
            Resources resources = H5Environment.getResources();
            H5NavMenu h5NavMenu2 = this.h5NavMenu;
            h5NavMenu2.addMenu(h5NavMenu2.menuList.size(), new H5NavMenuItem(resources.getString(R.string.h5_menu_report_new), H5Param.MENU_REPORT, resources.getDrawable(R.drawable.h5_nav_complain), false));
            if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult("status", "true");
            }
        } else if (this.h5NavMenu.hasMenu(H5Param.MENU_REPORT)) {
            this.h5NavMenu.removeMenu(H5Param.MENU_REPORT);
            if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult("status", "true");
            }
        }
        return false;
    }

    public void onRelease() {
        this.h5Page = null;
        if (this.mContentBgImage != null) {
            this.mContentBgImage = null;
        }
        H5TitleView h5TitleView2 = this.h5TitleView;
        if (h5TitleView2 != null) {
            h5TitleView2.releaseViewList();
        }
        IH5TinyPopMenu iH5TinyPopMenu = this.h5TinyPopMenu;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.onRelease();
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (!H5Plugin.CommonEvents.SHOW_TITLE_BAR.equals(action) && !H5Plugin.CommonEvents.HIDE_TITLE_BAR.equals(action)) {
            if ("showOptionMenu".equals(action)) {
                showNavOptions(true, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.SET_OPTION_MENU.equals(action)) {
                setOptionMenu(h5Event, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.HIDE_OPTION_MENU.equals(action)) {
                showNavOptions(false, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.SHOW_BACK_BUTTON.equals(action)) {
                showBackButton(true, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.HIDE_BACK_BUTTON.equals(action)) {
                showBackButton(false, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.SET_TITLE.equals(action)) {
                setTitle(h5Event.getParam());
                h5BridgeContext.sendSuccess();
            } else if ("readTitle".equals(action)) {
                this.readTitle = H5Utils.getBoolean(param, "readTitle", true);
            } else if (H5Plugin.InternalEvents.H5_SHOW_TIPS.equals(action)) {
                H5Tip.showTip(this.h5Page.getContext().getContext(), (ViewGroup) this.contentView, H5Utils.getString(h5Event.getParam(), H5Param.TIP_CONTENT));
            } else if (H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE.equals(action) || H5Plugin.CommonEvents.HIDE_CLOSE_BUTTON.equals(action)) {
                showClose(H5Utils.getBoolean(param, "show", false));
            } else if ("showTitleLoading".equals(action)) {
                showTitleLoading(true, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.HIDE_TITLE_LOADING.equals(action)) {
                showTitleLoading(false, h5BridgeContext);
            } else if (H5Plugin.CommonEvents.SET_TOOL_MENU.equals(action) || H5Plugin.CommonEvents.SHOW_POP_MENU.equals(action)) {
                if (H5Plugin.CommonEvents.SHOW_POP_MENU.equals(action)) {
                    this.h5PopMenu.setIsShowPopMenu(true);
                    this.h5PopMenu.setMenu(h5Event, this.pageStarted);
                } else {
                    this.h5NavMenu.setIsShowPopMenu(false);
                    if (this.isTinyApp) {
                        this.h5NavMenu.clearMenuList();
                    }
                    this.h5NavMenu.setMenu(h5Event, this.pageStarted);
                }
                if (H5Plugin.CommonEvents.SHOW_POP_MENU.equals(action)) {
                    this.h5PopMenu.showMenu(this.h5TitleView.getPopAnchor());
                }
                h5BridgeContext.sendBridgeResult("success", "true");
            } else if (H5Plugin.CommonEvents.SET_TITLE_COLOR.equals(action)) {
                handleSetTitleColor(h5Event, h5BridgeContext);
            } else if (H5_PAGE_ERROR_FOR_TITLEBAR.equals(action)) {
                if (this.h5TitleView != null && H5Environment.isInWallet()) {
                    this.h5TitleView.switchToBlueTheme();
                    switchIconFontToBlueTheme();
                    this.isPageError = true;
                    if (this.transTitle && this.h5Page != null) {
                        this.preventScrollTrans = true;
                    }
                }
            } else if (SET_BAR_BOTTOM_LINE_COLOR.equals(action)) {
                if (this.h5TitleHDivider != null) {
                    int i2 = -16777216 | H5Utils.getInt(param, CLConstants.FIELD_FONT_COLOR, -16777216);
                    H5Log.d(TAG, "setBarBottomLineColor color is ".concat(String.valueOf(i2)));
                    this.h5TitleHDivider.setBackgroundColor(i2);
                }
                h5BridgeContext.sendSuccess();
            } else if (SET_TRANSPARENT_TITLE.equals(action)) {
                String string = H5Utils.getString(param, H5Param.LONG_TRANSPARENT_TITLE);
                H5Log.d(TAG, "setTransparentTitle type ".concat(String.valueOf(string)));
                Bundle params = this.h5Page.getParams();
                H5Log.d(TAG, "setTransparentTitle originType ".concat(String.valueOf(H5Utils.getString(params, H5Param.LONG_TRANSPARENT_TITLE))));
                params.putString(H5Param.LONG_TRANSPARENT_TITLE, string);
                if (this.viewHolder != null) {
                    this.isSwitchMode = true;
                    setPage(this.h5Page);
                    this.viewHolder.refreshView();
                }
                h5BridgeContext.sendSuccess();
                H5Page h5Page2 = this.h5Page;
                if (h5Page2 != null) {
                    h5Page2.sendEvent(H5Plugin.CommonEvents.H5_TITLEBAR_TRANSSTATE_CHANGE, (e) null);
                }
            } else if (!H5Plugin.InternalEvents.H5_TITLEBAR_OPTIONS.equals(action)) {
                return false;
            } else {
                boolean z = H5Utils.getBoolean(param, "fromMenu", false);
                if (!z || !needTinyPopMenu(this.h5Page)) {
                    e eVar = new e();
                    eVar.put("data", (Object) param);
                    this.h5Page.getBridge().sendToWeb(action, eVar, (H5CallBack) null);
                    if (z) {
                        if (getH5SharePanelProvider() == null) {
                            this.h5NavMenu.showMenu(this.h5TitleView.getPopAnchor());
                        } else if (!this.optionMenuPreventDefault) {
                            getH5SharePanelProvider().showSharePanel(this.h5Page, this.isPageFinished);
                        }
                    }
                } else {
                    IH5TinyPopMenu iH5TinyPopMenu = this.h5TinyPopMenu;
                    if (iH5TinyPopMenu != null) {
                        iH5TinyPopMenu.showMenu();
                    } else {
                        H5Log.d(TAG, "h5TinyPopMenu==null");
                    }
                }
            }
        }
        return true;
    }

    private void handleSetTitleColor(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (this.contentBgDrawable != null) {
            e param = h5Event.getParam();
            int i2 = H5Utils.getInt(param, CLConstants.FIELD_FONT_COLOR, -16777216);
            boolean z = H5Utils.getBoolean(param, UpiConstants.UPI_RESET_TOKEN, false);
            boolean z2 = H5Utils.getBoolean(param, "resetTransparent", false);
            int i3 = i2 | -16777216;
            if (i3 != -16777216 && !z && !z2) {
                if (this.mContentBgImage != null) {
                    this.contentView.setBackgroundDrawable(this.contentBgDrawable);
                }
                setContentBgViewColor(i3);
                this.h5TitleDivider.setBackgroundColor(i3);
                if (!this.preventSetTitleColor) {
                    if (i3 != -1) {
                        this.h5TitleView.switchToWhiteTheme();
                        switchIconFontToWhiteTheme();
                    } else {
                        this.h5TitleView.switchToBlueTheme();
                        switchIconFontToBlueTheme();
                    }
                }
                if (i3 != -1) {
                    this.h5TitleHDivider.setBackgroundColor(i3);
                }
                if (this.transTitle) {
                    setTitleAlpha();
                }
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendSuccess();
                }
            } else if (z) {
                this.h5TitleView.resetTitleColor(-1);
                this.h5TitleView.switchToBlueTheme();
                switchIconFontToBlueTheme();
                this.h5TitleHDivider.setBackgroundColor(-16777216 | Color.parseColor("#C6C8C9"));
                if (this.transTitle) {
                    setTitleAlpha();
                } else {
                    setBackgroundDrawableFor(this.contentView, this.h5Page.getParams());
                }
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendBridgeResult("success", "true");
                }
            } else if (!z2 || !this.transTitle) {
                e eVar = new e();
                eVar.put("error", (Object) "2");
                h5BridgeContext.sendBridgeResult(eVar);
            } else {
                this.h5TitleView.switchToWhiteTheme();
                switchIconFontToWhiteTheme();
                setTitleAlpha();
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendBridgeResult("success", "true");
                }
            }
        }
    }

    private void showTitleLoading(boolean z, H5BridgeContext h5BridgeContext) {
        this.h5TitleView.showTitleLoading(z);
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult("success", "true");
        }
    }

    private void showClose(boolean z) {
        this.h5TitleView.showCloseButton(z);
    }

    private void showTitleBar(boolean z) {
        int i2 = 0;
        this.contentView.setVisibility(z ? 0 : 8);
        View view = this.h5TitleHDivider;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    private void showTitleBar(boolean z, H5BridgeContext h5BridgeContext) {
        showTitleBar(z);
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult("success", "true");
        }
    }

    private void showNavOptions(boolean z) {
        this.h5TitleView.showOptionMenu(z);
    }

    private void showNavOptions(boolean z, H5BridgeContext h5BridgeContext) {
        showNavOptions(z);
        h5BridgeContext.sendSuccess();
    }

    private void showBackButton(boolean z, H5BridgeContext h5BridgeContext) {
        this.h5TitleView.showBackButton(z);
        h5BridgeContext.sendSuccess();
    }

    private void setPageTitle(e eVar) {
        if (eVar.get("title") == null) {
            H5Log.d(TAG, "case 1, page title ignored!");
            return;
        }
        H5Log.d(TAG, "readTitle:" + this.readTitle);
        if (!this.readTitle || this.ignorePageTitleFromCallbacks || this.ifImageTitle) {
            H5Log.d(TAG, "case 2, page title ignored!");
            return;
        }
        String string = H5Utils.getString(eVar, "title");
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null || !TextUtils.equals(string, h5Page2.getUrl())) {
            try {
                String decode = URLDecoder.decode(H5Utils.getString(eVar, "url"));
                H5TitleView h5TitleView2 = this.h5TitleView;
                if (decode.equals("http://".concat(String.valueOf(string)))) {
                    string = this.defaultTitle;
                }
                h5TitleView2.setTitle(string);
            } catch (IllegalArgumentException e2) {
                H5Log.e(TAG, (Throwable) e2);
                this.h5TitleView.setTitle(this.defaultTitle);
            }
        } else {
            H5Log.d(TAG, string + " not show");
        }
    }

    private void setOptionMenu(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        if (param == null || param.isEmpty()) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return;
        }
        this.optionMenuPreventDefault = H5Utils.getBoolean(param, "preventDefault", false);
        if (!this.optionMenuPreventDefault) {
            this.h5TitleView.setOptionMenu(param);
            boolean equals = TextUtils.equals("tiny", H5Utils.getString(param, H5Param.LONG_BIZ_TYPE));
            if (!H5Utils.getBoolean(param, UpiConstants.UPI_RESET_TOKEN, false) || equals) {
                boolean z = H5Utils.getBoolean(param, "override", false);
                b jSONArray = H5Utils.getJSONArray(param, "menus", (b) null);
                int i2 = 2;
                if (jSONArray == null || jSONArray.isEmpty()) {
                    this.icontype = new String[2];
                    this.icontype[0] = H5Utils.getString(param, "icontype");
                    this.icontype[1] = "stupid";
                    Map<String, Integer> map = blueIconFontMap;
                    if (map == null || map.isEmpty() || !blueIconFontMap.containsKey(this.icontype[0])) {
                        String string = H5Utils.getString(param, H5Param.MENU_ICON);
                        if (!TextUtils.isEmpty(string)) {
                            loadImageAsync(string, equals ? 1 : 0);
                        }
                    } else if ((this.h5TitleView.getMainTitleView().getCurrentTextColor() | -16777216) != -15658735) {
                        setOptionImage(createIconBitmap(whiteIconFontMap.get(this.icontype[0]).intValue()), equals);
                    } else {
                        setOptionImage(createIconBitmap(blueIconFontMap.get(this.icontype[0]).intValue()), equals);
                    }
                } else if (!z || equals) {
                    e jSONObject = jSONArray.getJSONObject(0);
                    this.icontype = new String[2];
                    String[] strArr = this.icontype;
                    strArr[0] = "stupid";
                    strArr[1] = H5Utils.getString(jSONObject, "icontype");
                    Map<String, Integer> map2 = blueIconFontMap;
                    if (map2 == null || map2.isEmpty() || !blueIconFontMap.containsKey(this.icontype[1])) {
                        String string2 = H5Utils.getString(jSONObject, H5Param.MENU_ICON);
                        if (!TextUtils.isEmpty(string2)) {
                            loadImageAsync(string2, 1);
                        }
                    } else if ((this.h5TitleView.getMainTitleView().getCurrentTextColor() | -16777216) != -15658735) {
                        setOptionImage(createIconBitmap(whiteIconFontMap.get(this.icontype[1]).intValue()), 1);
                    } else {
                        setOptionImage(createIconBitmap(blueIconFontMap.get(this.icontype[1]).intValue()), 1);
                    }
                } else {
                    if (jSONArray.size() <= 2) {
                        i2 = jSONArray.size();
                    }
                    this.icontype = new String[i2];
                    for (int i3 = 0; i3 < i2; i3++) {
                        e jSONObject2 = jSONArray.getJSONObject(i3);
                        this.icontype[i3] = H5Utils.getString(jSONObject2, "icontype");
                        Map<String, Integer> map3 = blueIconFontMap;
                        if (map3 == null || map3.isEmpty() || !blueIconFontMap.containsKey(this.icontype[i3])) {
                            String string3 = H5Utils.getString(jSONObject2, H5Param.MENU_ICON);
                            if (!TextUtils.isEmpty(string3)) {
                                loadImageAsync(string3, i3);
                            }
                        } else if ((this.h5TitleView.getMainTitleView().getCurrentTextColor() | -16777216) != -15658735) {
                            setOptionImage(createIconBitmap(whiteIconFontMap.get(this.icontype[i3]).intValue()), i3);
                        } else {
                            setOptionImage(createIconBitmap(blueIconFontMap.get(this.icontype[i3]).intValue()), i3);
                        }
                    }
                }
                h5BridgeContext.sendSuccess();
                return;
            }
            this.optionMenuPreventDefault = false;
        }
    }

    private void loadImageAsync(String str, final int i2) {
        if (!str.startsWith("http")) {
            setOptionImage(H5ImageUtil.base64ToBitmap(str), i2);
        } else {
            Nebula.loadImage(str, new H5ImageListener() {
                public void onImage(Bitmap bitmap) {
                    if (bitmap != null) {
                        H5NavigationBar.this.setOptionImage(bitmap, i2);
                    }
                }
            });
        }
    }

    private Bitmap createIconBitmap(int i2) {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null) {
            return null;
        }
        return BitmapFactory.decodeResource(h5Page2.getContext().getContext().getResources(), i2);
    }

    /* access modifiers changed from: private */
    public void setOptionImage(final Bitmap bitmap, final int i2) {
        if (bitmap != null) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5NavigationBar.this.h5TitleView.setOptionType(H5Param.OptionType.ICON, i2, true);
                    H5NavigationBar.this.h5TitleView.setBtIcon(bitmap, i2);
                }
            });
        }
    }

    private void setTitle(e eVar) {
        if (eVar != null && !eVar.isEmpty()) {
            if (H5Utils.getBoolean(eVar, "fromJS", true)) {
                this.ignorePageTitleFromCallbacks = true;
            }
            final String string = H5Utils.getString(eVar, H5ResourceHandlerUtil.IMAGE);
            if (!TextUtils.isEmpty(string)) {
                this.ifImageTitle = true;
                H5Log.d(TAG, "setTitle image type");
                final String string2 = H5Utils.getString(eVar, "contentDesc");
                if (!string.startsWith("http")) {
                    H5Log.d(TAG, "setTitle image type base64");
                    Bitmap base64ToBitmap = H5ImageUtil.base64ToBitmap(string);
                    if (base64ToBitmap != null) {
                        this.h5TitleView.setImgTitle(base64ToBitmap, string2);
                        return;
                    }
                    return;
                }
                try {
                    string = URLDecoder.decode(string, AppConstants.UTF_8);
                } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                    H5Log.e(TAG, "catch exception ", e2);
                }
                if (this.h5Page != null) {
                    H5Log.d(TAG, "setTitle image type offlinepkg1");
                    H5SessionImpl h5SessionImpl = (H5SessionImpl) this.h5Page.getSession();
                    if (h5SessionImpl != null) {
                        H5Log.d(TAG, "setTitle image type offlinepkg2");
                        H5ContentProvider webProvider = h5SessionImpl.getWebProvider();
                        if (webProvider != null) {
                            H5Log.d(TAG, "setTitle image type offlinepkg3");
                            webProvider.getContent(string, (H5ContentProvider.ResponseListen) new H5ContentProvider.ResponseListen() {
                                public void onGetResponse(WebResourceResponse webResourceResponse) {
                                    if (webResourceResponse == null || webResourceResponse.getData() == null) {
                                        Nebula.loadImageKeepSize(string, new H5ImageListener() {
                                            public void onImage(final Bitmap bitmap) {
                                                if (bitmap != null) {
                                                    H5Log.d(H5NavigationBar.TAG, "setTitle image type network");
                                                    H5Utils.runOnMain(new Runnable() {
                                                        public void run() {
                                                            H5NavigationBar.this.h5TitleView.setImgTitle(bitmap, string2);
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    H5Log.d(H5NavigationBar.TAG, "setTitle image type offlinepkg");
                                    final Bitmap decodeStream = BitmapFactory.decodeStream(webResourceResponse.getData());
                                    H5Utils.runOnMain(new Runnable() {
                                        public void run() {
                                            if (H5NavigationBar.this.h5TitleView != null && decodeStream != null) {
                                                H5NavigationBar.this.h5TitleView.setImgTitle(decodeStream, string2);
                                            }
                                        }
                                    });
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            H5Log.d(TAG, "setTitle text type");
            String string3 = H5Utils.getString(eVar, "title");
            if (!TextUtils.isEmpty(string3) && !this.pageStarted) {
                this.defaultTitle = string3;
            }
            String str = null;
            if (eVar.containsKey("subtitle")) {
                str = H5Utils.getString(eVar, "subtitle", (String) null);
            }
            this.h5TitleView.setTitle(string3);
            this.h5TitleView.setSubTitle(str);
            this.h5Page.setTitle(string3);
            Intent intent = new Intent();
            intent.setAction(BROADCAST_TITLE_URL);
            intent.putExtra("title", string3);
            H5Page h5Page2 = this.h5Page;
            intent.putExtra("url", h5Page2 != null ? h5Page2.getUrl() : "");
            H5Log.d(TAG, "send page finished broadcast.");
            a.a(H5Environment.getContext()).a(intent);
        }
    }

    public void setTitleAlpha() {
        H5TitleView h5TitleView2;
        this.contentBgDrawable.setAlpha((int) (this.alpha * 255.0f));
        this.h5TitleHDivider.setAlpha(this.alpha);
        View view = this.searchView;
        if (view != null) {
            float f2 = this.alpha;
            if (f2 > 0.15f) {
                view.setAlpha(f2);
            } else {
                view.setAlpha(1.0f);
            }
        }
        if (this.scrollWithTitleText && (h5TitleView2 = this.h5TitleView) != null) {
            TextView mainTitleView = h5TitleView2.getMainTitleView();
            if (mainTitleView != null) {
                mainTitleView.setAlpha(this.alpha);
            }
            TextView subTitleView = this.h5TitleView.getSubTitleView();
            if (subTitleView != null) {
                subTitleView.setAlpha(this.alpha);
            }
        }
    }

    public void setContentBgViewColor(int i2) {
        H5SearchView h5SearchView;
        this.contentBgDrawable.setColor(i2);
        if (this.searchView != null && (h5SearchView = (H5SearchView) Nebula.getProviderManager().getProvider(H5SearchView.class.getName())) != null) {
            h5SearchView.setSearchBarColor(i2);
        }
    }

    public void setHdivider(View view) {
        this.h5TitleHDivider = view;
    }

    private void switchIconFontToWhiteTheme() {
        String[] strArr = this.icontype;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.icontype;
                if (i2 < strArr2.length) {
                    String str = strArr2[i2];
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "stupid") && whiteIconFontMap.get(str) != null) {
                        setOptionImage(createIconBitmap(whiteIconFontMap.get(str).intValue()), i2);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private void switchIconFontToBlueTheme() {
        String[] strArr = this.icontype;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.icontype;
                if (i2 < strArr2.length) {
                    String str = strArr2[i2];
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "stupid") && blueIconFontMap.get(str) != null) {
                        setOptionImage(createIconBitmap(blueIconFontMap.get(str).intValue()), i2);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean needTinyPopMenu(H5Page h5Page2) {
        if (h5Page2 == null) {
            return false;
        }
        return H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Utils.getString(h5Page2.getParams(), "usePresetPopmenu"));
    }

    private void getTinyPopMenuData(final Context context) {
        this.h5TinyPopMenu = (IH5TinyPopMenu) H5Utils.getH5ProviderManager().getProviderUseCache(IH5TinyPopMenu.class.getName(), false);
        IH5TinyPopMenu iH5TinyPopMenu = this.h5TinyPopMenu;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.requestRpc(new H5SimpleRpcListener() {
                public void onSuccess(String str) {
                    if (H5NavigationBar.this.h5Page != null) {
                        H5NavigationBar.this.h5TinyPopMenu.init(H5NavigationBar.this.h5Page, str, context);
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                View optionMenuContainer = H5NavigationBar.this.h5TitleView.getOptionMenuContainer();
                                if (optionMenuContainer != null) {
                                    optionMenuContainer.setVisibility(0);
                                }
                            }
                        });
                    }
                }

                public void onFailed(int i2, String str) {
                    H5Log.d(H5NavigationBar.TAG, "getTinyPopMenuData onFailed errorCode " + i2 + ", errorMessage " + str);
                }
            }, this.h5Page, context);
        }
    }
}
