package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStatusLevelCardItem implements IJRDataModel {
    private Boolean anim = Boolean.FALSE;
    private String icon;
    private String label;
    private String transition_icon;

    public String getIcon() {
        return this.icon;
    }

    public String getTransitionimage() {
        return this.transition_icon;
    }

    public void setTransitionimage(String str) {
        this.transition_icon = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public Boolean getAnim() {
        return this.anim;
    }

    public void setAnim(Boolean bool) {
        this.anim = bool;
    }

    public String getLebel() {
        return this.label;
    }

    public void setLebel(String str) {
        this.label = str;
    }
}
