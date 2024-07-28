package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.g;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.ga.GaBuilder;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IClientDataListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.GAGridProductClick;
import com.paytmmall.clpartifact.utils.GAImpression;
import com.paytmmall.clpartifact.utils.GAPromotionImpression;
import com.paytmmall.clpartifact.utils.GaPromotionClick;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class GaHandler {
    private static final String TAG = GaHandler.class.getSimpleName();
    private static GaHandler sInstance;
    private HashSet<String> mFiredPromotionSet;
    private Handler mHandler;
    private final HandlerThread mHandlerThread = new HandlerThread("GaHandler:Thread");
    private Queue<GAImpression> mProductImpression;
    private Queue<Promotion> mPromoImpression;

    private GaHandler() {
        init();
    }

    private void init() {
        this.mPromoImpression = new LinkedList();
        this.mProductImpression = new LinkedList();
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mFiredPromotionSet = new HashSet<>();
    }

    public static GaHandler getInstance() {
        if (sInstance == null) {
            synchronized (GaHandler.class) {
                if (sInstance == null) {
                    sInstance = new GaHandler();
                }
            }
        }
        return sInstance;
    }

    public void fireImpression(View view, int i2) {
        if (view != null && !view.isGaAdded()) {
            view.setGaAdded(true);
            this.mHandler.post(new Runnable(view, i2) {
                private final /* synthetic */ View f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GaHandler.this.lambda$fireImpression$0$GaHandler(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$fireImpression$0$GaHandler(View view, int i2) {
        fireImpression(GaBuilder.buildPromotion(view, i2), view.getGaData());
    }

    public void fireImpression(Item item, int i2) {
        if (item != null && !this.mFiredPromotionSet.contains(item.getId())) {
            this.mFiredPromotionSet.add(item.getId());
            if (item.isPromotion()) {
                firePromotionImpressionGA(item, i2);
            } else {
                fireProductImpressionGA(item, i2);
            }
        }
    }

    private void firePromotionImpressionGA(Item item, int i2) {
        this.mHandler.post(new Runnable(item, i2) {
            private final /* synthetic */ Item f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GaHandler.this.lambda$firePromotionImpressionGA$1$GaHandler(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$firePromotionImpressionGA$1$GaHandler(Item item, int i2) {
        fireImpression(GaBuilder.buildPromotion(item, i2, -1), item.getGaData());
    }

    private void fireProductImpressionGA(Item item, int i2) {
        this.mHandler.post(new Runnable(item, i2) {
            private final /* synthetic */ Item f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GaHandler.this.lambda$fireProductImpressionGA$2$GaHandler(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$fireProductImpressionGA$2$GaHandler(Item item, int i2) {
        fireProductImpression(GaBuilder.buildImpression(item, i2), item.getGaData());
    }

    public void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        if (cJRGridProduct != null && !cJRGridProduct.getIsAdded()) {
            cJRGridProduct.setAddedtoGA(Boolean.TRUE);
            fireProductImpression(GaBuilder.buildImpression(cJRGridProduct, i2), cJRGridProduct.getGaData());
        }
    }

    private void fireImpression(Promotion promotion, Map<String, Object> map) {
        this.mPromoImpression.add(promotion);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mPromoImpression);
        this.mPromoImpression.clear();
        submitImpressionList(arrayList, map, (IClientDataListener) null);
    }

    public void fireRecoImpression(Item item, int i2, Map<String, Object> map) {
        if (item != null && !this.mFiredPromotionSet.contains(item.getId())) {
            Promotion buildPromotion = GaBuilder.buildPromotion(item, i2, (item.getGaData() == null || !item.getGaData().containsKey(CLPConstants.WIDGET_BIND_POSITION)) ? item.getParentBindPosition() : Integer.parseInt(String.valueOf(item.getGaData().get(CLPConstants.WIDGET_BIND_POSITION))));
            buildPromotion.setName(GaBuilder.getPromotionName(item));
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildPromotion);
            this.mFiredPromotionSet.add(item.getId());
            submitImpressionList(arrayList, map, (IClientDataListener) null);
        }
    }

    public void submitImpressionList(List<Promotion> list, Map<String, Object> map, IClientDataListener iClientDataListener) {
        GAPromotionImpression gAPromotionImpression = new GAPromotionImpression();
        GAPromotionImpression.PromoView promoView = new GAPromotionImpression.PromoView();
        promoView.setImpressionsList(list);
        gAPromotionImpression.setPromotion(promoView);
        String gAKey = GaBuilder.getGAKey(map);
        if (TextUtils.isEmpty(gAKey) && iClientDataListener != null) {
            gAKey = iClientDataListener.getScreenName();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(GAUtil.event, GAUtil.eventPromotionImpression);
        hashMap.put(GAUtil.screenName, gAKey);
        hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
        hashMap.put(GAUtil.verticalName, iClientDataListener != null ? iClientDataListener.getVerticalID() : GAUtil.MARKET_PLACE);
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put("ecommerce", gVar.a().a(gAPromotionImpression.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionImpression, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void emptyPendingQueue() {
        this.mHandler.post(new Runnable() {
            public final void run() {
                GaHandler.this.lambda$emptyPendingQueue$3$GaHandler();
            }
        });
    }

    public /* synthetic */ void lambda$emptyPendingQueue$3$GaHandler() {
        emptyPromotionImpression();
        emptyProductImpression();
    }

    private void emptyPromotionImpression() {
        if (this.mPromoImpression.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mPromoImpression);
            this.mPromoImpression.clear();
            GAPromotionImpression gAPromotionImpression = new GAPromotionImpression();
            GAPromotionImpression.PromoView promoView = new GAPromotionImpression.PromoView();
            promoView.setImpressionsList(arrayList);
            gAPromotionImpression.setPromotion(promoView);
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, GAUtil.eventPromotionImpression);
            hashMap.put(GAUtil.screenName, GAUtil.getGakey());
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
            g gVar = new g();
            gVar.f39467e = false;
            hashMap.put("ecommerce", gVar.a().a(gAPromotionImpression.toJson(), new a<HashMap<String, Object>>() {
            }.getType()));
            CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionImpression, hashMap, CLPArtifact.getInstance().getContext());
        }
    }

    private void emptyProductImpression() {
        if (this.mProductImpression.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mProductImpression);
            this.mProductImpression.clear();
            GAProductImpression gAProductImpression = new GAProductImpression();
            gAProductImpression.setImpressionsList(arrayList);
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, GAUtil.eventProductImpression);
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
            g gVar = new g();
            gVar.f39467e = false;
            f a2 = gVar.a();
            hashMap.put("ecommerce", a2.a(a2.b(gAProductImpression), new a<HashMap<String, Object>>() {
            }.getType()));
            CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventProductImpression, hashMap, CLPArtifact.getInstance().getContext());
        }
    }

    private void fireProductImpression(GAImpression gAImpression, Map<String, Object> map) {
        this.mProductImpression.add(gAImpression);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mProductImpression);
        this.mProductImpression.clear();
        GAProductImpression gAProductImpression = new GAProductImpression();
        gAProductImpression.setImpressionsList(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put(GAUtil.event, GAUtil.eventProductImpression);
        hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(map));
        hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
        hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
        g gVar = new g();
        gVar.f39467e = false;
        f a2 = gVar.a();
        hashMap.put("ecommerce", a2.a(a2.b(gAProductImpression), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventProductImpression, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireClickEvent(Item item, int i2) {
        if (item != null) {
            if (item.isPromotion()) {
                firePromotionClickEvent(item, i2, (IClientDataListener) null);
            } else {
                fireInfiniteProductClick(item, Integer.valueOf(i2), CLPArtifact.getInstance().getContext());
            }
        }
    }

    public void fireClickEvent(View view, int i2) {
        if (view != null) {
            firePromotionClickEvent(view, i2);
        }
    }

    public void fireClickEvent(CJRGridProduct cJRGridProduct, int i2, Map<String, Object> map) {
        if (cJRGridProduct != null) {
            cJRGridProduct.setAddedtoGA(Boolean.TRUE);
            fireInfiniteProductClick(cJRGridProduct, Integer.valueOf(i2), CLPArtifact.getInstance().getContext(), map);
        }
    }

    private void fireInfiniteProductClick(CJRGridProduct cJRGridProduct, Integer num, Context context, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(GAUtil.event, "click");
        hashMap.put(GAUtil.evetName, GAUtil.eventProductClick);
        String dimension24ForInfiniteGrid = GaBuilder.getDimension24ForInfiniteGrid(map);
        hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(map));
        hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(context));
        hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
        GAGridProductClick gAGridProductClick = new GAGridProductClick();
        GAGridProductClick.clickData clickdata = new GAGridProductClick.clickData();
        GAGridProductClick.actionField actionfield = new GAGridProductClick.actionField();
        actionfield.setListType(dimension24ForInfiniteGrid);
        clickdata.setField(actionfield);
        GAGridProductClick.productList productlist = new GAGridProductClick.productList();
        productlist.setmId(!TextUtils.isEmpty(cJRGridProduct.getItemID()) ? cJRGridProduct.getItemID() : cJRGridProduct.getProductID());
        String str = "";
        productlist.setmName(!TextUtils.isEmpty(cJRGridProduct.getName()) ? cJRGridProduct.getName() : str);
        productlist.setMbrand(!TextUtils.isEmpty(cJRGridProduct.getBrand()) ? cJRGridProduct.getBrand() : str);
        productlist.setmPrice(!TextUtils.isEmpty(cJRGridProduct.getDiscountedPrice()) ? cJRGridProduct.getDiscountedPrice() : str);
        productlist.setCategory(!TextUtils.isEmpty(cJRGridProduct.getItemID()) ? cJRGridProduct.getCategoryId() : str);
        String valueOf = String.valueOf(num.intValue() + 1);
        productlist.setmPosition(valueOf);
        productlist.setmDimension25(valueOf);
        productlist.setDimension31(!TextUtils.isEmpty(cJRGridProduct.getAncestorID()) ? cJRGridProduct.getAncestorID() : str);
        if (!TextUtils.isEmpty(cJRGridProduct.getItemID())) {
            str = cJRGridProduct.getItemID();
        }
        productlist.setmDimesion38(str);
        productlist.setmDimesion39(CLPArtifact.getInstance().getCommunicationListener().getSiteId());
        productlist.setmDimesion41(!TextUtils.isEmpty(String.valueOf(cJRGridProduct.getMerchantId())) ? String.valueOf(cJRGridProduct.getMerchantId()) : "0");
        productlist.setmDimesion24(dimension24ForInfiniteGrid);
        productlist.setmDimension79(getDimesion79(cJRGridProduct.getPromoData()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(productlist);
        clickdata.setProductList(arrayList);
        gAGridProductClick.setData(clickdata);
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put("ecommerce", gVar.a().a(gAGridProductClick.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventProductClick, hashMap, context);
    }

    private void fireInfiniteProductClick(Item item, Integer num, Context context) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(GAUtil.event, "click");
        hashMap.put(GAUtil.evetName, GAUtil.eventProductClick);
        Map<String, Object> gaData = item.getGaData();
        String dimension24ForInfiniteGrid = GaBuilder.getDimension24ForInfiniteGrid(gaData);
        hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(gaData));
        hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(context));
        hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
        GAGridProductClick gAGridProductClick = new GAGridProductClick();
        GAGridProductClick.clickData clickdata = new GAGridProductClick.clickData();
        GAGridProductClick.actionField actionfield = new GAGridProductClick.actionField();
        actionfield.setListType(dimension24ForInfiniteGrid);
        clickdata.setField(actionfield);
        GAGridProductClick.productList productlist = new GAGridProductClick.productList();
        productlist.setmId(item.getmId());
        String str2 = "";
        productlist.setmName(TextUtils.isEmpty(item.getName()) ? str2 : item.getName());
        productlist.setMbrand(!TextUtils.isEmpty(item.getmBrand()) ? item.getmBrand() : str2);
        productlist.setmPrice(!TextUtils.isEmpty(item.getOfferPrice()) ? item.getOfferPrice() : str2);
        if (item.getItemId() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(item.getItemId());
            str = sb.toString();
        } else {
            str = item.getGaCategory();
        }
        productlist.setCategory(str);
        productlist.setmPosition(String.valueOf(num.intValue() + 1));
        if (item.getItemId() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(item.getItemId());
            str2 = sb2.toString();
        }
        productlist.setmDimesion38(str2);
        productlist.setmDimesion39(CLPArtifact.getInstance().getCommunicationListener().getSiteId());
        productlist.setmDimesion41(!TextUtils.isEmpty(String.valueOf(item.getMerchandID())) ? String.valueOf(item.getMerchandID()) : "0");
        productlist.setmDimesion24(dimension24ForInfiniteGrid);
        productlist.setmDimension79(getDimesion79(item.getPromoData()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(productlist);
        clickdata.setProductList(arrayList);
        gAGridProductClick.setData(clickdata);
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put("ecommerce", gVar.a().a(gAGridProductClick.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("productClick", hashMap, context);
    }

    public void firePromotionClickEvent(Item item, int i2, IClientDataListener iClientDataListener) {
        if (item != null) {
            item.setAddedtoGA(Boolean.TRUE);
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.evetName, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.verticalName, iClientDataListener != null ? iClientDataListener.getVerticalID() : GAUtil.MARKET_PLACE);
            String gAKey = GaBuilder.getGAKey(item.getGaData());
            if (TextUtils.isEmpty(gAKey) && iClientDataListener != null) {
                gAKey = iClientDataListener.getScreenName();
            }
            hashMap.put(GAUtil.screenName, gAKey);
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion buildPromotion = GaBuilder.buildPromotion(item, i2, item.getParentBindPosition());
            if (iClientDataListener != null) {
                buildPromotion.setName(GaBuilder.getPromotionName(item));
            }
            arrayList.add(buildPromotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            g gVar = new g();
            gVar.f39467e = false;
            hashMap.put("ecommerce", gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
            }.getType()));
            CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionClick, hashMap, CLPArtifact.getInstance().getContext());
        }
    }

    private void firePromotionClickEvent(View view, int i2) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, "click");
            hashMap.put(GAUtil.evetName, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.verticalName, GAUtil.MARKET_PLACE);
            Map<String, Object> gaData = view.getGaData();
            hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(gaData));
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion promotion = new Promotion();
            StringBuilder sb = new StringBuilder();
            sb.append(view.getId());
            promotion.setId(sb.toString());
            promotion.setName(GaBuilder.getPromotionName(gaData));
            promotion.setCreative(TextUtils.isEmpty(view.getTitle()) ? "" : view.getTitle());
            promotion.setPosition(String.valueOf(i2));
            promotion.setDimension40(GaBuilder.getContainerId(view));
            arrayList.add(promotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            g gVar = new g();
            gVar.f39467e = false;
            hashMap.put("ecommerce", gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
            }.getType()));
            CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("promotionClick", hashMap, CLPArtifact.getInstance().getContext());
        }
    }

    public void fireAddToCartEvent(CJRGridProduct cJRGridProduct) {
        String gAKey = GaBuilder.getGAKey(cJRGridProduct.getGaData());
        HashMap hashMap = new HashMap();
        hashMap.put("event_action", GAUtil.ADD_TO_CART);
        hashMap.put("vertical_name", GAUtil.MARKET_PLACE);
        hashMap.put("user_id", CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
        hashMap.put(GAUtil.evetName, "add_to_cart_clicked");
        hashMap.put(GAUtil.screenName, gAKey);
        hashMap.put("event_category", CLPConstants.DEFAULT_GRID_VIEW_TYPE);
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireSearchEvent() {
        CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(CLPArtifact.getInstance().getContext(), "top_nav", "search_textbox_clicked", "", "", "top nav", GAUtil.MARKET_PLACE);
    }

    public void fireClearFilterEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_filters_reset_clicked", hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireSortMenuClickEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_sort_menu_clicked", hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireSortFilterAppliedEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("product_grid_sort_filter_name", str);
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_sort_applied", hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireFilterPriceRangeChanged(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("product_grid_price_range", str + "/" + str2);
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_price_range_selected", hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireGridFilterAppliedEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("product_grid_selected_field_category", str);
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_filters_applied", hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireGridCategoryAction(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_grid_page_type", "non_search");
        hashMap.put("nav_user_id", TextUtils.isEmpty(getUserId()) ? "" : getUserId());
        hashMap.put("product_grid_category_action", str);
        hashMap.put("product_grid_category_item", str2);
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap("product_grid_category_action_performed", hashMap, CLPArtifact.getInstance().getContext());
    }

    private String getUserId() {
        return CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext());
    }

    public void fireClickFollowEvent(String str, String str2) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Context context = CLPArtifact.getInstance().getContext();
        communicationListener.sendCustomGTMEvents(context, "merchant_clp", "follow_button_clicked", "{brand_name=" + str + "}", "", str2, GAUtil.MARKET_PLACE);
    }

    public void fireClickUnFollowEvent(String str, String str2) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Context context = CLPArtifact.getInstance().getContext();
        communicationListener.sendCustomGTMEvents(context, "merchant_clp", "unfollow_button_clicked", "{brand_name=" + str + "}", "", str2, GAUtil.MARKET_PLACE);
    }

    public void fireISAdEvent(CJRHomePageItem cJRHomePageItem, Context context, String str) {
        if (CLPArtifact.isCLPListenerAvailable()) {
            CLPArtifact.getInstance().getCommunicationListener().sendInterStetialEvent(cJRHomePageItem, context, str);
        }
    }

    private static GAImpression.Dimension79 getDimesion79(List<CJRGridProduct.PromoData> list) {
        return GaBuilder.getDimesion79(GAUtil.isFlashSale(list));
    }

    public void clearFiredPromoSet() {
        this.mFiredPromotionSet.clear();
    }

    public void fireGroupGrid(Item item, int i2) {
        if (item != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, "click");
            hashMap.put(GAUtil.evetName, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(item.getGaData()));
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion promotion = new Promotion();
            promotion.setId(item.getId() != null ? item.getId() : "");
            promotion.setName(!TextUtils.isEmpty(item.getParentType()) ? item.getParentType() : " ");
            promotion.setCreative(item.getName());
            promotion.setPosition(String.valueOf(i2));
            promotion.setDimension40(item.getContainerinstatnceid());
            arrayList.add(promotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(hashMap, gaPromotionClick) {
                private final /* synthetic */ HashMap f$1;
                private final /* synthetic */ GaPromotionClick f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GaHandler.this.lambda$fireGroupGrid$4$GaHandler(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$fireGroupGrid$4$GaHandler(HashMap hashMap, GaPromotionClick gaPromotionClick) {
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put(CLPArtifact.getInstance().getContext().getString(R.string.ecommerce), gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionClick, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireCrossCLick(Item item, int i2) {
        if (item != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.evetName, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(item.getGaData()));
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion promotion = new Promotion();
            promotion.setId(item.getId() != null ? item.getId() : "");
            promotion.setName(!TextUtils.isEmpty(item.getParentType()) ? item.getParentType() : " ");
            promotion.setCreative(item.getName() + "_cross_clicked");
            promotion.setPosition(String.valueOf(i2));
            promotion.setDimension40(item.getContainerinstatnceid());
            arrayList.add(promotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable(hashMap, gaPromotionClick) {
                private final /* synthetic */ HashMap f$1;
                private final /* synthetic */ GaPromotionClick f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    GaHandler.this.lambda$fireCrossCLick$5$GaHandler(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$fireCrossCLick$5$GaHandler(HashMap hashMap, GaPromotionClick gaPromotionClick) {
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put(CLPArtifact.getInstance().getContext().getString(R.string.ecommerce), gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionClick, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void firePopUpEvent(CJRHomePageItem cJRHomePageItem, int i2, String str) {
        if (cJRHomePageItem != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, "click");
            hashMap.put(GAUtil.evetName, str);
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion promotion = new Promotion();
            promotion.setId(cJRHomePageItem.getItemID() != null ? cJRHomePageItem.getItemID() : "");
            promotion.setName(CLPConstants.GTM_FLASH_POPUP);
            promotion.setCreative(cJRHomePageItem.getName());
            promotion.setPosition(String.valueOf(i2));
            promotion.setDimension40(cJRHomePageItem.getmContainerInstanceID());
            arrayList.add(promotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(hashMap, gaPromotionClick, str) {
                private final /* synthetic */ HashMap f$1;
                private final /* synthetic */ GaPromotionClick f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    GaHandler.this.lambda$firePopUpEvent$6$GaHandler(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    public /* synthetic */ void lambda$firePopUpEvent$6$GaHandler(HashMap hashMap, GaPromotionClick gaPromotionClick, String str) {
        g gVar = new g();
        gVar.f39467e = false;
        hashMap.put(CLPArtifact.getInstance().getContext().getString(R.string.ecommerce), gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
        }.getType()));
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(str, hashMap, CLPArtifact.getInstance().getContext());
    }

    public void fireRecoState(Item item, int i2, String str) {
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable(item, str, i2) {
            private final /* synthetic */ Item f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                GaHandler.this.lambda$fireRecoState$7$GaHandler(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$fireRecoState$7$GaHandler(Item item, String str, int i2) {
        if (item != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GAUtil.event, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.evetName, GAUtil.eventPromotionClick);
            hashMap.put(GAUtil.screenName, GaBuilder.getGAKey(item.getGaData()));
            hashMap.put(GAUtil.customerId, CLPArtifact.getInstance().getCommunicationListener().getUserId(CLPArtifact.getInstance().getContext()));
            GaPromotionClick gaPromotionClick = new GaPromotionClick();
            GaPromotionClick.PromoClick promoClick = new GaPromotionClick.PromoClick();
            ArrayList arrayList = new ArrayList();
            Promotion promotion = new Promotion();
            promotion.setId(item.getId() != null ? item.getId() : "");
            promotion.setName(!TextUtils.isEmpty(item.getParentType()) ? item.getParentType() : " ");
            promotion.setCreative(str.equals(CLPConstants.COLLAPSED) ? "Show More" : "Show Less");
            promotion.setType(str);
            promotion.setPosition(String.valueOf(i2));
            promotion.setDimension40(item.getContainerinstatnceid());
            arrayList.add(promotion);
            promoClick.setPromotions(arrayList);
            gaPromotionClick.setPromoClick(promoClick);
            g gVar = new g();
            gVar.f39467e = false;
            hashMap.put(CLPArtifact.getInstance().getContext().getString(R.string.ecommerce), gVar.a().a(gaPromotionClick.toJson(), new a<HashMap<String, Object>>() {
            }.getType()));
            CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.eventPromotionClick, hashMap, CLPArtifact.getInstance().getContext());
        }
    }

    public void sendClickEventForWidgets(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_action", str);
        hashMap.put("event_category", str2);
        hashMap.put("event_label", str3);
        CLPArtifact.getInstance().getCommunicationListener().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, CLPArtifact.getInstance().getContext());
    }
}
