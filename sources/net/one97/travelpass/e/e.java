package net.one97.travelpass.e;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;

public final class e extends q {
    public final int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        View findSnapView;
        if (!(layoutManager instanceof RecyclerView.r.b) || (findSnapView = findSnapView(layoutManager)) == null) {
            return -1;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int position = layoutManager.getPosition(findSnapView);
        if (i2 > 400) {
            position = findLastVisibleItemPosition;
        } else if (i2 < 400) {
            position = findFirstVisibleItemPosition;
        }
        if (position == -1) {
            return -1;
        }
        return position;
    }
}
