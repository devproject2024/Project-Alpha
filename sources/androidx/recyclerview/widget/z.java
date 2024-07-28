package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class z extends RecyclerView.j {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.l mScrollListener = new RecyclerView.l() {

        /* renamed from: a  reason: collision with root package name */
        boolean f4364a = false;

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.f4364a) {
                this.f4364a = false;
                z.this.snapToTargetExistingView();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f4364a = true;
            }
        }
    };

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view);

    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    public boolean onFling(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && snapFromFling(layoutManager, i2, i3)) {
            return true;
        }
        return false;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener((RecyclerView.j) null);
    }

    public int[] calculateScrollDistance(int i2, int i3) {
        this.mGravityScroller.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        RecyclerView.r createScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.r.b) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i2, i3)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (findSnapView = findSnapView(layoutManager)) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public RecyclerView.r createScroller(RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public p createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        return new p(this.mRecyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public final void onTargetFound(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                if (z.this.mRecyclerView != null) {
                    z zVar = z.this;
                    int[] calculateDistanceToFinalSnap = zVar.calculateDistanceToFinalSnap(zVar.mRecyclerView.getLayoutManager(), view);
                    int i2 = calculateDistanceToFinalSnap[0];
                    int i3 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                    if (calculateTimeForDeceleration > 0) {
                        aVar.a(i2, i3, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return z.MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
