package com.whitedevils24.minimalnotes.dependencyinjection

import android.app.Application
import com.whitedevils24.minimalnotes.data.manager.LocalUserManagerImplementation
import com.whitedevils24.minimalnotes.domain.manager.LocalUserManager
import com.whitedevils24.minimalnotes.domain.usecases.AppEntryUseCases
import com.whitedevils24.minimalnotes.domain.usecases.ReadAppEntry
import com.whitedevils24.minimalnotes.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}