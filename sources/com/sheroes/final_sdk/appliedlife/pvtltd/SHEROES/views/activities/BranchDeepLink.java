package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.BranchModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.BranchData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.BranchSessionParam;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Community;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.CommunityPost;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import io.reactivex.rxjava3.g.c;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class BranchDeepLink extends BaseActivity {
    public static final String SCREEN_LABEL = "Deeplink Activity";
    public static final String TAG = "BranchDeepLinkActivity";
    BranchModel mBranchModel;

    private void startMainActivity() {
    }

    public Event getEventScreenName() {
        return null;
    }

    public SheroesPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return SCREEN_LABEL;
    }

    public boolean shouldTrackScreen() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SheroesSdk.getAppComponent(this).inject(this);
        if (getIntent() == null || getIntent().getData() == null) {
            startMainActivity();
        } else {
            routeDeepLink();
        }
        setContentView(R.layout.activity_sheroes_branch_deeplink);
    }

    private void routeDeepLink() {
        if (getIntent() == null || getIntent().getData() == null) {
            finish();
        } else {
            this.mBranchModel.fetchBranchData(getIntent().getData().toString(), "key_live_fot8gztY4GYDQYj12hCGWcplBuhnkzgZ").subscribe(new c<BranchData>() {
                public void onComplete() {
                }

                public void onError(Throwable th) {
                    BranchDeepLink.this.setBranchData((BranchData) null);
                }

                public void onNext(BranchData branchData) {
                    BranchDeepLink.this.setBranchData(branchData);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setBranchData(BranchData branchData) {
        if (branchData == null) {
            this.mBranchModel.fetchBranchData(getIntent().getData().toString(), "key_live_kdBTwNxOeTMdqEi8nsWj2ogeABiIJMY9").subscribe(new c<BranchData>() {
                public void onComplete() {
                }

                public void onError(Throwable th) {
                    BranchDeepLink.this.finish();
                }

                public void onNext(BranchData branchData) {
                    BranchDeepLink.this.deepLinkingRedirection(branchData);
                }
            });
        } else {
            deepLinkingRedirection(branchData);
        }
    }

    /* access modifiers changed from: private */
    public void deepLinkingRedirection(BranchData branchData) {
        String[] split;
        new Intent();
        String str = branchData.sessionParams.deepLinkUrl;
        String str2 = branchData.sessionParams.openInWebView;
        if (str.equalsIgnoreCase(AppConstants.COLLECTION_NEW_URL) || str.equalsIgnoreCase(AppConstants.COLLECTION_NEW_URL_COM)) {
            navigateToCollectionScreen(branchData);
        } else if (str.equalsIgnoreCase(AppConstants.CREATE_POST_URL) || str.equalsIgnoreCase(AppConstants.CREATE_POST_URL_COM)) {
            navigateToCommunityPostScreen(branchData);
        } else {
            if (str.contains(AppConstants.COMMUNITY_URL) || str.contains(AppConstants.COMMUNITY_URL_COM)) {
                try {
                    String substring = str.substring(AppUtils.findNthIndexOf(str, "/", 4), str.length());
                    if (countBackSlash(substring) > 2 && (split = substring.split("/")) != null && split.length > 0 && StringUtil.isNotNullOrEmptyString(split[split.length - 1]) && StringUtil.isNotNullOrEmptyString(split[split.length - 2])) {
                        navigateToPostDetailScreen(new String(Base64.decode(split[split.length - 1].replace("=", ""), 0), AppConstants.UTF_8));
                    }
                    finish();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(str)) {
                finish();
            } else if (str2 == null || !str2.equalsIgnoreCase("true")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!str.startsWith("https://sheroes.com") && !str.startsWith("http://sheroes.com") && !str.startsWith("https://sheroes.in") && !str.startsWith("http://sheroes.in")) {
                    startActivity(intent);
                    finish();
                }
            } else {
                AppUtils.openChromeTabForce(this, Uri.parse(str));
                finish();
            }
        }
    }

    private void navigateToPostDetailScreen(String str) {
        Intent intent = new Intent(this, PostDetailActivity.class);
        intent.putExtra(UserPostSolrObj.USER_POST_ID, str);
        intent.putExtra(BaseActivity.SOURCE_SCREEN, getScreenName());
        intent.setFlags(134217728);
        startActivity(intent);
    }

    private void navigateToSheroesDeeplinkScreen(Intent intent, JSONObject jSONObject, boolean z, String str) {
        intent.setPackage(SheroesSdk.getApplicationContext().getPackageName());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    intent.putExtra(next, (String) obj);
                }
                if (obj instanceof Boolean) {
                    intent.putExtra(next, ((Boolean) obj).booleanValue());
                }
                if (obj instanceof Integer) {
                    intent.putExtra(next, ((Integer) obj).intValue());
                }
            } catch (JSONException unused) {
            }
        }
        intent.putExtra(AppConstants.IS_SHARE_DEEP_LINK, z);
        if (isIntentAvailable(this, intent)) {
            intent.putExtra(BaseActivity.SOURCE_SCREEN, getScreenName());
            if (Uri.parse(str).getPath().equals("/home/")) {
                intent.getExtras();
            }
            startActivity(intent);
        }
        finish();
    }

    private void navigateToCommunityPostScreen(BranchData branchData) {
        BranchSessionParam branchSessionParam = branchData.sessionParams;
        String str = branchSessionParam.entityId;
        String str2 = branchSessionParam.entityName;
        int i2 = branchSessionParam.createPostRequestFor;
        boolean z = branchSessionParam.isMyEntity;
        String str3 = branchSessionParam.prefillText;
        boolean z2 = branchSessionParam.isChallengeType;
        String str4 = branchSessionParam.challengeAuthorType;
        CommunityPost communityPost = new CommunityPost();
        communityPost.community = new Community();
        communityPost.community.name = str2;
        communityPost.body = str3;
        communityPost.isMyPost = z;
        communityPost.createPostRequestFrom = i2;
        if (z2) {
            communityPost.isChallengeType = true;
            communityPost.challengeType = str4;
            communityPost.challengeHashTag = str3;
            communityPost.challengeId = Integer.parseInt(str);
        } else {
            communityPost.community.id = Long.parseLong(str);
        }
        CommunityPostActivity.navigateTo((Activity) this, communityPost, 5001, true, new EventProperty.Builder().sourceScreenId(str2).build());
        finish();
    }

    private void navigateToCollectionScreen(BranchData branchData) {
        String str = branchData.sessionParams.endPointUrl;
        String str2 = branchData.sessionParams.screenName;
        CollectionActivity.navigateTo(this, str, str2, getScreenName(), str2, (HashMap<String, Object>) null, 1);
        finish();
    }

    private boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private int countBackSlash(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '/') {
                i2++;
            }
        }
        return i2;
    }
}
