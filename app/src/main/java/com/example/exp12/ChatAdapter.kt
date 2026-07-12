package com.example.exp12

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    private var messages: List<Message> = emptyList()

    fun submitList(newMessages: List<Message>) {
        messages = newMessages
        notifyDataSetChanged()
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageText: TextView = view.findViewById(R.id.messageText)
        val container: LinearLayout = view as LinearLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.messageText.text = message.text

        val layoutParams = holder.messageText.layoutParams as LinearLayout.LayoutParams
        if (message.isSent) {
            holder.container.gravity = Gravity.END
            holder.messageText.setBackgroundResource(android.R.drawable.edit_text)
            holder.messageText.setTextColor(android.graphics.Color.BLACK)
        } else {
            holder.container.gravity = Gravity.START
            holder.messageText.setBackgroundResource(android.R.drawable.toast_frame)
            holder.messageText.setTextColor(android.graphics.Color.BLACK)
        }
        holder.messageText.layoutParams = layoutParams
    }

    override fun getItemCount() = messages.size
}