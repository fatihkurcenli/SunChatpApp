package com.autumnsun.sunchatapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.autumnsun.sunchatapp.data.repository.ChatAppImpl
import com.autumnsun.sunchatapp.domain.repository.ChatRepository
import com.autumnsun.sunchatapp.domain.usecase.SignUpCase
import com.autumnsun.sunchatapp.domain.usecase.SunChatAppCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
 Created by Fatih Kurcenli on 1/2/2022
*/


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseDb(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideChatRepository(
        db: FirebaseDatabase,
        auth: FirebaseAuth
    ): ChatRepository {
        return ChatAppImpl(db, auth)
    }

    @Provides
    @Singleton
    fun provideSunChatAppCase(
        chatRepository: ChatRepository
    ): SunChatAppCase {
        return SunChatAppCase(
            signUpCase = SignUpCase(chatRepository)
        )
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        preferencesDataStore(name = "data-store").getValue(context, String::javaClass)
}