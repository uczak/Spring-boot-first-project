package com.dio.live.controller;

import com.dio.live.ServiceRN.JornadaService;
import com.dio.live.ServiceRN.UsuarioService;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    @Autowired
    public UsuarioController( UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getUsuarioList() {
        return usuarioService.getUsuarioList();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioListId(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new Exception("Usuario not found.")));
    }

    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity deleteById(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        try{
            usuarioService.deleteUsuario(idUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Usuario>) ResponseEntity.ok();
    }
}
