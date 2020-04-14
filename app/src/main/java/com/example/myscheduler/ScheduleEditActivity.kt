package com.example.myscheduler

import android.graphics.Color
import android.text.format.DateFormat
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.*
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_schedule_edit.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.widget.TextView




class ScheduleEditActivity : AppCompatActivity() {

    private  lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_edit)

        realm = Realm.getDefaultInstance()


        val scheduleId = intent?.getLongExtra("schedule_id", -1L)

        if (scheduleId != -1L){
            val schedule = realm.where<Schedule>().equalTo("id", scheduleId ).findFirst()
            dateEdit.setText(DateFormat.format("yyyy/MM/dd", schedule?.date))
            titkeEdit.setText(schedule?.title)
            detailEdit.setText(schedule?.detail)
            delete.visibility = View.VISIBLE
        } else {
            delete.visibility = View.INVISIBLE
        }



        // 保存ボタン
        save.setOnClickListener { view: View ->

            when (scheduleId) {

                -1L -> {
                    realm.executeTransaction { db: Realm ->
                        val maxId = db.where<Schedule>().max("id")
                        val nextId = (maxId?.toLong() ?: 0L) + 1
                        val schedule = db.createObject<Schedule>(nextId)
                        val date = dateEdit.text.toString().toDate("yyyy/MM/dd")
                        if (date != null) schedule.date = date
                        schedule.title = titkeEdit.text.toString()
                        schedule.detail = detailEdit.text.toString()
                    }

                    make (view, "追加しました", LENGTH_SHORT)
                        .setAction("戻る") { finish() }
                        .setActionTextColor(Color.YELLOW)
                        .show()
                }
               else -> {
                    realm.executeTransaction { db: Realm ->
                        val schedule = db.where<Schedule>().equalTo("id", scheduleId).findFirst()
                        val date = dateEdit.text.toString().toDate("yyyy/MM/dd")
                        if (date != null) schedule?.date = date
                        schedule?.title = titkeEdit.text.toString()
                        schedule?.detail = detailEdit.text.toString()
                    }

                    make (view, "修正しました", LENGTH_SHORT)
                        .setAction("戻る") { finish() }
                        .setActionTextColor(Color.YELLOW)
                        .show()
                }

            }
        }

        // 削除ボタン
        delete.setOnClickListener { view: View ->
            realm.executeTransaction { db: Realm ->
                db.where<Schedule>().equalTo("id", scheduleId)
                    ?.findFirst()
                    ?.deleteFromRealm()
            }
            make(view,"削除しました", LENGTH_SHORT)
                .setAction("戻る") { finish() }
                .setActionTextColor(Color.YELLOW)
                .show()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun String.toDate(pattern: String = "yyyy/MM/dd HH:mm"): Date? {
        return try {
            SimpleDateFormat(pattern).parse(this)
        } catch (e: IllegalArgumentException) {
            return null
        } catch (e: ParseException) {
            return null
        }
    }
}
