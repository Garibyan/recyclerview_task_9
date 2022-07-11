package com.garibyan.armen.tbc_task_9

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.garibyan.armen.tbc_task_9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        userAdapter = UserAdapter(this, userList)

        setContentView(binding.root)

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val user = result.data?.getParcelableExtra<User>(Const.ADD_USER)
                    userAdapter.addUser(user!!)
                }
            }

        binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rcView.adapter = userAdapter

        binding.btnAdd.setOnClickListener {
            launcher.launch(Intent(this, AddEditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        userAdapter.notifyItemChanged(intent.getIntExtra(Const.USER_INFO_BY_INDEX, 0))
    }
}

