package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Shop;
import net.proselyte.springsecurityapp.model.Student;
import net.proselyte.springsecurityapp.model.StudentList;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping("/api")
public class JSONController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/xml/student", method = RequestMethod.GET)
    public @ResponseBody Student getStudent() {
        return new Student(23, "Meghna", "Naidu", "meghna@gmail.com", "8978767878");
    }

    @RequestMapping(value = "/xml/studentlist", method = RequestMethod.GET)
    public @ResponseBody StudentList getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(3, "Robert", "Parera", "robert@gmail.com", "8978767878"));
        studentList.add(new Student(93, "Andrew", "Strauss", "andrew@gmail.com", "8978767878"));
        studentList.add(new Student(239, "Eddy", "Knight", "knight@gmail.com", "7978767878"));

        return new StudentList(studentList);
    }

    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET)
    public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
        List<User> users = userService.findAll();

        ArrayList<String> data_1 = new ArrayList<>();
        String [] data_2 = new String[users.size()];
        List<Map<Long, String>> data_3 = new ArrayList<>();
        Map<Long, String> data_4 = new HashMap<>();
        Map<Long, Map<Long, String>> data_5 = new HashMap<>();
        Map<Long, List<String>> data_6 = new HashMap<>();

        int currentPosition = 0;
        for (User user: users) {
            data_1.add(user.getUsername());
            data_2[currentPosition] = user.getUsername();
            //data_2[toIntExact(user.getId())] = user.getUsername();

            Map<Long, String> tmp = new HashMap<>();
            tmp.put(user.getId(), user.getUsername());
            data_3.add(tmp);

            data_4.put(user.getId(), user.getUsername());

            data_5.put((long) currentPosition, tmp);

            List<String> tmp_0 = new ArrayList<>();
            tmp_0.add(user.getUsername());
            data_6.put(user.getId(), tmp_0);

            currentPosition++;
        }

        Shop shop = new Shop();
        shop.setName(name);
        shop.setStaffUserName_0(new String[] { "Foo", "Bar", "Baz" });
        shop.setStaffUserName_1(data_1.toArray(new String[data_1.size()]));
        shop.setStaffUserName_2(data_2);
        shop.setStaffUserName_3(data_3);
        shop.setStaffUserName_4(data_4);
        shop.setStaffUserName_5(data_5);
        shop.setStaffUserName_6(data_6);

        return shop;

    }

}