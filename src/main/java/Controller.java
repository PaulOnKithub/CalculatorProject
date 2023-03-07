import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField viewArea;
    @FXML
    private TextField viewArea1;
    private String operation=null;
    private String operand1,operand2="0";
    int operand1length=0;

    @FXML
    void operandButton(ActionEvent event) {

        if(viewArea.getText().length()<10){
            String number=((Button) event.getSource()).getText();
            viewArea.setText(viewArea.getText()+number);
        }
    }
    @FXML
    void operationButton(ActionEvent event) {
        operation=((Button) event.getSource()).getText();
        viewArea1.setText(viewArea.getText()+operation);
        operand1 = viewArea.getText();
        viewArea.setText("");
    }
    @FXML
    void equalsButton(ActionEvent event) {
        operand2=viewArea.getText();
        String result=CalculatorBackend.basicCompute(operand1,operand2,operation);
        viewArea1.setText(viewArea1.getText()+viewArea.getText()+"=");
        viewArea.setText(result);
    }

    @FXML
    void viewAreaButton(ActionEvent event) {
        String type=((Button) event.getSource()).getText();
        if(type.equals("DEL") & viewArea.getText().length()>0){
            String display=viewArea.getText();
            display=display.substring(0,display.length()-1);
            viewArea.setText(display);
        }else if(type.equals("CLEAR") &((viewArea.getText().length()>0)|(viewArea1.getText().length()>0))) {
            viewArea.setText("");
            viewArea1.setText("");
        }
    }
}
