package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class ea extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29563a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29564b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29565c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29566d;

    /* renamed from: e  reason: collision with root package name */
    protected RoomSelectionViewModel f29567e;

    /* renamed from: f  reason: collision with root package name */
    protected SubRoomOptions f29568f;

    /* renamed from: g  reason: collision with root package name */
    protected RoomOption f29569g;

    public abstract void a(RoomOption roomOption);

    public abstract void a(SubRoomOptions subRoomOptions);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected ea(Object obj, View view, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, 0);
        this.f29563a = constraintLayout;
        this.f29564b = imageView;
        this.f29565c = imageView2;
        this.f29566d = textView;
    }
}
