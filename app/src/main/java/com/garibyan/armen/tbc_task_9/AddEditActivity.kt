package com.garibyan.armen.tbc_task_9

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.garibyan.armen.tbc_task_9.databinding.ActivityAddEditBinding

class AddEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding
    private var isEding: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        binding.btnAdd.setOnClickListener {
            checkEdding()
        }
    }

    private fun init() {
        isEding = intent.getBooleanExtra(Const.IS_EDING, false)
        if (isEding) {
            binding.edtEmail.visibility = View.GONE
            binding.tvTitle.setText(R.string.edit_user)
            binding.btnAdd.setImageResource(R.drawable.ic_baseline_edit_24)
            getUserUnfo()
        }
    }

    private fun addUser() = with(binding) {
        if (!isEmptyField() && isEmailValid(edtEmail.text.toString()) && !emailexists()) {
            val user = User(
                edtName.text.toString(),
                edtSurname.text.toString(),
                edtEmail.text.toString()
            )

            setResult(RESULT_OK, Intent().putExtra(Const.ADD_USER, user))
            Toast.makeText(
                this@AddEditActivity,
                R.string.user_successfully_added,
                Toast.LENGTH_SHORT
            ).show()
            finish()
        } else
            Toast.makeText(this@AddEditActivity, R.string.incorrect_input, Toast.LENGTH_SHORT)
                .show()
    }

    private fun getUserUnfo() = with(binding) {
        val userIndex = intent.getIntExtra(Const.USER_INFO_BY_INDEX, 0)

        edtName.setText(userList[userIndex].name)
        edtSurname.setText(userList[userIndex].surname)
        edtEmail.setText(userList[userIndex].email)
    }

    private fun checkEdding() {
        when (isEding) {
            false -> addUser()
            true -> editUser()

        }
    }

    private fun editUser() = with(binding) {
        val userIndex = intent.getIntExtra(Const.USER_INFO_BY_INDEX, 0)
        val user = userList[userIndex]

        if (edtName.text!!.isNotEmpty()) user.name = edtName.text.toString()
        if (edtSurname.text!!.isNotEmpty()) user.surname = edtSurname.text.toString()

        Toast.makeText(this@AddEditActivity, R.string.user_successfully_edited, Toast.LENGTH_SHORT)
            .show()
        finish()
    }

    private fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isEmptyField(): Boolean = with(binding) {
        return@with edtName.text!!.isEmpty() || edtSurname.text!!.isEmpty() || edtEmail.text!!.isEmpty()
    }

    private fun emailexists(): Boolean = with(binding) {
        var exists = false
        userList.forEach {
            exists = it.email == edtEmail.text.toString()
        }
        return@with exists
    }
}
