import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestClient {
    public static void main(String[] args) {
        Gson gson = new Gson();
        ClientMethods clientMethods = new ClientMethods();
        ObjectMapper mapper = new ObjectMapper();
        // System.out.println(clientMethods.getAllEmployees());
        List<Employee> employeesList = new ArrayList<>();
        try {
            employeesList = mapper
                    .readValue(clientMethods.getAllEmployees(), new TypeReference<List<Employee>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(employeesList.get(0).getName() + employeesList.get(0).getEmployee_name());
//        Employee employee = new Employee();
//        employee.setName("Boris");
//        employee.setAge("25");
//        employee.setSalary("2000");
//        String json =clientMethods.createEmployee(employee);
//        System.out.println(json);
//        employee = gson.fromJson(json, Employee.class);
//
//      String jsonString = clientMethods.getEmployee(employee.getId());
//        System.out.println(jsonString);
//
//        Employee p = gson.fromJson(jsonString, Employee.class);
//        System.out.println(p.getEmployee_age() + p.getId() + p.getEmployee_name() + p.getEmployee_salary());
//        Employee employeNew = new Employee();
//        employeNew.setName("Goloborodko");
//         employeNew.setAge("40");
//        System.out.println(clientMethods.updateEmployee(p.getId(), employeNew));
        //   System.out.println(clientMethods.deleteEmployee(p.getId()));
        //  System.out.println(clientMethods.deleteEmployee("6468"));
    }
}
