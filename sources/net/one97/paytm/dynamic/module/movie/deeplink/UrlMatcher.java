package net.one97.paytm.dynamic.module.movie.deeplink;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.l;

public final class UrlMatcher {
    private final String URL_FORMAT_MATCH_REGEX = "(?:\\\\.\\([\\\\w%]+?\\))?";
    private final String URL_FORMAT_REGEX = "(?:\\.\\{format\\})$";
    private final String URL_PARAM_MATCH_REGEX = "\\([%\\\\w-.\\\\~!\\$&'\\\\(\\\\)\\\\*\\\\+,;=:\\\\[\\\\]@]+?\\)";
    private final Pattern URL_PARAM_PATTERN = Pattern.compile(this.URL_PARAM_REGEX);
    private final String URL_PARAM_REGEX = "\\{(\\w*?)\\}";
    private final String URL_QUERY_STRING_REGEX = "(?:\\?.*?)?$";
    private Pattern compiledUrl;
    private final List<String> pathParameterNames = new ArrayList();
    private HashMap<String, String> pathParameters = new HashMap<>();
    private HashMap<String, String> queryParams = new HashMap<>();
    private String urlPattern;

    public UrlMatcher(String str) {
        k.c(str, "pattern");
        setUrlPattern(str);
        compile();
    }

    public final List<String> getPathParameterNames() {
        return this.pathParameterNames;
    }

    public final HashMap<String, String> getPathParameters() {
        return this.pathParameters;
    }

    public final HashMap<String, String> getQueryParams() {
        return this.queryParams;
    }

    public final String getPattern() {
        String str = this.urlPattern;
        if (str == null) {
            k.a("urlPattern");
        }
        return new l(this.URL_FORMAT_REGEX).replaceFirst(str, "");
    }

    public final List<String> parameterNames() {
        return Collections.unmodifiableList(this.pathParameterNames);
    }

    public final boolean match(String str) {
        Pattern pattern = this.compiledUrl;
        Matcher matcher = pattern != null ? pattern.matcher(str) : null;
        if (matcher == null || !matcher.matches()) {
            return false;
        }
        this.pathParameters = extractPathParameters(matcher);
        this.queryParams = extractQueryParams(str);
        return true;
    }

    public final String getPathParam(String str) {
        k.c(str, "name");
        return this.pathParameters.get(str);
    }

    public final String getQueryParam(String str) {
        k.c(str, "name");
        return this.queryParams.get(str);
    }

    private final void compile() {
        acquireParameterNames();
        String str = this.urlPattern;
        if (str == null) {
            k.a("urlPattern");
        }
        l lVar = new l(this.URL_FORMAT_REGEX);
        String replace = new l(this.URL_PARAM_REGEX).replace((CharSequence) lVar.replaceFirst(str, this.URL_FORMAT_MATCH_REGEX), this.URL_PARAM_MATCH_REGEX);
        this.compiledUrl = Pattern.compile(replace + this.URL_QUERY_STRING_REGEX);
    }

    private final void setUrlPattern(String str) {
        this.urlPattern = str;
    }

    private final void acquireParameterNames() {
        Pattern pattern = this.URL_PARAM_PATTERN;
        String str = this.urlPattern;
        if (str == null) {
            k.a("urlPattern");
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            List<String> list = this.pathParameterNames;
            String group = matcher.group(1);
            k.a((Object) group, "m.group(1)");
            list.add(group);
        }
    }

    private final HashMap<String, String> extractPathParameters(Matcher matcher) {
        HashMap<String, String> hashMap = new HashMap<>();
        int groupCount = matcher.groupCount();
        int i2 = 0;
        while (i2 < groupCount) {
            int i3 = i2 + 1;
            String group = matcher.group(i3);
            if (group != null) {
                hashMap.put(this.pathParameterNames.get(i2), group);
            }
            i2 = i3;
        }
        return hashMap;
    }

    private final HashMap<String, String> extractQueryParams(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Uri parse = Uri.parse(str);
            k.a((Object) parse, "uri");
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            k.a((Object) queryParameterNames, "uri.queryParameterNames");
            for (String str2 : queryParameterNames) {
                String queryParameter = parse.getQueryParameter(str2);
                if (queryParameter != null) {
                    k.a((Object) str2, "key");
                    k.a((Object) queryParameter, "value");
                    hashMap.put(str2, queryParameter);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
