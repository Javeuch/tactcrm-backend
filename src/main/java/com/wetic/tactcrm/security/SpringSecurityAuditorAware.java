package com.wetic.tactcrm.security;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

/*
 * Alimenter les champs de l'audit automatiquement
 */
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of(SecurityUtils.getCurrentUserLogin().orElse("system"));
    }
}
