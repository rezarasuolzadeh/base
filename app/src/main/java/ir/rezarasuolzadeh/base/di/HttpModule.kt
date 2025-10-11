package ir.rezarasuolzadeh.base.di

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import ir.rezarasuolzadeh.base.data.constant.BASE_URL
import ir.rezarasuolzadeh.base.data.network.HttpClientFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val HttpModule = module {
    single {
        HttpClientFactory.create(engine = get())
    }

    single<HttpClientEngine> {
        OkHttp.create {
            preconfigured = get<OkHttpClient>()
        }
    }

    single<OkHttpClient> {
        val chuckerCollector = ChuckerCollector(
            context = get(),
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
        OkHttpClient.Builder()
            .addInterceptor(
                interceptor = ChuckerInterceptor
                    .Builder(context = get())
                    .collector(chuckerCollector)
                    .maxContentLength(length = 250_000L)
                    .redactHeaders("Auth-Token","Bearer")
                    .alwaysReadResponseBody(enable = true)
                    .build()
            )
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(name = "token", value = "BS45DUF672763V23X23XB5R752X2X")
                    .build()
                chain.proceed(newRequest)
            }
            .connectTimeout(timeout = 30, unit = TimeUnit.SECONDS)
            .writeTimeout(timeout = 30, unit = TimeUnit.SECONDS)
            .readTimeout(timeout = 30, unit = TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single {
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}