package com.bear.testtdd

import android.content.Context
import android.content.SharedPreferences
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*

class RepositoryTest {
    @Test
    fun saveUserId() {
        val userId="abc123"
        val preKey="account"
//        val sharedPreferences=mock(SharedPreferences::class.java)
//        val sharedPreferencesEditor=mock(SharedPreferences.Editor::class.java)
//        val context=mock(Context::class.java)
//        `when` (context.getSharedPreferences(anyString(),anyInt())).thenReturn(sharedPreferences)
//        `when` (sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
//        `when` (sharedPreferencesEditor.putString(anyString(), anyString())).thenReturn(sharedPreferencesEditor)

//        val repository=Repository(context)
//        repository.saveUserId(userId)
//        verify(sharedPreferencesEditor).putString(preKey,userId)
//        verify(sharedPreferencesEditor).apply()
        val sharePreferenceManager=mock(SharePreferenceManager::class.java)
        val repository=Repository(sharePreferenceManager)
        repository.saveUserId(userId)
        verify(sharePreferenceManager).saveString(preKey,userId)
    }
}