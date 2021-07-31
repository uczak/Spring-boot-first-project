package com.dio.live.controller;

import com.dio.live.ServiceRN.EmpresaService;
import com.dio.live.ServiceRN.JornadaService;
import com.dio.live.model.Empresa;
import com.dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public Empresa createJornada(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getJornadaList() {
        return empresaService.getEmpresaList();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<Empresa> getEmpresaListId(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new Exception("Empresa not found.")));
    }

    @PutMapping
    public Empresa updateJornada(@RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity deleteById(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        try{
            empresaService.deleteEmpresa(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }

}
