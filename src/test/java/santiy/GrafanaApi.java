package santiy;

import exstensions.APIActions;
import exstensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

public class GrafanaApi extends CommonOps {

    @Test (description = "test01 - Get Team From Grafana")
    @Description("This Test Verify Team")
    public void test01_VerifyTeam (){
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[0].name"), "shiran");
    }

    @Test (description = "test02 - Add Team To Grafana And Verify it")
    @Description("This Test Add Team And Verify it")
    public void test02_addTeam (){
        ApiFlows.postTeam("doron", "doron@gmail.com");
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[0].name"), "doron");
    }

    @Test (description = "test03 - Update Team in Grafana And Verify it")
    @Description("This Test update Team And Verify it")
    public void test03_updateTeam (){
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("doron", "doron@walla.co.il" , id);
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[0].email"), "doron@walla.co.il");
    }

    @Test (description = "test04 - Delete Team in Grafana And Verify it")
    @Description("This Test Delete Team And Verify it")
    public void test04_deleteTeam (){
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.deleteTeam(id);
        Verifications.VerifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
