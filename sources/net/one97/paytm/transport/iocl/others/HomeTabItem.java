package net.one97.paytm.transport.iocl.others;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONObject;

public interface HomeTabItem extends IJRDataModel {
    JSONObject getAnimationJson();

    Fragment getFragment(Bundle bundle);

    String getGtmEventTag();

    Drawable getIcon();

    String getId();

    int getPosition();

    String getText();

    int getTextColorResource();

    String getUrlType();

    String getmUrl();

    void setAnimationJson(String str);

    void setmSelector(StateListDrawable stateListDrawable);

    void setmText(String str);

    void setmUrl(String str, boolean z);

    boolean showNotificationCountView();
}
