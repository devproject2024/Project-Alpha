package com.paytmmall.clpartifact.utils;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.LayoutType;

public enum WidgetLayoutType {
    LAYOUT_LIST_SMALL_TI(100001, ViewHolderFactory.TYPE_LIST_SMALL_TI),
    LAYOUT_CAROUSEL_RECO(100002, ViewHolderFactory.TYPE_CAROUSEL_RECO),
    LAYOUT_H1_BANNER(100003, ViewHolderFactory.TYPE_H1_BANNER),
    LAYOUT_H1_FULL_BANNER(100004, ViewHolderFactory.TYPE_H1_FULL_BANNER),
    LAYOUT_H1_BANNER_FULL_WIDTH_CLASS(100005, ViewHolderFactory.TYPE_H1_BANNER_FULL_WIDTH_CLASS),
    LAYOUT_H1_FULL_BANNER_FULL_WIDTH_CLASS(100006, ViewHolderFactory.TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS),
    LAYOUT_CAROUSEL_BS1_LOW_DIMENTION_IAMGE(100007, ViewHolderFactory.TYPE_CAROUSEL_BS1_LOW_DIMENTION_IAMGE),
    LAYOUT_H1_FULL_BANNER_HOME_BANNER(100008, ViewHolderFactory.TYPE_H1_FULL_BANNER_HOME_BANNER),
    LAYOUT_H1_BANNER_HOME_BANNER(100009, ViewHolderFactory.TYPE_H1_BANNER_HOME_BANNER),
    LAYOUT_CAROUSEL_BS1(100010, ViewHolderFactory.TYPE_CAROUSEL_BS1),
    LAYOUT_HOME_THIN_BANNER(100011, ViewHolderFactory.TYPE_HOME_THIN_BANNER),
    LAYOUT_THIN_BANNER(100012, ViewHolderFactory.TYPE_THIN_BANNER),
    TYPE_SEAL_TRUST(100013, ViewHolderFactory.TYPE_SEAL_TRUST),
    LAYOUT_BANNER_2(100014, ViewHolderFactory.TYPE_BANNER_2),
    LAYOUT_BANNER_3(100015, ViewHolderFactory.TYPE_BANNER_3),
    LAYOUT_BANNER_3XN(100016, ViewHolderFactory.TYPE_BANNER_3XN),
    LAYOUT_BANNER_3XN_HOME(100017, ViewHolderFactory.TYPE_BANNER_3XN_HOME),
    LAYOUT_BANNER_PORTRAIT(100018, ViewHolderFactory.TYPE_PORTRAIT_3XN),
    LAYOUT_BANNER_2_FULL_WIDTH_CLASS(100019, ViewHolderFactory.TYPE_BANNER_2_FULL_WIDTH),
    LAYOUT_BANNER_3_FULL_WIDTH_CLASS(100020, ViewHolderFactory.TYPE_BANNER_3_FULL_WIDTH),
    LAYOUT_TYPE_CAROSUEL_ICON_4X(100022, ViewHolderFactory.TYPE_CAROUSEL_ICON_4X),
    LAYOUT_SMART_ICON_4X(100023, ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN);
    
    public static final Companion Companion = null;
    private final int index;
    private final String layoutName;

    protected WidgetLayoutType(int i2, String str) {
        k.c(str, "layoutName");
        this.index = i2;
        this.layoutName = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLayoutName() {
        return this.layoutName;
    }

    static {
        Companion = new Companion((g) null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getLayoutTypeNameNameFromIndex(int i2) {
            for (WidgetLayoutType widgetLayoutType : WidgetLayoutType.values()) {
                if (widgetLayoutType.getIndex() == i2) {
                    return widgetLayoutType.getLayoutName();
                }
            }
            String viewType = ViewHolderFactory.getViewType(i2);
            if (viewType != null) {
                return viewType;
            }
            String name = LayoutType.fromIndex(i2).getName();
            k.a((Object) name, "LayoutType.fromIndex(index).getName()");
            return name;
        }

        public final int getLayoutTypeIndexfromName(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            k.c(cJRHomePageLayoutV2, "pageLayoutV2");
            for (WidgetLayoutType widgetLayoutType : WidgetLayoutType.values()) {
                if (p.a(widgetLayoutType.getLayoutName(), cJRHomePageLayoutV2.getLayout(), true)) {
                    String layoutName = widgetLayoutType.getLayoutName();
                    switch (layoutName.hashCode()) {
                        case -1032895166:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_2) && (str = cJRHomePageLayoutV2.getmClassName()) != null && str.hashCode() == 1777783894 && str.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_BANNER_2_FULL_WIDTH_CLASS.getIndex();
                            }
                        case -1032894205:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_3) && (str2 = cJRHomePageLayoutV2.getmClassName()) != null && str2.hashCode() == 1777783894 && str2.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_BANNER_3_FULL_WIDTH_CLASS.getIndex();
                            }
                        case -1032893368:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_3XN) && (str3 = cJRHomePageLayoutV2.getmClassName()) != null && str3.hashCode() == 3208415 && str3.equals(ViewHolderFactory.CLASS_HOME)) {
                                return WidgetLayoutType.LAYOUT_BANNER_3XN_HOME.getIndex();
                            }
                        case 355717414:
                            if (layoutName.equals(ViewHolderFactory.TYPE_H1_FULL_BANNER) && (str4 = cJRHomePageLayoutV2.getmClassName()) != null) {
                                int hashCode = str4.hashCode();
                                if (hashCode != 3208415) {
                                    if (hashCode == 1777783894 && str4.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                        return WidgetLayoutType.LAYOUT_H1_FULL_BANNER_FULL_WIDTH_CLASS.getIndex();
                                    }
                                } else if (str4.equals(ViewHolderFactory.CLASS_HOME)) {
                                    return WidgetLayoutType.LAYOUT_H1_FULL_BANNER_HOME_BANNER.getIndex();
                                }
                            }
                            break;
                        case 388274352:
                            if (layoutName.equals(ViewHolderFactory.TYPE_H1_BANNER) && (str5 = cJRHomePageLayoutV2.getmClassName()) != null) {
                                int hashCode2 = str5.hashCode();
                                if (hashCode2 != 3208415) {
                                    if (hashCode2 == 1777783894 && str5.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                        return WidgetLayoutType.LAYOUT_H1_BANNER_FULL_WIDTH_CLASS.getIndex();
                                    }
                                } else if (str5.equals(ViewHolderFactory.CLASS_HOME)) {
                                    return WidgetLayoutType.LAYOUT_H1_BANNER_HOME_BANNER.getIndex();
                                }
                            }
                            break;
                        case 562539744:
                            if (layoutName.equals(ViewHolderFactory.TYPE_THIN_BANNER) && (str6 = cJRHomePageLayoutV2.getmClassName()) != null && str6.hashCode() == 3208415 && str6.equals(ViewHolderFactory.CLASS_HOME)) {
                                return WidgetLayoutType.LAYOUT_HOME_THIN_BANNER.getIndex();
                            }
                        case 1718789139:
                            if (layoutName.equals(ViewHolderFactory.TYPE_CAROUSEL_BS1) && (str7 = cJRHomePageLayoutV2.getmClassName()) != null && str7.hashCode() == 418546107 && str7.equals(ViewHolderFactory.CLASS_LOW_DIMENSION_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_CAROUSEL_BS1_LOW_DIMENTION_IAMGE.getIndex();
                            }
                    }
                    return widgetLayoutType.getIndex();
                }
            }
            LayoutType fromName = LayoutType.fromName(cJRHomePageLayoutV2.getLayout());
            k.a((Object) fromName, "LayoutType.fromName(pageLayoutV2.layout)");
            return fromName.getIndex();
        }

        public final int getLayoutTypeIndexfromName(View view) {
            String className;
            String className2;
            String className3;
            String className4;
            String className5;
            String className6;
            String className7;
            k.c(view, "pageLayoutV2");
            for (WidgetLayoutType widgetLayoutType : WidgetLayoutType.values()) {
                if (p.a(widgetLayoutType.getLayoutName(), view.getType(), true)) {
                    String layoutName = widgetLayoutType.getLayoutName();
                    switch (layoutName.hashCode()) {
                        case -1032895166:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_2) && (className = view.getClassName()) != null && className.hashCode() == 1777783894 && className.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_BANNER_2_FULL_WIDTH_CLASS.getIndex();
                            }
                        case -1032894205:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_3) && (className2 = view.getClassName()) != null && className2.hashCode() == 1777783894 && className2.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_BANNER_3_FULL_WIDTH_CLASS.getIndex();
                            }
                        case -1032893368:
                            if (layoutName.equals(ViewHolderFactory.TYPE_BANNER_3XN) && (className3 = view.getClassName()) != null && className3.hashCode() == 3208415 && className3.equals(ViewHolderFactory.CLASS_HOME)) {
                                return WidgetLayoutType.LAYOUT_BANNER_3XN_HOME.getIndex();
                            }
                        case 355717414:
                            if (layoutName.equals(ViewHolderFactory.TYPE_H1_FULL_BANNER) && (className4 = view.getClassName()) != null) {
                                int hashCode = className4.hashCode();
                                if (hashCode != 3208415) {
                                    if (hashCode == 1777783894 && className4.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                        return WidgetLayoutType.LAYOUT_H1_FULL_BANNER_FULL_WIDTH_CLASS.getIndex();
                                    }
                                } else if (className4.equals(ViewHolderFactory.CLASS_HOME)) {
                                    return WidgetLayoutType.LAYOUT_H1_FULL_BANNER_HOME_BANNER.getIndex();
                                }
                            }
                            break;
                        case 388274352:
                            if (layoutName.equals(ViewHolderFactory.TYPE_H1_BANNER) && (className5 = view.getClassName()) != null) {
                                int hashCode2 = className5.hashCode();
                                if (hashCode2 != 3208415) {
                                    if (hashCode2 == 1777783894 && className5.equals(ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE)) {
                                        return WidgetLayoutType.LAYOUT_H1_BANNER_FULL_WIDTH_CLASS.getIndex();
                                    }
                                } else if (className5.equals(ViewHolderFactory.CLASS_HOME)) {
                                    return WidgetLayoutType.LAYOUT_H1_BANNER_HOME_BANNER.getIndex();
                                }
                            }
                            break;
                        case 562539744:
                            if (layoutName.equals(ViewHolderFactory.TYPE_THIN_BANNER) && (className6 = view.getClassName()) != null && className6.hashCode() == 3208415 && className6.equals(ViewHolderFactory.CLASS_HOME)) {
                                return WidgetLayoutType.LAYOUT_HOME_THIN_BANNER.getIndex();
                            }
                        case 1718789139:
                            if (layoutName.equals(ViewHolderFactory.TYPE_CAROUSEL_BS1) && (className7 = view.getClassName()) != null && className7.hashCode() == 418546107 && className7.equals(ViewHolderFactory.CLASS_LOW_DIMENSION_IMAGE)) {
                                return WidgetLayoutType.LAYOUT_CAROUSEL_BS1_LOW_DIMENTION_IAMGE.getIndex();
                            }
                    }
                    return widgetLayoutType.getIndex();
                }
            }
            if (ViewHolderFactory.parseViewType(view.getType()) != 0) {
                return ViewHolderFactory.parseViewType(view.getType());
            }
            LayoutType fromName = LayoutType.fromName(view.getType());
            k.a((Object) fromName, "LayoutType.fromName(pageLayoutV2.type)");
            return fromName.getIndex();
        }
    }
}
