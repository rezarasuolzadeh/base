package ir.rezarasuolzadeh.translator.di

import ir.rezarasuolzadeh.translator.data.repository.TranslateRepository
import ir.rezarasuolzadeh.translator.data.repository.TranslateRepositoryImpl
import ir.rezarasuolzadeh.translator.data.webservice.translate.KtorRemoteTranslateDataSource
import ir.rezarasuolzadeh.translator.data.webservice.translate.RemoteTranslateDataSource
import org.koin.dsl.module

val WebserviceModule = module {
    single<RemoteTranslateDataSource> {
        KtorRemoteTranslateDataSource(httpClient = get())
    }
    single<TranslateRepository> {
        TranslateRepositoryImpl(remoteTranslateDatasource = get())
    }
}