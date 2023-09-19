package com.wetic.tactcrm.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

//TODO: remove all role related codeui
public final class SecurityUtils {

    private final Logger log  = LoggerFactory.getLogger(SecurityUtils.class);
    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.uti
     *
     * @return the login of the current user.
     */
    public static Optional<String> getCurrentUserLogin() {

        boolean isAuthenticated = isAuthenticated();

        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if(isAuthenticated == false ){
                        return null;
                    }
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    }
                     else if (authentication.getPrincipal() instanceof String) {
                         return (String) authentication.getPrincipal();
                     }
                    return null;
                });
    }

//    /**
//     * Check if a user is authenticated.
//     *
//     * @return true if the user is authenticated, false otherwise.
//     */
//    //TODO: RECHECK THIS FUNCTION
//    public static boolean isAuthenticated() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        return Optional.ofNullable(securityContext.getAuthentication())
//                .map(authentication -> authentication.getAuthorities().stream()
//                        .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("tempRole")))
//                .orElse(false);
//    }

    //TODO : replace this with above logic
    public static boolean isAuthenticated(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication()==null){
            return false;
        }
        Object securityContextStrategy = SecurityContextHolder.getContextHolderStrategy();
        Authentication authentication =  securityContext.getAuthentication();
        String name = authentication.getName();

        return authentication.isAuthenticated();

    }

    /**
     * If the current user has a specific authority (security role).
     * <p>
     * The name of this method comes from the {@code isUserInRole()} method in the Servlet API.
     *
     * @param authority the authority to check.
     * @return true if the current user has the authority, false otherwise.
     */
    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
                .orElse(false);
    }
}