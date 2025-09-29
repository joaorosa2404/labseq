package labseq.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import labseq.service.LabseqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

import static java.lang.System.nanoTime;

@Path("/labseq")
public class LabseqController {

    @Inject
    private LabseqService labseqService;

    @GET
    @Path("/{num}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> labseq(@PathParam("num") int num) {

        long start = System.nanoTime();
        BigInteger resultado = labseqService.getLabseq(num);
        long end = System.nanoTime();
        double elapsedTime = (end-start) / 1000000000.0; //calcula o tempo de duração do calculo labseq

        return Map.of(
                "Número",num,
                "Resultado", resultado,
                "Elapsed Time",elapsedTime
        );
    }

    @GET
    @Path("/reset")
    @Produces(MediaType.APPLICATION_JSON)
    public String reset(){
        try {
            labseqService.resetCache();
            return "Cache do array limpa!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
