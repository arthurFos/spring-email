package de.fkal.springemail.model.dto;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

@Data
public class MailProperties {
    private String to;
    private String from;
    private String subject;
    private List<String> recipients;
    private List<FileSystemResource> attachments;
}
