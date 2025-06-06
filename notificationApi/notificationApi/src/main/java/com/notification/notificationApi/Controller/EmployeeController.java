package com.notification.notificationApi.Controller;

import com.notification.notificationApi.Model.Employee;
import com.notification.notificationApi.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify/employee")
public class EmployeeController {

    @Autowired
    EmpService empService;

    public void notifyEmployeeForInvitation(Employee employee){
        empService.notifyEmployeeForInvitation(employee);
    }
}
