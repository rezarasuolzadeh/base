package ir.rezarasuolzadeh.base.di

import ir.rezarasuolzadeh.base.ui.viewmodel.HomeViewModel
import ir.rezarasuolzadeh.base.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        SplashViewModel()
    }
    viewModel {
        HomeViewModel(translateRepository = get())
    }
}