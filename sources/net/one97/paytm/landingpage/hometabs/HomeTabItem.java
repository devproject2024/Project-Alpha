package net.one97.paytm.landingpage.hometabs;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.landingpage.R;

public abstract class HomeTabItem implements IJRDataModel {
    public abstract Fragment getFragment(Bundle bundle);

    public abstract Drawable getIcon();

    public abstract int getPosition();

    public abstract String getText();

    public abstract String getUrlType();

    public int getTextColorResource() {
        return R.drawable.tab_bar_text_selector;
    }
}
