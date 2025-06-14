package com.ticket_management_system.central_api.Controller;

import com.ticket_management_system.central_api.Exception.WrongCredentials;
import com.ticket_management_system.central_api.Model.Employee;
import com.ticket_management_system.central_api.Service.EmpService;
import com.ticket_management_system.central_api.dto.Request.EmployeeReq;
import com.ticket_management_system.central_api.dto.Request.InviteEmployeeDto;
import com.ticket_management_system.central_api.dto.Request.LoginDto;
import com.ticket_management_system.central_api.dto.Request.TokenDto;
import com.ticket_management_system.central_api.dto.Response.EmployeeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/central/employee")
public class EmployeeController {

    @Autowired
    EmpService empService;

    @PostMapping("/createEmp")
    public EmployeeResp createEmployee(@RequestBody EmployeeReq employeeReq){
        return empService.createEmp(employeeReq);
    }

//    @GetMapping("/emp/orgId/{orgId}")
//    public Employee getEmployeeByEmail(String empEmail){
//        return empService.getEmployeeByEmail(empEmail);
//    }

    @GetMapping("/login")
    public ResponseEntity loginEmp(@RequestBody LoginDto loginDto){
        // String token = empService.loginEmployee(loginDto);
        try{
            String token = empService.loginEmployee(loginDto);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            return new ResponseEntity(tokenDto, HttpStatus.OK);
        }catch (WrongCredentials e){
            String message = e.getMessage();
            return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/invite")
    public ResponseEntity inviteEmp(@RequestBody InviteEmployeeDto inviteEmployeeDto,
                                    @RequestHeader String Authorization){
        Employee employee = empService.inviteEmployee(inviteEmployeeDto, Authorization);
        return new ResponseEntity(employee,HttpStatus.CREATED);
    }

    @GetMapping("/invite/accept/{token}")
    public ResponseEntity acceptInvite(@PathVariable String token){
        Employee employee = empService.acceptInvite(token);
        return new ResponseEntity(employee,HttpStatus.ACCEPTED);
    }
}
