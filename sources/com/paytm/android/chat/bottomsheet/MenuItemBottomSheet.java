package com.paytm.android.chat.bottomsheet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.android.chat.R;
import com.paytm.android.chat.view.MenuItemListView;
import com.paytm.android.chat.view.d;
import com.paytm.android.chat.view.e;
import com.paytm.android.chat.view.f;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class MenuItemBottomSheet extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final a f41823a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f41824b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f41825c;

    private View a(int i2) {
        if (this.f41825c == null) {
            this.f41825c = new HashMap();
        }
        View view = (View) this.f41825c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41825c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemBottomSheet(Context context, List<d> list) {
        super(context);
        k.c(context, "context");
        k.c(list, "list");
        this.f41824b = list;
        this.f41823a = new a(context);
        FrameLayout.inflate(context, R.layout.chat_menuitem_bottom_sheet, this);
        List<d> list2 = this.f41824b;
        k.c(list2, "newList");
        e eVar = ((MenuItemListView) a(R.id.menuItemView)).f42506a;
        k.c(list2, "newList");
        eVar.f42571a.clear();
        eVar.f42571a.addAll(list2);
        eVar.notifyDataSetChanged();
        this.f41823a.setContentView((View) this);
        Window window = this.f41823a.getWindow();
        if (window != null) {
            window.clearFlags(2);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{Color.parseColor("#f7f7f7"), Color.parseColor("#ededed")});
        View a2 = a(R.id.topShadow);
        k.a((Object) a2, "topShadow");
        a2.setBackground(gradientDrawable);
    }

    public final List<d> getList() {
        return this.f41824b;
    }

    /* access modifiers changed from: protected */
    public final a getMBottomSheetDialog() {
        return this.f41823a;
    }

    public final void setClickListener(f fVar) {
        k.c(fVar, "listener");
        ((MenuItemListView) a(R.id.menuItemView)).setClickListener(fVar);
    }

    private final void setPeekHeight(int i2) {
        BottomSheetBehavior from;
        ViewParent parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view != null && (from = BottomSheetBehavior.from(view)) != null) {
            k.a((Object) from, "behavior");
            from.setPeekHeight(i2);
        }
    }
}
