package api;

import dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController(value = "user")
@ComponentScan({"services"/*, "model"*/})
@RequestMapping("/user/api/v1/")
@Api(value = "User api")
public class UserApi extends CommonController{

    @Autowired
    UserService userService;




    @GetMapping(value = {"/auth/user"})
    @ResponseBody
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get user by Id", notes = "Returns user with specified id")
    public ResponseEntity<UserDto> getUserById(@RequestParam long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/sign_up", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Create user", notes = "Creates new user")
    public ResponseEntity<?> createUser(@RequestBody UserDto user){
        userService.create(user);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
