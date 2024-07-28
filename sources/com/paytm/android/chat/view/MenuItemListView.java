package com.paytm.android.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.utility.RoboTextView;
import kotlin.g.b.k;

public final class MenuItemListView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public final e f42506a = new e();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemListView(Context context) {
        super(context);
        k.c(context, "context");
        View inflate = View.inflate(getContext(), R.layout.chat_view_menu_list, this);
        k.a((Object) inflate, "view");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        k.a((Object) recyclerView, "view.recyclerview");
        recyclerView.setAdapter(this.f42506a);
        ((RoboTextView) inflate.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MenuItemListView f42507a;

            {
                this.f42507a = r1;
            }

            public final void onClick(View view) {
                f fVar = this.f42507a.f42506a.f42572b;
                if (fVar != null) {
                    fVar.a();
                }
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        View inflate = View.inflate(getContext(), R.layout.chat_view_menu_list, this);
        k.a((Object) inflate, "view");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        k.a((Object) recyclerView, "view.recyclerview");
        recyclerView.setAdapter(this.f42506a);
        ((RoboTextView) inflate.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MenuItemListView f42507a;

            {
                this.f42507a = r1;
            }

            public final void onClick(View view) {
                f fVar = this.f42507a.f42506a.f42572b;
                if (fVar != null) {
                    fVar.a();
                }
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        View inflate = View.inflate(getContext(), R.layout.chat_view_menu_list, this);
        k.a((Object) inflate, "view");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        k.a((Object) recyclerView, "view.recyclerview");
        recyclerView.setAdapter(this.f42506a);
        ((RoboTextView) inflate.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MenuItemListView f42507a;

            {
                this.f42507a = r1;
            }

            public final void onClick(View view) {
                f fVar = this.f42507a.f42506a.f42572b;
                if (fVar != null) {
                    fVar.a();
                }
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemListView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        View inflate = View.inflate(getContext(), R.layout.chat_view_menu_list, this);
        k.a((Object) inflate, "view");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        k.a((Object) recyclerView, "view.recyclerview");
        recyclerView.setAdapter(this.f42506a);
        ((RoboTextView) inflate.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MenuItemListView f42507a;

            {
                this.f42507a = r1;
            }

            public final void onClick(View view) {
                f fVar = this.f42507a.f42506a.f42572b;
                if (fVar != null) {
                    fVar.a();
                }
            }
        });
    }

    public final void setClickListener(f fVar) {
        k.c(fVar, "listener");
        this.f42506a.f42572b = fVar;
    }
}
