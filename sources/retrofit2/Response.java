package retrofit2;

import com.appsflyer.internal.referrer.Payload;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

public final class Response<T> {
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public static <T> Response<T> success(T t) {
        return success(t, new Response.Builder().code(200).message(Payload.RESPONSE_OK).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(int i2, T t) {
        if (i2 >= 200 && i2 < 300) {
            return success(t, new Response.Builder().code(i2).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: ".concat(String.valueOf(i2)));
    }

    public static <T> Response<T> success(T t, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return success(t, new Response.Builder().code(200).message(Payload.RESPONSE_OK).protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> error(int i2, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i2 >= 400) {
            return error(responseBody, new Response.Builder().body(new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: ".concat(String.valueOf(i2)));
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public final okhttp3.Response raw() {
        return this.rawResponse;
    }

    public final int code() {
        return this.rawResponse.code();
    }

    public final String message() {
        return this.rawResponse.message();
    }

    public final Headers headers() {
        return this.rawResponse.headers();
    }

    public final boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public final T body() {
        return this.body;
    }

    public final ResponseBody errorBody() {
        return this.errorBody;
    }

    public final String toString() {
        return this.rawResponse.toString();
    }
}
