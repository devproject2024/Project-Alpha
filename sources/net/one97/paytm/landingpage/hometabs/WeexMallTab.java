package net.one97.paytm.landingpage.hometabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytmmall.clpartifact.utils.CLPConstants;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.nativesdk.orflow.Utility;

public class WeexMallTab extends HomeTabItem {
    public static final int BOTTOM_TAB_POSITION = 1001;
    protected Context mContext;
    protected int mPosition;
    private Drawable mSelector = this.mContext.getResources().getDrawable(R.drawable.bottom_bar_mall_selector);
    protected String mText = this.mContext.getString(R.string.mall);
    protected String mUrl;
    protected String mUrlType = Utility.VERTICAL_NAME_MALL;
    private CJRCatalogItem mallItem;

    WeexMallTab(Context context, int i2) {
        this.mContext = context;
        this.mPosition = i2;
    }

    public Fragment getFragment(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (this.mallItem == null) {
            this.mallItem = getMallItem();
        }
        boolean z = this.mContext.getResources().getBoolean(R.bool.homepage_viewpager_page_change_with_animation);
        bundle2.putBoolean("key_actionbar_height_padding_required", z);
        bundle2.putBoolean("key_actionbar_height_padding_required_at_bottom", z);
        bundle2.putSerializable("bundle_extra_category_item", this.mallItem);
        boolean z2 = true;
        bundle2.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        d.a();
        bundle2.putBoolean("bundle_extra_secondary_home_user_visible", true);
        if (this.mPosition != 1) {
            z2 = false;
        }
        bundle2.putBoolean("caching_required", z2);
        bundle2.putString("url", this.mUrl);
        bundle2.putInt("key_bottom_tab_position", 1001);
        return d.a().a(bundle2);
    }

    public Drawable getIcon() {
        return this.mSelector;
    }

    public String getText() {
        return this.mText;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getUrlType() {
        return this.mUrlType;
    }

    private CJRCatalogItem getMallItem() {
        this.mallItem = new CJRCatalogItem();
        this.mallItem.setName("Mall");
        this.mallItem.setURLType(this.mUrlType);
        if (d.b().a("bottom_tab_fallback", false)) {
            this.mUrl = d.b().a("mall_homepage");
        } else {
            String a2 = d.b().a("mall_homepage");
            if (TextUtils.isEmpty(this.mUrl)) {
                this.mUrl = a2;
            }
        }
        this.mallItem.setUrl(this.mUrl);
        this.mallItem.setCategoryId("5165");
        CJRCatalogItem cJRCatalogItem = this.mallItem;
        cJRCatalogItem.position = this.mPosition;
        return cJRCatalogItem;
    }
}
