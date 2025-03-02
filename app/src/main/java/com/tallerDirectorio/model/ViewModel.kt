package com.tallerDirectorio.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallerDirectorio.model.User
import com.tallerDirectorio.model.UsersList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.tallerDirectorio.Network.KtorClient

data class UiState(
    val usuario: User? = null,
    val usersList: List<User> = emptyList()
)


class ContactViewModel : ViewModel() {

    // Estado de la UI
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private val ktorClient = KtorClient()

    init {
        fetchUsers()  // Cargar usuarios al inicializar el ViewModel
    }
    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response: UsersList = ktorClient.getUsers()
                _uiState.value = _uiState.value.copy(usersList = response.users)
            } catch (e: Exception) {
                println("Error al obtener usuarios: ${e.message}")
            }
        }
    }

    // Almacena el usuario seleccionado
    private var selectedUser: User? = null

    // Actualiza el usuario seleccionado
    fun updateContact(user: User) {
        selectedUser = user
    }

    // Busca un usuario por ID y actualiza el estado
    fun getUserById(userId: Int): User? {
        return _uiState.value.usersList.find { it.id == userId }
    }



    // Establece la lista de usuarios en el estado
    fun setUsers(users: List<User>) {
        _uiState.update { currentState ->
            currentState.copy(usersList = users)
        }
    }

    // Obtiene el usuario seleccionado
    fun getSelectedUser(): User? {
        return selectedUser
    }
}
