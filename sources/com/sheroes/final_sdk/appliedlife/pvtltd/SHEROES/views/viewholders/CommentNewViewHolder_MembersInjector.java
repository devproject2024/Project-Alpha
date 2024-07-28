package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import dagger.a;

public final class CommentNewViewHolder_MembersInjector implements a<CommentNewViewHolder> {
    private final javax.a.a<DateUtil> mDateUtilProvider;
    private final javax.a.a<Preference<LoginResponse>> userPreferenceProvider;

    public CommentNewViewHolder_MembersInjector(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2) {
        this.mDateUtilProvider = aVar;
        this.userPreferenceProvider = aVar2;
    }

    public static a<CommentNewViewHolder> create(javax.a.a<DateUtil> aVar, javax.a.a<Preference<LoginResponse>> aVar2) {
        return new CommentNewViewHolder_MembersInjector(aVar, aVar2);
    }

    public final void injectMembers(CommentNewViewHolder commentNewViewHolder) {
        injectMDateUtil(commentNewViewHolder, this.mDateUtilProvider.get());
        injectUserPreference(commentNewViewHolder, this.userPreferenceProvider.get());
    }

    public static void injectMDateUtil(CommentNewViewHolder commentNewViewHolder, DateUtil dateUtil) {
        commentNewViewHolder.mDateUtil = dateUtil;
    }

    public static void injectUserPreference(CommentNewViewHolder commentNewViewHolder, Preference<LoginResponse> preference) {
        commentNewViewHolder.userPreference = preference;
    }
}
