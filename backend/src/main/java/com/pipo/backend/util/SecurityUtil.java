package com.pipo.backend.util;

import java.util.Optional;

public class SecurityUtil {

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user.
     */
    public static Optional<String> getCurrentUserLogin() {
        // TODO: Implement actual Spring Security context retrieval here
        // Example:
        // SecurityContext securityContext = SecurityContextHolder.getContext();
        // return Optional.ofNullable(securityContext.getAuthentication())
        //         .map(authentication -> { ... return username; });
        return Optional.empty();
    }
}
