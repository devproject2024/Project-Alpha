package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.browser.customtabs.d;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityPostCreateRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.CommunityTopPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.RemoveMemberRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.MyCommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like.LikeRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous.ApproveSpamPostRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete.DeleteCommunityPostRequest;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.upi.util.UpiContract;

public class AppUtils {
    private static final String TAG = AppUtils.class.getName();
    private static AppUtils sInstance;
    public final Pattern URL_START_WWW_ADDRESS_PATTERN = Pattern.compile("([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
    public final Pattern URL_WITH_HTTP_ADDRESS_PATTERN = Pattern.compile("(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
    private String mDeviceId;

    private AppUtils() {
    }

    public static synchronized AppUtils getInstance() {
        AppUtils appUtils;
        synchronized (AppUtils.class) {
            if (sInstance == null) {
                sInstance = new AppUtils();
            }
            appUtils = sInstance;
        }
        return appUtils;
    }

    public Context getApplicationContext() {
        return SheroesSdk.getApplicationContext();
    }

    public static int[] getWindowSize(Context context) {
        int i2;
        int i3;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i2 = point.x;
            i3 = point.y;
        } else {
            int width = defaultDisplay.getWidth();
            i3 = defaultDisplay.getHeight();
            i2 = width;
        }
        return new int[]{i2, i3};
    }

    public String getAppVersionName() {
        return getPackageInfo(0) != null ? getPackageInfo(0).versionName : "";
    }

    public String getCloudMessaging() {
        return getPackageInfo(0) != null ? getPackageInfo(0).versionName : "";
    }

    public String getDeviceId() {
        try {
            if (this.mDeviceId == null) {
                this.mDeviceId = Settings.Secure.getString(SheroesSdk.getApplicationContext().getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            }
            return this.mDeviceId;
        } catch (Exception e2) {
            Bamboo.e(TAG, "", e2);
            return " ";
        }
    }

    public PackageInfo getPackageInfo(int i2) {
        try {
            return SheroesSdk.getApplicationContext().getPackageManager().getPackageInfo(SheroesSdk.getApplicationContext().getPackageName(), i2);
        } catch (PackageManager.NameNotFoundException e2) {
            Bamboo.e(TAG, e2.toString(), e2);
            return null;
        } catch (Exception e3) {
            Bamboo.e(TAG, e3.toString(), e3);
            return null;
        }
    }

    public boolean checkUrl(String str) {
        return this.URL_WITH_HTTP_ADDRESS_PATTERN.matcher(str).matches();
    }

    public boolean checkWWWUrl(String str) {
        return this.URL_START_WWW_ADDRESS_PATTERN.matcher(str).matches();
    }

    public static int findNthIndexOf(String str, String str2, int i2) throws IndexOutOfBoundsException {
        Matcher matcher = Pattern.compile(str2, 8).matcher(str);
        while (matcher.find()) {
            i2--;
            if (i2 == 0) {
                return matcher.start();
            }
        }
        return 0;
    }

    public static RemoveMemberRequest removeMemberRequestBuilder(Long l, Long l2) {
        RemoveMemberRequest removeMemberRequest = new RemoveMemberRequest();
        AppUtils instance = getInstance();
        removeMemberRequest.setCommunityId(l);
        removeMemberRequest.setUserId(l2);
        removeMemberRequest.setDeviceUniqueId(instance.getDeviceId());
        removeMemberRequest.setCommunityId(l);
        removeMemberRequest.setAppVersion(instance.getAppVersionName());
        removeMemberRequest.setCloudMessagingId(instance.getCloudMessaging());
        return removeMemberRequest;
    }

    public FeedRequestPojo userCommunityDetailRequestBuilder(String str, int i2, long j) {
        FeedRequestPojo makeFeedRequest = makeFeedRequest(str, i2);
        makeFeedRequest.setIdForFeedDetail(Long.valueOf(j));
        return makeFeedRequest;
    }

    public static FeedRequestPojo makeFeedRequest(String str, int i2) {
        AppUtils instance = getInstance();
        FeedRequestPojo feedRequestPojo = new FeedRequestPojo();
        feedRequestPojo.setAppVersion(instance.getAppVersionName());
        feedRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        feedRequestPojo.setScreenName("Feed");
        feedRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        feedRequestPojo.setPageNo(i2);
        feedRequestPojo.setPageSize(10);
        feedRequestPojo.setSubType(str);
        return feedRequestPojo;
    }

    public static DeleteCommunityPostRequest deleteCommunityPostRequest(long j) {
        AppUtils instance = getInstance();
        DeleteCommunityPostRequest deleteCommunityPostRequest = new DeleteCommunityPostRequest();
        deleteCommunityPostRequest.setAppVersion(instance.getAppVersionName());
        deleteCommunityPostRequest.setDeviceUniqueId(instance.getDeviceId());
        deleteCommunityPostRequest.setCloudMessagingId(instance.getCloudMessaging());
        deleteCommunityPostRequest.setIdOfEntityOrParticipant(j);
        return deleteCommunityPostRequest;
    }

    public LikeRequestPojo likeRequestBuilder(long j, int i2) {
        AppUtils instance = getInstance();
        LikeRequestPojo likeRequestPojo = new LikeRequestPojo();
        likeRequestPojo.setAppVersion(instance.getAppVersionName());
        likeRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        likeRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        likeRequestPojo.setEntityId(Long.valueOf(j));
        likeRequestPojo.setReactionValue(Integer.valueOf(i2));
        return likeRequestPojo;
    }

    public LikeRequestPojo likeRequestBuilder(long j, int i2, long j2) {
        AppUtils instance = getInstance();
        LikeRequestPojo likeRequestPojo = new LikeRequestPojo();
        likeRequestPojo.setAppVersion(instance.getAppVersionName());
        likeRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        likeRequestPojo.commentId = Long.valueOf(j2);
        likeRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        likeRequestPojo.setEntityId(Long.valueOf(j));
        likeRequestPojo.setReactionValue(Integer.valueOf(i2));
        return likeRequestPojo;
    }

    public LikeRequestPojo unLikeRequestBuilder(long j, long j2) {
        AppUtils instance = getInstance();
        LikeRequestPojo likeRequestPojo = new LikeRequestPojo();
        likeRequestPojo.setAppVersion(instance.getAppVersionName());
        likeRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        likeRequestPojo.commentId = Long.valueOf(j2);
        likeRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        likeRequestPojo.setEntityId(Long.valueOf(j));
        return likeRequestPojo;
    }

    public static CommentReactionRequestPojo getCommentRequestBuilder(long j, int i2) {
        AppUtils instance = getInstance();
        CommentReactionRequestPojo commentReactionRequestPojo = new CommentReactionRequestPojo();
        commentReactionRequestPojo.setAppVersion(instance.getAppVersionName());
        commentReactionRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        commentReactionRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        commentReactionRequestPojo.setPageNo(i2);
        commentReactionRequestPojo.setPageSize(25);
        commentReactionRequestPojo.setEntityId(j);
        return commentReactionRequestPojo;
    }

    public static CommentReactionRequestPojo getCommentRequestBuilder(long j, int i2, int i3) {
        AppUtils instance = getInstance();
        CommentReactionRequestPojo commentReactionRequestPojo = new CommentReactionRequestPojo();
        commentReactionRequestPojo.setAppVersion(instance.getAppVersionName());
        commentReactionRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        commentReactionRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        commentReactionRequestPojo.setPageNo(i2);
        commentReactionRequestPojo.setPageSize(i3);
        commentReactionRequestPojo.setEntityId(j);
        return commentReactionRequestPojo;
    }

    public static MyCommunityRequest myCommunityRequestBuilder(String str, int i2) {
        AppUtils instance = getInstance();
        MyCommunityRequest myCommunityRequest = new MyCommunityRequest();
        myCommunityRequest.setAppVersion(instance.getAppVersionName());
        myCommunityRequest.setSource("android");
        myCommunityRequest.setDeviceUniqueId(instance.getDeviceId());
        myCommunityRequest.setCloudMessagingId(instance.getCloudMessaging());
        myCommunityRequest.setPageNo(i2);
        myCommunityRequest.setPageSize(10);
        myCommunityRequest.setSubType(str);
        return myCommunityRequest;
    }

    public static MyCommunityRequest myCommunityRequestBuilder(String str, int i2, int i3) {
        AppUtils instance = getInstance();
        MyCommunityRequest myCommunityRequest = new MyCommunityRequest();
        myCommunityRequest.setAppVersion(instance.getAppVersionName());
        myCommunityRequest.setSource("android");
        myCommunityRequest.setDeviceUniqueId(instance.getDeviceId());
        myCommunityRequest.setCloudMessagingId(instance.getCloudMessaging());
        myCommunityRequest.setPageNo(i2);
        myCommunityRequest.setPageSize(i3);
        myCommunityRequest.setSubType(str);
        return myCommunityRequest;
    }

    public static CommunityPostCreateRequest schedulePost(Long l, String str, String str2, List<String> list, Long l2, LinkRenderResponse linkRenderResponse, boolean z, String str3) {
        CommunityPostCreateRequest createCommunityPostRequestBuilder = createCommunityPostRequestBuilder(l, str, str2, list, l2, linkRenderResponse, z);
        createCommunityPostRequestBuilder.setSchedulePost(str3);
        return createCommunityPostRequestBuilder;
    }

    public static CommunityPostCreateRequest createCommunityPostRequestBuilder(Long l, String str, String str2, List<String> list, Long l2, LinkRenderResponse linkRenderResponse, boolean z) {
        AppUtils instance = getInstance();
        CommunityPostCreateRequest communityPostCreateRequest = new CommunityPostCreateRequest();
        communityPostCreateRequest.setAppVersion(instance.getAppVersionName());
        communityPostCreateRequest.setCloudMessagingId(instance.getCloudMessaging());
        communityPostCreateRequest.setDeviceUniqueId(instance.getDeviceId());
        communityPostCreateRequest.setCommunityId(l);
        communityPostCreateRequest.setCreatorType(str);
        communityPostCreateRequest.setDescription(str2);
        communityPostCreateRequest.setImages(list);
        communityPostCreateRequest.setPostToFacebook(z);
        communityPostCreateRequest.setId(l2);
        if (linkRenderResponse != null) {
            communityPostCreateRequest.setOgTitleS(linkRenderResponse.getOgTitleS());
            communityPostCreateRequest.setOgDescriptionS(linkRenderResponse.getOgDescriptionS());
            communityPostCreateRequest.setOgImageUrlS(linkRenderResponse.getOgImageUrlS());
            communityPostCreateRequest.setOgVideoLinkB(linkRenderResponse.isOgVideoLinkB());
            communityPostCreateRequest.setOgRequestedUrlS(linkRenderResponse.getOgRequestedUrlS());
        } else {
            communityPostCreateRequest.setOgTitleS("");
            communityPostCreateRequest.setOgDescriptionS("");
            communityPostCreateRequest.setOgImageUrlS("");
            communityPostCreateRequest.setOgVideoLinkB(false);
            communityPostCreateRequest.setOgRequestedUrlS("");
        }
        return communityPostCreateRequest;
    }

    public LinkRequest linkRequestBuilder(String str) {
        AppUtils instance = getInstance();
        LinkRequest linkRequest = new LinkRequest();
        linkRequest.setAppVersion(instance.getAppVersionName());
        linkRequest.setSource("android");
        linkRequest.setLinkUrl(str);
        return linkRequest;
    }

    public static CommunityPostCreateRequest editCommunityPostRequestBuilder(Long l, String str, String str2, List<String> list, Long l2, List<Long> list2, LinkRenderResponse linkRenderResponse) {
        AppUtils instance = getInstance();
        CommunityPostCreateRequest communityPostCreateRequest = new CommunityPostCreateRequest();
        communityPostCreateRequest.setAppVersion(instance.getAppVersionName());
        communityPostCreateRequest.setCloudMessagingId(instance.getCloudMessaging());
        communityPostCreateRequest.setDeviceUniqueId(instance.getDeviceId());
        communityPostCreateRequest.setCommunityId(l);
        communityPostCreateRequest.setCreatorType(str);
        communityPostCreateRequest.setDescription(str2);
        communityPostCreateRequest.setImages(list);
        communityPostCreateRequest.setId(l2);
        communityPostCreateRequest.setDeleteImagesIds(list2);
        if (linkRenderResponse != null) {
            communityPostCreateRequest.setOgTitleS(linkRenderResponse.getOgTitleS());
            communityPostCreateRequest.setOgDescriptionS(linkRenderResponse.getOgDescriptionS());
            communityPostCreateRequest.setOgImageUrlS(linkRenderResponse.getOgImageUrlS());
            communityPostCreateRequest.setOgVideoLinkB(linkRenderResponse.isOgVideoLinkB());
            communityPostCreateRequest.setOgRequestedUrlS(linkRenderResponse.getOgRequestedUrlS());
        } else {
            communityPostCreateRequest.setOgTitleS("");
            communityPostCreateRequest.setOgDescriptionS("");
            communityPostCreateRequest.setOgImageUrlS("");
            communityPostCreateRequest.setOgVideoLinkB(false);
            communityPostCreateRequest.setOgRequestedUrlS("");
        }
        return communityPostCreateRequest;
    }

    public static CommunityTopPostRequest topCommunityPostRequestBuilder(Long l, String str, String str2, long j, boolean z) {
        AppUtils instance = getInstance();
        CommunityTopPostRequest communityTopPostRequest = new CommunityTopPostRequest();
        communityTopPostRequest.setAppVersion(instance.getAppVersionName());
        communityTopPostRequest.setCloudMessagingId(instance.getCloudMessaging());
        communityTopPostRequest.setDeviceUniqueId(instance.getDeviceId());
        communityTopPostRequest.setCommunityId(l);
        communityTopPostRequest.setCreatorType(str);
        communityTopPostRequest.setDescription(str2);
        communityTopPostRequest.setTopPost(z);
        communityTopPostRequest.setId(Long.valueOf(j));
        return communityTopPostRequest;
    }

    public ApproveSpamPostRequest spamPostApprovedRequestBuilder(FeedDetail feedDetail, boolean z, boolean z2, boolean z3) {
        AppUtils instance = getInstance();
        ApproveSpamPostRequest approveSpamPostRequest = new ApproveSpamPostRequest();
        approveSpamPostRequest.setAppVersion(instance.getAppVersionName());
        approveSpamPostRequest.setCloudMessagingId(instance.getCloudMessaging());
        approveSpamPostRequest.setDeviceUniqueId(instance.getDeviceId());
        approveSpamPostRequest.setApproved(z3);
        approveSpamPostRequest.setId(Long.valueOf(feedDetail.getIdOfEntityOrParticipant()));
        approveSpamPostRequest.setActive(z);
        approveSpamPostRequest.setSpam(z2);
        return approveSpamPostRequest;
    }

    public static CommentReactionRequestPojo postCommentRequestBuilder(long j, String str, boolean z) {
        AppUtils instance = getInstance();
        CommentReactionRequestPojo commentReactionRequestPojo = new CommentReactionRequestPojo();
        commentReactionRequestPojo.setAppVersion(instance.getAppVersionName());
        commentReactionRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        commentReactionRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        commentReactionRequestPojo.setUserComment(str);
        commentReactionRequestPojo.setIsAnonymous(z);
        commentReactionRequestPojo.setEntityId(j);
        return commentReactionRequestPojo;
    }

    public static CommentReactionRequestPojo editCommentRequestBuilder(long j, String str, boolean z, boolean z2, long j2) {
        AppUtils instance = getInstance();
        CommentReactionRequestPojo commentReactionRequestPojo = new CommentReactionRequestPojo();
        commentReactionRequestPojo.setAppVersion(instance.getAppVersionName());
        commentReactionRequestPojo.setDeviceUniqueId(instance.getDeviceId());
        commentReactionRequestPojo.setCloudMessagingId(instance.getCloudMessaging());
        commentReactionRequestPojo.setUserComment(str);
        commentReactionRequestPojo.setIsAnonymous(z);
        commentReactionRequestPojo.setIsActive(z2);
        commentReactionRequestPojo.setEntityId(j);
        commentReactionRequestPojo.setParticipationId(j2);
        return commentReactionRequestPojo;
    }

    public static CommunityRequest communityRequestBuilder(List<Long> list, long j, String str) {
        AppUtils instance = getInstance();
        CommunityRequest communityRequest = new CommunityRequest();
        communityRequest.setUserId(list);
        communityRequest.setCommunityId(j);
        communityRequest.setAppVersion(instance.getAppVersionName());
        communityRequest.setCloudMessagingId(instance.getCloudMessaging());
        communityRequest.setDeviceUniqueId(instance.getDeviceId());
        communityRequest.setLastScreenName("community_detail");
        communityRequest.setScreenName("community_detail");
        communityRequest.setReasonToJoin(str);
        return communityRequest;
    }

    public static void openChromeTab(Activity activity, Uri uri) {
        d c2 = new d.a().a(b.c(activity, R.color.colorPrimary)).b().a().c();
        if (Build.VERSION.SDK_INT >= 22) {
            Intent intent = c2.f1901a;
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("2//" + activity.getPackageName()));
        }
        c2.a((Context) activity, uri);
    }

    public static void openChromeTabForce(Activity activity, Uri uri) {
        d c2 = new d.a().a(b.c(activity, R.color.colorPrimary)).b().a().c();
        Iterator<ApplicationInfo> it2 = activity.getPackageManager().getInstalledApplications(128).iterator();
        while (true) {
            if (it2.hasNext()) {
                if (TextUtils.equals(it2.next().packageName, "com.android.chrome")) {
                    c2.f1901a.setPackage("com.android.chrome");
                    break;
                }
            } else {
                break;
            }
        }
        c2.a((Context) activity, uri);
    }

    public static boolean matchesWebsiteURLPattern(String str) {
        return Pattern.compile("\\b(https?|Https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", 40).matcher(str).find();
    }
}
