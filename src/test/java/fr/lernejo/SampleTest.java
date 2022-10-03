package fr.lernejo;

import static fr.lernejo.Sample.Operation.ADD;
import static fr.lernejo.Sample.Operation.MULT;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions; // (1)
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {
    private final Sample sample = new Sample();

    @Test // (2)
    void fact_of_negative_number_throws() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-1))
            .withMessage("N should be positive"); // (3)
    }
    @Test
    void fact_of_3_is_6() {
        int result = sample.fact(3);
        Assertions.assertThat(result).isEqualTo(6); // (4)
    }

    @Test
    void multiplication_of_3_is_9() {
        int result = sample.op(MULT, 3, 3);
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    void addition_of_3_is_6() {
        int result = sample.op(ADD, 3, 2);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest // (1)
    @CsvSource({ // (2)
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "13, 1932053504"
    })
    void fact_test_cases(int n, int expectedResult) { // (3)
        int result = sample.fact(n);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }



}
