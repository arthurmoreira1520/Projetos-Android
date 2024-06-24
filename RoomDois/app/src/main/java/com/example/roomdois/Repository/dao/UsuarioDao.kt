package com.example.roomdois.Repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdois.model.UsuarioModel

@Dao
interface UsuarioDao {

    @Insert
    fun insertUser(usuario: UsuarioModel): Long

    @Update
    fun updateUser(usuario: UsuarioModel): Int

    @Delete
    fun deleteUser(usuario: UsuarioModel): Int

    @Query("SELECT * FROM Usuario WHERE id_usuario = :id")
    fun get(id: Int): UsuarioModel

    @Query("SELECT * FROM Usuario")
    fun getAll(): List<UsuarioModel>

}