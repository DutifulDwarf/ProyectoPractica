package com.example.demo.service;

import com.example.demo.model.usuario;

import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }
    public Optional<usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }
    public usuario saveUsuario(usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
