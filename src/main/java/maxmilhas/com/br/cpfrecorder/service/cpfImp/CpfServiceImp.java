package maxmilhas.com.br.cpfrecorder.service.cpfImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maxmilhas.com.br.cpfrecorder.exception.ExistsCpfException;
import maxmilhas.com.br.cpfrecorder.exception.InvalidCpfException;
import maxmilhas.com.br.cpfrecorder.exception.NotFoundCpfException;
import maxmilhas.com.br.cpfrecorder.model.Cpf;
import maxmilhas.com.br.cpfrecorder.repository.CpfRepository;
import maxmilhas.com.br.cpfrecorder.service.CpfService;

@Service
public class CpfServiceImp implements CpfService {

    @Autowired
    CpfRepository cpfRepository;

    private void validationCpfExists(Cpf cpf) {

        /**
         * The method validation if the cpf exists in the repository and
         * If there is an error it executes an exception of type ExistsCpfException
         * If there is no function call validationCpf
         */

        cpfRepository.findByCpf(cpf.getCpf()).ifPresentOrElse(c -> {
            throw new ExistsCpfException();
        }, () -> {

            validationCpf(cpf.getCpf());
        });
    }

    private void validationCpf(String cpf) {

        /** Method validation if the cpf is valid to save in the repository */

        if (!cpf.matches("[0-9]+") || cpf.length() != 11) {
            throw new InvalidCpfException();
        }
    }

    private Cpf treatAndGetCpf(String cpf) {

        /** Method validation if the cpf is valid and if it exists */

        validationCpf(cpf);

        return cpfRepository.findByCpf(cpf).orElseThrow(() -> {
            throw new NotFoundCpfException();
        });
    }

    @Override
    public Cpf saveCpf(Cpf cpf) {

        /** The method save new Cpf in the repository */

        validationCpfExists(cpf);

        cpf.setCreatedAt(new Date());

        return cpfRepository.save(cpf);
    }

    @Override
    public List<Cpf> getCpfList() {

        /** The method list all Cpf's in the repository */

        return cpfRepository.findAll();
    }

    @Override
    public Cpf getCpf(String cpf) {

        /** The method getter cpf if exist in the repository */

        treatAndGetCpf(cpf);

        return treatAndGetCpf(cpf);
    }

    @Override
    public void removeCpf(String cpf) {

        /** The method remove cpf if exist in the repository */

        Cpf tryCPf = treatAndGetCpf(cpf);

        cpfRepository.delete(tryCPf);
    }

}
