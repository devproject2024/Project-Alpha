package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ee extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29581a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29582b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f29583c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29584d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29585e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29586f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29587g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29588h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29589i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final ea r;
    protected RoomSelectionViewModel s;
    protected SubRoomOptions t;
    protected RoomOption u;

    public abstract void a(RoomOption roomOption);

    public abstract void a(SubRoomOptions subRoomOptions);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ee(Object obj, View view, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, ea eaVar) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view2 = view;
        this.f29581a = constraintLayout;
        this.f29582b = imageView;
        this.f29583c = linearLayout;
        this.f29584d = recyclerView;
        this.f29585e = textView;
        this.f29586f = textView2;
        this.f29587g = textView3;
        this.f29588h = textView4;
        this.f29589i = textView5;
        this.j = textView6;
        this.k = textView7;
        this.l = textView8;
        this.m = textView9;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
        this.q = textView13;
        this.r = eaVar;
        setContainedBinding(this.r);
    }

    public static ee a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ee) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_rs_select_room_sticky, viewGroup, false, f.a());
    }
}
