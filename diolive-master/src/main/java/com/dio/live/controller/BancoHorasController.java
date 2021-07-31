package com.dio.live.controller;

import com.dio.live.ServiceRN.BancoHorasService;
import com.dio.live.model.BancoHoras;
import com.dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    BancoHorasService bancoHorasService;

    @Autowired
    public BancoHorasController(BancoHorasService bancoHorasService) {
        this.bancoHorasService = bancoHorasService;
    }

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.saveBancoHoras(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getJornadaList() {
        return bancoHorasService.getBancoHorasList();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getJornadaListId(@PathVariable("idBancoHoras") BancoHoras.BancoHorasId bancoHorasId) throws Exception {
        return ResponseEntity.ok(bancoHorasService.getById(bancoHorasId).orElseThrow(() -> new Exception("BancoHoras not found.")));
    }

    @PutMapping
    public BancoHoras updateJornada(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteById(@PathVariable("idBancoHoras") BancoHoras.BancoHorasId bancoHorasId) throws Exception {
        try{
            bancoHorasService.deleteBancoHoras(bancoHorasId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();
    }
}
