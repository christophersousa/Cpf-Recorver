package maxmilhas.com.br.cpfrecorder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import maxmilhas.com.br.cpfrecorder.model.Cpf;

@Service
public interface CpfService {
    Cpf saveCpf(Cpf cpf);

    List<Cpf> getCpfList();

    Cpf getCpf(String cpf);

    void removeCpf(String cpf);
}
