package com.dio.live.ServiceRN;

import com.dio.live.model.BancoHoras;
import com.dio.live.repositoryBD.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public BancoHoras getBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.getOne(bancoHoras.getBancoHorasId());
    }

    public List<BancoHoras> getBancoHorasList() {
        return bancoHorasRepository.findAll();
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(BancoHoras.BancoHorasId bancoHorasId) {
        bancoHorasRepository.deleteById(bancoHorasId);
    }

    public Optional<BancoHoras> getById(BancoHoras.BancoHorasId bancoHorasId) {
        return bancoHorasRepository.findById(bancoHorasId);
    }
}
