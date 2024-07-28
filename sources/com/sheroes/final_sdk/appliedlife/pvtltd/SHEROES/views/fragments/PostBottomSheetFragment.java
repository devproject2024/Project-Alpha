package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import com.google.android.material.bottomsheet.b;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Community;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.MyCommunities;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostBottomSheetPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.CommunityListAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IPostBottomSheetView;
import java.util.ArrayList;
import java.util.List;
import org.parceler.g;

public class PostBottomSheetFragment extends b implements IPostBottomSheetView {
    private static final String SCREEN_LABEL = "PostBottomSheetFragment";
    Preference<AllCommunitiesResponse> mAllCommunities;
    public List<Community> mCommunityList = new ArrayList();
    /* access modifiers changed from: private */
    public CommunityListAdapter mCommunityListAdapter;
    CommunityPostActivity mCommunityPostActivity;
    /* access modifiers changed from: private */
    public MyCommunities mMyCommunities;
    PostBottomSheetPresenter mPostBottomSheetPresenter;
    RecyclerView mRecyclerView;

    public void startProgressBar() {
    }

    public void stopProgressBar() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        getArguments();
        return super.onCreateDialog(bundle);
    }

    public void onAttach(Activity activity) {
        this.mCommunityPostActivity = (CommunityPostActivity) activity;
        super.onAttach(activity);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void setupDialog(Dialog dialog, int i2) {
        SheroesSdk.getAppComponent(getContext()).inject(this);
        this.mPostBottomSheetPresenter.attachView(this);
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.dialog_sheroes_community_list, (ViewGroup) null);
        dialog.setContentView(inflate);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.sheroes_community_list);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()) {
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.mRecyclerView.setNestedScrollingEnabled(false);
        this.mRecyclerView.setFocusable(false);
        ((y) this.mRecyclerView.getItemAnimator()).m = false;
        this.mMyCommunities = new MyCommunities();
        if (getArguments().getParcelable(MyCommunities.MY_COMMUNITY_OBJ) != null) {
            this.mMyCommunities = (MyCommunities) g.a(getArguments().getParcelable(MyCommunities.MY_COMMUNITY_OBJ));
            this.mCommunityList = this.mMyCommunities.myCommunities;
        } else {
            setMyCommunityList();
        }
        showCommunity();
    }

    private void setMyCommunityList() {
        this.mMyCommunities = new MyCommunities();
        Preference<AllCommunitiesResponse> preference = this.mAllCommunities;
        if (preference == null || !preference.isSet() || this.mAllCommunities.get() == null || CommonUtil.isEmpty(this.mAllCommunities.get().feedDetails)) {
            this.mPostBottomSheetPresenter.getAllCommunities(AppUtils.myCommunityRequestBuilder(AppConstants.FEED_COMMUNITY, 1));
            return;
        }
        boolean z = false;
        for (FeedDetail next : this.mAllCommunities.get().feedDetails) {
            Community community = new Community();
            community.id = next.getIdOfEntityOrParticipant();
            community.name = next.getNameOrTitle();
            community.thumbImageUrl = next.getThumbnailImageUrl();
            CommunityFeedSolrObj communityFeedSolrObj = (CommunityFeedSolrObj) next;
            community.isOwner = communityFeedSolrObj.isOwner();
            if (!communityFeedSolrObj.isOwner() && !communityFeedSolrObj.isMember() && !z) {
                community.isFirstOther = true;
                z = true;
            }
            this.mCommunityList.add(community);
        }
        this.mMyCommunities.myCommunities = new ArrayList(this.mCommunityList);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void showError(String str, FeedParticipationEnum feedParticipationEnum) {
        this.mCommunityPostActivity.showError(str, feedParticipationEnum);
    }

    public void getFeedListSuccess(FeedResponsePojo feedResponsePojo) {
        if (feedResponsePojo != null && !CommonUtil.isEmpty(feedResponsePojo.getFeedDetails())) {
            for (FeedDetail next : feedResponsePojo.getFeedDetails()) {
                Community community = new Community();
                community.id = next.getIdOfEntityOrParticipant();
                community.name = next.getNameOrTitle();
                community.thumbImageUrl = next.getThumbnailImageUrl();
                community.isOwner = ((CommunityFeedSolrObj) next).isOwner();
                this.mCommunityList.add(community);
            }
            this.mMyCommunities.myCommunities = new ArrayList(this.mCommunityList);
            showCommunity();
        }
    }

    private void showCommunity() {
        RecyclerView recyclerView = this.mRecyclerView;
        CommunityListAdapter communityListAdapter = new CommunityListAdapter(getActivity(), this.mCommunityList, new View.OnClickListener() {
            public void onClick(View view) {
                int childAdapterPosition = PostBottomSheetFragment.this.mRecyclerView.getChildAdapterPosition(view);
                PostBottomSheetFragment.this.clearCheck();
                PostBottomSheetFragment.this.mMyCommunities.myCommunities.get(childAdapterPosition).isChecked = true;
                PostBottomSheetFragment.this.mCommunityListAdapter.notifyDataSetChanged();
                PostBottomSheetFragment.this.mCommunityPostActivity.setMainCommunity(PostBottomSheetFragment.this.mCommunityList.get(childAdapterPosition), PostBottomSheetFragment.this.mMyCommunities);
                PostBottomSheetFragment.this.dismiss();
            }
        });
        this.mCommunityListAdapter = communityListAdapter;
        recyclerView.setAdapter(communityListAdapter);
    }

    /* access modifiers changed from: private */
    public void clearCheck() {
        if (!CommonUtil.isEmpty(this.mCommunityList)) {
            for (Community community : this.mCommunityList) {
                community.isChecked = false;
            }
        }
    }

    public static PostBottomSheetFragment showDialog(AppCompatActivity appCompatActivity, String str) {
        PostBottomSheetFragment postBottomSheetFragment = new PostBottomSheetFragment();
        Bundle bundle = new Bundle();
        postBottomSheetFragment.setArguments(bundle);
        bundle.putString(BaseActivity.SOURCE_SCREEN, str);
        postBottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), SCREEN_LABEL);
        return postBottomSheetFragment;
    }

    public static PostBottomSheetFragment showDialog(AppCompatActivity appCompatActivity, String str, MyCommunities myCommunities) {
        PostBottomSheetFragment postBottomSheetFragment = new PostBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MyCommunities.MY_COMMUNITY_OBJ, g.a(myCommunities));
        postBottomSheetFragment.setArguments(bundle);
        bundle.putString(BaseActivity.SOURCE_SCREEN, str);
        postBottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), SCREEN_LABEL);
        return postBottomSheetFragment;
    }
}
