package eu.deltasource.kat.web;

import eu.deltasource.kat.model.entity.Fine;
import eu.deltasource.kat.repository.FineRepository;
import eu.deltasource.kat.service.FineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fines")
public class FinesController {

    private final FineService fineService;

    public FinesController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping
    public ResponseEntity<List<Fine>> getAllFines() {
        return ResponseEntity.ok(fineService.getAllFines());
    }
}
