package com.example.myapplication.view.activity

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myapplication.MyApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAddUpdateDishBinding
import com.example.myapplication.viewmodel.PersonViewModalFactory
import com.example.myapplication.viewmodel.PersonViewModel

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mBinding :ActivityAddUpdateDishBinding


    private val personViewModel: PersonViewModel by viewModels{
        PersonViewModalFactory((application as MyApplication).reposatory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         mBinding = ActivityAddUpdateDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnAddUser.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_add_user ->{
                validateAndSaveUserDetail()
            }
        }
    }

    fun  validateAndSaveUserDetail(){
        var userName:String = mBinding.etUserName.text.toString()

        if(userName.isBlank()){
            Toast.makeText(this,"user name can not be blank",Toast.LENGTH_SHORT).show()
            return
        }
        if(userName.length < 5){
            Toast.makeText(this,"user name can not be less than 5 char",Toast.LENGTH_SHORT).show()
            return
        }


        val person:com.example.myapplication.model.entities.Person = com.example.myapplication.model.entities.Person(userName)
        personViewModel.insert(person);

        Toast.makeText(this,"user saved",Toast.LENGTH_SHORT).show()
        finish();
    }
}