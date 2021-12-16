package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPersonLayoutBinding
import com.example.myapplication.model.entities.Person

class PersonAdapter (private val fragment:Fragment):RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var personList :List<Person> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding :ItemPersonLayoutBinding= ItemPersonLayoutBinding.inflate(LayoutInflater.from(fragment.context),parent,false)
    return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var person = personList[position]

        holder.personName.text= person.userName
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun personList(persons:List<Person>){
        personList = persons
        notifyDataSetChanged()
    }

    class ViewHolder(v: ItemPersonLayoutBinding) : RecyclerView.ViewHolder(v.root) {
        val personName = v.tvPersonName
    }
}