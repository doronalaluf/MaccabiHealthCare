package workflows;

import exstensions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flows: Get Team Property")
    public static String getTeamProperty(String jPath){
       APIActions.get("/api/teams/search");
       return APIActions.extractFromJson(response , jPath);
    }

    @Step("Business Flows: Create New Team in Grafana")
    public static void postTeam (String name , String email){
        params.put("name" , name);
        params.put("email" , email);
        APIActions.Post(params,"/api/teams");
    }

    @Step("Business Flows: Update Team in Grafana")
    public static void updateTeam (String name , String email, String id){
        params.put("name" , name);
        params.put("email" , email);
        APIActions.put(params,"/api/teams/" + id);
    }

    @Step("Business Flows: Delete Team in Grafana")
    public static void deleteTeam (String id){
        APIActions.delete(id);
    }
}
