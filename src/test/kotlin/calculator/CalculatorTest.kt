package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `덧셈 연산`() {
        assertThat(Calculator.execute("1 + 2")).isEqualTo(3.0)
        assertThat(Calculator.execute("4 + 18")).isEqualTo(22.0)
    }

    @Test
    fun `뺄셈 연산`() {
        assertThat(Calculator.execute("7 - 2")).isEqualTo(5.0)
        assertThat(Calculator.execute("1 - 12")).isEqualTo(-11.0)
    }

    @Test
    fun `곱셈 연산`() {
        assertThat(Calculator.execute("5 * 3")).isEqualTo(15.0)
        assertThat(Calculator.execute("11 * 2")).isEqualTo(22.0)
    }

    @Test
    fun `나눗셈 연산`() {
        assertThat(Calculator.execute("10 / 5")).isEqualTo(2.0)
        assertThat(Calculator.execute("9 / 2")).isEqualTo(4.5)
    }

    @Test
    fun `혼합된 연산`() {
        assertThat(Calculator.execute("2 + 3 * 4 / 2")).isEqualTo(10.0)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.execute(null)
        }
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.execute("")
        }
    }
}
