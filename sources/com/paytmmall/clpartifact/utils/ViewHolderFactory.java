package com.paytmmall.clpartifact.utils;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.Carousel13Binding;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleLayoutBinding;
import com.paytmmall.clpartifact.databinding.ItemDefaultBinding;
import com.paytmmall.clpartifact.databinding.ItemFullWidthRootRvSmallTiBinding;
import com.paytmmall.clpartifact.databinding.ItemReco4xRvBinding;
import com.paytmmall.clpartifact.databinding.ItemRecoMainLytBinding;
import com.paytmmall.clpartifact.databinding.ItemRootRvNewBinding;
import com.paytmmall.clpartifact.databinding.ItemSmartHeaderRootBinding;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnBinding;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnRootBinding;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButtonBinding;
import com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderV2RootBinding;
import com.paytmmall.clpartifact.databinding.NewGroupGridRvBinding;
import com.paytmmall.clpartifact.databinding.OptimizeLytRootRvBinding;
import com.paytmmall.clpartifact.databinding.ParentStandardRvBinding;
import com.paytmmall.clpartifact.databinding.SmartGroupGrid4xnRvBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.view.HomeBanner3xnVHWithRV;
import com.paytmmall.clpartifact.view.viewHolder.BannerVHWithRV;
import com.paytmmall.clpartifact.view.viewHolder.BlueStripVH;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPCTAListViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarousel4X;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarousel_1_3;
import com.paytmmall.clpartifact.view.viewHolder.CLPCraousalBS1LowDimensionImageListViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPDealsVH;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemActiveOrder;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemInCartViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithVP;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.CLPMerchantBannerVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.CLPRecoListVH;
import com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconButton;
import com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconButton2XN;
import com.paytmmall.clpartifact.view.viewHolder.CLPSmartIconHeader;
import com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV;
import com.paytmmall.clpartifact.view.viewHolder.DefaultViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.FlashSaleViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.HomePortraitVH;
import com.paytmmall.clpartifact.view.viewHolder.InfiniteGridRowViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.RecoWidgetRechargeVH;
import com.paytmmall.clpartifact.view.viewHolder.SealTrustViewHodler;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconButton2XNItemVH;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconButtonItemVH;
import com.paytmmall.clpartifact.view.viewHolder.SmartIconHeaderV2RootVH;
import com.paytmmall.clpartifact.view.viewHolder.TreeWidgetViewHolder;
import com.paytmmall.clpartifact.view.viewmodel.NewSmartGroupVh;
import com.paytmmall.clpartifact.view.viewmodel.SmartGroupGrid4XNVH;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ViewHolderFactory {
    public static final String CAROUSEL_1_3 = "carousel-1_3";
    public static final String CLASS_FULL_WIDTH_IMAGE = "full-width-image";
    public static final String CLASS_HOME = "home";
    public static final String CLASS_LARGE_ICON = "large-icon";
    public static final String CLASS_LOW_DIMENSION_IMAGE = "low-dimension-image";
    public static final String CLASS_SEARCH_TIPS = "search_tips";
    private static HashMap<String, Integer> GRID_VIEW_TYPE_MAP = new HashMap<String, Integer>() {
        {
            put("grid", 2);
            put(ViewHolderFactory.TYPE_LARGE_GRID_SL, 2);
            put(ViewHolderFactory.TYPE_LARGE_GRID_DL, 2);
            put(ViewHolderFactory.TYPE_GRID_SL, 2);
            put(ViewHolderFactory.TYPE_GRID_DL, 2);
            put(ViewHolderFactory.TYPE_LIST, 1);
            put(ViewHolderFactory.TYPE_LARGE_LIST_SL, 1);
            put(ViewHolderFactory.TYPE_LARGE_LIST_DL, 1);
            put(ViewHolderFactory.TYPE_LIST_SL, 1);
            put(ViewHolderFactory.TYPE_LIST_DL, 1);
            put(ViewHolderFactory.TYPE_LIST_FMCG, 1);
            put(ViewHolderFactory.TYPE_COLLECTIONS, 1);
            put(ViewHolderFactory.TYPE_FREE_DEALS_GRID, 5);
            put(ViewHolderFactory.TYPE_DEALS_GRID, 4);
            put(ViewHolderFactory.TYPE_FOOD_LIST_WITH_DESCRIPTION, 3);
            put(ViewHolderFactory.TYPE_FOOD_LIST, 3);
        }
    };
    public static final String LARGE = "large";
    public static final String LAYOUT_CAROUSEL_3 = "carousel-3";
    public static final String LAYOUT_RECENTS = "recents-list";
    public static final String LAYOUT_SMART_ICON_BUTTON = "smart-icon-button";
    public static final String LAYOUT_SMART_ICON_BUTTON_2XN = "smart-icon-button-2xn";
    public static final String LAYOUT_SMART_ICON_GROUP_GRID = "smart-icon-group-grid";
    public static final String LAYOUT_SMART_ICON_GROUP_GRID_4XN = "smart-icon-grid-4xn";
    public static final String LAYOUT_SMART_ICON_GROUP_GRI_2_0 = "smart-icon-group-grid_2.0";
    public static final String LAYOUT_SMART_ICON_HEADER = "smart-icon-header";
    public static final String LAYOUT_SMART_ICON_HEADER_V2 = "smart-icon-header-v2";
    private static HashSet<String> NEW_ITEM_TYPES = new HashSet<String>() {
        {
            add(ViewHolderFactory.TYPE_LIST_SMALL_TI);
            add(ViewHolderFactory.TYPE_CAROUSEL_RECO);
            add(ViewHolderFactory.TYPE_SEAL_TRUST);
            add(ViewHolderFactory.TYPE_BANNER_2);
            add(ViewHolderFactory.TYPE_BANNER_3);
            add(ViewHolderFactory.TYPE_PORTRAIT_3XN);
            add(ViewHolderFactory.TYPE_CAROUSEL_ICON_4X);
            add(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN);
            add(ViewHolderFactory.TYPE_CAROUSEL_TOI);
        }
    };
    public static final String TYPE_ACTIVE_ORDER = "active_order";
    public static final String TYPE_BANNER_2 = "banner-2_0";
    public static final String TYPE_BANNER_2XN = "banner-2xn";
    public static final String TYPE_BANNER_2_FULL_WIDTH = "banner-2_0_full_width";
    public static final String TYPE_BANNER_3 = "banner-3_0";
    public static final String TYPE_BANNER_3XN = "banner-3xn";
    public static final String TYPE_BANNER_3XN_HOME = "banner_3xn_home";
    public static final String TYPE_BANNER_3_FULL_WIDTH = "banner-3_0_full_width";
    public static final String TYPE_BLUE_STRIP = "sell_partner_contact_icons";
    public static final String TYPE_C1_SQUARE_BANNER = "c1-square-banner";
    public static final String TYPE_C4_LARGE = "c4-large";
    public static final String TYPE_CAROUSEL_1 = "carousel-1";
    public static final String TYPE_CAROUSEL_2 = "carousel-2";
    public static final String TYPE_CAROUSEL_4 = "carousel-4";
    public static final String TYPE_CAROUSEL_BS1 = "carousel-bs1";
    public static final String TYPE_CAROUSEL_BS1_LOW_DIMENTION_IAMGE = "carousel-bs1-home";
    public static final String TYPE_CAROUSEL_BS2 = "carousel-bs2";
    public static final String TYPE_CAROUSEL_ICON_4X = "carousal-icon-4x";
    public static final String TYPE_CAROUSEL_LOCKED_CARD = "carousel-locked-cards";
    public static final String TYPE_CAROUSEL_RECO = "carousel-reco";
    public static final String TYPE_CAROUSEL_RECO_LARGE_IMAGE = "carousel-reco-large-image";
    public static final String TYPE_CAROUSEL_SCRATCH_CARD = "carousel-scratch-card";
    public static final String TYPE_CAROUSEL_TOI = "carousel-toi";
    public static final String TYPE_COLLAGE_3X = "collage-3x";
    public static final String TYPE_COLLAGE_5X = "collage-5x";
    private static final String TYPE_COLLECTIONS = "collections";
    public static final String TYPE_DEALS_2XN = "deals-2xn";
    private static final String TYPE_DEALS_GRID = "dealsgrid";
    private static final String TYPE_FOOD_LIST = "foodlist";
    private static final String TYPE_FOOD_LIST_WITH_DESCRIPTION = "foodlistwithdescription";
    private static final String TYPE_FREE_DEALS_GRID = "freedealsgrid";
    private static final String TYPE_GRID = "grid";
    private static final String TYPE_GRID_DL = "griddl";
    private static final String TYPE_GRID_SL = "gridsl";
    public static final String TYPE_H1_BANNER = "h1-banner";
    public static final String TYPE_H1_BANNER_FULL_WIDTH_CLASS = "h1-banner-full-width-image";
    public static final String TYPE_H1_BANNER_HOME_BANNER = "h1-banner-home";
    public static final String TYPE_H1_FULL_BANNER = "h1-full-banner";
    public static final String TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS = "h1-full-banner-full-width-image";
    public static final String TYPE_H1_FULL_BANNER_HOME_BANNER = "h1-full-banner-home";
    public static final String TYPE_H1_MERCHANT_BANNER = "h1-merchant-banner";
    public static final String TYPE_H1_STORE_BANNER = "h1-store-banner";
    public static final String TYPE_HOME_THIN_BANNER = "thin-banner-home";
    public static final String TYPE_ITEM_IN_CART = "item_in_cart";
    public static final String TYPE_ITEM_IN_WISHLIST = "item_in_wishlist";
    public static final String TYPE_ITEM_TABBED = "tabbed-1";
    public static final String TYPE_ITEM_TABBED_2 = "tabbed-2";
    private static final String TYPE_LARGE_GRID_DL = "largegriddl";
    private static final String TYPE_LARGE_GRID_SL = "largegridsl";
    private static final String TYPE_LARGE_LIST_DL = "largelistdl";
    private static final String TYPE_LARGE_LIST_SL = "largelistsl";
    private static final String TYPE_LIST = "list";
    private static final String TYPE_LIST_DL = "listdl";
    public static final String TYPE_LIST_FMCG = "listfmcg";
    private static final String TYPE_LIST_SL = "listsl";
    public static final String TYPE_LIST_SMALL_TI = "list-small-ti";
    public static final String TYPE_P4B_ANNOUNCEMENT = "p4b-announcement";
    public static final String TYPE_P4B_HOMETABS = "p4b-hometabs";
    public static final String TYPE_P4B_QR = "p4b-qr";
    public static final String TYPE_PORTRAIT_3XN = "portrait-3xn";
    public static final String TYPE_PROMO_OFFERS = "promo-offers";
    public static final String TYPE_RECENTLY_VIEWED = "recently_viewed";
    public static final String TYPE_RECO_RECHARGE = "carousel-reco-v2";
    public static final String TYPE_ROW = "row";
    public static final String TYPE_ROW_1XN = "row-1xn";
    public static final String TYPE_ROW_2XN = "row-2xn";
    public static final String TYPE_ROW_3XN = "row-3xn";
    public static final String TYPE_ROW_BS1 = "row-bs1";
    public static final String TYPE_ROW_BS2 = "row-bs2";
    public static final String TYPE_SEAL_TRUST = "footer";
    public static final String TYPE_SEARCH_WIDGET = "search-bar";
    public static final String TYPE_SMART_ICON_GRID = "smart-icon-grid";
    public static final String TYPE_SMART_ICON_LIST = "smart-icon-list";
    public static final String TYPE_TABBED_2_SALE = "tabbed-2-sale";
    public static final String TYPE_THIN_BANNER = "thin-banner";
    public static final String TYPE_THIN_SMALL_BANNER = "thin-small";
    public static final String TYPE_TREE_1 = "tree-1";
    public static final String TYPE_TREE_3 = "tree-3";
    private static Map<String, Integer> VIEW_TYPE_CHILD_HOLDER_MAP = new HashMap<String, Integer>() {
        {
            put(ViewHolderFactory.TYPE_CAROUSEL_1, Integer.valueOf(R.layout.item_carousel_one));
            put(ViewHolderFactory.TYPE_C4_LARGE, Integer.valueOf(R.layout.item_carosel_four_large));
            put(ViewHolderFactory.CAROUSEL_1_3, Integer.valueOf(R.layout.carousel_1_3));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID, Integer.valueOf(R.layout.item_smart_grp_grid));
            put(ViewHolderFactory.LAYOUT_RECENTS, Integer.valueOf(R.layout.item_smart_grp_grid));
            put(ViewHolderFactory.TYPE_CAROUSEL_2, Integer.valueOf(R.layout.item_carosel_two));
            put(ViewHolderFactory.TYPE_CAROUSEL_4, Integer.valueOf(R.layout.item_carousel_four));
            put(ViewHolderFactory.TYPE_CAROUSEL_BS1, Integer.valueOf(R.layout.item_carousel_bs1));
            put(ViewHolderFactory.TYPE_CAROUSEL_BS1_LOW_DIMENTION_IAMGE, Integer.valueOf(R.layout.item_carousel_bs1_low_dimensions_image_class));
            put(ViewHolderFactory.TYPE_SMART_ICON_LIST, Integer.valueOf(R.layout.item_smart_icon_list));
            put(ViewHolderFactory.TYPE_SMART_ICON_GRID, Integer.valueOf(R.layout.item_smart_icon_grid));
            put(ViewHolderFactory.TYPE_CAROUSEL_BS2, Integer.valueOf(R.layout.item_carosel_bs2));
            put(ViewHolderFactory.TYPE_ROW_BS1, Integer.valueOf(R.layout.item_row_bs1));
            put(ViewHolderFactory.TYPE_ROW_BS2, Integer.valueOf(R.layout.item_row_bs2));
            put(ViewHolderFactory.TYPE_ROW, Integer.valueOf(R.layout.item_row));
            put(ViewHolderFactory.TYPE_C1_SQUARE_BANNER, Integer.valueOf(R.layout.item_square_banner));
            put(ViewHolderFactory.TYPE_ROW_1XN, Integer.valueOf(R.layout.item_row1xn));
            put(ViewHolderFactory.TYPE_ROW_2XN, Integer.valueOf(R.layout.item_row2xn));
            put(ViewHolderFactory.TYPE_ROW_3XN, Integer.valueOf(R.layout.item_row3xn));
            put(ViewHolderFactory.TYPE_RECENTLY_VIEWED, Integer.valueOf(R.layout.item_cart));
            put(ViewHolderFactory.TYPE_ITEM_IN_WISHLIST, Integer.valueOf(R.layout.item_cart));
            put(ViewHolderFactory.TYPE_BANNER_2XN, Integer.valueOf(R.layout.item_banner_3xn));
            put(ViewHolderFactory.TYPE_BANNER_3XN, Integer.valueOf(R.layout.item_banner_3xn));
            put(ViewHolderFactory.TYPE_ITEM_IN_CART, Integer.valueOf(R.layout.item_cart));
            put(ViewHolderFactory.TYPE_ACTIVE_ORDER, Integer.valueOf(R.layout.item_active_order));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER, Integer.valueOf(R.layout.item_smart_icon_header));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON, Integer.valueOf(R.layout.item_smart_icon_button));
            put(ViewHolderFactory.TYPE_LIST_SMALL_TI, Integer.valueOf(R.layout.sf_item_ti));
            put(ViewHolderFactory.TYPE_CAROUSEL_RECO, Integer.valueOf(R.layout.item_reco_collapsed));
            put(ViewHolderFactory.TYPE_CAROUSEL_RECO_LARGE_IMAGE, Integer.valueOf(R.layout.item_recommendation_banner_large_image));
            put(ViewHolderFactory.TYPE_BANNER_3XN_HOME, Integer.valueOf(R.layout.item_banner_3xn_home));
            put(ViewHolderFactory.TYPE_PORTRAIT_3XN, Integer.valueOf(R.layout.item_portrait_3xn));
            put(ViewHolderFactory.TYPE_CAROUSEL_ICON_4X, Integer.valueOf(R.layout.item_reco_4x));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN, Integer.valueOf(R.layout.item_smart_grp_grid));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER_V2, Integer.valueOf(R.layout.item_smart_icon_header_v2_root));
            put(ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON_2XN, Integer.valueOf(R.layout.item_smart_icon_button_2xn));
            put(ViewHolderFactory.TYPE_CAROUSEL_TOI, Integer.valueOf(R.layout.sfs_item_carousel_toi));
            put(ViewHolderFactory.TYPE_H1_BANNER, Integer.valueOf(R.layout.item_h1_banner));
            put(ViewHolderFactory.TYPE_H1_BANNER_HOME_BANNER, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_H1_BANNER_FULL_WIDTH_CLASS, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER, Integer.valueOf(R.layout.item_h1_banner_scroll));
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER_HOME_BANNER, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_BANNER_3, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_BANNER_3_FULL_WIDTH, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_BANNER_2, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_BANNER_2_FULL_WIDTH, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_THIN_BANNER, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_HOME_THIN_BANNER, Integer.valueOf(R.layout.lyt_banner_item));
            put(ViewHolderFactory.TYPE_THIN_SMALL_BANNER, Integer.valueOf(R.layout.lyt_thin_banner_small));
        }
    };
    private static Map<Integer, Integer> VIEW_TYPE_HOLDER_MAP = new HashMap<Integer, Integer>() {
        {
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_COLLAGE_3X), Integer.valueOf(R.layout.item_collage_threexn));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_COLLAGE_5X), Integer.valueOf(R.layout.item_collage_5xn));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_TREE_1), Integer.valueOf(R.layout.item_tree_one_fixed));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_TREE_3), Integer.valueOf(R.layout.item_tree_one_fixed));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_ITEM_TABBED), Integer.valueOf(R.layout.item_infinite_row_headerr));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_ITEM_TABBED_2), Integer.valueOf(R.layout.item_infinite_row_headerr));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_H1_STORE_BANNER), Integer.valueOf(R.layout.item_store_banner));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_TABBED_2_SALE), Integer.valueOf(R.layout.clp_flash_sale_layout));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_H1_MERCHANT_BANNER), Integer.valueOf(R.layout.item_merchant_banner));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_DEALS_2XN), Integer.valueOf(R.layout.item_deals_2xn));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_SEAL_TRUST), Integer.valueOf(R.layout.item_seal_trust));
            put(ViewHolderFactory.VIEW_TYPE_MAP.get(ViewHolderFactory.TYPE_SEARCH_WIDGET), Integer.valueOf(R.layout.item_search_widget));
        }
    };
    /* access modifiers changed from: private */
    public static Map<String, Integer> VIEW_TYPE_MAP = new HashMap<String, Integer>() {
        {
            put(ViewHolderFactory.TYPE_CAROUSEL_1, 1);
            put(ViewHolderFactory.TYPE_C4_LARGE, 2);
            put(ViewHolderFactory.TYPE_H1_BANNER, 3);
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER, 4);
            put(ViewHolderFactory.TYPE_THIN_BANNER, 5);
            put(ViewHolderFactory.TYPE_CAROUSEL_2, 6);
            put(ViewHolderFactory.TYPE_CAROUSEL_4, 7);
            put(ViewHolderFactory.TYPE_CAROUSEL_BS1, 8);
            put(ViewHolderFactory.TYPE_TREE_1, 9);
            put(ViewHolderFactory.TYPE_TREE_3, 10);
            put(ViewHolderFactory.TYPE_SMART_ICON_LIST, 11);
            put(ViewHolderFactory.TYPE_SMART_ICON_GRID, 12);
            put(ViewHolderFactory.TYPE_PROMO_OFFERS, 13);
            put(ViewHolderFactory.TYPE_DEALS_2XN, 14);
            put(ViewHolderFactory.TYPE_H1_MERCHANT_BANNER, 15);
            put(ViewHolderFactory.TYPE_CAROUSEL_BS2, 16);
            put(ViewHolderFactory.TYPE_ROW_BS1, 17);
            put(ViewHolderFactory.TYPE_ROW_BS2, 18);
            put(ViewHolderFactory.TYPE_ROW, 19);
            put(ViewHolderFactory.TYPE_C1_SQUARE_BANNER, 20);
            put(ViewHolderFactory.TYPE_BANNER_2XN, 21);
            put(ViewHolderFactory.TYPE_BANNER_3XN, 22);
            put(ViewHolderFactory.TYPE_COLLAGE_3X, 23);
            put(ViewHolderFactory.TYPE_COLLAGE_5X, 24);
            put(ViewHolderFactory.TYPE_ROW_1XN, 25);
            put(ViewHolderFactory.TYPE_ROW_2XN, 26);
            put(ViewHolderFactory.TYPE_ROW_3XN, 27);
            put(ViewHolderFactory.TYPE_RECENTLY_VIEWED, 28);
            put(ViewHolderFactory.TYPE_ITEM_IN_WISHLIST, 29);
            put(ViewHolderFactory.TYPE_ITEM_IN_CART, 30);
            put(ViewHolderFactory.TYPE_ITEM_TABBED, 31);
            put(ViewHolderFactory.TYPE_THIN_SMALL_BANNER, 32);
            put(ViewHolderFactory.TYPE_ACTIVE_ORDER, 33);
            put(ViewHolderFactory.TYPE_H1_STORE_BANNER, 34);
            put(ViewHolderFactory.TYPE_ITEM_TABBED_2, 35);
            put(ViewHolderFactory.TYPE_TABBED_2_SALE, 36);
            put(ViewHolderFactory.TYPE_LIST_SMALL_TI, 37);
            put(ViewHolderFactory.TYPE_CAROUSEL_RECO, 38);
            put(ViewHolderFactory.TYPE_H1_BANNER_FULL_WIDTH_CLASS, 39);
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS, 40);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON, 41);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID, 42);
            put(ViewHolderFactory.TYPE_CAROUSEL_BS1_LOW_DIMENTION_IAMGE, 43);
            put(ViewHolderFactory.TYPE_H1_BANNER_HOME_BANNER, 44);
            put(ViewHolderFactory.TYPE_H1_FULL_BANNER_HOME_BANNER, 45);
            put(ViewHolderFactory.TYPE_HOME_THIN_BANNER, 46);
            put(ViewHolderFactory.TYPE_SEAL_TRUST, 47);
            put(ViewHolderFactory.TYPE_BANNER_2, 48);
            put(ViewHolderFactory.TYPE_BANNER_3, 49);
            put(ViewHolderFactory.TYPE_BANNER_3XN_HOME, 50);
            put(ViewHolderFactory.TYPE_BLUE_STRIP, 51);
            put(ViewHolderFactory.TYPE_PORTRAIT_3XN, 52);
            put(ViewHolderFactory.TYPE_BANNER_2_FULL_WIDTH, 53);
            put(ViewHolderFactory.TYPE_BANNER_3_FULL_WIDTH, 54);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN, 56);
            put(ViewHolderFactory.TYPE_CAROUSEL_ICON_4X, 57);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER_V2, 58);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON_2XN, 59);
            put(ViewHolderFactory.CAROUSEL_1_3, 60);
            put(ViewHolderFactory.TYPE_CAROUSEL_SCRATCH_CARD, 61);
            put(ViewHolderFactory.TYPE_CAROUSEL_LOCKED_CARD, 62);
            put(ViewHolderFactory.TYPE_CAROUSEL_TOI, 63);
            put(ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID_4XN, 64);
            put(ViewHolderFactory.TYPE_P4B_ANNOUNCEMENT, 65);
            put(ViewHolderFactory.TYPE_P4B_QR, 66);
            put(ViewHolderFactory.TYPE_P4B_HOMETABS, 67);
            put(ViewHolderFactory.TYPE_RECO_RECHARGE, 68);
            put(ViewHolderFactory.TYPE_SEARCH_WIDGET, 69);
            put(ViewHolderFactory.LAYOUT_RECENTS, 70);
        }
    };

    public static boolean isTiWidgetFamily(String str) {
        return TYPE_LIST_SMALL_TI.equalsIgnoreCase(str);
    }

    public static CLPItemRVViewHolder getCLPItemRVViewHolder(ViewGroup viewGroup, String str, IGAHandlerListener iGAHandlerListener) {
        return getCLPItemRVViewHolder(viewGroup, str, iGAHandlerListener, (CustomAction) null, "");
    }

    public static CLPItemRVViewHolder getCLPItemRVViewHolder(ViewGroup viewGroup, String str, IGAHandlerListener iGAHandlerListener, CustomAction customAction, String str2) {
        Map<String, Integer> map = VIEW_TYPE_CHILD_HOLDER_MAP;
        if (map == null || !map.containsKey(str)) {
            return new DefaultViewHolder((ItemDefaultBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_default), iGAHandlerListener, customAction);
        }
        if (LAYOUT_SMART_ICON_BUTTON.equalsIgnoreCase(str)) {
            return new SmartIconButtonItemVH((ItemSmartIconButtonBinding) DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(str).intValue()), iGAHandlerListener, customAction);
        }
        if (LAYOUT_SMART_ICON_BUTTON_2XN.equalsIgnoreCase(str)) {
            return new SmartIconButton2XNItemVH((ItemSmartIconButton2xnBinding) DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(str).intValue()), iGAHandlerListener, customAction);
        }
        if (TYPE_H1_BANNER.equalsIgnoreCase(str)) {
            if (CLASS_FULL_WIDTH_IMAGE.equalsIgnoreCase(str2)) {
                str = TYPE_H1_BANNER_FULL_WIDTH_CLASS;
            } else if (CLASS_HOME.equalsIgnoreCase(str2)) {
                str = TYPE_H1_BANNER_HOME_BANNER;
            }
        } else if (TYPE_H1_FULL_BANNER.equalsIgnoreCase(str)) {
            if (CLASS_FULL_WIDTH_IMAGE.equalsIgnoreCase(str2)) {
                str = TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS;
            } else if (CLASS_HOME.equalsIgnoreCase(str2)) {
                str = TYPE_H1_FULL_BANNER_HOME_BANNER;
            }
        } else if (TYPE_BANNER_3.equalsIgnoreCase(str)) {
            if (CLASS_FULL_WIDTH_IMAGE.equalsIgnoreCase(str2)) {
                str = TYPE_BANNER_3_FULL_WIDTH;
            }
        } else if (TYPE_BANNER_2.equalsIgnoreCase(str) && CLASS_FULL_WIDTH_IMAGE.equalsIgnoreCase(str2)) {
            str = TYPE_BANNER_2_FULL_WIDTH;
        }
        return new CLPItemRVViewHolder(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(str).intValue()), iGAHandlerListener, customAction);
    }

    public static CLPBaseViewHolder getViewHolder(ViewGroup viewGroup, int i2, j jVar) {
        return getViewHolder(viewGroup, i2, jVar, (IGAHandlerListener) null);
    }

    public static CLPBaseViewHolder getViewHolder(ViewGroup viewGroup, int i2, j jVar, IGAHandlerListener iGAHandlerListener) {
        return getViewHolder(viewGroup, i2, jVar, iGAHandlerListener, (CustomAction) null);
    }

    public static CLPBaseViewHolder getViewHolder(ViewGroup viewGroup, int i2, j jVar, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        HomeUtils.d("ViewHolderFactory getViewHolder called ", false);
        CLPBaseViewHolder cLPItemVHWithoutRV = getCLPItemVHWithoutRV(viewGroup, i2, jVar, iGAHandlerListener, customAction);
        if (cLPItemVHWithoutRV == null) {
            cLPItemVHWithoutRV = getCLPItemVHWithRV(viewGroup, i2, iGAHandlerListener, customAction);
        }
        HomeUtils.d("ViewHolderFactory getViewHolder finished", false);
        return cLPItemVHWithoutRV;
    }

    public static CLPBaseViewHolder getCLPItemVHWithoutRV(ViewGroup viewGroup, int i2, j jVar, IGAHandlerListener iGAHandlerListener) {
        return getCLPItemVHWithoutRV(viewGroup, i2, jVar, iGAHandlerListener, (CustomAction) null);
    }

    public static CLPBaseViewHolder getCLPItemVHWithoutRV(ViewGroup viewGroup, int i2, j jVar, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        if (i2 == parseViewType(TYPE_ITEM_TABBED) || i2 == parseViewType(TYPE_ITEM_TABBED_2)) {
            return new InfiniteGridRowViewHolder(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), jVar, i2 == parseViewType(TYPE_ITEM_TABBED_2), iGAHandlerListener, customAction);
        } else if (i2 == parseViewType(TYPE_TREE_1) || i2 == parseViewType(TYPE_TREE_3)) {
            return new TreeWidgetViewHolder(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
        } else {
            if (i2 == parseViewType(TYPE_TABBED_2_SALE)) {
                return new FlashSaleViewHolder((ClpFlashSaleLayoutBinding) DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), jVar, iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_SEAL_TRUST)) {
                return new SealTrustViewHodler(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_BLUE_STRIP)) {
                return new BlueStripVH(DataBindingUtils.getViewBinding(viewGroup, R.layout.sf_blue_strip), iGAHandlerListener, customAction);
            }
            Map<Integer, Integer> map = VIEW_TYPE_HOLDER_MAP;
            if (map == null || !map.containsKey(Integer.valueOf(i2))) {
                return null;
            }
            if (i2 == parseViewType(TYPE_H1_STORE_BANNER) && VIEW_TYPE_HOLDER_MAP.containsKey(Integer.valueOf(i2))) {
                return new CLPStoreBannerVHWithoutRV(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_H1_MERCHANT_BANNER) && VIEW_TYPE_HOLDER_MAP.containsKey(Integer.valueOf(i2))) {
                return new CLPMerchantBannerVHWithoutRV(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
            }
            if (i2 != parseViewType(TYPE_DEALS_2XN) || !VIEW_TYPE_HOLDER_MAP.containsKey(Integer.valueOf(i2))) {
                return new CLPItemVHWithoutRV(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
            }
            return new CLPDealsVH(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_HOLDER_MAP.get(Integer.valueOf(i2)).intValue()), iGAHandlerListener, customAction);
        }
    }

    private static CLPBaseViewHolder getCLPItemVHWithRV(ViewGroup viewGroup, int i2, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        HomeUtils.d("ViewHolderFactory getCLPItemVHWithRV called", false);
        if (i2 == parseViewType(TYPE_ITEM_IN_CART) || i2 == parseViewType(TYPE_RECENTLY_VIEWED) || i2 == parseViewType(TYPE_ITEM_IN_WISHLIST)) {
            return new CLPItemInCartViewHolder((ItemSmartIconButton2xnRootBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_smart_icon_button_2xn_root), iGAHandlerListener, customAction);
        }
        if (i2 == parseViewType(TYPE_ACTIVE_ORDER)) {
            return new CLPItemActiveOrder((ItemRootRvNewBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_root_rv_new), iGAHandlerListener, customAction);
        }
        if (i2 == parseViewType(LAYOUT_SMART_ICON_BUTTON)) {
            CLPSmartIconButton cLPSmartIconButton = new CLPSmartIconButton((ItemRootRvNewBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_root_rv_new), iGAHandlerListener, customAction);
            HomeUtils.d("ViewHolderFactory LAYOUT_SMART_ICON_BUTTON fetched", false);
            return cLPSmartIconButton;
        } else if (i2 == parseViewType(LAYOUT_SMART_ICON_BUTTON_2XN)) {
            return new CLPSmartIconButton2XN((ItemSmartIconButton2xnRootBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_smart_icon_button_2xn_root), iGAHandlerListener, customAction);
        } else {
            if (i2 == parseViewType(LAYOUT_SMART_ICON_HEADER)) {
                return new CLPSmartIconHeader((ItemSmartHeaderRootBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_smart_header_root), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(LAYOUT_SMART_ICON_HEADER_V2)) {
                return new SmartIconHeaderV2RootVH((ItemSmartIconHeaderV2RootBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_smart_icon_header_v2_root), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_LIST_SMALL_TI)) {
                return new CLPCTAListViewHolder((ItemFullWidthRootRvSmallTiBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_full_width_root_rv_small_ti), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_CAROUSEL_RECO)) {
                return new CLPRecoListVH((ItemRecoMainLytBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_reco_main_lyt), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_CAROUSEL_BS1_LOW_DIMENTION_IAMGE)) {
                return new CLPCraousalBS1LowDimensionImageListViewHolder(DataBindingUtils.getViewBinding(viewGroup, R.layout.item_root_rv_new), iGAHandlerListener, customAction);
            }
            if (i2 == parseViewType(TYPE_BANNER_3XN_HOME)) {
                HomeUtils.d("ViewHolderFactory getCLPItemVHWithRV called for TYPE_BANNER_3XN_HOME", false);
                HomeBanner3xnVHWithRV homeBanner3xnVHWithRV = new HomeBanner3xnVHWithRV((OptimizeLytRootRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.optimize_lyt_root_rv), iGAHandlerListener, customAction);
                HomeUtils.d("ViewHolderFactory TYPE_BANNER_3XN_HOME fetched", false);
                return homeBanner3xnVHWithRV;
            } else if (i2 == parseViewType(LAYOUT_SMART_ICON_GROUP_GRID) || i2 == parseViewType(LAYOUT_RECENTS)) {
                HomeUtils.d("ViewHolderFactory getCLPItemVHWithRV called for LAYOUT_SMART_ICON_GROUP_GRID", false);
                NewSmartGroupVh newSmartGroupVh = new NewSmartGroupVh((NewGroupGridRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.new_group_grid_rv), iGAHandlerListener, customAction);
                HomeUtils.d("ViewHolderFactory LAYOUT_SMART_ICON_GROUP_GRID fetched", false);
                return newSmartGroupVh;
            } else if (i2 == parseViewType(LAYOUT_SMART_ICON_GROUP_GRID_4XN)) {
                return new SmartGroupGrid4XNVH((SmartGroupGrid4xnRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.smart_group_grid_4xn_rv), iGAHandlerListener, customAction);
            } else {
                if (i2 == parseViewType(TYPE_PORTRAIT_3XN)) {
                    return new HomePortraitVH((OptimizeLytRootRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.optimize_lyt_root_rv), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(TYPE_CAROUSEL_ICON_4X)) {
                    return new CLPCarousel4X((ItemReco4xRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_reco_4x_rv), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(TYPE_RECO_RECHARGE)) {
                    return new RecoWidgetRechargeVH((ItemReco4xRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_reco_4x_rv), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(CAROUSEL_1_3)) {
                    return new CLPCarousel_1_3((Carousel13Binding) DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(CAROUSEL_1_3).intValue()), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(TYPE_H1_BANNER)) {
                    return new CLPItemVHWithVP(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(TYPE_H1_BANNER).intValue()), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(TYPE_H1_FULL_BANNER)) {
                    return new CLPItemVHWithVP(DataBindingUtils.getViewBinding(viewGroup, VIEW_TYPE_CHILD_HOLDER_MAP.get(TYPE_H1_FULL_BANNER).intValue()), iGAHandlerListener, customAction);
                }
                if (i2 == parseViewType(TYPE_BANNER_3) || i2 == parseViewType(TYPE_BANNER_3_FULL_WIDTH) || i2 == parseViewType(TYPE_BANNER_2) || i2 == parseViewType(TYPE_BANNER_2_FULL_WIDTH) || i2 == parseViewType(TYPE_H1_BANNER_HOME_BANNER) || i2 == parseViewType(TYPE_H1_BANNER_FULL_WIDTH_CLASS) || i2 == parseViewType(TYPE_H1_FULL_BANNER_HOME_BANNER) || i2 == parseViewType(TYPE_H1_FULL_BANNER_FULL_WIDTH_CLASS) || i2 == parseViewType(TYPE_HOME_THIN_BANNER) || i2 == parseViewType(TYPE_THIN_BANNER) || i2 == parseViewType(TYPE_THIN_SMALL_BANNER)) {
                    return new BannerVHWithRV((ParentStandardRvBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.parent_standard_rv), iGAHandlerListener, customAction);
                }
                return new CLPItemVHWithRV(DataBindingUtils.getViewBinding(viewGroup, R.layout.item_root_rv_new), iGAHandlerListener, customAction);
            }
        }
    }

    public static int parseViewType(String str) {
        Map<String, Integer> map = VIEW_TYPE_MAP;
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        return VIEW_TYPE_MAP.get(str).intValue();
    }

    public static int getViewType(String str) {
        Map<String, Integer> map = VIEW_TYPE_MAP;
        if (map == null || !map.containsKey(str)) {
            return GRID_VIEW_TYPE_MAP.get(str).intValue();
        }
        return VIEW_TYPE_MAP.get(str).intValue();
    }

    public static String getViewType(int i2) {
        for (String next : VIEW_TYPE_MAP.keySet()) {
            Map<String, Integer> map = VIEW_TYPE_MAP;
            if (map != null && map.containsKey(next) && VIEW_TYPE_MAP.get(next).intValue() == i2) {
                return next;
            }
        }
        return null;
    }

    public static int getGridViewType(String str) {
        if (TextUtils.isEmpty(str) || !GRID_VIEW_TYPE_MAP.containsKey(str.toLowerCase())) {
            return 2;
        }
        return GRID_VIEW_TYPE_MAP.get(str.toLowerCase()).intValue();
    }

    public static int getGridSpan(String str) {
        if (TextUtils.isEmpty(str) || !GRID_VIEW_TYPE_MAP.containsKey(str.toLowerCase())) {
            return 2;
        }
        int gridViewType = getGridViewType(str);
        if (gridViewType == 1 || gridViewType == 3 || gridViewType == 4 || gridViewType == 5) {
            return 1;
        }
        return 2;
    }

    public static boolean isViewTypeLarge(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(LARGE) || lowerCase.equalsIgnoreCase(TYPE_LIST_FMCG)) {
            return true;
        }
        return false;
    }

    public static HashSet<String> getNewItemTypes() {
        return NEW_ITEM_TYPES;
    }
}
