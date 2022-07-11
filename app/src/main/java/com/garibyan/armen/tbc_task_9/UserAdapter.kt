package com.garibyan.armen.tbc_task_9

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.garibyan.armen.tbc_task_9.databinding.RvItemBinding

class UserAdapter(
    val context: Context,
    val userList: ArrayList<User>
) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    inner class UserHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = RvItemBinding.bind(item)

        fun bind(user: User) = with(binding) {
            tvName.text = user.name
            tvSurname.text = user.surname
            tvEmail.text = user.email

            binding.btnDelete.setOnClickListener {
                deleteUser()
            }
            binding.btnEdit.setOnClickListener {
                editUser()
            }
        }

        private fun editUser() {
            val intent = Intent(context, AddEditActivity::class.java)
            intent.putExtra(Const.USER_INFO_BY_INDEX, adapterPosition)
            intent.putExtra(Const.IS_EDING, true)
            context.startActivity(intent)
        }

        private fun deleteUser() {
            AlertDialog.Builder(context)
                .setTitle(R.string.delete)
                .setIcon(R.drawable.ic_baseline_delete_black_24)
                .setMessage(R.string.confirm_delete)
                .setPositiveButton(R.string.yes) { dialog, _ ->
                    userList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    Toast.makeText(context, R.string.user_deleted, Toast.LENGTH_SHORT)
                        .show()
                    dialog.dismiss()
                }
                .setNegativeButton(R.string.no) { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)

        return UserHolder(view)
    }


    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun addUser(user: User) {
        userList.add(user)
        notifyDataSetChanged()
    }
}
