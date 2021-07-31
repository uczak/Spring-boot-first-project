package com.dio.live.ServiceRN;

import com.dio.live.model.Usuario;
import com.dio.live.repositoryBD.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(Usuario usuario) {
        return usuarioRepository.getOne(usuario.getId());
    }

    public List<Usuario> getUsuarioList() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
