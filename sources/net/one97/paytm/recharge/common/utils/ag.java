package net.one97.paytm.recharge.common.utils;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class ag extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private int f61500a = 5;

    /* renamed from: b  reason: collision with root package name */
    private int f61501b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f61502c = 0;

    /* renamed from: d  reason: collision with root package name */
    RecyclerView.LayoutManager f61503d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f61504e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f61505f = 1;

    public abstract void a(int i2);

    public ag(LinearLayoutManager linearLayoutManager) {
        this.f61503d = linearLayoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        int itemCount = this.f61503d.getItemCount();
        RecyclerView.LayoutManager layoutManager = this.f61503d;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] b2 = ((StaggeredGridLayoutManager) layoutManager).b();
            int i5 = 0;
            for (int i6 = 0; i6 < b2.length; i6++) {
                if (i6 == 0) {
                    i5 = b2[i6];
                } else if (b2[i6] > i5) {
                    i5 = b2[i6];
                }
            }
            i4 = i5;
        } else if (layoutManager instanceof LinearLayoutManager) {
            i4 = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else {
            i4 = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).findLastVisibleItemPosition() : 0;
        }
        if (itemCount < this.f61502c) {
            this.f61501b = this.f61505f;
            this.f61502c = itemCount;
            if (itemCount == 0) {
                this.f61504e = true;
            }
        }
        if (this.f61504e && itemCount > this.f61502c) {
            this.f61504e = false;
            this.f61502c = itemCount;
        }
        if (!this.f61504e && i4 + this.f61500a > itemCount) {
            this.f61501b++;
            a(this.f61501b);
            this.f61504e = true;
        }
    }
}
