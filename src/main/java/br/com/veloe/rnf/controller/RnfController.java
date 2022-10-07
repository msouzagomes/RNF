package br.com.veloe.rnf.controller;

import br.com.veloe.rnf.model.ExceptionResponse;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import br.com.veloe.rnf.service.RnfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/veloe")
public class RnfController {

    @Autowired
    private RnfService rnfService;

    @Operation(
            summary = "Api RNF ",
            description = "RNF",
            tags = {"Api RNF"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success", content = {@Content(
                    mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))}),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND: Entity could not be found")}
    )
    @PostMapping(value = "/rnf", produces = {"application/json"})
    public ResponseEntity<HttpStatus> rnfTransacao (@RequestBody TransacoesRnf transacoesRnf){
        return (ResponseEntity<HttpStatus>) this.rnfService.postRnfTransacao(transacoesRnf, null);
    }
}
