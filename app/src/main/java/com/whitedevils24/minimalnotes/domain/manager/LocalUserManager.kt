package com.whitedevils24.minimalnotes.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

   suspend fun saveAppEntry()

   fun readAppEntry() : Flow<Boolean>
}