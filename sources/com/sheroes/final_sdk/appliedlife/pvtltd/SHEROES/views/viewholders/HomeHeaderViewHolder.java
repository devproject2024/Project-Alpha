package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.ConfigData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CircleImageView;

public class HomeHeaderViewHolder extends BaseViewHolder<FeedDetail> {
    private int authorProfileSize;
    private FeedDetail dataItem;
    private TextView headerMsg;
    private CircleImageView ivLoginUserPic;
    private String loggedInUser;
    Preference<Configuration> mConfiguration;
    private String mPhotoUrl;
    private RelativeLayout rlHeaderView;
    private TextView userName;
    Preference<LoginResponse> userPreference;
    BaseHolderInterface viewInterface;

    public void viewRecycled() {
    }

    public HomeHeaderViewHolder(View view, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.viewInterface = baseHolderInterface;
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
        this.ivLoginUserPic = (CircleImageView) view.findViewById(R.id.sheroes_iv_header_circle_icon);
        this.headerMsg = (TextView) view.findViewById(R.id.sheroes_header_msg);
        this.headerMsg.setOnClickListener(this);
        this.userName = (TextView) view.findViewById(R.id.sheroes_user_name);
        this.rlHeaderView = (RelativeLayout) view.findViewById(R.id.sheroes_rl_header_view);
        this.rlHeaderView.setOnClickListener(this);
        this.authorProfileSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.dataItem = feedDetail;
        Preference<LoginResponse> preference = this.userPreference;
        if (!(preference == null || !preference.isSet() || this.userPreference.get().getUserSummary() == null)) {
            if (StringUtil.isNotNullOrEmptyString(this.userPreference.get().getUserSummary().getPhotoUrl())) {
                this.mPhotoUrl = this.userPreference.get().getUserSummary().getPhotoUrl();
            }
            String str = this.userPreference.get().getUserSummary().getFirstName() + " " + this.userPreference.get().getUserSummary().getLastName();
            if (StringUtil.isNotNullOrEmptyString(str)) {
                this.loggedInUser = str;
            }
            if (this.userPreference.get().getUserSummary().getUserBO().getUserTypeId() == 7) {
                this.dataItem.setAuthorMentor(true);
            }
        }
        this.ivLoginUserPic.setCircularImage(true);
        String str2 = this.mPhotoUrl;
        int i3 = this.authorProfileSize;
        this.ivLoginUserPic.bindImage(CommonUtil.getThumborUri(str2, i3, i3));
        if (StringUtil.isNotNullOrEmptyString(this.loggedInUser)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.loggedInUser.substring(0, 1).toUpperCase());
            String str3 = this.loggedInUser;
            sb.append(str3.substring(1, str3.length()));
            this.userName.setText(sb.toString());
        }
        Preference<Configuration> preference2 = this.mConfiguration;
        if (preference2 == null || !preference2.isSet() || this.mConfiguration.get().configData == null) {
            this.headerMsg.setText(new ConfigData().mFeedHeaderPostText);
        } else {
            this.headerMsg.setText(this.mConfiguration.get().configData.mFeedHeaderPostText);
        }
    }

    private void textClickForCreatePost() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onAskQuestionClicked();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_header_msg || id == R.id.sheroes_rl_header_view) {
            textClickForCreatePost();
        }
    }
}
