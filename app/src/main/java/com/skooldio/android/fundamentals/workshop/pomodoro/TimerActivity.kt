package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    private val binding: ActivityTimerBinding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }
//    private var workDuration: Int = 0
//    private var shortBreakDuration: Int = 0
//    private var longBreakDuration: Int = 0
    private var config: Config? = null

    companion object {
        private const val EXTRA_CONFIG = "config"
        fun newIntent(
            context: Context,
            config: Config,
        ) : Intent {
            return Intent(context, TimerActivity::class.java).apply {
                putExtra(EXTRA_CONFIG, config)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        restoreBundle()

    }

    private fun restoreBundle() {
        // WARNING: use of deprecated method
        config = intent.getParcelableExtra(EXTRA_CONFIG)
        Log.d("comsci", "config: $config")
    }
}