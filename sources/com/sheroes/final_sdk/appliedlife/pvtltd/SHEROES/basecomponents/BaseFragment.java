package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragmentlistner.FragmentIntractionWithActivityListner;
import java.util.Map;

public abstract class BaseFragment extends Fragment implements View.OnClickListener, BaseMvpView, EventInterface {
    private final String TAG = BaseFragment.class.getName();
    public FragmentActivity mActivity;
    public FragmentIntractionWithActivityListner mHomeSearchActivityFragmentIntractionWithActivityListner;
    private ProgressBar mProgressBar;
    Preference<LoginResponse> userPreference;

    public Event getEventScreenName() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getExtraProperties() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract SheroesPresenter getPresenter();

    public void onClick(View view) {
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean trackScreenTime() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getPresenter() != null) {
            getPresenter().onCreate();
        }
        e.m();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            this.mActivity = getActivity();
        }
        try {
            if (this.mActivity instanceof FragmentIntractionWithActivityListner) {
                this.mHomeSearchActivityFragmentIntractionWithActivityListner = (FragmentIntractionWithActivityListner) getActivity();
            }
        } catch (Fragment.b e2) {
            String str = this.TAG;
            Bamboo.e(str, "Exception while implement listner with in : " + this.TAG + " " + e2.getMessage());
        }
        if (getPresenter() != null) {
            getPresenter().onAttach();
        }
    }

    public void startProgressBar() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.mProgressBar.bringToFront();
        }
    }

    public void stopProgressBar() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void showError(String str, FeedParticipationEnum feedParticipationEnum) {
        this.mHomeSearchActivityFragmentIntractionWithActivityListner.onShowErrorDialog(str, feedParticipationEnum);
    }

    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    public void onDetach() {
        super.onDetach();
        if (getPresenter() != null) {
            getPresenter().onDetach();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && shouldTrackScreen()) {
            AnalyticsManager.trackScreenView(getEventScreenName(), getScreenName(), getExtraProperties());
        }
    }

    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    public void trackEvent(Event event, Map<String, Object> map) {
        AnalyticsManager.trackEvent(event, getScreenName(), map);
    }
}
