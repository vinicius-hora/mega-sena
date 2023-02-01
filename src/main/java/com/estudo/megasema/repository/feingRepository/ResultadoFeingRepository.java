package com.estudo.megasema.repository.feingRepository;

import com.estudo.megasema.dto.resultados.ResultadoDto;
import com.estudo.megasema.model.Resultado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loteria", url = "${url.api-loteria}", fallback = HystrixClientFallback.class)
public interface ResultadoFeingRepository {
    @GetMapping("/resultado")
    ResultadoDto buscarResultado(@RequestParam("loteria") String loteria, @RequestParam ("token") String token);
}
