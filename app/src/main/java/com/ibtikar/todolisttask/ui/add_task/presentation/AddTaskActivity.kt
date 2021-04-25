package com.ibtikar.todolisttask.ui.add_task.presentation

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ibtikar.todolisttask.databinding.ActivityAddTaskBinding
import com.ibtikar.todolisttask.ui.TodoApplication
import com.ibtikar.todolisttask.ui.base.data.Status
import com.ibtikar.todolisttask.ui.base.presentation.BaseActivity
import com.ibtikar.todolisttask.utils.date.DatePickerUtil
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_tasks.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import wtf.qase.datetimepicker.DateTimePickerDialog
import java.util.*
import javax.inject.Inject

class AddTaskActivity : BaseActivity<ActivityAddTaskBinding>() {

    @Inject
    lateinit var addTaskViewModelProvider: AddTaskViewModelProvider
    private val addTaskViewModel by viewModels<AddTaskViewModel> {
        addTaskViewModelProvider
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddTaskActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityAddTaskBinding
        get() = ActivityAddTaskBinding::inflate

    override fun initDependencyInjection() {
        (application as TodoApplication).appComponent
            .getAddTaskComponentFactory()
            .create()
            .inject(this)
    }

    override fun setup() {
        setListeners()
    }

    private fun setListeners() {
        binding.btnSave.setOnClickListener {
            runBlocking {
                addTaskViewModel.saveTask(
                    binding.etToDoTitle.text.toString().trim(),
                    binding.etToDoDescription.text.toString().trim()
                )
            }

            finish()
        }

        val callback: (date: Date) -> Unit = { newDate ->
            addTaskViewModel.onDateSelected(date = newDate)
            val sdf = SimpleDateFormat("dd.MM.yyyy - HH:mm", Locale.getDefault())
            binding.etSelectDate.setText(sdf.format(newDate))
        }

        binding.etSelectDate.setOnClickListener{
            DateTimePickerDialog.show(
                supportFragmentManager,
                "fragment_datepicker",              //tag for fragment manager
                callback,                           //calback with selected date
                Date(),                             //current date
                DateTimePickerDialog.TIME_DATE //choose one - DATE_TIME, TIME_ONLY, DATE_ONLY, TIME_DATE
            )
        }
    }
}
