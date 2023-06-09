package maxmilhas.com.br.cpfrecorder.util;

import maxmilhas.com.br.cpfrecorder.model.Cpf;

public class CpfTest {
    public static Cpf createTestCpf(String cpf) {
        Cpf testCpf = new Cpf();
        testCpf.setCpf(cpf);
        return testCpf;
    }
}
