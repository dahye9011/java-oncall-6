package oncall;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void 출력_기본_테스트() {
        // given
        OutputView outputView = new OutputView();
        EmployeeName employeeName = new EmployeeName("준팍");

        // when
        String result = outputView.formatScheduleLine(5, 1, "월", false, employeeName);

        // then
        assertThat(result).isEqualTo("5월 1일 월 준팍");
    }

    @Test
    void 출력_휴일_기본_테스트() {
        // given
        OutputView outputView = new OutputView();
        EmployeeName employeeName = new EmployeeName("루루");

        // when
        String result = outputView.formatScheduleLine(5, 5, "금", true, employeeName);

        // then
        assertThat(result).isEqualTo("5월 5일 금(휴일) 루루");
    }
}
