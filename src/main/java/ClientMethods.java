

import model.Employee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ClientMethods {

    Client client = ClientBuilder.newClient();

    public String getEmployee(String id) {
        String info;
        Invocation.Builder builder = client.target("http://dummy.restapiexample.com/api/v1/employee/")
                .path(id)
                .request();
        String response = builder.get().readEntity(String.class);
        return response;
    }

    public String deleteEmployee(String id) {
        String info;
        Response builder = client.target("http://dummy.restapiexample.com/api/v1/delete/")
                .path(id)
                .request()
                .delete();
        String response = builder.readEntity(String.class);
        return response;
    }

    public String createEmployee(Employee employee) {
        return client.target("http://dummy.restapiexample.com/api/v1/create")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(employee), String.class);
    }

    public String updateEmployee(String id,Employee employee) {
        return client.target("http://dummy.restapiexample.com/api/v1/update")
                .path(id)
                .request()
                .put(Entity.json(employee), String.class);
    }

    public String getAllEmployees (){
        return client.target("http://dummy.restapiexample.com/api/v1/employees")
                .request()
                .get()
                .readEntity(String.class);
    }
}
