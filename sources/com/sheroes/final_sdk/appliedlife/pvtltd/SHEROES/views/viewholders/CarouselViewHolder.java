package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.AllCommunityItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.CarouselListAdapter;
import java.util.List;

public class CarouselViewHolder extends BaseViewHolder<CarouselDataObj> {
    private final String TAG = CarouselViewHolder.class.getName();
    private CarouselDataObj carouselDataObj;
    private boolean isUpdateFromProfile;
    private TextView mBody;
    private TextView mIcon;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private TextView mTitle;
    /* access modifiers changed from: private */
    public int position;
    /* access modifiers changed from: private */
    public SparseArray<Parcelable> scrollStatePositionsMap = new SparseArray<>();
    private BaseHolderInterface viewInterface;

    public void viewRecycled() {
    }

    public CarouselViewHolder(View view, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.mIcon = (TextView) view.findViewById(R.id.sheroes_icon);
        this.mTitle = (TextView) view.findViewById(R.id.sheroes_title);
        this.mBody = (TextView) view.findViewById(R.id.sheroes_body);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.sheroes_rv_suggested_mentor_list);
        ((FrameLayout) view.findViewById(R.id.sheroes_icon_container)).setOnClickListener(this);
        this.viewInterface = baseHolderInterface;
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.l() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    CarouselViewHolder.this.scrollStatePositionsMap.put(CarouselViewHolder.this.position, recyclerView.getLayoutManager().onSaveInstanceState());
                }
            }
        });
    }

    public void bindData(CarouselDataObj carouselDataObj2, Context context, final int i2) {
        this.carouselDataObj = carouselDataObj2;
        this.position = i2;
        carouselDataObj2.setItemPosition(i2);
        int i3 = 0;
        if (StringUtil.isNotNullOrEmptyString(carouselDataObj2.getTitle())) {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(carouselDataObj2.getTitle());
        }
        if (StringUtil.isNotNullOrEmptyString(carouselDataObj2.getBody())) {
            this.mBody.setVisibility(0);
            this.mBody.setText(carouselDataObj2.getBody());
        } else {
            this.mBody.setVisibility(8);
        }
        if (CommonUtil.isNotEmpty(carouselDataObj2.getIconUrl())) {
            this.mIcon.setVisibility(0);
        }
        List<FeedDetail> feedDetails = carouselDataObj2.getFeedDetails();
        if (StringUtil.isNotEmptyCollection(feedDetails)) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            CarouselListAdapter carouselListAdapter = new CarouselListAdapter(context, this.viewInterface, carouselDataObj2, this);
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            this.mRecyclerView.setAdapter(carouselListAdapter);
            carouselListAdapter.setData(carouselDataObj2.getFeedDetails());
            while (true) {
                if (i3 < feedDetails.size()) {
                    if ((feedDetails.get(i3) instanceof UserSolrObj) && ((UserSolrObj) feedDetails.get(i3)).isSuggested()) {
                        this.isUpdateFromProfile = true;
                        UserSolrObj userSolrObj = (UserSolrObj) feedDetails.get(i3);
                        carouselListAdapter.notifyItemChanged(i3, userSolrObj);
                        this.mRecyclerView.scrollToPosition(userSolrObj.getItemPosition());
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (!this.isUpdateFromProfile) {
                carouselListAdapter.notifyDataSetChanged();
            }
            if (this.scrollStatePositionsMap.get(i2) != null) {
                this.mRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        CarouselViewHolder.this.mRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                        CarouselViewHolder.this.mRecyclerView.getLayoutManager().onRestoreInstanceState((Parcelable) CarouselViewHolder.this.scrollStatePositionsMap.get(i2));
                        return false;
                    }
                });
            }
        }
    }

    private void onIconClicked() {
        CarouselDataObj carouselDataObj2 = this.carouselDataObj;
        if (carouselDataObj2 != null && carouselDataObj2.getFeedDetails() != null) {
            BaseHolderInterface baseHolderInterface = this.viewInterface;
            if (baseHolderInterface instanceof AllCommunityItemCallback) {
                ((AllCommunityItemCallback) baseHolderInterface).onSeeMoreClicked(this.carouselDataObj);
            } else if (baseHolderInterface instanceof FeedItemCallback) {
                ((FeedItemCallback) baseHolderInterface).onSeeMoreClicked(this.carouselDataObj);
            } else {
                baseHolderInterface.handleOnClick(this.carouselDataObj, this.mIcon);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sheroes_icon_container) {
            onIconClicked();
        }
    }
}
