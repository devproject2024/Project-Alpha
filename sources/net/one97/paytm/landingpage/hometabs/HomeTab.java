package net.one97.paytm.landingpage.hometabs;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.SFHomeFragment;
import net.one97.paytm.landingpage.f.b;

public class HomeTab extends HomeTabItem {
    private int mPosition;
    private Drawable mSelector;
    private String mText;

    public String getUrlType() {
        return "main";
    }

    HomeTab(int i2, String str, Drawable drawable) {
        this.mPosition = i2;
        this.mSelector = drawable;
        this.mText = str;
    }

    public Fragment getFragment(Bundle bundle) {
        SFHomeFragment sFHomeFragment = new SFHomeFragment();
        sFHomeFragment.setHomeListener(new b());
        bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
        sFHomeFragment.setArguments(bundle);
        return sFHomeFragment;
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
}
