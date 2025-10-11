package ir.rezarasuolzadeh.base.di

import ir.rezarasuolzadeh.base.data.repository.TranslateRepository
import ir.rezarasuolzadeh.base.data.repository.TranslateRepositoryImpl
import ir.rezarasuolzadeh.base.data.webservice.translate.KtorRemoteTranslateDataSource
import ir.rezarasuolzadeh.base.data.webservice.translate.RemoteTranslateDataSource
import org.koin.dsl.module

val WebserviceModule = module {
    single<RemoteTranslateDataSource> {
        KtorRemoteTranslateDataSource(httpClient = get())
    }
    single<TranslateRepository> {
        TranslateRepositoryImpl(remoteTranslateDatasource = get())
    }
}