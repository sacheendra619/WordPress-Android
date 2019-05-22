package org.wordpress.android.modules

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import org.wordpress.android.fluxc.module.DebugOkHttpClientModule
import org.wordpress.android.fluxc.module.ReleaseBaseModule
import org.wordpress.android.fluxc.module.ReleaseNetworkModule
import org.wordpress.android.fluxc.module.ReleaseToolsModule
import org.wordpress.android.login.di.LoginFragmentModule
import org.wordpress.android.login.di.LoginServiceModule
import org.wordpress.android.ui.stats.refresh.StatsModule
import org.wordpress.android.util.UploadWorkRequestTest
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AppConfigModule::class,
    ReleaseBaseModule::class,
    DebugOkHttpClientModule::class,
    InterceptorModuleTest::class,
    ReleaseNetworkModule::class,
    LegacyModule::class,
    ReleaseToolsModule::class,
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    StatsModule::class,
    SupportModule::class,
    ThreadModule::class,
    // Mocked UploadStarter module
    MockedUploadStarterModule::class,
    // Login flow library
    LoginAnalyticsModule::class,
    LoginFragmentModule::class,
    LoginServiceModule::class])
interface MockedUploadAppComponent : AppComponent {
    @Component.Builder
    interface Builder : AppComponent.Builder {
        @BindsInstance
        override fun application(application: Application): MockedUploadAppComponent.Builder

        override fun build(): MockedUploadAppComponent
    }

    fun inject(o: UploadWorkRequestTest)
}