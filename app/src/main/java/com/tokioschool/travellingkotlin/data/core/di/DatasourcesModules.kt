package com.tokioschool.travellingkotlin.data.core.di

import com.tokioschool.travellingkotlin.data.datasource.HotelsDatasource
import com.tokioschool.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlin.data.datasource.WeatherDatasource
import com.tokioschool.travellingkotlin.data.datasource.impl.HotelsDatasourceImpl
import com.tokioschool.travellingkotlin.data.datasource.impl.LoginDatasourceImpl
import com.tokioschool.travellingkotlin.data.datasource.impl.WeatherDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourcesModules {
    @Binds
    abstract fun bindingLoginDataSource(loginDatasourceImpl: LoginDatasourceImpl): LoginDatasource

    @Binds
    abstract fun bindingHotelsDataSource(impl: HotelsDatasourceImpl): HotelsDatasource

    @Binds
    abstract fun bindingWeatherDataSource(impl: WeatherDatasourceImpl): WeatherDatasource
}