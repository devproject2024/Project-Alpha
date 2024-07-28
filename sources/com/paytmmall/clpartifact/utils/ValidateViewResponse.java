package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ViewDataBinding;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.TimeUtils;
import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ValidateViewResponse {
    private static final int DEFAULT_MULTIPLIER = 3;
    public static final ArrayList<Page> VALID_VIEWS_WITHOUT_ITEM = new ArrayList<Page>() {
        {
            add(Page.getDummyPage(ViewHolderFactory.TYPE_ITEM_IN_CART));
            add(Page.getDummyPage(ViewHolderFactory.TYPE_ITEM_IN_WISHLIST));
            add(Page.getDummyPage(ViewHolderFactory.TYPE_RECENTLY_VIEWED));
            add(Page.getDummyPage(ViewHolderFactory.TYPE_ACTIVE_ORDER));
        }
    };
    public static HashMap<Integer, Boolean> isValidStatusCode = new HashMap<Integer, Boolean>() {
        {
            put(2, Boolean.TRUE);
            put(5, Boolean.TRUE);
            put(6, Boolean.TRUE);
            put(9, Boolean.TRUE);
            put(13, Boolean.TRUE);
            put(15, Boolean.TRUE);
            put(16, Boolean.TRUE);
            put(17, Boolean.TRUE);
            put(22, Boolean.TRUE);
            put(23, Boolean.TRUE);
            put(24, Boolean.TRUE);
            put(25, Boolean.TRUE);
            put(26, Boolean.TRUE);
            put(27, Boolean.TRUE);
            put(30, Boolean.TRUE);
            put(118, Boolean.TRUE);
            put(119, Boolean.TRUE);
            put(123, Boolean.TRUE);
            put(212, Boolean.TRUE);
            put(215, Boolean.TRUE);
            put(216, Boolean.TRUE);
            put(219, Boolean.TRUE);
            put(220, Boolean.TRUE);
            put(Integer.valueOf(Constants.EASY_PAY_MINIMIZE_ASSIST), Boolean.TRUE);
            put(Integer.valueOf(Constants.EASY_PAY_VISIBLE_ASSIST), Boolean.TRUE);
            put(Integer.valueOf(Constants.EASY_PAY_INVISIBLE_ASSIST), Boolean.TRUE);
            put(226, Boolean.TRUE);
            put(228, Boolean.TRUE);
            put(229, Boolean.TRUE);
            put(230, Boolean.TRUE);
            put(231, Boolean.TRUE);
            put(239, Boolean.TRUE);
            put(240, Boolean.TRUE);
            put(241, Boolean.TRUE);
        }
    };

    public static Set<String> getRecoDisallowedSet() {
        return a.a(CLPArtifact.getInstance().getContext().getApplicationContext(), a.c.HOME).b("recoSet", (Set<String>) new HashSet(), true);
    }

    public static void setRecoDisallowedSet(String str) {
        Set<String> recoDisallowedSet = getRecoDisallowedSet();
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        hashSet.addAll(recoDisallowedSet);
        com.paytm.b.a.a.a(CLPArtifact.getInstance().getContext().getApplicationContext(), a.c.HOME).a("recoSet", (Set<String>) hashSet, true);
    }

    public static boolean sanitizeCLPResponse(List<Page> list, CLPResponse cLPResponse) {
        Iterator<Page> it2 = list.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            Page next = it2.next();
            if (!(next == null || VALID_VIEWS_WITHOUT_ITEM.contains(next) || next == null || next.getViews() == null || next.getViews().size() == 0 || next.getViews().get(0) == null)) {
                int parseViewType = ViewHolderFactory.parseViewType(next.getViews().get(0).getType());
                List<Item> list2 = next.getViews().get(0).mItems;
                if (parseViewType == 0 || list2 == null || list2.size() == 0 || !isValidViewResponse(next.getViews().get(0)) || (CLPUtils.isFlashSale(list) && !CLPUtils.isFlashSaleTab(next))) {
                    if (parseViewType != ViewHolderFactory.parseViewType(ViewHolderFactory.TYPE_H1_STORE_BANNER)) {
                        it2.remove();
                    } else {
                        z = true;
                        if (next.getViews().get(0).getRatingReview() != null) {
                            next.getViews().get(0).getRatingReview().setEntityIdentifier(cLPResponse.getEntityIdentifier());
                            next.getViews().get(0).getRatingReview().setEntityType(cLPResponse.getEntityType());
                        }
                    }
                } else if (list2.size() > 0) {
                    next.getViews().get(0).setItemData();
                }
            }
        }
        if (CLPUtils.isFlashSale(list)) {
            addFlashSaleView(list, list.get(0));
        }
        return z;
    }

    private static void setProductPriceFlag(Page page, boolean z) {
        try {
            page.getViews().get(0).setShowProductPrice(z);
        } catch (Exception unused) {
        }
    }

    private static boolean showProductPrice(Page page) {
        try {
            return !((TimeUtils.getMillisec(page.getViews().get(0).getItems().get(0).getStartTime()) > TimeUtils.currentMillisec() ? 1 : (TimeUtils.getMillisec(page.getViews().get(0).getItems().get(0).getStartTime()) == TimeUtils.currentMillisec() ? 0 : -1)) > 0);
        } catch (Exception unused) {
            return true;
        }
    }

    private static void addFlashSaleView(List<Page> list, Page page) {
        if (page != null && list != null) {
            boolean showProductPrice = showProductPrice(list.get(0));
            Page flashSalePage = getFlashSalePage(page);
            setProductPriceFlag(flashSalePage, showProductPrice);
            if (flashSalePage != null) {
                list.add(flashSalePage);
            }
        }
    }

    private static Page getFlashSalePage(Page page) {
        try {
            return page.getViews().get(0).getItems().get(0).getChildItems().get(0);
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean isValidView(View view) {
        return (view == null || view.getItems() == null || view.getItems().size() == 0 || ViewHolderFactory.parseViewType(view.getType()) == 0) ? false : true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isValidViewResponse(com.paytmmall.clpartifact.modal.clpCommon.View r11) {
        /*
            java.util.List r0 = r11.getItems()
            r1 = 0
            if (r0 == 0) goto L_0x00ae
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x000f
            goto L_0x00ae
        L_0x000f:
            java.lang.String r2 = r11.getType()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 5
            r6 = 3
            java.lang.String r7 = "smart-icon-group-grid"
            java.lang.String r8 = "banner-3xn"
            java.lang.String r9 = "banner-2xn"
            r10 = 1
            switch(r4) {
                case -1863943000: goto L_0x0067;
                case -1852641249: goto L_0x005d;
                case -1852641187: goto L_0x0053;
                case -1032894329: goto L_0x004b;
                case -1032893368: goto L_0x0043;
                case -865596990: goto L_0x0038;
                case -865596988: goto L_0x002d;
                case 1434954660: goto L_0x0025;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x0071
        L_0x0025:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0071
            r2 = 3
            goto L_0x0072
        L_0x002d:
            java.lang.String r4 = "tree-3"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0071
            r2 = 7
            goto L_0x0072
        L_0x0038:
            java.lang.String r4 = "tree-1"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0071
            r2 = 6
            goto L_0x0072
        L_0x0043:
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0071
            r2 = 1
            goto L_0x0072
        L_0x004b:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x0071
            r2 = 0
            goto L_0x0072
        L_0x0053:
            java.lang.String r4 = "collage-5x"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0071
            r2 = 5
            goto L_0x0072
        L_0x005d:
            java.lang.String r4 = "collage-3x"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0071
            r2 = 4
            goto L_0x0072
        L_0x0067:
            java.lang.String r4 = "banner_3xn_home"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0071
            r2 = 2
            goto L_0x0072
        L_0x0071:
            r2 = -1
        L_0x0072:
            switch(r2) {
                case 0: goto L_0x00a3;
                case 1: goto L_0x0097;
                case 2: goto L_0x0097;
                case 3: goto L_0x008b;
                case 4: goto L_0x0083;
                case 5: goto L_0x007b;
                case 6: goto L_0x0076;
                case 7: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            return r10
        L_0x0076:
            boolean r11 = validateTreeWidgetResponse(r11)
            return r11
        L_0x007b:
            int r11 = r0.size()
            if (r11 < r5) goto L_0x0082
            return r10
        L_0x0082:
            return r1
        L_0x0083:
            int r11 = r0.size()
            if (r11 < r6) goto L_0x008a
            return r10
        L_0x008a:
            return r1
        L_0x008b:
            int r0 = r0.size()
            int r11 = r11.getMinItemSize(r7)
            if (r0 <= r11) goto L_0x0096
            return r10
        L_0x0096:
            return r1
        L_0x0097:
            int r0 = r0.size()
            int r11 = r11.getMinItemSize(r8)
            if (r0 <= r11) goto L_0x00a2
            return r10
        L_0x00a2:
            return r1
        L_0x00a3:
            int r0 = r0.size()
            int r11 = r11.getMinItemSize(r9)
            if (r0 <= r11) goto L_0x00ae
            return r10
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.ValidateViewResponse.isValidViewResponse(com.paytmmall.clpartifact.modal.clpCommon.View):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (r0.equals(com.paytmmall.clpartifact.utils.ViewHolderFactory.TYPE_BANNER_2XN) != false) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean validateData(com.paytmmall.clpartifact.modal.clpCommon.View r5, androidx.databinding.ViewDataBinding r6) {
        /*
            java.util.List r0 = r5.getItems()
            r1 = 0
            if (r0 == 0) goto L_0x0034
            java.util.List r0 = r5.getItems()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0034
            android.view.View r5 = r6.getRoot()
            r0 = 8
            r5.setVisibility(r0)
            android.view.View r5 = r6.getRoot()
            int r2 = com.paytmmall.clpartifact.R.id.viewName
            android.view.View r5 = r5.findViewById(r2)
            if (r5 == 0) goto L_0x0033
            android.view.View r5 = r6.getRoot()
            int r6 = com.paytmmall.clpartifact.R.id.viewName
            android.view.View r5 = r5.findViewById(r6)
            r5.setVisibility(r0)
        L_0x0033:
            return r1
        L_0x0034:
            java.lang.String r0 = r5.getType()
            r2 = -1
            int r3 = r0.hashCode()
            r4 = 1
            switch(r3) {
                case -1852641249: goto L_0x007f;
                case -1852641187: goto L_0x0075;
                case -1032894329: goto L_0x006c;
                case -1032893368: goto L_0x0062;
                case -865596990: goto L_0x0057;
                case -865596988: goto L_0x004c;
                case 1434954660: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0089
        L_0x0042:
            java.lang.String r1 = "smart-icon-group-grid"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 2
            goto L_0x008a
        L_0x004c:
            java.lang.String r1 = "tree-3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 6
            goto L_0x008a
        L_0x0057:
            java.lang.String r1 = "tree-1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 5
            goto L_0x008a
        L_0x0062:
            java.lang.String r1 = "banner-3xn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 1
            goto L_0x008a
        L_0x006c:
            java.lang.String r3 = "banner-2xn"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0075:
            java.lang.String r1 = "collage-5x"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 4
            goto L_0x008a
        L_0x007f:
            java.lang.String r1 = "collage-3x"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0089
            r1 = 3
            goto L_0x008a
        L_0x0089:
            r1 = -1
        L_0x008a:
            switch(r1) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0098;
                case 4: goto L_0x0093;
                case 5: goto L_0x008e;
                case 6: goto L_0x008e;
                default: goto L_0x008d;
            }
        L_0x008d:
            return r4
        L_0x008e:
            boolean r5 = validateTreeWidget(r5, r6)
            return r5
        L_0x0093:
            boolean r5 = validateCollage5xn(r5, r6)
            return r5
        L_0x0098:
            boolean r5 = validateCollage3xn(r5, r6)
            return r5
        L_0x009d:
            boolean r5 = validateGroupgriditems(r5, r6)
            return r5
        L_0x00a2:
            boolean r5 = validateBanner3xn(r5, r6)
            return r5
        L_0x00a7:
            java.lang.Boolean r5 = validateBanner2xn(r5, r6)
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.ValidateViewResponse.validateData(com.paytmmall.clpartifact.modal.clpCommon.View, androidx.databinding.ViewDataBinding):boolean");
    }

    private static boolean validateTreeWidgetResponse(View view) {
        try {
            return !view.getItems().get(0).getItems().isEmpty();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }

    private static boolean validateTreeWidget(View view, ViewDataBinding viewDataBinding) {
        if (view.mItems.size() <= 0) {
            return true;
        }
        if (view.getItems().get(0) != null && view.getItems().get(0).getItems() != null && view.getItems().get(0).getItems().size() > 0) {
            return true;
        }
        viewDataBinding.getRoot().findViewById(R.id.tree_fixed).setVisibility(8);
        return false;
    }

    private static boolean validateBanner3xn(View view, ViewDataBinding viewDataBinding) {
        if (view.getType().equals(ViewHolderFactory.TYPE_BANNER_3XN) || ViewHolderFactory.TYPE_BANNER_3XN_HOME.equalsIgnoreCase(view.getType())) {
            if (view.mItems.size() <= view.getMinItemSize(ViewHolderFactory.TYPE_BANNER_3XN)) {
                viewDataBinding.getRoot().setVisibility(8);
                return false;
            } else if (ViewHolderFactory.TYPE_BANNER_3XN.equalsIgnoreCase(view.getType())) {
                if (view.mItems.size() >= 4 && view.mItems.size() < 6) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(view.mItems.get(0));
                    arrayList.add(view.mItems.get(1));
                    arrayList.add(view.mItems.get(2));
                    view.setItems(arrayList);
                } else if (view.mItems.size() >= 6) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(view.mItems.get(0));
                    arrayList2.add(view.mItems.get(1));
                    arrayList2.add(view.mItems.get(2));
                    arrayList2.add(view.mItems.get(3));
                    arrayList2.add(view.mItems.get(4));
                    arrayList2.add(view.mItems.get(5));
                    view.setItems(arrayList2);
                }
            }
        }
        return true;
    }

    private static boolean validateGroupgriditems(View view, ViewDataBinding viewDataBinding) {
        int i2;
        boolean z;
        int i3;
        if (view.getType().equals(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID)) {
            if (view.mItems.size() == 0) {
                viewDataBinding.getRoot().setVisibility(8);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int max_items_shown = view.getMax_items_shown();
            if (max_items_shown == 0 || (i3 = max_items_shown * 3) >= view.mItems.size()) {
                i2 = view.mItems.size();
                z = false;
            } else {
                i2 = i3 - 1;
                z = true;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(view.mItems.get(i4));
            }
            if (z) {
                arrayList.add(getMoreItem(viewDataBinding.getRoot().getContext(), view));
            }
            view.setItems(arrayList);
        }
        return true;
    }

    public static Item getMoreItem(Context context, View view) {
        Item item = new Item();
        if (!TextUtils.isEmpty(view.getShow_more_label())) {
            item.setName(view.getShow_more_label());
        } else {
            item.setName(context.getString(R.string.show_more));
        }
        item.setId(view.getId() + item.getName());
        item.setImageUrl(view.getShow_more_image_url());
        String str = "";
        item.setParentType(!TextUtils.isEmpty(view.getType()) ? view.getType() : str);
        if (!TextUtils.isEmpty(view.getSubtitle())) {
            str = view.getSubtitle();
        }
        if (!TextUtils.isEmpty(view.getSeourl())) {
            str = view.getSeourl();
        }
        item.setUrl(str);
        item.setGaAdded(true);
        item.setUrlType(CLPConstants.URL_TYPE_EMBED);
        item.setMore(true);
        return item;
    }

    public static Item getShowLessItem(Context context, String str, String str2, Long l) {
        Item item = new Item();
        if (!TextUtils.isEmpty(str)) {
            item.setName(str);
        } else {
            item.setName(context.getString(R.string.show_less));
        }
        item.setId(l + item.getName());
        item.setImageUrl(str2);
        item.setParentType(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID);
        item.setExpanded(true);
        item.setMore(true);
        return item;
    }

    private static Boolean validateBanner2xn(View view, ViewDataBinding viewDataBinding) {
        if (view.mItems.size() <= view.getMinItemSize(ViewHolderFactory.TYPE_BANNER_2XN)) {
            viewDataBinding.getRoot().setVisibility(8);
            return Boolean.FALSE;
        }
        if (view.mItems.size() == 3) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view.mItems.get(0));
            arrayList.add(view.mItems.get(1));
            view.setItems(arrayList);
        } else if (view.mItems.size() >= 5) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(view.mItems.get(0));
            arrayList2.add(view.mItems.get(1));
            arrayList2.add(view.mItems.get(2));
            arrayList2.add(view.mItems.get(3));
            view.setItems(arrayList2);
        }
        return Boolean.TRUE;
    }

    private static boolean validateCollage3xn(View view, ViewDataBinding viewDataBinding) {
        if (view.mItems.size() >= 3) {
            return true;
        }
        viewDataBinding.getRoot().setVisibility(8);
        return false;
    }

    private static boolean validateCollage5xn(View view, ViewDataBinding viewDataBinding) {
        if (view.mItems.size() >= 5) {
            return true;
        }
        viewDataBinding.getRoot().setVisibility(8);
        return false;
    }

    public static void maintainClpViewList(List<Page> list) {
        int indexOf = list.indexOf(Page.getDummyPage(ViewHolderFactory.TYPE_ITEM_TABBED));
        if (indexOf != -1) {
            list.remove(indexOf);
            list.add(list.size(), list.get(indexOf));
        }
    }

    public static void sanitizeInvalidOrder(ArrayList<Item> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2) != null && arrayList.get(i2).getStatusCode().intValue() > 0 && isValidStatusCode.get(arrayList.get(i2).getStatusCode()) == null) {
                arrayList.remove(i2);
            }
        }
    }
}
