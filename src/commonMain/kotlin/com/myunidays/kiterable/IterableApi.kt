package com.myunidays.kiterable

expect class IterableApi {

    companion object {

        fun initialize(config: Configuration): IterableApi

        fun getInstance(): IterableApi
        fun shared(): IterableApi
    }
    fun setUserId(userId: String?)
    fun getPayloadData(): PayloadData?
    fun getPayloadData(key: String): String?
    fun getInAppManager(): IterableInAppManager
    fun getMessages(): List<IterableInAppMessage>
    fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableUrlCallback)
    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler?)
}
