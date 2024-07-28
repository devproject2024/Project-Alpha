package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class cu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f29412a;

    /* renamed from: b  reason: collision with root package name */
    public final View f29413b;

    /* renamed from: c  reason: collision with root package name */
    public final cw f29414c;

    /* renamed from: d  reason: collision with root package name */
    protected ReviewViewModel f29415d;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected cu(Object obj, View view, CheckBox checkBox, View view2, cw cwVar) {
        super(obj, view, 2);
        this.f29412a = checkBox;
        this.f29413b = view2;
        this.f29414c = cwVar;
        setContainedBinding(this.f29414c);
    }
}
