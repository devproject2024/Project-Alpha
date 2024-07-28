package net.one97.paytm.landingpage.hometabs;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.common.b.d;

public class ScanTab extends HomeTabItem {
    private String id;
    private int mPosition;
    private Drawable mSelector;
    private String mText;

    public String getUrlType() {
        return "scan";
    }

    ScanTab(int i2, String str, Drawable drawable) {
        this.mPosition = i2;
        this.mText = str;
        this.mSelector = drawable;
    }

    public Fragment getFragment(Bundle bundle) {
        Fragment i2 = d.a().i();
        bundle.putBoolean("third_tab_home", true);
        i2.setArguments(bundle);
        return i2;
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
