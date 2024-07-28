package com.paytm.android.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class StatusBarUtil {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final int FAKE_STATUS_BAR_VIEW_ID = 0;
    private static final int FAKE_TRANSLUCENT_VIEW_ID = 0;
    private static final String TAG = "StatusBarUtil";
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    private static int calculateStatusColor(int i2, int i3) {
        if (i3 == 0) {
            return i2;
        }
        float f2 = 1.0f - (((float) i3) / 255.0f);
        int i4 = (i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID;
        return ((int) (((double) (((float) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID)) * f2)) + 0.5d)) | (((int) (((double) (((float) i4) * f2)) + 0.5d)) << 16) | -16777216 | (((int) (((double) (((float) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID)) * f2)) + 0.5d)) << 8);
    }

    public static void setColor(Activity activity, int i2) {
        setColor(activity, i2, 112);
    }

    public static void setColor(Activity activity, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(calculateStatusColor(i2, i3));
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(0);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(calculateStatusColor(i2, i3));
            } else {
                viewGroup.addView(createStatusBarView(activity, i2, i3));
            }
            setRootView(activity);
        }
    }

    public static void setColorNoTranslucent(Activity activity, int i2) {
        setColor(activity, i2, 0);
    }

    @Deprecated
    public static void setColorDiff(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            transparentStatusBar(activity);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View findViewById = viewGroup.findViewById(0);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i2);
            } else {
                viewGroup.addView(createStatusBarView(activity, i2));
            }
            setRootView(activity);
        }
    }

    public static void setTranslucent(Activity activity) {
        setTranslucent(activity, 112);
    }

    public static void setTranslucent(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTransparent(activity);
            addTranslucentView(activity, i2);
        }
    }

    public static void setTranslucentForCoordinatorLayout(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            transparentStatusBar(activity);
            addTranslucentView(activity, i2);
        }
    }

    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            transparentStatusBar(activity);
            setRootView(activity);
        }
    }

    @Deprecated
    public static void setTranslucentDiff(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            setRootView(activity);
        }
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i2) {
        setColorForDrawerLayout(activity, drawerLayout, i2, 112);
    }

    public static void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i2) {
        setColorForDrawerLayout(activity, drawerLayout, i2, 0);
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(67108864);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(0);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i2);
            } else {
                viewGroup.addView(createStatusBarView(activity, i2), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), getStatusBarHeight(activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
            setDrawerLayoutProperty(drawerLayout, viewGroup);
            addTranslucentView(activity, i3);
        }
    }

    private static void setDrawerLayoutProperty(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    @Deprecated
    public static void setColorForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(0);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(calculateStatusColor(i2, 112));
            } else {
                viewGroup.addView(createStatusBarView(activity, i2), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
            }
            setDrawerLayoutProperty(drawerLayout, viewGroup);
        }
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        setTranslucentForDrawerLayout(activity, drawerLayout, 112);
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTransparentForDrawerLayout(activity, drawerLayout);
            addTranslucentView(activity, i2);
        }
    }

    public static void setTransparentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(67108864);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
            }
            setDrawerLayoutProperty(drawerLayout, viewGroup);
        }
    }

    @Deprecated
    public static void setTranslucentForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public static void setTransparentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 0, view);
    }

    public static void setTranslucentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 112, view);
    }

    public static void setTranslucentForImageView(Activity activity, int i2, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTransparentForWindow(activity);
            addTranslucentView(activity, i2);
            if (view != null) {
                Object tag = view.getTag(TAG_KEY_HAVE_SET_OFFSET);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(TAG_KEY_HAVE_SET_OFFSET, Boolean.TRUE);
                }
            }
        }
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 112, view);
    }

    public static void setTransparentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 0, view);
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, int i2, View view) {
        setTranslucentForImageView(activity, i2, view);
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            clearPreviousSetting(activity);
        }
    }

    public static void hideFakeStatusBarView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(0);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(0);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    private static void clearPreviousSetting(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(0);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    private static void addTranslucentView(Activity activity, int i2) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(0);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(Color.argb(i2, 0, 0, 0));
            return;
        }
        viewGroup.addView(createTranslucentStatusBarView(activity, i2));
    }

    private static View createStatusBarView(Activity activity, int i2) {
        return createStatusBarView(activity, i2, 0);
    }

    private static View createStatusBarView(Activity activity, int i2, int i3) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(calculateStatusColor(i2, i3));
        view.setId(0);
        return view;
    }

    private static void setRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    private static void setTransparentForWindow(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().setFlags(67108864, 67108864);
        }
    }

    public static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(134217728);
            activity.getWindow().setStatusBarColor(0);
            return;
        }
        activity.getWindow().addFlags(67108864);
    }

    public static void transparentStatusBarV2(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(9216);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(67108864);
        }
    }

    private static View createTranslucentStatusBarView(Activity activity, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(Color.argb(i2, 0, 0, 0));
        view.setId(0);
        return view;
    }

    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void setStatusBarDarkMode(boolean z, Activity activity) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    public static boolean setStatusBarDarkIcon(Window window, boolean z) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt((Object) null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
                q.b("setStatusBarDarkIcon: failed");
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r3) {
        /*
            boolean r0 = hasNavBar(r3)
            if (r0 == 0) goto L_0x001b
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r1 = "dimen"
            java.lang.String r2 = "android"
            int r0 = r3.getIdentifier(r0, r1, r2)
            if (r0 <= 0) goto L_0x001b
            int r3 = r3.getDimensionPixelSize(r0)
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.StatusBarUtil.getNavigationBarHeight(android.content.Context):int");
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if ("0".equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static int getStatusBarLightMode(Window window) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (MIUISetStatusBarLightMode(window, true)) {
                return 1;
            }
            if (FlymeSetStatusBarLightMode(window, true)) {
                return 2;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                return 3;
            }
        }
        return 0;
    }

    public static void setStatusBarLightMode(Window window) {
        int statusBarLightMode = getStatusBarLightMode(window);
        if (statusBarLightMode == 1) {
            MIUISetStatusBarLightMode(window, true);
        } else if (statusBarLightMode == 2) {
            FlymeSetStatusBarLightMode(window, true);
        } else if (statusBarLightMode == 3) {
            window.getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }

    public static void StatusBarDarkMode(Window window) {
        int statusBarLightMode = getStatusBarLightMode(window);
        if (statusBarLightMode == 1) {
            MIUISetStatusBarLightMode(window, false);
        } else if (statusBarLightMode == 2) {
            FlymeSetStatusBarLightMode(window, false);
        } else if (statusBarLightMode == 3) {
            window.getDecorView().setSystemUiVisibility(0);
        }
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt((Object) null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i2), Integer.valueOf(i2)});
                    return true;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i2)});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isNotch(Context context) {
        return getInt("ro.miui.notch", context) == 1 || hasNotchAtHuawei(context) || hasNotchAtVivo(context) || hasNotchAtOPPO(context);
    }

    public static int getInt(String str, Context context) {
        if (!isXiaomi()) {
            return 0;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(loadClass, new Object[]{str, 0})).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    public static boolean isXiaomi() {
        return "Xiaomi".equals(Build.MANUFACTURER);
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            q.b("Huawei hasNotchInScreen ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            q.b("Huawei hasNotchInScreen NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            q.b("Huawei hasNotchInScreen Exception");
            return false;
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{32})).booleanValue();
        } catch (ClassNotFoundException unused) {
            q.b("Huawei hasNotchAtVivo ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            q.b("Huawei hasNotchAtVivo NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            q.b("Huawei hasNotchAtVivo Exception");
            return false;
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
