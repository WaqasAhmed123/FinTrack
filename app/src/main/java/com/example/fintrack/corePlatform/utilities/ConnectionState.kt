package com.example.fintrack.corePlatform.utilities

sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}