package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Community;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CircleTransform;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;

public class CommunityListAdapter extends RecyclerView.a<CommunityListItemViewHolder> {
    private final List<Community> mCommunityList;
    private final View.OnClickListener mOnClickListener;

    public CommunityListAdapter(Context context, List<Community> list, View.OnClickListener onClickListener) {
        this.mCommunityList = list;
        this.mOnClickListener = onClickListener;
    }

    public CommunityListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sheroes_community_item, viewGroup, false);
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            inflate.setOnClickListener(onClickListener);
        }
        return new CommunityListItemViewHolder(inflate);
    }

    public void onBindViewHolder(CommunityListItemViewHolder communityListItemViewHolder, int i2) {
        communityListItemViewHolder.mCommunityContainer.setOnClickListener(this.mOnClickListener);
        Community community = this.mCommunityList.get(i2);
        if (community != null) {
            if (community.thumbImageUrl != null && CommonUtil.isNotEmpty(community.thumbImageUrl)) {
                w.a().a(CommonUtil.getThumborUri(community.thumbImageUrl, communityListItemViewHolder.authorPicSize, communityListItemViewHolder.authorPicSize)).a((ah) new CircleTransform(0.0f, 0)).a(communityListItemViewHolder.communityPic, (e) null);
            }
            communityListItemViewHolder.communityName.setText(community.name);
            if (community.isChecked) {
                communityListItemViewHolder.mCheck.setVisibility(0);
            } else {
                communityListItemViewHolder.mCheck.setVisibility(8);
            }
            if (community.isFirstOther) {
                communityListItemViewHolder.otherCommunity.setVisibility(0);
            } else {
                communityListItemViewHolder.otherCommunity.setVisibility(8);
            }
        }
    }

    public int getItemCount() {
        List<Community> list = this.mCommunityList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    static class CommunityListItemViewHolder extends RecyclerView.v {
        int authorPicSize;
        TextView communityName;
        ImageView communityPic;
        ImageView mCheck;
        RelativeLayout mCommunityContainer;
        TextView otherCommunity;

        CommunityListItemViewHolder(View view) {
            super(view);
            this.otherCommunity = (TextView) view.findViewById(R.id.sheroes_other_community);
            this.authorPicSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_36);
            this.mCommunityContainer = (RelativeLayout) view.findViewById(R.id.sheroes_community_container);
            this.communityPic = (ImageView) view.findViewById(R.id.sheroes_community_pic);
            this.communityName = (TextView) view.findViewById(R.id.sheroes_community_name);
            this.mCheck = (ImageView) view.findViewById(R.id.sheroes_check);
        }
    }

    public void setItem(int i2, Community community) {
        this.mCommunityList.set(i2, community);
        notifyItemChanged(i2);
    }
}
