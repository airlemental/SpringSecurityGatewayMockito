package ninja.airelemental.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class GatewayUserController {

  @RequestMapping("/user")
  @ResponseBody
  public Map<String, Object> determineUserRole(Principal user) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("name", user.getName());
    map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
    return map;
  }

}
