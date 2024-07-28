package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import androidx.fragment.app.Fragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.trello.rxlifecycle4.android.b;
import com.trello.rxlifecycle4.android.c;
import com.trello.rxlifecycle4.d;
import io.reactivex.rxjava3.j.a;

public class BasePresenter<T extends BaseMvpView> implements SheroesPresenter<T> {
    private a<b> lifecycleFragmentSubject = null;
    private a<com.trello.rxlifecycle4.android.a> lifecycleSubject = null;
    private T mMvpView;

    public void detachView() {
    }

    public final <T> com.trello.rxlifecycle4.b<T> bindToLifecycle() {
        a<com.trello.rxlifecycle4.android.a> aVar = this.lifecycleSubject;
        return aVar != null ? c.a(aVar) : c.b(this.lifecycleFragmentSubject);
    }

    public final <T> com.trello.rxlifecycle4.b<T> bindUntilDestroy() {
        return d.a(this.lifecycleSubject, com.trello.rxlifecycle4.android.a.DESTROY);
    }

    public final <T> com.trello.rxlifecycle4.b<T> bindUntilStop() {
        return d.a(this.lifecycleSubject, com.trello.rxlifecycle4.android.a.STOP);
    }

    public final <T> com.trello.rxlifecycle4.b<T> bindUntilPause() {
        return d.a(this.lifecycleSubject, com.trello.rxlifecycle4.android.a.PAUSE);
    }

    public void onCreate() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.CREATE, b.CREATE);
    }

    private void sendLifecycleEvent(com.trello.rxlifecycle4.android.a aVar, b bVar) {
        a<com.trello.rxlifecycle4.android.a> aVar2 = this.lifecycleSubject;
        if (aVar2 != null) {
            aVar2.onNext(aVar);
            return;
        }
        a<b> aVar3 = this.lifecycleFragmentSubject;
        if (aVar3 != null) {
            aVar3.onNext(bVar);
        }
    }

    public void onDestroy() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.DESTROY, b.DESTROY);
    }

    public void onStart() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.START, b.START);
    }

    public void onStop() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.STOP, b.STOP);
    }

    public void onPause() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.PAUSE, b.PAUSE);
    }

    public void onResume() {
        sendLifecycleEvent(com.trello.rxlifecycle4.android.a.RESUME, b.RESUME);
    }

    public void onAttach() {
        sendLifecycleEvent((com.trello.rxlifecycle4.android.a) null, b.ATTACH);
    }

    public void onDetach() {
        sendLifecycleEvent((com.trello.rxlifecycle4.android.a) null, b.DETACH);
    }

    public void attachView(T t) {
        this.mMvpView = t;
        if (this.mMvpView instanceof Fragment) {
            this.lifecycleFragmentSubject = a.a();
            onCreate();
            onAttach();
            return;
        }
        this.lifecycleSubject = a.a();
        onCreate();
    }

    public boolean isViewAttached() {
        return this.mMvpView != null;
    }

    public T getMvpView() {
        return this.mMvpView;
    }
}
