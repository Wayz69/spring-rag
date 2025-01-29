package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.service.AssistanceAiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssistantRessource {

    private final Logger log = LoggerFactory.getLogger(fr.efrei.springrag.web.rest.AssistantRessource.class);

    private final AssistanceAiService assistanceAiService;

    public AssistantRessource(AssistanceAiService assistanceAiService) {
        this.assistanceAiService = assistanceAiService;
    }

    @PostMapping("/assistant/chat")
    public String chat(@RequestBody String query) {
        log.info("REST request to chat with assistant : {}", query);
        return assistanceAiService.chat(query);
    }
}

