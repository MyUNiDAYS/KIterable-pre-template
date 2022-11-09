package com.myunidays.kiterable

interface IterableUrlHandler {
    fun handleIterableURL(uri: String, actionContext: IterableActionContext): Boolean
}
