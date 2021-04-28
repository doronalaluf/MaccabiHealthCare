package santiy;

import exstensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test (description = "test01 - Verify Mortgage")
    @Description ("This Test fill in mortgage fields and calculate repayment")
    public static void Test01_VerifyMortgage(){
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.VerifyText(mortgageMain.txt_Repayment , "£30.03");
    }
}
