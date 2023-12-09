package com.whitedevils24.minimalnotes.domain.usecases

import com.whitedevils24.minimalnotes.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

}