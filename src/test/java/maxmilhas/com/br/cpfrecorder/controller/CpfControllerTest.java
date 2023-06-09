package maxmilhas.com.br.cpfrecorder.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import maxmilhas.com.br.cpfrecorder.model.Cpf;
import maxmilhas.com.br.cpfrecorder.service.cpfImp.CpfServiceImp;
import maxmilhas.com.br.cpfrecorder.util.CpfTest;

@ExtendWith(SpringExtension.class)
public class CpfControllerTest {

    @InjectMocks
    private CpfController cpfController;

    @Mock
    private CpfServiceImp CpfService;

    private static final String CPF = "88888888888";

    @BeforeEach
    void setup() {

        List<Cpf> list = new ArrayList<Cpf>();
        BDDMockito.when(CpfService.getCpfList()).thenReturn(list);

        BDDMockito.when(CpfService.saveCpf(CpfTest.createTestCpf(CPF)))
                .thenReturn(CpfTest.createTestCpf(CPF));

        BDDMockito.when(CpfService.getCpf(CPF))
                .thenReturn(CpfTest.createTestCpf(CPF));
    }

    @Test
    @DisplayName("Test to see if getCpfs is returning an empty list when no data is added and if it does not return null")
    void mustReturnAnStatusOfSucess_WhenSearchingForCpfs() {

        List<Cpf> listCpf = cpfController.getListCpf().getBody();

        System.out.println("Test list is not null");
        Assertions.assertThat(listCpf).isNotNull();

        System.out.println("Test list is empty");
        Assertions.assertThat(listCpf).isEqualTo(new ArrayList<Cpf>());

    }

    @Test
    @DisplayName("Test if the cpf is being registered correctly and if the createAt is correctly formatted")
    void mustReturnAnStatusOfSucess_WhenAddCpf() {

        Cpf cpfTest = cpfController.addCpf(CPF).getBody();

        System.out.println("Test CPF is not null");
        Assertions.assertThat(cpfTest).isNotNull();

        System.out.println("Test cpf is equal String CPF");
        Assertions.assertThat(cpfTest.getCpf()).isEqualTo(CPF);

        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try {

            Date newDate = DateFor.parse(new Date().toString());
            System.out.println("Test that the date is in the correct format");
            Assertions.assertThat(cpfTest.getCreatedAt()).isEqualTo(newDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Test to see if getCpf is returning a valid Cpf and with creatAt in ISO 8601 format -UTC")
    void mustReturnAnStatusOfSucess_WhenGetCpf() {

        Cpf cpfTest = cpfController.getCpf(CPF).getBody();

        System.out.println("Test CPF is not null");
        Assertions.assertThat(cpfTest).isNotNull();

        System.out.println("Test cpf is equal String CPF");
        Assertions.assertThat(cpfTest.getCpf()).isEqualTo(CPF);

        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try {

            Date newDate = DateFor.parse(new Date().toString());
            System.out.println("Test that the date is in the correct format");
            Assertions.assertThat(cpfTest.getCreatedAt()).isEqualTo(newDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
