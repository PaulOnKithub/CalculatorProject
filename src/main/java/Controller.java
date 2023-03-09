import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.util.StringUtils;

public class Controller {

    private String operation=null;
    private String operand1,operand2="0";
    @FXML
    //primary view area
    private TextField viewArea;
    @FXML
    //secondary view area
    private TextField viewArea1;
    @FXML
    //User input to primary view area
    void operandButton(ActionEvent event) {

        if(viewArea.getText().length()<10){
            String number=((Button) event.getSource()).getText();
            viewArea.setText(viewArea.getText()+number);
        }
    }
    @FXML
    //Select an operation, pass the first operand to the secondary view area and assign a value(i.e. operand 1)
    void operationButton(ActionEvent event) {
        operation=((Button) event.getSource()).getText();
        //Check to enable entry of negative values as first operands
        if(operation.equals("-")&(StringUtils.isEmpty(viewArea.getText())
        && StringUtils.isEmpty(viewArea1.getText()))){
            viewArea.setText("-");
            return;
        }
        viewArea1.setText(viewArea.getText()+operation);
        operand1 = viewArea.getText();
        viewArea.setText("");
    }
    @FXML
    //Enable input of decimal value operands
    void decimalButton(ActionEvent event) {
        String point=((Button)event.getSource()).getText();
        if(!(viewArea.getText().contains(point))){
            String decimal=(viewArea.getText()+point);
            viewArea.setText(decimal);
        }
    }
    @FXML
    //Assign value to operand 2, call the computation method and set result to primary view area
    void equalsButton(ActionEvent event) {
        operand2=viewArea.getText();
        if(!(StringUtils.isEmpty(operand1) | StringUtils.isEmpty(operand2))) {
            String result = CalculatorBackend.basicCompute(operand1, operand2, operation);
            viewArea1.setText(viewArea1.getText() + viewArea.getText() + "=");
            viewArea.setText(result);
        }
    }

    @FXML
    //Delete a single input value from view area or clear view area
    void viewAreaButton(ActionEvent event) {
        String type=((Button) event.getSource()).getText();
        if(type.equals("DEL") & viewArea.getText().length()>0){
            String display=viewArea.getText();
            display=display.substring(0,display.length()-1);
            viewArea.setText(display);
        }else if(type.equals("CLEAR") &((viewArea.getText().length()>0)|(viewArea1.getText().length()>0))) {
            operand1="0";
            operand2="0";
            viewArea.setText("");
            viewArea1.setText("");
        }
    }
}
