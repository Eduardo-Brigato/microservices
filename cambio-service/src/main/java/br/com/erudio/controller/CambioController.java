package br.com.erudio.controller;

import br.com.erudio.model.dto.CambioDTO;
import br.com.erudio.service.ICambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
@Tag(name = "Cambio Endpoint")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private Logger logger = LoggerFactory.getLogger(CambioController.class);
    @Resource
    private Environment environment;

    @Resource
    private ICambioService service;

    @Operation(description = "Get cambio from currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public CambioDTO getCambio(@PathVariable("amount") BigDecimal amount,
                               @PathVariable("from")String from,
                               @PathVariable("to")String to){

        CambioDTO cambio = service.findByFromAndTo(from, to);
        if (Objects.isNull(cambio)) throw new RuntimeException("Currency Unsupported");

        logger.info("getCambio is called with -> {}, {} and {}", amount, from, to);
        var port = environment.getProperty("local.server.port");
        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnviroment(port);

        return cambio;
    }
}
