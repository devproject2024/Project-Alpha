package net.one97.paytm.bankOpen.ica.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.utility.b;
import kotlin.g.b.k;
import net.one97.paytm.bankOpen.R;

public final class PBInfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f16619a;

    /* renamed from: b  reason: collision with root package name */
    private float f16620b;

    /* renamed from: c  reason: collision with root package name */
    private int f16621c;

    /* renamed from: d  reason: collision with root package name */
    private int f16622d;

    /* renamed from: e  reason: collision with root package name */
    private View f16623e;

    public PBInfoView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PBInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(attributeSet, "attributeSet");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PBInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(attributeSet, "attributeSet");
        a(attributeSet);
    }

    private final void a(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pb_ca_acc_open_info_item, (ViewGroup) null, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…n_info_item, null, false)");
        this.f16623e = inflate;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PBInfoView);
        this.f16622d = obtainStyledAttributes.getResourceId(R.styleable.PBInfoView_pbivImage, 0);
        this.f16621c = obtainStyledAttributes.getResourceId(R.styleable.PBInfoView_pbivText, 0);
        this.f16620b = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.PBInfoView_pbivTextSize, (int) getResources().getDimension(R.dimen.dimen_0dp));
        this.f16619a = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.PBInfoView_pbivImageDimen, (int) getResources().getDimension(R.dimen.dimen_0dp));
        if (obtainStyledAttributes.getInt(R.styleable.PBInfoView_pbivLytSize, 0) == 0) {
            setBigSize();
        } else {
            setSmallSize();
        }
        View view = this.f16623e;
        if (view == null) {
            k.a("view");
        }
        ((TextView) view.findViewById(R.id.infoview_tv)).setText(this.f16621c);
        View view2 = this.f16623e;
        if (view2 == null) {
            k.a("view");
        }
        addView(view2);
    }

    public final void setSmallSize() {
        View view = this.f16623e;
        if (view == null) {
            k.a("view");
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.infoview_iv);
        k.a((Object) appCompatImageView, "view.infoview_iv");
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        layoutParams.height = b.c(30);
        layoutParams.width = b.c(30);
        View view2 = this.f16623e;
        if (view2 == null) {
            k.a("view");
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(R.id.infoview_iv);
        k.a((Object) appCompatImageView2, "view.infoview_iv");
        appCompatImageView2.setLayoutParams(layoutParams);
        View view3 = this.f16623e;
        if (view3 == null) {
            k.a("view");
        }
        ((TextView) view3.findViewById(R.id.infoview_tv)).setTextSize(2, 12.0f);
    }

    public final void setBigSize() {
        View view = this.f16623e;
        if (view == null) {
            k.a("view");
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.infoview_iv);
        k.a((Object) appCompatImageView, "view.infoview_iv");
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        layoutParams.height = b.c(36);
        layoutParams.width = b.c(36);
        View view2 = this.f16623e;
        if (view2 == null) {
            k.a("view");
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(R.id.infoview_iv);
        k.a((Object) appCompatImageView2, "view.infoview_iv");
        appCompatImageView2.setLayoutParams(layoutParams);
        View view3 = this.f16623e;
        if (view3 == null) {
            k.a("view");
        }
        ((TextView) view3.findViewById(R.id.infoview_tv)).setTextSize(2, 14.0f);
    }
}
