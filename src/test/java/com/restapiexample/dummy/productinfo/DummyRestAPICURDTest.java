package com.restapiexample.dummy.productinfo;


import com.restapiexample.dummy.restfulinfo.DummyrestApiSteps;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class DummyRestAPICURDTest extends TestBase {

                static String status = "success";
                static String name ="John";
                static String salary= "35000";
                static String age = "30";
                static int id= 21;

                @Steps
                DummyrestApiSteps dummyrestApiSteps;

                @Title("This will create a new employee")
                @Test
                public void test001() {
                        ValidatableResponse response = dummyrestApiSteps.createUser(status,name,salary,age,id);
                        response.log().all().statusCode(200);

                }
                @Title("This will getting single user by id" )
                @Test
                public void test002(){
                        ValidatableResponse response=dummyrestApiSteps.gettingSingleEmployee(id);
                        response.log().all().statusCode(200);
                }
                @Title("This will updating user by Id")
                @Test
                public void test003(){
                        ValidatableResponse response=dummyrestApiSteps.updatingEmployeeId(id);
                        response.log().all().statusCode(200);
                }
                @Title("This will deleting user")
                @Test
                public void test004(){
                        ValidatableResponse response=dummyrestApiSteps.deletingEmployeeId(id);
                        response.log().all().statusCode(200);
                }
        }
