package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemReco4xBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;

public class CLPCarouselItem4X extends ClickableRVChildViewHolder {
    private int CLICKED_OUTSIDE = -2;
    ArrayList<String> gaList = new ArrayList<>();
    private Boolean isExpanded;
    private boolean isStackView;
    private ItemReco4xBinding reco4xBinding;

    public CLPCarouselItem4X(ItemReco4xBinding itemReco4xBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction, Boolean bool, boolean z) {
        super(itemReco4xBinding, iGAHandlerListener, customAction);
        this.reco4xBinding = itemReco4xBinding;
        this.isExpanded = bool;
        if (bool.booleanValue()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.reco4xBinding.mainLayoutReco.getLayoutParams();
            layoutParams.topMargin = a.a(5);
            layoutParams.bottomMargin = a.a(5);
            this.reco4xBinding.mainLayoutReco.setLayoutParams(layoutParams);
        } else {
            this.reco4xBinding.mainLayoutReco.setVisibility(0);
        }
        if (!z && !bool.booleanValue()) {
            CLPUtils.setHomeMargins(itemReco4xBinding.recoLayoutContainer);
        }
        this.isStackView = z;
    }

    public void bindItem(Item item, View view, int i2) {
        setGAData(view.getGaData());
        sendGa(item, i2);
        setGAParentPosition(item);
        enableItemClick();
        this.reco4xBinding.setVariable(BR.item, item);
        this.reco4xBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.reco4xBinding.executePendingBindings();
        setImageWidthBasedOnDisplaySize(this.reco4xBinding.mainLayoutReco);
    }

    private void setGAParentPosition(Item item) {
        item.setParentBindPosition((item.getGaData() == null || !item.getGaData().containsKey(CLPConstants.WIDGET_BIND_POSITION)) ? 0 : Integer.parseInt(String.valueOf(item.getGaData().get(CLPConstants.WIDGET_BIND_POSITION))));
    }

    private void sendGa(Item item, int i2) {
        if (this.isExpanded.booleanValue() && !this.gaList.contains(item.getId()) && !item.getAddedtoGA().booleanValue()) {
            GaHandler.getInstance().fireRecoImpression(item, i2, item.getGaData());
        } else if (!this.isExpanded.booleanValue() && !this.gaList.contains(item.getId())) {
            if (i2 == 0 || !this.isStackView) {
                handleGAImpression(item, i2);
                item.setAddedtoGA(Boolean.TRUE);
                this.gaList.add(item.getId());
            }
        }
    }

    private void setImageWidthBasedOnDisplaySize(android.view.View view) {
        Display defaultDisplay = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i2 = point.x;
        view.getLayoutParams().width = i2 - a.a(48);
    }

    public void setWidthBasedOnPosition(int i2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.reco4xBinding.getRoot().findViewById(R.id.mainLayoutReco);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) constraintLayout.getLayoutParams();
        layoutParams.width -= a.a(20) * i2;
        layoutParams.gravity = 1;
        constraintLayout.setLayoutParams(layoutParams);
        if (i2 == 0) {
            constraintLayout.setAlpha(1.0f);
        } else if (i2 == 1) {
            constraintLayout.setAlpha(0.7f);
        } else if (i2 == 2) {
            constraintLayout.setAlpha(0.6f);
        } else {
            constraintLayout.setAlpha(0.0f);
        }
    }

    public void startOpenAnimation(int i2, RecyclerView.LayoutManager layoutManager) {
        final android.view.View findViewByPosition = layoutManager.findViewByPosition(i2);
        if (findViewByPosition != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(findViewByPosition.getContext(), R.anim.sf_item_fall_down);
            final $$Lambda$CLPCarouselItem4X$GvOuIHHuCn2gmZtIj_S1sd2a16g r2 = new Runnable(i2, layoutManager) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ RecyclerView.LayoutManager f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CLPCarouselItem4X.this.lambda$startOpenAnimation$0$CLPCarouselItem4X(this.f$1, this.f$2);
                }
            };
            if (i2 != 0) {
                findViewByPosition.startAnimation(loadAnimation);
            } else {
                new Handler().postDelayed(r2, 50);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    findViewByPosition.setVisibility(0);
                    new Handler().postDelayed(r2, 50);
                }
            });
        }
    }

    public /* synthetic */ void lambda$startOpenAnimation$0$CLPCarouselItem4X(int i2, RecyclerView.LayoutManager layoutManager) {
        startOpenAnimation(i2 + 1, layoutManager);
    }

    public void onClick(RecoRvClick recoRvClick, Item item) {
        ((ImageView) this.reco4xBinding.getRoot().findViewById(R.id.close_icon)).setOnClickListener(new View.OnClickListener(item, recoRvClick) {
            private final /* synthetic */ Item f$1;
            private final /* synthetic */ RecoRvClick f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(android.view.View view) {
                CLPCarouselItem4X.this.lambda$onClick$1$CLPCarouselItem4X(this.f$1, this.f$2, view);
            }
        });
        this.itemView.findViewById(R.id.recoLayoutContainer).setOnClickListener(new View.OnClickListener(recoRvClick) {
            private final /* synthetic */ RecoRvClick f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(android.view.View view) {
                CLPCarouselItem4X.this.lambda$onClick$2$CLPCarouselItem4X(this.f$1, view);
            }
        });
        this.itemView.findViewById(R.id.mainLayoutReco).setOnClickListener(new View.OnClickListener(recoRvClick) {
            private final /* synthetic */ RecoRvClick f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(android.view.View view) {
                CLPCarouselItem4X.this.lambda$onClick$3$CLPCarouselItem4X(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$onClick$1$CLPCarouselItem4X(Item item, RecoRvClick recoRvClick, android.view.View view) {
        ValidateViewResponse.setRecoDisallowedSet(item.getId());
        Animation loadAnimation = AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.sf_popup_out_anim);
        loadAnimation.setDuration(200);
        this.itemView.startAnimation(loadAnimation);
        recoRvClick.closeClick(getAdapterPosition());
    }

    public /* synthetic */ void lambda$onClick$2$CLPCarouselItem4X(RecoRvClick recoRvClick, android.view.View view) {
        recoRvClick.closeClick(this.CLICKED_OUTSIDE);
    }

    public /* synthetic */ void lambda$onClick$3$CLPCarouselItem4X(RecoRvClick recoRvClick, android.view.View view) {
        recoRvClick.onItemClick(this.itemView, getAdapterPosition());
    }
}
