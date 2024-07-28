package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;

public interface SheroesPresenter<V extends BaseMvpView> {
    void attachView(V v);

    void detachView();

    void onAttach();

    void onCreate();

    void onDestroy();

    void onDetach();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
