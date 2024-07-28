package com.travel.flight.flightorder.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;

public final class a extends RecyclerView.h {
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.right = (int) recyclerView.getContext().getResources().getDimension(R.dimen.dimen_10dp);
    }
}
