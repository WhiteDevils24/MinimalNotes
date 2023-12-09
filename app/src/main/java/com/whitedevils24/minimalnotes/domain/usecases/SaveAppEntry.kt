package com.whitedevils24.minimalnotes.domain.usecases

import com.whitedevils24.minimalnotes.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}