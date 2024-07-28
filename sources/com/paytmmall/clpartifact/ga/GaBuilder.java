package com.paytmmall.clpartifact.ga;

import android.text.TextUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRAncestor;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.GAImpression;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.Promotion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GaBuilder {
    private static final String GA_KEY_DELIMITER = "/";

    public static GAImpression buildImpression(Page page, int i2) {
        View view = page.getViews().get(0);
        GAImpression gAImpression = new GAImpression();
        gAImpression.setmDimension40("");
        gAImpression.setmId(String.valueOf(page.getId()));
        gAImpression.setmDimesion38(String.valueOf(view.getId()));
        gAImpression.setmDimension67(view.getType());
        gAImpression.setmPosition(String.valueOf(i2));
        gAImpression.setmDimesion24(GAUtil.getGakey() + view.getTitle());
        gAImpression.setmList(GAUtil.getGakey() + view.getTitle());
        return gAImpression;
    }

    public static GAImpression buildImpression(Item item, int i2) {
        GAImpression gAImpression = new GAImpression();
        gAImpression.setmId(item.getId());
        gAImpression.setmName(item.getName());
        String dimension24ForInfiniteGrid = getDimension24ForInfiniteGrid(item.getGaData());
        gAImpression.setmList(dimension24ForInfiniteGrid);
        gAImpression.setMbrand(item.getmBrand());
        gAImpression.setmPrice(item.getOfferPrice());
        gAImpression.setmDimesion24(dimension24ForInfiniteGrid);
        String valueOf = String.valueOf(i2 + 1);
        gAImpression.setmPosition(valueOf);
        gAImpression.setmDimension25(valueOf);
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        if (communicationListener != null) {
            gAImpression.setmDimesion39(communicationListener.getSiteId());
        }
        gAImpression.setmDimesion70(valueOf);
        gAImpression.setmDimesion41(item.getmMerchantName());
        appendDimension79(gAImpression, item.getPromoData());
        if (item.getSponsored()) {
            gAImpression.setDimension52(item.getPlaTrackingId());
        }
        return gAImpression;
    }

    public static Promotion buildPromotion(Item item, int i2, int i3) {
        Promotion promotion = new Promotion();
        if (!(item.getMdisplaymetadata() == null || item.getMdisplaymetadata().getMmetadata() == null)) {
            promotion.setType("ads");
        }
        promotion.setTitle(item.getParentTitle());
        promotion.setId(item.getId());
        promotion.setName(getPromotionName(item.getGaData()));
        promotion.setPosition(getSlotPostion(item, i2, i3));
        promotion.setViewTag(item.getViewTag());
        promotion.setDimension40(item.getContainerinstatnceid());
        promotion.setCreative(TextUtils.isEmpty(item.getGaCategory()) ? item.getName() : appendDataIntoKey(item.getGaCategory(), item.getName()));
        promotion.setVariantInstanceID(item.getVariantInstanceId());
        promotion.setViewId(item.getParentId());
        promotion.setStorefrontId(item.getStorefrontId());
        promotion.setRequestId(item.getAdRequestId());
        promotion.setCtCampaignId(item.getCtCampaignId());
        promotion.setCtVariantId(item.getCtVariantId());
        if (item.getSponsored()) {
            promotion.setDimension52(item.getPlaTrackingId());
        }
        return promotion;
    }

    private static String getSlotPostion(Item item, int i2, int i3) {
        return "slot_" + (i2 + 1) + "_" + getParentPostion(item.getGaData(), i3) + "_" + item.getItemListSize();
    }

    private static String getParentPostion(Map<String, Object> map, int i2) {
        return (map == null || !map.containsKey(GAUtil.KEY_PREV_WIDGET_POSITION)) ? String.valueOf(i2 + 1) : String.valueOf(map.get(GAUtil.KEY_PREV_WIDGET_POSITION));
    }

    public static Promotion buildPromotion(View view, int i2) {
        String promotionName = getPromotionName(view.getGaData());
        Promotion promotion = new Promotion();
        promotion.setId(String.valueOf(view.getId()));
        promotion.setName(promotionName);
        promotion.setPosition(String.valueOf(i2 + 1));
        promotion.setDimension40(getContainerId(view));
        promotion.setCreative(view.getTitle());
        return promotion;
    }

    public static String getPromotionName(Map<String, Object> map) {
        return getDimension24ForInfiniteGrid(map);
    }

    public static String getContainerId(View view) {
        try {
            return view.getDataSources().get(0).getContainerInstanceId();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public static GAImpression buildImpression(CJRGridProduct cJRGridProduct, int i2) {
        GAImpression gAImpression = new GAImpression();
        if (cJRGridProduct != null) {
            gAImpression.setmName(cJRGridProduct.getName());
            gAImpression.setmId(cJRGridProduct.getProductID());
            gAImpression.setMbrand(cJRGridProduct.getBrand());
            gAImpression.setmPrice(cJRGridProduct.getDiscountedPrice());
            String dimension24ForInfiniteGrid = getDimension24ForInfiniteGrid(cJRGridProduct.getGaData());
            gAImpression.setmDimesion24(dimension24ForInfiniteGrid);
            String valueOf = String.valueOf(i2 + 1);
            gAImpression.setmPosition(valueOf);
            gAImpression.setmDimension25(valueOf);
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (communicationListener != null) {
                gAImpression.setmDimesion39(communicationListener.getSiteId());
            }
            gAImpression.setmDimesion70(valueOf);
            gAImpression.setmList(dimension24ForInfiniteGrid);
            gAImpression.setmDimesion41(cJRGridProduct.getMerchantName());
            gAImpression.setCategory(getAncestorsNames(cJRGridProduct.getAncestors()));
            gAImpression.setDimension43(getAncestorsIds(cJRGridProduct.getAncestors()));
            appendDimension79(gAImpression, cJRGridProduct.getPromoData());
            if (cJRGridProduct.isSponsored()) {
                gAImpression.setDimension52(cJRGridProduct.getPlaTrackingId());
            }
        }
        return gAImpression;
    }

    private static String getAncestorsIds(ArrayList<CJRAncestor> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            Iterator<CJRAncestor> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str = it2.next().getmAncestorID();
                if (sb.toString().isEmpty()) {
                    sb.append(str);
                } else {
                    sb.append("/");
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public static String getGAKey(Map<String, Object> map) {
        return map == null ? "" : getValueFromGAData(map, GAUtil.KEY_PREV_SCREEN_NAME);
    }

    public static String getDimension24ForInfiniteGrid(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        String gAKey = getGAKey(map);
        if (!TextUtils.isEmpty(GAUtil.getTimeSlot())) {
            return getDimension24ForFlashSale(gAKey, map);
        }
        return appendSlotAndTabInfo(appendDataIntoKey(appendDataIntoKey(appendDataIntoKey(gAKey, "widget" + getValueFromGAData(map, GAUtil.KEY_PREV_WIDGET_POSITION)), getValueFromGAData(map, GAUtil.KEY_PREV_WIDGET_TYPE)), getValueFromGAData(map, GAUtil.KEY_PREV_WIDGET_NAME)), getValueFromGAData(map, GAUtil.KEY_CATEGORY_TAB_NAME));
    }

    private static String getDimension24ForFlashSale(String str, Map<String, Object> map) {
        return appendSlotAndTabInfo(appendSlotAndTabInfo(str, GAUtil.getTimeSlot()), getValueFromGAData(map, GAUtil.KEY_CATEGORY_TAB_NAME));
    }

    private static String appendSlotAndTabInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "/" + str2;
    }

    private static String getValueFromGAData(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || (obj = map.get(str)) == null) {
            return "";
        }
        return String.valueOf(obj);
    }

    public static String appendDataIntoKey(String str, String str2) {
        String str3 = str + "/";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        return str3 + str2;
    }

    private static void appendDimension79(GAImpression gAImpression, List<CJRGridProduct.PromoData> list) {
        gAImpression.setmDimension79(getDimesion79(GAUtil.isFlashSale(list)));
    }

    public static GAImpression.Dimension79 getDimesion79(boolean z) {
        GAImpression.Dimension79 dimension79 = new GAImpression.Dimension79();
        dimension79.setmFlashSale(Boolean.valueOf(z));
        if (z) {
            dimension79.setTimeslot(GAUtil.getTimeSlot());
        }
        return dimension79;
    }

    private static String getAncestorsNames(ArrayList<CJRAncestor> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            Iterator<CJRAncestor> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str = it2.next().getmAncestorName();
                if (sb.toString().isEmpty()) {
                    sb.append(str);
                } else {
                    sb.append("/");
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public static String getPromotionName(Item item) {
        return "/-" + item.getParentType();
    }
}
