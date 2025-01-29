package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DocumentRessource {

    private final DocumentService documentService;


    private final Logger log = LoggerFactory.getLogger(DocumentService.class);

    public DocumentRessource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to save Document : {}", document);
        Document result = documentService.buildAndSave(document);

        return ResponseEntity
                .created(new URI("/api/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        log.debug("REST request to get all Documents");
        return documentService.findAll();
    }


}
