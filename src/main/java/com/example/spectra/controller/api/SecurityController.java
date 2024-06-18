package com.example.spectra.controller.api;

import com.example.spectra.dto.SecurityDTO;
import com.example.spectra.service.SecurityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/user-activity-logs")
    public List<SecurityDTO> getUserActivityLogs() {
        return securityService.getUserActivityLogs();
    }

    @GetMapping("/patch-management")
    public SecurityDTO getPatchManagement() {
        return securityService.getPatchManagement();
    }

    @GetMapping("/sql-injection-detection")
    public SecurityDTO getSqlInjectionDetection() {
        return securityService.getSqlInjectionDetection();
    }

    @GetMapping("/audit-logs")
    public List<SecurityDTO> getAuditLogs() {
        return securityService.getAuditLogs();
    }

    @GetMapping("/user-permissions")
    public SecurityDTO getUserPermissions() {
        return securityService.getUserPermissions();
    }

    @GetMapping("/access-logs")
    public List<SecurityDTO> getAccessLogs() {
        return securityService.getAccessLogs();
    }

    @GetMapping("/data-encryption")
    public SecurityDTO getDataEncryption() {
        return securityService.getDataEncryption();
    }

    @GetMapping("/compliance-checks")
    public SecurityDTO getComplianceChecks() {
        return securityService.getComplianceChecks();
    }
}
