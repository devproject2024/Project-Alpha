package net.one97.paytm.paymentsBank.drawer.menu.model;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import java.util.Objects;
import net.one97.paytm.common.entity.IJRDataModel;

public class DrawerMenuItem implements IJRDataModel {
    private Drawable drawable;
    private String heading;
    private int id;
    private View.OnClickListener onClickListener;
    private String subHeading;
    private int visibility = 0;

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getSubHeading() {
        return this.subHeading;
    }

    public void setSubHeading(String str) {
        this.subHeading = str;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DrawerMenuItem) && getId() == ((DrawerMenuItem) obj).getId();
    }

    public int hashCode() {
        if (Build.VERSION.SDK_INT < 19) {
            return 1009;
        }
        return Objects.hash(new Object[]{Integer.valueOf(getId())});
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int i2) {
        this.visibility = i2;
    }
}
