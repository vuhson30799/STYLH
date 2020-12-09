package stylh.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stylh.model.User;
import stylh.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<JSONObject> objects = new ArrayList<>();
        JSONObject object;

        for (User user : users){
            object = new JSONObject();
            object.put("userID",user.getUserID());
            object.put("loginName",user.getLoginName());
            object.put("password",user.getPassword());
            object.put("username",user.getUsername());
            object.put("email",user.getEmail());

            objects.add(object);
        }
        return new ResponseEntity<>(objects, HttpStatus.OK);

    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching user with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("user with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        JSONObject object = new JSONObject();

        object.put("userID",user.getUserID());
        object.put("loginName",user.getLoginName());
        object.put("password",user.getPassword());
        object.put("username",user.getUsername());
        object.put("email",user.getEmail());

        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
