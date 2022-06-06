package com.restapiexample.dummy.restfulinfo;


import com.restapiexample.dummy.constants.EndPoints;
import com.restapiexample.dummy.model.DummyrestPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DummyrestApiSteps {
    @Step("Creating Employee with status : {0}, name: {1}")
    public ValidatableResponse createUser(String status,String name,String salary,String age,int id
    ) {
        DummyrestPojo dummyrestPojo = new DummyrestPojo();
        dummyrestPojo.setStatus(status);
        dummyrestPojo.setName(name);
        dummyrestPojo.setSalary(salary);
        dummyrestPojo.setAge(age);
        dummyrestPojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(dummyrestPojo)
                .when()
                .post(EndPoints.CREATE_NEW_EMPLOYEE)
                .then();
    }
    @Step("Getting Single Employee Id: 21" )
    public ValidatableResponse gettingSingleEmployee(int id){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeddID",21)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE_BY_ID)
                .then();

    }
    @Step("Updating Employee Id: 21")
    public ValidatableResponse updatingEmployeeId(int id){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",21)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("Deleting Employee id: 21")
    public ValidatableResponse deletingEmployeeId(int id){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",21)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }
}



