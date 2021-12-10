package com.example.myapplication.viewmodel

import androidx.lifecycle.*
import com.example.myapplication.model.database.PersonRepository
import com.example.myapplication.model.entities.Person
import kotlinx.coroutines.launch

class PersonViewModel(private val repository : PersonRepository ): ViewModel() {

    fun insert(person:Person) = viewModelScope.launch {
        repository.insertPerson(person)
    }

    val allPersons : LiveData<List<Person>> = repository.allPersonList.asLiveData()

}

class PersonViewModalFactory(private val personRepository:PersonRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PersonViewModel::class.java))
        {
            return  PersonViewModel(personRepository) as T
        }

        throw IllegalArgumentException("unknown viewModel")
    }
}