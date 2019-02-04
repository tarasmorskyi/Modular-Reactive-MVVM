package com.tarasmorskyi.myapplication.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.tarasmorskyi.dataModel.Constants
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepositoryImpl
import com.tarasmorskyi.localstorage.Storage
import com.tarasmorskyi.myapplication.BuildConfig
import com.tarasmorskyi.myapplication.utils.MoshiDateAdapter
import com.tarasmorskyi.myapplication.utils.MyAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(StorageModule::class))
class DomainToolsModule {
    @Provides
    @Singleton
    internal fun okHttpClient(storage: Storage): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(StethoInterceptor())
        }

        val token =
            storage[LocalRepositoryImpl.USER, UserAuthenticationData::class.java, UserAuthenticationData()]?.accessToken
                ?: Constants.EMPTY_STRING
        if (!token.isBlank()) {
            builder.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(
                        "Authorization", "Bearer " + token
                    ).build()
                chain.proceed(request)
            }
        } else {
            builder.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(
                        "Authorization", "Client-ID 9a9f8a8c12cb9ce"
                    ).build()
                chain.proceed(request)
            }
        }
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideRestAdapter(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        builder.baseUrl(BuildConfig.SERVER)
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideDefaultMoshiBuilder(): Moshi.Builder {
        return Moshi.Builder()
            .add(MoshiDateAdapter())
            .add(MyAdapterFactory.create())
            .add(Wrapped.ADAPTER_FACTORY)
    }

    @Provides
    @Singleton
    internal fun provideMoshi(moshiBuilder: Moshi.Builder): Moshi {
        return moshiBuilder.build()
    }
}