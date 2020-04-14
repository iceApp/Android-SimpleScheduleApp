package com.example.myscheduler

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter


class ScheduleAdapter(data: OrderedRealmCollection<Schedule>) : RealmRecyclerViewAdapter<Schedule, ScheduleAdapter.ViewHolder>(data, true) {

    private var listener: ((Long?) -> Unit)? = null

    // 不変なID使用設定
    init {
        setHasStableIds(true)
    }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell) {
        val date: TextView = cell.findViewById(android.R.id.text1)
        val title: TextView = cell.findViewById(android.R.id.text2)
        }

        // セルが必要になるたびに呼び出される　ViewHolderインスタンスの作成 セルのレイアウト設定
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(android.R.layout.simple_expandable_list_item_2, parent, false)
            return ViewHolder(view)
        }

        // セル毎の値設定、クリック設定
        override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
            val schedule: Schedule? = getItem(position)
            holder.date.text = DateFormat.format("YYYY/MM/dd", schedule?.date)
            holder.title.text = schedule?.title
            holder.itemView.setOnClickListener {
                listener?.invoke(schedule?.id) // 関数に引数を渡して実行する
            }
        }

        override fun getItemId(position: Int): Long {
            return getItem(position)?.id ?: 0
        }

        fun setOnItemClickListener(listener: (Long?) -> Unit) {
            this.listener = listener
        }

    }
