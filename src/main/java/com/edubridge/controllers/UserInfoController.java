package com.edubridge.controllers;

import java.time.Duration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.models.UserInfo;
import com.edubridge.repository.UserInfoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserInfoController 
{

	@Autowired
	UserInfoRepository userinforepo;
	
	@ResponseBody
	@GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserInfo>> getAllUserInfo()
	{
		return new ResponseEntity<List<UserInfo>>(userinforepo.findAll(),HttpStatus.OK);
		
	}
	
	@ResponseBody
	@GetMapping(value = "/xmloutput", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<UserInfo>> getAllUserInfoXML()
	{
		return new ResponseEntity<List<UserInfo>>(userinforepo.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/fluxresult", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<List<UserInfo>> getAllUserInfoFluxResult()
	{
		return Flux.interval(Duration.ofSeconds(10)).map(result -> userinforepo.findAll());
		
	}
	
	@GetMapping(value = {"/id/{userid}"})
	public ResponseEntity<UserInfo> getUserById(@PathVariable("userid") Integer userid)
	{
		return new ResponseEntity<UserInfo>(userinforepo.findByUserinfoid(userid),HttpStatus.OK);
	}
	
	@GetMapping(value = {"/monoresult/id/{userid}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<UserInfo> getUserByIdMonoResult(@PathVariable("userid") Integer userid)
	{
		return Mono.just(userinforepo.findByUserinfoid(userid));
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> createUserInfo(@RequestParam(value = "username") String uname, @RequestParam(value="useremail") String uemail,@RequestParam(value="userpassword") String upassword) 
	{
		UserInfo user=new UserInfo(uname,uemail,upassword);
		userinforepo.save(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestParam(value = "userinfoid") Integer uid, @RequestParam(value = "username") String uname, @RequestParam(value="useremail") String uemail,@RequestParam(value="userpassword") String upassword) 
	{
		UserInfo user=new UserInfo(uid,uname,uemail,upassword);
		userinforepo.save(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer uid) 
	{
		UserInfo user=new UserInfo();
		user.setUserinfoid(uid);
		
		userinforepo.delete(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
