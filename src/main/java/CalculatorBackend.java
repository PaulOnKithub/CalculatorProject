public class CalculatorBackend {
    static String basicCompute(String operand1,String operand2,String operation){
        Double numResult=switch (operation){
            case "+"->{
                Double op1=Double.valueOf(operand1);
                Double op2=Double.valueOf(operand2);
                yield op1+op2;
            }
            case "-"->{
                Double op1=Double.valueOf(operand1);
                Double op2=Double.valueOf(operand2);
                yield op1-op2;
            }
            case "*"->{
                Double op1=Double.valueOf(operand1);
                Double op2=Double.valueOf(operand2);
                yield op1*op2;
            }
            case "/"->{
                Double op1=Double.valueOf(operand1);
                Double op2=Double.valueOf(operand2);
                yield op1/op2;
            }
            default ->(double) 0;

        };
        return String.valueOf(numResult);

    }
}
