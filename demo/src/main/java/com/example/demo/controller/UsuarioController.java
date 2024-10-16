package com.example.demo.controller;

import com.example.demo.model.usuario;

import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<com.example.demo.model.usuario>getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.demo.model.usuario> getUsuarioById (@PathVariable Long id) {
        Optional<com.example.demo.model.usuario> usuario=usuarioService.getUsuarioById(id);

        return usuario.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<com.example.demo.model.usuario> createUsuario(@RequestBody com.example.demo.model.usuario usuario) {
        com.example.demo.model.usuario newUsuario= usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
    usuarioService.deleteUsuario(id);
    return ResponseEntity.noContent().build();

}
}

