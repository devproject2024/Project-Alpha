package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils;

import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.util.Linkify;
import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Charsets;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final int EOF = -1;
    private static final String TAG = StringUtil.class.getName();

    public static boolean isNotNullOrEmptyString(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean isNotEmptyCollection(Collection collection) {
        return collection != null && collection.size() > 0;
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        return copyLarge(reader, writer, new char[4096]);
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static void copy(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.toCharset(charset));
        copy(inputStreamReader, writer);
        inputStreamReader.close();
    }

    public static void linkifyURLs(TextView textView) {
        Linkify.addLinks(textView, Pattern.compile("\\b(https?|Https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", 40), "", (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static SpannableString hashTagColorInString(String str) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#([A-Za-z0-9_-]+)").matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 18);
        }
        return spannableString;
    }

    public static SpannableString hashTagColorInString(Spannable spannable) {
        SpannableString spannableString = new SpannableString(spannable);
        Matcher matcher = Pattern.compile("#([A-Za-z0-9_-]+)").matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new StyleSpan(1), matcher.start(), matcher.end(), 18);
        }
        return spannableString;
    }

    public static String numericToThousand(int i2) {
        if (i2 <= 999) {
            return String.valueOf(i2);
        }
        return (i2 / 1000) + AppConstants.THOUSANDS;
    }

    public static String toString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        copy(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, Charset.defaultCharset());
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.toLowerCase().equals(str2.toLowerCase());
    }

    private StringUtil() {
    }

    public static Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }
}
