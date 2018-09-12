package co.windly.rename.data.network;

import android.support.annotation.NonNull;
import co.windly.rename.data.network.service.BooksApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static co.windly.rename.utility.BuildConfig.SERVER_CONNECTION_TIMEOUT;
import static co.windly.rename.utility.BuildConfig.SERVER_LOGGING_LEVEL;
import static co.windly.rename.utility.BuildConfig.SERVER_READ_TIMEOUT;
import static co.windly.rename.utility.BuildConfig.SERVER_URL;
import static co.windly.rename.utility.BuildConfig.SERVER_WRITE_TIMEOUT;
import static java.util.concurrent.TimeUnit.SECONDS;

@Module
public class NetworkModule {

  //region Constructor

  public NetworkModule() {
    // No-op.
  }

  //endregion

  //region Api

  @Provides
  @NonNull
  BooksApi provideBooksApi(Retrofit retrofit) {
    return retrofit.create(BooksApi.class);
  }

  //endregion

  //region Retrofit

  @Provides
  @NonNull
  Retrofit provideServerRetrofit(Retrofit.Builder builder, String url) {
    return builder
      .baseUrl(url)
      .build();
  }

  @Provides
  @NonNull
  String provideServerUrl() {
    return SERVER_URL;
  }

  //endregion

  //region Retrofit - Builder

  @Provides
  @NonNull
  Retrofit.Builder provideRetrofitBuilder(
    OkHttpClient client,
    Converter.Factory converterFactory,
    CallAdapter.Factory callAdapterFactory) {
    return new Retrofit.Builder()
      .addConverterFactory(converterFactory)
      .addCallAdapterFactory(callAdapterFactory)
      .client(client);
  }

  //endregion

  //region Retrofit - Factories

  @Provides
  @NonNull
  Converter.Factory provideConverterFactory() {
    return JacksonConverterFactory.create();
  }

  @Provides
  @NonNull
  CallAdapter.Factory provideCallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  //endregion

  //region Retrofit - Http

  @Provides
  @NonNull
  OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
    return builder
      .build();
  }

  @Provides
  @NonNull
  OkHttpClient.Builder provideOkHttpClientBuilder(HttpLoggingInterceptor.Level networkLogLevel) {
    return new OkHttpClient.Builder()
      .connectTimeout(SERVER_CONNECTION_TIMEOUT, SECONDS)
      .readTimeout(SERVER_READ_TIMEOUT, SECONDS)
      .writeTimeout(SERVER_WRITE_TIMEOUT, SECONDS)
      .addInterceptor(new HttpLoggingInterceptor().setLevel(networkLogLevel));
  }

  @Provides
  @NonNull
  HttpLoggingInterceptor.Level provideLogLevel() {
    return HttpLoggingInterceptor.Level.valueOf(SERVER_LOGGING_LEVEL.trim().toUpperCase());
  }

  //endregion
}
