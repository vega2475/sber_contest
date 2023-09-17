package edu.sber.controller;

import edu.sber.dto.TextDTO;
import edu.sber.service.TextService;
import edu.sber.utils.BracketCheckResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/api/checkBrackets")
    public ResponseEntity<BracketCheckResponse> postText(@RequestBody @Valid TextDTO textDTO, BindingResult bindingResult){
        if (!textService.checkText(textDTO.getText())) {
            BracketCheckResponse responseDTO = new BracketCheckResponse();
            responseDTO.setCorrectText(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        }
        boolean isCorrect = textService.checkText(textDTO.getText());

        BracketCheckResponse response = new BracketCheckResponse();
        response.setCorrectText(isCorrect);

        return ResponseEntity.ok(response);
    }
}
