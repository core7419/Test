package bookmarks;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import com.javarticle.spring.rest.Employee;
import org.springframework.web.client.RestTemplate;
  
 
public class SpringBootRestTestClient {
  
    public static final String REST_SERVICE_URI = "http://localhost:9090";
      
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-------v--2ffff222--");
          
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/", List.class);
          
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
      
    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Employee user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", Employee.class);
        System.out.println(user);
    }
      
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Employee user = new Employee();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, Employee.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
  
    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Employee user  = new Employee();
        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
        System.out.println(user);
    }
  
    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }
  
  
    /* DELETE */
    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }
  
    public static void main(String args[]){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        deleteAllUsers();
        listAllUsers();
    }
}