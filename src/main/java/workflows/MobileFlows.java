package workflows;

import exstensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flows: Fill Form and Calculate mortgage")
    public static void calculateMortgage (String amount ,String term ,String rate){
        MobileActions.updateText(mortgageMain.txt_amount, amount);
        MobileActions.updateText(mortgageMain.txt_Term, term);
        MobileActions.updateText(mortgageMain.txt_Rate, rate);
        MobileActions.tap(1, mortgageMain.btn_Calculate, 500);
    }

}
