package com.dio.live.ServiceRN;

import com.dio.live.model.Empresa;
import com.dio.live.model.Usuario;
import com.dio.live.repositoryBD.EmpresaRepository;
import com.dio.live.repositoryBD.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService( EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa getEmpresa(Empresa empresa) {
        return empresaRepository.getOne(empresa.getId());
    }

    public List<Empresa> getEmpresaList() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getById(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    public Empresa updateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }
}
