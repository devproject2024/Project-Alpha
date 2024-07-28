package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.UserLikedListPresenterImpl;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.LikeListAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IUserLikedListView;
import java.util.List;
import org.parceler.g;

public class LikeListBottomSheetFragment extends b implements LikeListAdapter.LikeHolderListener, IUserLikedListView {
    private static final String SCREEN_LABEL = "PostBottomSheetFragment";
    private static final String USER_POST_ID = "UserPostId";
    TextView mLikeCount;
    private LikeListAdapter mLikeListAdapter;
    ProgressBar mProgressBar;
    RecyclerView mRecyclerView;
    UserLikedListPresenterImpl mUserLikedListPresenter;
    public long mUserPostId;
    UserPostSolrObj mUserPostSolrObj;

    public void showError(String str, FeedParticipationEnum feedParticipationEnum) {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (getArguments() != null) {
            this.mUserPostId = getArguments().getLong(USER_POST_ID, -1);
            Parcelable parcelable = getArguments().getParcelable(UserPostSolrObj.USER_POST_OBJ);
            if (parcelable != null) {
                this.mUserPostSolrObj = (UserPostSolrObj) g.a(parcelable);
            }
            if (this.mUserPostId == -1 && getDialog() != null) {
                getDialog().dismiss();
            }
        }
        return super.onCreateDialog(bundle);
    }

    public void setupDialog(Dialog dialog, int i2) {
        SheroesSdk.getAppComponent(getContext()).inject(this);
        this.mUserLikedListPresenter.attachView(this);
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.dialog_sheroes_like_list, (ViewGroup) null);
        dialog.setContentView(inflate);
        this.mLikeCount = (TextView) inflate.findViewById(R.id.sheroes_like_count);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.sheroes_user_like_list);
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.sheroes_progress_bar);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()) {
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.mRecyclerView.setNestedScrollingEnabled(false);
        this.mRecyclerView.setFocusable(false);
        ((y) this.mRecyclerView.getItemAnimator()).m = false;
        this.mUserLikedListPresenter.getUserLikedList(AppUtils.getCommentRequestBuilder(this.mUserPostId, 1, 200), true, 0);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void startProgressBar() {
        this.mProgressBar.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.mLikeCount.setVisibility(8);
    }

    public void stopProgressBar() {
        this.mProgressBar.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mLikeCount.setVisibility(0);
    }

    public static LikeListBottomSheetFragment showDialog(AppCompatActivity appCompatActivity, String str, long j, UserPostSolrObj userPostSolrObj) {
        LikeListBottomSheetFragment likeListBottomSheetFragment = new LikeListBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(USER_POST_ID, j);
        bundle.putParcelable(UserPostSolrObj.USER_POST_OBJ, g.a(userPostSolrObj));
        bundle.putLong(USER_POST_ID, j);
        likeListBottomSheetFragment.setArguments(bundle);
        bundle.putString(BaseActivity.SOURCE_SCREEN, str);
        likeListBottomSheetFragment.show(appCompatActivity.getSupportFragmentManager(), SCREEN_LABEL);
        return likeListBottomSheetFragment;
    }

    public void showUserLikedList(List<Comment> list) {
        if (getActivity() != null && isAdded()) {
            RecyclerView recyclerView = this.mRecyclerView;
            LikeListAdapter likeListAdapter = new LikeListAdapter(getActivity(), list, this);
            this.mLikeListAdapter = likeListAdapter;
            recyclerView.setAdapter(likeListAdapter);
            LikeListAdapter likeListAdapter2 = this.mLikeListAdapter;
            if (likeListAdapter2 != null) {
                likeListAdapter2.notifyDataSetChanged();
            }
            String quantityString = getResources().getQuantityString(R.plurals.numberOfLikes, list.size());
            TextView textView = this.mLikeCount;
            textView.setText(CommonUtil.getRoundedMetricFormat((long) list.size()) + " " + quantityString);
        }
    }

    public void onLikeRowItemClicked(LikeListAdapter.LikeListItemViewHolder likeListItemViewHolder) {
        int adapterPosition = likeListItemViewHolder.getAdapterPosition();
        if (adapterPosition != -1) {
            this.mLikeListAdapter.getComment(adapterPosition);
        }
    }
}
