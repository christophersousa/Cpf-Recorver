package maxmilhas.com.br.cpfrecorder.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import maxmilhas.com.br.cpfrecorder.util.CpfTest;

@ExtendWith(SpringExtension.class)
public class CpfTestModel {

    private static final String CPF = "88888888888";

    @Test
    @DisplayName("Test model class cpf")
    void testCpf() throws Exception {
        Cpf testCpf = CpfTest.createTestCpf(CPF);
        testCpf.setCreatedAt(new Date());

        System.out.println("Test CPF is not null");
        Assertions.assertThat(testCpf).isNotNull();

        System.out.println("Test cpf is equal String CPF");
        Assertions.assertThat(testCpf.getCpf()).isEqualTo(CPF);

        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try {

            Date newDate = DateFor.parse(new Date().toString());
            System.out.println("Test that the date is in the correct format");
            Assertions.assertThat(testCpf.getCreatedAt()).isEqualTo(newDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
