package co.develhope.meteoapp.di

import androidx.lifecycle.ViewModelProvider
import co.develhope.meteoapp.network.SearchService
import co.develhope.meteoapp.network.WeatherService
import co.develhope.meteoapp.ui.home.HomeScreenFragment
import co.develhope.meteoapp.ui.home.HomeScreenViewModel
import co.develhope.meteoapp.ui.search.SearchScreenFragment
import co.develhope.meteoapp.ui.search.SearchViewModel
import co.develhope.meteoapp.ui.today.DailyViewModel
import co.develhope.meteoapp.ui.today.TodayScreenFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
object DailyViewModelModule {
    @Provides
    fun provideTodayViewModel(fragment: TodayScreenFragment): DailyViewModel {
        return ViewModelProvider(fragment)[DailyViewModel::class.java]
    }
}

@Module
@InstallIn(ActivityComponent::class)
object HomeScreenViewModelModule {
    @Provides
    fun provideHomeViewModel(fragment: HomeScreenFragment): HomeScreenViewModel {
        return ViewModelProvider(fragment)[HomeScreenViewModel::class.java]
    }
}

@Module
@InstallIn(ActivityComponent::class)
object SearchViewModelModule {
    @Provides
    fun provideSearchViewModel(fragment: SearchScreenFragment): SearchViewModel {
        return ViewModelProvider(fragment)[SearchViewModel::class.java]
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideSearchService(): SearchService{
        return co.develhope.meteoapp.network.Module().getSearchRetrofit().create(SearchService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object WeatherServiceModule{
    @Provides
    fun provideWeatherService(): WeatherService{
        return co.develhope.meteoapp.network.Module().getRetrofit().create(WeatherService::class.java)
    }
}