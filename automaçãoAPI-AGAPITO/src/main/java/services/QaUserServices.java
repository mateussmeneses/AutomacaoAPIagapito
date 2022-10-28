package services;

import io.restassured.http.ContentType;
import pojo.QaUser;
import pojo.Users;

import static io.restassured.RestAssured.given;

public class QaUserServices extends TestingSupport {

    public QaUserServices(){
        setURI("https://agapito-server.herokuapp.com/users");
    }


    public void fillFields(QaUser user, String field, String value) {
        switch (field){
            case "login" : user.setLogin(value);break;
            case "full_name" : user.setFull_name(value);break;
            case "email" : user.setEmail(value);break;
            case "age" : user.setAge(Integer.valueOf(value));break;


        }
    }

    public void post(QaUser user) {
        String bodySended = getGson().toJson(user);
        logRequest(bodySended);
        setResponse(given().
                when().
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    body(bodySended).
                    post(getURI()).
                then().extract().response()

                );
        logResponse();
        QaUser userAux = getGson().fromJson(getResponse().jsonPath().prettify(), QaUser.class);
        setLastId(userAux.getId());
    }
    public void get(Integer id) {
                setResponse(given().
                         when().
                                contentType(ContentType.JSON).
                                accept(ContentType.JSON).
                                get(getURI() + "/" + id.toString()).
                        then().extract().response()

        );
        logResponse();
    }

    public String getField(String field) {
        String res = "";
        QaUser usersAux = getGson().fromJson(getResponse().jsonPath().prettify(), QaUser.class);

        switch (field){
            case "login" : res = usersAux.getLogin();break;
            case "full_name" : res = usersAux.getFull_name();break;
            case "email" : res = usersAux.getEmail();break;
            case "age" : res = usersAux.getAge().toString();break;

        }

        return res;

    }


    public void put(Integer id, QaUser user) {
        String bodySended = getGson().toJson(user);


        setResponse(given().
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(bodySended).
                put(getURI() + "/" + id.toString()).
                then().extract().response()

        );
        logResponse();
    }

    public void delete(Integer id) {
        setResponse(given().
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                delete(getURI() + "/" + id.toString()).
                then().extract().response()

        );
        logResponse();
    }
}
