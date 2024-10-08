package com.aristocampapi.serviceimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aristocampapi.dao.UserInfoRepository;
import com.aristocampapi.entity.UserInfo;
import com.aristocampapi.request.ChangePasswordRequest;
import com.aristocampapi.response.ApiResponse;
import com.aristocampapi.response.UserResponse; 
  
@Service
public class UserInfoService implements UserDetailsService { 
  
    @Autowired 
    private UserInfoRepository repository; 
  
    @Autowired
    private PasswordEncoder encoder; 
  
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
  
//        Optional<UserInfo> userDetail = repository.findByLoginName(username); 
        Optional<UserInfo> userDetail = repository.findByLoginNameAndUserStatus(username,"Y"); 


        
 /*       try {
			int loginId = Integer.parseInt(userDetail.get().getLoginName());
			userDetail.get().setId(loginId);
		} catch (Exception e) {
			// TODO: handle exception by default auto generated id will be set 
		}
*/		// Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
    } 
  
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        userInfo.setUserStatus("Y");
        userInfo.setRoles(userInfo.getUserType()==10?"PSR/ FSO/ MR/ FO ":userInfo.getUserType()==20?"Line 1":userInfo.getUserType()==30?"Line 2":"Line 3");
        repository.save(userInfo);
        
        return "User Added Successfully"; 
    } 

    
    public String updateAllUser() {
    	List<UserInfo> userList = repository.findAll();
        //List<UserInfo> newList = userList.stream().map(user->user.setPassword(encoder.encode(user.getPassword())).collect(Collectors.toList()));
/*           List<UserInfo> newList =   userList.stream().map(e -> {
        	      e.setPassword(encoder.encode(e.getPassword()));
        	      return e;
        	    });*/
           
    	//   userList.stream().filter(u->u.getId()>150).map(user->{user.setPassword(encoder.encode(user.getPassword()));
    	 //                          return user;}).forEach(y->System.out.println(y.getPassword()));
								 
								

    	   
//           List<UserInfo> newList = userList.stream().filter(u->u.getId()>150)
 
                   List<UserInfo> newList = userList.stream()
        		    .map(e -> {
        		      e.setPassword(encoder.encode(e.getPassword().trim()));
        		      return e;
        		    })
        		    .collect(Collectors.toList());
           
//    	userInfo.setPassword(encoder.encode(userInfo.getPassword()));
           
//           UserInfo user = repository.findById(163).get();
//           user.setPassword(encoder.encode(user.getPassword().trim()));
           //repository.save(user);
        repository.saveAll(newList);
        return "User updated Successfully"; 
    } 

    
    public ApiResponse<UserResponse> getAllUser() {
    	List<UserInfo> userList = repository.findAll();
    	UserInfo userInfo=null;
    	UserResponse userResponse= null;
    	List<UserResponse> userResponseList=new ArrayList<UserResponse>();
    	
    	int size=userList.size();
    	for(int i=0;i<size;i++)
    	{
    	   userInfo = userList.get(i);
    	   userResponse= new UserResponse();
    	   userResponse.setLoginId(userInfo.getId());
    	   userResponse.setFname(userInfo.getFname());
    	   userResponse.setLoginName(userInfo.getLoginName());
    	   userResponse.setUtype(userInfo.getUserType());
    	   userResponse.setLastLoginDate(userInfo.getLastLoginDateTime().toString());
    	   userResponse.setUserStatus(userInfo.getUserStatus());
    	   userResponse.setUserType(userInfo.getUserType()==1?"Branch":userInfo.getUserType()==2?"All India":userInfo.getUserType()==3?"PMT":userInfo.getUserType()==4?"HQ":userInfo.getUserType()==5?"Multiple Branch":"Admin");
    	   userResponseList.add(userResponse);
    	}
    	ApiResponse<UserResponse> apiResponse = new ApiResponse<>("User List", size,userResponseList);
        return apiResponse; 
    } 

    
     public int changePassword(ChangePasswordRequest request )
     {
    		 UserInfo userDetail = repository.findById(request.getUserId());
    		 
    		 System.out.println(" id+kya hai "+userDetail.getId());
    		 int update=0;
        	 if (userDetail!=null)
        	 {
        		 boolean check = encoder.matches(request.getOldPassword(), userDetail.getPassword());
        		 //boolean check=true;
        		 if(check)
        		 {
        			 userDetail.setPassword(encoder.encode(request.getNewPassword().trim()));
        			 repository.save(userDetail);
        			 update=1;
        		 }
        	 }

    		 return update;
     }
     
     public int resetPassword(int userId )
     {
    		 UserInfo userDetail = repository.findById(userId);
    		 
    		
    		 int update=0;
        	 if (userDetail!=null)
        	 {
        			 userDetail.setPassword(encoder.encode("123"));
        			 repository.save(userDetail);
        			 update=1;
        	 }

    		 return update;
     }

     public int updateStatus(int userId,String userStatus )
     {
    		 UserInfo userDetail = repository.findById(userId);
    		 
    		
    		 int update=0;
        	 if (userDetail!=null)
        	 {
        			 userDetail.setUserStatus(userStatus);
        			 repository.save(userDetail);
        			 update=1;
        	 }

    		 return update;
     }

     
} 