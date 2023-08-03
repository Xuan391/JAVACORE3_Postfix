import com.beust.ah.A;
import org.example.ConvertPostfixAndCalculate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestConvertPostfixAndCalculate {

    @Test
    public void testEvaluateExpression_Addition() {
        String expression = "2+3";
        double expected = 5.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Subtraction() {
        String expression = "10-5";
        double expected = 5.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Multiplication() {
        String expression = "2*3";
        double expected = 6.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Division() {
        String expression = "10/2";
        double expected = 5.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_ComplexExpression() {
        String expression = "5+3*2-6/2";
        double expected = 8.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_NegativeResult() {
        String expression = "5-10";
        double expected = -5.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_DecimalResult() {
        String expression = "3.5+1.5";
        double expected = 5.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Parentheses() {
        String expression = "(2+3)*4";
        double expected = 20.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_ComplexWithParentheses() {
        String expression = "((10-5)*2+4)/2";
        double expected = 7.0;
        double result = ConvertPostfixAndCalculate.evaluateExpression(expression);
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_DivisionByZero() {
        String expression = "5/0";
        try {
            ConvertPostfixAndCalculate.evaluateExpression(expression);
            //the test fails
            Assert.assertEquals(true, false);
        } catch (ArithmeticException e) {
            // Division by zero, the test passes
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void testEvaluateExpression_InvalidExpression() {
        String expression = "2+3*";
        try {
            ConvertPostfixAndCalculate.evaluateExpression(expression);
            // the test fails
            Assert.assertEquals(true, false);
        } catch (IllegalArgumentException e) {
            // Invalid expression, the test passes
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void testEvaluateExpression_EmptyExpression() {
        String expression = "";
        try {
            ConvertPostfixAndCalculate.evaluateExpression(expression);
            // If the evaluation does not throw an exception, the test fails
            Assert.assertEquals(true, false);
        } catch (RuntimeException e) {
            // Empty expression, the test passes
            Assert.assertEquals(true, true);
        }
    }

}
