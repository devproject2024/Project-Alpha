package com.paytmmall.clpartifact;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.databinding.ActivityFilterBindingImpl;
import com.paytmmall.clpartifact.databinding.Carousel13BindingImpl;
import com.paytmmall.clpartifact.databinding.CartBottomSheetBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpActivitySearchBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpCustomDialogBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleLayoutBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleTimeSlotItemBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpFoodItemBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpFreeDealsItemBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpItemChartBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpItemProgressbarBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpItemReviewsBindingImpl;
import com.paytmmall.clpartifact.databinding.ClpVoucherItemBindingImpl;
import com.paytmmall.clpartifact.databinding.DealsItemClpBindingImpl;
import com.paytmmall.clpartifact.databinding.ExpandTreeBindingImpl;
import com.paytmmall.clpartifact.databinding.FloatingNavRvBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentFilterCategoryBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentFilterPriceBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentFilterRectBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentHomeBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentHsVariantBottomSheetBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentItemBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentItemListBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentReportBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentReviewBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentSmartIconListBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentVoucherBindingImpl;
import com.paytmmall.clpartifact.databinding.FragmentVsVariantBottomSheetBindingImpl;
import com.paytmmall.clpartifact.databinding.HsVariantBottomSheetListItemBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemActiveOrderBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemBannFullWidthBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemBanner3xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemBanner3xnHomeBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCaroselBs2BindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCaroselFourLargeBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCaroselTwoBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCarousel13BindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCarouselBs1BindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCarouselBs1LowDimensionsImageClassBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCarouselFourBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCarouselOneBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCartBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCartRvBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCollage5xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemCollageThreexnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemDeals2xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemDefaultBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFilterBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFilterCategoryBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFilterLinearRectBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFilterListBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavMultiBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFloatingNavSingleBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFullWidthRootRvBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemFullWidthRootRvSmallTiBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemH1BannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemH1BannerHomeBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemH1BannerScrollBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemH1FullBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemInfiniteGridContainerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemInfiniteRowHeaderrBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemMerchantBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemNewSmartHeaderDynBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemPortrait3xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRatingBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemReco4xBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemReco4xRvBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRecoCollapsedBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRecoMainLytBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRecommendationBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRecommendationBannerLargeImageBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRootRvNewBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRow1xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRow2xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRow3xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRowBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRowBs1BindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRowBs2BindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRowInfiniteGrid1xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemRowInfiniteGridBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSealTrustBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSearchWidgetBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartGrpGridBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartHeaderRootBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnRootBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButtonBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconGridBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconHeaderV2RootBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSmartIconListBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSortfilterDetailBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemSquareBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemStoreBannerBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemThinBannerHomeBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemTreeOneBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemTreeOneFixedBindingImpl;
import com.paytmmall.clpartifact.databinding.ItemVpH1BannerHomeBindingImpl;
import com.paytmmall.clpartifact.databinding.LayoutAddToCartBindingImpl;
import com.paytmmall.clpartifact.databinding.LayoutCategoryListItemBindingImpl;
import com.paytmmall.clpartifact.databinding.LayoutEditCartBindingImpl;
import com.paytmmall.clpartifact.databinding.LayoutNoRatingReviewsAvailableBindingImpl;
import com.paytmmall.clpartifact.databinding.LytBannerItemBindingImpl;
import com.paytmmall.clpartifact.databinding.LytCategoryItemBindingImpl;
import com.paytmmall.clpartifact.databinding.LytCategorySelectedBindingImpl;
import com.paytmmall.clpartifact.databinding.LytThinBannerSmallBindingImpl;
import com.paytmmall.clpartifact.databinding.NewGroupGridRvBindingImpl;
import com.paytmmall.clpartifact.databinding.OptimizeLytRootRvBindingImpl;
import com.paytmmall.clpartifact.databinding.ParentStandardRvBindingImpl;
import com.paytmmall.clpartifact.databinding.RatingReviewFragmentBindingImpl;
import com.paytmmall.clpartifact.databinding.SfBlueStripBindingImpl;
import com.paytmmall.clpartifact.databinding.SfGridPopupLayoutBindingImpl;
import com.paytmmall.clpartifact.databinding.SfItemTiBindingImpl;
import com.paytmmall.clpartifact.databinding.SfNotificationPopupBindingImpl;
import com.paytmmall.clpartifact.databinding.SfsItemCarouselToiBindingImpl;
import com.paytmmall.clpartifact.databinding.SmartGroupGrid4xnRvBindingImpl;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYFILTER = 1;
    private static final int LAYOUT_CAROUSEL13 = 2;
    private static final int LAYOUT_CARTBOTTOMSHEET = 3;
    private static final int LAYOUT_CLPACTIVITYSEARCH = 4;
    private static final int LAYOUT_CLPCUSTOMDIALOG = 5;
    private static final int LAYOUT_CLPFLASHSALELAYOUT = 6;
    private static final int LAYOUT_CLPFLASHSALETIMESLOTITEM = 7;
    private static final int LAYOUT_CLPFOODITEM = 8;
    private static final int LAYOUT_CLPFREEDEALSITEM = 9;
    private static final int LAYOUT_CLPITEMCHART = 10;
    private static final int LAYOUT_CLPITEMPROGRESSBAR = 11;
    private static final int LAYOUT_CLPITEMREVIEWS = 12;
    private static final int LAYOUT_CLPVOUCHERITEM = 13;
    private static final int LAYOUT_DEALSITEMCLP = 14;
    private static final int LAYOUT_EXPANDTREE = 15;
    private static final int LAYOUT_FLOATINGNAVRV = 16;
    private static final int LAYOUT_FRAGMENTFILTERCATEGORY = 17;
    private static final int LAYOUT_FRAGMENTFILTERPRICE = 18;
    private static final int LAYOUT_FRAGMENTFILTERRECT = 19;
    private static final int LAYOUT_FRAGMENTHOME = 20;
    private static final int LAYOUT_FRAGMENTHSVARIANTBOTTOMSHEET = 21;
    private static final int LAYOUT_FRAGMENTITEM = 22;
    private static final int LAYOUT_FRAGMENTITEMLIST = 23;
    private static final int LAYOUT_FRAGMENTREPORT = 24;
    private static final int LAYOUT_FRAGMENTREVIEW = 25;
    private static final int LAYOUT_FRAGMENTSMARTICONLIST = 26;
    private static final int LAYOUT_FRAGMENTVOUCHER = 27;
    private static final int LAYOUT_FRAGMENTVSVARIANTBOTTOMSHEET = 28;
    private static final int LAYOUT_HSVARIANTBOTTOMSHEETLISTITEM = 29;
    private static final int LAYOUT_ITEMACTIVEORDER = 30;
    private static final int LAYOUT_ITEMBANNER3XN = 32;
    private static final int LAYOUT_ITEMBANNER3XNHOME = 33;
    private static final int LAYOUT_ITEMBANNFULLWIDTH = 31;
    private static final int LAYOUT_ITEMCAROSELBS2 = 34;
    private static final int LAYOUT_ITEMCAROSELFOURLARGE = 35;
    private static final int LAYOUT_ITEMCAROSELTWO = 36;
    private static final int LAYOUT_ITEMCAROUSEL13 = 37;
    private static final int LAYOUT_ITEMCAROUSELBS1 = 38;
    private static final int LAYOUT_ITEMCAROUSELBS1LOWDIMENSIONSIMAGECLASS = 39;
    private static final int LAYOUT_ITEMCAROUSELFOUR = 40;
    private static final int LAYOUT_ITEMCAROUSELONE = 41;
    private static final int LAYOUT_ITEMCART = 42;
    private static final int LAYOUT_ITEMCARTRV = 43;
    private static final int LAYOUT_ITEMCOLLAGE5XN = 44;
    private static final int LAYOUT_ITEMCOLLAGETHREEXN = 45;
    private static final int LAYOUT_ITEMDEALS2XN = 46;
    private static final int LAYOUT_ITEMDEFAULT = 47;
    private static final int LAYOUT_ITEMFILTER = 48;
    private static final int LAYOUT_ITEMFILTERCATEGORY = 49;
    private static final int LAYOUT_ITEMFILTERLINEARRECT = 50;
    private static final int LAYOUT_ITEMFILTERLIST = 51;
    private static final int LAYOUT_ITEMFLOATINGNAVMULTI = 52;
    private static final int LAYOUT_ITEMFLOATINGNAVSINGLE = 53;
    private static final int LAYOUT_ITEMFULLWIDTHROOTRV = 54;
    private static final int LAYOUT_ITEMFULLWIDTHROOTRVSMALLTI = 55;
    private static final int LAYOUT_ITEMH1BANNER = 56;
    private static final int LAYOUT_ITEMH1BANNERHOMEBANNER = 57;
    private static final int LAYOUT_ITEMH1BANNERSCROLL = 58;
    private static final int LAYOUT_ITEMH1FULLBANNER = 59;
    private static final int LAYOUT_ITEMINFINITEGRIDCONTAINER = 60;
    private static final int LAYOUT_ITEMINFINITEROWHEADERR = 61;
    private static final int LAYOUT_ITEMMERCHANTBANNER = 62;
    private static final int LAYOUT_ITEMNEWSMARTHEADERDYN = 63;
    private static final int LAYOUT_ITEMPORTRAIT3XN = 64;
    private static final int LAYOUT_ITEMRATING = 65;
    private static final int LAYOUT_ITEMRECO4X = 66;
    private static final int LAYOUT_ITEMRECO4XRV = 67;
    private static final int LAYOUT_ITEMRECOCOLLAPSED = 68;
    private static final int LAYOUT_ITEMRECOMAINLYT = 69;
    private static final int LAYOUT_ITEMRECOMMENDATIONBANNER = 70;
    private static final int LAYOUT_ITEMRECOMMENDATIONBANNERLARGEIMAGE = 71;
    private static final int LAYOUT_ITEMROOTRVNEW = 72;
    private static final int LAYOUT_ITEMROW = 73;
    private static final int LAYOUT_ITEMROW1XN = 74;
    private static final int LAYOUT_ITEMROW2XN = 75;
    private static final int LAYOUT_ITEMROW3XN = 76;
    private static final int LAYOUT_ITEMROWBS1 = 77;
    private static final int LAYOUT_ITEMROWBS2 = 78;
    private static final int LAYOUT_ITEMROWINFINITEGRID = 79;
    private static final int LAYOUT_ITEMROWINFINITEGRID1XN = 80;
    private static final int LAYOUT_ITEMSEALTRUST = 81;
    private static final int LAYOUT_ITEMSEARCHWIDGET = 82;
    private static final int LAYOUT_ITEMSMARTGRPGRID = 83;
    private static final int LAYOUT_ITEMSMARTHEADERROOT = 84;
    private static final int LAYOUT_ITEMSMARTICONBUTTON = 85;
    private static final int LAYOUT_ITEMSMARTICONBUTTON2XN = 86;
    private static final int LAYOUT_ITEMSMARTICONBUTTON2XNROOT = 87;
    private static final int LAYOUT_ITEMSMARTICONGRID = 88;
    private static final int LAYOUT_ITEMSMARTICONHEADER = 89;
    private static final int LAYOUT_ITEMSMARTICONHEADERV2ROOT = 90;
    private static final int LAYOUT_ITEMSMARTICONLIST = 91;
    private static final int LAYOUT_ITEMSORTFILTERDETAIL = 92;
    private static final int LAYOUT_ITEMSQUAREBANNER = 93;
    private static final int LAYOUT_ITEMSTOREBANNER = 94;
    private static final int LAYOUT_ITEMTHINBANNERHOME = 95;
    private static final int LAYOUT_ITEMTREEONE = 96;
    private static final int LAYOUT_ITEMTREEONEFIXED = 97;
    private static final int LAYOUT_ITEMVPH1BANNERHOME = 98;
    private static final int LAYOUT_LAYOUTADDTOCART = 99;
    private static final int LAYOUT_LAYOUTCATEGORYLISTITEM = 100;
    private static final int LAYOUT_LAYOUTEDITCART = 101;
    private static final int LAYOUT_LAYOUTNORATINGREVIEWSAVAILABLE = 102;
    private static final int LAYOUT_LYTBANNERITEM = 103;
    private static final int LAYOUT_LYTCATEGORYITEM = 104;
    private static final int LAYOUT_LYTCATEGORYSELECTED = 105;
    private static final int LAYOUT_LYTTHINBANNERSMALL = 106;
    private static final int LAYOUT_NEWGROUPGRIDRV = 107;
    private static final int LAYOUT_OPTIMIZELYTROOTRV = 108;
    private static final int LAYOUT_PARENTSTANDARDRV = 109;
    private static final int LAYOUT_RATINGREVIEWFRAGMENT = 110;
    private static final int LAYOUT_SFBLUESTRIP = 111;
    private static final int LAYOUT_SFGRIDPOPUPLAYOUT = 112;
    private static final int LAYOUT_SFITEMTI = 113;
    private static final int LAYOUT_SFNOTIFICATIONPOPUP = 114;
    private static final int LAYOUT_SFSITEMCAROUSELTOI = 115;
    private static final int LAYOUT_SMARTGROUPGRID4XNRV = 116;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(116);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_filter, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.carousel_1_3, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.cart_bottom_sheet, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_activity_search, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_custom_dialog, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_flash_sale_layout, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_flash_sale_time_slot_item, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_food_item, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_free_deals_item, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_item_chart, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_item_progressbar, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_item_reviews, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.clp_voucher_item, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.deals_item_clp, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.expand_tree, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.floating_nav_rv, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_filter_category, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_filter_price, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_filter_rect, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_home, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_hs_variant_bottom_sheet, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_item, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_item_list, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_report, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_review, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_smart_icon_list, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_voucher, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_vs_variant_bottom_sheet, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hs_variant_bottom_sheet_list_item, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_active_order, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_bann_full_width, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_banner_3xn, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_banner_3xn_home, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carosel_bs2, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carosel_four_large, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carosel_two, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carousel_1_3, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carousel_bs1, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carousel_bs1_low_dimensions_image_class, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carousel_four, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_carousel_one, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_cart, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_cart_rv, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_collage_5xn, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_collage_threexn, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_deals_2xn, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_default, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_filter, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_filter_category, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_filter_linear_rect, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_filter_list, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_floating_nav_multi, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_floating_nav_single, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_full_width_root_rv, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_full_width_root_rv_small_ti, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_h1_banner, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_h1_banner_home_banner, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_h1_banner_scroll, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_h1_full_banner, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_infinite_grid_container, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_infinite_row_headerr, 61);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_merchant_banner, 62);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_new_smart_header_dyn, 63);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_portrait_3xn, 64);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_rating, 65);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_reco_4x, 66);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_reco_4x_rv, 67);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_reco_collapsed, 68);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_reco_main_lyt, 69);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_recommendation_banner, 70);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_recommendation_banner_large_image, 71);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_root_rv_new, 72);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row, 73);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row1xn, 74);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row2xn, 75);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row3xn, 76);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row_bs1, 77);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row_bs2, 78);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row_infinite_grid, 79);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_row_infinite_grid_1xn, 80);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_seal_trust, 81);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_search_widget, 82);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_grp_grid, 83);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_header_root, 84);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_button, 85);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_button_2xn, 86);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_button_2xn_root, 87);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_grid, 88);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_header, 89);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_header_v2_root, 90);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_smart_icon_list, 91);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_sortfilter_detail, 92);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_square_banner, 93);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_store_banner, 94);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_thin_banner_home, 95);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_tree_one, 96);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_tree_one_fixed, 97);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_vp_h1_banner_home, 98);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_add_to_cart, 99);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_category_list_item, 100);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_edit_cart, 101);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_no_rating_reviews_available, 102);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_banner_item, 103);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_category_item, 104);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_category_selected, 105);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_thin_banner_small, 106);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.new_group_grid_rv, 107);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.optimize_lyt_root_rv, 108);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.parent_standard_rv, 109);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.rating_review_fragment, 110);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.sf_blue_strip, 111);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.sf_grid_popup_layout, 112);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.sf_item_ti, 113);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.sf_notification_popup, 114);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.sfs_item_carousel_toi, 115);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.smart_group_grid_4xn_rv, 116);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/activity_filter_0".equals(obj)) {
                    return new ActivityFilterBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_filter is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/carousel_1_3_0".equals(obj)) {
                    return new Carousel13BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for carousel_1_3 is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/cart_bottom_sheet_0".equals(obj)) {
                    return new CartBottomSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for cart_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/clp_activity_search_0".equals(obj)) {
                    return new ClpActivitySearchBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_activity_search is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/clp_custom_dialog_0".equals(obj)) {
                    return new ClpCustomDialogBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_custom_dialog is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/clp_flash_sale_layout_0".equals(obj)) {
                    return new ClpFlashSaleLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_flash_sale_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/clp_flash_sale_time_slot_item_0".equals(obj)) {
                    return new ClpFlashSaleTimeSlotItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_flash_sale_time_slot_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/clp_food_item_0".equals(obj)) {
                    return new ClpFoodItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_food_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/clp_free_deals_item_0".equals(obj)) {
                    return new ClpFreeDealsItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_free_deals_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/clp_item_chart_0".equals(obj)) {
                    return new ClpItemChartBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_item_chart is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/clp_item_progressbar_0".equals(obj)) {
                    return new ClpItemProgressbarBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_item_progressbar is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/clp_item_reviews_0".equals(obj)) {
                    return new ClpItemReviewsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_item_reviews is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/clp_voucher_item_0".equals(obj)) {
                    return new ClpVoucherItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for clp_voucher_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/deals_item_clp_0".equals(obj)) {
                    return new DealsItemClpBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for deals_item_clp is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/expand_tree_0".equals(obj)) {
                    return new ExpandTreeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for expand_tree is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/floating_nav_rv_0".equals(obj)) {
                    return new FloatingNavRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for floating_nav_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/fragment_filter_category_0".equals(obj)) {
                    return new FragmentFilterCategoryBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_filter_category is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/fragment_filter_price_0".equals(obj)) {
                    return new FragmentFilterPriceBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_filter_price is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/fragment_filter_rect_0".equals(obj)) {
                    return new FragmentFilterRectBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_filter_rect is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/fragment_home_0".equals(obj)) {
                    return new FragmentHomeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/fragment_hs_variant_bottom_sheet_0".equals(obj)) {
                    return new FragmentHsVariantBottomSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_hs_variant_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/fragment_item_0".equals(obj)) {
                    return new FragmentItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/fragment_item_list_0".equals(obj)) {
                    return new FragmentItemListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_item_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/fragment_report_0".equals(obj)) {
                    return new FragmentReportBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_report is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/fragment_review_0".equals(obj)) {
                    return new FragmentReviewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_review is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/fragment_smart_icon_list_0".equals(obj)) {
                    return new FragmentSmartIconListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_smart_icon_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/fragment_voucher_0".equals(obj)) {
                    return new FragmentVoucherBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_voucher is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/fragment_vs_variant_bottom_sheet_0".equals(obj)) {
                    return new FragmentVsVariantBottomSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_vs_variant_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/hs_variant_bottom_sheet_list_item_0".equals(obj)) {
                    return new HsVariantBottomSheetListItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hs_variant_bottom_sheet_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/item_active_order_0".equals(obj)) {
                    return new ItemActiveOrderBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_active_order is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/item_bann_full_width_0".equals(obj)) {
                    return new ItemBannFullWidthBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_bann_full_width is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/item_banner_3xn_0".equals(obj)) {
                    return new ItemBanner3xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_banner_3xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/item_banner_3xn_home_0".equals(obj)) {
                    return new ItemBanner3xnHomeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_banner_3xn_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/item_carosel_bs2_0".equals(obj)) {
                    return new ItemCaroselBs2BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carosel_bs2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/item_carosel_four_large_0".equals(obj)) {
                    return new ItemCaroselFourLargeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carosel_four_large is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/item_carosel_two_0".equals(obj)) {
                    return new ItemCaroselTwoBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carosel_two is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/item_carousel_1_3_0".equals(obj)) {
                    return new ItemCarousel13BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carousel_1_3 is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/item_carousel_bs1_0".equals(obj)) {
                    return new ItemCarouselBs1BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carousel_bs1 is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/item_carousel_bs1_low_dimensions_image_class_0".equals(obj)) {
                    return new ItemCarouselBs1LowDimensionsImageClassBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carousel_bs1_low_dimensions_image_class is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/item_carousel_four_0".equals(obj)) {
                    return new ItemCarouselFourBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carousel_four is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/item_carousel_one_0".equals(obj)) {
                    return new ItemCarouselOneBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_carousel_one is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/item_cart_0".equals(obj)) {
                    return new ItemCartBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_cart is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/item_cart_rv_0".equals(obj)) {
                    return new ItemCartRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_cart_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/item_collage_5xn_0".equals(obj)) {
                    return new ItemCollage5xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_collage_5xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/item_collage_threexn_0".equals(obj)) {
                    return new ItemCollageThreexnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_collage_threexn is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/item_deals_2xn_0".equals(obj)) {
                    return new ItemDeals2xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_deals_2xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/item_default_0".equals(obj)) {
                    return new ItemDefaultBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_default is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/item_filter_0".equals(obj)) {
                    return new ItemFilterBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_filter is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/item_filter_category_0".equals(obj)) {
                    return new ItemFilterCategoryBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_filter_category is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/item_filter_linear_rect_0".equals(obj)) {
                    return new ItemFilterLinearRectBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_filter_linear_rect is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/item_filter_list_0".equals(obj)) {
                    return new ItemFilterListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_filter_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 52:
                if ("layout/item_floating_nav_multi_0".equals(obj)) {
                    return new ItemFloatingNavMultiBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_floating_nav_multi is invalid. Received: ".concat(String.valueOf(obj)));
            case 53:
                if ("layout/item_floating_nav_single_0".equals(obj)) {
                    return new ItemFloatingNavSingleBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_floating_nav_single is invalid. Received: ".concat(String.valueOf(obj)));
            case 54:
                if ("layout/item_full_width_root_rv_0".equals(obj)) {
                    return new ItemFullWidthRootRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_full_width_root_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 55:
                if ("layout/item_full_width_root_rv_small_ti_0".equals(obj)) {
                    return new ItemFullWidthRootRvSmallTiBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_full_width_root_rv_small_ti is invalid. Received: ".concat(String.valueOf(obj)));
            case 56:
                if ("layout/item_h1_banner_0".equals(obj)) {
                    return new ItemH1BannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_h1_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 57:
                if ("layout/item_h1_banner_home_banner_0".equals(obj)) {
                    return new ItemH1BannerHomeBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_h1_banner_home_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 58:
                if ("layout/item_h1_banner_scroll_0".equals(obj)) {
                    return new ItemH1BannerScrollBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_h1_banner_scroll is invalid. Received: ".concat(String.valueOf(obj)));
            case 59:
                if ("layout/item_h1_full_banner_0".equals(obj)) {
                    return new ItemH1FullBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_h1_full_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 60:
                if ("layout/item_infinite_grid_container_0".equals(obj)) {
                    return new ItemInfiniteGridContainerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_infinite_grid_container is invalid. Received: ".concat(String.valueOf(obj)));
            case 61:
                if ("layout/item_infinite_row_headerr_0".equals(obj)) {
                    return new ItemInfiniteRowHeaderrBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_infinite_row_headerr is invalid. Received: ".concat(String.valueOf(obj)));
            case 62:
                if ("layout/item_merchant_banner_0".equals(obj)) {
                    return new ItemMerchantBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_merchant_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 63:
                if ("layout/item_new_smart_header_dyn_0".equals(obj)) {
                    return new ItemNewSmartHeaderDynBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_smart_header_dyn is invalid. Received: ".concat(String.valueOf(obj)));
            case 64:
                if ("layout/item_portrait_3xn_0".equals(obj)) {
                    return new ItemPortrait3xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_portrait_3xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 65:
                if ("layout/item_rating_0".equals(obj)) {
                    return new ItemRatingBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_rating is invalid. Received: ".concat(String.valueOf(obj)));
            case 66:
                if ("layout/item_reco_4x_0".equals(obj)) {
                    return new ItemReco4xBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_reco_4x is invalid. Received: ".concat(String.valueOf(obj)));
            case 67:
                if ("layout/item_reco_4x_rv_0".equals(obj)) {
                    return new ItemReco4xRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_reco_4x_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 68:
                if ("layout/item_reco_collapsed_0".equals(obj)) {
                    return new ItemRecoCollapsedBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_reco_collapsed is invalid. Received: ".concat(String.valueOf(obj)));
            case 69:
                if ("layout/item_reco_main_lyt_0".equals(obj)) {
                    return new ItemRecoMainLytBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_reco_main_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 70:
                if ("layout/item_recommendation_banner_0".equals(obj)) {
                    return new ItemRecommendationBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommendation_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 71:
                if ("layout/item_recommendation_banner_large_image_0".equals(obj)) {
                    return new ItemRecommendationBannerLargeImageBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommendation_banner_large_image is invalid. Received: ".concat(String.valueOf(obj)));
            case 72:
                if ("layout/item_root_rv_new_0".equals(obj)) {
                    return new ItemRootRvNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_root_rv_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 73:
                if ("layout/item_row_0".equals(obj)) {
                    return new ItemRowBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row is invalid. Received: ".concat(String.valueOf(obj)));
            case 74:
                if ("layout/item_row1xn_0".equals(obj)) {
                    return new ItemRow1xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row1xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 75:
                if ("layout/item_row2xn_0".equals(obj)) {
                    return new ItemRow2xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row2xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 76:
                if ("layout/item_row3xn_0".equals(obj)) {
                    return new ItemRow3xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row3xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 77:
                if ("layout/item_row_bs1_0".equals(obj)) {
                    return new ItemRowBs1BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row_bs1 is invalid. Received: ".concat(String.valueOf(obj)));
            case 78:
                if ("layout/item_row_bs2_0".equals(obj)) {
                    return new ItemRowBs2BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row_bs2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 79:
                if ("layout/item_row_infinite_grid_0".equals(obj)) {
                    return new ItemRowInfiniteGridBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row_infinite_grid is invalid. Received: ".concat(String.valueOf(obj)));
            case 80:
                if ("layout/item_row_infinite_grid_1xn_0".equals(obj)) {
                    return new ItemRowInfiniteGrid1xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_row_infinite_grid_1xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 81:
                if ("layout/item_seal_trust_0".equals(obj)) {
                    return new ItemSealTrustBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_seal_trust is invalid. Received: ".concat(String.valueOf(obj)));
            case 82:
                if ("layout/item_search_widget_0".equals(obj)) {
                    return new ItemSearchWidgetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_search_widget is invalid. Received: ".concat(String.valueOf(obj)));
            case 83:
                if ("layout/item_smart_grp_grid_0".equals(obj)) {
                    return new ItemSmartGrpGridBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_grp_grid is invalid. Received: ".concat(String.valueOf(obj)));
            case 84:
                if ("layout/item_smart_header_root_0".equals(obj)) {
                    return new ItemSmartHeaderRootBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_header_root is invalid. Received: ".concat(String.valueOf(obj)));
            case 85:
                if ("layout/item_smart_icon_button_0".equals(obj)) {
                    return new ItemSmartIconButtonBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_button is invalid. Received: ".concat(String.valueOf(obj)));
            case 86:
                if ("layout/item_smart_icon_button_2xn_0".equals(obj)) {
                    return new ItemSmartIconButton2xnBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_button_2xn is invalid. Received: ".concat(String.valueOf(obj)));
            case 87:
                if ("layout/item_smart_icon_button_2xn_root_0".equals(obj)) {
                    return new ItemSmartIconButton2xnRootBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_button_2xn_root is invalid. Received: ".concat(String.valueOf(obj)));
            case 88:
                if ("layout/item_smart_icon_grid_0".equals(obj)) {
                    return new ItemSmartIconGridBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_grid is invalid. Received: ".concat(String.valueOf(obj)));
            case 89:
                if ("layout/item_smart_icon_header_0".equals(obj)) {
                    return new ItemSmartIconHeaderBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 90:
                if ("layout/item_smart_icon_header_v2_root_0".equals(obj)) {
                    return new ItemSmartIconHeaderV2RootBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_header_v2_root is invalid. Received: ".concat(String.valueOf(obj)));
            case 91:
                if ("layout/item_smart_icon_list_0".equals(obj)) {
                    return new ItemSmartIconListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_smart_icon_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 92:
                if ("layout/item_sortfilter_detail_0".equals(obj)) {
                    return new ItemSortfilterDetailBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_sortfilter_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 93:
                if ("layout/item_square_banner_0".equals(obj)) {
                    return new ItemSquareBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_square_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 94:
                if ("layout/item_store_banner_0".equals(obj)) {
                    return new ItemStoreBannerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_store_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 95:
                if ("layout/item_thin_banner_home_0".equals(obj)) {
                    return new ItemThinBannerHomeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_thin_banner_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 96:
                if ("layout/item_tree_one_0".equals(obj)) {
                    return new ItemTreeOneBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tree_one is invalid. Received: ".concat(String.valueOf(obj)));
            case 97:
                if ("layout/item_tree_one_fixed_0".equals(obj)) {
                    return new ItemTreeOneFixedBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tree_one_fixed is invalid. Received: ".concat(String.valueOf(obj)));
            case 98:
                if ("layout/item_vp_h1_banner_home_0".equals(obj)) {
                    return new ItemVpH1BannerHomeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_vp_h1_banner_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 99:
                if ("layout/layout_add_to_cart_0".equals(obj)) {
                    return new LayoutAddToCartBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_add_to_cart is invalid. Received: ".concat(String.valueOf(obj)));
            case 100:
                if ("layout/layout_category_list_item_0".equals(obj)) {
                    return new LayoutCategoryListItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_category_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 101:
                if ("layout/layout_edit_cart_0".equals(obj)) {
                    return new LayoutEditCartBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_edit_cart is invalid. Received: ".concat(String.valueOf(obj)));
            case 102:
                if ("layout/layout_no_rating_reviews_available_0".equals(obj)) {
                    return new LayoutNoRatingReviewsAvailableBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_no_rating_reviews_available is invalid. Received: ".concat(String.valueOf(obj)));
            case 103:
                if ("layout/lyt_banner_item_0".equals(obj)) {
                    return new LytBannerItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_banner_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 104:
                if ("layout/lyt_category_item_0".equals(obj)) {
                    return new LytCategoryItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_category_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 105:
                if ("layout/lyt_category_selected_0".equals(obj)) {
                    return new LytCategorySelectedBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_category_selected is invalid. Received: ".concat(String.valueOf(obj)));
            case 106:
                if ("layout/lyt_thin_banner_small_0".equals(obj)) {
                    return new LytThinBannerSmallBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_thin_banner_small is invalid. Received: ".concat(String.valueOf(obj)));
            case 107:
                if ("layout/new_group_grid_rv_0".equals(obj)) {
                    return new NewGroupGridRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for new_group_grid_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 108:
                if ("layout/optimize_lyt_root_rv_0".equals(obj)) {
                    return new OptimizeLytRootRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for optimize_lyt_root_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 109:
                if ("layout/parent_standard_rv_0".equals(obj)) {
                    return new ParentStandardRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for parent_standard_rv is invalid. Received: ".concat(String.valueOf(obj)));
            case 110:
                if ("layout/rating_review_fragment_0".equals(obj)) {
                    return new RatingReviewFragmentBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for rating_review_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 111:
                if ("layout/sf_blue_strip_0".equals(obj)) {
                    return new SfBlueStripBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for sf_blue_strip is invalid. Received: ".concat(String.valueOf(obj)));
            case 112:
                if ("layout/sf_grid_popup_layout_0".equals(obj)) {
                    return new SfGridPopupLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for sf_grid_popup_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 113:
                if ("layout/sf_item_ti_0".equals(obj)) {
                    return new SfItemTiBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for sf_item_ti is invalid. Received: ".concat(String.valueOf(obj)));
            case 114:
                if ("layout/sf_notification_popup_0".equals(obj)) {
                    return new SfNotificationPopupBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for sf_notification_popup is invalid. Received: ".concat(String.valueOf(obj)));
            case 115:
                if ("layout/sfs_item_carousel_toi_0".equals(obj)) {
                    return new SfsItemCarouselToiBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for sfs_item_carousel_toi is invalid. Received: ".concat(String.valueOf(obj)));
            case 116:
                if ("layout/smart_group_grid_4xn_rv_0".equals(obj)) {
                    return new SmartGroupGrid4xnRvBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for smart_group_grid_4xn_rv is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i4 = (i3 - 1) / 50;
            if (i4 == 0) {
                return internalGetViewDataBinding0(eVar, view, i3, tag);
            }
            if (i4 == 1) {
                return internalGetViewDataBinding1(eVar, view, i3, tag);
            }
            if (i4 != 2) {
                return null;
            }
            return internalGetViewDataBinding2(eVar, view, i3, tag);
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return InnerBrLookup.sKeys.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(65);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "handler");
            sKeys.put(2, "slider");
            sKeys.put(3, "isCollapsed");
            sKeys.put(4, "rating");
            sKeys.put(5, "showMoreVisibility");
            sKeys.put(6, "type");
            sKeys.put(7, "view");
            sKeys.put(8, "showRating");
            sKeys.put(9, "levelToRateCount");
            sKeys.put(10, "model");
            sKeys.put(11, "id");
            sKeys.put(12, "badgeText");
            sKeys.put(13, "totalReview");
            sKeys.put(14, "item");
            sKeys.put(15, "adapter");
            sKeys.put(16, "reviewDetail");
            sKeys.put(17, "showWishListIcon");
            sKeys.put(18, "ratingModel");
            sKeys.put(19, "entityType");
            sKeys.put(20, "totalRatings");
            sKeys.put(21, "ratingTotal");
            sKeys.put(22, "iSCOLLAPSED");
            sKeys.put(23, "starNumber");
            sKeys.put(24, "offerTag");
            sKeys.put(25, "badgeImageUrl");
            sKeys.put(26, "notificationActive");
            sKeys.put(27, "subCashback");
            sKeys.put(28, "following");
            sKeys.put(29, "name");
            sKeys.put(30, "tickerText");
            sKeys.put(31, "viewModel");
            sKeys.put(32, CLPConstants.ARGUMENT_KEY_POSITION);
            sKeys.put(33, "clickHandler");
            sKeys.put(34, "groupAdapter");
            sKeys.put(35, "dataModel");
            sKeys.put(36, "title");
            sKeys.put(37, "reviewDate");
            sKeys.put(38, "imageUrl");
            sKeys.put(39, "isSelected");
            sKeys.put(40, "isApplied");
            sKeys.put(41, "avgRating");
            sKeys.put(42, "IS_COLLAPSED");
            sKeys.put(43, "redirect");
            sKeys.put(44, "product");
            sKeys.put(45, "holder");
            sKeys.put(46, "label");
            sKeys.put(47, "clickhandler");
            sKeys.put(48, "cashback");
            sKeys.put(49, "entityIdentifier");
            sKeys.put(50, "pagerIndicatorVisibility");
            sKeys.put(51, "fragment");
            sKeys.put(52, "seourl");
            sKeys.put(53, "isWishListed");
            sKeys.put(54, "initialFrom");
            sKeys.put(55, "layoutManager");
            sKeys.put(56, "dialogDataModel");
            sKeys.put(57, "showSeparation");
            sKeys.put(58, "showPrice");
            sKeys.put(59, "showRatingBar");
            sKeys.put(60, "initialTo");
            sKeys.put(61, "category");
            sKeys.put(62, "defaultItemData");
            sKeys.put(63, "ratingData");
        }
    }

    static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(116);
            sKeys = hashMap;
            hashMap.put("layout/activity_filter_0", Integer.valueOf(R.layout.activity_filter));
            sKeys.put("layout/carousel_1_3_0", Integer.valueOf(R.layout.carousel_1_3));
            sKeys.put("layout/cart_bottom_sheet_0", Integer.valueOf(R.layout.cart_bottom_sheet));
            sKeys.put("layout/clp_activity_search_0", Integer.valueOf(R.layout.clp_activity_search));
            sKeys.put("layout/clp_custom_dialog_0", Integer.valueOf(R.layout.clp_custom_dialog));
            sKeys.put("layout/clp_flash_sale_layout_0", Integer.valueOf(R.layout.clp_flash_sale_layout));
            sKeys.put("layout/clp_flash_sale_time_slot_item_0", Integer.valueOf(R.layout.clp_flash_sale_time_slot_item));
            sKeys.put("layout/clp_food_item_0", Integer.valueOf(R.layout.clp_food_item));
            sKeys.put("layout/clp_free_deals_item_0", Integer.valueOf(R.layout.clp_free_deals_item));
            sKeys.put("layout/clp_item_chart_0", Integer.valueOf(R.layout.clp_item_chart));
            sKeys.put("layout/clp_item_progressbar_0", Integer.valueOf(R.layout.clp_item_progressbar));
            sKeys.put("layout/clp_item_reviews_0", Integer.valueOf(R.layout.clp_item_reviews));
            sKeys.put("layout/clp_voucher_item_0", Integer.valueOf(R.layout.clp_voucher_item));
            sKeys.put("layout/deals_item_clp_0", Integer.valueOf(R.layout.deals_item_clp));
            sKeys.put("layout/expand_tree_0", Integer.valueOf(R.layout.expand_tree));
            sKeys.put("layout/floating_nav_rv_0", Integer.valueOf(R.layout.floating_nav_rv));
            sKeys.put("layout/fragment_filter_category_0", Integer.valueOf(R.layout.fragment_filter_category));
            sKeys.put("layout/fragment_filter_price_0", Integer.valueOf(R.layout.fragment_filter_price));
            sKeys.put("layout/fragment_filter_rect_0", Integer.valueOf(R.layout.fragment_filter_rect));
            sKeys.put("layout/fragment_home_0", Integer.valueOf(R.layout.fragment_home));
            sKeys.put("layout/fragment_hs_variant_bottom_sheet_0", Integer.valueOf(R.layout.fragment_hs_variant_bottom_sheet));
            sKeys.put("layout/fragment_item_0", Integer.valueOf(R.layout.fragment_item));
            sKeys.put("layout/fragment_item_list_0", Integer.valueOf(R.layout.fragment_item_list));
            sKeys.put("layout/fragment_report_0", Integer.valueOf(R.layout.fragment_report));
            sKeys.put("layout/fragment_review_0", Integer.valueOf(R.layout.fragment_review));
            sKeys.put("layout/fragment_smart_icon_list_0", Integer.valueOf(R.layout.fragment_smart_icon_list));
            sKeys.put("layout/fragment_voucher_0", Integer.valueOf(R.layout.fragment_voucher));
            sKeys.put("layout/fragment_vs_variant_bottom_sheet_0", Integer.valueOf(R.layout.fragment_vs_variant_bottom_sheet));
            sKeys.put("layout/hs_variant_bottom_sheet_list_item_0", Integer.valueOf(R.layout.hs_variant_bottom_sheet_list_item));
            sKeys.put("layout/item_active_order_0", Integer.valueOf(R.layout.item_active_order));
            sKeys.put("layout/item_bann_full_width_0", Integer.valueOf(R.layout.item_bann_full_width));
            sKeys.put("layout/item_banner_3xn_0", Integer.valueOf(R.layout.item_banner_3xn));
            sKeys.put("layout/item_banner_3xn_home_0", Integer.valueOf(R.layout.item_banner_3xn_home));
            sKeys.put("layout/item_carosel_bs2_0", Integer.valueOf(R.layout.item_carosel_bs2));
            sKeys.put("layout/item_carosel_four_large_0", Integer.valueOf(R.layout.item_carosel_four_large));
            sKeys.put("layout/item_carosel_two_0", Integer.valueOf(R.layout.item_carosel_two));
            sKeys.put("layout/item_carousel_1_3_0", Integer.valueOf(R.layout.item_carousel_1_3));
            sKeys.put("layout/item_carousel_bs1_0", Integer.valueOf(R.layout.item_carousel_bs1));
            sKeys.put("layout/item_carousel_bs1_low_dimensions_image_class_0", Integer.valueOf(R.layout.item_carousel_bs1_low_dimensions_image_class));
            sKeys.put("layout/item_carousel_four_0", Integer.valueOf(R.layout.item_carousel_four));
            sKeys.put("layout/item_carousel_one_0", Integer.valueOf(R.layout.item_carousel_one));
            sKeys.put("layout/item_cart_0", Integer.valueOf(R.layout.item_cart));
            sKeys.put("layout/item_cart_rv_0", Integer.valueOf(R.layout.item_cart_rv));
            sKeys.put("layout/item_collage_5xn_0", Integer.valueOf(R.layout.item_collage_5xn));
            sKeys.put("layout/item_collage_threexn_0", Integer.valueOf(R.layout.item_collage_threexn));
            sKeys.put("layout/item_deals_2xn_0", Integer.valueOf(R.layout.item_deals_2xn));
            sKeys.put("layout/item_default_0", Integer.valueOf(R.layout.item_default));
            sKeys.put("layout/item_filter_0", Integer.valueOf(R.layout.item_filter));
            sKeys.put("layout/item_filter_category_0", Integer.valueOf(R.layout.item_filter_category));
            sKeys.put("layout/item_filter_linear_rect_0", Integer.valueOf(R.layout.item_filter_linear_rect));
            sKeys.put("layout/item_filter_list_0", Integer.valueOf(R.layout.item_filter_list));
            sKeys.put("layout/item_floating_nav_multi_0", Integer.valueOf(R.layout.item_floating_nav_multi));
            sKeys.put("layout/item_floating_nav_single_0", Integer.valueOf(R.layout.item_floating_nav_single));
            sKeys.put("layout/item_full_width_root_rv_0", Integer.valueOf(R.layout.item_full_width_root_rv));
            sKeys.put("layout/item_full_width_root_rv_small_ti_0", Integer.valueOf(R.layout.item_full_width_root_rv_small_ti));
            sKeys.put("layout/item_h1_banner_0", Integer.valueOf(R.layout.item_h1_banner));
            sKeys.put("layout/item_h1_banner_home_banner_0", Integer.valueOf(R.layout.item_h1_banner_home_banner));
            sKeys.put("layout/item_h1_banner_scroll_0", Integer.valueOf(R.layout.item_h1_banner_scroll));
            sKeys.put("layout/item_h1_full_banner_0", Integer.valueOf(R.layout.item_h1_full_banner));
            sKeys.put("layout/item_infinite_grid_container_0", Integer.valueOf(R.layout.item_infinite_grid_container));
            sKeys.put("layout/item_infinite_row_headerr_0", Integer.valueOf(R.layout.item_infinite_row_headerr));
            sKeys.put("layout/item_merchant_banner_0", Integer.valueOf(R.layout.item_merchant_banner));
            sKeys.put("layout/item_new_smart_header_dyn_0", Integer.valueOf(R.layout.item_new_smart_header_dyn));
            sKeys.put("layout/item_portrait_3xn_0", Integer.valueOf(R.layout.item_portrait_3xn));
            sKeys.put("layout/item_rating_0", Integer.valueOf(R.layout.item_rating));
            sKeys.put("layout/item_reco_4x_0", Integer.valueOf(R.layout.item_reco_4x));
            sKeys.put("layout/item_reco_4x_rv_0", Integer.valueOf(R.layout.item_reco_4x_rv));
            sKeys.put("layout/item_reco_collapsed_0", Integer.valueOf(R.layout.item_reco_collapsed));
            sKeys.put("layout/item_reco_main_lyt_0", Integer.valueOf(R.layout.item_reco_main_lyt));
            sKeys.put("layout/item_recommendation_banner_0", Integer.valueOf(R.layout.item_recommendation_banner));
            sKeys.put("layout/item_recommendation_banner_large_image_0", Integer.valueOf(R.layout.item_recommendation_banner_large_image));
            sKeys.put("layout/item_root_rv_new_0", Integer.valueOf(R.layout.item_root_rv_new));
            sKeys.put("layout/item_row_0", Integer.valueOf(R.layout.item_row));
            sKeys.put("layout/item_row1xn_0", Integer.valueOf(R.layout.item_row1xn));
            sKeys.put("layout/item_row2xn_0", Integer.valueOf(R.layout.item_row2xn));
            sKeys.put("layout/item_row3xn_0", Integer.valueOf(R.layout.item_row3xn));
            sKeys.put("layout/item_row_bs1_0", Integer.valueOf(R.layout.item_row_bs1));
            sKeys.put("layout/item_row_bs2_0", Integer.valueOf(R.layout.item_row_bs2));
            sKeys.put("layout/item_row_infinite_grid_0", Integer.valueOf(R.layout.item_row_infinite_grid));
            sKeys.put("layout/item_row_infinite_grid_1xn_0", Integer.valueOf(R.layout.item_row_infinite_grid_1xn));
            sKeys.put("layout/item_seal_trust_0", Integer.valueOf(R.layout.item_seal_trust));
            sKeys.put("layout/item_search_widget_0", Integer.valueOf(R.layout.item_search_widget));
            sKeys.put("layout/item_smart_grp_grid_0", Integer.valueOf(R.layout.item_smart_grp_grid));
            sKeys.put("layout/item_smart_header_root_0", Integer.valueOf(R.layout.item_smart_header_root));
            sKeys.put("layout/item_smart_icon_button_0", Integer.valueOf(R.layout.item_smart_icon_button));
            sKeys.put("layout/item_smart_icon_button_2xn_0", Integer.valueOf(R.layout.item_smart_icon_button_2xn));
            sKeys.put("layout/item_smart_icon_button_2xn_root_0", Integer.valueOf(R.layout.item_smart_icon_button_2xn_root));
            sKeys.put("layout/item_smart_icon_grid_0", Integer.valueOf(R.layout.item_smart_icon_grid));
            sKeys.put("layout/item_smart_icon_header_0", Integer.valueOf(R.layout.item_smart_icon_header));
            sKeys.put("layout/item_smart_icon_header_v2_root_0", Integer.valueOf(R.layout.item_smart_icon_header_v2_root));
            sKeys.put("layout/item_smart_icon_list_0", Integer.valueOf(R.layout.item_smart_icon_list));
            sKeys.put("layout/item_sortfilter_detail_0", Integer.valueOf(R.layout.item_sortfilter_detail));
            sKeys.put("layout/item_square_banner_0", Integer.valueOf(R.layout.item_square_banner));
            sKeys.put("layout/item_store_banner_0", Integer.valueOf(R.layout.item_store_banner));
            sKeys.put("layout/item_thin_banner_home_0", Integer.valueOf(R.layout.item_thin_banner_home));
            sKeys.put("layout/item_tree_one_0", Integer.valueOf(R.layout.item_tree_one));
            sKeys.put("layout/item_tree_one_fixed_0", Integer.valueOf(R.layout.item_tree_one_fixed));
            sKeys.put("layout/item_vp_h1_banner_home_0", Integer.valueOf(R.layout.item_vp_h1_banner_home));
            sKeys.put("layout/layout_add_to_cart_0", Integer.valueOf(R.layout.layout_add_to_cart));
            sKeys.put("layout/layout_category_list_item_0", Integer.valueOf(R.layout.layout_category_list_item));
            sKeys.put("layout/layout_edit_cart_0", Integer.valueOf(R.layout.layout_edit_cart));
            sKeys.put("layout/layout_no_rating_reviews_available_0", Integer.valueOf(R.layout.layout_no_rating_reviews_available));
            sKeys.put("layout/lyt_banner_item_0", Integer.valueOf(R.layout.lyt_banner_item));
            sKeys.put("layout/lyt_category_item_0", Integer.valueOf(R.layout.lyt_category_item));
            sKeys.put("layout/lyt_category_selected_0", Integer.valueOf(R.layout.lyt_category_selected));
            sKeys.put("layout/lyt_thin_banner_small_0", Integer.valueOf(R.layout.lyt_thin_banner_small));
            sKeys.put("layout/new_group_grid_rv_0", Integer.valueOf(R.layout.new_group_grid_rv));
            sKeys.put("layout/optimize_lyt_root_rv_0", Integer.valueOf(R.layout.optimize_lyt_root_rv));
            sKeys.put("layout/parent_standard_rv_0", Integer.valueOf(R.layout.parent_standard_rv));
            sKeys.put("layout/rating_review_fragment_0", Integer.valueOf(R.layout.rating_review_fragment));
            sKeys.put("layout/sf_blue_strip_0", Integer.valueOf(R.layout.sf_blue_strip));
            sKeys.put("layout/sf_grid_popup_layout_0", Integer.valueOf(R.layout.sf_grid_popup_layout));
            sKeys.put("layout/sf_item_ti_0", Integer.valueOf(R.layout.sf_item_ti));
            sKeys.put("layout/sf_notification_popup_0", Integer.valueOf(R.layout.sf_notification_popup));
            sKeys.put("layout/sfs_item_carousel_toi_0", Integer.valueOf(R.layout.sfs_item_carousel_toi));
            sKeys.put("layout/smart_group_grid_4xn_rv_0", Integer.valueOf(R.layout.smart_group_grid_4xn_rv));
        }
    }
}
