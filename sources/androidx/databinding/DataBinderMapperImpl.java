package androidx.databinding;

import net.one97.paytm.dynamic.module.movie.BuildConfig;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper((d) new net.one97.paytm.DataBinderMapperImpl());
        addMapper(BuildConfig.APPLICATION_ID);
        addMapper(net.one97.paytm.finance.BuildConfig.APPLICATION_ID);
        addMapper("com.paytm.dynamic.flight");
        addMapper(net.one97.paytm.dynamic.module.feed.BuildConfig.APPLICATION_ID);
        addMapper(net.one97.paytm.dynamic.module.BuildConfig.APPLICATION_ID);
    }
}
