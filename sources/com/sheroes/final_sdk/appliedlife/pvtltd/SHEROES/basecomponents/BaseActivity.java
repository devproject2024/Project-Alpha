package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.e;
import androidx.fragment.app.Fragment;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.errorview.NetworkTimeoutDialog;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragmentlistner.FragmentIntractionWithActivityListner;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.ShareBottomSheetFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, BaseHolderInterface, EventInterface, FragmentIntractionWithActivityListner {
    public static final String ANDROID_DEFAULT = "Android Default";
    public static final int BRANCH_REQUEST_CODE = 1290;
    public static final String SHARE_WHATSAPP = "Whatsapp";
    public static final String SOURCE_PROPERTIES = "SOURCE_PROPERTIES";
    public static final String SOURCE_SCREEN = "SOURCE_SCREEN";
    public boolean mIsDestroyed;
    private String mPreviousScreen;
    private HashMap<String, Object> mPreviousScreenProperties;
    public PopupWindow popupWindow;

    public void dataOperationOnClick(BaseResponse baseResponse) {
    }

    public Event getEventScreenName() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract SheroesPresenter getPresenter();

    public void handleOnClick(BaseResponse baseResponse, View view) {
    }

    public void onClick(View view) {
    }

    public void onSuccessResult(String str, FeedDetail feedDetail) {
    }

    public void setSource(String str) {
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean trackScreenTime() {
        return false;
    }

    public void userCommentLikeRequest(BaseResponse baseResponse, int i2, int i3) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.m();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            if (getIntent().getExtras().getInt(AppConstants.FROM_PUSH_NOTIFICATION, 0) == 1) {
                String string = getIntent().getExtras().getString(AppConstants.NOTIFICATION_ID, "");
                String string2 = getIntent().getExtras().getString("deep_link_url");
                boolean z = getIntent().getExtras().getBoolean(AppConstants.IS_MOENGAGE, false);
                String string3 = getIntent().getExtras().getString("title");
                if (getIntent().getExtras().getBoolean(AppConstants.IS_FROM_PUSH, false)) {
                    trackEvent(Event.PUSH_NOTIFICATION_CLICKED, new EventProperty.Builder().id(string).url(string2).isMonengage(z).title(string3).build());
                }
            }
            this.mPreviousScreen = getIntent().getStringExtra(SOURCE_SCREEN);
            this.mPreviousScreenProperties = (HashMap) getIntent().getSerializableExtra(SOURCE_PROPERTIES);
            if (getIntent().getExtras().getBoolean(AppConstants.IS_SHARE_DEEP_LINK)) {
                initShare(getIntent());
            }
        }
        if (!trackScreenTime() && shouldTrackScreen()) {
            Map<String, Object> extraPropertiesToTrack = getExtraPropertiesToTrack();
            if (!CommonUtil.isEmpty(this.mPreviousScreenProperties)) {
                extraPropertiesToTrack.putAll(this.mPreviousScreenProperties);
            }
            AnalyticsManager.trackScreenView(getEventScreenName(), getScreenName(), getPreviousScreenName(), extraPropertiesToTrack);
        }
        if (getPresenter() != null) {
            getPresenter().onCreate();
        }
    }

    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    public void onDestroy() {
        try {
            this.mIsDestroyed = true;
            super.onDestroy();
        } catch (Exception unused) {
        }
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        if (trackScreenTime()) {
            AnalyticsManager.timeScreenView(getScreenName());
        }
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    public void onPause() {
        if (trackScreenTime() && shouldTrackScreen()) {
            Map<String, Object> extraPropertiesToTrack = getExtraPropertiesToTrack();
            if (!CommonUtil.isEmpty(this.mPreviousScreenProperties)) {
                extraPropertiesToTrack.putAll(this.mPreviousScreenProperties);
            }
            AnalyticsManager.trackScreenView(getEventScreenName(), getScreenName(), getPreviousScreenName(), extraPropertiesToTrack);
        }
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.popupWindow.dismiss();
        return true;
    }

    public void onShowErrorDialog(String str, FeedParticipationEnum feedParticipationEnum) {
        if (StringUtil.isNotNullOrEmptyString(str)) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -299111350) {
                if (hashCode == 1152552230 && str.equals(AppConstants.CHECK_NETWORK_CONNECTION)) {
                    c2 = 0;
                }
            } else if (str.equals(AppConstants.MARK_AS_SPAM)) {
                c2 = 1;
            }
            if (c2 == 0) {
                showNetworkTimeoutDoalog(true, false, getString(R.string.sheroes_IDS_STR_NETWORK_TIME_OUT_DESCRIPTION));
            } else if (c2 == 1) {
                showNetworkTimeoutDoalog(true, false, str);
            } else if (AppConstants.BAD_RQUEST.contains(str)) {
                showNetworkTimeoutDoalog(true, false, getString(R.string.sheroes_ID_BAD_RQUEST));
            } else if (AppConstants.HTTP_401_UNAUTHORIZED.contains(str)) {
                showNetworkTimeoutDoalog(true, false, getString(R.string.sheroes_IDS_UN_AUTHORIZE));
            } else {
                showNetworkTimeoutDoalog(true, false, str);
            }
        } else {
            showNetworkTimeoutDoalog(true, false, getString(R.string.sheroes_ID_GENERIC_ERROR));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1290 && intent != null && intent.getExtras() != null && intent.getExtras().getBoolean(AppConstants.IS_SHARE_DEEP_LINK) && intent.getExtras().getBoolean(AppConstants.IS_SHARE_DEEP_LINK)) {
            initShare(intent);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A[SYNTHETIC, Splitter:B:11:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startActivity(android.content.Intent r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.getAction()
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r3.getDataString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            boolean r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.isBranchLink(r0)
            if (r0 == 0) goto L_0x0025
            java.lang.Class<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink> r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink.class
            r3.setClass(r2, r0)
            r0 = 1290(0x50a, float:1.808E-42)
            super.startActivityForResult(r3, r0)
            return
        L_0x0025:
            java.lang.String r0 = r3.getDataString()
            boolean r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils.matchesWebsiteURLPattern(r0)
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r3.getDataString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils.openChromeTab(r2, r0)
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 != 0) goto L_0x0042
            super.startActivity(r3)     // Catch:{ ActivityNotFoundException -> 0x0042 }
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity.startActivity(android.content.Intent):void");
    }

    private void initShare(Intent intent) {
        String string = intent.getExtras().getString(AppConstants.SHARE_TEXT);
        String string2 = intent.getExtras().getString(AppConstants.SHARE_IMAGE);
        String string3 = intent.getExtras().getString(AppConstants.SHARE_DEEP_LINK_URL);
        String string4 = intent.getExtras().getString(AppConstants.SHARE_DIALOG_TITLE);
        String string5 = intent.getExtras().getString("channel");
        Boolean bool = Boolean.FALSE;
        if (CommonUtil.isNotEmpty(string2)) {
            bool = Boolean.TRUE;
        }
        if (!CommonUtil.isNotEmpty(string5)) {
            ShareBottomSheetFragment.showDialog(this, string, string2, string3, "", bool.booleanValue(), string3, false, false, false, string4);
        } else if (string5.equalsIgnoreCase(ANDROID_DEFAULT)) {
            if (!bool.booleanValue()) {
                CommonUtil.shareCardViaSocial(this, string3);
            }
        } else if (!string5.equalsIgnoreCase(SHARE_WHATSAPP)) {
            ShareBottomSheetFragment.showDialog(this, string, string2, string3, "", bool.booleanValue(), string3, false, false, false, string4);
        } else if (!bool.booleanValue()) {
            CommonUtil.shareLinkToWhatsApp(this, string);
        }
    }

    public DialogFragment showNetworkTimeoutDoalog(boolean z, boolean z2, String str) {
        NetworkTimeoutDialog networkTimeoutDialog = (NetworkTimeoutDialog) getFragmentManager().findFragmentByTag(AppConstants.NETWORK_TIMEOUT);
        if (networkTimeoutDialog == null) {
            networkTimeoutDialog = new NetworkTimeoutDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(BaseDialogFragment.DISMISS_PARENT_ON_OK_OR_BACK, z);
            bundle.putBoolean(BaseDialogFragment.IS_CANCELABLE, z2);
            bundle.putString(BaseDialogFragment.ERROR_MESSAGE, str);
            networkTimeoutDialog.setArguments(bundle);
        }
        if (!networkTimeoutDialog.isVisible() && !networkTimeoutDialog.isAdded() && !isFinishing() && !this.mIsDestroyed) {
            networkTimeoutDialog.show(getFragmentManager(), AppConstants.NETWORK_TIMEOUT);
        }
        return networkTimeoutDialog;
    }

    public void trackEvent(Event event, Map<String, Object> map) {
        AnalyticsManager.trackEvent(event, getScreenName(), map);
    }

    public String getPreviousScreenName() {
        if (StringUtil.isNotNullOrEmptyString(this.mPreviousScreen)) {
            return this.mPreviousScreen;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getExtraPropertiesToTrack() {
        return new HashMap();
    }

    public String screenName() {
        List<Fragment> d2;
        if (!(getSupportFragmentManager() == null || CommonUtil.isEmpty(getSupportFragmentManager().f3424a.d()) || (d2 = getSupportFragmentManager().f3424a.d()) == null)) {
            for (Fragment next : d2) {
                if (next != null && next.isVisible()) {
                    return ((BaseFragment) next).getScreenName();
                }
            }
        }
        return "";
    }
}
