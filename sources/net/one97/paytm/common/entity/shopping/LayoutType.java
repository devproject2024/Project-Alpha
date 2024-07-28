package net.one97.paytm.common.entity.shopping;

import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import net.one97.paytm.upi.util.UpiConstants;

public enum LayoutType {
    LAYOUT_PRODUCT_ROW(100, ViewHolderFactory.TYPE_ROW),
    LAYOUT_CAROUSEL_1(101, "carousel_1"),
    LAYOUT_CAROUSEL2(102, ViewHolderFactory.TYPE_CAROUSEL_2),
    LAYOUT_CAROUSEL_2(103, "carousel_2"),
    LAYOUT_TEXT_LINKS(109, "textlinks"),
    LAYOUT_HORIZONTAL_TEXT_LIST(110, "horizontal_text_list"),
    LAYOUT_VIEW_PAGER(111, "view_pager"),
    LAYOUT_WALLET_OPTIONS(112, "wallet_option"),
    LAYOUT_FOOTER_SOCIAL_ICONS(113, "footer_view"),
    LAYOUT_SMART_LIST(114, ViewHolderFactory.TYPE_SMART_ICON_LIST),
    LAYOUT_SMART_ICON_HEADER(122, ViewHolderFactory.LAYOUT_SMART_ICON_HEADER),
    LAYOUT_C4_LARGE(532, ViewHolderFactory.TYPE_C4_LARGE),
    LAYOUT_GAMES_HOME_PAGE_INFO(115, "games_apps_info_text"),
    LAYOUT_SUCCESS_CARD(116, "success_card"),
    LAYOUT_PENDING_CARD(117, "pending_card"),
    LAYOUT_FAILURE_CARD(118, "failure_card"),
    LAYOUT_AUTO_CARD(119, "auto_card"),
    LAYOUT_FOOTER_CARD(120, "footer_card"),
    LAYOUT_PAYMENT_CARD(121, "payment_card"),
    LAYOUT_IGNORE_TYPE(-1, "ignore_type"),
    LAYOUT_CAROUSEL_4(200, "carousel_4"),
    LAYOUT_CAROUSEL_5(201, "carousel_5"),
    LAYOUT_CAROUSEL5(216, "carousel-5"),
    LAYOUT_SNIPPET_1(317, "snippets-grid"),
    LAYOUT_SNIPPET_2(318, "photo-carousel-featured"),
    LAYOUT_PRODUCT_GRID(319, "product-list-grid"),
    LAYOUT_VIDEO_COROUSEL(UpiConstants.REQUEST_CODE_BANK_DETAIL, "video-carousel-grid"),
    LAYOUT_PHOTO_COROUSEL(321, "photo-carousel-grid"),
    LAYOUT_CATEGORY_COROUSEL(322, "category-carousel"),
    LAYOUT_CAROUSEL_ROW(323, "carousel-row"),
    LAYOUT_BRAND_PRODUCT_ROW(324, "product-list-row"),
    LAYOUT_CAROUSEL_FULL_WIDTH(325, "carousel-full-width"),
    LAYOUT_HEADER_CARD(217, "summary_header_card"),
    LAYOUT_TRAIN_DESC_CARD(218, "train_summary_desc_card"),
    LAYOUT_FOOTER_SELL_PARTNER_CONTACT_ICONS(219, ViewHolderFactory.TYPE_BLUE_STRIP),
    LAYOUT_H1_BANNER(500, ViewHolderFactory.TYPE_H1_BANNER),
    LAYOUT_CAROUSEL1(H5ErrorCode.HTTP_NOT_IMPLEMENTED, ViewHolderFactory.TYPE_CAROUSEL_1),
    LAYOUT_SQUARE_BANNER(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE, ViewHolderFactory.TYPE_C1_SQUARE_BANNER),
    LAYOUT_BANNER_2XN(504, ViewHolderFactory.TYPE_BANNER_2XN),
    LAYOUT_BANNER_3XN(505, ViewHolderFactory.TYPE_BANNER_3XN),
    LAYOUT_COLLAGE_5X(506, ViewHolderFactory.TYPE_COLLAGE_5X),
    LAYOUT_COLLAGE_3X(507, ViewHolderFactory.TYPE_COLLAGE_3X),
    LAYOUT_THIN_BANNER(508, ViewHolderFactory.TYPE_THIN_BANNER),
    LAYOUT_PRODUCT_ROW_1XN(509, ViewHolderFactory.TYPE_ROW_1XN),
    LAYOUT_PRODUCT_ROW_2XN(510, ViewHolderFactory.TYPE_ROW_2XN),
    LAYOUT_PRODUCT_ROW_3XN(511, ViewHolderFactory.TYPE_ROW_3XN),
    LAYOUT_ACCORDION_VIEW(512, "accordion_menu"),
    LAYOUT_SMART_ICON_GRID(513, ViewHolderFactory.TYPE_SMART_ICON_GRID),
    LAYOUT_HEADER_GRID(514, "grid_header"),
    LAYOUT_FOOTER_VIEW_MORE(517, "grid_footer"),
    LAYOUT_DIVIDER_LINE(515, "grid-divider-thin"),
    LAYOUT_DIVIDER_GAP(516, "grid-divider-gap"),
    LAYOUT_BANNER_WITH_ROW(518, ViewHolderFactory.TYPE_ROW_BS1),
    LAYOUT_STORE_PRODUCT_ROW(519, ViewHolderFactory.TYPE_ROW_BS2),
    LAYOUT_STORE_BANNER_ROW(520, ViewHolderFactory.TYPE_CAROUSEL_BS1),
    LAYOUT_STORE_HEADER(521, "store_header"),
    LAYOUT_CAROUSEL4(522, ViewHolderFactory.TYPE_CAROUSEL_4),
    LAYOUT_STORE_BANNER_WITH_BANNER_ROW(523, ViewHolderFactory.TYPE_CAROUSEL_BS2),
    LAYOUT_RECENT_PAYMENT(524, "recent_payment"),
    LAYOUT_INFINITE_GRID(525, ViewHolderFactory.TYPE_ITEM_TABBED),
    LAYOUT_INFINITE_GRID_ROW(526, "infinite_grid_row"),
    LAYOUT_CIRCULAR_PROGRESS_BAR(527, "infinite_grid_loader"),
    LAYOUT_TICKER(37872, "smart-icon-ticker"),
    LAYOUT_POST_PAYMENT_LAYOUT(528, "layout_item"),
    LAYOUT_POST_PAYMENT_UPI_LAYOUT(529, "upi_layout_item"),
    LAYOUT_RECHARGE_HEADER_WIDGET(630, "layout_recharge_header_widget"),
    LAYOUT_SMART_ICON_CAROUSEL(631, "smart-icon-carousel"),
    LAYOUT_SMART_ICON_VIDEO(632, "video-bottom-image"),
    LAYOUT_SMART_ICON_GROUP_GRID(633, ViewHolderFactory.LAYOUT_SMART_ICON_GROUP_GRID),
    LAYOUT_SMART_ICON_BUTTON(634, ViewHolderFactory.LAYOUT_SMART_ICON_BUTTON);
    
    private int index;
    private String name;

    private LayoutType(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static LayoutType fromIndex(int i2) {
        for (LayoutType layoutType : values()) {
            if (layoutType.index == i2) {
                return layoutType;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }

    public static LayoutType fromName(String str) {
        for (LayoutType layoutType : values()) {
            if (layoutType.name.equalsIgnoreCase(str)) {
                return layoutType;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isNewType() {
        int i2 = this.index;
        return i2 >= 500 && i2 <= 530;
    }
}
