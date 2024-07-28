package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.SFNotificationPopup;

public abstract class SfNotificationPopupBinding extends ViewDataBinding {
    public final Group grpLayout;
    public final Guideline guidelineBottom;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final Guideline guidelineTop;
    public final AppCompatImageView imgDismiss;
    protected SFNotificationPopup mClickhandler;
    protected Item mItem;
    public final ImageView viewImg;
    public final TextView viewSubtitle;
    public final TextView viewTitle;

    public abstract void setClickhandler(SFNotificationPopup sFNotificationPopup);

    public abstract void setItem(Item item);

    protected SfNotificationPopupBinding(e eVar, View view, int i2, Group group, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, AppCompatImageView appCompatImageView, ImageView imageView, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.grpLayout = group;
        this.guidelineBottom = guideline;
        this.guidelineEnd = guideline2;
        this.guidelineStart = guideline3;
        this.guidelineTop = guideline4;
        this.imgDismiss = appCompatImageView;
        this.viewImg = imageView;
        this.viewSubtitle = textView;
        this.viewTitle = textView2;
    }

    public Item getItem() {
        return this.mItem;
    }

    public SFNotificationPopup getClickhandler() {
        return this.mClickhandler;
    }

    public static SfNotificationPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static SfNotificationPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (SfNotificationPopupBinding) f.a(layoutInflater, R.layout.sf_notification_popup, viewGroup, z, eVar);
    }

    public static SfNotificationPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static SfNotificationPopupBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (SfNotificationPopupBinding) f.a(layoutInflater, R.layout.sf_notification_popup, (ViewGroup) null, false, eVar);
    }

    public static SfNotificationPopupBinding bind(View view) {
        return bind(view, f.a());
    }

    public static SfNotificationPopupBinding bind(View view, e eVar) {
        return (SfNotificationPopupBinding) bind(eVar, view, R.layout.sf_notification_popup);
    }
}
