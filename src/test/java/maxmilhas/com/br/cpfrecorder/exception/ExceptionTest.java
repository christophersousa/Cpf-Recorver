package maxmilhas.com.br.cpfrecorder.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import maxmilhas.com.br.cpfrecorder.service.cpfImp.CpfServiceImp;
import maxmilhas.com.br.cpfrecorder.util.CpfTest;

@ExtendWith(SpringExtension.class)
public class ExceptionTest {

    @Mock
    private CpfServiceImp CpfService;

    private static final String CPF = "88888888888";

    @BeforeEach
    void setup() {

        BDDMockito.when(CpfService.saveCpf(ArgumentMatchers.any()))
                .thenThrow(ExistsCpfException.class);

        BDDMockito.when(CpfService.getCpf(ArgumentMatchers.any()))
                .thenThrow(InvalidCpfException.class);

        BDDMockito.doThrow(new NotFoundCpfException()).when(CpfService).removeCpf(CPF);

    }

    @Test
    public void whenExistsCpfExceptionThrown_thenAssertionSucceeds() {
        assertThrows(ExistsCpfException.class, () -> {
            CpfService.saveCpf(CpfTest.createTestCpf(CPF));
        }, "CPF already registered");

    }

    @Test
    public void whenNotFoundCpfExceptionThrown_thenAssertionSucceeds() {
        assertThrows(NotFoundCpfException.class, () -> {
            CpfService.removeCpf(CPF);
        }, "CPF not found");

    }

    @Test
    public void whenInvalidCpfExceptionThrown_thenAssertionSucceeds() {
        assertThrows(InvalidCpfException.class, () -> {
            CpfService.getCpf(CPF);
        }, "CPF is not valid");

    }
}
