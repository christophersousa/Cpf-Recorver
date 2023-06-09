package maxmilhas.com.br.cpfrecorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import maxmilhas.com.br.cpfrecorder.model.Cpf;
import maxmilhas.com.br.cpfrecorder.service.cpfImp.CpfServiceImp;

@Slf4j
@RestController
@RequestMapping("/cpf")
public class CpfController {

    @Autowired
    private CpfServiceImp service;

    @GetMapping()
    public ResponseEntity<List<Cpf>> getListCpf() {
        log.info("Method GET of list cpfs");
        return ResponseEntity.ok(service.getCpfList());
    }

    @PostMapping()
    public ResponseEntity<Cpf> addCpf(@RequestParam String cpf) {
        log.info("Method Post new cpfs");
        Cpf newCpf = new Cpf();
        newCpf.setCpf(cpf);
        newCpf = service.saveCpf(newCpf);
        return ResponseEntity.ok(newCpf);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cpf> getCpf(@PathVariable String cpf) {
        log.info("Method GET of cpf request");
        return ResponseEntity.ok(service.getCpf(cpf));
    }

    @DeleteMapping("/{cpf}")
    public void deleteCpf(@PathVariable String cpf) {
        log.info("Method DELETE of cpf request");
        service.removeCpf(cpf);
    }

}
