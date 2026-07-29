package com.vocationalsubject.skillsubai.chat

import com.vocationalsubject.skillsubai.network.ChatRequest
import com.vocationalsubject.skillsubai.network.ChatService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatService: ChatService
) {
    suspend fun sendMessage(message: String): String {
        return try {
            val response = chatService.sendMessage(ChatRequest(message))
            response.reply
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}
