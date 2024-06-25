package com.example.properties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//새로고침 - 정보 변경 반영
public class ProjectNameRestController {
    private final String projectName;

    @Autowired
    public ProjectNameRestController(@Value("${configuration.projectName}") String pn) {
        this.projectName = pn;
    }

    @RequestMapping("/project-name")
    String projectName() {
        return this.projectName;
    }
}
