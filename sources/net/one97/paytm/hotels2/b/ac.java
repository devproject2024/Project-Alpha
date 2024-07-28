package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails;
import net.one97.paytm.hotel4.viewmodel.EditSearchViewModel;

public abstract class ac extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29113a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f29114b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f29115c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f29116d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29117e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29118f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29119g;

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f29120h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f29121i;
    protected EditSearchViewModel j;
    protected GuestAndRoomCountDetails k;

    public abstract void a(GuestAndRoomCountDetails guestAndRoomCountDetails);

    public abstract void a(EditSearchViewModel editSearchViewModel);

    protected ac(Object obj, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6) {
        super(obj, view, 3);
        this.f29113a = constraintLayout;
        this.f29114b = constraintLayout2;
        this.f29115c = constraintLayout3;
        this.f29116d = constraintLayout4;
        this.f29117e = textView;
        this.f29118f = textView2;
        this.f29119g = textView3;
        this.f29120h = constraintLayout5;
        this.f29121i = constraintLayout6;
    }
}
